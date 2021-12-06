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
import org.eclipse.emf.common.util.EMap;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepository;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Artifact Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.ArtifactRepository#getArtifactMap <em>Artifact Map</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.P2Package#getArtifactRepository()
 * @model superTypes="org.eclipse.cbi.p2repo.p2.Repository&lt;org.eclipse.cbi.p2repo.p2.IArtifactKey&gt; org.eclipse.cbi.p2repo.p2.IArtifactRepository"
 * @generated
 */
public interface ArtifactRepository extends Repository<IArtifactKey>, IArtifactRepository {
	/**
	 * Returns the value of the '<em><b>Artifact Map</b></em>' map.
	 * The key is of type {@link org.eclipse.equinox.p2.metadata.IArtifactKey},
	 * and the value is of type list of {@link org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Artifact Map</em>' map.
	 * @see org.eclipse.cbi.p2repo.p2.P2Package#getArtifactRepository_ArtifactMap()
	 * @model mapType="org.eclipse.cbi.p2repo.p2.ArtifactsByKey&lt;org.eclipse.cbi.p2repo.p2.IArtifactKey, org.eclipse.cbi.p2repo.p2.IArtifactDescriptor&gt;"
	 * @generated
	 */
	EMap<IArtifactKey, EList<IArtifactDescriptor>> getArtifactMap();

} // ArtifactRepository
