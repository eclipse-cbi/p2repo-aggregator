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

package org.eclipse.cbi.p2repo.p2.util;

import org.eclipse.equinox.internal.p2.metadata.TranslationSupport;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.IQueryable;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class RepositoryTranslationSupport extends TranslationSupport {

	public static TranslationSupport getInstance(IQueryable<IInstallableUnit> mdr) {
		return new RepositoryTranslationSupport(mdr);
	}

	private RepositoryTranslationSupport(IQueryable<IInstallableUnit> mdr) {
		super();
		setTranslationSource(mdr);
	}
}
