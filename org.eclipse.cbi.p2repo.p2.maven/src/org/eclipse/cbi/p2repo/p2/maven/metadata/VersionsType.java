/**
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Versions Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.VersionsType#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getVersionsType()
 * @model extendedMetaData="name='versions_._type' kind='elementOnly'"
 * @generated
 */
public interface VersionsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute list.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getVersionsType_Version()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='version' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getVersion();

} // VersionsType
