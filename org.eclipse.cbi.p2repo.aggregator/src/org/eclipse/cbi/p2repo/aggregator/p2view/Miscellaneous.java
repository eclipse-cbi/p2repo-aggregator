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

import org.eclipse.cbi.p2repo.aggregator.ChildrenProvider;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Miscellaneous</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.Miscellaneous#getOthers <em>Others</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getMiscellaneous()
 * @model
 * @generated
 */
public interface Miscellaneous extends ChildrenProvider<OtherIU> {
	/**
	 * Returns the value of the '<em><b>Others</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.p2view.OtherIU}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Others</em>' reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getMiscellaneous_Others()
	 * @model
	 * @generated
	 */
	EList<OtherIU> getOthers();

} // Miscellaneous
