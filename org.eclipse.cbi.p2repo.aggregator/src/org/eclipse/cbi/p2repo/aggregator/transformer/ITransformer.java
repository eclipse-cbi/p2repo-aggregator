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

package org.eclipse.cbi.p2repo.aggregator.transformer;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

/**
 * Transforms source resource to target resource
 *
 * @author Karel Brezina
 */
public interface ITransformer {

	/**
	 * Returns resource errors.
	 *
	 * @return Returns a list of resource errors.
	 */
	List<Diagnostic> getResourceErrors();

	/**
	 * Initialize transformer
	 *
	 * @param srcResource
	 *            source resource
	 * @param trgtResource
	 *            target resource
	 * @param trgtPackage
	 *            target package which is used for target resource generation
	 */
	void initTransformer(Resource srcResource, Resource trgtResource, EPackage trgtPackage, Map<String, Object> context);

	/**
	 * Starts transformation
	 */
	void startTransformation(boolean resolveProxies);
}
