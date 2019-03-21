/**
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata.impl;

import java.util.Collection;

import org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage;
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion;
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersionsType;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Snapshot Versions Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.SnapshotVersionsTypeImpl#getSnapshotVersion <em>Snapshot Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SnapshotVersionsTypeImpl extends EObjectImpl implements SnapshotVersionsType {
	/**
	 * The cached value of the '{@link #getSnapshotVersion() <em>Snapshot Version</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSnapshotVersion()
	 * @generated
	 * @ordered
	 */
	protected EList<SnapshotVersion> snapshotVersion;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SnapshotVersionsTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetadataPackage.Literals.SNAPSHOT_VERSIONS_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<SnapshotVersion> getSnapshotVersion() {
		if (snapshotVersion == null) {
			snapshotVersion = new EObjectContainmentEList<>(SnapshotVersion.class, this,
					MetadataPackage.SNAPSHOT_VERSIONS_TYPE__SNAPSHOT_VERSION);
		}
		return snapshotVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MetadataPackage.SNAPSHOT_VERSIONS_TYPE__SNAPSHOT_VERSION:
				return ((InternalEList<?>) getSnapshotVersion()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case MetadataPackage.SNAPSHOT_VERSIONS_TYPE__SNAPSHOT_VERSION:
				return getSnapshotVersion();
		}
		return super.eGet(featureID, resolve, coreType);
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
			case MetadataPackage.SNAPSHOT_VERSIONS_TYPE__SNAPSHOT_VERSION:
				getSnapshotVersion().clear();
				getSnapshotVersion().addAll((Collection<? extends SnapshotVersion>) newValue);
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
			case MetadataPackage.SNAPSHOT_VERSIONS_TYPE__SNAPSHOT_VERSION:
				getSnapshotVersion().clear();
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
			case MetadataPackage.SNAPSHOT_VERSIONS_TYPE__SNAPSHOT_VERSION:
				return snapshotVersion != null && !snapshotVersion.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SnapshotVersionsTypeImpl
