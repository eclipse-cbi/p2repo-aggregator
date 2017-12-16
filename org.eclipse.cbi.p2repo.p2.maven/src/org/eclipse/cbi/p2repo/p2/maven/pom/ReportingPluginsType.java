/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.p2.maven.pom;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Reporting Plugins Type</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.ReportingPluginsType#getPlugin <em>Plugin</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getReportingPluginsType()
 * @model extendedMetaData="name='reporting_._plugins_._type' kind='elementOnly'"
 * @generated
 */
public interface ReportingPluginsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Plugin</b></em>' containment reference
	 * list. The list contents are of type
	 * {@link org.eclipse.cbi.p2repo.p2.maven.pom.ReportPlugin}. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Plugin</em>' containment reference list isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Plugin</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getReportingPluginsType_Plugin()
	 * @model containment="true" extendedMetaData="kind='element' name='plugin'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	EList<ReportPlugin> getPlugin();

} // ReportingPluginsType
