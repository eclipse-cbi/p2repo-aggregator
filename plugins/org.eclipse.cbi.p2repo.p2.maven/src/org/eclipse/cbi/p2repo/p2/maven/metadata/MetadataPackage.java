/**
 * Copyright (c) 2021 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model. It contains
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.DocumentRootImpl <em>Document Root</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.DocumentRootImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getDocumentRoot()
		 * @generated
		 */
		EClass DOCUMENT_ROOT = eINSTANCE.getDocumentRoot();

		/**
		 * The meta object literal for the '<em><b>Mixed</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOCUMENT_ROOT__MIXED = eINSTANCE.getDocumentRoot_Mixed();

		/**
		 * The meta object literal for the '<em><b>XMLNS Prefix Map</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XMLNS_PREFIX_MAP = eINSTANCE.getDocumentRoot_XMLNSPrefixMap();

		/**
		 * The meta object literal for the '<em><b>XSI Schema Location</b></em>' map feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = eINSTANCE.getDocumentRoot_XSISchemaLocation();

		/**
		 * The meta object literal for the '<em><b>Metadata</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DOCUMENT_ROOT__METADATA = eINSTANCE.getDocumentRoot_Metadata();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl <em>Meta Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getMetaData()
		 * @generated
		 */
		EClass META_DATA = eINSTANCE.getMetaData();

		/**
		 * The meta object literal for the '<em><b>Group Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA__GROUP_ID = eINSTANCE.getMetaData_GroupId();

		/**
		 * The meta object literal for the '<em><b>Artifact Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA__ARTIFACT_ID = eINSTANCE.getMetaData_ArtifactId();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA__VERSION = eINSTANCE.getMetaData_Version();

		/**
		 * The meta object literal for the '<em><b>Versioning</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_DATA__VERSIONING = eINSTANCE.getMetaData_Versioning();

		/**
		 * The meta object literal for the '<em><b>Plugins</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference META_DATA__PLUGINS = eINSTANCE.getMetaData_Plugins();

		/**
		 * The meta object literal for the '<em><b>Model Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute META_DATA__MODEL_VERSION = eINSTANCE.getMetaData_ModelVersion();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.PluginImpl <em>Plugin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.PluginImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getPlugin()
		 * @generated
		 */
		EClass PLUGIN = eINSTANCE.getPlugin();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__NAME = eINSTANCE.getPlugin_Name();

		/**
		 * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__PREFIX = eINSTANCE.getPlugin_Prefix();

		/**
		 * The meta object literal for the '<em><b>Artifact Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PLUGIN__ARTIFACT_ID = eINSTANCE.getPlugin_ArtifactId();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.PluginsTypeImpl <em>Plugins Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.PluginsTypeImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getPluginsType()
		 * @generated
		 */
		EClass PLUGINS_TYPE = eINSTANCE.getPluginsType();

		/**
		 * The meta object literal for the '<em><b>Plugin</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLUGINS_TYPE__PLUGIN = eINSTANCE.getPluginsType_Plugin();

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl <em>Versioning</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getVersioning()
		 * @generated
		 */
		EClass VERSIONING = eINSTANCE.getVersioning();

		/**
		 * The meta object literal for the '<em><b>Release</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSIONING__RELEASE = eINSTANCE.getVersioning_Release();

		/**
		 * The meta object literal for the '<em><b>Latest</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSIONING__LATEST = eINSTANCE.getVersioning_Latest();

		/**
		 * The meta object literal for the '<em><b>Versions</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERSIONING__VERSIONS = eINSTANCE.getVersioning_Versions();

		/**
		 * The meta object literal for the '<em><b>Last Updated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
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
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersionsTypeImpl <em>Versions Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersionsTypeImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getVersionsType()
		 * @generated
		 */
		EClass VERSIONS_TYPE = eINSTANCE.getVersionsType();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERSIONS_TYPE__VERSION = eINSTANCE.getVersionsType_Version();

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
		 * The meta object literal for the '<em><b>Local Copy</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT__LOCAL_COPY = eINSTANCE.getSnapshot_LocalCopy();

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
		 * The meta object literal for the '<em><b>Classifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SNAPSHOT_VERSION__CLASSIFIER = eINSTANCE.getSnapshotVersion_Classifier();

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

		/**
		 * The meta object literal for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionsTypeImpl <em>Snapshot Versions Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionsTypeImpl
		 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getSnapshotVersionsType()
		 * @generated
		 */
		EClass SNAPSHOT_VERSIONS_TYPE = eINSTANCE.getSnapshotVersionsType();

		/**
		 * The meta object literal for the '<em><b>Snapshot Version</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SNAPSHOT_VERSIONS_TYPE__SNAPSHOT_VERSION = eINSTANCE.getSnapshotVersionsType_SnapshotVersion();

	}

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "metadata";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://maven.apache.org/METADATA/1.1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "";

	/**
	 * The package content type ID.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eCONTENT_TYPE = "org.eclipse.cbi.p2repo.maven.p2.metadata";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	MetadataPackage eINSTANCE = org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.DocumentRootImpl <em>Document Root</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.DocumentRootImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getDocumentRoot()
	 * @generated
	 */
	int DOCUMENT_ROOT = 0;

	/**
	 * The feature id for the '<em><b>Mixed</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__MIXED = 0;

	/**
	 * The feature id for the '<em><b>XMLNS Prefix Map</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XMLNS_PREFIX_MAP = 1;

	/**
	 * The feature id for the '<em><b>XSI Schema Location</b></em>' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__XSI_SCHEMA_LOCATION = 2;

	/**
	 * The feature id for the '<em><b>Metadata</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT__METADATA = 3;

	/**
	 * The number of structural features of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Document Root</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOCUMENT_ROOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl <em>Meta Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getMetaData()
	 * @generated
	 */
	int META_DATA = 1;

	/**
	 * The feature id for the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA__GROUP_ID = 0;

	/**
	 * The feature id for the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA__ARTIFACT_ID = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Versioning</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA__VERSIONING = 3;

	/**
	 * The feature id for the '<em><b>Plugins</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA__PLUGINS = 4;

	/**
	 * The feature id for the '<em><b>Model Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA__MODEL_VERSION = 5;

	/**
	 * The number of structural features of the '<em>Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Meta Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int META_DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.PluginImpl <em>Plugin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.PluginImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getPlugin()
	 * @generated
	 */
	int PLUGIN = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__NAME = 0;

	/**
	 * The feature id for the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__PREFIX = 1;

	/**
	 * The feature id for the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN__ARTIFACT_ID = 2;

	/**
	 * The number of structural features of the '<em>Plugin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Plugin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGIN_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.PluginsTypeImpl <em>Plugins Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.PluginsTypeImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getPluginsType()
	 * @generated
	 */
	int PLUGINS_TYPE = 3;

	/**
	 * The feature id for the '<em><b>Plugin</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGINS_TYPE__PLUGIN = 0;

	/**
	 * The number of structural features of the '<em>Plugins Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGINS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Plugins Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLUGINS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl <em>Versioning</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getVersioning()
	 * @generated
	 */
	int VERSIONING = 7;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersionsTypeImpl <em>Versions Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersionsTypeImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getVersionsType()
	 * @generated
	 */
	int VERSIONS_TYPE = 8;

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
	 * The feature id for the '<em><b>Local Copy</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT__LOCAL_COPY = 2;

	/**
	 * The number of structural features of the '<em>Snapshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Snapshot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionImpl <em>Snapshot Version</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getSnapshotVersion()
	 * @generated
	 */
	int SNAPSHOT_VERSION = 5;

	/**
	 * The feature id for the '<em><b>Classifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSION__CLASSIFIER = 0;

	/**
	 * The feature id for the '<em><b>Extension</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSION__EXTENSION = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSION__VALUE = 2;

	/**
	 * The feature id for the '<em><b>Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSION__UPDATED = 3;

	/**
	 * The number of structural features of the '<em>Snapshot Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSION_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Snapshot Version</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionsTypeImpl <em>Snapshot Versions Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionsTypeImpl
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetadataPackageImpl#getSnapshotVersionsType()
	 * @generated
	 */
	int SNAPSHOT_VERSIONS_TYPE = 6;

	/**
	 * The feature id for the '<em><b>Snapshot Version</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSIONS_TYPE__SNAPSHOT_VERSION = 0;

	/**
	 * The number of structural features of the '<em>Snapshot Versions Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSIONS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Snapshot Versions Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SNAPSHOT_VERSIONS_TYPE_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Latest</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONING__LATEST = 0;

	/**
	 * The feature id for the '<em><b>Release</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONING__RELEASE = 1;

	/**
	 * The feature id for the '<em><b>Snapshot</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONING__SNAPSHOT = 2;

	/**
	 * The feature id for the '<em><b>Versions</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONING__VERSIONS = 3;

	/**
	 * The feature id for the '<em><b>Last Updated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONING__LAST_UPDATED = 4;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONING_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Versioning</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONING_OPERATION_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONS_TYPE__VERSION = 0;

	/**
	 * The number of structural features of the '<em>Versions Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONS_TYPE_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Versions Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERSIONS_TYPE_OPERATION_COUNT = 0;

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot <em>Document Root</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Document Root</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot
	 * @generated
	 */
	EClass getDocumentRoot();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getMetadata <em>Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Metadata</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getMetadata()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_Metadata();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getMixed <em>Mixed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Mixed</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getMixed()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EAttribute getDocumentRoot_Mixed();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getXMLNSPrefixMap <em>XMLNS Prefix Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XMLNS Prefix Map</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getXMLNSPrefixMap()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XMLNSPrefixMap();

	/**
	 * Returns the meta object for the map '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getXSISchemaLocation <em>XSI Schema Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the map '<em>XSI Schema Location</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot#getXSISchemaLocation()
	 * @see #getDocumentRoot()
	 * @generated
	 */
	EReference getDocumentRoot_XSISchemaLocation();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData <em>Meta Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Meta Data</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData
	 * @generated
	 */
	EClass getMetaData();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getArtifactId <em>Artifact Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Artifact Id</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getArtifactId()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_ArtifactId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getGroupId <em>Group Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Group Id</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getGroupId()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_GroupId();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getVersion()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_Version();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getVersioning <em>Versioning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Versioning</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getVersioning()
	 * @see #getMetaData()
	 * @generated
	 */
	EReference getMetaData_Versioning();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getPlugins <em>Plugins</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Plugins</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getPlugins()
	 * @see #getMetaData()
	 * @generated
	 */
	EReference getMetaData_Plugins();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getModelVersion <em>Model Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Model Version</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getModelVersion()
	 * @see #getMetaData()
	 * @generated
	 */
	EAttribute getMetaData_ModelVersion();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugin</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin
	 * @generated
	 */
	EClass getPlugin();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin#getName()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_Name();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin#getPrefix <em>Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prefix</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin#getPrefix()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_Prefix();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin#getArtifactId <em>Artifact Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Artifact Id</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin#getArtifactId()
	 * @see #getPlugin()
	 * @generated
	 */
	EAttribute getPlugin_ArtifactId();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.PluginsType <em>Plugins Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Plugins Type</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.PluginsType
	 * @generated
	 */
	EClass getPluginsType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.PluginsType#getPlugin <em>Plugin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Plugin</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.PluginsType#getPlugin()
	 * @see #getPluginsType()
	 * @generated
	 */
	EReference getPluginsType_Plugin();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	MetadataFactory getMetadataFactory();

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning <em>Versioning</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Versioning</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning
	 * @generated
	 */
	EClass getVersioning();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getLastUpdated <em>Last Updated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.VersionsType <em>Versions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Versions Type</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.VersionsType
	 * @generated
	 */
	EClass getVersionsType();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.VersionsType#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Version</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.VersionsType#getVersion()
	 * @see #getVersionsType()
	 * @generated
	 */
	EAttribute getVersionsType_Version();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getLatest <em>Latest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latest</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getLatest()
	 * @see #getVersioning()
	 * @generated
	 */
	EAttribute getVersioning_Latest();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getRelease <em>Release</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Release</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getRelease()
	 * @see #getVersioning()
	 * @generated
	 */
	EAttribute getVersioning_Release();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getVersions <em>Versions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Versions</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning#getVersions()
	 * @see #getVersioning()
	 * @generated
	 */
	EReference getVersioning_Versions();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#isLocalCopy <em>Local Copy</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Local Copy</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot#isLocalCopy()
	 * @see #getSnapshot()
	 * @generated
	 */
	EAttribute getSnapshot_LocalCopy();

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
	 * Returns the meta object for the attribute '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getClassifier <em>Classifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Classifier</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion#getClassifier()
	 * @see #getSnapshotVersion()
	 * @generated
	 */
	EAttribute getSnapshotVersion_Classifier();

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

	/**
	 * Returns the meta object for class '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersionsType <em>Snapshot Versions Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Snapshot Versions Type</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersionsType
	 * @generated
	 */
	EClass getSnapshotVersionsType();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersionsType#getSnapshotVersion <em>Snapshot Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Snapshot Version</em>'.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersionsType#getSnapshotVersion()
	 * @see #getSnapshotVersionsType()
	 * @generated
	 */
	EReference getSnapshotVersionsType_SnapshotVersion();

} // MetadataPackage
