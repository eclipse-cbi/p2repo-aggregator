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

import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.equinox.internal.p2.metadata.IRequiredCapability;
import org.eclipse.equinox.internal.p2.metadata.RequiredPropertiesMatch;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.metadata.expression.IFilterExpression;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Requirement Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A wrapper of a requirement.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis#getInstallableUnit <em>Installable Unit</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis#getRequirement <em>Requirement</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis#getResolutions <em>Resolutions</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getRequirementAnalysis()
 * @model
 * @generated
 */
public interface RequirementAnalysis extends EObject {
	Comparator<RequirementAnalysis> REQUIREMENT_ANALYSIS_COMPARATOR = new Comparator<RequirementAnalysis>() {
		public int compare(RequirementAnalysis ra1, RequirementAnalysis ra2) {
			if (ra1 == ra2) {
				return 0;
			}
			if (ra1 == null) {
				return -1;
			}
			if (ra2 == null) {
				return 1;
			}
			return REQUIREMENT_COMPARATOR.compare(ra1.getRequirement(), ra2.getRequirement());
		}

	};

	Comparator<IRequirement> REQUIREMENT_COMPARATOR = new Comparator<IRequirement>() {
		private final Comparator<String> comparator = CommonPlugin.INSTANCE.getComparator();

		public int compare(IRequirement r1, IRequirement r2) {
			if (r1 == r2) {
				return 0;
			}
			if (r1 == null) {
				return -1;
			}
			if (r2 == null) {
				return 1;
			}

			int compare;
			if (r1 instanceof IRequiredCapability && r2 instanceof IRequiredCapability) {
				IRequiredCapability rc1 = (IRequiredCapability) r1;
				IRequiredCapability rc2 = (IRequiredCapability) r2;
				String namespace1 = rc1.getNamespace();
				String namespace2 = rc2.getNamespace();
				compare = comparator.compare(namespace1, namespace2);
				if (compare == 0) {
					String name1 = rc1.getName();
					String name2 = rc2.getName();
					compare = comparator.compare(name1, name2);
					if (compare == 0) {
						VersionRange vr1 = rc1.getRange();
						VersionRange vr2 = rc2.getRange();
						compare = VERSION_RANGE_COMPARAOR.compare(vr1, vr2);
					}
				}
			} else {
				IMatchExpression<IInstallableUnit> m1 = r1.getMatches();
				IMatchExpression<IInstallableUnit> m2 = r2.getMatches();
				if (RequiredPropertiesMatch.isPropertiesMatchRequirement(m1)
						&& RequiredPropertiesMatch.isPropertiesMatchRequirement(m2)) {
					String namespace1 = RequiredPropertiesMatch.extractNamespace(m2);
					String namespace2 = RequiredPropertiesMatch.extractNamespace(m2);
					compare = comparator.compare(namespace1, namespace2);
					if (compare == 0) {
						IFilterExpression pm1 = RequiredPropertiesMatch.extractPropertiesMatch(m1);
						IFilterExpression pm2 = RequiredPropertiesMatch.extractPropertiesMatch(m2);
						compare = pm1.toString().compareTo(pm2.toString());
					}
				} else {
					compare = r1.getClass().getName().compareTo(r2.getClass().getName());
				}
			}
			return compare;
		}
	};

	Comparator<VersionRange> VERSION_RANGE_COMPARAOR = new Comparator<VersionRange>() {
		public int compare(VersionRange vr1, VersionRange vr2) {
			if (vr1 == vr2) {
				return 0;
			}
			if (vr1 == null) {
				return -1;
			}

			int result = vr1.getMinimum().compareTo(vr1.getMinimum());
			if (result == 0) {
				result = Boolean.compare(vr1.getIncludeMinimum(), vr2.getIncludeMinimum());
				if (result == 0) {
					result = vr1.getMaximum().compareTo(vr2.getMaximum());
					if (result == 0) {
						result = Boolean.compare(vr1.getIncludeMaximum(), vr2.getIncludeMaximum());
					}
				}
			}
			return result;
		}
	};

	/**
	 * Returns the value of the '<em><b>Requirement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement</em>' reference.
	 * @see #setRequirement(IRequirement)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getRequirementAnalysis_Requirement()
	 * @model type="org.eclipse.cbi.p2repo.p2.IRequirement" required="true"
	 * @generated
	 */
	IRequirement getRequirement();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis#getRequirement <em>Requirement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement</em>' reference.
	 * @see #getRequirement()
	 * @generated
	 */
	void setRequirement(IRequirement value);

	/**
	 * Returns the value of the '<em><b>Installable Unit</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis#getRequirements <em>Requirements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installable Unit</em>' container reference.
	 * @see #setInstallableUnit(InstallableUnitAnalysis)
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getRequirementAnalysis_InstallableUnit()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis#getRequirements
	 * @model opposite="requirements" transient="false"
	 * @generated
	 */
	InstallableUnitAnalysis getInstallableUnit();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis#getInstallableUnit <em>Installable Unit</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installable Unit</em>' container reference.
	 * @see #getInstallableUnit()
	 * @generated
	 */
	void setInstallableUnit(InstallableUnitAnalysis value);

	/**
	 * Returns the value of the '<em><b>Resolutions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution#getRequirement <em>Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resolutions</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage#getRequirementAnalysis_Resolutions()
	 * @see org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementResolution#getRequirement
	 * @model opposite="requirement" containment="true"
	 *        extendedMetaData="kind='element' name='resolution'"
	 * @generated
	 */
	EList<RequirementResolution> getResolutions();

} // RequirementAnalysis
