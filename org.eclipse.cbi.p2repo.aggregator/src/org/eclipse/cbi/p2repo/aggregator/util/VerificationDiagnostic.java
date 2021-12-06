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
package org.eclipse.cbi.p2repo.aggregator.util;

import java.util.Iterator;
import java.util.LinkedList;

import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.IdentificationProvider;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MappedUnit;
import org.eclipse.cbi.p2repo.aggregator.ValidationSet;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.equinox.internal.p2.director.Explanation;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;

public class VerificationDiagnostic extends ResourceDiagnosticImpl {

	public static class DependencyLink {

		IInstallableUnit installableUnit;

		DependencyLink parent;

		URI modelElementURI;

		String identifier;

		int level = -1;

		public DependencyLink(IInstallableUnit value, DependencyLink parent) {
			this.installableUnit = value;
			this.parent = parent;
		}

		public String getIdentifier() {
			return identifier;
		}

		public IInstallableUnit getInstallableUnit() {
			return installableUnit;
		}

		public int getLevel() {
			return level;
		}

		public URI getModelElementURI() {
			return modelElementURI;
		}

		public DependencyLink getParent() {
			return parent;
		}

		@Override
		public String toString() {
			return identifier == null && installableUnit != null
					? installableUnit.toString()
					: identifier;
		}

	}

	public static class Singleton extends VerificationDiagnostic {

		private final Explanation rootProblem;

		private final Singleton[] relatedDiagnostics;

		public Singleton(Explanation rootProblem, URI locationURI, Singleton[] relatedDiagnostics) {
			super(rootProblem.toString(), locationURI);
			this.relatedDiagnostics = relatedDiagnostics;
			this.rootProblem = rootProblem;
		}

		public Singleton[] getRelatedDiagnostics() {
			return relatedDiagnostics;
		}

		public Explanation getRootProblem() {
			return rootProblem;
		}

	}

	public static final String ATTR_ROOT_PROBLEM = "p2.verification.root.problem";

	public static final String ATTR_RELATED_DIAGNOSTICS = "p2.verification.related.diagnostics";

	public static final String ATTR_VERIFICATION_TYPE = "p2.verification.error.type";

	public static final String PROP_AGGREGATOR_MODEL_ELEMENT_URI = "org.eclipse.cbi.p2repo.aggregator.model.element.URI"; //$NON-NLS-1$

	public static EObject getCorrespondingModelObject(Resource resource, DependencyLink link) {
		String relativeEObjectURI = link.getInstallableUnit().getProperty(PROP_AGGREGATOR_MODEL_ELEMENT_URI);
		URI absoluteEObjectURI = URI.createURI(relativeEObjectURI).resolve(resource.getURI());

		return resource.getResourceSet().getEObject(absoluteEObjectURI, true);
	}

	public static String getIdentifierSegment(String type, String value) {
		return type + '(' + value + ')';
	}

	/** Build and set identifiers of all links in the dependency chain. */
	public static void identifyDependencyChain(DependencyLink dependencyChain, Resource resource, String separator,
			String indent) {
		LinkedList<Object> identifierSegmentList = new LinkedList<Object>();
		URI modelElementURI = null;
		int level;
		StringBuilder identifierBuilder = new StringBuilder();

		// build a list of segments of the identifier
		BUILD_IDENTIFIER_SEGMENT_LIST: {
			DependencyLink currentLink = dependencyChain;
			DependencyLink parentLink = currentLink.getParent();
			EObject modelObject;

			if(parentLink != null) {
				LINK_LOOP: while(true) {
					DependencyLink previousLink = currentLink;

					currentLink = parentLink;
					parentLink = currentLink.getParent();

					if(parentLink == null) { // the current link is the head of the chain
						// the head of the chain must have the model URI information attached
						modelObject = getCorrespondingModelObject(resource, currentLink);

						// try to locate a more specific model object corresponding to the currentLink
						if(modelObject instanceof MappedRepository) {
							IInstallableUnit previousIU = previousLink.getInstallableUnit();

							for(MappedUnit mu : ((MappedRepository) modelObject).getUnits(true)) {
								if(mu.getRequirement().isMatch(previousIU)) {
									currentLink = previousLink;
									modelObject = (EObject) mu;
									// we don't prepend the current link, we will rather prepend its corresponding model node
									break LINK_LOOP;
								}
							}
						}

						if((level = prependIdentifierSegment(identifierSegmentList, previousLink, null)) >= 0) {
							// the link had been already identified, which allows us to short circuit the current identification
							modelElementURI = previousLink.getModelElementURI();
							identifierBuilder.append(previousLink.getIdentifier());
							break BUILD_IDENTIFIER_SEGMENT_LIST;
						}

						// we've reached the head of the chain
						break LINK_LOOP;
					}

					if((level = prependIdentifierSegment(identifierSegmentList, previousLink, null)) >= 0) {
						// the link had been already identified, which allows us to short circuit the current identification
						modelElementURI = previousLink.getModelElementURI();
						identifierBuilder.append(previousLink.getIdentifier());
						break BUILD_IDENTIFIER_SEGMENT_LIST;
					}
				}
			}
			else
				// the chain consists of just one link - which is its head (which must have the model URI information attached)
				modelObject = getCorrespondingModelObject(resource, currentLink);

			if((level = prependIdentifierSegment(identifierSegmentList, currentLink, modelObject)) >= 0) {
				// the link had been already identified, which allows us to short circuit the current identification
				modelElementURI = currentLink.getModelElementURI();
				identifierBuilder.append(currentLink.getIdentifier());
				break BUILD_IDENTIFIER_SEGMENT_LIST;
			}

			// build a path of model elements up to a ValidationSet (or root) node
			while(true) {
				if(modelObject instanceof ValidationSet)
					break;

				if(modelObject instanceof Contribution)
					modelElementURI = EcoreUtil.getURI(modelObject);

				modelObject = modelObject.eContainer();

				if(modelObject == null) {
					modelElementURI = null;
					break;
				}

				prependIdentifierSegment(identifierSegmentList, null, modelObject);
			}
		}

		// build the identifier string
		String identifier;
		{
			Iterator<Object> segmentIterator = identifierSegmentList.iterator();

			while(segmentIterator.hasNext()) {
				++level;

				identifierBuilder.append(separator);
				for(int i = 0; i <= level; ++i)
					identifierBuilder.append(indent);

				identifierBuilder.append(segmentIterator.next().toString());
			}

			identifier = identifierBuilder.toString();
		}

		// set the identifiers (and other info) in the dependency chain links
		int length = 0;

		while(!identifierSegmentList.isEmpty()) {
			Object segment = identifierSegmentList.removeLast();
			if(!(segment instanceof DependencyLink))
				break;

			DependencyLink link = (DependencyLink) segment;
			if(link.level >= 0)
				break;

			identifier = identifier.substring(0, identifier.length() - length);
			length = link.identifier.length() + separator.length() + indent.length() * (level + 1);

			link.identifier = identifier;
			link.level = level--;
			link.modelElementURI = modelElementURI;
		}
	}

	protected static int prependIdentifierSegment(LinkedList<Object> identifierSegmentList, DependencyLink link,
			EObject eObject) {
		if(link != null) {
			String identifier = link.getIdentifier();

			if(identifier != null) { // if the link already has an identifier then we can finish the current identification right away
				return link.level;
			}

			// we temporarily store the segment text in the dependency link, it will be later replaced by the full identifier string
			link.identifier = (eObject == null)
					? getIdentifierSegment("InstallableUnit", link.getInstallableUnit().toString())
					: getIdentifierSegment(eObject.eClass().getName(), (eObject instanceof IdentificationProvider)
							? ((IdentificationProvider) eObject).getIdentification()
							: eObject.toString());

			identifierSegmentList.addFirst(link);
			return -1;
		}

		identifierSegmentList.addFirst(getIdentifierSegment(
			eObject.eClass().getName(), (eObject instanceof IdentificationProvider)
					? ((IdentificationProvider) eObject).getIdentification()
					: eObject.toString()));
		return -1;
	}

	protected URI locationURI;

	public VerificationDiagnostic(String message, URI locationURI) {
		super(message, locationURI.toString());
		this.locationURI = locationURI;
	}

	public URI getLocationURI() {
		return locationURI;
	}

	public void resolveLocation(URI base) {
		URI newLocationURI = locationURI.resolve(base);
		if(newLocationURI != locationURI) {
			location = newLocationURI.toString();
			locationURI = newLocationURI;
		}
	}

}
