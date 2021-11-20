/**
 * Copyright (c) 2021 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.cbi.p2repo.p2.loader.IRepositoryLoader;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.osgi.framework.BundleContext;

/**
 * This is the central singleton for the Aggregator model plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class AggregatorPlugin extends EMFPlugin {
	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 *
	 * @generated NOT
	 */
	public static class Implementation extends EclipsePlugin {
		private List<String> supportedNatures;

		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}

		public List<String> getSupportedRepositoryNatureList() {
			return supportedNatures;
		}

		@Override
		public void start(BundleContext context) throws Exception {
			super.start(context);
			supportedNatures = new ArrayList<>();

			for (IConfigurationElement extension : Platform.getExtensionRegistry()
					.getConfigurationElementsFor(IRepositoryLoader.EXTENSION_POINT_ID))
				supportedNatures.add(extension.getAttribute(IRepositoryLoader.EXTENSION_POINT_ATTRIBUTE_NATURE));

			Collections.sort(supportedNatures);
		}

		@Override
		public void stop(BundleContext context) throws Exception {
			super.stop(context);
			supportedNatures = null;
		}
	}

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final AggregatorPlugin INSTANCE = new AggregatorPlugin();

	public static final String AGGR_URI_SCHEME = "cbiaggr";

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	public static String getPluginID() {
		return plugin.getSymbolicName();
	}

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatorPlugin() {
		super(new ResourceLocator[] {});
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}
}
