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

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TrayDialog;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.jface.resource.JFaceColors;
import org.eclipse.jface.text.FindReplaceDocumentAdapterContentProposalProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.fieldassist.ContentAssistCommandAdapter;
import org.eclipse.ui.texteditor.ITextEditorActionDefinitionIds;

/**
 * @author Karel Brezina
 *
 */
public class FindIUDialog extends TrayDialog {
	private static final int FIND_ID = IDialogConstants.CLIENT_ID + 1;

	private static String getString(String key) {
		return AggregatorEditorPlugin.INSTANCE.getString(key);
	}

	private AggregatorEditor aggregatorEditor;

	private Text idPatternText;

	private Button regularExprButton;

	private ContentAssistCommandAdapter patterFieldContentAssist;

	private Text versionFromText;

	private Text versionToText;

	private Button forwardButton;

	private Label statusLabel;

	private Button findButton;

	protected FindIUDialog(IWorkbenchWindow window) {
		super(window.getShell());
		setShellStyle(SWT.SHELL_TRIM | SWT.RESIZE);

		aggregatorEditor = (AggregatorEditor) window.getActivePage().getActivePart();
	}

	@Override
	protected void buttonPressed(int buttonId) {
		switch(buttonId) {
			case IDialogConstants.CANCEL_ID:
				close();
				break;
			default:
				if(performAction(buttonId))
					close();
		}
	}

	@Override
	protected void configureShell(Shell shell) {
		super.configureShell(shell);
		shell.setText(getString("_UI_FindIUDialog_windowTitle"));
	}

	@Override
	protected Control createButtonBar(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		layout.numColumns = 0; // create
		layout.marginHeight = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_MARGIN);
		layout.marginWidth = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_MARGIN);
		layout.verticalSpacing = convertVerticalDLUsToPixels(IDialogConstants.VERTICAL_SPACING);
		layout.horizontalSpacing = convertHorizontalDLUsToPixels(IDialogConstants.HORIZONTAL_SPACING);

		composite.setLayout(layout);
		composite.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		Label filler = new Label(composite, SWT.NONE);
		filler.setLayoutData(new GridData(GridData.FILL_HORIZONTAL | GridData.GRAB_HORIZONTAL));
		layout.numColumns++;

		findButton = createButton(composite, FIND_ID, getString("_UI_FindIUDialog_findButton"), true);
		findButton.setEnabled(isFindEnabled());
		createButton(composite, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);

		return composite;
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite result = (Composite) super.createDialogArea(parent);

		Control fContents = createPageArea(result);
		fContents.setLayoutData(new GridData(GridData.FILL_BOTH));

		return result;
	}

	protected Control createPageArea(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setFont(parent.getFont());
		composite.setLayout(new GridLayout(4, false));
		composite.setLayoutData(new GridData(GridData.FILL_BOTH));

		new Label(composite, SWT.NONE).setText(getString("_UI_FindIUDialog_installableUnitIDField"));
		idPatternText = new Text(composite, SWT.BORDER);
		GridData layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 3;
		idPatternText.setLayoutData(layoutData);
		idPatternText.addModifyListener(new ModifyListener() {
			@Override
			public void modifyText(ModifyEvent e) {
				findButton.setEnabled(idPatternText.getCharCount() > 0);
			}
		});

		new Label(composite, SWT.NONE);
		regularExprButton = new Button(composite, SWT.CHECK);
		regularExprButton.setText(getString("_UI_FindIUDialog_regularExpressionField"));
		layoutData = new GridData();
		layoutData.horizontalSpan = 3;
		regularExprButton.setLayoutData(layoutData);
		regularExprButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				patterFieldContentAssist.setEnabled(isFindEnabled());
			}
		});

		TextContentAdapter contentAdapter = new TextContentAdapter();
		FindReplaceDocumentAdapterContentProposalProvider findProposer = new FindReplaceDocumentAdapterContentProposalProvider(
			true);
		patterFieldContentAssist = new ContentAssistCommandAdapter(
			idPatternText, contentAdapter, findProposer, ITextEditorActionDefinitionIds.CONTENT_ASSIST_PROPOSALS,
			new char[] { '\\', '[', '(' }, true);

		patterFieldContentAssist.setEnabled(regularExprButton.getSelection());

		labelSeparator(composite);

		new Label(composite, SWT.NONE).setText(getString("_UI_FindIUDialog_versionFromField"));
		versionFromText = new Text(composite, SWT.BORDER);
		versionFromText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		new Label(composite, SWT.NONE).setText(getString("_UI_FindIUDialog_versionToField"));
		versionToText = new Text(composite, SWT.BORDER);
		versionToText.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		labelSeparator(composite);

		Group directionGroup = new Group(composite, SWT.NONE);
		layoutData = new GridData(GridData.FILL_HORIZONTAL);
		layoutData.horizontalSpan = 4;
		directionGroup.setLayoutData(layoutData);
		directionGroup.setText(getString("_UI_FindIUDialog_directionGroupName"));
		directionGroup.setLayout(new GridLayout(2, true));

		forwardButton = new Button(directionGroup, SWT.RADIO);
		forwardButton.setText(getString("_UI_FindIUDialog_forwardButton"));

		Button backwardButton = new Button(directionGroup, SWT.RADIO);
		backwardButton.setText(getString("_UI_FindIUDialog_backwardButton"));

		forwardButton.setSelection(true);

		statusLabel = new Label(composite, SWT.LEFT);
		layoutData = new GridData(GridData.FILL, GridData.CENTER, true, false);
		layoutData.horizontalSpan = 4;
		statusLabel.setLayoutData(layoutData);

		return composite;
	}

	private boolean isFindEnabled() {
		return regularExprButton.getSelection();
	}

	private void labelSeparator(Composite composite) {
		Label separatorLabel = new Label(composite, SWT.NONE);
		GridData layoutData = new GridData();
		layoutData.horizontalSpan = 4;
		layoutData.heightHint = 8;
		separatorLabel.setLayoutData(layoutData);
	}

	protected boolean performAction(int actionID) {
		switch(actionID) {
			case CANCEL:
				return true;
			case FIND_ID:
				return performFind();
			default:
				return false;
		}
	}

	private boolean performFind() {
		Pattern idPattern = null;
		try {
			if(regularExprButton.getSelection())
				idPattern = Pattern.compile(UIUtils.trimmedValue(idPatternText));
			else
				idPattern = Pattern.compile(Pattern.quote(UIUtils.trimmedValue(idPatternText)));
		}
		catch(PatternSyntaxException e) {
			statusMessage(true, e.getLocalizedMessage());
			return false;
		}

		Version minVersion = null;
		String versionFromString = UIUtils.trimmedValue(versionFromText);

		if(versionFromString != null)
			minVersion = Version.parseVersion(versionFromString);
		else
			minVersion = Version.emptyVersion;

		Version maxVersion = null;
		String versionToString = UIUtils.trimmedValue(versionToText);

		if(versionToString != null)
			maxVersion = Version.parseVersion(versionToString);
		else
			maxVersion = Version.MAX_VERSION;

		VersionRange versionRange = new VersionRange(minVersion, true, maxVersion, true);

		aggregatorEditor.registerFindIUArguments(idPattern, versionRange);

		if(aggregatorEditor.findNextIU(forwardButton.getSelection()))
			statusMessage(false, "");
		else
			statusMessage(false, "String Not Found");

		return false;
	}

	private void statusMessage(boolean error, String message) {
		statusLabel.setText(message);

		if(error)
			statusLabel.setForeground(JFaceColors.getErrorText(statusLabel.getDisplay()));
		else
			statusLabel.setForeground(null);

		if(UIUtils.trimmedValue(message) != null)
			getShell().getDisplay().beep();
	}
}
