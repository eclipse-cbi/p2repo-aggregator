/**
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snapshot Versions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersions#getSnapshotVersion <em>Snapshot Version</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getSnapshotVersions()
 * @model extendedMetaData="name='SnapshotVersions' kind='elementOnly'"
 * @generated
 */
public interface SnapshotVersions extends EObject {
	/**
	 * Returns the value of the '<em><b>Snapshot Version</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snapshot Version</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snapshot Version</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getSnapshotVersions_SnapshotVersion()
	 * @model containment="true"
	 * @generated
	 */
	EList<SnapshotVersion> getSnapshotVersion();

} // SnapshotVersions
