/**
 * Copyright (c) 2025 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.analyzer.presentation.handlers;

import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.text.Collator;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.TreeMap;

import org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Project;
import org.eclipse.cbi.p2repo.aggregator.analyzer.presentation.AggregationAnalyzerEditorPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.json.JSONObject;

public class GenerateReleaseJSON extends BaseHandler {

	@Override
	protected Activity createActivity(Analysis analysis) {
		return new Generator(analysis);
	}

	private static class Generator extends Activity {
		private final Analysis analysis;

		private final URIConverter uriConverter;

		private URI releaseJSONRootURI;

		public Generator(Analysis analysis) {
			this.analysis = analysis;
			this.uriConverter = analysis.eResource().getResourceSet().getURIConverter();
		}

		@Override
		public boolean isEnabled() {
			return "simrel.aggran".equals(analysis.eResource().getURI().lastSegment());
		}

		@Override
		public void perform(Shell shell) {
			ReleaseJSONDialog releaseJSONDialog = new ReleaseJSONDialog(shell);
			releaseJSONDialog.setBlockOnOpen(true);
			if (releaseJSONDialog.open() == Window.OK) {
				releaseJSONRootURI = URI.createPlatformResourceURI(releaseJSONDialog.getFolder(), true);
				super.perform(shell);
			}
		}

		@Override
		protected void perform(IProgressMonitor monitor) throws Exception {
			generateReleaseRecord();
		}

		private void generateReleaseRecord() {
			try {
				var date = LocalDate.ofInstant(analysis.getReleaseDate().toInstant(), ZoneId.systemDefault());
				var releaseName = date.format(DateTimeFormatter.ofPattern("yyyy-MM", Locale.US));
				var previousReleaseName = date.minusMonths(3).format(DateTimeFormatter.ofPattern("yyyy-MM", Locale.US));

				var root = newJSONObject();

				var release = newJSONObject();
				release.put("release_name", releaseName);
				root.put(releaseName, release);

				var previousRelease = newJSONObject();
				previousRelease.put("release_name", previousReleaseName);
				previousRelease.put("release_url",
						"https://projects.eclipse.org/api/simultaneous_release/" + previousReleaseName);
				release.put("previous_release", previousRelease);

				JSONObject projects = newJSONObject();
				release.put("projects", projects);

				var sortedProjects = new TreeMap<String, Project>(Collator.getInstance());
				for (var contributionAnalysis : analysis.getContributions()) {
					if (contributionAnalysis.isEnabled() || "a.Participant".equals(contributionAnalysis.getLabel())) {
						for (var project : contributionAnalysis.getAllProjects()) {
							if (project.getParent() != null || project.getSubprojects().isEmpty()) {
								sortedProjects.put(project.getName(), project);
							}
						}
					}
				}

				for (var project : sortedProjects.values()) {
					var jsonProject = newJSONObject();
					projects.put(project.getSite().lastSegment(), jsonProject);
					jsonProject.put("project_name", project.getName());
					URI news = project.getNews();
					if (news != null) {
						jsonProject.put("new_and_noteworthy_url", Objects.toString(news));
					}
				}

				URI reportURI = releaseJSONRootURI.appendSegment(releaseName + "_participants.json");
				try (PrintStream out = new PrintStream(uriConverter.createOutputStream(reportURI), true,
						StandardCharsets.UTF_8)) {
					out.print(root.toString(2));
				}
			} catch (IOException ex) {
				AggregationAnalyzerEditorPlugin.INSTANCE.log(ex);
			}
		}

		private JSONObject newJSONObject() {
			return new MyJSONObject();
		}

		private static class MyJSONObject extends JSONObject {
			private static final Field MAP_FIELD;
			static {
				try {
					MAP_FIELD = JSONObject.class.getDeclaredField("map");
					MAP_FIELD.setAccessible(true);
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}
			}

			public MyJSONObject() {
				try {
					MAP_FIELD.set(this, new LinkedHashMap<String, Object>());
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}
			}

		}
	}

	private static class ReleaseJSONDialog extends Dialog {
		private static final IDialogSettings REPORT_DIALOG_SETTINGS = DialogSettings
				.getOrCreateSection(AggregationAnalyzerEditorPlugin.getPlugin().getDialogSettings(), "release-json");

		private Text text;

		public ReleaseJSONDialog(Shell parentShell) {
			super(parentShell);
		}

		@Override
		protected IDialogSettings getDialogBoundsSettings() {
			return REPORT_DIALOG_SETTINGS;
		}

		@Override
		protected boolean isResizable() {
			return true;
		}

		@Override
		protected Control createDialogArea(Composite parent) {
			Composite group = (Composite) super.createDialogArea(parent);
			GridLayout layout = new GridLayout();
			layout.numColumns = 2;
			group.setLayout(layout);

			Label label = new Label(group, SWT.NONE);
			label.setText("Wiki SimRel folder");

			text = new Text(group, SWT.SINGLE | SWT.BORDER);
			text.setLayoutData(GridDataFactory.fillDefaults().grab(true, false).create());
			String folder = REPORT_DIALOG_SETTINGS.get("target");
			if (folder != null) {
				text.setText(folder);
			}
			return dialogArea;
		}

		@Override
		protected void okPressed() {
			REPORT_DIALOG_SETTINGS.put("target", text.getText());
			super.okPressed();
		}

		public String getFolder() {
			return REPORT_DIALOG_SETTINGS.get("target");
		}
	}
}
