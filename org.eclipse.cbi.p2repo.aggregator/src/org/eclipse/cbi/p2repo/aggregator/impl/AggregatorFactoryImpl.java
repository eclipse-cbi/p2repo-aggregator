/**
 * Copyright (c) 2021 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.impl;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregationType;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.Architecture;
import org.eclipse.cbi.p2repo.aggregator.AvailableFrom;
import org.eclipse.cbi.p2repo.aggregator.AvailableVersion;
import org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader;
import org.eclipse.cbi.p2repo.aggregator.Bundle;
import org.eclipse.cbi.p2repo.aggregator.Category;
import org.eclipse.cbi.p2repo.aggregator.Configuration;
import org.eclipse.cbi.p2repo.aggregator.Contact;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.CustomCategory;
import org.eclipse.cbi.p2repo.aggregator.DescriptionProvider;
import org.eclipse.cbi.p2repo.aggregator.ExclusionRule;
import org.eclipse.cbi.p2repo.aggregator.Feature;
import org.eclipse.cbi.p2repo.aggregator.InfosProvider;
import org.eclipse.cbi.p2repo.aggregator.InstallableUnitType;
import org.eclipse.cbi.p2repo.aggregator.MapRule;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MappedUnit;
import org.eclipse.cbi.p2repo.aggregator.MavenItem;
import org.eclipse.cbi.p2repo.aggregator.MavenMapping;
import org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference;
import org.eclipse.cbi.p2repo.aggregator.OperatingSystem;
import org.eclipse.cbi.p2repo.aggregator.PackedStrategy;
import org.eclipse.cbi.p2repo.aggregator.Product;
import org.eclipse.cbi.p2repo.aggregator.Property;
import org.eclipse.cbi.p2repo.aggregator.Status;
import org.eclipse.cbi.p2repo.aggregator.StatusCode;
import org.eclipse.cbi.p2repo.aggregator.ValidConfigurationsRule;
import org.eclipse.cbi.p2repo.aggregator.ValidationSet;
import org.eclipse.cbi.p2repo.aggregator.VersionFormat;
import org.eclipse.cbi.p2repo.aggregator.VersionMatch;
import org.eclipse.cbi.p2repo.aggregator.WindowSystem;
import org.eclipse.cbi.p2repo.aggregator.util.InstallableUnitUtils;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AggregatorFactoryImpl extends EFactoryImpl implements AggregatorFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AggregatorPackage getPackage() {
		return AggregatorPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AggregatorFactory init() {
		try {
			AggregatorFactory theAggregatorFactory = (AggregatorFactory) EPackage.Registry.INSTANCE
					.getEFactory(AggregatorPackage.eNS_URI);
			if (theAggregatorFactory != null) {
				return theAggregatorFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AggregatorFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatorFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAggregationTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArchitectureToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAvailableFromToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertInstallableUnitTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatingSystemToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPackedStrategyToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStatusCodeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case AggregatorPackage.AGGREGATION_TYPE:
				return convertAggregationTypeToString(eDataType, instanceValue);
			case AggregatorPackage.ARCHITECTURE:
				return convertArchitectureToString(eDataType, instanceValue);
			case AggregatorPackage.AVAILABLE_FROM:
				return convertAvailableFromToString(eDataType, instanceValue);
			case AggregatorPackage.INSTALLABLE_UNIT_TYPE:
				return convertInstallableUnitTypeToString(eDataType, instanceValue);
			case AggregatorPackage.OPERATING_SYSTEM:
				return convertOperatingSystemToString(eDataType, instanceValue);
			case AggregatorPackage.PACKED_STRATEGY:
				return convertPackedStrategyToString(eDataType, instanceValue);
			case AggregatorPackage.STATUS_CODE:
				return convertStatusCodeToString(eDataType, instanceValue);
			case AggregatorPackage.VERSION_MATCH:
				return convertVersionMatchToString(eDataType, instanceValue);
			case AggregatorPackage.WINDOW_SYSTEM:
				return convertWindowSystemToString(eDataType, instanceValue);
			case AggregatorPackage.VERSION_FORMAT:
				return convertVersionFormatToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException(
						"The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVersionMatchToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertWindowSystemToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionFormat createVersionFormatFromString(EDataType eDataType, String initialValue) {
		VersionFormat result = VersionFormat.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertVersionFormatToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AggregatorPackage.AGGREGATION:
				return (EObject) createAggregation();
			case AggregatorPackage.AVAILABLE_VERSIONS_HEADER:
				return (EObject) createAvailableVersionsHeader();
			case AggregatorPackage.AVAILABLE_VERSION:
				return (EObject) createAvailableVersion();
			case AggregatorPackage.BUNDLE:
				return (EObject) createBundle();
			case AggregatorPackage.CATEGORY:
				return (EObject) createCategory();
			case AggregatorPackage.CONFIGURATION:
				return (EObject) createConfiguration();
			case AggregatorPackage.CONTACT:
				return (EObject) createContact();
			case AggregatorPackage.CONTRIBUTION:
				return (EObject) createContribution();
			case AggregatorPackage.FEATURE:
				return (EObject) createFeature();
			case AggregatorPackage.CUSTOM_CATEGORY:
				return (EObject) createCustomCategory();
			case AggregatorPackage.DESCRIPTION_PROVIDER:
				return (EObject) createDescriptionProvider();
			case AggregatorPackage.EXCLUSION_RULE:
				return (EObject) createExclusionRule();
			case AggregatorPackage.INFOS_PROVIDER:
				return (EObject) createInfosProvider();
			case AggregatorPackage.MAPPED_REPOSITORY:
				return (EObject) createMappedRepository();
			case AggregatorPackage.MAVEN_ITEM:
				return (EObject) createMavenItem();
			case AggregatorPackage.MAVEN_MAPPING:
				return (EObject) createMavenMapping();
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE:
				return (EObject) createMetadataRepositoryReference();
			case AggregatorPackage.PRODUCT:
				return (EObject) createProduct();
			case AggregatorPackage.PROPERTY:
				return (EObject) createProperty();
			case AggregatorPackage.STATUS:
				return (EObject) createStatus();
			case AggregatorPackage.VALIDATION_SET:
				return (EObject) createValidationSet();
			case AggregatorPackage.VALID_CONFIGURATIONS_RULE:
				return (EObject) createValidConfigurationsRule();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Aggregation createAggregation() {
		AggregationImpl aggregation = new AggregationImpl();
		return aggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregationType createAggregationTypeFromString(EDataType eDataType, String initialValue) {
		AggregationType result = AggregationType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Architecture createArchitectureFromString(EDataType eDataType, String initialValue) {
		Architecture result = Architecture.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvailableFrom createAvailableFromFromString(EDataType eDataType, String initialValue) {
		AvailableFrom result = AvailableFrom.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AvailableVersion createAvailableVersion() {
		AvailableVersionImpl availableVersion = new AvailableVersionImpl();
		return availableVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AvailableVersionsHeader createAvailableVersionsHeader() {
		AvailableVersionsHeaderImpl availableVersionsHeader = new AvailableVersionsHeaderImpl();
		return availableVersionsHeader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bundle createBundle() {
		BundleImpl bundle = new BundleImpl();
		return bundle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Category createCategory() {
		CategoryImpl category = new CategoryImpl();
		return category;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Configuration createConfiguration() {
		ConfigurationImpl configuration = new ConfigurationImpl();
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Contact createContact() {
		ContactImpl contact = new ContactImpl();
		return contact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Contribution createContribution() {
		ContributionImpl contribution = new ContributionImpl();
		return contribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CustomCategory createCustomCategory() {
		CustomCategoryImpl customCategory = new CustomCategoryImpl();
		return customCategory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DescriptionProvider createDescriptionProvider() {
		DescriptionProviderImpl descriptionProvider = new DescriptionProviderImpl();
		return descriptionProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExclusionRule createExclusionRule() {
		ExclusionRuleImpl exclusionRule = new ExclusionRuleImpl();
		return exclusionRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Feature createFeature() {
		FeatureImpl feature = new FeatureImpl();
		return feature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case AggregatorPackage.AGGREGATION_TYPE:
				return createAggregationTypeFromString(eDataType, initialValue);
			case AggregatorPackage.ARCHITECTURE:
				return createArchitectureFromString(eDataType, initialValue);
			case AggregatorPackage.AVAILABLE_FROM:
				return createAvailableFromFromString(eDataType, initialValue);
			case AggregatorPackage.INSTALLABLE_UNIT_TYPE:
				return createInstallableUnitTypeFromString(eDataType, initialValue);
			case AggregatorPackage.OPERATING_SYSTEM:
				return createOperatingSystemFromString(eDataType, initialValue);
			case AggregatorPackage.PACKED_STRATEGY:
				return createPackedStrategyFromString(eDataType, initialValue);
			case AggregatorPackage.STATUS_CODE:
				return createStatusCodeFromString(eDataType, initialValue);
			case AggregatorPackage.VERSION_MATCH:
				return createVersionMatchFromString(eDataType, initialValue);
			case AggregatorPackage.WINDOW_SYSTEM:
				return createWindowSystemFromString(eDataType, initialValue);
			case AggregatorPackage.VERSION_FORMAT:
				return createVersionFormatFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException(
						"The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InfosProvider createInfosProvider() {
		InfosProviderImpl infosProvider = new InfosProviderImpl();
		return infosProvider;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstallableUnitType createInstallableUnitTypeFromString(EDataType eDataType, String initialValue) {
		InstallableUnitType result = InstallableUnitType.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MappedRepository createMappedRepository() {
		MappedRepositoryImpl mappedRepository = new MappedRepositoryImpl();
		return mappedRepository;
	}

	/**
	 *
	 * @generated NOT
	 */
	@Override
	public MappedRepository createMappedRepository(MetadataRepository mdr) {
		MappedRepository mappedRepo = createMappedRepository();
		mappedRepo.setMetadataRepository(mdr);
		mappedRepo.setLocation(mdr.getLocation().toString());

		return mappedRepo;
	}

	/**
	 *
	 * @generated NOT
	 */
	@Override
	public MappedUnit createMappedUnit(IInstallableUnit iu) {
		MappedUnit mu = null;

		switch (InstallableUnitUtils.getType(iu)) {
			case FEATURE:
				mu = createFeature();
				break;
			case CATEGORY:
				mu = createCategory();
				break;
			case BUNDLE:
			case FRAGMENT:
				mu = createBundle();
				break;
			case PRODUCT:
				mu = createProduct();
				break;
			default:
				throw new IllegalArgumentException("Unknown IU type");
		}

		mu.setName(iu.getId());
		mu.setVersionRange(new VersionRange(iu.getVersion(), true, Version.MAX_VERSION, true));

		return mu;
	}

	/**
	 *
	 * @generated NOT
	 */
	@Override
	public MapRule createMapRule(IInstallableUnit iu, Class<? extends MapRule> ruleClass) {
		MapRule mr = null;

		if (ruleClass.isAssignableFrom(ExclusionRule.class))
			mr = createExclusionRule();
		else if (ruleClass.isAssignableFrom(ValidConfigurationsRule.class))
			mr = createValidConfigurationsRule();
		else
			throw new IllegalArgumentException("Unknown rule class " + ruleClass);

		mr.setName(iu.getId());
		mr.setVersionRange(new VersionRange(iu.getVersion(), true, Version.MAX_VERSION, true));

		return mr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MavenItem createMavenItem() {
		MavenItemImpl mavenItem = new MavenItemImpl();
		return mavenItem;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MavenMapping createMavenMapping() {
		MavenMappingImpl mavenMapping = new MavenMappingImpl();
		return mavenMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetadataRepositoryReference createMetadataRepositoryReference() {
		MetadataRepositoryReferenceImpl metadataRepositoryReference = new MetadataRepositoryReferenceImpl();
		return metadataRepositoryReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatingSystem createOperatingSystemFromString(EDataType eDataType, String initialValue) {
		OperatingSystem result = OperatingSystem.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PackedStrategy createPackedStrategyFromString(EDataType eDataType, String initialValue) {
		PackedStrategy result = PackedStrategy.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Product createProduct() {
		ProductImpl product = new ProductImpl();
		return product;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 *
	 * @generated NOT
	 */
	@Override
	public Property createProperty(String key, String value) {
		PropertyImpl property = new PropertyImpl(key, value);
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Status createStatus() {
		StatusImpl status = new StatusImpl();
		return status;
	}

	@Override
	public Status createStatus(StatusCode statusCode) {
		return StatusImpl.createStatus(statusCode);
	}

	@Override
	public Status createStatus(StatusCode statusCode, String message) {
		return StatusImpl.createStatus(statusCode, message);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatusCode createStatusCodeFromString(EDataType eDataType, String initialValue) {
		StatusCode result = StatusCode.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValidationSet createValidationSet() {
		ValidationSetImpl validationSet = new ValidationSetImpl();
		return validationSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ValidConfigurationsRule createValidConfigurationsRule() {
		ValidConfigurationsRuleImpl validConfigurationsRule = new ValidConfigurationsRuleImpl();
		return validConfigurationsRule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VersionMatch createVersionMatchFromString(EDataType eDataType, String initialValue) {
		VersionMatch result = VersionMatch.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WindowSystem createWindowSystemFromString(EDataType eDataType, String initialValue) {
		WindowSystem result = WindowSystem.get(initialValue);
		if (result == null)
			throw new IllegalArgumentException(
					"The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AggregatorPackage getAggregatorPackage() {
		return (AggregatorPackage) getEPackage();
	}

} // AggregatorFactoryImpl
