/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.b3.aggregator.p2.util;

import org.eclipse.b3.aggregator.loader.IRepositoryLoader;
import org.eclipse.b3.aggregator.util.RepositoryLoaderUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.emf.common.util.URI;

import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.ecore.resource.impl.ResourceFactoryImpl;

public class MetadataRepositoryResourceFactoryImpl extends ResourceFactoryImpl {
	private IConfigurationElement m_loaderConfiguration = null;

	public MetadataRepositoryResourceFactoryImpl() {
		super();
	}

	public Resource createResource(URI uri) {
		if(m_loaderConfiguration == null || !m_loaderConfiguration.isValid())
			try {
				m_loaderConfiguration = RepositoryLoaderUtils.getLoaderFor(uri.scheme());
			}
			catch(CoreException e) {
				throw new RuntimeException(e.getMessage(), e);
			}

		try {
			return new MetadataRepositoryResourceImpl(uri,
					(IRepositoryLoader) m_loaderConfiguration.createExecutableExtension("class"));
		}
		catch(CoreException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
