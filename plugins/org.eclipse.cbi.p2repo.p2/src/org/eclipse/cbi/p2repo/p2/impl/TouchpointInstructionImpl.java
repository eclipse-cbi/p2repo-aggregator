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
package org.eclipse.cbi.p2repo.p2.impl;

import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.p2.TouchpointInstruction;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.equinox.p2.metadata.ITouchpointInstruction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Touchpoint Instruction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.TouchpointInstructionImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.TouchpointInstructionImpl#getImportAttribute <em>Import Attribute</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TouchpointInstructionImpl extends MinimalEObjectImpl.Container implements TouchpointInstruction {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The default value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected static final String BODY_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected String body = BODY_EDEFAULT;

	/**
	 * The default value of the '{@link #getImportAttribute() <em>Import Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportAttribute()
	 * @generated
	 * @ordered
	 */
	protected static final String IMPORT_ATTRIBUTE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getImportAttribute() <em>Import Attribute</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportAttribute()
	 * @generated
	 * @ordered
	 */
	protected String importAttribute = IMPORT_ATTRIBUTE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TouchpointInstructionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2Package.TOUCHPOINT_INSTRUCTION__BODY:
				return getBody();
			case P2Package.TOUCHPOINT_INSTRUCTION__IMPORT_ATTRIBUTE:
				return getImportAttribute();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case P2Package.TOUCHPOINT_INSTRUCTION__BODY:
				return BODY_EDEFAULT == null ? body != null : !BODY_EDEFAULT.equals(body);
			case P2Package.TOUCHPOINT_INSTRUCTION__IMPORT_ATTRIBUTE:
				return IMPORT_ATTRIBUTE_EDEFAULT == null ? importAttribute != null
						: !IMPORT_ATTRIBUTE_EDEFAULT.equals(importAttribute);
		}
		return super.eIsSet(featureID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if ((obj == null) || !(obj instanceof ITouchpointInstruction))
			return false;
		ITouchpointInstruction other = (ITouchpointInstruction) obj;
		if (body == null) {
			if (other.getBody() != null)
				return false;
		} else if (!body.equals(other.getBody()))
			return false;
		if (importAttribute == null) {
			if (other.getImportAttribute() != null)
				return false;
		} else if (!importAttribute.equals(other.getImportAttribute()))
			return false;
		return true;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case P2Package.TOUCHPOINT_INSTRUCTION__BODY:
				setBody((String) newValue);
				return;
			case P2Package.TOUCHPOINT_INSTRUCTION__IMPORT_ATTRIBUTE:
				setImportAttribute((String) newValue);
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
		return P2Package.Literals.TOUCHPOINT_INSTRUCTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.TOUCHPOINT_INSTRUCTION__BODY:
				setBody(BODY_EDEFAULT);
				return;
			case P2Package.TOUCHPOINT_INSTRUCTION__IMPORT_ATTRIBUTE:
				setImportAttribute(IMPORT_ATTRIBUTE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getImportAttribute() {
		return importAttribute;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((body == null) ? 0 : body.hashCode());
		result = prime * result + ((importAttribute == null) ? 0 : importAttribute.hashCode());
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBody(String newBody) {
		String oldBody = body;
		body = newBody;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.TOUCHPOINT_INSTRUCTION__BODY, oldBody,
					body));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setImportAttribute(String newImportAttribute) {
		String oldImportAttribute = importAttribute;
		importAttribute = newImportAttribute;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, P2Package.TOUCHPOINT_INSTRUCTION__IMPORT_ATTRIBUTE,
					oldImportAttribute, importAttribute));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy())
			return super.toString();

		return "Instruction[" + body + ',' + importAttribute + ']';
	}

} // TouchpointInstructionImpl
