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
package org.eclipse.cbi.p2repo.aggregator.analyzer.util;

import org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage;
import org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository;
import org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Project;
import org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage
 * @generated
 */
public class AnalyzerSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AnalyzerPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalyzerSwitch() {
		if (modelPackage == null) {
			modelPackage = AnalyzerPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case AnalyzerPackage.ANALYSIS: {
				Analysis analysis = (Analysis) theEObject;
				T result = caseAnalysis(analysis);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS: {
				ContributionAnalysis contributionAnalysis = (ContributionAnalysis) theEObject;
				T result = caseContributionAnalysis(contributionAnalysis);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS: {
				InstallableUnitAnalysis installableUnitAnalysis = (InstallableUnitAnalysis) theEObject;
				T result = caseInstallableUnitAnalysis(installableUnitAnalysis);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AnalyzerPackage.REQUIREMENT_ANALYSIS: {
				RequirementAnalysis requirementAnalysis = (RequirementAnalysis) theEObject;
				T result = caseRequirementAnalysis(requirementAnalysis);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AnalyzerPackage.REQUIREMENT_RESOLUTION: {
				RequirementResolution requirementResolution = (RequirementResolution) theEObject;
				T result = caseRequirementResolution(requirementResolution);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AnalyzerPackage.CAPABILITY_ANALYSIS: {
				CapabilityAnalysis capabilityAnalysis = (CapabilityAnalysis) theEObject;
				T result = caseCapabilityAnalysis(capabilityAnalysis);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AnalyzerPackage.CAPABILITY_RESOLUTION: {
				CapabilityResolution capabilityResolution = (CapabilityResolution) theEObject;
				T result = caseCapabilityResolution(capabilityResolution);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AnalyzerPackage.PROJECT: {
				Project project = (Project) theEObject;
				T result = caseProject(project);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AnalyzerPackage.GIT_REPOSITORY: {
				GitRepository gitRepository = (GitRepository) theEObject;
				T result = caseGitRepository(gitRepository);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analysis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnalysis(Analysis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contribution Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contribution Analysis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContributionAnalysis(ContributionAnalysis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Installable Unit Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Installable Unit Analysis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstallableUnitAnalysis(InstallableUnitAnalysis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement Analysis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirementAnalysis(RequirementAnalysis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement Resolution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequirementResolution(RequirementResolution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability Analysis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCapabilityAnalysis(CapabilityAnalysis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Capability Resolution</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Capability Resolution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCapabilityResolution(CapabilityResolution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Project</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Project</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProject(Project object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Git Repository</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Git Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGitRepository(GitRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //AnalyzerSwitch
