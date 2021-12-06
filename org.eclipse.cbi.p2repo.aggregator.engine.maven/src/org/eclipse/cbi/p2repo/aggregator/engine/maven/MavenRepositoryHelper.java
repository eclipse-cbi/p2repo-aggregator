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
package org.eclipse.cbi.p2repo.aggregator.engine.maven;

/**
 * @author Filip Hrbek (filip.hrbek@cloudsmith.com)
 *
 */
public class MavenRepositoryHelper {
	private String[][] mappingRules;

	private InstallableUnitMapping top;

	public MavenRepositoryHelper(InstallableUnitMapping top, String[][] mappingRules) {
		this.top = top;
		this.mappingRules = mappingRules;
	}

	public String[][] getMappingRules() {
		return mappingRules;
	}

	public InstallableUnitMapping getTop() {
		return top;
	}
}
