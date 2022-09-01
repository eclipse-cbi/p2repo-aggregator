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

package org.eclipse.cbi.p2repo.util;

import java.lang.reflect.Method;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class StringUtils {

	private static Function<String, String> STRING_VARIABLE_SUBSTITUTOR;
	static {
		Function<String, String> stringSubstitutor = Function.identity();
		Bundle bundle = Platform.getBundle("org.eclipse.core.variables");
		if (bundle != null) {
			try {
				Class<?> variablesPluginClass = bundle.loadClass("org.eclipse.core.variables.VariablesPlugin");
				Object variablesPlugin = variablesPluginClass.getMethod("getDefault").invoke(null);
				Object stringVariableManager = variablesPluginClass.getMethod("getStringVariableManager")
						.invoke(variablesPlugin);
				Method performStringSubsitutionMethod = stringVariableManager.getClass()
						.getMethod("performStringSubstitution", String.class, boolean.class);
				stringSubstitutor = it -> {
					try {
						return (String) performStringSubsitutionMethod.invoke(stringVariableManager, it, false);
					} catch (Exception ex) {
						return it;
					}
				};
			} catch (Exception e) {
				//$FALL-THROUGH$
			}
		}
		STRING_VARIABLE_SUBSTITUTOR = stringSubstitutor;
	}

	private static final Pattern STRING_EXPANSION_PATTERN = Pattern.compile("\\$\\{([^${}|/]+)\\}");

	public static String performStringSubstitution(String str) {
		StringBuilder result = new StringBuilder();
		Matcher matcher = STRING_EXPANSION_PATTERN.matcher(str);
		while (matcher.find()) {
			String propertyName = matcher.group(1);
			String replacement = System.getProperty(propertyName);
			if (replacement != null) {
				matcher.appendReplacement(result, Matcher.quoteReplacement(replacement));
			} else {
				matcher.appendReplacement(result, Matcher.quoteReplacement(matcher.group()));
			}
		}
		matcher.appendTail(result);
		return STRING_VARIABLE_SUBSTITUTOR.apply(result.toString());
	}

	public static String trimmedOrNull(String str) {
		if (str == null)
			return null;

		str = str.trim();
		if (str.length() == 0)
			return null;

		return str;
	}

	public static String trimRight(String str) {
		if (str == null)
			return null;

		int pos = str.length();
		while (pos > 0 && Character.isWhitespace(str.charAt(pos - 1)))
			pos--;

		return str.substring(0, pos);
	}
}
