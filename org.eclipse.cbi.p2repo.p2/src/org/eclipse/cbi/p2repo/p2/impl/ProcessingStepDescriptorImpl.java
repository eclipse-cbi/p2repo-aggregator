/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 */
package org.eclipse.cbi.p2repo.p2.impl;

import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.p2.ProcessingStepDescriptor;
import org.eclipse.cbi.p2repo.util.Trivial;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.equinox.p2.repository.artifact.IProcessingStepDescriptor;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Processing Step Descriptor</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.ProcessingStepDescriptorImpl#getProcessorId <em>Processor Id</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.ProcessingStepDescriptorImpl#getData <em>Data</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.ProcessingStepDescriptorImpl#isRequired <em>Required</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProcessingStepDescriptorImpl extends MinimalEObjectImpl.Container implements ProcessingStepDescriptor {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The default value of the '{@link #getProcessorId() <em>Processor Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProcessorId()
	 * @generated
	 * @ordered
	 */
	protected static final String PROCESSOR_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProcessorId() <em>Processor Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getProcessorId()
	 * @generated
	 * @ordered
	 */
	protected String processorId = PROCESSOR_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected static final String DATA_EDEFAULT = "";

	/**
	 * The cached value of the '{@link #getData() <em>Data</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getData()
	 * @generated
	 * @ordered
	 */
	protected String data = DATA_EDEFAULT;

	/**
	 * The default value of the '{@link #isRequired() <em>Required</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final boolean REQUIRED_EDEFAULT = false;

	/**
	 * The flag representing the value of the '{@link #isRequired()
	 * <em>Required</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @see #isRequired()
	 * @generated
	 * @ordered
	 */
	protected static final int REQUIRED_EFLAG = 1 << 0;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessingStepDescriptorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2Package.PROCESSING_STEP_DESCRIPTOR__PROCESSOR_ID:
				return getProcessorId();
			case P2Package.PROCESSING_STEP_DESCRIPTOR__DATA:
				return getData();
			case P2Package.PROCESSING_STEP_DESCRIPTOR__REQUIRED:
				return isRequired();
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
			case P2Package.PROCESSING_STEP_DESCRIPTOR__PROCESSOR_ID:
				return PROCESSOR_ID_EDEFAULT == null ? processorId != null : !PROCESSOR_ID_EDEFAULT.equals(processorId);
			case P2Package.PROCESSING_STEP_DESCRIPTOR__DATA:
				return DATA_EDEFAULT == null ? data != null : !DATA_EDEFAULT.equals(data);
			case P2Package.PROCESSING_STEP_DESCRIPTOR__REQUIRED:
				return ((eFlags & REQUIRED_EFLAG) != 0) != REQUIRED_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean equals(Object v) {
		if (this == v)
			return true;
		if (v == null)
			return false;
		IProcessingStepDescriptor b = (IProcessingStepDescriptor) v;
		return isRequired() == b.isRequired() && Trivial.equalsAllowNull(getData(), b.getData())
				&& Trivial.equalsAllowNull(getProcessorId(), b.getProcessorId());
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case P2Package.PROCESSING_STEP_DESCRIPTOR__PROCESSOR_ID:
				setProcessorId((String) newValue);
				return;
			case P2Package.PROCESSING_STEP_DESCRIPTOR__DATA:
				setData((String) newValue);
				return;
			case P2Package.PROCESSING_STEP_DESCRIPTOR__REQUIRED:
				setRequired((Boolean) newValue);
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
		return P2Package.Literals.PROCESSING_STEP_DESCRIPTOR;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.PROCESSING_STEP_DESCRIPTOR__PROCESSOR_ID:
				setProcessorId(PROCESSOR_ID_EDEFAULT);
				return;
			case P2Package.PROCESSING_STEP_DESCRIPTOR__DATA:
				setData(DATA_EDEFAULT);
				return;
			case P2Package.PROCESSING_STEP_DESCRIPTOR__REQUIRED:
				setRequired(REQUIRED_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getData() {
		return data;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getProcessorId() {
		return processorId;
	}

	@Override
	public int hashCode() {
		int hash = isRequired() ? 17 : 1;

		hash = 17 * hash;
		if (getData() != null)
			hash += getData().hashCode();

		hash = 17 * hash;
		if (getProcessorId() != null)
			hash += getProcessorId().hashCode();

		return hash;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isRequired() {
		return (eFlags & REQUIRED_EFLAG) != 0;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setData(String newData) {
		String oldData = data;
		data = newData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.PROCESSING_STEP_DESCRIPTOR__DATA, oldData,
					data));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcessorId(String newProcessorId) {
		String oldProcessorId = processorId;
		processorId = newProcessorId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.PROCESSING_STEP_DESCRIPTOR__PROCESSOR_ID,
					oldProcessorId, processorId));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequired(boolean newRequired) {
		boolean oldRequired = (eFlags & REQUIRED_EFLAG) != 0;
		if (newRequired)
			eFlags |= REQUIRED_EFLAG;
		else
			eFlags &= ~REQUIRED_EFLAG;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.PROCESSING_STEP_DESCRIPTOR__REQUIRED,
					oldRequired, newRequired));
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
		result.append(" (processorId: ");
		result.append(processorId);
		result.append(", data: ");
		result.append(data);
		result.append(", required: ");
		result.append((eFlags & REQUIRED_EFLAG) != 0);
		result.append(')');
		return result.toString();
	}

} // ProcessingStepDescriptorImpl
