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

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class StringUtils {
	public static String trimmedOrNull(String str) {
		if(str == null)
			return null;

		str = str.trim();
		if(str.length() == 0)
			return null;

		return str;
	}

	public static String trimRight(String str) {
		if(str == null)
			return null;

		int pos = str.length();
		while(pos > 0 && Character.isWhitespace(str.charAt(pos - 1)))
			pos--;

		return str.substring(0, pos);
	}
}
