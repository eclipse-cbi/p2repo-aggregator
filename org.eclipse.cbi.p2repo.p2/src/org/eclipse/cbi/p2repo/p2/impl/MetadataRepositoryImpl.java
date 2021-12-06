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
package org.eclipse.cbi.p2repo.p2.impl;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.cbi.p2repo.p2.P2Factory;
import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.p2.util.P2Bridge;
import org.eclipse.cbi.p2repo.util.ExceptionUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.equinox.internal.p2.metadata.repository.CompositeMetadataRepository;
import org.eclipse.equinox.internal.p2.metadata.repository.LocalMetadataRepository;
import org.eclipse.equinox.p2.core.IPool;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.repository.IRepositoryReference;
import org.eclipse.equinox.p2.repository.IRunnableWithProgress;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metadata Repository</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.MetadataRepositoryImpl#getInstallableUnits <em>Installable Units</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.MetadataRepositoryImpl#getReferences <em>References</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetadataRepositoryImpl extends RepositoryImpl<IInstallableUnit> implements MetadataRepository {
	private static final Method LocalMetadataRepository_createRepositoriesSnapshot;

	static {
		try {
			LocalMetadataRepository_createRepositoriesSnapshot = LocalMetadataRepository.class
					.getDeclaredMethod("createRepositoriesSnapshot");
			LocalMetadataRepository_createRepositoriesSnapshot.setAccessible(true);
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e);
		}
	}

	private static final Pattern proxyFragmentPattern = Pattern.compile("^[^:]+:(.*)#\\/\\/.*$");

	/**
	 * The cached value of the '{@link #getInstallableUnits() <em>Installable Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallableUnits()
	 * @generated
	 * @ordered
	 */
	protected EList<IInstallableUnit> installableUnits;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<IRepositoryReference> references;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetadataRepositoryImpl() {
		super();
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public void addInstallableUnits(Collection<IInstallableUnit> installableUnits) {
		EList<IInstallableUnit> iuList = getInstallableUnits();
		for (IInstallableUnit iu : installableUnits)
			iuList.add(P2Bridge.importToModel(iu));
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	private void addReference(URI location, String nickname, int type, int options) {
		RepositoryReferenceImpl ref = (RepositoryReferenceImpl) P2Factory.eINSTANCE.createRepositoryReference();
		ref.setLocation(location);
		ref.setNickname(nickname);
		ref.setType(type);
		ref.setOptions(options);
		getReferences().add(ref);
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public void addReferences(Collection<? extends IRepositoryReference> references) {
		for (IRepositoryReference reference : references)
			addReference(reference.getLocation(), reference.getNickname(), reference.getType(), reference.getOptions());
	}

	public void addRepositoryReferences(IMetadataRepositoryManager mdrMgr, IMetadataRepository mdr)
			throws CoreException, OperationCanceledException {
		if (mdr instanceof LocalMetadataRepository) {
			try {
				@SuppressWarnings("unchecked")
				List<org.eclipse.equinox.p2.repository.spi.RepositoryReference> refs = (List<org.eclipse.equinox.p2.repository.spi.RepositoryReference>) LocalMetadataRepository_createRepositoriesSnapshot
						.invoke(mdr);
				for (org.eclipse.equinox.p2.repository.spi.RepositoryReference ref : refs)
					addReference(ref.getLocation(), ref.getNickname(), ref.getType(), ref.getOptions());
			} catch (Exception e) {
				throw ExceptionUtils.wrap(e);
			}
		} else if (mdr instanceof CompositeMetadataRepository) {
			List<URI> children = ((CompositeMetadataRepository) mdr).getChildren();
			for (URI child : children)
				addRepositoryReferences(mdrMgr, mdrMgr.loadRepository(child, null));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void compress(IPool<IInstallableUnit> iuPool) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2Package.METADATA_REPOSITORY__INSTALLABLE_UNITS:
				return getInstallableUnits();
			case P2Package.METADATA_REPOSITORY__REFERENCES:
				return getReferences();
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
			case P2Package.METADATA_REPOSITORY__INSTALLABLE_UNITS:
				return ((InternalEList<?>) getInstallableUnits()).basicRemove(otherEnd, msgs);
			case P2Package.METADATA_REPOSITORY__REFERENCES:
				return ((InternalEList<?>) getReferences()).basicRemove(otherEnd, msgs);
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
			case P2Package.METADATA_REPOSITORY__INSTALLABLE_UNITS:
				return installableUnits != null && !installableUnits.isEmpty();
			case P2Package.METADATA_REPOSITORY__REFERENCES:
				return references != null && !references.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof MetadataRepositoryImpl))
			return false;
		return getSafeLocation().equals(((MetadataRepositoryImpl) obj).getSafeLocation());
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
			case P2Package.METADATA_REPOSITORY__INSTALLABLE_UNITS:
				getInstallableUnits().clear();
				getInstallableUnits().addAll((Collection<? extends IInstallableUnit>) newValue);
				return;
			case P2Package.METADATA_REPOSITORY__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends IRepositoryReference>) newValue);
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
		return P2Package.Literals.METADATA_REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.METADATA_REPOSITORY__INSTALLABLE_UNITS:
				getInstallableUnits().clear();
				return;
			case P2Package.METADATA_REPOSITORY__REFERENCES:
				getReferences().clear();
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
	public IStatus executeBatch(IRunnableWithProgress runnable, IProgressMonitor monitor) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IInstallableUnit> getInstallableUnits() {
		if (installableUnits == null) {
			installableUnits = new EObjectContainmentEList.Resolving<>(IInstallableUnit.class, this,
					P2Package.METADATA_REPOSITORY__INSTALLABLE_UNITS);
		}
		return installableUnits;
	}

	public URI getLocationFromProxy() {
		Matcher m = proxyFragmentPattern.matcher(eProxyURI().toString());
		try {
			return m.matches() ? new URI(m.group(1)) : null;
		} catch (URISyntaxException e) {
			return null;
		}
	}

	public String getNameFromProxy() {
		// no way to retrieve name from location
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IRepositoryReference> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList.Resolving<>(IRepositoryReference.class, this,
					P2Package.METADATA_REPOSITORY__REFERENCES);
		}
		return references;
	}

	public URI getSafeLocation() {
		return location != null ? location : getLocationFromProxy();
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public IQueryResult<IInstallableUnit> query(IQuery<IInstallableUnit> query, IProgressMonitor progress) {
		return query.perform(getInstallableUnits().iterator());
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public void removeAll() {
		getInstallableUnits().clear();
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public boolean removeInstallableUnits(Collection<IInstallableUnit> installableUnits) {
		if (installableUnits == null)
			return false;

		List<IInstallableUnit> units = getInstallableUnits();

		return units.removeAll(installableUnits);
	}
} // MetadataRepositoryImpl
