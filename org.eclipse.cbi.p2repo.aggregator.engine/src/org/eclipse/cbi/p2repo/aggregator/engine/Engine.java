package org.eclipse.cbi.p2repo.aggregator.engine;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Engine extends Plugin {
	// The plug-in ID
	public static final String PLUGIN_ID = "org.eclipse.cbi.p2repo.aggregator.engine";
	// The plug-in ID of org.eclipse.equinox.p2.metadata.repository
	public static final String PLUGIN_ID_METADATA_REPOSITORY = "org.eclipse.equinox.p2.metadata.repository"; //$NON-NLS-1$

	// The shared instance
	private static Engine plugin;

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Engine getDefault() {
		return plugin;
	}

	/**
	 * The constructor
	 */
	public Engine() {
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
}
