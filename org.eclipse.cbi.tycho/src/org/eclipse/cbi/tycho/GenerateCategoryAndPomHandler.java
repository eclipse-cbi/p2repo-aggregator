/*******************************************************************************
 * Copyright (c) 2016-2020, Red Hat Inc. and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.cbi.tycho;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map.Entry;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.handlers.HandlerUtil;

public class GenerateCategoryAndPomHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IStructuredSelection sel = HandlerUtil.getCurrentStructuredSelection(event);
		Object o = sel.getFirstElement();
		if (! (o instanceof Aggregation)) {
			return null;
		}
		Aggregation agg = (Aggregation)o;
		IEditorInput input = HandlerUtil.getActiveEditorInput(event);
		IContainer container = null;
		if (input instanceof IFileEditorInput) {
			container = ((IFileEditorInput) input).getFile().getParent();
		}
		try {
			for (Entry<IPath, String> content : new AggregatorToTycho(agg).createTychoFiles().entrySet()) {
				ByteArrayInputStream source = new ByteArrayInputStream(content.getValue().getBytes());
				IFile file = container.getFile(content.getKey());
				IContainer parent = file.getParent();
				if (!parent.exists()) {
					parent.getParent().getFolder(Path.fromOSString(parent.getName())).create(false, true, new NullProgressMonitor());
				}
				if (!file.exists()) {
					file.create(source, true, new NullProgressMonitor());
				} else {
					file.setContents(source, false, true, new NullProgressMonitor());
				}
				source.close();
			}
		} catch (IOException | CoreException e) {
			e.printStackTrace();
		}

		return null;
	}

}
