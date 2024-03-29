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

import org.eclipse.cbi.p2repo.p2.maven.pom.PluginManagement;
import org.eclipse.cbi.p2repo.p2.maven.pom.PluginsType;
import org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plugin Management</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.impl.PluginManagementImpl#getPlugins <em>Plugins</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PluginManagementImpl extends MinimalEObjectImpl.Container implements PluginManagement {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PluginManagementImpl() {
		super();
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
					PomPackage.PLUGIN_MANAGEMENT__PLUGINS, oldPlugins, newPlugins);
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
			case PomPackage.PLUGIN_MANAGEMENT__PLUGINS:
				return getPlugins();
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
			case PomPackage.PLUGIN_MANAGEMENT__PLUGINS:
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
			case PomPackage.PLUGIN_MANAGEMENT__PLUGINS:
				return plugins != null;
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
			case PomPackage.PLUGIN_MANAGEMENT__PLUGINS:
				setPlugins((PluginsType) newValue);
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
			case PomPackage.PLUGIN_MANAGEMENT__PLUGINS:
				setPlugins((PluginsType) null);
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
	public PluginsType getPlugins() {
		return plugins;
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
						EOPPOSITE_FEATURE_BASE - PomPackage.PLUGIN_MANAGEMENT__PLUGINS, null, msgs);
			if (newPlugins != null)
				msgs = ((InternalEObject) newPlugins).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - PomPackage.PLUGIN_MANAGEMENT__PLUGINS, null, msgs);
			msgs = basicSetPlugins(newPlugins, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PomPackage.PLUGIN_MANAGEMENT__PLUGINS, newPlugins,
					newPlugins));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PomPackage.Literals.PLUGIN_MANAGEMENT;
	}

} // PluginManagementImpl
