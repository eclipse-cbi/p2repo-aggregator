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

import org.eclipse.equinox.p2.core.IProvisioningAgent;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class BackgroundProvisioningAgent implements IProvisioningAgent {

	private IProvisioningAgent agent;

	private boolean aboutToStop;

	private boolean stopped;

	private int activeTasks;

	public BackgroundProvisioningAgent(IProvisioningAgent agent) {
		this.agent = agent;
	}

	private void conditionalStop() {
		if(aboutToStop && activeTasks == 0 && !stopped) {
			stopped = true;

			agent.stop();
		}
	}

	@Override
	public Object getService(String serviceName) {
		return agent.getService(serviceName);
	}

	@Override
	public void registerService(String serviceName, Object service) {
		agent.registerService(serviceName, service);
	}

	synchronized public void registerTask() {
		if(!aboutToStop)
			activeTasks++;
	}

	@Override
	synchronized public void stop() {
		aboutToStop = true;
		conditionalStop();
	}

	@Override
	public void unregisterService(String serviceName, Object service) {
		agent.unregisterService(serviceName, service);
	}

	synchronized public void unregisterTask() {
		if(!aboutToStop && activeTasks > 0)
			activeTasks--;
		conditionalStop();
	}

	// To be removed when bug#551562 is solved (make getService(Class) default method)
	@SuppressWarnings("unchecked")
	@Override
	public <T> T getService(Class<T> key) {
		return (T) getService(key.getName());
	}
}
