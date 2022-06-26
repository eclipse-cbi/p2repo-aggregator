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
package org.eclipse.cbi.p2repo.aggregator.presentation;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.ValidationSet;
import org.eclipse.cbi.p2repo.aggregator.engine.Builder;
import org.eclipse.cbi.p2repo.aggregator.engine.Engine;
import org.eclipse.cbi.p2repo.aggregator.engine.ValidationSetVerifier.AnalyzedPlannerStatus;
import org.eclipse.cbi.p2repo.aggregator.impl.AggregationImpl;
import org.eclipse.cbi.p2repo.aggregator.impl.ContributionImpl;
import org.eclipse.cbi.p2repo.aggregator.util.AggregatorResourceImpl;
import org.eclipse.cbi.p2repo.aggregator.util.ResourceUtils;
import org.eclipse.cbi.p2repo.aggregator.util.VerificationDiagnostic;
import org.eclipse.cbi.p2repo.aggregator.util.VerificationDiagnostic.Singleton;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IMarkerResolution;
import org.eclipse.ui.IMarkerResolutionGenerator2;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;
import org.eclipse.ui.part.FileEditorInput;
import org.xml.sax.SAXException;

public class DiagnosticMarkerResolutionGenerator implements IMarkerResolutionGenerator2 {

	static abstract class AggregatorMarkerResolution implements IMarkerResolution {
		protected final Contribution contribution;

		AggregatorMarkerResolution(Contribution contribution) {
			this.contribution = contribution;
		}

		abstract ValidationSet getReceiver(Contribution contribution, ResourceSet resourceSet);

		@Override
		public void run(IMarker marker) {
			String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
			URI uri = URI.createURI(uriAttribute);
			if(uri.fragment() == null)
				return;

			AggregatorEditor editor = getAggregatorEditor(marker);
			if(editor == null)
				return;
			ResourceSet resourceSet = editor.getEditingDomain().getResourceSet();
			ValidationSet child = getReceiver(contribution, resourceSet);
			child.getContributions().add(contribution);
			editor.doSave(new NullProgressMonitor());
			verifyAggregation(ResourceUtils.getAggregation(resourceSet));
		}
	}

	static class MoveBothToNew extends MoveToNew {
		private final Contribution other;

		MoveBothToNew(Contribution contribution, Contribution other) {
			super(contribution);
			this.other = other;
		}

		@Override
		public String getLabel() {
			return String.format(
				"Move conflicting contributions %s and %s into two new separate validation sets",
				contribution.getLabel(), other.getLabel());
		}

		@Override
		public void run(IMarker marker) {
			String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
			URI uri = URI.createURI(uriAttribute);
			if(uri.fragment() == null)
				return;
			AggregatorEditor editor = getAggregatorEditor(marker);
			if(editor == null)
				return;

			ResourceSet resourceSet = editor.getEditingDomain().getResourceSet();

			ValidationSet vs = getReceiver(contribution, resourceSet);
			vs.getContributions().add(contribution);
			vs = getReceiver(other, resourceSet);
			vs.getContributions().add(other);
			editor.doSave(new NullProgressMonitor());
			verifyAggregation(ResourceUtils.getAggregation(resourceSet));
		}
	}

	static class MoveToExisting extends AggregatorMarkerResolution {
		private final ValidationSet receiver;

		MoveToExisting(Contribution contribution, ValidationSet receiver) {
			super(contribution);
			this.receiver = receiver;
		}

		@Override
		public String getLabel() {
			return String.format(
				"Move contribution %s into a validation set '%s'", contribution.getLabel(), receiver.getLabel());
		}

		@Override
		ValidationSet getReceiver(Contribution contribution, ResourceSet resourceSet) {
			return receiver;
		}
	}

	static class MoveToNew extends AggregatorMarkerResolution {
		MoveToNew(Contribution contribution) {
			super(contribution);
		}

		@Override
		public String getLabel() {
			return String.format("Move contribution %s into a new validation set", contribution.getLabel());
		}

		@Override
		ValidationSet getReceiver(Contribution contrib, ResourceSet resourceSet) {
			((ContributionImpl) contrib).setStatus(null);
			Aggregation aggregation = ResourceUtils.getAggregation(resourceSet);
			ValidationSet current = (ValidationSet) ((EObject) contrib).eContainer();
			ValidationSet newVs = AggregatorFactory.eINSTANCE.createValidationSet();
			newVs.getExtends().add(current);
			newVs.setLabel(contrib.getLabel());
			aggregation.getValidationSets().add(newVs);
			return newVs;
		}
	}

	private static final IMarkerResolution[] noResolutions = new IMarkerResolution[0];

	static void clearVerificationMarkers(Aggregation aggregation) {
		((AggregationImpl) aggregation).clearStatus();
	};

	static AggregatorEditor getAggregatorEditor(IMarker marker) {
		try {
			IFile file = (IFile) marker.getResource();
			AggregatorEditor editor = null;
			IWorkbenchPage firstPage = null;
			for (IWorkbenchWindow wbw : PlatformUI.getWorkbench().getWorkbenchWindows()) {
				for(IWorkbenchPage wbp : wbw.getPages()) {
					if(firstPage == null)
						firstPage = wbp;
					for(IEditorReference eref : wbp.getEditorReferences()) {
						IEditorPart ep = eref.getEditor(false);
						if(ep instanceof AggregatorEditor) {
							IEditorInput epInput = ep.getEditorInput();
							if(epInput instanceof FileEditorInput) {
								if(((FileEditorInput) epInput).getFile().equals(file)) {
									editor = (AggregatorEditor) ep;
									break;
								}
							}
						}
					}
				}
			}

			if(editor == null && firstPage != null) {
				IEditorPart ep = IDE.openEditor(firstPage, file);
				if(ep instanceof AggregatorEditor)
					editor = (AggregatorEditor) ep;
			}
			return editor;
		}
		catch(CoreException e) {
			return null;
		}
	}

	static Contribution getContribution(URI uri, ResourceSet resourceSet) {
		Contribution contrib = null;
		if(uri.fragment() != null)
			contrib = (Contribution) resourceSet.getEObject(uri, true);
		return contrib;
	}

	static List<Contribution> getContributions(IMarker marker, ResourceSet resourceSet) {
		String uriAttribute = marker.getAttribute(EValidator.URI_ATTRIBUTE, null);
		if(uriAttribute == null)
			return Collections.emptyList();

		Contribution contrib = getContribution(URI.createURI(uriAttribute), resourceSet);
		if(contrib == null)
			return Collections.emptyList();

		Singleton[] relatedDiags;
		try {
			relatedDiags = (Singleton[]) marker.getAttribute(VerificationDiagnostic.ATTR_RELATED_DIAGNOSTICS);
		}
		catch(CoreException e) {
			relatedDiags = null;
		}
		if(relatedDiags == null)
			return Collections.singletonList(contrib);

		List<Contribution> contribs = new UniqueEList.FastCompare<Contribution>();
		for(Singleton relatedDiag : relatedDiags) {
			Contribution relatedContrib = getContribution(relatedDiag.getLocationURI(), resourceSet);
			if(relatedContrib != null)
				contribs.add(relatedContrib);
		}
		return contribs;
	}

	static Throwable unwind(Throwable t) {
		for(;;) {
			Class<?> tc = t.getClass();

			// We don't use instanceof operator since we want
			// the explicit class, not subclasses.
			//
			if(tc != RuntimeException.class && tc != InvocationTargetException.class && tc != SAXException.class &&
					tc != IOException.class)
				break;

			Throwable cause = t.getCause();
			if(cause == null)
				break;

			String msg = t.getMessage();
			if(msg != null && !msg.equals(cause.toString()))
				break;

			t = cause;
		}
		return t;
	}

	static void verifyAggregation(final Aggregation aggregation) {
		new Job("CBI Aggregator") {
			{
				setUser(true);
				setPriority(Job.LONG);
			}

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				Resource resource = ((EObject) aggregation).eResource();
				try {
					clearVerificationMarkers(aggregation);
					Builder builder = new Builder();

					URI emfURI = resource.getURI();
					URL fileURL = FileLocator.toFileURL(new java.net.URI(emfURI.toString()).toURL());
					if(!"file".equals(fileURL.getProtocol()))
						throw new Exception("URI scheme is not \"file\"");
					java.net.URI uri = new java.net.URI(
						fileURL.getProtocol() + ":/" +
								URLEncoder.encode(fileURL.getPath(), "UTF-8").replaceAll("\\+", "%20"));
					builder.setBuildModelLocation(new File(uri));
					// builder.setLogLevel(LogUtils.DEBUG);
					builder.setAction(Builder.ActionType.VALIDATE);

					if(builder.run(true, monitor) != IApplication.EXIT_OK)
						throw new Exception("Build failed (see log for more details)");
				}
				catch(Exception e) {
					Throwable cause = unwind(e);
					IStatus status = (cause instanceof CoreException)
							? ((CoreException) cause).getStatus()
							: new Status(IStatus.ERROR, Engine.PLUGIN_ID, IStatus.OK, cause.getMessage(), cause);

					if(resource != null && status instanceof AnalyzedPlannerStatus)
						((AggregatorResourceImpl) resource).updateVerificationMarkers(
							((AnalyzedPlannerStatus) status).getVerificationDiagnostics());

					return status;
				}

				return Status.OK_STATUS;
			}
		}.schedule();
	}

	@Override
	public IMarkerResolution[] getResolutions(IMarker marker) {
		try {
			Object severity = marker.getAttribute(IMarker.SEVERITY);
			if(!(severity instanceof Integer && ((Integer) severity).intValue() == IMarker.SEVERITY_ERROR))
				return noResolutions;

			Object verType = marker.getAttribute(VerificationDiagnostic.ATTR_VERIFICATION_TYPE);
			if(!Singleton.class.getName().equals(verType))
				return noResolutions;

			AggregatorEditor editor = getAggregatorEditor(marker);
			ResourceSet resourceSet = editor.getEditingDomain().getResourceSet();
			List<Contribution> contribs = getContributions(marker, resourceSet);
			if(contribs.size() < 2)
				// Moving one contribution won't help much unless its in conflict
				// with anohter
				return noResolutions;

			Contribution contribA = contribs.get(0);
			ValidationSet vA = (ValidationSet) ((EObject) contribA).eContainer();

			Contribution contribB = contribs.get(1);
			ValidationSet vB = (ValidationSet) ((EObject) contribB).eContainer();

			// If the two contributions already live in two different validation sets
			// and if one doesn't inherit the other, then moving won't help
			if(!(vA.isExtensionOf(vB) || vB.isExtensionOf(vA)))
				return noResolutions;

			Aggregation aggregation = ResourceUtils.getAggregation(resourceSet);
			List<ValidationSet> vss = aggregation.getValidationSets(true);

			List<IMarkerResolution> resolutions = new ArrayList<IMarkerResolution>();
			// Find an aggregation set that vA doesn't inherit
			boolean hasSelfA = false;
			boolean hasSelfB = false;
			for(ValidationSet vs : vss) {
				if(!(vA.isExtensionOf(vs))) {
					// Moving contribA into this set could help
					resolutions.add(new MoveToExisting(contribA, vs));
				}
				if(!(vB.isExtensionOf(vs))) {
					// Moving contribB into this set could help
					resolutions.add(new MoveToExisting(contribB, vs));
				}
				if(vs.getLabel().equals(contribA.getLabel()))
					hasSelfA = true;
				if(vs.getLabel().equals(contribB.getLabel()))
					hasSelfB = true;
			}

			if(!hasSelfA)
				resolutions.add(new MoveToNew(contribA));
			if(!hasSelfB)
				resolutions.add(new MoveToNew(contribB));
			if(!(hasSelfA || hasSelfB))
				resolutions.add(new MoveBothToNew(contribA, contribB));

			if(resolutions.isEmpty())
				return noResolutions;

			return resolutions.toArray(new IMarkerResolution[resolutions.size()]);
		}
		catch(CoreException e) {
			return noResolutions;
		}
	}

	@Override
	public boolean hasResolutions(IMarker marker) {
		return getResolutions(marker).length > 0;
	}
}
