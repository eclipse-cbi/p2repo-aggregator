/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a
 * create method for each non-abstract class of the model. <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage
 * @generated
 */
public interface MetadataFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	MetadataFactory eINSTANCE = org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Document Root</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return a new object of class '<em>Document Root</em>'.
	 * @generated
	 */
	DocumentRoot createDocumentRoot();

	/**
	 * Returns a new object of class '<em>Meta Data</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Meta Data</em>'.
	 * @generated
	 */
	MetaData createMetaData();

	/**
	 * Returns a new object of class '<em>Plugin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plugin</em>'.
	 * @generated
	 */
	Plugin createPlugin();

	/**
	 * Returns a new object of class '<em>Plugins Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Plugins Type</em>'.
	 * @generated
	 */
	PluginsType createPluginsType();

	/**
	 * Returns a new object of class '<em>Versioning</em>'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return a new object of class '<em>Versioning</em>'.
	 * @generated
	 */
	Versioning createVersioning();

	/**
	 * Returns a new object of class '<em>Versions Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Versions Type</em>'.
	 * @generated
	 */
	VersionsType createVersionsType();

	/**
	 * Returns a new object of class '<em>Snapshot</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Snapshot</em>'.
	 * @generated
	 */
	Snapshot createSnapshot();

	/**
	 * Returns a new object of class '<em>Snapshot Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Snapshot Version</em>'.
	 * @generated
	 */
	SnapshotVersion createSnapshotVersion();

	/**
	 * Returns a new object of class '<em>Snapshot Versions Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Snapshot Versions Type</em>'.
	 * @generated
	 */
	SnapshotVersionsType createSnapshotVersionsType();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	MetadataPackage getMetadataPackage();

} // MetadataFactory
