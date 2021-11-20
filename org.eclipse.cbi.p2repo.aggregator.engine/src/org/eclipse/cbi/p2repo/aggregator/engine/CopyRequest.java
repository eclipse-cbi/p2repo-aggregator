/**
 * Copyright (c) 2021 Eclipse contributors and others.
 * 
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.engine;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.eclipse.cbi.p2repo.aggregator.AggregatorPlugin;
import org.eclipse.cbi.p2repo.util.ExceptionUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.internal.p2.artifact.repository.ArtifactRequest;
import org.eclipse.equinox.internal.p2.repository.Transport;
import org.eclipse.equinox.internal.provisional.p2.artifact.repository.processing.ProcessingStepHandler;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepository;

public class CopyRequest extends ArtifactRequest {
	private final File destination;

	public CopyRequest(IArtifactRepository src, IArtifactKey key, Transport transport, File destination) {
		super(key, transport);
		setSourceRepository(src);
		this.destination = destination;
	}

	@Override
	public void perform(IArtifactRepository sourceRepository, IProgressMonitor monitor) {
		monitor.subTask("Downloading " + getArtifactKey().getId());
		setSourceRepository(sourceRepository);

		// if the request does not have a descriptor then try to fill one in by getting
		// the list of all and randomly picking one that appears to be optimized.
		IArtifactDescriptor optimized = null;
		IArtifactDescriptor canonical = null;
		IArtifactDescriptor descriptor = null;

		IArtifactDescriptor[] descriptors = source.getArtifactDescriptors(getArtifactKey());
		if(descriptors.length > 0) {
			for(int i = 0; i < descriptors.length; i++) {
				if(descriptors[i].getProperty(IArtifactDescriptor.FORMAT) == null)
					canonical = descriptors[i];
				else if(ProcessingStepHandler.canProcess(descriptors[i]))
					optimized = descriptors[i];
			}

			boolean chooseCanonical = source.getLocation().getScheme().equals("file"); //$NON-NLS-1$
			// If the source repo is local then look for a canonical descriptor so we don't waste processing
			// time.
			descriptor = chooseCanonical
					? canonical
					: optimized;

			// if the descriptor is still null then we could not find our first choice of format so switch the
			// logic.
			if(descriptor == null)
				descriptor = !chooseCanonical
						? canonical
						: optimized;
		}

		// if the descriptor is not set now then the repo does not have the requested artifact
		if(descriptor == null) {
			setResult(new Status(IStatus.ERROR, AggregatorPlugin.getPluginID(), "Artifact not found: " +
					getArtifactKey()));
			return;
		}

		IStatus status = transfer(descriptor, monitor);
		if(monitor.isCanceled()) {
			setResult(Status.CANCEL_STATUS);
			return;
		}

		if(status.isOK() || status.getSeverity() == IStatus.CANCEL) {
			setResult(status);
			return;
		}

		if(descriptor == canonical || canonical == null) {
			setResult(status);
			return;
		}

		// try with canonical
		setResult(transfer(canonical, monitor));
	}

	private IStatus transfer(IArtifactDescriptor descriptor, IProgressMonitor monitor) {
		IStatus status;
		do {
			status = transferSingle(descriptor, monitor);
		} while(status.getSeverity() == IStatus.ERROR && status.getCode() == IArtifactRepository.CODE_RETRY);
		return status;
	}

	private IStatus transferSingle(IArtifactDescriptor descriptor, IProgressMonitor monitor) {
		OutputStream destinationStream = null;
		IStatus status = null;
		try {
			destinationStream = new FileOutputStream(destination);
			status = source.getArtifact(descriptor, destinationStream, monitor);
		}
		catch(IOException e) {
			status = ExceptionUtils.createStatus(e);
		}
		finally {
			if(destinationStream != null)
				try {
					destinationStream.close();
				}
				catch(IOException e) {
					// ignore
				}
		}
		return status;
	}
}
