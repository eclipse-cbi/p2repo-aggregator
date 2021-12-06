/**
 * Copyright (c) 2006-2013, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.osgi.filter.impl;

import org.eclipse.osgi.util.NLS;

public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.eclipse.cbi.p2repo.osgi.filter.impl.messages"; //$NON-NLS-1$

	public static String FILTER_TRAILING_CHARACTERS;

	public static String FILTER_MISSING_LEFTPAREN;

	public static String FILTER_MISSING_RIGHTPAREN;

	public static String FILTER_INVALID_OPERATOR;

	public static String FILTER_MISSING_ATTR;

	public static String FILTER_INVALID_VALUE;

	public static String FILTER_MISSING_VALUE;

	public static String FILTER_PREMATURE_END;

	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
