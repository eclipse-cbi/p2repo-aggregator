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

package org.eclipse.cbi.p2repo.p2.loader;

import java.net.URI;

import org.eclipse.cbi.p2repo.p2.impl.MetadataRepositoryImpl;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;

/**
 * @author Filip Hrbek
 *
 */
public interface IRepositoryLoader {
	final String EXTENSION_POINT_ID = "org.eclipse.cbi.p2repo.p2.loader";

	final String EXTENSION_POINT_ATTRIBUTE_NATURE = "nature";

	final String PROP_ORIGINAL_PATH = "original.path";

	final String PROP_ORIGINAL_ID = "original.id";

	void close() throws CoreException;

	IArtifactRepository getArtifactRepository(IMetadataRepository mdr, IProgressMonitor monitor) throws CoreException;

	void load(IProgressMonitor monitor) throws CoreException;

	void open(URI location, IProvisioningAgent agent, MetadataRepositoryImpl mdr) throws CoreException;

	void reload(IProgressMonitor monitor) throws CoreException;
}
