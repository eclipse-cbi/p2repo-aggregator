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

package org.eclipse.cbi.p2repo.p2.maven.loader;

import org.eclipse.equinox.p2.metadata.Version;

public class VersionEntry {
	String groupId;

	String artifactId;

	Version version;

	public VersionEntry(String groupId, String artifactId, Version version) {
		this.groupId = groupId;
		this.artifactId = artifactId;
		this.version = version;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(groupId);
		sb.append('/');
		sb.append(artifactId);
		sb.append('#');
		sb.append(version.getOriginal());
		return sb.toString();
	}
}
