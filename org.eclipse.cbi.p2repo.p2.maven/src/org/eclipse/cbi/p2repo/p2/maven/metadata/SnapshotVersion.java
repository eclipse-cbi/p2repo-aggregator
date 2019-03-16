/**
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snapshot Version</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getExtension <em>Extension</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getValue <em>Value</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getUpdated <em>Updated</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getSnapshotVersion()
 * @model
 * @generated
 */
public interface SnapshotVersion extends EObject {
	/**
	 * Returns the value of the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Extension</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Extension</em>' attribute.
	 * @see #setExtension(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getSnapshotVersion_Extension()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='extension' namespace='##targetNamespace'"
	 * @generated
	 */
	String getExtension();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getExtension <em>Extension</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Extension</em>' attribute.
	 * @see #getExtension()
	 * @generated
	 */
	void setExtension(String value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getSnapshotVersion_Value()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='value' namespace='##targetNamespace'"
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Updated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Updated</em>' attribute.
	 * @see #setUpdated(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getSnapshotVersion_Updated()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='updated' namespace='##targetNamespace'"
	 * @generated
	 */
	String getUpdated();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getUpdated <em>Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Updated</em>' attribute.
	 * @see #getUpdated()
	 * @generated
	 */
	void setUpdated(String value);

} // SnapshotVersion
