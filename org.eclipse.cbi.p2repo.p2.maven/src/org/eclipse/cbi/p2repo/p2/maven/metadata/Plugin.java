/**
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plugin</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * 1.0.0+
 * Mapping information for a single plugin within this group
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin#getPrefix <em>Prefix</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin#getArtifactId <em>Artifact Id</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getPlugin()
 * @model extendedMetaData="name='Plugin' kind='elementOnly'"
 * @generated
 */
public interface Plugin extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 1.0.0+
	 * Display name for the plugin.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getPlugin_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='name' namespace='##targetNamespace'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Prefix</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 1.0.0+
	 * The plugin invocation prefix (i.e. eclipse for eclipse:eclipse)
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Prefix</em>' attribute.
	 * @see #setPrefix(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getPlugin_Prefix()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='prefix' namespace='##targetNamespace'"
	 * @generated
	 */
	String getPrefix();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin#getPrefix <em>Prefix</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prefix</em>' attribute.
	 * @see #getPrefix()
	 * @generated
	 */
	void setPrefix(String value);

	/**
	 * Returns the value of the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * 1.0.0+
	 * The plugin artifactId
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Artifact Id</em>' attribute.
	 * @see #setArtifactId(String)
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getPlugin_ArtifactId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='artifactId' namespace='##targetNamespace'"
	 * @generated
	 */
	String getArtifactId();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin#getArtifactId <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Id</em>' attribute.
	 * @see #getArtifactId()
	 * @generated
	 */
	void setArtifactId(String value);

} // Plugin
