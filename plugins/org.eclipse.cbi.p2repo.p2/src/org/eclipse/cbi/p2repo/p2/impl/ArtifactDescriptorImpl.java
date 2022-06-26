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
package org.eclipse.cbi.p2repo.p2.impl;

import java.util.Collection;
import java.util.Map;

import org.eclipse.cbi.p2repo.p2.ArtifactDescriptor;
import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepository;
import org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Artifact Descriptor</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactDescriptorImpl#getArtifactKey <em>Artifact Key</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactDescriptorImpl#getPropertyMap <em>Property Map</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactDescriptorImpl#getProcessingStepList <em>Processing Step List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArtifactDescriptorImpl extends MinimalEObjectImpl.Container implements ArtifactDescriptor {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getArtifactKey() <em>Artifact Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArtifactKey()
	 * @generated
	 * @ordered
	 */
	protected IArtifactKey artifactKey;

	/**
	 * The cached value of the '{@link #getPropertyMap() <em>Property Map</em>}' map.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPropertyMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> propertyMap;

	/**
	 * The cached value of the '{@link #getProcessingStepList() <em>Processing Step List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessingStepList()
	 * @generated
	 * @ordered
	 */
	protected EList<IProcessingStepDescriptor> processingStepList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArtifactDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IArtifactKey basicGetArtifactKey() {
		return artifactKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2Package.ARTIFACT_DESCRIPTOR__ARTIFACT_KEY:
				if (resolve)
					return getArtifactKey();
				return basicGetArtifactKey();
			case P2Package.ARTIFACT_DESCRIPTOR__PROPERTY_MAP:
				if (coreType)
					return getPropertyMap();
				else
					return getPropertyMap().map();
			case P2Package.ARTIFACT_DESCRIPTOR__PROCESSING_STEP_LIST:
				return getProcessingStepList();
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
			case P2Package.ARTIFACT_DESCRIPTOR__PROPERTY_MAP:
				return ((InternalEList<?>) getPropertyMap()).basicRemove(otherEnd, msgs);
			case P2Package.ARTIFACT_DESCRIPTOR__PROCESSING_STEP_LIST:
				return ((InternalEList<?>) getProcessingStepList()).basicRemove(otherEnd, msgs);
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
			case P2Package.ARTIFACT_DESCRIPTOR__ARTIFACT_KEY:
				return artifactKey != null;
			case P2Package.ARTIFACT_DESCRIPTOR__PROPERTY_MAP:
				return propertyMap != null && !propertyMap.isEmpty();
			case P2Package.ARTIFACT_DESCRIPTOR__PROCESSING_STEP_LIST:
				return processingStepList != null && !processingStepList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean equals(Object v) {
		if (this == v)
			return true;
		if (!(v instanceof ArtifactDescriptor))
			return false;

		ArtifactDescriptor cmp = (ArtifactDescriptor) v;
		if (!getArtifactKey().equals(cmp.getArtifactKey()))
			return false;

		String format = getProperty(IArtifactDescriptor.FORMAT);
		String cmpFormat = cmp.getProperty(IArtifactDescriptor.FORMAT);
		if (format == null) {
			if (cmpFormat != null)
				return false;
		} else {
			if (!format.equals(cmpFormat))
				return false;
		}

		EList<IProcessingStepDescriptor> steps = getProcessingStepList();
		EList<IProcessingStepDescriptor> cmpSteps = cmp.getProcessingStepList();
		int idx = steps.size();
		if (idx != cmpSteps.size())
			return false;

		while (--idx >= 0)
			if (!steps.get(idx).equals(cmpSteps.get(idx)))
				return false;
		return true;
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
			case P2Package.ARTIFACT_DESCRIPTOR__ARTIFACT_KEY:
				setArtifactKey((IArtifactKey) newValue);
				return;
			case P2Package.ARTIFACT_DESCRIPTOR__PROPERTY_MAP:
				((EStructuralFeature.Setting) getPropertyMap()).set(newValue);
				return;
			case P2Package.ARTIFACT_DESCRIPTOR__PROCESSING_STEP_LIST:
				getProcessingStepList().clear();
				getProcessingStepList().addAll((Collection<? extends IProcessingStepDescriptor>) newValue);
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
		return P2Package.Literals.ARTIFACT_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.ARTIFACT_DESCRIPTOR__ARTIFACT_KEY:
				setArtifactKey((IArtifactKey) null);
				return;
			case P2Package.ARTIFACT_DESCRIPTOR__PROPERTY_MAP:
				getPropertyMap().clear();
				return;
			case P2Package.ARTIFACT_DESCRIPTOR__PROCESSING_STEP_LIST:
				getProcessingStepList().clear();
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
	public IArtifactKey getArtifactKey() {
		if (artifactKey != null && ((EObject) artifactKey).eIsProxy()) {
			InternalEObject oldArtifactKey = (InternalEObject) artifactKey;
			artifactKey = (IArtifactKey) eResolveProxy(oldArtifactKey);
			if (artifactKey != oldArtifactKey) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							P2Package.ARTIFACT_DESCRIPTOR__ARTIFACT_KEY, oldArtifactKey, artifactKey));
			}
		}
		return artifactKey;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IProcessingStepDescriptor> getProcessingStepList() {
		if (processingStepList == null) {
			processingStepList = new EObjectContainmentEList.Resolving<>(
					IProcessingStepDescriptor.class, this, P2Package.ARTIFACT_DESCRIPTOR__PROCESSING_STEP_LIST);
		}
		return processingStepList;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public IProcessingStepDescriptor[] getProcessingSteps() {
		EList<IProcessingStepDescriptor> steps = getProcessingStepList();
		return steps.toArray(new IProcessingStepDescriptor[steps.size()]);
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public Map<String, String> getProperties() {
		return getPropertyMap().map();
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public String getProperty(String key) {
		return getPropertyMap().get(key);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, String> getPropertyMap() {
		if (propertyMap == null) {
			propertyMap = new EcoreEMap<>(P2Package.Literals.PROPERTY, PropertyImpl.class, this,
					P2Package.ARTIFACT_DESCRIPTOR__PROPERTY_MAP);
		}
		return propertyMap;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public IArtifactRepository getRepository() {
		EObject container = eContainer();
		if (container instanceof ArtifactsByKeyImpl) {
			container = container.eContainer();
			if (container instanceof IArtifactRepository)
				return (IArtifactRepository) container;
		}
		return null;
	}

	@Override
	public int hashCode() {
		int hash = getArtifactKey().hashCode();
		String format = getProperty(IArtifactDescriptor.FORMAT);
		if (format != null)
			hash = 17 * hash + format.hashCode();
		EList<IProcessingStepDescriptor> steps = getProcessingStepList();
		int idx = steps.size();
		while (--idx >= 0)
			hash = 17 * hash + steps.get(idx).hashCode();
		return hash;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArtifactKey(IArtifactKey newArtifactKey) {
		IArtifactKey oldArtifactKey = artifactKey;
		artifactKey = newArtifactKey;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.ARTIFACT_DESCRIPTOR__ARTIFACT_KEY,
					oldArtifactKey, artifactKey));
	}

} // ArtifactDescriptorImpl
