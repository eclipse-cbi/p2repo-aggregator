/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.aggregator;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Property</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Property#getKey <em>Key</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.Property#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getProperty()
 * @model superTypes="org.eclipse.cbi.p2repo.p2.Comparable&lt;org.eclipse.cbi.p2repo.aggregator.Property&gt;"
 * @generated
 */
public interface Property extends Comparable<Property> {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' attribute.
	 * @see #setKey(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getProperty_Key()
	 * @model required="true"
	 * @generated
	 */
	String getKey();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getProperty_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Property#getKey <em>Key</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @param value
	 *            the new value of the '<em>Key</em>' attribute.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.Property#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // Property
