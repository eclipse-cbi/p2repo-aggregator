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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Installable Unit Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A wrapper of an installable unit.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis#getContribution <em>Contribution</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis#getInstallableUnit <em>Installable Unit</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis#getCapabilities <em>Capabilities</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getInstallableUnitAnalysis()
 * @model
 * @generated
 */
public interface InstallableUnitAnalysis extends EObject {

	/**
	 * Compares two {@link InstallableUnitAnalysis} instances by {@link IInstallableUnit#compareTo(IInstallableUnit) comparing} the {@link #getInstallableUnit() underlying} {@link IInstallableUnit}.
	 */
	Comparator<InstallableUnitAnalysis> INSTALLABLE_UNIT_ANALYIS_COMPARATOR = new Comparator<InstallableUnitAnalysis>() {
		public int compare(InstallableUnitAnalysis iua1, InstallableUnitAnalysis iua2) {
			IInstallableUnit iu1 = iua1.getInstallableUnit();
			IInstallableUnit iu2 = iua2.getInstallableUnit();
			if (iu1 == iu2) {
				return 0;
			}
			if (iu1 == null) {
				return -1;
			}
			return iu1.compareTo(iu2);
		}
	};

	/**
	 * Returns the value of the '<em><b>Contribution</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#getInstallableUnits <em>Installable Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Contribution</em>' container reference.
	 * @see #setContribution(ContributionAnalysis)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getInstallableUnitAnalysis_Contribution()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis#getInstallableUnits
	 * @model opposite="installableUnits" transient="false"
	 * @generated
	 */
	ContributionAnalysis getContribution();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis#getContribution <em>Contribution</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Contribution</em>' container reference.
	 * @see #getContribution()
	 * @generated
	 */
	void setContribution(ContributionAnalysis value);

	/**
	 * Returns the value of the '<em><b>Installable Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installable Unit</em>' reference.
	 * @see #setInstallableUnit(IInstallableUnit)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getInstallableUnitAnalysis_InstallableUnit()
	 * @model type="org.eclipse.cbi.p2repo.p2.IInstallableUnit" required="true"
	 * @generated
	 */
	IInstallableUnit getInstallableUnit();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis#getInstallableUnit <em>Installable Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installable Unit</em>' reference.
	 * @see #getInstallableUnit()
	 * @generated
	 */
	void setInstallableUnit(IInstallableUnit value);

	/**
	 * Returns the value of the '<em><b>Requirements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis#getInstallableUnit <em>Installable Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirements</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getInstallableUnitAnalysis_Requirements()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis#getInstallableUnit
	 * @model opposite="installableUnit" containment="true"
	 *        extendedMetaData="kind='element' name='requirement'"
	 * @generated
	 */
	EList<RequirementAnalysis> getRequirements();

	/**
	 * Returns the value of the '<em><b>Capabilities</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis#getInstallableUnit <em>Installable Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capabilities</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getInstallableUnitAnalysis_Capabilities()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis#getInstallableUnit
	 * @model opposite="installableUnit" containment="true"
	 *        extendedMetaData="kind='element' name='capability'"
	 * @generated
	 */
	EList<CapabilityAnalysis> getCapabilities();

} // InstallableUnitAnalysis
