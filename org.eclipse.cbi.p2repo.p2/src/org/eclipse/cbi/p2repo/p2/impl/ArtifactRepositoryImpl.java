/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 */
package org.eclipse.cbi.p2repo.p2.impl;

import java.io.OutputStream;

import org.eclipse.cbi.p2repo.p2.ArtifactRepository;
import org.eclipse.cbi.p2repo.p2.P2Factory;
import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.p2.util.P2Bridge;
import org.eclipse.cbi.p2repo.util.MonitorUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.equinox.internal.p2.metadata.expression.CompoundIterator;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.IQueryable;
import org.eclipse.equinox.p2.repository.IRunnableWithProgress;
import org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRequest;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Artifact Repository</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.ArtifactRepositoryImpl#getArtifactMap <em>Artifact Map</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArtifactRepositoryImpl extends RepositoryImpl<IArtifactKey> implements ArtifactRepository {
	/**
	 * The cached value of the '{@link #getArtifactMap() <em>Artifact Map</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getArtifactMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<IArtifactKey, EList<IArtifactDescriptor>> artifactMap;

	private static final IArtifactDescriptor[] noDescriptors = new IArtifactDescriptor[0];

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ArtifactRepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void addDescriptor(IArtifactDescriptor descriptor) {
		if (!(descriptor instanceof ArtifactDescriptorImpl))
			descriptor = P2Bridge.importToModel(this, descriptor);
		IArtifactKey key = descriptor.getArtifactKey();
		EMap<IArtifactKey, EList<IArtifactDescriptor>> map = getArtifactMap();
		EList<IArtifactDescriptor> descs = map.get(key);
		if (descs == null) {
			descs = new BasicEList<>();
			descs.add(descriptor);
			map.put(key, descs);
		} else
			descs.add(descriptor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void addDescriptor(IArtifactDescriptor descriptor, IProgressMonitor monitor) {
		addDescriptor(descriptor);
		MonitorUtils.complete(monitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void addDescriptors(IArtifactDescriptor[] descriptors) {
		for (IArtifactDescriptor descriptor : descriptors)
			addDescriptor(descriptor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void addDescriptors(IArtifactDescriptor[] descriptors, IProgressMonitor monitor) {
		addDescriptors(descriptors);
		MonitorUtils.complete(monitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean contains(IArtifactDescriptor descriptor) {
		EList<IArtifactDescriptor> descs = getArtifactMap().get(descriptor.getArtifactKey());
		if (descs == null)
			return false;

		if (!(descriptor instanceof ArtifactDescriptorImpl))
			// Can't trust ArtifactDescriptor equals unless we do this
			descriptor = P2Bridge.importToModel(this, descriptor);

		for (IArtifactDescriptor ad : descs)
			if (ad.equals(descriptor))
				return true;
		return false;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean contains(IArtifactKey key) {
		return getArtifactMap().containsKey(key);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public IArtifactDescriptor createArtifactDescriptor(IArtifactKey key) {
		ArtifactDescriptorImpl desc = (ArtifactDescriptorImpl) P2Factory.eINSTANCE.createArtifactDescriptor();
		if (!(key instanceof ArtifactKeyImpl))
			key = P2Bridge.importToModel(key);
		desc.setArtifactKey(key);
		return desc;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public IArtifactKey createArtifactKey(String classifier, String id, Version version) {
		ArtifactKeyImpl key = (ArtifactKeyImpl) P2Factory.eINSTANCE.createArtifactKey();
		key.setClassifier(classifier);
		key.setId(id);
		key.setVersion(version);
		return key;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public IQueryable<IArtifactDescriptor> descriptorQueryable() {
		return new IQueryable<IArtifactDescriptor>() {
			@Override
			public IQueryResult<IArtifactDescriptor> query(IQuery<IArtifactDescriptor> query,
					IProgressMonitor monitor) {
				return query.perform(new CompoundIterator<IArtifactDescriptor>(getArtifactMap().values().iterator()));
			}
		};
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2Package.ARTIFACT_REPOSITORY__ARTIFACT_MAP:
				if (coreType)
					return getArtifactMap();
				else
					return getArtifactMap().map();
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
			case P2Package.ARTIFACT_REPOSITORY__ARTIFACT_MAP:
				return ((InternalEList<?>) getArtifactMap()).basicRemove(otherEnd, msgs);
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
			case P2Package.ARTIFACT_REPOSITORY__ARTIFACT_MAP:
				return artifactMap != null && !artifactMap.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case P2Package.ARTIFACT_REPOSITORY__ARTIFACT_MAP:
				((EStructuralFeature.Setting) getArtifactMap()).set(newValue);
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
		return P2Package.Literals.ARTIFACT_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.ARTIFACT_REPOSITORY__ARTIFACT_MAP:
				getArtifactMap().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public IStatus executeBatch(IRunnableWithProgress runnable, IProgressMonitor monitor) {
		IStatus result;
		synchronized (this) {
			try {
				runnable.run(monitor);
				result = Status.OK_STATUS;
			} catch (OperationCanceledException e) {
				result = new Status(IStatus.CANCEL, "org.eclipse.cbi.p2repo.p2", e.getMessage(), e);
			} catch (Exception e) {
				result = new Status(IStatus.ERROR, "org.eclipse.cbi.p2repo.p2", e.getMessage(), e);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public IStatus getArtifact(IArtifactDescriptor descriptor, OutputStream destination, IProgressMonitor monitor) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public IArtifactDescriptor[] getArtifactDescriptors(IArtifactKey key) {
		EList<IArtifactDescriptor> result = getArtifactMap().get(key);
		return result == null ? noDescriptors : result.toArray(new IArtifactDescriptor[result.size()]);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<IArtifactKey, EList<IArtifactDescriptor>> getArtifactMap() {
		if (artifactMap == null) {
			artifactMap = new EcoreEMap<>(P2Package.Literals.ARTIFACTS_BY_KEY,
					ArtifactsByKeyImpl.class, this, P2Package.ARTIFACT_REPOSITORY__ARTIFACT_MAP);
		}
		return artifactMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public IStatus getArtifacts(IArtifactRequest[] requests, IProgressMonitor monitor) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public OutputStream getOutputStream(IArtifactDescriptor descriptor) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public IStatus getRawArtifact(IArtifactDescriptor descriptor, OutputStream destination, IProgressMonitor monitor) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public IQueryResult<IArtifactKey> query(IQuery<IArtifactKey> query, IProgressMonitor progress) {
		return query.perform(getArtifactMap().keySet().iterator());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void removeAll() {
		getArtifactMap().clear();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void removeAll(IProgressMonitor monitor) {
		removeAll();
		MonitorUtils.complete(monitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void removeDescriptor(IArtifactDescriptor descriptor) {
		IArtifactKey key = descriptor.getArtifactKey();
		EList<IArtifactDescriptor> descs = getArtifactMap().get(key);
		if (descs == null)
			return;

		if (!(descriptor instanceof ArtifactDescriptorImpl))
			// Can't trust ArtifactDescriptor equals unless we do this
			descriptor = P2Bridge.importToModel(this, descriptor);
		int idx = descs.indexOf(descriptor);
		if (idx < 0)
			return;

		descs.remove(idx);
		if (descs.isEmpty())
			// Remove the key since no descriptor is using it.
			getArtifactMap().removeKey(key);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void removeDescriptor(IArtifactDescriptor descriptor, IProgressMonitor monitor) {
		removeDescriptor(descriptor);
		MonitorUtils.complete(monitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void removeDescriptor(IArtifactKey key) {
		getArtifactMap().removeKey(key);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void removeDescriptor(IArtifactKey key, IProgressMonitor monitor) {
		removeDescriptor(key);
		MonitorUtils.complete(monitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void removeDescriptors(IArtifactDescriptor[] descriptors) {
		for (IArtifactDescriptor descriptor : descriptors)
			removeDescriptor(descriptor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void removeDescriptors(IArtifactDescriptor[] descriptors, IProgressMonitor monitor) {
		removeDescriptors(descriptors);
		MonitorUtils.complete(monitor);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void removeDescriptors(IArtifactKey[] keys) {
		for (IArtifactKey key : keys)
			removeDescriptor(key);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public void removeDescriptors(IArtifactKey[] keys, IProgressMonitor monitor) {
		removeDescriptors(keys);
		MonitorUtils.complete(monitor);
	}
} // ArtifactRepositoryImpl
