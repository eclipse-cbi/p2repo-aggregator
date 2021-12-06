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

package org.eclipse.cbi.p2repo.util;

import org.eclipse.core.runtime.IStatus;

public enum LogLevel {
	DEBUG(IStatus.OK), INFO(IStatus.INFO), WARNING(IStatus.WARNING), ERROR(IStatus.ERROR);

	int statusLevel;

	LogLevel(int statusLevel) {
		this.statusLevel = statusLevel;
	}

	public int getStatusLevel() {
		return statusLevel;
	}
}
