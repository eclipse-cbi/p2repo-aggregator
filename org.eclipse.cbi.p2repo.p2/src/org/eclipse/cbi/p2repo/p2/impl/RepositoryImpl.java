/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 */
package org.eclipse.cbi.p2repo.p2.impl;

import java.net.URI;
import java.util.Map;

import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.p2.Repository;
import org.eclipse.core.internal.runtime.AdapterManager;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.IQueryResult;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Repository</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.RepositoryImpl#getLocation <em>Location</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.RepositoryImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.RepositoryImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.RepositoryImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.RepositoryImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.RepositoryImpl#getProvider <em>Provider</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.RepositoryImpl#isModifiable <em>Modifiable</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.RepositoryImpl#getProvisioningAgent <em>Provisioning Agent</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.RepositoryImpl#getPropertyMap <em>Property Map</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RepositoryImpl<T> extends MinimalEObjectImpl.Container implements Repository<T> {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The default value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected static final URI LOCATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLocation() <em>Location</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLocation()
	 * @generated
	 * @ordered
	 */
	protected URI location = LOCATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProvider() <em>Provider</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProvider()
	 * @generated
	 * @ordered
	 */
	protected String provider = PROVIDER_EDEFAULT;

	/**
	 * The default value of the '{@link #isModifiable() <em>Modifiable</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isModifiable()
	 * @generated
	 * @ordered
	 */
	protected static final boolean MODIFIABLE_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isModifiable() <em>Modifiable</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isModifiable()
	 * @generated
	 * @ordered
	 */
	protected static final int MODIFIABLE_EFLAG = 1 << 0;

	/**
	 * The default value of the '{@link #getProvisioningAgent() <em>Provisioning Agent</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProvisioningAgent()
	 * @generated
	 * @ordered
	 */
	protected static final IProvisioningAgent PROVISIONING_AGENT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProvisioningAgent() <em>Provisioning Agent</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProvisioningAgent()
	 * @generated
	 * @ordered
	 */
	protected IProvisioningAgent provisioningAgent = PROVISIONING_AGENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPropertyMap() <em>Property Map</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getPropertyMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, String> propertyMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected RepositoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2Package.REPOSITORY__LOCATION:
				return getLocation();
			case P2Package.REPOSITORY__NAME:
				return getName();
			case P2Package.REPOSITORY__TYPE:
				return getType();
			case P2Package.REPOSITORY__VERSION:
				return getVersion();
			case P2Package.REPOSITORY__DESCRIPTION:
				return getDescription();
			case P2Package.REPOSITORY__PROVIDER:
				return getProvider();
			case P2Package.REPOSITORY__MODIFIABLE:
				return isModifiable();
			case P2Package.REPOSITORY__PROVISIONING_AGENT:
				return getProvisioningAgent();
			case P2Package.REPOSITORY__PROPERTY_MAP:
				if (coreType)
					return getPropertyMap();
				else
					return getPropertyMap().map();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case P2Package.REPOSITORY__PROPERTY_MAP:
				return ((InternalEList<?>) getPropertyMap()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case P2Package.REPOSITORY__LOCATION:
				return LOCATION_EDEFAULT == null ? location != null : !LOCATION_EDEFAULT.equals(location);
			case P2Package.REPOSITORY__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case P2Package.REPOSITORY__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case P2Package.REPOSITORY__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case P2Package.REPOSITORY__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case P2Package.REPOSITORY__PROVIDER:
				return PROVIDER_EDEFAULT == null ? provider != null : !PROVIDER_EDEFAULT.equals(provider);
			case P2Package.REPOSITORY__MODIFIABLE:
				return ((eFlags & MODIFIABLE_EFLAG) != 0) != MODIFIABLE_EDEFAULT;
			case P2Package.REPOSITORY__PROVISIONING_AGENT:
				return PROVISIONING_AGENT_EDEFAULT == null ? provisioningAgent != null
						: !PROVISIONING_AGENT_EDEFAULT.equals(provisioningAgent);
			case P2Package.REPOSITORY__PROPERTY_MAP:
				return propertyMap != null && !propertyMap.isEmpty();
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
			case P2Package.REPOSITORY__LOCATION:
				setLocation((URI) newValue);
				return;
			case P2Package.REPOSITORY__NAME:
				setName((String) newValue);
				return;
			case P2Package.REPOSITORY__TYPE:
				setType((String) newValue);
				return;
			case P2Package.REPOSITORY__VERSION:
				setVersion((String) newValue);
				return;
			case P2Package.REPOSITORY__DESCRIPTION:
				setDescription((String) newValue);
				return;
			case P2Package.REPOSITORY__PROVIDER:
				setProvider((String) newValue);
				return;
			case P2Package.REPOSITORY__MODIFIABLE:
				setModifiable((Boolean) newValue);
				return;
			case P2Package.REPOSITORY__PROVISIONING_AGENT:
				setProvisioningAgent((IProvisioningAgent) newValue);
				return;
			case P2Package.REPOSITORY__PROPERTY_MAP:
				((EStructuralFeature.Setting) getPropertyMap()).set(newValue);
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
		return P2Package.Literals.REPOSITORY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.REPOSITORY__LOCATION:
				setLocation(LOCATION_EDEFAULT);
				return;
			case P2Package.REPOSITORY__NAME:
				setName(NAME_EDEFAULT);
				return;
			case P2Package.REPOSITORY__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case P2Package.REPOSITORY__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case P2Package.REPOSITORY__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case P2Package.REPOSITORY__PROVIDER:
				setProvider(PROVIDER_EDEFAULT);
				return;
			case P2Package.REPOSITORY__MODIFIABLE:
				setModifiable(MODIFIABLE_EDEFAULT);
				return;
			case P2Package.REPOSITORY__PROVISIONING_AGENT:
				setProvisioningAgent(PROVISIONING_AGENT_EDEFAULT);
				return;
			case P2Package.REPOSITORY__PROPERTY_MAP:
				getPropertyMap().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public final Object getAdapter(Class adapter) {
		return AdapterManager.getDefault().getAdapter(this, adapter);
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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public URI getLocation() {
		return location;
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
	public final Map<String, String> getProperties() {
		return getPropertyMap().map();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public final String getProperty(String key) {
		return getPropertyMap().get(key);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, String> getPropertyMap() {
		if (propertyMap == null) {
			propertyMap = new EcoreEMap<>(P2Package.Literals.PROPERTY, PropertyImpl.class, this,
					P2Package.REPOSITORY__PROPERTY_MAP);
		}
		return propertyMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProvider() {
		return provider;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IProvisioningAgent getProvisioningAgent() {
		return provisioningAgent;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isModifiable() {
		return (eFlags & MODIFIABLE_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public abstract IQueryResult<T> query(IQuery<T> query, IProgressMonitor progress);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.REPOSITORY__DESCRIPTION, oldDescription,
					description));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setLocation(URI newLocation) {
		URI oldLocation = location;
		location = newLocation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.REPOSITORY__LOCATION, oldLocation,
					location));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setModifiable(boolean newModifiable) {
		boolean oldModifiable = (eFlags & MODIFIABLE_EFLAG) != 0;
		if (newModifiable)
			eFlags |= MODIFIABLE_EFLAG;
		else
			eFlags &= ~MODIFIABLE_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.REPOSITORY__MODIFIABLE, oldModifiable,
					newModifiable));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.REPOSITORY__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public final String setProperty(String key, String value) {
		return getPropertyMap().put(key, value);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String setProperty(String key, String value, IProgressMonitor monitor) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvider(String newProvider) {
		String oldProvider = provider;
		provider = newProvider;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.REPOSITORY__PROVIDER, oldProvider,
					provider));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProvisioningAgent(IProvisioningAgent newProvisioningAgent) {
		IProvisioningAgent oldProvisioningAgent = provisioningAgent;
		provisioningAgent = newProvisioningAgent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.REPOSITORY__PROVISIONING_AGENT,
					oldProvisioningAgent, provisioningAgent));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.REPOSITORY__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.REPOSITORY__VERSION, oldVersion, version));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (location: ");
		result.append(location);
		result.append(", name: ");
		result.append(name);
		result.append(", type: ");
		result.append(type);
		result.append(", version: ");
		result.append(version);
		result.append(", description: ");
		result.append(description);
		result.append(", provider: ");
		result.append(provider);
		result.append(", modifiable: ");
		result.append((eFlags & MODIFIABLE_EFLAG) != 0);
		result.append(", provisioningAgent: ");
		result.append(provisioningAgent);
		result.append(')');
		return result.toString();
	}

} // RepositoryImpl
