/*******************************************************************************
 * Copyright (c) 2006-2007, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 ******************************************************************************/

package org.eclipse.b3.p2.maven;

import java.io.IOException;
import java.util.Collections;

import org.eclipse.b3.p2.maven.metadata.DocumentRoot;
import org.eclipse.b3.p2.maven.metadata.MetaData;
import org.eclipse.b3.p2.maven.metadata.MetadataFactory;
import org.eclipse.b3.p2.maven.metadata.util.MetadataResourceFactoryImpl;
import org.eclipse.b3.util.ExceptionUtils;
import org.eclipse.b3.util.LogUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceFactoryRegistryImpl;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;

/**
 * @author Filip Hrbek (filip.hrbek@cloudsmith.com)
 * 
 */
public class MavenMetadata {
	private DocumentRoot documentRoot;

	public MavenMetadata() {
		documentRoot = MetadataFactory.eINSTANCE.createDocumentRoot();
		documentRoot.setMetadata(MetadataFactory.eINSTANCE.createMetaData());
	}

	public MavenMetadata(URI uri) throws CoreException {
		Resource resource = getResourceSet().getResource(uri, true);
		EList<EObject> content = resource.getContents();
		if(content.size() != 1)
			throw ExceptionUtils.fromMessage(
				"ECore Resource did not contain one resource. It had %d", Integer.valueOf(content.size()));

		documentRoot = (DocumentRoot) content.get(0);
		Diagnostic diag = Diagnostician.INSTANCE.validate(documentRoot);
		if(diag.getSeverity() == Diagnostic.ERROR) {
			for(Diagnostic childDiag : diag.getChildren())
				LogUtils.error(childDiag.getMessage());
			throw ExceptionUtils.fromMessage("Maven Metadata model validation failed: %s", diag.getMessage());
		}
	}

	public MetaData getMetaData() throws CoreException {
		if(documentRoot == null || documentRoot.getMetadata() == null)
			throw ExceptionUtils.fromMessage("No metadata available");

		return documentRoot.getMetadata();
	}

	public void save() throws CoreException {
		save((Resource) null);
	}

	public void save(Resource resource) throws CoreException {
		Resource targetResource = resource;

		if(targetResource == null)
			targetResource = documentRoot.eResource();

		if(targetResource == null)
			throw ExceptionUtils.fromMessage("No resource to store Maven Metadata");

		if(resource != null && !targetResource.equals(documentRoot.eResource()))
			targetResource.getContents().add(documentRoot);

		try {
			targetResource.save(Collections.emptyMap());
		}
		catch(IOException e) {
			throw ExceptionUtils.fromMessage(e, "Unable to save Maven Metadata");
		}
	}

	public void save(URI uri) throws CoreException {
		save(getResourceSet().createResource(uri));
	}

	private ResourceSet getResourceSet() {
		ResourceSet resourceSet = new ResourceSetImpl();
		resourceSet.setResourceFactoryRegistry(new ResourceFactoryRegistryImpl() {
			@Override
			public Resource.Factory getFactory(URI uri) {
				return new MetadataResourceFactoryImpl();
			}

			@Override
			public Resource.Factory getFactory(URI uri, String contentType) {
				return getFactory(uri);
			}
		});

		return resourceSet;
	}
}
