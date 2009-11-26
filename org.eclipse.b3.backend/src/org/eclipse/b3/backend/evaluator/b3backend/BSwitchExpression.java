/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.b3.backend.evaluator.b3backend;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BSwitch Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.b3.backend.evaluator.b3backend.BSwitchExpression#getSwitchExpression <em>Switch Expression</em>}</li>
 *   <li>{@link org.eclipse.b3.backend.evaluator.b3backend.BSwitchExpression#getCaseList <em>Case List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.b3.backend.evaluator.b3backend.B3backendPackage#getBSwitchExpression()
 * @model
 * @generated
 */
public interface BSwitchExpression extends BExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2009, Cloudsmith Inc and others.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\rContributors:\n- Cloudsmith Inc - initial API and implementation.\r";

	/**
	 * Returns the value of the '<em><b>Switch Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Switch Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Switch Expression</em>' containment reference.
	 * @see #setSwitchExpression(BExpression)
	 * @see org.eclipse.b3.backend.evaluator.b3backend.B3backendPackage#getBSwitchExpression_SwitchExpression()
	 * @model containment="true"
	 * @generated
	 */
	BExpression getSwitchExpression();

	/**
	 * Sets the value of the '{@link org.eclipse.b3.backend.evaluator.b3backend.BSwitchExpression#getSwitchExpression <em>Switch Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Switch Expression</em>' containment reference.
	 * @see #getSwitchExpression()
	 * @generated
	 */
	void setSwitchExpression(BExpression value);

	/**
	 * Returns the value of the '<em><b>Case List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Case List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Case List</em>' containment reference.
	 * @see #setCaseList(BCase)
	 * @see org.eclipse.b3.backend.evaluator.b3backend.B3backendPackage#getBSwitchExpression_CaseList()
	 * @model containment="true"
	 * @generated
	 */
	BCase getCaseList();

	/**
	 * Sets the value of the '{@link org.eclipse.b3.backend.evaluator.b3backend.BSwitchExpression#getCaseList <em>Case List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Case List</em>' containment reference.
	 * @see #getCaseList()
	 * @generated
	 */
	void setCaseList(BCase value);

} // BSwitchExpression