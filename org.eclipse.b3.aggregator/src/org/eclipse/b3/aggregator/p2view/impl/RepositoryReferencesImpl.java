/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */
package org.eclipse.b3.aggregator.p2view.impl;

import java.util.Collection;

import org.eclipse.b3.aggregator.p2view.P2viewPackage;
import org.eclipse.b3.aggregator.p2view.RepositoryReferences;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.equinox.p2.repository.IRepositoryReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository References</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.b3.aggregator.p2view.impl.RepositoryReferencesImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.b3.aggregator.p2view.impl.RepositoryReferencesImpl#getRepositoryReferences <em>Repository References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepositoryReferencesImpl extends MinimalEObjectImpl.Container implements RepositoryReferences {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getRepositoryReferences() <em>Repository References</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<IRepositoryReference> repositoryReferences;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryReferencesImpl() {
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
			case P2viewPackage.REPOSITORY_REFERENCES__CHILDREN:
				return getChildren();
			case P2viewPackage.REPOSITORY_REFERENCES__REPOSITORY_REFERENCES:
				return getRepositoryReferences();
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
			case P2viewPackage.REPOSITORY_REFERENCES__CHILDREN:
				return !getChildren().isEmpty();
			case P2viewPackage.REPOSITORY_REFERENCES__REPOSITORY_REFERENCES:
				return repositoryReferences != null && !repositoryReferences.isEmpty();
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
			case P2viewPackage.REPOSITORY_REFERENCES__REPOSITORY_REFERENCES:
				getRepositoryReferences().clear();
				getRepositoryReferences().addAll((Collection<? extends IRepositoryReference>)newValue);
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
		return P2viewPackage.Literals.REPOSITORY_REFERENCES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2viewPackage.REPOSITORY_REFERENCES__REPOSITORY_REFERENCES:
				getRepositoryReferences().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public EList<IRepositoryReference> getChildren() {
		return getRepositoryReferences();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<IRepositoryReference> getRepositoryReferences() {
		if (repositoryReferences == null) {
			repositoryReferences = new EObjectResolvingEList<IRepositoryReference>(IRepositoryReference.class, this, P2viewPackage.REPOSITORY_REFERENCES__REPOSITORY_REFERENCES);
		}
		return repositoryReferences;
	}

} // RepositoryReferencesImpl
