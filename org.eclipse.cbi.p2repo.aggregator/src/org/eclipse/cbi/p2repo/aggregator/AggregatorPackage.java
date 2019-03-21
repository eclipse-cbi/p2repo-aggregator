/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.aggregator;

import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorFactory
 * @model kind="package"
 * @generated
 */
public interface AggregatorPackage extends EPackage {
	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl <em>Aggregation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getAggregation()
		 * @generated
		 */
		EClass AGGREGATION = eINSTANCE.getAggregation();

		/**
		 * The meta object literal for the '<em><b>Validation Sets</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATION__VALIDATION_SETS = eINSTANCE.getAggregation_ValidationSets();

		/**
		 * The meta object literal for the '<em><b>Configurations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATION__CONFIGURATIONS = eINSTANCE.getAggregation_Configurations();

		/**
		 * The meta object literal for the '<em><b>Custom Categories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATION__CUSTOM_CATEGORIES = eINSTANCE.getAggregation_CustomCategories();

		/**
		 * The meta object literal for the '<em><b>Contacts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATION__CONTACTS = eINSTANCE.getAggregation_Contacts();

		/**
		 * The meta object literal for the '<em><b>Buildmaster</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATION__BUILDMASTER = eINSTANCE.getAggregation_Buildmaster();

		/**
		 * The meta object literal for the '<em><b>Buildmaster Backup</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATION__BUILDMASTER_BACKUP = eINSTANCE.getAggregation_BuildmasterBackup();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATION__LABEL = eINSTANCE.getAggregation_Label();

		/**
		 * The meta object literal for the '<em><b>Build Root</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATION__BUILD_ROOT = eINSTANCE.getAggregation_BuildRoot();

		/**
		 * The meta object literal for the '<em><b>Packed Strategy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATION__PACKED_STRATEGY = eINSTANCE.getAggregation_PackedStrategy();

		/**
		 * The meta object literal for the '<em><b>Sendmail</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATION__SENDMAIL = eINSTANCE.getAggregation_Sendmail();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATION__TYPE = eINSTANCE.getAggregation_Type();

		/**
		 * The meta object literal for the '<em><b>Maven Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATION__MAVEN_RESULT = eINSTANCE.getAggregation_MavenResult();

		/**
		 * The meta object literal for the '<em><b>Strict Maven Versions</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATION__STRICT_MAVEN_VERSIONS = eINSTANCE.getAggregation_StrictMavenVersions();

		/**
		 * The meta object literal for the '<em><b>Version Format</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATION__VERSION_FORMAT = eINSTANCE.getAggregation_VersionFormat();

		/**
		 * The meta object literal for the '<em><b>Maven Build Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATION__MAVEN_BUILD_NUMBER = eINSTANCE.getAggregation_MavenBuildNumber();

		/**
		 * The meta object literal for the '<em><b>Maven Mappings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATION__MAVEN_MAPPINGS = eINSTANCE.getAggregation_MavenMappings();

		/**
		 * The meta object literal for the '<em><b>Allow Legacy Sites</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATION__ALLOW_LEGACY_SITES = eINSTANCE.getAggregation_AllowLegacySites();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ValidationSetImpl <em>Validation Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.ValidationSetImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getValidationSet()
		 * @generated
		 */
		EClass VALIDATION_SET = eINSTANCE.getValidationSet();

		/**
		 * The meta object literal for the '<em><b>Abstract</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_SET__ABSTRACT = eINSTANCE.getValidationSet_Abstract();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_SET__EXTENSION = eINSTANCE.getValidationSet_Extension();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_SET__LABEL = eINSTANCE.getValidationSet_Label();

		/**
		 * The meta object literal for the '<em><b>Contributions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_SET__CONTRIBUTIONS = eINSTANCE.getValidationSet_Contributions();

		/**
		 * The meta object literal for the '<em><b>Validation Repositories</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_SET__VALIDATION_REPOSITORIES = eINSTANCE.getValidationSet_ValidationRepositories();

		/**
		 * The meta object literal for the '<em><b>Extends</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_SET__EXTENDS = eINSTANCE.getValidationSet_Extends();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.MappedRepositoryImpl <em>Mapped Repository</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.MappedRepositoryImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getMappedRepository()
		 * @generated
		 */
		EClass MAPPED_REPOSITORY = eINSTANCE.getMappedRepository();

		/**
		 * The meta object literal for the '<em><b>Products</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MAPPED_REPOSITORY__PRODUCTS = eINSTANCE.getMappedRepository_Products();

		/**
		 * The meta object literal for the '<em><b>Bundles</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MAPPED_REPOSITORY__BUNDLES = eINSTANCE.getMappedRepository_Bundles();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MAPPED_REPOSITORY__FEATURES = eINSTANCE.getMappedRepository_Features();

		/**
		 * The meta object literal for the '<em><b>Mirror Artifacts</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPED_REPOSITORY__MIRROR_ARTIFACTS = eINSTANCE.getMappedRepository_MirrorArtifacts();

		/**
		 * The meta object literal for the '<em><b>Category Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAPPED_REPOSITORY__CATEGORY_PREFIX = eINSTANCE.getMappedRepository_CategoryPrefix();

		/**
		 * The meta object literal for the '<em><b>Map Rules</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MAPPED_REPOSITORY__MAP_RULES = eINSTANCE.getMappedRepository_MapRules();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MAPPED_REPOSITORY__CATEGORIES = eINSTANCE.getMappedRepository_Categories();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ConfigurationImpl <em>Configuration</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.ConfigurationImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getConfiguration()
		 * @generated
		 */
		EClass CONFIGURATION = eINSTANCE.getConfiguration();

		/**
		 * The meta object literal for the '<em><b>Operating System</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__OPERATING_SYSTEM = eINSTANCE.getConfiguration_OperatingSystem();

		/**
		 * The meta object literal for the '<em><b>Window System</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__WINDOW_SYSTEM = eINSTANCE.getConfiguration_WindowSystem();

		/**
		 * The meta object literal for the '<em><b>Architecture</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONFIGURATION__ARCHITECTURE = eINSTANCE.getConfiguration_Architecture();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ContributionImpl <em>Contribution</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.ContributionImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getContribution()
		 * @generated
		 */
		EClass CONTRIBUTION = eINSTANCE.getContribution();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CONTRIBUTION__LABEL = eINSTANCE.getContribution_Label();

		/**
		 * The meta object literal for the '<em><b>Repositories</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference CONTRIBUTION__REPOSITORIES = eINSTANCE.getContribution_Repositories();

		/**
		 * The meta object literal for the '<em><b>Contacts</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTRIBUTION__CONTACTS = eINSTANCE.getContribution_Contacts();

		/**
		 * The meta object literal for the '<em><b>Maven Mappings</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference CONTRIBUTION__MAVEN_MAPPINGS = eINSTANCE.getContribution_MavenMappings();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ContactImpl <em>Contact</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.ContactImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getContact()
		 * @generated
		 */
		EClass CONTACT = eINSTANCE.getContact();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT__NAME = eINSTANCE.getContact_Name();

		/**
		 * The meta object literal for the '<em><b>Email</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CONTACT__EMAIL = eINSTANCE.getContact_Email();

		/**
		 * The meta object literal for the '<em><b>Aggregation</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTACT__AGGREGATION = eINSTANCE.getContact_Aggregation();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.FeatureImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Categories</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__CATEGORIES = eINSTANCE.getFeature_Categories();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.BundleImpl <em>Bundle</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.BundleImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getBundle()
		 * @generated
		 */
		EClass BUNDLE = eINSTANCE.getBundle();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.MappedUnitImpl <em>Mapped Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.MappedUnitImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getMappedUnit()
		 * @generated
		 */
		EClass MAPPED_UNIT = eINSTANCE.getMappedUnit();

		/**
		 * The meta object literal for the '<em><b>Valid Configurations</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference MAPPED_UNIT__VALID_CONFIGURATIONS = eINSTANCE.getMappedUnit_ValidConfigurations();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ProductImpl <em>Product</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.ProductImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getProduct()
		 * @generated
		 */
		EClass PRODUCT = eINSTANCE.getProduct();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.PropertyImpl <em>Property</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.PropertyImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getProperty()
		 * @generated
		 */
		EClass PROPERTY = eINSTANCE.getProperty();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__KEY = eINSTANCE.getProperty_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute PROPERTY__VALUE = eINSTANCE.getProperty_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.CategoryImpl <em>Category</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.CategoryImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getCategory()
		 * @generated
		 */
		EClass CATEGORY = eINSTANCE.getCategory();

		/**
		 * The meta object literal for the '<em><b>Label Override</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CATEGORY__LABEL_OVERRIDE = eINSTANCE.getCategory_LabelOverride();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.CustomCategoryImpl <em>Custom Category</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.CustomCategoryImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getCustomCategory()
		 * @generated
		 */
		EClass CUSTOM_CATEGORY = eINSTANCE.getCustomCategory();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_CATEGORY__IDENTIFIER = eINSTANCE.getCustomCategory_Identifier();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_CATEGORY__LABEL = eINSTANCE.getCustomCategory_Label();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CUSTOM_CATEGORY__DESCRIPTION = eINSTANCE.getCustomCategory_Description();

		/**
		 * The meta object literal for the '<em><b>Features</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOM_CATEGORY__FEATURES = eINSTANCE.getCustomCategory_Features();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider <em>Enabled Status Provider</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getEnabledStatusProvider()
		 * @generated
		 */
		EClass ENABLED_STATUS_PROVIDER = eINSTANCE.getEnabledStatusProvider();

		/**
		 * The meta object literal for the '<em><b>Branch Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENABLED_STATUS_PROVIDER__BRANCH_ENABLED = eINSTANCE.getEnabledStatusProvider_BranchEnabled();

		/**
		 * The meta object literal for the '<em><b>Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute ENABLED_STATUS_PROVIDER__ENABLED = eINSTANCE.getEnabledStatusProvider_Enabled();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.MapRuleImpl <em>Map Rule</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.MapRuleImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getMapRule()
		 * @generated
		 */
		EClass MAP_RULE = eINSTANCE.getMapRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.InstallableUnitRequestImpl <em>Installable Unit Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.InstallableUnitRequestImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getInstallableUnitRequest()
		 * @generated
		 */
		EClass INSTALLABLE_UNIT_REQUEST = eINSTANCE.getInstallableUnitRequest();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTALLABLE_UNIT_REQUEST__NAME = eINSTANCE.getInstallableUnitRequest_Name();

		/**
		 * The meta object literal for the '<em><b>Version Range</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTALLABLE_UNIT_REQUEST__VERSION_RANGE = eINSTANCE.getInstallableUnitRequest_VersionRange();

		/**
		 * The meta object literal for the '<em><b>Available Versions Header</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER = eINSTANCE
				.getInstallableUnitRequest_AvailableVersionsHeader();

		/**
		 * The meta object literal for the '<em><b>Available Versions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS = eINSTANCE
				.getInstallableUnitRequest_AvailableVersions();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ExclusionRuleImpl <em>Exclusion Rule</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.ExclusionRuleImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getExclusionRule()
		 * @generated
		 */
		EClass EXCLUSION_RULE = eINSTANCE.getExclusionRule();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ValidConfigurationsRuleImpl <em>Valid Configurations Rule</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.ValidConfigurationsRuleImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getValidConfigurationsRule()
		 * @generated
		 */
		EClass VALID_CONFIGURATIONS_RULE = eINSTANCE.getValidConfigurationsRule();

		/**
		 * The meta object literal for the '<em><b>Valid Configurations</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 *
		 * @generated
		 */
		EReference VALID_CONFIGURATIONS_RULE__VALID_CONFIGURATIONS = eINSTANCE
				.getValidConfigurationsRule_ValidConfigurations();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl <em>Metadata Repository Reference</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getMetadataRepositoryReference()
		 * @generated
		 */
		EClass METADATA_REPOSITORY_REFERENCE = eINSTANCE.getMetadataRepositoryReference();

		/**
		 * The meta object literal for the '<em><b>Metadata Repository</b></em>' reference feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference METADATA_REPOSITORY_REFERENCE__METADATA_REPOSITORY = eINSTANCE
				.getMetadataRepositoryReference_MetadataRepository();

		/**
		 * The meta object literal for the '<em><b>Location</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute METADATA_REPOSITORY_REFERENCE__LOCATION = eINSTANCE.getMetadataRepositoryReference_Location();

		/**
		 * The meta object literal for the '<em><b>Nature</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute METADATA_REPOSITORY_REFERENCE__NATURE = eINSTANCE.getMetadataRepositoryReference_Nature();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.StatusProvider <em>Status Provider</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.StatusProvider
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getStatusProvider()
		 * @generated
		 */
		EClass STATUS_PROVIDER = eINSTANCE.getStatusProvider();

		/**
		 * The meta object literal for the '<em><b>Status</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference STATUS_PROVIDER__STATUS = eINSTANCE.getStatusProvider_Status();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.InfosProviderImpl <em>Infos Provider</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.InfosProviderImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getInfosProvider()
		 * @generated
		 */
		EClass INFOS_PROVIDER = eINSTANCE.getInfosProvider();

		/**
		 * The meta object literal for the '<em><b>Errors</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute INFOS_PROVIDER__ERRORS = eINSTANCE.getInfosProvider_Errors();

		/**
		 * The meta object literal for the '<em><b>Warnings</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INFOS_PROVIDER__WARNINGS = eINSTANCE.getInfosProvider_Warnings();

		/**
		 * The meta object literal for the '<em><b>Infos</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute INFOS_PROVIDER__INFOS = eINSTANCE.getInfosProvider_Infos();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionsHeaderImpl <em>Available Versions Header</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionsHeaderImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getAvailableVersionsHeader()
		 * @generated
		 */
		EClass AVAILABLE_VERSIONS_HEADER = eINSTANCE.getAvailableVersionsHeader();

		/**
		 * The meta object literal for the '<em><b>Available Versions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AVAILABLE_VERSIONS_HEADER__AVAILABLE_VERSIONS = eINSTANCE
				.getAvailableVersionsHeader_AvailableVersions();

		/**
		 * The meta object literal for the '<em><b>Installable Unit Request</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AVAILABLE_VERSIONS_HEADER__INSTALLABLE_UNIT_REQUEST = eINSTANCE
				.getAvailableVersionsHeader_InstallableUnitRequest();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionImpl <em>Available Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getAvailableVersion()
		 * @generated
		 */
		EClass AVAILABLE_VERSION = eINSTANCE.getAvailableVersion();

		/**
		 * The meta object literal for the '<em><b>Version Match</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AVAILABLE_VERSION__VERSION_MATCH = eINSTANCE.getAvailableVersion_VersionMatch();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AVAILABLE_VERSION__VERSION = eINSTANCE.getAvailableVersion_Version();

		/**
		 * The meta object literal for the '<em><b>Filter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AVAILABLE_VERSION__FILTER = eINSTANCE.getAvailableVersion_Filter();

		/**
		 * The meta object literal for the '<em><b>Available From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AVAILABLE_VERSION__AVAILABLE_FROM = eINSTANCE.getAvailableVersion_AvailableFrom();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.AggregationType <em>Aggregation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.AggregationType
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getAggregationType()
		 * @generated
		 */
		EEnum AGGREGATION_TYPE = eINSTANCE.getAggregationType();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.LabelProvider <em>Label Provider</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.LabelProvider
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getLabelProvider()
		 * @generated
		 */
		EClass LABEL_PROVIDER = eINSTANCE.getLabelProvider();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute LABEL_PROVIDER__LABEL = eINSTANCE.getLabelProvider_Label();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.DescriptionProviderImpl <em>Description Provider</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.DescriptionProviderImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getDescriptionProvider()
		 * @generated
		 */
		EClass DESCRIPTION_PROVIDER = eINSTANCE.getDescriptionProvider();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute DESCRIPTION_PROVIDER__DESCRIPTION = eINSTANCE.getDescriptionProvider_Description();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.IdentificationProvider <em>Identification Provider</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.IdentificationProvider
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getIdentificationProvider()
		 * @generated
		 */
		EClass IDENTIFICATION_PROVIDER = eINSTANCE.getIdentificationProvider();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl <em>Maven Mapping</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getMavenMapping()
		 * @generated
		 */
		EClass MAVEN_MAPPING = eINSTANCE.getMavenMapping();

		/**
		 * The meta object literal for the '<em><b>Name Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVEN_MAPPING__NAME_PATTERN = eINSTANCE.getMavenMapping_NamePattern();

		/**
		 * The meta object literal for the '<em><b>Group Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MAVEN_MAPPING__GROUP_ID = eINSTANCE.getMavenMapping_GroupId();

		/**
		 * The meta object literal for the '<em><b>Artifact Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MAVEN_MAPPING__ARTIFACT_ID = eINSTANCE.getMavenMapping_ArtifactId();

		/**
		 * The meta object literal for the '<em><b>Version Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVEN_MAPPING__VERSION_PATTERN = eINSTANCE.getMavenMapping_VersionPattern();

		/**
		 * The meta object literal for the '<em><b>Version Template</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVEN_MAPPING__VERSION_TEMPLATE = eINSTANCE.getMavenMapping_VersionTemplate();

		/**
		 * The meta object literal for the '<em><b>Snapshot</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVEN_MAPPING__SNAPSHOT = eINSTANCE.getMavenMapping_Snapshot();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenItemImpl <em>Maven Item</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.MavenItemImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getMavenItem()
		 * @generated
		 */
		EClass MAVEN_ITEM = eINSTANCE.getMavenItem();

		/**
		 * The meta object literal for the '<em><b>Group Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MAVEN_ITEM__GROUP_ID = eINSTANCE.getMavenItem_GroupId();

		/**
		 * The meta object literal for the '<em><b>Artifact Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MAVEN_ITEM__ARTIFACT_ID = eINSTANCE.getMavenItem_ArtifactId();

		/**
		 * The meta object literal for the '<em><b>Mapped Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVEN_ITEM__MAPPED_VERSION = eINSTANCE.getMavenItem_MappedVersion();

		/**
		 * The meta object literal for the '<em><b>Classifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MAVEN_ITEM__CLASSIFIER = eINSTANCE.getMavenItem_Classifier();

		/**
		 * The meta object literal for the '<em><b>Maven Mapping</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAVEN_ITEM__MAVEN_MAPPING = eINSTANCE.getMavenItem_MavenMapping();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.ChildrenProvider <em>Children Provider</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.ChildrenProvider
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getChildrenProvider()
		 * @generated
		 */
		EClass CHILDREN_PROVIDER = eINSTANCE.getChildrenProvider();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHILDREN_PROVIDER__CHILDREN = eINSTANCE.getChildrenProvider_Children();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.StatusImpl <em>Status</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.StatusImpl
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getStatus()
		 * @generated
		 */
		EClass STATUS = eINSTANCE.getStatus();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__CODE = eINSTANCE.getStatus_Code();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute STATUS__MESSAGE = eINSTANCE.getStatus_Message();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.OperatingSystem <em>Operating System</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.OperatingSystem
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getOperatingSystem()
		 * @generated
		 */
		EEnum OPERATING_SYSTEM = eINSTANCE.getOperatingSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.WindowSystem <em>Window System</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.WindowSystem
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getWindowSystem()
		 * @generated
		 */
		EEnum WINDOW_SYSTEM = eINSTANCE.getWindowSystem();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.VersionFormat <em>Version Format</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.VersionFormat
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getVersionFormat()
		 * @generated
		 */
		EEnum VERSION_FORMAT = eINSTANCE.getVersionFormat();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.Architecture <em>Architecture</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.Architecture
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getArchitecture()
		 * @generated
		 */
		EEnum ARCHITECTURE = eINSTANCE.getArchitecture();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.AvailableFrom <em>Available From</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.AvailableFrom
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getAvailableFrom()
		 * @generated
		 */
		EEnum AVAILABLE_FROM = eINSTANCE.getAvailableFrom();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.PackedStrategy <em>Packed Strategy</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.PackedStrategy
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getPackedStrategy()
		 * @generated
		 */
		EEnum PACKED_STRATEGY = eINSTANCE.getPackedStrategy();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitType <em>Installable Unit Type</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.InstallableUnitType
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getInstallableUnitType()
		 * @generated
		 */
		EEnum INSTALLABLE_UNIT_TYPE = eINSTANCE.getInstallableUnitType();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.StatusCode <em>Status Code</em>}' enum.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.StatusCode
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getStatusCode()
		 * @generated
		 */
		EEnum STATUS_CODE = eINSTANCE.getStatusCode();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.aggregator.VersionMatch <em>Version Match</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.aggregator.VersionMatch
		 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getVersionMatch()
		 * @generated
		 */
		EEnum VERSION_MATCH = eINSTANCE.getVersionMatch();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "aggregator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/cbi/p2repo/2011/aggregator/1.1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "aggregator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	AggregatorPackage eINSTANCE = org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.DescriptionProviderImpl <em>Description Provider</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.DescriptionProviderImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getDescriptionProvider()
	 * @generated
	 */
	int DESCRIPTION_PROVIDER = 11;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_PROVIDER__DESCRIPTION = 0;

	/**
	 * The number of structural features of the '<em>Description Provider</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DESCRIPTION_PROVIDER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl <em>Aggregation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getAggregation()
	 * @generated
	 */
	int AGGREGATION = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__DESCRIPTION = DESCRIPTION_PROVIDER__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__STATUS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__ERRORS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__WARNINGS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__INFOS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Validation Sets</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__VALIDATION_SETS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Configurations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__CONFIGURATIONS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Custom Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__CUSTOM_CATEGORIES = DESCRIPTION_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Contacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__CONTACTS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Buildmaster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__BUILDMASTER = DESCRIPTION_PROVIDER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Buildmaster Backup</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__BUILDMASTER_BACKUP = DESCRIPTION_PROVIDER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__LABEL = DESCRIPTION_PROVIDER_FEATURE_COUNT + 10;

	/**
	 * The feature id for the '<em><b>Build Root</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__BUILD_ROOT = DESCRIPTION_PROVIDER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Packed Strategy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__PACKED_STRATEGY = DESCRIPTION_PROVIDER_FEATURE_COUNT + 12;

	/**
	 * The feature id for the '<em><b>Sendmail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__SENDMAIL = DESCRIPTION_PROVIDER_FEATURE_COUNT + 13;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__TYPE = DESCRIPTION_PROVIDER_FEATURE_COUNT + 14;

	/**
	 * The feature id for the '<em><b>Maven Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__MAVEN_RESULT = DESCRIPTION_PROVIDER_FEATURE_COUNT + 15;

	/**
	 * The feature id for the '<em><b>Strict Maven Versions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__STRICT_MAVEN_VERSIONS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 16;

	/**
	 * The feature id for the '<em><b>Version Format</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__VERSION_FORMAT = DESCRIPTION_PROVIDER_FEATURE_COUNT + 17;

	/**
	 * The feature id for the '<em><b>Maven Build Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__MAVEN_BUILD_NUMBER = DESCRIPTION_PROVIDER_FEATURE_COUNT + 18;

	/**
	 * The feature id for the '<em><b>Maven Mappings</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__MAVEN_MAPPINGS = DESCRIPTION_PROVIDER_FEATURE_COUNT + 19;

	/**
	 * The feature id for the '<em><b>Allow Legacy Sites</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION__ALLOW_LEGACY_SITES = DESCRIPTION_PROVIDER_FEATURE_COUNT + 20;

	/**
	 * The number of structural features of the '<em>Aggregation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATION_FEATURE_COUNT = DESCRIPTION_PROVIDER_FEATURE_COUNT + 21;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider <em>Enabled Status Provider</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getEnabledStatusProvider()
	 * @generated
	 */
	int ENABLED_STATUS_PROVIDER = 12;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ValidationSetImpl <em>Validation Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.ValidationSetImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getValidationSet()
	 * @generated
	 */
	int VALIDATION_SET = 28;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl <em>Metadata Repository Reference</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getMetadataRepositoryReference()
	 * @generated
	 */
	int METADATA_REPOSITORY_REFERENCE = 23;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.MappedRepositoryImpl <em>Mapped Repository</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.MappedRepositoryImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getMappedRepository()
	 * @generated
	 */
	int MAPPED_REPOSITORY = 18;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ConfigurationImpl <em>Configuration</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.ConfigurationImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getConfiguration()
	 * @generated
	 */
	int CONFIGURATION = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ContributionImpl <em>Contribution</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.ContributionImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getContribution()
	 * @generated
	 */
	int CONTRIBUTION = 8;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ContactImpl <em>Contact</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.ContactImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getContact()
	 * @generated
	 */
	int CONTACT = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.MappedUnitImpl <em>Mapped Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.MappedUnitImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getMappedUnit()
	 * @generated
	 */
	int MAPPED_UNIT = 19;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.StatusProvider <em>Status Provider</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.StatusProvider
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getStatusProvider()
	 * @generated
	 */
	int STATUS_PROVIDER = 27;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.InstallableUnitRequestImpl <em>Installable Unit Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.InstallableUnitRequestImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getInstallableUnitRequest()
	 * @generated
	 */
	int INSTALLABLE_UNIT_REQUEST = 16;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.FeatureImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 9;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.BundleImpl <em>Bundle</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.BundleImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getBundle()
	 * @generated
	 */
	int BUNDLE = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ProductImpl <em>Product</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.ProductImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getProduct()
	 * @generated
	 */
	int PRODUCT = 24;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.PropertyImpl <em>Property</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.PropertyImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getProperty()
	 * @generated
	 */
	int PROPERTY = 25;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.CategoryImpl <em>Category</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.CategoryImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getCategory()
	 * @generated
	 */
	int CATEGORY = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.CustomCategoryImpl <em>Custom Category</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.CustomCategoryImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getCustomCategory()
	 * @generated
	 */
	int CUSTOM_CATEGORY = 10;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.MapRuleImpl <em>Map Rule</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.MapRuleImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getMapRule()
	 * @generated
	 */
	int MAP_RULE = 20;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ExclusionRuleImpl <em>Exclusion Rule</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.ExclusionRuleImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getExclusionRule()
	 * @generated
	 */
	int EXCLUSION_RULE = 13;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.ValidConfigurationsRuleImpl <em>Valid Configurations Rule</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.ValidConfigurationsRuleImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getValidConfigurationsRule()
	 * @generated
	 */
	int VALID_CONFIGURATIONS_RULE = 29;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.LabelProvider <em>Label Provider</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.LabelProvider
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getLabelProvider()
	 * @generated
	 */
	int LABEL_PROVIDER = 17;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.IdentificationProvider <em>Identification Provider</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.IdentificationProvider
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getIdentificationProvider()
	 * @generated
	 */
	int IDENTIFICATION_PROVIDER = 14;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl <em>Maven Mapping</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getMavenMapping()
	 * @generated
	 */
	int MAVEN_MAPPING = 22;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenItemImpl <em>Maven Item</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.MavenItemImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getMavenItem()
	 * @generated
	 */
	int MAVEN_ITEM = 21;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.ChildrenProvider <em>Children Provider</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.ChildrenProvider
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getChildrenProvider()
	 * @generated
	 */
	int CHILDREN_PROVIDER = 5;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.StatusImpl <em>Status</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.StatusImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getStatus()
	 * @generated
	 */
	int STATUS = 26;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.InfosProviderImpl <em>Infos Provider</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.InfosProviderImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getInfosProvider()
	 * @generated
	 */
	int INFOS_PROVIDER = 15;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionsHeaderImpl <em>Available Versions Header</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionsHeaderImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getAvailableVersionsHeader()
	 * @generated
	 */
	int AVAILABLE_VERSIONS_HEADER = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionImpl <em>Available Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionImpl
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getAvailableVersion()
	 * @generated
	 */
	int AVAILABLE_VERSION = 2;

	/**
	 * The feature id for the '<em><b>Available Versions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABLE_VERSIONS_HEADER__AVAILABLE_VERSIONS = 0;

	/**
	 * The feature id for the '<em><b>Installable Unit Request</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABLE_VERSIONS_HEADER__INSTALLABLE_UNIT_REQUEST = 1;

	/**
	 * The number of structural features of the '<em>Available Versions Header</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABLE_VERSIONS_HEADER_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Version Match</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABLE_VERSION__VERSION_MATCH = P2Package.COMPARABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABLE_VERSION__VERSION = P2Package.COMPARABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABLE_VERSION__FILTER = P2Package.COMPARABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Available From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABLE_VERSION__AVAILABLE_FROM = P2Package.COMPARABLE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Available Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AVAILABLE_VERSION_FEATURE_COUNT = P2Package.COMPARABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_PROVIDER__STATUS = 0;

	/**
	 * The number of structural features of the '<em>Status Provider</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_PROVIDER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_REQUEST__STATUS = STATUS_PROVIDER__STATUS;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_REQUEST__ERRORS = STATUS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_REQUEST__WARNINGS = STATUS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_REQUEST__INFOS = STATUS_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_REQUEST__DESCRIPTION = STATUS_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_REQUEST__NAME = STATUS_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Version Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_REQUEST__VERSION_RANGE = STATUS_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Available Versions Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER = STATUS_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Available Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS = STATUS_PROVIDER_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Installable Unit Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTALLABLE_UNIT_REQUEST_FEATURE_COUNT = STATUS_PROVIDER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_UNIT__STATUS = INSTALLABLE_UNIT_REQUEST__STATUS;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_UNIT__ERRORS = INSTALLABLE_UNIT_REQUEST__ERRORS;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_UNIT__WARNINGS = INSTALLABLE_UNIT_REQUEST__WARNINGS;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_UNIT__INFOS = INSTALLABLE_UNIT_REQUEST__INFOS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_UNIT__DESCRIPTION = INSTALLABLE_UNIT_REQUEST__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_UNIT__NAME = INSTALLABLE_UNIT_REQUEST__NAME;

	/**
	 * The feature id for the '<em><b>Version Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_UNIT__VERSION_RANGE = INSTALLABLE_UNIT_REQUEST__VERSION_RANGE;

	/**
	 * The feature id for the '<em><b>Available Versions Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_UNIT__AVAILABLE_VERSIONS_HEADER = INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER;

	/**
	 * The feature id for the '<em><b>Available Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_UNIT__AVAILABLE_VERSIONS = INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_UNIT__BRANCH_ENABLED = INSTALLABLE_UNIT_REQUEST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_UNIT__ENABLED = INSTALLABLE_UNIT_REQUEST_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Valid Configurations</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_UNIT__VALID_CONFIGURATIONS = INSTALLABLE_UNIT_REQUEST_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Mapped Unit</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 * @ordered
	 */
	int MAPPED_UNIT_FEATURE_COUNT = INSTALLABLE_UNIT_REQUEST_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__STATUS = MAPPED_UNIT__STATUS;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__ERRORS = MAPPED_UNIT__ERRORS;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__WARNINGS = MAPPED_UNIT__WARNINGS;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__INFOS = MAPPED_UNIT__INFOS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__DESCRIPTION = MAPPED_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__NAME = MAPPED_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Version Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__VERSION_RANGE = MAPPED_UNIT__VERSION_RANGE;

	/**
	 * The feature id for the '<em><b>Available Versions Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__AVAILABLE_VERSIONS_HEADER = MAPPED_UNIT__AVAILABLE_VERSIONS_HEADER;

	/**
	 * The feature id for the '<em><b>Available Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__AVAILABLE_VERSIONS = MAPPED_UNIT__AVAILABLE_VERSIONS;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__BRANCH_ENABLED = MAPPED_UNIT__BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__ENABLED = MAPPED_UNIT__ENABLED;

	/**
	 * The feature id for the '<em><b>Valid Configurations</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE__VALID_CONFIGURATIONS = MAPPED_UNIT__VALID_CONFIGURATIONS;

	/**
	 * The number of structural features of the '<em>Bundle</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNDLE_FEATURE_COUNT = MAPPED_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__STATUS = MAPPED_UNIT__STATUS;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__ERRORS = MAPPED_UNIT__ERRORS;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__WARNINGS = MAPPED_UNIT__WARNINGS;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__INFOS = MAPPED_UNIT__INFOS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__DESCRIPTION = MAPPED_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__NAME = MAPPED_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Version Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__VERSION_RANGE = MAPPED_UNIT__VERSION_RANGE;

	/**
	 * The feature id for the '<em><b>Available Versions Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__AVAILABLE_VERSIONS_HEADER = MAPPED_UNIT__AVAILABLE_VERSIONS_HEADER;

	/**
	 * The feature id for the '<em><b>Available Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__AVAILABLE_VERSIONS = MAPPED_UNIT__AVAILABLE_VERSIONS;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__BRANCH_ENABLED = MAPPED_UNIT__BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__ENABLED = MAPPED_UNIT__ENABLED;

	/**
	 * The feature id for the '<em><b>Valid Configurations</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__VALID_CONFIGURATIONS = MAPPED_UNIT__VALID_CONFIGURATIONS;

	/**
	 * The feature id for the '<em><b>Label Override</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY__LABEL_OVERRIDE = MAPPED_UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Category</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CATEGORY_FEATURE_COUNT = MAPPED_UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILDREN_PROVIDER__CHILDREN = 0;

	/**
	 * The number of structural features of the '<em>Children Provider</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILDREN_PROVIDER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_STATUS_PROVIDER__BRANCH_ENABLED = 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_STATUS_PROVIDER__ENABLED = 1;

	/**
	 * The number of structural features of the '<em>Enabled Status Provider</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENABLED_STATUS_PROVIDER_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__BRANCH_ENABLED = ENABLED_STATUS_PROVIDER__BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ENABLED = ENABLED_STATUS_PROVIDER__ENABLED;

	/**
	 * The feature id for the '<em><b>Operating System</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__OPERATING_SYSTEM = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Window System</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__WINDOW_SYSTEM = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Architecture</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION__ARCHITECTURE = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Configuration</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONFIGURATION_FEATURE_COUNT = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Email</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__EMAIL = 1;

	/**
	 * The feature id for the '<em><b>Aggregation</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT__AGGREGATION = 2;

	/**
	 * The number of structural features of the '<em>Contact</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTACT_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__BRANCH_ENABLED = ENABLED_STATUS_PROVIDER__BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__ENABLED = ENABLED_STATUS_PROVIDER__ENABLED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__DESCRIPTION = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__STATUS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__ERRORS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__WARNINGS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__INFOS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__LABEL = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Repositories</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__REPOSITORIES = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Contacts</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__CONTACTS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Maven Mappings</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION__MAVEN_MAPPINGS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Contribution</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 * @ordered
	 */
	int CONTRIBUTION_FEATURE_COUNT = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__STATUS = MAPPED_UNIT__STATUS;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ERRORS = MAPPED_UNIT__ERRORS;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__WARNINGS = MAPPED_UNIT__WARNINGS;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__INFOS = MAPPED_UNIT__INFOS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__DESCRIPTION = MAPPED_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = MAPPED_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Version Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__VERSION_RANGE = MAPPED_UNIT__VERSION_RANGE;

	/**
	 * The feature id for the '<em><b>Available Versions Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__AVAILABLE_VERSIONS_HEADER = MAPPED_UNIT__AVAILABLE_VERSIONS_HEADER;

	/**
	 * The feature id for the '<em><b>Available Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__AVAILABLE_VERSIONS = MAPPED_UNIT__AVAILABLE_VERSIONS;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__BRANCH_ENABLED = MAPPED_UNIT__BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ENABLED = MAPPED_UNIT__ENABLED;

	/**
	 * The feature id for the '<em><b>Valid Configurations</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__VALID_CONFIGURATIONS = MAPPED_UNIT__VALID_CONFIGURATIONS;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CATEGORIES = MAPPED_UNIT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = MAPPED_UNIT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CATEGORY__STATUS = STATUS_PROVIDER__STATUS;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CATEGORY__ERRORS = STATUS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CATEGORY__WARNINGS = STATUS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CATEGORY__INFOS = STATUS_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CATEGORY__IDENTIFIER = STATUS_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CATEGORY__LABEL = STATUS_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CATEGORY__DESCRIPTION = STATUS_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Features</b></em>' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CATEGORY__FEATURES = STATUS_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Custom Category</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOM_CATEGORY_FEATURE_COUNT = STATUS_PROVIDER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_RULE__STATUS = INSTALLABLE_UNIT_REQUEST__STATUS;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_RULE__ERRORS = INSTALLABLE_UNIT_REQUEST__ERRORS;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_RULE__WARNINGS = INSTALLABLE_UNIT_REQUEST__WARNINGS;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_RULE__INFOS = INSTALLABLE_UNIT_REQUEST__INFOS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_RULE__DESCRIPTION = INSTALLABLE_UNIT_REQUEST__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_RULE__NAME = INSTALLABLE_UNIT_REQUEST__NAME;

	/**
	 * The feature id for the '<em><b>Version Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_RULE__VERSION_RANGE = INSTALLABLE_UNIT_REQUEST__VERSION_RANGE;

	/**
	 * The feature id for the '<em><b>Available Versions Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_RULE__AVAILABLE_VERSIONS_HEADER = INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER;

	/**
	 * The feature id for the '<em><b>Available Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_RULE__AVAILABLE_VERSIONS = INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_RULE__BRANCH_ENABLED = INSTALLABLE_UNIT_REQUEST_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_RULE__ENABLED = INSTALLABLE_UNIT_REQUEST_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Map Rule</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAP_RULE_FEATURE_COUNT = INSTALLABLE_UNIT_REQUEST_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_RULE__STATUS = MAP_RULE__STATUS;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_RULE__ERRORS = MAP_RULE__ERRORS;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_RULE__WARNINGS = MAP_RULE__WARNINGS;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_RULE__INFOS = MAP_RULE__INFOS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_RULE__DESCRIPTION = MAP_RULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_RULE__NAME = MAP_RULE__NAME;

	/**
	 * The feature id for the '<em><b>Version Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_RULE__VERSION_RANGE = MAP_RULE__VERSION_RANGE;

	/**
	 * The feature id for the '<em><b>Available Versions Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_RULE__AVAILABLE_VERSIONS_HEADER = MAP_RULE__AVAILABLE_VERSIONS_HEADER;

	/**
	 * The feature id for the '<em><b>Available Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_RULE__AVAILABLE_VERSIONS = MAP_RULE__AVAILABLE_VERSIONS;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_RULE__BRANCH_ENABLED = MAP_RULE__BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_RULE__ENABLED = MAP_RULE__ENABLED;

	/**
	 * The number of structural features of the '<em>Exclusion Rule</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXCLUSION_RULE_FEATURE_COUNT = MAP_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Identification Provider</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFICATION_PROVIDER_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFOS_PROVIDER__ERRORS = 0;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFOS_PROVIDER__WARNINGS = 1;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFOS_PROVIDER__INFOS = 2;

	/**
	 * The number of structural features of the '<em>Infos Provider</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFOS_PROVIDER_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_PROVIDER__LABEL = 0;

	/**
	 * The number of structural features of the '<em>Label Provider</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_PROVIDER_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY_REFERENCE__BRANCH_ENABLED = ENABLED_STATUS_PROVIDER__BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY_REFERENCE__ENABLED = ENABLED_STATUS_PROVIDER__ENABLED;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY_REFERENCE__STATUS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY_REFERENCE__ERRORS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY_REFERENCE__WARNINGS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY_REFERENCE__INFOS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Metadata Repository</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY_REFERENCE__METADATA_REPOSITORY = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY_REFERENCE__LOCATION = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Nature</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY_REFERENCE__NATURE = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Metadata Repository Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METADATA_REPOSITORY_REFERENCE_FEATURE_COUNT = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__BRANCH_ENABLED = METADATA_REPOSITORY_REFERENCE__BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__ENABLED = METADATA_REPOSITORY_REFERENCE__ENABLED;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__STATUS = METADATA_REPOSITORY_REFERENCE__STATUS;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__ERRORS = METADATA_REPOSITORY_REFERENCE__ERRORS;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__WARNINGS = METADATA_REPOSITORY_REFERENCE__WARNINGS;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__INFOS = METADATA_REPOSITORY_REFERENCE__INFOS;

	/**
	 * The feature id for the '<em><b>Metadata Repository</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__METADATA_REPOSITORY = METADATA_REPOSITORY_REFERENCE__METADATA_REPOSITORY;

	/**
	 * The feature id for the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__LOCATION = METADATA_REPOSITORY_REFERENCE__LOCATION;

	/**
	 * The feature id for the '<em><b>Nature</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__NATURE = METADATA_REPOSITORY_REFERENCE__NATURE;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__DESCRIPTION = METADATA_REPOSITORY_REFERENCE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Products</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__PRODUCTS = METADATA_REPOSITORY_REFERENCE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Bundles</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__BUNDLES = METADATA_REPOSITORY_REFERENCE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Features</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__FEATURES = METADATA_REPOSITORY_REFERENCE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Categories</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__CATEGORIES = METADATA_REPOSITORY_REFERENCE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Mirror Artifacts</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__MIRROR_ARTIFACTS = METADATA_REPOSITORY_REFERENCE_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Category Prefix</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__CATEGORY_PREFIX = METADATA_REPOSITORY_REFERENCE_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Map Rules</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY__MAP_RULES = METADATA_REPOSITORY_REFERENCE_FEATURE_COUNT + 7;

	/**
	 * The number of structural features of the '<em>Mapped Repository</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPED_REPOSITORY_FEATURE_COUNT = METADATA_REPOSITORY_REFERENCE_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_ITEM__GROUP_ID = 0;

	/**
	 * The feature id for the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_ITEM__ARTIFACT_ID = 1;

	/**
	 * The feature id for the '<em><b>Mapped Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_ITEM__MAPPED_VERSION = 2;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_ITEM__CLASSIFIER = 3;

	/**
	 * The feature id for the '<em><b>Maven Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_ITEM__MAVEN_MAPPING = 4;

	/**
	 * The number of structural features of the '<em>Maven Item</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 * @ordered
	 */
	int MAVEN_ITEM_FEATURE_COUNT = 5;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_MAPPING__STATUS = STATUS_PROVIDER__STATUS;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_MAPPING__ERRORS = STATUS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_MAPPING__WARNINGS = STATUS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_MAPPING__INFOS = STATUS_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name Pattern</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_MAPPING__NAME_PATTERN = STATUS_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_MAPPING__GROUP_ID = STATUS_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_MAPPING__ARTIFACT_ID = STATUS_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Version Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_MAPPING__VERSION_PATTERN = STATUS_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Version Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_MAPPING__VERSION_TEMPLATE = STATUS_PROVIDER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Snapshot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_MAPPING__SNAPSHOT = STATUS_PROVIDER_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Maven Mapping</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAVEN_MAPPING_FEATURE_COUNT = STATUS_PROVIDER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__STATUS = MAPPED_UNIT__STATUS;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__ERRORS = MAPPED_UNIT__ERRORS;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__WARNINGS = MAPPED_UNIT__WARNINGS;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__INFOS = MAPPED_UNIT__INFOS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__DESCRIPTION = MAPPED_UNIT__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__NAME = MAPPED_UNIT__NAME;

	/**
	 * The feature id for the '<em><b>Version Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__VERSION_RANGE = MAPPED_UNIT__VERSION_RANGE;

	/**
	 * The feature id for the '<em><b>Available Versions Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__AVAILABLE_VERSIONS_HEADER = MAPPED_UNIT__AVAILABLE_VERSIONS_HEADER;

	/**
	 * The feature id for the '<em><b>Available Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__AVAILABLE_VERSIONS = MAPPED_UNIT__AVAILABLE_VERSIONS;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__BRANCH_ENABLED = MAPPED_UNIT__BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__ENABLED = MAPPED_UNIT__ENABLED;

	/**
	 * The feature id for the '<em><b>Valid Configurations</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT__VALID_CONFIGURATIONS = MAPPED_UNIT__VALID_CONFIGURATIONS;

	/**
	 * The number of structural features of the '<em>Product</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRODUCT_FEATURE_COUNT = MAPPED_UNIT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__KEY = P2Package.COMPARABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY__VALUE = P2Package.COMPARABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Property</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROPERTY_FEATURE_COUNT = P2Package.COMPARABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__CODE = 0;

	/**
	 * The feature id for the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS__MESSAGE = 1;

	/**
	 * The number of structural features of the '<em>Status</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATUS_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET__BRANCH_ENABLED = ENABLED_STATUS_PROVIDER__BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET__ENABLED = ENABLED_STATUS_PROVIDER__ENABLED;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET__DESCRIPTION = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET__STATUS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET__ERRORS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET__WARNINGS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET__INFOS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET__ABSTRACT = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET__EXTENSION = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET__LABEL = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Contributions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET__CONTRIBUTIONS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Validation Repositories</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET__VALIDATION_REPOSITORIES = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Extends</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET__EXTENDS = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>Validation Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_SET_FEATURE_COUNT = ENABLED_STATUS_PROVIDER_FEATURE_COUNT + 11;

	/**
	 * The feature id for the '<em><b>Status</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_CONFIGURATIONS_RULE__STATUS = MAP_RULE__STATUS;

	/**
	 * The feature id for the '<em><b>Errors</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_CONFIGURATIONS_RULE__ERRORS = MAP_RULE__ERRORS;

	/**
	 * The feature id for the '<em><b>Warnings</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_CONFIGURATIONS_RULE__WARNINGS = MAP_RULE__WARNINGS;

	/**
	 * The feature id for the '<em><b>Infos</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_CONFIGURATIONS_RULE__INFOS = MAP_RULE__INFOS;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_CONFIGURATIONS_RULE__DESCRIPTION = MAP_RULE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_CONFIGURATIONS_RULE__NAME = MAP_RULE__NAME;

	/**
	 * The feature id for the '<em><b>Version Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_CONFIGURATIONS_RULE__VERSION_RANGE = MAP_RULE__VERSION_RANGE;

	/**
	 * The feature id for the '<em><b>Available Versions Header</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_CONFIGURATIONS_RULE__AVAILABLE_VERSIONS_HEADER = MAP_RULE__AVAILABLE_VERSIONS_HEADER;

	/**
	 * The feature id for the '<em><b>Available Versions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_CONFIGURATIONS_RULE__AVAILABLE_VERSIONS = MAP_RULE__AVAILABLE_VERSIONS;

	/**
	 * The feature id for the '<em><b>Branch Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_CONFIGURATIONS_RULE__BRANCH_ENABLED = MAP_RULE__BRANCH_ENABLED;

	/**
	 * The feature id for the '<em><b>Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_CONFIGURATIONS_RULE__ENABLED = MAP_RULE__ENABLED;

	/**
	 * The feature id for the '<em><b>Valid Configurations</b></em>' reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_CONFIGURATIONS_RULE__VALID_CONFIGURATIONS = MAP_RULE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Valid Configurations Rule</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALID_CONFIGURATIONS_RULE_FEATURE_COUNT = MAP_RULE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.AggregationType <em>Aggregation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregationType
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getAggregationType()
	 * @generated
	 */
	int AGGREGATION_TYPE = 30;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.OperatingSystem <em>Operating System</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.OperatingSystem
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getOperatingSystem()
	 * @generated
	 */
	int OPERATING_SYSTEM = 34;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.WindowSystem <em>Window System</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.WindowSystem
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getWindowSystem()
	 * @generated
	 */
	int WINDOW_SYSTEM = 38;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.VersionFormat <em>Version Format</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.VersionFormat
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getVersionFormat()
	 * @generated
	 */
	int VERSION_FORMAT = 39;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.Architecture <em>Architecture</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.Architecture
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getArchitecture()
	 * @generated
	 */
	int ARCHITECTURE = 31;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.AvailableFrom <em>Available From</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.AvailableFrom
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getAvailableFrom()
	 * @generated
	 */
	int AVAILABLE_FROM = 32;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.PackedStrategy <em>Packed Strategy</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.PackedStrategy
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getPackedStrategy()
	 * @generated
	 */
	int PACKED_STRATEGY = 35;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitType <em>Installable Unit Type</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.InstallableUnitType
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getInstallableUnitType()
	 * @generated
	 */
	int INSTALLABLE_UNIT_TYPE = 33;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.StatusCode <em>Status Code</em>}' enum.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.StatusCode
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getStatusCode()
	 * @generated
	 */
	int STATUS_CODE = 36;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.aggregator.VersionMatch <em>Version Match</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.aggregator.VersionMatch
	 * @see org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl#getVersionMatch()
	 * @generated
	 */
	int VERSION_MATCH = 37;

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation <em>Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregation</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation
	 * @generated
	 */
	EClass getAggregation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isAllowLegacySites <em>Allow Legacy Sites</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Allow Legacy Sites</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#isAllowLegacySites()
	 * @see #getAggregation()
	 * @generated
	 */
	EAttribute getAggregation_AllowLegacySites();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getBuildmaster <em>Buildmaster</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buildmaster</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#getBuildmaster()
	 * @see #getAggregation()
	 * @generated
	 */
	EReference getAggregation_Buildmaster();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getBuildmasterBackup <em>Buildmaster Backup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Buildmaster Backup</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#getBuildmasterBackup()
	 * @see #getAggregation()
	 * @generated
	 */
	EReference getAggregation_BuildmasterBackup();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getBuildRoot <em>Build Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Build Root</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#getBuildRoot()
	 * @see #getAggregation()
	 * @generated
	 */
	EAttribute getAggregation_BuildRoot();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getConfigurations <em>Configurations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Configurations</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#getConfigurations()
	 * @see #getAggregation()
	 * @generated
	 */
	EReference getAggregation_Configurations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getContacts <em>Contacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contacts</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#getContacts()
	 * @see #getAggregation()
	 * @generated
	 */
	EReference getAggregation_Contacts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getCustomCategories <em>Custom Categories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Custom Categories</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#getCustomCategories()
	 * @see #getAggregation()
	 * @generated
	 */
	EReference getAggregation_CustomCategories();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#getLabel()
	 * @see #getAggregation()
	 * @generated
	 */
	EAttribute getAggregation_Label();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getMavenMappings <em>Maven Mappings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Maven Mappings</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#getMavenMappings()
	 * @see #getAggregation()
	 * @generated
	 */
	EReference getAggregation_MavenMappings();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isMavenResult <em>Maven Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maven Result</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#isMavenResult()
	 * @see #getAggregation()
	 * @generated
	 */
	EAttribute getAggregation_MavenResult();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isStrictMavenVersions <em>Strict Maven Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strict Maven Versions</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#isStrictMavenVersions()
	 * @see #getAggregation()
	 * @generated
	 */
	EAttribute getAggregation_StrictMavenVersions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getVersionFormat <em>Version Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version Format</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#getVersionFormat()
	 * @see #getAggregation()
	 * @generated
	 */
	EAttribute getAggregation_VersionFormat();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getMavenBuildNumber <em>Maven Build Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Maven Build Number</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#getMavenBuildNumber()
	 * @see #getAggregation()
	 * @generated
	 */
	EAttribute getAggregation_MavenBuildNumber();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getPackedStrategy <em>Packed Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Packed Strategy</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#getPackedStrategy()
	 * @see #getAggregation()
	 * @generated
	 */
	EAttribute getAggregation_PackedStrategy();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isSendmail <em>Sendmail</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sendmail</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#isSendmail()
	 * @see #getAggregation()
	 * @generated
	 */
	EAttribute getAggregation_Sendmail();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#getType()
	 * @see #getAggregation()
	 * @generated
	 */
	EAttribute getAggregation_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getValidationSets <em>Validation Sets</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Validation Sets</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Aggregation#getValidationSets()
	 * @see #getAggregation()
	 * @generated
	 */
	EReference getAggregation_ValidationSets();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.cbi.p2repo.aggregator.AggregationType <em>Aggregation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Aggregation Type</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregationType
	 * @generated
	 */
	EEnum getAggregationType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AggregatorFactory getAggregatorFactory();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.cbi.p2repo.aggregator.Architecture <em>Architecture</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Architecture</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Architecture
	 * @generated
	 */
	EEnum getArchitecture();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.cbi.p2repo.aggregator.AvailableFrom <em>Available From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Available From</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.AvailableFrom
	 * @generated
	 */
	EEnum getAvailableFrom();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.AvailableVersion <em>Available Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Available Version</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.AvailableVersion
	 * @generated
	 */
	EClass getAvailableVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.AvailableVersion#getAvailableFrom <em>Available From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Available From</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.AvailableVersion#getAvailableFrom()
	 * @see #getAvailableVersion()
	 * @generated
	 */
	EAttribute getAvailableVersion_AvailableFrom();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.AvailableVersion#getFilter <em>Filter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Filter</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.AvailableVersion#getFilter()
	 * @see #getAvailableVersion()
	 * @generated
	 */
	EAttribute getAvailableVersion_Filter();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.AvailableVersion#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.AvailableVersion#getVersion()
	 * @see #getAvailableVersion()
	 * @generated
	 */
	EAttribute getAvailableVersion_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.AvailableVersion#getVersionMatch <em>Version Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version Match</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.AvailableVersion#getVersionMatch()
	 * @see #getAvailableVersion()
	 * @generated
	 */
	EAttribute getAvailableVersion_VersionMatch();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader <em>Available Versions Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Available Versions Header</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader
	 * @generated
	 */
	EClass getAvailableVersionsHeader();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader#getAvailableVersions <em>Available Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Available Versions</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader#getAvailableVersions()
	 * @see #getAvailableVersionsHeader()
	 * @generated
	 */
	EReference getAvailableVersionsHeader_AvailableVersions();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader#getInstallableUnitRequest <em>Installable Unit Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Installable Unit Request</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader#getInstallableUnitRequest()
	 * @see #getAvailableVersionsHeader()
	 * @generated
	 */
	EReference getAvailableVersionsHeader_InstallableUnitRequest();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.Bundle <em>Bundle</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Bundle</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Bundle
	 * @generated
	 */
	EClass getBundle();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.Category <em>Category</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Category</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Category
	 * @generated
	 */
	EClass getCategory();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Category#getLabelOverride <em>Label Override</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label Override</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Category#getLabelOverride()
	 * @see #getCategory()
	 * @generated
	 */
	EAttribute getCategory_LabelOverride();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.ChildrenProvider <em>Children Provider</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Children Provider</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.ChildrenProvider
	 * @generated
	 */
	EClass getChildrenProvider();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.cbi.p2repo.aggregator.ChildrenProvider#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Children</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.ChildrenProvider#getChildren()
	 * @see #getChildrenProvider()
	 * @generated
	 */
	EReference getChildrenProvider_Children();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.Configuration <em>Configuration</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Configuration</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Configuration
	 * @generated
	 */
	EClass getConfiguration();

	/**
	 * Returns the meta object for the attribute ' {@link org.eclipse.cbi.p2repo.aggregator.Configuration#getArchitecture
	 * <em>Architecture</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Architecture</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Configuration#getArchitecture()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_Architecture();

	/**
	 * Returns the meta object for the attribute ' {@link org.eclipse.cbi.p2repo.aggregator.Configuration#getOperatingSystem
	 * <em>Operating System</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Operating System</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Configuration#getOperatingSystem()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_OperatingSystem();

	/**
	 * Returns the meta object for the attribute ' {@link org.eclipse.cbi.p2repo.aggregator.Configuration#getWindowSystem
	 * <em>Window System</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Window System</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Configuration#getWindowSystem()
	 * @see #getConfiguration()
	 * @generated
	 */
	EAttribute getConfiguration_WindowSystem();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.Contact <em>Contact</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Contact</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Contact
	 * @generated
	 */
	EClass getContact();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.cbi.p2repo.aggregator.Contact#getAggregation <em>Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Aggregation</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Contact#getAggregation()
	 * @see #getContact()
	 * @generated
	 */
	EReference getContact_Aggregation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Contact#getEmail <em>Email</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Email</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Contact#getEmail()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_Email();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Contact#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Contact#getName()
	 * @see #getContact()
	 * @generated
	 */
	EAttribute getContact_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.Contribution <em>Contribution</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Contribution</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Contribution
	 * @generated
	 */
	EClass getContribution();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.cbi.p2repo.aggregator.Contribution#getContacts <em>Contacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Contacts</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Contribution#getContacts()
	 * @see #getContribution()
	 * @generated
	 */
	EReference getContribution_Contacts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Contribution#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Contribution#getLabel()
	 * @see #getContribution()
	 * @generated
	 */
	EAttribute getContribution_Label();

	/**
	 * Returns the meta object for the reference list ' {@link org.eclipse.cbi.p2repo.aggregator.Contribution#getMavenMappings
	 * <em>Maven Mappings</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Maven Mappings</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Contribution#getMavenMappings()
	 * @see #getContribution()
	 * @generated
	 */
	EReference getContribution_MavenMappings();

	/**
	 * Returns the meta object for the containment reference list ' {@link org.eclipse.cbi.p2repo.aggregator.Contribution#getRepositories
	 * <em>Repositories</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Repositories</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Contribution#getRepositories()
	 * @see #getContribution()
	 * @generated
	 */
	EReference getContribution_Repositories();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.CustomCategory <em>Custom Category</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Custom Category</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.CustomCategory
	 * @generated
	 */
	EClass getCustomCategory();

	/**
	 * Returns the meta object for the attribute ' {@link org.eclipse.cbi.p2repo.aggregator.CustomCategory#getDescription
	 * <em>Description</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.CustomCategory#getDescription()
	 * @see #getCustomCategory()
	 * @generated
	 */
	EAttribute getCustomCategory_Description();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.cbi.p2repo.aggregator.CustomCategory#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Features</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.CustomCategory#getFeatures()
	 * @see #getCustomCategory()
	 * @generated
	 */
	EReference getCustomCategory_Features();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.CustomCategory#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.CustomCategory#getIdentifier()
	 * @see #getCustomCategory()
	 * @generated
	 */
	EAttribute getCustomCategory_Identifier();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.CustomCategory#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.CustomCategory#getLabel()
	 * @see #getCustomCategory()
	 * @generated
	 */
	EAttribute getCustomCategory_Label();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.DescriptionProvider <em>Description Provider</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Description Provider</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.DescriptionProvider
	 * @generated
	 */
	EClass getDescriptionProvider();

	/**
	 * Returns the meta object for the attribute ' {@link org.eclipse.cbi.p2repo.aggregator.DescriptionProvider#getDescription
	 * <em>Description</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.DescriptionProvider#getDescription()
	 * @see #getDescriptionProvider()
	 * @generated
	 */
	EAttribute getDescriptionProvider_Description();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider <em>Enabled Status Provider</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enabled Status Provider</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider
	 * @generated
	 */
	EClass getEnabledStatusProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider#isBranchEnabled <em>Branch Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Branch Enabled</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider#isBranchEnabled()
	 * @see #getEnabledStatusProvider()
	 * @generated
	 */
	EAttribute getEnabledStatusProvider_BranchEnabled();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider#isEnabled <em>Enabled</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Enabled</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider#isEnabled()
	 * @see #getEnabledStatusProvider()
	 * @generated
	 */
	EAttribute getEnabledStatusProvider_Enabled();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.ExclusionRule <em>Exclusion Rule</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Exclusion Rule</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.ExclusionRule
	 * @generated
	 */
	EClass getExclusionRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.Feature <em>Feature</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.cbi.p2repo.aggregator.Feature#getCategories <em>Categories</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Categories</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Feature#getCategories()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Categories();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.IdentificationProvider <em>Identification Provider</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identification Provider</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.IdentificationProvider
	 * @generated
	 */
	EClass getIdentificationProvider();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.InfosProvider <em>Infos Provider</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infos Provider</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.InfosProvider
	 * @generated
	 */
	EClass getInfosProvider();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.cbi.p2repo.aggregator.InfosProvider#getErrors <em>Errors</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the attribute list '<em>Errors</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.InfosProvider#getErrors()
	 * @see #getInfosProvider()
	 * @generated
	 */
	EAttribute getInfosProvider_Errors();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.cbi.p2repo.aggregator.InfosProvider#getInfos <em>Infos</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Infos</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.InfosProvider#getInfos()
	 * @see #getInfosProvider()
	 * @generated
	 */
	EAttribute getInfosProvider_Infos();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.cbi.p2repo.aggregator.InfosProvider#getWarnings <em>Warnings</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Warnings</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.InfosProvider#getWarnings()
	 * @see #getInfosProvider()
	 * @generated
	 */
	EAttribute getInfosProvider_Warnings();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest <em>Installable Unit Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Installable Unit Request</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest
	 * @generated
	 */
	EClass getInstallableUnitRequest();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getAvailableVersions <em>Available Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Available Versions</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getAvailableVersions()
	 * @see #getInstallableUnitRequest()
	 * @generated
	 */
	EReference getInstallableUnitRequest_AvailableVersions();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getAvailableVersionsHeader <em>Available Versions Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Available Versions Header</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getAvailableVersionsHeader()
	 * @see #getInstallableUnitRequest()
	 * @generated
	 */
	EReference getInstallableUnitRequest_AvailableVersionsHeader();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getName()
	 * @see #getInstallableUnitRequest()
	 * @generated
	 */
	EAttribute getInstallableUnitRequest_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getVersionRange <em>Version Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version Range</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getVersionRange()
	 * @see #getInstallableUnitRequest()
	 * @generated
	 */
	EAttribute getInstallableUnitRequest_VersionRange();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitType <em>Installable Unit Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Installable Unit Type</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.InstallableUnitType
	 * @generated
	 */
	EEnum getInstallableUnitType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.LabelProvider <em>Label Provider</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label Provider</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.LabelProvider
	 * @generated
	 */
	EClass getLabelProvider();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.LabelProvider#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.LabelProvider#getLabel()
	 * @see #getLabelProvider()
	 * @generated
	 */
	EAttribute getLabelProvider_Label();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.MappedRepository <em>Mapped Repository</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Repository</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MappedRepository
	 * @generated
	 */
	EClass getMappedRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.aggregator.MappedRepository#getBundles <em>Bundles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Bundles</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MappedRepository#getBundles()
	 * @see #getMappedRepository()
	 * @generated
	 */
	EReference getMappedRepository_Bundles();

	/**
	 * Returns the meta object for the containment reference list ' {@link org.eclipse.cbi.p2repo.aggregator.MappedRepository#getCategories
	 * <em>Categories</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the containment reference list '<em>Categories</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MappedRepository#getCategories()
	 * @see #getMappedRepository()
	 * @generated
	 */
	EReference getMappedRepository_Categories();

	/**
	 * Returns the meta object for the attribute ' {@link org.eclipse.cbi.p2repo.aggregator.MappedRepository#getCategoryPrefix
	 * <em>Category Prefix</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Category Prefix</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MappedRepository#getCategoryPrefix()
	 * @see #getMappedRepository()
	 * @generated
	 */
	EAttribute getMappedRepository_CategoryPrefix();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.aggregator.MappedRepository#getFeatures <em>Features</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Features</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MappedRepository#getFeatures()
	 * @see #getMappedRepository()
	 * @generated
	 */
	EReference getMappedRepository_Features();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.aggregator.MappedRepository#getMapRules <em>Map Rules</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Map Rules</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MappedRepository#getMapRules()
	 * @see #getMappedRepository()
	 * @generated
	 */
	EReference getMappedRepository_MapRules();

	/**
	 * Returns the meta object for the attribute ' {@link org.eclipse.cbi.p2repo.aggregator.MappedRepository#isMirrorArtifacts
	 * <em>Mirror Artifacts</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Mirror Artifacts</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MappedRepository#isMirrorArtifacts()
	 * @see #getMappedRepository()
	 * @generated
	 */
	EAttribute getMappedRepository_MirrorArtifacts();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.aggregator.MappedRepository#getProducts <em>Products</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Products</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MappedRepository#getProducts()
	 * @see #getMappedRepository()
	 * @generated
	 */
	EReference getMappedRepository_Products();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.MappedUnit <em>Mapped Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapped Unit</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MappedUnit
	 * @generated
	 */
	EClass getMappedUnit();

	/**
	 * Returns the meta object for the reference list ' {@link org.eclipse.cbi.p2repo.aggregator.MappedUnit#getValidConfigurations
	 * <em>Valid Configurations</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the reference list '<em>Valid Configurations</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MappedUnit#getValidConfigurations()
	 * @see #getMappedUnit()
	 * @generated
	 */
	EReference getMappedUnit_ValidConfigurations();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.MapRule <em>Map Rule</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Map Rule</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MapRule
	 * @generated
	 */
	EClass getMapRule();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.MavenItem <em>Maven Item</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Maven Item</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MavenItem
	 * @generated
	 */
	EClass getMavenItem();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getArtifactId <em>Artifact Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Artifact Id</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MavenItem#getArtifactId()
	 * @see #getMavenItem()
	 * @generated
	 */
	EAttribute getMavenItem_ArtifactId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getMappedVersion <em>Mapped Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Mapped Version</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MavenItem#getMappedVersion()
	 * @see #getMavenItem()
	 * @generated
	 */
	EAttribute getMavenItem_MappedVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classifier</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MavenItem#getClassifier()
	 * @see #getMavenItem()
	 * @generated
	 */
	EAttribute getMavenItem_Classifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getMavenMapping <em>Maven Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Maven Mapping</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MavenItem#getMavenMapping()
	 * @see #getMavenItem()
	 * @generated
	 */
	EReference getMavenItem_MavenMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getGroupId <em>Group Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Id</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MavenItem#getGroupId()
	 * @see #getMavenItem()
	 * @generated
	 */
	EAttribute getMavenItem_GroupId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping <em>Maven Mapping</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Maven Mapping</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MavenMapping
	 * @generated
	 */
	EClass getMavenMapping();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getArtifactId <em>Artifact Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Artifact Id</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MavenMapping#getArtifactId()
	 * @see #getMavenMapping()
	 * @generated
	 */
	EAttribute getMavenMapping_ArtifactId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getVersionPattern <em>Version Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version Pattern</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MavenMapping#getVersionPattern()
	 * @see #getMavenMapping()
	 * @generated
	 */
	EAttribute getMavenMapping_VersionPattern();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getVersionTemplate <em>Version Template</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version Template</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MavenMapping#getVersionTemplate()
	 * @see #getMavenMapping()
	 * @generated
	 */
	EAttribute getMavenMapping_VersionTemplate();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#isSnapshot <em>Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Snapshot</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MavenMapping#isSnapshot()
	 * @see #getMavenMapping()
	 * @generated
	 */
	EAttribute getMavenMapping_Snapshot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getGroupId <em>Group Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Id</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MavenMapping#getGroupId()
	 * @see #getMavenMapping()
	 * @generated
	 */
	EAttribute getMavenMapping_GroupId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getNamePattern <em>Name Pattern</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name Pattern</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MavenMapping#getNamePattern()
	 * @see #getMavenMapping()
	 * @generated
	 */
	EAttribute getMavenMapping_NamePattern();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference <em>Metadata Repository Reference</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Metadata Repository Reference</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference
	 * @generated
	 */
	EClass getMetadataRepositoryReference();

	/**
	 * Returns the meta object for the attribute ' {@link org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference#getLocation <em>Location</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Location</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference#getLocation()
	 * @see #getMetadataRepositoryReference()
	 * @generated
	 */
	EAttribute getMetadataRepositoryReference_Location();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference#getMetadataRepository <em>Metadata Repository</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Metadata Repository</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference#getMetadataRepository()
	 * @see #getMetadataRepositoryReference()
	 * @generated
	 */
	EReference getMetadataRepositoryReference_MetadataRepository();

	/**
	 * Returns the meta object for the attribute ' {@link org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference#getNature <em>Nature</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for the attribute '<em>Nature</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference#getNature()
	 * @see #getMetadataRepositoryReference()
	 * @generated
	 */
	EAttribute getMetadataRepositoryReference_Nature();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.cbi.p2repo.aggregator.OperatingSystem <em>Operating System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operating System</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.OperatingSystem
	 * @generated
	 */
	EEnum getOperatingSystem();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.cbi.p2repo.aggregator.PackedStrategy <em>Packed Strategy</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Packed Strategy</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.PackedStrategy
	 * @generated
	 */
	EEnum getPackedStrategy();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.Product <em>Product</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Product</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Product
	 * @generated
	 */
	EClass getProduct();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.Property <em>Property</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Property</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Property
	 * @generated
	 */
	EClass getProperty();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Property#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Property#getKey()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Key();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Property#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Property#getValue()
	 * @see #getProperty()
	 * @generated
	 */
	EAttribute getProperty_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.Status <em>Status</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the meta object for class '<em>Status</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Status
	 * @generated
	 */
	EClass getStatus();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Status#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Status#getCode()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Code();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.Status#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.Status#getMessage()
	 * @see #getStatus()
	 * @generated
	 */
	EAttribute getStatus_Message();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.cbi.p2repo.aggregator.StatusCode <em>Status Code</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Status Code</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.StatusCode
	 * @generated
	 */
	EEnum getStatusCode();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.StatusProvider <em>Status Provider</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Status Provider</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.StatusProvider
	 * @generated
	 */
	EClass getStatusProvider();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.cbi.p2repo.aggregator.StatusProvider#getStatus <em>Status</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Status</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.StatusProvider#getStatus()
	 * @see #getStatusProvider()
	 * @generated
	 */
	EReference getStatusProvider_Status();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.ValidationSet <em>Validation Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validation Set</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.ValidationSet
	 * @generated
	 */
	EClass getValidationSet();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.ValidationSet#isAbstract <em>Abstract</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstract</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.ValidationSet#isAbstract()
	 * @see #getValidationSet()
	 * @generated
	 */
	EAttribute getValidationSet_Abstract();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.aggregator.ValidationSet#getContributions <em>Contributions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Contributions</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.ValidationSet#getContributions()
	 * @see #getValidationSet()
	 * @generated
	 */
	EReference getValidationSet_Contributions();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.cbi.p2repo.aggregator.ValidationSet#getExtends <em>Extends</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Extends</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.ValidationSet#getExtends()
	 * @see #getValidationSet()
	 * @generated
	 */
	EReference getValidationSet_Extends();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.ValidationSet#isExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.ValidationSet#isExtension()
	 * @see #getValidationSet()
	 * @generated
	 */
	EAttribute getValidationSet_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.aggregator.ValidationSet#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Label</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.ValidationSet#getLabel()
	 * @see #getValidationSet()
	 * @generated
	 */
	EAttribute getValidationSet_Label();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.aggregator.ValidationSet#getValidationRepositories <em>Validation Repositories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Validation Repositories</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.ValidationSet#getValidationRepositories()
	 * @see #getValidationSet()
	 * @generated
	 */
	EReference getValidationSet_ValidationRepositories();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.aggregator.ValidConfigurationsRule <em>Valid Configurations Rule</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Valid Configurations Rule</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.ValidConfigurationsRule
	 * @generated
	 */
	EClass getValidConfigurationsRule();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.cbi.p2repo.aggregator.ValidConfigurationsRule#getValidConfigurations <em>Valid Configurations</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Valid Configurations</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.ValidConfigurationsRule#getValidConfigurations()
	 * @see #getValidConfigurationsRule()
	 * @generated
	 */
	EReference getValidConfigurationsRule_ValidConfigurations();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.cbi.p2repo.aggregator.VersionMatch <em>Version Match</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Version Match</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.VersionMatch
	 * @generated
	 */
	EEnum getVersionMatch();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.cbi.p2repo.aggregator.WindowSystem <em>Window System</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Window System</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.WindowSystem
	 * @generated
	 */
	EEnum getWindowSystem();

	/**
	 * Returns the meta object for enum '{@link org.eclipse.cbi.p2repo.aggregator.VersionFormat <em>Version Format</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Version Format</em>'.
	 * @see org.eclipse.cbi.p2repo.aggregator.VersionFormat
	 * @generated
	 */
	EEnum getVersionFormat();

} // AggregatorPackage
