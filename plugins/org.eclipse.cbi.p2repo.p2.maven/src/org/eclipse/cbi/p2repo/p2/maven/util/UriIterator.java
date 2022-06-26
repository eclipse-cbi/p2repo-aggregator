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
package org.eclipse.cbi.p2repo.p2.maven.util;

import java.net.URI;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.equinox.internal.p2.repository.Transport;

public class UriIterator implements Iterator<URI> {
	private final URI root;

	private final URI[] uris;

	private final Pattern excludePattern;

	private int index;

	public UriIterator(Transport transport, URI root, Pattern excludePattern, IProgressMonitor monitor)
			throws CoreException {
		this.uris = UriUtils.list(transport, UriUtils.appendTrailingSlash(root), monitor);
		this.excludePattern = excludePattern;
		this.root = root;
		index = -1;
		positionNext();
	}

	public UriIterator(URI root, Pattern excludePattern, URI[] uris) {
		this.uris = uris;
		this.excludePattern = excludePattern;
		this.root = root;
		index = -1;
		positionNext();
	}

	public URI getRoot() {
		return root;
	}

	public URI[] getURIs() {
		return uris;
	}

	@Override
	public boolean hasNext() {
		return index < uris.length;
	}

	@Override
	public URI next() {
		if(!hasNext())
			throw new NoSuchElementException();

		URI nextURL = uris[index];
		positionNext();
		return nextURL;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

	public int size() {
		return uris.length;
	}

	private void positionNext() {
		if(excludePattern == null)
			++index;
		else {
			int top = uris.length;
			for(;;) {
				if(++index >= top || !excludePattern.matcher(uris[index].toString()).matches())
					break;
			}
		}
	}
}
