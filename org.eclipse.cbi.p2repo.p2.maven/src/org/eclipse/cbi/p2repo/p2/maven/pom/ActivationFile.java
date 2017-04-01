/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.p2.maven.pom;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Activation File</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 4.0.0
 *
 * This is the file specification used to activate the profile. The missing value will be the location
 * of a file that needs to exist, and if it doesn't the profile will be activated. On the other hand exists will test
 * for the existence of the file and if it is there the profile will be activated.
 *
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.ActivationFile#getMissing <em>Missing</em>}</li>
 * <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.ActivationFile#getExists <em>Exists</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getActivationFile()
 * @model extendedMetaData="name='ActivationFile' kind='elementOnly'"
 * @generated
 */
public interface ActivationFile extends EObject {
	/**
	 * Returns the value of the '<em><b>Exists</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> 4.0.0 The name of the file that must exist to activate the profile. <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Exists</em>' attribute.
	 * @see #setExists(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getActivationFile_Exists()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='exists' namespace='##targetNamespace'"
	 * @generated
	 */
	String getExists();

	/**
	 * Returns the value of the '<em><b>Missing</b></em>' attribute. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc --> 4.0.0 The name of the file that must be missing to activate the profile. <!-- end-model-doc
	 * -->
	 *
	 * @return the value of the '<em>Missing</em>' attribute.
	 * @see #setMissing(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getActivationFile_Missing()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='missing' namespace='##targetNamespace'"
	 * @generated
	 */
	String getMissing();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.ActivationFile#getExists <em>Exists</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Exists</em>' attribute.
	 * @see #getExists()
	 * @generated
	 */
	void setExists(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.pom.ActivationFile#getMissing <em>Missing</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Missing</em>' attribute.
	 * @see #getMissing()
	 * @generated
	 */
	void setMissing(String value);

} // ActivationFile
