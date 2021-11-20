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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provided Capabilities</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.ProvidedCapabilities#getProvidedCapabilities <em>Provided Capabilities</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getProvidedCapabilities()
 * @model
 * @generated
 */
public interface ProvidedCapabilities {
	/**
	 * Returns the value of the '<em><b>Provided Capabilities</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.p2view.ProvidedCapabilityWrapper}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Capabilities</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getProvidedCapabilities_ProvidedCapabilities()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<ProvidedCapabilityWrapper> getProvidedCapabilities();

} // ProvidedCapabilities
