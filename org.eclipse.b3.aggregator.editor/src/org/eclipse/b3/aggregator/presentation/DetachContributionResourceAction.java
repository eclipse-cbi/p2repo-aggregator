/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */

package org.eclipse.b3.aggregator.presentation;

import org.eclipse.b3.aggregator.Contribution;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.ui.action.ControlAction;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;

/**
 * @author Karel Brezina
 * 
 */
public class DetachContributionResourceAction extends ControlAction {

	protected static class DetachContributionResourceDialog extends ControlResourceDialog {

		private static final String CONTRIBUTION_FILE_EXTENSION = "b3aggrcon";

		private static final String UNTITLED_FILE_NAME = "untitled";

		private EObject currentEObject;

		public DetachContributionResourceDialog(Shell parent, EditingDomain domain, EObject currentEObject) {
			super(parent, domain, currentEObject.eResource());
			this.currentEObject = currentEObject;
			title = LABEL_DETACH_RESOURCE;
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Control control = super.createDialogArea(parent);

			URI uri = currentEObject.eResource().getURI();

			String mainResourceUri = uri.toString();
			if(uri.lastSegment().contains("."))
				mainResourceUri = mainResourceUri.replaceAll("\\.[^.]*$", "");

			String lastSegment;
			if(UIUtils.trimmedValue(((Contribution) currentEObject).getLabel()) != null)
				lastSegment = "." + ((Contribution) currentEObject).getLabel() + "." + CONTRIBUTION_FILE_EXTENSION;
			else
				lastSegment = "." + UNTITLED_FILE_NAME + "." + CONTRIBUTION_FILE_EXTENSION;

			String newUriString = mainResourceUri + removeUnsupportedChars(lastSegment);

			uriField.setText(newUriString);

			return control;
		}

		/**
		 * @param lastSegment
		 * @return
		 */
		private String removeUnsupportedChars(String lastSegment) {
			return lastSegment.replaceAll("[^\\w\\.\\(\\)]", "_");
		}
	}

	private static final String LABEL_DETACH_RESOURCE = "Detach Resource";

	private static final String LABEL_ATTACH_RESOURCE = "Attach Resource";

	public DetachContributionResourceAction() {
		super();
		setText("Detach Resource");
	}

	public DetachContributionResourceAction(EditingDomain domain) {
		super(domain);
		setText("Detach Resource");
	}

	@Override
	protected Resource getResource() {
		DetachContributionResourceDialog dialog = new DetachContributionResourceDialog(
			PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell(), domain, eObject);
		dialog.open();
		return dialog.getResource();
	}

	@Override
	public void run() {
		String commandLabel = null;

		if(command == null)
			commandLabel = LABEL_DETACH_RESOURCE;
		else
			commandLabel = LABEL_ATTACH_RESOURCE;

		super.run();

		if(command != null)
			((AbstractCommand) command).setLabel(commandLabel);
	}

	@Override
	public boolean updateSelection(IStructuredSelection selection) {
		boolean result = super.updateSelection(selection);

		if(selection.size() != 1)
			return false;
		Object object = AdapterFactoryEditingDomain.unwrap(selection.getFirstElement());

		if(!AdapterFactoryEditingDomain.isControlled(object))
			setText("Detach Resource");
		else
			setText("Attach Resource");

		result = result && (object instanceof Contribution);

		return result;
	}
}
