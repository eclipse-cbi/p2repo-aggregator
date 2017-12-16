/**
 * Copyright (c) 2006-2011, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.aggregator.p2view;

import java.util.Comparator;

import org.eclipse.cbi.p2repo.aggregator.InstallableUnitType;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>IU Presentation</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getLabel <em>Label</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getInstallableUnit <em>Installable Unit</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getIUPresentation()
 * @model abstract="true"
 * @generated
 */
public interface IUPresentation {
	// Compares IU presentation by label
	static class IUPresentationComparator implements Comparator<IUPresentation> {

		@Override
		public int compare(IUPresentation iup1, IUPresentation iup2) {
			String label1 = iup1 != null ? iup1.getLabel() : null;
			String label2 = iup2 != null ? iup2.getLabel() : null;
			return label1 != null ? (label2 == null ? 1 : label1.compareTo(label2)) : (label2 != null ? -1 : 0);
		}
	}

	static Comparator<IUPresentation> COMPARATOR = new IUPresentationComparator();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getIUPresentation_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Returns the value of the '<em><b>Filter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter</em>' attribute.
	 * @see #setFilter(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getIUPresentation_Filter()
	 * @model
	 * @generated
	 */
	String getFilter();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getIUPresentation_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Returns the value of the '<em><b>Installable Unit</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iu</em>' reference isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Installable Unit</em>' reference.
	 * @see #setInstallableUnit(IInstallableUnit)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getIUPresentation_InstallableUnit()
	 * @model type="org.eclipse.cbi.p2repo.p2.IInstallableUnit" resolveProxies="false"
	 * @generated
	 */
	IInstallableUnit getInstallableUnit();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getIUPresentation_Label()
	 * @model
	 * @generated
	 */
	String getLabel();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> ======= Returns the value of
	 * the '<em><b>Name</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getIUPresentation_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipse.cbi.p2repo.aggregator.InstallableUnitType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see org.eclipse.cbi.p2repo.aggregator.InstallableUnitType
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getIUPresentation_Type()
	 * @model unique="false" required="true" changeable="false" volatile="true"
	 * @generated
	 */
	InstallableUnitType getType();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc --> ======= Returns the value
	 * of the '<em><b>Version</b></em>' attribute. <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(Version)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getIUPresentation_Version()
	 * @model dataType="org.eclipse.cbi.p2repo.p2.Version"
	 * @generated
	 */
	Version getVersion();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getFilter <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter</em>' attribute.
	 * @see #getFilter()
	 * @generated
	 */
	void setFilter(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getInstallableUnit <em>Installable Unit</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Installable Unit</em>' reference.
	 * @see #getInstallableUnit()
	 * @generated
	 */
	void setInstallableUnit(IInstallableUnit value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(Version value);

} // IUPresentation
