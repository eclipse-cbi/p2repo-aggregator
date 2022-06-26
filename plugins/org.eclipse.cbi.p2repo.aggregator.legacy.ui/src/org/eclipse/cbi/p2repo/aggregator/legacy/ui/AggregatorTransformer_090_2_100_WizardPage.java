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

package org.eclipse.cbi.p2repo.aggregator.legacy.ui;

import java.util.Map;

import org.eclipse.cbi.p2repo.aggregator.legacy.AggregatorTransformer_090_2_100;
import org.eclipse.cbi.p2repo.aggregator.transformer.ui.TransformerContributorWizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class AggregatorTransformer_090_2_100_WizardPage extends TransformerContributorWizardPage {

	private static final String PAGE_ID = "AggregatorTransformer_090_2_100";

	private Combo transformationTypeCombo;

	private int selectedType = 0;

	public AggregatorTransformer_090_2_100_WizardPage() {
		super(PAGE_ID);
		setPageComplete(true);
		setTitle("Version to Version Range transformation");
		setDescription("Choose how to transform installable unit versions");
	}

	@Override
	public void contributeToContext(Map<String, Object> context) {
		context.put(AggregatorTransformer_090_2_100.CONTEXT_FIXED_VERSION, Boolean.valueOf(selectedType == 0));
	}

	@Override
	public void createControl(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayout(new GridLayout(2, false));

		new Label(composite, SWT.NONE).setText("Target version range will include:");
		transformationTypeCombo = new Combo(composite, SWT.READ_ONLY);
		transformationTypeCombo.setItems(
			new String[] { "exactly original version", "all versions >= original version" });
		Boolean defaultValue = (Boolean) defaultContext.get(AggregatorTransformer_090_2_100.CONTEXT_FIXED_VERSION);
		transformationTypeCombo.select(defaultValue != null && !defaultValue
				? 1
				: 0);

		transformationTypeCombo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				selectedType = transformationTypeCombo.getSelectionIndex();
			}
		});

		setControl(composite);
	}
}
