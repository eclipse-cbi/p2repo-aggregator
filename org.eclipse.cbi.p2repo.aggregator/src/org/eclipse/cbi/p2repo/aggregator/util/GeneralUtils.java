/*******************************************************************************
 * Copyright (c) 2006-2007, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 ******************************************************************************/

package org.eclipse.cbi.p2repo.aggregator.util;

import java.util.ArrayList;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

public class GeneralUtils {

	public static Aggregation getAggregation(EObject eObject) {
		EObject p = eObject;
		EObject c = p;
		while(c != null) {
			if(c instanceof Aggregation)
				return (Aggregation) c;
			p = c;
			c = c.eContainer();
		}
		// Not found in parent chain. Get the resource set.
		EList<EObject> contents = getAggregatorResource(p).getContents();
		if(contents != null && contents.size() > 0)
			return (Aggregation) contents.get(0);

		throw new IllegalArgumentException("Aggregator was not found");
	}

	public static AggregatorResource getAggregatorResource(EObject eObject) {

		try {
			for(Resource resource : new ArrayList<Resource>(eObject.eResource().getResourceSet().getResources()))
				if(resource instanceof AggregatorResource)
					return (AggregatorResource) resource;
		}
		catch(Exception e) {
			throw new IllegalArgumentException("AggregatorResource was not found", e);
		}

		throw new IllegalArgumentException("AggregatorResource was not found");
	}

	public static <T extends EnabledStatusProvider> EList<T> getEnabled(EList<T> ts) {
		int count = ts.size();
		int idx = 0;
		for(; idx < count; ++idx) {
			if(!ts.get(idx).isEnabled())
				break;
		}
		if(idx == count)
			return ts;

		EList<T> enabledTs = new UniqueEList.FastCompare<T>(count - 1);
		for(int sdx = 0; sdx < idx; ++sdx)
			enabledTs.add(ts.get(sdx));
		for(++idx; idx < count; ++idx) {
			T t = ts.get(idx);
			if(t.isEnabled())
				enabledTs.add(t);
		}
		return enabledTs;
	}

	public static boolean isBranchEnabled(Object esp) {
		if(esp instanceof EnabledStatusProvider && !((EnabledStatusProvider) esp).isEnabled())
			return false;
		if(esp instanceof EObject) {
			for(EObject v = ((EObject) esp).eContainer(); v != null; v = v.eContainer()) {
				if(v instanceof EnabledStatusProvider)
					return ((EnabledStatusProvider) v).isBranchEnabled();
			}
		}
		return true;
	}
}
