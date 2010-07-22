/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.b3.aggregator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc --> A representation of the literals of the enumeration '<em><b>Operating System</b></em>', and
 * utility methods for working with them. <!-- end-user-doc -->
 * 
 * @see org.eclipse.b3.aggregator.AggregatorPackage#getOperatingSystem()
 * @model
 * @generated
 */
public enum OperatingSystem implements Enumerator {
	/**
	 * The '<em><b>Win32</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #WIN32_VALUE
	 * @generated
	 * @ordered
	 */
	WIN32(0, "Win32", "win32"),

	/**
	 * The '<em><b>Linux</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #LINUX_VALUE
	 * @generated
	 * @ordered
	 */
	LINUX(1, "Linux", "linux"),

	/**
	 * The '<em><b>Mac OSX</b></em>' literal object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #MAC_OSX_VALUE
	 * @generated
	 * @ordered
	 */
	MAC_OSX(2, "MacOSX", "macosx"), /**
	 * The '<em><b>AIX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #AIX_VALUE
	 * @generated
	 * @ordered
	 */
	AIX(3, "AIX", "aix"), /**
	 * The '<em><b>HPUX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #HPUX_VALUE
	 * @generated
	 * @ordered
	 */
	HPUX(4, "HPUX", "hpux"), /**
	 * The '<em><b>Solaris</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #SOLARIS_VALUE
	 * @generated
	 * @ordered
	 */
	SOLARIS(5, "Solaris", "solaris"), /**
	 * The '<em><b>QNX</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #QNX_VALUE
	 * @generated
	 * @ordered
	 */
	QNX(6, "QNX", "qnx");

	/**
	 * The '<em><b>Win32</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Win32</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #WIN32
	 * @model name="Win32" literal="win32"
	 * @generated
	 * @ordered
	 */
	public static final int WIN32_VALUE = 0;

	/**
	 * The '<em><b>Linux</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Linux</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #LINUX
	 * @model name="Linux" literal="linux"
	 * @generated
	 * @ordered
	 */
	public static final int LINUX_VALUE = 1;

	/**
	 * The '<em><b>Mac OSX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Mac OSX</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #MAC_OSX
	 * @model name="MacOSX" literal="macosx"
	 * @generated
	 * @ordered
	 */
	public static final int MAC_OSX_VALUE = 2;

	/**
	 * The '<em><b>AIX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>AIX</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #AIX
	 * @model literal="aix"
	 * @generated
	 * @ordered
	 */
	public static final int AIX_VALUE = 3;

	/**
	 * The '<em><b>HPUX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>HPUX</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #HPUX
	 * @model literal="hpux"
	 * @generated
	 * @ordered
	 */
	public static final int HPUX_VALUE = 4;

	/**
	 * The '<em><b>Solaris</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>Solaris</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #SOLARIS
	 * @model name="Solaris" literal="solaris"
	 * @generated
	 * @ordered
	 */
	public static final int SOLARIS_VALUE = 5;

	/**
	 * The '<em><b>QNX</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of '<em><b>QNX</b></em>' literal object isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @see #QNX
	 * @model literal="qnx"
	 * @generated
	 * @ordered
	 */
	public static final int QNX_VALUE = 6;

	/**
	 * An array of all the '<em><b>Operating System</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private static final OperatingSystem[] VALUES_ARRAY = new OperatingSystem[] {
			WIN32, LINUX, MAC_OSX, AIX, HPUX, SOLARIS, QNX, };

	/**
	 * A public read-only list of all the '<em><b>Operating System</b></em>' enumerators.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static final List<OperatingSystem> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Operating System</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static OperatingSystem get(int value) {
		switch(value) {
			case WIN32_VALUE:
				return WIN32;
			case LINUX_VALUE:
				return LINUX;
			case MAC_OSX_VALUE:
				return MAC_OSX;
			case AIX_VALUE:
				return AIX;
			case HPUX_VALUE:
				return HPUX;
			case SOLARIS_VALUE:
				return SOLARIS;
			case QNX_VALUE:
				return QNX;
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operating System</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static OperatingSystem get(String literal) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			OperatingSystem result = VALUES_ARRAY[i];
			if(result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Operating System</b></em>' literal with the specified name.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	public static OperatingSystem getByName(String name) {
		for(int i = 0; i < VALUES_ARRAY.length; ++i) {
			OperatingSystem result = VALUES_ARRAY[i];
			if(result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	private OperatingSystem(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getLiteral() {
		return literal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}

} // OperatingSystem
