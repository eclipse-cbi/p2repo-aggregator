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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Git Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository#getURI <em>URI</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository#getLastModified <em>Last Modified</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository#getProject <em>Project</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getGitRepository()
 * @model
 * @generated
 */
public interface GitRepository extends EObject {
	/**
	 * Returns the value of the '<em><b>URI</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>URI</em>' attribute.
	 * @see #setURI(URI)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getGitRepository_URI()
	 * @model dataType="org.eclipse.cbi.p2repo.aggregator.analyzer.URI"
	 *        extendedMetaData="name='uri'"
	 * @generated
	 */
	URI getURI();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository#getURI <em>URI</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URI</em>' attribute.
	 * @see #getURI()
	 * @generated
	 */
	void setURI(URI value);

	/**
	 * Returns the value of the '<em><b>Last Modified</b></em>' attribute.
	 * The default value is <code>"-9223372036854775808"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The last time in millis of the most recent commit in this Git
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Last Modified</em>' attribute.
	 * @see #setLastModified(long)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getGitRepository_LastModified()
	 * @model default="-9223372036854775808" transient="true"
	 * @generated
	 */
	long getLastModified();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository#getLastModified <em>Last Modified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Last Modified</em>' attribute.
	 * @see #getLastModified()
	 * @generated
	 */
	void setLastModified(long value);

	/**
	 * Returns the value of the '<em><b>Project</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getRepositories <em>Repositories</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project</em>' container reference.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getGitRepository_Project()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.Project#getRepositories
	 * @model opposite="repositories" resolveProxies="false" changeable="false"
	 * @generated
	 */
	Project getProject();

} // GitRepository
