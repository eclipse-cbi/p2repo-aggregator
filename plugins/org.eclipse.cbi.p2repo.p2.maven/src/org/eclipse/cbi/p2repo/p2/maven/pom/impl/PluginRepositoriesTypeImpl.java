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

import java.util.Collection;

import org.eclipse.cbi.p2repo.p2.maven.pom.PluginRepositoriesType;
import org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage;
import org.eclipse.cbi.p2repo.p2.maven.pom.Repository;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Plugin Repositories Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.impl.PluginRepositoriesTypeImpl#getPluginRepository <em>Plugin Repository</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PluginRepositoriesTypeImpl extends MinimalEObjectImpl.Container implements PluginRepositoriesType {
	/**
	 * The cached value of the '{@link #getPluginRepository() <em>Plugin Repository</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPluginRepository()
	 * @generated
	 * @ordered
	 */
	protected EList<Repository> pluginRepository;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PluginRepositoriesTypeImpl() {
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
			case PomPackage.PLUGIN_REPOSITORIES_TYPE__PLUGIN_REPOSITORY:
				return getPluginRepository();
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
			case PomPackage.PLUGIN_REPOSITORIES_TYPE__PLUGIN_REPOSITORY:
				return ((InternalEList<?>) getPluginRepository()).basicRemove(otherEnd, msgs);
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
			case PomPackage.PLUGIN_REPOSITORIES_TYPE__PLUGIN_REPOSITORY:
				return pluginRepository != null && !pluginRepository.isEmpty();
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
			case PomPackage.PLUGIN_REPOSITORIES_TYPE__PLUGIN_REPOSITORY:
				getPluginRepository().clear();
				getPluginRepository().addAll((Collection<? extends Repository>) newValue);
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
			case PomPackage.PLUGIN_REPOSITORIES_TYPE__PLUGIN_REPOSITORY:
				getPluginRepository().clear();
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
	public EList<Repository> getPluginRepository() {
		if (pluginRepository == null) {
			pluginRepository = new EObjectContainmentEList<>(Repository.class, this,
					PomPackage.PLUGIN_REPOSITORIES_TYPE__PLUGIN_REPOSITORY);
		}
		return pluginRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PomPackage.Literals.PLUGIN_REPOSITORIES_TYPE;
	}

} // PluginRepositoriesTypeImpl
