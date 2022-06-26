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
package org.eclipse.cbi.p2repo.aggregator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Category</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Category#getLabelOverride <em>Label Override</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getCategory()
 * @model
 * @generated
 */
public interface Category extends MappedUnit {
	/**
	 * Returns the value of the '<em><b>Label Override</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label Override</em>' attribute.
	 * @see #setLabelOverride(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getCategory_LabelOverride()
	 * @model
	 * @generated
	 */
	String getLabelOverride();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Category#getLabelOverride <em>Label Override</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label Override</em>' attribute.
	 * @see #getLabelOverride()
	 * @generated
	 */
	void setLabelOverride(String value);

} // Category
