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
package org.eclipse.cbi.p2repo.aggregator.impl;

import java.io.File;
import java.util.Collection;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPlugin;
import org.eclipse.cbi.p2repo.aggregator.InfosProvider;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference;
import org.eclipse.cbi.p2repo.aggregator.Status;
import org.eclipse.cbi.p2repo.aggregator.StatusCode;
import org.eclipse.cbi.p2repo.aggregator.StatusProvider;
import org.eclipse.cbi.p2repo.aggregator.p2.util.MetadataRepositoryResourceImpl;
import org.eclipse.cbi.p2repo.aggregator.util.AggregatorResource;
import org.eclipse.cbi.p2repo.aggregator.util.GeneralUtils;
import org.eclipse.cbi.p2repo.cli.HeadlessActivator;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.cbi.p2repo.p2.P2Factory;
import org.eclipse.cbi.p2repo.util.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metadata Repository Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl#isBranchEnabled <em>Branch Enabled</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl#isEnabled <em>Enabled</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl#getInfos <em>Infos</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl#getMetadataRepository <em>Metadata Repository</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl#getNature <em>Nature</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetadataRepositoryReferenceImpl extends MinimalEObjectImpl.Container
		implements MetadataRepositoryReference {
	/**
	 * This looks up a string in the plugin's plugin.properties file.
	 *
	 * @generated NOT
	 */
	private static String getString(String key) {
		return AggregatorPlugin.INSTANCE.getString(key);
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
	 * The default value of the '{@link #isBranchEnabled() <em>Branch Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isBranchEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BRANCH_ENABLED_EDEFAULT = false;

	/**
	 * The default value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ENABLED_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isEnabled() <em>Enabled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEnabled()
	 * @generated
	 * @ordered
	 */
	protected static final int ENABLED_EFLAG = 1 << 0;

	/**
	 * The cached value of the '{@link #getErrors() <em>Errors</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getErrors()
	 * @generated
	 * @ordered
	 */
	protected EList<String> errors;

	/**
	 * The cached value of the '{@link #getWarnings() <em>Warnings</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWarnings()
	 * @generated
	 * @ordered
	 */
	protected EList<String> warnings;

	/**
	 * The cached value of the '{@link #getInfos() <em>Infos</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfos()
	 * @generated
	 * @ordered
	 */
	protected EList<String> infos;

	/**
	 * The cached value of the '{@link #getMetadataRepository() <em>Metadata Repository</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetadataRepository()
	 * @generated
	 * @ordered
	 */
	protected MetadataRepository metadataRepository;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final String LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected String location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getNature() <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNature()
	 * @generated
	 * @ordered
	 */
	protected static final String NATURE_EDEFAULT = "p2";

	/**
	 * The cached value of the '{@link #getNature() <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNature()
	 * @generated
	 * @ordered
	 */
	protected String nature = NATURE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetadataRepositoryReferenceImpl() {
		super();
		eFlags |= ENABLED_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetadataRepository basicGetMetadataRepository() {
		return metadataRepository;
	}

	@Override
	synchronized public void cancelRepositoryLoad() {
		MetadataRepositoryResourceImpl.cancelLoadRepository(getNature(), getResolvedLocation(), getAggregation());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == StatusProvider.class) {
			switch (derivedFeatureID) {
				case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__STATUS:
					return AggregatorPackage.STATUS_PROVIDER__STATUS;
				default:
					return -1;
			}
		}
		if (baseClass == InfosProvider.class) {
			switch (derivedFeatureID) {
				case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ERRORS:
					return AggregatorPackage.INFOS_PROVIDER__ERRORS;
				case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__WARNINGS:
					return AggregatorPackage.INFOS_PROVIDER__WARNINGS;
				case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__INFOS:
					return AggregatorPackage.INFOS_PROVIDER__INFOS;
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
		if (baseClass == StatusProvider.class) {
			switch (baseFeatureID) {
				case AggregatorPackage.STATUS_PROVIDER__STATUS:
					return AggregatorPackage.METADATA_REPOSITORY_REFERENCE__STATUS;
				default:
					return -1;
			}
		}
		if (baseClass == InfosProvider.class) {
			switch (baseFeatureID) {
				case AggregatorPackage.INFOS_PROVIDER__ERRORS:
					return AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ERRORS;
				case AggregatorPackage.INFOS_PROVIDER__WARNINGS:
					return AggregatorPackage.METADATA_REPOSITORY_REFERENCE__WARNINGS;
				case AggregatorPackage.INFOS_PROVIDER__INFOS:
					return AggregatorPackage.METADATA_REPOSITORY_REFERENCE__INFOS;
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
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__BRANCH_ENABLED:
				return isBranchEnabled();
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ENABLED:
				return isEnabled();
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__STATUS:
				return getStatus();
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ERRORS:
				return getErrors();
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__WARNINGS:
				return getWarnings();
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__INFOS:
				return getInfos();
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__METADATA_REPOSITORY:
				if (resolve)
					return getMetadataRepository();
				return basicGetMetadataRepository();
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__LOCATION:
				return getLocation();
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__NATURE:
				return getNature();
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
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__BRANCH_ENABLED:
				return isSetBranchEnabled();
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ENABLED:
				return ((eFlags & ENABLED_EFLAG) != 0) != ENABLED_EDEFAULT;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__STATUS:
				return getStatus() != null;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ERRORS:
				return errors != null && !errors.isEmpty();
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__WARNINGS:
				return warnings != null && !warnings.isEmpty();
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__INFOS:
				return infos != null && !infos.isEmpty();
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__METADATA_REPOSITORY:
				return metadataRepository != null;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__NATURE:
				return NATURE_EDEFAULT == null ? nature != null : !NATURE_EDEFAULT.equals(nature);
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
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ENABLED:
				setEnabled((Boolean) newValue);
				return;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ERRORS:
				getErrors().clear();
				getErrors().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__WARNINGS:
				getWarnings().clear();
				getWarnings().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__INFOS:
				getInfos().clear();
				getInfos().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__METADATA_REPOSITORY:
				setMetadataRepository((MetadataRepository) newValue);
				return;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__LOCATION:
				setLocation((String) newValue);
				return;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__NATURE:
				setNature((String) newValue);
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
		return AggregatorPackage.Literals.METADATA_REPOSITORY_REFERENCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ENABLED:
				setEnabled(ENABLED_EDEFAULT);
				return;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ERRORS:
				getErrors().clear();
				return;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__WARNINGS:
				getWarnings().clear();
				return;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__INFOS:
				getInfos().clear();
				return;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__METADATA_REPOSITORY:
				setMetadataRepository((MetadataRepository) null);
				return;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__NATURE:
				setNature(NATURE_EDEFAULT);
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
	public Aggregation getAggregation() {
		return GeneralUtils.getAggregation(this);
	}

	private AggregatorResource getAggregatorResource() {
		return GeneralUtils.getAggregatorResource(this);
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public EList<String> getErrors() {
		errors = new BasicEList<>();

		String nature = getNature();
		String location = getResolvedLocation();
		if (nature == null || location == null) {
			// Node is incomplete and doesn't appoint a repository just yet.
			errors.add(getString("_UI_ErrorMessage_RepositoryIsNotSet"));
			return errors;
		}

		if (eResource() != null) {
			MetadataRepositoryResourceImpl res = (MetadataRepositoryResourceImpl) MetadataRepositoryResourceImpl
					.getResourceForNatureAndLocation(nature, location, getAggregation(), false);

			if (res == null) {
				errors.add(getString("_UI_ErrorMessage_RepositoryIsNotAvailable"));
				return errors;
			}
		}

		return errors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getInfos() {
		if (infos == null) {
			infos = new EDataTypeUniqueEList<>(String.class, this,
					AggregatorPackage.METADATA_REPOSITORY_REFERENCE__INFOS);
		}
		return infos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLocation() {
		return location;
	}

	/**
	 * Load and resolve if needed
	 *
	 * @generated NOT
	 */
	@Override
	public MetadataRepository getMetadataRepository() {
		return getMetadataRepository(true);
	}

	/**
	 * Prevent MDR from being loaded if the mapping is disabled
	 *
	 * @generated NOT
	 */
	@Override
	public MetadataRepository getMetadataRepository(boolean forceResolve) {
		if (!isBranchEnabled())
			return null;

		if (forceResolve) {
			if (metadataRepository == null)
				metadataRepository = P2Factory.eINSTANCE.createMetadataRepositoryProxy(getNature(),
						getResolvedLocation());

			return getMetadataRepositoryGen();
		}

		return metadataRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetadataRepository getMetadataRepositoryGen() {
		if (metadataRepository != null && ((EObject) metadataRepository).eIsProxy()) {
			InternalEObject oldMetadataRepository = (InternalEObject) metadataRepository;
			metadataRepository = (MetadataRepository) eResolveProxy(oldMetadataRepository);
			if (metadataRepository != oldMetadataRepository) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AggregatorPackage.METADATA_REPOSITORY_REFERENCE__METADATA_REPOSITORY, oldMetadataRepository,
							metadataRepository));
			}
		}
		return metadataRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNature() {
		return nature;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public String getResolvedLocation() {
		String location = StringUtils.trimmedOrNull(getLocation());
		if (location == null)
			return null;

		URI uri;
		File locationFile = new File(location);

		// if the location happens to specify an absolute pathname (or a pathname starting at the root of the current drive on Windows), then
		// use it as such
		if (locationFile.isAbsolute() || location.startsWith(File.separator) || location.startsWith("/")) {
			uri = URI.createURI(locationFile.toURI().toString());
		} else {
			uri = URI.createURI(location, true);
			if (uri.isRelative()) { // try to resolve the location URI if not absolute
				URI base = ((EObject) getAggregation()).eResource().getURI();
				if (base != null)
					uri = uri.resolve(base);
			}
		}

		// strip any trailing empty segments if there is at least one non-empty segment preceding them
		String[] uriSegments = uri.segments();
		for (int i = uriSegments.length; i > 0;) {
			String segment = uriSegments[--i];
			if (segment.length() != 0) {
				uri = uri.trimSegments(uriSegments.length - i - 1);
				break;
			}
		}

		return uri.toString();
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	synchronized public Status getStatus() {
		if (isBranchEnabled()) {
			// status is ok only if MDR is not null and is resolvable
			if (getMetadataRepository(false) != null && !((EObject) getMetadataRepository(false)).eIsProxy())
				return AggregatorFactory.eINSTANCE.createStatus(StatusCode.OK);

			String nature = getNature();
			String location = getResolvedLocation();
			if (nature == null || location == null)
				// Node is incomplete and doesn't appoint a repository just yet.
				return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN,
						getString("_UI_ErrorMessage_RepositoryIsNotSet"));

			MetadataRepositoryResourceImpl res;
			try {
				res = (MetadataRepositoryResourceImpl) MetadataRepositoryResourceImpl
						.getResourceForNatureAndLocation(nature, location, getAggregation(), false);
			} catch (Exception e) {
				// cannot get Aggregator top node
				res = null;
			}

			if (res != null)
				return res.getStatus();
		}

		return AggregatorFactory.eINSTANCE.createStatus(StatusCode.OK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getWarnings() {
		if (warnings == null) {
			warnings = new EDataTypeUniqueEList<>(String.class, this,
					AggregatorPackage.METADATA_REPOSITORY_REFERENCE__WARNINGS);
		}
		return warnings;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isBranchEnabled() {
		return GeneralUtils.isBranchEnabled(this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isEnabled() {
		return (eFlags & ENABLED_EFLAG) != 0;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isSetBranchEnabled() {
		return true;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public void onRepositoryLoad() {

		if (this instanceof MappedRepository) {
			if (eNotificationRequired())
				eNotify(new ENotificationImpl(this, Notification.SET,
						AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS, null, null));
		}

		if (!HeadlessActivator.getInstance().isHeadless())
			getAggregatorResource().analyzeResource();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEnabled(boolean newEnabled) {
		boolean oldEnabled = (eFlags & ENABLED_EFLAG) != 0;
		if (newEnabled)
			eFlags |= ENABLED_EFLAG;
		else
			eFlags &= ~ENABLED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ENABLED, oldEnabled, newEnabled));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLocation(String newLocation) {
		String oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.METADATA_REPOSITORY_REFERENCE__LOCATION, oldLocation, location));
	}

	@Override
	synchronized public void setMetadataRepository(MetadataRepository newMetadataRepository) {
		if (newMetadataRepository != metadataRepository)
			setMetadataRepositoryGen(newMetadataRepository);
	}

	/**
	 *
	 * @generated NOT
	 */
	public void setMetadataRepositoryGen(MetadataRepository newMetadataRepository) {
		MetadataRepository oldMetadataRepository = metadataRepository;
		metadataRepository = newMetadataRepository;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.METADATA_REPOSITORY_REFERENCE__METADATA_REPOSITORY, oldMetadataRepository,
					metadataRepository));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNature(String newNature) {
		String oldNature = nature;
		nature = newNature;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.METADATA_REPOSITORY_REFERENCE__NATURE, oldNature, nature));
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	synchronized public void startRepositoryLoad(final boolean forceReload) {
		if (StringUtils.trimmedOrNull(getLocation()) == null) {
			setMetadataRepository(null);
			onRepositoryLoad();
			return;
		}

		String nature = getNature();
		String resolvedLocation = getResolvedLocation();
		Aggregation aggregation = getAggregation();
		Resource res = MetadataRepositoryResourceImpl.getResourceForNatureAndLocation(nature, resolvedLocation,
				aggregation);
		if (res != null)
			((MetadataRepositoryResourceImpl) res).startAsynchronousLoad(forceReload);
		else {
			onRepositoryLoad();
			return;
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (enabled: ");
		result.append((eFlags & ENABLED_EFLAG) != 0);
		result.append(", errors: ");
		result.append(errors);
		result.append(", warnings: ");
		result.append(warnings);
		result.append(", infos: ");
		result.append(infos);
		result.append(", location: ");
		result.append(location);
		result.append(", nature: ");
		result.append(nature);
		result.append(')');
		return result.toString();
	}
} // MetadataRepositoryReferenceImpl
