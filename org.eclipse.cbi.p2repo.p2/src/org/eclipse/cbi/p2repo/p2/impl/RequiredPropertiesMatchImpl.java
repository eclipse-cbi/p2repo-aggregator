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
package org.eclipse.cbi.p2repo.p2.impl;

import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.p2.RequiredPropertiesMatch;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.expression.IFilterExpression;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Required Properties Match</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.RequiredPropertiesMatchImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.RequiredPropertiesMatchImpl#getPropertiesMatch <em>Properties Match</em>}</li>
 * </ul>
 *
 * @since 1.1
 * @generated
 */
public class RequiredPropertiesMatchImpl extends RequirementImpl implements RequiredPropertiesMatch {
	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPropertiesMatch() <em>Properties Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertiesMatch()
	 * @generated
	 * @ordered
	 */
	protected static final IFilterExpression PROPERTIES_MATCH_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPropertiesMatch() <em>Properties Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertiesMatch()
	 * @generated
	 * @ordered
	 */
	protected IFilterExpression propertiesMatch = PROPERTIES_MATCH_EDEFAULT;

	private boolean matchesDirty = true;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RequiredPropertiesMatchImpl() {
		super();
	}

	synchronized private void computeMatches() {
		if (matchesDirty) {
			org.eclipse.equinox.internal.p2.metadata.RequiredPropertiesMatch rpm = new org.eclipse.equinox.internal.p2.metadata.RequiredPropertiesMatch(
					namespace, getPropertiesMatch(), getFilter(), getMin(), getMax(), isGreedy(), getDescription());
			super.setMatches(rpm.getMatches());
		}

		matchesDirty = false;
	}

	@Override
	public IMatchExpression<IInstallableUnit> getMatches() {
		if (matchesDirty)
			computeMatches();

		return matches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return P2Package.Literals.REQUIRED_PROPERTIES_MATCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNamespace() {
		return namespace;
	}

	@Override
	public void setNamespace(String newNamespace) {
		matchesDirty = true;
		setNamespaceGen(newNamespace);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNamespaceGen(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.REQUIRED_PROPERTIES_MATCH__NAMESPACE,
					oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IFilterExpression getPropertiesMatch() {
		return propertiesMatch;
	}

	@Override
	public void setPropertiesMatch(IFilterExpression newPropertiesMatch) {
		setPropertiesMatchGen(newPropertiesMatch);
		matchesDirty = true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPropertiesMatchGen(IFilterExpression newPropertiesMatch) {
		IFilterExpression oldPropertiesMatch = propertiesMatch;
		propertiesMatch = newPropertiesMatch;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.REQUIRED_PROPERTIES_MATCH__PROPERTIES_MATCH,
					oldPropertiesMatch, propertiesMatch));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2Package.REQUIRED_PROPERTIES_MATCH__NAMESPACE:
				return getNamespace();
			case P2Package.REQUIRED_PROPERTIES_MATCH__PROPERTIES_MATCH:
				return getPropertiesMatch();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case P2Package.REQUIRED_PROPERTIES_MATCH__NAMESPACE:
				setNamespace((String) newValue);
				return;
			case P2Package.REQUIRED_PROPERTIES_MATCH__PROPERTIES_MATCH:
				setPropertiesMatch((IFilterExpression) newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.REQUIRED_PROPERTIES_MATCH__NAMESPACE:
				setNamespace(NAMESPACE_EDEFAULT);
				return;
			case P2Package.REQUIRED_PROPERTIES_MATCH__PROPERTIES_MATCH:
				setPropertiesMatch(PROPERTIES_MATCH_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case P2Package.REQUIRED_PROPERTIES_MATCH__NAMESPACE:
				return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
			case P2Package.REQUIRED_PROPERTIES_MATCH__PROPERTIES_MATCH:
				return PROPERTIES_MATCH_EDEFAULT == null ? propertiesMatch != null
						: !PROPERTIES_MATCH_EDEFAULT.equals(propertiesMatch);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder();
		result.append(namespace);
		result.append("; ");
		result.append(propertiesMatch);
		return result.toString();
	}

} // RequiredPropertiesMatchImpl
