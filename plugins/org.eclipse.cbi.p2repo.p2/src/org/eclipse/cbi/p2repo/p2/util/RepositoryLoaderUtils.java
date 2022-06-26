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

import org.eclipse.cbi.p2repo.p2.loader.IRepositoryLoader;
import org.eclipse.cbi.p2repo.util.ExceptionUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

/**
 * @author Filip Hrbek
 *
 */
public class RepositoryLoaderUtils {
	public static IConfigurationElement getLoaderFor(String nature) throws CoreException {
		for(IConfigurationElement extension : Platform.getExtensionRegistry().getConfigurationElementsFor(
			IRepositoryLoader.EXTENSION_POINT_ID)) {
			if(nature.equals(extension.getAttribute(IRepositoryLoader.EXTENSION_POINT_ATTRIBUTE_NATURE)))
				return extension;
		}

		throw ExceptionUtils.fromMessage("No repository loader for nature %s", nature);
	}
}
