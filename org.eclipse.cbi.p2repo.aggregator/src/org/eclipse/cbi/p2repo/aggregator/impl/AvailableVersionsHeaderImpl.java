/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.aggregator.impl;

import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.AvailableVersion;
import org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader;
import org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Available Versions Header</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionsHeaderImpl#getAvailableVersions <em>Available Versions</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionsHeaderImpl#getInstallableUnitRequest <em>Installable Unit Request</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AvailableVersionsHeaderImpl extends MinimalEObjectImpl.Container implements AvailableVersionsHeader {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AvailableVersionsHeaderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case AggregatorPackage.AVAILABLE_VERSIONS_HEADER__INSTALLABLE_UNIT_REQUEST:
				return eInternalContainer().eInverseRemove(this,
						AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER,
						InstallableUnitRequest.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AggregatorPackage.AVAILABLE_VERSIONS_HEADER__AVAILABLE_VERSIONS:
				return getAvailableVersions();
			case AggregatorPackage.AVAILABLE_VERSIONS_HEADER__INSTALLABLE_UNIT_REQUEST:
				return getInstallableUnitRequest();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AggregatorPackage.AVAILABLE_VERSIONS_HEADER__INSTALLABLE_UNIT_REQUEST:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return eBasicSetContainer(otherEnd,
						AggregatorPackage.AVAILABLE_VERSIONS_HEADER__INSTALLABLE_UNIT_REQUEST, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AggregatorPackage.AVAILABLE_VERSIONS_HEADER__INSTALLABLE_UNIT_REQUEST:
				return eBasicSetContainer(null, AggregatorPackage.AVAILABLE_VERSIONS_HEADER__INSTALLABLE_UNIT_REQUEST,
						msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AggregatorPackage.AVAILABLE_VERSIONS_HEADER__AVAILABLE_VERSIONS:
				return ((InstallableUnitRequestImpl) getInstallableUnitRequest())
						.eIsSet(AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS);
			case AggregatorPackage.AVAILABLE_VERSIONS_HEADER__INSTALLABLE_UNIT_REQUEST:
				return getInstallableUnitRequest() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AggregatorPackage.Literals.AVAILABLE_VERSIONS_HEADER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public EList<AvailableVersion> getAvailableVersions() {
		return getInstallableUnitRequest().getAvailableVersions();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstallableUnitRequest getInstallableUnitRequest() {
		if (eContainerFeatureID() != AggregatorPackage.AVAILABLE_VERSIONS_HEADER__INSTALLABLE_UNIT_REQUEST)
			return null;
		return (InstallableUnitRequest) eInternalContainer();
	}

} // AvailableVersionsHeaderImpl
