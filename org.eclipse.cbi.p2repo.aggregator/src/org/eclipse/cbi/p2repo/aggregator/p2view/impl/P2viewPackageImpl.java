/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.aggregator.p2view.impl;

import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.impl.AggregatorPackageImpl;
import org.eclipse.cbi.p2repo.aggregator.p2view.Bundle;
import org.eclipse.cbi.p2repo.aggregator.p2view.Bundles;
import org.eclipse.cbi.p2repo.aggregator.p2view.Categories;
import org.eclipse.cbi.p2repo.aggregator.p2view.Category;
import org.eclipse.cbi.p2repo.aggregator.p2view.Feature;
import org.eclipse.cbi.p2repo.aggregator.p2view.Features;
import org.eclipse.cbi.p2repo.aggregator.p2view.Fragment;
import org.eclipse.cbi.p2repo.aggregator.p2view.Fragments;
import org.eclipse.cbi.p2repo.aggregator.p2view.IUDetails;
import org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation;
import org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentationWithDetails;
import org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits;
import org.eclipse.cbi.p2repo.aggregator.p2view.Licenses;
import org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView;
import org.eclipse.cbi.p2repo.aggregator.p2view.Miscellaneous;
import org.eclipse.cbi.p2repo.aggregator.p2view.OtherIU;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewFactory;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.cbi.p2repo.aggregator.p2view.Product;
import org.eclipse.cbi.p2repo.aggregator.p2view.Products;
import org.eclipse.cbi.p2repo.aggregator.p2view.Properties;
import org.eclipse.cbi.p2repo.aggregator.p2view.ProvidedCapabilities;
import org.eclipse.cbi.p2repo.aggregator.p2view.ProvidedCapabilityWrapper;
import org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryBrowser;
import org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryReferences;
import org.eclipse.cbi.p2repo.aggregator.p2view.RequirementWrapper;
import org.eclipse.cbi.p2repo.aggregator.p2view.Requirements;
import org.eclipse.cbi.p2repo.aggregator.p2view.Touchpoints;
import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class P2viewPackageImpl extends EPackageImpl implements P2viewPackage {
	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link P2viewPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static P2viewPackage init() {
		if (isInited)
			return (P2viewPackage) EPackage.Registry.INSTANCE.getEPackage(P2viewPackage.eNS_URI);

		// Obtain or create and register package
		P2viewPackageImpl theP2viewPackage = (P2viewPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof P2viewPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new P2viewPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		P2Package.eINSTANCE.eClass();
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		AggregatorPackageImpl theAggregatorPackage = (AggregatorPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(AggregatorPackage.eNS_URI) instanceof AggregatorPackageImpl
						? EPackage.Registry.INSTANCE.getEPackage(AggregatorPackage.eNS_URI)
						: AggregatorPackage.eINSTANCE);

		// Create package meta-data objects
		theP2viewPackage.createPackageContents();
		theAggregatorPackage.createPackageContents();

		// Initialize created meta-data
		theP2viewPackage.initializePackageContents();
		theAggregatorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theP2viewPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(P2viewPackage.eNS_URI, theP2viewPackage);
		return theP2viewPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metadataRepositoryStructuredViewEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass installableUnitsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoriesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featuresEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass productsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bundlesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fragmentsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass miscellaneousEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iuPresentationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iuPresentationWithDetailsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass categoryEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass featureEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass productEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bundleEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fragmentEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass otherIUEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass propertiesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementsEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass providedCapabilitiesEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass touchpointsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass licensesEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repositoryBrowserEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iuDetailsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementWrapperEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass providedCapabilityWrapperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass repositoryReferencesEClass = null;

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
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private P2viewPackageImpl() {
		super(eNS_URI, P2viewFactory.eINSTANCE);
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
		bundleEClass = createEClass(BUNDLE);

		bundlesEClass = createEClass(BUNDLES);
		createEReference(bundlesEClass, BUNDLES__BUNDLES);

		categoryEClass = createEClass(CATEGORY);
		createEReference(categoryEClass, CATEGORY__CATEGORY_CONTAINER);
		createEReference(categoryEClass, CATEGORY__FEATURE_CONTAINER);
		createEReference(categoryEClass, CATEGORY__PRODUCT_CONTAINER);
		createEReference(categoryEClass, CATEGORY__BUNDLE_CONTAINER);
		createEReference(categoryEClass, CATEGORY__FRAGMENT_CONTAINER);
		createEReference(categoryEClass, CATEGORY__IU_DETAILS);

		categoriesEClass = createEClass(CATEGORIES);
		createEReference(categoriesEClass, CATEGORIES__CATEGORIES);

		featureEClass = createEClass(FEATURE);
		createEReference(featureEClass, FEATURE__FEATURE_CONTAINER);
		createEReference(featureEClass, FEATURE__BUNDLE_CONTAINER);
		createEReference(featureEClass, FEATURE__FRAGMENT_CONTAINER);

		featuresEClass = createEClass(FEATURES);
		createEReference(featuresEClass, FEATURES__FEATURES);

		fragmentEClass = createEClass(FRAGMENT);

		fragmentsEClass = createEClass(FRAGMENTS);
		createEReference(fragmentsEClass, FRAGMENTS__FRAGMENTS);

		installableUnitsEClass = createEClass(INSTALLABLE_UNITS);
		createEReference(installableUnitsEClass, INSTALLABLE_UNITS__ALL_IUS);
		createEReference(installableUnitsEClass, INSTALLABLE_UNITS__CATEGORY_CONTAINER);
		createEReference(installableUnitsEClass, INSTALLABLE_UNITS__FEATURE_CONTAINER);
		createEReference(installableUnitsEClass, INSTALLABLE_UNITS__PRODUCT_CONTAINER);
		createEReference(installableUnitsEClass, INSTALLABLE_UNITS__BUNDLE_CONTAINER);
		createEReference(installableUnitsEClass, INSTALLABLE_UNITS__FRAGMENT_CONTAINER);
		createEReference(installableUnitsEClass, INSTALLABLE_UNITS__MISCELLANEOUS_CONTAINER);

		iuDetailsEClass = createEClass(IU_DETAILS);
		createEReference(iuDetailsEClass, IU_DETAILS__REQUIREMENTS_CONTAINER);
		createEReference(iuDetailsEClass, IU_DETAILS__PROVIDED_CAPABILITIES_CONTAINER);
		createEReference(iuDetailsEClass, IU_DETAILS__PROPERTIES_CONTAINER);
		createEReference(iuDetailsEClass, IU_DETAILS__TOUCHPOINTS_CONTAINER);
		createEReference(iuDetailsEClass, IU_DETAILS__UPDATE_DESCRIPTOR);
		createEReference(iuDetailsEClass, IU_DETAILS__COPYRIGHT);
		createEReference(iuDetailsEClass, IU_DETAILS__LICENSES_CONTAINER);

		iuPresentationEClass = createEClass(IU_PRESENTATION);
		createEAttribute(iuPresentationEClass, IU_PRESENTATION__ID);
		createEAttribute(iuPresentationEClass, IU_PRESENTATION__VERSION);
		createEAttribute(iuPresentationEClass, IU_PRESENTATION__NAME);
		createEAttribute(iuPresentationEClass, IU_PRESENTATION__LABEL);
		createEAttribute(iuPresentationEClass, IU_PRESENTATION__DESCRIPTION);
		createEAttribute(iuPresentationEClass, IU_PRESENTATION__TYPE);
		createEAttribute(iuPresentationEClass, IU_PRESENTATION__FILTER);
		createEReference(iuPresentationEClass, IU_PRESENTATION__INSTALLABLE_UNIT);

		iuPresentationWithDetailsEClass = createEClass(IU_PRESENTATION_WITH_DETAILS);
		createEAttribute(iuPresentationWithDetailsEClass, IU_PRESENTATION_WITH_DETAILS__DETAILS_RESOLVED);

		licensesEClass = createEClass(LICENSES);
		createEReference(licensesEClass, LICENSES__LICENSES);

		repositoryBrowserEClass = createEClass(REPOSITORY_BROWSER);
		createEReference(repositoryBrowserEClass, REPOSITORY_BROWSER__REPOSITORIES);
		createEAttribute(repositoryBrowserEClass, REPOSITORY_BROWSER__LOADING);

		metadataRepositoryStructuredViewEClass = createEClass(METADATA_REPOSITORY_STRUCTURED_VIEW);
		createEAttribute(metadataRepositoryStructuredViewEClass, METADATA_REPOSITORY_STRUCTURED_VIEW__NAME);
		createEReference(metadataRepositoryStructuredViewEClass,
				METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST);
		createEReference(metadataRepositoryStructuredViewEClass, METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES);
		createEReference(metadataRepositoryStructuredViewEClass,
				METADATA_REPOSITORY_STRUCTURED_VIEW__METADATA_REPOSITORY);
		createEAttribute(metadataRepositoryStructuredViewEClass, METADATA_REPOSITORY_STRUCTURED_VIEW__LOADED);
		createEReference(metadataRepositoryStructuredViewEClass,
				METADATA_REPOSITORY_STRUCTURED_VIEW__REPOSITORY_REFERENCES);
		createEAttribute(metadataRepositoryStructuredViewEClass, METADATA_REPOSITORY_STRUCTURED_VIEW__LOCATION);

		miscellaneousEClass = createEClass(MISCELLANEOUS);
		createEReference(miscellaneousEClass, MISCELLANEOUS__OTHERS);

		otherIUEClass = createEClass(OTHER_IU);

		productEClass = createEClass(PRODUCT);
		createEReference(productEClass, PRODUCT__FEATURE_CONTAINER);
		createEReference(productEClass, PRODUCT__BUNDLE_CONTAINER);
		createEReference(productEClass, PRODUCT__FRAGMENT_CONTAINER);

		productsEClass = createEClass(PRODUCTS);
		createEReference(productsEClass, PRODUCTS__PRODUCTS);

		propertiesEClass = createEClass(PROPERTIES);
		createEReference(propertiesEClass, PROPERTIES__PROPERTY_LIST);

		providedCapabilitiesEClass = createEClass(PROVIDED_CAPABILITIES);
		createEReference(providedCapabilitiesEClass, PROVIDED_CAPABILITIES__PROVIDED_CAPABILITIES);

		providedCapabilityWrapperEClass = createEClass(PROVIDED_CAPABILITY_WRAPPER);
		createEReference(providedCapabilityWrapperEClass, PROVIDED_CAPABILITY_WRAPPER__GENUINE);

		repositoryReferencesEClass = createEClass(REPOSITORY_REFERENCES);
		createEReference(repositoryReferencesEClass, REPOSITORY_REFERENCES__REPOSITORY_REFERENCES);

		requirementsEClass = createEClass(REQUIREMENTS);
		createEReference(requirementsEClass, REQUIREMENTS__REQUIREMENTS);

		requirementWrapperEClass = createEClass(REQUIREMENT_WRAPPER);
		createEReference(requirementWrapperEClass, REQUIREMENT_WRAPPER__GENUINE);

		touchpointsEClass = createEClass(TOUCHPOINTS);
		createEReference(touchpointsEClass, TOUCHPOINTS__TOUCHPOINT_TYPE);
		createEReference(touchpointsEClass, TOUCHPOINTS__TOUCHPOINT_DATA_LIST);
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
	public EClass getBundles() {
		return bundlesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBundles_Bundles() {
		return (EReference) bundlesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCategories() {
		return categoriesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCategories_Categories() {
		return (EReference) categoriesEClass.getEStructuralFeatures().get(0);
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
	public EReference getCategory_BundleContainer() {
		return (EReference) categoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCategory_CategoryContainer() {
		return (EReference) categoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCategory_FeatureContainer() {
		return (EReference) categoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCategory_FragmentContainer() {
		return (EReference) categoryEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCategory_IuDetails() {
		return (EReference) categoryEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCategory_ProductContainer() {
		return (EReference) categoryEClass.getEStructuralFeatures().get(2);
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
	public EReference getFeature_BundleContainer() {
		return (EReference) featureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFeature_FeatureContainer() {
		return (EReference) featureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFeature_FragmentContainer() {
		return (EReference) featureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFeatures() {
		return featuresEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFeatures_Features() {
		return (EReference) featuresEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFragment() {
		return fragmentEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getFragments() {
		return fragmentsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getFragments_Fragments() {
		return (EReference) fragmentsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInstallableUnits() {
		return installableUnitsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstallableUnits_AllIUs() {
		return (EReference) installableUnitsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstallableUnits_BundleContainer() {
		return (EReference) installableUnitsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstallableUnits_CategoryContainer() {
		return (EReference) installableUnitsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstallableUnits_FeatureContainer() {
		return (EReference) installableUnitsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstallableUnits_FragmentContainer() {
		return (EReference) installableUnitsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstallableUnits_MiscellaneousContainer() {
		return (EReference) installableUnitsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInstallableUnits_ProductContainer() {
		return (EReference) installableUnitsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIUDetails() {
		return iuDetailsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIUDetails_Copyright() {
		return (EReference) iuDetailsEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIUDetails_LicensesContainer() {
		return (EReference) iuDetailsEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIUDetails_PropertiesContainer() {
		return (EReference) iuDetailsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIUDetails_ProvidedCapabilitiesContainer() {
		return (EReference) iuDetailsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIUDetails_RequirementsContainer() {
		return (EReference) iuDetailsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIUDetails_TouchpointsContainer() {
		return (EReference) iuDetailsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIUDetails_UpdateDescriptor() {
		return (EReference) iuDetailsEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIUPresentation() {
		return iuPresentationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIUPresentation_Description() {
		return (EAttribute) iuPresentationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIUPresentation_Filter() {
		return (EAttribute) iuPresentationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIUPresentation_Id() {
		return (EAttribute) iuPresentationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getIUPresentation_InstallableUnit() {
		return (EReference) iuPresentationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIUPresentation_Label() {
		return (EAttribute) iuPresentationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIUPresentation_Name() {
		return (EAttribute) iuPresentationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIUPresentation_Type() {
		return (EAttribute) iuPresentationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIUPresentation_Version() {
		return (EAttribute) iuPresentationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getIUPresentationWithDetails() {
		return iuPresentationWithDetailsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getIUPresentationWithDetails_DetailsResolved() {
		return (EAttribute) iuPresentationWithDetailsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLicenses() {
		return licensesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLicenses_Licenses() {
		return (EReference) licensesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetadataRepositoryStructuredView() {
		return metadataRepositoryStructuredViewEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetadataRepositoryStructuredView_InstallableUnitList() {
		return (EReference) metadataRepositoryStructuredViewEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetadataRepositoryStructuredView_Loaded() {
		return (EAttribute) metadataRepositoryStructuredViewEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetadataRepositoryStructuredView_Location() {
		return (EAttribute) metadataRepositoryStructuredViewEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetadataRepositoryStructuredView_MetadataRepository() {
		return (EReference) metadataRepositoryStructuredViewEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetadataRepositoryStructuredView_Name() {
		return (EAttribute) metadataRepositoryStructuredViewEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetadataRepositoryStructuredView_Properties() {
		return (EReference) metadataRepositoryStructuredViewEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetadataRepositoryStructuredView_RepositoryReferences() {
		return (EReference) metadataRepositoryStructuredViewEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMiscellaneous() {
		return miscellaneousEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMiscellaneous_Others() {
		return (EReference) miscellaneousEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOtherIU() {
		return otherIUEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public P2viewFactory getP2viewFactory() {
		return (P2viewFactory) getEFactoryInstance();
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
	public EReference getProduct_BundleContainer() {
		return (EReference) productEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProduct_FeatureContainer() {
		return (EReference) productEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProduct_FragmentContainer() {
		return (EReference) productEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProducts() {
		return productsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProducts_Products() {
		return (EReference) productsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProperties() {
		return propertiesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProperties_PropertyList() {
		return (EReference) propertiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProvidedCapabilities() {
		return providedCapabilitiesEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProvidedCapabilities_ProvidedCapabilities() {
		return (EReference) providedCapabilitiesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getProvidedCapabilityWrapper() {
		return providedCapabilityWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getProvidedCapabilityWrapper_Genuine() {
		return (EReference) providedCapabilityWrapperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRepositoryBrowser() {
		return repositoryBrowserEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRepositoryBrowser_Loading() {
		return (EAttribute) repositoryBrowserEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRepositoryBrowser_Repositories() {
		return (EReference) repositoryBrowserEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRepositoryReferences() {
		return repositoryReferencesEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRepositoryReferences_RepositoryReferences() {
		return (EReference) repositoryReferencesEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRequirements() {
		return requirementsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRequirements_Requirements() {
		return (EReference) requirementsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRequirementWrapper() {
		return requirementWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRequirementWrapper_Genuine() {
		return (EReference) requirementWrapperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTouchpoints() {
		return touchpointsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTouchpoints_TouchpointDataList() {
		return (EReference) touchpointsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTouchpoints_TouchpointType() {
		return (EReference) touchpointsEClass.getEStructuralFeatures().get(0);
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
		AggregatorPackage theAggregatorPackage = (AggregatorPackage) EPackage.Registry.INSTANCE
				.getEPackage(AggregatorPackage.eNS_URI);
		P2Package theP2Package = (P2Package) EPackage.Registry.INSTANCE.getEPackage(P2Package.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE
				.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		bundleEClass.getESuperTypes().add(this.getIUPresentationWithDetails());
		EGenericType g1 = createEGenericType(theAggregatorPackage.getChildrenProvider());
		EGenericType g2 = createEGenericType(this.getBundle());
		g1.getETypeArguments().add(g2);
		bundlesEClass.getEGenericSuperTypes().add(g1);
		categoryEClass.getESuperTypes().add(this.getIUPresentation());
		g1 = createEGenericType(theAggregatorPackage.getChildrenProvider());
		g2 = createEGenericType(this.getCategory());
		g1.getETypeArguments().add(g2);
		categoriesEClass.getEGenericSuperTypes().add(g1);
		featureEClass.getESuperTypes().add(this.getIUPresentationWithDetails());
		g1 = createEGenericType(theAggregatorPackage.getChildrenProvider());
		g2 = createEGenericType(this.getFeature());
		g1.getETypeArguments().add(g2);
		featuresEClass.getEGenericSuperTypes().add(g1);
		fragmentEClass.getESuperTypes().add(this.getBundle());
		g1 = createEGenericType(theAggregatorPackage.getChildrenProvider());
		g2 = createEGenericType(this.getFragment());
		g1.getETypeArguments().add(g2);
		fragmentsEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theAggregatorPackage.getChildrenProvider());
		g2 = createEGenericType(ecorePackage.getEObject());
		g1.getETypeArguments().add(g2);
		installableUnitsEClass.getEGenericSuperTypes().add(g1);
		iuPresentationWithDetailsEClass.getESuperTypes().add(this.getIUPresentation());
		iuPresentationWithDetailsEClass.getESuperTypes().add(this.getIUDetails());
		g1 = createEGenericType(theAggregatorPackage.getStatusProvider());
		repositoryBrowserEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theAggregatorPackage.getChildrenProvider());
		g2 = createEGenericType(this.getMetadataRepositoryStructuredView());
		g1.getETypeArguments().add(g2);
		repositoryBrowserEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theAggregatorPackage.getChildrenProvider());
		g2 = createEGenericType(this.getInstallableUnits());
		g1.getETypeArguments().add(g2);
		metadataRepositoryStructuredViewEClass.getEGenericSuperTypes().add(g1);
		g1 = createEGenericType(theAggregatorPackage.getChildrenProvider());
		g2 = createEGenericType(this.getOtherIU());
		g1.getETypeArguments().add(g2);
		miscellaneousEClass.getEGenericSuperTypes().add(g1);
		otherIUEClass.getESuperTypes().add(this.getIUPresentationWithDetails());
		productEClass.getESuperTypes().add(this.getIUPresentationWithDetails());
		g1 = createEGenericType(theAggregatorPackage.getChildrenProvider());
		g2 = createEGenericType(this.getProduct());
		g1.getETypeArguments().add(g2);
		productsEClass.getEGenericSuperTypes().add(g1);
		providedCapabilityWrapperEClass.getESuperTypes().add(theP2Package.getIProvidedCapability());
		providedCapabilityWrapperEClass.getESuperTypes().add(theAggregatorPackage.getLabelProvider());
		g1 = createEGenericType(theAggregatorPackage.getChildrenProvider());
		g2 = createEGenericType(theP2Package.getIRepositoryReference());
		g1.getETypeArguments().add(g2);
		repositoryReferencesEClass.getEGenericSuperTypes().add(g1);
		requirementWrapperEClass.getESuperTypes().add(theP2Package.getIRequirement());
		requirementWrapperEClass.getESuperTypes().add(theAggregatorPackage.getLabelProvider());

		// Initialize classes and features; add operations and parameters
		initEClass(bundleEClass, Bundle.class, "Bundle", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bundlesEClass, Bundles.class, "Bundles", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBundles_Bundles(), this.getBundle(), null, "bundles", null, 0, -1, Bundles.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(categoryEClass, Category.class, "Category", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCategory_CategoryContainer(), this.getCategories(), null, "categoryContainer", null, 0, 1,
				Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCategory_FeatureContainer(), this.getFeatures(), null, "featureContainer", null, 0, 1,
				Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCategory_ProductContainer(), this.getProducts(), null, "productContainer", null, 0, 1,
				Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCategory_BundleContainer(), this.getBundles(), null, "bundleContainer", null, 0, 1,
				Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCategory_FragmentContainer(), this.getFragments(), null, "fragmentContainer", null, 0, 1,
				Category.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCategory_IuDetails(), this.getIUDetails(), null, "iuDetails", null, 0, 1, Category.class,
				!IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(categoryEClass, this.getCategories(), "getNotNullCategoryContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(categoryEClass, this.getFeatures(), "getNotNullFeatureContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(categoryEClass, this.getProducts(), "getNotNullProductContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(categoryEClass, this.getBundles(), "getNotNullBundleContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(categoryEClass, this.getFragments(), "getNotNullFragmentContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(categoryEClass, ecorePackage.getEBoolean(), "isNested", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(categoriesEClass, Categories.class, "Categories", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCategories_Categories(), this.getCategory(), null, "categories", null, 0, -1,
				Categories.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(featureEClass, Feature.class, "Feature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeature_FeatureContainer(), this.getFeatures(), null, "featureContainer", null, 0, 1,
				Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_BundleContainer(), this.getBundles(), null, "bundleContainer", null, 0, 1,
				Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFeature_FragmentContainer(), this.getFragments(), null, "fragmentContainer", null, 0, 1,
				Feature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(featureEClass, this.getFeatures(), "getNotNullFeatureContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(featureEClass, this.getBundles(), "getNotNullBundleContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(featureEClass, this.getFragments(), "getNotNullFragmentContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(featuresEClass, Features.class, "Features", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFeatures_Features(), this.getFeature(), null, "features", null, 0, -1, Features.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fragmentEClass, Fragment.class, "Fragment", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(fragmentsEClass, Fragments.class, "Fragments", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFragments_Fragments(), this.getFragment(), null, "fragments", null, 0, -1, Fragments.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(installableUnitsEClass, InstallableUnits.class, "InstallableUnits", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInstallableUnits_AllIUs(), this.getIUPresentation(), null, "allIUs", null, 0, -1,
				InstallableUnits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstallableUnits_CategoryContainer(), this.getCategories(), null, "categoryContainer", null,
				0, 1, InstallableUnits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstallableUnits_FeatureContainer(), this.getFeatures(), null, "featureContainer", null, 0, 1,
				InstallableUnits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstallableUnits_ProductContainer(), this.getProducts(), null, "productContainer", null, 0, 1,
				InstallableUnits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstallableUnits_BundleContainer(), this.getBundles(), null, "bundleContainer", null, 0, 1,
				InstallableUnits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstallableUnits_FragmentContainer(), this.getFragments(), null, "fragmentContainer", null, 0,
				1, InstallableUnits.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInstallableUnits_MiscellaneousContainer(), this.getMiscellaneous(), null,
				"miscellaneousContainer", null, 0, 1, InstallableUnits.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(installableUnitsEClass, this.getCategories(), "getNotNullCategoryContainer", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		addEOperation(installableUnitsEClass, this.getFeatures(), "getNotNullFeatureContainer", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		addEOperation(installableUnitsEClass, this.getProducts(), "getNotNullProductContainer", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		addEOperation(installableUnitsEClass, this.getBundles(), "getNotNullBundleContainer", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		addEOperation(installableUnitsEClass, this.getFragments(), "getNotNullFragmentContainer", 0, 1, IS_UNIQUE,
				IS_ORDERED);

		addEOperation(installableUnitsEClass, this.getMiscellaneous(), "getNotNullMiscellaneousContainer", 0, 1,
				IS_UNIQUE, IS_ORDERED);

		initEClass(iuDetailsEClass, IUDetails.class, "IUDetails", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getIUDetails_RequirementsContainer(), this.getRequirements(), null, "requirementsContainer",
				null, 0, 1, IUDetails.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIUDetails_ProvidedCapabilitiesContainer(), this.getProvidedCapabilities(), null,
				"providedCapabilitiesContainer", null, 0, 1, IUDetails.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIUDetails_PropertiesContainer(), this.getProperties(), null, "propertiesContainer", null, 0,
				1, IUDetails.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIUDetails_TouchpointsContainer(), this.getTouchpoints(), null, "touchpointsContainer", null,
				0, 1, IUDetails.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIUDetails_UpdateDescriptor(), theP2Package.getIUpdateDescriptor(), null, "updateDescriptor",
				null, 0, 1, IUDetails.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIUDetails_Copyright(), theP2Package.getICopyright(), null, "copyright", null, 0, 1,
				IUDetails.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIUDetails_LicensesContainer(), this.getLicenses(), null, "licensesContainer", null, 0, 1,
				IUDetails.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iuPresentationEClass, IUPresentation.class, "IUPresentation", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIUPresentation_Id(), ecorePackage.getEString(), "id", null, 0, 1, IUPresentation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIUPresentation_Version(), theP2Package.getVersion(), "version", null, 0, 1,
				IUPresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getIUPresentation_Name(), ecorePackage.getEString(), "name", null, 0, 1, IUPresentation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIUPresentation_Label(), ecorePackage.getEString(), "label", null, 0, 1, IUPresentation.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIUPresentation_Description(), ecorePackage.getEString(), "description", null, 0, 1,
				IUPresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getIUPresentation_Type(), theAggregatorPackage.getInstallableUnitType(), "type", null, 1, 1,
				IUPresentation.class, !IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getIUPresentation_Filter(), ecorePackage.getEString(), "filter", null, 0, 1,
				IUPresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getIUPresentation_InstallableUnit(), theP2Package.getIInstallableUnit(), null, "installableUnit",
				null, 0, 1, IUPresentation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iuPresentationWithDetailsEClass, IUPresentationWithDetails.class, "IUPresentationWithDetails",
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIUPresentationWithDetails_DetailsResolved(), theXMLTypePackage.getBoolean(),
				"detailsResolved", null, 0, 1, IUPresentationWithDetails.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(licensesEClass, Licenses.class, "Licenses", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLicenses_Licenses(), theP2Package.getILicense(), null, "licenses", null, 0, -1,
				Licenses.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repositoryBrowserEClass, RepositoryBrowser.class, "RepositoryBrowser", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepositoryBrowser_Repositories(), this.getMetadataRepositoryStructuredView(), null,
				"repositories", null, 0, -1, RepositoryBrowser.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getRepositoryBrowser_Loading(), ecorePackage.getEBoolean(), "loading", "false", 0, 1,
				RepositoryBrowser.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);

		initEClass(metadataRepositoryStructuredViewEClass, MetadataRepositoryStructuredView.class,
				"MetadataRepositoryStructuredView", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetadataRepositoryStructuredView_Name(), ecorePackage.getEString(), "name", null, 0, 1,
				MetadataRepositoryStructuredView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetadataRepositoryStructuredView_InstallableUnitList(), this.getInstallableUnits(), null,
				"installableUnitList", null, 0, 1, MetadataRepositoryStructuredView.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetadataRepositoryStructuredView_Properties(), this.getProperties(), null, "properties", null,
				0, 1, MetadataRepositoryStructuredView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetadataRepositoryStructuredView_MetadataRepository(), theP2Package.getMetadataRepository(),
				null, "metadataRepository", null, 1, 1, MetadataRepositoryStructuredView.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEAttribute(getMetadataRepositoryStructuredView_Loaded(), ecorePackage.getEBoolean(), "loaded", null, 0, 1,
				MetadataRepositoryStructuredView.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetadataRepositoryStructuredView_RepositoryReferences(), this.getRepositoryReferences(), null,
				"repositoryReferences", null, 0, 1, MetadataRepositoryStructuredView.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetadataRepositoryStructuredView_Location(), theP2Package.getURI(), "location", null, 1, 1,
				MetadataRepositoryStructuredView.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE,
				!IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		initEClass(miscellaneousEClass, Miscellaneous.class, "Miscellaneous", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMiscellaneous_Others(), this.getOtherIU(), null, "others", null, 0, -1, Miscellaneous.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(otherIUEClass, OtherIU.class, "OtherIU", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(productEClass, Product.class, "Product", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProduct_FeatureContainer(), this.getFeatures(), null, "featureContainer", null, 0, 1,
				Product.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProduct_BundleContainer(), this.getBundles(), null, "bundleContainer", null, 0, 1,
				Product.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProduct_FragmentContainer(), this.getFragments(), null, "fragmentContainer", null, 0, 1,
				Product.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(productEClass, this.getFeatures(), "getNotNullFeatureContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(productEClass, this.getBundles(), "getNotNullBundleContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(productEClass, this.getFragments(), "getNotNullFragmentContainer", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(productsEClass, Products.class, "Products", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProducts_Products(), this.getProduct(), null, "products", null, 0, -1, Products.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(propertiesEClass, Properties.class, "Properties", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProperties_PropertyList(), theAggregatorPackage.getProperty(), null, "propertyList", null, 0,
				-1, Properties.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(providedCapabilitiesEClass, ProvidedCapabilities.class, "ProvidedCapabilities", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProvidedCapabilities_ProvidedCapabilities(), this.getProvidedCapabilityWrapper(), null,
				"providedCapabilities", null, 0, -1, ProvidedCapabilities.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(providedCapabilityWrapperEClass, ProvidedCapabilityWrapper.class, "ProvidedCapabilityWrapper",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProvidedCapabilityWrapper_Genuine(), theP2Package.getIProvidedCapability(), null, "genuine",
				null, 1, 1, ProvidedCapabilityWrapper.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(repositoryReferencesEClass, RepositoryReferences.class, "RepositoryReferences", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRepositoryReferences_RepositoryReferences(), theP2Package.getIRepositoryReference(), null,
				"repositoryReferences", null, 0, -1, RepositoryReferences.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requirementsEClass, Requirements.class, "Requirements", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequirements_Requirements(), this.getRequirementWrapper(), null, "requirements", null, 0, -1,
				Requirements.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(requirementWrapperEClass, RequirementWrapper.class, "RequirementWrapper", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequirementWrapper_Genuine(), theP2Package.getIRequirement(), null, "genuine", null, 1, 1,
				RequirementWrapper.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(touchpointsEClass, Touchpoints.class, "Touchpoints", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTouchpoints_TouchpointType(), theP2Package.getITouchpointType(), null, "touchpointType", null,
				0, 1, Touchpoints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTouchpoints_TouchpointDataList(), theP2Package.getITouchpointData(), null,
				"touchpointDataList", null, 0, -1, Touchpoints.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} // P2viewPackageImpl
