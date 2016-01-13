/**
 * Copyright (c) 2016, Red Hat Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */
package org.eclipse.b3.aggregator.presentation;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.eclipse.b3.aggregator.Feature;
import org.eclipse.b3.aggregator.InstallableUnitRequest;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Handler opening the FixVersionDialog_Title
 */
public class FixVersionHandler extends AbstractHandler {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.core.commands.IHandler#execute(org.eclipse.core.commands.ExecutionEvent)
	 */
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EditingDomain domain = null;
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if(editor instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider) editor).getEditingDomain();
		}
		else {
			return null;
		}

		ISelection selection = HandlerUtil.getCurrentSelection(event);
		if(editor instanceof ISelectionProvider) {
			selection = ((ISelectionProvider) editor).getSelection();
		}
		if(selection.isEmpty()) {
			return null;
		}
		List<Object> items = Collections.emptyList();
		if(selection instanceof IStructuredSelection) {
			items = ((IStructuredSelection) selection).toList();
		}

		Map<InstallableUnitRequest, VersionRange> versionsToSet = new HashMap<InstallableUnitRequest, VersionRange>();
		if(items.size() == 1 && items.get(0) instanceof InstallableUnitRequest) {
			InstallableUnitRequest feature = (Feature) items.get(0);
			VersionRangeEditorDialog dialog = new VersionRangeEditorDialog(
				HandlerUtil.getActiveShell(event), null, feature.getVersionRange(), feature);
			dialog.setBlockOnOpen(true);
			if(dialog.open() == IDialogConstants.OK_ID) {
				versionsToSet.put(feature, dialog.getResult());
			}
		}
		else {
			FixVersionsDialog dialog = new FixVersionsDialog(
				HandlerUtil.getActiveShell(event), new HashSet<Object>(items));
			dialog.setBlockOnOpen(true);
			if(dialog.open() == IDialogConstants.OK_ID) {
				for(Entry<InstallableUnitRequest, Version> entry : dialog.getResult().entrySet()) {
					versionsToSet.put(entry.getKey(), new VersionRange(entry.getValue(), true, entry.getValue(), true));
				}
			}
		}
		if(!versionsToSet.isEmpty()) {
			CompoundCommand compoundCommand = new CompoundCommand();
			for(final Entry<InstallableUnitRequest, VersionRange> toSet : versionsToSet.entrySet()) {
				Command command = new AbstractCommand("Set version") {
					@Override
					public boolean canExecute() {
						return true;
					}

					@Override
					public void execute() {
						toSet.getKey().setVersionRange(toSet.getValue());
					}

					@Override
					public Collection<?> getAffectedObjects() {
						return Collections.singletonList(toSet.getKey());
					}

					@Override
					public void redo() {
						execute();
					}
				};
				compoundCommand.append(command);
			}
			domain.getCommandStack().execute(compoundCommand);
		}
		return null;
	}

}
