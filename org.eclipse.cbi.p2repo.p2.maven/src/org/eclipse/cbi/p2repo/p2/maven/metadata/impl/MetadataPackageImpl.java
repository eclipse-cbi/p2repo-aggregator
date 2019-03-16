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
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!--
 * end-user-doc -->
 * @generated
 */
public class MetadataPackageImpl extends EPackageImpl implements MetadataPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass documentRootEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass metaDataEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versioningEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass versionsEClass = null;

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
	private EClass snapshotVersionsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass snapshotVersionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model,
	 * and for any others upon which it depends.
	 *
	 * <p>
	 * This method is used to initialize {@link MetadataPackage#eINSTANCE} when
	 * that field is accessed. Clients should not invoke it directly. Instead,
	 * they should simply access that field to obtain the package. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
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

		// Create package meta-data objects
		theMetadataPackage.createPackageContents();

		// Initialize created meta-data
		theMetadataPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMetadataPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MetadataPackage.eNS_URI, theMetadataPackage);
		return theMetadataPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the
	 * package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory
	 * method {@link #init init()}, which also performs initialization of the
	 * package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
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

		versioningEClass = createEClass(VERSIONING);
		createEAttribute(versioningEClass, VERSIONING__RELEASE);
		createEAttribute(versioningEClass, VERSIONING__LATEST);
		createEReference(versioningEClass, VERSIONING__VERSIONS);
		createEAttribute(versioningEClass, VERSIONING__LAST_UPDATED);
		createEReference(versioningEClass, VERSIONING__SNAPSHOT);
		createEReference(versioningEClass, VERSIONING__SNAPSHOT_VERSIONS);

		versionsEClass = createEClass(VERSIONS);
		createEAttribute(versionsEClass, VERSIONS__VERSION);

		snapshotEClass = createEClass(SNAPSHOT);
		createEAttribute(snapshotEClass, SNAPSHOT__TIMESTAMP);
		createEAttribute(snapshotEClass, SNAPSHOT__BUILD_NUMBER);

		snapshotVersionsEClass = createEClass(SNAPSHOT_VERSIONS);
		createEReference(snapshotVersionsEClass, SNAPSHOT_VERSIONS__SNAPSHOT_VERSIONS);

		snapshotVersionEClass = createEClass(SNAPSHOT_VERSION);
		createEAttribute(snapshotVersionEClass, SNAPSHOT_VERSION__EXTENSION);
		createEAttribute(snapshotVersionEClass, SNAPSHOT_VERSION__VALUE);
		createEAttribute(snapshotVersionEClass, SNAPSHOT_VERSION__UPDATED);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDocumentRoot() {
		return documentRootEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_Metadata() {
		return (EReference) documentRootEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDocumentRoot_Mixed() {
		return (EAttribute) documentRootEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_XMLNSPrefixMap() {
		return (EReference) documentRootEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDocumentRoot_XSISchemaLocation() {
		return (EReference) documentRootEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMetaData() {
		return metaDataEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaData_ArtifactId() {
		return (EAttribute) metaDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaData_GroupId() {
		return (EAttribute) metaDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMetaData_Version() {
		return (EAttribute) metaDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMetaData_Versioning() {
		return (EReference) metaDataEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetadataFactory getMetadataFactory() {
		return (MetadataFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVersioning() {
		return versioningEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVersioning_LastUpdated() {
		return (EAttribute) versioningEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVersioning_Snapshot() {
		return (EReference) versioningEClass.getEStructuralFeatures().get(4);
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVersioning_Latest() {
		return (EAttribute) versioningEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVersioning_Release() {
		return (EAttribute) versioningEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVersioning_Versions() {
		return (EReference) versioningEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVersions() {
		return versionsEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVersions_Version() {
		return (EAttribute) versionsEClass.getEStructuralFeatures().get(0);
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
	public EClass getSnapshotVersions() {
		return snapshotVersionsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getSnapshotVersions_SnapshotVersions() {
		return (EReference) snapshotVersionsEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getSnapshotVersion_Extension() {
		return (EAttribute) snapshotVersionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSnapshotVersion_Value() {
		return (EAttribute) snapshotVersionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSnapshotVersion_Updated() {
		return (EAttribute) snapshotVersionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Complete the initialization of the package and its meta-model. This
	 * method is guarded to have no affect on any invocation but its first. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
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

		// Initialize classes and features; add operations and parameters
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
		initEReference(getMetaData_Versioning(), this.getVersioning(), null, "versioning", null, 1, 1, MetaData.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versioningEClass, Versioning.class, "Versioning", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersioning_Release(), theXMLTypePackage.getString(), "release", null, 0, 1, Versioning.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersioning_Latest(), theXMLTypePackage.getString(), "latest", null, 0, 1, Versioning.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersioning_Versions(), this.getVersions(), null, "versions", null, 1, 1, Versioning.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVersioning_LastUpdated(), theXMLTypePackage.getString(), "lastUpdated", null, 0, 1,
				Versioning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getVersioning_Snapshot(), this.getSnapshot(), null, "snapshot", null, 0, 1, Versioning.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVersioning_SnapshotVersions(), this.getSnapshotVersions(), null, "snapshotVersions", null, 0,
				1, Versioning.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(versionsEClass, Versions.class, "Versions", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVersions_Version(), theXMLTypePackage.getString(), "version", null, 1, -1, Versions.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(snapshotEClass, Snapshot.class, "Snapshot", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSnapshot_Timestamp(), theXMLTypePackage.getString(), "timestamp", null, 0, 1, Snapshot.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshot_BuildNumber(), theXMLTypePackage.getString(), "buildNumber", null, 0, 1,
				Snapshot.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(snapshotVersionsEClass, SnapshotVersions.class, "SnapshotVersions", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSnapshotVersions_SnapshotVersions(), this.getSnapshotVersion(), null, "snapshotVersions",
				null, 0, -1, SnapshotVersions.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(snapshotVersionEClass, SnapshotVersion.class, "SnapshotVersion", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSnapshotVersion_Extension(), theXMLTypePackage.getString(), "extension", null, 0, 1,
				SnapshotVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshotVersion_Value(), theXMLTypePackage.getString(), "value", null, 0, 1,
				SnapshotVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getSnapshotVersion_Updated(), theXMLTypePackage.getString(), "updated", null, 0, 1,
				SnapshotVersion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for
	 * <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
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
		addAnnotation(versioningEClass, source, new String[] { "name", "Versioning", "kind", "elementOnly" });
		addAnnotation(getVersioning_Release(), source,
				new String[] { "kind", "element", "name", "release", "namespace", "##targetNamespace" });
		addAnnotation(getVersioning_Latest(), source,
				new String[] { "kind", "element", "name", "latest", "namespace", "##targetNamespace" });
		addAnnotation(getVersioning_Versions(), source,
				new String[] { "kind", "element", "name", "versions", "namespace", "##targetNamespace" });
		addAnnotation(getVersioning_LastUpdated(), source,
				new String[] { "kind", "element", "name", "lastUpdated", "namespace", "##targetNamespace" });
		addAnnotation(versionsEClass, source, new String[] { "name", "Versions", "kind", "elementOnly" });
		addAnnotation(getVersions_Version(), source,
				new String[] { "kind", "element", "name", "version", "namespace", "##targetNamespace" });
		addAnnotation(snapshotEClass, source, new String[] { "name", "SnapshotVersions", "kind", "elementOnly" });
		addAnnotation(getSnapshot_Timestamp(), source,
				new String[] { "kind", "element", "name", "timestamp", "namespace", "##targetNamespace" });
		addAnnotation(getSnapshot_BuildNumber(), source,
				new String[] { "kind", "element", "name", "buildNumber", "namespace", "##targetNamespace" });
		addAnnotation(snapshotVersionsEClass, source,
				new String[] { "name", "SnapshotVersions", "kind", "elementOnly" });
		addAnnotation(getSnapshotVersion_Extension(), source,
				new String[] { "kind", "element", "name", "extension", "namespace", "##targetNamespace" });
		addAnnotation(getSnapshotVersion_Value(), source,
				new String[] { "kind", "element", "name", "value", "namespace", "##targetNamespace" });
		addAnnotation(getSnapshotVersion_Updated(), source,
				new String[] { "kind", "element", "name", "updated", "namespace", "##targetNamespace" });
	}

} // MetadataPackageImpl
