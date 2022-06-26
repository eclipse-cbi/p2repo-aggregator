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
package org.eclipse.cbi.p2repo.aggregator.engine;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;

public abstract class BuilderPhase {
	private final Builder builder;

	protected BuilderPhase(Builder builder) {
		this.builder = builder;
	}

	public Builder getBuilder() {
		return builder;
	}

	public abstract void run(IProgressMonitor monitor) throws CoreException;
}
