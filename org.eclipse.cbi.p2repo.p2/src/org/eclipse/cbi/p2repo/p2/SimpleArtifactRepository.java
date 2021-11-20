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

import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.p2.repository.artifact.IFileArtifactRepository;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple Artifact Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.SimpleArtifactRepository#getRules <em>Rules</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.P2Package#getSimpleArtifactRepository()
 * @model superTypes="org.eclipse.cbi.p2repo.p2.ArtifactRepository org.eclipse.cbi.p2repo.p2.IFileArtifactRepository"
 * @generated
 */
public interface SimpleArtifactRepository extends ArtifactRepository, IFileArtifactRepository {
	/**
	 * Returns the value of the '<em><b>Rules</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.p2.MappingRule}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rules</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.p2.P2Package#getSimpleArtifactRepository_Rules()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<MappingRule> getRules();

} // SimpleArtifactRepository
