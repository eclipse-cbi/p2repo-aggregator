/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */
package org.eclipse.cbi.p2repo.p2.impl;

import java.util.Map;

import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.p2.TouchpointData;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.equinox.p2.metadata.ITouchpointInstruction;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Touchpoint Data</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.p2.impl.TouchpointDataImpl#getInstructionMap <em>Instruction Map</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TouchpointDataImpl extends MinimalEObjectImpl.Container implements TouchpointData {
	/**
	 * A set of bit flags representing the values of boolean attributes and whether unsettable features have been set.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected int eFlags = 0;

	/**
	 * The cached value of the '{@link #getInstructionMap() <em>Instruction Map</em>}' map.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getInstructionMap()
	 * @generated
	 * @ordered
	 */
	protected EMap<String, ITouchpointInstruction> instructionMap;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TouchpointDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case P2Package.TOUCHPOINT_DATA__INSTRUCTION_MAP:
				if (coreType)
					return getInstructionMap();
				else
					return getInstructionMap().map();
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
			case P2Package.TOUCHPOINT_DATA__INSTRUCTION_MAP:
				return ((InternalEList<?>) getInstructionMap()).basicRemove(otherEnd, msgs);
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
			case P2Package.TOUCHPOINT_DATA__INSTRUCTION_MAP:
				return instructionMap != null && !instructionMap.isEmpty();
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
			case P2Package.TOUCHPOINT_DATA__INSTRUCTION_MAP:
				((EStructuralFeature.Setting) getInstructionMap()).set(newValue);
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
		return P2Package.Literals.TOUCHPOINT_DATA;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case P2Package.TOUCHPOINT_DATA__INSTRUCTION_MAP:
				getInstructionMap().clear();
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
	public ITouchpointInstruction getInstruction(String key) {
		return getInstructionMap().get(key);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EMap<String, ITouchpointInstruction> getInstructionMap() {
		if (instructionMap == null) {
			instructionMap = new EcoreEMap<>(P2Package.Literals.INSTRUCTION_MAP,
					InstructionMapImpl.class, this, P2Package.TOUCHPOINT_DATA__INSTRUCTION_MAP);
		}
		return instructionMap;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Map<String, ITouchpointInstruction> getInstructions() {
		return getInstructionMap().map();
	}

} // TouchpointDataImpl
