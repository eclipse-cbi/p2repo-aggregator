/*******************************************************************************
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 ******************************************************************************/
package org.eclipse.b3.aggregator.engine;

import static java.lang.String.format;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.b3.aggregator.Aggregate;
import org.eclipse.b3.aggregator.Category;
import org.eclipse.b3.aggregator.Configuration;
import org.eclipse.b3.aggregator.Contribution;
import org.eclipse.b3.aggregator.ExclusionRule;
import org.eclipse.b3.aggregator.InstallableUnitType;
import org.eclipse.b3.aggregator.MapRule;
import org.eclipse.b3.aggregator.MappedRepository;
import org.eclipse.b3.aggregator.MappedUnit;
import org.eclipse.b3.aggregator.ValidConfigurationsRule;
import org.eclipse.b3.aggregator.engine.internal.RequirementUtils;
import org.eclipse.b3.aggregator.util.InstallableUnitUtils;
import org.eclipse.b3.aggregator.util.ResourceUtils;
import org.eclipse.b3.util.LogUtils;
import org.eclipse.b3.util.MonitorUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.equinox.internal.p2.metadata.expression.ExpressionFactory;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IInstallableUnitPatch;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.MetadataFactory;
import org.eclipse.equinox.p2.metadata.MetadataFactory.InstallableUnitDescription;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.metadata.expression.ExpressionUtil;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;
import org.eclipse.equinox.p2.publisher.AbstractPublisherAction;
import org.eclipse.equinox.p2.publisher.IPublisherInfo;
import org.eclipse.equinox.p2.publisher.IPublisherResult;
import org.eclipse.equinox.spi.p2.publisher.PublisherHelper;

/**
 * This action creates the feature that contains all features and bundles that are listed contributions in the Aggregate passed to the constructor
 * of this class.
 * 
 * @see Builder#getVerificationIUName(Aggregate)
 */
public class VerificationIUAction extends AbstractPublisherAction {
	static class RepositoryRequirement {
		Contribution contribution;

		MappedRepository repository;

		IRequirement requirement;

		boolean explicit;

		public RepositoryRequirement(Contribution contribution, MappedRepository repository, IRequirement requirement,
				boolean explicit) {
			super();
			this.contribution = contribution;
			this.repository = repository;
			this.requirement = requirement;
			this.explicit = explicit;
		}

		@Override
		public boolean equals(Object o) {
			if(!(o instanceof RepositoryRequirement))
				return false;

			RepositoryRequirement other = (RepositoryRequirement) o;
			return other.repository.equals(repository) && other.requirement.equals(requirement) &&
					other.explicit == explicit;
		}
	}

	private static IMatchExpression<IInstallableUnit> createFilter(List<Configuration> configs) {
		List<Configuration> enabledConfigs = getEnabledConfigs(configs);

		if(!(enabledConfigs == null || enabledConfigs.isEmpty())) {
			StringBuilder filterBld = new StringBuilder();
			if(enabledConfigs.size() > 1)
				filterBld.append("(|");

			for(Configuration config : enabledConfigs) {
				filterBld.append("(&(osgi.os=");
				filterBld.append(config.getOperatingSystem().getLiteral());
				filterBld.append(")(osgi.ws=");
				filterBld.append(config.getWindowSystem().getLiteral());
				filterBld.append(")(osgi.arch=");
				filterBld.append(config.getArchitecture().getLiteral());
				filterBld.append("))");
			}
			if(enabledConfigs.size() > 1)
				filterBld.append(')');
			return ExpressionUtil.getFactory().matchExpression(
				ExpressionUtil.parse("properties ~= $0"), ExpressionUtil.parseLDAP(filterBld.toString()));
		}
		return null;
	}

	private static List<Configuration> getEnabledConfigs(List<Configuration> configs) {
		List<Configuration> enabledConfigs = new ArrayList<Configuration>();

		for(Configuration config : configs)
			if(config.isEnabled())
				enabledConfigs.add(config);

		return enabledConfigs;
	}

	private final Builder builder;

	private final Aggregate aggregate;

	public VerificationIUAction(Builder builder, Aggregate aggregate) {
		this.builder = builder;
		this.aggregate = aggregate;
	}

	private void addCategoryContent(IInstallableUnit category, Contribution contribution, MappedRepository repository,
			List<IInstallableUnit> allIUs, Map<String, Set<RepositoryRequirement>> required, List<String> errors,
			Set<String> explicit) {
		// We don't map categories verbatim here. They are added elsewhere. We do
		// map their contents though.
		requirements: for(IRequirement rc : category.getRequirements()) {
			for(IInstallableUnit riu : allIUs) {
				if(riu.satisfies(rc)) {
					if("true".equalsIgnoreCase(riu.getProperty(InstallableUnitDescription.PROP_TYPE_CATEGORY))) {
						// Nested category
						addCategoryContent(riu, contribution, repository, allIUs, required, errors, explicit);
						continue requirements;
					}

					addRequirementFor(contribution, repository, riu, rc.getFilter(), required, errors, explicit, false);
					continue requirements;
				}
			}

			// Categorized IU is not found
			//
			String error = format(
				"Category %s includes a requirement for %s that cannot be fulfilled", category.getId(), rc);
			errors.add(error);
			LogUtils.error(error);
		}
	}

	private void addRequirementFor(Contribution contribution, MappedRepository mr, IInstallableUnit iu,
			IMatchExpression<IInstallableUnit> filter, Map<String, Set<RepositoryRequirement>> requirements,
			List<String> errors, Set<String> explicit, boolean isExplicit) {
		String id = iu.getId();
		Version v = iu.getVersion();
		VersionRange range = null;
		if(!Version.emptyVersion.equals(v))
			range = new VersionRange(v, true, v, true);

		IMatchExpression<IInstallableUnit> iuFilter = filter;
		IMatchExpression<IInstallableUnit> origFilter = iu.getFilter();
		if(origFilter != null) {
			if(filter != null) {
				Object[] origFilterParams = origFilter.getParameters();
				Object[] filterParams = filter.getParameters();
				Object[] compoundParams = new Object[origFilterParams.length + filterParams.length];
				System.arraycopy(origFilterParams, 0, compoundParams, 0, origFilterParams.length);
				System.arraycopy(filterParams, 0, compoundParams, origFilterParams.length, filterParams.length);
				iuFilter = ExpressionFactory.INSTANCE.matchExpression(
					ExpressionFactory.INSTANCE.and(origFilter, filter), compoundParams);
			}
		}
		IRequirement rc = MetadataFactory.createRequirement(
			PublisherHelper.IU_NAMESPACE, id, range, iuFilter, false, false);
		// TODO Use this to activate the "version enumeration" policy workaround
		// IRequirement req = RequirementUtils.createMultiRangeRequirement(mr.getMetadataRepository(), rc);
		IRequirement req = rc;

		addRequirementFor(contribution, mr, req, requirements, errors, explicit, isExplicit);
	}

	private void addRequirementFor(Contribution contribution, MappedRepository mr, IRequirement rc,
			Map<String, Set<RepositoryRequirement>> requirements, List<String> errors, Set<String> explicit,
			boolean isExplicit) {

		String id = RequirementUtils.getName(rc);
		RepositoryRequirement rq = new RepositoryRequirement(contribution, mr, rc, isExplicit);

		Set<RepositoryRequirement> repoReqs = requirements.get(id);
		if(repoReqs == null)
			requirements.put(id, repoReqs = new HashSet<RepositoryRequirement>());

		repoReqs.add(rq);

		// if just 1 requirement exists for this ID, there's nothing to do
		if(repoReqs.size() == 1) {
			if(isExplicit)
				explicit.add(id);
			return;
		}

		// Mark all involved repositories as affected (they can't be mapped verbatim any more)
		for(RepositoryRequirement req : repoReqs)
			builder.addMappingExclusion(req.repository);

		if(explicit.contains(id)) {
			if(!isExplicit) {
				LogUtils.debug("%s excluded since it is already explicitly mapped", rc.toString());
				// Remove the new one
				repoReqs.remove(rq);
			}
			else {
				String error;
				boolean filtersAllTheSame = true;
				for(RepositoryRequirement req : repoReqs) {
					if(rc.getFilter() != null && !rc.getFilter().equals(req.requirement.getFilter()) ||
							rc.getFilter() == null && req.requirement.getFilter() != null) {
						filtersAllTheSame = false;
						break;
					}
				}

				if(!filtersAllTheSame) {
					error = format("%s is explicitly mapped more than once but with different configurations", id);
					errors.add(error);

					LogUtils.error(error);
				}
			}
			return;
		}

		if(isExplicit) {
			Iterator<RepositoryRequirement> itor = repoReqs.iterator();
			while(itor.hasNext()) {
				RepositoryRequirement req = itor.next();
				if(req.equals(rq))
					continue;

				LogUtils.debug("%s excluded since it is explicitly mapped", req.requirement.toString());
				itor.remove();
			}

			explicit.add(id);
			return;
		}

		// all mappings are implicit so far, then we replace requirements by unions of implicit requirements
		// let's find the original one first (there should be only one shared requirement instance at the moment)
		IRequirement orig = null;
		for(RepositoryRequirement req : repoReqs) {
			if(!req.equals(rq))
				continue;
			orig = req.requirement;
			break;
		}

		// TODO Use this to activate the "version enumeration" policy workaround
		// IRequirement modifiedReq = RequirementUtils.versionUnion(orig, rq.requirement);
		IRequirement modifiedReq = MetadataFactory.createRequirement(
			PublisherHelper.IU_NAMESPACE, id, VersionRange.emptyRange, orig.getFilter(), false, false);

		for(RepositoryRequirement req : repoReqs)
			req.requirement = modifiedReq;
	}

	public String getRelativeEObjectURI(EObject eObject) {
		return EcoreUtil.getURI(eObject).deresolve(eObject.eResource().getURI()).toString();
	}

	@Override
	public IStatus perform(IPublisherInfo publisherInfo, IPublisherResult results, IProgressMonitor monitor) {
		Map<String, Set<RepositoryRequirement>> required = new HashMap<String, Set<RepositoryRequirement>>();

		boolean errorsFound = false;
		List<Contribution> aggregateContribs = builder.getAggregator().getAggregateContributions(aggregate, true);
		SubMonitor subMon = SubMonitor.convert(monitor, 2 + aggregateContribs.size());
		try {
			Set<String> explicit = new HashSet<String>();
			for(Contribution contrib : aggregateContribs) {
				ArrayList<String> errors = new ArrayList<String>();
				for(MappedRepository repository : contrib.getRepositories(true)) {
					List<IInstallableUnit> allIUs;

					try {
						allIUs = ResourceUtils.getMetadataRepository(repository).getInstallableUnits();
					}
					catch(CoreException e) {
						LogUtils.error(e, e.getMessage());
						errors.add(e.getMessage());
						continue;
					}

					if(repository.isMapExclusive()) {
						for(MappedUnit mu : repository.getUnits(true)) {
							if(mu instanceof Category)
								addCategoryContent(
									mu.resolveAsSingleton(true), contrib, repository, allIUs, required, errors,
									explicit);
							else
								addRequirementFor(
									contrib, repository, mu.getRequirement(), required, errors, explicit, true);
						}
					}
					else {
						// Verify that all products and features can be installed.
						//
						List<MapRule> mapRules = repository.getMapRules();
						Map<IMatchExpression<IInstallableUnit>, List<IInstallableUnit>> preSelectedIUs = new HashMap<IMatchExpression<IInstallableUnit>, List<IInstallableUnit>>();
						allIUs: for(IInstallableUnit riu : allIUs) {

							// don't include patches as root IUs
							if(riu instanceof IInstallableUnitPatch)
								continue;

							// We assume that all groups that are not categories are either products or
							// features.
							//
							InstallableUnitType riuType = InstallableUnitUtils.getType(riu);
							if(riuType == InstallableUnitType.PRODUCT || riuType == InstallableUnitType.FEATURE) {
								IMatchExpression<IInstallableUnit> filter = null;
								for(MapRule rule : mapRules) {
									if(riu.getId().equals(rule.getName()) &&
											rule.getVersionRange().isIncluded(riu.getVersion())) {
										if(rule instanceof ExclusionRule) {
											builder.addMappingExclusion(repository);
											continue allIUs;
										}
										if(rule instanceof ValidConfigurationsRule) {
											if(filter != null)
												throw new IllegalStateException(
													"Only one configuration rule per IU name can be specified");
											filter = createFilter(((ValidConfigurationsRule) rule).getValidConfigurations());
										}
									}
								}
								List<IInstallableUnit> units = preSelectedIUs.get(filter);
								if(units == null)
									preSelectedIUs.put(filter, units = new ArrayList<IInstallableUnit>());
								units.add(riu);
							}
						}

						for(Map.Entry<IMatchExpression<IInstallableUnit>, List<IInstallableUnit>> entry : preSelectedIUs.entrySet())
							for(IRequirement req : RequirementUtils.createAllAvailableVersionsRequirements(
								entry.getValue(), entry.getKey()))
								addRequirementFor(contrib, repository, req, required, errors, explicit, false);
					}
				}
				if(errors.size() > 0) {
					errorsFound = true;
					builder.sendEmail(contrib, errors);
				}
				MonitorUtils.worked(subMon, 1);
			}
			if(errorsFound)
				return new Status(IStatus.ERROR, Engine.PLUGIN_ID, "Features without repositories");

			// create a map using contributions as keys
			HashMap<Contribution, ArrayList<IRequirement>> crMap = new HashMap<Contribution, ArrayList<IRequirement>>();
			for(Set<RepositoryRequirement> rcSet : required.values())
				for(RepositoryRequirement req : rcSet) {
					ArrayList<IRequirement> rList = crMap.get(req.contribution);

					if(rList == null) {
						rList = new ArrayList<IRequirement>();
						crMap.put(req.contribution, rList);
					}

					rList.add(req.requirement);
				}

			InstallableUnitDescription iuDescription = new MetadataFactory.InstallableUnitDescription();

			// add the "Cannot be installed into the IDE" IU
			iuDescription.setId(Builder.PDE_TARGET_PLATFORM_NAME);
			iuDescription.setVersion(Version.emptyVersion);
			iuDescription.addProvidedCapabilities(Collections.singletonList(MetadataFactory.createProvidedCapability(
				Builder.PDE_TARGET_PLATFORM_NAMESPACE, iuDescription.getId(), iuDescription.getVersion())));
			results.addIU(MetadataFactory.createInstallableUnit(iuDescription), IPublisherResult.NON_ROOT);

			// add the IUs representing contributions
			// (and build the list of requirements of the verification IU)
			ArrayList<IRequirement> rList = new ArrayList<IRequirement>(crMap.size());
			for(Map.Entry<Contribution, ArrayList<IRequirement>> crEntry : crMap.entrySet()) {
				Contribution contrib = crEntry.getKey();
				ArrayList<IRequirement> crList = crEntry.getValue();

				iuDescription.setId(builder.getContributionVerifyIUName(contrib));
				iuDescription.setVersion(Builder.ALL_CONTRIBUTED_CONTENT_VERSION);
				iuDescription.setProperty(InstallableUnitDescription.PROP_TYPE_GROUP, Boolean.TRUE.toString());
				iuDescription.setProperty(
					Builder.CONTRIBUTION_LOCATION_PROPERTY, getRelativeEObjectURI((EObject) contrib));
				iuDescription.addProvidedCapabilities(Collections.singletonList(createSelfCapability(
					iuDescription.getId(), iuDescription.getVersion())));
				iuDescription.setRequirements(crList.toArray(new IRequirement[crList.size()]));

				rList.add(MetadataFactory.createRequirement(
					PublisherHelper.IU_NAMESPACE, iuDescription.getId(), new VersionRange(
						iuDescription.getVersion(), true, iuDescription.getVersion(), true), null, false, false));

				results.addIU(MetadataFactory.createInstallableUnit(iuDescription), IPublisherResult.NON_ROOT);
			}

			// add the verification IU
			iuDescription.setId(builder.getVerificationIUName(aggregate));
			iuDescription.setVersion(Builder.ALL_CONTRIBUTED_CONTENT_VERSION);
			iuDescription.setProperty(InstallableUnitDescription.PROP_TYPE_GROUP, Boolean.TRUE.toString());
			iuDescription.addProvidedCapabilities(Collections.singletonList(createSelfCapability(
				iuDescription.getId(), iuDescription.getVersion())));
			// add the IUs representing contributions as requirements of the verification IU
			iuDescription.setRequirements(rList.toArray(new IRequirement[rList.size()]));
			results.addIU(MetadataFactory.createInstallableUnit(iuDescription), IPublisherResult.ROOT);

			return Status.OK_STATUS;
		}
		finally {
			MonitorUtils.done(subMon);
		}
	}
}
