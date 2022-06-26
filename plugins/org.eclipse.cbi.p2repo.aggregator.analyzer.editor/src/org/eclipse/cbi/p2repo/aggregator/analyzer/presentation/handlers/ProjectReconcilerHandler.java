/**
 * Copyright (c) 2022 Eclipse contributors and others.
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerFactory;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Project;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.impl.URIMappingRegistryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.swt.widgets.Shell;

public class ProjectReconcilerHandler extends BaseHandler {

	@Override
	protected Activity createActivity(Analysis analysis) {
		return new Reconciler(analysis);
	}

	private static class Reconciler extends Activity {

		private final Analysis analysis;

		ProjectMapper projectMapper;

		private Map<ContributionAnalysis, List<Project>> projects;

		public Reconciler(Analysis analysis) {
			this.analysis = analysis;
		}

		@Override
		public void perform(Shell shell) {
			checkStaleCache(shell);
			super.perform(shell);
		}

		@Override
		protected void perform(IProgressMonitor monitor) throws Exception {
			projectMapper = new ProjectMapper(analysis.getReleaseDate());
			projects = reconcile(monitor);
		}

		@Override
		protected void asyncExec() {
			EditingDomain editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(analysis);
			CommandStack commandStack = editingDomain.getCommandStack();
			class ProjectReconcileCommand extends ChangeCommand {
				private ProjectReconcileCommand(Collection<Notifier> notifiers) {
					super(notifiers);
				}

				@Override
				protected void doExecute() {
					for (Map.Entry<ContributionAnalysis, List<Project>> entry : projects.entrySet()) {
						if (!EcoreUtil.equals(entry.getKey().getProjects(), entry.getValue())) {
							ECollections.setEList(entry.getKey().getProjects(), entry.getValue());
						}
					}
				}

				public String getLabel() {
					return "Reconcile Projects";
				}

				public boolean hasChanges() {
					return changeDescription != null && !changeDescription.getObjectChanges().isEmpty();
				}
			}

			ProjectReconcileCommand reconcileCommand = new ProjectReconcileCommand(List.of(analysis));
			commandStack.execute(reconcileCommand);

			// If the reconcile operation produced no changes, the command is a no-op so we can remove it from the command stack.
			// This way the resource is only dirty if it's actually been reconciled in a way that changes the structure.
			if (!reconcileCommand.hasChanges()) {
				commandStack.undo();
			}
		}

		public Map<ContributionAnalysis, List<Project>> reconcile(IProgressMonitor monitor) throws Exception {
			Map<ContributionAnalysis, List<Project>> projectLinks = computeProjectLinks(monitor, analysis);
			compareWithOfficialList(projectLinks);
			return projectLinks;
		}

		private void compareWithOfficialList(Map<ContributionAnalysis, List<Project>> projectLinks) {
			Set<String> projectIDs = new TreeSet<>(CommonPlugin.INSTANCE.getComparator());

			Map<String, String> projectVersions = new TreeMap<>(CommonPlugin.INSTANCE.getComparator());
			for (Map.Entry<ContributionAnalysis, List<Project>> entry : projectLinks.entrySet()) {
				Contribution contribution = entry.getKey().getContribution();
				if (contribution == null || contribution.isEnabled()) {
					for (Project project : entry.getValue()) {
						URI version = project.getVersion();
						projectIDs.add(project.getSite().lastSegment());
						projectVersions.put(project.getName(), version == null ? null : version.lastSegment());
					}
				}
			}

			System.out.println("-----------------------------");
			for (Map.Entry<String, String> entry : projectVersions.entrySet()) {
				System.out.println(entry.getKey() + " -> " + entry.getValue());
			}

			if (Boolean.FALSE) {
				// If Wayne asks for a list of IDs, this can be enabled.
				System.out.println("-----------------------------");
				for (String project : projectIDs) {
					System.out.println(project);
				}
			}

			Map<String, String> projectsWayne = new TreeMap<>();
			try {
				String content = getContent(
						URI.createURI(ProjectMapper.ECLIPSE_PROJECT_PORTAL_HOST + "releases/2022-06"));
				Pattern projectPattern = Pattern
						.compile("<a href=\"/projects/([^\"]+)\">([^<]+)</a></td><td><a href=\"([^\"]+)\">[^<]+</a>");
				for (Matcher matcher = projectPattern.matcher(content); matcher.find();) {
					String group2 = matcher.group(2).trim().replace("\u2122", "");
					String group3 = matcher.group(3);
					projectsWayne.put(group2, URI.createURI(group3).lastSegment());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

			System.out.println("-----------------------------");

			for (Map.Entry<String, String> project : projectVersions.entrySet()) {
				if (!projectsWayne.containsKey(project.getKey())) {
					System.out.println("++ " + project);
				} else {
					String value1 = project.getValue();
					String value2 = projectsWayne.get(project.getKey());
					if (!Objects.equals(value1, value2)) {
						System.out.println("?? " + project.getKey() + " " + value1 + " != " + value2);
					}
				}
			}

			for (String project : projectsWayne.keySet()) {
				if (!projectVersions.containsKey(project)) {
					System.out.println("-- " + project);
				}
			}
		}

		private Map<ContributionAnalysis, List<Project>> computeProjectLinks(IProgressMonitor monitor,
				Analysis analysis) throws Exception {
			Map<ContributionAnalysis, List<Project>> result = new LinkedHashMap<>();
			EList<ContributionAnalysis> contributions = analysis.getContributions();
			SubMonitor subMonitor = SubMonitor.convert(monitor, "Analyzing", contributions.size());
			for (ContributionAnalysis contributionAnalysis : contributions) {
				List<Project> projects = new ArrayList<>();
				result.put(contributionAnalysis, projects);

				SubMonitor projectSubMonitor = subMonitor.newChild(1);
				projectSubMonitor.subTask(contributionAnalysis.getLabel());

				Set<String> projectIDs = getProjectIDs(contributionAnalysis);
				for (String projectID : projectIDs) {
					projects.add(createProject(projectID));
				}
			}

			return result;
		}

		private Project createProject(String projectID) throws IOException {

			Project project = AnalyzerFactory.eINSTANCE.createProject();
			project.setSite(URI.createURI(ProjectMapper.ECLIPSE_PROJECT_PORTAL + projectID));
			project.setName(projectMapper.getProjectName(projectID));

			String latestReleaseURL = projectMapper.getLatestReleaseInfo(String.class, projectID);
			if (latestReleaseURL != null) {
				project.setVersion(URI.createURI(latestReleaseURL));
				Date date = projectMapper.getLatestReleaseInfo(Date.class, projectID);
				if (date != null) {
					project.setReleaseDate(date);
				}
			}

			EList<GitRepository> repositories = project.getRepositories();
			Set<String> repositoryURIs = projectMapper.getRepositories(projectID);
			for (String repositoryURI : repositoryURIs) {
				GitRepository gitRepository = AnalyzerFactory.eINSTANCE.createGitRepository();
				gitRepository.setURI(URI.createURI(repositoryURI));
				repositories.add(gitRepository);
			}

			if (!projectID.contains(".")) {
				EList<Project> subprojects = project.getSubprojects();
				Set<String> subprojectIDs = projectMapper.getSubprojects(projectID);
				for (String subprojectID : subprojectIDs) {
					subprojects.add(createProject(subprojectID));
				}
			}

			return project;
		}

		private Set<String> getProjectIDs(ContributionAnalysis contributionAnalysis) {
			Set<String> projects = new TreeSet<>();
			Contribution contribution = contributionAnalysis.getContribution();
			if (contribution != null) {
				for (MappedRepository mappedRepository : contribution.getRepositories(false)) {
					String resolvedLocation = mappedRepository.getResolvedLocation();
					String projectID = projectMapper.getProjectID(URI.createURI(resolvedLocation));
					if (projectID == null) {
						System.out.println("Not found: " + resolvedLocation);
					} else {
						projects.add(projectID);
					}
				}
			}

			for (Project project : contributionAnalysis.getProjects()) {
				URI site = project.getSite();
				if (site.toString().startsWith(ProjectMapper.ECLIPSE_PROJECT_PORTAL)) {
					String projectID = site.lastSegment();
					if (projectMapper.getProjectName(projectID) != null) {
						projects.add(projectID);
					}
				}
			}

			return projects;
		}
	}

	private static final class ProjectMapper {
		public static final String ECLIPSE_PROJECT_PORTAL_HOST = "https://projects.eclipse.org/";

		public static final String ECLIPSE_PROJECT_PORTAL = ECLIPSE_PROJECT_PORTAL_HOST + "projects/";

		private static final URI PROJECTS = URI
				.createURI("https://download.eclipse.org/oomph/archive/projects/projects.txt");

		private static final URI MAPPINGS = URI
				.createURI("https://download.eclipse.org/oomph/archive/projects/mappings.txt");

		private final URIMappingRegistryImpl registry = new URIMappingRegistryImpl();

		private final Map<String, String> pmiContent = new TreeMap<>();

		private final Map<String, String> projects = new TreeMap<>();

		private long versionCutoffTime;

		public ProjectMapper(Date releaseDate) throws IOException {

			if (releaseDate == null) {
				long now = System.currentTimeMillis();
				// Three months from now.
				versionCutoffTime = now + 1000L * 60L * 60L * 24L * 30L * 3L;
			} else {
				// Plus one day for time zone differences.
				versionCutoffTime = releaseDate.getTime() + 1000L * 60L * 60L * 24L;
			}

			String mappings = getContent(MAPPINGS);
			for (String line : mappings.split("\r?\n")) {
				int tab = line.indexOf('\t');
				String path = line.substring(0, tab);
				String project = line.substring(tab + 1);

				if ("webtools.releng".equals(project)) {
					project = "webtools";
				} else if ("eclipse.platform".equals(project)) {
					project = "eclipse";
				}

				URI projectURI = URI.createURI("project://" + project + "/");
				for (String host : new String[] { "https://download.eclipse.org", "https://archive.eclipse.org",
						"http://download.eclipse.org", "http://archive.eclipse.org" }) {
					registry.put(createURI(host, path), projectURI);
				}
			}

			String projects = getContent(PROJECTS);
			for (String line : projects.split("\r?\n")) {
				int tab = line.indexOf('\t');
				String id = line.substring(0, tab);
				if (!id.endsWith(".incubator")) {
					String name = line.substring(tab + 1);
					this.projects.put(id, name);
				}
			}
		}

		public String getProjectID(URI uri) {
			URI projectURI = registry.getURI(uri);
			if (projectURI != null && "project".equals(projectURI.scheme())) {
				return projectURI.authority();
			}

			return null;
		}

		public String getProjectName(String projectID) {
			return projects.get(projectID);
		}

		public Set<String> getRepositories(String projectID) throws IOException {
			Set<String> result = new TreeSet<>();
			String content = getPMIContent(projectID);
			String githubRepos = getSection("github_repos", content);
			if (githubRepos != null) {
				result.addAll(getValues("url", githubRepos));
			}

			String gitlabRepos = getSection("gitlab_repos", content);
			if (githubRepos != null) {
				result.addAll(getValues("url", gitlabRepos));
			}

			String gerritRepos = getSection("gerrit_repos", content);
			if (gerritRepos != null) {
				result.addAll(getValues("url", gerritRepos));
			}

			result.removeIf(
					it -> it.endsWith("/.github") || it.contains("www.eclipse.org") || it.endsWith(".incubator"));
			return result;
		}

		public <T> T getLatestReleaseInfo(Class<T> type, String projectID) throws IOException {
			String content = getPMIContent(projectID);
			String releases = getSection("releases", content);
			if (releases != null) {
				Set<String> values = getValues("url", releases);
				Pattern releasePattern = Pattern.compile(
						"<span[^>]+property=\"dc:date\"[^>]+datatype=\"xsd:dateTime\"[^>]+content=\"([^\"]+)\">");
				for (String releaseURI : values) {
					String releaseRecord = getContent(URI.createURI(releaseURI));
					Matcher matcher = releasePattern.matcher(releaseRecord);
					if (matcher.find()) {
						String date = matcher.group(1);
						try {
							SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");
							Date dateValue = simpleDateFormat.parse(date);

							long delta = versionCutoffTime - dateValue.getTime();
							if (delta > 0) {
								if (type.isInstance(releaseURI)) {
									return type.cast(releaseURI);
								}
								if (type.isInstance(dateValue)) {
									return type.cast(dateValue);
								}

								throw new IllegalArgumentException("Type " + type.getName() + " not expected");
							} else {
								// Release is after the cutoff date
								System.out.println("-- " + projectID + " -> " + releaseURI + " -> " + date + " > "
										+ simpleDateFormat.format(new Date(versionCutoffTime)));
							}
						} catch (ParseException e) {
							throw new IOException(e);
						}
					}
				}
			}
			return null;
		}

		private String getSection(String key, String content) {
			Pattern pattern = Pattern.compile('"' + key + "\":\\[([^]]*)\\]");
			Matcher matcher = pattern.matcher(content);
			if (matcher.find()) {
				return matcher.group(1);
			}
			return null;
		}

		private Set<String> getValues(String key, String content) {
			Set<String> result = new LinkedHashSet<>();
			Matcher matcher = Pattern.compile('"' + key + "\":\"([^\"]+)\"").matcher(content);
			while (matcher.find()) {
				result.add(matcher.group(1));
			}
			return result;
		}

		public Set<String> getSubprojects(String projectID) {
			Set<String> result = new LinkedHashSet<>();
			String prefix = projectID + '.';
			for (String otherProjectID : projects.keySet()) {
				if (otherProjectID.startsWith(prefix) && !otherProjectID.equals("eclipse.e4")) {
					result.add(otherProjectID);
				}
			}
			return result;
		}

		public String getPMIContent(String projectID) throws IOException {
			String result = pmiContent.get(projectID);
			if (result == null) {
				String pmiID = projectID.replace('.', '_');
				URI pmiURI = URI.createURI(ECLIPSE_PROJECT_PORTAL_HOST + "api/projects/" + pmiID);
				result = getContent(pmiURI);
				pmiContent.put(projectID, result);
			}
			return result;
		}

		private URI createURI(String baseURI, String path) {
			if (!path.endsWith("/")) {
				path += "/";
			}

			return URI.createURI(baseURI + "/" + path);
		}
	}
}
