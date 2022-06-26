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
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis;
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
import org.eclipse.equinox.p2.metadata.IInstallableUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Installable Unit Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.InstallableUnitAnalysisImpl#getContribution <em>Contribution</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.InstallableUnitAnalysisImpl#getInstallableUnit <em>Installable Unit</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.InstallableUnitAnalysisImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.InstallableUnitAnalysisImpl#getCapabilities <em>Capabilities</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstallableUnitAnalysisImpl extends MinimalEObjectImpl.Container implements InstallableUnitAnalysis {
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
	protected IInstallableUnit installableUnit;

	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<RequirementAnalysis> requirements;

	/**
	 * The cached value of the '{@link #getCapabilities() <em>Capabilities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapabilities()
	 * @generated
	 * @ordered
	 */
	protected EList<CapabilityAnalysis> capabilities;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstallableUnitAnalysisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyzerPackage.Literals.INSTALLABLE_UNIT_ANALYSIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContributionAnalysis getContribution() {
		if (eContainerFeatureID() != AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CONTRIBUTION)
			return null;
		return (ContributionAnalysis) eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetContribution(ContributionAnalysis newContribution, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject) newContribution,
				AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CONTRIBUTION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContribution(ContributionAnalysis newContribution) {
		if (newContribution != eInternalContainer()
				|| (eContainerFeatureID() != AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CONTRIBUTION
						&& newContribution != null)) {
			if (EcoreUtil.isAncestor(this, newContribution))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newContribution != null)
				msgs = ((InternalEObject) newContribution).eInverseAdd(this,
						AnalyzerPackage.CONTRIBUTION_ANALYSIS__INSTALLABLE_UNITS, ContributionAnalysis.class, msgs);
			msgs = basicSetContribution(newContribution, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CONTRIBUTION, newContribution, newContribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IInstallableUnit getInstallableUnit() {
		if (installableUnit != null && ((EObject) installableUnit).eIsProxy()) {
			InternalEObject oldInstallableUnit = (InternalEObject) installableUnit;
			installableUnit = (IInstallableUnit) eResolveProxy(oldInstallableUnit);
			if (installableUnit != oldInstallableUnit) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__INSTALLABLE_UNIT, oldInstallableUnit,
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
	public IInstallableUnit basicGetInstallableUnit() {
		return installableUnit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstallableUnit(IInstallableUnit newInstallableUnit) {
		IInstallableUnit oldInstallableUnit = installableUnit;
		installableUnit = newInstallableUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__INSTALLABLE_UNIT, oldInstallableUnit, installableUnit));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<RequirementAnalysis> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectContainmentWithInverseEList<>(RequirementAnalysis.class, this,
					AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__REQUIREMENTS,
					AnalyzerPackage.REQUIREMENT_ANALYSIS__INSTALLABLE_UNIT);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CapabilityAnalysis> getCapabilities() {
		if (capabilities == null) {
			capabilities = new EObjectContainmentWithInverseEList<>(CapabilityAnalysis.class, this,
					AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CAPABILITIES,
					AnalyzerPackage.CAPABILITY_ANALYSIS__INSTALLABLE_UNIT);
		}
		return capabilities;
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
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CONTRIBUTION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetContribution((ContributionAnalysis) otherEnd, msgs);
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__REQUIREMENTS:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getRequirements()).basicAdd(otherEnd, msgs);
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CAPABILITIES:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getCapabilities()).basicAdd(otherEnd, msgs);
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
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CONTRIBUTION:
				return basicSetContribution(null, msgs);
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__REQUIREMENTS:
				return ((InternalEList<?>) getRequirements()).basicRemove(otherEnd, msgs);
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CAPABILITIES:
				return ((InternalEList<?>) getCapabilities()).basicRemove(otherEnd, msgs);
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
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CONTRIBUTION:
				return eInternalContainer().eInverseRemove(this,
						AnalyzerPackage.CONTRIBUTION_ANALYSIS__INSTALLABLE_UNITS, ContributionAnalysis.class, msgs);
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
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CONTRIBUTION:
				return getContribution();
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__INSTALLABLE_UNIT:
				if (resolve)
					return getInstallableUnit();
				return basicGetInstallableUnit();
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__REQUIREMENTS:
				return getRequirements();
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CAPABILITIES:
				return getCapabilities();
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
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CONTRIBUTION:
				setContribution((ContributionAnalysis) newValue);
				return;
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__INSTALLABLE_UNIT:
				setInstallableUnit((IInstallableUnit) newValue);
				return;
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends RequirementAnalysis>) newValue);
				return;
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CAPABILITIES:
				getCapabilities().clear();
				getCapabilities().addAll((Collection<? extends CapabilityAnalysis>) newValue);
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
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CONTRIBUTION:
				setContribution((ContributionAnalysis) null);
				return;
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__INSTALLABLE_UNIT:
				setInstallableUnit((IInstallableUnit) null);
				return;
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__REQUIREMENTS:
				getRequirements().clear();
				return;
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CAPABILITIES:
				getCapabilities().clear();
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
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CONTRIBUTION:
				return getContribution() != null;
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__INSTALLABLE_UNIT:
				return installableUnit != null;
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CAPABILITIES:
				return capabilities != null && !capabilities.isEmpty();
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
		result.append("( installableUnit: ");
		result.append(installableUnit);
		result.append(')');
		return result.toString();
	}

} // InstallableUnitAnalysisImpl
