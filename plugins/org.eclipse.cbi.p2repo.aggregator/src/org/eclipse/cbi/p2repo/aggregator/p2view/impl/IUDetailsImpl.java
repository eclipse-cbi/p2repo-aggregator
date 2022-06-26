/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.p2view.impl;

import org.eclipse.cbi.p2repo.aggregator.p2view.IUDetails;
import org.eclipse.cbi.p2repo.aggregator.p2view.Licenses;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.cbi.p2repo.aggregator.p2view.Properties;
import org.eclipse.cbi.p2repo.aggregator.p2view.ProvidedCapabilities;
import org.eclipse.cbi.p2repo.aggregator.p2view.Requirements;
import org.eclipse.cbi.p2repo.aggregator.p2view.Touchpoints;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.equinox.p2.metadata.ICopyright;
import org.eclipse.equinox.p2.metadata.IUpdateDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>IU Details</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUDetailsImpl#getRequirementsContainer <em>Requirements Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUDetailsImpl#getProvidedCapabilitiesContainer <em>Provided Capabilities Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUDetailsImpl#getPropertiesContainer <em>Properties Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUDetailsImpl#getTouchpointsContainer <em>Touchpoints Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUDetailsImpl#getUpdateDescriptor <em>Update Descriptor</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUDetailsImpl#getCopyright <em>Copyright</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUDetailsImpl#getLicensesContainer <em>Licenses Container</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IUDetailsImpl extends MinimalEObjectImpl.Container implements IUDetails {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getRequirementsContainer() <em>Requirements Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementsContainer()
	 * @generated
	 * @ordered
	 */
	protected Requirements requirementsContainer;

	/**
	 * The cached value of the '{@link #getProvidedCapabilitiesContainer() <em>Provided Capabilities Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedCapabilitiesContainer()
	 * @generated
	 * @ordered
	 */
	protected ProvidedCapabilities providedCapabilitiesContainer;

	/**
	 * The cached value of the '{@link #getPropertiesContainer() <em>Properties Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertiesContainer()
	 * @generated
	 * @ordered
	 */
	protected Properties propertiesContainer;

	/**
	 * The cached value of the '{@link #getTouchpointsContainer() <em>Touchpoints Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTouchpointsContainer()
	 * @generated
	 * @ordered
	 */
	protected Touchpoints touchpointsContainer;

	/**
	 * The cached value of the '{@link #getUpdateDescriptor() <em>Update Descriptor</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdateDescriptor()
	 * @generated
	 * @ordered
	 */
	protected IUpdateDescriptor updateDescriptor;

	/**
	 * The cached value of the '{@link #getCopyright() <em>Copyright</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyright()
	 * @generated
	 * @ordered
	 */
	protected ICopyright copyright;

	/**
	 * The cached value of the '{@link #getLicensesContainer() <em>Licenses Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicensesContainer()
	 * @generated
	 * @ordered
	 */
	protected Licenses licensesContainer;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IUDetailsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCopyright(ICopyright newCopyright, NotificationChain msgs) {
		ICopyright oldCopyright = copyright;
		copyright = newCopyright;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_DETAILS__COPYRIGHT, oldCopyright, newCopyright);
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
	public NotificationChain basicSetLicensesContainer(Licenses newLicensesContainer, NotificationChain msgs) {
		Licenses oldLicensesContainer = licensesContainer;
		licensesContainer = newLicensesContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_DETAILS__LICENSES_CONTAINER, oldLicensesContainer, newLicensesContainer);
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
	public NotificationChain basicSetPropertiesContainer(Properties newPropertiesContainer, NotificationChain msgs) {
		Properties oldPropertiesContainer = propertiesContainer;
		propertiesContainer = newPropertiesContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_DETAILS__PROPERTIES_CONTAINER, oldPropertiesContainer, newPropertiesContainer);
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
	public NotificationChain basicSetProvidedCapabilitiesContainer(
			ProvidedCapabilities newProvidedCapabilitiesContainer, NotificationChain msgs) {
		ProvidedCapabilities oldProvidedCapabilitiesContainer = providedCapabilitiesContainer;
		providedCapabilitiesContainer = newProvidedCapabilitiesContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_DETAILS__PROVIDED_CAPABILITIES_CONTAINER, oldProvidedCapabilitiesContainer,
					newProvidedCapabilitiesContainer);
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
	public NotificationChain basicSetRequirementsContainer(Requirements newRequirementsContainer,
			NotificationChain msgs) {
		Requirements oldRequirementsContainer = requirementsContainer;
		requirementsContainer = newRequirementsContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_DETAILS__REQUIREMENTS_CONTAINER, oldRequirementsContainer,
					newRequirementsContainer);
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
	public NotificationChain basicSetTouchpointsContainer(Touchpoints newTouchpointsContainer, NotificationChain msgs) {
		Touchpoints oldTouchpointsContainer = touchpointsContainer;
		touchpointsContainer = newTouchpointsContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_DETAILS__TOUCHPOINTS_CONTAINER, oldTouchpointsContainer, newTouchpointsContainer);
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
	public NotificationChain basicSetUpdateDescriptor(IUpdateDescriptor newUpdateDescriptor, NotificationChain msgs) {
		IUpdateDescriptor oldUpdateDescriptor = updateDescriptor;
		updateDescriptor = newUpdateDescriptor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_DETAILS__UPDATE_DESCRIPTOR, oldUpdateDescriptor, newUpdateDescriptor);
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
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2viewPackage.IU_DETAILS__REQUIREMENTS_CONTAINER:
				return getRequirementsContainer();
			case P2viewPackage.IU_DETAILS__PROVIDED_CAPABILITIES_CONTAINER:
				return getProvidedCapabilitiesContainer();
			case P2viewPackage.IU_DETAILS__PROPERTIES_CONTAINER:
				return getPropertiesContainer();
			case P2viewPackage.IU_DETAILS__TOUCHPOINTS_CONTAINER:
				return getTouchpointsContainer();
			case P2viewPackage.IU_DETAILS__UPDATE_DESCRIPTOR:
				return getUpdateDescriptor();
			case P2viewPackage.IU_DETAILS__COPYRIGHT:
				return getCopyright();
			case P2viewPackage.IU_DETAILS__LICENSES_CONTAINER:
				return getLicensesContainer();
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
			case P2viewPackage.IU_DETAILS__REQUIREMENTS_CONTAINER:
				return basicSetRequirementsContainer(null, msgs);
			case P2viewPackage.IU_DETAILS__PROVIDED_CAPABILITIES_CONTAINER:
				return basicSetProvidedCapabilitiesContainer(null, msgs);
			case P2viewPackage.IU_DETAILS__PROPERTIES_CONTAINER:
				return basicSetPropertiesContainer(null, msgs);
			case P2viewPackage.IU_DETAILS__TOUCHPOINTS_CONTAINER:
				return basicSetTouchpointsContainer(null, msgs);
			case P2viewPackage.IU_DETAILS__UPDATE_DESCRIPTOR:
				return basicSetUpdateDescriptor(null, msgs);
			case P2viewPackage.IU_DETAILS__COPYRIGHT:
				return basicSetCopyright(null, msgs);
			case P2viewPackage.IU_DETAILS__LICENSES_CONTAINER:
				return basicSetLicensesContainer(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case P2viewPackage.IU_DETAILS__REQUIREMENTS_CONTAINER:
				return requirementsContainer != null;
			case P2viewPackage.IU_DETAILS__PROVIDED_CAPABILITIES_CONTAINER:
				return providedCapabilitiesContainer != null;
			case P2viewPackage.IU_DETAILS__PROPERTIES_CONTAINER:
				return propertiesContainer != null;
			case P2viewPackage.IU_DETAILS__TOUCHPOINTS_CONTAINER:
				return touchpointsContainer != null;
			case P2viewPackage.IU_DETAILS__UPDATE_DESCRIPTOR:
				return updateDescriptor != null;
			case P2viewPackage.IU_DETAILS__COPYRIGHT:
				return copyright != null;
			case P2viewPackage.IU_DETAILS__LICENSES_CONTAINER:
				return licensesContainer != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case P2viewPackage.IU_DETAILS__REQUIREMENTS_CONTAINER:
				setRequirementsContainer((Requirements) newValue);
				return;
			case P2viewPackage.IU_DETAILS__PROVIDED_CAPABILITIES_CONTAINER:
				setProvidedCapabilitiesContainer((ProvidedCapabilities) newValue);
				return;
			case P2viewPackage.IU_DETAILS__PROPERTIES_CONTAINER:
				setPropertiesContainer((Properties) newValue);
				return;
			case P2viewPackage.IU_DETAILS__TOUCHPOINTS_CONTAINER:
				setTouchpointsContainer((Touchpoints) newValue);
				return;
			case P2viewPackage.IU_DETAILS__UPDATE_DESCRIPTOR:
				setUpdateDescriptor((IUpdateDescriptor) newValue);
				return;
			case P2viewPackage.IU_DETAILS__COPYRIGHT:
				setCopyright((ICopyright) newValue);
				return;
			case P2viewPackage.IU_DETAILS__LICENSES_CONTAINER:
				setLicensesContainer((Licenses) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return P2viewPackage.Literals.IU_DETAILS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2viewPackage.IU_DETAILS__REQUIREMENTS_CONTAINER:
				setRequirementsContainer((Requirements) null);
				return;
			case P2viewPackage.IU_DETAILS__PROVIDED_CAPABILITIES_CONTAINER:
				setProvidedCapabilitiesContainer((ProvidedCapabilities) null);
				return;
			case P2viewPackage.IU_DETAILS__PROPERTIES_CONTAINER:
				setPropertiesContainer((Properties) null);
				return;
			case P2viewPackage.IU_DETAILS__TOUCHPOINTS_CONTAINER:
				setTouchpointsContainer((Touchpoints) null);
				return;
			case P2viewPackage.IU_DETAILS__UPDATE_DESCRIPTOR:
				setUpdateDescriptor((IUpdateDescriptor) null);
				return;
			case P2viewPackage.IU_DETAILS__COPYRIGHT:
				setCopyright((ICopyright) null);
				return;
			case P2viewPackage.IU_DETAILS__LICENSES_CONTAINER:
				setLicensesContainer((Licenses) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ICopyright getCopyright() {
		return copyright;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Licenses getLicensesContainer() {
		return licensesContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Properties getPropertiesContainer() {
		return propertiesContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ProvidedCapabilities getProvidedCapabilitiesContainer() {
		return providedCapabilitiesContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Requirements getRequirementsContainer() {
		return requirementsContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Touchpoints getTouchpointsContainer() {
		return touchpointsContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IUpdateDescriptor getUpdateDescriptor() {
		return updateDescriptor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCopyright(ICopyright newCopyright) {
		if (newCopyright != copyright) {
			NotificationChain msgs = null;
			if (copyright != null)
				msgs = ((InternalEObject) copyright).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__COPYRIGHT, null, msgs);
			if (newCopyright != null)
				msgs = ((InternalEObject) newCopyright).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__COPYRIGHT, null, msgs);
			msgs = basicSetCopyright(newCopyright, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_DETAILS__COPYRIGHT, newCopyright,
					newCopyright));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLicensesContainer(Licenses newLicensesContainer) {
		if (newLicensesContainer != licensesContainer) {
			NotificationChain msgs = null;
			if (licensesContainer != null)
				msgs = ((InternalEObject) licensesContainer).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__LICENSES_CONTAINER, null, msgs);
			if (newLicensesContainer != null)
				msgs = ((InternalEObject) newLicensesContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__LICENSES_CONTAINER, null, msgs);
			msgs = basicSetLicensesContainer(newLicensesContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_DETAILS__LICENSES_CONTAINER,
					newLicensesContainer, newLicensesContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPropertiesContainer(Properties newPropertiesContainer) {
		if (newPropertiesContainer != propertiesContainer) {
			NotificationChain msgs = null;
			if (propertiesContainer != null)
				msgs = ((InternalEObject) propertiesContainer).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__PROPERTIES_CONTAINER, null, msgs);
			if (newPropertiesContainer != null)
				msgs = ((InternalEObject) newPropertiesContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__PROPERTIES_CONTAINER, null, msgs);
			msgs = basicSetPropertiesContainer(newPropertiesContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_DETAILS__PROPERTIES_CONTAINER,
					newPropertiesContainer, newPropertiesContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProvidedCapabilitiesContainer(ProvidedCapabilities newProvidedCapabilitiesContainer) {
		if (newProvidedCapabilitiesContainer != providedCapabilitiesContainer) {
			NotificationChain msgs = null;
			if (providedCapabilitiesContainer != null)
				msgs = ((InternalEObject) providedCapabilitiesContainer).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__PROVIDED_CAPABILITIES_CONTAINER, null, msgs);
			if (newProvidedCapabilitiesContainer != null)
				msgs = ((InternalEObject) newProvidedCapabilitiesContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__PROVIDED_CAPABILITIES_CONTAINER, null, msgs);
			msgs = basicSetProvidedCapabilitiesContainer(newProvidedCapabilitiesContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_DETAILS__PROVIDED_CAPABILITIES_CONTAINER, newProvidedCapabilitiesContainer,
					newProvidedCapabilitiesContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequirementsContainer(Requirements newRequirementsContainer) {
		if (newRequirementsContainer != requirementsContainer) {
			NotificationChain msgs = null;
			if (requirementsContainer != null)
				msgs = ((InternalEObject) requirementsContainer).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__REQUIREMENTS_CONTAINER, null, msgs);
			if (newRequirementsContainer != null)
				msgs = ((InternalEObject) newRequirementsContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__REQUIREMENTS_CONTAINER, null, msgs);
			msgs = basicSetRequirementsContainer(newRequirementsContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_DETAILS__REQUIREMENTS_CONTAINER,
					newRequirementsContainer, newRequirementsContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTouchpointsContainer(Touchpoints newTouchpointsContainer) {
		if (newTouchpointsContainer != touchpointsContainer) {
			NotificationChain msgs = null;
			if (touchpointsContainer != null)
				msgs = ((InternalEObject) touchpointsContainer).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__TOUCHPOINTS_CONTAINER, null, msgs);
			if (newTouchpointsContainer != null)
				msgs = ((InternalEObject) newTouchpointsContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__TOUCHPOINTS_CONTAINER, null, msgs);
			msgs = basicSetTouchpointsContainer(newTouchpointsContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_DETAILS__TOUCHPOINTS_CONTAINER,
					newTouchpointsContainer, newTouchpointsContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUpdateDescriptor(IUpdateDescriptor newUpdateDescriptor) {
		if (newUpdateDescriptor != updateDescriptor) {
			NotificationChain msgs = null;
			if (updateDescriptor != null)
				msgs = ((InternalEObject) updateDescriptor).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__UPDATE_DESCRIPTOR, null, msgs);
			if (newUpdateDescriptor != null)
				msgs = ((InternalEObject) newUpdateDescriptor).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_DETAILS__UPDATE_DESCRIPTOR, null, msgs);
			msgs = basicSetUpdateDescriptor(newUpdateDescriptor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_DETAILS__UPDATE_DESCRIPTOR,
					newUpdateDescriptor, newUpdateDescriptor));
	}

} // IUDetailsImpl
