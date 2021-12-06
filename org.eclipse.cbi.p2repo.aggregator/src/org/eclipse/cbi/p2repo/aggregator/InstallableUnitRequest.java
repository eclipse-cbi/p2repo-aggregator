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

import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.VersionRange;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Installable Unit Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getVersionRange <em>Version Range</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getAvailableVersionsHeader <em>Available Versions Header</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getAvailableVersions <em>Available Versions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getInstallableUnitRequest()
 * @model abstract="true"
 * @generated
 */
public interface InstallableUnitRequest extends StatusProvider, InfosProvider, DescriptionProvider {
	/**
	 * Returns the value of the '<em><b>Available Versions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.AvailableVersion}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Versions</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getInstallableUnitRequest_AvailableVersions()
	 * @model containment="true" transient="true"
	 * @generated
	 */
	EList<AvailableVersion> getAvailableVersions();

	/**
	 * Returns the value of the '<em><b>Available Versions Header</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader#getInstallableUnitRequest <em>Installable Unit Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Available Versions Header</em>' containment reference.
	 * @see #setAvailableVersionsHeader(AvailableVersionsHeader)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getInstallableUnitRequest_AvailableVersionsHeader()
	 * @see org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader#getInstallableUnitRequest
	 * @model opposite="installableUnitRequest" containment="true" transient="true"
	 * @generated
	 */
	AvailableVersionsHeader getAvailableVersionsHeader();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getInstallableUnitRequest_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Version Range</b></em>' attribute.
	 * The default value is <code>"0.0.0"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Range</em>' attribute.
	 * @see #setVersionRange(VersionRange)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getInstallableUnitRequest_VersionRange()
	 * @model default="0.0.0" dataType="org.eclipse.cbi.p2repo.p2.VersionRange"
	 * @generated
	 */
	VersionRange getVersionRange();

	/**
	 *
	 *
	 * @model kind="operation"
	 * @generated NOT
	 */
	boolean isBranchDisabledOrMappedRepositoryBroken();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isBranchEnabled();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isMappedRepositoryBroken();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model type="org.eclipse.cbi.p2repo.p2.IInstallableUnit"
	 * @generated
	 */
	IInstallableUnit resolveAsSingleton();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model type="org.eclipse.cbi.p2repo.p2.IInstallableUnit"
	 * @generated
	 */
	IInstallableUnit resolveAsSingleton(boolean forceResolve);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model updateOnlyDataType="org.eclipse.emf.ecore.xml.type.Boolean"
	 * @generated
	 */
	void resolveAvailableVersions(boolean updateOnly);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getAvailableVersionsHeader <em>Available Versions Header</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Available Versions Header</em>' containment reference.
	 * @see #getAvailableVersionsHeader()
	 * @generated
	 */
	void setAvailableVersionsHeader(AvailableVersionsHeader value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest#getVersionRange <em>Version Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Range</em>' attribute.
	 * @see #getVersionRange()
	 * @generated
	 */
	void setVersionRange(VersionRange value);

} // InstallableUnitReference
