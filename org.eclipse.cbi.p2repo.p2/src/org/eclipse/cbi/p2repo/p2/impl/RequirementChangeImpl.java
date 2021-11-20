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
package org.eclipse.cbi.p2repo.p2.impl;

import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.p2.RequirementChange;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.equinox.internal.p2.metadata.IRequiredCapability;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement Change</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.RequirementChangeImpl#getApplyOn <em>Apply On</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.RequirementChangeImpl#getNewValue <em>New Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequirementChangeImpl extends MinimalEObjectImpl.Container implements RequirementChange {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getApplyOn() <em>Apply On</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getApplyOn()
	 * @generated
	 * @ordered
	 */
	protected IRequiredCapability applyOn;

	/**
	 * The cached value of the '{@link #getNewValue() <em>New Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNewValue()
	 * @generated
	 * @ordered
	 */
	protected IRequiredCapability newValue;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementChangeImpl() {
		super();
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public IRequiredCapability applyOn() {
		return getApplyOn();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRequiredCapability basicGetApplyOn() {
		return applyOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRequiredCapability basicGetNewValue() {
		return newValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetApplyOn(IRequiredCapability newApplyOn, NotificationChain msgs) {
		IRequiredCapability oldApplyOn = applyOn;
		applyOn = newApplyOn;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2Package.REQUIREMENT_CHANGE__APPLY_ON, oldApplyOn, newApplyOn);
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
	public NotificationChain basicSetNewValue(IRequiredCapability newNewValue, NotificationChain msgs) {
		IRequiredCapability oldNewValue = newValue;
		newValue = newNewValue;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2Package.REQUIREMENT_CHANGE__NEW_VALUE, oldNewValue, newNewValue);
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
			case P2Package.REQUIREMENT_CHANGE__APPLY_ON:
				if (resolve)
					return getApplyOn();
				return basicGetApplyOn();
			case P2Package.REQUIREMENT_CHANGE__NEW_VALUE:
				if (resolve)
					return getNewValue();
				return basicGetNewValue();
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
			case P2Package.REQUIREMENT_CHANGE__APPLY_ON:
				return basicSetApplyOn(null, msgs);
			case P2Package.REQUIREMENT_CHANGE__NEW_VALUE:
				return basicSetNewValue(null, msgs);
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
			case P2Package.REQUIREMENT_CHANGE__APPLY_ON:
				return applyOn != null;
			case P2Package.REQUIREMENT_CHANGE__NEW_VALUE:
				return newValue != null;
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
			case P2Package.REQUIREMENT_CHANGE__APPLY_ON:
				setApplyOn((IRequiredCapability) newValue);
				return;
			case P2Package.REQUIREMENT_CHANGE__NEW_VALUE:
				setNewValue((IRequiredCapability) newValue);
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
		return P2Package.Literals.REQUIREMENT_CHANGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.REQUIREMENT_CHANGE__APPLY_ON:
				setApplyOn((IRequiredCapability) null);
				return;
			case P2Package.REQUIREMENT_CHANGE__NEW_VALUE:
				setNewValue((IRequiredCapability) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRequiredCapability getApplyOn() {
		if (applyOn != null && ((EObject) applyOn).eIsProxy()) {
			InternalEObject oldApplyOn = (InternalEObject) applyOn;
			applyOn = (IRequiredCapability) eResolveProxy(oldApplyOn);
			if (applyOn != oldApplyOn) {
				InternalEObject newApplyOn = (InternalEObject) applyOn;
				NotificationChain msgs = oldApplyOn.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2Package.REQUIREMENT_CHANGE__APPLY_ON, null, null);
				if (newApplyOn.eInternalContainer() == null) {
					msgs = newApplyOn.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - P2Package.REQUIREMENT_CHANGE__APPLY_ON,
							null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, P2Package.REQUIREMENT_CHANGE__APPLY_ON,
							oldApplyOn, applyOn));
			}
		}
		return applyOn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRequiredCapability getNewValue() {
		if (newValue != null && ((EObject) newValue).eIsProxy()) {
			InternalEObject oldNewValue = (InternalEObject) newValue;
			newValue = (IRequiredCapability) eResolveProxy(oldNewValue);
			if (newValue != oldNewValue) {
				InternalEObject newNewValue = (InternalEObject) newValue;
				NotificationChain msgs = oldNewValue.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2Package.REQUIREMENT_CHANGE__NEW_VALUE, null, null);
				if (newNewValue.eInternalContainer() == null) {
					msgs = newNewValue.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE - P2Package.REQUIREMENT_CHANGE__NEW_VALUE, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, P2Package.REQUIREMENT_CHANGE__NEW_VALUE,
							oldNewValue, newValue));
			}
		}
		return newValue;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public boolean matches(IRequiredCapability toMatch) {
		IRequiredCapability ao = getApplyOn();
		if (!toMatch.getNamespace().equals(ao.getNamespace()) || !toMatch.getName().equals(ao.getName()))
			return false;
		if (toMatch.getRange().equals(ao.getRange()))
			return true;

		return toMatch.getRange().intersect(ao.getRange()) != null;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public IRequiredCapability newValue() {
		return getNewValue();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setApplyOn(IRequiredCapability newApplyOn) {
		if (newApplyOn != applyOn) {
			NotificationChain msgs = null;
			if (applyOn != null)
				msgs = ((InternalEObject) applyOn).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2Package.REQUIREMENT_CHANGE__APPLY_ON, null, msgs);
			if (newApplyOn != null)
				msgs = ((InternalEObject) newApplyOn).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2Package.REQUIREMENT_CHANGE__APPLY_ON, null, msgs);
			msgs = basicSetApplyOn(newApplyOn, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.REQUIREMENT_CHANGE__APPLY_ON, newApplyOn,
					newApplyOn));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNewValue(IRequiredCapability newNewValue) {
		if (newNewValue != newValue) {
			NotificationChain msgs = null;
			if (newValue != null)
				msgs = ((InternalEObject) newValue).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2Package.REQUIREMENT_CHANGE__NEW_VALUE, null, msgs);
			if (newNewValue != null)
				msgs = ((InternalEObject) newNewValue).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2Package.REQUIREMENT_CHANGE__NEW_VALUE, null, msgs);
			msgs = basicSetNewValue(newNewValue, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.REQUIREMENT_CHANGE__NEW_VALUE, newNewValue,
					newNewValue));
	}

} // RequirementChangeImpl
