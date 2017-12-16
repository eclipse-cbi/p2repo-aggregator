/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 */
package org.eclipse.cbi.p2repo.p2;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Mapping
 * Rule</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.MappingRule#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.MappingRule#getOutput <em>Output</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.p2.P2Package#getMappingRule()
 * @model
 * @generated
 */
public interface MappingRule {
	/**
	 * Returns the value of the '<em><b>Filter</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Filter</em>' attribute.
	 * @see #setFilter(String)
	 * @see org.eclipse.cbi.p2repo.p2.P2Package#getMappingRule_Filter()
	 * @model required="true"
	 * @generated
	 */
	String getFilter();

	/**
	 * Returns the value of the '<em><b>Output</b></em>' attribute. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output</em>' attribute isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 *
	 * @return the value of the '<em>Output</em>' attribute.
	 * @see #setOutput(String)
	 * @see org.eclipse.cbi.p2repo.p2.P2Package#getMappingRule_Output()
	 * @model required="true"
	 * @generated
	 */
	String getOutput();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.MappingRule#getFilter <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' attribute.
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.p2.MappingRule#getOutput <em>Output</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Output</em>' attribute.
	 * @see #getOutput()
	 * @generated
	 */
	void setOutput(String value);

} // MappingRule
