package org.eclipse.b3.beelang.tests;

import org.eclipse.b3.beelang.junit.B3Files;
import org.eclipse.b3.beelang.junit.JUnitB3TestRunner;
import org.junit.runner.RunWith;

@RunWith (JUnitB3TestRunner.class)
@B3Files ( { "/src-b3/smoketestFunctionArithmetic.b3", //
		"/src-b3/testArithmeticFunctions.b3", //
		"/src-b3/testAssertFunctions.b3", //
		"/src-b3/testAssigmentFunctions.b3", //
		"/src-b3/testBitwiseFunctions.b3", //
		"/src-b3/testCache.b3", //
		"/src-b3/testExceptions.b3", //
		"/src-b3/testGuard.b3", //
		"/src-b3/testHelloWorld.b3", //
		"/src-b3/testIfThenElse.b3", //
		"/src-b3/testJavaMethodCall.b3", //
		"/src-b3/testLambdas.b3", //
		"/src-b3/testLiteralList.b3", //
		"/src-b3/testLiteralMap.b3", //
		"/src-b3/testLogicalFunctions.b3", //
		"/src-b3/testNew.b3", //
		"/src-b3/testRelationalFunctions.b3", //
		"/src-b3/testSequenceExpression.b3", //
		"/src-b3/testSwitch.b3", //
		"/src-b3/testSystemFunctions.b3", //
		"/src-b3/testTypes.b3", //
		"/src-b3/testVarValScope.b3" //
})
public class AllB3Tests {
}