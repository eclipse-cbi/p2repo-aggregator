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
import org.eclipse.cbi.p2repo.aggregator.StatusProvider;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository Browser</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryBrowser#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryBrowser#isLoading <em>Loading</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getRepositoryBrowser()
 * @model
 * @generated
 */
public interface RepositoryBrowser extends StatusProvider, ChildrenProvider<MetadataRepositoryStructuredView> {
	/**
	 * Returns the value of the '<em><b>Repositories</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repositories</em>' reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getRepositoryBrowser_Repositories()
	 * @model resolveProxies="false" transient="true" volatile="true" derived="true"
	 * @generated
	 */
	EList<MetadataRepositoryStructuredView> getRepositories();

	/**
	 * Returns the value of the '<em><b>Loading</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loading</em>' attribute.
	 * @see #isSetLoading()
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getRepositoryBrowser_Loading()
	 * @model default="false" unsettable="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isLoading();

	/**
	 * Returns whether the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryBrowser#isLoading <em>Loading</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Loading</em>' attribute is set.
	 * @see #isLoading()
	 * @generated
	 */
	boolean isSetLoading();

} // RepositoryBrowser
