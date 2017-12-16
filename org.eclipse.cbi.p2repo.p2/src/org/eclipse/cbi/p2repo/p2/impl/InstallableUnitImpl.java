/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */
package org.eclipse.cbi.p2repo.p2.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

import org.eclipse.cbi.p2repo.p2.InstallableUnit;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.p2.util.RepositoryTranslationSupport;
import org.eclipse.cbi.p2repo.util.StringUtils;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.equinox.internal.p2.core.helpers.OrderedProperties;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.metadata.ICopyright;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IInstallableUnitFragment;
import org.eclipse.equinox.p2.metadata.ILicense;
import org.eclipse.equinox.p2.metadata.IProvidedCapability;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.ITouchpointData;
import org.eclipse.equinox.p2.metadata.ITouchpointType;
import org.eclipse.equinox.p2.metadata.IUpdateDescriptor;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Installable Unit</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getArtifacts <em>Artifacts</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getCopyright <em>Copyright</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getFilter <em>Filter</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getFragments <em>Fragments</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getLicenses <em>Licenses</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getMetaRequirements <em>Meta Requirements</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getProvidedCapabilities <em>Provided Capabilities</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getRequirements <em>Requirements</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getTouchpointData <em>Touchpoint Data</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getTouchpointType <em>Touchpoint Type</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getUpdateDescriptor <em>Update Descriptor</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#isResolved <em>Resolved</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#isSingleton <em>Singleton</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl#getPropertyMap <em>Property Map</em>}</li>
 * </ul>
 *
 * @generated
 */
public class InstallableUnitImpl extends MinimalEObjectImpl.Container implements InstallableUnit {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final Version VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected Version version = VERSION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getArtifacts() <em>Artifacts</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getArtifacts()
	 * @generated
	 * @ordered
	 */
	protected EList<IArtifactKey> artifacts;

	/**
	 * The cached value of the '{@link #getCopyright() <em>Copyright</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getCopyright()
	 * @generated
	 * @ordered
	 */
	protected ICopyright copyright;

	/**
	 * The cached value of the '{@link #getFilter() <em>Filter</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFilter()
	 * @generated
	 * @ordered
	 */
	protected IMatchExpression<IInstallableUnit> filter;

	/**
	 * The cached value of the '{@link #getFragments() <em>Fragments</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFragments()
	 * @generated
	 * @ordered
	 */
	protected EList<IInstallableUnitFragment> fragments;

	/**
	 * The cached value of the '{@link #getLicenses() <em>Licenses</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getLicenses()
	 * @generated
	 * @ordered
	 */
	protected EList<ILicense> licenses;

	/**
	 * The cached value of the '{@link #getMetaRequirements() <em>Meta Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMetaRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<IRequirement> metaRequirements;

	/**
	 * The cached value of the '{@link #getProvidedCapabilities() <em>Provided Capabilities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedCapabilities()
	 * @generated
	 * @ordered
	 */
	protected EList<IProvidedCapability> providedCapabilities;

	/**
	 * The cached value of the '{@link #getRequirements() <em>Requirements</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getRequirements()
	 * @generated
	 * @ordered
	 */
	protected EList<IRequirement> requirements;

	/**
	 * The cached value of the '{@link #getTouchpointData() <em>Touchpoint Data</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTouchpointData()
	 * @generated
	 * @ordered
	 */
	protected EList<ITouchpointData> touchpointData;

	/**
	 * The cached value of the '{@link #getTouchpointType() <em>Touchpoint Type</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getTouchpointType()
	 * @generated
	 * @ordered
	 */
	protected ITouchpointType touchpointType;

	/**
	 * The cached value of the '{@link #getUpdateDescriptor() <em>Update Descriptor</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getUpdateDescriptor()
	 * @generated
	 * @ordered
	 */
	protected IUpdateDescriptor updateDescriptor;

	/**
	 * The default value of the '{@link #isResolved() <em>Resolved</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isResolved()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RESOLVED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isResolved()
	 * <em>Resolved</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #isResolved()
	 * @generated
	 * @ordered
	 */
	protected static final int RESOLVED_EFLAG = 1 << 0;

	/**
	 * The default value of the '{@link #isSingleton() <em>Singleton</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isSingleton()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SINGLETON_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isSingleton()
	 * <em>Singleton</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #isSingleton()
	 * @generated
	 * @ordered
	 */
	protected static final int SINGLETON_EFLAG = 1 << 1;

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
	protected InstallableUnitImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ICopyright basicGetCopyright() {
		return copyright;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ITouchpointType basicGetTouchpointType() {
		return touchpointType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IUpdateDescriptor basicGetUpdateDescriptor() {
		return updateDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCopyright(ICopyright newCopyright, NotificationChain msgs) {
		ICopyright oldCopyright = copyright;
		copyright = newCopyright;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2Package.INSTALLABLE_UNIT__COPYRIGHT, oldCopyright, newCopyright);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTouchpointType(ITouchpointType newTouchpointType, NotificationChain msgs) {
		ITouchpointType oldTouchpointType = touchpointType;
		touchpointType = newTouchpointType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2Package.INSTALLABLE_UNIT__TOUCHPOINT_TYPE, oldTouchpointType, newTouchpointType);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUpdateDescriptor(IUpdateDescriptor newUpdateDescriptor, NotificationChain msgs) {
		IUpdateDescriptor oldUpdateDescriptor = updateDescriptor;
		updateDescriptor = newUpdateDescriptor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2Package.INSTALLABLE_UNIT__UPDATE_DESCRIPTOR, oldUpdateDescriptor, newUpdateDescriptor);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public int compareTo(IInstallableUnit o) {
		int idCmp = getId().compareTo(o.getId());
		return idCmp == 0 ? getVersion().compareTo(o.getVersion()) : idCmp;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2Package.INSTALLABLE_UNIT__ID:
				return getId();
			case P2Package.INSTALLABLE_UNIT__VERSION:
				return getVersion();
			case P2Package.INSTALLABLE_UNIT__ARTIFACTS:
				return getArtifacts();
			case P2Package.INSTALLABLE_UNIT__COPYRIGHT:
				if (resolve)
					return getCopyright();
				return basicGetCopyright();
			case P2Package.INSTALLABLE_UNIT__FILTER:
				return getFilter();
			case P2Package.INSTALLABLE_UNIT__FRAGMENTS:
				return getFragments();
			case P2Package.INSTALLABLE_UNIT__LICENSES:
				return getLicenses();
			case P2Package.INSTALLABLE_UNIT__META_REQUIREMENTS:
				return getMetaRequirements();
			case P2Package.INSTALLABLE_UNIT__PROVIDED_CAPABILITIES:
				return getProvidedCapabilities();
			case P2Package.INSTALLABLE_UNIT__REQUIREMENTS:
				return getRequirements();
			case P2Package.INSTALLABLE_UNIT__TOUCHPOINT_DATA:
				return getTouchpointData();
			case P2Package.INSTALLABLE_UNIT__TOUCHPOINT_TYPE:
				if (resolve)
					return getTouchpointType();
				return basicGetTouchpointType();
			case P2Package.INSTALLABLE_UNIT__UPDATE_DESCRIPTOR:
				if (resolve)
					return getUpdateDescriptor();
				return basicGetUpdateDescriptor();
			case P2Package.INSTALLABLE_UNIT__RESOLVED:
				return isResolved();
			case P2Package.INSTALLABLE_UNIT__SINGLETON:
				return isSingleton();
			case P2Package.INSTALLABLE_UNIT__PROPERTY_MAP:
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
			case P2Package.INSTALLABLE_UNIT__ARTIFACTS:
				return ((InternalEList<?>) getArtifacts()).basicRemove(otherEnd, msgs);
			case P2Package.INSTALLABLE_UNIT__COPYRIGHT:
				return basicSetCopyright(null, msgs);
			case P2Package.INSTALLABLE_UNIT__LICENSES:
				return ((InternalEList<?>) getLicenses()).basicRemove(otherEnd, msgs);
			case P2Package.INSTALLABLE_UNIT__META_REQUIREMENTS:
				return ((InternalEList<?>) getMetaRequirements()).basicRemove(otherEnd, msgs);
			case P2Package.INSTALLABLE_UNIT__PROVIDED_CAPABILITIES:
				return ((InternalEList<?>) getProvidedCapabilities()).basicRemove(otherEnd, msgs);
			case P2Package.INSTALLABLE_UNIT__REQUIREMENTS:
				return ((InternalEList<?>) getRequirements()).basicRemove(otherEnd, msgs);
			case P2Package.INSTALLABLE_UNIT__TOUCHPOINT_DATA:
				return ((InternalEList<?>) getTouchpointData()).basicRemove(otherEnd, msgs);
			case P2Package.INSTALLABLE_UNIT__TOUCHPOINT_TYPE:
				return basicSetTouchpointType(null, msgs);
			case P2Package.INSTALLABLE_UNIT__UPDATE_DESCRIPTOR:
				return basicSetUpdateDescriptor(null, msgs);
			case P2Package.INSTALLABLE_UNIT__PROPERTY_MAP:
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
			case P2Package.INSTALLABLE_UNIT__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case P2Package.INSTALLABLE_UNIT__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case P2Package.INSTALLABLE_UNIT__ARTIFACTS:
				return artifacts != null && !artifacts.isEmpty();
			case P2Package.INSTALLABLE_UNIT__COPYRIGHT:
				return copyright != null;
			case P2Package.INSTALLABLE_UNIT__FILTER:
				return filter != null;
			case P2Package.INSTALLABLE_UNIT__FRAGMENTS:
				return fragments != null && !fragments.isEmpty();
			case P2Package.INSTALLABLE_UNIT__LICENSES:
				return licenses != null && !licenses.isEmpty();
			case P2Package.INSTALLABLE_UNIT__META_REQUIREMENTS:
				return metaRequirements != null && !metaRequirements.isEmpty();
			case P2Package.INSTALLABLE_UNIT__PROVIDED_CAPABILITIES:
				return providedCapabilities != null && !providedCapabilities.isEmpty();
			case P2Package.INSTALLABLE_UNIT__REQUIREMENTS:
				return requirements != null && !requirements.isEmpty();
			case P2Package.INSTALLABLE_UNIT__TOUCHPOINT_DATA:
				return touchpointData != null && !touchpointData.isEmpty();
			case P2Package.INSTALLABLE_UNIT__TOUCHPOINT_TYPE:
				return touchpointType != null;
			case P2Package.INSTALLABLE_UNIT__UPDATE_DESCRIPTOR:
				return updateDescriptor != null;
			case P2Package.INSTALLABLE_UNIT__RESOLVED:
				return ((eFlags & RESOLVED_EFLAG) != 0) != RESOLVED_EDEFAULT;
			case P2Package.INSTALLABLE_UNIT__SINGLETON:
				return ((eFlags & SINGLETON_EFLAG) != 0) != SINGLETON_EDEFAULT;
			case P2Package.INSTALLABLE_UNIT__PROPERTY_MAP:
				return propertyMap != null && !propertyMap.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof IInstallableUnit))
			return false;
		final IInstallableUnit other = (IInstallableUnit) obj;
		String thisId = StringUtils.trimmedOrNull(id);
		String otherId = StringUtils.trimmedOrNull(other.getId());

		if (thisId == null) {
			if (otherId != null)
				return false;
		} else if (!thisId.equals(otherId))
			return false;
		if (getVersion() == null) {
			if (other.getVersion() != null)
				return false;

			if (other instanceof InstallableUnitImpl) {
				URI thisProxyURI = eProxyURI();
				URI otherProxyURI = ((InstallableUnitImpl) other).eProxyURI();

				if (thisProxyURI != null)
					return thisProxyURI.equals(otherProxyURI);

				if (otherProxyURI != null)
					return false;
			}
		} else if (!getVersion().equals(other.getVersion()))
			return false;

		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case P2Package.INSTALLABLE_UNIT__ID:
				setId((String) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__VERSION:
				setVersion((Version) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__ARTIFACTS:
				getArtifacts().clear();
				getArtifacts().addAll((Collection<? extends IArtifactKey>) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__COPYRIGHT:
				setCopyright((ICopyright) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__FILTER:
				setFilter((IMatchExpression<IInstallableUnit>) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__FRAGMENTS:
				getFragments().clear();
				getFragments().addAll((Collection<? extends IInstallableUnitFragment>) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__LICENSES:
				getLicenses().clear();
				getLicenses().addAll((Collection<? extends ILicense>) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__META_REQUIREMENTS:
				getMetaRequirements().clear();
				getMetaRequirements().addAll((Collection<? extends IRequirement>) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__PROVIDED_CAPABILITIES:
				getProvidedCapabilities().clear();
				getProvidedCapabilities().addAll((Collection<? extends IProvidedCapability>) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__REQUIREMENTS:
				getRequirements().clear();
				getRequirements().addAll((Collection<? extends IRequirement>) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__TOUCHPOINT_DATA:
				getTouchpointData().clear();
				getTouchpointData().addAll((Collection<? extends ITouchpointData>) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__TOUCHPOINT_TYPE:
				setTouchpointType((ITouchpointType) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__UPDATE_DESCRIPTOR:
				setUpdateDescriptor((IUpdateDescriptor) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__RESOLVED:
				setResolved((Boolean) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__SINGLETON:
				setSingleton((Boolean) newValue);
				return;
			case P2Package.INSTALLABLE_UNIT__PROPERTY_MAP:
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
		return P2Package.Literals.INSTALLABLE_UNIT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.INSTALLABLE_UNIT__ID:
				setId(ID_EDEFAULT);
				return;
			case P2Package.INSTALLABLE_UNIT__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case P2Package.INSTALLABLE_UNIT__ARTIFACTS:
				getArtifacts().clear();
				return;
			case P2Package.INSTALLABLE_UNIT__COPYRIGHT:
				setCopyright((ICopyright) null);
				return;
			case P2Package.INSTALLABLE_UNIT__FILTER:
				setFilter((IMatchExpression<IInstallableUnit>) null);
				return;
			case P2Package.INSTALLABLE_UNIT__FRAGMENTS:
				getFragments().clear();
				return;
			case P2Package.INSTALLABLE_UNIT__LICENSES:
				getLicenses().clear();
				return;
			case P2Package.INSTALLABLE_UNIT__META_REQUIREMENTS:
				getMetaRequirements().clear();
				return;
			case P2Package.INSTALLABLE_UNIT__PROVIDED_CAPABILITIES:
				getProvidedCapabilities().clear();
				return;
			case P2Package.INSTALLABLE_UNIT__REQUIREMENTS:
				getRequirements().clear();
				return;
			case P2Package.INSTALLABLE_UNIT__TOUCHPOINT_DATA:
				getTouchpointData().clear();
				return;
			case P2Package.INSTALLABLE_UNIT__TOUCHPOINT_TYPE:
				setTouchpointType((ITouchpointType) null);
				return;
			case P2Package.INSTALLABLE_UNIT__UPDATE_DESCRIPTOR:
				setUpdateDescriptor((IUpdateDescriptor) null);
				return;
			case P2Package.INSTALLABLE_UNIT__RESOLVED:
				setResolved(RESOLVED_EDEFAULT);
				return;
			case P2Package.INSTALLABLE_UNIT__SINGLETON:
				setSingleton(SINGLETON_EDEFAULT);
				return;
			case P2Package.INSTALLABLE_UNIT__PROPERTY_MAP:
				getPropertyMap().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IArtifactKey> getArtifacts() {
		if (artifacts == null) {
			artifacts = new EObjectContainmentEList.Resolving<>(IArtifactKey.class, this,
					P2Package.INSTALLABLE_UNIT__ARTIFACTS);
		}
		return artifacts;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ICopyright getCopyright() {
		if (copyright != null && ((EObject) copyright).eIsProxy()) {
			InternalEObject oldCopyright = (InternalEObject) copyright;
			copyright = (ICopyright) eResolveProxy(oldCopyright);
			if (copyright != oldCopyright) {
				InternalEObject newCopyright = (InternalEObject) copyright;
				NotificationChain msgs = oldCopyright.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT__COPYRIGHT, null, null);
				if (newCopyright.eInternalContainer() == null) {
					msgs = newCopyright.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT__COPYRIGHT, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, P2Package.INSTALLABLE_UNIT__COPYRIGHT,
							oldCopyright, copyright));
			}
		}
		return copyright;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public ICopyright getCopyright(String locale) {
		return RepositoryTranslationSupport.getInstance((MetadataRepository) eContainer()).getCopyright(this, locale);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IMatchExpression<IInstallableUnit> getFilter() {
		return filter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IInstallableUnitFragment> getFragments() {
		if (fragments == null) {
			fragments = new EObjectResolvingEList<>(IInstallableUnitFragment.class, this,
					P2Package.INSTALLABLE_UNIT__FRAGMENTS);
		}
		return fragments;
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
	public EList<ILicense> getLicenses() {
		if (licenses == null) {
			licenses = new EObjectContainmentEList.Resolving<>(ILicense.class, this,
					P2Package.INSTALLABLE_UNIT__LICENSES);
		}
		return licenses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public EList<ILicense> getLicenses(String locale) {
		EList<ILicense> licenses = new BasicEList<>();
		for (ILicense license : RepositoryTranslationSupport.getInstance((MetadataRepository) eContainer())
				.getLicenses(this, locale))
			licenses.add(license);

		return licenses;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IRequirement> getMetaRequirements() {
		if (metaRequirements == null) {
			metaRequirements = new EObjectContainmentEList.Resolving<>(IRequirement.class, this,
					P2Package.INSTALLABLE_UNIT__META_REQUIREMENTS);
		}
		return metaRequirements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Map<String, String> getProperties() {
		// Retain the order of the properties
		//
		EMap<String, String> propertyEntries = getPropertyMap();
		int top = propertyEntries.size();
		if (top == 0)
			return Collections.emptyMap();

		if (top == 1) {
			Map.Entry<String, String> entry = propertyEntries.get(0);
			return Collections.singletonMap(entry.getKey(), entry.getValue());
		}

		OrderedProperties props = new OrderedProperties(top);
		for (int idx = 0; idx < top; ++idx) {
			Map.Entry<String, String> entry = propertyEntries.get(idx);
			props.put(entry.getKey(), entry.getValue());
		}
		return props;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public String getProperty(String key) {
		return getPropertyMap().get(key);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public String getProperty(String key, String locale) {
		return RepositoryTranslationSupport.getInstance((MetadataRepository) eContainer()).getIUProperty(this, key,
				locale);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, String> getPropertyMap() {
		if (propertyMap == null) {
			propertyMap = new EcoreEMap<>(P2Package.Literals.PROPERTY, PropertyImpl.class, this,
					P2Package.INSTALLABLE_UNIT__PROPERTY_MAP);
		}
		return propertyMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IProvidedCapability> getProvidedCapabilities() {
		if (providedCapabilities == null) {
			providedCapabilities = new EObjectContainmentEList.Resolving<>(IProvidedCapability.class,
					this, P2Package.INSTALLABLE_UNIT__PROVIDED_CAPABILITIES);
		}
		return providedCapabilities;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<IRequirement> getRequirements() {
		if (requirements == null) {
			requirements = new EObjectContainmentEList.Resolving<>(IRequirement.class, this,
					P2Package.INSTALLABLE_UNIT__REQUIREMENTS);
		}
		return requirements;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ITouchpointData> getTouchpointData() {
		if (touchpointData == null) {
			touchpointData = new EObjectContainmentEList.Resolving<>(ITouchpointData.class, this,
					P2Package.INSTALLABLE_UNIT__TOUCHPOINT_DATA);
		}
		return touchpointData;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public ITouchpointType getTouchpointType() {
		return touchpointType != null ? touchpointType : eIsProxy() ? null : ITouchpointType.NONE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IUpdateDescriptor getUpdateDescriptor() {
		if (updateDescriptor != null && ((EObject) updateDescriptor).eIsProxy()) {
			InternalEObject oldUpdateDescriptor = (InternalEObject) updateDescriptor;
			updateDescriptor = (IUpdateDescriptor) eResolveProxy(oldUpdateDescriptor);
			if (updateDescriptor != oldUpdateDescriptor) {
				InternalEObject newUpdateDescriptor = (InternalEObject) updateDescriptor;
				NotificationChain msgs = oldUpdateDescriptor.eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT__UPDATE_DESCRIPTOR, null, null);
				if (newUpdateDescriptor.eInternalContainer() == null) {
					msgs = newUpdateDescriptor.eInverseAdd(this,
							EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT__UPDATE_DESCRIPTOR, null, msgs);
				}
				if (msgs != null)
					msgs.dispatch();
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE,
							P2Package.INSTALLABLE_UNIT__UPDATE_DESCRIPTOR, oldUpdateDescriptor, updateDescriptor));
			}
		}
		return updateDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Version getVersion() {
		return version;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isResolved() {
		return (eFlags & RESOLVED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSingleton() {
		return (eFlags & SINGLETON_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public boolean satisfies(IRequirement candidate) {
		return candidate.isMatch(this);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setCopyright(ICopyright newCopyright) {
		if (newCopyright != copyright) {
			NotificationChain msgs = null;
			if (copyright != null)
				msgs = ((InternalEObject) copyright).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT__COPYRIGHT, null, msgs);
			if (newCopyright != null)
				msgs = ((InternalEObject) newCopyright).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT__COPYRIGHT, null, msgs);
			msgs = basicSetCopyright(newCopyright, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.INSTALLABLE_UNIT__COPYRIGHT, newCopyright,
					newCopyright));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setFilter(IMatchExpression<IInstallableUnit> newFilter) {
		IMatchExpression<IInstallableUnit> oldFilter = filter;
		filter = newFilter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.INSTALLABLE_UNIT__FILTER, oldFilter,
					filter));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.INSTALLABLE_UNIT__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setResolved(boolean newResolved) {
		boolean oldResolved = (eFlags & RESOLVED_EFLAG) != 0;
		if (newResolved)
			eFlags |= RESOLVED_EFLAG;
		else
			eFlags &= ~RESOLVED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.INSTALLABLE_UNIT__RESOLVED, oldResolved,
					newResolved));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setSingleton(boolean newSingleton) {
		boolean oldSingleton = (eFlags & SINGLETON_EFLAG) != 0;
		if (newSingleton)
			eFlags |= SINGLETON_EFLAG;
		else
			eFlags &= ~SINGLETON_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.INSTALLABLE_UNIT__SINGLETON, oldSingleton,
					newSingleton));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	public void setTouchpointType(ITouchpointType newTouchpointType) {
		if (newTouchpointType == ITouchpointType.NONE)
			newTouchpointType = null;
		setTouchpointTypeGen(newTouchpointType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setTouchpointTypeGen(ITouchpointType newTouchpointType) {
		if (newTouchpointType != touchpointType) {
			NotificationChain msgs = null;
			if (touchpointType != null)
				msgs = ((InternalEObject) touchpointType).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT__TOUCHPOINT_TYPE, null, msgs);
			if (newTouchpointType != null)
				msgs = ((InternalEObject) newTouchpointType).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT__TOUCHPOINT_TYPE, null, msgs);
			msgs = basicSetTouchpointType(newTouchpointType, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.INSTALLABLE_UNIT__TOUCHPOINT_TYPE,
					newTouchpointType, newTouchpointType));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setUpdateDescriptor(IUpdateDescriptor newUpdateDescriptor) {
		if (newUpdateDescriptor != updateDescriptor) {
			NotificationChain msgs = null;
			if (updateDescriptor != null)
				msgs = ((InternalEObject) updateDescriptor).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT__UPDATE_DESCRIPTOR, null, msgs);
			if (newUpdateDescriptor != null)
				msgs = ((InternalEObject) newUpdateDescriptor).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2Package.INSTALLABLE_UNIT__UPDATE_DESCRIPTOR, null, msgs);
			msgs = basicSetUpdateDescriptor(newUpdateDescriptor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.INSTALLABLE_UNIT__UPDATE_DESCRIPTOR,
					newUpdateDescriptor, newUpdateDescriptor));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setVersion(Version newVersion) {
		Version oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.INSTALLABLE_UNIT__VERSION, oldVersion,
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", version: ");
		result.append(version);
		result.append(", filter: ");
		result.append(filter);
		result.append(", resolved: ");
		result.append((eFlags & RESOLVED_EFLAG) != 0);
		result.append(", singleton: ");
		result.append((eFlags & SINGLETON_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public IInstallableUnit unresolved() {
		return this;
	}

} // InstallableUnitImpl
