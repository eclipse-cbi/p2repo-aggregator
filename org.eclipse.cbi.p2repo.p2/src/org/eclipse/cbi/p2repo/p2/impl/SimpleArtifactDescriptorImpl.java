/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 */
package org.eclipse.cbi.p2repo.p2.impl;

import java.util.Map;

import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.p2.SimpleArtifactDescriptor;
import org.eclipse.cbi.p2repo.util.Trivial;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Simple
 * Artifact Descriptor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.SimpleArtifactDescriptorImpl#getRepositoryPropertyMap <em>Repository Property Map</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SimpleArtifactDescriptorImpl extends ArtifactDescriptorImpl implements SimpleArtifactDescriptor {
	/**
	 * The cached value of the '{@link #getRepositoryPropertyMap() <em>Repository Property Map</em>}' map.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getRepositoryPropertyMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> repositoryPropertyMap;

	public static final String ARTIFACT_REFERENCE = "artifact.reference"; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected SimpleArtifactDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2Package.SIMPLE_ARTIFACT_DESCRIPTOR__REPOSITORY_PROPERTY_MAP:
				if (coreType)
					return getRepositoryPropertyMap();
				else
					return getRepositoryPropertyMap().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case P2Package.SIMPLE_ARTIFACT_DESCRIPTOR__REPOSITORY_PROPERTY_MAP:
				return ((InternalEList<?>) getRepositoryPropertyMap()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case P2Package.SIMPLE_ARTIFACT_DESCRIPTOR__REPOSITORY_PROPERTY_MAP:
				return repositoryPropertyMap != null && !repositoryPropertyMap.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SimpleArtifactDescriptorImpl))
			return false;

		SimpleArtifactDescriptorImpl other = (SimpleArtifactDescriptorImpl) obj;
		return Trivial.equalsAllowNull(getRepositoryProperty(ARTIFACT_REFERENCE),
				other.getRepositoryProperty(ARTIFACT_REFERENCE)) && super.equals(obj);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case P2Package.SIMPLE_ARTIFACT_DESCRIPTOR__REPOSITORY_PROPERTY_MAP:
				((EStructuralFeature.Setting) getRepositoryPropertyMap()).set(newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return P2Package.Literals.SIMPLE_ARTIFACT_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.SIMPLE_ARTIFACT_DESCRIPTOR__REPOSITORY_PROPERTY_MAP:
				getRepositoryPropertyMap().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Map<String, String> getRepositoryProperties() {
		return getRepositoryPropertyMap().map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public String getRepositoryProperty(String key) {
		return getRepositoryPropertyMap().get(key);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, String> getRepositoryPropertyMap() {
		if (repositoryPropertyMap == null) {
			repositoryPropertyMap = new EcoreEMap<>(P2Package.Literals.PROPERTY, PropertyImpl.class, this,
					P2Package.SIMPLE_ARTIFACT_DESCRIPTOR__REPOSITORY_PROPERTY_MAP);
		}
		return repositoryPropertyMap;
	}

	@Override
	public int hashCode() {
		int hash = super.hashCode();
		String ref = getRepositoryProperty(ARTIFACT_REFERENCE);
		hash = 31 * hash;
		if (ref != null)
			hash += ref.hashCode();
		return hash;
	}

} // SimpleArtifactDescriptorImpl
