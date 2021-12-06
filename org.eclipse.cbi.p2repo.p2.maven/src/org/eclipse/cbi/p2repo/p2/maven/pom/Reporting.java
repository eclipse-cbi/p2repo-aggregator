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
 * A representation of the model object '<em><b>Reporting</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 4.0.0
 * Section for management of reports and their configuration.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.Reporting#isExcludeDefaults <em>Exclude Defaults</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.Reporting#getOutputDirectory <em>Output Directory</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.Reporting#getPlugins <em>Plugins</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getReporting()
 * @model extendedMetaData="name='Reporting' kind='elementOnly'"
 * @generated
 */
public interface Reporting extends EObject {
	/**
	 * Returns the value of the '<em><b>Output Directory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 4.0.0
	 *
	 *             Where to store all of the generated reports. The default is
	 *             &lt;code&gt;${project.build.directory}/site&lt;/code&gt;
	 *             .
	 *
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Output Directory</em>' attribute.
	 * @see #setOutputDirectory(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getReporting_OutputDirectory()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='outputDirectory' namespace='##targetNamespace'"
	 * @generated
	 */
	String getOutputDirectory();

	/**
	 * Returns the value of the '<em><b>Plugins</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 4.0.0
	 * The reporting plugins to use and their configuration.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Plugins</em>' containment reference.
	 * @see #setPlugins(ReportingPluginsType)
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getReporting_Plugins()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='plugins' namespace='##targetNamespace'"
	 * @generated
	 */
	ReportingPluginsType getPlugins();

	/**
	 * Returns the value of the '<em><b>Exclude Defaults</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 4.0.0
	 * If true, then the default reports are not included in the site generation. This includes the
	 *             reports in the "Project Info" menu.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Exclude Defaults</em>' attribute.
	 * @see #isSetExcludeDefaults()
	 * @see #unsetExcludeDefaults()
	 * @see #setExcludeDefaults(boolean)
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getReporting_ExcludeDefaults()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='element' name='excludeDefaults' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isExcludeDefaults();

	/**
	 * Returns whether the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.Reporting#isExcludeDefaults <em>Exclude Defaults</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Exclude Defaults</em>' attribute is set.
	 * @see #unsetExcludeDefaults()
	 * @see #isExcludeDefaults()
	 * @see #setExcludeDefaults(boolean)
	 * @generated
	 */
	boolean isSetExcludeDefaults();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.Reporting#isExcludeDefaults <em>Exclude Defaults</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exclude Defaults</em>' attribute.
	 * @see #isSetExcludeDefaults()
	 * @see #unsetExcludeDefaults()
	 * @see #isExcludeDefaults()
	 * @generated
	 */
	void setExcludeDefaults(boolean value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.Reporting#getOutputDirectory <em>Output Directory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output Directory</em>' attribute.
	 * @see #getOutputDirectory()
	 * @generated
	 */
	void setOutputDirectory(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.Reporting#getPlugins <em>Plugins</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugins</em>' containment reference.
	 * @see #getPlugins()
	 * @generated
	 */
	void setPlugins(ReportingPluginsType value);

	/**
	 * Unsets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.Reporting#isExcludeDefaults <em>Exclude Defaults</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetExcludeDefaults()
	 * @see #isExcludeDefaults()
	 * @see #setExcludeDefaults(boolean)
	 * @generated
	 */
	void unsetExcludeDefaults();

} // Reporting
