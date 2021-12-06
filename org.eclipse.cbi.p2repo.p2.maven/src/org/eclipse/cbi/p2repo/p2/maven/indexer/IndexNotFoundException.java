/**
 * Copyright (c) 2006-2007, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.cbi.p2repo.p2.maven.indexer;

/**
 * @author Filip Hrbek (filip.hrbek@cloudsmith.com)
 *
 */
public class IndexNotFoundException extends Exception {
	private static final long serialVersionUID = -802899846175692819L;

	public IndexNotFoundException() {
	}

	/**
	 * @param message
	 */
	public IndexNotFoundException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public IndexNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public IndexNotFoundException(Throwable cause) {
		super(cause);
	}

}
