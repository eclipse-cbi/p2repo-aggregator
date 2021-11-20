/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.p2;

import java.util.Map;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Artifact Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.SimpleArtifactDescriptor#getRepositoryPropertyMap <em>Repository Property Map</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.P2Package#getSimpleArtifactDescriptor()
 * @model
 * @generated
 */
public interface SimpleArtifactDescriptor extends ArtifactDescriptor {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Map<String, String> getRepositoryProperties();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	String getRepositoryProperty(String key);

	/**
	 * Returns the value of the '<em><b>Repository Property Map</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository Property Map</em>' map.
	 * @see org.eclipse.cbi.p2repo.p2.P2Package#getSimpleArtifactDescriptor_RepositoryPropertyMap()
	 * @model mapType="org.eclipse.cbi.p2repo.p2.Property&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString&gt;"
	 * @generated
	 */
	EMap<String, String> getRepositoryPropertyMap();

} // SimpleArtifactDescriptor
