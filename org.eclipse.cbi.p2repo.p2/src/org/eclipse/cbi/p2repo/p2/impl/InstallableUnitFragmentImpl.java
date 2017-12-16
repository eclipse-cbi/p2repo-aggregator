/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */
package org.eclipse.cbi.p2repo.p2.impl;

import java.util.Collection;

import org.eclipse.cbi.p2repo.p2.InstallableUnitFragment;
import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.equinox.p2.metadata.IRequirement;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Installable Unit Fragment</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitFragmentImpl#getHost <em>Host</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstallableUnitFragmentImpl extends InstallableUnitImpl implements InstallableUnitFragment {

	/**
	 * The cached value of the '{@link #getHost() <em>Host</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getHost()
	 * @generated
	 * @ordered
	 */
	protected EList<IRequirement> host;

	// private Collection<IRequirement> hostList;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected InstallableUnitFragmentImpl() {
		super();
	}

	// /**
	// * <!-- begin-user-doc -->
	// * <!-- end-user-doc -->
	// *
	// * @generated NOT
	// */
	// public Collection<IRequirement> getHost() {
	// if(hostList == null)
	// hostList = new ArrayList<IRequirement>();
	//
	// return hostList;
	// }

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2Package.INSTALLABLE_UNIT_FRAGMENT__HOST:
				return getHost();
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
			case P2Package.INSTALLABLE_UNIT_FRAGMENT__HOST:
				return ((InternalEList<?>) getHost()).basicRemove(otherEnd, msgs);
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
			case P2Package.INSTALLABLE_UNIT_FRAGMENT__HOST:
				return host != null && !host.isEmpty();
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
			case P2Package.INSTALLABLE_UNIT_FRAGMENT__HOST:
				getHost().clear();
				getHost().addAll((Collection<? extends IRequirement>) newValue);
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
		return P2Package.Literals.INSTALLABLE_UNIT_FRAGMENT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.INSTALLABLE_UNIT_FRAGMENT__HOST:
				getHost().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IRequirement> getHost() {
		if (host == null) {
			host = new EObjectContainmentEList.Resolving<>(IRequirement.class, this,
					P2Package.INSTALLABLE_UNIT_FRAGMENT__HOST);
		}
		return host;
	}

} // InstallableUnitFragmentImpl
