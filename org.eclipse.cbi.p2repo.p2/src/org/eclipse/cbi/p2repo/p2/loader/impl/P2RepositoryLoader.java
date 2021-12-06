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
package org.eclipse.cbi.p2repo.p2.loader.impl;

import java.io.IOException;
import java.net.URI;

import org.eclipse.cbi.p2repo.p2.impl.MetadataRepositoryImpl;
import org.eclipse.cbi.p2repo.p2.loader.IRepositoryLoader;
import org.eclipse.cbi.p2repo.p2.util.P2Bridge;
import org.eclipse.cbi.p2repo.p2.util.P2Utils;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepository;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepositoryManager;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;

public class P2RepositoryLoader implements IRepositoryLoader {
	private IProvisioningAgent agent;

	private URI location;

	private MetadataRepositoryImpl repository;

	private IMetadataRepositoryManager mdrMgr;

	@Override
	public void close() {
		P2Utils.ungetRepositoryManager(agent, mdrMgr);
	}

	@Override
	public IArtifactRepository getArtifactRepository(IMetadataRepository mdr, IProgressMonitor monitor)
			throws CoreException {
		IArtifactRepositoryManager arMgr = null;

		try {
			arMgr = P2Utils.getRepositoryManager(agent, IArtifactRepositoryManager.class);
			return arMgr.loadRepository(mdr.getLocation(), monitor);
		}
		finally {
			P2Utils.ungetRepositoryManager(agent, arMgr);
		}
	}

	@Override
	public void load(IProgressMonitor monitor) throws CoreException {
		load(monitor, false);
	}

	private void load(IProgressMonitor monitor, boolean avoidCache) throws CoreException {
		SubMonitor subMon = SubMonitor.convert(monitor, 100);

		IMetadataRepository repo = null;

		// This is a workaround. If aggregator editor is loading repositories too early
		// (while restoring the workbench before the framework starts up completely),
		// the SAX parser service may not be ready yet. If this is the case, up to 3 attempts
		// are made to obtain the service.
		for(int i = 2; i >= 0; i--) {
			try {
				if(avoidCache) {
					// This is a workaround - we need to clear the NotFound cache to force
					// the MDR manager to fetch the repo again.
					if(mdrMgr.contains(location))
						// if the repo is known to MDR manager, it should be simply refreshed
						repo = mdrMgr.refreshRepository(location, subMon.newChild(80));
					else {
						// if the repo is not known to MDR manager, we call the refresh in order
						// to clear the NotFound cache only and we expect an exception to be thrown
						// due to unknown repository
						try {
							mdrMgr.refreshRepository(location, new NullProgressMonitor());
						}
						catch(ProvisionException e) {
							// this is expected - but the NotFound cache has been cleared
						}
						repo = mdrMgr.loadRepository(location, subMon.newChild(80));
					}
				}
				else
					repo = mdrMgr.loadRepository(location, subMon.newChild(80));

				break;
			}
			catch(OperationCanceledException e) {
				LogUtils.info("Operation canceled."); //$NON-NLS-1$
			}
			catch(ProvisionException e) {
				Throwable t = e.getCause();
				if(i > 0 && t instanceof IOException && t.getMessage() != null &&
						t.getMessage().contains("SAX parser service")) {
					LogUtils.warning(
						"Error loading repository: %s Trying to recover (attempts remaining: %d)", t.getMessage(), i);
					try {
						Thread.sleep(1000 * (3 - i));
					}
					catch(InterruptedException ie) {
						// ignore
					}
					continue;
				}

				throw (e);
			}
		}
		if(!monitor.isCanceled()) {
			P2Bridge.importToModel(mdrMgr, repo, repository, subMon.newChild(20), true);
		}
	}

	@Override
	public void open(URI location, IProvisioningAgent agent, MetadataRepositoryImpl mdr) throws CoreException {
		this.agent = agent;
		this.location = location;
		repository = mdr;
		mdrMgr = P2Utils.getRepositoryManager(agent, IMetadataRepositoryManager.class);
	}

	@Override
	public void reload(IProgressMonitor monitor) throws CoreException {
		load(monitor, true);
	}

}
