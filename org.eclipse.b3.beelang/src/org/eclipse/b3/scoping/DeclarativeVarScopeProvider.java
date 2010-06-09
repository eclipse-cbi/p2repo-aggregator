/**
 * Copyright (c) 2010, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */

package org.eclipse.b3.scoping;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.b3.backend.evaluator.b3backend.B3Function;
import org.eclipse.b3.backend.evaluator.b3backend.B3JavaImport;
import org.eclipse.b3.backend.evaluator.b3backend.BCatch;
import org.eclipse.b3.backend.evaluator.b3backend.BChainedExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BDefValue;
import org.eclipse.b3.backend.evaluator.b3backend.BExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BFunctionConcernContext;
import org.eclipse.b3.backend.evaluator.b3backend.BParameterDeclaration;
import org.eclipse.b3.backend.evaluator.b3backend.BParameterPredicate;
import org.eclipse.b3.backend.evaluator.b3backend.BVariableExpression;
import org.eclipse.b3.backend.evaluator.b3backend.BWithContextExpression;
import org.eclipse.b3.backend.evaluator.b3backend.INamedValue;
import org.eclipse.b3.build.build.BeeModel;
import org.eclipse.b3.build.build.Builder;
import org.eclipse.b3.build.build.Prerequisite;
import org.eclipse.b3.build.build.UnitProvider;
import org.eclipse.b3.build.core.B3BuildConstants;
import org.eclipse.b3.build.engine.B3BuildEngineResource;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.util.Exceptions;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.PolymorphicDispatcher.ErrorHandler;

/**
 * Provides variable scopes for a containement of expressions.
 * 
 * TODO: improve performance by not creating iterables of descriptions from arrays,
 * can just iterate over
 * 
 */
public class DeclarativeVarScopeProvider {
	private static boolean isNullOrEmpty(String s) {
		return (s == null || s.length() < 1)
				? true
				: false;

	}

	private final PolymorphicDispatcher<Object> scopeDispatcher = new PolymorphicDispatcher<Object>(
		"varScope", 1, 2, Collections.singletonList(this), new ErrorHandler<Object>() {
			public Object handle(Object[] params, Throwable e) {
				return handleError(params, e);
			}
		});

	/**
	 * Safe create SimpleScope (if outer is null).
	 * 
	 * @param outer
	 * @param descriptions
	 * @return
	 */
	private IScope createScope(IScope outer, Iterable<IEObjectDescription> descriptions) {
		return new SimpleScope(outer == null
				? SimpleScope.NULLSCOPE
				: outer, descriptions);
	}

	protected IScope doGetVarScope(EObject container, EObject contained) {
		if(container == null)
			return null;
		return (IScope) scopeDispatcher.invoke(container, contained);
	}

	protected IScope doGetVarScope(Object element) {
		IScope scope = (IScope) scopeDispatcher.invoke(element);
		if(scope != null) {
			return scope;
		}
		return null;
	}

	protected Object handleError(Object[] params, Throwable e) {
		// TODO: don't know how this is supposed to work...
		//
		return Exceptions.throwUncheckedException(e);
	}

	IScope varScope(B3Function container, EObject contained) {
		ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		for(BParameterDeclaration param : container.getParameters()) {
			result.add(new EObjectDescription(param.getName(), param, null));
		}
		// if there were no values to add, continue search in container (not meaningful to create
		// an empty scope with parent scope as outer.
		if(result.size() < 1)
			return doGetVarScope(container.eContainer(), container);
		return createScope(doGetVarScope(container.eContainer(), container), result);
	}

	public IScope varScope(BCatch container, EObject contained) {
		if(container.getName() == null)
			return doGetVarScope(container.eContainer(), container);
		ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		result.add(new EObjectDescription(container.getName(), container, null));
		return createScope(doGetVarScope(container.eContainer(), container), result);
	}

	IScope varScope(BChainedExpression container, EObject contained) {
		ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		// search expressions from start to the contained (variables declared after the contained are
		// not visible
		for(BExpression expr : container.getExpressions()) {
			if(expr == contained)
				break;
			if(expr instanceof INamedValue)
				result.add(new EObjectDescription(((INamedValue) expr).getName(), expr, null));
		}
		// if there were no values to add, continue search in container (not meaningful to create
		// an empty scope with parent scope as outer.
		if(result.size() < 1)
			return doGetVarScope(container.eContainer(), container);
		return createScope(doGetVarScope(container.eContainer(), container), result);
	}

	IScope varScope(BeeModel container, EObject contained) {
		ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();

		for(Type t : container.getImports())
			if(t instanceof B3JavaImport)
				result.add(new EObjectDescription(((INamedValue) t).getName(), (INamedValue) t, null));

		if(result.size() < 1)
			return doGetVarScope(container.eContainer(), container);
		return createScope(doGetVarScope(container.eContainer(), container), result);
	}

	IScope varScope(BFunctionConcernContext container, EObject contained) {
		ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		for(BParameterPredicate param : container.getParameters()) {
			if(param.getName() != null && param.getType() != null && isNullOrEmpty(param.getTypePredicateOp())) {
				// an unambigous parameter predicate
				result.add(new EObjectDescription(((INamedValue) param).getName(), param, null));
			}
		}
		if(result.size() < 1)
			return doGetVarScope(container.eContainer(), container);
		return createScope(doGetVarScope(container.eContainer(), container), result);
	}

	/**
	 * A Builder scope has the implicit variables input, source and output, as well as the prerequisite aliases
	 * declared in the "input" declaration. All of these are added to the scope.
	 * Note that the input can define the same alias more than once, it should only be presented once though.
	 * 
	 * @param container
	 * @param contained
	 * @return
	 */
	IScope varScope(Builder container, EObject contained) {
		URI uri = URI.createURI(B3BuildConstants.B3ENGINE_MODEL_URI);
		B3BuildEngineResource r = (B3BuildEngineResource) container.eResource().getResourceSet().getResource(uri, false);
		ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();

		BDefValue varInput = r.getVarInput();
		if(container.getInput() != null) {
			result.add(new EObjectDescription(varInput.getName(), varInput, null));
			TreeIterator<EObject> itor = container.getInput().eAllContents();
			Map<String, Prerequisite> aliasMap = new HashMap<String, Prerequisite>();
			while(itor.hasNext()) {
				EObject e = itor.next();
				if(e instanceof Prerequisite) {
					Prerequisite p = (Prerequisite) e;
					String n = p.getName();
					if(n != null && n.length() > 0 && !aliasMap.containsKey(n))
						aliasMap.put(n, p);
				}
			}
			for(Map.Entry<String, Prerequisite> element : aliasMap.entrySet())
				result.add(new EObjectDescription(element.getValue().getName(), element.getValue(), null));
		}
		BDefValue varOutput = r.getVarOutput();
		if(container.getOutput() != null) {
			result.add(new EObjectDescription(varOutput.getName(), varOutput, null));
		}

		BDefValue varSource = r.getVarSource();
		if(container.getOutput() != null) {
			result.add(new EObjectDescription(varSource.getName(), varSource, null));
		}

		return createScope(doGetVarScope(container.eContainer(), container), result);

	}

	IScope varScope(BVariableExpression varExpr) {
		IScope scope = doGetVarScope(varExpr.eContainer(), varExpr);
		if(scope == null)
			return SimpleScope.NULLSCOPE;
		return scope;
	}

	public IScope varScope(BWithContextExpression container, EObject contained) {
		ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		result.add(new EObjectDescription(container.getName(), container, null));
		return createScope(doGetVarScope(container.eContainer(), container), result);
	}

	/**
	 * Default - a container that does not introduce variables simple continues the search in its parent.
	 * 
	 * @param container
	 * @param contained
	 * @return
	 */
	public IScope varScope(EObject container, EObject contained) {
		if(container == null)
			return null;
		return doGetVarScope(container.eContainer(), container);
	}

	public IScope varScope(Object o) {
		return null;
	}

	/**
	 * Picks the "resource" variable from the engine resource
	 * 
	 * @param container
	 * @param contained
	 * @return
	 */
	IScope varScope(UnitProvider container, EObject contained) {
		URI uri = URI.createURI(B3BuildConstants.B3ENGINE_MODEL_URI);
		Resource r = container.eResource().getResourceSet().getResource(uri, false);
		BDefValue req = ((B3BuildEngineResource) r).getVarRequest();
		ArrayList<IEObjectDescription> result = new ArrayList<IEObjectDescription>();
		result.add(new EObjectDescription(req.getName(), req, null));
		return createScope(doGetVarScope(container.eContainer(), container), result);
	}
}
