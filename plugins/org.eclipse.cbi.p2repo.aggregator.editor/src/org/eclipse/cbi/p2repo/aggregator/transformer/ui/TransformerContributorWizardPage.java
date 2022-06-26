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

package org.eclipse.cbi.p2repo.aggregator.transformer.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.cbi.p2repo.aggregator.transformer.TransformerContextContributor;
import org.eclipse.jface.wizard.WizardPage;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public abstract class TransformerContributorWizardPage extends WizardPage implements
		TransformerContextContributor.IInteractiveHook {

	protected Map<String, Object> defaultContext = new HashMap<String, Object>();

	protected TransformerContributorWizardPage(String pageName) {
		super(pageName);
	}

	public final void setContextContributor(TransformerContextContributor contributor) {
		contributor.contributeDefaultsToContext(defaultContext);
		contributor.setInteractiveHook(this);
	}
}
