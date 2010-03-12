/**
 * Copyright (c) 2010, Cloudsmith Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * - Cloudsmith Inc - initial API and implementation.
 * 
 */
package org.eclipse.b3.build.build;

import org.eclipse.b3.backend.evaluator.b3backend.BSwitchExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Switch Repository</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.b3.build.build.SwitchRepository#getRepoSwitch <em>Repo Switch</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.b3.build.build.B3BuildPackage#getSwitchRepository()
 * @model
 * @generated
 */
public interface SwitchRepository extends BuildUnitRepository {
	/**
	 * Returns the value of the '<em><b>Repo Switch</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The repoSwitch switches between instantiated repositories.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Repo Switch</em>' containment reference.
	 * @see #setRepoSwitch(BSwitchExpression)
	 * @see org.eclipse.b3.build.build.B3BuildPackage#getSwitchRepository_RepoSwitch()
	 * @model containment="true"
	 * @generated
	 */
	BSwitchExpression getRepoSwitch();

	/**
	 * Sets the value of the '{@link org.eclipse.b3.build.build.SwitchRepository#getRepoSwitch <em>Repo Switch</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repo Switch</em>' containment reference.
	 * @see #getRepoSwitch()
	 * @generated
	 */
	void setRepoSwitch(BSwitchExpression value);

} // SwitchRepository
