/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Meta
 * Data</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 1.0.0+
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getArtifactId <em>Artifact Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getVersioning <em>Versioning</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getPlugins <em>Plugins</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getModelVersion <em>Model Version</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getMetaData()
 * @model extendedMetaData="name='MetaData' kind='elementOnly'"
 * @generated
 */
public interface MetaData extends EObject {
	/**
	 * Returns the value of the '<em><b>Artifact Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 *
	 * 1.0.0
	 *
	 *
	 * The identifier for this artifact that is unique within the group given by
	 * the group ID. An artifact is something that is either produced or used by
	 * a project. Examples of artifacts produced by Maven for a project include:
	 * JARs, source and binary distributions, and WARs.
	 *
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Artifact Id</em>' attribute.
	 * @see #setArtifactId(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getMetaData_ArtifactId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='artifactId'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	String getArtifactId();

	/**
	 * Returns the value of the '<em><b>Group Id</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 *
	 * 1.0.0
	 *
	 *
	 * A universally unique identifier for a project. It is normal to use a
	 * fully-qualified package name to distinguish it from other projects with a
	 * similar name (eg. &lt;code&gt;org.apache.maven&lt;/code&gt;).
	 *
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Group Id</em>' attribute.
	 * @see #setGroupId(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getMetaData_GroupId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='groupId'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	String getGroupId();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc -->
	 *
	 * 1.0.0
	 *
	 *
	 * The current version of the artifact produced by this project.
	 *
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getMetaData_Version()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='version'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	String getVersion();

	/**
	 * Returns the value of the '<em><b>Versioning</b></em>' containment
	 * reference. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
	 * begin-model-doc -->
	 *
	 * 1.0.0
	 *
	 *
	 * Container for he set of versions in the repository for this artifact and
	 * the last update time.
	 *
	 * <!-- end-model-doc -->
	 *
	 * @return the value of the '<em>Versioning</em>' containment reference.
	 * @see #setVersioning(Versioning)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getMetaData_Versioning()
	 * @model containment="true" required="true"
	 *        extendedMetaData="kind='element' name='versioning'
	 *        namespace='##targetNamespace'"
	 * @generated
	 */
	Versioning getVersioning();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getArtifactId <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Artifact Id</em>' attribute.
	 * @see #getArtifactId()
	 * @generated
	 */
	void setArtifactId(String value);

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getGroupId
	 * <em>Group Id</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @param value
	 *            the new value of the '<em>Group Id</em>' attribute.
	 * @see #getGroupId()
	 * @generated
	 */
	void setGroupId(String value);

	/**
	 * Sets the value of the
	 * '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getVersion
	 * <em>Version</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @param value
	 *            the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getVersioning <em>Versioning</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @param value the new value of the '<em>Versioning</em>' containment reference.
	 * @see #getVersioning()
	 * @generated
	 */
	void setVersioning(Versioning value);

	/**
	 * Returns the value of the '<em><b>Plugins</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 1.0.0+
	 * The set of plugin mappings for the group represented by this directory
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Plugins</em>' containment reference.
	 * @see #setPlugins(PluginsType)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getMetaData_Plugins()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='plugins' namespace='##targetNamespace'"
	 * @generated
	 */
	PluginsType getPlugins();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getPlugins <em>Plugins</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Plugins</em>' containment reference.
	 * @see #getPlugins()
	 * @generated
	 */
	void setPlugins(PluginsType value);

	/**
	 * Returns the value of the '<em><b>Model Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 1.1.0+
	 * The version of the underlying metadata model.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Model Version</em>' attribute.
	 * @see #setModelVersion(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getMetaData_ModelVersion()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='modelVersion'"
	 * @generated
	 */
	String getModelVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData#getModelVersion <em>Model Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Model Version</em>' attribute.
	 * @see #getModelVersion()
	 * @generated
	 */
	void setModelVersion(String value);

} // MetaData
