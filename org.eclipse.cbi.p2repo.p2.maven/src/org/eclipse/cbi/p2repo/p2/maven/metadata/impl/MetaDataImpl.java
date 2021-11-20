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

import org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData;
import org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage;
import org.eclipse.cbi.p2repo.p2.maven.metadata.PluginsType;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Meta Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl#getArtifactId <em>Artifact Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl#getVersioning <em>Versioning</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl#getPlugins <em>Plugins</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.MetaDataImpl#getModelVersion <em>Model Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetaDataImpl extends MinimalEObjectImpl.Container implements MetaData {
	/**
	 * The default value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected static final String GROUP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getGroupId() <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGroupId()
	 * @generated
	 * @ordered
	 */
	protected String groupId = GROUP_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getArtifactId() <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifactId()
	 * @generated
	 * @ordered
	 */
	protected static final String ARTIFACT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getArtifactId() <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifactId()
	 * @generated
	 * @ordered
	 */
	protected String artifactId = ARTIFACT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVersioning() <em>Versioning</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersioning()
	 * @generated
	 * @ordered
	 */
	protected Versioning versioning;

	/**
	 * The cached value of the '{@link #getPlugins() <em>Plugins</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlugins()
	 * @generated
	 * @ordered
	 */
	protected PluginsType plugins;

	/**
	 * The default value of the '{@link #getModelVersion() <em>Model Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String MODEL_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getModelVersion() <em>Model Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getModelVersion()
	 * @generated
	 * @ordered
	 */
	protected String modelVersion = MODEL_VERSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetaDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetVersioning(Versioning newVersioning, NotificationChain msgs) {
		Versioning oldVersioning = versioning;
		versioning = newVersioning;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MetadataPackage.META_DATA__VERSIONING, oldVersioning, newVersioning);
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetadataPackage.META_DATA__GROUP_ID:
				return getGroupId();
			case MetadataPackage.META_DATA__ARTIFACT_ID:
				return getArtifactId();
			case MetadataPackage.META_DATA__VERSION:
				return getVersion();
			case MetadataPackage.META_DATA__VERSIONING:
				return getVersioning();
			case MetadataPackage.META_DATA__PLUGINS:
				return getPlugins();
			case MetadataPackage.META_DATA__MODEL_VERSION:
				return getModelVersion();
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
			case MetadataPackage.META_DATA__VERSIONING:
				return basicSetVersioning(null, msgs);
			case MetadataPackage.META_DATA__PLUGINS:
				return basicSetPlugins(null, msgs);
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
			case MetadataPackage.META_DATA__GROUP_ID:
				return GROUP_ID_EDEFAULT == null ? groupId != null : !GROUP_ID_EDEFAULT.equals(groupId);
			case MetadataPackage.META_DATA__ARTIFACT_ID:
				return ARTIFACT_ID_EDEFAULT == null ? artifactId != null : !ARTIFACT_ID_EDEFAULT.equals(artifactId);
			case MetadataPackage.META_DATA__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case MetadataPackage.META_DATA__VERSIONING:
				return versioning != null;
			case MetadataPackage.META_DATA__PLUGINS:
				return plugins != null;
			case MetadataPackage.META_DATA__MODEL_VERSION:
				return MODEL_VERSION_EDEFAULT == null ? modelVersion != null
						: !MODEL_VERSION_EDEFAULT.equals(modelVersion);
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
			case MetadataPackage.META_DATA__GROUP_ID:
				setGroupId((String) newValue);
				return;
			case MetadataPackage.META_DATA__ARTIFACT_ID:
				setArtifactId((String) newValue);
				return;
			case MetadataPackage.META_DATA__VERSION:
				setVersion((String) newValue);
				return;
			case MetadataPackage.META_DATA__VERSIONING:
				setVersioning((Versioning) newValue);
				return;
			case MetadataPackage.META_DATA__PLUGINS:
				setPlugins((PluginsType) newValue);
				return;
			case MetadataPackage.META_DATA__MODEL_VERSION:
				setModelVersion((String) newValue);
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
			case MetadataPackage.META_DATA__GROUP_ID:
				setGroupId(GROUP_ID_EDEFAULT);
				return;
			case MetadataPackage.META_DATA__ARTIFACT_ID:
				setArtifactId(ARTIFACT_ID_EDEFAULT);
				return;
			case MetadataPackage.META_DATA__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case MetadataPackage.META_DATA__VERSIONING:
				setVersioning((Versioning) null);
				return;
			case MetadataPackage.META_DATA__PLUGINS:
				setPlugins((PluginsType) null);
				return;
			case MetadataPackage.META_DATA__MODEL_VERSION:
				setModelVersion(MODEL_VERSION_EDEFAULT);
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
	public String getArtifactId() {
		return artifactId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getGroupId() {
		return groupId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Versioning getVersioning() {
		return versioning;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setArtifactId(String newArtifactId) {
		String oldArtifactId = artifactId;
		artifactId = newArtifactId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.META_DATA__ARTIFACT_ID, oldArtifactId,
					artifactId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setGroupId(String newGroupId) {
		String oldGroupId = groupId;
		groupId = newGroupId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.META_DATA__GROUP_ID, oldGroupId,
					groupId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.META_DATA__VERSION, oldVersion,
					version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersioning(Versioning newVersioning) {
		if (newVersioning != versioning) {
			NotificationChain msgs = null;
			if (versioning != null)
				msgs = ((InternalEObject) versioning).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MetadataPackage.META_DATA__VERSIONING, null, msgs);
			if (newVersioning != null)
				msgs = ((InternalEObject) newVersioning).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MetadataPackage.META_DATA__VERSIONING, null, msgs);
			msgs = basicSetVersioning(newVersioning, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.META_DATA__VERSIONING, newVersioning,
					newVersioning));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PluginsType getPlugins() {
		return plugins;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlugins(PluginsType newPlugins, NotificationChain msgs) {
		PluginsType oldPlugins = plugins;
		plugins = newPlugins;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MetadataPackage.META_DATA__PLUGINS, oldPlugins, newPlugins);
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
	public void setPlugins(PluginsType newPlugins) {
		if (newPlugins != plugins) {
			NotificationChain msgs = null;
			if (plugins != null)
				msgs = ((InternalEObject) plugins).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MetadataPackage.META_DATA__PLUGINS, null, msgs);
			if (newPlugins != null)
				msgs = ((InternalEObject) newPlugins).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MetadataPackage.META_DATA__PLUGINS, null, msgs);
			msgs = basicSetPlugins(newPlugins, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.META_DATA__PLUGINS, newPlugins,
					newPlugins));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getModelVersion() {
		return modelVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setModelVersion(String newModelVersion) {
		String oldModelVersion = modelVersion;
		modelVersion = newModelVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MetadataPackage.META_DATA__MODEL_VERSION,
					oldModelVersion, modelVersion));
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
		result.append(" (groupId: ");
		result.append(groupId);
		result.append(", artifactId: ");
		result.append(artifactId);
		result.append(", version: ");
		result.append(version);
		result.append(", modelVersion: ");
		result.append(modelVersion);
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
		return MetadataPackage.Literals.META_DATA;
	}

} // MetaDataImpl
