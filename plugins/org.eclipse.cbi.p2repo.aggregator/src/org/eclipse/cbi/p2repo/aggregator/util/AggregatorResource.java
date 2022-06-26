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

import java.util.Map;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.xmi.XMIResource;

/**
 * @author Karel Brezina
 *
 */
public interface AggregatorResource extends XMIResource {
	/**
	 * The {@link #getInfos} feature {@link org.eclipse.emf.common.notify.Notification#getFeatureID ID}.
	 */
	int RESOURCE__INFOS = 1001;

	int RESOURCE__ANALYSIS_STARTED = 1002;

	int RESOURCE__ANALYSIS_FINISHED = 1003;

	/**
	 * Analysis aggregator errors, warnings & infos
	 */
	void analyzeResource();

	/**
	 * Returns the {@link Aggregation} instance contained in this {@link Resource}.
	 *
	 * @return the {@code Aggregator} instance contained in this {@code Resource}.
	 */
	Aggregation getAggregation();

	/**
	 * Returns a list of the infos in the resource; each error will be of type {@link org.eclipse.emf.ecore.resource.Resource.Diagnostic}.
	 *
	 * @return a list of the infos in the resource.
	 * @see #load(Map)
	 */
	EList<Diagnostic> getInfos();
}
