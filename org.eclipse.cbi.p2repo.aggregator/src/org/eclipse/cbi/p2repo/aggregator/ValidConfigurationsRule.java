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

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Valid Configurations Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.ValidConfigurationsRule#getValidConfigurations <em>Valid Configurations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getValidConfigurationsRule()
 * @model
 * @generated
 */
public interface ValidConfigurationsRule extends MapRule {
	/**
	 * Returns the value of the '<em><b>Valid Configurations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.Configuration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Configurations</em>' reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getValidConfigurationsRule_ValidConfigurations()
	 * @model
	 * @generated
	 */
	EList<Configuration> getValidConfigurations();

} // ValidConfigurationsRule
