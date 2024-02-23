/**
 * Copyright (c) 2022 Eclipse Foundation and others.
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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Project</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getSite <em>Site</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getReleaseDate <em>Release Date</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getRank <em>Rank</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getContribution <em>Contribution</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getParent <em>Parent</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getSubprojects <em>Subprojects</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getProject()
 * @model
 * @generated
 */
public interface Project extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getProject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Site</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Site</em>' attribute.
	 * @see #setSite(URI)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getProject_Site()
	 * @model dataType="org.eclipse.cbi.p2repo.aggregator.analyzer.URI"
	 * @generated
	 */
	URI getSite();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getSite <em>Site</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Site</em>' attribute.
	 * @see #getSite()
	 * @generated
	 */
	void setSite(URI value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(URI)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getProject_Version()
	 * @model dataType="org.eclipse.cbi.p2repo.aggregator.analyzer.URI"
	 * @generated
	 */
	URI getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(URI value);

	/**
	 * Returns the value of the '<em><b>Release Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The date of the version release
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Release Date</em>' attribute.
	 * @see #setReleaseDate(Date)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getProject_ReleaseDate()
	 * @model dataType="org.eclipse.cbi.p2repo.aggregator.analyzer.Date"
	 * @generated
	 */
	Date getReleaseDate();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getReleaseDate <em>Release Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Release Date</em>' attribute.
	 * @see #getReleaseDate()
	 * @generated
	 */
	void setReleaseDate(Date value);

	/**
	 * Returns the value of the '<em><b>Rank</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rank</em>' attribute.
	 * @see #setRank(int)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getProject_Rank()
	 * @model
	 * @generated
	 */
	int getRank();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getRank <em>Rank</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Rank</em>' attribute.
	 * @see #getRank()
	 * @generated
	 */
	void setRank(int value);

	/**
	 * Returns the value of the '<em><b>Contribution</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contribution</em>' reference.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getProject_Contribution()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	ContributionAnalysis getContribution();

	/**
	 * Returns the value of the '<em><b>Parent</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getSubprojects <em>Subprojects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent</em>' container reference.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getProject_Parent()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getSubprojects
	 * @model opposite="subprojects" resolveProxies="false" changeable="false"
	 * @generated
	 */
	Project getParent();

	/**
	 * Returns the value of the '<em><b>Repositories</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository#getProject <em>Project</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repositories</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getProject_Repositories()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository#getProject
	 * @model opposite="project" containment="true"
	 *        extendedMetaData="kind='element' name='repository'"
	 * @generated
	 */
	EList<GitRepository> getRepositories();

	/**
	 * Returns the value of the '<em><b>Subprojects</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subprojects</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getProject_Subprojects()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getParent
	 * @model opposite="parent" containment="true"
	 *        extendedMetaData="kind='element' name='subproject'"
	 * @generated
	 */
	EList<Project> getSubprojects();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Project> getAllProjects();

} // Project
