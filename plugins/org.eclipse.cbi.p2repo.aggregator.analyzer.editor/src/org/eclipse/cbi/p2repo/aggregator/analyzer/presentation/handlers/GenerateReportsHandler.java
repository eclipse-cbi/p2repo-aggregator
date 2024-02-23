/**
 * Copyright (c) 2024 Eclipse contributors and others.
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
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HexFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository;
import org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Project;
import org.eclipse.cbi.p2repo.aggregator.analyzer.presentation.AggregationAnalyzerEditorPlugin;
import org.eclipse.cbi.p2repo.aggregator.analyzer.presentation.AnalyzerEditor;
import org.eclipse.cbi.p2repo.aggregator.analyzer.presentation.handlers.LastModifiedHandler.LastModifiedUpdater;
import org.eclipse.cbi.p2repo.aggregator.analyzer.util.AnalyzerUtil;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.ui.ImageURIRegistry;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.ui.provider.ExtendedImageRegistry;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.DialogSettings;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.PlatformUI;

public class GenerateReportsHandler extends BaseHandler {

	@Override
	protected Activity createActivity(Analysis analysis) {
		return new Generator(analysis);
	}

	private static class Generator extends Activity {
		private final Map<Image, String> images = new HashMap<>();
		private final Analysis analysis;
		private final LastModifiedUpdater lastModifiedUpdater;
		private final AdapterFactoryEditingDomain editingDomain;
		private final URIConverter uriConverter;
		private final AnalyzerEditor analyzerEditor;

		private URI reportRootURI;

		public Generator(Analysis analysis) {
			editingDomain = (AdapterFactoryEditingDomain) AdapterFactoryEditingDomain.getEditingDomainFor(analysis);
			reportRootURI = editingDomain.getResourceSet().getResources().get(0).getURI().trimSegments(1);
			uriConverter = editingDomain.getResourceSet().getURIConverter();
			this.analysis = analysis;
			lastModifiedUpdater = new LastModifiedUpdater(analysis);

			IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getActiveEditor();
			if (activeEditor instanceof AnalyzerEditor) {
				analyzerEditor = (AnalyzerEditor) activeEditor;
			} else {
				analyzerEditor = null;
			}
		}

		@Override
		public void perform(Shell shell) {
			ReportsDialog reportsDialog = new ReportsDialog(shell);
			reportsDialog.setBlockOnOpen(true);
			if (reportsDialog.open() == Window.OK) {
				reportRootURI = URI.createPlatformResourceURI(reportsDialog.getFolder(), true);
				super.perform(shell);
			}
		}

		@Override
		protected void perform(IProgressMonitor monitor) throws Exception {
			SubMonitor subMonitor = SubMonitor.convert(monitor, 100);
			lastModifiedUpdater.perform(subMonitor.split(90));
			generateReport();
		}

		private String getImage(Object object) {
			IItemLabelProvider labelProvider = (IItemLabelProvider) ((AdapterFactoryEditingDomain) editingDomain)
					.getAdapterFactory().adapt(object, IItemLabelProvider.class);
			Image image = ExtendedImageRegistry.getInstance().getImage(labelProvider.getImage(object));
			String name = images.get(image);
			if (name == null) {
				URI imageURI = ImageURIRegistry.INSTANCE.getImageURI(ExtendedImageRegistry.INSTANCE.getImage(image));
				try (InputStream in = uriConverter.createInputStream(imageURI)) {
					byte[] bytes = in.readAllBytes();
					MessageDigest digester = MessageDigest.getInstance("SHA-1");
					byte[] digest = digester.digest(bytes);
					name = "report-" + HexFormat.of().formatHex(digest, 0, 8) + "." + imageURI.fileExtension();
					images.put(image, name);
					try (OutputStream out = uriConverter.createOutputStream(reportRootURI.appendSegment(name))) {
						out.write(bytes);
					}
				} catch (IOException | NoSuchAlgorithmException ex) {
					AggregationAnalyzerEditorPlugin.INSTANCE.log(ex);
				}
			}

			return "![](" + name + ") ";
		}

		private void generateReport() {
			URI reportURI = reportRootURI.appendSegment("report.md");
			URI plainReportURI = AnalyzerUtil.getGitRepositoryURI(reportURI).getPlainURI();
			try (PrintStream out = new PrintStream(uriConverter.createOutputStream(reportURI), true,
					StandardCharsets.UTF_8)) {

				Map<String, String> anchors = new HashMap<>();
				List<ContributionAnalysis> contributions = new ArrayList<>(analysis.getContributions());
				for (ContributionAnalysis contributionAnalysis : contributions) {
					String label = contributionAnalysis.getLabel();
					String anchor = label.replace(' ', '-').replaceAll("[.():,]", "").toLowerCase();
					int rank = contributionAnalysis.getRank();
					if (rank != 0) {
						anchor += "--" + rank;
					}
					anchors.put(label, anchor);
				}

				if (analyzerEditor != null) {
					URI reportSVGURI = reportRootURI.appendSegment("report.svg");
					String svg = analyzerEditor.getEditorSite().getShell().getDisplay()
							.syncCall(() -> analyzerEditor.getDependenciesSVG());
					Pattern NODE_PATTERN = Pattern.compile("<text.*?>(.*?)\u200b.*?</text.*?>", Pattern.DOTALL);

					Matcher matcher = NODE_PATTERN.matcher(svg);
					StringBuilder linkifiedSVG = new StringBuilder();
					while (matcher.find()) {
						String label = matcher.group(1);
						String anchor = anchors.get(label);
						matcher.appendReplacement(linkifiedSVG, Matcher.quoteReplacement(
								"<a xlink:href= '" + plainReportURI + "#-" + anchor + "'>" + matcher.group() + "</a>"));
					}
					matcher.appendTail(linkifiedSVG);

					try (PrintStream svgOut = new PrintStream(uriConverter.createOutputStream(reportSVGURI), true,
							StandardCharsets.UTF_8)) {
						svgOut.println(linkifiedSVG);
					} catch (IOException ex) {
						AggregationAnalyzerEditorPlugin.INSTANCE.log(ex);
					}

					URI rawURI = AnalyzerUtil.getGitRepositoryURI(reportSVGURI).getRawURI();
					if (rawURI != null) {
						out.println("![](" + rawURI + ")");
					} else {
						out.println("![](report.svg)");
					}
				}

				Collections.sort(contributions, AnalyzerUtil.CONTRIBUTION_ANALYSIS_COMPARATOR_WITH_RANK);

				out.println("# Contributing Projects and Git Repositories");
				out.println();

				for (ContributionAnalysis contributionAnalysis : contributions) {
					List<Project> projects = contributionAnalysis.getProjects();
					if (isEnabled(contributionAnalysis)) {
						out.print("## ");
						out.print(getImage(contributionAnalysis));
						out.print(contributionAnalysis.getLabel());
						int rank = contributionAnalysis.getRank();
						if (rank != 0) {
							out.print(" \u2B50 ");
							out.print(rank);
						}
						out.println();

						if (!projects.isEmpty()) {
							for (Project project : projects) {
								printGitRepositories(out, "", project);
								out.println();
							}
							out.println("##");
						}

						Contribution contribution = contributionAnalysis.getContribution();
						if (contribution != null) {
							EList<MappedRepository> repositories = contribution.getRepositories(true);
							if (!repositories.isEmpty()) {
								out.print(" - ");
								out.print(getImage(contribution));
								URI uri = getBlobURI(contribution);
								out.print("[");
								out.print(String.join("/", uri.segmentsList()) + " - "
										+ uri.trimSegments(uri.segmentCount()));
								out.print("](");
								out.print(uri);
								out.print(")");
								Float ageInDays = AnalyzerUtil.getAgeInDays(contributionAnalysis);
								if (ageInDays != null) {
									out.print(" - ");
									out.printf("%.0f", ageInDays);
								}
								out.println();

								for (MappedRepository mappedRepository : repositories) {
									URI resolvedLocation = URI.createURI(mappedRepository.getResolvedLocation());
									out.print("   - ");
									out.print(getImage(mappedRepository));
									out.print("[");
									out.print(String.join("/", resolvedLocation.segmentsList()) + " - "
											+ resolvedLocation.trimSegments(resolvedLocation.segmentCount()));
									out.print("](");
									out.print(resolvedLocation);
									out.print(")");

									SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
									List<IInstallableUnit> installableUnits = contributionAnalysis.getInstallableUnits()
											.stream().map(InstallableUnitAnalysis::getInstallableUnit).toList();
									Pattern DATE_PATTERN = Pattern.compile("(2[01][0-9][0-9][01][0-9][0-3][0-9])");
									Date newestDate = null;

									MetadataRepository metadataRepository = mappedRepository.getMetadataRepository();
									Set<IInstallableUnit> ius = metadataRepository
											.query(QueryUtil.createIUAnyQuery(), null).toSet();
									for (IInstallableUnit iu : ius) {
										if (installableUnits.contains(iu)) {
											Version version = iu.getVersion();
											if (version.getSegmentCount() >= 3) {
												String qualifier = version.getSegment(3).toString();
												Matcher matcher = DATE_PATTERN.matcher(qualifier);
												if (matcher.find()) {
													try {
														Date date = simpleDateFormat.parse(matcher.group(1));
														if (newestDate == null || newestDate.compareTo(date) < 0) {
															newestDate = date;
														}
													} catch (Exception ex) {
														AggregationAnalyzerEditorPlugin.INSTANCE.log(ex);
													}
												}
											}
										}
									}

									if (newestDate == null) {
										String timestamp = metadataRepository.getProperty("p2.timestamp");
										if (timestamp != null) {
											newestDate = new Date(Long.parseLong(timestamp));
										}
									}

									if (newestDate != null) {
										out.print(" - ");
										out.printf("%.0f", AnalyzerUtil.getAgeInDays(newestDate.getTime()));
									}

									out.println();
								}
								out.println();
								out.println("##");
							}
						}
					}
				}

				if (Boolean.FALSE)
					for (ContributionAnalysis contributionAnalysis : contributions) {
						Contribution contribution = contributionAnalysis.getContribution();
						if (contribution != null && contribution.isEnabled()) {
							EList<MappedRepository> repositories = contribution.getRepositories(true);
							if (!repositories.isEmpty()) {
								out.print(getImage(contributionAnalysis));
								out.print(contributionAnalysis.getLabel());
								out.println();

								for (MappedRepository mappedRepository : repositories) {
									URI resolvedLocation = URI.createURI(mappedRepository.getResolvedLocation());
									out.print("- ");
									out.print(getImage(mappedRepository));
									out.print("[");
									out.print(String.join("/", resolvedLocation.segmentsList()) + " - "
											+ resolvedLocation.trimSegments(resolvedLocation.segmentCount()));
									out.print("](");
									out.print(resolvedLocation);
									out.print(")");

									SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
									Pattern DATE_PATTERN = Pattern.compile("(2[01][0-9][0-9][01][0-9][0-3][0-9])");
									Date newestDate = null;

									MetadataRepository metadataRepository = mappedRepository.getMetadataRepository();
									Set<IInstallableUnit> ius = metadataRepository
											.query(QueryUtil.createIUAnyQuery(), null).toSet();
									for (IInstallableUnit iu : ius) {
										Version version = iu.getVersion();
										if (version.getSegmentCount() >= 3) {
											String qualifier = version.getSegment(3).toString();
											Matcher matcher = DATE_PATTERN.matcher(qualifier);
											if (matcher.find()) {
												try {
													Date date = simpleDateFormat.parse(matcher.group(1));
													if (newestDate == null || newestDate.compareTo(date) < 0) {
														newestDate = date;
													}
												} catch (Exception ex) {
													AggregationAnalyzerEditorPlugin.INSTANCE.log(ex);
												}
											}
										}
									}

									if (newestDate == null) {
										String timestamp = metadataRepository.getProperty("p2.timestamp");
										if (timestamp != null) {
											newestDate = new Date(Long.parseLong(timestamp));
										}
									}

									if (newestDate != null) {
										out.print(" - ");
										out.printf("%.0f", AnalyzerUtil.getAgeInDays(newestDate.getTime()));
									}

									out.println();
								}

								out.println();
							}
						}
					}
			} catch (IOException ex) {
				AggregationAnalyzerEditorPlugin.INSTANCE.log(ex);
			}
		}

		private URI getBlobURI(Contribution contribution) {
			Resource eResource = ((EObject) contribution).eResource();
			if (eResource != null) {
				URI uri = eResource.getURI();
				AnalyzerUtil.Repo gitRepositoryURI = AnalyzerUtil.getGitRepositoryURI(uri);
				if (gitRepositoryURI != null) {
					return gitRepositoryURI.getPlainURI();
				}

				return uri;
			}

			return null;
		}

		private boolean isEnabled(ContributionAnalysis contributionAnalysis) {
			Contribution contribution = contributionAnalysis.getContribution();
			if (contribution == null) {
				// return !contributionAnalysis.getProjects().isEmpty();
				return true;
			}
			if (!contribution.isEnabled()) {
				return false;
			}
			return !contribution.getRepositories(true).isEmpty();
		}

		private void printGitRepositories(PrintStream out, String indent, Project project) {
			String name = project.getName();
			out.print(indent);
			out.print("- ");
			out.print(getImage(project));
			printLink(out, name, project.getSite());

			int rank = project.getRank();
			if (rank != 0) {
				out.print(" \u2B50 ");
				out.print(rank);
			}

			Date releaseDate = project.getReleaseDate();
			URI version = project.getVersion();
			if (version != null) {
				version.lastSegment();
				out.print(" ");
				printLink(out, version.lastSegment(), version);
			}

			if (releaseDate != null) {
				out.print(" ");
				out.print(new SimpleDateFormat("yyyy-MM-dd").format(releaseDate));
			}

			out.println();

			String nestedIndent = indent + "    ";

			EList<GitRepository> repositories = project.getRepositories();
			for (GitRepository repository : repositories) {
				URI uri = repository.getURI();
				String lastSegment = uri.lastSegment();
				String label = lastSegment != null ? lastSegment + " - " + uri.trimSegments(1) : uri.toString();

				Matcher matcher = Pattern.compile("(https://git.eclipse.org/)r(/.*)").matcher(uri.toString());
				if (matcher.matches()) {
					uri = URI.createURI(matcher.group(1) + "c" + matcher.group(2) + ".git");
				}

				out.print(nestedIndent);
				out.print("- ");
				out.print(getImage(repository));
				printLink(out, label, uri);

				Float ageInDays = AnalyzerUtil.getAgeInDays(repository);
				if (ageInDays != null) {
					out.print(" - ");
					out.printf("%.0f", ageInDays);
				}

				out.println();
			}

			for (Project nestedProject : project.getSubprojects()) {
				printGitRepositories(out, nestedIndent, nestedProject);
			}
		}

		private void printLink(PrintStream out, String label, URI uri) {
			out.print("[");
			out.print(label);
			out.print("](");
			out.print(uri);
			out.print(")");
		}

	}

	private static class ReportsDialog extends Dialog {
		private static final IDialogSettings REPORT_DIALOG_SETTINGS = DialogSettings
				.getOrCreateSection(AggregationAnalyzerEditorPlugin.getPlugin().getDialogSettings(), "report");

		private Text text;

		public ReportsDialog(Shell parentShell) {
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
			label.setText("Report Folder");

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
			REPORT_DIALOG_SETTINGS.put("target", getFolder());
			super.okPressed();
		}

		public String getFolder() {
			return REPORT_DIALOG_SETTINGS.get("target");
		}
	}

}
