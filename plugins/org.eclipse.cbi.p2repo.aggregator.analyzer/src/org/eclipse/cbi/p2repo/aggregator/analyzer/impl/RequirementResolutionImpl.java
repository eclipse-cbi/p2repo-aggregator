/**
 * Copyright (c) 2021 Eclipse Foundation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.analyzer.impl;

import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage;
import org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement Resolution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.RequirementResolutionImpl#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.RequirementResolutionImpl#getInstallableUnit <em>Installable Unit</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.RequirementResolutionImpl#getCapability <em>Capability</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequirementResolutionImpl extends MinimalEObjectImpl.Container implements RequirementResolution {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getInstallableUnit() <em>Installable Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallableUnit()
	 * @generated
	 * @ordered
	 */
	protected InstallableUnitAnalysis installableUnit;

	/**
	 * The cached value of the '{@link #getCapability() <em>Capability</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapability()
	 * @generated
	 * @ordered
	 */
	protected CapabilityAnalysis capability;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementResolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyzerPackage.Literals.REQUIREMENT_RESOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RequirementAnalysis getRequirement() {
		if (eContainerFeatureID() != AnalyzerPackage.REQUIREMENT_RESOLUTION__REQUIREMENT)
			return null;
		return (RequirementAnalysis) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequirement(RequirementAnalysis newRequirement, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newRequirement, AnalyzerPackage.REQUIREMENT_RESOLUTION__REQUIREMENT,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequirement(RequirementAnalysis newRequirement) {
		if (newRequirement != eInternalContainer()
				|| (eContainerFeatureID() != AnalyzerPackage.REQUIREMENT_RESOLUTION__REQUIREMENT
						&& newRequirement != null)) {
			if (EcoreUtil.isAncestor(this, newRequirement))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newRequirement != null)
				msgs = ((InternalEObject) newRequirement).eInverseAdd(this,
						AnalyzerPackage.REQUIREMENT_ANALYSIS__RESOLUTIONS, RequirementAnalysis.class, msgs);
			msgs = basicSetRequirement(newRequirement, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.REQUIREMENT_RESOLUTION__REQUIREMENT,
					newRequirement, newRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstallableUnitAnalysis getInstallableUnit() {
		if (installableUnit != null && installableUnit.eIsProxy()) {
			InternalEObject oldInstallableUnit = (InternalEObject) installableUnit;
			installableUnit = (InstallableUnitAnalysis) eResolveProxy(oldInstallableUnit);
			if (installableUnit != oldInstallableUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AnalyzerPackage.REQUIREMENT_RESOLUTION__INSTALLABLE_UNIT, oldInstallableUnit,
							installableUnit));
			}
		}
		return installableUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstallableUnitAnalysis basicGetInstallableUnit() {
		return installableUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstallableUnit(InstallableUnitAnalysis newInstallableUnit) {
		InstallableUnitAnalysis oldInstallableUnit = installableUnit;
		installableUnit = newInstallableUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AnalyzerPackage.REQUIREMENT_RESOLUTION__INSTALLABLE_UNIT, oldInstallableUnit, installableUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CapabilityAnalysis getCapability() {
		if (capability != null && capability.eIsProxy()) {
			InternalEObject oldCapability = (InternalEObject) capability;
			capability = (CapabilityAnalysis) eResolveProxy(oldCapability);
			if (capability != oldCapability) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AnalyzerPackage.REQUIREMENT_RESOLUTION__CAPABILITY, oldCapability, capability));
			}
		}
		return capability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapabilityAnalysis basicGetCapability() {
		return capability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCapability(CapabilityAnalysis newCapability) {
		CapabilityAnalysis oldCapability = capability;
		capability = newCapability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.REQUIREMENT_RESOLUTION__CAPABILITY,
					oldCapability, capability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__REQUIREMENT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetRequirement((RequirementAnalysis) otherEnd, msgs);
			default:
				return super.eInverseAdd(otherEnd, featureID, msgs);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__REQUIREMENT:
				return basicSetRequirement(null, msgs);
			default:
				return super.eInverseRemove(otherEnd, featureID, msgs);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__REQUIREMENT:
				return eInternalContainer().eInverseRemove(this, AnalyzerPackage.REQUIREMENT_ANALYSIS__RESOLUTIONS,
						RequirementAnalysis.class, msgs);
			default:
				return super.eBasicRemoveFromContainerFeature(msgs);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__REQUIREMENT:
				return getRequirement();
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__INSTALLABLE_UNIT:
				if (resolve)
					return getInstallableUnit();
				return basicGetInstallableUnit();
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__CAPABILITY:
				if (resolve)
					return getCapability();
				return basicGetCapability();
			default:
				return super.eGet(featureID, resolve, coreType);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__REQUIREMENT:
				setRequirement((RequirementAnalysis) newValue);
				return;
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__INSTALLABLE_UNIT:
				setInstallableUnit((InstallableUnitAnalysis) newValue);
				return;
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__CAPABILITY:
				setCapability((CapabilityAnalysis) newValue);
				return;
			default:
				super.eSet(featureID, newValue);
				return;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__REQUIREMENT:
				setRequirement((RequirementAnalysis) null);
				return;
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__INSTALLABLE_UNIT:
				setInstallableUnit((InstallableUnitAnalysis) null);
				return;
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__CAPABILITY:
				setCapability((CapabilityAnalysis) null);
				return;
			default:
				super.eUnset(featureID);
				return;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__REQUIREMENT:
				return getRequirement() != null;
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__INSTALLABLE_UNIT:
				return installableUnit != null;
			case AnalyzerPackage.REQUIREMENT_RESOLUTION__CAPABILITY:
				return capability != null;
			default:
				return super.eIsSet(featureID);
		}
	}

	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append("( capability: ");
		result.append(capability);
		result.append(", installableUnit: ");
		result.append(installableUnit);
		result.append(')');
		return result.toString();
	}

} // RequirementResolutionImpl
