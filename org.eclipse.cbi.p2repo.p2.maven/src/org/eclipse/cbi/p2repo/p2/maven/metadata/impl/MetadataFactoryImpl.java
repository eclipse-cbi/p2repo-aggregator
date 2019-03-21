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
import org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin;
import org.eclipse.cbi.p2repo.p2.maven.metadata.PluginsType;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot;
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion;
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersionsType;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning;
import org.eclipse.cbi.p2repo.p2.maven.metadata.VersionsType;
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
			case MetadataPackage.PLUGIN:
				return createPlugin();
			case MetadataPackage.PLUGINS_TYPE:
				return createPluginsType();
			case MetadataPackage.SNAPSHOT:
				return createSnapshot();
			case MetadataPackage.SNAPSHOT_VERSION:
				return createSnapshotVersion();
			case MetadataPackage.SNAPSHOT_VERSIONS_TYPE:
				return createSnapshotVersionsType();
			case MetadataPackage.VERSIONING:
				return createVersioning();
			case MetadataPackage.VERSIONS_TYPE:
				return createVersionsType();
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Plugin createPlugin() {
		PluginImpl plugin = new PluginImpl();
		return plugin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PluginsType createPluginsType() {
		PluginsTypeImpl pluginsType = new PluginsTypeImpl();
		return pluginsType;
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VersionsType createVersionsType() {
		VersionsTypeImpl versionsType = new VersionsTypeImpl();
		return versionsType;
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
	public SnapshotVersion createSnapshotVersion() {
		SnapshotVersionImpl snapshotVersion = new SnapshotVersionImpl();
		return snapshotVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SnapshotVersionsType createSnapshotVersionsType() {
		SnapshotVersionsTypeImpl snapshotVersionsType = new SnapshotVersionsTypeImpl();
		return snapshotVersionsType;
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
