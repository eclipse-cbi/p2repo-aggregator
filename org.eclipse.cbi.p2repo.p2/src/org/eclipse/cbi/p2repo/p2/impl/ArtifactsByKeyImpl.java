/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 */
package org.eclipse.cbi.p2repo.p2.impl;

import java.util.Collection;

import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Artifacts By Key</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactsByKeyImpl#getTypedKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactsByKeyImpl#getTypedValue <em>Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArtifactsByKeyImpl extends MinimalEObjectImpl.Container
		implements BasicEMap.Entry<IArtifactKey, EList<IArtifactDescriptor>> {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getTypedKey() <em>Key</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTypedKey()
	 * @generated
	 * @ordered
	 */
	protected IArtifactKey key;

	/**
	 * The cached value of the '{@link #getTypedValue() <em>Value</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getTypedValue()
	 * @generated
	 * @ordered
	 */
	protected EList<IArtifactDescriptor> value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected int hash = -1;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ArtifactsByKeyImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IArtifactKey basicGetTypedKey() {
		return key;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypedKey(IArtifactKey newKey, NotificationChain msgs) {
		IArtifactKey oldKey = key;
		key = newKey;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2Package.ARTIFACTS_BY_KEY__KEY, oldKey, newKey);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2Package.ARTIFACTS_BY_KEY__KEY:
				if (resolve)
					return getTypedKey();
				return basicGetTypedKey();
			case P2Package.ARTIFACTS_BY_KEY__VALUE:
				return getTypedValue();
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
			case P2Package.ARTIFACTS_BY_KEY__KEY:
				return basicSetTypedKey(null, msgs);
			case P2Package.ARTIFACTS_BY_KEY__VALUE:
				return ((InternalEList<?>) getTypedValue()).basicRemove(otherEnd, msgs);
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
			case P2Package.ARTIFACTS_BY_KEY__KEY:
				return key != null;
			case P2Package.ARTIFACTS_BY_KEY__VALUE:
				return value != null && !value.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case P2Package.ARTIFACTS_BY_KEY__KEY:
				setTypedKey((IArtifactKey) newValue);
				return;
			case P2Package.ARTIFACTS_BY_KEY__VALUE:
				getTypedValue().clear();
				getTypedValue().addAll((Collection<? extends IArtifactDescriptor>) newValue);
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
		return P2Package.Literals.ARTIFACTS_BY_KEY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.ARTIFACTS_BY_KEY__KEY:
				setTypedKey((IArtifactKey) null);
				return;
			case P2Package.ARTIFACTS_BY_KEY__VALUE:
				getTypedValue().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public EMap<IArtifactKey, EList<IArtifactDescriptor>> getEMap() {
		EObject container = eContainer();
		return container == null ? null
				: (EMap<IArtifactKey, EList<IArtifactDescriptor>>) container.eGet(eContainmentFeature());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getHash() {
		if (hash == -1) {
			Object theKey = getKey();
			hash = (theKey == null ? 0 : theKey.hashCode());
		}
		return hash;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IArtifactKey getKey() {
		return getTypedKey();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IArtifactKey getTypedKey() {
		if (key != null && ((EObject) key).eIsProxy()) {
			InternalEObject oldKey = (InternalEObject) key;
			key = (IArtifactKey) eResolveProxy(oldKey);
			if (key != oldKey) {
				InternalEObject newKey = (InternalEObject) key;
				NotificationChain msgs = oldKey.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2Package.ARTIFACTS_BY_KEY__KEY, null, null);
				if (newKey.eInternalContainer() == null) {
					msgs = newKey.eInverseAdd(this, EOPPOSITE_FEATURE_BASE - P2Package.ARTIFACTS_BY_KEY__KEY, null,
							msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, P2Package.ARTIFACTS_BY_KEY__KEY, oldKey,
							key));
			}
		}
		return key;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IArtifactDescriptor> getTypedValue() {
		if (value == null) {
			value = new EObjectContainmentEList.Resolving<>(IArtifactDescriptor.class, this,
					P2Package.ARTIFACTS_BY_KEY__VALUE);
		}
		return value;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IArtifactDescriptor> getValue() {
		return getTypedValue();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setHash(int hash) {
		this.hash = hash;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setKey(IArtifactKey key) {
		setTypedKey(key);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypedKey(IArtifactKey newKey) {
		if (newKey != key) {
			NotificationChain msgs = null;
			if (key != null)
				msgs = ((InternalEObject) key).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2Package.ARTIFACTS_BY_KEY__KEY, null, msgs);
			if (newKey != null)
				msgs = ((InternalEObject) newKey).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2Package.ARTIFACTS_BY_KEY__KEY, null, msgs);
			msgs = basicSetTypedKey(newKey, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.ARTIFACTS_BY_KEY__KEY, newKey, newKey));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IArtifactDescriptor> setValue(EList<IArtifactDescriptor> value) {
		EList<IArtifactDescriptor> oldValue = getValue();
		getTypedValue().clear();
		getTypedValue().addAll(value);
		return oldValue;
	}

} // ArtifactsByKeyImpl
