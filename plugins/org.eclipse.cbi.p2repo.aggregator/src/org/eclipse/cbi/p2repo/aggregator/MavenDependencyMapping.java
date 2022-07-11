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

import org.eclipse.equinox.p2.metadata.VersionRange;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Maven Dependency Mapping</b></em>'.
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
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getIuNamePattern <em>Iu Name Pattern</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getNamespacePattern <em>Namespace Pattern</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getNamePattern <em>Name Pattern</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getArtifactId <em>Artifact Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getVersionRangePattern <em>Version Range Pattern</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getVersionRangeTemplate <em>Version Range Template</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenDependencyMapping()
 * @model
 * @generated
 */
public interface MavenDependencyMapping extends StatusProvider, InfosProvider {
	/**
	 * Returns the value of the '<em><b>Iu Name Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iu Name Pattern</em>' attribute.
	 * @see #setIuNamePattern(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenDependencyMapping_IuNamePattern()
	 * @model
	 * @generated
	 */
	String getIuNamePattern();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getIuNamePattern <em>Iu Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iu Name Pattern</em>' attribute.
	 * @see #getIuNamePattern()
	 * @generated
	 */
	void setIuNamePattern(String value);

	/**
	 * Returns the value of the '<em><b>Namespace Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace Pattern</em>' attribute.
	 * @see #setNamespacePattern(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenDependencyMapping_NamespacePattern()
	 * @model
	 * @generated
	 */
	String getNamespacePattern();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getNamespacePattern <em>Namespace Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace Pattern</em>' attribute.
	 * @see #getNamespacePattern()
	 * @generated
	 */
	void setNamespacePattern(String value);

	/**
	 * Returns the value of the '<em><b>Name Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Pattern</em>' attribute.
	 * @see #setNamePattern(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenDependencyMapping_NamePattern()
	 * @model
	 * @generated
	 */
	String getNamePattern();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getNamePattern <em>Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Pattern</em>' attribute.
	 * @see #getNamePattern()
	 * @generated
	 */
	void setNamePattern(String value);

	/**
	 * Returns the value of the '<em><b>Group Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Group Id</em>' attribute.
	 * @see #setGroupId(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenDependencyMapping_GroupId()
	 * @model
	 * @generated
	 */
	String getGroupId();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getGroupId <em>Group Id</em>}' attribute.
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
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenDependencyMapping_ArtifactId()
	 * @model
	 * @generated
	 */
	String getArtifactId();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getArtifactId <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Id</em>' attribute.
	 * @see #getArtifactId()
	 * @generated
	 */
	void setArtifactId(String value);

	/**
	 * Returns the value of the '<em><b>Version Range Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Range Pattern</em>' attribute.
	 * @see #setVersionRangePattern(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenDependencyMapping_VersionRangePattern()
	 * @model
	 * @generated
	 */
	String getVersionRangePattern();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getVersionRangePattern <em>Version Range Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Range Pattern</em>' attribute.
	 * @see #getVersionRangePattern()
	 * @generated
	 */
	void setVersionRangePattern(String value);

	/**
	 * Returns the value of the '<em><b>Version Range Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Range Template</em>' attribute.
	 * @see #setVersionRangeTemplate(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenDependencyMapping_VersionRangeTemplate()
	 * @model
	 * @generated
	 */
	String getVersionRangeTemplate();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping#getVersionRangeTemplate <em>Version Range Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Range Template</em>' attribute.
	 * @see #getVersionRangeTemplate()
	 * @generated
	 */
	void setVersionRangeTemplate(String value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model versionRangeDataType="org.eclipse.cbi.p2repo.p2.VersionRange"
	 * @generated
	 */
	MavenDependencyItem map(String iuName, String requirementNamespace, String requirementName,
			VersionRange versionRange);

} // MavenDependencyMapping
