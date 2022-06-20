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
import org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution;
import org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Capability Resolution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.CapabilityResolutionImpl#getCapability <em>Capability</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.CapabilityResolutionImpl#getRequirement <em>Requirement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CapabilityResolutionImpl extends MinimalEObjectImpl.Container implements CapabilityResolution {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getRequirement() <em>Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirement()
	 * @generated
	 * @ordered
	 */
	protected RequirementAnalysis requirement;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CapabilityResolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyzerPackage.Literals.CAPABILITY_RESOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CapabilityAnalysis getCapability() {
		if (eContainerFeatureID() != AnalyzerPackage.CAPABILITY_RESOLUTION__CAPABILITY)
			return null;
		return (CapabilityAnalysis) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCapability(CapabilityAnalysis newCapability, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newCapability, AnalyzerPackage.CAPABILITY_RESOLUTION__CAPABILITY,
				msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCapability(CapabilityAnalysis newCapability) {
		if (newCapability != eInternalContainer()
				|| (eContainerFeatureID() != AnalyzerPackage.CAPABILITY_RESOLUTION__CAPABILITY
						&& newCapability != null)) {
			if (EcoreUtil.isAncestor(this, newCapability))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newCapability != null)
				msgs = ((InternalEObject) newCapability).eInverseAdd(this,
						AnalyzerPackage.CAPABILITY_ANALYSIS__RESOLUTIONS, CapabilityAnalysis.class, msgs);
			msgs = basicSetCapability(newCapability, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.CAPABILITY_RESOLUTION__CAPABILITY,
					newCapability, newCapability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RequirementAnalysis getRequirement() {
		if (requirement != null && requirement.eIsProxy()) {
			InternalEObject oldRequirement = (InternalEObject) requirement;
			requirement = (RequirementAnalysis) eResolveProxy(oldRequirement);
			if (requirement != oldRequirement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AnalyzerPackage.CAPABILITY_RESOLUTION__REQUIREMENT, oldRequirement, requirement));
			}
		}
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequirementAnalysis basicGetRequirement() {
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequirement(RequirementAnalysis newRequirement) {
		RequirementAnalysis oldRequirement = requirement;
		requirement = newRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.CAPABILITY_RESOLUTION__REQUIREMENT,
					oldRequirement, requirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalyzerPackage.CAPABILITY_RESOLUTION__CAPABILITY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetCapability((CapabilityAnalysis) otherEnd, msgs);
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
			case AnalyzerPackage.CAPABILITY_RESOLUTION__CAPABILITY:
				return basicSetCapability(null, msgs);
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
			case AnalyzerPackage.CAPABILITY_RESOLUTION__CAPABILITY:
				return eInternalContainer().eInverseRemove(this, AnalyzerPackage.CAPABILITY_ANALYSIS__RESOLUTIONS,
						CapabilityAnalysis.class, msgs);
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
			case AnalyzerPackage.CAPABILITY_RESOLUTION__CAPABILITY:
				return getCapability();
			case AnalyzerPackage.CAPABILITY_RESOLUTION__REQUIREMENT:
				if (resolve)
					return getRequirement();
				return basicGetRequirement();
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
			case AnalyzerPackage.CAPABILITY_RESOLUTION__CAPABILITY:
				setCapability((CapabilityAnalysis) newValue);
				return;
			case AnalyzerPackage.CAPABILITY_RESOLUTION__REQUIREMENT:
				setRequirement((RequirementAnalysis) newValue);
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
			case AnalyzerPackage.CAPABILITY_RESOLUTION__CAPABILITY:
				setCapability((CapabilityAnalysis) null);
				return;
			case AnalyzerPackage.CAPABILITY_RESOLUTION__REQUIREMENT:
				setRequirement((RequirementAnalysis) null);
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
			case AnalyzerPackage.CAPABILITY_RESOLUTION__CAPABILITY:
				return getCapability() != null;
			case AnalyzerPackage.CAPABILITY_RESOLUTION__REQUIREMENT:
				return requirement != null;
			default:
				return super.eIsSet(featureID);
		}
	}

	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append("( requirement: ");
		result.append(requirement);
		result.append(')');
		return result.toString();
	}

} // CapabilityResolutionImpl
