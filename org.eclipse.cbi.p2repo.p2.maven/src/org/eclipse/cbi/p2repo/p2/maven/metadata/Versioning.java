/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object
 * '<em><b>Versioning</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 1.0.0+
 * Versioning information for an artifact (un-versioned or snapshot)
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getLatest <em>Latest</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getRelease <em>Release</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getSnapshot <em>Snapshot</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getVersions <em>Versions</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getLastUpdated <em>Last Updated</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getSnapshotVersions <em>Snapshot Versions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getVersioning()
 * @model extendedMetaData="name='Versioning' kind='elementOnly'"
 * @generated
 */
public interface Versioning extends EObject {
	/**
	 * Returns the value of the '<em><b>Last Updated</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 *
	 * 1.0.0
	 *
	 *
	 * The timinig of the last update of the current version
	 *
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Last Updated</em>' attribute.
	 * @see #setLastUpdated(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getVersioning_LastUpdated()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='lastUpdated'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	String getLastUpdated();

	/**
	 * Returns the value of the '<em><b>Latest</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 *
	 * 1.0.0
	 *
	 *
	 * The latest version of the project.
	 *
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Latest</em>' attribute.
	 * @see #setLatest(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getVersioning_Latest()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='latest'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	String getLatest();

	/**
	 * Returns the value of the '<em><b>Release</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 *
	 * 1.0.0
	 *
	 *
	 * The latest release version of the project.
	 *
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Release</em>' attribute.
	 * @see #setRelease(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getVersioning_Release()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='release'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	String getRelease();

	/**
	 * Returns the value of the '<em><b>Versions</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc -->
	 *
	 * 1.0.0
	 *
	 *
	 * The minimum version of Maven required to build the project, or to use
	 * this plugin.
	 *
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Versions</em>' containment reference.
	 * @see #setVersions(Versions)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getVersioning_Versions()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='versions'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	VersionsType getVersions();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getVersions <em>Versions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Versions</em>' containment reference.
	 * @see #getVersions()
	 * @generated
	 */
	void setVersions(VersionsType value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getLastUpdated <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Last Updated</em>' attribute.
	 * @see #getLastUpdated()
	 * @generated
	 */
	void setLastUpdated(String value);

	/**
	 * Returns the value of the '<em><b>Snapshot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snapshot</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 1.0.0+
	 * The current snapshot data in use for this version (artifact snapshots only)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Snapshot</em>' containment reference.
	 * @see #setSnapshot(Snapshot)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getVersioning_Snapshot()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='snapshot' namespace='##targetNamespace'"
	 * @generated
	 */
	Snapshot getSnapshot();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getSnapshot <em>Snapshot</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snapshot</em>' containment reference.
	 * @see #getSnapshot()
	 * @generated
	 */
	void setSnapshot(Snapshot value);

	/**
	 * Returns the value of the '<em><b>Snapshot Versions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snapshot Versions</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 1.1.0+
	 * Information for each sub-artifact available in this artifact snapshot.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Snapshot Versions</em>' containment reference.
	 * @see #setSnapshotVersions(SnapshotVersionsType)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getVersioning_SnapshotVersions()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='snapshotVersions' namespace='##targetNamespace'"
	 * @generated
	 */
	SnapshotVersionsType getSnapshotVersions();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getSnapshotVersions <em>Snapshot Versions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snapshot Versions</em>' containment reference.
	 * @see #getSnapshotVersions()
	 * @generated
	 */
	void setSnapshotVersions(SnapshotVersionsType value);

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getLatest
	 * <em>Latest</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @param value
	 *            the new value of the '<em>Latest</em>' attribute.
	 * @see #getLatest()
	 * @generated
	 */
	void setLatest(String value);

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getRelease
	 * <em>Release</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @param value
	 *            the new value of the '<em>Release</em>' attribute.
	 * @see #getRelease()
	 * @generated
	 */
	void setRelease(String value);

} // Versioning
