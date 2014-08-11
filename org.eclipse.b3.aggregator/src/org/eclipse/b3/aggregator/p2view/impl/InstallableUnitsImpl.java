/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 * $Id$
 */
package org.eclipse.b3.aggregator.p2view.impl;

import java.util.Collection;

import org.eclipse.b3.aggregator.p2view.Bundles;
import org.eclipse.b3.aggregator.p2view.Categories;
import org.eclipse.b3.aggregator.p2view.Features;
import org.eclipse.b3.aggregator.p2view.Fragments;
import org.eclipse.b3.aggregator.p2view.IUPresentation;
import org.eclipse.b3.aggregator.p2view.InstallableUnits;
import org.eclipse.b3.aggregator.p2view.Miscellaneous;
import org.eclipse.b3.aggregator.p2view.P2viewFactory;
import org.eclipse.b3.aggregator.p2view.P2viewPackage;
import org.eclipse.b3.aggregator.p2view.Products;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Installable Units</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.b3.aggregator.p2view.impl.InstallableUnitsImpl#getCategoryContainer <em>Category Container </em>}</li>
 * <li>{@link org.eclipse.b3.aggregator.p2view.impl.InstallableUnitsImpl#getFeatureContainer <em>Feature Container</em>}</li>
 * <li>{@link org.eclipse.b3.aggregator.p2view.impl.InstallableUnitsImpl#getProductContainer <em>Product Container</em>}</li>
 * <li>{@link org.eclipse.b3.aggregator.p2view.impl.InstallableUnitsImpl#getBundleContainer <em>Bundle Container</em>}</li>
 * <li>{@link org.eclipse.b3.aggregator.p2view.impl.InstallableUnitsImpl#getMiscellaneousContainer <em> Miscellaneous Container</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstallableUnitsImpl extends MinimalEObjectImpl.Container implements InstallableUnits {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getAllIUs() <em>All IUs</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @see #getAllIUs()
	 * @generated
	 * @ordered
	 */
	protected EList<IUPresentation> allIUs;

	/**
	 * The cached value of the '{@link #getCategoryContainer() <em>Category Container</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getCategoryContainer()
	 * @generated
	 * @ordered
	 */
	protected Categories categoryContainer;

	/**
	 * The cached value of the '{@link #getFeatureContainer() <em>Feature Container</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getFeatureContainer()
	 * @generated
	 * @ordered
	 */
	protected Features featureContainer;

	/**
	 * The cached value of the '{@link #getProductContainer() <em>Product Container</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getProductContainer()
	 * @generated
	 * @ordered
	 */
	protected Products productContainer;

	/**
	 * The cached value of the '{@link #getBundleContainer() <em>Bundle Container</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 *
	 * @see #getBundleContainer()
	 * @generated
	 * @ordered
	 */
	protected Bundles bundleContainer;

	/**
	 * The cached value of the '{@link #getFragmentContainer() <em>Fragment Container</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getFragmentContainer()
	 * @generated
	 * @ordered
	 */
	protected Fragments fragmentContainer;

	/**
	 * The cached value of the '{@link #getMiscellaneousContainer() <em>Miscellaneous Container</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getMiscellaneousContainer()
	 * @generated
	 * @ordered
	 */
	protected Miscellaneous miscellaneousContainer;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected InstallableUnitsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Bundles basicGetBundleContainer() {
		return bundleContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Categories basicGetCategoryContainer() {
		return categoryContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Features basicGetFeatureContainer() {
		return featureContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Fragments basicGetFragmentContainer() {
		return fragmentContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Miscellaneous basicGetMiscellaneousContainer() {
		return miscellaneousContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Products basicGetProductContainer() {
		return productContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetBundleContainer(Bundles newBundleContainer, NotificationChain msgs) {
		Bundles oldBundleContainer = bundleContainer;
		bundleContainer = newBundleContainer;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, P2viewPackage.INSTALLABLE_UNITS__BUNDLE_CONTAINER, oldBundleContainer,
				newBundleContainer);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetCategoryContainer(Categories newCategoryContainer, NotificationChain msgs) {
		Categories oldCategoryContainer = categoryContainer;
		categoryContainer = newCategoryContainer;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, P2viewPackage.INSTALLABLE_UNITS__CATEGORY_CONTAINER, oldCategoryContainer,
				newCategoryContainer);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetFeatureContainer(Features newFeatureContainer, NotificationChain msgs) {
		Features oldFeatureContainer = featureContainer;
		featureContainer = newFeatureContainer;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, P2viewPackage.INSTALLABLE_UNITS__FEATURE_CONTAINER, oldFeatureContainer,
				newFeatureContainer);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetFragmentContainer(Fragments newFragmentContainer, NotificationChain msgs) {
		Fragments oldFragmentContainer = fragmentContainer;
		fragmentContainer = newFragmentContainer;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, P2viewPackage.INSTALLABLE_UNITS__FRAGMENT_CONTAINER, oldFragmentContainer,
				newFragmentContainer);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetMiscellaneousContainer(Miscellaneous newMiscellaneousContainer,
			NotificationChain msgs) {
		Miscellaneous oldMiscellaneousContainer = miscellaneousContainer;
		miscellaneousContainer = newMiscellaneousContainer;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, P2viewPackage.INSTALLABLE_UNITS__MISCELLANEOUS_CONTAINER,
				oldMiscellaneousContainer, newMiscellaneousContainer);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public NotificationChain basicSetProductContainer(Products newProductContainer, NotificationChain msgs) {
		Products oldProductContainer = productContainer;
		productContainer = newProductContainer;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(
				this, Notification.SET, P2viewPackage.INSTALLABLE_UNITS__PRODUCT_CONTAINER, oldProductContainer,
				newProductContainer);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
			case P2viewPackage.INSTALLABLE_UNITS__CHILDREN:
				return getChildren();
			case P2viewPackage.INSTALLABLE_UNITS__ALL_IUS:
				return getAllIUs();
			case P2viewPackage.INSTALLABLE_UNITS__CATEGORY_CONTAINER:
				if(resolve)
					return getCategoryContainer();
				return basicGetCategoryContainer();
			case P2viewPackage.INSTALLABLE_UNITS__FEATURE_CONTAINER:
				if(resolve)
					return getFeatureContainer();
				return basicGetFeatureContainer();
			case P2viewPackage.INSTALLABLE_UNITS__PRODUCT_CONTAINER:
				if(resolve)
					return getProductContainer();
				return basicGetProductContainer();
			case P2viewPackage.INSTALLABLE_UNITS__BUNDLE_CONTAINER:
				if(resolve)
					return getBundleContainer();
				return basicGetBundleContainer();
			case P2viewPackage.INSTALLABLE_UNITS__FRAGMENT_CONTAINER:
				if(resolve)
					return getFragmentContainer();
				return basicGetFragmentContainer();
			case P2viewPackage.INSTALLABLE_UNITS__MISCELLANEOUS_CONTAINER:
				if(resolve)
					return getMiscellaneousContainer();
				return basicGetMiscellaneousContainer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
			case P2viewPackage.INSTALLABLE_UNITS__ALL_IUS:
				return ((InternalEList<?>) getAllIUs()).basicRemove(otherEnd, msgs);
			case P2viewPackage.INSTALLABLE_UNITS__CATEGORY_CONTAINER:
				return basicSetCategoryContainer(null, msgs);
			case P2viewPackage.INSTALLABLE_UNITS__FEATURE_CONTAINER:
				return basicSetFeatureContainer(null, msgs);
			case P2viewPackage.INSTALLABLE_UNITS__PRODUCT_CONTAINER:
				return basicSetProductContainer(null, msgs);
			case P2viewPackage.INSTALLABLE_UNITS__BUNDLE_CONTAINER:
				return basicSetBundleContainer(null, msgs);
			case P2viewPackage.INSTALLABLE_UNITS__FRAGMENT_CONTAINER:
				return basicSetFragmentContainer(null, msgs);
			case P2viewPackage.INSTALLABLE_UNITS__MISCELLANEOUS_CONTAINER:
				return basicSetMiscellaneousContainer(null, msgs);
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
			case P2viewPackage.INSTALLABLE_UNITS__CHILDREN:
				return !getChildren().isEmpty();
			case P2viewPackage.INSTALLABLE_UNITS__ALL_IUS:
				return allIUs != null && !allIUs.isEmpty();
			case P2viewPackage.INSTALLABLE_UNITS__CATEGORY_CONTAINER:
				return categoryContainer != null;
			case P2viewPackage.INSTALLABLE_UNITS__FEATURE_CONTAINER:
				return featureContainer != null;
			case P2viewPackage.INSTALLABLE_UNITS__PRODUCT_CONTAINER:
				return productContainer != null;
			case P2viewPackage.INSTALLABLE_UNITS__BUNDLE_CONTAINER:
				return bundleContainer != null;
			case P2viewPackage.INSTALLABLE_UNITS__FRAGMENT_CONTAINER:
				return fragmentContainer != null;
			case P2viewPackage.INSTALLABLE_UNITS__MISCELLANEOUS_CONTAINER:
				return miscellaneousContainer != null;
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
			case P2viewPackage.INSTALLABLE_UNITS__ALL_IUS:
				getAllIUs().clear();
				getAllIUs().addAll((Collection<? extends IUPresentation>) newValue);
				return;
			case P2viewPackage.INSTALLABLE_UNITS__CATEGORY_CONTAINER:
				setCategoryContainer((Categories) newValue);
				return;
			case P2viewPackage.INSTALLABLE_UNITS__FEATURE_CONTAINER:
				setFeatureContainer((Features) newValue);
				return;
			case P2viewPackage.INSTALLABLE_UNITS__PRODUCT_CONTAINER:
				setProductContainer((Products) newValue);
				return;
			case P2viewPackage.INSTALLABLE_UNITS__BUNDLE_CONTAINER:
				setBundleContainer((Bundles) newValue);
				return;
			case P2viewPackage.INSTALLABLE_UNITS__FRAGMENT_CONTAINER:
				setFragmentContainer((Fragments) newValue);
				return;
			case P2viewPackage.INSTALLABLE_UNITS__MISCELLANEOUS_CONTAINER:
				setMiscellaneousContainer((Miscellaneous) newValue);
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
		return P2viewPackage.Literals.INSTALLABLE_UNITS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
			case P2viewPackage.INSTALLABLE_UNITS__ALL_IUS:
				getAllIUs().clear();
				return;
			case P2viewPackage.INSTALLABLE_UNITS__CATEGORY_CONTAINER:
				setCategoryContainer((Categories) null);
				return;
			case P2viewPackage.INSTALLABLE_UNITS__FEATURE_CONTAINER:
				setFeatureContainer((Features) null);
				return;
			case P2viewPackage.INSTALLABLE_UNITS__PRODUCT_CONTAINER:
				setProductContainer((Products) null);
				return;
			case P2viewPackage.INSTALLABLE_UNITS__BUNDLE_CONTAINER:
				setBundleContainer((Bundles) null);
				return;
			case P2viewPackage.INSTALLABLE_UNITS__FRAGMENT_CONTAINER:
				setFragmentContainer((Fragments) null);
				return;
			case P2viewPackage.INSTALLABLE_UNITS__MISCELLANEOUS_CONTAINER:
				setMiscellaneousContainer((Miscellaneous) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public EList<IUPresentation> getAllIUs() {
		if(allIUs == null) {
			allIUs = new EObjectContainmentEList.Resolving<IUPresentation>(
				IUPresentation.class, this, P2viewPackage.INSTALLABLE_UNITS__ALL_IUS);
		}
		return allIUs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Bundles getBundleContainer() {
		if(bundleContainer != null && ((EObject) bundleContainer).eIsProxy()) {
			InternalEObject oldBundleContainer = (InternalEObject) bundleContainer;
			bundleContainer = (Bundles) eResolveProxy(oldBundleContainer);
			if(bundleContainer != oldBundleContainer) {
				InternalEObject newBundleContainer = (InternalEObject) bundleContainer;
				NotificationChain msgs = oldBundleContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__BUNDLE_CONTAINER, null, null);
				if(newBundleContainer.eInternalContainer() == null) {
					msgs = newBundleContainer.eInverseAdd(this, EOPPOSITE_FEATURE_BASE -
							P2viewPackage.INSTALLABLE_UNITS__BUNDLE_CONTAINER, null, msgs);
				}
				if(msgs != null)
					msgs.dispatch();
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(
						this, Notification.RESOLVE, P2viewPackage.INSTALLABLE_UNITS__BUNDLE_CONTAINER,
						oldBundleContainer, bundleContainer));
			}
		}
		return bundleContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Categories getCategoryContainer() {
		if(categoryContainer != null && ((EObject) categoryContainer).eIsProxy()) {
			InternalEObject oldCategoryContainer = (InternalEObject) categoryContainer;
			categoryContainer = (Categories) eResolveProxy(oldCategoryContainer);
			if(categoryContainer != oldCategoryContainer) {
				InternalEObject newCategoryContainer = (InternalEObject) categoryContainer;
				NotificationChain msgs = oldCategoryContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__CATEGORY_CONTAINER, null, null);
				if(newCategoryContainer.eInternalContainer() == null) {
					msgs = newCategoryContainer.eInverseAdd(this, EOPPOSITE_FEATURE_BASE -
							P2viewPackage.INSTALLABLE_UNITS__CATEGORY_CONTAINER, null, msgs);
				}
				if(msgs != null)
					msgs.dispatch();
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(
						this, Notification.RESOLVE, P2viewPackage.INSTALLABLE_UNITS__CATEGORY_CONTAINER,
						oldCategoryContainer, categoryContainer));
			}
		}
		return categoryContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public EList<EObject> getChildren() {
		EList<EObject> children = new BasicEList<EObject>();

		if(getCategoryContainer() != null)
			children.add((EObject) getCategoryContainer());
		if(getFeatureContainer() != null)
			children.add((EObject) getFeatureContainer());
		if(getProductContainer() != null)
			children.add((EObject) getProductContainer());
		if(getBundleContainer() != null)
			children.add((EObject) getBundleContainer());
		if(getFragmentContainer() != null)
			children.add((EObject) getFragmentContainer());
		if(getMiscellaneousContainer() != null)
			children.add((EObject) getMiscellaneousContainer());

		return children;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Features getFeatureContainer() {
		if(featureContainer != null && ((EObject) featureContainer).eIsProxy()) {
			InternalEObject oldFeatureContainer = (InternalEObject) featureContainer;
			featureContainer = (Features) eResolveProxy(oldFeatureContainer);
			if(featureContainer != oldFeatureContainer) {
				InternalEObject newFeatureContainer = (InternalEObject) featureContainer;
				NotificationChain msgs = oldFeatureContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__FEATURE_CONTAINER, null, null);
				if(newFeatureContainer.eInternalContainer() == null) {
					msgs = newFeatureContainer.eInverseAdd(this, EOPPOSITE_FEATURE_BASE -
							P2viewPackage.INSTALLABLE_UNITS__FEATURE_CONTAINER, null, msgs);
				}
				if(msgs != null)
					msgs.dispatch();
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(
						this, Notification.RESOLVE, P2viewPackage.INSTALLABLE_UNITS__FEATURE_CONTAINER,
						oldFeatureContainer, featureContainer));
			}
		}
		return featureContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Fragments getFragmentContainer() {
		if(fragmentContainer != null && ((EObject) fragmentContainer).eIsProxy()) {
			InternalEObject oldFragmentContainer = (InternalEObject) fragmentContainer;
			fragmentContainer = (Fragments) eResolveProxy(oldFragmentContainer);
			if(fragmentContainer != oldFragmentContainer) {
				InternalEObject newFragmentContainer = (InternalEObject) fragmentContainer;
				NotificationChain msgs = oldFragmentContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__FRAGMENT_CONTAINER, null, null);
				if(newFragmentContainer.eInternalContainer() == null) {
					msgs = newFragmentContainer.eInverseAdd(this, EOPPOSITE_FEATURE_BASE -
							P2viewPackage.INSTALLABLE_UNITS__FRAGMENT_CONTAINER, null, msgs);
				}
				if(msgs != null)
					msgs.dispatch();
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(
						this, Notification.RESOLVE, P2viewPackage.INSTALLABLE_UNITS__FRAGMENT_CONTAINER,
						oldFragmentContainer, fragmentContainer));
			}
		}
		return fragmentContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Miscellaneous getMiscellaneousContainer() {
		if(miscellaneousContainer != null && ((EObject) miscellaneousContainer).eIsProxy()) {
			InternalEObject oldMiscellaneousContainer = (InternalEObject) miscellaneousContainer;
			miscellaneousContainer = (Miscellaneous) eResolveProxy(oldMiscellaneousContainer);
			if(miscellaneousContainer != oldMiscellaneousContainer) {
				InternalEObject newMiscellaneousContainer = (InternalEObject) miscellaneousContainer;
				NotificationChain msgs = oldMiscellaneousContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__MISCELLANEOUS_CONTAINER, null, null);
				if(newMiscellaneousContainer.eInternalContainer() == null) {
					msgs = newMiscellaneousContainer.eInverseAdd(this, EOPPOSITE_FEATURE_BASE -
							P2viewPackage.INSTALLABLE_UNITS__MISCELLANEOUS_CONTAINER, null, msgs);
				}
				if(msgs != null)
					msgs.dispatch();
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(
						this, Notification.RESOLVE, P2viewPackage.INSTALLABLE_UNITS__MISCELLANEOUS_CONTAINER,
						oldMiscellaneousContainer, miscellaneousContainer));
			}
		}
		return miscellaneousContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public Bundles getNotNullBundleContainer() {
		if(bundleContainer == null)
			setBundleContainer(P2viewFactory.eINSTANCE.createBundles());

		return getBundleContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public Categories getNotNullCategoryContainer() {
		if(categoryContainer == null)
			setCategoryContainer(P2viewFactory.eINSTANCE.createCategories());

		return getCategoryContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public Features getNotNullFeatureContainer() {
		if(featureContainer == null)
			setFeatureContainer(P2viewFactory.eINSTANCE.createFeatures());

		return getFeatureContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public Fragments getNotNullFragmentContainer() {
		if(fragmentContainer == null)
			setFragmentContainer(P2viewFactory.eINSTANCE.createFragments());

		return getFragmentContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public Miscellaneous getNotNullMiscellaneousContainer() {
		if(miscellaneousContainer == null)
			setMiscellaneousContainer(P2viewFactory.eINSTANCE.createMiscellaneous());

		return getMiscellaneousContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public Products getNotNullProductContainer() {
		if(productContainer == null)
			setProductContainer(P2viewFactory.eINSTANCE.createProducts());

		return getProductContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public Products getProductContainer() {
		if(productContainer != null && ((EObject) productContainer).eIsProxy()) {
			InternalEObject oldProductContainer = (InternalEObject) productContainer;
			productContainer = (Products) eResolveProxy(oldProductContainer);
			if(productContainer != oldProductContainer) {
				InternalEObject newProductContainer = (InternalEObject) productContainer;
				NotificationChain msgs = oldProductContainer.eInverseRemove(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__PRODUCT_CONTAINER, null, null);
				if(newProductContainer.eInternalContainer() == null) {
					msgs = newProductContainer.eInverseAdd(this, EOPPOSITE_FEATURE_BASE -
							P2viewPackage.INSTALLABLE_UNITS__PRODUCT_CONTAINER, null, msgs);
				}
				if(msgs != null)
					msgs.dispatch();
				if(eNotificationRequired())
					eNotify(new ENotificationImpl(
						this, Notification.RESOLVE, P2viewPackage.INSTALLABLE_UNITS__PRODUCT_CONTAINER,
						oldProductContainer, productContainer));
			}
		}
		return productContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setBundleContainer(Bundles newBundleContainer) {
		if(newBundleContainer != bundleContainer) {
			NotificationChain msgs = null;
			if(bundleContainer != null)
				msgs = ((InternalEObject) bundleContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__BUNDLE_CONTAINER, null, msgs);
			if(newBundleContainer != null)
				msgs = ((InternalEObject) newBundleContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__BUNDLE_CONTAINER, null, msgs);
			msgs = basicSetBundleContainer(newBundleContainer, msgs);
			if(msgs != null)
				msgs.dispatch();
		}
		else if(eNotificationRequired())
			eNotify(new ENotificationImpl(
				this, Notification.SET, P2viewPackage.INSTALLABLE_UNITS__BUNDLE_CONTAINER, newBundleContainer,
				newBundleContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setCategoryContainer(Categories newCategoryContainer) {
		if(newCategoryContainer != categoryContainer) {
			NotificationChain msgs = null;
			if(categoryContainer != null)
				msgs = ((InternalEObject) categoryContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__CATEGORY_CONTAINER, null, msgs);
			if(newCategoryContainer != null)
				msgs = ((InternalEObject) newCategoryContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__CATEGORY_CONTAINER, null, msgs);
			msgs = basicSetCategoryContainer(newCategoryContainer, msgs);
			if(msgs != null)
				msgs.dispatch();
		}
		else if(eNotificationRequired())
			eNotify(new ENotificationImpl(
				this, Notification.SET, P2viewPackage.INSTALLABLE_UNITS__CATEGORY_CONTAINER, newCategoryContainer,
				newCategoryContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setFeatureContainer(Features newFeatureContainer) {
		if(newFeatureContainer != featureContainer) {
			NotificationChain msgs = null;
			if(featureContainer != null)
				msgs = ((InternalEObject) featureContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__FEATURE_CONTAINER, null, msgs);
			if(newFeatureContainer != null)
				msgs = ((InternalEObject) newFeatureContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__FEATURE_CONTAINER, null, msgs);
			msgs = basicSetFeatureContainer(newFeatureContainer, msgs);
			if(msgs != null)
				msgs.dispatch();
		}
		else if(eNotificationRequired())
			eNotify(new ENotificationImpl(
				this, Notification.SET, P2viewPackage.INSTALLABLE_UNITS__FEATURE_CONTAINER, newFeatureContainer,
				newFeatureContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setFragmentContainer(Fragments newFragmentContainer) {
		if(newFragmentContainer != fragmentContainer) {
			NotificationChain msgs = null;
			if(fragmentContainer != null)
				msgs = ((InternalEObject) fragmentContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__FRAGMENT_CONTAINER, null, msgs);
			if(newFragmentContainer != null)
				msgs = ((InternalEObject) newFragmentContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__FRAGMENT_CONTAINER, null, msgs);
			msgs = basicSetFragmentContainer(newFragmentContainer, msgs);
			if(msgs != null)
				msgs.dispatch();
		}
		else if(eNotificationRequired())
			eNotify(new ENotificationImpl(
				this, Notification.SET, P2viewPackage.INSTALLABLE_UNITS__FRAGMENT_CONTAINER, newFragmentContainer,
				newFragmentContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setMiscellaneousContainer(Miscellaneous newMiscellaneousContainer) {
		if(newMiscellaneousContainer != miscellaneousContainer) {
			NotificationChain msgs = null;
			if(miscellaneousContainer != null)
				msgs = ((InternalEObject) miscellaneousContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__MISCELLANEOUS_CONTAINER, null, msgs);
			if(newMiscellaneousContainer != null)
				msgs = ((InternalEObject) newMiscellaneousContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__MISCELLANEOUS_CONTAINER, null, msgs);
			msgs = basicSetMiscellaneousContainer(newMiscellaneousContainer, msgs);
			if(msgs != null)
				msgs.dispatch();
		}
		else if(eNotificationRequired())
			eNotify(new ENotificationImpl(
				this, Notification.SET, P2viewPackage.INSTALLABLE_UNITS__MISCELLANEOUS_CONTAINER,
				newMiscellaneousContainer, newMiscellaneousContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public void setProductContainer(Products newProductContainer) {
		if(newProductContainer != productContainer) {
			NotificationChain msgs = null;
			if(productContainer != null)
				msgs = ((InternalEObject) productContainer).eInverseRemove(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__PRODUCT_CONTAINER, null, msgs);
			if(newProductContainer != null)
				msgs = ((InternalEObject) newProductContainer).eInverseAdd(this, EOPPOSITE_FEATURE_BASE -
						P2viewPackage.INSTALLABLE_UNITS__PRODUCT_CONTAINER, null, msgs);
			msgs = basicSetProductContainer(newProductContainer, msgs);
			if(msgs != null)
				msgs.dispatch();
		}
		else if(eNotificationRequired())
			eNotify(new ENotificationImpl(
				this, Notification.SET, P2viewPackage.INSTALLABLE_UNITS__PRODUCT_CONTAINER, newProductContainer,
				newProductContainer));
	}

} // InstallableUnitsImpl
