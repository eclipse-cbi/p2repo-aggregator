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
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Project;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Contribution Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ContributionAnalysisImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ContributionAnalysisImpl#isDominant <em>Dominant</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ContributionAnalysisImpl#getMatch <em>Match</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ContributionAnalysisImpl#getLastModified <em>Last Modified</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ContributionAnalysisImpl#getContribution <em>Contribution</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ContributionAnalysisImpl#getInstallableUnits <em>Installable Units</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.ContributionAnalysisImpl#getProjects <em>Projects</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ContributionAnalysisImpl extends MinimalEObjectImpl.Container implements ContributionAnalysis {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #isDominant() <em>Dominant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDominant()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DOMINANT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isDominant() <em>Dominant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDominant()
	 * @generated
	 * @ordered
	 */
	protected static final int DOMINANT_EFLAG = 1 << 0;

	/**
	 * The default value of the '{@link #getMatch() <em>Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatch()
	 * @generated
	 * @ordered
	 */
	protected static final Pattern MATCH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMatch() <em>Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMatch()
	 * @generated
	 * @ordered
	 */
	protected Pattern match = MATCH_EDEFAULT;

	/**
	 * The default value of the '{@link #getLastModified() <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModified()
	 * @generated
	 * @ordered
	 */
	protected static final long LAST_MODIFIED_EDEFAULT = -9223372036854775808L;

	/**
	 * The cached value of the '{@link #getLastModified() <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastModified()
	 * @generated
	 * @ordered
	 */
	protected long lastModified = LAST_MODIFIED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getContribution() <em>Contribution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContribution()
	 * @generated
	 * @ordered
	 */
	protected Contribution contribution;

	/**
	 * The cached value of the '{@link #getInstallableUnits() <em>Installable Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallableUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<InstallableUnitAnalysis> installableUnits;

	/**
	 * The cached value of the '{@link #getProjects() <em>Projects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProjects()
	 * @generated
	 * @ordered
	 */
	protected EList<Project> projects;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContributionAnalysisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS;
	}

	@Override
	public String getLabel() {
		String label = getLabelGen();
		if (label == null) {
			Contribution contribution = getContribution();
			if (contribution != null) {
				label = contribution.getLabel();
			}
		}
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLabelGen() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.CONTRIBUTION_ANALYSIS__LABEL,
					oldLabel, label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDominant() {
		return (eFlags & DOMINANT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDominant(boolean newDominant) {
		boolean oldDominant = (eFlags & DOMINANT_EFLAG) != 0;
		if (newDominant)
			eFlags |= DOMINANT_EFLAG;
		else
			eFlags &= ~DOMINANT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.CONTRIBUTION_ANALYSIS__DOMINANT,
					oldDominant, newDominant));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Pattern getMatch() {
		return match;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMatch(Pattern newMatch) {
		Pattern oldMatch = match;
		match = newMatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.CONTRIBUTION_ANALYSIS__MATCH,
					oldMatch, match));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public long getLastModified() {
		return lastModified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastModified(long newLastModified) {
		long oldLastModified = lastModified;
		lastModified = newLastModified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.CONTRIBUTION_ANALYSIS__LAST_MODIFIED,
					oldLastModified, lastModified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Contribution getContribution() {
		if (contribution != null && ((EObject) contribution).eIsProxy()) {
			InternalEObject oldContribution = (InternalEObject) contribution;
			contribution = (Contribution) eResolveProxy(oldContribution);
			if (contribution != oldContribution) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AnalyzerPackage.CONTRIBUTION_ANALYSIS__CONTRIBUTION, oldContribution, contribution));
			}
		}
		return contribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contribution basicGetContribution() {
		return contribution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setContribution(Contribution newContribution) {
		Contribution oldContribution = contribution;
		contribution = newContribution;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.CONTRIBUTION_ANALYSIS__CONTRIBUTION,
					oldContribution, contribution));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<InstallableUnitAnalysis> getInstallableUnits() {
		if (installableUnits == null) {
			installableUnits = new EObjectContainmentWithInverseEList<>(
					InstallableUnitAnalysis.class, this, AnalyzerPackage.CONTRIBUTION_ANALYSIS__INSTALLABLE_UNITS,
					AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS__CONTRIBUTION);
		}
		return installableUnits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Project> getProjects() {
		if (projects == null) {
			projects = new EObjectContainmentEList<>(Project.class, this,
					AnalyzerPackage.CONTRIBUTION_ANALYSIS__PROJECTS);
		}
		return projects;
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
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__INSTALLABLE_UNITS:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getInstallableUnits()).basicAdd(otherEnd,
						msgs);
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
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__INSTALLABLE_UNITS:
				return ((InternalEList<?>) getInstallableUnits()).basicRemove(otherEnd, msgs);
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__PROJECTS:
				return ((InternalEList<?>) getProjects()).basicRemove(otherEnd, msgs);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__LABEL:
				return getLabel();
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__DOMINANT:
				return isDominant();
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__MATCH:
				return getMatch();
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__LAST_MODIFIED:
				return getLastModified();
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__CONTRIBUTION:
				if (resolve)
					return getContribution();
				return basicGetContribution();
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__INSTALLABLE_UNITS:
				return getInstallableUnits();
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__PROJECTS:
				return getProjects();
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
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__LABEL:
				setLabel((String) newValue);
				return;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__DOMINANT:
				setDominant((Boolean) newValue);
				return;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__MATCH:
				setMatch((Pattern) newValue);
				return;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__LAST_MODIFIED:
				setLastModified((Long) newValue);
				return;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__CONTRIBUTION:
				setContribution((Contribution) newValue);
				return;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__INSTALLABLE_UNITS:
				getInstallableUnits().clear();
				getInstallableUnits().addAll((Collection<? extends InstallableUnitAnalysis>) newValue);
				return;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__PROJECTS:
				getProjects().clear();
				getProjects().addAll((Collection<? extends Project>) newValue);
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
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__DOMINANT:
				setDominant(DOMINANT_EDEFAULT);
				return;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__MATCH:
				setMatch(MATCH_EDEFAULT);
				return;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__LAST_MODIFIED:
				setLastModified(LAST_MODIFIED_EDEFAULT);
				return;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__CONTRIBUTION:
				setContribution((Contribution) null);
				return;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__INSTALLABLE_UNITS:
				getInstallableUnits().clear();
				return;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__PROJECTS:
				getProjects().clear();
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
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__DOMINANT:
				return ((eFlags & DOMINANT_EFLAG) != 0) != DOMINANT_EDEFAULT;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__MATCH:
				return MATCH_EDEFAULT == null ? match != null : !MATCH_EDEFAULT.equals(match);
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__LAST_MODIFIED:
				return lastModified != LAST_MODIFIED_EDEFAULT;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__CONTRIBUTION:
				return contribution != null;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__INSTALLABLE_UNITS:
				return installableUnits != null && !installableUnits.isEmpty();
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__PROJECTS:
				return projects != null && !projects.isEmpty();
			default:
				return super.eIsSet(featureID);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (label: ");
		result.append(label);
		result.append(", dominant: ");
		result.append((eFlags & DOMINANT_EFLAG) != 0);
		result.append(", match: ");
		result.append(match);
		result.append(", lastModified: ");
		result.append(lastModified);
		result.append(')');
		return result.toString();
	}

} // ContributionAnalysisImpl
