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
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.cbi.p2repo.aggregator.ValidationSet;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.cbi.p2repo.util.MonitorUtils;
import org.eclipse.cbi.p2repo.util.TimeUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.equinox.internal.p2.core.helpers.FileUtils;
import org.eclipse.equinox.p2.publisher.IPublisherAction;
import org.eclipse.equinox.p2.publisher.Publisher;
import org.eclipse.equinox.p2.publisher.PublisherInfo;
import org.eclipse.equinox.p2.repository.IRunnableWithProgress;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;

public class VerificationIUGenerator extends BuilderPhase {
	private ValidationSet validationSet;

	public VerificationIUGenerator(Builder builder, ValidationSet validationSet) {
		super(builder);
		this.validationSet = validationSet;
	}

	private IPublisherAction[] createActions(IMetadataRepository mdr) {
		return new IPublisherAction[] { new VerificationIUAction(getBuilder(), validationSet) };
	}

	@Override
	public void run(IProgressMonitor monitor) throws CoreException {
		String taskLabel = Builder.getValidationSetLabel(validationSet);

		long start = TimeUtils.getNow();
		MonitorUtils.begin(monitor, "Verifying Features for validationSet: " + taskLabel, 100);
		String info = "Starting generation of verification feature for validationSet: " + taskLabel;
		LogUtils.info(info);
		MonitorUtils.subTask(monitor, info);

		String name = getBuilder().getAggregation().getLabel();
		if(validationSet != null)
			name += " / " + validationSet.getLabel();
		name += " Verification repository";

		File globalLocation = new File(getBuilder().getBuildRoot(), Builder.REPO_FOLDER_INTERIM);
		File location = new File(
			globalLocation,
			Builder.REPO_FOLDER_VERIFICATION + getBuilder().getValidationSetSubdirectory(validationSet));
		FileUtils.deleteAll(location);

		Map<String, String> properties = new HashMap<String, String>();
		URI locationURI = Builder.createURI(location);

		IMetadataRepositoryManager mdrMgr = getBuilder().getMdrManager();

		try {
			mdrMgr.removeRepository(locationURI);

			// TODO Use this to activate the "version enumeration" policy workaround
			// IMetadataRepository mdr = mdrMgr.createRepository(locationURI, name, Builder.INTERNAL_METADATA_TYPE,
			// properties);
			final IMetadataRepository mdr = mdrMgr.createRepository(
				locationURI, name, Builder.SIMPLE_METADATA_TYPE, properties);
			final IStatus[] publishResult = new IStatus[] { Status.OK_STATUS };
			mdr.executeBatch(new IRunnableWithProgress() {
				@Override
				public void run(IProgressMonitor monitor) throws InvocationTargetException, OperationCanceledException {
					PublisherInfo pubInfo = new PublisherInfo();
					pubInfo.setMetadataRepository(mdr);
					Publisher publisher = new Publisher(pubInfo);
					publishResult[0] = publisher.publish(createActions(mdr), MonitorUtils.subMonitor(monitor, 90));
				}
			}, MonitorUtils.subMonitor(monitor, 90));
			if(publishResult[0].getSeverity() == IStatus.ERROR)
				throw new CoreException(publishResult[0]);

			getBuilder().getSourceComposite(validationSet).addChild(mdr.getLocation());
		}
		catch(OperationCanceledException e) {
			LogUtils.info("Operation canceled."); //$NON-NLS-1$
		}
		finally {
			MonitorUtils.done(monitor);
		}
		if(!monitor.isCanceled()) {
			LogUtils.info("Done. Took %s", TimeUtils.getFormattedDuration(start)); //$NON-NLS-1$
		}
	}
}
