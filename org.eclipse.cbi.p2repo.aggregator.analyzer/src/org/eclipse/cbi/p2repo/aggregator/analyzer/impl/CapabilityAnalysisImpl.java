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

import java.util.Collection;

import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage;
import org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution;
import org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.equinox.p2.metadata.IProvidedCapability;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Capability Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.CapabilityAnalysisImpl#getInstallableUnit <em>Installable Unit</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.CapabilityAnalysisImpl#getCapability <em>Capability</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.CapabilityAnalysisImpl#getResolutions <em>Resolutions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CapabilityAnalysisImpl extends MinimalEObjectImpl.Container implements CapabilityAnalysis {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getCapability() <em>Capability</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapability()
	 * @generated
	 * @ordered
	 */
	protected IProvidedCapability capability;

	/**
	 * The cached value of the '{@link #getResolutions() <em>Resolutions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolutions()
	 * @generated
	 * @ordered
	 */
	protected EList<CapabilityResolution> resolutions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CapabilityAnalysisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyzerPackage.Literals.CAPABILITY_ANALYSIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstallableUnitAnalysis getInstallableUnit() {
		if (eContainerFeatureID() != AnalyzerPackage.CAPABILITY_ANALYSIS__INSTALLABLE_UNIT)
			return null;
		return (InstallableUnitAnalysis) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInstallableUnit(InstallableUnitAnalysis newInstallableUnit,
			NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newInstallableUnit,
				AnalyzerPackage.CAPABILITY_ANALYSIS__INSTALLABLE_UNIT, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstallableUnit(InstallableUnitAnalysis newInstallableUnit) {
		if (newInstallableUnit != eInternalContainer()
				|| (eContainerFeatureID() != AnalyzerPackage.CAPABILITY_ANALYSIS__INSTALLABLE_UNIT
						&& newInstallableUnit != null)) {
			if (EcoreUtil.isAncestor(this, newInstallableUnit))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInstallableUnit != null)
				msgs = ((InternalEObject) newInstallableUnit).eInverseAdd(this,
						AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CAPABILITIES, InstallableUnitAnalysis.class, msgs);
			msgs = basicSetInstallableUnit(newInstallableUnit, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.CAPABILITY_ANALYSIS__INSTALLABLE_UNIT,
					newInstallableUnit, newInstallableUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IProvidedCapability getCapability() {
		if (capability != null && ((EObject) capability).eIsProxy()) {
			InternalEObject oldCapability = (InternalEObject) capability;
			capability = (IProvidedCapability) eResolveProxy(oldCapability);
			if (capability != oldCapability) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AnalyzerPackage.CAPABILITY_ANALYSIS__CAPABILITY, oldCapability, capability));
			}
		}
		return capability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IProvidedCapability basicGetCapability() {
		return capability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCapability(IProvidedCapability newCapability) {
		IProvidedCapability oldCapability = capability;
		capability = newCapability;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.CAPABILITY_ANALYSIS__CAPABILITY,
					oldCapability, capability));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CapabilityResolution> getResolutions() {
		if (resolutions == null) {
			resolutions = new EObjectContainmentWithInverseEList<>(CapabilityResolution.class, this,
					AnalyzerPackage.CAPABILITY_ANALYSIS__RESOLUTIONS,
					AnalyzerPackage.CAPABILITY_RESOLUTION__CAPABILITY);
		}
		return resolutions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalyzerPackage.CAPABILITY_ANALYSIS__INSTALLABLE_UNIT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInstallableUnit((InstallableUnitAnalysis) otherEnd, msgs);
			case AnalyzerPackage.CAPABILITY_ANALYSIS__RESOLUTIONS:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getResolutions()).basicAdd(otherEnd, msgs);
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
			case AnalyzerPackage.CAPABILITY_ANALYSIS__INSTALLABLE_UNIT:
				return basicSetInstallableUnit(null, msgs);
			case AnalyzerPackage.CAPABILITY_ANALYSIS__RESOLUTIONS:
				return ((InternalEList<?>) getResolutions()).basicRemove(otherEnd, msgs);
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
			case AnalyzerPackage.CAPABILITY_ANALYSIS__INSTALLABLE_UNIT:
				return eInternalContainer().eInverseRemove(this,
						AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CAPABILITIES, InstallableUnitAnalysis.class, msgs);
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
			case AnalyzerPackage.CAPABILITY_ANALYSIS__INSTALLABLE_UNIT:
				return getInstallableUnit();
			case AnalyzerPackage.CAPABILITY_ANALYSIS__CAPABILITY:
				if (resolve)
					return getCapability();
				return basicGetCapability();
			case AnalyzerPackage.CAPABILITY_ANALYSIS__RESOLUTIONS:
				return getResolutions();
			default:
				return super.eGet(featureID, resolve, coreType);
		}
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
			case AnalyzerPackage.CAPABILITY_ANALYSIS__INSTALLABLE_UNIT:
				setInstallableUnit((InstallableUnitAnalysis) newValue);
				return;
			case AnalyzerPackage.CAPABILITY_ANALYSIS__CAPABILITY:
				setCapability((IProvidedCapability) newValue);
				return;
			case AnalyzerPackage.CAPABILITY_ANALYSIS__RESOLUTIONS:
				getResolutions().clear();
				getResolutions().addAll((Collection<? extends CapabilityResolution>) newValue);
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
			case AnalyzerPackage.CAPABILITY_ANALYSIS__INSTALLABLE_UNIT:
				setInstallableUnit((InstallableUnitAnalysis) null);
				return;
			case AnalyzerPackage.CAPABILITY_ANALYSIS__CAPABILITY:
				setCapability((IProvidedCapability) null);
				return;
			case AnalyzerPackage.CAPABILITY_ANALYSIS__RESOLUTIONS:
				getResolutions().clear();
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
			case AnalyzerPackage.CAPABILITY_ANALYSIS__INSTALLABLE_UNIT:
				return getInstallableUnit() != null;
			case AnalyzerPackage.CAPABILITY_ANALYSIS__CAPABILITY:
				return capability != null;
			case AnalyzerPackage.CAPABILITY_ANALYSIS__RESOLUTIONS:
				return resolutions != null && !resolutions.isEmpty();
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
		result.append(')');
		return result.toString();
	}

} // CapabilityAnalysisImpl
