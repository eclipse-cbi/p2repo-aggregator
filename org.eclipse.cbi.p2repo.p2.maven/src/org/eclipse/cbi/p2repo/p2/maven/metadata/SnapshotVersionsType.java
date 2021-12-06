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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Snapshot Versions Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersionsType#getSnapshotVersion <em>Snapshot Version</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getSnapshotVersionsType()
 * @model extendedMetaData="name='snapshotVersions_._type' kind='elementOnly'"
 * @generated
 */
public interface SnapshotVersionsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Snapshot Version</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snapshot Version</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage#getSnapshotVersionsType_SnapshotVersion()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='snapshotVersion' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<SnapshotVersion> getSnapshotVersion();

} // SnapshotVersionsType
