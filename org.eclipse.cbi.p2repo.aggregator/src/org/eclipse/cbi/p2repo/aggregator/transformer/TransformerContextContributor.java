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

package org.eclipse.cbi.p2repo.aggregator.transformer;

import java.util.Map;

/**
 * Capable of adding data to context. It's used for aggregator transformations.
 *
 * @author Karel Brezina
 *
 */
public abstract class TransformerContextContributor {

	public interface IInteractiveHook {
		void contributeToContext(Map<String, Object> context);
	}

	private IInteractiveHook interactiveHook;

	/**
	 * Add data to context
	 *
	 * @param context
	 */
	public abstract void contributeDefaultsToContext(Map<String, Object> context);

	/**
	 * Add data to context, possibly obtained by an interactive user interface
	 *
	 * @param context
	 */
	public final void contributeToContext(Map<String, Object> context) {
		if(interactiveHook != null)
			interactiveHook.contributeToContext(context);
		else
			contributeDefaultsToContext(context);
	}

	/**
	 * @param interactiveHook
	 *            the interactiveHook to set
	 */
	public final void setInteractiveHook(IInteractiveHook interactiveHook) {
		this.interactiveHook = interactiveHook;
	}
}
