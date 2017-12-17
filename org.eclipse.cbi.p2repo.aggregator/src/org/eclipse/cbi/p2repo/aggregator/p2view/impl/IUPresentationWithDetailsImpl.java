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

import org.eclipse.cbi.p2repo.aggregator.p2view.IUDetails;
import org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentationWithDetails;
import org.eclipse.cbi.p2repo.aggregator.p2view.Licenses;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewFactory;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.cbi.p2repo.aggregator.p2view.Properties;
import org.eclipse.cbi.p2repo.aggregator.p2view.ProvidedCapabilities;
import org.eclipse.cbi.p2repo.aggregator.p2view.Requirements;
import org.eclipse.cbi.p2repo.aggregator.p2view.Touchpoints;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.equinox.p2.metadata.ICopyright;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IUpdateDescriptor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>IU Presentation With Details</b></em>'. <!--
 * end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUPresentationWithDetailsImpl#getRequirementsContainer <em>Requirements Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUPresentationWithDetailsImpl#getProvidedCapabilitiesContainer <em>Provided Capabilities Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUPresentationWithDetailsImpl#getPropertiesContainer <em>Properties Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUPresentationWithDetailsImpl#getTouchpointsContainer <em>Touchpoints Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUPresentationWithDetailsImpl#getUpdateDescriptor <em>Update Descriptor</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUPresentationWithDetailsImpl#getCopyright <em>Copyright</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUPresentationWithDetailsImpl#getLicensesContainer <em>Licenses Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.impl.IUPresentationWithDetailsImpl#isDetailsResolved <em>Details Resolved</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class IUPresentationWithDetailsImpl extends IUPresentationImpl implements IUPresentationWithDetails {
	/**
	 * The cached value of the '{@link #getRequirementsContainer() <em>Requirements Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementsContainer()
	 * @generated
	 * @ordered
	 */
	protected Requirements requirementsContainer;

	/**
	 * The cached value of the '{@link #getProvidedCapabilitiesContainer() <em>Provided Capabilities Container</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProvidedCapabilitiesContainer()
	 * @generated
	 * @ordered
	 */
	protected ProvidedCapabilities providedCapabilitiesContainer;

	/**
	 * The cached value of the '{@link #getPropertiesContainer() <em>Properties Container</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getPropertiesContainer()
	 * @generated
	 * @ordered
	 */
	protected Properties propertiesContainer;

	/**
	 * The cached value of the '{@link #getTouchpointsContainer() <em>Touchpoints Container</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getTouchpointsContainer()
	 * @generated
	 * @ordered
	 */
	protected Touchpoints touchpointsContainer;

	/**
	 * The cached value of the '{@link #getUpdateDescriptor() <em>Update Descriptor</em>}' reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #getUpdateDescriptor()
	 * @generated
	 * @ordered
	 */
	protected IUpdateDescriptor updateDescriptor;

	/**
	 * The cached value of the '{@link #getCopyright() <em>Copyright</em>}' containment reference.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getCopyright()
	 * @generated
	 * @ordered
	 */
	protected ICopyright copyright;

	/**
	 * The cached value of the '{@link #getLicensesContainer() <em>Licenses Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLicensesContainer()
	 * @generated
	 * @ordered
	 */
	protected Licenses licensesContainer;

	/**
	 * The default value of the '{@link #isDetailsResolved() <em>Details Resolved</em>}' attribute.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #isDetailsResolved()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DETAILS_RESOLVED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isDetailsResolved() <em>Details Resolved</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @see #isDetailsResolved()
	 * @generated
	 * @ordered
	 */
	protected static final int DETAILS_RESOLVED_EFLAG = 1 << 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected IUPresentationWithDetailsImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	protected IUPresentationWithDetailsImpl(IInstallableUnit iu) {
		super(iu);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCopyright(ICopyright newCopyright, NotificationChain msgs) {
		ICopyright oldCopyright = copyright;
		copyright = newCopyright;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__COPYRIGHT, oldCopyright, newCopyright);
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
	public NotificationChain basicSetLicensesContainer(Licenses newLicensesContainer, NotificationChain msgs) {
		Licenses oldLicensesContainer = licensesContainer;
		licensesContainer = newLicensesContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__LICENSES_CONTAINER, oldLicensesContainer,
					newLicensesContainer);
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
	public NotificationChain basicSetPropertiesContainer(Properties newPropertiesContainer, NotificationChain msgs) {
		Properties oldPropertiesContainer = propertiesContainer;
		propertiesContainer = newPropertiesContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROPERTIES_CONTAINER, oldPropertiesContainer,
					newPropertiesContainer);
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
	public NotificationChain basicSetProvidedCapabilitiesContainer(
			ProvidedCapabilities newProvidedCapabilitiesContainer, NotificationChain msgs) {
		ProvidedCapabilities oldProvidedCapabilitiesContainer = providedCapabilitiesContainer;
		providedCapabilitiesContainer = newProvidedCapabilitiesContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROVIDED_CAPABILITIES_CONTAINER,
					oldProvidedCapabilitiesContainer, newProvidedCapabilitiesContainer);
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
	public NotificationChain basicSetRequirementsContainer(Requirements newRequirementsContainer,
			NotificationChain msgs) {
		Requirements oldRequirementsContainer = requirementsContainer;
		requirementsContainer = newRequirementsContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__REQUIREMENTS_CONTAINER, oldRequirementsContainer,
					newRequirementsContainer);
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
	public NotificationChain basicSetTouchpointsContainer(Touchpoints newTouchpointsContainer, NotificationChain msgs) {
		Touchpoints oldTouchpointsContainer = touchpointsContainer;
		touchpointsContainer = newTouchpointsContainer;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__TOUCHPOINTS_CONTAINER, oldTouchpointsContainer,
					newTouchpointsContainer);
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
	public NotificationChain basicSetUpdateDescriptor(IUpdateDescriptor newUpdateDescriptor, NotificationChain msgs) {
		IUpdateDescriptor oldUpdateDescriptor = updateDescriptor;
		updateDescriptor = newUpdateDescriptor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__UPDATE_DESCRIPTOR, oldUpdateDescriptor,
					newUpdateDescriptor);
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
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == IUDetails.class) {
			switch (derivedFeatureID) {
				case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__REQUIREMENTS_CONTAINER:
					return P2viewPackage.IU_DETAILS__REQUIREMENTS_CONTAINER;
				case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROVIDED_CAPABILITIES_CONTAINER:
					return P2viewPackage.IU_DETAILS__PROVIDED_CAPABILITIES_CONTAINER;
				case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROPERTIES_CONTAINER:
					return P2viewPackage.IU_DETAILS__PROPERTIES_CONTAINER;
				case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__TOUCHPOINTS_CONTAINER:
					return P2viewPackage.IU_DETAILS__TOUCHPOINTS_CONTAINER;
				case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__UPDATE_DESCRIPTOR:
					return P2viewPackage.IU_DETAILS__UPDATE_DESCRIPTOR;
				case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__COPYRIGHT:
					return P2viewPackage.IU_DETAILS__COPYRIGHT;
				case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__LICENSES_CONTAINER:
					return P2viewPackage.IU_DETAILS__LICENSES_CONTAINER;
				default:
					return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == IUDetails.class) {
			switch (baseFeatureID) {
				case P2viewPackage.IU_DETAILS__REQUIREMENTS_CONTAINER:
					return P2viewPackage.IU_PRESENTATION_WITH_DETAILS__REQUIREMENTS_CONTAINER;
				case P2viewPackage.IU_DETAILS__PROVIDED_CAPABILITIES_CONTAINER:
					return P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROVIDED_CAPABILITIES_CONTAINER;
				case P2viewPackage.IU_DETAILS__PROPERTIES_CONTAINER:
					return P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROPERTIES_CONTAINER;
				case P2viewPackage.IU_DETAILS__TOUCHPOINTS_CONTAINER:
					return P2viewPackage.IU_PRESENTATION_WITH_DETAILS__TOUCHPOINTS_CONTAINER;
				case P2viewPackage.IU_DETAILS__UPDATE_DESCRIPTOR:
					return P2viewPackage.IU_PRESENTATION_WITH_DETAILS__UPDATE_DESCRIPTOR;
				case P2viewPackage.IU_DETAILS__COPYRIGHT:
					return P2viewPackage.IU_PRESENTATION_WITH_DETAILS__COPYRIGHT;
				case P2viewPackage.IU_DETAILS__LICENSES_CONTAINER:
					return P2viewPackage.IU_PRESENTATION_WITH_DETAILS__LICENSES_CONTAINER;
				default:
					return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__REQUIREMENTS_CONTAINER:
				return getRequirementsContainer();
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROVIDED_CAPABILITIES_CONTAINER:
				return getProvidedCapabilitiesContainer();
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROPERTIES_CONTAINER:
				return getPropertiesContainer();
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__TOUCHPOINTS_CONTAINER:
				return getTouchpointsContainer();
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__UPDATE_DESCRIPTOR:
				return getUpdateDescriptor();
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__COPYRIGHT:
				return getCopyright();
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__LICENSES_CONTAINER:
				return getLicensesContainer();
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__DETAILS_RESOLVED:
				return isDetailsResolved();
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
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__REQUIREMENTS_CONTAINER:
				return basicSetRequirementsContainer(null, msgs);
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROVIDED_CAPABILITIES_CONTAINER:
				return basicSetProvidedCapabilitiesContainer(null, msgs);
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROPERTIES_CONTAINER:
				return basicSetPropertiesContainer(null, msgs);
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__TOUCHPOINTS_CONTAINER:
				return basicSetTouchpointsContainer(null, msgs);
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__UPDATE_DESCRIPTOR:
				return basicSetUpdateDescriptor(null, msgs);
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__COPYRIGHT:
				return basicSetCopyright(null, msgs);
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__LICENSES_CONTAINER:
				return basicSetLicensesContainer(null, msgs);
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
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__REQUIREMENTS_CONTAINER:
				return requirementsContainer != null;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROVIDED_CAPABILITIES_CONTAINER:
				return providedCapabilitiesContainer != null;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROPERTIES_CONTAINER:
				return propertiesContainer != null;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__TOUCHPOINTS_CONTAINER:
				return touchpointsContainer != null;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__UPDATE_DESCRIPTOR:
				return updateDescriptor != null;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__COPYRIGHT:
				return copyright != null;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__LICENSES_CONTAINER:
				return licensesContainer != null;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__DETAILS_RESOLVED:
				return ((eFlags & DETAILS_RESOLVED_EFLAG) != 0) != DETAILS_RESOLVED_EDEFAULT;
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
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__REQUIREMENTS_CONTAINER:
				setRequirementsContainer((Requirements) newValue);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROVIDED_CAPABILITIES_CONTAINER:
				setProvidedCapabilitiesContainer((ProvidedCapabilities) newValue);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROPERTIES_CONTAINER:
				setPropertiesContainer((Properties) newValue);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__TOUCHPOINTS_CONTAINER:
				setTouchpointsContainer((Touchpoints) newValue);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__UPDATE_DESCRIPTOR:
				setUpdateDescriptor((IUpdateDescriptor) newValue);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__COPYRIGHT:
				setCopyright((ICopyright) newValue);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__LICENSES_CONTAINER:
				setLicensesContainer((Licenses) newValue);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__DETAILS_RESOLVED:
				setDetailsResolved((Boolean) newValue);
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
		return P2viewPackage.Literals.IU_PRESENTATION_WITH_DETAILS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__REQUIREMENTS_CONTAINER:
				setRequirementsContainer((Requirements) null);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROVIDED_CAPABILITIES_CONTAINER:
				setProvidedCapabilitiesContainer((ProvidedCapabilities) null);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROPERTIES_CONTAINER:
				setPropertiesContainer((Properties) null);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__TOUCHPOINTS_CONTAINER:
				setTouchpointsContainer((Touchpoints) null);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__UPDATE_DESCRIPTOR:
				setUpdateDescriptor((IUpdateDescriptor) null);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__COPYRIGHT:
				setCopyright((ICopyright) null);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__LICENSES_CONTAINER:
				setLicensesContainer((Licenses) null);
				return;
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__DETAILS_RESOLVED:
				setDetailsResolved(DETAILS_RESOLVED_EDEFAULT);
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
	public ICopyright getCopyright() {
		if (!isDetailsResolved())
			resolveDetails();

		return copyright;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Licenses getLicensesContainer() {
		return licensesContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Properties getPropertiesContainer() {
		if (!isDetailsResolved())
			resolveDetails();

		return propertiesContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public ProvidedCapabilities getProvidedCapabilitiesContainer() {
		if (!isDetailsResolved())
			resolveDetails();

		return providedCapabilitiesContainer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Requirements getRequirementsContainer() {
		if (!isDetailsResolved())
			resolveDetails();

		return requirementsContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Touchpoints getTouchpointsContainer() {
		if (!isDetailsResolved())
			resolveDetails();

		return touchpointsContainer;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public IUpdateDescriptor getUpdateDescriptor() {
		if (!isDetailsResolved())
			resolveDetails();

		return updateDescriptor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isDetailsResolved() {
		return (eFlags & DETAILS_RESOLVED_EFLAG) != 0;
	}

	private void resolveDetails() {
		IUDetails iuDetails = P2viewFactory.eINSTANCE.createIUDetails(getInstallableUnit());

		setRequirementsContainer(iuDetails.getRequirementsContainer());
		setProvidedCapabilitiesContainer(iuDetails.getProvidedCapabilitiesContainer());
		setPropertiesContainer(iuDetails.getPropertiesContainer());
		setTouchpointsContainer(iuDetails.getTouchpointsContainer());
		setUpdateDescriptor(iuDetails.getUpdateDescriptor());
		setCopyright(iuDetails.getCopyright());
		setLicensesContainer(iuDetails.getLicensesContainer());

		setDetailsResolved(true);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCopyright(ICopyright newCopyright) {
		if (newCopyright != copyright) {
			NotificationChain msgs = null;
			if (copyright != null)
				msgs = ((InternalEObject) copyright).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_PRESENTATION_WITH_DETAILS__COPYRIGHT, null, msgs);
			if (newCopyright != null)
				msgs = ((InternalEObject) newCopyright).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_PRESENTATION_WITH_DETAILS__COPYRIGHT, null, msgs);
			msgs = basicSetCopyright(newCopyright, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2viewPackage.IU_PRESENTATION_WITH_DETAILS__COPYRIGHT,
					newCopyright, newCopyright));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDetailsResolved(boolean newDetailsResolved) {
		boolean oldDetailsResolved = (eFlags & DETAILS_RESOLVED_EFLAG) != 0;
		if (newDetailsResolved)
			eFlags |= DETAILS_RESOLVED_EFLAG;
		else
			eFlags &= ~DETAILS_RESOLVED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__DETAILS_RESOLVED, oldDetailsResolved,
					newDetailsResolved));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLicensesContainer(Licenses newLicensesContainer) {
		if (newLicensesContainer != licensesContainer) {
			NotificationChain msgs = null;
			if (licensesContainer != null)
				msgs = ((InternalEObject) licensesContainer).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_PRESENTATION_WITH_DETAILS__LICENSES_CONTAINER, null,
						msgs);
			if (newLicensesContainer != null)
				msgs = ((InternalEObject) newLicensesContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_PRESENTATION_WITH_DETAILS__LICENSES_CONTAINER, null,
						msgs);
			msgs = basicSetLicensesContainer(newLicensesContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__LICENSES_CONTAINER, newLicensesContainer,
					newLicensesContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPropertiesContainer(Properties newPropertiesContainer) {
		if (newPropertiesContainer != propertiesContainer) {
			NotificationChain msgs = null;
			if (propertiesContainer != null)
				msgs = ((InternalEObject) propertiesContainer).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROPERTIES_CONTAINER, null,
						msgs);
			if (newPropertiesContainer != null)
				msgs = ((InternalEObject) newPropertiesContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROPERTIES_CONTAINER, null,
						msgs);
			msgs = basicSetPropertiesContainer(newPropertiesContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROPERTIES_CONTAINER, newPropertiesContainer,
					newPropertiesContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setProvidedCapabilitiesContainer(ProvidedCapabilities newProvidedCapabilitiesContainer) {
		if (newProvidedCapabilitiesContainer != providedCapabilitiesContainer) {
			NotificationChain msgs = null;
			if (providedCapabilitiesContainer != null)
				msgs = ((InternalEObject) providedCapabilitiesContainer).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE
								- P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROVIDED_CAPABILITIES_CONTAINER,
						null, msgs);
			if (newProvidedCapabilitiesContainer != null)
				msgs = ((InternalEObject) newProvidedCapabilitiesContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE
								- P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROVIDED_CAPABILITIES_CONTAINER,
						null, msgs);
			msgs = basicSetProvidedCapabilitiesContainer(newProvidedCapabilitiesContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__PROVIDED_CAPABILITIES_CONTAINER,
					newProvidedCapabilitiesContainer, newProvidedCapabilitiesContainer));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequirementsContainer(Requirements newRequirementsContainer) {
		if (newRequirementsContainer != requirementsContainer) {
			NotificationChain msgs = null;
			if (requirementsContainer != null)
				msgs = ((InternalEObject) requirementsContainer).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_PRESENTATION_WITH_DETAILS__REQUIREMENTS_CONTAINER,
						null, msgs);
			if (newRequirementsContainer != null)
				msgs = ((InternalEObject) newRequirementsContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_PRESENTATION_WITH_DETAILS__REQUIREMENTS_CONTAINER,
						null, msgs);
			msgs = basicSetRequirementsContainer(newRequirementsContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__REQUIREMENTS_CONTAINER, newRequirementsContainer,
					newRequirementsContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setTouchpointsContainer(Touchpoints newTouchpointsContainer) {
		if (newTouchpointsContainer != touchpointsContainer) {
			NotificationChain msgs = null;
			if (touchpointsContainer != null)
				msgs = ((InternalEObject) touchpointsContainer).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_PRESENTATION_WITH_DETAILS__TOUCHPOINTS_CONTAINER,
						null, msgs);
			if (newTouchpointsContainer != null)
				msgs = ((InternalEObject) newTouchpointsContainer).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_PRESENTATION_WITH_DETAILS__TOUCHPOINTS_CONTAINER,
						null, msgs);
			msgs = basicSetTouchpointsContainer(newTouchpointsContainer, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__TOUCHPOINTS_CONTAINER, newTouchpointsContainer,
					newTouchpointsContainer));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUpdateDescriptor(IUpdateDescriptor newUpdateDescriptor) {
		if (newUpdateDescriptor != updateDescriptor) {
			NotificationChain msgs = null;
			if (updateDescriptor != null)
				msgs = ((InternalEObject) updateDescriptor).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_PRESENTATION_WITH_DETAILS__UPDATE_DESCRIPTOR, null,
						msgs);
			if (newUpdateDescriptor != null)
				msgs = ((InternalEObject) newUpdateDescriptor).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - P2viewPackage.IU_PRESENTATION_WITH_DETAILS__UPDATE_DESCRIPTOR, null,
						msgs);
			msgs = basicSetUpdateDescriptor(newUpdateDescriptor, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET,
					P2viewPackage.IU_PRESENTATION_WITH_DETAILS__UPDATE_DESCRIPTOR, newUpdateDescriptor,
					newUpdateDescriptor));
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
		result.append(" (detailsResolved: ");
		result.append((eFlags & DETAILS_RESOLVED_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} // IUPresentationWithDetailsImpl
