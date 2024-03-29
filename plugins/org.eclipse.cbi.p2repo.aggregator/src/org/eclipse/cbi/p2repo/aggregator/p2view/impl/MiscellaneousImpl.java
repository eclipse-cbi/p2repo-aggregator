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
package org.eclipse.cbi.p2repo.aggregator.p2view.impl;

import java.util.Collection;

import org.eclipse.cbi.p2repo.aggregator.p2view.Miscellaneous;
import org.eclipse.cbi.p2repo.aggregator.p2view.OtherIU;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Miscellaneous</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.MiscellaneousImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.MiscellaneousImpl#getOthers <em>Others</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MiscellaneousImpl extends MinimalEObjectImpl.Container implements Miscellaneous {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getOthers() <em>Others</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOthers()
	 * @generated
	 * @ordered
	 */
	protected EList<OtherIU> others;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MiscellaneousImpl() {
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
			case P2viewPackage.MISCELLANEOUS__CHILDREN:
				return getChildren();
			case P2viewPackage.MISCELLANEOUS__OTHERS:
				return getOthers();
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
			case P2viewPackage.MISCELLANEOUS__CHILDREN:
				return !getChildren().isEmpty();
			case P2viewPackage.MISCELLANEOUS__OTHERS:
				return others != null && !others.isEmpty();
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
			case P2viewPackage.MISCELLANEOUS__OTHERS:
				getOthers().clear();
				getOthers().addAll((Collection<? extends OtherIU>) newValue);
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
		return P2viewPackage.Literals.MISCELLANEOUS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2viewPackage.MISCELLANEOUS__OTHERS:
				getOthers().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public EList<OtherIU> getChildren() {
		return getOthers();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<OtherIU> getOthers() {
		if (others == null) {
			others = new EObjectResolvingEList<>(OtherIU.class, this, P2viewPackage.MISCELLANEOUS__OTHERS);
		}
		return others;
	}

} // MiscellaneousImpl
