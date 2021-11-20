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
package org.eclipse.cbi.p2repo.aggregator.impl;

import java.util.Collection;

import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.Configuration;
import org.eclipse.cbi.p2repo.aggregator.ValidConfigurationsRule;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Valid Configurations Rule</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.ValidConfigurationsRuleImpl#getValidConfigurations <em>Valid Configurations</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ValidConfigurationsRuleImpl extends MapRuleImpl implements ValidConfigurationsRule {
	/**
	 * The cached value of the '{@link #getValidConfigurations() <em>Valid Configurations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<Configuration> validConfigurations;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ValidConfigurationsRuleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AggregatorPackage.VALID_CONFIGURATIONS_RULE__VALID_CONFIGURATIONS:
				return getValidConfigurations();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AggregatorPackage.VALID_CONFIGURATIONS_RULE__VALID_CONFIGURATIONS:
				return validConfigurations != null && !validConfigurations.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AggregatorPackage.VALID_CONFIGURATIONS_RULE__VALID_CONFIGURATIONS:
				getValidConfigurations().clear();
				getValidConfigurations().addAll((Collection<? extends Configuration>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AggregatorPackage.Literals.VALID_CONFIGURATIONS_RULE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AggregatorPackage.VALID_CONFIGURATIONS_RULE__VALID_CONFIGURATIONS:
				getValidConfigurations().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Configuration> getValidConfigurations() {
		if (validConfigurations == null) {
			validConfigurations = new EObjectResolvingEList<>(Configuration.class, this,
					AggregatorPackage.VALID_CONFIGURATIONS_RULE__VALID_CONFIGURATIONS);
		}
		return validConfigurations;
	}

} // ValidConfigurationsRuleImpl
