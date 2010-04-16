/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 * $Id$
 */
package org.eclipse.b3.aggregator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Version Match</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * 
 * @see org.eclipse.b3.aggregator.AggregatorPackage#getVersionMatch()
 * @model
 * @generated
 */
public enum VersionMatch implements Enumerator {
	/**
	 * The '<em><b>BELOW</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #BELOW_VALUE
	 * @generated
	 * @ordered
	 */
	BELOW(0, "BELOW", "below"),

	/**
	 * The '<em><b>MATCHES</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #MATCHES_VALUE
	 * @generated
	 * @ordered
	 */
	MATCHES(1, "MATCHES", "matches"),

	/**
	 * The '<em><b>ABOVE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #ABOVE_VALUE
	 * @generated
	 * @ordered
	 */
	ABOVE(2, "ABOVE", "above");

	/**
	 * The '<em><b>BELOW</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>BELOW</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #BELOW
	 * @model literal="below"
	 * @generated
	 * @ordered
	 */
	public static final int BELOW_VALUE = 0;

	/**
	 * The '<em><b>MATCHES</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>MATCHES</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #MATCHES
	 * @model literal="matches"
	 * @generated
	 * @ordered
	 */
	public static final int MATCHES_VALUE = 1;

	/**
	 * The '<em><b>ABOVE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>ABOVE</b></em>' literal object isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #ABOVE
	 * @model literal="above"
	 * @generated
	 * @ordered
	 */
	public static final int ABOVE_VALUE = 2;

	/**
	 * An array of all the '<em><b>Version Match</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final VersionMatch[] VALUES_ARRAY = new VersionMatch[] { BELOW, MATCHES, ABOVE, };

	/**
	 * A public read-only list of all the '<em><b>Version Match</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<VersionMatch> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Version Match</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static VersionMatch get(int value) {
		switch(value) {
			case BELOW_VALUE:
				return BELOW;
			case MATCHES_VALUE:
				return MATCHES;
			case ABOVE_VALUE:
				return ABOVE;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Version Match</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static VersionMatch get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			VersionMatch result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Version Match</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static VersionMatch getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			VersionMatch result = VALUES_ARRAY[i];
			if(result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private VersionMatch(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // VersionMatch
