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
 * A representation of the model object '<em><b>Contribution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Contribution#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Contribution#getRepositories <em>Repositories</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Contribution#getContacts <em>Contacts</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Contribution#getMavenMappings <em>Maven Mappings</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Contribution#getMavenDependencyMappings <em>Maven Dependency Mappings</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getContribution()
 * @model
 * @generated
 */
public interface Contribution
		extends EnabledStatusProvider, DescriptionProvider, StatusProvider, InfosProvider, IdentificationProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<MavenMapping> getAllMavenMappings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * @since 1.1.0
	 * <!-- end-model-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<MavenDependencyMapping> getAllMavenDependencyMappings();

	/**
	 * Returns the value of the '<em><b>Contacts</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.Contact}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contacts</em>' reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getContribution_Contacts()
	 * @model keys="email"
	 * @generated
	 */
	EList<Contact> getContacts();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getContribution_Label()
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
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getContribution_MavenMappings()
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
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getContribution_MavenDependencyMappings()
	 * @model containment="true" resolveProxies="true"
	 *        extendedMetaData="name='mavenDependencyMapping'"
	 * @generated
	 */
	EList<MavenDependencyMapping> getMavenDependencyMappings();

	/**
	 * Returns the value of the '<em><b>Repositories</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.MappedRepository}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repositories</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getContribution_Repositories()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<MappedRepository> getRepositories();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	EList<MappedRepository> getRepositories(boolean enabledOnly);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Contribution#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

} // Contribution
