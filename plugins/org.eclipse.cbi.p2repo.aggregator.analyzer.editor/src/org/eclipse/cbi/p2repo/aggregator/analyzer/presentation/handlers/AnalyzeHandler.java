/**
 * Copyright (c) 2021 Eclipse Foundation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.analyzer.presentation.handlers;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MappedUnit;
import org.eclipse.cbi.p2repo.aggregator.ValidationSet;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerFactory;
import org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution;
import org.eclipse.cbi.p2repo.aggregator.engine.Builder;
import org.eclipse.cbi.p2repo.aggregator.engine.Builder.ActionType;
import org.eclipse.cbi.p2repo.aggregator.p2.util.MetadataRepositoryResourceFactoryImpl;
import org.eclipse.cbi.p2repo.aggregator.p2view.util.MetadataRepositoryStructuredViewBuilder;
import org.eclipse.cbi.p2repo.p2.InstallableUnit;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.cbi.p2repo.p2.P2Factory;
import org.eclipse.cbi.p2repo.p2.impl.MetadataRepositoryImpl;
import org.eclipse.cbi.p2repo.p2.util.P2Bridge;
import org.eclipse.cbi.p2repo.p2.util.P2ResourceFactoryImpl;
import org.eclipse.cbi.p2repo.p2.util.P2Utils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.equinox.internal.p2.metadata.IRequiredCapability;
import org.eclipse.equinox.internal.p2.metadata.RequiredPropertiesMatch;
import org.eclipse.equinox.internal.p2.metadata.ResolvedInstallableUnit;
import org.eclipse.equinox.internal.p2.metadata.TranslationSupport;
import org.eclipse.equinox.internal.p2.metadata.index.CapabilityIndex;
import org.eclipse.equinox.internal.p2.metadata.index.IdIndex;
import org.eclipse.equinox.internal.p2.metadata.index.IndexProvider;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IProvidedCapability;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.KeyWithLocale;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.metadata.expression.IFilterExpression;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;
import org.eclipse.equinox.p2.metadata.index.IIndex;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.IQueryable;
import org.eclipse.equinox.p2.query.QueryUtil;

public class AnalyzeHandler extends BaseHandler {

	public static final URI ANALYSIS_RESULT = URI.createURI("readonly://result.aggran");

	public static final URI DUPLICATE_ANALYSIS_RESULT = URI.createURI("readonly://duplicate.result.aggran");

	public static final URI STRICT_REQUIREMENT_ANALYSIS_RESULT = URI
			.createURI("readonly://strict.requirement.result.aggran");

	public static String AGGREGATE_REPOSITORY_LOCATION = "readonly://aggregation.result.p2";

	public static final URI AGGREGATE_REPOSITORY = (URI.createURI("p2aggr:p2:" + AGGREGATE_REPOSITORY_LOCATION));

	public static String STRUCTURED_AGGREGATE_REPOSITORY_LOCATION = "readonly://aggregation.structured.result.p2";

	public static final URI STRUCTURED_AGGREGATE_REPOSITORY = (URI
			.createURI("p2aggr:p2:" + STRUCTURED_AGGREGATE_REPOSITORY_LOCATION));

	public static final Comparator<InstallableUnitAnalysis> INSTALLABLE_UNIT_ANALYIS_COMPARATOR = new Comparator<InstallableUnitAnalysis>() {
		public int compare(InstallableUnitAnalysis o1, InstallableUnitAnalysis o2) {
			return o1.getInstallableUnit().compareTo(o2.getInstallableUnit());
		}
	};

	@Override
	protected Activity createActivity(Analysis analysis) {
		return new Analyzer(analysis);
	}

	public static class Analyzer extends Activity {
		private Analysis originalAnalysis;
		private Analysis result;
		private ExecutorService executor;
		private Resource aggregateMetadataRepositoryResource;
		private Resource structuredAggregateMetadataRepositoryResource;
		private Builder builder;
		private List<InstallableUnitAnalysis> duplicates;
		private List<InstallableUnitAnalysis> strictRequirements;

		public Analyzer(Analysis analysis) {
			this.originalAnalysis = analysis;
		}

		@Override
		public boolean isEnabled() {
			return getBuildModelLocation() != null;
		}

		public Analysis getOriginalAnalysis() {
			return originalAnalysis;
		}

		public URI getBuildModelLocation() {
			Aggregation aggregation = originalAnalysis.getAggregation();
			URI uri = EcoreUtil.getURI((EObject) aggregation).trimFragment();
			URI resolvedURI = CommonPlugin.resolve(uri);
			if (resolvedURI.isFile()) {
				return resolvedURI;
			}
			return null;
		}

		private Builder getBuilder(IProgressMonitor monitor) throws Exception {
			if (builder == null) {
				URI resolvedURI = getBuildModelLocation();
				if (resolvedURI != null) {
					builder = new Builder();
					builder.setAction(ActionType.VALIDATE);
					builder.setBuildModelLocation(new File(resolvedURI.toFileString()));
					builder.setProvisioningAgent(P2Utils.getDefaultProvisioningAgent());
					builder.run(false, monitor);
				}
			}
			return builder;
		}

		@Override
		protected void perform(IProgressMonitor monitor) throws Exception {
			result = analyze(monitor);
			duplicates = analyzeDuplicates(result);
			strictRequirements = analyzeStrictRequirements(result);
		}

		@Override
		protected void asyncExec() {
			Resource resource = ((EObject) getOriginalAnalysis()).eResource();
			if (resource != null) {
				ResourceSet resourceSet = resource.getResourceSet();
				EList<Resource> resources = resourceSet.getResources();

				XMLResource resultResource = (XMLResource) resourceSet.getResourceFactoryRegistry()
						.getFactory(ANALYSIS_RESULT).createResource(ANALYSIS_RESULT);
				resultResource.getContents().add(result);
				resources.add(resultResource);

				resources.add(aggregateMetadataRepositoryResource);
				resources.add(structuredAggregateMetadataRepositoryResource);

				Resource duplicateResultResource = resourceSet.getResourceFactoryRegistry()
						.getFactory(DUPLICATE_ANALYSIS_RESULT).createResource(DUPLICATE_ANALYSIS_RESULT);
				duplicateResultResource.getContents().addAll(duplicates);
				resources.add(duplicateResultResource);

				Resource strictRequirementsResultResource = resourceSet.getResourceFactoryRegistry()
						.getFactory(STRICT_REQUIREMENT_ANALYSIS_RESULT)
						.createResource(STRICT_REQUIREMENT_ANALYSIS_RESULT);
				strictRequirementsResultResource.getContents().addAll(strictRequirements);
				resources.add(strictRequirementsResultResource);
			}
		}

		private List<InstallableUnitAnalysis> analyzeDuplicates(Analysis analysis) {
			Map<String, List<InstallableUnitAnalysis>> ius = new TreeMap<>();
			analysis.getContributions().stream().flatMap(c -> c.getInstallableUnits().stream()).forEach(iu -> {
				IInstallableUnit installableUnit = iu.getInstallableUnit();
				String id = installableUnit.getId();
				installableUnit.getVersion();
				ius.computeIfAbsent(id, i -> new ArrayList<>()).add(iu);
			});

			ius.entrySet().removeIf(e -> e.getValue().size() == 1);

			Comparator<InstallableUnitAnalysis> compareVersion = new Comparator<InstallableUnitAnalysis>() {
				@Override
				public int compare(InstallableUnitAnalysis o1, InstallableUnitAnalysis o2) {
					return o1.getInstallableUnit().getVersion().compareTo(o2.getInstallableUnit().getVersion());
				}
			};
			ius.values().forEach(l -> l.sort(compareVersion));

			return ius.values().stream().flatMap(list -> list.stream()).map(i -> computeStrictlyRequiredBy(i))
					.collect(Collectors.toList());
		}

		private List<InstallableUnitAnalysis> analyzeStrictRequirements(Analysis analysis) {
			List<InstallableUnitAnalysis> result = analysis.getContributions().stream()
					.flatMap(c -> c.getInstallableUnits().stream()).map(i -> computeStrictlyRequiredBy(i))
					.collect(Collectors.toList());
			result.sort(INSTALLABLE_UNIT_ANALYIS_COMPARATOR);
			return result;
		}

		public static InstallableUnitAnalysis computeStrictlyRequiredBy(InstallableUnitAnalysis element) {
			InstallableUnitAnalysis copy = EcoreUtil.copy(element);
			copy.getRequirements().clear();
			for (CapabilityAnalysis capabilityAnalysis : copy.getCapabilities()) {
				EList<CapabilityResolution> resolutions = capabilityAnalysis.getResolutions();
				List<CapabilityResolution> toRemove = new ArrayList<>();
				for (CapabilityResolution capabilityResolution : resolutions) {
					RequirementAnalysis requirement = capabilityResolution.getRequirement();
					EList<RequirementResolution> resolutions2 = requirement.getResolutions();
					for (RequirementResolution requirementResolution : resolutions2) {
						if (requirementResolution.getInstallableUnit() != element) {
							toRemove.add(capabilityResolution);
							break;
						}
					}
				}

				resolutions.removeAll(toRemove);
			}

			copy.getCapabilities().removeIf(c -> c.getResolutions().isEmpty());
			return copy;
		}

		public Analysis analyze(IProgressMonitor monitor) throws Exception {
			SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
			Builder builder = getBuilder(subMonitor.newChild(90));
			try {
				if (builder != null) {
					subMonitor.setTaskName("Analyzing Aggregation");
					Aggregation builderAggregation = builder.getAggregation();

					subMonitor.subTask("Collecting contributions");
					subMonitor.worked(1);

					Set<IInstallableUnit> allUnitsToAggregate = new TreeSet<>();
					for (ValidationSet validationSet : builderAggregation.getValidationSets(true)) {
						allUnitsToAggregate.addAll(builder.getUnitsToAggregate(validationSet).stream()
								.map(iu -> iu instanceof ResolvedInstallableUnit
										? ((ResolvedInstallableUnit) iu).getOriginal()
										: iu)
								.collect(Collectors.toSet()));
					}

					MetadataRepositoryImpl aggregateMetadataRepository = (MetadataRepositoryImpl) P2Factory.eINSTANCE
							.createMetadataRepository();
					aggregateMetadataRepository.setLocation(new java.net.URI(AGGREGATE_REPOSITORY_LOCATION));

					Map<IInstallableUnit, InstallableUnit> modeledIUs = allUnitsToAggregate.stream()
							.collect(Collectors.toMap(Function.identity(), iu -> P2Bridge.importToModel(iu)));
					aggregateMetadataRepository.getInstallableUnits().addAll(new TreeSet<>(modeledIUs.values()));

					IQueryable<IInstallableUnit> queriable = new QueryableArray(modeledIUs.values());

					Set<URI> contributionsWithDuplicateRepositories = new HashSet<>();
					Map<java.net.URI, URI> owningContributions = new HashMap<>();
					EList<Contribution> allContributions = builderAggregation.getAllContributions(true);

					Map<URI, Set<IInstallableUnit>> allContributionIUs = new HashMap<>();
					Map<URI, Set<IInstallableUnit>> allIncludedIUs = new HashMap<>();

					ExecutorService executor = getExecutor();

					subMonitor.worked(1);
					subMonitor.subTask("Analyzing contributions");

					for (Contribution contribution : allContributions) {
						Set<IInstallableUnit> contributionIUs = new TreeSet<>();
						Set<IInstallableUnit> includedIUs = new TreeSet<>();
						URI contributionURI = EcoreUtil.getURI((EObject) contribution);
						allContributionIUs.put(contributionURI, contributionIUs);
						allIncludedIUs.put(contributionURI, includedIUs);

						EList<MappedRepository> repositories = contribution.getRepositories(true);
						for (MappedRepository mappedRepository : repositories) {
							MetadataRepository metadataRepository = mappedRepository.getMetadataRepository();
							EList<IInstallableUnit> installableUnits = metadataRepository.getInstallableUnits();
							contributionIUs.addAll(installableUnits.stream().map(iu -> modeledIUs.get(iu))
									.filter(Objects::nonNull).collect(Collectors.toSet()));

							java.net.URI location = metadataRepository.getLocation();
							URI otherContribution = owningContributions.put(location, contributionURI);
							if (otherContribution != null) {
								contributionsWithDuplicateRepositories.add(contributionURI);
								contributionsWithDuplicateRepositories.add(otherContribution);
							}

							EList<MappedUnit> units = mappedRepository.getUnits(true);
							for (MappedUnit mappedUnit : units) {
								Set<IInstallableUnit> ius = query(queriable,
										QueryUtil.createIUQuery(mappedUnit.getName(), mappedUnit.getVersionRange()));
								if (!ius.isEmpty()) {
									for (IInstallableUnit iu : ius) {
										collectChildren(queriable, includedIUs, iu);
									}
								}
							}
						}
					}

					Set<IInstallableUnit> remainingIUs = modeledIUs.keySet();

					Map<IInstallableUnit, InstallableUnitAnalysis> usedIUs = new LinkedHashMap<>();

					Analysis analysis = EcoreUtil.copy(originalAnalysis);

					Pattern exclusion = analysis.getExclusion();

					subMonitor.worked(1);
					subMonitor.subTask("Partitioning contributions");

					Map<RequirementAnalysis, Future<Set<IInstallableUnit>>> dependencies = new LinkedHashMap<>();
					EList<ContributionAnalysis> contributions = analysis.getContributions();
					for (boolean all : new boolean[] { false, true }) {
						for (ContributionAnalysis contributionAnalysis : contributions) {
							Contribution contribution = contributionAnalysis.getContribution();
							URI contributionURI = contribution == null ? null
									: CommonPlugin.asLocalURI(EcoreUtil.getURI((EObject) contribution));
							boolean duplicated = contributionsWithDuplicateRepositories.contains(contributionURI);
							Pattern match = contributionAnalysis.getMatch();
							Set<IInstallableUnit> ius = (duplicated || match != null
									? all ? allContributionIUs : allIncludedIUs
									: allContributionIUs).get(contributionURI);
							if (ius == null && match != null) {
								ius = new LinkedHashSet<>(modeledIUs.values());
							}
							if (ius != null) {
								EList<InstallableUnitAnalysis> installableUnits = contributionAnalysis
										.getInstallableUnits();
								for (IInstallableUnit iu : ius) {
									String id = iu.getId();
									if ((match == null || match.matcher(id).matches()) && remainingIUs.remove(iu)
											&& (exclusion == null || !exclusion.matcher(id).matches())) {
										InstallableUnitAnalysis installableUnitAnalysis = AnalyzerFactory.eINSTANCE
												.createInstallableUnitAnalysis();
										installableUnitAnalysis.setInstallableUnit(iu);
										usedIUs.put(iu, installableUnitAnalysis);
										installableUnits.add(installableUnitAnalysis);

										EList<RequirementAnalysis> requirements = installableUnitAnalysis
												.getRequirements();

										for (IRequirement requirement : iu.getRequirements()) {
											RequirementAnalysis requirementAnalysis = AnalyzerFactory.eINSTANCE
													.createRequirementAnalysis();
											requirementAnalysis.setRequirement(requirement);
											requirements.add(requirementAnalysis);

											IMatchExpression<IInstallableUnit> matches = requirement.getMatches();
											dependencies.put(requirementAnalysis, executor.submit(
													() -> query(queriable, QueryUtil.createMatchQuery(matches))));
										}

										ECollections.sort(requirements,
												RequirementAnalysis.REQUIREMENT_ANALYSIS_COMPARATOR);
									}
								}

								ECollections.sort(installableUnits,

										InstallableUnitAnalysis.INSTALLABLE_UNIT_ANALYIS_COMPARATOR);
							}
						}
					}

					subMonitor.worked(1);
					subMonitor.subTask("Analyzing dependencies");

					Map<InstallableUnitAnalysis, Set<RequirementResolution>> dependants = new LinkedHashMap<>();
					for (Map.Entry<RequirementAnalysis, Future<Set<IInstallableUnit>>> entry : dependencies
							.entrySet()) {
						RequirementAnalysis requirementAnalysis = entry.getKey();
						Set<IInstallableUnit> ius = entry.getValue().get();
						Set<RequirementResolution> resolutions = ius.stream() //
								.map(iu -> usedIUs.get(iu)).filter(Objects::nonNull) //
								.map(iu -> {
									RequirementResolution requirementResolution = AnalyzerFactory.eINSTANCE
											.createRequirementResolution();
									requirementResolution.setInstallableUnit(iu);
									dependants.computeIfAbsent(iu, i -> new LinkedHashSet<>())
											.add(requirementResolution);

									return requirementResolution;
								}).collect(Collectors.toSet());
						requirementAnalysis.getResolutions().addAll(resolutions);
					}

					subMonitor.worked(1);
					subMonitor.subTask("Building dependency results");

					for (Map.Entry<InstallableUnitAnalysis, Set<RequirementResolution>> entry : dependants.entrySet()) {
						InstallableUnitAnalysis installableUnitAnalysis = entry.getKey();
						EList<CapabilityAnalysis> capabilities = installableUnitAnalysis.getCapabilities();
						Set<RequirementResolution> requirementResolutions = entry.getValue();

						IInstallableUnit iu = installableUnitAnalysis.getInstallableUnit();
						for (IProvidedCapability capability : iu.getProvidedCapabilities()) {
							CapabilityAnalysis capabilityAnalysis = AnalyzerFactory.eINSTANCE
									.createCapabilityAnalysis();
							capabilityAnalysis.setCapability(capability);
							capabilities.add(capabilityAnalysis);
							EList<CapabilityResolution> resolutions = capabilityAnalysis.getResolutions();

							String namespace = capability.getNamespace();
							String name = capability.getName();
							for (Iterator<RequirementResolution> it = requirementResolutions.iterator(); it
									.hasNext();) {
								RequirementResolution requirementResolution = it.next();
								RequirementAnalysis requirementAnalysis = requirementResolution.getRequirement();
								IRequirement requirement = requirementAnalysis.getRequirement();
								if (requirement instanceof IRequiredCapability) {
									IRequiredCapability requiredCapability = (IRequiredCapability) requirement;
									String requiredNamespace = requiredCapability.getNamespace();
									String requiredName = requiredCapability.getName();
									if (requiredNamespace.equals(namespace) && requiredName.equals(name)) {
										CapabilityResolution capabilityResolution = AnalyzerFactory.eINSTANCE
												.createCapabilityResolution();
										capabilityResolution.setRequirement(requirementAnalysis);
										resolutions.add(capabilityResolution);
										requirementResolution.setCapability(capabilityAnalysis);
										it.remove();
									}
								} else {
									IMatchExpression<IInstallableUnit> match = requirement.getMatches();
									if (RequiredPropertiesMatch.isPropertiesMatchRequirement(match)) {
										String requiredNamespace = RequiredPropertiesMatch.extractNamespace(match);
										if (namespace.equals(requiredNamespace)) {
											IFilterExpression propertiesMatch = RequiredPropertiesMatch
													.extractPropertiesMatch(match);
											if (propertiesMatch.match(capability.getProperties())) {
												CapabilityResolution capabilityResolution = AnalyzerFactory.eINSTANCE
														.createCapabilityResolution();
												capabilityResolution.setRequirement(requirementAnalysis);
												resolutions.add(capabilityResolution);
												requirementResolution.setCapability(capabilityAnalysis);
												it.remove();
											}
										}
									}
								}
							}

							ECollections.sort(resolutions, CapabilityResolution.CAPABILITY_RESOLUTION_COMPARATOR);
						}

						if (!requirementResolutions.isEmpty()) {
							System.err.println("###" + requirementResolutions);
						}
					}

					aggregateMetadataRepository.getInstallableUnits().retainAll(usedIUs.keySet());

					aggregateMetadataRepositoryResource = new P2ResourceFactoryImpl()
							.createResource(AGGREGATE_REPOSITORY);
					aggregateMetadataRepositoryResource.getContents().add(aggregateMetadataRepository);

					structuredAggregateMetadataRepositoryResource = new MetadataRepositoryResourceFactoryImpl()
							.createResource(STRUCTURED_AGGREGATE_REPOSITORY);
					structuredAggregateMetadataRepositoryResource.getContents()
							.add((EObject) MetadataRepositoryStructuredViewBuilder.create(aggregateMetadataRepository));

					Comparator<String> comparator = CommonPlugin.INSTANCE.getComparator();
					ECollections.sort(analysis.getContributions(), (c1, c2) -> {
						String label1 = c1.getLabel();
						String label2 = c2.getLabel();
						return comparator.compare(label1, label2);
					});

					subMonitor.worked(1);
					subMonitor.subTask("Background tasks completed");

					return analysis;
				}

				return null;
			} finally {
				shutDownExecutor();
			}
		}

		private ExecutorService getExecutor() {
			if (executor == null) {
				executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
			}

			return executor;
		}

		private void shutDownExecutor() throws InterruptedException {
			if (executor != null) {
				executor.shutdown();
				executor.awaitTermination(10, TimeUnit.MINUTES);
				executor = null;
			}
		}

		private Set<IInstallableUnit> query(IQueryable<IInstallableUnit> queriable, IQuery<IInstallableUnit> query) {
			IQueryResult<IInstallableUnit> queryResult = queriable.query(query, new NullProgressMonitor());
			Set<IInstallableUnit> result = new TreeSet<IInstallableUnit>();
			for (IInstallableUnit iu : queryResult) {
				result.add(iu);
			}

			return result;
		}

		private void collectChildren(IQueryable<IInstallableUnit> queriable, Set<IInstallableUnit> allIUs,
				IInstallableUnit iu) {
			if (allIUs.add(iu)) {
				for (IRequirement requirement : iu.getRequirements()) {
					if (requirement instanceof IRequiredCapability) {
						IRequiredCapability requiredCapability = (IRequiredCapability) requirement;
						if (IInstallableUnit.NAMESPACE_IU_ID.equals(requiredCapability.getNamespace())) {
							VersionRange range = requiredCapability.getRange();
							Version minimum = range.getMinimum();
							if (minimum.equals(range.getMaximum())) {
								Set<IInstallableUnit> result = query(queriable,
										QueryUtil.createIUQuery(requiredCapability.getName(), minimum));
								if (result.isEmpty()) {
									System.err.println("### not found " + requirement + " in " + queriable);
								} else {
									IInstallableUnit requiredIU = result.iterator().next();
									collectChildren(queriable, allIUs, requiredIU);
								}
							}
						}
					}
				}
			}
		}
	}

	public static class QueryableArray extends IndexProvider<IInstallableUnit> {
		private final List<IInstallableUnit> dataSet;
		private final IIndex<IInstallableUnit> capabilityIndex;
		private final IIndex<IInstallableUnit> idIndex;
		private final TranslationSupport translationSupport;

		public QueryableArray(IInstallableUnit[] ius) {
			this(Arrays.asList(ius));
		}

		public QueryableArray(Collection<? extends IInstallableUnit> ius) {
			dataSet = new ArrayList<>(ius);
			capabilityIndex = new CapabilityIndex(dataSet.iterator());
			idIndex = new IdIndex(dataSet.iterator());
			translationSupport = new TranslationSupport(this);
		}

		@Override
		public Iterator<IInstallableUnit> everything() {
			return dataSet.iterator();
		}

		@Override
		public IIndex<IInstallableUnit> getIndex(String memberName) {
			if (org.eclipse.equinox.internal.p2.metadata.InstallableUnit.MEMBER_PROVIDED_CAPABILITIES
					.equals(memberName)) {
				return capabilityIndex;
			}
			if (org.eclipse.equinox.internal.p2.metadata.InstallableUnit.MEMBER_ID.equals(memberName)) {
				return idIndex;
			}
			return null;
		}

		@Override
		public Object getManagedProperty(Object client, String memberName, Object key) {
			if (client instanceof IInstallableUnit
					&& org.eclipse.equinox.internal.p2.metadata.InstallableUnit.MEMBER_TRANSLATED_PROPERTIES
							.equals(memberName)) {
				IInstallableUnit iu = (IInstallableUnit) client;
				return key instanceof KeyWithLocale ? translationSupport.getIUProperty(iu, (KeyWithLocale) key)
						: translationSupport.getIUProperty(iu, key.toString());
			}
			return null;
		}
	}
}
