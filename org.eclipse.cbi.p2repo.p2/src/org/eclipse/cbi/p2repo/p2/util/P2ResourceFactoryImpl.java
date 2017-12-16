/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */
package org.eclipse.cbi.p2repo.p2.util;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.p2.loader.IRepositoryLoader;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

/**
 * <!-- begin-user-doc --> The <b>Resource Factory</b> associated with the
 * package. <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.p2.util.P2ResourceImpl
 * @generated
 */
public class P2ResourceFactoryImpl extends ResourceFactoryImpl {
	private static final Pattern URI_LOADER_PATTERN = Pattern.compile("^([^:]+):.*");

	private Map<String, IConfigurationElement> loaderConfigurations = new HashMap<>();

	/**
	 * Creates an instance of the resource factory.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public P2ResourceFactoryImpl() {
		super();
	}

	/**
	 * Creates an instance of the resource. <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Resource createResource(URI uri) {
		String nature;
		Matcher matcher = URI_LOADER_PATTERN.matcher(uri.opaquePart());
		if (matcher.matches())
			nature = matcher.group(1);
		else
			throw new RuntimeException("Unexpected URI format: " + uri.toString());

		IConfigurationElement loaderConfiguration = loaderConfigurations.get(nature);
		if (loaderConfiguration == null || !loaderConfiguration.isValid())
			try {
				loaderConfiguration = RepositoryLoaderUtils.getLoaderFor(matcher.group(1));
			} catch (CoreException e) {
				throw new RuntimeException(e.getMessage(), e);
			}

		try {
			return new P2ResourceImpl(uri, (IRepositoryLoader) loaderConfiguration.createExecutableExtension("class"));
		} catch (CoreException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

} // P2ResourceFactoryImpl
