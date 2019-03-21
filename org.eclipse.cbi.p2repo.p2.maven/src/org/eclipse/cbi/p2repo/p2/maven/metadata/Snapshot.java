/**
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snapshot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 1.0.0+
 * Snapshot data for the current artifact version
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#getBuildNumber <em>Build Number</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#isLocalCopy <em>Local Copy</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getSnapshot()
 * @model extendedMetaData="name='Snapshot' kind='elementOnly'"
 * @generated
 */
public interface Snapshot extends EObject {
	/**
	 * Returns the value of the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timestamp</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 1.0.0+
	 * The time it was deployed
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Timestamp</em>' attribute.
	 * @see #setTimestamp(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getSnapshot_Timestamp()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='timestamp' namespace='##targetNamespace'"
	 * @generated
	 */
	String getTimestamp();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#getTimestamp <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timestamp</em>' attribute.
	 * @see #getTimestamp()
	 * @generated
	 */
	void setTimestamp(String value);

	/**
	 * Returns the value of the '<em><b>Build Number</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Build Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 1.0.0+
	 * The incremental build number
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Build Number</em>' attribute.
	 * @see #isSetBuildNumber()
	 * @see #unsetBuildNumber()
	 * @see #setBuildNumber(int)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getSnapshot_BuildNumber()
	 * @model default="0" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 *        extendedMetaData="kind='element' name='buildNumber' namespace='##targetNamespace'"
	 * @generated
	 */
	int getBuildNumber();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#getBuildNumber <em>Build Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Build Number</em>' attribute.
	 * @see #isSetBuildNumber()
	 * @see #unsetBuildNumber()
	 * @see #getBuildNumber()
	 * @generated
	 */
	void setBuildNumber(int value);

	/**
	 * Unsets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#getBuildNumber <em>Build Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetBuildNumber()
	 * @see #getBuildNumber()
	 * @see #setBuildNumber(int)
	 * @generated
	 */
	void unsetBuildNumber();

	/**
	 * Returns whether the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#getBuildNumber <em>Build Number</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Build Number</em>' attribute is set.
	 * @see #unsetBuildNumber()
	 * @see #getBuildNumber()
	 * @see #setBuildNumber(int)
	 * @generated
	 */
	boolean isSetBuildNumber();

	/**
	 * Returns the value of the '<em><b>Local Copy</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 1.0.0+
	 * Whether to use a local copy instead (with filename that includes the base version)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Local Copy</em>' attribute.
	 * @see #isSetLocalCopy()
	 * @see #unsetLocalCopy()
	 * @see #setLocalCopy(boolean)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getSnapshot_LocalCopy()
	 * @model default="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 *        extendedMetaData="kind='element' name='localCopy' namespace='##targetNamespace'"
	 * @generated
	 */
	boolean isLocalCopy();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#isLocalCopy <em>Local Copy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Local Copy</em>' attribute.
	 * @see #isSetLocalCopy()
	 * @see #unsetLocalCopy()
	 * @see #isLocalCopy()
	 * @generated
	 */
	void setLocalCopy(boolean value);

	/**
	 * Unsets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#isLocalCopy <em>Local Copy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetLocalCopy()
	 * @see #isLocalCopy()
	 * @see #setLocalCopy(boolean)
	 * @generated
	 */
	void unsetLocalCopy();

	/**
	 * Returns whether the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#isLocalCopy <em>Local Copy</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Local Copy</em>' attribute is set.
	 * @see #unsetLocalCopy()
	 * @see #isLocalCopy()
	 * @see #setLocalCopy(boolean)
	 * @generated
	 */
	boolean isSetLocalCopy();

} // Snapshot
