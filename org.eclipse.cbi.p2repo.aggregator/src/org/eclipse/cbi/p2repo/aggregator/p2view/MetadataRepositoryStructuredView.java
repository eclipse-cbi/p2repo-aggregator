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
package org.eclipse.cbi.p2repo.aggregator.p2view;

import java.net.URI;

import org.eclipse.cbi.p2repo.aggregator.ChildrenProvider;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metadata Repository Structured View</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#getInstallableUnitList <em>Installable Unit List</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#getMetadataRepository <em>Metadata Repository</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#isLoaded <em>Loaded</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#getRepositoryReferences <em>Repository References</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#getLocation <em>Location</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getMetadataRepositoryStructuredView()
 * @model
 * @generated
 */
public interface MetadataRepositoryStructuredView extends ChildrenProvider<InstallableUnits> {
	/**
	 * Returns the value of the '<em><b>Installable Unit List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installable Unit List</em>' containment reference.
	 * @see #setInstallableUnitList(InstallableUnits)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getMetadataRepositoryStructuredView_InstallableUnitList()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	InstallableUnits getInstallableUnitList();

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #isSetLocation()
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getMetadataRepositoryStructuredView_Location()
	 * @model unsettable="true" dataType="org.eclipse.cbi.p2repo.p2.URI" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	URI getLocation();

	/**
	 * Returns the value of the '<em><b>Metadata Repository</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metadata Repository</em>' containment reference.
	 * @see #setMetadataRepository(MetadataRepository)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getMetadataRepositoryStructuredView_MetadataRepository()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	MetadataRepository getMetadataRepository();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#getMetadataRepository <em>Metadata Repository</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metadata Repository</em>' containment reference.
	 * @see #getMetadataRepository()
	 * @generated
	 */
	void setMetadataRepository(MetadataRepository value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getMetadataRepositoryStructuredView_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' containment reference.
	 * @see #setProperties(Properties)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getMetadataRepositoryStructuredView_Properties()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Properties getProperties();

	/**
	 * Returns the value of the '<em><b>Repository References</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Repository References</em>' reference.
	 * @see #setRepositoryReferences(RepositoryReferences)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getMetadataRepositoryStructuredView_RepositoryReferences()
	 * @model
	 * @generated
	 */
	RepositoryReferences getRepositoryReferences();

	/**
	 * Returns the value of the '<em><b>Loaded</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loaded</em>' attribute.
	 * @see #setLoaded(boolean)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getMetadataRepositoryStructuredView_Loaded()
	 * @model
	 * @generated
	 */
	boolean isLoaded();

	/**
	 * Returns whether the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#getLocation <em>Location</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Location</em>' attribute is set.
	 * @see #getLocation()
	 * @generated
	 */
	boolean isSetLocation();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#getInstallableUnitList <em>Installable Unit List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installable Unit List</em>' containment reference.
	 * @see #getInstallableUnitList()
	 * @generated
	 */
	void setInstallableUnitList(InstallableUnits value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#isLoaded <em>Loaded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loaded</em>' attribute.
	 * @see #isLoaded()
	 * @generated
	 */
	void setLoaded(boolean value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#getProperties <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Properties</em>' containment reference.
	 * @see #getProperties()
	 * @generated
	 */
	void setProperties(Properties value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView#getRepositoryReferences <em>Repository References</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Repository References</em>' reference.
	 * @see #getRepositoryReferences()
	 * @generated
	 */
	void setRepositoryReferences(RepositoryReferences value);

} // MetadataRepositoryStructuredView
