/**
 * Copyright (c) 2021 Eclipse Foundation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.analyzer.presentation;

import java.lang.reflect.InvocationTargetException;

import org.eclipse.cbi.p2repo.aggregator.provider.AggregatorEditPlugin;
import org.eclipse.cbi.p2repo.p2.provider.P2EditPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.EMFPlugin;
import org.eclipse.emf.common.ui.EclipseUIPlugin;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.statushandlers.IStatusAdapterConstants;
import org.eclipse.ui.statushandlers.StatusAdapter;
import org.eclipse.ui.statushandlers.StatusManager;

/**
 * This is the central singleton for the AggregationAnalyzer editor plugin.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public final class AggregationAnalyzerEditorPlugin extends EMFPlugin {
	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final AggregationAnalyzerEditorPlugin INSTANCE = new AggregationAnalyzerEditorPlugin();

	/**
	 * Keep track of the singleton.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static Implementation plugin;

	/**
	 * Create the instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregationAnalyzerEditorPlugin() {
		super(new ResourceLocator[] { AggregatorEditPlugin.INSTANCE, P2EditPlugin.INSTANCE, });
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	@Override
	public ResourceLocator getPluginResourceLocator() {
		return plugin;
	}

	/**
	 * Returns the singleton instance of the Eclipse plugin.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the singleton instance.
	 * @generated
	 */
	public static Implementation getPlugin() {
		return plugin;
	}

	/**
	 * The actual implementation of the Eclipse <b>Plugin</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static class Implementation extends EclipseUIPlugin {
		/**
		 * Creates an instance.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public Implementation() {
			super();

			// Remember the static instance.
			//
			plugin = this;
		}
	}

	public static void runInProgressDialog(Shell shell, IRunnableWithProgress runnable)
			throws InvocationTargetException, InterruptedException {
		ProgressMonitorDialog dialog = new ProgressMonitorDialog(shell) {
			@Override
			protected Point getInitialSize() {
				Point calculatedSize = super.getInitialSize();
				if (calculatedSize.x < 800) {
					calculatedSize.x = 800;
				}

				return calculatedSize;
			}
		};

		try {
			dialog.run(true, true, runnable);
		} catch (OperationCanceledException ex) {
			// Ignore.
		} catch (InvocationTargetException ex) {
			if (!(ex.getCause() instanceof OperationCanceledException)) {
				throw ex;
			}
		}
	}

	public void showError(String title, Throwable throwable) {
		if (throwable instanceof InvocationTargetException) {
			showError(title, throwable.getCause());
		} else if (throwable instanceof CoreException) {
			showError(title, ((CoreException) throwable).getStatus());
		} else {
			showError(title, new Status(IStatus.ERROR, getSymbolicName(), throwable.getLocalizedMessage(), throwable));
		}
	}

	public void showError(String title, IStatus status) {
		StatusAdapter statusAdapter = new StatusAdapter(status);
		statusAdapter.setProperty(IStatusAdapterConstants.TITLE_PROPERTY, title);
		StatusManager.getManager().handle(statusAdapter, StatusManager.SHOW);
	}

}
