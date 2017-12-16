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

import org.eclipse.cbi.p2repo.aggregator.InstallableUnitType;
import org.eclipse.cbi.p2repo.aggregator.p2view.Bundles;
import org.eclipse.cbi.p2repo.aggregator.p2view.Features;
import org.eclipse.cbi.p2repo.aggregator.p2view.Fragments;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewFactory;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.cbi.p2repo.aggregator.p2view.Product;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Product</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.ProductImpl#getFeatureContainer <em>Feature Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.ProductImpl#getBundleContainer <em>Bundle Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.ProductImpl#getFragmentContainer <em>Fragment Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProductImpl extends IUPresentationWithDetailsImpl implements Product {
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
	 * The cached value of the '{@link #getBundleContainer() <em>Bundle Container</em>}' containment reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ProductImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected ProductImpl(IInstallableUnit iu) {
		super(iu);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Bundles basicGetBundleContainer() {
		return bundleContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Features basicGetFeatureContainer() {
		return featureContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Fragments basicGetFragmentContainer() {
		return fragmentContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBundleContainer(Bundles newBundleContainer, NotificationChain msgs) {
		Bundles oldBundleContainer = bundleContainer;
		bundleContainer = newBundleContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.PRODUCT__BUNDLE_CONTAINER, oldBundleContainer, newBundleContainer);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFeatureContainer(Features newFeatureContainer, NotificationChain msgs) {
		Features oldFeatureContainer = featureContainer;
		featureContainer = newFeatureContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.PRODUCT__FEATURE_CONTAINER, oldFeatureContainer, newFeatureContainer);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFragmentContainer(Fragments newFragmentContainer, NotificationChain msgs) {
		Fragments oldFragmentContainer = fragmentContainer;
		fragmentContainer = newFragmentContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.PRODUCT__FRAGMENT_CONTAINER, oldFragmentContainer, newFragmentContainer);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2viewPackage.PRODUCT__FEATURE_CONTAINER:
				if (resolve)
					return getFeatureContainer();
				return basicGetFeatureContainer();
			case P2viewPackage.PRODUCT__BUNDLE_CONTAINER:
				if (resolve)
					return getBundleContainer();
				return basicGetBundleContainer();
			case P2viewPackage.PRODUCT__FRAGMENT_CONTAINER:
				if (resolve)
					return getFragmentContainer();
				return basicGetFragmentContainer();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case P2viewPackage.PRODUCT__FEATURE_CONTAINER:
				return basicSetFeatureContainer(null, msgs);
			case P2viewPackage.PRODUCT__BUNDLE_CONTAINER:
				return basicSetBundleContainer(null, msgs);
			case P2viewPackage.PRODUCT__FRAGMENT_CONTAINER:
				return basicSetFragmentContainer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case P2viewPackage.PRODUCT__FEATURE_CONTAINER:
				return featureContainer != null;
			case P2viewPackage.PRODUCT__BUNDLE_CONTAINER:
				return bundleContainer != null;
			case P2viewPackage.PRODUCT__FRAGMENT_CONTAINER:
				return fragmentContainer != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case P2viewPackage.PRODUCT__FEATURE_CONTAINER:
				setFeatureContainer((Features) newValue);
				return;
			case P2viewPackage.PRODUCT__BUNDLE_CONTAINER:
				setBundleContainer((Bundles) newValue);
				return;
			case P2viewPackage.PRODUCT__FRAGMENT_CONTAINER:
				setFragmentContainer((Fragments) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return P2viewPackage.Literals.PRODUCT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2viewPackage.PRODUCT__FEATURE_CONTAINER:
				setFeatureContainer((Features) null);
				return;
			case P2viewPackage.PRODUCT__BUNDLE_CONTAINER:
				setBundleContainer((Bundles) null);
				return;
			case P2viewPackage.PRODUCT__FRAGMENT_CONTAINER:
				setFragmentContainer((Fragments) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Bundles getBundleContainer() {
		if (bundleContainer != null && ((EObject) bundleContainer).eIsProxy()) {
			InternalEObject oldBundleContainer = (InternalEObject) bundleContainer;
			bundleContainer = (Bundles) eResolveProxy(oldBundleContainer);
			if (bundleContainer != oldBundleContainer) {
				InternalEObject newBundleContainer = (InternalEObject) bundleContainer;
				NotificationChain msgs = oldBundleContainer.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.PRODUCT__BUNDLE_CONTAINER, null, null);
				if (newBundleContainer.eInternalContainer() == null) {
					msgs = newBundleContainer.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE - P2viewPackage.PRODUCT__BUNDLE_CONTAINER, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, P2viewPackage.PRODUCT__BUNDLE_CONTAINER,
							oldBundleContainer, bundleContainer));
			}
		}
		return bundleContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Features getFeatureContainer() {
		if (featureContainer != null && ((EObject) featureContainer).eIsProxy()) {
			InternalEObject oldFeatureContainer = (InternalEObject) featureContainer;
			featureContainer = (Features) eResolveProxy(oldFeatureContainer);
			if (featureContainer != oldFeatureContainer) {
				InternalEObject newFeatureContainer = (InternalEObject) featureContainer;
				NotificationChain msgs = oldFeatureContainer.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.PRODUCT__FEATURE_CONTAINER, null, null);
				if (newFeatureContainer.eInternalContainer() == null) {
					msgs = newFeatureContainer.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE - P2viewPackage.PRODUCT__FEATURE_CONTAINER, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, P2viewPackage.PRODUCT__FEATURE_CONTAINER,
							oldFeatureContainer, featureContainer));
			}
		}
		return featureContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Fragments getFragmentContainer() {
		if (fragmentContainer != null && ((EObject) fragmentContainer).eIsProxy()) {
			InternalEObject oldFragmentContainer = (InternalEObject) fragmentContainer;
			fragmentContainer = (Fragments) eResolveProxy(oldFragmentContainer);
			if (fragmentContainer != oldFragmentContainer) {
				InternalEObject newFragmentContainer = (InternalEObject) fragmentContainer;
				NotificationChain msgs = oldFragmentContainer.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.PRODUCT__FRAGMENT_CONTAINER, null, null);
				if (newFragmentContainer.eInternalContainer() == null) {
					msgs = newFragmentContainer.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE - P2viewPackage.PRODUCT__FRAGMENT_CONTAINER, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, P2viewPackage.PRODUCT__FRAGMENT_CONTAINER,
							oldFragmentContainer, fragmentContainer));
			}
		}
		return fragmentContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Bundles getNotNullBundleContainer() {
		if (bundleContainer == null)
			setBundleContainer(P2viewFactory.eINSTANCE.createBundles());

		return getBundleContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Features getNotNullFeatureContainer() {
		if (featureContainer == null)
			setFeatureContainer(P2viewFactory.eINSTANCE.createFeatures());

		return getFeatureContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Fragments getNotNullFragmentContainer() {
		if (fragmentContainer == null)
			setFragmentContainer(P2viewFactory.eINSTANCE.createFragments());

		return getFragmentContainer();
	}

	@Override
	public InstallableUnitType getType() {
		return InstallableUnitType.PRODUCT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBundleContainer(Bundles newBundleContainer) {
		if (newBundleContainer != bundleContainer) {
			NotificationChain msgs = null;
			if (bundleContainer != null)
				msgs = ((InternalEObject) bundleContainer).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.PRODUCT__BUNDLE_CONTAINER, null, msgs);
			if (newBundleContainer != null)
				msgs = ((InternalEObject) newBundleContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.PRODUCT__BUNDLE_CONTAINER, null, msgs);
			msgs = basicSetBundleContainer(newBundleContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.PRODUCT__BUNDLE_CONTAINER,
					newBundleContainer, newBundleContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFeatureContainer(Features newFeatureContainer) {
		if (newFeatureContainer != featureContainer) {
			NotificationChain msgs = null;
			if (featureContainer != null)
				msgs = ((InternalEObject) featureContainer).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.PRODUCT__FEATURE_CONTAINER, null, msgs);
			if (newFeatureContainer != null)
				msgs = ((InternalEObject) newFeatureContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.PRODUCT__FEATURE_CONTAINER, null, msgs);
			msgs = basicSetFeatureContainer(newFeatureContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.PRODUCT__FEATURE_CONTAINER,
					newFeatureContainer, newFeatureContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFragmentContainer(Fragments newFragmentContainer) {
		if (newFragmentContainer != fragmentContainer) {
			NotificationChain msgs = null;
			if (fragmentContainer != null)
				msgs = ((InternalEObject) fragmentContainer).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.PRODUCT__FRAGMENT_CONTAINER, null, msgs);
			if (newFragmentContainer != null)
				msgs = ((InternalEObject) newFragmentContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.PRODUCT__FRAGMENT_CONTAINER, null, msgs);
			msgs = basicSetFragmentContainer(newFragmentContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.PRODUCT__FRAGMENT_CONTAINER,
					newFragmentContainer, newFragmentContainer));
	}

} // ProductImpl
