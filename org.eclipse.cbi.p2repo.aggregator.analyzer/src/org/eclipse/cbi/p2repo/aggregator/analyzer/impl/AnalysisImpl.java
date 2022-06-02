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
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerFactory;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.AnalysisImpl#getReleaseDate <em>Release Date</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.AnalysisImpl#getExclusion <em>Exclusion</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.AnalysisImpl#getLevels <em>Levels</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.AnalysisImpl#getAggregation <em>Aggregation</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.impl.AnalysisImpl#getContributions <em>Contributions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AnalysisImpl extends MinimalEObjectImpl.Container implements Analysis {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The default value of the '{@link #getReleaseDate() <em>Release Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleaseDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date RELEASE_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getReleaseDate() <em>Release Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReleaseDate()
	 * @generated
	 * @ordered
	 */
	protected Date releaseDate = RELEASE_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getExclusion() <em>Exclusion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExclusion()
	 * @generated
	 * @ordered
	 */
	protected static final Pattern EXCLUSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getExclusion() <em>Exclusion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExclusion()
	 * @generated
	 * @ordered
	 */
	protected Pattern exclusion = EXCLUSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLevels() <em>Levels</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevels()
	 * @generated
	 * @ordered
	 */
	protected EList<Integer> levels;

	/**
	 * The cached value of the '{@link #getAggregation() <em>Aggregation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAggregation()
	 * @generated
	 * @ordered
	 */
	protected Aggregation aggregation;

	/**
	 * The cached value of the '{@link #getContributions() <em>Contributions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContributions()
	 * @generated
	 * @ordered
	 */
	protected EList<ContributionAnalysis> contributions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalysisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AnalyzerPackage.Literals.ANALYSIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Date getReleaseDate() {
		return releaseDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReleaseDate(Date newReleaseDate) {
		Date oldReleaseDate = releaseDate;
		releaseDate = newReleaseDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.ANALYSIS__RELEASE_DATE,
					oldReleaseDate, releaseDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Pattern getExclusion() {
		return exclusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Integer> getLevels() {
		if (levels == null) {
			levels = new EDataTypeUniqueEList<>(Integer.class, this, AnalyzerPackage.ANALYSIS__LEVELS);
		}
		return levels;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Aggregation getAggregation() {
		if (aggregation != null && ((EObject) aggregation).eIsProxy()) {
			InternalEObject oldAggregation = (InternalEObject) aggregation;
			aggregation = (Aggregation) eResolveProxy(oldAggregation);
			if (aggregation != oldAggregation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnalyzerPackage.ANALYSIS__AGGREGATION,
							oldAggregation, aggregation));
			}
		}
		return aggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Aggregation basicGetAggregation() {
		return aggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAggregation(Aggregation newAggregation) {
		Aggregation oldAggregation = aggregation;
		aggregation = newAggregation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.ANALYSIS__AGGREGATION, oldAggregation,
					aggregation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ContributionAnalysis> getContributions() {
		if (contributions == null) {
			contributions = new EObjectContainmentEList<>(ContributionAnalysis.class, this,
					AnalyzerPackage.ANALYSIS__CONTRIBUTIONS);
		}
		return contributions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public void reconcile() {
		Aggregation aggregation = getAggregation();
		if (!isNullOrProxy(aggregation)) {
			EList<ContributionAnalysis> contributions = getContributions();
			Map<Contribution, ContributionAnalysis> contributionMapping = contributions.stream()
					.filter(it -> it.getContribution() != null)
					.collect(Collectors.toMap(ContributionAnalysis::getContribution, Function.identity()));
			List<ContributionAnalysis> staleContributions = contributionMapping.entrySet().stream()
					.filter(it -> isNullOrProxy(it.getKey())).map(Map.Entry::getValue).collect(Collectors.toList());
			List<ContributionAnalysis> missingContributions = aggregation.getAllContributions(false).stream()
					.filter(it -> !isNullOrProxy(it) && !contributionMapping.containsKey(it)).map(it -> {
						ContributionAnalysis contribution = AnalyzerFactory.eINSTANCE.createContributionAnalysis();
						contribution.setContribution(it);
						return contribution;
					}).collect(Collectors.toList());
			contributions.removeAll(staleContributions);
			contributions.addAll(missingContributions);
		}
	}

	private static boolean isNullOrProxy(Object object) {
		return object == null || ((EObject) object).eIsProxy();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AnalyzerPackage.ANALYSIS__CONTRIBUTIONS:
				return ((InternalEList<?>) getContributions()).basicRemove(otherEnd, msgs);
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
			case AnalyzerPackage.ANALYSIS__RELEASE_DATE:
				return getReleaseDate();
			case AnalyzerPackage.ANALYSIS__EXCLUSION:
				return getExclusion();
			case AnalyzerPackage.ANALYSIS__LEVELS:
				return getLevels();
			case AnalyzerPackage.ANALYSIS__AGGREGATION:
				if (resolve)
					return getAggregation();
				return basicGetAggregation();
			case AnalyzerPackage.ANALYSIS__CONTRIBUTIONS:
				return getContributions();
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
			case AnalyzerPackage.ANALYSIS__RELEASE_DATE:
				setReleaseDate((Date) newValue);
				return;
			case AnalyzerPackage.ANALYSIS__EXCLUSION:
				setExclusion((Pattern) newValue);
				return;
			case AnalyzerPackage.ANALYSIS__LEVELS:
				getLevels().clear();
				getLevels().addAll((Collection<? extends Integer>) newValue);
				return;
			case AnalyzerPackage.ANALYSIS__AGGREGATION:
				setAggregation((Aggregation) newValue);
				return;
			case AnalyzerPackage.ANALYSIS__CONTRIBUTIONS:
				getContributions().clear();
				getContributions().addAll((Collection<? extends ContributionAnalysis>) newValue);
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
			case AnalyzerPackage.ANALYSIS__RELEASE_DATE:
				setReleaseDate(RELEASE_DATE_EDEFAULT);
				return;
			case AnalyzerPackage.ANALYSIS__EXCLUSION:
				setExclusion(EXCLUSION_EDEFAULT);
				return;
			case AnalyzerPackage.ANALYSIS__LEVELS:
				getLevels().clear();
				return;
			case AnalyzerPackage.ANALYSIS__AGGREGATION:
				setAggregation((Aggregation) null);
				return;
			case AnalyzerPackage.ANALYSIS__CONTRIBUTIONS:
				getContributions().clear();
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
			case AnalyzerPackage.ANALYSIS__RELEASE_DATE:
				return RELEASE_DATE_EDEFAULT == null ? releaseDate != null : !RELEASE_DATE_EDEFAULT.equals(releaseDate);
			case AnalyzerPackage.ANALYSIS__EXCLUSION:
				return EXCLUSION_EDEFAULT == null ? exclusion != null : !EXCLUSION_EDEFAULT.equals(exclusion);
			case AnalyzerPackage.ANALYSIS__LEVELS:
				return levels != null && !levels.isEmpty();
			case AnalyzerPackage.ANALYSIS__AGGREGATION:
				return aggregation != null;
			case AnalyzerPackage.ANALYSIS__CONTRIBUTIONS:
				return contributions != null && !contributions.isEmpty();
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
		result.append(" (releaseDate: ");
		result.append(releaseDate);
		result.append(", exclusion: ");
		result.append(exclusion);
		result.append(", levels: ");
		result.append(levels);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExclusion(Pattern newExclusion) {
		Pattern oldExclusion = exclusion;
		exclusion = newExclusion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalyzerPackage.ANALYSIS__EXCLUSION, oldExclusion,
					exclusion));
	}

} // AnalysisImpl
