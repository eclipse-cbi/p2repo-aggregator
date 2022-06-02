/**
 * Copyright (c) 2006-2016, Cloudsmith Inc. and others
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 */
package org.eclipse.cbi.p2repo.p2;

import org.eclipse.equinox.p2.metadata.expression.IFilterExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Required Properties Match</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @since 1.1
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.RequiredPropertiesMatch#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.RequiredPropertiesMatch#getPropertiesMatch <em>Properties Match</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.P2Package#getRequiredPropertiesMatch()
 * @model
 * @generated
 */
public interface RequiredPropertiesMatch extends Requirement {
	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see org.eclipse.cbi.p2repo.p2.P2Package#getRequiredPropertiesMatch_Namespace()
	 * @model
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.RequiredPropertiesMatch#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Properties Match</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties Match</em>' attribute.
	 * @see #setPropertiesMatch(IFilterExpression)
	 * @see org.eclipse.cbi.p2repo.p2.P2Package#getRequiredPropertiesMatch_PropertiesMatch()
	 * @model dataType="org.eclipse.cbi.p2repo.p2.IFilterExpression"
	 * @generated
	 */
	IFilterExpression getPropertiesMatch();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.RequiredPropertiesMatch#getPropertiesMatch <em>Properties Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties Match</em>' attribute.
	 * @see #getPropertiesMatch()
	 * @generated
	 */
	void setPropertiesMatch(IFilterExpression value);

} // RequiredPropertiesMatch
