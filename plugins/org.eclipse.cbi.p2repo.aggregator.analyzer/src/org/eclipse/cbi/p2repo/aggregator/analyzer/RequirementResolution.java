/**
 * Copyright (c) 2021 Eclipse Foundation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.analyzer;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement Resolution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution#getInstallableUnit <em>Installable Unit</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution#getCapability <em>Capability</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getRequirementResolution()
 * @model
 * @generated
 */
public interface RequirementResolution extends EObject {
	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis#getResolutions <em>Resolutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' container reference.
	 * @see #setRequirement(RequirementAnalysis)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getRequirementResolution_Requirement()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis#getResolutions
	 * @model opposite="resolutions" transient="false"
	 * @generated
	 */
	RequirementAnalysis getRequirement();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution#getRequirement <em>Requirement</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' container reference.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(RequirementAnalysis value);

	/**
	 * Returns the value of the '<em><b>Installable Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installable Unit</em>' reference.
	 * @see #setInstallableUnit(InstallableUnitAnalysis)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getRequirementResolution_InstallableUnit()
	 * @model required="true"
	 * @generated
	 */
	InstallableUnitAnalysis getInstallableUnit();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution#getInstallableUnit <em>Installable Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installable Unit</em>' reference.
	 * @see #getInstallableUnit()
	 * @generated
	 */
	void setInstallableUnit(InstallableUnitAnalysis value);

	/**
	 * Returns the value of the '<em><b>Capability</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability</em>' reference.
	 * @see #setCapability(CapabilityAnalysis)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getRequirementResolution_Capability()
	 * @model
	 * @generated
	 */
	CapabilityAnalysis getCapability();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution#getCapability <em>Capability</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability</em>' reference.
	 * @see #getCapability()
	 * @generated
	 */
	void setCapability(CapabilityAnalysis value);

} // RequirementResolution
