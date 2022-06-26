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
 * A representation of the model object '<em><b>Other Archives Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.OtherArchivesType#getOtherArchive <em>Other Archive</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getOtherArchivesType()
 * @model extendedMetaData="name='otherArchives_._type' kind='elementOnly'"
 * @generated
 */
public interface OtherArchivesType extends EObject {
	/**
	 * Returns the value of the '<em><b>Other Archive</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Other Archive</em>' attribute list.
	 * @see org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage#getOtherArchivesType_OtherArchive()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='element' name='otherArchive' namespace='##targetNamespace'"
	 * @generated
	 */
	EList<String> getOtherArchive();

} // OtherArchivesType
