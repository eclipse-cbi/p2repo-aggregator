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
 * A representation of the model object '<em><b>Enabled Status Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider#isBranchEnabled <em>Branch Enabled</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider#isEnabled <em>Enabled</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getEnabledStatusProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface EnabledStatusProvider {
	/**
	 * Returns the value of the '<em><b>Branch Enabled</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Enabled</em>' attribute.
	 * @see #isSetBranchEnabled()
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getEnabledStatusProvider_BranchEnabled()
	 * @model default="false" unsettable="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isBranchEnabled();

	/**
	 * Returns the value of the '<em><b>Enabled</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enabled</em>' attribute.
	 * @see #setEnabled(boolean)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getEnabledStatusProvider_Enabled()
	 * @model default="true"
	 * @generated
	 */
	boolean isEnabled();

	/**
	 * Returns whether the value of the '{@link org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider#isBranchEnabled <em>Branch Enabled</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Branch Enabled</em>' attribute is set.
	 * @see #isBranchEnabled()
	 * @generated
	 */
	boolean isSetBranchEnabled();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider#isEnabled <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enabled</em>' attribute.
	 * @see #isEnabled()
	 * @generated
	 */
	void setEnabled(boolean value);

} // EnabledStatusProvider
