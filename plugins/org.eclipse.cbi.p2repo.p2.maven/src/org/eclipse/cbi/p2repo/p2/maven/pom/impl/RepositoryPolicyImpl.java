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
package org.eclipse.cbi.p2repo.p2.maven.pom.impl;

import org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage;
import org.eclipse.cbi.p2repo.p2.maven.pom.RepositoryPolicy;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository Policy</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.impl.RepositoryPolicyImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.impl.RepositoryPolicyImpl#getUpdatePolicy <em>Update Policy</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.impl.RepositoryPolicyImpl#getChecksumPolicy <em>Checksum Policy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepositoryPolicyImpl extends MinimalEObjectImpl.Container implements RepositoryPolicy {
	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected boolean enabled = ENABLED_EDEFAULT;

	/**
	 * This is true if the Enabled attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean enabledESet;

	/**
	 * The default value of the '{@link #getUpdatePolicy() <em>Update Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdatePolicy()
	 * @generated
	 * @ordered
	 */
	protected static final String UPDATE_POLICY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getUpdatePolicy() <em>Update Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUpdatePolicy()
	 * @generated
	 * @ordered
	 */
	protected String updatePolicy = UPDATE_POLICY_EDEFAULT;

	/**
	 * The default value of the '{@link #getChecksumPolicy() <em>Checksum Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChecksumPolicy()
	 * @generated
	 * @ordered
	 */
	protected static final String CHECKSUM_POLICY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getChecksumPolicy() <em>Checksum Policy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChecksumPolicy()
	 * @generated
	 * @ordered
	 */
	protected String checksumPolicy = CHECKSUM_POLICY_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryPolicyImpl() {
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
			case PomPackage.REPOSITORY_POLICY__ENABLED:
				return isEnabled();
			case PomPackage.REPOSITORY_POLICY__UPDATE_POLICY:
				return getUpdatePolicy();
			case PomPackage.REPOSITORY_POLICY__CHECKSUM_POLICY:
				return getChecksumPolicy();
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
			case PomPackage.REPOSITORY_POLICY__ENABLED:
				return isSetEnabled();
			case PomPackage.REPOSITORY_POLICY__UPDATE_POLICY:
				return UPDATE_POLICY_EDEFAULT == null ? updatePolicy != null
						: !UPDATE_POLICY_EDEFAULT.equals(updatePolicy);
			case PomPackage.REPOSITORY_POLICY__CHECKSUM_POLICY:
				return CHECKSUM_POLICY_EDEFAULT == null ? checksumPolicy != null
						: !CHECKSUM_POLICY_EDEFAULT.equals(checksumPolicy);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case PomPackage.REPOSITORY_POLICY__ENABLED:
				setEnabled((Boolean) newValue);
				return;
			case PomPackage.REPOSITORY_POLICY__UPDATE_POLICY:
				setUpdatePolicy((String) newValue);
				return;
			case PomPackage.REPOSITORY_POLICY__CHECKSUM_POLICY:
				setChecksumPolicy((String) newValue);
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
			case PomPackage.REPOSITORY_POLICY__ENABLED:
				unsetEnabled();
				return;
			case PomPackage.REPOSITORY_POLICY__UPDATE_POLICY:
				setUpdatePolicy(UPDATE_POLICY_EDEFAULT);
				return;
			case PomPackage.REPOSITORY_POLICY__CHECKSUM_POLICY:
				setChecksumPolicy(CHECKSUM_POLICY_EDEFAULT);
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
	public String getChecksumPolicy() {
		return checksumPolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUpdatePolicy() {
		return updatePolicy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetEnabled() {
		return enabledESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setChecksumPolicy(String newChecksumPolicy) {
		String oldChecksumPolicy = checksumPolicy;
		checksumPolicy = newChecksumPolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PomPackage.REPOSITORY_POLICY__CHECKSUM_POLICY,
					oldChecksumPolicy, checksumPolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = enabled;
		enabled = newEnabled;
		boolean oldEnabledESet = enabledESet;
		enabledESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PomPackage.REPOSITORY_POLICY__ENABLED, oldEnabled,
					enabled, !oldEnabledESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUpdatePolicy(String newUpdatePolicy) {
		String oldUpdatePolicy = updatePolicy;
		updatePolicy = newUpdatePolicy;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PomPackage.REPOSITORY_POLICY__UPDATE_POLICY,
					oldUpdatePolicy, updatePolicy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (enabled: ");
		if (enabledESet)
			result.append(enabled);
		else
			result.append("<unset>");
		result.append(", updatePolicy: ");
		result.append(updatePolicy);
		result.append(", checksumPolicy: ");
		result.append(checksumPolicy);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetEnabled() {
		boolean oldEnabled = enabled;
		boolean oldEnabledESet = enabledESet;
		enabled = ENABLED_EDEFAULT;
		enabledESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, PomPackage.REPOSITORY_POLICY__ENABLED, oldEnabled,
					ENABLED_EDEFAULT, oldEnabledESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PomPackage.Literals.REPOSITORY_POLICY;
	}

} // RepositoryPolicyImpl
