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

package org.eclipse.cbi.p2repo.aggregator.util;

import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

/**
 * @author Karel Brezina
 *
 */
public class ResourceDiagnosticImpl implements Diagnostic {
	protected String location;

	protected String message;

	public ResourceDiagnosticImpl(String message, String location) {
		this.message = message;
		this.location = location;
	}

	public int getColumn() {
		return 0;
	}

	public int getLine() {
		return 0;
	}

	public String getLocation() {
		return location;
	}

	public String getMessage() {
		return message;
	}
}
