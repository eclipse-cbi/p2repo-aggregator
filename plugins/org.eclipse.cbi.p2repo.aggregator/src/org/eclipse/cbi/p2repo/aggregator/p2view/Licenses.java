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
package org.eclipse.cbi.p2repo.aggregator.p2view;

import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.p2.metadata.ILicense;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Licenses</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.Licenses#getLicenses <em>Licenses</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getLicenses()
 * @model
 * @generated
 */
public interface Licenses {
	/**
	 * Returns the value of the '<em><b>Licenses</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.equinox.p2.metadata.ILicense}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Licenses</em>' reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getLicenses_Licenses()
	 * @model type="org.eclipse.cbi.p2repo.p2.ILicense"
	 * @generated
	 */
	EList<ILicense> getLicenses();

} // Licenses
