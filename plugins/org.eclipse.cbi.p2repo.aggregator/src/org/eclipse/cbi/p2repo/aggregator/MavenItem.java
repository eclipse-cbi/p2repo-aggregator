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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Maven Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getArtifactId <em>Artifact Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getMappedVersion <em>Mapped Version</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getClassifier <em>Classifier</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getMavenMapping <em>Maven Mapping</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenItem()
 * @model
 * @generated
 */
public interface MavenItem {
	/**
	 * Returns the value of the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Artifact Id</em>' attribute.
	 * @see #setArtifactId(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenItem_ArtifactId()
	 * @model
	 * @generated
	 */
	String getArtifactId();

	/**
	 * Returns the value of the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Id</em>' attribute.
	 * @see #setGroupId(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenItem_GroupId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getGroupId();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getArtifactId <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Id</em>' attribute.
	 * @see #getArtifactId()
	 * @generated
	 */
	void setArtifactId(String value);

	/**
	 * Returns the value of the '<em><b>Mapped Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Version</em>' attribute.
	 * @see #setMappedVersion(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenItem_MappedVersion()
	 * @model
	 * @generated
	 */
	String getMappedVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getMappedVersion <em>Mapped Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Version</em>' attribute.
	 * @see #getMappedVersion()
	 * @generated
	 */
	void setMappedVersion(String value);

	/**
	 * Returns the value of the '<em><b>Classifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classifier</em>' attribute.
	 * @see #setClassifier(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenItem_Classifier()
	 * @model
	 * @generated
	 */
	String getClassifier();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getClassifier <em>Classifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Classifier</em>' attribute.
	 * @see #getClassifier()
	 * @generated
	 */
	void setClassifier(String value);

	/**
	 * Returns the value of the '<em><b>Maven Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maven Mapping</em>' reference.
	 * @see #setMavenMapping(MavenMapping)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenItem_MavenMapping()
	 * @model
	 * @generated
	 */
	MavenMapping getMavenMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getMavenMapping <em>Maven Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maven Mapping</em>' reference.
	 * @see #getMavenMapping()
	 * @generated
	 */
	void setMavenMapping(MavenMapping value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isSources();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenItem#getGroupId <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Id</em>' attribute.
	 * @see #getGroupId()
	 * @generated
	 */
	void setGroupId(String value);

} // MavenItem
