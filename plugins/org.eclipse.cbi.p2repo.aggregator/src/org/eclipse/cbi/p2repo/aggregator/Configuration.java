/**
 * Copyright (c) 2021 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator;

import org.eclipse.emf.common.util.EMap;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Configuration#getOperatingSystem <em>Operating System</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Configuration#getWindowSystem <em>Window System</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Configuration#getArchitecture <em>Architecture</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Configuration#getProperties <em>Properties</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getConfiguration()
 * @model
 * @generated
 */
public interface Configuration extends EnabledStatusProvider {
	/**
	 * Returns the value of the '<em><b>Architecture</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.cbi.p2repo.aggregator.Architecture}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Architecture</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.Architecture
	 * @see #setArchitecture(Architecture)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getConfiguration_Architecture()
	 * @model required="true"
	 * @generated
	 */
	Architecture getArchitecture();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Operating System</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.cbi.p2repo.aggregator.OperatingSystem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operating System</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.OperatingSystem
	 * @see #setOperatingSystem(OperatingSystem)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getConfiguration_OperatingSystem()
	 * @model required="true"
	 * @generated
	 */
	OperatingSystem getOperatingSystem();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getOSGiEnvironmentString();

	/**
	 * Returns the value of the '<em><b>Window System</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.cbi.p2repo.aggregator.WindowSystem}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Window System</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.WindowSystem
	 * @see #setWindowSystem(WindowSystem)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getConfiguration_WindowSystem()
	 * @model required="true"
	 * @generated
	 */
	WindowSystem getWindowSystem();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Configuration#getArchitecture <em>Architecture</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Architecture</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.Architecture
	 * @see #getArchitecture()
	 * @generated
	 */
	void setArchitecture(Architecture value);

	/**
	 * Returns the value of the '<em><b>Properties</b></em>' map.
	 * The key is of type {@link java.lang.String},
	 * and the value is of type {@link java.lang.String},
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Properties</em>' map.
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getConfiguration_Properties()
	 * @model mapType="org.eclipse.cbi.p2repo.p2.Property&lt;org.eclipse.emf.ecore.EString, org.eclipse.emf.ecore.EString&gt;"
	 * @generated
	 */
	EMap<String, String> getProperties();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Configuration#getOperatingSystem <em>Operating System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operating System</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.OperatingSystem
	 * @see #getOperatingSystem()
	 * @generated
	 */
	void setOperatingSystem(OperatingSystem value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Configuration#getWindowSystem <em>Window System</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Window System</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.WindowSystem
	 * @see #getWindowSystem()
	 * @generated
	 */
	void setWindowSystem(WindowSystem value);

} // Configuration
