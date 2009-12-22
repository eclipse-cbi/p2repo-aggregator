/*******************************************************************************
 * Copyright (c) 2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 ******************************************************************************/

package org.eclipse.b3.beelang.junit;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.b3.BeeLangRuntimeModule;
import org.eclipse.b3.backend.core.B3Engine;
import org.eclipse.b3.backend.core.B3EngineException;
import org.eclipse.b3.backend.evaluator.b3backend.B3JavaImport;
import org.eclipse.b3.backend.evaluator.b3backend.BExecutionContext;
import org.eclipse.b3.backend.evaluator.b3backend.BFunction;
import org.eclipse.b3.backend.evaluator.typesystem.TypeUtils;
import org.eclipse.b3.beeLang.BeeModel;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ContentHandler;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.ParentRunner;
import org.junit.runners.model.InitializationError;
import org.osgi.framework.BundleReference;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * A factory class for building JUnit 4 runners capable of executing B3 language functions as JUnit tests. A separate
 * runner is built for each of the <code>{@link B3TestFiles}</code> defined for the class passed to the factory's
 * constructor. Each runner built by this factory executes all B3 functions from the B3 file it was built for which
 * names start with the prefix of "test" as separate JUnit tests.
 * 
 * @author michal.ruzicka@cloudsmith.com
 * 
 * @see B3TestFiles
 * @see JUnitB3TestRunner
 */
class JUnitB3FileRunnerFactory {

	public static final String TEST_FUNCTION_PREFIX = "test";

	protected static final Object[] EMPTY_PARAMETER_ARRAY = new Object[] {};

	protected static final Type[] EMPTY_TYPE_ARRAY = new Type[] {};

	protected class JUnitB3FileRunner extends ParentRunner<JUnitB3FileRunner.TestFunctionDescriptor> {

		protected class TestFunctionDescriptor {

			protected String testFunctionName;

			protected Description testDescription;

			public TestFunctionDescriptor(String functionName) {
				testFunctionName = functionName;
				// We call Description.createSuiteDescription despite this is really no test suite. This is because the
				// other Description.create*Description methods take a Class<?> argument which we can't provide since
				// the tests are actually B3 functions not wrapped by any Java class.
				testDescription = Description.createSuiteDescription(String.format("%s(%s)", functionName, b3FilePath));
			}

			public String getFunctionName() {
				return testFunctionName;
			}

			public Description getDescription() {
				return testDescription;
			}

		}

		protected String b3FilePath;

		protected ArrayList<TestFunctionDescriptor> testFunctionDescriptors;

		protected B3Engine b3Engine;

		public JUnitB3FileRunner(String b3File) throws Exception {
			super(definitionClass);

			if(b3File.charAt(0) != '/')
				b3File = '/' + b3File;

			b3FilePath = b3File;

			initializeFunctionTests();
		}

		protected void initializeFunctionTests() throws Exception {
			URI b3FileURI = URI.createPlatformPluginURI(containingBundleName + b3FilePath, true);
			XtextResource resource = (XtextResource) beeLangResourceSet.createResource(b3FileURI,
					ContentHandler.UNSPECIFIED_CONTENT_TYPE);

			try {
				resource.load(null);
			} catch(IOException e) {
				throw new Exception("Failed to load B3 file: " + b3FilePath, e);
			}
			// TODO: consult resource.getErrors() and report possible errors

			BeeModel beeModel = (BeeModel) resource.getParseResult().getRootASTElement();
			BExecutionContext b3Context = (b3Engine = new B3Engine()).getContext();

			testFunctionDescriptors = new ArrayList<TestFunctionDescriptor>();

			try {
				// Define all imports as constants
				for(Type type : beeModel.getImports()) {
					if(type instanceof B3JavaImport) {
						Class<?> klass = TypeUtils.getRaw(type);
						b3Context.defineValue(((B3JavaImport) type).getName(), klass, klass);
					}
				}

				// Define all functions and create descriptors of test functions
				for(BFunction function : beeModel.getFunctions()) {
					b3Context.defineFunction(function);

					String functionName = function.getName();

					if(functionName.length() > TEST_FUNCTION_PREFIX.length()
							&& functionName.startsWith(TEST_FUNCTION_PREFIX)
							&& function.getParameterTypes().length == 0)
						testFunctionDescriptors.add(new TestFunctionDescriptor(function.getName()));
				}
			} catch(B3EngineException e) {
				throw new Exception("Failed to initialize B3Engine in preparation for testing of B3 file: "
						+ b3FilePath, e);
			}
		}

		@Override
		protected String getName() {
			return b3FilePath;
		}

		@Override
		protected Description describeChild(TestFunctionDescriptor child) {
			return child.getDescription();
		}

		@Override
		protected void runChild(TestFunctionDescriptor child, RunNotifier notifier) {
			Description testDescription = child.getDescription();

			notifier.fireTestStarted(testDescription);
			try {
				b3Engine.getContext().callFunction(child.getFunctionName(), EMPTY_PARAMETER_ARRAY, EMPTY_TYPE_ARRAY);
			} catch(Throwable t) {
				notifier.fireTestFailure(new Failure(testDescription, t));
			} finally {
				notifier.fireTestFinished(testDescription);
			}
		}

		@Override
		protected List<TestFunctionDescriptor> getChildren() {
			return testFunctionDescriptors;
		}

	}

	protected static class ErrorReportingRunner extends Runner {

		private final Description testDescription;

		private final Throwable error;

		public ErrorReportingRunner(String testName, Throwable t) {
			testDescription = Description.createSuiteDescription(testName);
			error = t;
		}

		@Override
		public Description getDescription() {
			return testDescription;
		}

		@Override
		public void run(RunNotifier notifier) {
			Description description = getDescription();

			notifier.fireTestStarted(description);
			notifier.fireTestFailure(new Failure(description, error));
			notifier.fireTestFinished(description);
		}

	}

	protected XtextResourceSet beeLangResourceSet;

	protected final Class<?> definitionClass;

	protected final String containingBundleName;

	protected List<Runner> b3FileRunners;

	{
		Injector beeLangInjector = Guice.createInjector(new BeeLangRuntimeModule());

		beeLangResourceSet = beeLangInjector.getProvider(XtextResourceSet.class).get();
	}

	public JUnitB3FileRunnerFactory(Class<?> klass) throws InitializationError {
		ClassLoader classLoader = klass.getClassLoader();

		if(!(classLoader instanceof BundleReference))
			throw new InitializationError("Failed to find out Bundle containing class: " + klass.getName());

		definitionClass = klass;
		containingBundleName = ((BundleReference) classLoader).getBundle().getSymbolicName();

		Annotation[] testClassAnnotations = klass.getAnnotations();

		for(Annotation annotation : testClassAnnotations) {
			if(annotation instanceof B3TestFiles) {
				createB3FileRunners(((B3TestFiles) annotation).value());
				return;
			}
		}

		throw new InitializationError("No @B3Files annotation specified for class: " + klass.getName());
	}

	protected Runner createB3FileRunner(String b3File) throws Exception {
		return new JUnitB3FileRunner(b3File);
	}

	protected void createB3FileRunners(String[] b3Files) {
		ArrayList<Runner> runners = new ArrayList<Runner>(b3Files.length);

		for(String b3File : b3Files) {
			try {
				runners.add(createB3FileRunner(b3File));
			} catch(Throwable t) {
				runners.add(new ErrorReportingRunner(b3File, t));
			}
		}

		b3FileRunners = runners;
	}

	public List<Runner> getB3FileRunners() {
		return b3FileRunners;
	}

}
