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
package org.eclipse.cbi.p2repo.aggregator.impl;

import java.util.Collection;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregationType;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.Configuration;
import org.eclipse.cbi.p2repo.aggregator.Contact;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.CustomCategory;
import org.eclipse.cbi.p2repo.aggregator.Feature;
import org.eclipse.cbi.p2repo.aggregator.InfosProvider;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MavenMapping;
import org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference;
import org.eclipse.cbi.p2repo.aggregator.PackedStrategy;
import org.eclipse.cbi.p2repo.aggregator.Status;
import org.eclipse.cbi.p2repo.aggregator.StatusCode;
import org.eclipse.cbi.p2repo.aggregator.StatusProvider;
import org.eclipse.cbi.p2repo.aggregator.ValidationSet;
import org.eclipse.cbi.p2repo.aggregator.VersionFormat;
import org.eclipse.cbi.p2repo.aggregator.util.GeneralUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Aggregator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getStatus <em>Status</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getErrors <em>Errors</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getWarnings <em>Warnings</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getInfos <em>Infos</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getValidationSets <em>Validation Sets</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getCustomCategories <em>Custom Categories</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getContacts <em>Contacts</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getBuildmaster <em>Buildmaster</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getBuildmasterBackup <em>Buildmaster Backup</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getBuildRoot <em>Build Root</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getPackedStrategy <em>Packed Strategy</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#isSendmail <em>Sendmail</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#isMavenResult <em>Maven Result</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#isStrictMavenVersions <em>Strict Maven Versions</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getVersionFormat <em>Version Format</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getMavenBuildNumber <em>Maven Build Number</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#getMavenMappings <em>Maven Mappings</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl#isAllowLegacySites <em>Allow Legacy Sites</em>}</li>
 * </ul>
 *
 * @generated
 */
public class AggregationImpl extends DescriptionProviderImpl implements Aggregation {
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
	 * The cached value of the '{@link #getValidationSets() <em>Validation Sets</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValidationSets()
	 * @generated
	 * @ordered
	 */
	protected EList<ValidationSet> validationSets;

	/**
	 * The cached value of the '{@link #getConfigurations() <em>Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<Configuration> configurations;

	/**
	 * The cached value of the '{@link #getCustomCategories() <em>Custom Categories</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCustomCategories()
	 * @generated
	 * @ordered
	 */
	protected EList<CustomCategory> customCategories;

	/**
	 * The cached value of the '{@link #getContacts() <em>Contacts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContacts()
	 * @generated
	 * @ordered
	 */
	protected EList<Contact> contacts;

	/**
	 * The cached value of the '{@link #getBuildmaster() <em>Buildmaster</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildmaster()
	 * @generated
	 * @ordered
	 */
	protected Contact buildmaster;

	/**
	 * The cached value of the '{@link #getBuildmasterBackup() <em>Buildmaster Backup</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildmasterBackup()
	 * @generated
	 * @ordered
	 */
	protected Contact buildmasterBackup;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getBuildRoot() <em>Build Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildRoot()
	 * @generated
	 * @ordered
	 */
	protected static final String BUILD_ROOT_EDEFAULT = "${user.home}/build";

	/**
	 * The cached value of the '{@link #getBuildRoot() <em>Build Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBuildRoot()
	 * @generated
	 * @ordered
	 */
	protected String buildRoot = BUILD_ROOT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPackedStrategy() <em>Packed Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackedStrategy()
	 * @generated
	 * @ordered
	 */
	protected static final PackedStrategy PACKED_STRATEGY_EDEFAULT = PackedStrategy.COPY;

	/**
	 * The offset of the flags representing the value of the '{@link #getPackedStrategy() <em>Packed Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int PACKED_STRATEGY_EFLAG_OFFSET = 0;

	/**
	 * The flags representing the default value of the '{@link #getPackedStrategy() <em>Packed Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int PACKED_STRATEGY_EFLAG_DEFAULT = PACKED_STRATEGY_EDEFAULT
			.ordinal() << PACKED_STRATEGY_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link PackedStrategy Packed Strategy}'
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	private static final PackedStrategy[] PACKED_STRATEGY_EFLAG_VALUES = PackedStrategy.values();

	/**
	 * The flags representing the value of the '{@link #getPackedStrategy() <em>Packed Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackedStrategy()
	 * @generated
	 * @ordered
	 */
	protected static final int PACKED_STRATEGY_EFLAG = 0x7 << PACKED_STRATEGY_EFLAG_OFFSET;

	/**
	 * The default value of the '{@link #isSendmail() <em>Sendmail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSendmail()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SENDMAIL_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isSendmail() <em>Sendmail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSendmail()
	 * @generated
	 * @ordered
	 */
	protected static final int SENDMAIL_EFLAG = 1 << 3;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final AggregationType TYPE_EDEFAULT = AggregationType.STABLE;

	/**
	 * The offset of the flags representing the value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int TYPE_EFLAG_OFFSET = 4;

	/**
	 * The flags representing the default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int TYPE_EFLAG_DEFAULT = TYPE_EDEFAULT.ordinal() << TYPE_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link AggregationType Aggregation Type}'
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	private static final AggregationType[] TYPE_EFLAG_VALUES = AggregationType.values();

	/**
	 * The flags representing the value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final int TYPE_EFLAG = 0x7 << TYPE_EFLAG_OFFSET;

	/**
	 * The default value of the '{@link #isMavenResult() <em>Maven Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMavenResult()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MAVEN_RESULT_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isMavenResult() <em>Maven Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isMavenResult()
	 * @generated
	 * @ordered
	 */
	protected static final int MAVEN_RESULT_EFLAG = 1 << 7;

	/**
	 * The default value of the '{@link #isStrictMavenVersions() <em>Strict Maven Versions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrictMavenVersions()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STRICT_MAVEN_VERSIONS_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isStrictMavenVersions() <em>Strict Maven Versions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStrictMavenVersions()
	 * @generated
	 * @ordered
	 */
	protected static final int STRICT_MAVEN_VERSIONS_EFLAG = 1 << 8;

	/**
	 * The default value of the '{@link #getVersionFormat() <em>Version Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionFormat()
	 * @generated
	 * @ordered
	 */
	protected static final VersionFormat VERSION_FORMAT_EDEFAULT = VersionFormat.NORMAL;

	/**
	 * The offset of the flags representing the value of the '{@link #getVersionFormat() <em>Version Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int VERSION_FORMAT_EFLAG_OFFSET = 9;

	/**
	 * The flags representing the default value of the '{@link #getVersionFormat() <em>Version Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected static final int VERSION_FORMAT_EFLAG_DEFAULT = VERSION_FORMAT_EDEFAULT
			.ordinal() << VERSION_FORMAT_EFLAG_OFFSET;

	/**
	 * The array of enumeration values for '{@link VersionFormat Version Format}'
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	private static final VersionFormat[] VERSION_FORMAT_EFLAG_VALUES = VersionFormat.values();

	/**
	 * The flags representing the value of the '{@link #getVersionFormat() <em>Version Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersionFormat()
	 * @generated
	 * @ordered
	 */
	protected static final int VERSION_FORMAT_EFLAG = 0x3 << VERSION_FORMAT_EFLAG_OFFSET;

	/**
	 * The default value of the '{@link #getMavenBuildNumber() <em>Maven Build Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMavenBuildNumber()
	 * @generated
	 * @ordered
	 */
	protected static final int MAVEN_BUILD_NUMBER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMavenBuildNumber() <em>Maven Build Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMavenBuildNumber()
	 * @generated
	 * @ordered
	 */
	protected int mavenBuildNumber = MAVEN_BUILD_NUMBER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getMavenMappings() <em>Maven Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMavenMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<MavenMapping> mavenMappings;

	/**
	 * The default value of the '{@link #isAllowLegacySites() <em>Allow Legacy Sites</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowLegacySites()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ALLOW_LEGACY_SITES_EDEFAULT = true;

	/**
	 * The flag representing the value of the '{@link #isAllowLegacySites() <em>Allow Legacy Sites</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAllowLegacySites()
	 * @generated
	 * @ordered
	 */
	protected static final int ALLOW_LEGACY_SITES_EFLAG = 1 << 11;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AggregationImpl() {
		super();
		eFlags |= ALLOW_LEGACY_SITES_EFLAG;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contact basicGetBuildmaster() {
		return buildmaster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Contact basicGetBuildmasterBackup() {
		return buildmasterBackup;
	}

	public void clearStatus() {
		for (ValidationSet vs : getValidationSets())
			((ValidationSetImpl) vs).clearStatus();
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
				case AggregatorPackage.AGGREGATION__STATUS:
					return AggregatorPackage.STATUS_PROVIDER__STATUS;
				default:
					return -1;
			}
		}
		if (baseClass == InfosProvider.class) {
			switch (derivedFeatureID) {
				case AggregatorPackage.AGGREGATION__ERRORS:
					return AggregatorPackage.INFOS_PROVIDER__ERRORS;
				case AggregatorPackage.AGGREGATION__WARNINGS:
					return AggregatorPackage.INFOS_PROVIDER__WARNINGS;
				case AggregatorPackage.AGGREGATION__INFOS:
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
					return AggregatorPackage.AGGREGATION__STATUS;
				default:
					return -1;
			}
		}
		if (baseClass == InfosProvider.class) {
			switch (baseFeatureID) {
				case AggregatorPackage.INFOS_PROVIDER__ERRORS:
					return AggregatorPackage.AGGREGATION__ERRORS;
				case AggregatorPackage.INFOS_PROVIDER__WARNINGS:
					return AggregatorPackage.AGGREGATION__WARNINGS;
				case AggregatorPackage.INFOS_PROVIDER__INFOS:
					return AggregatorPackage.AGGREGATION__INFOS;
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
			case AggregatorPackage.AGGREGATION__STATUS:
				return getStatus();
			case AggregatorPackage.AGGREGATION__ERRORS:
				return getErrors();
			case AggregatorPackage.AGGREGATION__WARNINGS:
				return getWarnings();
			case AggregatorPackage.AGGREGATION__INFOS:
				return getInfos();
			case AggregatorPackage.AGGREGATION__VALIDATION_SETS:
				return getValidationSets();
			case AggregatorPackage.AGGREGATION__CONFIGURATIONS:
				return getConfigurations();
			case AggregatorPackage.AGGREGATION__CUSTOM_CATEGORIES:
				return getCustomCategories();
			case AggregatorPackage.AGGREGATION__CONTACTS:
				return getContacts();
			case AggregatorPackage.AGGREGATION__BUILDMASTER:
				if (resolve)
					return getBuildmaster();
				return basicGetBuildmaster();
			case AggregatorPackage.AGGREGATION__BUILDMASTER_BACKUP:
				if (resolve)
					return getBuildmasterBackup();
				return basicGetBuildmasterBackup();
			case AggregatorPackage.AGGREGATION__LABEL:
				return getLabel();
			case AggregatorPackage.AGGREGATION__BUILD_ROOT:
				return getBuildRoot();
			case AggregatorPackage.AGGREGATION__PACKED_STRATEGY:
				return getPackedStrategy();
			case AggregatorPackage.AGGREGATION__SENDMAIL:
				return isSendmail();
			case AggregatorPackage.AGGREGATION__TYPE:
				return getType();
			case AggregatorPackage.AGGREGATION__MAVEN_RESULT:
				return isMavenResult();
			case AggregatorPackage.AGGREGATION__STRICT_MAVEN_VERSIONS:
				return isStrictMavenVersions();
			case AggregatorPackage.AGGREGATION__VERSION_FORMAT:
				return getVersionFormat();
			case AggregatorPackage.AGGREGATION__MAVEN_BUILD_NUMBER:
				return getMavenBuildNumber();
			case AggregatorPackage.AGGREGATION__MAVEN_MAPPINGS:
				return getMavenMappings();
			case AggregatorPackage.AGGREGATION__ALLOW_LEGACY_SITES:
				return isAllowLegacySites();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AggregatorPackage.AGGREGATION__CONTACTS:
				return ((InternalEList<InternalEObject>) (InternalEList<?>) getContacts()).basicAdd(otherEnd, msgs);
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
			case AggregatorPackage.AGGREGATION__VALIDATION_SETS:
				return ((InternalEList<?>) getValidationSets()).basicRemove(otherEnd, msgs);
			case AggregatorPackage.AGGREGATION__CONFIGURATIONS:
				return ((InternalEList<?>) getConfigurations()).basicRemove(otherEnd, msgs);
			case AggregatorPackage.AGGREGATION__CUSTOM_CATEGORIES:
				return ((InternalEList<?>) getCustomCategories()).basicRemove(otherEnd, msgs);
			case AggregatorPackage.AGGREGATION__CONTACTS:
				return ((InternalEList<?>) getContacts()).basicRemove(otherEnd, msgs);
			case AggregatorPackage.AGGREGATION__MAVEN_MAPPINGS:
				return ((InternalEList<?>) getMavenMappings()).basicRemove(otherEnd, msgs);
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
			case AggregatorPackage.AGGREGATION__STATUS:
				return getStatus() != null;
			case AggregatorPackage.AGGREGATION__ERRORS:
				return errors != null && !errors.isEmpty();
			case AggregatorPackage.AGGREGATION__WARNINGS:
				return warnings != null && !warnings.isEmpty();
			case AggregatorPackage.AGGREGATION__INFOS:
				return infos != null && !infos.isEmpty();
			case AggregatorPackage.AGGREGATION__VALIDATION_SETS:
				return validationSets != null && !validationSets.isEmpty();
			case AggregatorPackage.AGGREGATION__CONFIGURATIONS:
				return configurations != null && !configurations.isEmpty();
			case AggregatorPackage.AGGREGATION__CUSTOM_CATEGORIES:
				return customCategories != null && !customCategories.isEmpty();
			case AggregatorPackage.AGGREGATION__CONTACTS:
				return contacts != null && !contacts.isEmpty();
			case AggregatorPackage.AGGREGATION__BUILDMASTER:
				return buildmaster != null;
			case AggregatorPackage.AGGREGATION__BUILDMASTER_BACKUP:
				return buildmasterBackup != null;
			case AggregatorPackage.AGGREGATION__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case AggregatorPackage.AGGREGATION__BUILD_ROOT:
				return BUILD_ROOT_EDEFAULT == null ? buildRoot != null : !BUILD_ROOT_EDEFAULT.equals(buildRoot);
			case AggregatorPackage.AGGREGATION__PACKED_STRATEGY:
				return (eFlags & PACKED_STRATEGY_EFLAG) != PACKED_STRATEGY_EFLAG_DEFAULT;
			case AggregatorPackage.AGGREGATION__SENDMAIL:
				return ((eFlags & SENDMAIL_EFLAG) != 0) != SENDMAIL_EDEFAULT;
			case AggregatorPackage.AGGREGATION__TYPE:
				return (eFlags & TYPE_EFLAG) != TYPE_EFLAG_DEFAULT;
			case AggregatorPackage.AGGREGATION__MAVEN_RESULT:
				return ((eFlags & MAVEN_RESULT_EFLAG) != 0) != MAVEN_RESULT_EDEFAULT;
			case AggregatorPackage.AGGREGATION__STRICT_MAVEN_VERSIONS:
				return ((eFlags & STRICT_MAVEN_VERSIONS_EFLAG) != 0) != STRICT_MAVEN_VERSIONS_EDEFAULT;
			case AggregatorPackage.AGGREGATION__VERSION_FORMAT:
				return (eFlags & VERSION_FORMAT_EFLAG) != VERSION_FORMAT_EFLAG_DEFAULT;
			case AggregatorPackage.AGGREGATION__MAVEN_BUILD_NUMBER:
				return mavenBuildNumber != MAVEN_BUILD_NUMBER_EDEFAULT;
			case AggregatorPackage.AGGREGATION__MAVEN_MAPPINGS:
				return mavenMappings != null && !mavenMappings.isEmpty();
			case AggregatorPackage.AGGREGATION__ALLOW_LEGACY_SITES:
				return ((eFlags & ALLOW_LEGACY_SITES_EFLAG) != 0) != ALLOW_LEGACY_SITES_EDEFAULT;
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
			case AggregatorPackage.AGGREGATION__ERRORS:
				getErrors().clear();
				getErrors().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.AGGREGATION__WARNINGS:
				getWarnings().clear();
				getWarnings().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.AGGREGATION__INFOS:
				getInfos().clear();
				getInfos().addAll((Collection<? extends String>) newValue);
				return;
			case AggregatorPackage.AGGREGATION__VALIDATION_SETS:
				getValidationSets().clear();
				getValidationSets().addAll((Collection<? extends ValidationSet>) newValue);
				return;
			case AggregatorPackage.AGGREGATION__CONFIGURATIONS:
				getConfigurations().clear();
				getConfigurations().addAll((Collection<? extends Configuration>) newValue);
				return;
			case AggregatorPackage.AGGREGATION__CUSTOM_CATEGORIES:
				getCustomCategories().clear();
				getCustomCategories().addAll((Collection<? extends CustomCategory>) newValue);
				return;
			case AggregatorPackage.AGGREGATION__CONTACTS:
				getContacts().clear();
				getContacts().addAll((Collection<? extends Contact>) newValue);
				return;
			case AggregatorPackage.AGGREGATION__BUILDMASTER:
				setBuildmaster((Contact) newValue);
				return;
			case AggregatorPackage.AGGREGATION__BUILDMASTER_BACKUP:
				setBuildmasterBackup((Contact) newValue);
				return;
			case AggregatorPackage.AGGREGATION__LABEL:
				setLabel((String) newValue);
				return;
			case AggregatorPackage.AGGREGATION__BUILD_ROOT:
				setBuildRoot((String) newValue);
				return;
			case AggregatorPackage.AGGREGATION__PACKED_STRATEGY:
				setPackedStrategy((PackedStrategy) newValue);
				return;
			case AggregatorPackage.AGGREGATION__SENDMAIL:
				setSendmail((Boolean) newValue);
				return;
			case AggregatorPackage.AGGREGATION__TYPE:
				setType((AggregationType) newValue);
				return;
			case AggregatorPackage.AGGREGATION__MAVEN_RESULT:
				setMavenResult((Boolean) newValue);
				return;
			case AggregatorPackage.AGGREGATION__STRICT_MAVEN_VERSIONS:
				setStrictMavenVersions((Boolean) newValue);
				return;
			case AggregatorPackage.AGGREGATION__VERSION_FORMAT:
				setVersionFormat((VersionFormat) newValue);
				return;
			case AggregatorPackage.AGGREGATION__MAVEN_BUILD_NUMBER:
				setMavenBuildNumber((Integer) newValue);
				return;
			case AggregatorPackage.AGGREGATION__MAVEN_MAPPINGS:
				getMavenMappings().clear();
				getMavenMappings().addAll((Collection<? extends MavenMapping>) newValue);
				return;
			case AggregatorPackage.AGGREGATION__ALLOW_LEGACY_SITES:
				setAllowLegacySites((Boolean) newValue);
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
		return AggregatorPackage.Literals.AGGREGATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case AggregatorPackage.AGGREGATION__ERRORS:
				getErrors().clear();
				return;
			case AggregatorPackage.AGGREGATION__WARNINGS:
				getWarnings().clear();
				return;
			case AggregatorPackage.AGGREGATION__INFOS:
				getInfos().clear();
				return;
			case AggregatorPackage.AGGREGATION__VALIDATION_SETS:
				getValidationSets().clear();
				return;
			case AggregatorPackage.AGGREGATION__CONFIGURATIONS:
				getConfigurations().clear();
				return;
			case AggregatorPackage.AGGREGATION__CUSTOM_CATEGORIES:
				getCustomCategories().clear();
				return;
			case AggregatorPackage.AGGREGATION__CONTACTS:
				getContacts().clear();
				return;
			case AggregatorPackage.AGGREGATION__BUILDMASTER:
				setBuildmaster((Contact) null);
				return;
			case AggregatorPackage.AGGREGATION__BUILDMASTER_BACKUP:
				setBuildmasterBackup((Contact) null);
				return;
			case AggregatorPackage.AGGREGATION__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case AggregatorPackage.AGGREGATION__BUILD_ROOT:
				setBuildRoot(BUILD_ROOT_EDEFAULT);
				return;
			case AggregatorPackage.AGGREGATION__PACKED_STRATEGY:
				setPackedStrategy(PACKED_STRATEGY_EDEFAULT);
				return;
			case AggregatorPackage.AGGREGATION__SENDMAIL:
				setSendmail(SENDMAIL_EDEFAULT);
				return;
			case AggregatorPackage.AGGREGATION__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case AggregatorPackage.AGGREGATION__MAVEN_RESULT:
				setMavenResult(MAVEN_RESULT_EDEFAULT);
				return;
			case AggregatorPackage.AGGREGATION__STRICT_MAVEN_VERSIONS:
				setStrictMavenVersions(STRICT_MAVEN_VERSIONS_EDEFAULT);
				return;
			case AggregatorPackage.AGGREGATION__VERSION_FORMAT:
				setVersionFormat(VERSION_FORMAT_EDEFAULT);
				return;
			case AggregatorPackage.AGGREGATION__MAVEN_BUILD_NUMBER:
				setMavenBuildNumber(MAVEN_BUILD_NUMBER_EDEFAULT);
				return;
			case AggregatorPackage.AGGREGATION__MAVEN_MAPPINGS:
				getMavenMappings().clear();
				return;
			case AggregatorPackage.AGGREGATION__ALLOW_LEGACY_SITES:
				setAllowLegacySites(ALLOW_LEGACY_SITES_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 *
	 * @generated NOT
	 */
	@Override
	public EList<Contribution> getAllContributions(boolean enabledOnly) {
		BasicEList<Contribution> result = new UniqueEList.FastCompare<>();
		for (ValidationSet vs : getValidationSets(enabledOnly)) {
			for (Contribution contribution : vs.getContributions()) {
				if (enabledOnly && !contribution.isEnabled())
					continue;
				result.add(contribution);
			}
		}
		return result;
	}

	/**
	 *
	 * @generated NOT
	 */
	@Override
	public EList<MetadataRepositoryReference> getAllMetadataRepositoryReferences(boolean enabledOnly) {
		EList<MetadataRepositoryReference> allRepos = new UniqueEList.FastCompare<>();
		for (ValidationSet vs : getValidationSets(enabledOnly)) {
			for (Contribution contribution : vs.getContributions()) {
				if (enabledOnly && !contribution.isEnabled())
					continue;
				for (MappedRepository mappedRepository : contribution.getRepositories(enabledOnly))
					allRepos.add(mappedRepository);
			}
			for (MetadataRepositoryReference mrRef : vs.getValidationRepositories()) {
				if (enabledOnly && !mrRef.isEnabled())
					continue;
				allRepos.add(mrRef);
			}
		}
		return allRepos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Contact getBuildmaster() {
		if (buildmaster != null && ((EObject) buildmaster).eIsProxy()) {
			InternalEObject oldBuildmaster = (InternalEObject) buildmaster;
			buildmaster = (Contact) eResolveProxy(oldBuildmaster);
			if (buildmaster != oldBuildmaster) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AggregatorPackage.AGGREGATION__BUILDMASTER, oldBuildmaster, buildmaster));
			}
		}
		return buildmaster;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Contact getBuildmasterBackup() {
		if (buildmasterBackup != null && ((EObject) buildmasterBackup).eIsProxy()) {
			InternalEObject oldBuildmasterBackup = (InternalEObject) buildmasterBackup;
			buildmasterBackup = (Contact) eResolveProxy(oldBuildmasterBackup);
			if (buildmasterBackup != oldBuildmasterBackup) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							AggregatorPackage.AGGREGATION__BUILDMASTER_BACKUP, oldBuildmasterBackup,
							buildmasterBackup));
			}
		}
		return buildmasterBackup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBuildRoot() {
		return buildRoot;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Configuration> getConfigurations() {
		if (configurations == null) {
			configurations = new EObjectContainmentEList.Resolving<>(Configuration.class, this,
					AggregatorPackage.AGGREGATION__CONFIGURATIONS);
		}
		return configurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Contact> getContacts() {
		if (contacts == null) {
			contacts = new EObjectContainmentWithInverseEList.Resolving<>(Contact.class, this,
					AggregatorPackage.AGGREGATION__CONTACTS, AggregatorPackage.CONTACT__AGGREGATION);
		}
		return contacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CustomCategory> getCustomCategories() {
		if (customCategories == null) {
			customCategories = new EObjectContainmentEList.Resolving<>(CustomCategory.class, this,
					AggregatorPackage.AGGREGATION__CUSTOM_CATEGORIES);
		}
		return customCategories;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getErrors() {
		if (errors == null) {
			errors = new EDataTypeUniqueEList<>(String.class, this, AggregatorPackage.AGGREGATION__ERRORS);
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
			infos = new EDataTypeUniqueEList<>(String.class, this, AggregatorPackage.AGGREGATION__INFOS);
		}
		return infos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<MavenMapping> getMavenMappings() {
		if (mavenMappings == null) {
			mavenMappings = new EObjectContainmentEList.Resolving<>(MavenMapping.class, this,
					AggregatorPackage.AGGREGATION__MAVEN_MAPPINGS);
		}
		return mavenMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PackedStrategy getPackedStrategy() {
		return PACKED_STRATEGY_EFLAG_VALUES[(eFlags & PACKED_STRATEGY_EFLAG) >>> PACKED_STRATEGY_EFLAG_OFFSET];
	}

	@Override
	synchronized public Status getStatus() {
		StatusCode statusCode;
		for (ValidationSet vs : getValidationSets(true)) {
			if ((statusCode = vs.getStatus().getCode()) != StatusCode.OK && statusCode != StatusCode.WAITING)
				return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN);
		}
		for (MavenMapping mapping : getMavenMappings()) {
			if ((statusCode = mapping.getStatus().getCode()) != StatusCode.OK && statusCode != StatusCode.WAITING)
				return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN);
		}
		for (CustomCategory customCategory : getCustomCategories()) {
			for (Feature feature : customCategory.getFeatures()) {
				if ((statusCode = feature.getStatus().getCode()) != StatusCode.OK && statusCode != StatusCode.WAITING) {
					return AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN);
				}
			}
		}
		return AggregatorFactory.eINSTANCE.createStatus(StatusCode.OK);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AggregationType getType() {
		return TYPE_EFLAG_VALUES[(eFlags & TYPE_EFLAG) >>> TYPE_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ValidationSet> getValidationSets() {
		if (validationSets == null) {
			validationSets = new EObjectContainmentEList.Resolving<>(ValidationSet.class, this,
					AggregatorPackage.AGGREGATION__VALIDATION_SETS);
		}
		return validationSets;
	}

	/**
	 *
	 * @generated NOT
	 */
	@Override
	public EList<ValidationSet> getValidationSets(boolean enabledOnly) {
		EList<ValidationSet> vss = getValidationSets();
		if (enabledOnly) {
			vss = GeneralUtils.getEnabled(vss);
		}
		return vss;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VersionFormat getVersionFormat() {
		return VERSION_FORMAT_EFLAG_VALUES[(eFlags & VERSION_FORMAT_EFLAG) >>> VERSION_FORMAT_EFLAG_OFFSET];
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getWarnings() {
		if (warnings == null) {
			warnings = new EDataTypeUniqueEList<>(String.class, this, AggregatorPackage.AGGREGATION__WARNINGS);
		}
		return warnings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isAllowLegacySites() {
		return (eFlags & ALLOW_LEGACY_SITES_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isMavenResult() {
		return (eFlags & MAVEN_RESULT_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSendmail() {
		return (eFlags & SENDMAIL_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isStrictMavenVersions() {
		return (eFlags & STRICT_MAVEN_VERSIONS_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAllowLegacySites(boolean newAllowLegacySites) {
		boolean oldAllowLegacySites = (eFlags & ALLOW_LEGACY_SITES_EFLAG) != 0;
		if (newAllowLegacySites)
			eFlags |= ALLOW_LEGACY_SITES_EFLAG;
		else
			eFlags &= ~ALLOW_LEGACY_SITES_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AGGREGATION__ALLOW_LEGACY_SITES,
					oldAllowLegacySites, newAllowLegacySites));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBuildmaster(Contact newBuildmaster) {
		Contact oldBuildmaster = buildmaster;
		buildmaster = newBuildmaster;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AGGREGATION__BUILDMASTER,
					oldBuildmaster, buildmaster));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBuildmasterBackup(Contact newBuildmasterBackup) {
		Contact oldBuildmasterBackup = buildmasterBackup;
		buildmasterBackup = newBuildmasterBackup;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AGGREGATION__BUILDMASTER_BACKUP,
					oldBuildmasterBackup, buildmasterBackup));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBuildRoot(String newBuildRoot) {
		String oldBuildRoot = buildRoot;
		buildRoot = newBuildRoot;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AGGREGATION__BUILD_ROOT,
					oldBuildRoot, buildRoot));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AGGREGATION__LABEL, oldLabel,
					label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMavenResult(boolean newMavenResult) {
		boolean oldMavenResult = (eFlags & MAVEN_RESULT_EFLAG) != 0;
		if (newMavenResult)
			eFlags |= MAVEN_RESULT_EFLAG;
		else
			eFlags &= ~MAVEN_RESULT_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AGGREGATION__MAVEN_RESULT,
					oldMavenResult, newMavenResult));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPackedStrategy(PackedStrategy newPackedStrategy) {
		PackedStrategy oldPackedStrategy = PACKED_STRATEGY_EFLAG_VALUES[(eFlags
				& PACKED_STRATEGY_EFLAG) >>> PACKED_STRATEGY_EFLAG_OFFSET];
		if (newPackedStrategy == null)
			newPackedStrategy = PACKED_STRATEGY_EDEFAULT;
		eFlags = eFlags & ~PACKED_STRATEGY_EFLAG | newPackedStrategy.ordinal() << PACKED_STRATEGY_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AGGREGATION__PACKED_STRATEGY,
					oldPackedStrategy, newPackedStrategy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSendmail(boolean newSendmail) {
		boolean oldSendmail = (eFlags & SENDMAIL_EFLAG) != 0;
		if (newSendmail)
			eFlags |= SENDMAIL_EFLAG;
		else
			eFlags &= ~SENDMAIL_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AGGREGATION__SENDMAIL, oldSendmail,
					newSendmail));
	}

	/**
	 *
	 * @generated NOT
	 */
	@Override
	public void setStrictMavenVersions(boolean newStrictMavenVersions) {
		boolean oldStrictMavenVersions = (eFlags & STRICT_MAVEN_VERSIONS_EFLAG) != 0;
		if (newStrictMavenVersions)
			eFlags |= STRICT_MAVEN_VERSIONS_EFLAG;
		else
			eFlags &= ~STRICT_MAVEN_VERSIONS_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AGGREGATION__STRICT_MAVEN_VERSIONS,
					oldStrictMavenVersions, newStrictMavenVersions));
		if (newStrictMavenVersions != oldStrictMavenVersions) {
			if (newStrictMavenVersions)
				setVersionFormat(VersionFormat.STRICT_MAVEN);
			else if (getVersionFormat() == VersionFormat.STRICT_MAVEN) // don't propagate if format is MavenRelease
				setVersionFormat(VersionFormat.NORMAL);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(AggregationType newType) {
		AggregationType oldType = TYPE_EFLAG_VALUES[(eFlags & TYPE_EFLAG) >>> TYPE_EFLAG_OFFSET];
		if (newType == null)
			newType = TYPE_EDEFAULT;
		eFlags = eFlags & ~TYPE_EFLAG | newType.ordinal() << TYPE_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AGGREGATION__TYPE, oldType,
					newType));
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public void setVersionFormat(VersionFormat newVersionFormat) {
		VersionFormat oldVersionFormat = VERSION_FORMAT_EFLAG_VALUES[(eFlags
				& VERSION_FORMAT_EFLAG) >>> VERSION_FORMAT_EFLAG_OFFSET];
		if (newVersionFormat == null)
			newVersionFormat = VERSION_FORMAT_EDEFAULT;
		eFlags = eFlags & ~VERSION_FORMAT_EFLAG | newVersionFormat.ordinal() << VERSION_FORMAT_EFLAG_OFFSET;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AGGREGATION__VERSION_FORMAT,
					oldVersionFormat, newVersionFormat));
		if (oldVersionFormat != newVersionFormat)
			setStrictMavenVersions(newVersionFormat == VersionFormat.STRICT_MAVEN);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getMavenBuildNumber() {
		return mavenBuildNumber;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMavenBuildNumber(int newMavenBuildNumber) {
		int oldMavenBuildNumber = mavenBuildNumber;
		mavenBuildNumber = newMavenBuildNumber;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AggregatorPackage.AGGREGATION__MAVEN_BUILD_NUMBER,
					oldMavenBuildNumber, mavenBuildNumber));
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
		result.append(", label: ");
		result.append(label);
		result.append(", buildRoot: ");
		result.append(buildRoot);
		result.append(", packedStrategy: ");
		result.append(PACKED_STRATEGY_EFLAG_VALUES[(eFlags & PACKED_STRATEGY_EFLAG) >>> PACKED_STRATEGY_EFLAG_OFFSET]);
		result.append(", sendmail: ");
		result.append((eFlags & SENDMAIL_EFLAG) != 0);
		result.append(", type: ");
		result.append(TYPE_EFLAG_VALUES[(eFlags & TYPE_EFLAG) >>> TYPE_EFLAG_OFFSET]);
		result.append(", mavenResult: ");
		result.append((eFlags & MAVEN_RESULT_EFLAG) != 0);
		result.append(", strictMavenVersions: ");
		result.append((eFlags & STRICT_MAVEN_VERSIONS_EFLAG) != 0);
		result.append(", versionFormat: ");
		result.append(VERSION_FORMAT_EFLAG_VALUES[(eFlags & VERSION_FORMAT_EFLAG) >>> VERSION_FORMAT_EFLAG_OFFSET]);
		result.append(", mavenBuildNumber: ");
		result.append(mavenBuildNumber);
		result.append(", allowLegacySites: ");
		result.append((eFlags & ALLOW_LEGACY_SITES_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} // AggregatorImpl
