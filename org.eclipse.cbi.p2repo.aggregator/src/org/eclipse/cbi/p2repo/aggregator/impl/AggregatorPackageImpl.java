/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
import org.eclipse.cbi.p2repo.aggregator.ChildrenProvider;
import org.eclipse.cbi.p2repo.aggregator.Configuration;
import org.eclipse.cbi.p2repo.aggregator.Contact;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.CustomCategory;
import org.eclipse.cbi.p2repo.aggregator.DescriptionProvider;
import org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider;
import org.eclipse.cbi.p2repo.aggregator.ExclusionRule;
import org.eclipse.cbi.p2repo.aggregator.Feature;
import org.eclipse.cbi.p2repo.aggregator.IdentificationProvider;
import org.eclipse.cbi.p2repo.aggregator.InfosProvider;
import org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest;
import org.eclipse.cbi.p2repo.aggregator.InstallableUnitType;
import org.eclipse.cbi.p2repo.aggregator.LabelProvider;
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
import org.eclipse.cbi.p2repo.aggregator.StatusProvider;
import org.eclipse.cbi.p2repo.aggregator.ValidConfigurationsRule;
import org.eclipse.cbi.p2repo.aggregator.ValidationSet;
import org.eclipse.cbi.p2repo.aggregator.VersionFormat;
import org.eclipse.cbi.p2repo.aggregator.VersionMatch;
import org.eclipse.cbi.p2repo.aggregator.WindowSystem;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.cbi.p2repo.aggregator.p2view.impl.P2viewPackageImpl;
import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class AggregatorPackageImpl extends EPackageImpl implements AggregatorPackage {
	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link AggregatorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AggregatorPackage init() {
		if (isInited)
			return (AggregatorPackage) EPackage.Registry.INSTANCE.getEPackage(AggregatorPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredAggregatorPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		AggregatorPackageImpl theAggregatorPackage = registeredAggregatorPackage instanceof AggregatorPackageImpl
				? (AggregatorPackageImpl) registeredAggregatorPackage
				: new AggregatorPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		P2Package.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(P2viewPackage.eNS_URI);
		P2viewPackageImpl theP2viewPackage = (P2viewPackageImpl) (registeredPackage instanceof P2viewPackageImpl
				? registeredPackage
				: P2viewPackage.eINSTANCE);

		// Create package meta-data objects
		theAggregatorPackage.createPackageContents();
		theP2viewPackage.createPackageContents();

		// Initialize created meta-data
		theAggregatorPackage.initializePackageContents();
		theP2viewPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAggregatorPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(AggregatorPackage.eNS_URI, theAggregatorPackage);
		return theAggregatorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass aggregationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validationSetEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass configurationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contributionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contactEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bundleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mappedUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass productEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertyEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass customCategoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enabledStatusProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mapRuleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass installableUnitRequestEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass exclusionRuleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass validConfigurationsRuleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metadataRepositoryReferenceEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statusProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass infosProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass availableVersionsHeaderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass availableVersionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum aggregationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass labelProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass descriptionProviderEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identificationProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mavenMappingEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mavenItemEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass childrenProviderEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass statusEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operatingSystemEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum windowSystemEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum versionFormatEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum architectureEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum availableFromEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum packedStrategyEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum installableUnitTypeEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum statusCodeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum versionMatchEEnum = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AggregatorPackageImpl() {
		super(eNS_URI, AggregatorFactory.eINSTANCE);
	}

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		aggregationEClass = createEClass(AGGREGATION);
		createEReference(aggregationEClass, AGGREGATION__VALIDATION_SETS);
		createEReference(aggregationEClass, AGGREGATION__CONFIGURATIONS);
		createEReference(aggregationEClass, AGGREGATION__CUSTOM_CATEGORIES);
		createEReference(aggregationEClass, AGGREGATION__CONTACTS);
		createEReference(aggregationEClass, AGGREGATION__BUILDMASTER);
		createEReference(aggregationEClass, AGGREGATION__BUILDMASTER_BACKUP);
		createEAttribute(aggregationEClass, AGGREGATION__LABEL);
		createEAttribute(aggregationEClass, AGGREGATION__BUILD_ROOT);
		createEAttribute(aggregationEClass, AGGREGATION__PACKED_STRATEGY);
		createEAttribute(aggregationEClass, AGGREGATION__SENDMAIL);
		createEAttribute(aggregationEClass, AGGREGATION__TYPE);
		createEAttribute(aggregationEClass, AGGREGATION__MAVEN_RESULT);
		createEAttribute(aggregationEClass, AGGREGATION__STRICT_MAVEN_VERSIONS);
		createEAttribute(aggregationEClass, AGGREGATION__VERSION_FORMAT);
		createEReference(aggregationEClass, AGGREGATION__MAVEN_MAPPINGS);
		createEAttribute(aggregationEClass, AGGREGATION__ALLOW_LEGACY_SITES);

		availableVersionsHeaderEClass = createEClass(AVAILABLE_VERSIONS_HEADER);
		createEReference(availableVersionsHeaderEClass, AVAILABLE_VERSIONS_HEADER__AVAILABLE_VERSIONS);
		createEReference(availableVersionsHeaderEClass, AVAILABLE_VERSIONS_HEADER__INSTALLABLE_UNIT_REQUEST);

		availableVersionEClass = createEClass(AVAILABLE_VERSION);
		createEAttribute(availableVersionEClass, AVAILABLE_VERSION__VERSION_MATCH);
		createEAttribute(availableVersionEClass, AVAILABLE_VERSION__VERSION);
		createEAttribute(availableVersionEClass, AVAILABLE_VERSION__FILTER);
		createEAttribute(availableVersionEClass, AVAILABLE_VERSION__AVAILABLE_FROM);

		bundleEClass = createEClass(BUNDLE);

		categoryEClass = createEClass(CATEGORY);
		createEAttribute(categoryEClass, CATEGORY__LABEL_OVERRIDE);

		childrenProviderEClass = createEClass(CHILDREN_PROVIDER);
		createEReference(childrenProviderEClass, CHILDREN_PROVIDER__CHILDREN);

		configurationEClass = createEClass(CONFIGURATION);
		createEAttribute(configurationEClass, CONFIGURATION__OPERATING_SYSTEM);
		createEAttribute(configurationEClass, CONFIGURATION__WINDOW_SYSTEM);
		createEAttribute(configurationEClass, CONFIGURATION__ARCHITECTURE);

		contactEClass = createEClass(CONTACT);
		createEAttribute(contactEClass, CONTACT__NAME);
		createEAttribute(contactEClass, CONTACT__EMAIL);
		createEReference(contactEClass, CONTACT__AGGREGATION);

		contributionEClass = createEClass(CONTRIBUTION);
		createEAttribute(contributionEClass, CONTRIBUTION__LABEL);
		createEReference(contributionEClass, CONTRIBUTION__REPOSITORIES);
		createEReference(contributionEClass, CONTRIBUTION__CONTACTS);
		createEReference(contributionEClass, CONTRIBUTION__MAVEN_MAPPINGS);

		featureEClass = createEClass(FEATURE);
		createEReference(featureEClass, FEATURE__CATEGORIES);

		customCategoryEClass = createEClass(CUSTOM_CATEGORY);
		createEAttribute(customCategoryEClass, CUSTOM_CATEGORY__IDENTIFIER);
		createEAttribute(customCategoryEClass, CUSTOM_CATEGORY__LABEL);
		createEAttribute(customCategoryEClass, CUSTOM_CATEGORY__DESCRIPTION);
		createEReference(customCategoryEClass, CUSTOM_CATEGORY__FEATURES);

		descriptionProviderEClass = createEClass(DESCRIPTION_PROVIDER);
		createEAttribute(descriptionProviderEClass, DESCRIPTION_PROVIDER__DESCRIPTION);

		enabledStatusProviderEClass = createEClass(ENABLED_STATUS_PROVIDER);
		createEAttribute(enabledStatusProviderEClass, ENABLED_STATUS_PROVIDER__BRANCH_ENABLED);
		createEAttribute(enabledStatusProviderEClass, ENABLED_STATUS_PROVIDER__ENABLED);

		exclusionRuleEClass = createEClass(EXCLUSION_RULE);

		identificationProviderEClass = createEClass(IDENTIFICATION_PROVIDER);

		infosProviderEClass = createEClass(INFOS_PROVIDER);
		createEAttribute(infosProviderEClass, INFOS_PROVIDER__ERRORS);
		createEAttribute(infosProviderEClass, INFOS_PROVIDER__WARNINGS);
		createEAttribute(infosProviderEClass, INFOS_PROVIDER__INFOS);

		installableUnitRequestEClass = createEClass(INSTALLABLE_UNIT_REQUEST);
		createEAttribute(installableUnitRequestEClass, INSTALLABLE_UNIT_REQUEST__NAME);
		createEAttribute(installableUnitRequestEClass, INSTALLABLE_UNIT_REQUEST__VERSION_RANGE);
		createEReference(installableUnitRequestEClass, INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER);
		createEReference(installableUnitRequestEClass, INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS);

		labelProviderEClass = createEClass(LABEL_PROVIDER);
		createEAttribute(labelProviderEClass, LABEL_PROVIDER__LABEL);

		mappedRepositoryEClass = createEClass(MAPPED_REPOSITORY);
		createEReference(mappedRepositoryEClass, MAPPED_REPOSITORY__PRODUCTS);
		createEReference(mappedRepositoryEClass, MAPPED_REPOSITORY__BUNDLES);
		createEReference(mappedRepositoryEClass, MAPPED_REPOSITORY__FEATURES);
		createEReference(mappedRepositoryEClass, MAPPED_REPOSITORY__CATEGORIES);
		createEAttribute(mappedRepositoryEClass, MAPPED_REPOSITORY__MIRROR_ARTIFACTS);
		createEAttribute(mappedRepositoryEClass, MAPPED_REPOSITORY__CATEGORY_PREFIX);
		createEReference(mappedRepositoryEClass, MAPPED_REPOSITORY__MAP_RULES);

		mappedUnitEClass = createEClass(MAPPED_UNIT);
		createEReference(mappedUnitEClass, MAPPED_UNIT__VALID_CONFIGURATIONS);

		mapRuleEClass = createEClass(MAP_RULE);

		mavenItemEClass = createEClass(MAVEN_ITEM);
		createEAttribute(mavenItemEClass, MAVEN_ITEM__GROUP_ID);
		createEAttribute(mavenItemEClass, MAVEN_ITEM__ARTIFACT_ID);
		createEAttribute(mavenItemEClass, MAVEN_ITEM__MAPPED_VERSION);
		createEAttribute(mavenItemEClass, MAVEN_ITEM__CLASSIFIER);
		createEReference(mavenItemEClass, MAVEN_ITEM__MAVEN_MAPPING);

		mavenMappingEClass = createEClass(MAVEN_MAPPING);
		createEAttribute(mavenMappingEClass, MAVEN_MAPPING__NAME_PATTERN);
		createEAttribute(mavenMappingEClass, MAVEN_MAPPING__GROUP_ID);
		createEAttribute(mavenMappingEClass, MAVEN_MAPPING__ARTIFACT_ID);
		createEAttribute(mavenMappingEClass, MAVEN_MAPPING__VERSION_PATTERN);
		createEAttribute(mavenMappingEClass, MAVEN_MAPPING__VERSION_TEMPLATE);

		metadataRepositoryReferenceEClass = createEClass(METADATA_REPOSITORY_REFERENCE);
		createEReference(metadataRepositoryReferenceEClass, METADATA_REPOSITORY_REFERENCE__METADATA_REPOSITORY);
		createEAttribute(metadataRepositoryReferenceEClass, METADATA_REPOSITORY_REFERENCE__LOCATION);
		createEAttribute(metadataRepositoryReferenceEClass, METADATA_REPOSITORY_REFERENCE__NATURE);

		productEClass = createEClass(PRODUCT);

		propertyEClass = createEClass(PROPERTY);
		createEAttribute(propertyEClass, PROPERTY__KEY);
		createEAttribute(propertyEClass, PROPERTY__VALUE);

		statusEClass = createEClass(STATUS);
		createEAttribute(statusEClass, STATUS__CODE);
		createEAttribute(statusEClass, STATUS__MESSAGE);

		statusProviderEClass = createEClass(STATUS_PROVIDER);
		createEReference(statusProviderEClass, STATUS_PROVIDER__STATUS);

		validationSetEClass = createEClass(VALIDATION_SET);
		createEAttribute(validationSetEClass, VALIDATION_SET__ABSTRACT);
		createEAttribute(validationSetEClass, VALIDATION_SET__EXTENSION);
		createEAttribute(validationSetEClass, VALIDATION_SET__LABEL);
		createEReference(validationSetEClass, VALIDATION_SET__CONTRIBUTIONS);
		createEReference(validationSetEClass, VALIDATION_SET__VALIDATION_REPOSITORIES);
		createEReference(validationSetEClass, VALIDATION_SET__EXTENDS);

		validConfigurationsRuleEClass = createEClass(VALID_CONFIGURATIONS_RULE);
		createEReference(validConfigurationsRuleEClass, VALID_CONFIGURATIONS_RULE__VALID_CONFIGURATIONS);

		// Create enums
		aggregationTypeEEnum = createEEnum(AGGREGATION_TYPE);
		architectureEEnum = createEEnum(ARCHITECTURE);
		availableFromEEnum = createEEnum(AVAILABLE_FROM);
		installableUnitTypeEEnum = createEEnum(INSTALLABLE_UNIT_TYPE);
		operatingSystemEEnum = createEEnum(OPERATING_SYSTEM);
		packedStrategyEEnum = createEEnum(PACKED_STRATEGY);
		statusCodeEEnum = createEEnum(STATUS_CODE);
		versionMatchEEnum = createEEnum(VERSION_MATCH);
		windowSystemEEnum = createEEnum(WINDOW_SYSTEM);
		versionFormatEEnum = createEEnum(VERSION_FORMAT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAggregation() {
		return aggregationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAggregation_AllowLegacySites() {
		return (EAttribute) aggregationEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAggregation_Buildmaster() {
		return (EReference) aggregationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAggregation_BuildmasterBackup() {
		return (EReference) aggregationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAggregation_BuildRoot() {
		return (EAttribute) aggregationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAggregation_Configurations() {
		return (EReference) aggregationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAggregation_Contacts() {
		return (EReference) aggregationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAggregation_CustomCategories() {
		return (EReference) aggregationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAggregation_Label() {
		return (EAttribute) aggregationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAggregation_MavenMappings() {
		return (EReference) aggregationEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAggregation_MavenResult() {
		return (EAttribute) aggregationEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAggregation_StrictMavenVersions() {
		return (EAttribute) aggregationEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAggregation_VersionFormat() {
		return (EAttribute) aggregationEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAggregation_PackedStrategy() {
		return (EAttribute) aggregationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAggregation_Sendmail() {
		return (EAttribute) aggregationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAggregation_Type() {
		return (EAttribute) aggregationEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAggregation_ValidationSets() {
		return (EReference) aggregationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getAggregationType() {
		return aggregationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AggregatorFactory getAggregatorFactory() {
		return (AggregatorFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getArchitecture() {
		return architectureEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getAvailableFrom() {
		return availableFromEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAvailableVersion() {
		return availableVersionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAvailableVersion_AvailableFrom() {
		return (EAttribute) availableVersionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAvailableVersion_Filter() {
		return (EAttribute) availableVersionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAvailableVersion_Version() {
		return (EAttribute) availableVersionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAvailableVersion_VersionMatch() {
		return (EAttribute) availableVersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAvailableVersionsHeader() {
		return availableVersionsHeaderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAvailableVersionsHeader_AvailableVersions() {
		return (EReference) availableVersionsHeaderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getAvailableVersionsHeader_InstallableUnitRequest() {
		return (EReference) availableVersionsHeaderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBundle() {
		return bundleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCategory() {
		return categoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCategory_LabelOverride() {
		return (EAttribute) categoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getChildrenProvider() {
		return childrenProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getChildrenProvider_Children() {
		return (EReference) childrenProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getConfiguration() {
		return configurationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfiguration_Architecture() {
		return (EAttribute) configurationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfiguration_OperatingSystem() {
		return (EAttribute) configurationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getConfiguration_WindowSystem() {
		return (EAttribute) configurationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContact() {
		return contactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContact_Aggregation() {
		return (EReference) contactEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContact_Email() {
		return (EAttribute) contactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContact_Name() {
		return (EAttribute) contactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContribution() {
		return contributionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContribution_Contacts() {
		return (EReference) contributionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContribution_Label() {
		return (EAttribute) contributionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContribution_MavenMappings() {
		return (EReference) contributionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContribution_Repositories() {
		return (EReference) contributionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCustomCategory() {
		return customCategoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCustomCategory_Description() {
		return (EAttribute) customCategoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCustomCategory_Features() {
		return (EReference) customCategoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCustomCategory_Identifier() {
		return (EAttribute) customCategoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCustomCategory_Label() {
		return (EAttribute) customCategoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDescriptionProvider() {
		return descriptionProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDescriptionProvider_Description() {
		return (EAttribute) descriptionProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnabledStatusProvider() {
		return enabledStatusProviderEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEnabledStatusProvider_BranchEnabled() {
		return (EAttribute) enabledStatusProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEnabledStatusProvider_Enabled() {
		return (EAttribute) enabledStatusProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExclusionRule() {
		return exclusionRuleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFeature() {
		return featureEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFeature_Categories() {
		return (EReference) featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIdentificationProvider() {
		return identificationProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInfosProvider() {
		return infosProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInfosProvider_Errors() {
		return (EAttribute) infosProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInfosProvider_Infos() {
		return (EAttribute) infosProviderEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInfosProvider_Warnings() {
		return (EAttribute) infosProviderEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInstallableUnitRequest() {
		return installableUnitRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstallableUnitRequest_AvailableVersions() {
		return (EReference) installableUnitRequestEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstallableUnitRequest_AvailableVersionsHeader() {
		return (EReference) installableUnitRequestEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInstallableUnitRequest_Name() {
		return (EAttribute) installableUnitRequestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getInstallableUnitRequest_VersionRange() {
		return (EAttribute) installableUnitRequestEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getInstallableUnitType() {
		return installableUnitTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLabelProvider() {
		return labelProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getLabelProvider_Label() {
		return (EAttribute) labelProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappedRepository() {
		return mappedRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedRepository_Bundles() {
		return (EReference) mappedRepositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedRepository_Categories() {
		return (EReference) mappedRepositoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappedRepository_CategoryPrefix() {
		return (EAttribute) mappedRepositoryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedRepository_Features() {
		return (EReference) mappedRepositoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedRepository_MapRules() {
		return (EReference) mappedRepositoryEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMappedRepository_MirrorArtifacts() {
		return (EAttribute) mappedRepositoryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedRepository_Products() {
		return (EReference) mappedRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMappedUnit() {
		return mappedUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMappedUnit_ValidConfigurations() {
		return (EReference) mappedUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMapRule() {
		return mapRuleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMavenItem() {
		return mavenItemEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMavenItem_ArtifactId() {
		return (EAttribute) mavenItemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMavenItem_MappedVersion() {
		return (EAttribute) mavenItemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMavenItem_Classifier() {
		return (EAttribute) mavenItemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMavenItem_MavenMapping() {
		return (EReference) mavenItemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMavenItem_GroupId() {
		return (EAttribute) mavenItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMavenMapping() {
		return mavenMappingEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMavenMapping_ArtifactId() {
		return (EAttribute) mavenMappingEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMavenMapping_VersionPattern() {
		return (EAttribute) mavenMappingEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMavenMapping_VersionTemplate() {
		return (EAttribute) mavenMappingEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMavenMapping_GroupId() {
		return (EAttribute) mavenMappingEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMavenMapping_NamePattern() {
		return (EAttribute) mavenMappingEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetadataRepositoryReference() {
		return metadataRepositoryReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetadataRepositoryReference_Location() {
		return (EAttribute) metadataRepositoryReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetadataRepositoryReference_MetadataRepository() {
		return (EReference) metadataRepositoryReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetadataRepositoryReference_Nature() {
		return (EAttribute) metadataRepositoryReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getOperatingSystem() {
		return operatingSystemEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getPackedStrategy() {
		return packedStrategyEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProduct() {
		return productEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProperty() {
		return propertyEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProperty_Key() {
		return (EAttribute) propertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getProperty_Value() {
		return (EAttribute) propertyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStatus() {
		return statusEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStatus_Code() {
		return (EAttribute) statusEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getStatus_Message() {
		return (EAttribute) statusEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getStatusCode() {
		return statusCodeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getStatusProvider() {
		return statusProviderEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getStatusProvider_Status() {
		return (EReference) statusProviderEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValidationSet() {
		return validationSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValidationSet_Abstract() {
		return (EAttribute) validationSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValidationSet_Contributions() {
		return (EReference) validationSetEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValidationSet_Extends() {
		return (EReference) validationSetEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValidationSet_Extension() {
		return (EAttribute) validationSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValidationSet_Label() {
		return (EAttribute) validationSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValidationSet_ValidationRepositories() {
		return (EReference) validationSetEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValidConfigurationsRule() {
		return validConfigurationsRuleEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValidConfigurationsRule_ValidConfigurations() {
		return (EReference) validConfigurationsRuleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getVersionMatch() {
		return versionMatchEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getWindowSystem() {
		return windowSystemEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getVersionFormat() {
		return versionFormatEEnum;
	}

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		P2viewPackage theP2viewPackage = (P2viewPackage) EPackage.Registry.INSTANCE.getEPackage(P2viewPackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE
				.getEPackage(XMLTypePackage.eNS_URI);
		P2Package theP2Package = (P2Package) EPackage.Registry.INSTANCE.getEPackage(P2Package.eNS_URI);

		// Add subpackages
		getESubpackages().add(theP2viewPackage);

		// Create type parameters
		ETypeParameter childrenProviderEClass_T = addETypeParameter(childrenProviderEClass, "T");

		// Set bounds for type parameters

		// Add supertypes to classes
		aggregationEClass.getESuperTypes().add(this.getDescriptionProvider());
		aggregationEClass.getESuperTypes().add(this.getStatusProvider());
		aggregationEClass.getESuperTypes().add(this.getInfosProvider());
		EGenericType g1 = createEGenericType(theP2Package.getComparable());
		EGenericType g2 = createEGenericType(this.getAvailableVersion());
		g1.getETypeArguments().add(g2);
		availableVersionEClass.getEGenericSuperTypes().add(g1);
		bundleEClass.getESuperTypes().add(this.getMappedUnit());
		categoryEClass.getESuperTypes().add(this.getMappedUnit());
		configurationEClass.getESuperTypes().add(this.getEnabledStatusProvider());
		contributionEClass.getESuperTypes().add(this.getEnabledStatusProvider());
		contributionEClass.getESuperTypes().add(this.getDescriptionProvider());
		contributionEClass.getESuperTypes().add(this.getStatusProvider());
		contributionEClass.getESuperTypes().add(this.getInfosProvider());
		contributionEClass.getESuperTypes().add(this.getIdentificationProvider());
		featureEClass.getESuperTypes().add(this.getMappedUnit());
		customCategoryEClass.getESuperTypes().add(this.getStatusProvider());
		customCategoryEClass.getESuperTypes().add(this.getInfosProvider());
		exclusionRuleEClass.getESuperTypes().add(this.getMapRule());
		installableUnitRequestEClass.getESuperTypes().add(this.getStatusProvider());
		installableUnitRequestEClass.getESuperTypes().add(this.getInfosProvider());
		installableUnitRequestEClass.getESuperTypes().add(this.getDescriptionProvider());
		mappedRepositoryEClass.getESuperTypes().add(this.getMetadataRepositoryReference());
		mappedRepositoryEClass.getESuperTypes().add(this.getDescriptionProvider());
		mappedRepositoryEClass.getESuperTypes().add(this.getIdentificationProvider());
		mappedUnitEClass.getESuperTypes().add(this.getInstallableUnitRequest());
		mappedUnitEClass.getESuperTypes().add(this.getEnabledStatusProvider());
		mappedUnitEClass.getESuperTypes().add(this.getIdentificationProvider());
		mapRuleEClass.getESuperTypes().add(this.getInstallableUnitRequest());
		mapRuleEClass.getESuperTypes().add(this.getDescriptionProvider());
		mapRuleEClass.getESuperTypes().add(this.getEnabledStatusProvider());
		mavenMappingEClass.getESuperTypes().add(this.getStatusProvider());
		mavenMappingEClass.getESuperTypes().add(this.getInfosProvider());
		metadataRepositoryReferenceEClass.getESuperTypes().add(this.getEnabledStatusProvider());
		metadataRepositoryReferenceEClass.getESuperTypes().add(this.getStatusProvider());
		metadataRepositoryReferenceEClass.getESuperTypes().add(this.getInfosProvider());
		productEClass.getESuperTypes().add(this.getMappedUnit());
		g1 = createEGenericType(theP2Package.getComparable());
		g2 = createEGenericType(this.getProperty());
		g1.getETypeArguments().add(g2);
		propertyEClass.getEGenericSuperTypes().add(g1);
		validationSetEClass.getESuperTypes().add(this.getEnabledStatusProvider());
		validationSetEClass.getESuperTypes().add(this.getDescriptionProvider());
		validationSetEClass.getESuperTypes().add(this.getStatusProvider());
		validationSetEClass.getESuperTypes().add(this.getInfosProvider());
		validationSetEClass.getESuperTypes().add(this.getIdentificationProvider());
		validConfigurationsRuleEClass.getESuperTypes().add(this.getMapRule());

		// Initialize classes and features; add operations and parameters
		initEClass(aggregationEClass, Aggregation.class, "Aggregation", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAggregation_ValidationSets(), this.getValidationSet(), null, "validationSets", null, 0, -1,
				Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getAggregation_ValidationSets().getEKeys().add(this.getValidationSet_Label());
		initEReference(getAggregation_Configurations(), this.getConfiguration(), null, "configurations", null, 1, -1,
				Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAggregation_CustomCategories(), this.getCustomCategory(), null, "customCategories", null, 0,
				-1, Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getAggregation_CustomCategories().getEKeys().add(this.getCustomCategory_Identifier());
		initEReference(getAggregation_Contacts(), this.getContact(), this.getContact_Aggregation(), "contacts", null, 0,
				-1, Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getAggregation_Contacts().getEKeys().add(this.getContact_Email());
		initEReference(getAggregation_Buildmaster(), this.getContact(), null, "buildmaster", null, 0, 1,
				Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getAggregation_Buildmaster().getEKeys().add(this.getContact_Email());
		initEReference(getAggregation_BuildmasterBackup(), this.getContact(), null, "buildmasterBackup", null, 0, 1,
				Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getAggregation_BuildmasterBackup().getEKeys().add(this.getContact_Email());
		initEAttribute(getAggregation_Label(), ecorePackage.getEString(), "label", null, 1, 1, Aggregation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregation_BuildRoot(), ecorePackage.getEString(), "buildRoot", "${user.home}/build", 0, 1,
				Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregation_PackedStrategy(), this.getPackedStrategy(), "packedStrategy", null, 0, 1,
				Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregation_Sendmail(), ecorePackage.getEBoolean(), "sendmail", null, 0, 1, Aggregation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregation_Type(), this.getAggregationType(), "type", null, 1, 1, Aggregation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregation_MavenResult(), ecorePackage.getEBoolean(), "mavenResult", null, 0, 1,
				Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregation_StrictMavenVersions(), ecorePackage.getEBoolean(), "strictMavenVersions", null, 0,
				1, Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregation_VersionFormat(), this.getVersionFormat(), "versionFormat", null, 0, 1,
				Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getAggregation_MavenMappings(), this.getMavenMapping(), null, "mavenMappings", null, 0, -1,
				Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAggregation_AllowLegacySites(), theXMLTypePackage.getBoolean(), "allowLegacySites", "true", 0,
				1, Aggregation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		EOperation op = addEOperation(aggregationEClass, this.getMetadataRepositoryReference(),
				"getAllMetadataRepositoryReferences", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "enabledOnly", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(aggregationEClass, this.getValidationSet(), "getValidationSets", 0, -1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "enabledOnly", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(aggregationEClass, this.getContribution(), "getAllContributions", 0, -1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "enabledOnly", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(availableVersionsHeaderEClass, AvailableVersionsHeader.class, "AvailableVersionsHeader",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAvailableVersionsHeader_AvailableVersions(), this.getAvailableVersion(), null,
				"availableVersions", null, 0, -1, AvailableVersionsHeader.class, IS_TRANSIENT, IS_VOLATILE,
				!IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAvailableVersionsHeader_InstallableUnitRequest(), this.getInstallableUnitRequest(),
				this.getInstallableUnitRequest_AvailableVersionsHeader(), "installableUnitRequest", null, 1, 1,
				AvailableVersionsHeader.class, IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(availableVersionEClass, AvailableVersion.class, "AvailableVersion", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAvailableVersion_VersionMatch(), this.getVersionMatch(), "versionMatch", null, 1, 1,
				AvailableVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getAvailableVersion_Version(), theP2Package.getVersion(), "version", null, 0, 1,
				AvailableVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(theP2Package.getIMatchExpression());
		g2 = createEGenericType(theP2Package.getIInstallableUnit());
		g1.getETypeArguments().add(g2);
		initEAttribute(getAvailableVersion_Filter(), g1, "filter", null, 0, 1, AvailableVersion.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAvailableVersion_AvailableFrom(), this.getAvailableFrom(), "availableFrom", "repository", 1,
				1, AvailableVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bundleEClass, Bundle.class, "Bundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCategory_LabelOverride(), ecorePackage.getEString(), "labelOverride", null, 0, 1,
				Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(childrenProviderEClass, ChildrenProvider.class, "ChildrenProvider", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(childrenProviderEClass_T);
		initEReference(getChildrenProvider_Children(), g1, null, "children", null, 0, -1, ChildrenProvider.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(configurationEClass, Configuration.class, "Configuration", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConfiguration_OperatingSystem(), this.getOperatingSystem(), "operatingSystem", null, 1, 1,
				Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_WindowSystem(), this.getWindowSystem(), "windowSystem", null, 1, 1,
				Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getConfiguration_Architecture(), this.getArchitecture(), "architecture", null, 1, 1,
				Configuration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		addEOperation(configurationEClass, ecorePackage.getEString(), "getName", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(configurationEClass, ecorePackage.getEString(), "getOSGiEnvironmentString", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(contactEClass, Contact.class, "Contact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContact_Name(), ecorePackage.getEString(), "name", null, 0, 1, Contact.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContact_Email(), ecorePackage.getEString(), "email", null, 1, 1, Contact.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContact_Aggregation(), this.getAggregation(), this.getAggregation_Contacts(), "aggregation",
				null, 1, 1, Contact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contributionEClass, Contribution.class, "Contribution", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContribution_Label(), ecorePackage.getEString(), "label", null, 1, 1, Contribution.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContribution_Repositories(), this.getMappedRepository(), null, "repositories", null, 0, -1,
				Contribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContribution_Contacts(), this.getContact(), null, "contacts", null, 0, -1, Contribution.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getContribution_Contacts().getEKeys().add(this.getContact_Email());
		initEReference(getContribution_MavenMappings(), this.getMavenMapping(), null, "mavenMappings", null, 0, -1,
				Contribution.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(contributionEClass, this.getMappedRepository(), "getRepositories", 0, -1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "enabledOnly", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(contributionEClass, this.getMavenMapping(), "getAllMavenMappings", 0, -1, IS_UNIQUE, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeature_Categories(), this.getCustomCategory(), this.getCustomCategory_Features(),
				"categories", null, 0, -1, Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(customCategoryEClass, CustomCategory.class, "CustomCategory", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCustomCategory_Identifier(), ecorePackage.getEString(), "identifier", null, 1, 1,
				CustomCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomCategory_Label(), ecorePackage.getEString(), "label", null, 0, 1, CustomCategory.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCustomCategory_Description(), ecorePackage.getEString(), "description", null, 0, 1,
				CustomCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getCustomCategory_Features(), this.getFeature(), this.getFeature_Categories(), "features", null,
				0, -1, CustomCategory.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(descriptionProviderEClass, DescriptionProvider.class, "DescriptionProvider", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDescriptionProvider_Description(), theXMLTypePackage.getString(), "description", null, 0, 1,
				DescriptionProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enabledStatusProviderEClass, EnabledStatusProvider.class, "EnabledStatusProvider", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEnabledStatusProvider_BranchEnabled(), ecorePackage.getEBoolean(), "branchEnabled", "false",
				0, 1, EnabledStatusProvider.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnabledStatusProvider_Enabled(), ecorePackage.getEBoolean(), "enabled", "true", 0, 1,
				EnabledStatusProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(exclusionRuleEClass, ExclusionRule.class, "ExclusionRule", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(identificationProviderEClass, IdentificationProvider.class, "IdentificationProvider", IS_ABSTRACT,
				IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		addEOperation(identificationProviderEClass, ecorePackage.getEString(), "getIdentification", 1, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(infosProviderEClass, InfosProvider.class, "InfosProvider", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInfosProvider_Errors(), theXMLTypePackage.getString(), "errors", null, 0, -1,
				InfosProvider.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getInfosProvider_Warnings(), theXMLTypePackage.getString(), "warnings", null, 0, -1,
				InfosProvider.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getInfosProvider_Infos(), theXMLTypePackage.getString(), "infos", null, 0, -1,
				InfosProvider.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(installableUnitRequestEClass, InstallableUnitRequest.class, "InstallableUnitRequest", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInstallableUnitRequest_Name(), ecorePackage.getEString(), "name", null, 0, 1,
				InstallableUnitRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getInstallableUnitRequest_VersionRange(), theP2Package.getVersionRange(), "versionRange",
				"0.0.0", 0, 1, InstallableUnitRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstallableUnitRequest_AvailableVersionsHeader(), this.getAvailableVersionsHeader(),
				this.getAvailableVersionsHeader_InstallableUnitRequest(), "availableVersionsHeader", null, 0, 1,
				InstallableUnitRequest.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstallableUnitRequest_AvailableVersions(), this.getAvailableVersion(), null,
				"availableVersions", null, 0, -1, InstallableUnitRequest.class, IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(installableUnitRequestEClass, ecorePackage.getEBoolean(), "isMappedRepositoryBroken", 0, 1,
				IS_UNIQUE, IS_ORDERED);

		addEOperation(installableUnitRequestEClass, ecorePackage.getEBoolean(), "isBranchEnabled", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		addEOperation(installableUnitRequestEClass, theP2Package.getIInstallableUnit(), "resolveAsSingleton", 0, 1,
				IS_UNIQUE, IS_ORDERED);

		op = addEOperation(installableUnitRequestEClass, theP2Package.getIInstallableUnit(), "resolveAsSingleton", 0, 1,
				IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "forceResolve", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(installableUnitRequestEClass, null, "resolveAvailableVersions", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theXMLTypePackage.getBoolean(), "updateOnly", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(labelProviderEClass, LabelProvider.class, "LabelProvider", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLabelProvider_Label(), theXMLTypePackage.getString(), "label", null, 0, 1,
				LabelProvider.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(mappedRepositoryEClass, MappedRepository.class, "MappedRepository", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappedRepository_Products(), this.getProduct(), null, "products", null, 0, -1,
				MappedRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedRepository_Bundles(), this.getBundle(), null, "bundles", null, 0, -1,
				MappedRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedRepository_Features(), this.getFeature(), null, "features", null, 0, -1,
				MappedRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMappedRepository_Categories(), this.getCategory(), null, "categories", null, 0, -1,
				MappedRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappedRepository_MirrorArtifacts(), ecorePackage.getEBoolean(), "mirrorArtifacts", "true", 0,
				1, MappedRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMappedRepository_CategoryPrefix(), ecorePackage.getEString(), "categoryPrefix", null, 0, 1,
				MappedRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getMappedRepository_MapRules(), this.getMapRule(), null, "mapRules", null, 0, -1,
				MappedRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(mappedRepositoryEClass, this.getMapRule(), "getMapRules", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "enabledOnly", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mappedRepositoryEClass, this.getMappedUnit(), "getUnits", 0, -1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "enabledOnly", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(mappedRepositoryEClass, ecorePackage.getEBoolean(), "isMapExclusive", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		initEClass(mappedUnitEClass, MappedUnit.class, "MappedUnit", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMappedUnit_ValidConfigurations(), this.getConfiguration(), null, "validConfigurations", null,
				0, -1, MappedUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getMappedUnit_ValidConfigurations().getEKeys().add(this.getConfiguration_OperatingSystem());
		getMappedUnit_ValidConfigurations().getEKeys().add(this.getConfiguration_WindowSystem());
		getMappedUnit_ValidConfigurations().getEKeys().add(this.getConfiguration_Architecture());

		addEOperation(mappedUnitEClass, theP2Package.getIRequirement(), "getRequirement", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mappedUnitEClass, null, "getFilter", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(theP2Package.getIMatchExpression());
		g2 = createEGenericType(theP2Package.getIInstallableUnit());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(mapRuleEClass, MapRule.class, "MapRule", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(mavenItemEClass, MavenItem.class, "MavenItem", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMavenItem_GroupId(), theXMLTypePackage.getString(), "groupId", null, 0, 1, MavenItem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMavenItem_ArtifactId(), ecorePackage.getEString(), "artifactId", null, 0, 1, MavenItem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMavenItem_MappedVersion(), ecorePackage.getEString(), "mappedVersion", null, 0, 1,
				MavenItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getMavenItem_Classifier(), ecorePackage.getEString(), "classifier", null, 0, 1, MavenItem.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMavenItem_MavenMapping(), this.getMavenMapping(), null, "mavenMapping", null, 0, 1,
				MavenItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(mavenItemEClass, ecorePackage.getEBoolean(), "isSources", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(mavenMappingEClass, MavenMapping.class, "MavenMapping", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMavenMapping_NamePattern(), ecorePackage.getEString(), "namePattern", null, 0, 1,
				MavenMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getMavenMapping_GroupId(), ecorePackage.getEString(), "groupId", null, 0, 1, MavenMapping.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMavenMapping_ArtifactId(), ecorePackage.getEString(), "artifactId", null, 0, 1,
				MavenMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getMavenMapping_VersionPattern(), ecorePackage.getEString(), "versionPattern", null, 0, 1,
				MavenMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getMavenMapping_VersionTemplate(), ecorePackage.getEString(), "versionTemplate", null, 0, 1,
				MavenMapping.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		op = addEOperation(mavenMappingEClass, this.getMavenItem(), "map", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "installableUnitID", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theP2Package.getVersion(), "version", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(mavenMappingEClass, ecorePackage.getEString(), "mapVersion", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, theP2Package.getVersion(), "version", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(metadataRepositoryReferenceEClass, MetadataRepositoryReference.class, "MetadataRepositoryReference",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMetadataRepositoryReference_MetadataRepository(), theP2Package.getMetadataRepository(), null,
				"metadataRepository", null, 0, 1, MetadataRepositoryReference.class, IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetadataRepositoryReference_Location(), ecorePackage.getEString(), "location", null, 1, 1,
				MetadataRepositoryReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetadataRepositoryReference_Nature(), ecorePackage.getEString(), "nature", "p2", 1, 1,
				MetadataRepositoryReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(metadataRepositoryReferenceEClass, this.getAggregation(), "getAggregation", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		addEOperation(metadataRepositoryReferenceEClass, ecorePackage.getEBoolean(), "isBranchEnabled", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		addEOperation(metadataRepositoryReferenceEClass, ecorePackage.getEString(), "getResolvedLocation", 0, 1,
				IS_UNIQUE, IS_ORDERED);

		op = addEOperation(metadataRepositoryReferenceEClass, null, "startRepositoryLoad", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "forceReload", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(metadataRepositoryReferenceEClass, null, "cancelRepositoryLoad", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(metadataRepositoryReferenceEClass, null, "onRepositoryLoad", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(productEClass, Product.class, "Product", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(propertyEClass, Property.class, "Property", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProperty_Key(), ecorePackage.getEString(), "key", null, 1, 1, Property.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProperty_Value(), ecorePackage.getEString(), "value", null, 0, 1, Property.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(statusEClass, Status.class, "Status", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStatus_Code(), this.getStatusCode(), "code", null, 1, 1, Status.class, !IS_TRANSIENT,
				!IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getStatus_Message(), theXMLTypePackage.getString(), "message", null, 0, 1, Status.class,
				!IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		initEClass(statusProviderEClass, StatusProvider.class, "StatusProvider", IS_ABSTRACT, IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getStatusProvider_Status(), this.getStatus(), null, "status", null, 1, 1, StatusProvider.class,
				IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(validationSetEClass, ValidationSet.class, "ValidationSet", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValidationSet_Abstract(), ecorePackage.getEBoolean(), "abstract", "false", 0, 1,
				ValidationSet.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidationSet_Extension(), ecorePackage.getEBoolean(), "extension", "false", 0, 1,
				ValidationSet.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);
		initEAttribute(getValidationSet_Label(), ecorePackage.getEString(), "label", null, 1, 1, ValidationSet.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidationSet_Contributions(), this.getContribution(), null, "contributions", null, 0, -1,
				ValidationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		getValidationSet_Contributions().getEKeys().add(this.getContribution_Label());
		initEReference(getValidationSet_ValidationRepositories(), this.getMetadataRepositoryReference(), null,
				"validationRepositories", null, 0, -1, ValidationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValidationSet_Extends(), this.getValidationSet(), null, "extends", null, 0, -1,
				ValidationSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(validationSetEClass, this.getMetadataRepositoryReference(), "getAllValidationRepositories", 0, -1,
				IS_UNIQUE, IS_ORDERED);

		addEOperation(validationSetEClass, this.getContribution(), "getAllContributions", 0, -1, IS_UNIQUE, IS_ORDERED);

		addEOperation(validationSetEClass, this.getContribution(), "getDeclaredContributions", 0, -1, IS_UNIQUE,
				IS_ORDERED);

		addEOperation(validationSetEClass, this.getMetadataRepositoryReference(), "getDeclaredValidationRepositories",
				0, -1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(validationSetEClass, ecorePackage.getEBoolean(), "isExtensionOf", 0, 1, IS_UNIQUE,
				IS_ORDERED);
		addEParameter(op, this.getValidationSet(), "validationSet", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(validConfigurationsRuleEClass, ValidConfigurationsRule.class, "ValidConfigurationsRule",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getValidConfigurationsRule_ValidConfigurations(), this.getConfiguration(), null,
				"validConfigurations", null, 0, -1, ValidConfigurationsRule.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(aggregationTypeEEnum, AggregationType.class, "AggregationType");
		addEEnumLiteral(aggregationTypeEEnum, AggregationType.STABLE);
		addEEnumLiteral(aggregationTypeEEnum, AggregationType.INTEGRATION);
		addEEnumLiteral(aggregationTypeEEnum, AggregationType.NIGHTLY);
		addEEnumLiteral(aggregationTypeEEnum, AggregationType.MAINTENANCE);
		addEEnumLiteral(aggregationTypeEEnum, AggregationType.CONTINUOUS);
		addEEnumLiteral(aggregationTypeEEnum, AggregationType.RELEASE);

		initEEnum(architectureEEnum, Architecture.class, "Architecture");
		addEEnumLiteral(architectureEEnum, Architecture.X86);
		addEEnumLiteral(architectureEEnum, Architecture.PPC);
		addEEnumLiteral(architectureEEnum, Architecture.X86_64);
		addEEnumLiteral(architectureEEnum, Architecture.IA64);
		addEEnumLiteral(architectureEEnum, Architecture.IA64_32);
		addEEnumLiteral(architectureEEnum, Architecture.SPARC);
		addEEnumLiteral(architectureEEnum, Architecture.PPC64);
		addEEnumLiteral(architectureEEnum, Architecture.S390);
		addEEnumLiteral(architectureEEnum, Architecture.S390X);
		addEEnumLiteral(architectureEEnum, Architecture.SPARCV9);
		addEEnumLiteral(architectureEEnum, Architecture.PPC64LE);

		initEEnum(availableFromEEnum, AvailableFrom.class, "AvailableFrom");
		addEEnumLiteral(availableFromEEnum, AvailableFrom.REPOSITORY);
		addEEnumLiteral(availableFromEEnum, AvailableFrom.CONTRIBUTION);
		addEEnumLiteral(availableFromEEnum, AvailableFrom.VALIDATION_SET);
		addEEnumLiteral(availableFromEEnum, AvailableFrom.AGGREGATION);

		initEEnum(installableUnitTypeEEnum, InstallableUnitType.class, "InstallableUnitType");
		addEEnumLiteral(installableUnitTypeEEnum, InstallableUnitType.BUNDLE);
		addEEnumLiteral(installableUnitTypeEEnum, InstallableUnitType.FEATURE);
		addEEnumLiteral(installableUnitTypeEEnum, InstallableUnitType.PRODUCT);
		addEEnumLiteral(installableUnitTypeEEnum, InstallableUnitType.CATEGORY);
		addEEnumLiteral(installableUnitTypeEEnum, InstallableUnitType.FRAGMENT);
		addEEnumLiteral(installableUnitTypeEEnum, InstallableUnitType.OTHER);

		initEEnum(operatingSystemEEnum, OperatingSystem.class, "OperatingSystem");
		addEEnumLiteral(operatingSystemEEnum, OperatingSystem.WIN32);
		addEEnumLiteral(operatingSystemEEnum, OperatingSystem.LINUX);
		addEEnumLiteral(operatingSystemEEnum, OperatingSystem.MAC_OSX);
		addEEnumLiteral(operatingSystemEEnum, OperatingSystem.AIX);
		addEEnumLiteral(operatingSystemEEnum, OperatingSystem.HPUX);
		addEEnumLiteral(operatingSystemEEnum, OperatingSystem.SOLARIS);
		addEEnumLiteral(operatingSystemEEnum, OperatingSystem.QNX);

		initEEnum(packedStrategyEEnum, PackedStrategy.class, "PackedStrategy");
		addEEnumLiteral(packedStrategyEEnum, PackedStrategy.COPY);
		addEEnumLiteral(packedStrategyEEnum, PackedStrategy.VERIFY);
		addEEnumLiteral(packedStrategyEEnum, PackedStrategy.UNPACK_AS_SIBLING);
		addEEnumLiteral(packedStrategyEEnum, PackedStrategy.UNPACK);
		addEEnumLiteral(packedStrategyEEnum, PackedStrategy.SKIP);

		initEEnum(statusCodeEEnum, StatusCode.class, "StatusCode");
		addEEnumLiteral(statusCodeEEnum, StatusCode.OK);
		addEEnumLiteral(statusCodeEEnum, StatusCode.BROKEN);
		addEEnumLiteral(statusCodeEEnum, StatusCode.WAITING);

		initEEnum(versionMatchEEnum, VersionMatch.class, "VersionMatch");
		addEEnumLiteral(versionMatchEEnum, VersionMatch.BELOW);
		addEEnumLiteral(versionMatchEEnum, VersionMatch.MATCHES);
		addEEnumLiteral(versionMatchEEnum, VersionMatch.ABOVE);

		initEEnum(windowSystemEEnum, WindowSystem.class, "WindowSystem");
		addEEnumLiteral(windowSystemEEnum, WindowSystem.WIN32);
		addEEnumLiteral(windowSystemEEnum, WindowSystem.GTK);
		addEEnumLiteral(windowSystemEEnum, WindowSystem.CARBON);
		addEEnumLiteral(windowSystemEEnum, WindowSystem.COCOA);
		addEEnumLiteral(windowSystemEEnum, WindowSystem.MOTIF);
		addEEnumLiteral(windowSystemEEnum, WindowSystem.PHOTON);

		initEEnum(versionFormatEEnum, VersionFormat.class, "VersionFormat");
		addEEnumLiteral(versionFormatEEnum, VersionFormat.NORMAL);
		addEEnumLiteral(versionFormatEEnum, VersionFormat.STRICT_MAVEN);
		addEEnumLiteral(versionFormatEEnum, VersionFormat.MAVEN_RELEASE);

		// Create resource
		createResource(eNS_URI);
	}

} // AggregatorPackageImpl
