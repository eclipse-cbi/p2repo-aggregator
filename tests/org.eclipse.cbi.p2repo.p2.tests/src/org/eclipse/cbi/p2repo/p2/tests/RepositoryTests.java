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

import java.io.File;
import java.net.URI;
import java.net.URL;

import org.eclipse.cbi.p2repo.util.Trivial;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.equinox.p2.repository.IRepository;
import org.junit.Assert;

public class RepositoryTests<T> {
	public static URI getTestData(String fileName) throws Exception {
		URI testDataURI = URI.create("platform:/plugin/org.eclipse.cbi.p2repo.p2.tests/testData/" + fileName);
		URL resolved = FileLocator.resolve(testDataURI.toURL());
		if(!"file".equalsIgnoreCase(resolved.getProtocol()))
			Assert.fail("Unable to resolve URL" + testDataURI);
		testDataURI = resolved.toURI();
		File file = new File(testDataURI);
		if(!file.canRead())
			Assert.fail("File does not exist: " + file.getAbsolutePath());
		return testDataURI;
	}

	private static void assertFieldEquals(String field, Object a, Object b) {
		if(!Trivial.equalsAllowNull(a, b))
			Assert.fail("Repository " + field + " differs");
	}

	protected IProgressMonitor monitor = new NullProgressMonitor();

	public void assertEquals(IRepository<T> a, IRepository<T> b) {
		assertFieldEquals("name", a.getName(), b.getName());
		assertFieldEquals("location", a.getLocation(), b.getLocation());
		assertFieldEquals("description", a.getDescription(), b.getDescription());
		assertFieldEquals("provider", a.getProvider(), b.getProvider());
		assertFieldEquals("type", a.getType(), b.getType());
		assertFieldEquals("version", a.getVersion(), b.getVersion());
		assertFieldEquals("properties", a.getProperties(), b.getProperties());
	}
}
