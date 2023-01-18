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
package org.eclipse.cbi.p2repo.aggregator;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Aggregation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getValidationSets <em>Validation Sets</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getCustomCategories <em>Custom Categories</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getContacts <em>Contacts</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getBuildmaster <em>Buildmaster</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getBuildmasterBackup <em>Buildmaster Backup</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getBuildRoot <em>Build Root</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getPackedStrategy <em>Packed Strategy</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isSendmail <em>Sendmail</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isMavenResult <em>Maven Result</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isStrictMavenVersions <em>Strict Maven Versions</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getVersionFormat <em>Version Format</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getMavenBuildNumber <em>Maven Build Number</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getMavenMappings <em>Maven Mappings</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getMavenDependencyMappings <em>Maven Dependency Mappings</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isAllowLegacySites <em>Allow Legacy Sites</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isIncludeSources <em>Include Sources</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation()
 * @model
 * @generated
 */
public interface Aggregation extends DescriptionProvider, StatusProvider, InfosProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<Contribution> getAllContributions(boolean enabledOnly);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<MetadataRepositoryReference> getAllMetadataRepositoryReferences(boolean enabledOnly);

	/**
	 * Returns the value of the '<em><b>Buildmaster</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buildmaster</em>' reference.
	 * @see #setBuildmaster(Contact)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_Buildmaster()
	 * @model keys="email"
	 * @generated
	 */
	Contact getBuildmaster();

	/**
	 * Returns the value of the '<em><b>Buildmaster Backup</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Buildmaster Backup</em>' reference.
	 * @see #setBuildmasterBackup(Contact)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_BuildmasterBackup()
	 * @model keys="email"
	 * @generated
	 */
	Contact getBuildmasterBackup();

	/**
	 * Returns the value of the '<em><b>Build Root</b></em>' attribute.
	 * The default value is <code>"${user.home}/build"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Build Root</em>' attribute.
	 * @see #setBuildRoot(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_BuildRoot()
	 * @model default="${user.home}/build"
	 * @generated
	 */
	String getBuildRoot();

	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.Configuration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_Configurations()
	 * @model containment="true" resolveProxies="true" required="true"
	 * @generated
	 */
	EList<Configuration> getConfigurations();

	/**
	 * Returns the value of the '<em><b>Contacts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.Contact}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.Contact#getAggregation <em>Aggregation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contacts</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_Contacts()
	 * @see org.eclipse.cbi.p2repo.aggregator.Contact#getAggregation
	 * @model opposite="aggregation" containment="true" resolveProxies="true" keys="email"
	 * @generated
	 */
	EList<Contact> getContacts();

	/**
	 * Returns the value of the '<em><b>Custom Categories</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.CustomCategory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Custom Categories</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_CustomCategories()
	 * @model containment="true" resolveProxies="true" keys="identifier"
	 * @generated
	 */
	EList<CustomCategory> getCustomCategories();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_Label()
	 * @model required="true"
	 * @generated
	 */
	String getLabel();

	/**
	 * Returns the value of the '<em><b>Maven Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.MavenMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maven Mappings</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_MavenMappings()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<MavenMapping> getMavenMappings();

	/**
	 * Returns the value of the '<em><b>Maven Dependency Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @since 1.1.0
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Maven Dependency Mappings</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_MavenDependencyMappings()
	 * @model containment="true" resolveProxies="true"
	 *        extendedMetaData="name='mavenDependencyMapping'"
	 * @generated
	 */
	EList<MavenDependencyMapping> getMavenDependencyMappings();

	/**
	 * Returns the value of the '<em><b>Packed Strategy</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.cbi.p2repo.aggregator.PackedStrategy}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packed Strategy</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.PackedStrategy
	 * @see #setPackedStrategy(PackedStrategy)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_PackedStrategy()
	 * @model
	 * @generated
	 */
	PackedStrategy getPackedStrategy();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.cbi.p2repo.aggregator.AggregationType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregationType
	 * @see #setType(AggregationType)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_Type()
	 * @model required="true"
	 * @generated
	 */
	AggregationType getType();

	/**
	 * Returns the value of the '<em><b>Validation Sets</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.ValidationSet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validation Sets</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_ValidationSets()
	 * @model containment="true" resolveProxies="true" keys="label"
	 * @generated
	 */
	EList<ValidationSet> getValidationSets();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<ValidationSet> getValidationSets(boolean enabledOnly);

	/**
	 * Returns the value of the '<em><b>Allow Legacy Sites</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allow Legacy Sites</em>' attribute.
	 * @see #setAllowLegacySites(boolean)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_AllowLegacySites()
	 * @model default="true" dataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	boolean isAllowLegacySites();

	/**
	 * Returns the value of the '<em><b>Maven Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maven Result</em>' attribute.
	 * @see #setMavenResult(boolean)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_MavenResult()
	 * @model
	 * @generated
	 */
	boolean isMavenResult();

	/**
	 * Returns the value of the '<em><b>Sendmail</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sendmail</em>' attribute.
	 * @see #setSendmail(boolean)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_Sendmail()
	 * @model
	 * @generated
	 */
	boolean isSendmail();

	/**
	 * Returns the value of the '<em><b>Strict Maven Versions</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Strict Maven Versions</em>' attribute.
	 * @see #setStrictMavenVersions(boolean)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_StrictMavenVersions()
	 * @model
	 * @generated
	 */
	boolean isStrictMavenVersions();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isAllowLegacySites <em>Allow Legacy Sites</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allow Legacy Sites</em>' attribute.
	 * @see #isAllowLegacySites()
	 * @generated
	 */
	void setAllowLegacySites(boolean value);

	/**
	 * Returns the value of the '<em><b>Include Sources</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Include Sources</em>' attribute.
	 * @see #setIncludeSources(boolean)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_IncludeSources()
	 * @model
	 * @generated
	 */
	boolean isIncludeSources();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isIncludeSources <em>Include Sources</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Include Sources</em>' attribute.
	 * @see #isIncludeSources()
	 * @generated
	 */
	void setIncludeSources(boolean value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getBuildmaster <em>Buildmaster</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buildmaster</em>' reference.
	 * @see #getBuildmaster()
	 * @generated
	 */
	void setBuildmaster(Contact value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getBuildmasterBackup <em>Buildmaster Backup</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Buildmaster Backup</em>' reference.
	 * @see #getBuildmasterBackup()
	 * @generated
	 */
	void setBuildmasterBackup(Contact value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getBuildRoot <em>Build Root</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Build Root</em>' attribute.
	 * @see #getBuildRoot()
	 * @generated
	 */
	void setBuildRoot(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isMavenResult <em>Maven Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maven Result</em>' attribute.
	 * @see #isMavenResult()
	 * @generated
	 */
	void setMavenResult(boolean value);

	/**
	 * Returns the value of the '<em><b>Version Format</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.cbi.p2repo.aggregator.VersionFormat}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Format</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.VersionFormat
	 * @see #setVersionFormat(VersionFormat)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_VersionFormat()
	 * @model
	 * @generated
	 */
	VersionFormat getVersionFormat();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getVersionFormat <em>Version Format</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Format</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.VersionFormat
	 * @see #getVersionFormat()
	 * @generated
	 */
	void setVersionFormat(VersionFormat value);

	/**
	 * Returns the value of the '<em><b>Maven Build Number</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maven Build Number</em>' attribute.
	 * @see #setMavenBuildNumber(int)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAggregation_MavenBuildNumber()
	 * @model default="0" dataType="org.eclipse.emf.ecore.xml.type.Int"
	 * @generated
	 */
	int getMavenBuildNumber();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getMavenBuildNumber <em>Maven Build Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maven Build Number</em>' attribute.
	 * @see #getMavenBuildNumber()
	 * @generated
	 */
	void setMavenBuildNumber(int value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getPackedStrategy <em>Packed Strategy</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Packed Strategy</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.PackedStrategy
	 * @see #getPackedStrategy()
	 * @generated
	 */
	void setPackedStrategy(PackedStrategy value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isSendmail <em>Sendmail</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sendmail</em>' attribute.
	 * @see #isSendmail()
	 * @generated
	 */
	void setSendmail(boolean value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#isStrictMavenVersions <em>Strict Maven Versions</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Strict Maven Versions</em>' attribute.
	 * @see #isStrictMavenVersions()
	 * @generated
	 */
	void setStrictMavenVersions(boolean value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Aggregation#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregationType
	 * @see #getType()
	 * @generated
	 */
	void setType(AggregationType value);

} // Aggregator
