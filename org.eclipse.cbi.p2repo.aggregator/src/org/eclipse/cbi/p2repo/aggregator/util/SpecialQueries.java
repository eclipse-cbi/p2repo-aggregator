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

package org.eclipse.cbi.p2repo.aggregator.util;

import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IInstallableUnitPatch;
import org.eclipse.equinox.p2.metadata.MetadataFactory.InstallableUnitDescription;
import org.eclipse.equinox.p2.metadata.expression.ExpressionUtil;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.QueryUtil;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class SpecialQueries {

	/**
	 * match every {@link IInstallableUnit} that describes an OSGi bundle.
	 */
	private static final IMatchExpression<IInstallableUnit> bundles = ExpressionUtil.getFactory().matchExpression(
		ExpressionUtil.parse("providedCapabilities.exists(p | p.namespace == 'osgi.bundle')")); //$NON-NLS-1$

	/**
	 * match every {@link IInstallableUnit} that describes a feature.
	 */
	private static final IMatchExpression<IInstallableUnit> features = ExpressionUtil.getFactory().matchExpression(
		ExpressionUtil.parse("id ~= /*.feature.group/")); //$NON-NLS-1$

	public static IQuery<IInstallableUnit> createBundleQuery() {
		return QueryUtil.createMatchQuery(bundles);
	}

	public static IQuery<IInstallableUnit> createFeatureQuery() {
		return QueryUtil.createMatchQuery(features);
	}

	public static IQuery<IInstallableUnit> createPatchApplicabilityQuery(IInstallableUnitPatch patch) {
		return QueryUtil.createMatchQuery(
			"$0.exists(rcs | rcs.all(rc | this ~= rc))", (Object) patch.getApplicabilityScope());
	}

	public static IQuery<IInstallableUnit> createProductQuery() {
		return QueryUtil.createIUPropertyQuery(InstallableUnitDescription.PROP_TYPE_GROUP, "true");
	}
}
