/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains
 * accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataFactory
 * @model kind="package"
 * @generated
 */
public interface MetadataPackage extends EPackage {
	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that
	 * represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.DocumentRootImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Metadata</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__METADATA = eINSTANCE.getDocumentRoot_Metadata();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl
		 * <em>Meta Data</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 *
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getMetaData()
		 * @generated
		 */
		EClass META_DATA = eINSTANCE.getMetaData();

		/**
		 * The meta object literal for the '<em><b>Group Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA__GROUP_ID = eINSTANCE.getMetaData_GroupId();

		/**
		 * The meta object literal for the '<em><b>Artifact Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA__ARTIFACT_ID = eINSTANCE.getMetaData_ArtifactId();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA__VERSION = eINSTANCE.getMetaData_Version();

		/**
		 * The meta object literal for the '<em><b>Versioning</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference META_DATA__VERSIONING = eINSTANCE.getMetaData_Versioning();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl <em>Versioning</em>}' class.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getVersioning()
		 * @generated
		 */
		EClass VERSIONING = eINSTANCE.getVersioning();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSIONING__RELEASE = eINSTANCE.getVersioning_Release();

		/**
		 * The meta object literal for the '<em><b>Latest</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSIONING__LATEST = eINSTANCE.getVersioning_Latest();

		/**
		 * The meta object literal for the '<em><b>Versions</b></em>' containment reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference VERSIONING__VERSIONS = eINSTANCE.getVersioning_Versions();

		/**
		 * The meta object literal for the '<em><b>Last Updated</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSIONING__LAST_UPDATED = eINSTANCE.getVersioning_LastUpdated();

		/**
		 * The meta object literal for the '<em><b>Snapshot</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSIONING__SNAPSHOT = eINSTANCE.getVersioning_Snapshot();

		/**
		 * The meta object literal for the '<em><b>Snapshot Versions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSIONING__SNAPSHOT_VERSIONS = eINSTANCE.getVersioning_SnapshotVersions();

		/**
		 * The meta object literal for the
		 * '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersionsImpl
		 * <em>Versions</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
		 * -->
		 *
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersionsImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getVersions()
		 * @generated
		 */
		EClass VERSIONS = eINSTANCE.getVersions();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSIONS__VERSION = eINSTANCE.getVersions_Version();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotImpl <em>Snapshot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getSnapshot()
		 * @generated
		 */
		EClass SNAPSHOT = eINSTANCE.getSnapshot();

		/**
		 * The meta object literal for the '<em><b>Timestamp</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT__TIMESTAMP = eINSTANCE.getSnapshot_Timestamp();

		/**
		 * The meta object literal for the '<em><b>Build Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT__BUILD_NUMBER = eINSTANCE.getSnapshot_BuildNumber();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionsImpl <em>Snapshot Versions</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionsImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getSnapshotVersions()
		 * @generated
		 */
		EClass SNAPSHOT_VERSIONS = eINSTANCE.getSnapshotVersions();

		/**
		 * The meta object literal for the '<em><b>Snapshot Version</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT_VERSIONS__SNAPSHOT_VERSION = eINSTANCE.getSnapshotVersions_SnapshotVersion();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionImpl <em>Snapshot Version</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getSnapshotVersion()
		 * @generated
		 */
		EClass SNAPSHOT_VERSION = eINSTANCE.getSnapshotVersion();

		/**
		 * The meta object literal for the '<em><b>Extension</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT_VERSION__EXTENSION = eINSTANCE.getSnapshotVersion_Extension();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT_VERSION__VALUE = eINSTANCE.getSnapshotVersion_Value();

		/**
		 * The meta object literal for the '<em><b>Updated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT_VERSION__UPDATED = eINSTANCE.getSnapshotVersion_Updated();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metadata";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://maven.apache.org/METADATA/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	MetadataPackage eINSTANCE = org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl.init();

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.DocumentRootImpl
	 * <em>Document Root</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.DocumentRootImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__METADATA = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl <em>Meta Data</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getMetaData()
	 * @generated
	 */
	int META_DATA = 1;

	/**
	 * The feature id for the '<em><b>Group Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int META_DATA__GROUP_ID = 0;

	/**
	 * The feature id for the '<em><b>Artifact Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int META_DATA__ARTIFACT_ID = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int META_DATA__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Versioning</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA__VERSIONING = 3;

	/**
	 * The number of structural features of the '<em>Meta Data</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int META_DATA_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the
	 * '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl
	 * <em>Versioning</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getVersioning()
	 * @generated
	 */
	int VERSIONING = 2;

	/**
	 * The feature id for the '<em><b>Release</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int VERSIONING__RELEASE = 0;

	/**
	 * The feature id for the '<em><b>Latest</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int VERSIONING__LATEST = 1;

	/**
	 * The feature id for the '<em><b>Versions</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONING__VERSIONS = 2;

	/**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int VERSIONING__LAST_UPDATED = 3;

	/**
	 * The feature id for the '<em><b>Snapshot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONING__SNAPSHOT = 4;

	/**
	 * The feature id for the '<em><b>Snapshot Versions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONING__SNAPSHOT_VERSIONS = 5;

	/**
	 * The number of structural features of the '<em>Versioning</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONING_FEATURE_COUNT = 6;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersionsImpl <em>Versions</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersionsImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getVersions()
	 * @generated
	 */
	int VERSIONS = 3;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int VERSIONS__VERSION = 0;

	/**
	 * The number of structural features of the '<em>Versions</em>' class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 * @ordered
	 */
	int VERSIONS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotImpl <em>Snapshot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getSnapshot()
	 * @generated
	 */
	int SNAPSHOT = 4;

	/**
	 * The feature id for the '<em><b>Timestamp</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__TIMESTAMP = 0;

	/**
	 * The feature id for the '<em><b>Build Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__BUILD_NUMBER = 1;

	/**
	 * The number of structural features of the '<em>Snapshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionsImpl <em>Snapshot Versions</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionsImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getSnapshotVersions()
	 * @generated
	 */
	int SNAPSHOT_VERSIONS = 5;

	/**
	 * The feature id for the '<em><b>Snapshot Version</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSIONS__SNAPSHOT_VERSION = 0;

	/**
	 * The number of structural features of the '<em>Snapshot Versions</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSIONS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionImpl <em>Snapshot Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getSnapshotVersion()
	 * @generated
	 */
	int SNAPSHOT_VERSION = 6;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSION__EXTENSION = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSION__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSION__UPDATED = 2;

	/**
	 * The number of structural features of the '<em>Snapshot Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSION_FEATURE_COUNT = 3;

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getMetadata <em>Metadata</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Metadata</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getMetadata()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Metadata();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map
	 * '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getXMLNSPrefixMap
	 * <em>XMLNS Prefix Map</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map
	 * '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getXSISchemaLocation
	 * <em>XSI Schema Location</em>}'. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData <em>Meta Data</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Data</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData
	 * @generated
	 */
	EClass getMetaData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getArtifactId <em>Artifact Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Artifact Id</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getArtifactId()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_ArtifactId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getGroupId <em>Group Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Id</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getGroupId()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_GroupId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getVersion()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_Version();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getVersioning <em>Versioning</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Versioning</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getVersioning()
	 * @see #getMetaData()
	 * @generated
	 */
	EReference getMetaData_Versioning();

	/**
	 * Returns the factory that creates the instances of the model. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetadataFactory getMetadataFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning <em>Versioning</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Versioning</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning
	 * @generated
	 */
	EClass getVersioning();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getLastUpdated <em>Last Updated</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Last Updated</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getLastUpdated()
	 * @see #getVersioning()
	 * @generated
	 */
	EAttribute getVersioning_LastUpdated();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getSnapshot <em>Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Snapshot</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getSnapshot()
	 * @see #getVersioning()
	 * @generated
	 */
	EReference getVersioning_Snapshot();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getSnapshotVersions <em>Snapshot Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Snapshot Versions</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getSnapshotVersions()
	 * @see #getVersioning()
	 * @generated
	 */
	EReference getVersioning_SnapshotVersions();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getLatest <em>Latest</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latest</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getLatest()
	 * @see #getVersioning()
	 * @generated
	 */
	EAttribute getVersioning_Latest();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getRelease()
	 * @see #getVersioning()
	 * @generated
	 */
	EAttribute getVersioning_Release();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getVersions <em>Versions</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Versions</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getVersions()
	 * @see #getVersioning()
	 * @generated
	 */
	EReference getVersioning_Versions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versions <em>Versions</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Versions</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versions
	 * @generated
	 */
	EClass getVersions();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versions#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Version</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versions#getVersion()
	 * @see #getVersions()
	 * @generated
	 */
	EAttribute getVersions_Version();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot <em>Snapshot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshot</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot
	 * @generated
	 */
	EClass getSnapshot();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#getTimestamp <em>Timestamp</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timestamp</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#getTimestamp()
	 * @see #getSnapshot()
	 * @generated
	 */
	EAttribute getSnapshot_Timestamp();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#getBuildNumber <em>Build Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Build Number</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#getBuildNumber()
	 * @see #getSnapshot()
	 * @generated
	 */
	EAttribute getSnapshot_BuildNumber();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersions <em>Snapshot Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshot Versions</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersions
	 * @generated
	 */
	EClass getSnapshotVersions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersions#getSnapshotVersion <em>Snapshot Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Snapshot Version</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersions#getSnapshotVersion()
	 * @see #getSnapshotVersions()
	 * @generated
	 */
	EReference getSnapshotVersions_SnapshotVersion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion <em>Snapshot Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshot Version</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion
	 * @generated
	 */
	EClass getSnapshotVersion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getExtension <em>Extension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Extension</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getExtension()
	 * @see #getSnapshotVersion()
	 * @generated
	 */
	EAttribute getSnapshotVersion_Extension();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getValue()
	 * @see #getSnapshotVersion()
	 * @generated
	 */
	EAttribute getSnapshotVersion_Value();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getUpdated <em>Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Updated</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getUpdated()
	 * @see #getSnapshotVersion()
	 * @generated
	 */
	EAttribute getSnapshotVersion_Updated();

} // MetadataPackage
