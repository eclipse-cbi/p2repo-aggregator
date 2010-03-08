/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.b3.backend.evaluator.b3backend.impl;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Iterator;
import java.util.regex.Pattern;
import org.eclipse.b3.backend.core.B3DynamicClassLoader;
import org.eclipse.b3.backend.core.B3EngineException;
import org.eclipse.b3.backend.core.B3ExpressionCache;
import org.eclipse.b3.backend.core.B3FuncStore;
import org.eclipse.b3.backend.core.LValue;
import org.eclipse.b3.backend.core.ValueMap;
import org.eclipse.b3.backend.evaluator.b3backend.B3FuncTypeVariable;
import org.eclipse.b3.backend.evaluator.b3backend.B3Function;
import org.eclipse.b3.backend.evaluator.b3backend.B3FunctionType;
import org.eclipse.b3.backend.evaluator.b3backend.B3JavaImport;
import org.eclipse.b3.backend.evaluator.b3backend.B3MetaClass;
import org.eclipse.b3.backend.evaluator.b3backend.B3ParameterizedType;
import org.eclipse.b3.backend.evaluator.b3backend.B3WildcardType;
import org.eclipse.b3.backend.evaluator.b3backend.B3backendFactory;
import org.eclipse.b3.backend.evaluator.b3backend.B3backendPackage;
import org.eclipse.b3.backend.evaluator.b3backend.BAdvice;
import org.eclipse.b3.backend.evaluator.b3backend.BAndExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BAssignmentExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BAtExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BBinaryExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BBinaryOpExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BCachedExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BCallExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BCase;
import org.eclipse.b3.backend.evaluator.b3backend.BCatch;
import org.eclipse.b3.backend.evaluator.b3backend.BChainedExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BConcern;
import org.eclipse.b3.backend.evaluator.b3backend.BConcernContext;
import org.eclipse.b3.backend.evaluator.b3backend.BConditionalPropertyOperation;
import org.eclipse.b3.backend.evaluator.b3backend.BContext;
import org.eclipse.b3.backend.evaluator.b3backend.BCreateExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BDefProperty;
import org.eclipse.b3.backend.evaluator.b3backend.BDefValue;
import org.eclipse.b3.backend.evaluator.b3backend.BDefaultPropertySet;
import org.eclipse.b3.backend.evaluator.b3backend.BDelegatingContext;
import org.eclipse.b3.backend.evaluator.b3backend.BExecutionContext;
import org.eclipse.b3.backend.evaluator.b3backend.BExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BExpressionWrapper;
import org.eclipse.b3.backend.evaluator.b3backend.BFeatureExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BFunction;
import org.eclipse.b3.backend.evaluator.b3backend.BFunctionConcernContext;
import org.eclipse.b3.backend.evaluator.b3backend.BFunctionContainer;
import org.eclipse.b3.backend.evaluator.b3backend.BFunctionNamePredicate;
import org.eclipse.b3.backend.evaluator.b3backend.BFunctionWrapper;
import org.eclipse.b3.backend.evaluator.b3backend.BGuard;
import org.eclipse.b3.backend.evaluator.b3backend.BGuardExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BGuardFunction;
import org.eclipse.b3.backend.evaluator.b3backend.BIfExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BInnerContext;
import org.eclipse.b3.backend.evaluator.b3backend.BInstanceContext;
import org.eclipse.b3.backend.evaluator.b3backend.BInvocationContext;
import org.eclipse.b3.backend.evaluator.b3backend.BJavaCallType;
import org.eclipse.b3.backend.evaluator.b3backend.BJavaFunction;
import org.eclipse.b3.backend.evaluator.b3backend.BLineReference;
import org.eclipse.b3.backend.evaluator.b3backend.BLiteralAny;
import org.eclipse.b3.backend.evaluator.b3backend.BLiteralExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BLiteralListExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BLiteralMapExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BLiteralType;
import org.eclipse.b3.backend.evaluator.b3backend.BMapEntry;
import org.eclipse.b3.backend.evaluator.b3backend.BNamePredicate;
import org.eclipse.b3.backend.evaluator.b3backend.BOrExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BParameter;
import org.eclipse.b3.backend.evaluator.b3backend.BParameterDeclaration;
import org.eclipse.b3.backend.evaluator.b3backend.BParameterList;
import org.eclipse.b3.backend.evaluator.b3backend.BParameterPredicate;
import org.eclipse.b3.backend.evaluator.b3backend.BParameterizedExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BProceedExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BPropertyDefinitionOperation;
import org.eclipse.b3.backend.evaluator.b3backend.BPropertyOperation;
import org.eclipse.b3.backend.evaluator.b3backend.BPropertySet;
import org.eclipse.b3.backend.evaluator.b3backend.BPropertySetOperation;
import org.eclipse.b3.backend.evaluator.b3backend.BRegularExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BSwitchExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BSystemContext;
import org.eclipse.b3.backend.evaluator.b3backend.BThrowExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BTryExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BTypeCalculator;
import org.eclipse.b3.backend.evaluator.b3backend.BTypeCalculatorFunction;
import org.eclipse.b3.backend.evaluator.b3backend.BUnaryExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BUnaryOpExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BUnaryPostOpExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BUnaryPreOpExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BVariableExpression;

import org.eclipse.b3.backend.evaluator.b3backend.BWithContextExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BWithExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BWrappingContext;
import org.eclipse.b3.backend.evaluator.b3backend.ExecutionMode;
import org.eclipse.b3.backend.evaluator.b3backend.IFunction;
import org.eclipse.b3.backend.evaluator.b3backend.ITypedValueContainer;
import org.eclipse.b3.backend.evaluator.b3backend.Visibility;
import org.eclipse.core.runtime.CoreException;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.ETypeParameter;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class B3backendPackageImpl extends EPackageImpl implements B3backendPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2009, Cloudsmith Inc and others.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\rContributors:\n- Cloudsmith Inc - initial API and implementation.\r";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bLineReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bExecutionContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bIfExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bSwitchExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bTryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bCatchEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bBinaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bOrExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bAndExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bChainedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bUnaryExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bThrowExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bUnaryOpExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bUnaryPostOpExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bBinaryOpExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bCachedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bLiteralExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bLiteralListExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bLiteralMapExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bMapEntryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bFeatureExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bAtExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bVariableExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bCallExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bParameterizedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bLiteralAnyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bCreateExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bFunctionWrapperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bNamePredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bFunctionNamePredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bFunctionConcernContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bParameterPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bProceedExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bDelegatingContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bWrappingContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass b3MetaClassEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bExpressionWrapperEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bWithContextExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTypedValueContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bGuardEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bGuardExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bSystemContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bInnerContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bInvocationContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bUnaryPreOpExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bAssignmentExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass b3FunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bJavaFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bFunctionContainerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bDefValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bRegularExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bParameterListEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bParameterDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass b3FunctionTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iParameterizedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iGenericDeclarationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass b3ParameterizedTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iWildcardTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass b3WildcardTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass iTypeVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass b3FuncTypeVariableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass b3JavaImportEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bLiteralTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bGuardFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bTypeCalculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bTypeCalculatorFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bInstanceContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bDefPropertyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bPropertySetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bDefaultPropertySetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bPropertyOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bPropertyDefinitionOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bConditionalPropertyOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bPropertySetOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bAdviceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bConcernEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bWithExpressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bConcernContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum visibilityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum executionModeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum bJavaCallTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType coreExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType objectArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType valueMapEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType b3EngineExceptionEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType b3ExpressionCacheEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType throwableEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType lValueEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typeArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType methodEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType typeVariableArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType funcStoreEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType regexpPatternEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType stringArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType b3DynamicClassLoaderEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType javaIteratorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType uriEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType iProgressMonitorEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.b3.backend.evaluator.b3backend.B3backendPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private B3backendPackageImpl() {
		super(eNS_URI, B3backendFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link B3backendPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static B3backendPackage init() {
		if (isInited) return (B3backendPackage)EPackage.Registry.INSTANCE.getEPackage(B3backendPackage.eNS_URI);

		// Obtain or create and register package
		B3backendPackageImpl theB3backendPackage = (B3backendPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof B3backendPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new B3backendPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theB3backendPackage.createPackageContents();

		// Initialize created meta-data
		theB3backendPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theB3backendPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(B3backendPackage.eNS_URI, theB3backendPackage);
		return theB3backendPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBExpression() {
		return bExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBLineReference() {
		return bLineReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBExecutionContext() {
		return bExecutionContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBExecutionContext_ParentContext() {
		return (EReference)bExecutionContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBExecutionContext_ValueMap() {
		return (EAttribute)bExecutionContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBExecutionContext_FuncStore() {
		return (EAttribute)bExecutionContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBExecutionContext_EffectiveConcerns() {
		return (EReference)bExecutionContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBExecutionContext_ProgressMonitor() {
		return (EAttribute)bExecutionContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBIfExpression() {
		return bIfExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBIfExpression_ConditionExpr() {
		return (EReference)bIfExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBIfExpression_ThenExpr() {
		return (EReference)bIfExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBIfExpression_ElseExpr() {
		return (EReference)bIfExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBSwitchExpression() {
		return bSwitchExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBSwitchExpression_SwitchExpression() {
		return (EReference)bSwitchExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBSwitchExpression_CaseList() {
		return (EReference)bSwitchExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBCase() {
		return bCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBCase_ConditionExpr() {
		return (EReference)bCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBCase_ThenExpr() {
		return (EReference)bCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBTryExpression() {
		return bTryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBTryExpression_TryExpr() {
		return (EReference)bTryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBTryExpression_CatchBlocks() {
		return (EReference)bTryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBTryExpression_FinallyExpr() {
		return (EReference)bTryExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBCatch() {
		return bCatchEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBCatch_CatchExpr() {
		return (EReference)bCatchEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBCatch_ExceptionType() {
		return (EReference)bCatchEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBCatch_Varname() {
		return (EAttribute)bCatchEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBBinaryExpression() {
		return bBinaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBBinaryExpression_LeftExpr() {
		return (EReference)bBinaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBBinaryExpression_RightExpr() {
		return (EReference)bBinaryExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBOrExpression() {
		return bOrExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBAndExpression() {
		return bAndExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBChainedExpression() {
		return bChainedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBChainedExpression_Expressions() {
		return (EReference)bChainedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBUnaryExpression() {
		return bUnaryExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBUnaryExpression_Expr() {
		return (EReference)bUnaryExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBThrowExpression() {
		return bThrowExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBUnaryOpExpression() {
		return bUnaryOpExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBUnaryOpExpression_FunctionName() {
		return (EAttribute)bUnaryOpExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBUnaryPostOpExpression() {
		return bUnaryPostOpExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBBinaryOpExpression() {
		return bBinaryOpExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBBinaryOpExpression_FunctionName() {
		return (EAttribute)bBinaryOpExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBCachedExpression() {
		return bCachedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBLiteralExpression() {
		return bLiteralExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBLiteralExpression_Value() {
		return (EAttribute)bLiteralExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBLiteralListExpression() {
		return bLiteralListExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBLiteralListExpression_Entries() {
		return (EReference)bLiteralListExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBLiteralListExpression_EntryType() {
		return (EReference)bLiteralListExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBLiteralMapExpression() {
		return bLiteralMapExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBLiteralMapExpression_Entries() {
		return (EReference)bLiteralMapExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBLiteralMapExpression_KeyType() {
		return (EReference)bLiteralMapExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBLiteralMapExpression_ValueType() {
		return (EReference)bLiteralMapExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBMapEntry() {
		return bMapEntryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBMapEntry_Key() {
		return (EReference)bMapEntryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBMapEntry_Value() {
		return (EReference)bMapEntryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBFeatureExpression() {
		return bFeatureExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBFeatureExpression_ObjExpr() {
		return (EReference)bFeatureExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBFeatureExpression_FeatureName() {
		return (EAttribute)bFeatureExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBAtExpression() {
		return bAtExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBAtExpression_ObjExpr() {
		return (EReference)bAtExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBAtExpression_IndexExpr() {
		return (EReference)bAtExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBVariableExpression() {
		return bVariableExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBVariableExpression_Name() {
		return (EAttribute)bVariableExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBCallExpression() {
		return bCallExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBCallExpression_FuncExpr() {
		return (EReference)bCallExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBCallExpression_Name() {
		return (EAttribute)bCallExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBParameterizedExpression() {
		return bParameterizedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBParameterizedExpression_ParameterList() {
		return (EReference)bParameterizedExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBLiteralAny() {
		return bLiteralAnyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBCreateExpression() {
		return bCreateExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBCreateExpression_ContextBlock() {
		return (EReference)bCreateExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIFunction() {
		return iFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFunction_Visibility() {
		return (EAttribute)iFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFunction_Final() {
		return (EAttribute)iFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFunction_ExecutionMode() {
		return (EAttribute)iFunctionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFunction_Name() {
		return (EAttribute)iFunctionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFunction_Guard() {
		return (EReference)iFunctionEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFunction_ParameterTypes() {
		return (EAttribute)iFunctionEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFunction_ExceptionTypes() {
		return (EAttribute)iFunctionEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFunction_TypeParameters() {
		return (EAttribute)iFunctionEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFunction_ParameterNames() {
		return (EAttribute)iFunctionEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFunction_Parameters() {
		return (EReference)iFunctionEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFunction_VarArgs() {
		return (EAttribute)iFunctionEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFunction_Documentation() {
		return (EAttribute)iFunctionEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFunction_ReturnType() {
		return (EReference)iFunctionEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFunction_Closure() {
		return (EReference)iFunctionEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFunction_TypeCalculator() {
		return (EReference)iFunctionEClass.getEStructuralFeatures().get(14);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getIFunction_Container() {
		return (EReference)iFunctionEClass.getEStructuralFeatures().get(15);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFunction_ClassFunction() {
		return (EAttribute)iFunctionEClass.getEStructuralFeatures().get(16);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIFunction_VarargArrayType() {
		return (EAttribute)iFunctionEClass.getEStructuralFeatures().get(17);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBCreateExpression_Alias() {
		return (EAttribute)bCreateExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBCreateExpression_TypeExpr() {
		return (EReference)bCreateExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBFunction() {
		return bFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBFunctionWrapper() {
		return bFunctionWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBFunctionWrapper_AroundExpr() {
		return (EReference)bFunctionWrapperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBFunctionWrapper_Original() {
		return (EReference)bFunctionWrapperEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBFunctionWrapper_ParameterMap() {
		return (EAttribute)bFunctionWrapperEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBFunctionWrapper_VarargsName() {
		return (EAttribute)bFunctionWrapperEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBNamePredicate() {
		return bNamePredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBNamePredicate_NamePattern() {
		return (EReference)bNamePredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBNamePredicate_Name() {
		return (EAttribute)bNamePredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBFunctionNamePredicate() {
		return bFunctionNamePredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBFunctionNamePredicate_NamePredicate() {
		return (EReference)bFunctionNamePredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBFunctionConcernContext() {
		return bFunctionConcernContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBFunctionConcernContext_NamePredicate() {
		return (EReference)bFunctionConcernContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBFunctionConcernContext_Parameters() {
		return (EReference)bFunctionConcernContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBFunctionConcernContext_FuncExpr() {
		return (EReference)bFunctionConcernContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBFunctionConcernContext_VarArgs() {
		return (EAttribute)bFunctionConcernContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBFunctionConcernContext_MatchParameters() {
		return (EAttribute)bFunctionConcernContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBParameterPredicate() {
		return bParameterPredicateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBParameterPredicate_Name() {
		return (EAttribute)bParameterPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBParameterPredicate_Type() {
		return (EReference)bParameterPredicateEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBParameterPredicate_TypePredicateOp() {
		return (EAttribute)bParameterPredicateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBProceedExpression() {
		return bProceedExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBDelegatingContext() {
		return bDelegatingContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBWrappingContext() {
		return bWrappingContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBWrappingContext_FunctionWrapper() {
		return (EReference)bWrappingContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBWrappingContext_WrappedContext() {
		return (EReference)bWrappingContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWrappingContext_Parameters() {
		return (EAttribute)bWrappingContextEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWrappingContext_ParameterTypes() {
		return (EAttribute)bWrappingContextEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWrappingContext_VarargsName() {
		return (EAttribute)bWrappingContextEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getB3MetaClass() {
		return b3MetaClassEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getB3MetaClass_InstanceClass() {
		return (EAttribute)b3MetaClassEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBExpressionWrapper() {
		return bExpressionWrapperEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBExpressionWrapper_Original() {
		return (EReference)bExpressionWrapperEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBWithContextExpression() {
		return bWithContextExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBWithContextExpression_Alias() {
		return (EAttribute)bWithContextExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBWithContextExpression_Expr() {
		return (EReference)bWithContextExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBWithContextExpression_ContextBlock() {
		return (EReference)bWithContextExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITypedValueContainer() {
		return iTypedValueContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBGuard() {
		return bGuardEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBGuardExpression() {
		return bGuardExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBGuardExpression_GuardExpr() {
		return (EReference)bGuardExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBSystemContext() {
		return bSystemContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBContext() {
		return bContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBInnerContext() {
		return bInnerContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBInnerContext_OuterContext() {
		return (EReference)bInnerContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBInvocationContext() {
		return bInvocationContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBInvocationContext_ExpressionCache() {
		return (EAttribute)bInvocationContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBUnaryPreOpExpression() {
		return bUnaryPreOpExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBAssignmentExpression() {
		return bAssignmentExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getB3Function() {
		return b3FunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getB3Function_FuncExpr() {
		return (EReference)b3FunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBJavaFunction() {
		return bJavaFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBJavaFunction_Method() {
		return (EAttribute)bJavaFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBJavaFunction_CallType() {
		return (EAttribute)bJavaFunctionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBFunctionContainer() {
		return bFunctionContainerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBFunctionContainer_Functions() {
		return (EReference)bFunctionContainerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBDefValue() {
		return bDefValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBDefValue_Name() {
		return (EAttribute)bDefValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBDefValue_Final() {
		return (EAttribute)bDefValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBDefValue_Immutable() {
		return (EAttribute)bDefValueEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBDefValue_ValueExpr() {
		return (EReference)bDefValueEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBDefValue_Type() {
		return (EReference)bDefValueEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBRegularExpression() {
		return bRegularExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBRegularExpression_Pattern() {
		return (EAttribute)bRegularExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBParameterList() {
		return bParameterListEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBParameterList_Parameters() {
		return (EReference)bParameterListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBParameter() {
		return bParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBParameter_Name() {
		return (EAttribute)bParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBParameter_Expr() {
		return (EReference)bParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBParameterDeclaration() {
		return bParameterDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBParameterDeclaration_Name() {
		return (EAttribute)bParameterDeclarationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBParameterDeclaration_Type() {
		return (EReference)bParameterDeclarationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBParameterDeclaration_Final() {
		return (EAttribute)bParameterDeclarationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBParameterDeclaration_Immutable() {
		return (EAttribute)bParameterDeclarationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIType() {
		return iTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getB3FunctionType() {
		return b3FunctionTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getB3FunctionType_FunctionType() {
		return (EReference)b3FunctionTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getB3FunctionType_ReturnType() {
		return (EReference)b3FunctionTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getB3FunctionType_ParameterTypes() {
		return (EReference)b3FunctionTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getB3FunctionType_VarArgs() {
		return (EAttribute)b3FunctionTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getB3FunctionType_TypeCalculator() {
		return (EReference)b3FunctionTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIParameterizedType() {
		return iParameterizedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIGenericDeclaration() {
		return iGenericDeclarationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getB3ParameterizedType() {
		return b3ParameterizedTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getB3ParameterizedType_OwnerType() {
		return (EReference)b3ParameterizedTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getB3ParameterizedType_RawType() {
		return (EReference)b3ParameterizedTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getB3ParameterizedType_ActualArgumentsList() {
		return (EReference)b3ParameterizedTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIWildcardType() {
		return iWildcardTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getB3WildcardType() {
		return b3WildcardTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getB3WildcardType_LowerBoundsList() {
		return (EReference)b3WildcardTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getB3WildcardType_UpperBoundsList() {
		return (EReference)b3WildcardTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getITypeVariable() {
		return iTypeVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getB3FuncTypeVariable() {
		return b3FuncTypeVariableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getB3FuncTypeVariable_Bounds() {
		return (EAttribute)b3FuncTypeVariableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getB3FuncTypeVariable_GenericDeclaration() {
		return (EReference)b3FuncTypeVariableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getB3FuncTypeVariable_Name() {
		return (EAttribute)b3FuncTypeVariableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getB3JavaImport() {
		return b3JavaImportEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getB3JavaImport_Name() {
		return (EAttribute)b3JavaImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getB3JavaImport_QualifiedName() {
		return (EAttribute)b3JavaImportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getB3JavaImport_Type() {
		return (EAttribute)b3JavaImportEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getB3JavaImport_Reexport() {
		return (EAttribute)b3JavaImportEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBLiteralType() {
		return bLiteralTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBLiteralType_Type() {
		return (EReference)bLiteralTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBGuardFunction() {
		return bGuardFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBGuardFunction_Func() {
		return (EReference)bGuardFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBTypeCalculator() {
		return bTypeCalculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBTypeCalculatorFunction() {
		return bTypeCalculatorFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBTypeCalculatorFunction_Func() {
		return (EReference)bTypeCalculatorFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBInstanceContext() {
		return bInstanceContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBInstanceContext_Instance() {
		return (EAttribute)bInstanceContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBDefProperty() {
		return bDefPropertyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBDefProperty_Mutable() {
		return (EAttribute)bDefPropertyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBPropertySet() {
		return bPropertySetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBPropertySet_Extends() {
		return (EReference)bPropertySetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBPropertySet_Operations() {
		return (EReference)bPropertySetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBPropertySet_PropertiesFile() {
		return (EAttribute)bPropertySetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBDefaultPropertySet() {
		return bDefaultPropertySetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBPropertyOperation() {
		return bPropertyOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBPropertyDefinitionOperation() {
		return bPropertyDefinitionOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBPropertyDefinitionOperation_Definition() {
		return (EReference)bPropertyDefinitionOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBConditionalPropertyOperation() {
		return bConditionalPropertyOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBConditionalPropertyOperation_CondExpr() {
		return (EReference)bConditionalPropertyOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBConditionalPropertyOperation_Body() {
		return (EReference)bConditionalPropertyOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBPropertySetOperation() {
		return bPropertySetOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBPropertySetOperation_PropertySet() {
		return (EReference)bPropertySetOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBAdvice() {
		return bAdviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBAdvice_Name() {
		return (EAttribute)bAdviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBConcern() {
		return bConcernEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBConcern_Documentation() {
		return (EAttribute)bConcernEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBConcern_SuperConcerns() {
		return (EReference)bConcernEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBConcern_PropertySets() {
		return (EReference)bConcernEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBConcern_Contexts() {
		return (EReference)bConcernEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBWithExpression() {
		return bWithExpressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBWithExpression_ReferencedAdvice() {
		return (EReference)bWithExpressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBWithExpression_PropertySets() {
		return (EReference)bWithExpressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBWithExpression_Concerns() {
		return (EReference)bWithExpressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBWithExpression_FuncExpr() {
		return (EReference)bWithExpressionEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBConcernContext() {
		return bConcernContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBConcernContext_Documentation() {
		return (EAttribute)bConcernContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVisibility() {
		return visibilityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExecutionMode() {
		return executionModeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getBJavaCallType() {
		return bJavaCallTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCoreException() {
		return coreExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getType() {
		return typeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getObjectArray() {
		return objectArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getValueMap() {
		return valueMapEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getB3EngineException() {
		return b3EngineExceptionEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getB3ExpressionCache() {
		return b3ExpressionCacheEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getThrowable() {
		return throwableEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getLValue() {
		return lValueEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTypeArray() {
		return typeArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getMethod() {
		return methodEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getTypeVariableArray() {
		return typeVariableArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getFuncStore() {
		return funcStoreEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRegexpPattern() {
		return regexpPatternEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getStringArray() {
		return stringArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getB3DynamicClassLoader() {
		return b3DynamicClassLoaderEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getJavaIterator() {
		return javaIteratorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURI() {
		return uriEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIProgressMonitor() {
		return iProgressMonitorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public B3backendFactory getB3backendFactory() {
		return (B3backendFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		bExpressionEClass = createEClass(BEXPRESSION);

		bLineReferenceEClass = createEClass(BLINE_REFERENCE);

		bExecutionContextEClass = createEClass(BEXECUTION_CONTEXT);
		createEReference(bExecutionContextEClass, BEXECUTION_CONTEXT__PARENT_CONTEXT);
		createEAttribute(bExecutionContextEClass, BEXECUTION_CONTEXT__VALUE_MAP);
		createEAttribute(bExecutionContextEClass, BEXECUTION_CONTEXT__FUNC_STORE);
		createEReference(bExecutionContextEClass, BEXECUTION_CONTEXT__EFFECTIVE_CONCERNS);
		createEAttribute(bExecutionContextEClass, BEXECUTION_CONTEXT__PROGRESS_MONITOR);

		bIfExpressionEClass = createEClass(BIF_EXPRESSION);
		createEReference(bIfExpressionEClass, BIF_EXPRESSION__CONDITION_EXPR);
		createEReference(bIfExpressionEClass, BIF_EXPRESSION__THEN_EXPR);
		createEReference(bIfExpressionEClass, BIF_EXPRESSION__ELSE_EXPR);

		bSwitchExpressionEClass = createEClass(BSWITCH_EXPRESSION);
		createEReference(bSwitchExpressionEClass, BSWITCH_EXPRESSION__SWITCH_EXPRESSION);
		createEReference(bSwitchExpressionEClass, BSWITCH_EXPRESSION__CASE_LIST);

		bCaseEClass = createEClass(BCASE);
		createEReference(bCaseEClass, BCASE__CONDITION_EXPR);
		createEReference(bCaseEClass, BCASE__THEN_EXPR);

		bTryExpressionEClass = createEClass(BTRY_EXPRESSION);
		createEReference(bTryExpressionEClass, BTRY_EXPRESSION__TRY_EXPR);
		createEReference(bTryExpressionEClass, BTRY_EXPRESSION__CATCH_BLOCKS);
		createEReference(bTryExpressionEClass, BTRY_EXPRESSION__FINALLY_EXPR);

		bCatchEClass = createEClass(BCATCH);
		createEReference(bCatchEClass, BCATCH__CATCH_EXPR);
		createEAttribute(bCatchEClass, BCATCH__VARNAME);
		createEReference(bCatchEClass, BCATCH__EXCEPTION_TYPE);

		bBinaryExpressionEClass = createEClass(BBINARY_EXPRESSION);
		createEReference(bBinaryExpressionEClass, BBINARY_EXPRESSION__LEFT_EXPR);
		createEReference(bBinaryExpressionEClass, BBINARY_EXPRESSION__RIGHT_EXPR);

		bOrExpressionEClass = createEClass(BOR_EXPRESSION);

		bAndExpressionEClass = createEClass(BAND_EXPRESSION);

		bChainedExpressionEClass = createEClass(BCHAINED_EXPRESSION);
		createEReference(bChainedExpressionEClass, BCHAINED_EXPRESSION__EXPRESSIONS);

		bUnaryExpressionEClass = createEClass(BUNARY_EXPRESSION);
		createEReference(bUnaryExpressionEClass, BUNARY_EXPRESSION__EXPR);

		bThrowExpressionEClass = createEClass(BTHROW_EXPRESSION);

		bUnaryOpExpressionEClass = createEClass(BUNARY_OP_EXPRESSION);
		createEAttribute(bUnaryOpExpressionEClass, BUNARY_OP_EXPRESSION__FUNCTION_NAME);

		bUnaryPostOpExpressionEClass = createEClass(BUNARY_POST_OP_EXPRESSION);

		bBinaryOpExpressionEClass = createEClass(BBINARY_OP_EXPRESSION);
		createEAttribute(bBinaryOpExpressionEClass, BBINARY_OP_EXPRESSION__FUNCTION_NAME);

		bCachedExpressionEClass = createEClass(BCACHED_EXPRESSION);

		bLiteralExpressionEClass = createEClass(BLITERAL_EXPRESSION);
		createEAttribute(bLiteralExpressionEClass, BLITERAL_EXPRESSION__VALUE);

		bLiteralListExpressionEClass = createEClass(BLITERAL_LIST_EXPRESSION);
		createEReference(bLiteralListExpressionEClass, BLITERAL_LIST_EXPRESSION__ENTRIES);
		createEReference(bLiteralListExpressionEClass, BLITERAL_LIST_EXPRESSION__ENTRY_TYPE);

		bLiteralMapExpressionEClass = createEClass(BLITERAL_MAP_EXPRESSION);
		createEReference(bLiteralMapExpressionEClass, BLITERAL_MAP_EXPRESSION__ENTRIES);
		createEReference(bLiteralMapExpressionEClass, BLITERAL_MAP_EXPRESSION__KEY_TYPE);
		createEReference(bLiteralMapExpressionEClass, BLITERAL_MAP_EXPRESSION__VALUE_TYPE);

		bMapEntryEClass = createEClass(BMAP_ENTRY);
		createEReference(bMapEntryEClass, BMAP_ENTRY__KEY);
		createEReference(bMapEntryEClass, BMAP_ENTRY__VALUE);

		bFeatureExpressionEClass = createEClass(BFEATURE_EXPRESSION);
		createEReference(bFeatureExpressionEClass, BFEATURE_EXPRESSION__OBJ_EXPR);
		createEAttribute(bFeatureExpressionEClass, BFEATURE_EXPRESSION__FEATURE_NAME);

		bAtExpressionEClass = createEClass(BAT_EXPRESSION);
		createEReference(bAtExpressionEClass, BAT_EXPRESSION__OBJ_EXPR);
		createEReference(bAtExpressionEClass, BAT_EXPRESSION__INDEX_EXPR);

		bVariableExpressionEClass = createEClass(BVARIABLE_EXPRESSION);
		createEAttribute(bVariableExpressionEClass, BVARIABLE_EXPRESSION__NAME);

		bCallExpressionEClass = createEClass(BCALL_EXPRESSION);
		createEReference(bCallExpressionEClass, BCALL_EXPRESSION__FUNC_EXPR);
		createEAttribute(bCallExpressionEClass, BCALL_EXPRESSION__NAME);

		bParameterizedExpressionEClass = createEClass(BPARAMETERIZED_EXPRESSION);
		createEReference(bParameterizedExpressionEClass, BPARAMETERIZED_EXPRESSION__PARAMETER_LIST);

		bLiteralAnyEClass = createEClass(BLITERAL_ANY);

		bCreateExpressionEClass = createEClass(BCREATE_EXPRESSION);
		createEAttribute(bCreateExpressionEClass, BCREATE_EXPRESSION__ALIAS);
		createEReference(bCreateExpressionEClass, BCREATE_EXPRESSION__TYPE_EXPR);
		createEReference(bCreateExpressionEClass, BCREATE_EXPRESSION__CONTEXT_BLOCK);

		iFunctionEClass = createEClass(IFUNCTION);
		createEAttribute(iFunctionEClass, IFUNCTION__VISIBILITY);
		createEAttribute(iFunctionEClass, IFUNCTION__FINAL);
		createEAttribute(iFunctionEClass, IFUNCTION__EXECUTION_MODE);
		createEAttribute(iFunctionEClass, IFUNCTION__NAME);
		createEReference(iFunctionEClass, IFUNCTION__GUARD);
		createEAttribute(iFunctionEClass, IFUNCTION__PARAMETER_TYPES);
		createEAttribute(iFunctionEClass, IFUNCTION__EXCEPTION_TYPES);
		createEAttribute(iFunctionEClass, IFUNCTION__TYPE_PARAMETERS);
		createEAttribute(iFunctionEClass, IFUNCTION__PARAMETER_NAMES);
		createEReference(iFunctionEClass, IFUNCTION__PARAMETERS);
		createEAttribute(iFunctionEClass, IFUNCTION__VAR_ARGS);
		createEAttribute(iFunctionEClass, IFUNCTION__DOCUMENTATION);
		createEReference(iFunctionEClass, IFUNCTION__RETURN_TYPE);
		createEReference(iFunctionEClass, IFUNCTION__CLOSURE);
		createEReference(iFunctionEClass, IFUNCTION__TYPE_CALCULATOR);
		createEReference(iFunctionEClass, IFUNCTION__CONTAINER);
		createEAttribute(iFunctionEClass, IFUNCTION__CLASS_FUNCTION);
		createEAttribute(iFunctionEClass, IFUNCTION__VARARG_ARRAY_TYPE);

		bGuardEClass = createEClass(BGUARD);

		bGuardExpressionEClass = createEClass(BGUARD_EXPRESSION);
		createEReference(bGuardExpressionEClass, BGUARD_EXPRESSION__GUARD_EXPR);

		bSystemContextEClass = createEClass(BSYSTEM_CONTEXT);

		bContextEClass = createEClass(BCONTEXT);

		bInnerContextEClass = createEClass(BINNER_CONTEXT);
		createEReference(bInnerContextEClass, BINNER_CONTEXT__OUTER_CONTEXT);

		bInvocationContextEClass = createEClass(BINVOCATION_CONTEXT);
		createEAttribute(bInvocationContextEClass, BINVOCATION_CONTEXT__EXPRESSION_CACHE);

		bUnaryPreOpExpressionEClass = createEClass(BUNARY_PRE_OP_EXPRESSION);

		bAssignmentExpressionEClass = createEClass(BASSIGNMENT_EXPRESSION);

		b3FunctionEClass = createEClass(B3_FUNCTION);
		createEReference(b3FunctionEClass, B3_FUNCTION__FUNC_EXPR);

		bJavaFunctionEClass = createEClass(BJAVA_FUNCTION);
		createEAttribute(bJavaFunctionEClass, BJAVA_FUNCTION__METHOD);
		createEAttribute(bJavaFunctionEClass, BJAVA_FUNCTION__CALL_TYPE);

		bFunctionContainerEClass = createEClass(BFUNCTION_CONTAINER);
		createEReference(bFunctionContainerEClass, BFUNCTION_CONTAINER__FUNCTIONS);

		bDefValueEClass = createEClass(BDEF_VALUE);
		createEAttribute(bDefValueEClass, BDEF_VALUE__NAME);
		createEAttribute(bDefValueEClass, BDEF_VALUE__FINAL);
		createEAttribute(bDefValueEClass, BDEF_VALUE__IMMUTABLE);
		createEReference(bDefValueEClass, BDEF_VALUE__VALUE_EXPR);
		createEReference(bDefValueEClass, BDEF_VALUE__TYPE);

		bRegularExpressionEClass = createEClass(BREGULAR_EXPRESSION);
		createEAttribute(bRegularExpressionEClass, BREGULAR_EXPRESSION__PATTERN);

		bParameterListEClass = createEClass(BPARAMETER_LIST);
		createEReference(bParameterListEClass, BPARAMETER_LIST__PARAMETERS);

		bParameterEClass = createEClass(BPARAMETER);
		createEAttribute(bParameterEClass, BPARAMETER__NAME);
		createEReference(bParameterEClass, BPARAMETER__EXPR);

		bParameterDeclarationEClass = createEClass(BPARAMETER_DECLARATION);
		createEAttribute(bParameterDeclarationEClass, BPARAMETER_DECLARATION__NAME);
		createEReference(bParameterDeclarationEClass, BPARAMETER_DECLARATION__TYPE);
		createEAttribute(bParameterDeclarationEClass, BPARAMETER_DECLARATION__FINAL);
		createEAttribute(bParameterDeclarationEClass, BPARAMETER_DECLARATION__IMMUTABLE);

		iTypeEClass = createEClass(ITYPE);

		b3FunctionTypeEClass = createEClass(B3_FUNCTION_TYPE);
		createEReference(b3FunctionTypeEClass, B3_FUNCTION_TYPE__FUNCTION_TYPE);
		createEReference(b3FunctionTypeEClass, B3_FUNCTION_TYPE__RETURN_TYPE);
		createEReference(b3FunctionTypeEClass, B3_FUNCTION_TYPE__PARAMETER_TYPES);
		createEAttribute(b3FunctionTypeEClass, B3_FUNCTION_TYPE__VAR_ARGS);
		createEReference(b3FunctionTypeEClass, B3_FUNCTION_TYPE__TYPE_CALCULATOR);

		iParameterizedTypeEClass = createEClass(IPARAMETERIZED_TYPE);

		iGenericDeclarationEClass = createEClass(IGENERIC_DECLARATION);

		b3ParameterizedTypeEClass = createEClass(B3_PARAMETERIZED_TYPE);
		createEReference(b3ParameterizedTypeEClass, B3_PARAMETERIZED_TYPE__OWNER_TYPE);
		createEReference(b3ParameterizedTypeEClass, B3_PARAMETERIZED_TYPE__RAW_TYPE);
		createEReference(b3ParameterizedTypeEClass, B3_PARAMETERIZED_TYPE__ACTUAL_ARGUMENTS_LIST);

		iWildcardTypeEClass = createEClass(IWILDCARD_TYPE);

		b3WildcardTypeEClass = createEClass(B3_WILDCARD_TYPE);
		createEReference(b3WildcardTypeEClass, B3_WILDCARD_TYPE__LOWER_BOUNDS_LIST);
		createEReference(b3WildcardTypeEClass, B3_WILDCARD_TYPE__UPPER_BOUNDS_LIST);

		iTypeVariableEClass = createEClass(ITYPE_VARIABLE);

		b3FuncTypeVariableEClass = createEClass(B3_FUNC_TYPE_VARIABLE);
		createEAttribute(b3FuncTypeVariableEClass, B3_FUNC_TYPE_VARIABLE__BOUNDS);
		createEReference(b3FuncTypeVariableEClass, B3_FUNC_TYPE_VARIABLE__GENERIC_DECLARATION);
		createEAttribute(b3FuncTypeVariableEClass, B3_FUNC_TYPE_VARIABLE__NAME);

		b3JavaImportEClass = createEClass(B3_JAVA_IMPORT);
		createEAttribute(b3JavaImportEClass, B3_JAVA_IMPORT__NAME);
		createEAttribute(b3JavaImportEClass, B3_JAVA_IMPORT__QUALIFIED_NAME);
		createEAttribute(b3JavaImportEClass, B3_JAVA_IMPORT__TYPE);
		createEAttribute(b3JavaImportEClass, B3_JAVA_IMPORT__REEXPORT);

		bLiteralTypeEClass = createEClass(BLITERAL_TYPE);
		createEReference(bLiteralTypeEClass, BLITERAL_TYPE__TYPE);

		bGuardFunctionEClass = createEClass(BGUARD_FUNCTION);
		createEReference(bGuardFunctionEClass, BGUARD_FUNCTION__FUNC);

		bTypeCalculatorEClass = createEClass(BTYPE_CALCULATOR);

		bTypeCalculatorFunctionEClass = createEClass(BTYPE_CALCULATOR_FUNCTION);
		createEReference(bTypeCalculatorFunctionEClass, BTYPE_CALCULATOR_FUNCTION__FUNC);

		bInstanceContextEClass = createEClass(BINSTANCE_CONTEXT);
		createEAttribute(bInstanceContextEClass, BINSTANCE_CONTEXT__INSTANCE);

		bDefPropertyEClass = createEClass(BDEF_PROPERTY);
		createEAttribute(bDefPropertyEClass, BDEF_PROPERTY__MUTABLE);

		bPropertySetEClass = createEClass(BPROPERTY_SET);
		createEReference(bPropertySetEClass, BPROPERTY_SET__EXTENDS);
		createEReference(bPropertySetEClass, BPROPERTY_SET__OPERATIONS);
		createEAttribute(bPropertySetEClass, BPROPERTY_SET__PROPERTIES_FILE);

		bDefaultPropertySetEClass = createEClass(BDEFAULT_PROPERTY_SET);

		bPropertyOperationEClass = createEClass(BPROPERTY_OPERATION);

		bPropertyDefinitionOperationEClass = createEClass(BPROPERTY_DEFINITION_OPERATION);
		createEReference(bPropertyDefinitionOperationEClass, BPROPERTY_DEFINITION_OPERATION__DEFINITION);

		bConditionalPropertyOperationEClass = createEClass(BCONDITIONAL_PROPERTY_OPERATION);
		createEReference(bConditionalPropertyOperationEClass, BCONDITIONAL_PROPERTY_OPERATION__COND_EXPR);
		createEReference(bConditionalPropertyOperationEClass, BCONDITIONAL_PROPERTY_OPERATION__BODY);

		bPropertySetOperationEClass = createEClass(BPROPERTY_SET_OPERATION);
		createEReference(bPropertySetOperationEClass, BPROPERTY_SET_OPERATION__PROPERTY_SET);

		bAdviceEClass = createEClass(BADVICE);
		createEAttribute(bAdviceEClass, BADVICE__NAME);

		bConcernEClass = createEClass(BCONCERN);
		createEAttribute(bConcernEClass, BCONCERN__DOCUMENTATION);
		createEReference(bConcernEClass, BCONCERN__SUPER_CONCERNS);
		createEReference(bConcernEClass, BCONCERN__PROPERTY_SETS);
		createEReference(bConcernEClass, BCONCERN__CONTEXTS);

		bWithExpressionEClass = createEClass(BWITH_EXPRESSION);
		createEReference(bWithExpressionEClass, BWITH_EXPRESSION__REFERENCED_ADVICE);
		createEReference(bWithExpressionEClass, BWITH_EXPRESSION__PROPERTY_SETS);
		createEReference(bWithExpressionEClass, BWITH_EXPRESSION__CONCERNS);
		createEReference(bWithExpressionEClass, BWITH_EXPRESSION__FUNC_EXPR);

		bConcernContextEClass = createEClass(BCONCERN_CONTEXT);
		createEAttribute(bConcernContextEClass, BCONCERN_CONTEXT__DOCUMENTATION);

		bFunctionEClass = createEClass(BFUNCTION);

		bFunctionWrapperEClass = createEClass(BFUNCTION_WRAPPER);
		createEReference(bFunctionWrapperEClass, BFUNCTION_WRAPPER__AROUND_EXPR);
		createEReference(bFunctionWrapperEClass, BFUNCTION_WRAPPER__ORIGINAL);
		createEAttribute(bFunctionWrapperEClass, BFUNCTION_WRAPPER__PARAMETER_MAP);
		createEAttribute(bFunctionWrapperEClass, BFUNCTION_WRAPPER__VARARGS_NAME);

		bNamePredicateEClass = createEClass(BNAME_PREDICATE);
		createEReference(bNamePredicateEClass, BNAME_PREDICATE__NAME_PATTERN);
		createEAttribute(bNamePredicateEClass, BNAME_PREDICATE__NAME);

		bFunctionNamePredicateEClass = createEClass(BFUNCTION_NAME_PREDICATE);
		createEReference(bFunctionNamePredicateEClass, BFUNCTION_NAME_PREDICATE__NAME_PREDICATE);

		bFunctionConcernContextEClass = createEClass(BFUNCTION_CONCERN_CONTEXT);
		createEReference(bFunctionConcernContextEClass, BFUNCTION_CONCERN_CONTEXT__NAME_PREDICATE);
		createEReference(bFunctionConcernContextEClass, BFUNCTION_CONCERN_CONTEXT__PARAMETERS);
		createEReference(bFunctionConcernContextEClass, BFUNCTION_CONCERN_CONTEXT__FUNC_EXPR);
		createEAttribute(bFunctionConcernContextEClass, BFUNCTION_CONCERN_CONTEXT__VAR_ARGS);
		createEAttribute(bFunctionConcernContextEClass, BFUNCTION_CONCERN_CONTEXT__MATCH_PARAMETERS);

		bParameterPredicateEClass = createEClass(BPARAMETER_PREDICATE);
		createEAttribute(bParameterPredicateEClass, BPARAMETER_PREDICATE__NAME);
		createEAttribute(bParameterPredicateEClass, BPARAMETER_PREDICATE__TYPE_PREDICATE_OP);
		createEReference(bParameterPredicateEClass, BPARAMETER_PREDICATE__TYPE);

		bProceedExpressionEClass = createEClass(BPROCEED_EXPRESSION);

		bDelegatingContextEClass = createEClass(BDELEGATING_CONTEXT);

		bWrappingContextEClass = createEClass(BWRAPPING_CONTEXT);
		createEReference(bWrappingContextEClass, BWRAPPING_CONTEXT__FUNCTION_WRAPPER);
		createEReference(bWrappingContextEClass, BWRAPPING_CONTEXT__WRAPPED_CONTEXT);
		createEAttribute(bWrappingContextEClass, BWRAPPING_CONTEXT__PARAMETERS);
		createEAttribute(bWrappingContextEClass, BWRAPPING_CONTEXT__PARAMETER_TYPES);
		createEAttribute(bWrappingContextEClass, BWRAPPING_CONTEXT__VARARGS_NAME);

		b3MetaClassEClass = createEClass(B3_META_CLASS);
		createEAttribute(b3MetaClassEClass, B3_META_CLASS__INSTANCE_CLASS);

		bExpressionWrapperEClass = createEClass(BEXPRESSION_WRAPPER);
		createEReference(bExpressionWrapperEClass, BEXPRESSION_WRAPPER__ORIGINAL);

		bWithContextExpressionEClass = createEClass(BWITH_CONTEXT_EXPRESSION);
		createEAttribute(bWithContextExpressionEClass, BWITH_CONTEXT_EXPRESSION__ALIAS);
		createEReference(bWithContextExpressionEClass, BWITH_CONTEXT_EXPRESSION__EXPR);
		createEReference(bWithContextExpressionEClass, BWITH_CONTEXT_EXPRESSION__CONTEXT_BLOCK);

		iTypedValueContainerEClass = createEClass(ITYPED_VALUE_CONTAINER);

		// Create enums
		visibilityEEnum = createEEnum(VISIBILITY);
		executionModeEEnum = createEEnum(EXECUTION_MODE);
		bJavaCallTypeEEnum = createEEnum(BJAVA_CALL_TYPE);

		// Create data types
		coreExceptionEDataType = createEDataType(CORE_EXCEPTION);
		typeEDataType = createEDataType(TYPE);
		objectArrayEDataType = createEDataType(OBJECT_ARRAY);
		valueMapEDataType = createEDataType(VALUE_MAP);
		b3EngineExceptionEDataType = createEDataType(B3_ENGINE_EXCEPTION);
		b3ExpressionCacheEDataType = createEDataType(B3_EXPRESSION_CACHE);
		throwableEDataType = createEDataType(THROWABLE);
		lValueEDataType = createEDataType(LVALUE);
		typeArrayEDataType = createEDataType(TYPE_ARRAY);
		methodEDataType = createEDataType(METHOD);
		typeVariableArrayEDataType = createEDataType(TYPE_VARIABLE_ARRAY);
		funcStoreEDataType = createEDataType(FUNC_STORE);
		regexpPatternEDataType = createEDataType(REGEXP_PATTERN);
		stringArrayEDataType = createEDataType(STRING_ARRAY);
		b3DynamicClassLoaderEDataType = createEDataType(B3_DYNAMIC_CLASS_LOADER);
		javaIteratorEDataType = createEDataType(JAVA_ITERATOR);
		uriEDataType = createEDataType(URI);
		iProgressMonitorEDataType = createEDataType(IPROGRESS_MONITOR);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters
		ETypeParameter iTypeVariableEClass_D = addETypeParameter(iTypeVariableEClass, "D");
		addETypeParameter(javaIteratorEDataType, "E");

		// Set bounds for type parameters
		EGenericType g1 = createEGenericType(this.getIGenericDeclaration());
		iTypeVariableEClass_D.getEBounds().add(g1);

		// Add supertypes to classes
		bExecutionContextEClass.getESuperTypes().add(this.getITypedValueContainer());
		bIfExpressionEClass.getESuperTypes().add(this.getBExpression());
		bSwitchExpressionEClass.getESuperTypes().add(this.getBExpression());
		bTryExpressionEClass.getESuperTypes().add(this.getBExpression());
		bBinaryExpressionEClass.getESuperTypes().add(this.getBExpression());
		bOrExpressionEClass.getESuperTypes().add(this.getBBinaryExpression());
		bAndExpressionEClass.getESuperTypes().add(this.getBBinaryExpression());
		bChainedExpressionEClass.getESuperTypes().add(this.getBExpression());
		bUnaryExpressionEClass.getESuperTypes().add(this.getBExpression());
		bThrowExpressionEClass.getESuperTypes().add(this.getBUnaryExpression());
		bUnaryOpExpressionEClass.getESuperTypes().add(this.getBUnaryExpression());
		bUnaryPostOpExpressionEClass.getESuperTypes().add(this.getBUnaryOpExpression());
		bBinaryOpExpressionEClass.getESuperTypes().add(this.getBBinaryExpression());
		bCachedExpressionEClass.getESuperTypes().add(this.getBUnaryExpression());
		bLiteralExpressionEClass.getESuperTypes().add(this.getBExpression());
		bLiteralListExpressionEClass.getESuperTypes().add(this.getBExpression());
		bLiteralMapExpressionEClass.getESuperTypes().add(this.getBExpression());
		bFeatureExpressionEClass.getESuperTypes().add(this.getBExpression());
		bAtExpressionEClass.getESuperTypes().add(this.getBExpression());
		bVariableExpressionEClass.getESuperTypes().add(this.getBExpression());
		bCallExpressionEClass.getESuperTypes().add(this.getBParameterizedExpression());
		bParameterizedExpressionEClass.getESuperTypes().add(this.getBExpression());
		bLiteralAnyEClass.getESuperTypes().add(this.getBExpression());
		bCreateExpressionEClass.getESuperTypes().add(this.getBParameterizedExpression());
		iFunctionEClass.getESuperTypes().add(this.getIGenericDeclaration());
		iFunctionEClass.getESuperTypes().add(this.getBExpression());
		bGuardExpressionEClass.getESuperTypes().add(this.getBGuard());
		bSystemContextEClass.getESuperTypes().add(this.getBExecutionContext());
		bContextEClass.getESuperTypes().add(this.getBExecutionContext());
		bInnerContextEClass.getESuperTypes().add(this.getBExecutionContext());
		bInvocationContextEClass.getESuperTypes().add(this.getBExecutionContext());
		bUnaryPreOpExpressionEClass.getESuperTypes().add(this.getBUnaryOpExpression());
		bAssignmentExpressionEClass.getESuperTypes().add(this.getBBinaryOpExpression());
		b3FunctionEClass.getESuperTypes().add(this.getBFunction());
		bJavaFunctionEClass.getESuperTypes().add(this.getBFunction());
		bDefValueEClass.getESuperTypes().add(this.getBExpression());
		bRegularExpressionEClass.getESuperTypes().add(this.getBExpression());
		b3FunctionTypeEClass.getESuperTypes().add(this.getIType());
		iParameterizedTypeEClass.getESuperTypes().add(this.getIType());
		b3ParameterizedTypeEClass.getESuperTypes().add(this.getIParameterizedType());
		iWildcardTypeEClass.getESuperTypes().add(this.getIType());
		b3WildcardTypeEClass.getESuperTypes().add(this.getIWildcardType());
		iTypeVariableEClass.getESuperTypes().add(this.getIType());
		g1 = createEGenericType(this.getITypeVariable());
		EGenericType g2 = createEGenericType(this.getIFunction());
		g1.getETypeArguments().add(g2);
		b3FuncTypeVariableEClass.getEGenericSuperTypes().add(g1);
		b3JavaImportEClass.getESuperTypes().add(this.getIType());
		bLiteralTypeEClass.getESuperTypes().add(this.getBExpression());
		bGuardFunctionEClass.getESuperTypes().add(this.getBGuard());
		bTypeCalculatorFunctionEClass.getESuperTypes().add(this.getBTypeCalculator());
		bInstanceContextEClass.getESuperTypes().add(this.getBInnerContext());
		bDefPropertyEClass.getESuperTypes().add(this.getBDefValue());
		bPropertySetEClass.getESuperTypes().add(this.getBAdvice());
		bDefaultPropertySetEClass.getESuperTypes().add(this.getBPropertySet());
		bPropertyOperationEClass.getESuperTypes().add(this.getBExpression());
		bPropertyDefinitionOperationEClass.getESuperTypes().add(this.getBPropertyOperation());
		bConditionalPropertyOperationEClass.getESuperTypes().add(this.getBPropertyOperation());
		bPropertySetOperationEClass.getESuperTypes().add(this.getBPropertyOperation());
		bAdviceEClass.getESuperTypes().add(this.getBExpression());
		bConcernEClass.getESuperTypes().add(this.getBAdvice());
		bConcernEClass.getESuperTypes().add(this.getBFunctionContainer());
		bWithExpressionEClass.getESuperTypes().add(this.getBExpression());
		bConcernContextEClass.getESuperTypes().add(this.getBExpression());
		bConcernContextEClass.getESuperTypes().add(this.getBFunctionContainer());
		bFunctionEClass.getESuperTypes().add(this.getBExpression());
		bFunctionEClass.getESuperTypes().add(this.getIFunction());
		bFunctionWrapperEClass.getESuperTypes().add(this.getBExpression());
		bFunctionWrapperEClass.getESuperTypes().add(this.getIFunction());
		bFunctionNamePredicateEClass.getESuperTypes().add(this.getBExpression());
		bFunctionConcernContextEClass.getESuperTypes().add(this.getBConcernContext());
		bProceedExpressionEClass.getESuperTypes().add(this.getBExpression());
		bDelegatingContextEClass.getESuperTypes().add(this.getBInnerContext());
		bWrappingContextEClass.getESuperTypes().add(this.getBDelegatingContext());
		b3MetaClassEClass.getESuperTypes().add(this.getIType());
		bExpressionWrapperEClass.getESuperTypes().add(this.getBExpression());
		bWithContextExpressionEClass.getESuperTypes().add(this.getBExpression());

		// Initialize classes and features; add operations and parameters
		initEClass(bExpressionEClass, BExpression.class, "BExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		EOperation op = addEOperation(bExpressionEClass, ecorePackage.getEJavaObject(), "evaluate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		op = addEOperation(bExpressionEClass, this.getLValue(), "getLValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(bExpressionEClass, this.getType(), "getDeclaredType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		initEClass(bLineReferenceEClass, BLineReference.class, "BLineReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bExecutionContextEClass, BExecutionContext.class, "BExecutionContext", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBExecutionContext_ParentContext(), this.getBExecutionContext(), null, "parentContext", null, 0, 1, BExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBExecutionContext_ValueMap(), this.getValueMap(), "valueMap", "", 1, 1, BExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBExecutionContext_FuncStore(), this.getFuncStore(), "funcStore", null, 0, 1, BExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBExecutionContext_EffectiveConcerns(), this.getBConcern(), null, "effectiveConcerns", null, 0, -1, BExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBExecutionContext_ProgressMonitor(), this.getIProgressMonitor(), "progressMonitor", null, 0, 1, BExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(bExecutionContextEClass, null, "loadFunctions", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		EGenericType g3 = createEGenericType(ecorePackage.getEJavaObject());
		g2.setEUpperBound(g3);
		addEParameter(op, g1, "clazz", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getB3EngineException());

		op = addEOperation(bExecutionContextEClass, this.getBJavaFunction(), "loadFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getMethod(), "method", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getB3EngineException());

		op = addEOperation(bExecutionContextEClass, this.getIFunction(), "defineFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIFunction(), "function", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getB3EngineException());

		op = addEOperation(bExecutionContextEClass, ecorePackage.getEJavaObject(), "callFunction", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "functionName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObjectArray(), "parameters", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTypeArray(), "types", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		op = addEOperation(bExecutionContextEClass, this.getBInvocationContext(), "getInvocationContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getB3EngineException());

		addEOperation(bExecutionContextEClass, this.getBExecutionContext(), "createInnerContext", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(bExecutionContextEClass, this.getBInnerContext(), "createWrappedInnerContext", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(bExecutionContextEClass, this.getBExecutionContext(), "createOuterContext", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(bExecutionContextEClass, this.getIType(), "getDeclaredFunctionType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "functionName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTypeArray(), "types", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		addEOperation(bExecutionContextEClass, ecorePackage.getEBoolean(), "isPropertyScope", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(bExecutionContextEClass, null, "getContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		ETypeParameter t1 = addETypeParameter(op, "T");
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType(t1);
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "clazz", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getB3EngineException());
		g1 = createEGenericType(t1);
		initEOperation(op, g1);

		op = addEOperation(bExecutionContextEClass, null, "getFunctionIterator", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getJavaIterator());
		g2 = createEGenericType(this.getIFunction());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(bExecutionContextEClass, null, "getFunctionIterator", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getJavaIterator());
		g2 = createEGenericType(this.getIFunction());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(bExecutionContextEClass, null, "getFunctionIterator", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "functionType", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getJavaIterator());
		g2 = createEGenericType(this.getIFunction());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		op = addEOperation(bExecutionContextEClass, null, "getConcernIterator", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "candidate", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getJavaIterator());
		g2 = createEGenericType(this.getBConcernContext());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(bIfExpressionEClass, BIfExpression.class, "BIfExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBIfExpression_ConditionExpr(), this.getBExpression(), null, "conditionExpr", null, 0, 1, BIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBIfExpression_ThenExpr(), this.getBExpression(), null, "thenExpr", null, 0, 1, BIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBIfExpression_ElseExpr(), this.getBExpression(), null, "elseExpr", null, 0, 1, BIfExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bSwitchExpressionEClass, BSwitchExpression.class, "BSwitchExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBSwitchExpression_SwitchExpression(), this.getBExpression(), null, "switchExpression", null, 0, 1, BSwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBSwitchExpression_CaseList(), this.getBCase(), null, "caseList", null, 0, -1, BSwitchExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bCaseEClass, BCase.class, "BCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBCase_ConditionExpr(), this.getBExpression(), null, "conditionExpr", null, 0, 1, BCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBCase_ThenExpr(), this.getBExpression(), null, "thenExpr", null, 0, 1, BCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(bCaseEClass, ecorePackage.getEJavaObject(), "evaluate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "switchValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		op = addEOperation(bCaseEClass, this.getIType(), "getDeclaredType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		initEClass(bTryExpressionEClass, BTryExpression.class, "BTryExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBTryExpression_TryExpr(), this.getBExpression(), null, "tryExpr", null, 0, 1, BTryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBTryExpression_CatchBlocks(), this.getBCatch(), null, "catchBlocks", null, 0, -1, BTryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBTryExpression_FinallyExpr(), this.getBExpression(), null, "finallyExpr", null, 0, 1, BTryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bCatchEClass, BCatch.class, "BCatch", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBCatch_CatchExpr(), this.getBExpression(), null, "catchExpr", null, 0, 1, BCatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBCatch_Varname(), ecorePackage.getEString(), "varname", null, 0, 1, BCatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBCatch_ExceptionType(), this.getIType(), null, "exceptionType", null, 1, 1, BCatch.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(bCatchEClass, ecorePackage.getEJavaObject(), "evaluate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		op = addEOperation(bCatchEClass, this.getType(), "getDeclaredType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		initEClass(bBinaryExpressionEClass, BBinaryExpression.class, "BBinaryExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBBinaryExpression_LeftExpr(), this.getBExpression(), null, "leftExpr", null, 0, 1, BBinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBBinaryExpression_RightExpr(), this.getBExpression(), null, "rightExpr", null, 0, 1, BBinaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bOrExpressionEClass, BOrExpression.class, "BOrExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bAndExpressionEClass, BAndExpression.class, "BAndExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bChainedExpressionEClass, BChainedExpression.class, "BChainedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBChainedExpression_Expressions(), this.getBExpression(), null, "expressions", null, 0, -1, BChainedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bUnaryExpressionEClass, BUnaryExpression.class, "BUnaryExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBUnaryExpression_Expr(), this.getBExpression(), null, "expr", null, 0, 1, BUnaryExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bThrowExpressionEClass, BThrowExpression.class, "BThrowExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bUnaryOpExpressionEClass, BUnaryOpExpression.class, "BUnaryOpExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBUnaryOpExpression_FunctionName(), ecorePackage.getEString(), "functionName", null, 0, 1, BUnaryOpExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bUnaryPostOpExpressionEClass, BUnaryPostOpExpression.class, "BUnaryPostOpExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bBinaryOpExpressionEClass, BBinaryOpExpression.class, "BBinaryOpExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBBinaryOpExpression_FunctionName(), ecorePackage.getEString(), "functionName", null, 0, 1, BBinaryOpExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bCachedExpressionEClass, BCachedExpression.class, "BCachedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bLiteralExpressionEClass, BLiteralExpression.class, "BLiteralExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBLiteralExpression_Value(), ecorePackage.getEJavaObject(), "value", null, 0, 1, BLiteralExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bLiteralListExpressionEClass, BLiteralListExpression.class, "BLiteralListExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBLiteralListExpression_Entries(), this.getBExpression(), null, "entries", null, 0, -1, BLiteralListExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBLiteralListExpression_EntryType(), this.getIType(), null, "entryType", null, 0, 1, BLiteralListExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bLiteralMapExpressionEClass, BLiteralMapExpression.class, "BLiteralMapExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBLiteralMapExpression_Entries(), this.getBMapEntry(), null, "entries", null, 0, -1, BLiteralMapExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBLiteralMapExpression_KeyType(), this.getIType(), null, "keyType", null, 0, 1, BLiteralMapExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBLiteralMapExpression_ValueType(), this.getIType(), null, "valueType", null, 0, 1, BLiteralMapExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bMapEntryEClass, BMapEntry.class, "BMapEntry", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBMapEntry_Key(), this.getBExpression(), null, "key", null, 0, 1, BMapEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBMapEntry_Value(), this.getBExpression(), null, "value", null, 0, 1, BMapEntry.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bFeatureExpressionEClass, BFeatureExpression.class, "BFeatureExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBFeatureExpression_ObjExpr(), this.getBExpression(), null, "objExpr", null, 1, 1, BFeatureExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBFeatureExpression_FeatureName(), ecorePackage.getEString(), "featureName", null, 0, 1, BFeatureExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bAtExpressionEClass, BAtExpression.class, "BAtExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBAtExpression_ObjExpr(), this.getBExpression(), null, "objExpr", null, 1, 1, BAtExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBAtExpression_IndexExpr(), this.getBExpression(), null, "indexExpr", null, 1, 1, BAtExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bVariableExpressionEClass, BVariableExpression.class, "BVariableExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBVariableExpression_Name(), ecorePackage.getEString(), "name", null, 0, 1, BVariableExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bCallExpressionEClass, BCallExpression.class, "BCallExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBCallExpression_FuncExpr(), this.getBExpression(), null, "funcExpr", null, 0, 1, BCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBCallExpression_Name(), ecorePackage.getEString(), "name", null, 0, 1, BCallExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bParameterizedExpressionEClass, BParameterizedExpression.class, "BParameterizedExpression", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBParameterizedExpression_ParameterList(), this.getBParameterList(), null, "parameterList", null, 0, 1, BParameterizedExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bLiteralAnyEClass, BLiteralAny.class, "BLiteralAny", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bCreateExpressionEClass, BCreateExpression.class, "BCreateExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBCreateExpression_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, BCreateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBCreateExpression_TypeExpr(), this.getBExpression(), null, "typeExpr", null, 0, 1, BCreateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBCreateExpression_ContextBlock(), this.getBExpression(), null, "contextBlock", null, 0, 1, BCreateExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iFunctionEClass, IFunction.class, "IFunction", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIFunction_Visibility(), this.getVisibility(), "visibility", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIFunction_Final(), ecorePackage.getEBoolean(), "final", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIFunction_ExecutionMode(), this.getExecutionMode(), "executionMode", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIFunction_Name(), ecorePackage.getEString(), "name", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIFunction_Guard(), this.getBGuard(), null, "guard", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIFunction_ParameterTypes(), this.getTypeArray(), "parameterTypes", null, 0, 1, IFunction.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEAttribute(getIFunction_ExceptionTypes(), this.getTypeArray(), "exceptionTypes", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIFunction_TypeParameters(), this.getTypeVariableArray(), "typeParameters", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIFunction_ParameterNames(), this.getStringArray(), "parameterNames", null, 0, 1, IFunction.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);
		initEReference(getIFunction_Parameters(), this.getBParameterDeclaration(), null, "parameters", null, 0, -1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIFunction_VarArgs(), ecorePackage.getEBoolean(), "varArgs", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIFunction_Documentation(), ecorePackage.getEString(), "documentation", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIFunction_ReturnType(), this.getIType(), null, "returnType", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIFunction_Closure(), this.getBExecutionContext(), null, "closure", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIFunction_TypeCalculator(), this.getBTypeCalculator(), null, "typeCalculator", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getIFunction_Container(), this.getBFunctionContainer(), this.getBFunctionContainer_Functions(), "container", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIFunction_ClassFunction(), ecorePackage.getEBoolean(), "classFunction", null, 0, 1, IFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getIFunction_VarargArrayType(), this.getType(), "varargArrayType", null, 0, 1, IFunction.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(iFunctionEClass, ecorePackage.getEJavaObject(), "call", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObjectArray(), "parameters", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTypeArray(), "types", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		op = addEOperation(iFunctionEClass, ecorePackage.getEJavaObject(), "internalCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObjectArray(), "parameters", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTypeArray(), "types", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		op = addEOperation(iFunctionEClass, this.getBExecutionContext(), "prepareCall", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObjectArray(), "parameters", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTypeArray(), "types", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		addEOperation(iFunctionEClass, this.getIType(), "getSignature", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iFunctionEClass, this.getType(), "getReturnTypeForParameterTypes", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTypeArray(), "types", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bGuardEClass, BGuard.class, "BGuard", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(bGuardEClass, ecorePackage.getEBoolean(), "accepts", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIFunction(), "function", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getObjectArray(), "parameters", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTypeArray(), "types", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		initEClass(bGuardExpressionEClass, BGuardExpression.class, "BGuardExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBGuardExpression_GuardExpr(), this.getBExpression(), null, "guardExpr", null, 0, 1, BGuardExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bSystemContextEClass, BSystemContext.class, "BSystemContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(bSystemContextEClass, this.getIFunction(), "loadMethod", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "functionName", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTypeArray(), "types", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getB3EngineException());

		initEClass(bContextEClass, BContext.class, "BContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bInnerContextEClass, BInnerContext.class, "BInnerContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBInnerContext_OuterContext(), this.getBExecutionContext(), null, "outerContext", null, 1, 1, BInnerContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bInvocationContextEClass, BInvocationContext.class, "BInvocationContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBInvocationContext_ExpressionCache(), this.getB3ExpressionCache(), "expressionCache", null, 0, 1, BInvocationContext.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(bInvocationContextEClass, ecorePackage.getEJavaObject(), "evaluateIfNotCached", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBCachedExpression(), "cachedExpression", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		initEClass(bUnaryPreOpExpressionEClass, BUnaryPreOpExpression.class, "BUnaryPreOpExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bAssignmentExpressionEClass, BAssignmentExpression.class, "BAssignmentExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(b3FunctionEClass, B3Function.class, "B3Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getB3Function_FuncExpr(), this.getBExpression(), null, "funcExpr", null, 0, 1, B3Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bJavaFunctionEClass, BJavaFunction.class, "BJavaFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBJavaFunction_Method(), this.getMethod(), "method", null, 0, 1, BJavaFunction.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBJavaFunction_CallType(), this.getBJavaCallType(), "callType", null, 0, 1, BJavaFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(bJavaFunctionEClass, ecorePackage.getEBoolean(), "isSystemCall", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(bJavaFunctionEClass, ecorePackage.getEBoolean(), "isFunctionCall", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(bJavaFunctionEClass, ecorePackage.getEBoolean(), "isMethodCall", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bFunctionContainerEClass, BFunctionContainer.class, "BFunctionContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBFunctionContainer_Functions(), this.getIFunction(), this.getIFunction_Container(), "functions", null, 0, -1, BFunctionContainer.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bDefValueEClass, BDefValue.class, "BDefValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBDefValue_Name(), ecorePackage.getEString(), "name", null, 0, 1, BDefValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBDefValue_Final(), ecorePackage.getEBoolean(), "final", null, 0, 1, BDefValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBDefValue_Immutable(), ecorePackage.getEBoolean(), "immutable", null, 0, 1, BDefValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBDefValue_ValueExpr(), this.getBExpression(), null, "valueExpr", null, 0, 1, BDefValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBDefValue_Type(), this.getIType(), null, "type", null, 0, 1, BDefValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bRegularExpressionEClass, BRegularExpression.class, "BRegularExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBRegularExpression_Pattern(), this.getRegexpPattern(), "pattern", null, 0, 1, BRegularExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bParameterListEClass, BParameterList.class, "BParameterList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBParameterList_Parameters(), this.getBParameter(), null, "parameters", null, 0, -1, BParameterList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bParameterEClass, BParameter.class, "BParameter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBParameter_Name(), ecorePackage.getEString(), "name", null, 0, 1, BParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBParameter_Expr(), this.getBExpression(), null, "expr", null, 0, 1, BParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bParameterDeclarationEClass, BParameterDeclaration.class, "BParameterDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBParameterDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, BParameterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBParameterDeclaration_Type(), this.getIType(), null, "type", null, 0, 1, BParameterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBParameterDeclaration_Final(), ecorePackage.getEBoolean(), "final", null, 0, 1, BParameterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBParameterDeclaration_Immutable(), ecorePackage.getEBoolean(), "immutable", null, 0, 1, BParameterDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iTypeEClass, Type.class, "IType", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(b3FunctionTypeEClass, B3FunctionType.class, "B3FunctionType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getB3FunctionType_FunctionType(), this.getIType(), null, "functionType", null, 0, 1, B3FunctionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getB3FunctionType_ReturnType(), this.getIType(), null, "returnType", null, 0, 1, B3FunctionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getB3FunctionType_ParameterTypes(), this.getIType(), null, "parameterTypes", null, 0, -1, B3FunctionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getB3FunctionType_VarArgs(), ecorePackage.getEBoolean(), "varArgs", null, 0, 1, B3FunctionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getB3FunctionType_TypeCalculator(), this.getBTypeCalculator(), null, "typeCalculator", null, 0, 1, B3FunctionType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(b3FunctionTypeEClass, this.getTypeArray(), "getParameterTypesArray", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(b3FunctionTypeEClass, ecorePackage.getEBoolean(), "isAssignableFrom", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(b3FunctionTypeEClass, this.getType(), "getReturnTypeForParameterTypes", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTypeArray(), "types", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(iParameterizedTypeEClass, ParameterizedType.class, "IParameterizedType", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(iGenericDeclarationEClass, GenericDeclaration.class, "IGenericDeclaration", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(b3ParameterizedTypeEClass, B3ParameterizedType.class, "B3ParameterizedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getB3ParameterizedType_OwnerType(), this.getIType(), null, "ownerType", null, 0, 1, B3ParameterizedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getB3ParameterizedType_RawType(), this.getIType(), null, "rawType", null, 0, 1, B3ParameterizedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getB3ParameterizedType_ActualArgumentsList(), this.getIType(), null, "actualArgumentsList", null, 0, -1, B3ParameterizedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(b3ParameterizedTypeEClass, this.getTypeArray(), "getActualTypeArguments", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(iWildcardTypeEClass, WildcardType.class, "IWildcardType", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(b3WildcardTypeEClass, B3WildcardType.class, "B3WildcardType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getB3WildcardType_LowerBoundsList(), this.getIType(), null, "lowerBoundsList", null, 0, -1, B3WildcardType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getB3WildcardType_UpperBoundsList(), this.getIType(), null, "upperBoundsList", null, 0, -1, B3WildcardType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		addEOperation(b3WildcardTypeEClass, this.getTypeArray(), "getLowerBounds", 0, 1, IS_UNIQUE, IS_ORDERED);

		addEOperation(b3WildcardTypeEClass, this.getTypeArray(), "getUpperBounds", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(iTypeVariableEClass, TypeVariable.class, "ITypeVariable", IS_ABSTRACT, IS_INTERFACE, !IS_GENERATED_INSTANCE_CLASS);

		initEClass(b3FuncTypeVariableEClass, B3FuncTypeVariable.class, "B3FuncTypeVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getB3FuncTypeVariable_Bounds(), this.getTypeArray(), "bounds", null, 0, 1, B3FuncTypeVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getB3FuncTypeVariable_GenericDeclaration(), this.getIFunction(), null, "genericDeclaration", null, 0, 1, B3FuncTypeVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getB3FuncTypeVariable_Name(), ecorePackage.getEString(), "name", null, 0, 1, B3FuncTypeVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(b3JavaImportEClass, B3JavaImport.class, "B3JavaImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getB3JavaImport_Name(), ecorePackage.getEString(), "name", null, 0, 1, B3JavaImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getB3JavaImport_QualifiedName(), ecorePackage.getEString(), "qualifiedName", null, 0, 1, B3JavaImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getB3JavaImport_Type(), this.getType(), "type", null, 0, 1, B3JavaImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getB3JavaImport_Reexport(), ecorePackage.getEBoolean(), "reexport", null, 0, 1, B3JavaImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bLiteralTypeEClass, BLiteralType.class, "BLiteralType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBLiteralType_Type(), this.getIType(), null, "type", null, 0, 1, BLiteralType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bGuardFunctionEClass, BGuardFunction.class, "BGuardFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBGuardFunction_Func(), this.getIFunction(), null, "func", null, 0, 1, BGuardFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bTypeCalculatorEClass, BTypeCalculator.class, "BTypeCalculator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(bTypeCalculatorEClass, this.getType(), "getReturnTypeForParameterTypes", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getTypeArray(), "types", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bTypeCalculatorFunctionEClass, BTypeCalculatorFunction.class, "BTypeCalculatorFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBTypeCalculatorFunction_Func(), this.getIFunction(), null, "func", null, 0, 1, BTypeCalculatorFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bInstanceContextEClass, BInstanceContext.class, "BInstanceContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBInstanceContext_Instance(), ecorePackage.getEJavaObject(), "instance", null, 0, 1, BInstanceContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bDefPropertyEClass, BDefProperty.class, "BDefProperty", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBDefProperty_Mutable(), ecorePackage.getEBoolean(), "mutable", null, 0, 1, BDefProperty.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, IS_ORDERED);

		op = addEOperation(bDefPropertyEClass, ecorePackage.getEJavaObject(), "evaluateDefaults", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "allVisible", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		initEClass(bPropertySetEClass, BPropertySet.class, "BPropertySet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBPropertySet_Extends(), this.getBPropertySet(), null, "extends", null, 0, 1, BPropertySet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBPropertySet_Operations(), this.getBPropertyOperation(), null, "operations", null, 0, -1, BPropertySet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBPropertySet_PropertiesFile(), this.getURI(), "propertiesFile", null, 0, 1, BPropertySet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(bPropertySetEClass, ecorePackage.getEJavaObject(), "evaluateDefaults", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "allVisible", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		initEClass(bDefaultPropertySetEClass, BDefaultPropertySet.class, "BDefaultPropertySet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bPropertyOperationEClass, BPropertyOperation.class, "BPropertyOperation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(bPropertyOperationEClass, ecorePackage.getEJavaObject(), "evaluateDefaults", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "allVisible", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		initEClass(bPropertyDefinitionOperationEClass, BPropertyDefinitionOperation.class, "BPropertyDefinitionOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBPropertyDefinitionOperation_Definition(), this.getBDefProperty(), null, "definition", null, 0, 1, BPropertyDefinitionOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bConditionalPropertyOperationEClass, BConditionalPropertyOperation.class, "BConditionalPropertyOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBConditionalPropertyOperation_CondExpr(), this.getBExpression(), null, "condExpr", null, 0, 1, BConditionalPropertyOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBConditionalPropertyOperation_Body(), this.getBPropertyOperation(), null, "body", null, 0, 1, BConditionalPropertyOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bPropertySetOperationEClass, BPropertySetOperation.class, "BPropertySetOperation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBPropertySetOperation_PropertySet(), this.getBPropertySet(), null, "propertySet", null, 0, 1, BPropertySetOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bAdviceEClass, BAdvice.class, "BAdvice", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBAdvice_Name(), ecorePackage.getEString(), "name", null, 0, 1, BAdvice.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bConcernEClass, BConcern.class, "BConcern", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBConcern_Documentation(), ecorePackage.getEString(), "documentation", null, 0, 1, BConcern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBConcern_SuperConcerns(), this.getBConcern(), null, "superConcerns", null, 0, -1, BConcern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBConcern_PropertySets(), this.getBPropertySet(), null, "propertySets", null, 0, -1, BConcern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBConcern_Contexts(), this.getBConcernContext(), null, "contexts", null, 0, -1, BConcern.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(bConcernEClass, ecorePackage.getEBoolean(), "evaluateIfMatching", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "candidate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		op = addEOperation(bConcernEClass, null, "getConcernContextIterator", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(this.getJavaIterator());
		g2 = createEGenericType(this.getBConcernContext());
		g1.getETypeArguments().add(g2);
		initEOperation(op, g1);

		initEClass(bWithExpressionEClass, BWithExpression.class, "BWithExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBWithExpression_ReferencedAdvice(), this.getBAdvice(), null, "referencedAdvice", null, 0, -1, BWithExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBWithExpression_PropertySets(), this.getBPropertySet(), null, "propertySets", null, 0, -1, BWithExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBWithExpression_Concerns(), this.getBConcern(), null, "concerns", null, 0, -1, BWithExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBWithExpression_FuncExpr(), this.getBExpression(), null, "funcExpr", null, 0, 1, BWithExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(bWithExpressionEClass, this.getBInnerContext(), "createContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(bWithExpressionEClass, this.getBExecutionContext(), "getEvaluationContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		initEClass(bConcernContextEClass, BConcernContext.class, "BConcernContext", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBConcernContext_Documentation(), ecorePackage.getEString(), "documentation", null, 0, 1, BConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(bConcernContextEClass, ecorePackage.getEBoolean(), "evaluateIfMatching", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "candidate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getThrowable());

		op = addEOperation(bConcernContextEClass, ecorePackage.getEBoolean(), "matches", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "candidate", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bFunctionEClass, BFunction.class, "BFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bFunctionWrapperEClass, BFunctionWrapper.class, "BFunctionWrapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBFunctionWrapper_AroundExpr(), this.getBExpression(), null, "aroundExpr", null, 1, 1, BFunctionWrapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBFunctionWrapper_Original(), this.getIFunction(), null, "original", null, 0, 1, BFunctionWrapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		initEAttribute(getBFunctionWrapper_ParameterMap(), g1, "parameterMap", null, 0, 1, BFunctionWrapper.class, IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBFunctionWrapper_VarargsName(), ecorePackage.getEString(), "varargsName", null, 0, 1, BFunctionWrapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bNamePredicateEClass, BNamePredicate.class, "BNamePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBNamePredicate_NamePattern(), this.getBExpression(), null, "namePattern", null, 0, 1, BNamePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBNamePredicate_Name(), ecorePackage.getEString(), "name", null, 0, 1, BNamePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(bNamePredicateEClass, ecorePackage.getEBoolean(), "matches", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bFunctionNamePredicateEClass, BFunctionNamePredicate.class, "BFunctionNamePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBFunctionNamePredicate_NamePredicate(), this.getBNamePredicate(), null, "namePredicate", null, 0, 1, BFunctionNamePredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(bFunctionNamePredicateEClass, ecorePackage.getEBoolean(), "matches", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bFunctionConcernContextEClass, BFunctionConcernContext.class, "BFunctionConcernContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBFunctionConcernContext_NamePredicate(), this.getBFunctionNamePredicate(), null, "namePredicate", null, 0, 1, BFunctionConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBFunctionConcernContext_Parameters(), this.getBParameterPredicate(), null, "parameters", null, 0, -1, BFunctionConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBFunctionConcernContext_FuncExpr(), this.getBExpression(), null, "funcExpr", null, 0, 1, BFunctionConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBFunctionConcernContext_VarArgs(), ecorePackage.getEBoolean(), "varArgs", null, 0, 1, BFunctionConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBFunctionConcernContext_MatchParameters(), ecorePackage.getEBoolean(), "matchParameters", null, 0, 1, BFunctionConcernContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bParameterPredicateEClass, BParameterPredicate.class, "BParameterPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBParameterPredicate_Name(), ecorePackage.getEString(), "name", null, 0, 1, BParameterPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBParameterPredicate_TypePredicateOp(), ecorePackage.getEString(), "typePredicateOp", null, 0, 1, BParameterPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBParameterPredicate_Type(), this.getIType(), null, "type", null, 0, 1, BParameterPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bProceedExpressionEClass, BProceedExpression.class, "BProceedExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bDelegatingContextEClass, BDelegatingContext.class, "BDelegatingContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(bWrappingContextEClass, BWrappingContext.class, "BWrappingContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBWrappingContext_FunctionWrapper(), this.getBFunctionWrapper(), null, "functionWrapper", null, 0, 1, BWrappingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBWrappingContext_WrappedContext(), this.getBExecutionContext(), null, "wrappedContext", null, 0, 1, BWrappingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWrappingContext_Parameters(), this.getObjectArray(), "parameters", null, 0, 1, BWrappingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWrappingContext_ParameterTypes(), this.getTypeArray(), "parameterTypes", null, 0, 1, BWrappingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBWrappingContext_VarargsName(), ecorePackage.getEString(), "varargsName", null, 0, 1, BWrappingContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(bWrappingContextEClass, null, "mapContext", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBExecutionContext(), "ctx", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEString());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "map", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getBFunctionWrapper(), "functionWrapper", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(b3MetaClassEClass, B3MetaClass.class, "B3MetaClass", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		g1 = createEGenericType(ecorePackage.getEJavaClass());
		g2 = createEGenericType();
		g1.getETypeArguments().add(g2);
		initEAttribute(getB3MetaClass_InstanceClass(), g1, "instanceClass", null, 0, 1, B3MetaClass.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = addEOperation(b3MetaClassEClass, ecorePackage.getEBoolean(), "isAssignableFrom", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(bExpressionWrapperEClass, BExpressionWrapper.class, "BExpressionWrapper", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBExpressionWrapper_Original(), this.getBExpression(), null, "original", null, 0, 1, BExpressionWrapper.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(bWithContextExpressionEClass, BWithContextExpression.class, "BWithContextExpression", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBWithContextExpression_Alias(), ecorePackage.getEString(), "alias", null, 0, 1, BWithContextExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBWithContextExpression_Expr(), this.getBExpression(), null, "expr", null, 1, 1, BWithContextExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBWithContextExpression_ContextBlock(), this.getBExpression(), null, "contextBlock", null, 1, 1, BWithContextExpression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(iTypedValueContainerEClass, ITypedValueContainer.class, "ITypedValueContainer", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		op = addEOperation(iTypedValueContainerEClass, ecorePackage.getEJavaObject(), "getValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getB3EngineException());

		op = addEOperation(iTypedValueContainerEClass, this.getLValue(), "getLValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getB3EngineException());

		op = addEOperation(iTypedValueContainerEClass, ecorePackage.getEJavaObject(), "defineValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getB3EngineException());

		op = addEOperation(iTypedValueContainerEClass, ecorePackage.getEJavaObject(), "defineFinalValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getB3EngineException());

		op = addEOperation(iTypedValueContainerEClass, ecorePackage.getEJavaObject(), "defineVariableValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getB3EngineException());

		op = addEOperation(iTypedValueContainerEClass, ecorePackage.getEJavaObject(), "defineFinalVariableValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEJavaObject(), "value", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, this.getIType(), "type", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getB3EngineException());

		op = addEOperation(iTypedValueContainerEClass, ecorePackage.getEBoolean(), "isFinal", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iTypedValueContainerEClass, ecorePackage.getEBoolean(), "isImmutable", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);

		op = addEOperation(iTypedValueContainerEClass, this.getIType(), "getDeclaredValueType", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEException(op, this.getB3EngineException());

		op = addEOperation(iTypedValueContainerEClass, ecorePackage.getEBoolean(), "containsValue", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEString(), "name", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEBoolean(), "allVisible", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(visibilityEEnum, Visibility.class, "Visibility");
		addEEnumLiteral(visibilityEEnum, Visibility.PRIVATE);
		addEEnumLiteral(visibilityEEnum, Visibility.PUBLIC);

		initEEnum(executionModeEEnum, ExecutionMode.class, "ExecutionMode");
		addEEnumLiteral(executionModeEEnum, ExecutionMode.SEQUENTIAL);
		addEEnumLiteral(executionModeEEnum, ExecutionMode.PARALLEL);

		initEEnum(bJavaCallTypeEEnum, BJavaCallType.class, "BJavaCallType");
		addEEnumLiteral(bJavaCallTypeEEnum, BJavaCallType.FUNCTION);
		addEEnumLiteral(bJavaCallTypeEEnum, BJavaCallType.SYSTEM);
		addEEnumLiteral(bJavaCallTypeEEnum, BJavaCallType.METHOD);

		// Initialize data types
		initEDataType(coreExceptionEDataType, CoreException.class, "CoreException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typeEDataType, Type.class, "Type", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(objectArrayEDataType, Object[].class, "ObjectArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(valueMapEDataType, ValueMap.class, "ValueMap", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(b3EngineExceptionEDataType, B3EngineException.class, "B3EngineException", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(b3ExpressionCacheEDataType, B3ExpressionCache.class, "B3ExpressionCache", !IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(throwableEDataType, Throwable.class, "Throwable", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(lValueEDataType, LValue.class, "LValue", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typeArrayEDataType, Type[].class, "TypeArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(methodEDataType, Method.class, "Method", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(typeVariableArrayEDataType, TypeVariable[].class, "TypeVariableArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(funcStoreEDataType, B3FuncStore.class, "FuncStore", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(regexpPatternEDataType, Pattern.class, "RegexpPattern", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(stringArrayEDataType, String[].class, "StringArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(b3DynamicClassLoaderEDataType, B3DynamicClassLoader.class, "B3DynamicClassLoader", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(javaIteratorEDataType, Iterator.class, "JavaIterator", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(uriEDataType, java.net.URI.class, "URI", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(iProgressMonitorEDataType, IProgressMonitor.class, "IProgressMonitor", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //B3backendPackageImpl
