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
import org.eclipse.equinox.p2.metadata.IInstallableUnitFragment;
import org.eclipse.equinox.p2.metadata.IRequirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Installable Unit Fragment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.InstallableUnitFragment#getHost <em>Host</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.P2Package#getInstallableUnitFragment()
 * @model superTypes="org.eclipse.cbi.p2repo.p2.InstallableUnit org.eclipse.cbi.p2repo.p2.IInstallableUnitFragment"
 * @generated
 */
public interface InstallableUnitFragment extends InstallableUnit, IInstallableUnitFragment {
	/**
	 * Returns the value of the '<em><b>Host</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.equinox.p2.metadata.IRequirement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Host</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.p2.P2Package#getInstallableUnitFragment_Host()
	 * @model type="org.eclipse.cbi.p2repo.p2.IRequirement" containment="true" resolveProxies="true"
	 * @generated
	 */
	@Override
	EList<IRequirement> getHost();

} // InstallableUnitFragment
