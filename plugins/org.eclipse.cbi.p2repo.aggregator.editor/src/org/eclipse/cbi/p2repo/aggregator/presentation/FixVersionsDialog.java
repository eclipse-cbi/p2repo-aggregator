/**
 * Copyright (c) 2016 Red Hat Inc. Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.cbi.p2repo.aggregator.presentation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AvailableVersion;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.P2RepoMessages;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ComboBoxViewerCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 *
 */
public class FixVersionsDialog extends TitleAreaDialog {

	private Map<InstallableUnitRequest, Version> suggestedVersions;

	/**
	 * @param parentShell
	 * @param aggregatorModelObjects
	 */
	public FixVersionsDialog(Shell parentShell, Set<Object> aggregatorModelObjects) {
		super(parentShell);
		this.suggestedVersions = new HashMap<InstallableUnitRequest, Version>();
		LinkedList<Object> toProcess = new LinkedList<Object>(aggregatorModelObjects);
		HashSet<Object> processed = new HashSet<Object>();
		while(!toProcess.isEmpty()) {
			Object current = toProcess.pop();
			if(processed.contains(current)) {
				continue;
			}
			processed.add(current);
			if(current instanceof InstallableUnitRequest) {
				InstallableUnitRequest feature = (InstallableUnitRequest) current;
				List<AvailableVersion> availableVersions = feature.getAvailableVersions();
				if(availableVersions != null && !availableVersions.isEmpty()) {
					boolean skip = false;
					if(feature.getVersionRange() != null) {
						VersionRange range = feature.getVersionRange();
						if(range.getIncludeMaximum() && range.getIncludeMaximum() &&
								range.getMinimum().equals(range.getMaximum())) {
							for(AvailableVersion available : feature.getAvailableVersions()) {
								if(available.getVersion().equals(range.getMaximum())) {
									skip = true;
								}
							}
						}
					}
					if(skip) {
						continue;
					}
					this.suggestedVersions.put(feature, availableVersions.get(0).getVersion());
					for(AvailableVersion version : availableVersions) {
						VersionRange range = feature.getVersionRange();
						if(range == null || range.isIncluded(version.getVersion())) {
							if(!suggestedVersions.containsKey(feature) ||
									suggestedVersions.get(feature).compareTo(version.getVersion()) < 0) {
								suggestedVersions.put(feature, version.getVersion());
							}
						}
					}
				}
			}
			else if(current instanceof Aggregation) {
				toProcess.addAll(((Aggregation) current).getAllContributions(false));
			}
			else if(current instanceof Contribution) {
				toProcess.addAll(((Contribution) current).getRepositories());
			}
			else if(current instanceof MappedRepository) {
				toProcess.addAll(((MappedRepository) current).getFeatures());
			}
		}
	}

	@Override
	public Control createDialogArea(Composite parent) {
		setTitle(P2RepoMessages.FixVersionDialog_Title);
		setMessage(P2RepoMessages.FixVersionDialog_UpdateMessage);

		Composite res = new Composite(parent, SWT.NONE);
		res.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		res.setLayout(new GridLayout(1, false));

		Label summaryLabel = new Label(res, SWT.NONE);
		summaryLabel.setText(this.suggestedVersions.size() + " versions to update.");

		final TableViewer viewer = new TableViewer(res);
		viewer.getControl().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		viewer.getTable().setHeaderVisible(true);
		viewer.getTable().setLinesVisible(true);
		TableViewerColumn nameColumn = new TableViewerColumn(viewer, SWT.DEFAULT);
		nameColumn.getColumn().setText("Feature");
		nameColumn.getColumn().setResizable(true);
		nameColumn.getColumn().setWidth(200);
		nameColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object o) {
				return ((InstallableUnitRequest) o).getName();
			}
		});
		TableViewerColumn previousVersion = new TableViewerColumn(viewer, SWT.DEFAULT);
		previousVersion.getColumn().setResizable(true);
		previousVersion.getColumn().setWidth(200);
		previousVersion.getColumn().setText("Current Version");
		previousVersion.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object o) {
				VersionRange range = ((InstallableUnitRequest) o).getVersionRange();
				if(range != null) {
					return range.toString();
				}
				return ""; //$NON-NLS-1$
			}
		});
		TableViewerColumn suggestedVersion = new TableViewerColumn(viewer, SWT.DEFAULT);
		suggestedVersion.getColumn().setText("Suggested Version");
		suggestedVersion.getColumn().setResizable(true);
		suggestedVersion.getColumn().setWidth(200);
		suggestedVersion.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public Color getForeground(Object o) {
				InstallableUnitRequest feature = (InstallableUnitRequest) o;
				VersionRange range = feature.getVersionRange();
				if(range != null) {
					if(!range.isIncluded(suggestedVersions.get(feature))) {
						return viewer.getControl().getDisplay().getSystemColor(SWT.COLOR_RED);
					}
				}
				return viewer.getControl().getDisplay().getSystemColor(SWT.COLOR_DARK_GREEN);
			}

			@Override
			public String getText(Object o) {
				InstallableUnitRequest feature = (InstallableUnitRequest) o;
				return suggestedVersions.get(feature).toString();
			}
		});
		suggestedVersion.setEditingSupport(new EditingSupport(viewer) {
			@Override
			protected boolean canEdit(Object element) {
				return ((InstallableUnitRequest) element).getAvailableVersions().size() > 1;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				InstallableUnitRequest feature = (InstallableUnitRequest) element;
				ComboBoxViewerCellEditor comboCellEditor = new ComboBoxViewerCellEditor(viewer.getTable());
				comboCellEditor.setContentProvider(new ArrayContentProvider());
				List<Version> content = new ArrayList<Version>();
				for(AvailableVersion version : feature.getAvailableVersions()) {
					content.add(version.getVersion());
				}
				comboCellEditor.setInput(content);
				return comboCellEditor;
			}

			@Override
			protected Version getValue(Object element) {
				InstallableUnitRequest feature = (InstallableUnitRequest) element;
				return suggestedVersions.get(feature);
			}

			@Override
			protected void setValue(Object element, Object value) {
				suggestedVersions.put((InstallableUnitRequest) element, (Version) value);
				viewer.refresh(element);
			}
		});
		viewer.setContentProvider(new ArrayContentProvider());
		this.suggestedVersions.values().removeIf(Objects::isNull);
		viewer.setInput(this.suggestedVersions.keySet());

		return res;
	}

	/**
	 * @return
	 */
	public Map<InstallableUnitRequest, Version> getResult() {
		return this.suggestedVersions;
	}
}
