/**
 * Copyright (c) 2006-2016, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.Category;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.CustomCategory;
import org.eclipse.cbi.p2repo.aggregator.ExclusionRule;
import org.eclipse.cbi.p2repo.aggregator.Feature;
import org.eclipse.cbi.p2repo.aggregator.MapRule;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.engine.internal.RequirementUtils;
import org.eclipse.cbi.p2repo.p2.InstallableUnit;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.cbi.p2repo.p2.P2Factory;
import org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl;
import org.eclipse.cbi.p2repo.p2.impl.ProvidedCapabilityImpl;
import org.eclipse.cbi.p2repo.p2.util.P2Bridge;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.cbi.p2repo.util.MonitorUtils;
import org.eclipse.cbi.p2repo.util.StringUtils;
import org.eclipse.cbi.p2repo.util.TimeUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.equinox.internal.p2.metadata.IRequiredCapability;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IProvidedCapability;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.IVersionedId;
import org.eclipse.equinox.p2.metadata.MetadataFactory.InstallableUnitDescription;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.metadata.VersionedId;

public class CategoriesGenerator extends BuilderPhase {
	private static void assignCategoryVersion(InstallableUnitImpl category) {
		List<VersionedId> includedBundles = new ArrayList<VersionedId>();
		List<VersionedId> includedFeatures = new ArrayList<VersionedId>();
		for(IRequirement req : category.getRequirements()) {
			if(!(req instanceof IRequiredCapability))
				continue;

			IRequiredCapability cap = (IRequiredCapability) req;
			VersionRange range = cap.getRange();
			Version version;
			if(range == null)
				version = Version.emptyVersion;
			else
				version = range.getMinimum();
			VersionedId vn = new VersionedId(cap.getName(), version);
			if(cap.getName().endsWith(Builder.FEATURE_GROUP_SUFFIX))
				includedFeatures.add(vn);
			else
				includedBundles.add(vn);
		}

		VersionSuffixGenerator suffixGen = new VersionSuffixGenerator();
		Version catVersion = Version.createOSGi(0, 0, 0, suffixGen.generateSuffix(includedFeatures, includedBundles));
		category.setVersion(catVersion);
		List<IProvidedCapability> providedCaps = category.getProvidedCapabilities();
		providedCaps.clear();
		ProvidedCapabilityImpl providedCap = (ProvidedCapabilityImpl) P2Factory.eINSTANCE.createProvidedCapability();
		providedCap.setName(category.getId());
		providedCap.setNamespace(IInstallableUnit.NAMESPACE_IU_ID);
		providedCap.setVersion(catVersion);
		providedCaps.add(providedCap);
	}

	private static boolean isExcluded(MappedRepository repo, IVersionedId iu) {
		for(MapRule rule : repo.getMapRules(true))
			if(rule instanceof ExclusionRule && RequirementUtils.isIncluded(rule, iu))
				return true;
		return false;
	}

	public CategoriesGenerator(Builder builder) {
		super(builder);
	}

	private InstallableUnit createCategoryIU(CustomCategory category) {
		P2Factory factory = P2Factory.eINSTANCE;
		InstallableUnitImpl cat = (InstallableUnitImpl) factory.createInstallableUnit();
		cat.setSingleton(true);
		String categoryId = category.getIdentifier();
		cat.setId(categoryId);

		Map<String, String> props = cat.getPropertyMap().map();
		props.put(IInstallableUnit.PROP_NAME, category.getLabel());
		props.put(IInstallableUnit.PROP_DESCRIPTION, category.getDescription());
		props.put(InstallableUnitDescription.PROP_TYPE_CATEGORY, "true"); //$NON-NLS-1$

		List<Feature> features = category.getFeatures();
		List<IRequirement> rcs = cat.getRequirements();
		List<VersionedId> includedBundles = new ArrayList<VersionedId>();
		List<VersionedId> includedFeatures = new ArrayList<VersionedId>();
		for(Feature feature : features) {
			if(!feature.isBranchEnabled())
				continue;

			rcs.add(P2Bridge.importToModel(feature.getRequirement()));
			VersionedId vn = new VersionedId(feature.getName(), feature.getVersionRange().getMinimum());
			if(vn.getId().endsWith(Builder.FEATURE_GROUP_SUFFIX))
				includedFeatures.add(vn);
			else
				includedBundles.add(vn);
		}

		// Add self capability
		ProvidedCapabilityImpl pc = (ProvidedCapabilityImpl) factory.createProvidedCapability();
		pc.setName(categoryId);
		pc.setNamespace(IInstallableUnit.NAMESPACE_IU_ID);

		VersionSuffixGenerator suffixGen = new VersionSuffixGenerator();
		Version catVersion = Version.createOSGi(0, 0, 0, suffixGen.generateSuffix(includedFeatures, includedBundles));
		pc.setVersion(catVersion);
		cat.setVersion(catVersion);
		cat.getProvidedCapabilities().add(pc);
		return cat;
	}

	private List<IInstallableUnit> getRepositoryCategories(MappedRepository repo) {
		Builder builder = getBuilder();
		ArrayList<IInstallableUnit> categoryIUs = new ArrayList<IInstallableUnit>();
		if(repo.isMapExclusive()) {
			for(Category category : repo.getCategories()) {
				if(category.isEnabled()) {
					IInstallableUnit iu = category.resolveAsSingleton();
					if(builder.isTopLevelCategory(iu) && !isExcluded(repo, iu))
						categoryIUs.add(iu);
				}
			}
		}
		else {
			for(IInstallableUnit iu : repo.getMetadataRepository().getInstallableUnits()) {
				if(builder.isTopLevelCategory(iu) && !isExcluded(repo, iu)) {
					categoryIUs.add(iu);
				}
			}
		}

		// Add all categories from this repository.
		//
		String categoryPrefix = StringUtils.trimmedOrNull(repo.getCategoryPrefix());
		if(categoryPrefix != null) {
			// All requirements for categories must be renamed.
			//
			String idSuffix = makeValidIUSuffix(categoryPrefix);
			StringBuilder prefixConcat = new StringBuilder();
			prefixConcat.append(categoryPrefix);
			prefixConcat.append(' ');
			int prefixLen = prefixConcat.length();
			int idx = categoryIUs.size();
			while(--idx >= 0) {
				IInstallableUnit iu = categoryIUs.get(idx);
				InstallableUnitImpl renamedIU = (InstallableUnitImpl) P2Bridge.importToModel(iu);
				prefixConcat.setLength(prefixLen);
				prefixConcat.append(iu.getProperty(IInstallableUnit.PROP_NAME));
				renamedIU.getPropertyMap().map().put(IInstallableUnit.PROP_NAME, prefixConcat.toString());
				renamedIU.setId(iu.getId() + idSuffix);
				assignCategoryVersion(renamedIU);
				categoryIUs.set(idx, renamedIU);
			}
		}
		return categoryIUs;
	}

	private String makeValidIUSuffix(String categoryPrefix) {
		int top = categoryPrefix.length();
		StringBuilder bld = new StringBuilder(top);
		for(int idx = 0; idx < top; ++idx) {
			char c = categoryPrefix.charAt(idx);
			if(c >= 'A' && c <= 'Z')
				bld.append(c + ('a' - 'A'));
			else if(c == '-' || c == '.' || c == '_' || (c >= '0' && c <= '9') || (c >= 'a' && c <= 'z'))
				bld.append(c);
			else if(c == ' ')
				bld.append('_');
		}
		return bld.toString();
	}

	private List<IInstallableUnit> normalizeCategories(List<IInstallableUnit> categoryIUs) {
		Map<String, List<IRequirement>> map = new HashMap<String, List<IRequirement>>();
		Map<String, IInstallableUnit> catMap = new HashMap<String, IInstallableUnit>();
		for(IInstallableUnit category : categoryIUs) {
			String name = category.getProperty(IInstallableUnit.PROP_NAME);
			List<IRequirement> caps = map.get(name);
			if(caps == null) {
				caps = new ArrayList<IRequirement>();
				map.put(name, caps);
			}

			// TODO Before we could map version ranges, here had been an algorithm fixing possible version replacements.
			// This may be required in future again but it will need a different implementation
			caps.addAll(category.getRequirements());

			IInstallableUnit oldCat = catMap.put(name, category);
			if(oldCat == null)
				continue;

			// We keep the category with the longest description
			//
			String oldDesc = oldCat.getProperty(IInstallableUnit.PROP_DESCRIPTION);
			if(oldDesc == null) {
				// Toss the old one
				tossCategory(oldCat);
				continue;
			}

			String newDesc = category.getProperty(IInstallableUnit.PROP_DESCRIPTION);
			if(newDesc == null || newDesc.length() < oldDesc.length()) {
				// Retain old and throw away new.
				tossCategory(category);
				catMap.put(name, oldCat);
			}
			else {
				if(category.getVersion().compareTo(oldCat.getVersion()) > 0)
					// Toss the old one
					tossCategory(oldCat);
			}
		}

		List<IInstallableUnit> normalized = new ArrayList<IInstallableUnit>();
		for(IInstallableUnit category : catMap.values()) {
			String name = category.getProperty(IInstallableUnit.PROP_NAME);
			List<IRequirement> newCaps = map.get(name);
			Collection<IRequirement> origCaps = category.getRequirements();
			if(origCaps.size() == newCaps.size() && origCaps.containsAll(newCaps)) {
				// This category passed through normalization without change
				normalized.add(category);
				continue;
			}

			InstallableUnitImpl newCategory = (InstallableUnitImpl) P2Factory.eINSTANCE.createInstallableUnit();
			newCategory.setId(category.getId());
			for(Map.Entry<String, String> entry : category.getProperties().entrySet())
				newCategory.getPropertyMap().put(entry.getKey(), entry.getValue());
			newCategory.getRequirements().addAll(newCaps);
			assignCategoryVersion(newCategory);
			tossCategory(category);
			normalized.add(newCategory);
		}
		return normalized;
	}

	@Override
	public void run(IProgressMonitor monitor) throws CoreException {
		long start = TimeUtils.getNow();
		MonitorUtils.begin(monitor, 10);
		String info = "Starting generation of categories";
		Builder builder = getBuilder();
		MonitorUtils.subTask(monitor, info);
		LogUtils.info(info);
		try {
			List<IInstallableUnit> results = new ArrayList<IInstallableUnit>();

			Aggregation aggregation = builder.getAggregation();

			// only process custom categories in the main (implicit) validationSet
			for(CustomCategory category : aggregation.getCustomCategories())
				results.add(createCategoryIU(category));

			MonitorUtils.worked(monitor, 5);
			for(Contribution contrib : getBuilder().getAggregation().getAllContributions(true)) {
				for(MappedRepository repo : contrib.getRepositories(true))
					results.addAll(getRepositoryCategories(repo));
			}

			results = normalizeCategories(results);
			if(!results.isEmpty())
				builder.getAggregationMetadataRepository().addInstallableUnits(results);
		}
		catch(OperationCanceledException e) {
			LogUtils.info("Operation canceled."); //$NON-NLS-1$
		}
		finally {
			MonitorUtils.done(monitor);
		}
		if(!monitor.isCanceled()) {
			LogUtils.info("Done. Took %s", TimeUtils.getFormattedDuration(start)); //$NON-NLS-1$
		}
	}

	/**
	 * Ensure that mapped repositories that reference the given category IU are not mapped verbatim.
	 *
	 * @param category
	 *            The category IU that will be excluded
	 */
	private void tossCategory(IInstallableUnit category) {
		MetadataRepository parent = (MetadataRepository) ((EObject) category).eContainer();
		Builder builder = getBuilder();
		for(Contribution contrib : builder.getAggregation().getAllContributions(true)) {
			for(MappedRepository mappedRepo : contrib.getRepositories(true)) {
				if(mappedRepo.getMetadataRepository() == parent && builder.isMapVerbatim(mappedRepo)) {
					LogUtils.debug(
						"Excluding %s from verbatim mapping since category %s has been normalized",
						mappedRepo.getLocation(), category.getProperty(IInstallableUnit.PROP_NAME));
					builder.addMappingExclusion(mappedRepo);
				}
			}
		}
	}
}
