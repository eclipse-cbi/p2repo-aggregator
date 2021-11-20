/**
 * Copyright (c) 2021 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.p2.maven.pom.impl;

import java.util.Collection;

import org.eclipse.cbi.p2repo.p2.maven.pom.MailingList;
import org.eclipse.cbi.p2repo.p2.maven.pom.MailingListsType;
import org.eclipse.cbi.p2repo.p2.maven.pom.PomPackage;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Mailing Lists Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.maven.pom.impl.MailingListsTypeImpl#getMailingList <em>Mailing List</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MailingListsTypeImpl extends MinimalEObjectImpl.Container implements MailingListsType {
	/**
	 * The cached value of the '{@link #getMailingList() <em>Mailing List</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMailingList()
	 * @generated
	 * @ordered
	 */
	protected EList<MailingList> mailingList;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MailingListsTypeImpl() {
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
			case PomPackage.MAILING_LISTS_TYPE__MAILING_LIST:
				return getMailingList();
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
			case PomPackage.MAILING_LISTS_TYPE__MAILING_LIST:
				return ((InternalEList<?>) getMailingList()).basicRemove(otherEnd, msgs);
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
			case PomPackage.MAILING_LISTS_TYPE__MAILING_LIST:
				return mailingList != null && !mailingList.isEmpty();
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
			case PomPackage.MAILING_LISTS_TYPE__MAILING_LIST:
				getMailingList().clear();
				getMailingList().addAll((Collection<? extends MailingList>) newValue);
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
			case PomPackage.MAILING_LISTS_TYPE__MAILING_LIST:
				getMailingList().clear();
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
	public EList<MailingList> getMailingList() {
		if (mailingList == null) {
			mailingList = new EObjectContainmentEList<>(MailingList.class, this,
					PomPackage.MAILING_LISTS_TYPE__MAILING_LIST);
		}
		return mailingList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return PomPackage.Literals.MAILING_LISTS_TYPE;
	}

} // MailingListsTypeImpl
