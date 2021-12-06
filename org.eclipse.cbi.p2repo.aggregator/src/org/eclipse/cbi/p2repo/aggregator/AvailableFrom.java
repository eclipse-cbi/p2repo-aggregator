/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Available From</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getAvailableFrom()
 * @model
 * @generated
 */
public enum AvailableFrom implements Enumerator {
	/**
	 * The '<em><b>REPOSITORY</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPOSITORY_VALUE
	 * @generated
	 * @ordered
	 */
	REPOSITORY(0, "REPOSITORY", "repository"),

	/**
	 * The '<em><b>CONTRIBUTION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTRIBUTION_VALUE
	 * @generated
	 * @ordered
	 */
	CONTRIBUTION(1, "CONTRIBUTION", "contribution"),

	/**
	 * The '<em><b>VALIDATION SET</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALIDATION_SET_VALUE
	 * @generated
	 * @ordered
	 */
	VALIDATION_SET(2, "VALIDATION_SET", "validationSet"),
	/**
	 * The '<em><b>AGGREGATION</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGGREGATION_VALUE
	 * @generated
	 * @ordered
	 */
	AGGREGATION(3, "AGGREGATION", "aggregation");

	/**
	 * The '<em><b>REPOSITORY</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #REPOSITORY
	 * @model literal="repository"
	 * @generated
	 * @ordered
	 */
	public static final int REPOSITORY_VALUE = 0;

	/**
	 * The '<em><b>CONTRIBUTION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #CONTRIBUTION
	 * @model literal="contribution"
	 * @generated
	 * @ordered
	 */
	public static final int CONTRIBUTION_VALUE = 1;

	/**
	 * The '<em><b>VALIDATION SET</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #VALIDATION_SET
	 * @model literal="validationSet"
	 * @generated
	 * @ordered
	 */
	public static final int VALIDATION_SET_VALUE = 2;

	/**
	 * The '<em><b>AGGREGATION</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AGGREGATION
	 * @model literal="aggregation"
	 * @generated
	 * @ordered
	 */
	public static final int AGGREGATION_VALUE = 3;

	/**
	 * An array of all the '<em><b>Available From</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AvailableFrom[] VALUES_ARRAY = new AvailableFrom[] { REPOSITORY, CONTRIBUTION, VALIDATION_SET,
			AGGREGATION, };

	/**
	 * A public read-only list of all the '<em><b>Available From</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AvailableFrom> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Available From</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AvailableFrom get(int value) {
		switch (value) {
			case REPOSITORY_VALUE:
				return REPOSITORY;
			case CONTRIBUTION_VALUE:
				return CONTRIBUTION;
			case VALIDATION_SET_VALUE:
				return VALIDATION_SET;
			case AGGREGATION_VALUE:
				return AGGREGATION;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Available From</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AvailableFrom get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AvailableFrom result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Available From</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AvailableFrom getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AvailableFrom result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AvailableFrom(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
		return value;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // AvailableFrom
