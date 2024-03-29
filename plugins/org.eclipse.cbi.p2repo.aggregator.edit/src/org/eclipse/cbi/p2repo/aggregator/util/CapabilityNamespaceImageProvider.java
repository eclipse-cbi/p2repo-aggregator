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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.cbi.p2repo.aggregator.provider.AggregatorEditPlugin;
import org.eclipse.emf.common.util.ResourceLocator;

/**
 * @author Karel Brezina
 *
 */
public class CapabilityNamespaceImageProvider {
	private static Map<CapabilityNamespace, String> namespaceMap;

	static {
		namespaceMap = new HashMap<CapabilityNamespace, String>();
		namespaceMap.put(CapabilityNamespace.FEATURE, "full/obj16/Feature");
		namespaceMap.put(CapabilityNamespace.BUNDLE, "full/obj16/Bundle");
		namespaceMap.put(CapabilityNamespace.FRAGMENT, "full/obj16/Fragment");
		namespaceMap.put(CapabilityNamespace.JAVA_PACKAGE, "full/obj16/JavaPackage");
		namespaceMap.put(CapabilityNamespace.IU, "full/obj16/InstallableUnit");
	}

	public static Object getImage(String namespace) {
		if(namespace == null)
			return null;

		CapabilityNamespace cn = CapabilityNamespace.byId(namespace);
		String imageKey = namespaceMap.get(cn);
		return imageKey == null
				? null
				: getResourceLocator().getImage(imageKey);
	}

	private static ResourceLocator getResourceLocator() {
		return AggregatorEditPlugin.INSTANCE;
	}

}
