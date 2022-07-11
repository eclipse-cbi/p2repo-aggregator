/**
 * Copyright (c) 2006-2007, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.cbi.p2repo.aggregator.util;

import java.util.ArrayList;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider;
import org.eclipse.cbi.p2repo.aggregator.MavenMapping;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class GeneralUtils {

	public static Aggregation getAggregation(EObject eObject) {
		EObject p = eObject;
		EObject c = p;
		while (c != null) {
			if (c instanceof Aggregation)
				return (Aggregation) c;
			p = c;
			c = c.eContainer();
		}
		// Not found in parent chain. Get the resource set.
		EList<EObject> contents = getAggregatorResource(p).getContents();
		if (contents != null && contents.size() > 0)
			return (Aggregation) contents.get(0);

		throw new IllegalArgumentException("Aggregator was not found");
	}

	public static AggregatorResource getAggregatorResource(EObject eObject) {

		try {
			for (Resource resource : new ArrayList<Resource>(eObject.eResource().getResourceSet().getResources()))
				if (resource instanceof AggregatorResource)
					return (AggregatorResource) resource;
		} catch (Exception e) {
			throw new IllegalArgumentException("AggregatorResource was not found", e);
		}

		throw new IllegalArgumentException("AggregatorResource was not found");
	}

	public static <T extends EnabledStatusProvider> EList<T> getEnabled(EList<T> ts) {
		int count = ts.size();
		int idx = 0;
		for (; idx < count; ++idx) {
			if (!ts.get(idx).isEnabled())
				break;
		}
		if (idx == count)
			return ts;

		EList<T> enabledTs = new UniqueEList.FastCompare<T>(count - 1);
		for (int sdx = 0; sdx < idx; ++sdx)
			enabledTs.add(ts.get(sdx));
		for (++idx; idx < count; ++idx) {
			T t = ts.get(idx);
			if (t.isEnabled())
				enabledTs.add(t);
		}
		return enabledTs;
	}

	public static boolean isBranchEnabled(Object esp) {
		if (esp instanceof EnabledStatusProvider && !((EnabledStatusProvider) esp).isEnabled())
			return false;
		if (esp instanceof EObject) {
			for (EObject v = ((EObject) esp).eContainer(); v != null; v = v.eContainer()) {
				if (v instanceof EnabledStatusProvider)
					return ((EnabledStatusProvider) v).isBranchEnabled();
			}
		}
		return true;
	}

	public static String toString(MavenMapping mapping) {
		StringBuilder result = new StringBuilder();
		String namePattern = mapping.getNamePattern();
		if (namePattern != null) {
			result.append(namePattern);
		}

		result.append("' => '");
		String groupId = mapping.getGroupId();
		if (groupId != null) {
			result.append(groupId);
		}
		String artifactId = mapping.getArtifactId();
		if (artifactId != null) {
			result.append('/');
			result.append(artifactId);
		}

		String versionPattern = mapping.getVersionPattern();
		String versionTemplate = mapping.getVersionTemplate();
		if (versionPattern != null && versionTemplate != null) {
			result.append("', '").append(versionPattern);
			result.append("' => '").append(versionTemplate);
		}

		if (mapping.isSnapshot()) {
			result.append(" SNAPSHOT");
		}

		return result.toString();
	}
}
