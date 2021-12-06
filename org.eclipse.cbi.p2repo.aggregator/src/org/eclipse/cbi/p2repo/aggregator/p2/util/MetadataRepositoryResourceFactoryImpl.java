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
package org.eclipse.cbi.p2repo.aggregator.p2.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.p2.loader.IRepositoryLoader;
import org.eclipse.cbi.p2repo.p2.util.RepositoryLoaderUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

public class MetadataRepositoryResourceFactoryImpl extends ResourceFactoryImpl {
	private static final Pattern URI_LOADER_PATTERN = Pattern.compile("^([^:]+):.*");

	private Map<String, IConfigurationElement> loaderConfigurations = new HashMap<String, IConfigurationElement>();

	public MetadataRepositoryResourceFactoryImpl() {
		super();
	}

	@Override
	public Resource createResource(URI uri) {
		String nature;
		Matcher matcher = URI_LOADER_PATTERN.matcher(uri.opaquePart());
		if(matcher.matches())
			nature = matcher.group(1);
		else
			throw new RuntimeException("Unexpected URI format: " + uri.toString());

		IConfigurationElement loaderConfiguration = loaderConfigurations.get(nature);
		if(loaderConfiguration == null || !loaderConfiguration.isValid())
			try {
				loaderConfiguration = RepositoryLoaderUtils.getLoaderFor(matcher.group(1));
			}
			catch(CoreException e) {
				throw new RuntimeException(e.getMessage(), e);
			}

		try {
			return new MetadataRepositoryResourceImpl(
				uri, (IRepositoryLoader) loaderConfiguration.createExecutableExtension("class"));
		}
		catch(CoreException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
