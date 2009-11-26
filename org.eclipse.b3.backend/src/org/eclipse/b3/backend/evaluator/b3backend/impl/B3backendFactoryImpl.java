/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.b3.backend.evaluator.b3backend.impl;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import org.eclipse.b3.backend.core.B3EngineException;
import org.eclipse.b3.backend.core.B3FuncStore;
import org.eclipse.b3.backend.core.LValue;
import org.eclipse.b3.backend.core.ValueMap;
import org.eclipse.b3.backend.evaluator.b3backend.*;

import org.eclipse.core.runtime.CoreException;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class B3backendFactoryImpl extends EFactoryImpl implements B3backendFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2009, Cloudsmith Inc and others.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\rContributors:\n- Cloudsmith Inc - initial API and implementation.\r";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static B3backendFactory init() {
		try {
			B3backendFactory theB3backendFactory = (B3backendFactory)EPackage.Registry.INSTANCE.getEFactory("http://b3backend/1.0"); 
			if (theB3backendFactory != null) {
				return theB3backendFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new B3backendFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B3backendFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case B3backendPackage.BFILE_REFERENCE: return createBFileReference();
			case B3backendPackage.BLINE_REFERENCE: return createBLineReference();
			case B3backendPackage.BIF_EXPRESSION: return createBIfExpression();
			case B3backendPackage.BSWITCH_EXPRESSION: return createBSwitchExpression();
			case B3backendPackage.BCASE: return createBCase();
			case B3backendPackage.BTRY_EXPRESSION: return createBTryExpression();
			case B3backendPackage.BCATCH: return createBCatch();
			case B3backendPackage.BOR_EXPRESSION: return createBOrExpression();
			case B3backendPackage.BAND_EXPRESSION: return createBAndExpression();
			case B3backendPackage.BCHAINED_EXPRESSION: return createBChainedExpression();
			case B3backendPackage.BTHROW_EXPRESSION: return createBThrowExpression();
			case B3backendPackage.BUNARY_OP_EXPRESSION: return createBUnaryOpExpression();
			case B3backendPackage.BUNARY_POST_OP_EXPRESSION: return createBUnaryPostOpExpression();
			case B3backendPackage.BBINARY_OP_EXPRESSION: return createBBinaryOpExpression();
			case B3backendPackage.BCACHED_EXPRESSION: return createBCachedExpression();
			case B3backendPackage.BLITERAL_EXPRESSION: return createBLiteralExpression();
			case B3backendPackage.BLITERAL_LIST_EXPRESSION: return createBLiteralListExpression();
			case B3backendPackage.BLITERAL_MAP_EXPRESSION: return createBLiteralMapExpression();
			case B3backendPackage.BMAP_ENTRY: return createBMapEntry();
			case B3backendPackage.BFEATURE_EXPRESSION: return createBFeatureExpression();
			case B3backendPackage.BAT_EXPRESSION: return createBAtExpression();
			case B3backendPackage.BVARIABLE_EXPRESSION: return createBVariableExpression();
			case B3backendPackage.BCALL_EXPRESSION: return createBCallExpression();
			case B3backendPackage.BLITERAL_ANY: return createBLiteralAny();
			case B3backendPackage.BCREATE_EXPRESSION: return createBCreateExpression();
			case B3backendPackage.BGUARD_INSTANCE: return createBGuardInstance();
			case B3backendPackage.BGUARD_EXPRESSION: return createBGuardExpression();
			case B3backendPackage.BSYSTEM_CONTEXT: return createBSystemContext();
			case B3backendPackage.BCONTEXT: return createBContext();
			case B3backendPackage.BINNER_CONTEXT: return createBInnerContext();
			case B3backendPackage.BINVOCATION_CONTEXT: return createBInvocationContext();
			case B3backendPackage.BUNARY_PRE_OP_EXPRESSION: return createBUnaryPreOpExpression();
			case B3backendPackage.BASSIGNMENT_EXPRESSION: return createBAssignmentExpression();
			case B3backendPackage.B3_FUNCTION: return createB3Function();
			case B3backendPackage.BJAVA_FUNCTION: return createBJavaFunction();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case B3backendPackage.CORE_EXCEPTION:
				return createCoreExceptionFromString(eDataType, initialValue);
			case B3backendPackage.TYPE:
				return createTypeFromString(eDataType, initialValue);
			case B3backendPackage.OBJECT_ARRAY:
				return createObjectArrayFromString(eDataType, initialValue);
			case B3backendPackage.VALUE_MAP:
				return createValueMapFromString(eDataType, initialValue);
			case B3backendPackage.B3_ENGINE_EXCEPTION:
				return createB3EngineExceptionFromString(eDataType, initialValue);
			case B3backendPackage.THROWABLE:
				return createThrowableFromString(eDataType, initialValue);
			case B3backendPackage.LVALUE:
				return createLValueFromString(eDataType, initialValue);
			case B3backendPackage.TYPE_ARRAY:
				return createTypeArrayFromString(eDataType, initialValue);
			case B3backendPackage.METHOD:
				return createMethodFromString(eDataType, initialValue);
			case B3backendPackage.TYPE_VARIABLE_ARRAY:
				return createTypeVariableArrayFromString(eDataType, initialValue);
			case B3backendPackage.FUNC_STORE:
				return createFuncStoreFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case B3backendPackage.CORE_EXCEPTION:
				return convertCoreExceptionToString(eDataType, instanceValue);
			case B3backendPackage.TYPE:
				return convertTypeToString(eDataType, instanceValue);
			case B3backendPackage.OBJECT_ARRAY:
				return convertObjectArrayToString(eDataType, instanceValue);
			case B3backendPackage.VALUE_MAP:
				return convertValueMapToString(eDataType, instanceValue);
			case B3backendPackage.B3_ENGINE_EXCEPTION:
				return convertB3EngineExceptionToString(eDataType, instanceValue);
			case B3backendPackage.THROWABLE:
				return convertThrowableToString(eDataType, instanceValue);
			case B3backendPackage.LVALUE:
				return convertLValueToString(eDataType, instanceValue);
			case B3backendPackage.TYPE_ARRAY:
				return convertTypeArrayToString(eDataType, instanceValue);
			case B3backendPackage.METHOD:
				return convertMethodToString(eDataType, instanceValue);
			case B3backendPackage.TYPE_VARIABLE_ARRAY:
				return convertTypeVariableArrayToString(eDataType, instanceValue);
			case B3backendPackage.FUNC_STORE:
				return convertFuncStoreToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BFileReference createBFileReference() {
		BFileReferenceImpl bFileReference = new BFileReferenceImpl();
		return bFileReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BLineReference createBLineReference() {
		BLineReferenceImpl bLineReference = new BLineReferenceImpl();
		return bLineReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BIfExpression createBIfExpression() {
		BIfExpressionImpl bIfExpression = new BIfExpressionImpl();
		return bIfExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BSwitchExpression createBSwitchExpression() {
		BSwitchExpressionImpl bSwitchExpression = new BSwitchExpressionImpl();
		return bSwitchExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BCase createBCase() {
		BCaseImpl bCase = new BCaseImpl();
		return bCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BTryExpression createBTryExpression() {
		BTryExpressionImpl bTryExpression = new BTryExpressionImpl();
		return bTryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BCatch createBCatch() {
		BCatchImpl bCatch = new BCatchImpl();
		return bCatch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BOrExpression createBOrExpression() {
		BOrExpressionImpl bOrExpression = new BOrExpressionImpl();
		return bOrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BAndExpression createBAndExpression() {
		BAndExpressionImpl bAndExpression = new BAndExpressionImpl();
		return bAndExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BChainedExpression createBChainedExpression() {
		BChainedExpressionImpl bChainedExpression = new BChainedExpressionImpl();
		return bChainedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BThrowExpression createBThrowExpression() {
		BThrowExpressionImpl bThrowExpression = new BThrowExpressionImpl();
		return bThrowExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BUnaryOpExpression createBUnaryOpExpression() {
		BUnaryOpExpressionImpl bUnaryOpExpression = new BUnaryOpExpressionImpl();
		return bUnaryOpExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BUnaryPostOpExpression createBUnaryPostOpExpression() {
		BUnaryPostOpExpressionImpl bUnaryPostOpExpression = new BUnaryPostOpExpressionImpl();
		return bUnaryPostOpExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BBinaryOpExpression createBBinaryOpExpression() {
		BBinaryOpExpressionImpl bBinaryOpExpression = new BBinaryOpExpressionImpl();
		return bBinaryOpExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BCachedExpression createBCachedExpression() {
		BCachedExpressionImpl bCachedExpression = new BCachedExpressionImpl();
		return bCachedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BLiteralExpression createBLiteralExpression() {
		BLiteralExpressionImpl bLiteralExpression = new BLiteralExpressionImpl();
		return bLiteralExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BLiteralListExpression createBLiteralListExpression() {
		BLiteralListExpressionImpl bLiteralListExpression = new BLiteralListExpressionImpl();
		return bLiteralListExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BLiteralMapExpression createBLiteralMapExpression() {
		BLiteralMapExpressionImpl bLiteralMapExpression = new BLiteralMapExpressionImpl();
		return bLiteralMapExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BMapEntry createBMapEntry() {
		BMapEntryImpl bMapEntry = new BMapEntryImpl();
		return bMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BFeatureExpression createBFeatureExpression() {
		BFeatureExpressionImpl bFeatureExpression = new BFeatureExpressionImpl();
		return bFeatureExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BAtExpression createBAtExpression() {
		BAtExpressionImpl bAtExpression = new BAtExpressionImpl();
		return bAtExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BVariableExpression createBVariableExpression() {
		BVariableExpressionImpl bVariableExpression = new BVariableExpressionImpl();
		return bVariableExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BCallExpression createBCallExpression() {
		BCallExpressionImpl bCallExpression = new BCallExpressionImpl();
		return bCallExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BLiteralAny createBLiteralAny() {
		BLiteralAnyImpl bLiteralAny = new BLiteralAnyImpl();
		return bLiteralAny;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BCreateExpression createBCreateExpression() {
		BCreateExpressionImpl bCreateExpression = new BCreateExpressionImpl();
		return bCreateExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BGuardInstance createBGuardInstance() {
		BGuardInstanceImpl bGuardInstance = new BGuardInstanceImpl();
		return bGuardInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BGuardExpression createBGuardExpression() {
		BGuardExpressionImpl bGuardExpression = new BGuardExpressionImpl();
		return bGuardExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BSystemContext createBSystemContext() {
		BSystemContextImpl bSystemContext = new BSystemContextImpl();
		return bSystemContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BContext createBContext() {
		BContextImpl bContext = new BContextImpl();
		return bContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BInnerContext createBInnerContext() {
		BInnerContextImpl bInnerContext = new BInnerContextImpl();
		return bInnerContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BInvocationContext createBInvocationContext() {
		BInvocationContextImpl bInvocationContext = new BInvocationContextImpl();
		return bInvocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BUnaryPreOpExpression createBUnaryPreOpExpression() {
		BUnaryPreOpExpressionImpl bUnaryPreOpExpression = new BUnaryPreOpExpressionImpl();
		return bUnaryPreOpExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BAssignmentExpression createBAssignmentExpression() {
		BAssignmentExpressionImpl bAssignmentExpression = new BAssignmentExpressionImpl();
		return bAssignmentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B3Function createB3Function() {
		B3FunctionImpl b3Function = new B3FunctionImpl();
		return b3Function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BJavaFunction createBJavaFunction() {
		BJavaFunctionImpl bJavaFunction = new BJavaFunctionImpl();
		return bJavaFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CoreException createCoreExceptionFromString(EDataType eDataType, String initialValue) {
		return (CoreException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCoreExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type createTypeFromString(EDataType eDataType, String initialValue) {
		return (Type)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object[] createObjectArrayFromString(EDataType eDataType, String initialValue) {
		return (Object[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertObjectArrayToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueMap createValueMapFromString(EDataType eDataType, String initialValue) {
		return (ValueMap)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertValueMapToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B3EngineException createB3EngineExceptionFromString(EDataType eDataType, String initialValue) {
		return (B3EngineException)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertB3EngineExceptionToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Throwable createThrowableFromString(EDataType eDataType, String initialValue) {
		return (Throwable)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertThrowableToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LValue createLValueFromString(EDataType eDataType, String initialValue) {
		return (LValue)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLValueToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type[] createTypeArrayFromString(EDataType eDataType, String initialValue) {
		return (Type[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeArrayToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Method createMethodFromString(EDataType eDataType, String initialValue) {
		return (Method)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMethodToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public TypeVariable[] createTypeVariableArrayFromString(EDataType eDataType, String initialValue) {
		return (TypeVariable[])super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTypeVariableArrayToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B3FuncStore createFuncStoreFromString(EDataType eDataType, String initialValue) {
		return (B3FuncStore)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertFuncStoreToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B3backendPackage getB3backendPackage() {
		return (B3backendPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static B3backendPackage getPackage() {
		return B3backendPackage.eINSTANCE;
	}

} //B3backendFactoryImpl