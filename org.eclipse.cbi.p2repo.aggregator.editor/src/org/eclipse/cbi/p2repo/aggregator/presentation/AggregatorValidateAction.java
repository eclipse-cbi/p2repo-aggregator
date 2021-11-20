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

package org.eclipse.cbi.p2repo.aggregator.presentation;

import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.edit.ui.action.ValidateAction;

/**
 * ValidateAction that uses aggregator problem marker
 *
 * @author Karel Brezina
 */
public class AggregatorValidateAction extends ValidateAction {
	public static class AggregatorResourcesUtil extends EclipseResourcesUtil {
		@Override
		protected String getMarkerID() {
			return AggregatorEditor.AGGREGATOR_PERSISTENT_PROBLEM_MARKER;
		}
	}

	{
		eclipseResourcesUtil = EMFPlugin.IS_RESOURCES_BUNDLE_AVAILABLE
				? new AggregatorResourcesUtil()
				: null;
	}
}
