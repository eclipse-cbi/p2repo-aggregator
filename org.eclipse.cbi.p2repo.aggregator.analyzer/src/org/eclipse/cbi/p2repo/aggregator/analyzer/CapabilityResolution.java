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

import java.util.Comparator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.equinox.p2.metadata.IRequirement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capability Resolution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution#getCapability <em>Capability</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution#getRequirement <em>Requirement</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getCapabilityResolution()
 * @model
 * @generated
 */
public interface CapabilityResolution extends EObject {

	Comparator<CapabilityResolution> CAPABILITY_RESOLUTION_COMPARATOR = new Comparator<CapabilityResolution>() {
		public int compare(CapabilityResolution cr1, CapabilityResolution cr2) {
			RequirementAnalysis ra1 = cr1.getRequirement();
			RequirementAnalysis ra2 = cr2.getRequirement();
			InstallableUnitAnalysis iua1 = ra1.getInstallableUnit();
			InstallableUnitAnalysis iua2 = ra2.getInstallableUnit();
			int result = InstallableUnitAnalysis.INSTALLABLE_UNIT_ANALYIS_COMPARATOR.compare(iua1, iua2);
			if (result == 0) {
				IRequirement r1 = ra1.getRequirement();
				IRequirement r2 = ra2.getRequirement();
				result = RequirementAnalysis.REQUIREMENT_COMPARATOR.compare(r1, r2);
			}
			return result;
		}
	};

	/**
	 * Returns the value of the '<em><b>Capability</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis#getResolutions <em>Resolutions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability</em>' container reference.
	 * @see #setCapability(CapabilityAnalysis)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getCapabilityResolution_Capability()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis#getResolutions
	 * @model opposite="resolutions" transient="false"
	 * @generated
	 */
	CapabilityAnalysis getCapability();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution#getCapability <em>Capability</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability</em>' container reference.
	 * @see #getCapability()
	 * @generated
	 */
	void setCapability(CapabilityAnalysis value);

	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' reference.
	 * @see #setRequirement(RequirementAnalysis)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getCapabilityResolution_Requirement()
	 * @model required="true"
	 * @generated
	 */
	RequirementAnalysis getRequirement();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution#getRequirement <em>Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' reference.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(RequirementAnalysis value);

} // CapabilityResolution
