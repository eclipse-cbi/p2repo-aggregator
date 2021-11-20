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

package org.eclipse.cbi.p2repo.p2.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.p2.InstallableUnit;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionedId;

/**
 * @author Filip Hrbek
 *
 */
public class IUUtils {
	private static final Pattern proxyFragmentPattern = Pattern.compile("^.*/@installableUnits\\[id='([^']*)',version='([^']*)'\\]$");

	public static String encodeFilterValue(String value) {
		boolean encoded = false;
		int inlen = value.length();
		int outlen = inlen << 1; /* inlen * 2 */

		char[] output = new char[outlen];
		value.getChars(0, inlen, output, inlen);

		int cursor = 0;
		for(int i = inlen; i < outlen; i++) {
			char c = output[i];

			switch(c) {
				case '(':
				case '*':
				case ')':
				case '\\': {
					output[cursor] = '\\';
					cursor++;
					encoded = true;

					break;
				}
			}

			output[cursor] = c;
			cursor++;
		}

		return encoded
				? new String(output, 0, cursor)
				: value;
	}

	/**
	 * Obtains the name and version information either from the proxy URI fragment or from attributes. So, it works for
	 * both genuine instance or proxy.
	 */
	public static VersionedId getVersionedName(InstallableUnit iu) {
		if(((EObject) iu).eIsProxy())
			return getVersionedNameFromProxy(iu);
		else
			return new VersionedId(iu.getId(), iu.getVersion());
	}

	/**
	 * Obtains the name and version information from the proxy URI fragment
	 */
	public static VersionedId getVersionedNameFromProxy(InstallableUnit iu) {
		return getVersionedNameFromProxy((InternalEObject) iu);
	}

	// needed for dynamic EMF
	public static VersionedId getVersionedNameFromProxy(InternalEObject iu) {
		URI uri = iu.eProxyURI();
		if(uri == null)
			return null;

		String frag = uri.fragment();
		if(frag == null)
			return null;

		Matcher m = proxyFragmentPattern.matcher(frag);
		try {
			return m.matches()
					? new VersionedId(URLDecoder.decode(m.group(1), "UTF-8"), m.group(2))
					: null;
		}
		catch(UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	public static String stringifyVersion(Version version) {
		String result = version.getOriginal();

		if(result == null)
			result = version.toString();

		return result;
	}
}
