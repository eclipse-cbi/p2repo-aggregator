/**
 * Copyright (c) 2009, Cloudsmith Inc and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * - Cloudsmith Inc - initial API and implementation.
 * 
 *
 * $Id$
 */
package org.eclipse.b3.backend.evaluator.b3backend.impl;

import java.lang.reflect.Type;

import java.util.Collection;

import org.eclipse.b3.backend.evaluator.b3backend.B3FunctionType;
import org.eclipse.b3.backend.evaluator.b3backend.B3backendPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>B3 Function Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.b3.backend.evaluator.b3backend.impl.B3FunctionTypeImpl#getFunctionType <em>Function Type</em>}</li>
 *   <li>{@link org.eclipse.b3.backend.evaluator.b3backend.impl.B3FunctionTypeImpl#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link org.eclipse.b3.backend.evaluator.b3backend.impl.B3FunctionTypeImpl#getParameterTypes <em>Parameter Types</em>}</li>
 *   <li>{@link org.eclipse.b3.backend.evaluator.b3backend.impl.B3FunctionTypeImpl#isVarArgs <em>Var Args</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class B3FunctionTypeImpl extends EObjectImpl implements B3FunctionType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2009, Cloudsmith Inc and others.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\rContributors:\n- Cloudsmith Inc - initial API and implementation.\r";

	/**
	 * The cached value of the '{@link #getFunctionType() <em>Function Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionType()
	 * @generated
	 * @ordered
	 */
	protected Type functionType;

	/**
	 * The cached value of the '{@link #getReturnType() <em>Return Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReturnType()
	 * @generated
	 * @ordered
	 */
	protected Type returnType;

	/**
	 * The cached value of the '{@link #getParameterTypes() <em>Parameter Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> parameterTypes;

	/**
	 * The default value of the '{@link #isVarArgs() <em>Var Args</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVarArgs()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VAR_ARGS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isVarArgs() <em>Var Args</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVarArgs()
	 * @generated
	 * @ordered
	 */
	protected boolean varArgs = VAR_ARGS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected B3FunctionTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return B3backendPackage.Literals.B3_FUNCTION_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getFunctionType() {
		return functionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFunctionType(Type newFunctionType, NotificationChain msgs) {
		Type oldFunctionType = functionType;
		functionType = newFunctionType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, B3backendPackage.B3_FUNCTION_TYPE__FUNCTION_TYPE, oldFunctionType, newFunctionType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * functionType may not be an EObject, if not, no notification is generated.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setFunctionType(Type newFunctionType) {
		if(! (functionType instanceof EObject && newFunctionType instanceof EObject))
			functionType = newFunctionType;
		else {
		if (newFunctionType != functionType) {
			NotificationChain msgs = null;
			if (functionType != null)
				msgs = ((InternalEObject)functionType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - B3backendPackage.B3_FUNCTION_TYPE__FUNCTION_TYPE, null, msgs);
			if (newFunctionType != null)
				msgs = ((InternalEObject)newFunctionType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - B3backendPackage.B3_FUNCTION_TYPE__FUNCTION_TYPE, null, msgs);
			msgs = basicSetFunctionType(newFunctionType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, B3backendPackage.B3_FUNCTION_TYPE__FUNCTION_TYPE, newFunctionType, newFunctionType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * The generated version casts the return type to EObject !
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Type getReturnType() {
		if (returnType != null && returnType instanceof EObject && ((EObject)returnType).eIsProxy()) {
			InternalEObject oldReturnType = (InternalEObject)returnType;
			returnType = (Type)eResolveProxy(oldReturnType);
			if (returnType != oldReturnType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, B3backendPackage.B3_FUNCTION_TYPE__RETURN_TYPE, oldReturnType, returnType));
			}
		}
		return returnType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetReturnType(Type newReturnType, NotificationChain msgs) {
		Type oldReturnType = returnType;
		returnType = newReturnType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, B3backendPackage.B3_FUNCTION_TYPE__RETURN_TYPE, oldReturnType, newReturnType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * returnType may not be an EObject, if not, no notification is sent.
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public void setReturnType(Type newReturnType) {
		if(!(returnType instanceof EObject && newReturnType instanceof EObject))
			returnType = newReturnType;
		else {
		if (newReturnType != returnType) {
			NotificationChain msgs = null;
			if (returnType != null)
				msgs = ((InternalEObject)returnType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - B3backendPackage.B3_FUNCTION_TYPE__RETURN_TYPE, null, msgs);
			if (newReturnType != null)
				msgs = ((InternalEObject)newReturnType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - B3backendPackage.B3_FUNCTION_TYPE__RETURN_TYPE, null, msgs);
			msgs = basicSetReturnType(newReturnType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, B3backendPackage.B3_FUNCTION_TYPE__RETURN_TYPE, newReturnType, newReturnType));
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getParameterTypes() {
		if (parameterTypes == null) {
			parameterTypes = new EObjectContainmentEList<Type>(Type.class, this, B3backendPackage.B3_FUNCTION_TYPE__PARAMETER_TYPES);
		}
		return parameterTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVarArgs() {
		return varArgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVarArgs(boolean newVarArgs) {
		boolean oldVarArgs = varArgs;
		varArgs = newVarArgs;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, B3backendPackage.B3_FUNCTION_TYPE__VAR_ARGS, oldVarArgs, varArgs));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type[] getParameterTypesArray() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case B3backendPackage.B3_FUNCTION_TYPE__FUNCTION_TYPE:
				return basicSetFunctionType(null, msgs);
			case B3backendPackage.B3_FUNCTION_TYPE__RETURN_TYPE:
				return basicSetReturnType(null, msgs);
			case B3backendPackage.B3_FUNCTION_TYPE__PARAMETER_TYPES:
				return ((InternalEList<?>)getParameterTypes()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case B3backendPackage.B3_FUNCTION_TYPE__FUNCTION_TYPE:
				return getFunctionType();
			case B3backendPackage.B3_FUNCTION_TYPE__RETURN_TYPE:
				return getReturnType();
			case B3backendPackage.B3_FUNCTION_TYPE__PARAMETER_TYPES:
				return getParameterTypes();
			case B3backendPackage.B3_FUNCTION_TYPE__VAR_ARGS:
				return isVarArgs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case B3backendPackage.B3_FUNCTION_TYPE__FUNCTION_TYPE:
				setFunctionType((Type)newValue);
				return;
			case B3backendPackage.B3_FUNCTION_TYPE__RETURN_TYPE:
				setReturnType((Type)newValue);
				return;
			case B3backendPackage.B3_FUNCTION_TYPE__PARAMETER_TYPES:
				getParameterTypes().clear();
				getParameterTypes().addAll((Collection<? extends Type>)newValue);
				return;
			case B3backendPackage.B3_FUNCTION_TYPE__VAR_ARGS:
				setVarArgs((Boolean)newValue);
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
	public void eUnset(int featureID) {
		switch (featureID) {
			case B3backendPackage.B3_FUNCTION_TYPE__FUNCTION_TYPE:
				setFunctionType((Type)null);
				return;
			case B3backendPackage.B3_FUNCTION_TYPE__RETURN_TYPE:
				setReturnType((Type)null);
				return;
			case B3backendPackage.B3_FUNCTION_TYPE__PARAMETER_TYPES:
				getParameterTypes().clear();
				return;
			case B3backendPackage.B3_FUNCTION_TYPE__VAR_ARGS:
				setVarArgs(VAR_ARGS_EDEFAULT);
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
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case B3backendPackage.B3_FUNCTION_TYPE__FUNCTION_TYPE:
				return functionType != null;
			case B3backendPackage.B3_FUNCTION_TYPE__RETURN_TYPE:
				return returnType != null;
			case B3backendPackage.B3_FUNCTION_TYPE__PARAMETER_TYPES:
				return parameterTypes != null && !parameterTypes.isEmpty();
			case B3backendPackage.B3_FUNCTION_TYPE__VAR_ARGS:
				return varArgs != VAR_ARGS_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (varArgs: ");
		result.append(varArgs);
		result.append(')');
		return result.toString();
	}

} //B3FunctionTypeImpl