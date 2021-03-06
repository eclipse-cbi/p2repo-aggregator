/**
 * Copyright (c) 2016, Red Hat Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
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
