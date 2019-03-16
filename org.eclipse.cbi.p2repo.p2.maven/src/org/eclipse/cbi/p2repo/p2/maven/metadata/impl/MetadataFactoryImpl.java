/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata.impl;

import org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot;
import org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData;
import org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataFactory;
import org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot;
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion;
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersions;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Versions;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class MetadataFactoryImpl extends EFactoryImpl implements MetadataFactory {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MetadataPackage getPackage() {
		return MetadataPackage.eINSTANCE;
	}

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public static MetadataFactory init() {
		try {
			MetadataFactory theMetadataFactory = (MetadataFactory) EPackage.Registry.INSTANCE
					.getEFactory(MetadataPackage.eNS_URI);
			if (theMetadataFactory != null) {
				return theMetadataFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MetadataFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public MetadataFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MetadataPackage.DOCUMENT_ROOT:
				return createDocumentRoot();
			case MetadataPackage.META_DATA:
				return createMetaData();
			case MetadataPackage.VERSIONING:
				return createVersioning();
			case MetadataPackage.VERSIONS:
				return createVersions();
			case MetadataPackage.SNAPSHOT:
				return createSnapshot();
			case MetadataPackage.SNAPSHOT_VERSIONS:
				return createSnapshotVersions();
			case MetadataPackage.SNAPSHOT_VERSION:
				return createSnapshotVersion();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DocumentRoot createDocumentRoot() {
		DocumentRootImpl documentRoot = new DocumentRootImpl();
		return documentRoot;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetaData createMetaData() {
		MetaDataImpl metaData = new MetaDataImpl();
		return metaData;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Versioning createVersioning() {
		VersioningImpl versioning = new VersioningImpl();
		return versioning;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Versions createVersions() {
		VersionsImpl versions = new VersionsImpl();
		return versions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Snapshot createSnapshot() {
		SnapshotImpl snapshot = new SnapshotImpl();
		return snapshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SnapshotVersions createSnapshotVersions() {
		SnapshotVersionsImpl snapshotVersions = new SnapshotVersionsImpl();
		return snapshotVersions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SnapshotVersion createSnapshotVersion() {
		SnapshotVersionImpl snapshotVersion = new SnapshotVersionImpl();
		return snapshotVersion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetadataPackage getMetadataPackage() {
		return (MetadataPackage) getEPackage();
	}

} // MetadataFactoryImpl
