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
package org.eclipse.cbi.p2repo.aggregator;

import org.eclipse.cbi.p2repo.p2.MetadataRepository;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Metadata Repository Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference#getMetadataRepository <em>Metadata Repository</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference#getNature <em>Nature</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMetadataRepositoryReference()
 * @model
 * @generated
 */
public interface MetadataRepositoryReference extends EnabledStatusProvider, StatusProvider, InfosProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void cancelRepositoryLoad();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Aggregation getAggregation();

	/**
	 * Returns the value of the '<em><b>Location</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Location</em>' attribute.
	 * @see #setLocation(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMetadataRepositoryReference_Location()
	 * @model required="true"
	 * @generated
	 */
	String getLocation();

	/**
	 * Returns the value of the '<em><b>Metadata Repository</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Metadata Repository</em>' reference.
	 * @see #setMetadataRepository(MetadataRepository)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMetadataRepositoryReference_MetadataRepository()
	 * @model transient="true"
	 * @generated
	 */
	MetadataRepository getMetadataRepository();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference#getMetadataRepository <em>Metadata Repository</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Metadata Repository</em>' reference.
	 * @see #getMetadataRepository()
	 * @generated
	 */
	void setMetadataRepository(MetadataRepository value);

	/**
	 * Returns the value of the '<em><b>Metadata Repository</b></em>' reference.
	 *
	 *
	 * @return the value of the '<em>Metadata Repository</em>' reference.
	 * @see #setMetadataRepository(MetadataRepository)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMetadataRepositoryReference_MetadataRepository()
	 * @model transient="true"
	 * @generated NOT
	 */
	MetadataRepository getMetadataRepository(boolean forceResolve);

	/**
	 * Returns the value of the '<em><b>Nature</b></em>' attribute.
	 * The default value is <code>"p2"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nature</em>' attribute.
	 * @see #setNature(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMetadataRepositoryReference_Nature()
	 * @model default="p2" required="true"
	 * @generated
	 */
	String getNature();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getResolvedLocation();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	@Override
	boolean isBranchEnabled();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void onRepositoryLoad();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference#getLocation <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Location</em>' attribute.
	 * @see #getLocation()
	 * @generated
	 */
	void setLocation(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference#getNature <em>Nature</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nature</em>' attribute.
	 * @see #getNature()
	 * @generated
	 */
	void setNature(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void startRepositoryLoad(boolean forceReload);

} // MetadataRepositoryReference
