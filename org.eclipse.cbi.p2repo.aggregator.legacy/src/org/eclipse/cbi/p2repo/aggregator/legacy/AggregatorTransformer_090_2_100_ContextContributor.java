package org.eclipse.cbi.p2repo.aggregator.legacy;

import java.util.Map;

import org.eclipse.cbi.p2repo.aggregator.transformer.TransformerContextContributor;

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

/**
 * @author Karel Brezina
 *
 */
public class AggregatorTransformer_090_2_100_ContextContributor extends TransformerContextContributor {

	@Override
	public void contributeDefaultsToContext(Map<String, Object> context) {
		context.put(AggregatorTransformer_090_2_100.CONTEXT_FIXED_VERSION, true);
	}
}
