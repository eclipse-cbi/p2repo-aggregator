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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Architecture</b></em>', and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getArchitecture()
 * @model
 * @generated
 */
public enum Architecture implements Enumerator {
	/**
	 * The '<em><b>X86</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #X86_VALUE
	 * @generated
	 * @ordered
	 */
	X86(0, "X86", "x86"),

	/**
	 * The '<em><b>PPC</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PPC_VALUE
	 * @generated
	 * @ordered
	 */
	PPC(1, "PPC", "ppc"),

	/**
	 * The '<em><b>X86 64</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #X86_64_VALUE
	 * @generated
	 * @ordered
	 */
	X86_64(2, "X86_64", "x86_64"),
	/**
	 * The '<em><b>IA64</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IA64_VALUE
	 * @generated
	 * @ordered
	 */
	IA64(3, "IA64", "ia64"),
	/**
	 * The '<em><b>IA64 32</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IA64_32_VALUE
	 * @generated
	 * @ordered
	 */
	IA64_32(4, "IA64_32", "ia64_32"),
	/**
	 * The '<em><b>Sparc</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPARC_VALUE
	 * @generated
	 * @ordered
	 */
	SPARC(5, "Sparc", "sparc"),
	/**
	 * The '<em><b>PPC64</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PPC64_VALUE
	 * @generated
	 * @ordered
	 */
	PPC64(6, "PPC64", "ppc64"),
	/**
	 * The '<em><b>S390</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #S390_VALUE
	 * @generated
	 * @ordered
	 */
	S390(7, "S390", "s390"),
	/**
	 * The '<em><b>S390X</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #S390X_VALUE
	 * @generated
	 * @ordered
	 */
	S390X(8, "S390X", "s390x"),
	/**
	 * The '<em><b>Sparcv9</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPARCV9_VALUE
	 * @generated
	 * @ordered
	 */
	SPARCV9(9, "Sparcv9", "sparcv9"),
	/**
	 * The '<em><b>PPC64LE</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PPC64LE_VALUE
	 * @generated
	 * @ordered
	 */
	PPC64LE(10, "PPC64LE", "ppc64le"),
	/**
	 * The '<em><b>Aarch64</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AARCH64_VALUE
	 * @generated
	 * @ordered
	 */
	AARCH64(11, "aarch64", "aarch64"),
	/**
	 * The '<em><b>Arm64</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARM64_VALUE
	 * @generated
	 * @ordered
	 */
	ARM64(12, "arm64", "arm64");

	/**
	 * The '<em><b>X86</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #X86
	 * @model literal="x86"
	 * @generated
	 * @ordered
	 */
	public static final int X86_VALUE = 0;

	/**
	 * The '<em><b>PPC</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PPC
	 * @model literal="ppc"
	 * @generated
	 * @ordered
	 */
	public static final int PPC_VALUE = 1;

	/**
	 * The '<em><b>X86 64</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #X86_64
	 * @model literal="x86_64"
	 * @generated
	 * @ordered
	 */
	public static final int X86_64_VALUE = 2;

	/**
	 * The '<em><b>IA64</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IA64
	 * @model literal="ia64"
	 * @generated
	 * @ordered
	 */
	public static final int IA64_VALUE = 3;

	/**
	 * The '<em><b>IA64 32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #IA64_32
	 * @model literal="ia64_32"
	 * @generated
	 * @ordered
	 */
	public static final int IA64_32_VALUE = 4;

	/**
	 * The '<em><b>Sparc</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPARC
	 * @model name="Sparc" literal="sparc"
	 * @generated
	 * @ordered
	 */
	public static final int SPARC_VALUE = 5;

	/**
	 * The '<em><b>PPC64</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PPC64
	 * @model literal="ppc64"
	 * @generated
	 * @ordered
	 */
	public static final int PPC64_VALUE = 6;

	/**
	 * The '<em><b>S390</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #S390
	 * @model literal="s390"
	 * @generated
	 * @ordered
	 */
	public static final int S390_VALUE = 7;

	/**
	 * The '<em><b>S390X</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #S390X
	 * @model literal="s390x"
	 * @generated
	 * @ordered
	 */
	public static final int S390X_VALUE = 8;

	/**
	 * The '<em><b>Sparcv9</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #SPARCV9
	 * @model name="Sparcv9" literal="sparcv9"
	 * @generated
	 * @ordered
	 */
	public static final int SPARCV9_VALUE = 9;

	/**
	 * The '<em><b>PPC64LE</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #PPC64LE
	 * @model literal="ppc64le"
	 * @generated
	 * @ordered
	 */
	public static final int PPC64LE_VALUE = 10;

	/**
	 * The '<em><b>Aarch64</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #AARCH64
	 * @model name="aarch64"
	 * @generated
	 * @ordered
	 */
	public static final int AARCH64_VALUE = 11;

	/**
	 * The '<em><b>Arm64</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #ARM64
	 * @model name="arm64"
	 * @generated
	 * @ordered
	 */
	public static final int ARM64_VALUE = 12;

	/**
	 * An array of all the '<em><b>Architecture</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final Architecture[] VALUES_ARRAY = new Architecture[] { X86, PPC, X86_64, IA64, IA64_32, SPARC,
			PPC64, S390, S390X, SPARCV9, PPC64LE, AARCH64, ARM64, };

	/**
	 * A public read-only list of all the '<em><b>Architecture</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<Architecture> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Architecture</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Architecture get(int value) {
		switch (value) {
			case X86_VALUE:
				return X86;
			case PPC_VALUE:
				return PPC;
			case X86_64_VALUE:
				return X86_64;
			case IA64_VALUE:
				return IA64;
			case IA64_32_VALUE:
				return IA64_32;
			case SPARC_VALUE:
				return SPARC;
			case PPC64_VALUE:
				return PPC64;
			case S390_VALUE:
				return S390;
			case S390X_VALUE:
				return S390X;
			case SPARCV9_VALUE:
				return SPARCV9;
			case PPC64LE_VALUE:
				return PPC64LE;
			case AARCH64_VALUE:
				return AARCH64;
			case ARM64_VALUE:
				return ARM64;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Architecture</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Architecture get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Architecture result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Architecture</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static Architecture getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			Architecture result = VALUES_ARRAY[i];
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
	private Architecture(int value, String name, String literal) {
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

} // Architecture
