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

package org.eclipse.cbi.p2repo.p2.maven.indexer;

import org.codehaus.plexus.ContainerConfiguration;
import org.codehaus.plexus.DefaultContainerConfiguration;
import org.codehaus.plexus.DefaultPlexusContainer;
import org.codehaus.plexus.PlexusContainer;
import org.codehaus.plexus.classworlds.ClassWorld;
import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class Activator extends Plugin {

	private static Activator plugin;

	public static Activator getPlugin() {
		return plugin;
	}

	private PlexusContainer plexus;

	public Activator() {
		plugin = this;
	}

	public PlexusContainer getPlexusContainer() {
		return plexus;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		ContainerConfiguration cc = new DefaultContainerConfiguration().setClassWorld(
			new ClassWorld("cbi.p2repo.aggregator", Activator.class.getClassLoader())).setName("cbi.p2repo.plexus");
		plexus = new DefaultPlexusContainer(cc);
	}

	@Override
	public void stop(BundleContext context) {
		plexus.dispose();
		plexus = null;
	}
}
