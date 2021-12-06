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
package org.eclipse.cbi.p2repo.p2;

import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.repository.IRepositoryReference;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metadata Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.MetadataRepository#getInstallableUnits <em>Installable Units</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.MetadataRepository#getReferences <em>References</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.P2Package#getMetadataRepository()
 * @model superTypes="org.eclipse.cbi.p2repo.p2.Repository&lt;org.eclipse.cbi.p2repo.p2.IInstallableUnit&gt; org.eclipse.cbi.p2repo.p2.IMetadataRepository"
 * @generated
 */
public interface MetadataRepository extends Repository<IInstallableUnit>, IMetadataRepository {
	/**
	 * Returns the value of the '<em><b>Installable Units</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.equinox.p2.metadata.IInstallableUnit}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installable Units</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.p2.P2Package#getMetadataRepository_InstallableUnits()
	 * @model type="org.eclipse.cbi.p2repo.p2.IInstallableUnit" containment="true" resolveProxies="true" keys="id version"
	 * @generated
	 */
	EList<IInstallableUnit> getInstallableUnits();

	/**
	 * Returns the value of the '<em><b>References</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.equinox.p2.repository.IRepositoryReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>References</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.p2.P2Package#getMetadataRepository_References()
	 * @model type="org.eclipse.cbi.p2repo.p2.IRepositoryReference" containment="true" resolveProxies="true"
	 * @generated
	 */
	@Override
	EList<IRepositoryReference> getReferences();

} // MetadataRepository
