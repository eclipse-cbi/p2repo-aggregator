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

import static java.lang.String.format;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPlugin;
import org.eclipse.cbi.p2repo.aggregator.ChildrenProvider;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MappedUnit;
import org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference;
import org.eclipse.cbi.p2repo.aggregator.Status;
import org.eclipse.cbi.p2repo.aggregator.StatusCode;
import org.eclipse.cbi.p2repo.aggregator.StatusProvider;
import org.eclipse.cbi.p2repo.aggregator.ValidationSet;
import org.eclipse.cbi.p2repo.aggregator.p2view.Categories;
import org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation;
import org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewFactory;
import org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryBrowser;
import org.eclipse.cbi.p2repo.aggregator.p2view.util.MetadataRepositoryStructuredViewBuilder;
import org.eclipse.cbi.p2repo.aggregator.util.ResourceDiagnosticImpl;
import org.eclipse.cbi.p2repo.aggregator.util.ResourceUtils;
import org.eclipse.cbi.p2repo.aggregator.util.TwoColumnMatrix;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.cbi.p2repo.p2.P2Factory;
import org.eclipse.cbi.p2repo.p2.impl.MetadataRepositoryImpl;
import org.eclipse.cbi.p2repo.p2.loader.IRepositoryLoader;
import org.eclipse.cbi.p2repo.p2.util.P2Utils;
import org.eclipse.cbi.p2repo.p2.util.ResourceSetWithAgent;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.cbi.p2repo.util.MonitorUtils;
import org.eclipse.cbi.p2repo.util.StringUtils;
import org.eclipse.cbi.p2repo.util.TimeUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.VersionRange;

public class MetadataRepositoryResourceImpl extends ResourceImpl implements StatusProvider {
	class AsynchronousLoader extends Job {
		private final Job replaceJob;

		private final boolean force;

		public AsynchronousLoader(String name, Job replaceJob, boolean force) {
			super(name);
			this.replaceJob = replaceJob;
			this.force = force;
		}

		public boolean isForce() {
			return force;
		}

		@Override
		protected IStatus run(final IProgressMonitor monitor) {
			class MonitorWatchDog extends Thread {
				private boolean done;

				@Override
				public void run() {
					while(!done) {
						if(monitor.isCanceled()) {
							cancelLoadingJob();
							break;
						}

						try {
							Thread.sleep(100);
						}
						catch(InterruptedException e) {
							// ignore
						}
					}
				}

				public void setDone() {
					done = true;
				}
			}

			MonitorWatchDog watchDog = new MonitorWatchDog();

			try {
				if(replaceJob != null) {
					replaceJob.cancel();
					replaceJob.join();
				}

				watchDog.start();

				MetadataRepository mdr = loadRepository(force);

				IStatus status = org.eclipse.core.runtime.Status.OK_STATUS;

				if(monitor.isCanceled()) {
					// cancelled by user
					status = org.eclipse.core.runtime.Status.CANCEL_STATUS;
					mdr = null;
				}

				synchronized(MetadataRepositoryResourceImpl.this) {
					String myLocation = getURI().opaquePart();
					Aggregation aggregation = getAggregation();

					// check if the aggregator is still available - if not, it means that the resource has already been excluded
					if(aggregation == null)
						return status;

					if(myLocation.endsWith("/"))
						myLocation = myLocation.substring(0, myLocation.length() - 1);
					for(MetadataRepositoryReference repoRef : aggregation.getAllMetadataRepositoryReferences(true)) {
						synchronized(repoRef) {
							String refLocation = repoRef.getNature() + ":" + repoRef.getResolvedLocation();
							if(refLocation.endsWith("/"))
								refLocation = refLocation.substring(0, refLocation.length() - 1);
							if(myLocation.equals(refLocation)) {
								repoRef.setMetadataRepository(mdr);
								repoRef.onRepositoryLoad();
							}
						}
					}
				}
				return status;
			}
			catch(InterruptedException e) {
				throw new RuntimeException("Repository load was interrupted");
			}
			finally {
				monitor.done();
				watchDog.setDone();

				synchronized(MetadataRepositoryResourceImpl.this) {
					if(asynchronousLoader == this)
						asynchronousLoader = null;
				}
			}
		}
	}

	class RepositoryLoaderJob extends Job {
		private final MetadataRepositoryImpl repository;

		private final java.net.URI location;

		private IProvisioningAgent agent;

		private boolean forceReload;

		private final MetadataRepositoryStructuredView repoView;

		private Exception exception;

		private TwoColumnMatrix<IUPresentation, Object[]> allIUMatrix;

		public RepositoryLoaderJob(IProvisioningAgent agent, MetadataRepositoryImpl repository, java.net.URI location,
				boolean forceReload, MetadataRepositoryStructuredView repoView,
				TwoColumnMatrix<IUPresentation, Object[]> allIUMap) {
			super("Repository Loader");
			this.agent = agent;
			this.repository = repository;
			this.location = location;
			this.forceReload = forceReload;
			this.repoView = repoView;
			this.allIUMatrix = allIUMap;
			setUser(false);
			setSystem(false);
			setPriority(Job.SHORT);
		}

		public Exception getException() {
			return exception;
		}

		@Override
		protected IStatus run(IProgressMonitor monitor) {
			exception = null;
			String msg = format("Loading repository %s", location);
			SubMonitor subMon = SubMonitor.convert(monitor, msg, 100);
			try {
				loader.open(location, agent, repository);
				LogUtils.debug(msg);
				long start = TimeUtils.getNow();

				// avoid resetting the task name when the loader converts the monitor to a SubMonitor
				// by suppressing the beginTask operation
				SubMonitor loaderMonitor = subMon.newChild(100, SubMonitor.SUPPRESS_BEGINTASK);

				if(!forceReload)
					loader.load(loaderMonitor);
				else
					loader.reload(loaderMonitor);

				updateAvailableVersions();

				MetadataRepositoryStructuredViewBuilder.build(MetadataRepositoryResourceImpl.this, repoView, repository,
						allIUMatrix);

				LogUtils.debug("Repository %s loaded (Took %s)", location, TimeUtils.getFormattedDuration(start));
			}

			catch(Exception e) {
				exception = e;
				LogUtils.error(e, "Unable to load repository %s", location);
			}
			finally {
				try {
					loader.close();
				}
				catch(CoreException e) {
					exception = e;
					LogUtils.error(e, "Unable to close repository loader for %s", location);
				}

				MonitorUtils.done(subMon);
			}
			return org.eclipse.core.runtime.Status.OK_STATUS;
		}

		/**
		 *
		 */
		private void updateAvailableVersions() {
			Aggregation aggregation = ResourceUtils.getAggregation(getResourceSet());
			if(aggregation != null)
				for(ValidationSet vs : aggregation.getValidationSets())
					for(Contribution contribution : vs.getContributions())
						for(MappedRepository mappedRepo : contribution.getRepositories())
							// mappedRepo can be null is cancelled while loading
							if(mappedRepo != null) {
								if(repository.getLocation().toString().equals(mappedRepo.getLocation()))
									for(MappedUnit unit : mappedRepo.getUnits(false))
										unit.resolveAvailableVersions(true);
							}
		}
	}

	@SuppressWarnings("serial")
	class UnknownStatusException extends Exception {
		UnknownStatusException(String message) {
			super(message);
		}
	}

	private static final String NOTIFICATION_KEY = "notification";

	public static void cancelLoadRepository(String nature, String repositoryLocation, Aggregation aggregator) {
		Resource mdr = getResourceForNatureAndLocation(nature, repositoryLocation, aggregator);

		if(mdr instanceof MetadataRepositoryResourceImpl)
			((MetadataRepositoryResourceImpl) mdr).cancelLoadingJob();
	}

	public static Resource getResourceForNatureAndLocation(String nature, String repositoryLocation,
			Aggregation aggregator) {
		return getResourceForNatureAndLocation(nature, repositoryLocation, aggregator, true);
	}

	public static Resource getResourceForNatureAndLocation(String nature, String repositoryLocation,
			Aggregation aggregator, boolean create) {
		if(nature == null || repositoryLocation == null)
			return null;

		ResourceSet topSet = ((EObject) aggregator).eResource().getResourceSet();

		URI repoURI = getResourceUriForNatureAndLocation(nature, repositoryLocation);
		Resource mdr = null;

		synchronized(topSet) {
			mdr = topSet.getResource(repoURI, false);
			if(mdr == null && create)
				mdr = topSet.createResource(repoURI);
		}

		if(mdr != null && !(mdr instanceof MetadataRepositoryResourceImpl)) {
			topSet.getResources().remove(mdr);
			mdr = null;
		}

		return mdr;
	}

	public static URI getResourceUriForNatureAndLocation(String nature, String location) {
		int last = location.length() - 1;
		if(last >= 0) {
			char c = location.charAt(last);
			if(c == '/' || c == '\\')
				location = location.substring(0, last);
		}
		return URI.createGenericURI(AggregatorPlugin.AGGR_URI_SCHEME, nature + ":" + location, null);
	}

	private static Throwable unwrap(Exception loadException) {
		Throwable rootCauseCandidate = loadException;

		while(rootCauseCandidate.getCause() != null)
			rootCauseCandidate = rootCauseCandidate.getCause();

		return rootCauseCandidate;
	}

	private AsynchronousLoader asynchronousLoader;

	private IRepositoryLoader loader;

	private MetadataRepositoryStructuredView repoView;

	private final TwoColumnMatrix<IUPresentation, Object[]> allIUPresentationMatrix = new TwoColumnMatrix<IUPresentation, Object[]>();

	private Exception lastException = null;

	private boolean forceReload = false;

	private RepositoryLoaderJob loadingJob;

	private org.eclipse.emf.common.util.Diagnostic diagnostic;

	private Status status = AggregatorFactory.eINSTANCE.createStatus(StatusCode.OK);

	public MetadataRepositoryResourceImpl(URI uri, IRepositoryLoader loader) {
		super(uri);
		this.loader = loader;
	}

	public synchronized void cancelLoadingJob() {
		if(loadingJob != null)
			loadingJob.cancel();
	}

	@Override
	protected void doUnload() {
		super.doUnload();
		forceReload = true;
	}

	private List<Object> findIU(List<Object> nodePath, Pattern iuIdPattern, VersionRange iuVersionRange,
			boolean forward) {
		List<Object> foundInSubTreePath = null;

		if(forward)
			foundInSubTreePath = findIUInSubTree(nodePath, iuIdPattern, iuVersionRange);
		else
			foundInSubTreePath = findIUInNode(nodePath, iuIdPattern, iuVersionRange);

		if(foundInSubTreePath != null)
			return foundInSubTreePath;

		List<Object> nextNodePath = getNextNode(nodePath, forward);

		if(nextNodePath != null)
			return findIU(nextNodePath, iuIdPattern, iuVersionRange, forward);

		return null;
	}

	private List<Object> findIUInNode(List<Object> nodePath, Pattern iuIdPattern, VersionRange iuVersionRange) {
		Object node = nodePath.get(nodePath.size() - 1);

		if(node instanceof IUPresentation) {
			IUPresentation iup = (IUPresentation) node;
			IInstallableUnit iu = iup.getInstallableUnit();
			if(iuIdPattern.matcher(iu.getId()).find() && iuVersionRange.isIncluded(iu.getVersion()))
				return nodePath;
		}

		return null;
	}

	private List<Object> findIUInSubTree(List<Object> nodePath, Pattern iuIdPattern, VersionRange iuVersionRange) {
		List<Object> foundIUPath = findIUInNode(nodePath, iuIdPattern, iuVersionRange);
		if(foundIUPath != null)
			return foundIUPath;

		Object node = nodePath.get(nodePath.size() - 1);

		if(node instanceof ChildrenProvider<?>) {
			for(Object child : ((ChildrenProvider<?>) node).getChildren()) {
				List<Object> childPath = new ArrayList<Object>(nodePath);
				childPath.add(child);

				foundIUPath = findIUInSubTree(childPath, iuIdPattern, iuVersionRange);

				if(foundIUPath != null)
					return foundIUPath;
			}
		}

		return null;
	}

	public Object[] findIUPresentation(Pattern iuIdPattern, VersionRange iuVersionRange, Object[] startAfterPath,
			boolean forward) {
		List<Object> firstNodePath = null;

		if(startAfterPath != null && startAfterPath.length > 0 && startAfterPath[0] instanceof RepositoryBrowser)
			firstNodePath = getFirstNode(startAfterPath, forward);
		else
			firstNodePath = getFirstNode(null, forward);

		if(firstNodePath == null)
			return null;

		List<Object> foundIUPath = findIU(firstNodePath, iuIdPattern, iuVersionRange, forward);

		return foundIUPath == null
				? null
				: foundIUPath.toArray();
	}

	// each IU is located in the structured view twice 1) under Categories node, 2) under Features (Bundles, ..) node
	// skipCategoriesSubTree filters out the Categories subtree
	public TwoColumnMatrix<IUPresentation, Object[]> findIUPresentationsWhichSatisfies(IRequirement rc,
			boolean skipCategoriesSubTree) {
		TwoColumnMatrix<IUPresentation, Object[]> found = new TwoColumnMatrix<IUPresentation, Object[]>();

		for(int i = 0; i < allIUPresentationMatrix.size(); i++) {
			IUPresentation iup = allIUPresentationMatrix.getKey(i);
			if(iup == null)
				continue;

			IInstallableUnit iu = iup.getInstallableUnit();

			if(iu.satisfies(rc)) {
				Object[] path = allIUPresentationMatrix.getValue(i);
				if(!(skipCategoriesSubTree && path[path.length - 2] instanceof Categories))
					found.add(iup, allIUPresentationMatrix.getValue(i));
			}
		}

		return found;
	}

	private void finishLoading(Map<?, ?> options) {
		Notification notification = null;
		synchronized(this) {
			isLoading = false;
			loadingJob = null;
			notification = setLoaded(true);
		}

		if(notification != null) {
			if(options.containsKey(NOTIFICATION_KEY)) {
				Notification notificationRef[] = (Notification[]) options.get(NOTIFICATION_KEY);
				notificationRef[0] = notification;
			}
			else
				eNotify(notification);
		}
		setModified(false);
	}

	private Aggregation getAggregation() {
		ResourceSet rs = getResourceSet();
		if(rs != null) {
			List<Resource> resources = rs.getResources();
			if(resources != null && resources.size() > 0) {
				Resource aggrResource = resources.get(0);
				if(aggrResource != null)
					return (Aggregation) aggrResource.getContents().get(0);
			}
		}

		return null;
	}

	public org.eclipse.emf.common.util.Diagnostic getDiagnostic() {
		return diagnostic;
	}

	private List<Object> getFirstNode(Object[] startAfterPath, boolean forward) {
		List<Object> firstNodePath = new ArrayList<Object>();

		if(startAfterPath == null) {
			firstNodePath.add(repoView);

			if(!forward)
				firstNodePath = getLastChild(firstNodePath);
		}
		else
			firstNodePath = getNextNode(Arrays.asList(startAfterPath), forward);

		return firstNodePath;
	}

	private List<Object> getLastChild(List<Object> nodePath) {
		if(!(nodePath.get(nodePath.size() - 1) instanceof ChildrenProvider<?>))
			return nodePath;

		EList<?> children = ((ChildrenProvider<?>) nodePath.get(nodePath.size() - 1)).getChildren();

		if(children == null || children.size() == 0)
			return nodePath;

		Object lastChild = children.get(children.size() - 1);

		List<Object> childPath = new ArrayList<Object>(nodePath);
		childPath.add(lastChild);

		return getLastChild(childPath);
	}

	public Exception getLastException() {
		return lastException;
	}

	private java.net.URI getLocationFromURI(URI uri) throws URISyntaxException {
		String opaquePart = uri.opaquePart();
		int pos = opaquePart.indexOf(':');
		return new java.net.URI(opaquePart.substring(pos + 1));
	}

	private MappedRepository getMappedRepository() {
		Aggregation aggregation = ResourceUtils.getAggregation(getResourceSet());
		if(aggregation == null)
			return null;

		String uriString = getURI().toString();
		if(!uriString.startsWith("cbiaggr:p2:"))
			return null;

		uriString = uriString.substring(10);
		for(ValidationSet vs : aggregation.getValidationSets())
			for(Contribution contribution : vs.getContributions())
				for(MappedRepository mappedRepo : contribution.getRepositories())
					if(uriString.equals(mappedRepo.getLocation()))
						return mappedRepo;
		return null;
	}

	public MetadataRepository getMetadataRepository() {
		if(repoView != null)
			return repoView.getMetadataRepository();

		return null;
	}

	private List<Object> getNextNode(List<Object> nodePath, boolean forward) {
		int pathSize = nodePath.size();
		if(pathSize == 0)
			return null;

		int parentIdx = pathSize - 2;
		if(parentIdx < 0)
			parentIdx = 0;

		Object parent = nodePath.get(parentIdx);

		if(forward) {
			if(parent instanceof ChildrenProvider<?>) {
				EList<?> children = ((ChildrenProvider<?>) parent).getChildren();
				int nodeIndex = children.indexOf(nodePath.get(nodePath.size() - 1));
				if(nodeIndex < (children.size() - 1)) {
					List<Object> nextNodePath = new ArrayList<Object>(nodePath);
					nextNodePath.remove(nodePath.size() - 1);
					nextNodePath.add(children.get(nodeIndex + 1));

					return nextNodePath;
				}
			}

			List<Object> parentPath = new ArrayList<Object>(nodePath);
			parentPath.remove(nodePath.size() - 1);

			return parentPath.size() > 1
					? getNextNode(parentPath, forward)
					: null;
		}

		if(parent instanceof ChildrenProvider<?>) {
			EList<?> children = ((ChildrenProvider<?>) parent).getChildren();
			int nodeIndex = children.indexOf(nodePath.get(nodePath.size() - 1));
			if(nodeIndex > 0) {
				List<Object> nextNodePath = new ArrayList<Object>(nodePath);
				nextNodePath.remove(nodePath.size() - 1);
				nextNodePath.add(children.get(nodeIndex - 1));

				return getLastChild(nextNodePath);
			}
		}

		List<Object> parentPath = new ArrayList<Object>(nodePath);
		parentPath.remove(nodePath.size() - 1);

		return parentPath.size() > 2
				? parentPath
				: null;
	}

	public Status getStatus() {
		return status;
	}

	@Override
	public void load(Map<?, ?> options) throws IOException {
		lastException = null;

		boolean jobManagerReadyBeforeJobScheduled = !Job.getJobManager().isSuspended();

		synchronized(this) {
			if(isLoading) {
				if(loadingJob != null) {
					try {
						loadingJob.join();
					}
					catch(InterruptedException e) {
						finishLoading(options);
						throw new IOException("Repository loading was interrupted");
					}
				}
				else {
					finishLoading(options);
					throw new IOException("The resource is loading but no loader job was found");
				}

				return;
			}

			isLoading = true;

			java.net.URI location;
			try {
				location = getLocationFromURI(getURI());
			}
			catch(URISyntaxException e) {
				lastException = new Resource.IOWrappedException(e);
				finishLoading(options);
				return;
			}

			MetadataRepositoryImpl repository = (MetadataRepositoryImpl) P2Factory.eINSTANCE.createMetadataRepository();

			repoView = P2viewFactory.eINSTANCE.createMetadataRepositoryStructuredView(repository);
			getContents().add((EObject) repoView);
			allIUPresentationMatrix.clear();

			ResourceSet resourceSet = getResourceSet();
			IProvisioningAgent agent = null;

			if(resourceSet instanceof ResourceSetWithAgent)
				agent = ((ResourceSetWithAgent) resourceSet).getProvisioningAgent();
			else
				try {
					agent = P2Utils.getDefaultProvisioningAgent();
				}
				catch(CoreException e) {
					throw new RuntimeException("Unable to obtain agent", e);
				}

			loadingJob = new RepositoryLoaderJob(
				agent, repository, location, forceReload, repoView, allIUPresentationMatrix);
			loadingJob.schedule();
		}

		try {
			loadingJob.join();

			Exception e = loadingJob.getException();
			if(e != null) {
				lastException = new Resource.IOWrappedException(e);
				return;
			}

			if(!jobManagerReadyBeforeJobScheduled)
				lastException = new UnknownStatusException(
					"Unknown repository status - loading job was scheduled while job manager was suspended");
		}
		catch(InterruptedException e) {
			loadingJob.cancel();
			throw new IOException("Repository loading was interrupted");
		}
		finally {
			finishLoading(options);
		}
	}

	public MetadataRepository loadRepository(boolean force) {
		Exception loadException = null;
		Map<String, Notification[]> notificationCollector = Collections.singletonMap(
			NOTIFICATION_KEY, new Notification[] { null });

		try {
			if(warnings != null)
				warnings.clear();

			if(errors != null)
				errors.clear();

			setStatus(AggregatorFactory.eINSTANCE.createStatus(StatusCode.WAITING));

			if(force) {
				unload();
				load(notificationCollector);
			}
			else if(!isLoaded())
				load(notificationCollector);

			if(getLastException() != null)
				throw getLastException();

			if(!repoView.isLoaded() || repoView.getMetadataRepository().getLocation() == null)
				throw new Exception(String.format("Unable to load repository %s", getURI().toString()));

			return ((MetadataRepositoryStructuredView) contents.get(0)).getMetadataRepository();
		}
		catch(Exception e) {
			loadException = e;
			return null;
		}
		finally {
			if(loadException != null) {
				MappedRepository mr = getMappedRepository();
				URI uri;
				if(mr != null)
					uri = EcoreUtil.getURI((EObject) mr);
				else
					uri = getURI();

				getErrors().add(new ResourceDiagnosticImpl(loadException.getMessage(), uri.toString()));
				String message = StringUtils.trimmedOrNull(loadException.getMessage());
				if(message == null && unwrap(loadException) instanceof OperationCanceledException)
					message = "Repository loading was cancelled";
				setStatus(AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN, message));
			}
			else {
				setStatus(AggregatorFactory.eINSTANCE.createStatus(StatusCode.OK));
			}

			Notification notificationRef[] = notificationCollector.get(NOTIFICATION_KEY);
			Notification notification = notificationRef[0];
			if(notification != null && eNotificationRequired())
				eNotify(notification);
		}
	}

	@Override
	public void save(Map<?, ?> options) throws IOException {
		// Let this be a no-op.
	}

	private void setStatus(Status status) {
		this.status = status;
	}

	synchronized public void startAsynchronousLoad(boolean forceReload) {
		setStatus(AggregatorFactory.eINSTANCE.createStatus(StatusCode.WAITING));

		boolean wasLoaded = false;
		// force listeners to update status
		eNotify(setLoaded(isLoaded));
		wasLoaded = isLoaded() && !isLoading();

		String myLocation = getURI().opaquePart();
		MetadataRepository myMDR;
		boolean mdrFinal = false;
		if(!forceReload && wasLoaded) {
			myMDR = loadRepository(false);
			mdrFinal = true;
		}
		else
			myMDR = null;

		Aggregation aggregation = getAggregation();
		if(aggregation == null)
			// the resource was removed before it was loaded
			return;

		for(MetadataRepositoryReference mdr : aggregation.getAllMetadataRepositoryReferences(true)) {
			String refLocation = mdr.getNature() + ":" + mdr.getResolvedLocation();
			if(myLocation.equals(refLocation)) {
				mdr.setMetadataRepository(myMDR);
				if(mdrFinal)
					mdr.onRepositoryLoad();
			}
		}

		ResourceUtils.cleanUpResources(aggregation, false);

		if(mdrFinal)
			return;

		AsynchronousLoader lastLoader = asynchronousLoader;

		if(lastLoader == null || forceReload && !lastLoader.isForce()) {
			asynchronousLoader = new AsynchronousLoader("Loading " + myLocation, lastLoader, forceReload);
			asynchronousLoader.setUser(false);
			asynchronousLoader.schedule();
		}
	}
}
