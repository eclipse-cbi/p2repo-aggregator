/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.aggregator.p2view.impl;

import org.eclipse.cbi.p2repo.aggregator.InstallableUnitType;
import org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>IU Presentation</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUPresentationImpl#getId <em>Id</em>}</li>
 * <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUPresentationImpl#getVersion <em>Version</em>}</li>
 * <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUPresentationImpl#getName <em>Name</em>}</li>
 * <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUPresentationImpl#getDescription <em>Description</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class IUPresentationImpl extends MinimalEObjectImpl.Container implements IUPresentation {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final Version VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected Version version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getLabel() <em>Label</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected static final String LABEL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected String label = LABEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final InstallableUnitType TYPE_EDEFAULT = InstallableUnitType.BUNDLE;

	/**
	 * The default value of the '{@link #getFilter() <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected static final String FILTER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFilter() <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected String filter = FILTER_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInstallableUnit() <em>Installable Unit</em>}' reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getInstallableUnit()
	 * @generated
	 * @ordered
	 */
	protected IInstallableUnit installableUnit;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IUPresentationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected IUPresentationImpl(IInstallableUnit iu) {
		super();
		this.installableUnit = iu;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2viewPackage.IU_PRESENTATION__ID:
				return getId();
			case P2viewPackage.IU_PRESENTATION__VERSION:
				return getVersion();
			case P2viewPackage.IU_PRESENTATION__NAME:
				return getName();
			case P2viewPackage.IU_PRESENTATION__LABEL:
				return getLabel();
			case P2viewPackage.IU_PRESENTATION__DESCRIPTION:
				return getDescription();
			case P2viewPackage.IU_PRESENTATION__TYPE:
				return getType();
			case P2viewPackage.IU_PRESENTATION__FILTER:
				return getFilter();
			case P2viewPackage.IU_PRESENTATION__INSTALLABLE_UNIT:
				return getInstallableUnit();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case P2viewPackage.IU_PRESENTATION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case P2viewPackage.IU_PRESENTATION__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case P2viewPackage.IU_PRESENTATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case P2viewPackage.IU_PRESENTATION__LABEL:
				return LABEL_EDEFAULT == null ? label != null : !LABEL_EDEFAULT.equals(label);
			case P2viewPackage.IU_PRESENTATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case P2viewPackage.IU_PRESENTATION__TYPE:
				return getType() != TYPE_EDEFAULT;
			case P2viewPackage.IU_PRESENTATION__FILTER:
				return FILTER_EDEFAULT == null ? filter != null : !FILTER_EDEFAULT.equals(filter);
			case P2viewPackage.IU_PRESENTATION__INSTALLABLE_UNIT:
				return installableUnit != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case P2viewPackage.IU_PRESENTATION__ID:
				setId((String) newValue);
				return;
			case P2viewPackage.IU_PRESENTATION__VERSION:
				setVersion((Version) newValue);
				return;
			case P2viewPackage.IU_PRESENTATION__NAME:
				setName((String) newValue);
				return;
			case P2viewPackage.IU_PRESENTATION__LABEL:
				setLabel((String) newValue);
				return;
			case P2viewPackage.IU_PRESENTATION__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case P2viewPackage.IU_PRESENTATION__FILTER:
				setFilter((String) newValue);
				return;
			case P2viewPackage.IU_PRESENTATION__INSTALLABLE_UNIT:
				setInstallableUnit((IInstallableUnit) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return P2viewPackage.Literals.IU_PRESENTATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2viewPackage.IU_PRESENTATION__ID:
				setId(ID_EDEFAULT);
				return;
			case P2viewPackage.IU_PRESENTATION__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case P2viewPackage.IU_PRESENTATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case P2viewPackage.IU_PRESENTATION__LABEL:
				setLabel(LABEL_EDEFAULT);
				return;
			case P2viewPackage.IU_PRESENTATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case P2viewPackage.IU_PRESENTATION__FILTER:
				setFilter(FILTER_EDEFAULT);
				return;
			case P2viewPackage.IU_PRESENTATION__INSTALLABLE_UNIT:
				setInstallableUnit((IInstallableUnit) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFilter() {
		return filter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IInstallableUnit getInstallableUnit() {
		return installableUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	abstract public InstallableUnitType getType();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Version getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_PRESENTATION__DESCRIPTION,
					oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFilter(String newFilter) {
		String oldFilter = filter;
		filter = newFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_PRESENTATION__FILTER, oldFilter,
					filter));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_PRESENTATION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstallableUnit(IInstallableUnit newInstallableUnit) {
		IInstallableUnit oldInstallableUnit = installableUnit;
		installableUnit = newInstallableUnit;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_PRESENTATION__INSTALLABLE_UNIT,
					oldInstallableUnit, installableUnit));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLabel(String newLabel) {
		String oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_PRESENTATION__LABEL, oldLabel,
					label));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_PRESENTATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(Version newVersion) {
		Version oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_PRESENTATION__VERSION, oldVersion,
					version));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", version: ");
		result.append(version);
		result.append(", name: ");
		result.append(name);
		result.append(", label: ");
		result.append(label);
		result.append(", description: ");
		result.append(description);
		result.append(", filter: ");
		result.append(filter);
		result.append(')');
		return result.toString();
	}

} // IUPresentationImpl
