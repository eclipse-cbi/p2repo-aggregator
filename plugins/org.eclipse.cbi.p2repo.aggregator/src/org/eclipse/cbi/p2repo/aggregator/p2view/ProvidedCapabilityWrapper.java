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

import org.eclipse.cbi.p2repo.aggregator.LabelProvider;
import org.eclipse.equinox.p2.metadata.IProvidedCapability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Provided Capability Wrapper</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.ProvidedCapabilityWrapper#getGenuine <em>Genuine</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getProvidedCapabilityWrapper()
 * @model superTypes="org.eclipse.cbi.p2repo.p2.IProvidedCapability org.eclipse.cbi.p2repo.aggregator.LabelProvider"
 * @generated
 */
public interface ProvidedCapabilityWrapper extends IProvidedCapability, LabelProvider {
	/**
	 * Returns the value of the '<em><b>Genuine</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Genuine</em>' reference.
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getProvidedCapabilityWrapper_Genuine()
	 * @model type="org.eclipse.cbi.p2repo.p2.IProvidedCapability" resolveProxies="false" required="true" changeable="false"
	 * @generated
	 */
	IProvidedCapability getGenuine();

} // ProvidedCapabilityWrapper
