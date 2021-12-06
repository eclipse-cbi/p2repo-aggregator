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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>IU Presentation With Details</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentationWithDetails#isDetailsResolved <em>Details Resolved</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getIUPresentationWithDetails()
 * @model abstract="true"
 * @generated
 */
public interface IUPresentationWithDetails extends IUPresentation, IUDetails {

	/**
	 * Returns the value of the '<em><b>Details Resolved</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Details Resolved</em>' attribute.
	 * @see #setDetailsResolved(boolean)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getIUPresentationWithDetails_DetailsResolved()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	boolean isDetailsResolved();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentationWithDetails#isDetailsResolved <em>Details Resolved</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Details Resolved</em>' attribute.
	 * @see #isDetailsResolved()
	 * @generated
	 */
	void setDetailsResolved(boolean value);
} // IUPresentationWithDetails
