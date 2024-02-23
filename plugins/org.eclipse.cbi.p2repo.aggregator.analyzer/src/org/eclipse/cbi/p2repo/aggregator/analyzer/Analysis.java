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
package org.eclipse.cbi.p2repo.aggregator.analyzer;

import java.util.Date;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The root analysis instance that references the aggregaton being analyzed.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis#getReleaseDate <em>Release Date</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis#getExclusion <em>Exclusion</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis#getLevels <em>Levels</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis#getGitRepositoryFilters <em>Git Repository Filters</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis#getAggregation <em>Aggregation</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis#getContributions <em>Contributions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getAnalysis()
 * @model
 * @generated
 */
public interface Analysis extends EObject {
	/**
	 * Returns the value of the '<em><b>Release Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The date of the next scheduled release
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Release Date</em>' attribute.
	 * @see #setReleaseDate(Date)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getAnalysis_ReleaseDate()
	 * @model dataType="org.eclipse.cbi.p2repo.aggregator.analyzer.Date"
	 * @generated
	 */
	Date getReleaseDate();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis#getReleaseDate <em>Release Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release Date</em>' attribute.
	 * @see #getReleaseDate()
	 * @generated
	 */
	void setReleaseDate(Date value);

	/**
	 * Returns the value of the '<em><b>Exclusion</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exclusion</em>' attribute.
	 * @see #setExclusion(Pattern)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getAnalysis_Exclusion()
	 * @model dataType="org.eclipse.cbi.p2repo.aggregator.analyzer.Pattern"
	 * @generated
	 */
	Pattern getExclusion();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis#getExclusion <em>Exclusion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exclusion</em>' attribute.
	 * @see #getExclusion()
	 * @generated
	 */
	void setExclusion(Pattern value);

	/**
	 * Returns the value of the '<em><b>Levels</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Levels</em>' attribute list.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getAnalysis_Levels()
	 * @model
	 * @generated
	 */
	EList<Integer> getLevels();

	/**
	 * Returns the value of the '<em><b>Git Repository Filters</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Git Repository Filters</em>' attribute list.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getAnalysis_GitRepositoryFilters()
	 * @model extendedMetaData="kind='element' name='gitRepositoryFilter'"
	 * @generated
	 */
	EList<String> getGitRepositoryFilters();

	/**
	 * Returns the value of the '<em><b>Aggregation</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The aggregation being analyzed.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Aggregation</em>' reference.
	 * @see #setAggregation(Aggregation)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getAnalysis_Aggregation()
	 * @model required="true"
	 * @generated
	 */
	Aggregation getAggregation();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis#getAggregation <em>Aggregation</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Aggregation</em>' reference.
	 * @see #getAggregation()
	 * @generated
	 */
	void setAggregation(Aggregation value);

	/**
	 * Returns the value of the '<em><b>Contributions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The analyzed contributions.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Contributions</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getAnalysis_Contributions()
	 * @model containment="true"
	 *        extendedMetaData="name='contribution' kind='element'"
	 * @generated
	 */
	EList<ContributionAnalysis> getContributions();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void reconcile();

} // Analysis
