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

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * @author Filip Hrbek (filip.hrbek@cloudsmith.com)
 *
 */
public class IndexerUtils {
	public static IMaven2Indexer getIndexer(String name) {
		for(IConfigurationElement extension : Platform.getExtensionRegistry().getConfigurationElementsFor(
			IMaven2Indexer.EXTENSION_POINT_ID)) {
			if(name.equals(extension.getAttribute(IMaven2Indexer.EXTENSION_POINT_ATTRIBUTE_ID)))
				try {
					return (IMaven2Indexer) extension.createExecutableExtension("class");
				}
				catch(CoreException e) {
					// try another one
				}
		}

		return null;
	}
}
