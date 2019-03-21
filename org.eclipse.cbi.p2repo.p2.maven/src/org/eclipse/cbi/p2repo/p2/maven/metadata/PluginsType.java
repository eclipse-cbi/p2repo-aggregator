/**
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Plugins Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.PluginsType#getPlugin <em>Plugin</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getPluginsType()
 * @model extendedMetaData="name='plugins_._type' kind='elementOnly'"
 * @generated
 */
public interface PluginsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Plugin</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.p2.maven.metadata.Plugin}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Plugin</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getPluginsType_Plugin()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='plugin' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Plugin> getPlugin();

} // PluginsType
