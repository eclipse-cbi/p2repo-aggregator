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
package org.eclipse.cbi.p2repo.aggregator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Available Versions Header</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader#getAvailableVersions <em>Available Versions</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader#getInstallableUnitRequest <em>Installable Unit Request</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAvailableVersionsHeader()
 * @model
 * @generated
 */
public interface AvailableVersionsHeader {
	/**
	 * Returns the value of the '<em><b>Available Versions</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.AvailableVersion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Versions</em>' reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAvailableVersionsHeader_AvailableVersions()
	 * @model resolveProxies="false" transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	EList<AvailableVersion> getAvailableVersions();

	/**
	 * Returns the value of the '<em><b>Installable Unit Request</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getAvailableVersionsHeader <em>Available Versions Header</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installable Unit Request</em>' container reference.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAvailableVersionsHeader_InstallableUnitRequest()
	 * @see org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getAvailableVersionsHeader
	 * @model opposite="availableVersionsHeader" resolveProxies="false" required="true" changeable="false"
	 * @generated
	 */
	InstallableUnitRequest getInstallableUnitRequest();

} // AvailableVersionsHeader
