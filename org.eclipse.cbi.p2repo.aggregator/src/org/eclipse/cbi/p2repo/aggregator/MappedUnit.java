/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.aggregator;

import org.eclipse.emf.common.util.EList;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Mapped Unit</b></em>'.
 *
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MappedUnit#getValidConfigurations <em>Valid Configurations</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMappedUnit()
 * @model abstract="true"
 * @generated
 */
public interface MappedUnit extends InstallableUnitRequest, EnabledStatusProvider, IdentificationProvider {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="org.eclipse.cbi.p2repo.p2.IMatchExpression<org.eclipse.cbi.p2repo.p2.IInstallableUnit>"
	 * @generated
	 */
	IMatchExpression<IInstallableUnit> getFilter();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" type="org.eclipse.cbi.p2repo.p2.IRequirement"
	 * @generated
	 */
	IRequirement getRequirement();

	/**
	 * Returns the value of the '<em><b>Valid Configurations</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.Configuration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Valid Configurations</em>' reference list isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Valid Configurations</em>' reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMappedUnit_ValidConfigurations()
	 * @model keys="operatingSystem windowSystem architecture"
	 * @generated
	 */
	EList<Configuration> getValidConfigurations();

} // MappedUnit
