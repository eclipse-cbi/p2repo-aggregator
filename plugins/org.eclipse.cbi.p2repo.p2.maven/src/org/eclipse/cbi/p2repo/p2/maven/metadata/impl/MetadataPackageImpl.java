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
import org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage;
import org.eclipse.cbi.p2repo.p2.maven.pom.impl.PomPackageImpl;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MetadataPackageImpl extends EPackageImpl implements MetadataPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pluginEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pluginsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versioningEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass snapshotEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass snapshotVersionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass snapshotVersionsTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link MetadataPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MetadataPackage init() {
		if (isInited)
			return (MetadataPackage) EPackage.Registry.INSTANCE.getEPackage(MetadataPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMetadataPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MetadataPackageImpl theMetadataPackage = registeredMetadataPackage instanceof MetadataPackageImpl
				? (MetadataPackageImpl) registeredMetadataPackage
				: new MetadataPackageImpl();

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(PomPackage.eNS_URI);
		PomPackageImpl thePomPackage = (PomPackageImpl) (registeredPackage instanceof PomPackageImpl ? registeredPackage
				: PomPackage.eINSTANCE);

		// Create package meta-data objects
		theMetadataPackage.createPackageContents();
		thePomPackage.createPackageContents();

		// Initialize created meta-data
		theMetadataPackage.initializePackageContents();
		thePomPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetadataPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetadataPackage.eNS_URI, theMetadataPackage);
		return theMetadataPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MetadataPackageImpl() {
		super(eNS_URI, MetadataFactory.eINSTANCE);
	}

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		documentRootEClass = createEClass(DOCUMENT_ROOT);
		createEAttribute(documentRootEClass, DOCUMENT_ROOT__MIXED);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XMLNS_PREFIX_MAP);
		createEReference(documentRootEClass, DOCUMENT_ROOT__XSI_SCHEMA_LOCATION);
		createEReference(documentRootEClass, DOCUMENT_ROOT__METADATA);

		metaDataEClass = createEClass(META_DATA);
		createEAttribute(metaDataEClass, META_DATA__GROUP_ID);
		createEAttribute(metaDataEClass, META_DATA__ARTIFACT_ID);
		createEAttribute(metaDataEClass, META_DATA__VERSION);
		createEReference(metaDataEClass, META_DATA__VERSIONING);
		createEReference(metaDataEClass, META_DATA__PLUGINS);
		createEAttribute(metaDataEClass, META_DATA__MODEL_VERSION);

		pluginEClass = createEClass(PLUGIN);
		createEAttribute(pluginEClass, PLUGIN__NAME);
		createEAttribute(pluginEClass, PLUGIN__PREFIX);
		createEAttribute(pluginEClass, PLUGIN__ARTIFACT_ID);

		pluginsTypeEClass = createEClass(PLUGINS_TYPE);
		createEReference(pluginsTypeEClass, PLUGINS_TYPE__PLUGIN);

		snapshotEClass = createEClass(SNAPSHOT);
		createEAttribute(snapshotEClass, SNAPSHOT__TIMESTAMP);
		createEAttribute(snapshotEClass, SNAPSHOT__BUILD_NUMBER);
		createEAttribute(snapshotEClass, SNAPSHOT__LOCAL_COPY);

		snapshotVersionEClass = createEClass(SNAPSHOT_VERSION);
		createEAttribute(snapshotVersionEClass, SNAPSHOT_VERSION__CLASSIFIER);
		createEAttribute(snapshotVersionEClass, SNAPSHOT_VERSION__EXTENSION);
		createEAttribute(snapshotVersionEClass, SNAPSHOT_VERSION__VALUE);
		createEAttribute(snapshotVersionEClass, SNAPSHOT_VERSION__UPDATED);

		snapshotVersionsTypeEClass = createEClass(SNAPSHOT_VERSIONS_TYPE);
		createEReference(snapshotVersionsTypeEClass, SNAPSHOT_VERSIONS_TYPE__SNAPSHOT_VERSION);

		versioningEClass = createEClass(VERSIONING);
		createEAttribute(versioningEClass, VERSIONING__LATEST);
		createEAttribute(versioningEClass, VERSIONING__RELEASE);
		createEReference(versioningEClass, VERSIONING__SNAPSHOT);
		createEReference(versioningEClass, VERSIONING__VERSIONS);
		createEAttribute(versioningEClass, VERSIONING__LAST_UPDATED);
		createEReference(versioningEClass, VERSIONING__SNAPSHOT_VERSIONS);

		versionsTypeEClass = createEClass(VERSIONS_TYPE);
		createEAttribute(versionsTypeEClass, VERSIONS_TYPE__VERSION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_Metadata() {
		return (EReference) documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute) documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference) documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference) documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetaData() {
		return metaDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaData_ArtifactId() {
		return (EAttribute) metaDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaData_GroupId() {
		return (EAttribute) metaDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaData_Version() {
		return (EAttribute) metaDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetaData_Versioning() {
		return (EReference) metaDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetaData_Plugins() {
		return (EReference) metaDataEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaData_ModelVersion() {
		return (EAttribute) metaDataEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPlugin() {
		return pluginEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPlugin_Name() {
		return (EAttribute) pluginEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPlugin_Prefix() {
		return (EAttribute) pluginEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getPlugin_ArtifactId() {
		return (EAttribute) pluginEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getPluginsType() {
		return pluginsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getPluginsType_Plugin() {
		return (EReference) pluginsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetadataFactory getMetadataFactory() {
		return (MetadataFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVersioning() {
		return versioningEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVersioning_LastUpdated() {
		return (EAttribute) versioningEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVersioning_Snapshot() {
		return (EReference) versioningEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVersioning_SnapshotVersions() {
		return (EReference) versioningEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVersionsType() {
		return versionsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVersionsType_Version() {
		return (EAttribute) versionsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVersioning_Latest() {
		return (EAttribute) versioningEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVersioning_Release() {
		return (EAttribute) versioningEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVersioning_Versions() {
		return (EReference) versioningEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSnapshot() {
		return snapshotEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSnapshot_Timestamp() {
		return (EAttribute) snapshotEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSnapshot_BuildNumber() {
		return (EAttribute) snapshotEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSnapshot_LocalCopy() {
		return (EAttribute) snapshotEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSnapshotVersion() {
		return snapshotVersionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSnapshotVersion_Classifier() {
		return (EAttribute) snapshotVersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSnapshotVersion_Extension() {
		return (EAttribute) snapshotVersionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSnapshotVersion_Value() {
		return (EAttribute) snapshotVersionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSnapshotVersion_Updated() {
		return (EAttribute) snapshotVersionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSnapshotVersionsType() {
		return snapshotVersionsTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSnapshotVersionsType_SnapshotVersion() {
		return (EReference) snapshotVersionsTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage) EPackage.Registry.INSTANCE
				.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes, features, and operations; add parameters
		initEClass(documentRootEClass, DocumentRoot.class, "DocumentRoot", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDocumentRoot_Mixed(), ecorePackage.getEFeatureMapEntry(), "mixed", null, 0, -1, null,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEReference(getDocumentRoot_XMLNSPrefixMap(), ecorePackage.getEStringToStringMapEntry(), null,
				"xMLNSPrefixMap", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_XSISchemaLocation(), ecorePackage.getEStringToStringMapEntry(), null,
				"xSISchemaLocation", null, 0, -1, null, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDocumentRoot_Metadata(), this.getMetaData(), null, "metadata", null, 0, -2, null,
				IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);

		initEClass(metaDataEClass, MetaData.class, "MetaData", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMetaData_GroupId(), theXMLTypePackage.getString(), "groupId", null, 0, 1, MetaData.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaData_ArtifactId(), theXMLTypePackage.getString(), "artifactId", null, 0, 1,
				MetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaData_Version(), theXMLTypePackage.getString(), "version", null, 0, 1, MetaData.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetaData_Versioning(), this.getVersioning(), null, "versioning", null, 0, 1, MetaData.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMetaData_Plugins(), this.getPluginsType(), null, "plugins", null, 0, 1, MetaData.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMetaData_ModelVersion(), theXMLTypePackage.getString(), "modelVersion", null, 0, 1,
				MetaData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(pluginEClass, Plugin.class, "Plugin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPlugin_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Plugin.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlugin_Prefix(), theXMLTypePackage.getString(), "prefix", null, 0, 1, Plugin.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPlugin_ArtifactId(), theXMLTypePackage.getString(), "artifactId", null, 0, 1, Plugin.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pluginsTypeEClass, PluginsType.class, "PluginsType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPluginsType_Plugin(), this.getPlugin(), null, "plugin", null, 0, -1, PluginsType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(snapshotEClass, Snapshot.class, "Snapshot", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSnapshot_Timestamp(), theXMLTypePackage.getString(), "timestamp", null, 0, 1, Snapshot.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshot_BuildNumber(), theXMLTypePackage.getInt(), "buildNumber", "0", 0, 1, Snapshot.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshot_LocalCopy(), theXMLTypePackage.getBoolean(), "localCopy", "false", 0, 1,
				Snapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(snapshotVersionEClass, SnapshotVersion.class, "SnapshotVersion", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSnapshotVersion_Classifier(), theXMLTypePackage.getString(), "classifier", "", 0, 1,
				SnapshotVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshotVersion_Extension(), theXMLTypePackage.getString(), "extension", null, 0, 1,
				SnapshotVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshotVersion_Value(), theXMLTypePackage.getString(), "value", null, 0, 1,
				SnapshotVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshotVersion_Updated(), theXMLTypePackage.getString(), "updated", null, 0, 1,
				SnapshotVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(snapshotVersionsTypeEClass, SnapshotVersionsType.class, "SnapshotVersionsType", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSnapshotVersionsType_SnapshotVersion(), this.getSnapshotVersion(), null, "snapshotVersion",
				null, 0, -1, SnapshotVersionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versioningEClass, Versioning.class, "Versioning", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersioning_Latest(), theXMLTypePackage.getString(), "latest", null, 0, 1, Versioning.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersioning_Release(), theXMLTypePackage.getString(), "release", null, 0, 1, Versioning.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersioning_Snapshot(), this.getSnapshot(), null, "snapshot", null, 0, 1, Versioning.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersioning_Versions(), this.getVersionsType(), null, "versions", null, 0, 1, Versioning.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersioning_LastUpdated(), theXMLTypePackage.getString(), "lastUpdated", null, 0, 1,
				Versioning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getVersioning_SnapshotVersions(), this.getSnapshotVersionsType(), null, "snapshotVersions", null,
				0, 1, Versioning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionsTypeEClass, VersionsType.class, "VersionsType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersionsType_Version(), theXMLTypePackage.getString(), "version", null, 0, -1,
				VersionsType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";
		addAnnotation(documentRootEClass, source, new String[] { "name", "", "kind", "mixed" });
		addAnnotation(getDocumentRoot_Mixed(), source, new String[] { "kind", "elementWildcard", "name", ":mixed" });
		addAnnotation(getDocumentRoot_XMLNSPrefixMap(), source,
				new String[] { "kind", "attribute", "name", "xmlns:prefix" });
		addAnnotation(getDocumentRoot_XSISchemaLocation(), source,
				new String[] { "kind", "attribute", "name", "xsi:schemaLocation" });
		addAnnotation(getDocumentRoot_Metadata(), source,
				new String[] { "kind", "element", "name", "metadata", "namespace", "##targetNamespace" });
		addAnnotation(metaDataEClass, source, new String[] { "name", "MetaData", "kind", "elementOnly" });
		addAnnotation(getMetaData_GroupId(), source,
				new String[] { "kind", "element", "name", "groupId", "namespace", "##targetNamespace" });
		addAnnotation(getMetaData_ArtifactId(), source,
				new String[] { "kind", "element", "name", "artifactId", "namespace", "##targetNamespace" });
		addAnnotation(getMetaData_Version(), source,
				new String[] { "kind", "element", "name", "version", "namespace", "##targetNamespace" });
		addAnnotation(getMetaData_Versioning(), source,
				new String[] { "kind", "element", "name", "versioning", "namespace", "##targetNamespace" });
		addAnnotation(getMetaData_Plugins(), source,
				new String[] { "kind", "element", "name", "plugins", "namespace", "##targetNamespace" });
		addAnnotation(getMetaData_ModelVersion(), source, new String[] { "kind", "attribute", "name", "modelVersion" });
		addAnnotation(pluginEClass, source, new String[] { "name", "Plugin", "kind", "elementOnly" });
		addAnnotation(getPlugin_Name(), source,
				new String[] { "kind", "element", "name", "name", "namespace", "##targetNamespace" });
		addAnnotation(getPlugin_Prefix(), source,
				new String[] { "kind", "element", "name", "prefix", "namespace", "##targetNamespace" });
		addAnnotation(getPlugin_ArtifactId(), source,
				new String[] { "kind", "element", "name", "artifactId", "namespace", "##targetNamespace" });
		addAnnotation(pluginsTypeEClass, source, new String[] { "name", "plugins_._type", "kind", "elementOnly" });
		addAnnotation(getPluginsType_Plugin(), source,
				new String[] { "kind", "element", "name", "plugin", "namespace", "##targetNamespace" });
		addAnnotation(snapshotEClass, source, new String[] { "name", "Snapshot", "kind", "elementOnly" });
		addAnnotation(getSnapshot_Timestamp(), source,
				new String[] { "kind", "element", "name", "timestamp", "namespace", "##targetNamespace" });
		addAnnotation(getSnapshot_BuildNumber(), source,
				new String[] { "kind", "element", "name", "buildNumber", "namespace", "##targetNamespace" });
		addAnnotation(getSnapshot_LocalCopy(), source,
				new String[] { "kind", "element", "name", "localCopy", "namespace", "##targetNamespace" });
		addAnnotation(snapshotVersionEClass, source, new String[] { "name", "SnapshotVersion", "kind", "elementOnly" });
		addAnnotation(getSnapshotVersion_Classifier(), source,
				new String[] { "kind", "element", "name", "classifier", "namespace", "##targetNamespace" });
		addAnnotation(getSnapshotVersion_Extension(), source,
				new String[] { "kind", "element", "name", "extension", "namespace", "##targetNamespace" });
		addAnnotation(getSnapshotVersion_Value(), source,
				new String[] { "kind", "element", "name", "value", "namespace", "##targetNamespace" });
		addAnnotation(getSnapshotVersion_Updated(), source,
				new String[] { "kind", "element", "name", "updated", "namespace", "##targetNamespace" });
		addAnnotation(snapshotVersionsTypeEClass, source,
				new String[] { "name", "snapshotVersions_._type", "kind", "elementOnly" });
		addAnnotation(getSnapshotVersionsType_SnapshotVersion(), source,
				new String[] { "kind", "element", "name", "snapshotVersion", "namespace", "##targetNamespace" });
		addAnnotation(versioningEClass, source, new String[] { "name", "Versioning", "kind", "elementOnly" });
		addAnnotation(getVersioning_Latest(), source,
				new String[] { "kind", "element", "name", "latest", "namespace", "##targetNamespace" });
		addAnnotation(getVersioning_Release(), source,
				new String[] { "kind", "element", "name", "release", "namespace", "##targetNamespace" });
		addAnnotation(getVersioning_Snapshot(), source,
				new String[] { "kind", "element", "name", "snapshot", "namespace", "##targetNamespace" });
		addAnnotation(getVersioning_Versions(), source,
				new String[] { "kind", "element", "name", "versions", "namespace", "##targetNamespace" });
		addAnnotation(getVersioning_LastUpdated(), source,
				new String[] { "kind", "element", "name", "lastUpdated", "namespace", "##targetNamespace" });
		addAnnotation(getVersioning_SnapshotVersions(), source,
				new String[] { "kind", "element", "name", "snapshotVersions", "namespace", "##targetNamespace" });
		addAnnotation(versionsTypeEClass, source, new String[] { "name", "versions_._type", "kind", "elementOnly" });
		addAnnotation(getVersionsType_Version(), source,
				new String[] { "kind", "element", "name", "version", "namespace", "##targetNamespace" });
	}

} // MetadataPackageImpl
