/**
 * Copyright (c) 2009, Cloudsmith Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * - Cloudsmith Inc - initial API and implementation.
 * 
 */
package org.eclipse.b3.backend.evaluator.b3backend;

import org.eclipse.b3.backend.core.datatypes.SimplePattern;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>BSimple Pattern Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.b3.backend.evaluator.b3backend.BSimplePatternExpression#getPattern <em>Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.b3.backend.evaluator.b3backend.B3backendPackage#getBSimplePatternExpression()
 * @model
 * @generated
 */
public interface BSimplePatternExpression extends BPatternLiteralExpression {
	/**
	 * Returns the value of the '<em><b>Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pattern</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pattern</em>' attribute.
	 * @see #setPattern(SimplePattern)
	 * @see org.eclipse.b3.backend.evaluator.b3backend.B3backendPackage#getBSimplePatternExpression_Pattern()
	 * @model dataType="org.eclipse.b3.backend.evaluator.b3backend.SimplePattern"
	 * @generated
	 */
	SimplePattern getPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.b3.backend.evaluator.b3backend.BSimplePatternExpression#getPattern <em>Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pattern</em>' attribute.
	 * @see #getPattern()
	 * @generated
	 */
	void setPattern(SimplePattern value);

} // BSimplePatternExpression
