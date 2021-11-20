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
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersionsType;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning;
import org.eclipse.cbi.p2repo.p2.maven.metadata.VersionsType;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Versioning</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl#getLatest <em>Latest</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl#getRelease <em>Release</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl#getSnapshot <em>Snapshot</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl#getVersions <em>Versions</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl#getLastUpdated <em>Last Updated</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersioningImpl#getSnapshotVersions <em>Snapshot Versions</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VersioningImpl extends MinimalEObjectImpl.Container implements Versioning {
	/**
	 * The default value of the '{@link #getLatest() <em>Latest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatest()
	 * @generated
	 * @ordered
	 */
	protected static final String LATEST_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLatest() <em>Latest</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatest()
	 * @generated
	 * @ordered
	 */
	protected String latest = LATEST_EDEFAULT;

	/**
	 * The default value of the '{@link #getRelease() <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelease()
	 * @generated
	 * @ordered
	 */
	protected static final String RELEASE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRelease() <em>Release</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRelease()
	 * @generated
	 * @ordered
	 */
	protected String release = RELEASE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSnapshot() <em>Snapshot</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshot()
	 * @generated
	 * @ordered
	 */
	protected Snapshot snapshot;

	/**
	 * The cached value of the '{@link #getVersions() <em>Versions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersions()
	 * @generated
	 * @ordered
	 */
	protected VersionsType versions;

	/**
	 * The default value of the '{@link #getLastUpdated() <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
	protected static final String LAST_UPDATED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLastUpdated() <em>Last Updated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLastUpdated()
	 * @generated
	 * @ordered
	 */
	protected String lastUpdated = LAST_UPDATED_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSnapshotVersions() <em>Snapshot Versions</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshotVersions()
	 * @generated
	 * @ordered
	 */
	protected SnapshotVersionsType snapshotVersions;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VersioningImpl() {
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
			case MetadataPackage.VERSIONING__LATEST:
				return getLatest();
			case MetadataPackage.VERSIONING__RELEASE:
				return getRelease();
			case MetadataPackage.VERSIONING__SNAPSHOT:
				return getSnapshot();
			case MetadataPackage.VERSIONING__VERSIONS:
				return getVersions();
			case MetadataPackage.VERSIONING__LAST_UPDATED:
				return getLastUpdated();
			case MetadataPackage.VERSIONING__SNAPSHOT_VERSIONS:
				return getSnapshotVersions();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetadataPackage.VERSIONING__SNAPSHOT:
				return basicSetSnapshot(null, msgs);
			case MetadataPackage.VERSIONING__VERSIONS:
				return basicSetVersions(null, msgs);
			case MetadataPackage.VERSIONING__SNAPSHOT_VERSIONS:
				return basicSetSnapshotVersions(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case MetadataPackage.VERSIONING__LATEST:
				return LATEST_EDEFAULT == null ? latest != null : !LATEST_EDEFAULT.equals(latest);
			case MetadataPackage.VERSIONING__RELEASE:
				return RELEASE_EDEFAULT == null ? release != null : !RELEASE_EDEFAULT.equals(release);
			case MetadataPackage.VERSIONING__SNAPSHOT:
				return snapshot != null;
			case MetadataPackage.VERSIONING__VERSIONS:
				return versions != null;
			case MetadataPackage.VERSIONING__LAST_UPDATED:
				return LAST_UPDATED_EDEFAULT == null ? lastUpdated != null : !LAST_UPDATED_EDEFAULT.equals(lastUpdated);
			case MetadataPackage.VERSIONING__SNAPSHOT_VERSIONS:
				return snapshotVersions != null;
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
			case MetadataPackage.VERSIONING__LATEST:
				setLatest((String) newValue);
				return;
			case MetadataPackage.VERSIONING__RELEASE:
				setRelease((String) newValue);
				return;
			case MetadataPackage.VERSIONING__SNAPSHOT:
				setSnapshot((Snapshot) newValue);
				return;
			case MetadataPackage.VERSIONING__VERSIONS:
				setVersions((VersionsType) newValue);
				return;
			case MetadataPackage.VERSIONING__LAST_UPDATED:
				setLastUpdated((String) newValue);
				return;
			case MetadataPackage.VERSIONING__SNAPSHOT_VERSIONS:
				setSnapshotVersions((SnapshotVersionsType) newValue);
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
			case MetadataPackage.VERSIONING__LATEST:
				setLatest(LATEST_EDEFAULT);
				return;
			case MetadataPackage.VERSIONING__RELEASE:
				setRelease(RELEASE_EDEFAULT);
				return;
			case MetadataPackage.VERSIONING__SNAPSHOT:
				setSnapshot((Snapshot) null);
				return;
			case MetadataPackage.VERSIONING__VERSIONS:
				setVersions((VersionsType) null);
				return;
			case MetadataPackage.VERSIONING__LAST_UPDATED:
				setLastUpdated(LAST_UPDATED_EDEFAULT);
				return;
			case MetadataPackage.VERSIONING__SNAPSHOT_VERSIONS:
				setSnapshotVersions((SnapshotVersionsType) null);
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
	public String getLastUpdated() {
		return lastUpdated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLatest() {
		return latest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRelease() {
		return release;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VersionsType getVersions() {
		return versions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersions(VersionsType newVersions, NotificationChain msgs) {
		VersionsType oldVersions = versions;
		versions = newVersions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MetadataPackage.VERSIONING__VERSIONS, oldVersions, newVersions);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersions(VersionsType newVersions) {
		if (newVersions != versions) {
			NotificationChain msgs = null;
			if (versions != null)
				msgs = ((InternalEObject) versions).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MetadataPackage.VERSIONING__VERSIONS, null, msgs);
			if (newVersions != null)
				msgs = ((InternalEObject) newVersions).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MetadataPackage.VERSIONING__VERSIONS, null, msgs);
			msgs = basicSetVersions(newVersions, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.VERSIONING__VERSIONS, newVersions,
					newVersions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLastUpdated(String newLastUpdated) {
		String oldLastUpdated = lastUpdated;
		lastUpdated = newLastUpdated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.VERSIONING__LAST_UPDATED,
					oldLastUpdated, lastUpdated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Snapshot getSnapshot() {
		return snapshot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSnapshot(Snapshot newSnapshot, NotificationChain msgs) {
		Snapshot oldSnapshot = snapshot;
		snapshot = newSnapshot;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MetadataPackage.VERSIONING__SNAPSHOT, oldSnapshot, newSnapshot);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSnapshot(Snapshot newSnapshot) {
		if (newSnapshot != snapshot) {
			NotificationChain msgs = null;
			if (snapshot != null)
				msgs = ((InternalEObject) snapshot).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MetadataPackage.VERSIONING__SNAPSHOT, null, msgs);
			if (newSnapshot != null)
				msgs = ((InternalEObject) newSnapshot).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MetadataPackage.VERSIONING__SNAPSHOT, null, msgs);
			msgs = basicSetSnapshot(newSnapshot, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.VERSIONING__SNAPSHOT, newSnapshot,
					newSnapshot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SnapshotVersionsType getSnapshotVersions() {
		return snapshotVersions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSnapshotVersions(SnapshotVersionsType newSnapshotVersions,
			NotificationChain msgs) {
		SnapshotVersionsType oldSnapshotVersions = snapshotVersions;
		snapshotVersions = newSnapshotVersions;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MetadataPackage.VERSIONING__SNAPSHOT_VERSIONS, oldSnapshotVersions, newSnapshotVersions);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSnapshotVersions(SnapshotVersionsType newSnapshotVersions) {
		if (newSnapshotVersions != snapshotVersions) {
			NotificationChain msgs = null;
			if (snapshotVersions != null)
				msgs = ((InternalEObject) snapshotVersions).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MetadataPackage.VERSIONING__SNAPSHOT_VERSIONS, null, msgs);
			if (newSnapshotVersions != null)
				msgs = ((InternalEObject) newSnapshotVersions).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MetadataPackage.VERSIONING__SNAPSHOT_VERSIONS, null, msgs);
			msgs = basicSetSnapshotVersions(newSnapshotVersions, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.VERSIONING__SNAPSHOT_VERSIONS,
					newSnapshotVersions, newSnapshotVersions));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLatest(String newLatest) {
		String oldLatest = latest;
		latest = newLatest;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.VERSIONING__LATEST, oldLatest,
					latest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRelease(String newRelease) {
		String oldRelease = release;
		release = newRelease;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.VERSIONING__RELEASE, oldRelease,
					release));
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
		result.append(" (latest: ");
		result.append(latest);
		result.append(", release: ");
		result.append(release);
		result.append(", lastUpdated: ");
		result.append(lastUpdated);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetadataPackage.Literals.VERSIONING;
	}

} // VersioningImpl
