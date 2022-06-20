/**
 * Copyright (c) 2022 Eclipse Foundation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.analyzer.presentation;

import java.lang.reflect.Method;
import java.util.function.BiConsumer;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Widget;

public final class BreadCrumbSupport {
	private BreadCrumbSupport() {
		throw new RuntimeException("Cannot instantiate");
	}

	public static StructuredViewer createBreadCrumbViewer(Composite parent, int style,
			BiConsumer<StructuredViewer, Object> dropDownViewerConfigurator) {
		return new BreadcrumbViewer(parent, style, dropDownViewerConfigurator);
	}

	@SuppressWarnings("restriction")
	private static final class BreadcrumbViewer
			extends org.eclipse.jdt.internal.ui.javaeditor.breadcrumb.BreadcrumbViewer {
		final private BiConsumer<StructuredViewer, Object> dropDownViewerConfigurator;

		public BreadcrumbViewer(Composite parent, int style,
				BiConsumer<StructuredViewer, Object> dropDownViewerConfigurator) {
			super(parent, style);
			this.dropDownViewerConfigurator = dropDownViewerConfigurator;

			addDoubleClickListener(event -> {
				Object element = ((IStructuredSelection) event.getSelection()).getFirstElement();
				Widget item = findItem(((ITreeContentProvider) getContentProvider()).getParent(element));
				if (item != null) {
					try {
						Method openDropDownMenuMethod = item.getClass().getDeclaredMethod("openDropDownMenu");
						openDropDownMenuMethod.setAccessible(true);
						openDropDownMenuMethod.invoke(item);
					} catch (Exception ex) {
						// Ignore.
					}
				}
			});
		}

		@Override
		protected void configureDropDownViewer(TreeViewer viewer, Object input) {
			dropDownViewerConfigurator.accept(viewer, input);
		}
	}
}