/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.b3.backend.evaluator.b3backend.impl;

import java.lang.reflect.Type;

import org.eclipse.b3.backend.core.LValue;
import org.eclipse.b3.backend.evaluator.BackendHelper;
import org.eclipse.b3.backend.evaluator.EcoreFeatureLValue;
import org.eclipse.b3.backend.evaluator.PojoFeatureLValue;
import org.eclipse.b3.backend.evaluator.b3backend.B3backendPackage;
import org.eclipse.b3.backend.evaluator.b3backend.BExecutionContext;
import org.eclipse.b3.backend.evaluator.b3backend.BExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BFeatureExpression;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>BFeature Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BFeatureExpressionImpl#getObjExpr <em>Obj Expr</em>}</li>
 * <li>{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BFeatureExpressionImpl#getFeatureName <em>Feature Name
 * </em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BFeatureExpressionImpl extends BExpressionImpl implements BFeatureExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2009, Cloudsmith Inc and others.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\rContributors:\n- Cloudsmith Inc - initial API and implementation.\r";

	/**
	 * The cached value of the '{@link #getObjExpr() <em>Obj Expr</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getObjExpr()
	 * @generated
	 * @ordered
	 */
	protected BExpression objExpr;

	/**
	 * The default value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected static final String FEATURE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFeatureName() <em>Feature Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getFeatureName()
	 * @generated
	 * @ordered
	 */
	protected String featureName = FEATURE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BFeatureExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public NotificationChain basicSetObjExpr(BExpression newObjExpr, NotificationChain msgs) {
		BExpression oldObjExpr = objExpr;
		objExpr = newObjExpr;
		if(eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					B3backendPackage.BFEATURE_EXPRESSION__OBJ_EXPR, oldObjExpr, newObjExpr);
			if(msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch(featureID) {
		case B3backendPackage.BFEATURE_EXPRESSION__OBJ_EXPR:
			return getObjExpr();
		case B3backendPackage.BFEATURE_EXPRESSION__FEATURE_NAME:
			return getFeatureName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch(featureID) {
		case B3backendPackage.BFEATURE_EXPRESSION__OBJ_EXPR:
			return basicSetObjExpr(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch(featureID) {
		case B3backendPackage.BFEATURE_EXPRESSION__OBJ_EXPR:
			return objExpr != null;
		case B3backendPackage.BFEATURE_EXPRESSION__FEATURE_NAME:
			return FEATURE_NAME_EDEFAULT == null
					? featureName != null
					: !FEATURE_NAME_EDEFAULT.equals(featureName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch(featureID) {
		case B3backendPackage.BFEATURE_EXPRESSION__OBJ_EXPR:
			setObjExpr((BExpression) newValue);
			return;
		case B3backendPackage.BFEATURE_EXPRESSION__FEATURE_NAME:
			setFeatureName((String) newValue);
			return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return B3backendPackage.Literals.BFEATURE_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch(featureID) {
		case B3backendPackage.BFEATURE_EXPRESSION__OBJ_EXPR:
			setObjExpr((BExpression) null);
			return;
		case B3backendPackage.BFEATURE_EXPRESSION__FEATURE_NAME:
			setFeatureName(FEATURE_NAME_EDEFAULT);
			return;
		}
		super.eUnset(featureID);
	}

	/**
	 * Returns a feature from an object. If the instance is an EObject, the feature is obtained using
	 * Ecore technology. If the instance is a POJO, the feature is obtained using reflection and mapping
	 * of feature name to a getter (using Java Beans naming convention).
	 */
	@Override
	public Object evaluate(BExecutionContext ctx) throws Throwable {
		Object lhs = objExpr.evaluate(ctx);
		// for Ecore
		if(lhs instanceof EObject) {
			EObject eLhs = (EObject) lhs;
			EStructuralFeature feature = eLhs.eClass().getEStructuralFeature(featureName);
			if(feature == null)
				throw BackendHelper.createException(objExpr, "feature ''{0}'' is not a feature of the lhs expression",
						new Object[] { featureName });
			return eLhs.eGet(feature);
		}
		else {
			// use pojo reflection
			PojoFeatureLValue resultingLValue = new PojoFeatureLValue(lhs, featureName);
			Object result = null;
			try {
				if(resultingLValue.isGetable())
					result = resultingLValue.get();
			}
			catch(Throwable e) {
				throw BackendHelper.createException(objExpr, e, "failed to get feature ''{0}'' from lhs expression",
						new Object[] { featureName });
			}
			return result;
		}
	}

	@Override
	public Type getDeclaredType(BExecutionContext ctx) throws Throwable {
		return getLValue(ctx).getDeclaredType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public String getFeatureName() {
		return featureName;
	}

	@Override
	public LValue getLValue(BExecutionContext ctx) throws Throwable {
		Object lhs = objExpr.evaluate(ctx);
		// for Ecore
		if(lhs instanceof EObject) {
			EObject eLhs = (EObject) lhs;
			EStructuralFeature feature = eLhs.eClass().getEStructuralFeature(featureName);
			if(feature == null)
				throw BackendHelper.createException(objExpr, "feature ''{0}'' is not a feature of the lhs expression",
						new Object[] { featureName });
			return new EcoreFeatureLValue((EObject) lhs, feature);
		}
		else {
			return new PojoFeatureLValue(lhs, featureName);
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public BExpression getObjExpr() {
		return objExpr;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setFeatureName(String newFeatureName) {
		String oldFeatureName = featureName;
		featureName = newFeatureName;
		if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, B3backendPackage.BFEATURE_EXPRESSION__FEATURE_NAME,
					oldFeatureName, featureName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public void setObjExpr(BExpression newObjExpr) {
		if(newObjExpr != objExpr) {
			NotificationChain msgs = null;
			if(objExpr != null)
				msgs = ((InternalEObject) objExpr).eInverseRemove(this, EOPPOSITE_FEATURE_BASE
						- B3backendPackage.BFEATURE_EXPRESSION__OBJ_EXPR, null, msgs);
			if(newObjExpr != null)
				msgs = ((InternalEObject) newObjExpr).eInverseAdd(this, EOPPOSITE_FEATURE_BASE
						- B3backendPackage.BFEATURE_EXPRESSION__OBJ_EXPR, null, msgs);
			msgs = basicSetObjExpr(newObjExpr, msgs);
			if(msgs != null)
				msgs.dispatch();
		}
		else if(eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, B3backendPackage.BFEATURE_EXPRESSION__OBJ_EXPR,
					newObjExpr, newObjExpr));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String toString() {
		if(eIsProxy())
			return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (featureName: ");
		result.append(featureName);
		result.append(')');
		return result.toString();
	}
} // BFeatureExpressionImpl
