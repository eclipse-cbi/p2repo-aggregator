/*******************************************************************************
 * Copyright (c) 2006-2007, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 ******************************************************************************/

package org.eclipse.b3.aggregator.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.b3.aggregator.AggregatorPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;

/**
 * @author Karel Brezina
 * 
 */
public enum CapabilityNamespace{
	IU("_UI_Capability_IU_type"), TYPE("_UI_Capability_Type_type"), LOCALIZATION("_UI_Capability_Localization_type"), FLAVOR(
			"_UI_Capability_Flavor_type"), FEATURE("_UI_Capability_Feature_type"), BUNDLE("_UI_Capability_Bundle_type"), FRAGMENT(
			"_UI_Capability_Fragment_type"), JAVA_PACKAGE("_UI_Capability_JavaPackage_type"), TOOLING(
			"_UI_Capability_Tooling_type"), UNKNOWN("_UI_Capability_Unknown_type");

	private static Map<String, CapabilityNamespace> namespaceMap;

	private static Map<Pattern, CapabilityNamespace> namespaceMatchMap;

	static {
		namespaceMap = new HashMap<String, CapabilityNamespace>();
		namespaceMap.put("org.eclipse.equinox.p2.iu", IU);
		namespaceMap.put("org.eclipse.equinox.p2.eclipse.type", TYPE);
		namespaceMap.put("org.eclipse.equinox.p2.localization", LOCALIZATION);
		namespaceMap.put("org.eclipse.equinox.p2.flavor", FLAVOR);
		namespaceMap.put("org.eclipse.update.feature", FEATURE);
		namespaceMap.put("osgi.bundle", BUNDLE);
		namespaceMap.put("osgi.fragment", FRAGMENT);
		namespaceMap.put("java.package", JAVA_PACKAGE);

		namespaceMatchMap = new HashMap<Pattern, CapabilityNamespace>();
		namespaceMatchMap.put(Pattern.compile("^tooling.*"), TOOLING);
	}

	public static CapabilityNamespace byFilter(IMatchExpression<IInstallableUnit> filter) {
		// TODO Parse the filter and try to resolve the namespace
		return null;
	}

	public static CapabilityNamespace byId(String namespaceId) {
		CapabilityNamespace namespace = namespaceMap.get(namespaceId);

		if(namespace == null)
			for(Pattern pattern : namespaceMatchMap.keySet())
				if(pattern.matcher(namespaceId).matches())
					return namespaceMatchMap.get(pattern);

		if(namespace == null) {
			namespace = UNKNOWN;
			namespace.label = namespaceId + ":";
		}

		return namespace;
	}

	private static ResourceLocator getResourceLocator() {
		return AggregatorPlugin.INSTANCE;
	}

	private String label;

	private CapabilityNamespace(String label) {
		this.label = getResourceLocator().getString(label);
	}

	public String getLabel() {
		return label;
	}

}
