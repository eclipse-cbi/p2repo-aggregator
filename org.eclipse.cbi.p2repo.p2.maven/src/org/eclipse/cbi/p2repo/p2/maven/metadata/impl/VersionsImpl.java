/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.p2.maven.metadata.impl;

import java.util.Collection;

import org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataPackage;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Versions;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Versions</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 * <li>{@link org.eclipse.cbi.p2repo.p2.maven.metadata.impl.VersionsImpl#getVersion <em>Version</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VersionsImpl extends EObjectImpl implements Versions {
	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected EList<String> version;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	protected VersionsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
			case MetadataPackage.VERSIONS__VERSION:
				return getVersion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
			case MetadataPackage.VERSIONS__VERSION:
				return version != null && !version.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
			case MetadataPackage.VERSIONS__VERSION:
				getVersion().clear();
				getVersion().addAll((Collection<? extends String>) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
			case MetadataPackage.VERSIONS__VERSION:
				getVersion().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public EList<String> getVersion() {
		if(version == null) {
			version = new EDataTypeUniqueEList<String>(String.class, this, MetadataPackage.VERSIONS__VERSION);
		}
		return version;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (version: ");
		result.append(version);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MetadataPackage.Literals.VERSIONS;
	}

} // VersionsImpl
