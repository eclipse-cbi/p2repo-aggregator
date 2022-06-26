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

package org.eclipse.cbi.p2repo.aggregator.presentation;

import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.util.VerificationDiagnostic;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.ui.util.EditUIMarkerHelper;

class AggregatorMarkerHelper extends EditUIMarkerHelper {

	@Override
	protected void adjustMarker(IMarker marker, Diagnostic diagnostic, Diagnostic parentDiagnostic)
			throws CoreException {
		List<?> data = diagnostic.getData();
		StringBuilder relatedURIs = new StringBuilder();
		boolean first = true;

		for(Object object : data) {
			String uriString = null;

			if(object instanceof Resource.Diagnostic) {
				uriString = ((Resource.Diagnostic) object).getLocation();
				if(object instanceof VerificationDiagnostic) {
					marker.setAttribute(VerificationDiagnostic.ATTR_VERIFICATION_TYPE, object.getClass().getName());
					if(object instanceof VerificationDiagnostic.Singleton) {
						marker.setAttribute(
							VerificationDiagnostic.ATTR_ROOT_PROBLEM,
							((VerificationDiagnostic.Singleton) object).getRootProblem());
						marker.setAttribute(
							VerificationDiagnostic.ATTR_RELATED_DIAGNOSTICS,
							((VerificationDiagnostic.Singleton) object).getRelatedDiagnostics());
					}
				}
			}
			else {
				URI uri = null;

				if(object instanceof EObject)
					uri = EcoreUtil.getURI((EObject) object);
				else if(object instanceof Resource)
					uri = ((Resource) object).getURI();

				if(uri != null)
					uriString = uri.toString();
			}

			if(uriString != null) {
				if(first) {
					first = false;
					marker.setAttribute(EValidator.URI_ATTRIBUTE, uriString);
				}
				else {
					if(relatedURIs.length() != 0) {
						relatedURIs.append(' ');
					}
					relatedURIs.append(URI.encodeFragment(uriString, false));
				}
			}
		}

		if(relatedURIs.length() > 0) {
			marker.setAttribute(EValidator.RELATED_URIS_ATTRIBUTE, relatedURIs.toString());
		}
	}

	public void createMarkers(Resource markerResource, Diagnostic diagnostic) throws CoreException {
		if(diagnostic.getChildren().isEmpty()) {
			if(diagnostic.getSeverity() != Diagnostic.OK)
				createMarkers(getFile(markerResource), diagnostic, null);
		}
		else if(diagnostic.getMessage() == null) {
			for(Diagnostic childDiagnostic : diagnostic.getChildren()) {
				createMarkers(markerResource, childDiagnostic);
			}
		}
		else {
			for(Diagnostic childDiagnostic : diagnostic.getChildren()) {
				createMarkers(getFile(markerResource), childDiagnostic, diagnostic);
			}
		}
	}

	@Override
	protected String getMarkerID() {
		return AggregatorEditor.AGGREGATOR_NONPERSISTENT_PROBLEM_MARKER;
	}

}
