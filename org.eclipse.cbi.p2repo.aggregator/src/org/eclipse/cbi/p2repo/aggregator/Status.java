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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Status</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Status#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Status#getMessage <em>Message</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getStatus()
 * @model
 * @generated
 */
public interface Status {
	/**
	 * Returns the value of the '<em><b>Code</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.cbi.p2repo.aggregator.StatusCode}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Code</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.StatusCode
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getStatus_Code()
	 * @model required="true" changeable="false"
	 * @generated
	 */
	StatusCode getCode();

	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getStatus_Message()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" changeable="false"
	 * @generated
	 */
	String getMessage();

} // Status
