/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 */
package org.eclipse.cbi.p2repo.p2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor;
import org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Artifact
 * Descriptor</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.ArtifactDescriptor#getPropertyMap <em>Property Map</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.ArtifactDescriptor#getProcessingStepList <em>Processing Step List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.P2Package#getArtifactDescriptor()
 * @model superTypes="org.eclipse.cbi.p2repo.p2.IArtifactDescriptor"
 * @generated
 */
public interface ArtifactDescriptor extends IArtifactDescriptor {
	/**
	 * Returns the value of the '<em><b>Processing Step List</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processing Step List</em>' reference list
	 * isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processing Step List</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.p2.P2Package#getArtifactDescriptor_ProcessingStepList()
	 * @model type="org.eclipse.cbi.p2repo.p2.IProcessingStepDescriptor" containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IProcessingStepDescriptor> getProcessingStepList();

	/**
	 * Returns the value of the '<em><b>Property Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Property Map</em>' map isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Property Map</em>' map.
	 * @see org.eclipse.cbi.p2repo.p2.P2Package#getArtifactDescriptor_PropertyMap()
	 * @model mapType="org.eclipse.cbi.p2repo.p2.Property&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString&gt;"
	 * @generated
	 */
	EMap<String, String> getPropertyMap();

} // ArtifactDescriptor
