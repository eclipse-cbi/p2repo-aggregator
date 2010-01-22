/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 * $Id$
 */
package org.eclipse.b3.aggregator;

import org.eclipse.b3.aggregator.p2.InstallableUnit;
import org.eclipse.equinox.internal.provisional.p2.metadata.Version;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Installable Unit Reference</b></em>'. <!--
 * end-user-doc -->
 * 
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link org.eclipse.b3.aggregator.InstallableUnitReference#getInstallableUnit <em>Installable Unit</em>}</li>
 * </ul>
 * </p>
 * 
 * @see org.eclipse.b3.aggregator.AggregatorPackage#getInstallableUnitReference()
 * @model abstract="true"
 * @generated
 */
public interface InstallableUnitReference extends StatusProvider, InfosProvider {
	/**
	 * Returns the value of the '<em><b>Installable Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Installable Unit</em>' reference isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Installable Unit</em>' reference.
	 * @see #setInstallableUnit(InstallableUnit)
	 * @see org.eclipse.b3.aggregator.AggregatorPackage#getInstallableUnitReference_InstallableUnit()
	 * @model keys="id version"
	 * @generated
	 */
	InstallableUnit getInstallableUnit();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model
	 * @generated
	 */
	InstallableUnit getInstallableUnit(boolean forceResolve);

	/**
	 * Returns the latest available version in the corresponding MDR
	 */
	Version getLatestVersion();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation"
	 * @generated NOT
	 */
	boolean isBranchDisabledOrMappedRepositoryBroken();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation"
	 * @generated
	 */
	boolean isBranchEnabled();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @model kind="operation"
	 * @generated
	 */
	boolean isMappedRepositoryBroken();

	/**
	 * Sets the value of the '{@link org.eclipse.b3.aggregator.InstallableUnitReference#getInstallableUnit
	 * <em>Installable Unit</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value
	 *            the new value of the '<em>Installable Unit</em>' reference.
	 * @see #getInstallableUnit()
	 * @generated
	 */
	void setInstallableUnit(InstallableUnit value);

} // InstallableUnitReference
