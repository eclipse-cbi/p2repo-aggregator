/**
 * Copyright (c) 2006-2010, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.cbi.p2repo.p2.tests;

import static org.junit.Assert.assertTrue;

import org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.junit.Test;

public class MavenModelTest {

	@Test
	public void testMetaDataLoad() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI modelURI = URI.createPlatformPluginURI(
				"/org.eclipse.cbi.p2repo.p2.tests/testData/maven-metadata-with-namespace.xml", true);
		Resource resource = resourceSet.getResource(modelURI, true);
		EList<EObject> contents = resource.getContents();
		assertTrue("One root element expected", contents.size() == 1);
		EObject eObject = contents.get(0);
		assertTrue("Root element of type org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot expected",
				eObject instanceof DocumentRoot);
	}

	@Test
	public void testMetaDataLoadNoNamespace() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI modelURI = URI.createPlatformPluginURI("/org.eclipse.cbi.p2repo.p2.tests/testData/maven-metadata.xml",
				true);
		Resource resource = resourceSet.getResource(modelURI, true);
		EList<EObject> contents = resource.getContents();
		assertTrue("One root element expected", contents.size() == 1);
		EObject eObject = contents.get(0);
		assertTrue("Root element of type org.eclipse.cbi.p2repo.p2.maven.metadata.DocumentRoot expected",
				eObject instanceof DocumentRoot);
	}

	@Test
	public void testPOM() {
		ResourceSet resourceSet = new ResourceSetImpl();
		URI modelURI = URI.createPlatformPluginURI("/org.eclipse.cbi.p2repo.p2.tests/testData/sample.pom", true);
		Resource resource = resourceSet.getResource(modelURI, true);
		EList<EObject> contents = resource.getContents();
		assertTrue("One root element expected", contents.size() == 1);
		EObject eObject = contents.get(0);
		assertTrue("Root element of type org.eclipse.cbi.p2repo.p2.maven.pom.DocumentRoot expected",
				eObject instanceof org.eclipse.cbi.p2repo.p2.maven.pom.DocumentRoot);
	}
}
