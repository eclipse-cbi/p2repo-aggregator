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
import org.eclipse.equinox.p2.metadata.ITouchpointData;
import org.eclipse.equinox.p2.metadata.ITouchpointType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Touchpoints</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.Touchpoints#getTouchpointType <em>Touchpoint Type</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.Touchpoints#getTouchpointDataList <em>Touchpoint Data List</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getTouchpoints()
 * @model
 * @generated
 */
public interface Touchpoints {
	/**
	 * Returns the value of the '<em><b>Touchpoint Data List</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.equinox.p2.metadata.ITouchpointData}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Touchpoint Data List</em>' reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getTouchpoints_TouchpointDataList()
	 * @model type="org.eclipse.cbi.p2repo.p2.ITouchpointData"
	 * @generated
	 */
	EList<ITouchpointData> getTouchpointDataList();

	/**
	 * Returns the value of the '<em><b>Touchpoint Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Touchpoint Type</em>' reference.
	 * @see #setTouchpointType(ITouchpointType)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getTouchpoints_TouchpointType()
	 * @model type="org.eclipse.cbi.p2repo.p2.ITouchpointType"
	 * @generated
	 */
	ITouchpointType getTouchpointType();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.Touchpoints#getTouchpointType <em>Touchpoint Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Touchpoint Type</em>' reference.
	 * @see #getTouchpointType()
	 * @generated
	 */
	void setTouchpointType(ITouchpointType value);

} // Touchpoints
