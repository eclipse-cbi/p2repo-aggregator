/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.b3.backend.evaluator.b3backend;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.b3.backend.evaluator.b3backend.B3backendFactory
 * @model kind="package"
 * @generated
 */
public interface B3backendPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2009, Cloudsmith Inc and others.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\rContributors:\n- Cloudsmith Inc - initial API and implementation.\r";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "b3backend";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://b3backend/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "b3backend";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	B3backendPackage eINSTANCE = org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BSourceLinkImpl <em>BSource Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BSourceLinkImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBSourceLink()
	 * @generated
	 */
	int BSOURCE_LINK = 1;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BSOURCE_LINK__LINE_NUMBER = 0;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BSOURCE_LINK__FILE_REFERENCE = 1;

	/**
	 * The number of structural features of the '<em>BSource Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BSOURCE_LINK_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BExpressionImpl <em>BExpression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBExpression()
	 * @generated
	 */
	int BEXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEXPRESSION__LINE_NUMBER = BSOURCE_LINK__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEXPRESSION__FILE_REFERENCE = BSOURCE_LINK__FILE_REFERENCE;

	/**
	 * The number of structural features of the '<em>BExpression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEXPRESSION_FEATURE_COUNT = BSOURCE_LINK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BFileReferenceImpl <em>BFile Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BFileReferenceImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBFileReference()
	 * @generated
	 */
	int BFILE_REFERENCE = 2;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFILE_REFERENCE__FILE_NAME = 0;

	/**
	 * The number of structural features of the '<em>BFile Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFILE_REFERENCE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BLineReferenceImpl <em>BLine Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BLineReferenceImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBLineReference()
	 * @generated
	 */
	int BLINE_REFERENCE = 3;

	/**
	 * The number of structural features of the '<em>BLine Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLINE_REFERENCE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BExecutionContextImpl <em>BExecution Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BExecutionContextImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBExecutionContext()
	 * @generated
	 */
	int BEXECUTION_CONTEXT = 4;

	/**
	 * The feature id for the '<em><b>Parent Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEXECUTION_CONTEXT__PARENT_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Child Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEXECUTION_CONTEXT__CHILD_CONTEXTS = 1;

	/**
	 * The feature id for the '<em><b>Value Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEXECUTION_CONTEXT__VALUE_MAP = 2;

	/**
	 * The feature id for the '<em><b>Func Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEXECUTION_CONTEXT__FUNC_STORE = 3;

	/**
	 * The number of structural features of the '<em>BExecution Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEXECUTION_CONTEXT_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BIfExpressionImpl <em>BIf Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BIfExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBIfExpression()
	 * @generated
	 */
	int BIF_EXPRESSION = 5;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIF_EXPRESSION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIF_EXPRESSION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Condition Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIF_EXPRESSION__CONDITION_EXPR = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIF_EXPRESSION__THEN_EXPR = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIF_EXPRESSION__ELSE_EXPR = BEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>BIf Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BIF_EXPRESSION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BSwitchExpressionImpl <em>BSwitch Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BSwitchExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBSwitchExpression()
	 * @generated
	 */
	int BSWITCH_EXPRESSION = 6;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BSWITCH_EXPRESSION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BSWITCH_EXPRESSION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Switch Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BSWITCH_EXPRESSION__SWITCH_EXPRESSION = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Case List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BSWITCH_EXPRESSION__CASE_LIST = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BSwitch Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BSWITCH_EXPRESSION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BCaseImpl <em>BCase</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BCaseImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBCase()
	 * @generated
	 */
	int BCASE = 7;

	/**
	 * The feature id for the '<em><b>Condition Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCASE__CONDITION_EXPR = 0;

	/**
	 * The feature id for the '<em><b>Then Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCASE__THEN_EXPR = 1;

	/**
	 * The feature id for the '<em><b>Next Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCASE__NEXT_CASE = 2;

	/**
	 * The number of structural features of the '<em>BCase</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCASE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BTryExpressionImpl <em>BTry Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BTryExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBTryExpression()
	 * @generated
	 */
	int BTRY_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTRY_EXPRESSION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTRY_EXPRESSION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Try Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTRY_EXPRESSION__TRY_EXPR = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Catch Blocks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTRY_EXPRESSION__CATCH_BLOCKS = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Finally Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTRY_EXPRESSION__FINALLY_EXPR = BEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>BTry Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTRY_EXPRESSION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BCatchImpl <em>BCatch</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BCatchImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBCatch()
	 * @generated
	 */
	int BCATCH = 9;

	/**
	 * The feature id for the '<em><b>Catch Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCATCH__CATCH_EXPR = 0;

	/**
	 * The feature id for the '<em><b>Varname</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCATCH__VARNAME = 1;

	/**
	 * The feature id for the '<em><b>Exception Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCATCH__EXCEPTION_TYPE = 2;

	/**
	 * The number of structural features of the '<em>BCatch</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCATCH_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BBinaryExpressionImpl <em>BBinary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BBinaryExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBBinaryExpression()
	 * @generated
	 */
	int BBINARY_EXPRESSION = 10;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BBINARY_EXPRESSION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BBINARY_EXPRESSION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Left Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BBINARY_EXPRESSION__LEFT_EXPR = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BBINARY_EXPRESSION__RIGHT_EXPR = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BBinary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BBINARY_EXPRESSION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BOrExpressionImpl <em>BOr Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BOrExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBOrExpression()
	 * @generated
	 */
	int BOR_EXPRESSION = 11;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOR_EXPRESSION__LINE_NUMBER = BBINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOR_EXPRESSION__FILE_REFERENCE = BBINARY_EXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Left Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOR_EXPRESSION__LEFT_EXPR = BBINARY_EXPRESSION__LEFT_EXPR;

	/**
	 * The feature id for the '<em><b>Right Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOR_EXPRESSION__RIGHT_EXPR = BBINARY_EXPRESSION__RIGHT_EXPR;

	/**
	 * The number of structural features of the '<em>BOr Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOR_EXPRESSION_FEATURE_COUNT = BBINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BAndExpressionImpl <em>BAnd Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BAndExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBAndExpression()
	 * @generated
	 */
	int BAND_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAND_EXPRESSION__LINE_NUMBER = BBINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAND_EXPRESSION__FILE_REFERENCE = BBINARY_EXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Left Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAND_EXPRESSION__LEFT_EXPR = BBINARY_EXPRESSION__LEFT_EXPR;

	/**
	 * The feature id for the '<em><b>Right Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAND_EXPRESSION__RIGHT_EXPR = BBINARY_EXPRESSION__RIGHT_EXPR;

	/**
	 * The number of structural features of the '<em>BAnd Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAND_EXPRESSION_FEATURE_COUNT = BBINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BChainedExpressionImpl <em>BChained Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BChainedExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBChainedExpression()
	 * @generated
	 */
	int BCHAINED_EXPRESSION = 13;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCHAINED_EXPRESSION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCHAINED_EXPRESSION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCHAINED_EXPRESSION__EXPRESSIONS = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BChained Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCHAINED_EXPRESSION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryExpressionImpl <em>BUnary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBUnaryExpression()
	 * @generated
	 */
	int BUNARY_EXPRESSION = 14;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_EXPRESSION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_EXPRESSION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_EXPRESSION__EXPR = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BUnary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_EXPRESSION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BThrowExpressionImpl <em>BThrow Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BThrowExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBThrowExpression()
	 * @generated
	 */
	int BTHROW_EXPRESSION = 15;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTHROW_EXPRESSION__LINE_NUMBER = BUNARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTHROW_EXPRESSION__FILE_REFERENCE = BUNARY_EXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTHROW_EXPRESSION__EXPR = BUNARY_EXPRESSION__EXPR;

	/**
	 * The number of structural features of the '<em>BThrow Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BTHROW_EXPRESSION_FEATURE_COUNT = BUNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryOpExpressionImpl <em>BUnary Op Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryOpExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBUnaryOpExpression()
	 * @generated
	 */
	int BUNARY_OP_EXPRESSION = 16;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_OP_EXPRESSION__LINE_NUMBER = BUNARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_OP_EXPRESSION__FILE_REFERENCE = BUNARY_EXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_OP_EXPRESSION__EXPR = BUNARY_EXPRESSION__EXPR;

	/**
	 * The feature id for the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_OP_EXPRESSION__FUNCTION_NAME = BUNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BUnary Op Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_OP_EXPRESSION_FEATURE_COUNT = BUNARY_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryPostOpExpressionImpl <em>BUnary Post Op Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryPostOpExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBUnaryPostOpExpression()
	 * @generated
	 */
	int BUNARY_POST_OP_EXPRESSION = 17;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_POST_OP_EXPRESSION__LINE_NUMBER = BUNARY_OP_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_POST_OP_EXPRESSION__FILE_REFERENCE = BUNARY_OP_EXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_POST_OP_EXPRESSION__EXPR = BUNARY_OP_EXPRESSION__EXPR;

	/**
	 * The feature id for the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_POST_OP_EXPRESSION__FUNCTION_NAME = BUNARY_OP_EXPRESSION__FUNCTION_NAME;

	/**
	 * The number of structural features of the '<em>BUnary Post Op Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_POST_OP_EXPRESSION_FEATURE_COUNT = BUNARY_OP_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BBinaryOpExpressionImpl <em>BBinary Op Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BBinaryOpExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBBinaryOpExpression()
	 * @generated
	 */
	int BBINARY_OP_EXPRESSION = 18;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BBINARY_OP_EXPRESSION__LINE_NUMBER = BBINARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BBINARY_OP_EXPRESSION__FILE_REFERENCE = BBINARY_EXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Left Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BBINARY_OP_EXPRESSION__LEFT_EXPR = BBINARY_EXPRESSION__LEFT_EXPR;

	/**
	 * The feature id for the '<em><b>Right Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BBINARY_OP_EXPRESSION__RIGHT_EXPR = BBINARY_EXPRESSION__RIGHT_EXPR;

	/**
	 * The feature id for the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BBINARY_OP_EXPRESSION__FUNCTION_NAME = BBINARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BBinary Op Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BBINARY_OP_EXPRESSION_FEATURE_COUNT = BBINARY_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BCachedExpressionImpl <em>BCached Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BCachedExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBCachedExpression()
	 * @generated
	 */
	int BCACHED_EXPRESSION = 19;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCACHED_EXPRESSION__LINE_NUMBER = BUNARY_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCACHED_EXPRESSION__FILE_REFERENCE = BUNARY_EXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCACHED_EXPRESSION__EXPR = BUNARY_EXPRESSION__EXPR;

	/**
	 * The number of structural features of the '<em>BCached Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCACHED_EXPRESSION_FEATURE_COUNT = BUNARY_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralExpressionImpl <em>BLiteral Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBLiteralExpression()
	 * @generated
	 */
	int BLITERAL_EXPRESSION = 20;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_EXPRESSION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_EXPRESSION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_EXPRESSION__VALUE = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BLiteral Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_EXPRESSION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralListExpressionImpl <em>BLiteral List Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralListExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBLiteralListExpression()
	 * @generated
	 */
	int BLITERAL_LIST_EXPRESSION = 21;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_LIST_EXPRESSION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_LIST_EXPRESSION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_LIST_EXPRESSION__ENTRIES = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Entry Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_LIST_EXPRESSION__ENTRY_TYPE = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BLiteral List Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_LIST_EXPRESSION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralMapExpressionImpl <em>BLiteral Map Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralMapExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBLiteralMapExpression()
	 * @generated
	 */
	int BLITERAL_MAP_EXPRESSION = 22;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_MAP_EXPRESSION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_MAP_EXPRESSION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Entries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_MAP_EXPRESSION__ENTRIES = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Key Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_MAP_EXPRESSION__KEY_TYPE = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_MAP_EXPRESSION__VALUE_TYPE = BEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>BLiteral Map Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_MAP_EXPRESSION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BMapEntryImpl <em>BMap Entry</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BMapEntryImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBMapEntry()
	 * @generated
	 */
	int BMAP_ENTRY = 23;

	/**
	 * The feature id for the '<em><b>Key</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMAP_ENTRY__KEY = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMAP_ENTRY__VALUE = 1;

	/**
	 * The number of structural features of the '<em>BMap Entry</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BMAP_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BFeatureExpressionImpl <em>BFeature Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BFeatureExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBFeatureExpression()
	 * @generated
	 */
	int BFEATURE_EXPRESSION = 24;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFEATURE_EXPRESSION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFEATURE_EXPRESSION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Obj Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFEATURE_EXPRESSION__OBJ_EXPR = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Feature Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFEATURE_EXPRESSION__FEATURE_NAME = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BFeature Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFEATURE_EXPRESSION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BAtExpressionImpl <em>BAt Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BAtExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBAtExpression()
	 * @generated
	 */
	int BAT_EXPRESSION = 25;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAT_EXPRESSION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAT_EXPRESSION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Obj Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAT_EXPRESSION__OBJ_EXPR = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Index Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAT_EXPRESSION__INDEX_EXPR = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BAt Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BAT_EXPRESSION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BVariableExpressionImpl <em>BVariable Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BVariableExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBVariableExpression()
	 * @generated
	 */
	int BVARIABLE_EXPRESSION = 26;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVARIABLE_EXPRESSION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVARIABLE_EXPRESSION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVARIABLE_EXPRESSION__NAME = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BVariable Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BVARIABLE_EXPRESSION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BParameterizedExpressionImpl <em>BParameterized Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BParameterizedExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBParameterizedExpression()
	 * @generated
	 */
	int BPARAMETERIZED_EXPRESSION = 28;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPARAMETERIZED_EXPRESSION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPARAMETERIZED_EXPRESSION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPARAMETERIZED_EXPRESSION__PARAMETERS = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BParameterized Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BPARAMETERIZED_EXPRESSION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BCallExpressionImpl <em>BCall Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BCallExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBCallExpression()
	 * @generated
	 */
	int BCALL_EXPRESSION = 27;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCALL_EXPRESSION__LINE_NUMBER = BPARAMETERIZED_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCALL_EXPRESSION__FILE_REFERENCE = BPARAMETERIZED_EXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCALL_EXPRESSION__PARAMETERS = BPARAMETERIZED_EXPRESSION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Func Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCALL_EXPRESSION__FUNC_EXPR = BPARAMETERIZED_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCALL_EXPRESSION__NAME = BPARAMETERIZED_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BCall Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCALL_EXPRESSION_FEATURE_COUNT = BPARAMETERIZED_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralAnyImpl <em>BLiteral Any</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralAnyImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBLiteralAny()
	 * @generated
	 */
	int BLITERAL_ANY = 29;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_ANY__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_ANY__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The number of structural features of the '<em>BLiteral Any</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLITERAL_ANY_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BCreateExpressionImpl <em>BCreate Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BCreateExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBCreateExpression()
	 * @generated
	 */
	int BCREATE_EXPRESSION = 30;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCREATE_EXPRESSION__LINE_NUMBER = BPARAMETERIZED_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCREATE_EXPRESSION__FILE_REFERENCE = BPARAMETERIZED_EXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCREATE_EXPRESSION__PARAMETERS = BPARAMETERIZED_EXPRESSION__PARAMETERS;

	/**
	 * The feature id for the '<em><b>Alias</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCREATE_EXPRESSION__ALIAS = BPARAMETERIZED_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCREATE_EXPRESSION__TYPE = BPARAMETERIZED_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BCreate Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCREATE_EXPRESSION_FEATURE_COUNT = BPARAMETERIZED_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BFunctionImpl <em>BFunction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BFunctionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBFunction()
	 * @generated
	 */
	int BFUNCTION = 31;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION__LINE_NUMBER = BEXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION__FILE_REFERENCE = BEXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION__PRIVATE = BEXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION__FINAL = BEXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Sequential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION__SEQUENTIAL = BEXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION__NAME = BEXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION__GUARD = BEXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION__RETURN_TYPE = BEXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Parameter Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION__PARAMETER_TYPES = BEXPRESSION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Exception Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION__EXCEPTION_TYPES = BEXPRESSION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Type Variables</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION__TYPE_VARIABLES = BEXPRESSION_FEATURE_COUNT + 8;

	/**
	 * The feature id for the '<em><b>Parameter Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION__PARAMETER_NAMES = BEXPRESSION_FEATURE_COUNT + 9;

	/**
	 * The feature id for the '<em><b>Var Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION__VAR_ARGS = BEXPRESSION_FEATURE_COUNT + 10;

	/**
	 * The number of structural features of the '<em>BFunction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BFUNCTION_FEATURE_COUNT = BEXPRESSION_FEATURE_COUNT + 11;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BGuardImpl <em>BGuard</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BGuardImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBGuard()
	 * @generated
	 */
	int BGUARD = 32;

	/**
	 * The number of structural features of the '<em>BGuard</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BGUARD_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BGuardInstanceImpl <em>BGuard Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BGuardInstanceImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBGuardInstance()
	 * @generated
	 */
	int BGUARD_INSTANCE = 33;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BGUARD_INSTANCE__INSTANCE = BGUARD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BGuard Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BGUARD_INSTANCE_FEATURE_COUNT = BGUARD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BGuardExpressionImpl <em>BGuard Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BGuardExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBGuardExpression()
	 * @generated
	 */
	int BGUARD_EXPRESSION = 34;

	/**
	 * The feature id for the '<em><b>Guard Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BGUARD_EXPRESSION__GUARD_EXPR = BGUARD_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BGuard Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BGUARD_EXPRESSION_FEATURE_COUNT = BGUARD_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BSystemContextImpl <em>BSystem Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BSystemContextImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBSystemContext()
	 * @generated
	 */
	int BSYSTEM_CONTEXT = 35;

	/**
	 * The feature id for the '<em><b>Parent Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BSYSTEM_CONTEXT__PARENT_CONTEXT = BEXECUTION_CONTEXT__PARENT_CONTEXT;

	/**
	 * The feature id for the '<em><b>Child Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BSYSTEM_CONTEXT__CHILD_CONTEXTS = BEXECUTION_CONTEXT__CHILD_CONTEXTS;

	/**
	 * The feature id for the '<em><b>Value Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BSYSTEM_CONTEXT__VALUE_MAP = BEXECUTION_CONTEXT__VALUE_MAP;

	/**
	 * The feature id for the '<em><b>Func Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BSYSTEM_CONTEXT__FUNC_STORE = BEXECUTION_CONTEXT__FUNC_STORE;

	/**
	 * The number of structural features of the '<em>BSystem Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BSYSTEM_CONTEXT_FEATURE_COUNT = BEXECUTION_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BContextImpl <em>BContext</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BContextImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBContext()
	 * @generated
	 */
	int BCONTEXT = 36;

	/**
	 * The feature id for the '<em><b>Parent Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCONTEXT__PARENT_CONTEXT = BEXECUTION_CONTEXT__PARENT_CONTEXT;

	/**
	 * The feature id for the '<em><b>Child Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCONTEXT__CHILD_CONTEXTS = BEXECUTION_CONTEXT__CHILD_CONTEXTS;

	/**
	 * The feature id for the '<em><b>Value Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCONTEXT__VALUE_MAP = BEXECUTION_CONTEXT__VALUE_MAP;

	/**
	 * The feature id for the '<em><b>Func Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCONTEXT__FUNC_STORE = BEXECUTION_CONTEXT__FUNC_STORE;

	/**
	 * The number of structural features of the '<em>BContext</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BCONTEXT_FEATURE_COUNT = BEXECUTION_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BInnerContextImpl <em>BInner Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BInnerContextImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBInnerContext()
	 * @generated
	 */
	int BINNER_CONTEXT = 37;

	/**
	 * The feature id for the '<em><b>Parent Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINNER_CONTEXT__PARENT_CONTEXT = BEXECUTION_CONTEXT__PARENT_CONTEXT;

	/**
	 * The feature id for the '<em><b>Child Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINNER_CONTEXT__CHILD_CONTEXTS = BEXECUTION_CONTEXT__CHILD_CONTEXTS;

	/**
	 * The feature id for the '<em><b>Value Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINNER_CONTEXT__VALUE_MAP = BEXECUTION_CONTEXT__VALUE_MAP;

	/**
	 * The feature id for the '<em><b>Func Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINNER_CONTEXT__FUNC_STORE = BEXECUTION_CONTEXT__FUNC_STORE;

	/**
	 * The feature id for the '<em><b>Outer Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINNER_CONTEXT__OUTER_CONTEXT = BEXECUTION_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BInner Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINNER_CONTEXT_FEATURE_COUNT = BEXECUTION_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BInvocationContextImpl <em>BInvocation Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BInvocationContextImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBInvocationContext()
	 * @generated
	 */
	int BINVOCATION_CONTEXT = 38;

	/**
	 * The feature id for the '<em><b>Parent Context</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINVOCATION_CONTEXT__PARENT_CONTEXT = BEXECUTION_CONTEXT__PARENT_CONTEXT;

	/**
	 * The feature id for the '<em><b>Child Contexts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINVOCATION_CONTEXT__CHILD_CONTEXTS = BEXECUTION_CONTEXT__CHILD_CONTEXTS;

	/**
	 * The feature id for the '<em><b>Value Map</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINVOCATION_CONTEXT__VALUE_MAP = BEXECUTION_CONTEXT__VALUE_MAP;

	/**
	 * The feature id for the '<em><b>Func Store</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINVOCATION_CONTEXT__FUNC_STORE = BEXECUTION_CONTEXT__FUNC_STORE;

	/**
	 * The feature id for the '<em><b>Expression Cache</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINVOCATION_CONTEXT__EXPRESSION_CACHE = BEXECUTION_CONTEXT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>BInvocation Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINVOCATION_CONTEXT_FEATURE_COUNT = BEXECUTION_CONTEXT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryPreOpExpressionImpl <em>BUnary Pre Op Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryPreOpExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBUnaryPreOpExpression()
	 * @generated
	 */
	int BUNARY_PRE_OP_EXPRESSION = 39;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_PRE_OP_EXPRESSION__LINE_NUMBER = BUNARY_OP_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_PRE_OP_EXPRESSION__FILE_REFERENCE = BUNARY_OP_EXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_PRE_OP_EXPRESSION__EXPR = BUNARY_OP_EXPRESSION__EXPR;

	/**
	 * The feature id for the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_PRE_OP_EXPRESSION__FUNCTION_NAME = BUNARY_OP_EXPRESSION__FUNCTION_NAME;

	/**
	 * The number of structural features of the '<em>BUnary Pre Op Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUNARY_PRE_OP_EXPRESSION_FEATURE_COUNT = BUNARY_OP_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BAssignmentExpressionImpl <em>BAssignment Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BAssignmentExpressionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBAssignmentExpression()
	 * @generated
	 */
	int BASSIGNMENT_EXPRESSION = 40;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASSIGNMENT_EXPRESSION__LINE_NUMBER = BBINARY_OP_EXPRESSION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASSIGNMENT_EXPRESSION__FILE_REFERENCE = BBINARY_OP_EXPRESSION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Left Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASSIGNMENT_EXPRESSION__LEFT_EXPR = BBINARY_OP_EXPRESSION__LEFT_EXPR;

	/**
	 * The feature id for the '<em><b>Right Expr</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASSIGNMENT_EXPRESSION__RIGHT_EXPR = BBINARY_OP_EXPRESSION__RIGHT_EXPR;

	/**
	 * The feature id for the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASSIGNMENT_EXPRESSION__FUNCTION_NAME = BBINARY_OP_EXPRESSION__FUNCTION_NAME;

	/**
	 * The number of structural features of the '<em>BAssignment Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BASSIGNMENT_EXPRESSION_FEATURE_COUNT = BBINARY_OP_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.B3FunctionImpl <em>B3 Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3FunctionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getB3Function()
	 * @generated
	 */
	int B3_FUNCTION = 41;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__LINE_NUMBER = BFUNCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__FILE_REFERENCE = BFUNCTION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__PRIVATE = BFUNCTION__PRIVATE;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__FINAL = BFUNCTION__FINAL;

	/**
	 * The feature id for the '<em><b>Sequential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__SEQUENTIAL = BFUNCTION__SEQUENTIAL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__NAME = BFUNCTION__NAME;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__GUARD = BFUNCTION__GUARD;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__RETURN_TYPE = BFUNCTION__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__PARAMETER_TYPES = BFUNCTION__PARAMETER_TYPES;

	/**
	 * The feature id for the '<em><b>Exception Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__EXCEPTION_TYPES = BFUNCTION__EXCEPTION_TYPES;

	/**
	 * The feature id for the '<em><b>Type Variables</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__TYPE_VARIABLES = BFUNCTION__TYPE_VARIABLES;

	/**
	 * The feature id for the '<em><b>Parameter Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__PARAMETER_NAMES = BFUNCTION__PARAMETER_NAMES;

	/**
	 * The feature id for the '<em><b>Var Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__VAR_ARGS = BFUNCTION__VAR_ARGS;

	/**
	 * The feature id for the '<em><b>Func Expr</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION__FUNC_EXPR = BFUNCTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>B3 Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int B3_FUNCTION_FEATURE_COUNT = BFUNCTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BJavaFunctionImpl <em>BJava Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BJavaFunctionImpl
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBJavaFunction()
	 * @generated
	 */
	int BJAVA_FUNCTION = 42;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__LINE_NUMBER = BFUNCTION__LINE_NUMBER;

	/**
	 * The feature id for the '<em><b>File Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__FILE_REFERENCE = BFUNCTION__FILE_REFERENCE;

	/**
	 * The feature id for the '<em><b>Private</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__PRIVATE = BFUNCTION__PRIVATE;

	/**
	 * The feature id for the '<em><b>Final</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__FINAL = BFUNCTION__FINAL;

	/**
	 * The feature id for the '<em><b>Sequential</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__SEQUENTIAL = BFUNCTION__SEQUENTIAL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__NAME = BFUNCTION__NAME;

	/**
	 * The feature id for the '<em><b>Guard</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__GUARD = BFUNCTION__GUARD;

	/**
	 * The feature id for the '<em><b>Return Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__RETURN_TYPE = BFUNCTION__RETURN_TYPE;

	/**
	 * The feature id for the '<em><b>Parameter Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__PARAMETER_TYPES = BFUNCTION__PARAMETER_TYPES;

	/**
	 * The feature id for the '<em><b>Exception Types</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__EXCEPTION_TYPES = BFUNCTION__EXCEPTION_TYPES;

	/**
	 * The feature id for the '<em><b>Type Variables</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__TYPE_VARIABLES = BFUNCTION__TYPE_VARIABLES;

	/**
	 * The feature id for the '<em><b>Parameter Names</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__PARAMETER_NAMES = BFUNCTION__PARAMETER_NAMES;

	/**
	 * The feature id for the '<em><b>Var Args</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__VAR_ARGS = BFUNCTION__VAR_ARGS;

	/**
	 * The feature id for the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__METHOD = BFUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>System Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION__SYSTEM_CALL = BFUNCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>BJava Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BJAVA_FUNCTION_FEATURE_COUNT = BFUNCTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '<em>Core Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.core.runtime.CoreException
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getCoreException()
	 * @generated
	 */
	int CORE_EXCEPTION = 43;


	/**
	 * The meta object id for the '<em>Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.reflect.Type
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 44;

	/**
	 * The meta object id for the '<em>Object Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getObjectArray()
	 * @generated
	 */
	int OBJECT_ARRAY = 45;


	/**
	 * The meta object id for the '<em>Value Map</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.core.ValueMap
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getValueMap()
	 * @generated
	 */
	int VALUE_MAP = 46;


	/**
	 * The meta object id for the '<em>B3 Engine Exception</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.core.B3EngineException
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getB3EngineException()
	 * @generated
	 */
	int B3_ENGINE_EXCEPTION = 47;


	/**
	 * The meta object id for the '<em>B3 Expression Cache</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.core.B3ExpressionCache
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getB3ExpressionCache()
	 * @generated
	 */
	int B3_EXPRESSION_CACHE = 48;


	/**
	 * The meta object id for the '<em>Throwable</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.Throwable
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getThrowable()
	 * @generated
	 */
	int THROWABLE = 49;

	/**
	 * The meta object id for the '<em>LValue</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.core.LValue
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getLValue()
	 * @generated
	 */
	int LVALUE = 50;

	/**
	 * The meta object id for the '<em>Type Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getTypeArray()
	 * @generated
	 */
	int TYPE_ARRAY = 51;

	/**
	 * The meta object id for the '<em>Method</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.reflect.Method
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getMethod()
	 * @generated
	 */
	int METHOD = 52;

	/**
	 * The meta object id for the '<em>Type Variable Array</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getTypeVariableArray()
	 * @generated
	 */
	int TYPE_VARIABLE_ARRAY = 53;

	/**
	 * The meta object id for the '<em>Func Store</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.b3.backend.core.B3FuncStore
	 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getFuncStore()
	 * @generated
	 */
	int FUNC_STORE = 54;

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BExpression <em>BExpression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BExpression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BExpression
	 * @generated
	 */
	EClass getBExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BSourceLink <em>BSource Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BSource Link</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BSourceLink
	 * @generated
	 */
	EClass getBSourceLink();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BSourceLink#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BSourceLink#getLineNumber()
	 * @see #getBSourceLink()
	 * @generated
	 */
	EAttribute getBSourceLink_LineNumber();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BSourceLink#getFileReference <em>File Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>File Reference</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BSourceLink#getFileReference()
	 * @see #getBSourceLink()
	 * @generated
	 */
	EReference getBSourceLink_FileReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BFileReference <em>BFile Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BFile Reference</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFileReference
	 * @generated
	 */
	EClass getBFileReference();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BFileReference#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFileReference#getFileName()
	 * @see #getBFileReference()
	 * @generated
	 */
	EAttribute getBFileReference_FileName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BLineReference <em>BLine Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BLine Reference</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BLineReference
	 * @generated
	 */
	EClass getBLineReference();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BExecutionContext <em>BExecution Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BExecution Context</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BExecutionContext
	 * @generated
	 */
	EClass getBExecutionContext();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BExecutionContext#getParentContext <em>Parent Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent Context</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BExecutionContext#getParentContext()
	 * @see #getBExecutionContext()
	 * @generated
	 */
	EReference getBExecutionContext_ParentContext();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.b3.backend.evaluator.b3backend.BExecutionContext#getChildContexts <em>Child Contexts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Child Contexts</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BExecutionContext#getChildContexts()
	 * @see #getBExecutionContext()
	 * @generated
	 */
	EReference getBExecutionContext_ChildContexts();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BExecutionContext#getValueMap <em>Value Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Map</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BExecutionContext#getValueMap()
	 * @see #getBExecutionContext()
	 * @generated
	 */
	EAttribute getBExecutionContext_ValueMap();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BExecutionContext#getFuncStore <em>Func Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Func Store</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BExecutionContext#getFuncStore()
	 * @see #getBExecutionContext()
	 * @generated
	 */
	EAttribute getBExecutionContext_FuncStore();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BIfExpression <em>BIf Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BIf Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BIfExpression
	 * @generated
	 */
	EClass getBIfExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BIfExpression#getConditionExpr <em>Condition Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BIfExpression#getConditionExpr()
	 * @see #getBIfExpression()
	 * @generated
	 */
	EReference getBIfExpression_ConditionExpr();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BIfExpression#getThenExpr <em>Then Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BIfExpression#getThenExpr()
	 * @see #getBIfExpression()
	 * @generated
	 */
	EReference getBIfExpression_ThenExpr();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BIfExpression#getElseExpr <em>Else Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BIfExpression#getElseExpr()
	 * @see #getBIfExpression()
	 * @generated
	 */
	EReference getBIfExpression_ElseExpr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BSwitchExpression <em>BSwitch Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BSwitch Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BSwitchExpression
	 * @generated
	 */
	EClass getBSwitchExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BSwitchExpression#getSwitchExpression <em>Switch Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Switch Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BSwitchExpression#getSwitchExpression()
	 * @see #getBSwitchExpression()
	 * @generated
	 */
	EReference getBSwitchExpression_SwitchExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BSwitchExpression#getCaseList <em>Case List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Case List</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BSwitchExpression#getCaseList()
	 * @see #getBSwitchExpression()
	 * @generated
	 */
	EReference getBSwitchExpression_CaseList();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BCase <em>BCase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BCase</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCase
	 * @generated
	 */
	EClass getBCase();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BCase#getConditionExpr <em>Condition Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCase#getConditionExpr()
	 * @see #getBCase()
	 * @generated
	 */
	EReference getBCase_ConditionExpr();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BCase#getThenExpr <em>Then Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCase#getThenExpr()
	 * @see #getBCase()
	 * @generated
	 */
	EReference getBCase_ThenExpr();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BCase#getNextCase <em>Next Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Next Case</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCase#getNextCase()
	 * @see #getBCase()
	 * @generated
	 */
	EReference getBCase_NextCase();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BTryExpression <em>BTry Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BTry Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BTryExpression
	 * @generated
	 */
	EClass getBTryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BTryExpression#getTryExpr <em>Try Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Try Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BTryExpression#getTryExpr()
	 * @see #getBTryExpression()
	 * @generated
	 */
	EReference getBTryExpression_TryExpr();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.b3.backend.evaluator.b3backend.BTryExpression#getCatchBlocks <em>Catch Blocks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Catch Blocks</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BTryExpression#getCatchBlocks()
	 * @see #getBTryExpression()
	 * @generated
	 */
	EReference getBTryExpression_CatchBlocks();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BTryExpression#getFinallyExpr <em>Finally Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Finally Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BTryExpression#getFinallyExpr()
	 * @see #getBTryExpression()
	 * @generated
	 */
	EReference getBTryExpression_FinallyExpr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BCatch <em>BCatch</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BCatch</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCatch
	 * @generated
	 */
	EClass getBCatch();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BCatch#getCatchExpr <em>Catch Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Catch Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCatch#getCatchExpr()
	 * @see #getBCatch()
	 * @generated
	 */
	EReference getBCatch_CatchExpr();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BCatch#getExceptionType <em>Exception Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception Type</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCatch#getExceptionType()
	 * @see #getBCatch()
	 * @generated
	 */
	EAttribute getBCatch_ExceptionType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BCatch#getVarname <em>Varname</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Varname</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCatch#getVarname()
	 * @see #getBCatch()
	 * @generated
	 */
	EAttribute getBCatch_Varname();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BBinaryExpression <em>BBinary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BBinary Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BBinaryExpression
	 * @generated
	 */
	EClass getBBinaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BBinaryExpression#getLeftExpr <em>Left Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BBinaryExpression#getLeftExpr()
	 * @see #getBBinaryExpression()
	 * @generated
	 */
	EReference getBBinaryExpression_LeftExpr();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BBinaryExpression#getRightExpr <em>Right Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BBinaryExpression#getRightExpr()
	 * @see #getBBinaryExpression()
	 * @generated
	 */
	EReference getBBinaryExpression_RightExpr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BOrExpression <em>BOr Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BOr Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BOrExpression
	 * @generated
	 */
	EClass getBOrExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BAndExpression <em>BAnd Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BAnd Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BAndExpression
	 * @generated
	 */
	EClass getBAndExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BChainedExpression <em>BChained Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BChained Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BChainedExpression
	 * @generated
	 */
	EClass getBChainedExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.b3.backend.evaluator.b3backend.BChainedExpression#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BChainedExpression#getExpressions()
	 * @see #getBChainedExpression()
	 * @generated
	 */
	EReference getBChainedExpression_Expressions();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BUnaryExpression <em>BUnary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BUnary Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BUnaryExpression
	 * @generated
	 */
	EClass getBUnaryExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BUnaryExpression#getExpr <em>Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BUnaryExpression#getExpr()
	 * @see #getBUnaryExpression()
	 * @generated
	 */
	EReference getBUnaryExpression_Expr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BThrowExpression <em>BThrow Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BThrow Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BThrowExpression
	 * @generated
	 */
	EClass getBThrowExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BUnaryOpExpression <em>BUnary Op Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BUnary Op Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BUnaryOpExpression
	 * @generated
	 */
	EClass getBUnaryOpExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BUnaryOpExpression#getFunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function Name</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BUnaryOpExpression#getFunctionName()
	 * @see #getBUnaryOpExpression()
	 * @generated
	 */
	EAttribute getBUnaryOpExpression_FunctionName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BUnaryPostOpExpression <em>BUnary Post Op Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BUnary Post Op Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BUnaryPostOpExpression
	 * @generated
	 */
	EClass getBUnaryPostOpExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BBinaryOpExpression <em>BBinary Op Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BBinary Op Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BBinaryOpExpression
	 * @generated
	 */
	EClass getBBinaryOpExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BBinaryOpExpression#getFunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function Name</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BBinaryOpExpression#getFunctionName()
	 * @see #getBBinaryOpExpression()
	 * @generated
	 */
	EAttribute getBBinaryOpExpression_FunctionName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BCachedExpression <em>BCached Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BCached Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCachedExpression
	 * @generated
	 */
	EClass getBCachedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BLiteralExpression <em>BLiteral Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BLiteral Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BLiteralExpression
	 * @generated
	 */
	EClass getBLiteralExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BLiteralExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BLiteralExpression#getValue()
	 * @see #getBLiteralExpression()
	 * @generated
	 */
	EAttribute getBLiteralExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BLiteralListExpression <em>BLiteral List Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BLiteral List Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BLiteralListExpression
	 * @generated
	 */
	EClass getBLiteralListExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.b3.backend.evaluator.b3backend.BLiteralListExpression#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BLiteralListExpression#getEntries()
	 * @see #getBLiteralListExpression()
	 * @generated
	 */
	EReference getBLiteralListExpression_Entries();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BLiteralListExpression#getEntryType <em>Entry Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Entry Type</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BLiteralListExpression#getEntryType()
	 * @see #getBLiteralListExpression()
	 * @generated
	 */
	EAttribute getBLiteralListExpression_EntryType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BLiteralMapExpression <em>BLiteral Map Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BLiteral Map Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BLiteralMapExpression
	 * @generated
	 */
	EClass getBLiteralMapExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.b3.backend.evaluator.b3backend.BLiteralMapExpression#getEntries <em>Entries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Entries</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BLiteralMapExpression#getEntries()
	 * @see #getBLiteralMapExpression()
	 * @generated
	 */
	EReference getBLiteralMapExpression_Entries();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BLiteralMapExpression#getKeyType <em>Key Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Key Type</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BLiteralMapExpression#getKeyType()
	 * @see #getBLiteralMapExpression()
	 * @generated
	 */
	EAttribute getBLiteralMapExpression_KeyType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BLiteralMapExpression#getValueType <em>Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value Type</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BLiteralMapExpression#getValueType()
	 * @see #getBLiteralMapExpression()
	 * @generated
	 */
	EAttribute getBLiteralMapExpression_ValueType();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BMapEntry <em>BMap Entry</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BMap Entry</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BMapEntry
	 * @generated
	 */
	EClass getBMapEntry();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BMapEntry#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Key</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BMapEntry#getKey()
	 * @see #getBMapEntry()
	 * @generated
	 */
	EReference getBMapEntry_Key();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BMapEntry#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BMapEntry#getValue()
	 * @see #getBMapEntry()
	 * @generated
	 */
	EReference getBMapEntry_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BFeatureExpression <em>BFeature Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BFeature Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFeatureExpression
	 * @generated
	 */
	EClass getBFeatureExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BFeatureExpression#getObjExpr <em>Obj Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Obj Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFeatureExpression#getObjExpr()
	 * @see #getBFeatureExpression()
	 * @generated
	 */
	EReference getBFeatureExpression_ObjExpr();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BFeatureExpression#getFeatureName <em>Feature Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature Name</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFeatureExpression#getFeatureName()
	 * @see #getBFeatureExpression()
	 * @generated
	 */
	EAttribute getBFeatureExpression_FeatureName();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BAtExpression <em>BAt Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BAt Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BAtExpression
	 * @generated
	 */
	EClass getBAtExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BAtExpression#getObjExpr <em>Obj Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Obj Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BAtExpression#getObjExpr()
	 * @see #getBAtExpression()
	 * @generated
	 */
	EReference getBAtExpression_ObjExpr();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BAtExpression#getIndexExpr <em>Index Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Index Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BAtExpression#getIndexExpr()
	 * @see #getBAtExpression()
	 * @generated
	 */
	EReference getBAtExpression_IndexExpr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BVariableExpression <em>BVariable Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BVariable Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BVariableExpression
	 * @generated
	 */
	EClass getBVariableExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BVariableExpression#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BVariableExpression#getName()
	 * @see #getBVariableExpression()
	 * @generated
	 */
	EAttribute getBVariableExpression_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BCallExpression <em>BCall Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BCall Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCallExpression
	 * @generated
	 */
	EClass getBCallExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BCallExpression#getFuncExpr <em>Func Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Func Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCallExpression#getFuncExpr()
	 * @see #getBCallExpression()
	 * @generated
	 */
	EReference getBCallExpression_FuncExpr();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BCallExpression#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCallExpression#getName()
	 * @see #getBCallExpression()
	 * @generated
	 */
	EAttribute getBCallExpression_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BParameterizedExpression <em>BParameterized Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BParameterized Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BParameterizedExpression
	 * @generated
	 */
	EClass getBParameterizedExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipse.b3.backend.evaluator.b3backend.BParameterizedExpression#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BParameterizedExpression#getParameters()
	 * @see #getBParameterizedExpression()
	 * @generated
	 */
	EReference getBParameterizedExpression_Parameters();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BLiteralAny <em>BLiteral Any</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BLiteral Any</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BLiteralAny
	 * @generated
	 */
	EClass getBLiteralAny();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BCreateExpression <em>BCreate Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BCreate Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCreateExpression
	 * @generated
	 */
	EClass getBCreateExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BCreateExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCreateExpression#getType()
	 * @see #getBCreateExpression()
	 * @generated
	 */
	EAttribute getBCreateExpression_Type();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BCreateExpression#getAlias <em>Alias</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Alias</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BCreateExpression#getAlias()
	 * @see #getBCreateExpression()
	 * @generated
	 */
	EAttribute getBCreateExpression_Alias();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BFunction <em>BFunction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BFunction</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFunction
	 * @generated
	 */
	EClass getBFunction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BFunction#isPrivate <em>Private</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Private</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFunction#isPrivate()
	 * @see #getBFunction()
	 * @generated
	 */
	EAttribute getBFunction_Private();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BFunction#isFinal <em>Final</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Final</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFunction#isFinal()
	 * @see #getBFunction()
	 * @generated
	 */
	EAttribute getBFunction_Final();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BFunction#isSequential <em>Sequential</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sequential</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFunction#isSequential()
	 * @see #getBFunction()
	 * @generated
	 */
	EAttribute getBFunction_Sequential();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BFunction#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFunction#getName()
	 * @see #getBFunction()
	 * @generated
	 */
	EAttribute getBFunction_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BFunction#getGuard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Guard</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFunction#getGuard()
	 * @see #getBFunction()
	 * @generated
	 */
	EReference getBFunction_Guard();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BFunction#getReturnType <em>Return Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Return Type</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFunction#getReturnType()
	 * @see #getBFunction()
	 * @generated
	 */
	EAttribute getBFunction_ReturnType();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BFunction#getParameterTypes <em>Parameter Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter Types</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFunction#getParameterTypes()
	 * @see #getBFunction()
	 * @generated
	 */
	EAttribute getBFunction_ParameterTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BFunction#getExceptionTypes <em>Exception Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exception Types</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFunction#getExceptionTypes()
	 * @see #getBFunction()
	 * @generated
	 */
	EAttribute getBFunction_ExceptionTypes();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BFunction#getTypeVariables <em>Type Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Variables</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFunction#getTypeVariables()
	 * @see #getBFunction()
	 * @generated
	 */
	EAttribute getBFunction_TypeVariables();

	/**
	 * Returns the meta object for the attribute list '{@link org.eclipse.b3.backend.evaluator.b3backend.BFunction#getParameterNames <em>Parameter Names</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Parameter Names</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFunction#getParameterNames()
	 * @see #getBFunction()
	 * @generated
	 */
	EAttribute getBFunction_ParameterNames();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BFunction#isVarArgs <em>Var Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Var Args</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BFunction#isVarArgs()
	 * @see #getBFunction()
	 * @generated
	 */
	EAttribute getBFunction_VarArgs();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BGuard <em>BGuard</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BGuard</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BGuard
	 * @generated
	 */
	EClass getBGuard();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BGuardInstance <em>BGuard Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BGuard Instance</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BGuardInstance
	 * @generated
	 */
	EClass getBGuardInstance();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BGuardInstance#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Instance</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BGuardInstance#getInstance()
	 * @see #getBGuardInstance()
	 * @generated
	 */
	EAttribute getBGuardInstance_Instance();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BGuardExpression <em>BGuard Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BGuard Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BGuardExpression
	 * @generated
	 */
	EClass getBGuardExpression();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BGuardExpression#getGuardExpr <em>Guard Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Guard Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BGuardExpression#getGuardExpr()
	 * @see #getBGuardExpression()
	 * @generated
	 */
	EReference getBGuardExpression_GuardExpr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BSystemContext <em>BSystem Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BSystem Context</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BSystemContext
	 * @generated
	 */
	EClass getBSystemContext();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BContext <em>BContext</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BContext</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BContext
	 * @generated
	 */
	EClass getBContext();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BInnerContext <em>BInner Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BInner Context</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BInnerContext
	 * @generated
	 */
	EClass getBInnerContext();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.b3.backend.evaluator.b3backend.BInnerContext#getOuterContext <em>Outer Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Outer Context</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BInnerContext#getOuterContext()
	 * @see #getBInnerContext()
	 * @generated
	 */
	EReference getBInnerContext_OuterContext();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BInvocationContext <em>BInvocation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BInvocation Context</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BInvocationContext
	 * @generated
	 */
	EClass getBInvocationContext();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BInvocationContext#getExpressionCache <em>Expression Cache</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Expression Cache</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BInvocationContext#getExpressionCache()
	 * @see #getBInvocationContext()
	 * @generated
	 */
	EAttribute getBInvocationContext_ExpressionCache();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BUnaryPreOpExpression <em>BUnary Pre Op Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BUnary Pre Op Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BUnaryPreOpExpression
	 * @generated
	 */
	EClass getBUnaryPreOpExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BAssignmentExpression <em>BAssignment Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BAssignment Expression</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BAssignmentExpression
	 * @generated
	 */
	EClass getBAssignmentExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.B3Function <em>B3 Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>B3 Function</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.B3Function
	 * @generated
	 */
	EClass getB3Function();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.b3.backend.evaluator.b3backend.B3Function#getFuncExpr <em>Func Expr</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Func Expr</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.B3Function#getFuncExpr()
	 * @see #getB3Function()
	 * @generated
	 */
	EReference getB3Function_FuncExpr();

	/**
	 * Returns the meta object for class '{@link org.eclipse.b3.backend.evaluator.b3backend.BJavaFunction <em>BJava Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>BJava Function</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BJavaFunction
	 * @generated
	 */
	EClass getBJavaFunction();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BJavaFunction#getMethod <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BJavaFunction#getMethod()
	 * @see #getBJavaFunction()
	 * @generated
	 */
	EAttribute getBJavaFunction_Method();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.b3.backend.evaluator.b3backend.BJavaFunction#isSystemCall <em>System Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>System Call</em>'.
	 * @see org.eclipse.b3.backend.evaluator.b3backend.BJavaFunction#isSystemCall()
	 * @see #getBJavaFunction()
	 * @generated
	 */
	EAttribute getBJavaFunction_SystemCall();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.core.runtime.CoreException <em>Core Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Core Exception</em>'.
	 * @see org.eclipse.core.runtime.CoreException
	 * @model instanceClass="org.eclipse.core.runtime.CoreException"
	 * @generated
	 */
	EDataType getCoreException();

	/**
	 * Returns the meta object for data type '{@link java.lang.reflect.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type</em>'.
	 * @see java.lang.reflect.Type
	 * @model instanceClass="java.lang.reflect.Type"
	 * @generated
	 */
	EDataType getType();

	/**
	 * Returns the meta object for data type '<em>Object Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Object Array</em>'.
	 * @model instanceClass="java.lang.Object[]"
	 * @generated
	 */
	EDataType getObjectArray();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.b3.backend.core.ValueMap <em>Value Map</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Value Map</em>'.
	 * @see org.eclipse.b3.backend.core.ValueMap
	 * @model instanceClass="org.eclipse.b3.backend.core.ValueMap"
	 * @generated
	 */
	EDataType getValueMap();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.b3.backend.core.B3EngineException <em>B3 Engine Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>B3 Engine Exception</em>'.
	 * @see org.eclipse.b3.backend.core.B3EngineException
	 * @model instanceClass="org.eclipse.b3.backend.core.B3EngineException"
	 * @generated
	 */
	EDataType getB3EngineException();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.b3.backend.core.B3ExpressionCache <em>B3 Expression Cache</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>B3 Expression Cache</em>'.
	 * @see org.eclipse.b3.backend.core.B3ExpressionCache
	 * @model instanceClass="org.eclipse.b3.backend.core.B3ExpressionCache" serializeable="false"
	 * @generated
	 */
	EDataType getB3ExpressionCache();

	/**
	 * Returns the meta object for data type '{@link java.lang.Throwable <em>Throwable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Throwable</em>'.
	 * @see java.lang.Throwable
	 * @model instanceClass="java.lang.Throwable"
	 * @generated
	 */
	EDataType getThrowable();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.b3.backend.core.LValue <em>LValue</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>LValue</em>'.
	 * @see org.eclipse.b3.backend.core.LValue
	 * @model instanceClass="org.eclipse.b3.backend.core.LValue"
	 * @generated
	 */
	EDataType getLValue();

	/**
	 * Returns the meta object for data type '<em>Type Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Array</em>'.
	 * @model instanceClass="java.lang.reflect.Type[]"
	 * @generated
	 */
	EDataType getTypeArray();

	/**
	 * Returns the meta object for data type '{@link java.lang.reflect.Method <em>Method</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Method</em>'.
	 * @see java.lang.reflect.Method
	 * @model instanceClass="java.lang.reflect.Method"
	 * @generated
	 */
	EDataType getMethod();

	/**
	 * Returns the meta object for data type '<em>Type Variable Array</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Type Variable Array</em>'.
	 * @model instanceClass="java.lang.reflect.TypeVariable[]"
	 * @generated
	 */
	EDataType getTypeVariableArray();

	/**
	 * Returns the meta object for data type '{@link org.eclipse.b3.backend.core.B3FuncStore <em>Func Store</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Func Store</em>'.
	 * @see org.eclipse.b3.backend.core.B3FuncStore
	 * @model instanceClass="org.eclipse.b3.backend.core.B3FuncStore"
	 * @generated
	 */
	EDataType getFuncStore();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	B3backendFactory getB3backendFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BExpressionImpl <em>BExpression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBExpression()
		 * @generated
		 */
		EClass BEXPRESSION = eINSTANCE.getBExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BSourceLinkImpl <em>BSource Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BSourceLinkImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBSourceLink()
		 * @generated
		 */
		EClass BSOURCE_LINK = eINSTANCE.getBSourceLink();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BSOURCE_LINK__LINE_NUMBER = eINSTANCE.getBSourceLink_LineNumber();

		/**
		 * The meta object literal for the '<em><b>File Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BSOURCE_LINK__FILE_REFERENCE = eINSTANCE.getBSourceLink_FileReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BFileReferenceImpl <em>BFile Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BFileReferenceImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBFileReference()
		 * @generated
		 */
		EClass BFILE_REFERENCE = eINSTANCE.getBFileReference();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BFILE_REFERENCE__FILE_NAME = eINSTANCE.getBFileReference_FileName();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BLineReferenceImpl <em>BLine Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BLineReferenceImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBLineReference()
		 * @generated
		 */
		EClass BLINE_REFERENCE = eINSTANCE.getBLineReference();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BExecutionContextImpl <em>BExecution Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BExecutionContextImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBExecutionContext()
		 * @generated
		 */
		EClass BEXECUTION_CONTEXT = eINSTANCE.getBExecutionContext();

		/**
		 * The meta object literal for the '<em><b>Parent Context</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEXECUTION_CONTEXT__PARENT_CONTEXT = eINSTANCE.getBExecutionContext_ParentContext();

		/**
		 * The meta object literal for the '<em><b>Child Contexts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEXECUTION_CONTEXT__CHILD_CONTEXTS = eINSTANCE.getBExecutionContext_ChildContexts();

		/**
		 * The meta object literal for the '<em><b>Value Map</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEXECUTION_CONTEXT__VALUE_MAP = eINSTANCE.getBExecutionContext_ValueMap();

		/**
		 * The meta object literal for the '<em><b>Func Store</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BEXECUTION_CONTEXT__FUNC_STORE = eINSTANCE.getBExecutionContext_FuncStore();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BIfExpressionImpl <em>BIf Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BIfExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBIfExpression()
		 * @generated
		 */
		EClass BIF_EXPRESSION = eINSTANCE.getBIfExpression();

		/**
		 * The meta object literal for the '<em><b>Condition Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIF_EXPRESSION__CONDITION_EXPR = eINSTANCE.getBIfExpression_ConditionExpr();

		/**
		 * The meta object literal for the '<em><b>Then Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIF_EXPRESSION__THEN_EXPR = eINSTANCE.getBIfExpression_ThenExpr();

		/**
		 * The meta object literal for the '<em><b>Else Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BIF_EXPRESSION__ELSE_EXPR = eINSTANCE.getBIfExpression_ElseExpr();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BSwitchExpressionImpl <em>BSwitch Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BSwitchExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBSwitchExpression()
		 * @generated
		 */
		EClass BSWITCH_EXPRESSION = eINSTANCE.getBSwitchExpression();

		/**
		 * The meta object literal for the '<em><b>Switch Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BSWITCH_EXPRESSION__SWITCH_EXPRESSION = eINSTANCE.getBSwitchExpression_SwitchExpression();

		/**
		 * The meta object literal for the '<em><b>Case List</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BSWITCH_EXPRESSION__CASE_LIST = eINSTANCE.getBSwitchExpression_CaseList();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BCaseImpl <em>BCase</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BCaseImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBCase()
		 * @generated
		 */
		EClass BCASE = eINSTANCE.getBCase();

		/**
		 * The meta object literal for the '<em><b>Condition Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BCASE__CONDITION_EXPR = eINSTANCE.getBCase_ConditionExpr();

		/**
		 * The meta object literal for the '<em><b>Then Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BCASE__THEN_EXPR = eINSTANCE.getBCase_ThenExpr();

		/**
		 * The meta object literal for the '<em><b>Next Case</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BCASE__NEXT_CASE = eINSTANCE.getBCase_NextCase();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BTryExpressionImpl <em>BTry Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BTryExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBTryExpression()
		 * @generated
		 */
		EClass BTRY_EXPRESSION = eINSTANCE.getBTryExpression();

		/**
		 * The meta object literal for the '<em><b>Try Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BTRY_EXPRESSION__TRY_EXPR = eINSTANCE.getBTryExpression_TryExpr();

		/**
		 * The meta object literal for the '<em><b>Catch Blocks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BTRY_EXPRESSION__CATCH_BLOCKS = eINSTANCE.getBTryExpression_CatchBlocks();

		/**
		 * The meta object literal for the '<em><b>Finally Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BTRY_EXPRESSION__FINALLY_EXPR = eINSTANCE.getBTryExpression_FinallyExpr();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BCatchImpl <em>BCatch</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BCatchImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBCatch()
		 * @generated
		 */
		EClass BCATCH = eINSTANCE.getBCatch();

		/**
		 * The meta object literal for the '<em><b>Catch Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BCATCH__CATCH_EXPR = eINSTANCE.getBCatch_CatchExpr();

		/**
		 * The meta object literal for the '<em><b>Exception Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BCATCH__EXCEPTION_TYPE = eINSTANCE.getBCatch_ExceptionType();

		/**
		 * The meta object literal for the '<em><b>Varname</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BCATCH__VARNAME = eINSTANCE.getBCatch_Varname();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BBinaryExpressionImpl <em>BBinary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BBinaryExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBBinaryExpression()
		 * @generated
		 */
		EClass BBINARY_EXPRESSION = eINSTANCE.getBBinaryExpression();

		/**
		 * The meta object literal for the '<em><b>Left Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BBINARY_EXPRESSION__LEFT_EXPR = eINSTANCE.getBBinaryExpression_LeftExpr();

		/**
		 * The meta object literal for the '<em><b>Right Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BBINARY_EXPRESSION__RIGHT_EXPR = eINSTANCE.getBBinaryExpression_RightExpr();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BOrExpressionImpl <em>BOr Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BOrExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBOrExpression()
		 * @generated
		 */
		EClass BOR_EXPRESSION = eINSTANCE.getBOrExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BAndExpressionImpl <em>BAnd Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BAndExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBAndExpression()
		 * @generated
		 */
		EClass BAND_EXPRESSION = eINSTANCE.getBAndExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BChainedExpressionImpl <em>BChained Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BChainedExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBChainedExpression()
		 * @generated
		 */
		EClass BCHAINED_EXPRESSION = eINSTANCE.getBChainedExpression();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BCHAINED_EXPRESSION__EXPRESSIONS = eINSTANCE.getBChainedExpression_Expressions();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryExpressionImpl <em>BUnary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBUnaryExpression()
		 * @generated
		 */
		EClass BUNARY_EXPRESSION = eINSTANCE.getBUnaryExpression();

		/**
		 * The meta object literal for the '<em><b>Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BUNARY_EXPRESSION__EXPR = eINSTANCE.getBUnaryExpression_Expr();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BThrowExpressionImpl <em>BThrow Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BThrowExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBThrowExpression()
		 * @generated
		 */
		EClass BTHROW_EXPRESSION = eINSTANCE.getBThrowExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryOpExpressionImpl <em>BUnary Op Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryOpExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBUnaryOpExpression()
		 * @generated
		 */
		EClass BUNARY_OP_EXPRESSION = eINSTANCE.getBUnaryOpExpression();

		/**
		 * The meta object literal for the '<em><b>Function Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BUNARY_OP_EXPRESSION__FUNCTION_NAME = eINSTANCE.getBUnaryOpExpression_FunctionName();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryPostOpExpressionImpl <em>BUnary Post Op Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryPostOpExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBUnaryPostOpExpression()
		 * @generated
		 */
		EClass BUNARY_POST_OP_EXPRESSION = eINSTANCE.getBUnaryPostOpExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BBinaryOpExpressionImpl <em>BBinary Op Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BBinaryOpExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBBinaryOpExpression()
		 * @generated
		 */
		EClass BBINARY_OP_EXPRESSION = eINSTANCE.getBBinaryOpExpression();

		/**
		 * The meta object literal for the '<em><b>Function Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BBINARY_OP_EXPRESSION__FUNCTION_NAME = eINSTANCE.getBBinaryOpExpression_FunctionName();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BCachedExpressionImpl <em>BCached Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BCachedExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBCachedExpression()
		 * @generated
		 */
		EClass BCACHED_EXPRESSION = eINSTANCE.getBCachedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralExpressionImpl <em>BLiteral Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBLiteralExpression()
		 * @generated
		 */
		EClass BLITERAL_EXPRESSION = eINSTANCE.getBLiteralExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLITERAL_EXPRESSION__VALUE = eINSTANCE.getBLiteralExpression_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralListExpressionImpl <em>BLiteral List Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralListExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBLiteralListExpression()
		 * @generated
		 */
		EClass BLITERAL_LIST_EXPRESSION = eINSTANCE.getBLiteralListExpression();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLITERAL_LIST_EXPRESSION__ENTRIES = eINSTANCE.getBLiteralListExpression_Entries();

		/**
		 * The meta object literal for the '<em><b>Entry Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLITERAL_LIST_EXPRESSION__ENTRY_TYPE = eINSTANCE.getBLiteralListExpression_EntryType();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralMapExpressionImpl <em>BLiteral Map Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralMapExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBLiteralMapExpression()
		 * @generated
		 */
		EClass BLITERAL_MAP_EXPRESSION = eINSTANCE.getBLiteralMapExpression();

		/**
		 * The meta object literal for the '<em><b>Entries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLITERAL_MAP_EXPRESSION__ENTRIES = eINSTANCE.getBLiteralMapExpression_Entries();

		/**
		 * The meta object literal for the '<em><b>Key Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLITERAL_MAP_EXPRESSION__KEY_TYPE = eINSTANCE.getBLiteralMapExpression_KeyType();

		/**
		 * The meta object literal for the '<em><b>Value Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BLITERAL_MAP_EXPRESSION__VALUE_TYPE = eINSTANCE.getBLiteralMapExpression_ValueType();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BMapEntryImpl <em>BMap Entry</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BMapEntryImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBMapEntry()
		 * @generated
		 */
		EClass BMAP_ENTRY = eINSTANCE.getBMapEntry();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMAP_ENTRY__KEY = eINSTANCE.getBMapEntry_Key();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BMAP_ENTRY__VALUE = eINSTANCE.getBMapEntry_Value();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BFeatureExpressionImpl <em>BFeature Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BFeatureExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBFeatureExpression()
		 * @generated
		 */
		EClass BFEATURE_EXPRESSION = eINSTANCE.getBFeatureExpression();

		/**
		 * The meta object literal for the '<em><b>Obj Expr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFEATURE_EXPRESSION__OBJ_EXPR = eINSTANCE.getBFeatureExpression_ObjExpr();

		/**
		 * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BFEATURE_EXPRESSION__FEATURE_NAME = eINSTANCE.getBFeatureExpression_FeatureName();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BAtExpressionImpl <em>BAt Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BAtExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBAtExpression()
		 * @generated
		 */
		EClass BAT_EXPRESSION = eINSTANCE.getBAtExpression();

		/**
		 * The meta object literal for the '<em><b>Obj Expr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BAT_EXPRESSION__OBJ_EXPR = eINSTANCE.getBAtExpression_ObjExpr();

		/**
		 * The meta object literal for the '<em><b>Index Expr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BAT_EXPRESSION__INDEX_EXPR = eINSTANCE.getBAtExpression_IndexExpr();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BVariableExpressionImpl <em>BVariable Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BVariableExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBVariableExpression()
		 * @generated
		 */
		EClass BVARIABLE_EXPRESSION = eINSTANCE.getBVariableExpression();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BVARIABLE_EXPRESSION__NAME = eINSTANCE.getBVariableExpression_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BCallExpressionImpl <em>BCall Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BCallExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBCallExpression()
		 * @generated
		 */
		EClass BCALL_EXPRESSION = eINSTANCE.getBCallExpression();

		/**
		 * The meta object literal for the '<em><b>Func Expr</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BCALL_EXPRESSION__FUNC_EXPR = eINSTANCE.getBCallExpression_FuncExpr();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BCALL_EXPRESSION__NAME = eINSTANCE.getBCallExpression_Name();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BParameterizedExpressionImpl <em>BParameterized Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BParameterizedExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBParameterizedExpression()
		 * @generated
		 */
		EClass BPARAMETERIZED_EXPRESSION = eINSTANCE.getBParameterizedExpression();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BPARAMETERIZED_EXPRESSION__PARAMETERS = eINSTANCE.getBParameterizedExpression_Parameters();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralAnyImpl <em>BLiteral Any</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BLiteralAnyImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBLiteralAny()
		 * @generated
		 */
		EClass BLITERAL_ANY = eINSTANCE.getBLiteralAny();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BCreateExpressionImpl <em>BCreate Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BCreateExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBCreateExpression()
		 * @generated
		 */
		EClass BCREATE_EXPRESSION = eINSTANCE.getBCreateExpression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BCREATE_EXPRESSION__TYPE = eINSTANCE.getBCreateExpression_Type();

		/**
		 * The meta object literal for the '<em><b>Alias</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BCREATE_EXPRESSION__ALIAS = eINSTANCE.getBCreateExpression_Alias();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BFunctionImpl <em>BFunction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BFunctionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBFunction()
		 * @generated
		 */
		EClass BFUNCTION = eINSTANCE.getBFunction();

		/**
		 * The meta object literal for the '<em><b>Private</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BFUNCTION__PRIVATE = eINSTANCE.getBFunction_Private();

		/**
		 * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BFUNCTION__FINAL = eINSTANCE.getBFunction_Final();

		/**
		 * The meta object literal for the '<em><b>Sequential</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BFUNCTION__SEQUENTIAL = eINSTANCE.getBFunction_Sequential();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BFUNCTION__NAME = eINSTANCE.getBFunction_Name();

		/**
		 * The meta object literal for the '<em><b>Guard</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BFUNCTION__GUARD = eINSTANCE.getBFunction_Guard();

		/**
		 * The meta object literal for the '<em><b>Return Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BFUNCTION__RETURN_TYPE = eINSTANCE.getBFunction_ReturnType();

		/**
		 * The meta object literal for the '<em><b>Parameter Types</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BFUNCTION__PARAMETER_TYPES = eINSTANCE.getBFunction_ParameterTypes();

		/**
		 * The meta object literal for the '<em><b>Exception Types</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BFUNCTION__EXCEPTION_TYPES = eINSTANCE.getBFunction_ExceptionTypes();

		/**
		 * The meta object literal for the '<em><b>Type Variables</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BFUNCTION__TYPE_VARIABLES = eINSTANCE.getBFunction_TypeVariables();

		/**
		 * The meta object literal for the '<em><b>Parameter Names</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BFUNCTION__PARAMETER_NAMES = eINSTANCE.getBFunction_ParameterNames();

		/**
		 * The meta object literal for the '<em><b>Var Args</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BFUNCTION__VAR_ARGS = eINSTANCE.getBFunction_VarArgs();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BGuardImpl <em>BGuard</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BGuardImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBGuard()
		 * @generated
		 */
		EClass BGUARD = eINSTANCE.getBGuard();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BGuardInstanceImpl <em>BGuard Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BGuardInstanceImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBGuardInstance()
		 * @generated
		 */
		EClass BGUARD_INSTANCE = eINSTANCE.getBGuardInstance();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BGUARD_INSTANCE__INSTANCE = eINSTANCE.getBGuardInstance_Instance();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BGuardExpressionImpl <em>BGuard Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BGuardExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBGuardExpression()
		 * @generated
		 */
		EClass BGUARD_EXPRESSION = eINSTANCE.getBGuardExpression();

		/**
		 * The meta object literal for the '<em><b>Guard Expr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BGUARD_EXPRESSION__GUARD_EXPR = eINSTANCE.getBGuardExpression_GuardExpr();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BSystemContextImpl <em>BSystem Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BSystemContextImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBSystemContext()
		 * @generated
		 */
		EClass BSYSTEM_CONTEXT = eINSTANCE.getBSystemContext();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BContextImpl <em>BContext</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BContextImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBContext()
		 * @generated
		 */
		EClass BCONTEXT = eINSTANCE.getBContext();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BInnerContextImpl <em>BInner Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BInnerContextImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBInnerContext()
		 * @generated
		 */
		EClass BINNER_CONTEXT = eINSTANCE.getBInnerContext();

		/**
		 * The meta object literal for the '<em><b>Outer Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINNER_CONTEXT__OUTER_CONTEXT = eINSTANCE.getBInnerContext_OuterContext();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BInvocationContextImpl <em>BInvocation Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BInvocationContextImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBInvocationContext()
		 * @generated
		 */
		EClass BINVOCATION_CONTEXT = eINSTANCE.getBInvocationContext();

		/**
		 * The meta object literal for the '<em><b>Expression Cache</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BINVOCATION_CONTEXT__EXPRESSION_CACHE = eINSTANCE.getBInvocationContext_ExpressionCache();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryPreOpExpressionImpl <em>BUnary Pre Op Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BUnaryPreOpExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBUnaryPreOpExpression()
		 * @generated
		 */
		EClass BUNARY_PRE_OP_EXPRESSION = eINSTANCE.getBUnaryPreOpExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BAssignmentExpressionImpl <em>BAssignment Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BAssignmentExpressionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBAssignmentExpression()
		 * @generated
		 */
		EClass BASSIGNMENT_EXPRESSION = eINSTANCE.getBAssignmentExpression();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.B3FunctionImpl <em>B3 Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3FunctionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getB3Function()
		 * @generated
		 */
		EClass B3_FUNCTION = eINSTANCE.getB3Function();

		/**
		 * The meta object literal for the '<em><b>Func Expr</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference B3_FUNCTION__FUNC_EXPR = eINSTANCE.getB3Function_FuncExpr();

		/**
		 * The meta object literal for the '{@link org.eclipse.b3.backend.evaluator.b3backend.impl.BJavaFunctionImpl <em>BJava Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.BJavaFunctionImpl
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getBJavaFunction()
		 * @generated
		 */
		EClass BJAVA_FUNCTION = eINSTANCE.getBJavaFunction();

		/**
		 * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BJAVA_FUNCTION__METHOD = eINSTANCE.getBJavaFunction_Method();

		/**
		 * The meta object literal for the '<em><b>System Call</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BJAVA_FUNCTION__SYSTEM_CALL = eINSTANCE.getBJavaFunction_SystemCall();

		/**
		 * The meta object literal for the '<em>Core Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.core.runtime.CoreException
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getCoreException()
		 * @generated
		 */
		EDataType CORE_EXCEPTION = eINSTANCE.getCoreException();

		/**
		 * The meta object literal for the '<em>Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.reflect.Type
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getType()
		 * @generated
		 */
		EDataType TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '<em>Object Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getObjectArray()
		 * @generated
		 */
		EDataType OBJECT_ARRAY = eINSTANCE.getObjectArray();

		/**
		 * The meta object literal for the '<em>Value Map</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.core.ValueMap
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getValueMap()
		 * @generated
		 */
		EDataType VALUE_MAP = eINSTANCE.getValueMap();

		/**
		 * The meta object literal for the '<em>B3 Engine Exception</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.core.B3EngineException
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getB3EngineException()
		 * @generated
		 */
		EDataType B3_ENGINE_EXCEPTION = eINSTANCE.getB3EngineException();

		/**
		 * The meta object literal for the '<em>B3 Expression Cache</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.core.B3ExpressionCache
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getB3ExpressionCache()
		 * @generated
		 */
		EDataType B3_EXPRESSION_CACHE = eINSTANCE.getB3ExpressionCache();

		/**
		 * The meta object literal for the '<em>Throwable</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.Throwable
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getThrowable()
		 * @generated
		 */
		EDataType THROWABLE = eINSTANCE.getThrowable();

		/**
		 * The meta object literal for the '<em>LValue</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.core.LValue
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getLValue()
		 * @generated
		 */
		EDataType LVALUE = eINSTANCE.getLValue();

		/**
		 * The meta object literal for the '<em>Type Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getTypeArray()
		 * @generated
		 */
		EDataType TYPE_ARRAY = eINSTANCE.getTypeArray();

		/**
		 * The meta object literal for the '<em>Method</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.reflect.Method
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getMethod()
		 * @generated
		 */
		EDataType METHOD = eINSTANCE.getMethod();

		/**
		 * The meta object literal for the '<em>Type Variable Array</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getTypeVariableArray()
		 * @generated
		 */
		EDataType TYPE_VARIABLE_ARRAY = eINSTANCE.getTypeVariableArray();

		/**
		 * The meta object literal for the '<em>Func Store</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.b3.backend.core.B3FuncStore
		 * @see org.eclipse.b3.backend.evaluator.b3backend.impl.B3backendPackageImpl#getFuncStore()
		 * @generated
		 */
		EDataType FUNC_STORE = eINSTANCE.getFuncStore();

	}

} //B3backendPackage