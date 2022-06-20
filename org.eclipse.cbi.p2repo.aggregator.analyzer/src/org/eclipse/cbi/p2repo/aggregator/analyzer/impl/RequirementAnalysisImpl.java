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
import org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution;
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
import org.eclipse.equinox.p2.metadata.IRequirement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Requirement Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.RequirementAnalysisImpl#getInstallableUnit <em>Installable Unit</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.RequirementAnalysisImpl#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.RequirementAnalysisImpl#getResolutions <em>Resolutions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RequirementAnalysisImpl extends MinimalEObjectImpl.Container implements RequirementAnalysis {
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
	protected IRequirement requirement;

	/**
	 * The cached value of the '{@link #getResolutions() <em>Resolutions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResolutions()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementResolution> resolutions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequirementAnalysisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyzerPackage.Literals.REQUIREMENT_ANALYSIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IRequirement getRequirement() {
		if (requirement != null && ((EObject) requirement).eIsProxy()) {
			InternalEObject oldRequirement = (InternalEObject) requirement;
			requirement = (IRequirement) eResolveProxy(oldRequirement);
			if (requirement != oldRequirement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AnalyzerPackage.REQUIREMENT_ANALYSIS__REQUIREMENT, oldRequirement, requirement));
			}
		}
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IRequirement basicGetRequirement() {
		return requirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequirement(IRequirement newRequirement) {
		IRequirement oldRequirement = requirement;
		requirement = newRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.REQUIREMENT_ANALYSIS__REQUIREMENT,
					oldRequirement, requirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstallableUnitAnalysis getInstallableUnit() {
		if (eContainerFeatureID() != AnalyzerPackage.REQUIREMENT_ANALYSIS__INSTALLABLE_UNIT)
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
				AnalyzerPackage.REQUIREMENT_ANALYSIS__INSTALLABLE_UNIT, msgs);
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
				|| (eContainerFeatureID() != AnalyzerPackage.REQUIREMENT_ANALYSIS__INSTALLABLE_UNIT
						&& newInstallableUnit != null)) {
			if (EcoreUtil.isAncestor(this, newInstallableUnit))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newInstallableUnit != null)
				msgs = ((InternalEObject) newInstallableUnit).eInverseAdd(this,
						AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__REQUIREMENTS, InstallableUnitAnalysis.class, msgs);
			msgs = basicSetInstallableUnit(newInstallableUnit, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AnalyzerPackage.REQUIREMENT_ANALYSIS__INSTALLABLE_UNIT, newInstallableUnit, newInstallableUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RequirementResolution> getResolutions() {
		if (resolutions == null) {
			resolutions = new EObjectContainmentWithInverseEList<>(RequirementResolution.class,
					this, AnalyzerPackage.REQUIREMENT_ANALYSIS__RESOLUTIONS,
					AnalyzerPackage.REQUIREMENT_RESOLUTION__REQUIREMENT);
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
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__INSTALLABLE_UNIT:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetInstallableUnit((InstallableUnitAnalysis) otherEnd, msgs);
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__RESOLUTIONS:
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
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__INSTALLABLE_UNIT:
				return basicSetInstallableUnit(null, msgs);
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__RESOLUTIONS:
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
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__INSTALLABLE_UNIT:
				return eInternalContainer().eInverseRemove(this,
						AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__REQUIREMENTS, InstallableUnitAnalysis.class, msgs);
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
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__INSTALLABLE_UNIT:
				return getInstallableUnit();
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__REQUIREMENT:
				if (resolve)
					return getRequirement();
				return basicGetRequirement();
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__RESOLUTIONS:
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
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__INSTALLABLE_UNIT:
				setInstallableUnit((InstallableUnitAnalysis) newValue);
				return;
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__REQUIREMENT:
				setRequirement((IRequirement) newValue);
				return;
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__RESOLUTIONS:
				getResolutions().clear();
				getResolutions().addAll((Collection<? extends RequirementResolution>) newValue);
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
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__INSTALLABLE_UNIT:
				setInstallableUnit((InstallableUnitAnalysis) null);
				return;
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__REQUIREMENT:
				setRequirement((IRequirement) null);
				return;
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__RESOLUTIONS:
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
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__INSTALLABLE_UNIT:
				return getInstallableUnit() != null;
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__REQUIREMENT:
				return requirement != null;
			case AnalyzerPackage.REQUIREMENT_ANALYSIS__RESOLUTIONS:
				return resolutions != null && !resolutions.isEmpty();
			default:
				return super.eIsSet(featureID);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.emf.ecore.impl.BasicEObjectImpl#toString()
	 */
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

} // RequirementAnalysisImpl
