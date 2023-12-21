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

import java.io.File;
import java.net.URI;

import org.eclipse.cbi.p2repo.util.P2RepoUtil;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.equinox.internal.p2.metadata.expression.LDAPFilter;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.IProvisioningAgentProvider;
import org.eclipse.equinox.p2.core.spi.IAgentServiceFactory;
import org.eclipse.equinox.p2.engine.IProfileRegistry;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.metadata.expression.ExpressionUtil;
import org.eclipse.equinox.p2.metadata.expression.IExpression;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;
import org.eclipse.equinox.p2.planner.IPlanner;
import org.eclipse.equinox.p2.repository.IRepositoryManager;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class P2Utils {

	public static IProvisioningAgent createDedicatedProvisioningAgent(URI location) throws CoreException {
		IProvisioningAgentProvider agentProvider = null;

		try {
			agentProvider = P2RepoUtil.getPlugin().getService(IProvisioningAgentProvider.class);
			IProvisioningAgent agent = agentProvider.createAgent(location);
			return new BackgroundProvisioningAgent(agent);
		}
		finally {
			P2RepoUtil.getPlugin().ungetService(agentProvider);
		}
	}

	public static String filterToString(IMatchExpression<IInstallableUnit> filter) {
		if(filter == null)
			return null;

		Object[] params = filter.getParameters();
		if(params.length == 1) {
			Object param = params[0];
			if(param instanceof LDAPFilter) {
				IExpression expr = ExpressionUtil.getOperand(filter);
				if(expr.getExpressionType() == IExpression.TYPE_MATCHES) {
					IExpression lhs = ExpressionUtil.getLHS(expr);
					if(lhs.getExpressionType() == IExpression.TYPE_MEMBER &&
							"properties".equals(ExpressionUtil.getName(lhs)) &&
							ExpressionUtil.getRHS(expr).getExpressionType() == IExpression.TYPE_PARAMETER) {
						return "LDAP Filter: " + param.toString();
					}
				}
			}
		}
		return filter.toString();
	}

	public static IProvisioningAgent getDefaultProvisioningAgent() throws CoreException {
		String filter = null;
		File defaultLocation = getDefaultProvisioningAgentLocation();
		URI defaultLocationURI = null;
		if(defaultLocation != null) {
			defaultLocationURI = defaultLocation.toURI();
			filter = "(locationURI=" + defaultLocationURI + ')';
		}
		try {
			return P2RepoUtil.getPlugin().getService(IProvisioningAgent.class, filter);
		}
		catch(CoreException e) {
			// Agent not created yet. This is expected the first time a process
			// makes this call.
		}

		IProvisioningAgentProvider agentProvider = P2RepoUtil.getPlugin().getService(IProvisioningAgentProvider.class);
		try {
			return agentProvider.createAgent(defaultLocationURI);
		}
		finally {
			P2RepoUtil.getPlugin().ungetService(agentProvider);
		}
	}

	public static File getDefaultProvisioningAgentLocation() {
		String userHome = System.getProperty("user.home");
		if(userHome == null)
			return null;
		File home = new File(userHome);
		File cbiP2RepoHome = new File(home, ".cbiP2Repo");
		if(!(cbiP2RepoHome.isDirectory() || cbiP2RepoHome.mkdirs()))
			return null;

		File agentLocation = new File(cbiP2RepoHome, "p2agent");
		if(!(agentLocation.isDirectory() || agentLocation.mkdirs()))
			return null;
		return agentLocation;
	}

	private static <T> T getP2Service(IProvisioningAgent agent, Class<T> clazz) {
		try {
			IProvisioningAgent agentParam = agent;
			if(agent == null)
				agent = getDefaultProvisioningAgent();

			Object service = agent.getService(clazz.getName());
			if(service == null) {
				String filter = "(p2.agent.servicename=" + clazz.getName() + ")";
				IAgentServiceFactory serviceFactory = P2RepoUtil.getPlugin().getService(
					IAgentServiceFactory.class, filter);
				service = serviceFactory.createService(agent);
				P2RepoUtil.getPlugin().ungetService(serviceFactory);
			}
			T result = clazz.cast(service);

			P2RepoUtil.getPlugin().ungetService(agent);

			if(result != null) {
				if(agentParam != null && agentParam instanceof BackgroundProvisioningAgent)
					((BackgroundProvisioningAgent) agentParam).registerTask();
				return result;
			}
		}
		catch(RuntimeException t) {
			throw t;
		}
		catch(Exception t) {
			throw new RuntimeException(t);
		}

		throw new RuntimeException("p2 service " + clazz.getName() + "not available");
	}

	public static IPlanner getPlanner(IProvisioningAgent agent) {
		return getP2Service(agent, IPlanner.class);
	}

	public static IProfileRegistry getProfileRegistry(IProvisioningAgent agent) {
		return getP2Service(agent, IProfileRegistry.class);
	}

	public static <T extends IRepositoryManager<?>> T getRepositoryManager(Class<T> clazz) {
		return getP2Service(null, clazz);
	}

	public static <T extends IRepositoryManager<?>> T getRepositoryManager(IProvisioningAgent agent, Class<T> clazz) {
		return getP2Service(agent, clazz);
	}

	public static void stopProvisioningAgent(final IProvisioningAgent agent) {
		if(agent != null)
			agent.stop();
	}

	public static void ungetPlanner(IProvisioningAgent agent, IPlanner planner) {
		if(agent != null && agent instanceof BackgroundProvisioningAgent)
			((BackgroundProvisioningAgent) agent).unregisterTask();
	}

	public static void ungetProfileRegistry(IProvisioningAgent agent, IProfileRegistry registry) {
		if(agent != null && agent instanceof BackgroundProvisioningAgent)
			((BackgroundProvisioningAgent) agent).unregisterTask();
	}

	public static void ungetRepositoryManager(IProvisioningAgent agent, IRepositoryManager<?> manager) {
		if(agent != null && agent instanceof BackgroundProvisioningAgent)
			((BackgroundProvisioningAgent) agent).unregisterTask();
	}

	public static String versionRangeToString(VersionRange versionRange) {
		if(versionRange == null)
			return null;
		StringBuilder bld = new StringBuilder();
		if(versionRange.getIncludeMinimum() && versionRange.getIncludeMaximum() &&
				versionRange.getMinimum().equals(versionRange.getMaximum())) {
			// Exact version. Don't display both upper and lower bounds
			bld.append('[');
			versionRange.getMinimum().toString(bld);
			bld.append(']');
		}
		else
			versionRange.toString(bld);
		return bld.toString();
	}

}
