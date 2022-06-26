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

import org.eclipse.equinox.p2.metadata.IInstallableUnitPatch;
import org.eclipse.equinox.p2.metadata.IRequirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Installable Unit Patch</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipse.cbi.p2repo.p2.P2Package#getInstallableUnitPatch()
 * @model superTypes="org.eclipse.cbi.p2repo.p2.InstallableUnit org.eclipse.cbi.p2repo.p2.IInstallableUnitPatch"
 * @generated
 */
public interface InstallableUnitPatch extends InstallableUnit, IInstallableUnitPatch {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.cbi.p2repo.p2.IRequirementArrayArray"
	 * @generated
	 */
	@Override
	IRequirement[][] getApplicabilityScope();

} // InstallableUnitPatch
