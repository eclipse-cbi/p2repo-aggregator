/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.b3.aggregator.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.b3.aggregator.Aggregation;
import org.eclipse.b3.aggregator.AggregatorFactory;
import org.eclipse.b3.aggregator.AggregatorPackage;
import org.eclipse.b3.aggregator.Bundle;
import org.eclipse.b3.aggregator.Category;
import org.eclipse.b3.aggregator.Contribution;
import org.eclipse.b3.aggregator.DescriptionProvider;
import org.eclipse.b3.aggregator.Feature;
import org.eclipse.b3.aggregator.IdentificationProvider;
import org.eclipse.b3.aggregator.MapRule;
import org.eclipse.b3.aggregator.MappedRepository;
import org.eclipse.b3.aggregator.MappedUnit;
import org.eclipse.b3.aggregator.Product;
import org.eclipse.b3.aggregator.Status;
import org.eclipse.b3.aggregator.StatusCode;
import org.eclipse.b3.aggregator.util.GeneralUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Mapped Repository</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.b3.aggregator.impl.MappedRepositoryImpl#getProducts <em>Products</em>}</li>
 * <li>{@link org.eclipse.b3.aggregator.impl.MappedRepositoryImpl#getBundles <em>Bundles</em>}</li>
 * <li>{@link org.eclipse.b3.aggregator.impl.MappedRepositoryImpl#getFeatures <em>Features</em>}</li>
 * <li>{@link org.eclipse.b3.aggregator.impl.MappedRepositoryImpl#isMapVerbatim <em>Map Verbatim</em>}</li>
 * <li>{@link org.eclipse.b3.aggregator.impl.MappedRepositoryImpl#getMetadataRepository <em>Metadata Repository </em>}</li>
 * <li>{@link org.eclipse.b3.aggregator.impl.MappedRepositoryImpl#getCategories <em>Categories</em>}</li>
 * <li>{@link org.eclipse.b3.aggregator.impl.MappedRepositoryImpl#getLocation <em>Location</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class MappedRepositoryImpl extends MetadataRepositoryReferenceImpl implements MappedRepository {
	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = "";

	private static boolean hasMappedUnit(List<? extends MappedUnit> list) {
		return list != null && list.size() > 0;
	}

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getProducts() <em>Products</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getProducts()
	 * @generated
	 * @ordered
	 */
	protected EList<Product> products;

	/**
	 * The cached value of the '{@link #getBundles() <em>Bundles</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getBundles()
	 * @generated
	 * @ordered
	 */
	protected EList<Bundle> bundles;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;

	/**
	 * The cached value of the '{@link #getCategories() <em>Categories</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<Category> categories;

	/**
	 * The default value of the '{@link #isMirrorArtifacts() <em>Mirror Artifacts</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #isMirrorArtifacts()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MIRROR_ARTIFACTS_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isMirrorArtifacts() <em>Mirror Artifacts</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isMirrorArtifacts()
	 * @generated
	 * @ordered
	 */
	protected static final int MIRROR_ARTIFACTS_EFLAG = 1 << 1;

	/**
	 * The default value of the '{@link #getCategoryPrefix() <em>Category Prefix</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getCategoryPrefix()
	 * @generated
	 * @ordered
	 */
	protected static final String CATEGORY_PREFIX_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCategoryPrefix() <em>Category Prefix</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * @see #getCategoryPrefix()
	 * @generated
	 * @ordered
	 */
	protected String categoryPrefix = CATEGORY_PREFIX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMapRules() <em>Map Rules</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getMapRules()
	 * @generated
	 * @ordered
	 */
	protected EList<MapRule> mapRules;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected MappedRepositoryImpl() {
		super();
		eFlags |= MIRROR_ARTIFACTS_EFLAG;
	}

	public void addUnit(MappedUnit unit) {
		if(unit instanceof Feature)
			getFeatures().add((Feature) unit);
		else if(unit instanceof Category)
			getCategories().add((Category) unit);
		else if(unit instanceof Bundle)
			getBundles().add((Bundle) unit);
		else if(unit instanceof Product)
			getProducts().add((Product) unit);
		else
			throw new IllegalArgumentException("Unknown IU type");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if(baseClass == DescriptionProvider.class) {
			switch(derivedFeatureID) {
				case AggregatorPackage.MAPPED_REPOSITORY__DESCRIPTION:
					return AggregatorPackage.DESCRIPTION_PROVIDER__DESCRIPTION;
				default:
					return -1;
			}
		}
		if(baseClass == IdentificationProvider.class) {
			switch(derivedFeatureID) {
				default:
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if(baseClass == DescriptionProvider.class) {
			switch(baseFeatureID) {
				case AggregatorPackage.DESCRIPTION_PROVIDER__DESCRIPTION:
					return AggregatorPackage.MAPPED_REPOSITORY__DESCRIPTION;
				default:
					return -1;
			}
		}
		if(baseClass == IdentificationProvider.class) {
			switch(baseFeatureID) {
				default:
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
			case AggregatorPackage.MAPPED_REPOSITORY__DESCRIPTION:
				return getDescription();
			case AggregatorPackage.MAPPED_REPOSITORY__PRODUCTS:
				return getProducts();
			case AggregatorPackage.MAPPED_REPOSITORY__BUNDLES:
				return getBundles();
			case AggregatorPackage.MAPPED_REPOSITORY__FEATURES:
				return getFeatures();
			case AggregatorPackage.MAPPED_REPOSITORY__CATEGORIES:
				return getCategories();
			case AggregatorPackage.MAPPED_REPOSITORY__MIRROR_ARTIFACTS:
				return isMirrorArtifacts();
			case AggregatorPackage.MAPPED_REPOSITORY__CATEGORY_PREFIX:
				return getCategoryPrefix();
			case AggregatorPackage.MAPPED_REPOSITORY__MAP_RULES:
				return getMapRules();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
			case AggregatorPackage.MAPPED_REPOSITORY__PRODUCTS:
				return ((InternalEList<?>) getProducts()).basicRemove(otherEnd, msgs);
			case AggregatorPackage.MAPPED_REPOSITORY__BUNDLES:
				return ((InternalEList<?>) getBundles()).basicRemove(otherEnd, msgs);
			case AggregatorPackage.MAPPED_REPOSITORY__FEATURES:
				return ((InternalEList<?>) getFeatures()).basicRemove(otherEnd, msgs);
			case AggregatorPackage.MAPPED_REPOSITORY__CATEGORIES:
				return ((InternalEList<?>) getCategories()).basicRemove(otherEnd, msgs);
			case AggregatorPackage.MAPPED_REPOSITORY__MAP_RULES:
				return ((InternalEList<?>) getMapRules()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
			case AggregatorPackage.MAPPED_REPOSITORY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null
						? description != null
						: !DESCRIPTION_EDEFAULT.equals(description);
			case AggregatorPackage.MAPPED_REPOSITORY__PRODUCTS:
				return products != null && !products.isEmpty();
			case AggregatorPackage.MAPPED_REPOSITORY__BUNDLES:
				return bundles != null && !bundles.isEmpty();
			case AggregatorPackage.MAPPED_REPOSITORY__FEATURES:
				return features != null && !features.isEmpty();
			case AggregatorPackage.MAPPED_REPOSITORY__CATEGORIES:
				return categories != null && !categories.isEmpty();
			case AggregatorPackage.MAPPED_REPOSITORY__MIRROR_ARTIFACTS:
				return ((eFlags & MIRROR_ARTIFACTS_EFLAG) != 0) != MIRROR_ARTIFACTS_EDEFAULT;
			case AggregatorPackage.MAPPED_REPOSITORY__CATEGORY_PREFIX:
				return CATEGORY_PREFIX_EDEFAULT == null
						? categoryPrefix != null
						: !CATEGORY_PREFIX_EDEFAULT.equals(categoryPrefix);
			case AggregatorPackage.MAPPED_REPOSITORY__MAP_RULES:
				return mapRules != null && !mapRules.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
			case AggregatorPackage.MAPPED_REPOSITORY__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__PRODUCTS:
				getProducts().clear();
				getProducts().addAll((Collection<? extends Product>) newValue);
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__BUNDLES:
				getBundles().clear();
				getBundles().addAll((Collection<? extends Bundle>) newValue);
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>) newValue);
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__CATEGORIES:
				getCategories().clear();
				getCategories().addAll((Collection<? extends Category>) newValue);
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__MIRROR_ARTIFACTS:
				setMirrorArtifacts((Boolean) newValue);
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__CATEGORY_PREFIX:
				setCategoryPrefix((String) newValue);
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__MAP_RULES:
				getMapRules().clear();
				getMapRules().addAll((Collection<? extends MapRule>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AggregatorPackage.Literals.MAPPED_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
			case AggregatorPackage.MAPPED_REPOSITORY__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__PRODUCTS:
				getProducts().clear();
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__BUNDLES:
				getBundles().clear();
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__FEATURES:
				getFeatures().clear();
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__CATEGORIES:
				getCategories().clear();
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__MIRROR_ARTIFACTS:
				setMirrorArtifacts(MIRROR_ARTIFACTS_EDEFAULT);
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__CATEGORY_PREFIX:
				setCategoryPrefix(CATEGORY_PREFIX_EDEFAULT);
				return;
			case AggregatorPackage.MAPPED_REPOSITORY__MAP_RULES:
				getMapRules().clear();
				return;
		}
		super.eUnset(featureID);
	}

	@Override
	public Aggregation getAggregation() {
		return GeneralUtils.getAggregation(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Bundle> getBundles() {
		if(bundles == null) {
			bundles = new EObjectContainmentEList.Resolving<Bundle>(
				Bundle.class, this, AggregatorPackage.MAPPED_REPOSITORY__BUNDLES);
		}
		return bundles;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Category> getCategories() {
		if(categories == null) {
			categories = new EObjectContainmentEList.Resolving<Category>(
				Category.class, this, AggregatorPackage.MAPPED_REPOSITORY__CATEGORIES);
		}
		return categories;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getCategoryPrefix() {
		return categoryPrefix;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<MappedUnit> getEnabledUnits() {
		EList<Category> categories = getCategories();
		EList<Product> products = getProducts();
		EList<Feature> features = getFeatures();
		EList<Bundle> bundles = getBundles();
		EList<MappedUnit> units = new BasicEList<MappedUnit>(categories.size() + products.size() + features.size() +
				bundles.size());
		for(Category category : categories)
			if(category.isEnabled())
				units.add(category);
		for(Product product : products)
			if(product.isEnabled())
				units.add(product);
		for(Feature feature : features)
			if(feature.isEnabled())
				units.add(feature);
		for(Bundle bundle : bundles)
			if(bundle.isEnabled())
				units.add(bundle);
		return units;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Feature> getFeatures() {
		if(features == null) {
			features = new EObjectContainmentEList.Resolving<Feature>(
				Feature.class, this, AggregatorPackage.MAPPED_REPOSITORY__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public String getIdentification() {
		return getLocation();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<MapRule> getMapRules() {
		if(mapRules == null) {
			mapRules = new EObjectContainmentEList.Resolving<MapRule>(
				MapRule.class, this, AggregatorPackage.MAPPED_REPOSITORY__MAP_RULES);
		}
		return mapRules;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<MapRule> getMapRules(boolean enabledOnly) {
		EList<MapRule> mrules = getMapRules();
		if(enabledOnly)
			mrules = GeneralUtils.getEnabled(mrules);
		return mrules;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public EList<Product> getProducts() {
		if(products == null) {
			products = new EObjectContainmentEList.Resolving<Product>(
				Product.class, this, AggregatorPackage.MAPPED_REPOSITORY__PRODUCTS);
		}
		return products;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	synchronized public Status getStatus() {
		if(isBranchEnabled()) {
			Status status = super.getStatus();

			if(status.getCode() == StatusCode.OK) {
				for(MappedUnit unit : getEnabledUnits())
					if(unit.getStatus().getCode() != StatusCode.OK)
						return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN);
				for(MapRule rule : getMapRules())
					if(rule.getStatus().getCode() != StatusCode.OK)
						return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN);
			}

			return status;
		}

		return AggregatorFactory.eINSTANCE.createStatus(StatusCode.OK);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<MappedUnit> getUnits(boolean enabledOnly) {
		EList<Category> categories = getCategories();
		if(enabledOnly)
			categories = GeneralUtils.getEnabled(categories);
		EList<Product> products = getProducts();
		if(enabledOnly)
			products = GeneralUtils.getEnabled(products);
		EList<Feature> features = getFeatures();
		if(enabledOnly)
			features = GeneralUtils.getEnabled(features);
		EList<Bundle> bundles = getBundles();
		if(enabledOnly)
			bundles = GeneralUtils.getEnabled(bundles);

		EList<MappedUnit> units = new BasicEList<MappedUnit>(categories.size() + products.size() + features.size() +
				bundles.size());
		units.addAll(categories);
		units.addAll(products);
		units.addAll(features);
		units.addAll(bundles);
		return units;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public boolean isBranchEnabled() {
		return super.isBranchEnabled() && (eContainer() == null || ((Contribution) eContainer()).isEnabled());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean isMapExclusive() {
		return hasMappedUnit(bundles) || hasMappedUnit(features) || hasMappedUnit(categories) || hasMappedUnit(products);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean isMirrorArtifacts() {
		return (eFlags & MIRROR_ARTIFACTS_EFLAG) != 0;
	}

	public void removeUnit(MappedUnit unit) {
		if(unit instanceof Feature)
			getFeatures().remove(unit);
		else if(unit instanceof Category)
			getCategories().remove(unit);
		else if(unit instanceof Bundle)
			getBundles().remove(unit);
		else if(unit instanceof Product)
			getProducts().remove(unit);
		else
			throw new IllegalArgumentException("Unknown IU type");
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setCategoryPrefix(String newCategoryPrefix) {
		String oldCategoryPrefix = categoryPrefix;
		categoryPrefix = newCategoryPrefix;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(
				this, Notification.SET, AggregatorPackage.MAPPED_REPOSITORY__CATEGORY_PREFIX, oldCategoryPrefix,
				categoryPrefix));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(
				this, Notification.SET, AggregatorPackage.MAPPED_REPOSITORY__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setMirrorArtifacts(boolean newMirrorArtifacts) {
		boolean oldMirrorArtifacts = (eFlags & MIRROR_ARTIFACTS_EFLAG) != 0;
		if(newMirrorArtifacts)
			eFlags |= MIRROR_ARTIFACTS_EFLAG;
		else
			eFlags &= ~MIRROR_ARTIFACTS_EFLAG;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(
				this, Notification.SET, AggregatorPackage.MAPPED_REPOSITORY__MIRROR_ARTIFACTS, oldMirrorArtifacts,
				newMirrorArtifacts));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (description: ");
		result.append(description);
		result.append(", mirrorArtifacts: ");
		result.append((eFlags & MIRROR_ARTIFACTS_EFLAG) != 0);
		result.append(", categoryPrefix: ");
		result.append(categoryPrefix);
		result.append(')');
		return result.toString();
	}
} // MappedRepositoryImpl
