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
 * A representation of the model object '<em><b>Scm</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 4.0.0
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.Scm#getConnection <em>Connection</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.Scm#getDeveloperConnection <em>Developer Connection</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.Scm#getTag <em>Tag</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.Scm#getUrl <em>Url</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getScm()
 * @model extendedMetaData="name='Scm' kind='elementOnly'"
 * @generated
 */
public interface Scm extends EObject {
	/**
	 * Returns the value of the '<em><b>Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 4.0.0
	 *
	 *               The source control management system URL
	 *               that describes the repository and how to connect to the
	 *               repository. For more information, see the
	 *               &lt;a href="http://maven.apache.org/scm/scm-url-format.html"&gt;URL format&lt;/a&gt;
	 *               and &lt;a href="http://maven.apache.org/scm/scms-overview.html"&gt;list of supported SCMs&lt;/a&gt;.
	 *               This connection is read-only.
	 *
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Connection</em>' attribute.
	 * @see #setConnection(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getScm_Connection()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='connection' namespace='##targetNamespace'"
	 * @generated
	 */
	String getConnection();

	/**
	 * Returns the value of the '<em><b>Developer Connection</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 4.0.0
	 *
	 *             Just like &lt;code&gt;connection&lt;/code&gt;, but for developers, i.e. this scm connection
	 *             will not be read only.
	 *
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Developer Connection</em>' attribute.
	 * @see #setDeveloperConnection(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getScm_DeveloperConnection()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='developerConnection' namespace='##targetNamespace'"
	 * @generated
	 */
	String getDeveloperConnection();

	/**
	 * Returns the value of the '<em><b>Tag</b></em>' attribute.
	 * The default value is <code>"HEAD"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 4.0.0
	 *
	 *             The tag of current code. By default, it's set to HEAD during development.
	 *
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Tag</em>' attribute.
	 * @see #isSetTag()
	 * @see #unsetTag()
	 * @see #setTag(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getScm_Tag()
	 * @model default="HEAD" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='tag' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTag();

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 4.0.0
	 *
	 *             The URL to the project's browsable SCM repository, such as ViewVC or Fisheye.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getScm_Url()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='url' namespace='##targetNamespace'"
	 * @generated
	 */
	String getUrl();

	/**
	 * Returns whether the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.Scm#getTag <em>Tag</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Tag</em>' attribute is set.
	 * @see #unsetTag()
	 * @see #getTag()
	 * @see #setTag(String)
	 * @generated
	 */
	boolean isSetTag();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.Scm#getConnection <em>Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Connection</em>' attribute.
	 * @see #getConnection()
	 * @generated
	 */
	void setConnection(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.Scm#getDeveloperConnection <em>Developer Connection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Developer Connection</em>' attribute.
	 * @see #getDeveloperConnection()
	 * @generated
	 */
	void setDeveloperConnection(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.Scm#getTag <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tag</em>' attribute.
	 * @see #isSetTag()
	 * @see #unsetTag()
	 * @see #getTag()
	 * @generated
	 */
	void setTag(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.Scm#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

	/**
	 * Unsets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.Scm#getTag <em>Tag</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetTag()
	 * @see #getTag()
	 * @see #setTag(String)
	 * @generated
	 */
	void unsetTag();

} // Scm
