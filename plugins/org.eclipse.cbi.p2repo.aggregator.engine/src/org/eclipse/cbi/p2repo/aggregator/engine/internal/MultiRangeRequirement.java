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

package org.eclipse.cbi.p2repo.aggregator.engine.internal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.equinox.internal.p2.core.helpers.CollectionUtils;
import org.eclipse.equinox.internal.p2.metadata.RequiredCapability;
import org.eclipse.equinox.internal.p2.metadata.expression.EvaluationContext;
import org.eclipse.equinox.internal.p2.metadata.expression.Expression;
import org.eclipse.equinox.internal.p2.metadata.expression.ExpressionFactory;
import org.eclipse.equinox.internal.p2.metadata.expression.Unary;
import org.eclipse.equinox.internal.p2.metadata.expression.Variable;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.metadata.expression.ExpressionUtil;
import org.eclipse.equinox.p2.metadata.expression.IEvaluationContext;
import org.eclipse.equinox.p2.metadata.expression.IExpression;
import org.eclipse.equinox.p2.metadata.expression.IExpressionFactory;
import org.eclipse.equinox.p2.metadata.expression.IExpressionVisitor;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;

@Deprecated
public class MultiRangeRequirement implements IRequirement {

	// TODO This is just a ultramegahack to satisfy the RequiredCapability.assertValid
	private static class HackingMatchExpression extends Unary implements IMatchExpression<IInstallableUnit> {
		private static final Object[] noParams = new Object[0];

		private final Object[] parameters;

		private Expression myOperand;

		HackingMatchExpression(Expression expression, Expression fakeOperand, Object... parameters) {

			// this is the hack - we will put a different operand to the superclass
			super(fakeOperand);

			this.myOperand = expression;
			this.parameters = parameters == null
					? noParams
					: parameters;
		}

		@Override
		public boolean accept(IExpressionVisitor visitor) {
			return myOperand.accept(visitor);
		}

		@Override
		public int compareTo(Expression e) {
			int cmp = getPriority() - e.getPriority();
			if(cmp == 0) {
				int e1 = getExpressionType();
				int e2 = e.getExpressionType();
				cmp = e1 > e2
						? 1
						: (e1 == e2
								? 0
								: -1);
			}

			if(cmp == 0)
				cmp = myOperand.compareTo(((HackingMatchExpression) e).myOperand);

			return cmp;
		}

		@Override
		public IEvaluationContext createContext() {
			return EvaluationContext.create(parameters, ExpressionFactory.THIS);
		}

		@Override
		public boolean equals(Object o) {
			return super.equals(o) && Arrays.equals(parameters, ((HackingMatchExpression) o).parameters);
		}

		@Override
		public Object evaluate(IEvaluationContext context) {
			return myOperand.evaluate(parameters.length == 0
					? context
					: EvaluationContext.create(context, parameters));
		}

		@Override
		public int getExpressionType() {
			return 0;
		}

		@Override
		public Expression getOperand() {
			return myOperand;
		}

		@Override
		public String getOperator() {
			throw new UnsupportedOperationException();
		}

		@Override
		public Object[] getParameters() {
			return parameters;
		}

		@Override
		public int getPriority() {
			return myOperand.getPriority();
		}

		@Override
		public int hashCode() {
			return myOperand.hashCode() * 31 + CollectionUtils.hashCode(parameters);
		}

		@Override
		public boolean isMatch(IEvaluationContext context, IInstallableUnit value) {
			ExpressionFactory.THIS.setValue(context, value);
			return Boolean.TRUE == myOperand.evaluate(context);
		}

		@Override
		public boolean isMatch(IInstallableUnit value) {
			return isMatch(createContext(), value);
		}

		@Override
		public void toLDAPString(StringBuffer bld) {
			myOperand.toLDAPString(bld);
		}

		@Override
		public void toString(StringBuilder bld, Variable rootVariable) {
			myOperand.toString(bld, rootVariable);
		}
	}

	private final IMatchExpression<IInstallableUnit> matchExpression;

	private static final String MEMBER_NAME = "name"; //$NON-NLS-1$

	private static final String MEMBER_NAMESPACE = "namespace"; //$NON-NLS-1$

	private static final String MEMBER_VERSION = "version"; //$NON-NLS-1$

	private static final String MEMBER_PROVIDED_CAPABILITIES = "providedCapabilities"; //$NON-NLS-1$

	private static IExpressionFactory factory = ExpressionUtil.getFactory();

	private static IExpression xVar = factory.variable("x"); //$NON-NLS-1$

	private static IExpression nameEqual = factory.equals(
		factory.member(xVar, MEMBER_NAME), factory.indexedParameter(0));

	private static IExpression namespaceEqual = factory.equals(
		factory.member(xVar, MEMBER_NAMESPACE), factory.indexedParameter(1));

	private static IExpression versionMember = factory.member(xVar, MEMBER_VERSION);

	private static IExpression pvMember = factory.member(factory.thisVariable(), MEMBER_PROVIDED_CAPABILITIES);

	private String name;

	private String namespace;

	private Set<Version> versions;

	private Set<VersionRange> versionRanges;

	private IMatchExpression<IInstallableUnit> filter;

	@Deprecated
	public MultiRangeRequirement(String name, String namespace, Set<Version> versions, Set<VersionRange> versionRanges,
			IMatchExpression<IInstallableUnit> filter) {
		if(versions == null)
			versions = Collections.emptySet();
		if(versionRanges == null)
			versionRanges = Collections.emptySet();

		this.name = name;
		this.namespace = namespace;
		this.versions = versions;
		this.versionRanges = versionRanges;
		this.filter = filter;

		List<IExpression> expressions = new ArrayList<IExpression>();
		List<Object> parameters = new ArrayList<Object>();
		parameters.add(name);
		parameters.add(namespace);

		int idx = 2;
		for(Version version : versions) {
			expressions.add(factory.equals(versionMember, factory.indexedParameter(idx++)));
			parameters.add(version);
		}

		for(VersionRange versionRange : versionRanges) {
			if(versionRange == null)
				versionRange = VersionRange.emptyRange;

			if(versionRange.getMinimum().equals(versionRange.getMaximum())) {
				// The same as a single version
				expressions.add(factory.equals(versionMember, factory.indexedParameter(idx++)));
				parameters.add(versionRange.getMinimum());
			}
			else {
				if(versionRange.getMaximum().equals(Version.MAX_VERSION)) {
					// Open ended
					if(versionRange.getIncludeMinimum())
						expressions.add(factory.greaterEqual(versionMember, factory.indexedParameter(idx++)));
					else
						expressions.add(factory.greater(versionMember, factory.indexedParameter(idx++)));

					parameters.add(versionRange.getMinimum());
				}
				else {
					IExpression lower;
					IExpression upper;
					if(versionRange.getIncludeMinimum())
						lower = factory.greaterEqual(versionMember, factory.indexedParameter(idx++));
					else
						lower = factory.greater(versionMember, factory.indexedParameter(idx++));

					parameters.add(versionRange.getMinimum());

					if(versionRange.getIncludeMaximum())
						upper = factory.lessEqual(versionMember, factory.indexedParameter(idx++));
					else
						upper = factory.less(versionMember, factory.indexedParameter(idx++));

					parameters.add(versionRange.getMaximum());

					expressions.add(factory.and(lower, upper));
				}
			}
		}

		// TODO This is how it should look like - but now we need the hack
		// matchExpression = factory.matchExpression(factory.exists(pvMember, factory.lambda(xVar,
		// factory.and(nameEqual,
		// namespaceEqual, factory.or(versionExpressions)))), parameters);

		// TODO This is the hack
		RequiredCapability fakeCapability = new RequiredCapability(namespace, name, null, null, false, true);
		Expression fakeOperand = ((Unary) fakeCapability.getMatches()).operand;
		matchExpression = new HackingMatchExpression(
			(Expression) factory.exists(
				pvMember,
				factory.lambda(
					xVar,
					factory.and(
						nameEqual, namespaceEqual, factory.or(expressions.toArray(new IExpression[expressions.size()]))))),
			fakeOperand, parameters.toArray(new Object[parameters.size()]));
	}

	@Deprecated
	@Override
	public String getDescription() {
		return null;
	}

	@Deprecated
	@Override
	public IMatchExpression<IInstallableUnit> getFilter() {
		return filter;
	}

	@Deprecated
	@Override
	public IMatchExpression<IInstallableUnit> getMatches() {
		return matchExpression;
	}

	@Deprecated
	@Override
	public int getMax() {
		return Integer.MAX_VALUE;
	}

	@Deprecated
	@Override
	public int getMin() {
		return 1;
	}

	/**
	 * @return the name
	 */
	@Deprecated
	public String getName() {
		return name;
	}

	/**
	 * @return the namespace
	 */
	@Deprecated
	public String getNamespace() {
		return namespace;
	}

	/**
	 * @return the version ranges
	 */
	@Deprecated
	public Set<VersionRange> getVersionRanges() {
		return versionRanges;
	}

	/**
	 * @return the versions
	 */
	@Deprecated
	public Set<Version> getVersions() {
		return versions;
	}

	@Deprecated
	@Override
	public boolean isGreedy() {
		return true;
	}

	@Deprecated
	@Override
	public boolean isMatch(IInstallableUnit iu) {
		return getMatches().isMatch(iu);
	}

	@Deprecated
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();

		if(IInstallableUnit.NAMESPACE_IU_ID.equals(getNamespace())) {
			// print nothing for an IU id dependency because this is the default (most common) case
			result.append(""); //$NON-NLS-1$
		}
		else if("osgi.bundle".equals(getNamespace())) { //$NON-NLS-1$
			result.append("bundle"); //$NON-NLS-1$
		}
		else if("java.package".equals(getNamespace())) { //$NON-NLS-1$
			result.append("package"); //$NON-NLS-1$
		}
		else {
			result.append(getNamespace());
		}
		if(result.length() > 0)
			result.append(' ');
		result.append(getName());
		result.append(' ');
		boolean first = true;
		for(Version version : getVersions()) {
			if(first)
				first = false;
			else
				result.append('|');
			result.append(version);
		}

		for(VersionRange range : getVersionRanges()) {
			if(first)
				first = false;
			else
				result.append('|');

			// for an exact version match, print a simpler expression
			if(range.getMinimum().equals(range.getMaximum()))
				result.append('[').append(range.getMinimum()).append(']');
			else
				result.append(range);
		}

		return result.toString();
	}
}
