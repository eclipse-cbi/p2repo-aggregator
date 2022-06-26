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

import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.AvailableFrom;
import org.eclipse.cbi.p2repo.aggregator.AvailableVersion;
import org.eclipse.cbi.p2repo.aggregator.VersionMatch;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Available Version</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionImpl#getVersionMatch <em>Version Match</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AvailableVersionImpl#getAvailableFrom <em>Available From</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AvailableVersionImpl extends MinimalEObjectImpl.Container implements AvailableVersion {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The default value of the '{@link #getVersionMatch() <em>Version Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionMatch()
	 * @generated
	 * @ordered
	 */
	protected static final VersionMatch VERSION_MATCH_EDEFAULT = VersionMatch.BELOW;

	/**
	 * The offset of the flags representing the value of the '{@link #getVersionMatch() <em>Version Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int VERSION_MATCH_EFLAG_OFFSET = 0;

	/**
	 * The flags representing the default value of the '{@link #getVersionMatch() <em>Version Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int VERSION_MATCH_EFLAG_DEFAULT = VERSION_MATCH_EDEFAULT
			.ordinal() << VERSION_MATCH_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link VersionMatch Version Match}'
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	private static final VersionMatch[] VERSION_MATCH_EFLAG_VALUES = VersionMatch.values();

	/**
	 * The flags representing the value of the '{@link #getVersionMatch() <em>Version Match</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionMatch()
	 * @generated
	 * @ordered
	 */
	protected static final int VERSION_MATCH_EFLAG = 0x3 << VERSION_MATCH_EFLAG_OFFSET;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final Version VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected Version version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFilter() <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected IMatchExpression<IInstallableUnit> filter;

	/**
	 * The default value of the '{@link #getAvailableFrom() <em>Available From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableFrom()
	 * @generated
	 * @ordered
	 */
	protected static final AvailableFrom AVAILABLE_FROM_EDEFAULT = AvailableFrom.REPOSITORY;

	/**
	 * The offset of the flags representing the value of the '{@link #getAvailableFrom() <em>Available From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int AVAILABLE_FROM_EFLAG_OFFSET = 2;

	/**
	 * The flags representing the default value of the '{@link #getAvailableFrom() <em>Available From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int AVAILABLE_FROM_EFLAG_DEFAULT = AVAILABLE_FROM_EDEFAULT
			.ordinal() << AVAILABLE_FROM_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link AvailableFrom Available From}'
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	private static final AvailableFrom[] AVAILABLE_FROM_EFLAG_VALUES = AvailableFrom.values();

	/**
	 * The flags representing the value of the '{@link #getAvailableFrom() <em>Available From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailableFrom()
	 * @generated
	 * @ordered
	 */
	protected static final int AVAILABLE_FROM_EFLAG = 0x3 << AVAILABLE_FROM_EFLAG_OFFSET;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AvailableVersionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 */
	@Override
	public int compareTo(AvailableVersion o) {
		if (version == o.getVersion())
			return 0;
		if (version == null)
			return 1;
		if (o.getVersion() == null)
			return -1;
		return o.getVersion().compareTo(version);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AggregatorPackage.AVAILABLE_VERSION__VERSION_MATCH:
				return getVersionMatch();
			case AggregatorPackage.AVAILABLE_VERSION__VERSION:
				return getVersion();
			case AggregatorPackage.AVAILABLE_VERSION__FILTER:
				return getFilter();
			case AggregatorPackage.AVAILABLE_VERSION__AVAILABLE_FROM:
				return getAvailableFrom();
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
			case AggregatorPackage.AVAILABLE_VERSION__VERSION_MATCH:
				return (eFlags & VERSION_MATCH_EFLAG) != VERSION_MATCH_EFLAG_DEFAULT;
			case AggregatorPackage.AVAILABLE_VERSION__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case AggregatorPackage.AVAILABLE_VERSION__FILTER:
				return filter != null;
			case AggregatorPackage.AVAILABLE_VERSION__AVAILABLE_FROM:
				return (eFlags & AVAILABLE_FROM_EFLAG) != AVAILABLE_FROM_EFLAG_DEFAULT;
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
			case AggregatorPackage.AVAILABLE_VERSION__VERSION_MATCH:
				setVersionMatch((VersionMatch) newValue);
				return;
			case AggregatorPackage.AVAILABLE_VERSION__VERSION:
				setVersion((Version) newValue);
				return;
			case AggregatorPackage.AVAILABLE_VERSION__FILTER:
				setFilter((IMatchExpression<IInstallableUnit>) newValue);
				return;
			case AggregatorPackage.AVAILABLE_VERSION__AVAILABLE_FROM:
				setAvailableFrom((AvailableFrom) newValue);
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
		return AggregatorPackage.Literals.AVAILABLE_VERSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AggregatorPackage.AVAILABLE_VERSION__VERSION_MATCH:
				setVersionMatch(VERSION_MATCH_EDEFAULT);
				return;
			case AggregatorPackage.AVAILABLE_VERSION__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case AggregatorPackage.AVAILABLE_VERSION__FILTER:
				setFilter((IMatchExpression<IInstallableUnit>) null);
				return;
			case AggregatorPackage.AVAILABLE_VERSION__AVAILABLE_FROM:
				setAvailableFrom(AVAILABLE_FROM_EDEFAULT);
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
	public AvailableFrom getAvailableFrom() {
		return AVAILABLE_FROM_EFLAG_VALUES[(eFlags & AVAILABLE_FROM_EFLAG) >>> AVAILABLE_FROM_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IMatchExpression<IInstallableUnit> getFilter() {
		return filter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Version getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VersionMatch getVersionMatch() {
		return VERSION_MATCH_EFLAG_VALUES[(eFlags & VERSION_MATCH_EFLAG) >>> VERSION_MATCH_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAvailableFrom(AvailableFrom newAvailableFrom) {
		AvailableFrom oldAvailableFrom = AVAILABLE_FROM_EFLAG_VALUES[(eFlags
				& AVAILABLE_FROM_EFLAG) >>> AVAILABLE_FROM_EFLAG_OFFSET];
		if (newAvailableFrom == null)
			newAvailableFrom = AVAILABLE_FROM_EDEFAULT;
		eFlags = eFlags & ~AVAILABLE_FROM_EFLAG | newAvailableFrom.ordinal() << AVAILABLE_FROM_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AVAILABLE_VERSION__AVAILABLE_FROM,
					oldAvailableFrom, newAvailableFrom));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilter(IMatchExpression<IInstallableUnit> newFilter) {
		IMatchExpression<IInstallableUnit> oldFilter = filter;
		filter = newFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AVAILABLE_VERSION__FILTER,
					oldFilter, filter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(Version newVersion) {
		Version oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AVAILABLE_VERSION__VERSION,
					oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersionMatch(VersionMatch newVersionMatch) {
		VersionMatch oldVersionMatch = VERSION_MATCH_EFLAG_VALUES[(eFlags
				& VERSION_MATCH_EFLAG) >>> VERSION_MATCH_EFLAG_OFFSET];
		if (newVersionMatch == null)
			newVersionMatch = VERSION_MATCH_EDEFAULT;
		eFlags = eFlags & ~VERSION_MATCH_EFLAG | newVersionMatch.ordinal() << VERSION_MATCH_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AVAILABLE_VERSION__VERSION_MATCH,
					oldVersionMatch, newVersionMatch));
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
		result.append(" (versionMatch: ");
		result.append(VERSION_MATCH_EFLAG_VALUES[(eFlags & VERSION_MATCH_EFLAG) >>> VERSION_MATCH_EFLAG_OFFSET]);
		result.append(", version: ");
		result.append(version);
		result.append(", filter: ");
		result.append(filter);
		result.append(", availableFrom: ");
		result.append(AVAILABLE_FROM_EFLAG_VALUES[(eFlags & AVAILABLE_FROM_EFLAG) >>> AVAILABLE_FROM_EFLAG_OFFSET]);
		result.append(')');
		return result.toString();
	}

} // AvailableVersionImpl
