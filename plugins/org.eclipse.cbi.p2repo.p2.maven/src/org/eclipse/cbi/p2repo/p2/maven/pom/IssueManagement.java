/**
 * Copyright (c) 2021 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.p2.maven.pom;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Issue Management</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 4.0.0
 *
 *         Information about the issue tracking (or bug tracking) system used to manage this project.
 *
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.IssueManagement#getSystem <em>System</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.IssueManagement#getUrl <em>Url</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getIssueManagement()
 * @model extendedMetaData="name='IssueManagement' kind='elementOnly'"
 * @generated
 */
public interface IssueManagement extends EObject {
	/**
	 * Returns the value of the '<em><b>System</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 4.0.0
	 * The name of the issue management system, e.g. Bugzilla
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>System</em>' attribute.
	 * @see #setSystem(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getIssueManagement_System()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='system' namespace='##targetNamespace'"
	 * @generated
	 */
	String getSystem();

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 4.0.0
	 * URL for the issue management system used by the project.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getIssueManagement_Url()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='url' namespace='##targetNamespace'"
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.IssueManagement#getSystem <em>System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>System</em>' attribute.
	 * @see #getSystem()
	 * @generated
	 */
	void setSystem(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.IssueManagement#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

} // IssueManagement
