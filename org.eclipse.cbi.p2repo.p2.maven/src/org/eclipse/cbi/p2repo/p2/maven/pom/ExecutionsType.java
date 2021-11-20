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
package org.eclipse.cbi.p2repo.p2.maven.pom;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Executions Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.ExecutionsType#getExecution <em>Execution</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getExecutionsType()
 * @model extendedMetaData="name='executions_._type' kind='elementOnly'"
 * @generated
 */
public interface ExecutionsType extends EObject {
	/**
	 * Returns the value of the '<em><b>Execution</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.p2.maven.pom.PluginExecution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getExecutionsType_Execution()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='execution' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<PluginExecution> getExecution();

} // ExecutionsType
