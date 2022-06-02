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
package org.eclipse.cbi.p2repo.aggregator.analyzer.impl;

import java.util.Date;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerFactory;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage;
import org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository;
import org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Project;
import org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnalyzerFactoryImpl extends EFactoryImpl implements AnalyzerFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnalyzerFactory init() {
		try {
			AnalyzerFactory theAnalyzerFactory = (AnalyzerFactory) EPackage.Registry.INSTANCE
					.getEFactory(AnalyzerPackage.eNS_URI);
			if (theAnalyzerFactory != null) {
				return theAnalyzerFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AnalyzerFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalyzerFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AnalyzerPackage.ANALYSIS:
				return createAnalysis();
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS:
				return createContributionAnalysis();
			case AnalyzerPackage.INSTALLABLE_UNIT_ANALYSIS:
				return createInstallableUnitAnalysis();
			case AnalyzerPackage.REQUIREMENT_ANALYSIS:
				return createRequirementAnalysis();
			case AnalyzerPackage.REQUIREMENT_RESOLUTION:
				return createRequirementResolution();
			case AnalyzerPackage.CAPABILITY_ANALYSIS:
				return createCapabilityAnalysis();
			case AnalyzerPackage.CAPABILITY_RESOLUTION:
				return createCapabilityResolution();
			case AnalyzerPackage.PROJECT:
				return createProject();
			case AnalyzerPackage.GIT_REPOSITORY:
				return createGitRepository();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case AnalyzerPackage.PATTERN:
				return createPatternFromString(eDataType, initialValue);
			case AnalyzerPackage.URI:
				return createURIFromString(eDataType, initialValue);
			case AnalyzerPackage.DATE:
				return createDateFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException(
						"The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case AnalyzerPackage.PATTERN:
				return convertPatternToString(eDataType, instanceValue);
			case AnalyzerPackage.URI:
				return convertURIToString(eDataType, instanceValue);
			case AnalyzerPackage.DATE:
				return convertDateToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException(
						"The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Analysis createAnalysis() {
		AnalysisImpl analysis = new AnalysisImpl();
		return analysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ContributionAnalysis createContributionAnalysis() {
		ContributionAnalysisImpl contributionAnalysis = new ContributionAnalysisImpl();
		return contributionAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstallableUnitAnalysis createInstallableUnitAnalysis() {
		InstallableUnitAnalysisImpl installableUnitAnalysis = new InstallableUnitAnalysisImpl();
		return installableUnitAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RequirementAnalysis createRequirementAnalysis() {
		RequirementAnalysisImpl requirementAnalysis = new RequirementAnalysisImpl();
		return requirementAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RequirementResolution createRequirementResolution() {
		RequirementResolutionImpl requirementResolution = new RequirementResolutionImpl();
		return requirementResolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CapabilityAnalysis createCapabilityAnalysis() {
		CapabilityAnalysisImpl capabilityAnalysis = new CapabilityAnalysisImpl();
		return capabilityAnalysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CapabilityResolution createCapabilityResolution() {
		CapabilityResolutionImpl capabilityResolution = new CapabilityResolutionImpl();
		return capabilityResolution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Project createProject() {
		ProjectImpl project = new ProjectImpl();
		return project;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public GitRepository createGitRepository() {
		GitRepositoryImpl gitRepository = new GitRepositoryImpl();
		return gitRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Pattern createPatternFromString(EDataType eDataType, String initialValue) {
		return initialValue == null ? null : Pattern.compile(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertPatternToString(EDataType eDataType, Object instanceValue) {
		return instanceValue instanceof Pattern ? ((Pattern) instanceValue).pattern() : null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI createURI(final String it) {
		return it == null ? null : URI.createURI(it);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public URI createURIFromString(EDataType eDataType, String initialValue) {
		return createURI(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertURI(final URI it) {
		return it == null ? null : it.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertURIToString(EDataType eDataType, Object instanceValue) {
		return convertURI((URI) instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date createDateFromString(EDataType eDataType, String initialValue) {
		return (Date) super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String convertDateToString(EDataType eDataType, Object instanceValue) {
		if (instanceValue == null) {
			return null;
		}

		return EDATE_FORMATS[EDATE_FORMATS.length - 1].format(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AnalyzerPackage getAnalyzerPackage() {
		return (AnalyzerPackage) getEPackage();
	}

} //AnalyzerFactoryImpl
