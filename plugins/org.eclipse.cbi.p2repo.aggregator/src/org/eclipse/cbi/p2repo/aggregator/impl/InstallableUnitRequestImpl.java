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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPlugin;
import org.eclipse.cbi.p2repo.aggregator.AvailableFrom;
import org.eclipse.cbi.p2repo.aggregator.AvailableVersion;
import org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.DescriptionProvider;
import org.eclipse.cbi.p2repo.aggregator.InfosProvider;
import org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.Status;
import org.eclipse.cbi.p2repo.aggregator.StatusCode;
import org.eclipse.cbi.p2repo.aggregator.ValidationSet;
import org.eclipse.cbi.p2repo.aggregator.VersionMatch;
import org.eclipse.cbi.p2repo.aggregator.util.GeneralUtils;
import org.eclipse.cbi.p2repo.p2.InstallableUnit;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.cbi.p2repo.p2.P2Factory;
import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.util.StringUtils;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.query.QueryUtil;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Installable Unit Reference</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.InstallableUnitRequestImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.InstallableUnitRequestImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.InstallableUnitRequestImpl#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.InstallableUnitRequestImpl#getInfos <em>Infos</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.InstallableUnitRequestImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.InstallableUnitRequestImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.InstallableUnitRequestImpl#getVersionRange <em>Version Range</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.InstallableUnitRequestImpl#getAvailableVersionsHeader <em>Available Versions Header</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.InstallableUnitRequestImpl#getAvailableVersions <em>Available Versions</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class InstallableUnitRequestImpl extends MinimalEObjectImpl.Container
		implements InstallableUnitRequest {
	/**
	 * This looks up a string in the plugin's plugin.properties file.
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
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersionRange() <em>Version Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionRange()
	 * @generated
	 * @ordered
	 */
	protected static final VersionRange VERSION_RANGE_EDEFAULT = (VersionRange) P2Factory.eINSTANCE
			.createFromString(P2Package.eINSTANCE.getVersionRange(), "0.0.0");

	/**
	 * The cached value of the '{@link #getVersionRange() <em>Version Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionRange()
	 * @generated
	 * @ordered
	 */
	protected VersionRange versionRange = VERSION_RANGE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAvailableVersionsHeader() <em>Available Versions Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableVersionsHeader()
	 * @generated
	 * @ordered
	 */
	protected AvailableVersionsHeader availableVersionsHeader;

	/**
	 * The cached value of the '{@link #getAvailableVersions() <em>Available Versions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableVersions()
	 * @generated
	 * @ordered
	 */
	protected EList<AvailableVersion> availableVersions;

	/**
	 *
	 * @generated NOT
	 */
	protected InstallableUnitRequestImpl() {
		super();
		setAvailableVersionsHeader(AggregatorFactory.eINSTANCE.createAvailableVersionsHeader());
	}

	private void addAvailableVersions(MappedRepository mr, IQuery<IInstallableUnit> query, AvailableFrom source,
			List<AvailableVersion> receiver) {
		if (mr == null || ((EObject) mr).eIsProxy())
			return;

		MetadataRepository mdr = mr.getMetadataRepository();
		if (mdr == null || ((EObject) mdr).eIsProxy())
			return;

		IQueryResult<IInstallableUnit> ius = mdr.query(query, null);
		for (IInstallableUnit iu : ius.toUnmodifiableSet()) {
			AvailableVersion av = AggregatorFactory.eINSTANCE.createAvailableVersion();

			if (versionRange == null || versionRange.isIncluded(iu.getVersion()))
				av.setVersionMatch(VersionMatch.MATCHES);
			else {
				int result = versionRange.getMinimum().compareTo(iu.getVersion());

				if (result >= 0)
					av.setVersionMatch(VersionMatch.BELOW);
				else
					av.setVersionMatch(VersionMatch.ABOVE);
			}
			av.setVersion(iu.getVersion());
			av.setFilter(iu.getFilter());
			av.setAvailableFrom(source);
			receiver.add(av);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAvailableVersionsHeader(AvailableVersionsHeader newAvailableVersionsHeader,
			NotificationChain msgs) {
		AvailableVersionsHeader oldAvailableVersionsHeader = availableVersionsHeader;
		availableVersionsHeader = newAvailableVersionsHeader;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER, oldAvailableVersionsHeader,
					newAvailableVersionsHeader);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == InfosProvider.class) {
			switch (derivedFeatureID) {
				case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__ERRORS:
					return AggregatorPackage.INFOS_PROVIDER__ERRORS;
				case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__WARNINGS:
					return AggregatorPackage.INFOS_PROVIDER__WARNINGS;
				case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__INFOS:
					return AggregatorPackage.INFOS_PROVIDER__INFOS;
				default:
					return -1;
			}
		}
		if (baseClass == DescriptionProvider.class) {
			switch (derivedFeatureID) {
				case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__DESCRIPTION:
					return AggregatorPackage.DESCRIPTION_PROVIDER__DESCRIPTION;
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
		if (baseClass == InfosProvider.class) {
			switch (baseFeatureID) {
				case AggregatorPackage.INFOS_PROVIDER__ERRORS:
					return AggregatorPackage.INSTALLABLE_UNIT_REQUEST__ERRORS;
				case AggregatorPackage.INFOS_PROVIDER__WARNINGS:
					return AggregatorPackage.INSTALLABLE_UNIT_REQUEST__WARNINGS;
				case AggregatorPackage.INFOS_PROVIDER__INFOS:
					return AggregatorPackage.INSTALLABLE_UNIT_REQUEST__INFOS;
				default:
					return -1;
			}
		}
		if (baseClass == DescriptionProvider.class) {
			switch (baseFeatureID) {
				case AggregatorPackage.DESCRIPTION_PROVIDER__DESCRIPTION:
					return AggregatorPackage.INSTALLABLE_UNIT_REQUEST__DESCRIPTION;
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
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__STATUS:
				return getStatus();
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__ERRORS:
				return getErrors();
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__WARNINGS:
				return getWarnings();
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__INFOS:
				return getInfos();
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__DESCRIPTION:
				return getDescription();
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__NAME:
				return getName();
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__VERSION_RANGE:
				return getVersionRange();
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER:
				return getAvailableVersionsHeader();
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS:
				return getAvailableVersions();
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
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER:
				if (availableVersionsHeader != null)
					msgs = ((InternalEObject) availableVersionsHeader).eInverseRemove(this,
							EOPPOSITE_FEATURE_BASE
									- AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER,
							null, msgs);
				return basicSetAvailableVersionsHeader((AvailableVersionsHeader) otherEnd, msgs);
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
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER:
				return basicSetAvailableVersionsHeader(null, msgs);
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS:
				return ((InternalEList<?>) getAvailableVersions()).basicRemove(otherEnd, msgs);
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
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__STATUS:
				return getStatus() != null;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__ERRORS:
				return errors != null && !errors.isEmpty();
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__WARNINGS:
				return warnings != null && !warnings.isEmpty();
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__INFOS:
				return infos != null && !infos.isEmpty();
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__VERSION_RANGE:
				return VERSION_RANGE_EDEFAULT == null ? versionRange != null
						: !VERSION_RANGE_EDEFAULT.equals(versionRange);
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER:
				return availableVersionsHeader != null;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS:
				return availableVersions != null && !availableVersions.isEmpty();
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
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__ERRORS:
				getErrors().clear();
				getErrors().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__WARNINGS:
				getWarnings().clear();
				getWarnings().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__INFOS:
				getInfos().clear();
				getInfos().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__NAME:
				setName((String) newValue);
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__VERSION_RANGE:
				setVersionRange((VersionRange) newValue);
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER:
				setAvailableVersionsHeader((AvailableVersionsHeader) newValue);
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS:
				getAvailableVersions().clear();
				getAvailableVersions().addAll((Collection<? extends AvailableVersion>) newValue);
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
		return AggregatorPackage.Literals.INSTALLABLE_UNIT_REQUEST;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__ERRORS:
				getErrors().clear();
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__WARNINGS:
				getWarnings().clear();
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__INFOS:
				getInfos().clear();
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__NAME:
				setName(NAME_EDEFAULT);
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__VERSION_RANGE:
				setVersionRange(VERSION_RANGE_EDEFAULT);
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER:
				setAvailableVersionsHeader((AvailableVersionsHeader) null);
				return;
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS:
				getAvailableVersions().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 *
	 * @generated NOT
	 */
	@Override
	public EList<AvailableVersion> getAvailableVersions() {
		if (availableVersions == null) {
			resolveAvailableVersions(false);
		}
		return availableVersions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AvailableVersionsHeader getAvailableVersionsHeader() {
		return availableVersionsHeader;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 *
	 * @generated NOT
	 */
	@Override
	public EList<String> getErrors() {
		errors = new BasicEList<>();

		if (!isMappedRepositoryBroken()) {
			if (resolveAsSingleton() == null)
				errors.add(getString("_UI_ErrorMessage_NoInstallableUnitIsAvailable"));
		}

		return errors;
	}

	/**
	 *
	 * @generated NOT
	 */
	@Override
	public EList<String> getInfos() {
		infos = new BasicEList<>();

		// TODO Informing about new versions is deprecated for now

		return infos;
	}

	public MappedRepository getMappedRepository() {
		for (EObject container = eContainer(); container != null; container = container.eContainer())
			if (container instanceof MappedRepository)
				return (MappedRepository) container;

		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 *
	 * @generated NOT
	 */
	@Override
	synchronized public Status getStatus() {
		if (eIsProxy()) {
			return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN, AggregatorPlugin.INSTANCE
					.getString("_UI_ErrorMessage_UnresolvedProxy", new Object[] { eProxyURI() }));
		}
		if (!isBranchDisabledOrMappedRepositoryBroken()) {
			if (resolveAsSingleton() == null)
				return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN,
						getString("_UI_ErrorMessage_NoInstallableUnitIsAvailable"));
		}

		return AggregatorFactory.eINSTANCE.createStatus(StatusCode.OK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VersionRange getVersionRange() {
		return versionRange;
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
					AggregatorPackage.INSTALLABLE_UNIT_REQUEST__WARNINGS);
		}
		return warnings;
	}

	@Override
	public boolean isBranchDisabledOrMappedRepositoryBroken() {
		return !isBranchEnabled() || isMappedRepositoryBroken();
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
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isMappedRepositoryBroken() {
		MappedRepository repo = (MappedRepository) eContainer();
		return repo == null || repo.getMetadataRepository(false) == null
				|| ((EObject) repo.getMetadataRepository()).eIsProxy();
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public IInstallableUnit resolveAsSingleton() {
		return resolveAsSingleton(false);
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public IInstallableUnit resolveAsSingleton(boolean forceResolve) {
		String id = getName();

		if (id == null)
			return null;

		IQuery<IInstallableUnit> query = QueryUtil.createIUQuery(id, versionRange);

		MetadataRepository mdr = ((MappedRepository) eContainer()).getMetadataRepository(forceResolve);
		if (mdr == null || ((EObject) mdr).eIsProxy())
			return null;

		IQueryResult<IInstallableUnit> ius = mdr.query(QueryUtil.createLatestQuery(query), new NullProgressMonitor());
		if (!ius.isEmpty()) {
			InstallableUnit iu = (InstallableUnit) ius.toArray(IInstallableUnit.class)[0];
			return iu;
		}
		return null;
	}

	@Override
	synchronized public void resolveAvailableVersions(boolean updateOnly) {

		if (availableVersions == null) {
			if (updateOnly)
				return;
			availableVersions = new EObjectContainmentEList<>(AvailableVersion.class, this,
					AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS);
		} else
			availableVersions.clear();

		if (StringUtils.trimmedOrNull(name) == null)
			return;

		List<AvailableVersion> avList = new ArrayList<>();
		IQuery<IInstallableUnit> query = QueryUtil.createIUQuery(name);
		MappedRepository mr = getMappedRepository();
		if (mr == null) {
			return;
		}

		addAvailableVersions(mr, query, AvailableFrom.REPOSITORY, avList);
		Contribution contrib = (Contribution) ((EObject) mr).eContainer();
		if (contrib == null) {
			// Happens during drag-n-drop
			return;
		}

		for (MappedRepository omr : contrib.getRepositories(true)) {
			if (omr != mr)
				addAvailableVersions(omr, query, AvailableFrom.CONTRIBUTION, avList);
		}

		ValidationSet vs = (ValidationSet) ((EObject) contrib).eContainer();
		if (vs == null) {
			// Happens during drag-n-drop
			return;
		}

		for (Contribution oc : vs.getAllContributions()) {
			if (oc != contrib) {
				for (MappedRepository omr : oc.getRepositories(true)) {
					addAvailableVersions(omr, query, AvailableFrom.VALIDATION_SET, avList);
				}
			}
		}

		Aggregation aggr = (Aggregation) ((EObject) vs).eContainer();
		if (aggr == null) {
			// Happens during drag-n-drop
			return;
		}

		for (ValidationSet vr : aggr.getValidationSets(true)) {
			if (vr != vs) {
				for (Contribution oc : vr.getDeclaredContributions()) {
					for (MappedRepository omr : oc.getRepositories(true)) {
						addAvailableVersions(omr, query, AvailableFrom.AGGREGATION, avList);
					}
				}
			}
		}

		if (avList.size() == 0) {
			AvailableVersion av = AggregatorFactory.eINSTANCE.createAvailableVersion();
			av.setVersionMatch(VersionMatch.MATCHES);
			availableVersions.add(av);
		} else {
			Collections.sort(avList);
			availableVersions.addAll(avList);
		}
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public void setAvailableVersionsHeader(AvailableVersionsHeader newAvailableVersionsHeader) {
		if (newAvailableVersionsHeader != availableVersionsHeader) {
			NotificationChain msgs = null;
			if (availableVersionsHeader != null)
				msgs = ((InternalEObject) availableVersionsHeader).eInverseRemove(this,
						AggregatorPackage.AVAILABLE_VERSIONS_HEADER__INSTALLABLE_UNIT_REQUEST,
						AvailableVersionsHeader.class, msgs);
			if (newAvailableVersionsHeader != null)
				msgs = ((InternalEObject) newAvailableVersionsHeader).eInverseAdd(this,
						AggregatorPackage.AVAILABLE_VERSIONS_HEADER__INSTALLABLE_UNIT_REQUEST,
						AvailableVersionsHeader.class, msgs);
			msgs = basicSetAvailableVersionsHeader(newAvailableVersionsHeader, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.INSTALLABLE_UNIT_REQUEST__AVAILABLE_VERSIONS_HEADER, newAvailableVersionsHeader,
					newAvailableVersionsHeader));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.INSTALLABLE_UNIT_REQUEST__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.INSTALLABLE_UNIT_REQUEST__NAME,
					oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersionRange(VersionRange newVersionRange) {
		VersionRange oldVersionRange = versionRange;
		versionRange = newVersionRange;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					AggregatorPackage.INSTALLABLE_UNIT_REQUEST__VERSION_RANGE, oldVersionRange, versionRange));
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
		result.append(" (errors: ");
		result.append(errors);
		result.append(", warnings: ");
		result.append(warnings);
		result.append(", infos: ");
		result.append(infos);
		result.append(", description: ");
		result.append(description);
		result.append(", name: ");
		result.append(name);
		result.append(", versionRange: ");
		result.append(versionRange);
		result.append(')');
		return result.toString();
	}

} // InstallableUnitReferenceImpl
