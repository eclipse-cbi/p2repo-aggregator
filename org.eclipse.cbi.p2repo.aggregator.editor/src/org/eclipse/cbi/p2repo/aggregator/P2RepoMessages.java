/**
 * Copyright (c) 2016, Red Hat Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.cbi.p2repo.aggregator;

import org.eclipse.osgi.util.NLS;

/**
 * Messages used by cbi p2Repo aggregator
 */
public class P2RepoMessages extends NLS {

	public static String VersionRangeDialog_NoVersionFound;

	public static String VersionRangeDialog_AvailableVersions;

	public static String FixVersionDialog_Title;

	public static String FixVersionDialog_UpdateMessage;

	static {
		NLS.initializeMessages(P2RepoMessages.class.getPackage().getName() + ".messages", P2RepoMessages.class); // #NON-NLS-1$
	}
}
