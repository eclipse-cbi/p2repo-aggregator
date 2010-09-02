/**
 * Copyright (c) 2010, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 * 
 * Cloudsmith Inc. API and initial contribution.
 */
package org.eclipse.b3.build.ui.commands;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.b3.backend.core.IResultStatus;
import org.eclipse.b3.beelang.ui.xtext.linked.ExtLinkedXtextEditor;
import org.eclipse.b3.build.ui.Activator;
import org.eclipse.b3.build.ui.core.B3BuildUIErrorCodes;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.EvaluationContext;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.InvalidRegistryObjectException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.window.Window;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentUtil;

/**
 * Loads the BeeModel associated with the current editor (if it is an XtextEditor and
 * has b3 content - i.e. a BeeModel) into a b3 engine
 * afer having loaded a b3 Cmd (a b3 file with a _main(List) function)).
 * The _main() function is called, and defines what to do next.
 * The Event context should contain the parameter "cmdPath", with a fake URI b3:/pluginId/path.b3 to
 * mean first found of resource:/pluginId/path.b3, and plugin:/pluginId/path.b3 - or be a URI that can
 * be loaded as an Xtext Resource.
 */
public class RunCmdOnResourceHandler extends AbstractHandlerWithDialog {
	public static final String CMD_PARAM__WIZARD_ID = "org.eclipse.b3.ui.run.b3cmd.wizardId";

	public static final String CMD_PARAM__PATH = "org.eclipse.b3.ui.run.b3cmd.pathParameter";

	public static final String CMD_PARAM__FUNCTION = "org.eclipse.b3.ui.run.b3cmd.cmdFunction";

	@Override
	public IStatus executeWithDialogSupport(final ExecutionEvent event) throws ExecutionException {
		final Shell shell = HandlerUtil.getActiveShell(event);

		EvaluationContext ctx = (EvaluationContext) event.getApplicationContext();

		Object editor = ctx.getVariable("activeEditor");
		if(editor == null || !(editor instanceof ExtLinkedXtextEditor)) {
			return new Status(
				IStatus.ERROR, Activator.PLUGIN_ID, B3BuildUIErrorCodes.BAD_UI_CONFIGURATION,
				"Handler invoked on wrong type of editor: RunMainFunctionInActiveEditorHandler", null);
		}
		final String cmdPath = event.getParameter(CMD_PARAM__PATH);
		final String cmdFunction = getParameter(event, CMD_PARAM__FUNCTION, "main");

		if(cmdPath == null) {
			return new Status(
				IStatus.ERROR, Activator.PLUGIN_ID, B3BuildUIErrorCodes.BAD_UI_CONFIGURATION,
				"Bad configuration - org.eclipse.b3.ui.run.b3cmd.pathParameter not specified.", null);
		}

		ExtLinkedXtextEditor b3Editor = (ExtLinkedXtextEditor) editor;
		IXtextDocument xtextDocument = XtextDocumentUtil.get(b3Editor);
		if(xtextDocument == null) {
			return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "No b3 document found in current editor.");
		}

		IStatus result = null;
		// if a wizard should be used to collect additional information
		final String wizardId = event.getParameter(CMD_PARAM__WIZARD_ID);

		CmdUnitOfWork uow = new CmdUnitOfWork(xtextDocument, cmdPath, cmdFunction);
		if(wizardId != null) {
			// find the extension and run the wizard
			ICmdWizard wiz = null;
			IConfigurationElement[] ceDecl = Platform.getExtensionRegistry().getConfigurationElementsFor(
				"org.eclipse.b3.build.ui.cmdWizard");

			for(int i = 0; i < ceDecl.length; i++) {
				IConfigurationElement ce = ceDecl[i];
				// if(ce.getDeclaringExtension().get)
				if(!wizardId.equals(ce.getDeclaringExtension().getUniqueIdentifier()))
					continue;

				try {
					wiz = (ICmdWizard) ce.createExecutableExtension("wizard");
				}
				catch(InvalidRegistryObjectException e) {
					return new Status(
						IStatus.ERROR, Activator.PLUGIN_ID, B3BuildUIErrorCodes.BAD_UI_CONFIGURATION,
						"Faulty wizard ID in UI configuration", e);
				}
				catch(CoreException e) {
					return new Status(
						IStatus.ERROR, Activator.PLUGIN_ID, B3BuildUIErrorCodes.BAD_UI_CONFIGURATION,
						"Error while creating cmd wizard", e);
				}
			}
			if(wiz == null)
				return new Status(
					IStatus.ERROR, Activator.PLUGIN_ID, B3BuildUIErrorCodes.BAD_UI_CONFIGURATION,
					"Cmd Wizard with extension ID=" + wizardId + " not found", null);

			// set the CmdUnitOfWork in the wizard
			wiz.setCmdWork(uow);

			// run the wizard
			if(new WizardDialog(shell, wiz).open() == Window.CANCEL)
				return new Status(IStatus.CANCEL, Activator.PLUGIN_ID, B3BuildUIErrorCodes.WIZARD_CANCELED, "", null);
			// get the result from the wizard
			result = wiz.getResult();
		}
		else {
			// if there was no wizard, run the command in a null progress monitor
			try {
				uow.run(new NullProgressMonitor());
			}
			catch(InvocationTargetException e1) {
				return new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Invocation of command handler failed", e1);
			}
			catch(InterruptedException e1) {
				return Status.CANCEL_STATUS;
			}
			result = uow.getResult();
		}

		// // this is what the wizard should run
		// // it needs properties and stuff that only the wizard knows about
		//
		// IStatus result = xtextDocument.readOnly(new IUnitOfWork<IStatus, XtextResource>() {
		// // @Override
		// public IStatus exec(XtextResource state) throws Exception {
		//
		// // Check for syntax errors in 'state'
		// IResourceServiceProvider serviceProvider = state.getResourceServiceProvider();
		// IResourceValidator resourceValidator = serviceProvider.getResourceValidator();
		// List<Issue> validate = resourceValidator.validate(state, CheckMode.ALL, null);
		// if(validate.size() > 0) {
		// MultiStatus ms = new MultiStatus(
		// Activator.PLUGIN_ID, IStatus.ERROR, "Syntax errors in b3 file!", null);
		// for(Issue issue : validate)
		// ms.add(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "line " + issue.getLineNumber() + ": " +
		// issue.getMessage()));
		// return ms;
		// }
		//
		// // 1. if the path starts with b3: it means try resource:, then plugin: schemes
		// // 2. Else, the path should be a URI and only one attempt is made
		// // 3. If the result in any case is a bad URI, the configuration is bad
		// String cmdURI = cmdPath;
		// URI uris[] = null;
		// try {
		// if(cmdURI.startsWith("b3:")) {
		// String pathPart = cmdURI.substring(3);
		// uris = new URI[2];
		// uris[0] = URI.createPlatformResourceURI(pathPart, true);
		// uris[1] = URI.createPlatformPluginURI(pathPart, true);
		// }
		// else {
		// uris = new URI[1];
		// uris[0] = URI.createURI(cmdURI);
		// }
		// }
		// catch(IllegalArgumentException e) {
		// return new Status(
		// IStatus.ERROR, Activator.PLUGIN_ID, B3BuildUIErrorCodes.BAD_UI_CONFIGURATION,
		// "Faulty cmd URI in UI configuration", e);
		// }
		// // TODO: if there is a wizard for this uri:
		// // - initialize it with an IRunnableWithProgress that performs the bulk of the job
		// // - the wizard will produce parameters for this runnable
		// //
		// for(int i = 0; i < uris.length; i++) {
		// URI uri = uris[i];
		// // Try different URIs - the first to succeed is used
		//
		// // TODO: Should pass a progress monitor to the run call
		// @SuppressWarnings("unchecked")
		// IStatus result = new B3BuildEngine().run(new RunCmdOnResourceOperation(
		// uri, cmdFunction, event.getParameters(), state));
		// if(result.isOK())
		// return result;
		// if(result.getCode() != B3BuildStatusCodes.COULD_NOT_LOAD_RESOURCE)
		// return result;
		// }
		// return new Status(
		// IStatus.ERROR, Activator.PLUGIN_ID, B3BuildUIErrorCodes.BAD_UI_CONFIGURATION,
		// "Bad menu/command configuration - could not find cmd: " + cmdURI, null);
		// }
		// });
		// If invocation status is ok, and the result is a status, report that status instead of
		// the invocation status.
		//
		if(result.isOK() && result instanceof IResultStatus && ((IResultStatus) result).getResult() instanceof IStatus)
			return (IStatus) ((IResultStatus) result).getResult();
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.b3.build.ui.commands.AbstractHandlerWithDialog#shouldThisCancelBeReported(org.eclipse.core.runtime.IStatus)
	 */
	@Override
	protected boolean shouldThisCancelBeReported(IStatus status) {
		// canceling the wizard is a "normal end" and should not be reported with an extra dialog
		if(status.getCode() == B3BuildUIErrorCodes.WIZARD_CANCELED)
			return false;
		return super.shouldThisCancelBeReported(status);
	}

	private String getParameter(ExecutionEvent event, String name, String defaultValue) {
		String value = event.getParameter(name);
		return value == null
				? defaultValue
				: value;
	}
}
