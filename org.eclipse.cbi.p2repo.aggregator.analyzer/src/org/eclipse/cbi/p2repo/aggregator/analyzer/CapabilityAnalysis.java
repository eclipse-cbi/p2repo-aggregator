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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.equinox.p2.metadata.IProvidedCapability;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Capability Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A wrapper of a capability.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis#getInstallableUnit <em>Installable Unit</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis#getCapability <em>Capability</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis#getResolutions <em>Resolutions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getCapabilityAnalysis()
 * @model
 * @generated
 */
public interface CapabilityAnalysis extends EObject {
	/**
	 * Returns the value of the '<em><b>Installable Unit</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis#getCapabilities <em>Capabilities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installable Unit</em>' container reference.
	 * @see #setInstallableUnit(InstallableUnitAnalysis)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getCapabilityAnalysis_InstallableUnit()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis#getCapabilities
	 * @model opposite="capabilities" transient="false"
	 * @generated
	 */
	InstallableUnitAnalysis getInstallableUnit();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis#getInstallableUnit <em>Installable Unit</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installable Unit</em>' container reference.
	 * @see #getInstallableUnit()
	 * @generated
	 */
	void setInstallableUnit(InstallableUnitAnalysis value);

	/**
	 * Returns the value of the '<em><b>Capability</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capability</em>' reference.
	 * @see #setCapability(IProvidedCapability)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getCapabilityAnalysis_Capability()
	 * @model type="org.eclipse.cbi.p2repo.p2.IProvidedCapability" required="true"
	 * @generated
	 */
	IProvidedCapability getCapability();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis#getCapability <em>Capability</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Capability</em>' reference.
	 * @see #getCapability()
	 * @generated
	 */
	void setCapability(IProvidedCapability value);

	/**
	 * Returns the value of the '<em><b>Resolutions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution#getCapability <em>Capability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolutions</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getCapabilityAnalysis_Resolutions()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution#getCapability
	 * @model opposite="capability" containment="true"
	 * @generated
	 */
	EList<CapabilityResolution> getResolutions();

} // CapabilityAnalysis
