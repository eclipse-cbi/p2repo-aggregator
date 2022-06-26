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

package org.eclipse.cbi.p2repo.p2.util;

import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.p2.core.IProvisioningAgent;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class ResourceSetWithAgent extends ResourceSetImpl {
	private IProvisioningAgent agent;

	/**
	 * @return the agent
	 */
	public IProvisioningAgent getProvisioningAgent() {
		return agent;
	}

	/**
	 * @param agent
	 *            the agent to set
	 */
	public void setProvisioningAgent(IProvisioningAgent agent) {
		this.agent = agent;
	}
}
