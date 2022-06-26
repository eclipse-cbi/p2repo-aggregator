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
import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.p2.repository.IRepositoryReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Repository References</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryReferences#getRepositoryReferences <em>Repository References</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getRepositoryReferences()
 * @model superTypes="org.eclipse.cbi.p2repo.aggregator.ChildrenProvider&lt;org.eclipse.cbi.p2repo.p2.IRepositoryReference&gt;"
 * @generated
 */
public interface RepositoryReferences extends ChildrenProvider<IRepositoryReference> {
	/**
	 * Returns the value of the '<em><b>Repository References</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.equinox.p2.repository.IRepositoryReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository References</em>' reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getRepositoryReferences_RepositoryReferences()
	 * @model type="org.eclipse.cbi.p2repo.p2.IRepositoryReference"
	 * @generated
	 */
	EList<IRepositoryReference> getRepositoryReferences();

} // RepositoryReferences
