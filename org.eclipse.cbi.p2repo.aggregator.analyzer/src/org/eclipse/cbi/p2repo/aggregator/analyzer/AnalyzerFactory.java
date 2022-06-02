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

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage
 * @generated
 */
public interface AnalyzerFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnalyzerFactory eINSTANCE = org.eclipse.cbi.p2repo.aggregator.analyzer.impl.AnalyzerFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Analysis</em>'.
	 * @generated
	 */
	Analysis createAnalysis();

	/**
	 * Returns a new object of class '<em>Contribution Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Contribution Analysis</em>'.
	 * @generated
	 */
	ContributionAnalysis createContributionAnalysis();

	/**
	 * Returns a new object of class '<em>Installable Unit Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Installable Unit Analysis</em>'.
	 * @generated
	 */
	InstallableUnitAnalysis createInstallableUnitAnalysis();

	/**
	 * Returns a new object of class '<em>Requirement Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Requirement Analysis</em>'.
	 * @generated
	 */
	RequirementAnalysis createRequirementAnalysis();

	/**
	 * Returns a new object of class '<em>Requirement Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Requirement Resolution</em>'.
	 * @generated
	 */
	RequirementResolution createRequirementResolution();

	/**
	 * Returns a new object of class '<em>Capability Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Capability Analysis</em>'.
	 * @generated
	 */
	CapabilityAnalysis createCapabilityAnalysis();

	/**
	 * Returns a new object of class '<em>Capability Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Capability Resolution</em>'.
	 * @generated
	 */
	CapabilityResolution createCapabilityResolution();

	/**
	 * Returns a new object of class '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Project</em>'.
	 * @generated
	 */
	Project createProject();

	/**
	 * Returns a new object of class '<em>Git Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Git Repository</em>'.
	 * @generated
	 */
	GitRepository createGitRepository();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AnalyzerPackage getAnalyzerPackage();

} //AnalyzerFactory
