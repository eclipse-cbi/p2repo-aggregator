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

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Maven Item</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.b3.aggregator.MavenItem#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.eclipse.b3.aggregator.MavenItem#getArtifactId <em>Artifact Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.b3.aggregator.AggregatorPackage#getMavenItem()
 * @model
 * @generated
 */
public interface MavenItem
{
	/**
	 * Returns the value of the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Artifact Id</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Artifact Id</em>' attribute.
	 * @see #setArtifactId(String)
	 * @see org.eclipse.b3.aggregator.AggregatorPackage#getMavenItem_ArtifactId()
	 * @model
	 * @generated
	 */
	String getArtifactId();

	/**
	 * Returns the value of the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Group Id</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Id</em>' attribute.
	 * @see #setGroupId(String)
	 * @see org.eclipse.b3.aggregator.AggregatorPackage#getMavenItem_GroupId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getGroupId();

	/**
	 * Sets the value of the '{@link org.eclipse.b3.aggregator.MavenItem#getArtifactId <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Id</em>' attribute.
	 * @see #getArtifactId()
	 * @generated
	 */
	void setArtifactId(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.b3.aggregator.MavenItem#getGroupId <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Id</em>' attribute.
	 * @see #getGroupId()
	 * @generated
	 */
	void setGroupId(String value);

} // MavenItem
