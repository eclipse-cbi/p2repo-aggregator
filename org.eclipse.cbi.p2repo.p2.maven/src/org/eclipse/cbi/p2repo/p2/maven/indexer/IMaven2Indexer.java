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
package org.eclipse.cbi.p2repo.p2.maven.indexer;

import java.net.URI;
import java.util.Iterator;

import org.eclipse.cbi.p2repo.p2.maven.loader.VersionEntry;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Filip Hrbek (filip.hrbek@cloudsmith.com)
 *
 */
public interface IMaven2Indexer {
	public static final String EXTENSION_POINT_ID = "org.eclipse.cbi.p2repo.p2.maven.indexer";

	public final static String EXTENSION_POINT_ATTRIBUTE_ID = "id";

	/**
	 * Closes all resources associated with an open index. Does nothing if no index is open.
	 *
	 */
	void closeRemoteIndex() throws CoreException;

	/**
	 * Obtain an interator of all artifacts contained in the indexed repository
	 *
	 * @return the iterator
	 */
	Iterator<VersionEntry> getArtifacts() throws CoreException;

	/**
	 * Estimate number of entries. If getting an exact number would slow down performance too much, an estimate or is
	 * ok. If the number of entries is really hard to count or estimate, this method should return 0.
	 *
	 * @return number of version entries (true or estimated) or zero if it is too hard to count or estimate
	 */
	int getNumberOfEntries() throws CoreException;

	/**
	 * Tries to open remote index. If no index is available at the remote location, an exception is thrown.
	 *
	 * @param location
	 *            Remote repository location
	 * @param clearLocalCache
	 *            Whether the local cache should be cleared and whole index be downloaded rather than using index update
	 * @throws IndexNotFoundException
	 */
	void openRemoteIndex(URI location, boolean clearLocalCache) throws IndexNotFoundException, CoreException;

	/**
	 * Creates or updates an index on a local repository.
	 *
	 * @param location
	 *            Writable location of local repository
	 * @param createNew
	 *            if set to true, an existing index will be replaced, otherwise an incremental index update is created
	 */
	void updateLocalIndex(URI location, boolean createNew) throws CoreException;
}
