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
package org.eclipse.cbi.p2repo.p2.maven.metadata.impl;

import org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Snapshot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotImpl#getTimestamp <em>Timestamp</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotImpl#getBuildNumber <em>Build Number</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotImpl#isLocalCopy <em>Local Copy</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SnapshotImpl extends MinimalEObjectImpl.Container implements Snapshot {
	/**
	 * The default value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected static final String TIMESTAMP_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTimestamp() <em>Timestamp</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimestamp()
	 * @generated
	 * @ordered
	 */
	protected String timestamp = TIMESTAMP_EDEFAULT;

	/**
	 * The default value of the '{@link #getBuildNumber() <em>Build Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int BUILD_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBuildNumber() <em>Build Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildNumber()
	 * @generated
	 * @ordered
	 */
	protected int buildNumber = BUILD_NUMBER_EDEFAULT;

	/**
	 * This is true if the Build Number attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean buildNumberESet;

	/**
	 * The default value of the '{@link #isLocalCopy() <em>Local Copy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocalCopy()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOCAL_COPY_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isLocalCopy() <em>Local Copy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLocalCopy()
	 * @generated
	 * @ordered
	 */
	protected boolean localCopy = LOCAL_COPY_EDEFAULT;

	/**
	 * This is true if the Local Copy attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean localCopyESet;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SnapshotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetadataPackage.Literals.SNAPSHOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getTimestamp() {
		return timestamp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTimestamp(String newTimestamp) {
		String oldTimestamp = timestamp;
		timestamp = newTimestamp;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SNAPSHOT__TIMESTAMP, oldTimestamp,
					timestamp));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getBuildNumber() {
		return buildNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBuildNumber(int newBuildNumber) {
		int oldBuildNumber = buildNumber;
		buildNumber = newBuildNumber;
		boolean oldBuildNumberESet = buildNumberESet;
		buildNumberESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SNAPSHOT__BUILD_NUMBER,
					oldBuildNumber, buildNumber, !oldBuildNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetBuildNumber() {
		int oldBuildNumber = buildNumber;
		boolean oldBuildNumberESet = buildNumberESet;
		buildNumber = BUILD_NUMBER_EDEFAULT;
		buildNumberESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetadataPackage.SNAPSHOT__BUILD_NUMBER,
					oldBuildNumber, BUILD_NUMBER_EDEFAULT, oldBuildNumberESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetBuildNumber() {
		return buildNumberESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLocalCopy() {
		return localCopy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocalCopy(boolean newLocalCopy) {
		boolean oldLocalCopy = localCopy;
		localCopy = newLocalCopy;
		boolean oldLocalCopyESet = localCopyESet;
		localCopyESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.SNAPSHOT__LOCAL_COPY, oldLocalCopy,
					localCopy, !oldLocalCopyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void unsetLocalCopy() {
		boolean oldLocalCopy = localCopy;
		boolean oldLocalCopyESet = localCopyESet;
		localCopy = LOCAL_COPY_EDEFAULT;
		localCopyESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, MetadataPackage.SNAPSHOT__LOCAL_COPY, oldLocalCopy,
					LOCAL_COPY_EDEFAULT, oldLocalCopyESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetLocalCopy() {
		return localCopyESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetadataPackage.SNAPSHOT__TIMESTAMP:
				return getTimestamp();
			case MetadataPackage.SNAPSHOT__BUILD_NUMBER:
				return getBuildNumber();
			case MetadataPackage.SNAPSHOT__LOCAL_COPY:
				return isLocalCopy();
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
			case MetadataPackage.SNAPSHOT__TIMESTAMP:
				setTimestamp((String) newValue);
				return;
			case MetadataPackage.SNAPSHOT__BUILD_NUMBER:
				setBuildNumber((Integer) newValue);
				return;
			case MetadataPackage.SNAPSHOT__LOCAL_COPY:
				setLocalCopy((Boolean) newValue);
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
			case MetadataPackage.SNAPSHOT__TIMESTAMP:
				setTimestamp(TIMESTAMP_EDEFAULT);
				return;
			case MetadataPackage.SNAPSHOT__BUILD_NUMBER:
				unsetBuildNumber();
				return;
			case MetadataPackage.SNAPSHOT__LOCAL_COPY:
				unsetLocalCopy();
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
			case MetadataPackage.SNAPSHOT__TIMESTAMP:
				return TIMESTAMP_EDEFAULT == null ? timestamp != null : !TIMESTAMP_EDEFAULT.equals(timestamp);
			case MetadataPackage.SNAPSHOT__BUILD_NUMBER:
				return isSetBuildNumber();
			case MetadataPackage.SNAPSHOT__LOCAL_COPY:
				return isSetLocalCopy();
		}
		return super.eIsSet(featureID);
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
		result.append(" (timestamp: ");
		result.append(timestamp);
		result.append(", buildNumber: ");
		if (buildNumberESet)
			result.append(buildNumber);
		else
			result.append("<unset>");
		result.append(", localCopy: ");
		if (localCopyESet)
			result.append(localCopy);
		else
			result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //SnapshotImpl
