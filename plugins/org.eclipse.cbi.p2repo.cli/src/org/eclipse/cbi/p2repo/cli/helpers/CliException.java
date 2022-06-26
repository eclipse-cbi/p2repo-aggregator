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

package org.eclipse.cbi.p2repo.cli.helpers;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class CliException extends Exception {

	private static final long serialVersionUID = -5229548403667906807L;

	public CliException() {
		super();
	}

	/**
	 * @param message
	 */
	public CliException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CliException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public CliException(Throwable cause) {
		super(cause);
	}

}
