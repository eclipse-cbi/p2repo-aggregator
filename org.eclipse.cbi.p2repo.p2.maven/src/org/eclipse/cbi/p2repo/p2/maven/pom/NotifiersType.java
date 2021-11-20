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
 * A representation of the model object '<em><b>Notifiers Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.NotifiersType#getNotifier <em>Notifier</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getNotifiersType()
 * @model extendedMetaData="name='notifiers_._type' kind='elementOnly'"
 * @generated
 */
public interface NotifiersType extends EObject {
	/**
	 * Returns the value of the '<em><b>Notifier</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.p2.maven.pom.Notifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Notifier</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getNotifiersType_Notifier()
	 * @model containment="true"
	 *        extendedMetaData="kind='element' name='notifier' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<Notifier> getNotifier();

} // NotifiersType
