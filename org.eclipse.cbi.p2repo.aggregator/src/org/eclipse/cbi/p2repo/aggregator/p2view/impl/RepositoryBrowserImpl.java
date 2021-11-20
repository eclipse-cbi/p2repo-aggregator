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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.ChildrenProvider;
import org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference;
import org.eclipse.cbi.p2repo.aggregator.Status;
import org.eclipse.cbi.p2repo.aggregator.StatusCode;
import org.eclipse.cbi.p2repo.aggregator.p2.util.MetadataRepositoryResourceImpl;
import org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryBrowser;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EContentAdapter;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Repository Browser</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.RepositoryBrowserImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.RepositoryBrowserImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.RepositoryBrowserImpl#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.RepositoryBrowserImpl#isLoading <em>Loading</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RepositoryBrowserImpl extends MinimalEObjectImpl.Container implements RepositoryBrowser {
	class NotifyDispatcher extends EContentAdapter {
		@Override
		public void notifyChanged(Notification notification) {
			Object nf = notification.getNotifier();

			// We listen to when resources change
			boolean loading = nf instanceof ResourceSet
					&& notification.getFeatureID(ResourceSet.class) == ResourceSet.RESOURCE_SET__RESOURCES;

			if (!loading)
				// We also listen to when a reference to a repository changes its reference.
				loading = nf instanceof MetadataRepositoryReference && notification.getFeatureID(
						MetadataRepositoryReference.class) == AggregatorPackage.METADATA_REPOSITORY_REFERENCE__METADATA_REPOSITORY;

			if (loading) {
				eNotify(new ENotificationImpl(RepositoryBrowserImpl.this, Notification.SET,
						P2viewPackage.REPOSITORY_BROWSER__LOADING, null, null));
			}
		}
	}

	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The default value of the '{@link #isLoading() <em>Loading</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoading()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOADING_EDEFAULT = false;

	private final Aggregation aggregation;

	private final NotifyDispatcher notifyDispatcher = new NotifyDispatcher();

	/**
	 *
	 *
	 * @generated NOT
	 */
	protected RepositoryBrowserImpl() {
		throw new UnsupportedOperationException();
	}

	protected RepositoryBrowserImpl(Aggregation aggregation) {
		super();
		this.aggregation = aggregation;
		((EObject) aggregation).eResource().getResourceSet().eAdapters().add(notifyDispatcher);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == ChildrenProvider.class) {
			switch (derivedFeatureID) {
				case P2viewPackage.REPOSITORY_BROWSER__CHILDREN:
					return AggregatorPackage.CHILDREN_PROVIDER__CHILDREN;
				default:
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == ChildrenProvider.class) {
			switch (baseFeatureID) {
				case AggregatorPackage.CHILDREN_PROVIDER__CHILDREN:
					return P2viewPackage.REPOSITORY_BROWSER__CHILDREN;
				default:
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2viewPackage.REPOSITORY_BROWSER__STATUS:
				return getStatus();
			case P2viewPackage.REPOSITORY_BROWSER__CHILDREN:
				return getChildren();
			case P2viewPackage.REPOSITORY_BROWSER__REPOSITORIES:
				return getRepositories();
			case P2viewPackage.REPOSITORY_BROWSER__LOADING:
				return isLoading();
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
			case P2viewPackage.REPOSITORY_BROWSER__STATUS:
				return getStatus() != null;
			case P2viewPackage.REPOSITORY_BROWSER__CHILDREN:
				return !getChildren().isEmpty();
			case P2viewPackage.REPOSITORY_BROWSER__REPOSITORIES:
				return !getRepositories().isEmpty();
			case P2viewPackage.REPOSITORY_BROWSER__LOADING:
				return isSetLoading();
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
			case P2viewPackage.REPOSITORY_BROWSER__REPOSITORIES:
				getRepositories().clear();
				getRepositories().addAll((Collection<? extends MetadataRepositoryStructuredView>) newValue);
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
		return P2viewPackage.Literals.REPOSITORY_BROWSER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2viewPackage.REPOSITORY_BROWSER__REPOSITORIES:
				getRepositories().clear();
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
	public EList<MetadataRepositoryStructuredView> getChildren() {
		return getRepositories();
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public EList<MetadataRepositoryStructuredView> getRepositories() {
		List<Resource> resources = getResources();
		EList<MetadataRepositoryStructuredView> result = new BasicEList<>(resources.size() - 1);
		for (Resource resource : resources) {
			if (resource instanceof MetadataRepositoryResourceImpl) {
				EList<EObject> contents = resource.getContents();
				if (contents.size() == 1) {
					EObject view = contents.get(0);
					if (view instanceof MetadataRepositoryStructuredView)
						result.add((MetadataRepositoryStructuredView) view);
				}
			}
		}
		return result;
	}

	private List<Resource> getResources() {
		List<Resource> result = null;
		Resource aggrResource = ((EObject) aggregation).eResource();
		if (aggrResource != null) {
			ResourceSet rs = aggrResource.getResourceSet();
			if (rs != null)
				// We need a clone here to avoid ConcurrentModificationException
				// when iterating
				result = new ArrayList<>(rs.getResources());
		}
		if (result == null)
			result = Collections.emptyList();
		return result;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public Status getStatus() {
		Status result = null;
		for (Resource resource : getResources()) {
			if (!(resource instanceof MetadataRepositoryResourceImpl))
				continue;
			Status childStatus = ((MetadataRepositoryResourceImpl) resource).getStatus();
			switch (childStatus.getCode()) {
				case BROKEN:
					return childStatus;
				case WAITING:
					result = childStatus;
					break;
				default:
			}
		}
		if (result == null)
			result = AggregatorFactory.eINSTANCE.createStatus(StatusCode.OK);
		return result;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isLoading() {
		boolean loading = false;
		for (Resource resource : getResources()) {
			if (resource instanceof MetadataRepositoryResourceImpl
					&& ((MetadataRepositoryResourceImpl) resource).isLoading()) {
				loading = true;
				break;
			}
		}
		return loading;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isSetLoading() {
		return true;
	}
} // RepositoryBrowserImpl
