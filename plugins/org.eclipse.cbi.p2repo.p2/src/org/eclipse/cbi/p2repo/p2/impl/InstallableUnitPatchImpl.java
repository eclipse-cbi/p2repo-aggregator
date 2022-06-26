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

import java.util.Collection;
import java.util.List;

import org.eclipse.cbi.p2repo.p2.InstallableUnitPatch;
import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.equinox.p2.metadata.IInstallableUnitPatch;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.IRequirementChange;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Installable Unit Patch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitPatchImpl#getRequirementsChange <em>Requirements Change</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitPatchImpl#getLifeCycle <em>Life Cycle</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitPatchImpl#getAppliesTo <em>Applies To</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstallableUnitPatchImpl extends InstallableUnitImpl implements InstallableUnitPatch {
	/**
	 * The cached value of the '{@link #getRequirementsChange() <em>Requirements Change</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementsChange()
	 * @generated
	 * @ordered
	 */
	protected EList<IRequirementChange> requirementsChange;

	/**
	 * The cached value of the '{@link #getLifeCycle() <em>Life Cycle</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLifeCycle()
	 * @generated
	 * @ordered
	 */
	protected IRequirement lifeCycle;

	/**
	 * The cached value of the '{@link #getAppliesTo() <em>Applies To</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAppliesTo()
	 * @generated
	 * @ordered
	 */
	protected EList<IRequirement> appliesTo;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstallableUnitPatchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRequirement basicGetLifeCycle() {
		return lifeCycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLifeCycle(IRequirement newLifeCycle, NotificationChain msgs) {
		IRequirement oldLifeCycle = lifeCycle;
		lifeCycle = newLifeCycle;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE, oldLifeCycle, newLifeCycle);
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
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IInstallableUnitPatch.class) {
			switch (derivedFeatureID) {
				case P2Package.INSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE:
					return P2Package.IINSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE;
				case P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE:
					return P2Package.IINSTALLABLE_UNIT_PATCH__LIFE_CYCLE;
				case P2Package.INSTALLABLE_UNIT_PATCH__APPLIES_TO:
					return P2Package.IINSTALLABLE_UNIT_PATCH__APPLIES_TO;
				default:
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IInstallableUnitPatch.class) {
			switch (baseFeatureID) {
				case P2Package.IINSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE:
					return P2Package.INSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE;
				case P2Package.IINSTALLABLE_UNIT_PATCH__LIFE_CYCLE:
					return P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE;
				case P2Package.IINSTALLABLE_UNIT_PATCH__APPLIES_TO:
					return P2Package.INSTALLABLE_UNIT_PATCH__APPLIES_TO;
				default:
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2Package.INSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE:
				return getRequirementsChange();
			case P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE:
				if (resolve)
					return getLifeCycle();
				return basicGetLifeCycle();
			case P2Package.INSTALLABLE_UNIT_PATCH__APPLIES_TO:
				return getAppliesTo();
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
			case P2Package.INSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE:
				return ((InternalEList<?>) getRequirementsChange()).basicRemove(otherEnd, msgs);
			case P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE:
				return basicSetLifeCycle(null, msgs);
			case P2Package.INSTALLABLE_UNIT_PATCH__APPLIES_TO:
				return ((InternalEList<?>) getAppliesTo()).basicRemove(otherEnd, msgs);
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
			case P2Package.INSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE:
				return requirementsChange != null && !requirementsChange.isEmpty();
			case P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE:
				return lifeCycle != null;
			case P2Package.INSTALLABLE_UNIT_PATCH__APPLIES_TO:
				return appliesTo != null && !appliesTo.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case P2Package.INSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE:
				getRequirementsChange().clear();
				getRequirementsChange().addAll((Collection<? extends IRequirementChange>) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE:
				setLifeCycle((IRequirement) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT_PATCH__APPLIES_TO:
				getAppliesTo().clear();
				getAppliesTo().addAll((Collection<? extends IRequirement>) newValue);
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
		return P2Package.Literals.INSTALLABLE_UNIT_PATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.INSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE:
				getRequirementsChange().clear();
				return;
			case P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE:
				setLifeCycle((IRequirement) null);
				return;
			case P2Package.INSTALLABLE_UNIT_PATCH__APPLIES_TO:
				getAppliesTo().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public IRequirement[][] getApplicabilityScope() {
		List<IRequirement> scope = getAppliesTo();
		if (scope.size() == 0)
			return new IRequirement[0][0];

		IRequirement[] scopeArr = scope.toArray(new IRequirement[scope.size()]);
		return new IRequirement[][] { scopeArr };
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IRequirement> getAppliesTo() {
		if (appliesTo == null) {
			appliesTo = new EObjectContainmentEList.Resolving<>(IRequirement.class, this,
					P2Package.INSTALLABLE_UNIT_PATCH__APPLIES_TO);
		}
		return appliesTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IRequirement getLifeCycle() {
		if (lifeCycle != null && ((EObject) lifeCycle).eIsProxy()) {
			InternalEObject oldLifeCycle = (InternalEObject) lifeCycle;
			lifeCycle = (IRequirement) eResolveProxy(oldLifeCycle);
			if (lifeCycle != oldLifeCycle) {
				InternalEObject newLifeCycle = (InternalEObject) lifeCycle;
				NotificationChain msgs = oldLifeCycle.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE, null, null);
				if (newLifeCycle.eInternalContainer() == null) {
					msgs = newLifeCycle.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE, oldLifeCycle, lifeCycle));
			}
		}
		return lifeCycle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IRequirementChange> getRequirementsChange() {
		if (requirementsChange == null) {
			requirementsChange = new EObjectContainmentEList.Resolving<>(IRequirementChange.class,
					this, P2Package.INSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE);
		}
		return requirementsChange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLifeCycle(IRequirement newLifeCycle) {
		if (newLifeCycle != lifeCycle) {
			NotificationChain msgs = null;
			if (lifeCycle != null)
				msgs = ((InternalEObject) lifeCycle).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE, null, msgs);
			if (newLifeCycle != null)
				msgs = ((InternalEObject) newLifeCycle).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE, null, msgs);
			msgs = basicSetLifeCycle(newLifeCycle, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE,
					newLifeCycle, newLifeCycle));
	}

} // InstallableUnitPatchImpl
