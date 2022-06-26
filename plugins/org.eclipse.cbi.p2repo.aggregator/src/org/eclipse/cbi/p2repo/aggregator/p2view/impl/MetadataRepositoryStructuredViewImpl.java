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
package org.eclipse.cbi.p2repo.aggregator.p2view.impl;

import java.net.URI;

import org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits;
import org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.cbi.p2repo.aggregator.p2view.Properties;
import org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryReferences;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Metadata Repository Structured View</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.MetadataRepositoryStructuredViewImpl#getChildren <em>Children</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.MetadataRepositoryStructuredViewImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.MetadataRepositoryStructuredViewImpl#getInstallableUnitList <em>Installable Unit List</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.MetadataRepositoryStructuredViewImpl#getProperties <em>Properties</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.MetadataRepositoryStructuredViewImpl#getMetadataRepository <em>Metadata Repository</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.MetadataRepositoryStructuredViewImpl#isLoaded <em>Loaded</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.MetadataRepositoryStructuredViewImpl#getRepositoryReferences <em>Repository References</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.MetadataRepositoryStructuredViewImpl#getLocation <em>Location</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MetadataRepositoryStructuredViewImpl extends MinimalEObjectImpl.Container
		implements MetadataRepositoryStructuredView {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getInstallableUnitList() <em>Installable Unit List</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstallableUnitList()
	 * @generated
	 * @ordered
	 */
	protected InstallableUnits installableUnitList;

	/**
	 * The cached value of the '{@link #getProperties() <em>Properties</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProperties()
	 * @generated
	 * @ordered
	 */
	protected Properties properties;

	/**
	 * The cached value of the '{@link #getMetadataRepository() <em>Metadata Repository</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetadataRepository()
	 * @generated
	 * @ordered
	 */
	protected MetadataRepository metadataRepository;

	/**
	 * The default value of the '{@link #isLoaded() <em>Loaded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoaded()
	 * @generated
	 * @ordered
	 */
	protected static final boolean LOADED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isLoaded() <em>Loaded</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isLoaded()
	 * @generated
	 * @ordered
	 */
	protected static final int LOADED_EFLAG = 1 << 0;

	/**
	 * The cached value of the '{@link #getRepositoryReferences() <em>Repository References</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepositoryReferences()
	 * @generated
	 * @ordered
	 */
	protected RepositoryReferences repositoryReferences;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final URI LOCATION_EDEFAULT = null;

	/**
	 *
	 *
	 * @generated NOT
	 */
	protected MetadataRepositoryStructuredViewImpl() {
		this(null);
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	protected MetadataRepositoryStructuredViewImpl(MetadataRepository metadataRepository) {
		super();
		setMetadataRepository(metadataRepository);
		setLoaded(false);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstallableUnits basicGetInstallableUnitList() {
		return installableUnitList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Properties basicGetProperties() {
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryReferences basicGetRepositoryReferences() {
		return repositoryReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInstallableUnitList(InstallableUnits newInstallableUnitList,
			NotificationChain msgs) {
		InstallableUnits oldInstallableUnitList = installableUnitList;
		installableUnitList = newInstallableUnitList;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST, oldInstallableUnitList,
					newInstallableUnitList);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetProperties(Properties newProperties, NotificationChain msgs) {
		Properties oldProperties = properties;
		properties = newProperties;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES, oldProperties, newProperties);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__CHILDREN:
				return getChildren();
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__NAME:
				return getName();
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST:
				if (resolve)
					return getInstallableUnitList();
				return basicGetInstallableUnitList();
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES:
				if (resolve)
					return getProperties();
				return basicGetProperties();
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__METADATA_REPOSITORY:
				return getMetadataRepository();
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__LOADED:
				return isLoaded();
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__REPOSITORY_REFERENCES:
				if (resolve)
					return getRepositoryReferences();
				return basicGetRepositoryReferences();
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__LOCATION:
				return getLocation();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST:
				return basicSetInstallableUnitList(null, msgs);
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES:
				return basicSetProperties(null, msgs);
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__METADATA_REPOSITORY:
				return basicSetMetadataRepository(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__CHILDREN:
				return !getChildren().isEmpty();
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST:
				return installableUnitList != null;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES:
				return properties != null;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__METADATA_REPOSITORY:
				return metadataRepository != null;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__LOADED:
				return ((eFlags & LOADED_EFLAG) != 0) != LOADED_EDEFAULT;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__REPOSITORY_REFERENCES:
				return repositoryReferences != null;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__LOCATION:
				return isSetLocation();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__NAME:
				setName((String) newValue);
				return;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST:
				setInstallableUnitList((InstallableUnits) newValue);
				return;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES:
				setProperties((Properties) newValue);
				return;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__METADATA_REPOSITORY:
				setMetadataRepository((MetadataRepository) newValue);
				return;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__LOADED:
				setLoaded((Boolean) newValue);
				return;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__REPOSITORY_REFERENCES:
				setRepositoryReferences((RepositoryReferences) newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return P2viewPackage.Literals.METADATA_REPOSITORY_STRUCTURED_VIEW;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__NAME:
				setName(NAME_EDEFAULT);
				return;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST:
				setInstallableUnitList((InstallableUnits) null);
				return;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES:
				setProperties((Properties) null);
				return;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__METADATA_REPOSITORY:
				setMetadataRepository((MetadataRepository) null);
				return;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__LOADED:
				setLoaded(LOADED_EDEFAULT);
				return;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__REPOSITORY_REFERENCES:
				setRepositoryReferences((RepositoryReferences) null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public EList<InstallableUnits> getChildren() {
		EList<InstallableUnits> children = new BasicEList<>();
		children.add(getInstallableUnitList());
		return children;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public InstallableUnits getInstallableUnitList() {
		if (installableUnitList != null && ((EObject) installableUnitList).eIsProxy()) {
			InternalEObject oldInstallableUnitList = (InternalEObject) installableUnitList;
			installableUnitList = (InstallableUnits) eResolveProxy(oldInstallableUnitList);
			if (installableUnitList != oldInstallableUnitList) {
				InternalEObject newInstallableUnitList = (InternalEObject) installableUnitList;
				NotificationChain msgs = oldInstallableUnitList.eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST, null, null);
				if (newInstallableUnitList.eInternalContainer() == null) {
					msgs = newInstallableUnitList.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE
									- P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST,
							null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST,
							oldInstallableUnitList, installableUnitList));
			}
		}
		return installableUnitList;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public URI getLocation() {
		MetadataRepository mr = getMetadataRepository();
		return mr == null ? null : mr.getLocation();
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public MetadataRepository getMetadataRepository() {
		if (!isLoaded())
			return null;

		return getMetadataRepositoryGen();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetadataRepository getMetadataRepositoryGen() {
		return metadataRepository;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetMetadataRepository(MetadataRepository newMetadataRepository,
			NotificationChain msgs) {
		MetadataRepository oldMetadataRepository = metadataRepository;
		metadataRepository = newMetadataRepository;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__METADATA_REPOSITORY, oldMetadataRepository,
					newMetadataRepository);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMetadataRepository(MetadataRepository newMetadataRepository) {
		if (newMetadataRepository != metadataRepository) {
			NotificationChain msgs = null;
			if (metadataRepository != null)
				msgs = ((InternalEObject) metadataRepository).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__METADATA_REPOSITORY,
						null, msgs);
			if (newMetadataRepository != null)
				msgs = ((InternalEObject) newMetadataRepository).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__METADATA_REPOSITORY,
						null, msgs);
			msgs = basicSetMetadataRepository(newMetadataRepository, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__METADATA_REPOSITORY, newMetadataRepository,
					newMetadataRepository));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Properties getProperties() {
		if (properties != null && ((EObject) properties).eIsProxy()) {
			InternalEObject oldProperties = (InternalEObject) properties;
			properties = (Properties) eResolveProxy(oldProperties);
			if (properties != oldProperties) {
				InternalEObject newProperties = (InternalEObject) properties;
				NotificationChain msgs = oldProperties.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES, null,
						null);
				if (newProperties.eInternalContainer() == null) {
					msgs = newProperties.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE - P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES,
							null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES, oldProperties, properties));
			}
		}
		return properties;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RepositoryReferences getRepositoryReferences() {
		if (repositoryReferences != null && ((EObject) repositoryReferences).eIsProxy()) {
			InternalEObject oldRepositoryReferences = (InternalEObject) repositoryReferences;
			repositoryReferences = (RepositoryReferences) eResolveProxy(oldRepositoryReferences);
			if (repositoryReferences != oldRepositoryReferences) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__REPOSITORY_REFERENCES,
							oldRepositoryReferences, repositoryReferences));
			}
		}
		return repositoryReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isLoaded() {
		return (eFlags & LOADED_EFLAG) != 0;
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public boolean isSetLocation() {
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setInstallableUnitList(InstallableUnits newInstallableUnitList) {
		if (newInstallableUnitList != installableUnitList) {
			NotificationChain msgs = null;
			if (installableUnitList != null)
				msgs = ((InternalEObject) installableUnitList).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST, null, msgs);
			if (newInstallableUnitList != null)
				msgs = ((InternalEObject) newInstallableUnitList).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST, null, msgs);
			msgs = basicSetInstallableUnitList(newInstallableUnitList, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST, newInstallableUnitList,
					newInstallableUnitList));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLoaded(boolean newLoaded) {
		boolean oldLoaded = (eFlags & LOADED_EFLAG) != 0;
		if (newLoaded)
			eFlags |= LOADED_EFLAG;
		else
			eFlags &= ~LOADED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__LOADED, oldLoaded, newLoaded));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProperties(Properties newProperties) {
		if (newProperties != properties) {
			NotificationChain msgs = null;
			if (properties != null)
				msgs = ((InternalEObject) properties).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES, null,
						msgs);
			if (newProperties != null)
				msgs = ((InternalEObject) newProperties).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES, null,
						msgs);
			msgs = basicSetProperties(newProperties, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES, newProperties, newProperties));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRepositoryReferences(RepositoryReferences newRepositoryReferences) {
		RepositoryReferences oldRepositoryReferences = repositoryReferences;
		repositoryReferences = newRepositoryReferences;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__REPOSITORY_REFERENCES, oldRepositoryReferences,
					repositoryReferences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", loaded: ");
		result.append((eFlags & LOADED_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} // MetadataRepositoryStructuredViewImpl
