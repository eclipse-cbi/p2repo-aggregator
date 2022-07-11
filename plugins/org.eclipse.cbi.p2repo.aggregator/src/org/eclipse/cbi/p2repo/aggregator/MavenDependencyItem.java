/**
 * Copyright (c) 2022 Eclipse Foundation and others.
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
 * A representation of the model object '<em><b>Maven Dependency Item</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * @since 1.1.0
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyItem#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyItem#getArtifactId <em>Artifact Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyItem#getMappedVersionRange <em>Mapped Version Range</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyItem#getMavenDependencyMapping <em>Maven Dependency Mapping</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenDependencyItem()
 * @model
 * @generated
 */
public interface MavenDependencyItem {
	/**
	 * Returns the value of the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Id</em>' attribute.
	 * @see #setGroupId(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenDependencyItem_GroupId()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getGroupId();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyItem#getGroupId <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Id</em>' attribute.
	 * @see #getGroupId()
	 * @generated
	 */
	void setGroupId(String value);

	/**
	 * Returns the value of the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Artifact Id</em>' attribute.
	 * @see #setArtifactId(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenDependencyItem_ArtifactId()
	 * @model
	 * @generated
	 */
	String getArtifactId();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyItem#getArtifactId <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Id</em>' attribute.
	 * @see #getArtifactId()
	 * @generated
	 */
	void setArtifactId(String value);

	/**
	 * Returns the value of the '<em><b>Mapped Version Range</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mapped Version Range</em>' attribute.
	 * @see #setMappedVersionRange(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenDependencyItem_MappedVersionRange()
	 * @model
	 * @generated
	 */
	String getMappedVersionRange();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyItem#getMappedVersionRange <em>Mapped Version Range</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mapped Version Range</em>' attribute.
	 * @see #getMappedVersionRange()
	 * @generated
	 */
	void setMappedVersionRange(String value);

	/**
	 * Returns the value of the '<em><b>Maven Dependency Mapping</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Maven Dependency Mapping</em>' reference.
	 * @see #setMavenDependencyMapping(MavenDependencyMapping)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenDependencyItem_MavenDependencyMapping()
	 * @model
	 * @generated
	 */
	MavenDependencyMapping getMavenDependencyMapping();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyItem#getMavenDependencyMapping <em>Maven Dependency Mapping</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Maven Dependency Mapping</em>' reference.
	 * @see #getMavenDependencyMapping()
	 * @generated
	 */
	void setMavenDependencyMapping(MavenDependencyMapping value);

} // MavenDependencyItem
