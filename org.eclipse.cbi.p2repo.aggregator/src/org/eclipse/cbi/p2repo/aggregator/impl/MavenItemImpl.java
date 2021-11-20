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

import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.MavenItem;
import org.eclipse.cbi.p2repo.aggregator.MavenMapping;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Maven Item</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenItemImpl#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenItemImpl#getArtifactId <em>Artifact Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenItemImpl#getMappedVersion <em>Mapped Version</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenItemImpl#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MavenItemImpl#getMavenMapping <em>Maven Mapping</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MavenItemImpl extends MinimalEObjectImpl.Container implements MavenItem {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

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
	 * The default value of the '{@link #getMappedVersion() <em>Mapped Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String MAPPED_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMappedVersion() <em>Mapped Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMappedVersion()
	 * @generated
	 * @ordered
	 */
	protected String mappedVersion = MAPPED_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getClassifier() <em>Classifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifier()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASSIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassifier() <em>Classifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassifier()
	 * @generated
	 * @ordered
	 */
	protected String classifier = CLASSIFIER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMavenMapping() <em>Maven Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMavenMapping()
	 * @generated
	 * @ordered
	 */
	protected MavenMapping mavenMapping;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MavenItemImpl() {
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
			case AggregatorPackage.MAVEN_ITEM__GROUP_ID:
				return getGroupId();
			case AggregatorPackage.MAVEN_ITEM__ARTIFACT_ID:
				return getArtifactId();
			case AggregatorPackage.MAVEN_ITEM__MAPPED_VERSION:
				return getMappedVersion();
			case AggregatorPackage.MAVEN_ITEM__CLASSIFIER:
				return getClassifier();
			case AggregatorPackage.MAVEN_ITEM__MAVEN_MAPPING:
				if (resolve)
					return getMavenMapping();
				return basicGetMavenMapping();
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
			case AggregatorPackage.MAVEN_ITEM__GROUP_ID:
				return GROUP_ID_EDEFAULT == null ? groupId != null : !GROUP_ID_EDEFAULT.equals(groupId);
			case AggregatorPackage.MAVEN_ITEM__ARTIFACT_ID:
				return ARTIFACT_ID_EDEFAULT == null ? artifactId != null : !ARTIFACT_ID_EDEFAULT.equals(artifactId);
			case AggregatorPackage.MAVEN_ITEM__MAPPED_VERSION:
				return MAPPED_VERSION_EDEFAULT == null ? mappedVersion != null
						: !MAPPED_VERSION_EDEFAULT.equals(mappedVersion);
			case AggregatorPackage.MAVEN_ITEM__CLASSIFIER:
				return CLASSIFIER_EDEFAULT == null ? classifier != null : !CLASSIFIER_EDEFAULT.equals(classifier);
			case AggregatorPackage.MAVEN_ITEM__MAVEN_MAPPING:
				return mavenMapping != null;
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
			case AggregatorPackage.MAVEN_ITEM__GROUP_ID:
				setGroupId((String) newValue);
				return;
			case AggregatorPackage.MAVEN_ITEM__ARTIFACT_ID:
				setArtifactId((String) newValue);
				return;
			case AggregatorPackage.MAVEN_ITEM__MAPPED_VERSION:
				setMappedVersion((String) newValue);
				return;
			case AggregatorPackage.MAVEN_ITEM__CLASSIFIER:
				setClassifier((String) newValue);
				return;
			case AggregatorPackage.MAVEN_ITEM__MAVEN_MAPPING:
				setMavenMapping((MavenMapping) newValue);
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
		return AggregatorPackage.Literals.MAVEN_ITEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AggregatorPackage.MAVEN_ITEM__GROUP_ID:
				setGroupId(GROUP_ID_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_ITEM__ARTIFACT_ID:
				setArtifactId(ARTIFACT_ID_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_ITEM__MAPPED_VERSION:
				setMappedVersion(MAPPED_VERSION_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_ITEM__CLASSIFIER:
				setClassifier(CLASSIFIER_EDEFAULT);
				return;
			case AggregatorPackage.MAVEN_ITEM__MAVEN_MAPPING:
				setMavenMapping((MavenMapping) null);
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
	public String getClassifier() {
		return classifier;
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
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isSources() {
		return MavenMappingImpl.MAVEN_SOURCES_CLASSIFIER.equals(getClassifier());
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
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.MAVEN_ITEM__ARTIFACT_ID,
					oldArtifactId, artifactId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMappedVersion() {
		return mappedVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMappedVersion(String newMappedVersion) {
		String oldMappedVersion = mappedVersion;
		mappedVersion = newMappedVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.MAVEN_ITEM__MAPPED_VERSION,
					oldMappedVersion, mappedVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setClassifier(String newClassifier) {
		String oldClassifier = classifier;
		classifier = newClassifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.MAVEN_ITEM__CLASSIFIER,
					oldClassifier, classifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MavenMapping getMavenMapping() {
		if (mavenMapping != null && ((EObject) mavenMapping).eIsProxy()) {
			InternalEObject oldMavenMapping = (InternalEObject) mavenMapping;
			mavenMapping = (MavenMapping) eResolveProxy(oldMavenMapping);
			if (mavenMapping != oldMavenMapping) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AggregatorPackage.MAVEN_ITEM__MAVEN_MAPPING, oldMavenMapping, mavenMapping));
			}
		}
		return mavenMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MavenMapping basicGetMavenMapping() {
		return mavenMapping;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMavenMapping(MavenMapping newMavenMapping) {
		MavenMapping oldMavenMapping = mavenMapping;
		mavenMapping = newMavenMapping;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.MAVEN_ITEM__MAVEN_MAPPING,
					oldMavenMapping, mavenMapping));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.MAVEN_ITEM__GROUP_ID, oldGroupId,
					groupId));
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
		result.append(", mappedVersion: ");
		result.append(mappedVersion);
		result.append(", classifier: ");
		result.append(classifier);
		result.append(')');
		return result.toString();
	}

} // MavenItemImpl
