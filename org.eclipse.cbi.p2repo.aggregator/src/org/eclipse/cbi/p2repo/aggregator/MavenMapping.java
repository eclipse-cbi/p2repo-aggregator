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

import org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl;
import org.eclipse.equinox.p2.metadata.Version;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Maven Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getNamePattern <em>Name Pattern</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getGroupId <em>Group Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getArtifactId <em>Artifact Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getVersionPattern <em>Version Pattern</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getVersionTemplate <em>Version Template</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#isSnapshot <em>Snapshot</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenMapping()
 * @model
 * @generated
 */
public interface MavenMapping extends StatusProvider, InfosProvider {
	MavenMapping DEFAULT_MAPPING = new MavenMappingImpl("^([^.]+(?:\\.[^.]+(?:\\.[^.]+)?)?)(?:\\.[^.]+)*$", "$1", "$0");

	/**
	 * Returns the value of the '<em><b>Artifact Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Artifact Id</em>' attribute.
	 * @see #setArtifactId(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenMapping_ArtifactId()
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
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenMapping_GroupId()
	 * @model
	 * @generated
	 */
	String getGroupId();

	/**
	 * Returns the value of the '<em><b>Name Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name Pattern</em>' attribute.
	 * @see #setNamePattern(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenMapping_NamePattern()
	 * @model
	 * @generated
	 */
	String getNamePattern();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getArtifactId <em>Artifact Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Artifact Id</em>' attribute.
	 * @see #getArtifactId()
	 * @generated
	 */
	void setArtifactId(String value);

	/**
	 * Returns the value of the '<em><b>Version Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Pattern</em>' attribute.
	 * @see #setVersionPattern(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenMapping_VersionPattern()
	 * @model
	 * @generated
	 */
	String getVersionPattern();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getVersionPattern <em>Version Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Pattern</em>' attribute.
	 * @see #getVersionPattern()
	 * @generated
	 */
	void setVersionPattern(String value);

	/**
	 * Returns the value of the '<em><b>Version Template</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version Template</em>' attribute.
	 * @see #setVersionTemplate(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenMapping_VersionTemplate()
	 * @model
	 * @generated
	 */
	String getVersionTemplate();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getVersionTemplate <em>Version Template</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version Template</em>' attribute.
	 * @see #getVersionTemplate()
	 * @generated
	 */
	void setVersionTemplate(String value);

	/**
	 * Returns the value of the '<em><b>Snapshot</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snapshot</em>' attribute.
	 * @see #setSnapshot(boolean)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getMavenMapping_Snapshot()
	 * @model default="false" dataType="org.eclipse.emf.ecore.xml.type.Boolean" required="true"
	 * @generated
	 */
	boolean isSnapshot();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#isSnapshot <em>Snapshot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snapshot</em>' attribute.
	 * @see #isSnapshot()
	 * @generated
	 */
	void setSnapshot(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model versionDataType="org.eclipse.cbi.p2repo.p2.Version"
	 * @generated
	 */
	MavenItem map(String installableUnitID, Version version);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model versionDataType="org.eclipse.cbi.p2repo.p2.Version"
	 * @generated
	 */
	String mapVersion(Version version);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getGroupId <em>Group Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Group Id</em>' attribute.
	 * @see #getGroupId()
	 * @generated
	 */
	void setGroupId(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.MavenMapping#getNamePattern <em>Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name Pattern</em>' attribute.
	 * @see #getNamePattern()
	 * @generated
	 */
	void setNamePattern(String value);

} // MavenMapping
