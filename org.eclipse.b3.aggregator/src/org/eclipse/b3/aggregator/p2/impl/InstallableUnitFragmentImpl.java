/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.b3.aggregator.p2.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.b3.aggregator.p2.InstallableUnitFragment;
import org.eclipse.b3.aggregator.p2.P2Package;
import org.eclipse.b3.aggregator.p2.RequiredCapability;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.eclipse.equinox.internal.provisional.p2.metadata.IRequiredCapability;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Installable Unit Fragment</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.b3.aggregator.p2.impl.InstallableUnitFragmentImpl#getHostList <em>Host List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InstallableUnitFragmentImpl extends InstallableUnitImpl implements InstallableUnitFragment
{
	/**
	 * The cached value of the '{@link #getHostList() <em>Host List</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getHostList()
	 * @generated
	 * @ordered
	 */
	protected EList<RequiredCapability> hostList;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected InstallableUnitFragmentImpl()
	{
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID) {
			case P2Package.INSTALLABLE_UNIT_FRAGMENT__HOST_LIST:
				return getHostList();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
	{
		switch (featureID) {
			case P2Package.INSTALLABLE_UNIT_FRAGMENT__HOST_LIST:
				return ((InternalEList<?>)getHostList()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID)
	{
		switch (featureID) {
			case P2Package.INSTALLABLE_UNIT_FRAGMENT__HOST_LIST:
				return hostList != null && !hostList.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue)
	{
		switch (featureID) {
			case P2Package.INSTALLABLE_UNIT_FRAGMENT__HOST_LIST:
				getHostList().clear();
				getHostList().addAll((Collection<? extends RequiredCapability>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID)
	{
		switch (featureID) {
			case P2Package.INSTALLABLE_UNIT_FRAGMENT__HOST_LIST:
				getHostList().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public IRequiredCapability[] getHost()
	{
		List<RequiredCapability> list = getHostList();
		return list.toArray(new IRequiredCapability[list.size()]);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<RequiredCapability> getHostList()
	{
		if (hostList == null) {
			hostList = new EObjectContainmentEList<RequiredCapability>(RequiredCapability.class, this, P2Package.INSTALLABLE_UNIT_FRAGMENT__HOST_LIST);
		}
		return hostList;
	}

	@Override
	public boolean isFragment()
	{
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass()
	{
		return P2Package.Literals.INSTALLABLE_UNIT_FRAGMENT;
	}

} // InstallableUnitFragmentImpl
