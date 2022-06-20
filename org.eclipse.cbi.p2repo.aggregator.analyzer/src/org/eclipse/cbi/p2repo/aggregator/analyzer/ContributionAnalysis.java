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

import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Contribution Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A wrapper of a contribution.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#isDominant <em>Dominant</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#getMatch <em>Match</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#getLastModified <em>Last Modified</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#getContribution <em>Contribution</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#getInstallableUnits <em>Installable Units</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#getProjects <em>Projects</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getContributionAnalysis()
 * @model
 * @generated
 */
public interface ContributionAnalysis extends EObject {
	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The contribution's label override.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getContributionAnalysis_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Returns the value of the '<em><b>Dominant</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dominant</em>' attribute.
	 * @see #setDominant(boolean)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getContributionAnalysis_Dominant()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	boolean isDominant();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#isDominant <em>Dominant</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dominant</em>' attribute.
	 * @see #isDominant()
	 * @generated
	 */
	void setDominant(boolean value);

	/**
	 * Returns the value of the '<em><b>Match</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Match</em>' attribute.
	 * @see #setMatch(Pattern)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getContributionAnalysis_Match()
	 * @model dataType="org.eclipse.cbi.p2repo.aggregator.analyzer.Pattern"
	 * @generated
	 */
	Pattern getMatch();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#getMatch <em>Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Match</em>' attribute.
	 * @see #getMatch()
	 * @generated
	 */
	void setMatch(Pattern value);

	/**
	 * Returns the value of the '<em><b>Last Modified</b></em>' attribute.
	 * The default value is <code>"-9223372036854775808"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The last time in millis that this contribution was modified
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Last Modified</em>' attribute.
	 * @see #setLastModified(long)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getContributionAnalysis_LastModified()
	 * @model default="-9223372036854775808" transient="true"
	 * @generated
	 */
	long getLastModified();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#getLastModified <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Modified</em>' attribute.
	 * @see #getLastModified()
	 * @generated
	 */
	void setLastModified(long value);

	/**
	 * Returns the value of the '<em><b>Contribution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The analyzed contribution.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Contribution</em>' reference.
	 * @see #setContribution(Contribution)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getContributionAnalysis_Contribution()
	 * @model required="true"
	 * @generated
	 */
	Contribution getContribution();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#getContribution <em>Contribution</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contribution</em>' reference.
	 * @see #getContribution()
	 * @generated
	 */
	void setContribution(Contribution value);

	/**
	 * Returns the value of the '<em><b>Installable Units</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis#getContribution <em>Contribution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installable Units</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getContributionAnalysis_InstallableUnits()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis#getContribution
	 * @model opposite="contribution" containment="true"
	 *        extendedMetaData="kind='element' name='installableUnit'"
	 * @generated
	 */
	EList<InstallableUnitAnalysis> getInstallableUnits();

	/**
	 * Returns the value of the '<em><b>Projects</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Projects</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getContributionAnalysis_Projects()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='project'"
	 * @generated
	 */
	EList<Project> getProjects();

} // ContributionAnalysis
