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
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerFactory;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Project;
import org.eclipse.cbi.p2repo.aggregator.analyzer.presentation.AggregationAnalyzerEditorPlugin;
import org.eclipse.cbi.p2repo.aggregator.analyzer.util.AnalyzerUtil;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.command.CommandStack;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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
			EList<String> gitRepositoryFilters = analysis.getGitRepositoryFilters();
			projectMapper = new ProjectMapper(analysis.getReleaseDate(),
					gitRepositoryFilters.isEmpty() ? null : Pattern.compile(String.join("|", gitRepositoryFilters)));
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
						EList<Project> oldProjects = entry.getKey().getProjects();
						List<Project> newProjects = entry.getValue();
						if (!EcoreUtil.equals(oldProjects, newProjects)) {
							reconcile(oldProjects, newProjects);
							ECollections.setEList(oldProjects, newProjects);
						}
					}
				}

				private void reconcile(List<Project> oldProjects, List<Project> newProjects) {
					Map<String, EList<String>> tags = new HashMap<>();
					for (Iterator<EObject> it = EcoreUtil.getAllContents(oldProjects); it.hasNext();) {
						EObject eObject = it.next();
						if (eObject instanceof Project project) {
							tags.put(project.getName(), project.getTags());
						}
					}
					for (Iterator<EObject> it = EcoreUtil.getAllContents(newProjects); it.hasNext();) {
						EObject eObject = it.next();
						if (eObject instanceof Project project) {
							EList<String> projectTags = tags.get(project.getName());
							if (projectTags != null) {
								project.getTags().addAll(projectTags);
							}
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
			if (Boolean.FALSE) {
				compareWithOfficialList(projectLinks);
			}

			update(projectLinks);
			return projectLinks;
		}

		private void update(Map<ContributionAnalysis, List<Project>> projectLinks) {
			String csv = System.getProperty(
					"org.eclipse.cbi.p2repo.aggregator.analyzer.presentation.handlers.ProjectReconcilerHandler.csv");

			Map<URI, List<Project>> sitesToProjects = new LinkedHashMap<>();
			for (List<Project> projects : projectLinks.values()) {
				for (TreeIterator<Object> allContents = EcoreUtil.getAllContents(projects); allContents.hasNext();) {
					Object content = allContents.next();
					if (content instanceof Project project) {
						sitesToProjects.computeIfAbsent(project.getSite(), it -> new ArrayList<>()).add(project);
					}
				}
			}

			if (csv != null) {
				try {
					List<String> lines = Files.readAllLines(Path.of(csv));
					for (String line : lines) {
						String[] parts = line.split(";", -1);
						String url = parts[1];
						if (url.startsWith("https:")) {
							int rank = Integer.valueOf(parts[parts.length - 1]);
							URI uri = URI.createURI(url);
							List<Project> projects = sitesToProjects.get(uri);
							if (projects != null && !projects.isEmpty()) {
								for (Project project : projects) {
									project.setRank(rank);
								}
							}
						}
					}
				} catch (Exception ex) {
					AggregationAnalyzerEditorPlugin.INSTANCE.log(ex);
				}
			}
		}

		private void compareWithOfficialList(Map<ContributionAnalysis, List<Project>> projectLinks) {
			Set<String> projectIDs = new TreeSet<>(CommonPlugin.INSTANCE.getComparator());

			Map<String, Project> projects = new TreeMap<>(CommonPlugin.INSTANCE.getComparator());
			Map<String, String> projectVersions = new TreeMap<>(CommonPlugin.INSTANCE.getComparator());
			Map<String, Date> projectDates = new TreeMap<>(CommonPlugin.INSTANCE.getComparator());
			Map<String, String> projectNameIDs = new TreeMap<>(CommonPlugin.INSTANCE.getComparator());
			for (Map.Entry<ContributionAnalysis, List<Project>> entry : projectLinks.entrySet()) {
				Contribution contribution = entry.getKey().getContribution();
				if (contribution == null || contribution.isEnabled()) {
					for (Project project : entry.getValue()) {
						URI version = project.getVersion();
						String projectID = project.getSite().lastSegment();
						String projectName = project.getName();

						projects.put(projectName, project);
						projectIDs.add(projectID);
						projectNameIDs.put(projectName, projectID);
						projectVersions.put(projectName, version == null ? null : version.lastSegment());
						projectDates.put(projectName, project.getReleaseDate());
					}
				}
			}

			System.out.println("-----------------------------");
			for (Map.Entry<String, String> entry : projectVersions.entrySet()) {
				Date releaseDate = projectDates.get(entry.getKey());
				String date = releaseDate == null ? "" : " " + AnalyzerUtil.format(releaseDate);
				System.out.println(entry.getKey() + " -> " + entry.getValue() + date);
			}

			System.out.println("-----------------------------");
			for (Map.Entry<String, String> entry : projectVersions.entrySet()) {
				Date releaseDate = projectDates.get(entry.getKey());
				String date = releaseDate == null ? "" : " " + AnalyzerUtil.format(releaseDate);
				System.out.println(entry.getKey() + " -> https://projects.eclipse.org/projects/"
						+ projectNameIDs.get(entry.getKey()) + "/releases/" + entry.getValue() + date);
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
						URI.createURI(ProjectMapper.ECLIPSE_PROJECT_PORTAL_HOST + "releases/2023-09"));
				Pattern projectPattern = Pattern
						.compile("<a href=\"/projects/([^\"]+)\">([^<]+)</a></td><td><a href=\"([^\"]+)\">[^<]+</a>");
				for (Matcher matcher = projectPattern.matcher(content); matcher.find();) {
					String group2 = matcher.group(2).trim().replace("\u2122", "");
					String group3 = matcher.group(3);
					projectsWayne.put(group2, URI.createURI(group3).lastSegment());
				}
			} catch (IOException ex) {
				AggregationAnalyzerEditorPlugin.INSTANCE.log(ex);
			}

			System.out.println("-----------------------------");

			for (Map.Entry<String, String> project : projectVersions.entrySet()) {
				if (project.getKey() != null) {
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
			}

			for (String project : projectsWayne.keySet()) {
				if (!projectVersions.containsKey(project)) {
					System.out.println("-- " + project);
				}
			}

			System.out.println("-----------------------------");
			for (Project project : projects.values()) {
				Date releaseDate = project.getReleaseDate();
				URI site = project.getSite();
				URI version = project.getVersion();
				System.out.print(" - [" + project.getName() + "](" + site + "/releases)");
				if (version != null) {
					System.out.print(" \u2022 [**" + version.lastSegment() + "**](" + version + ")");
					if (releaseDate != null) {
						String date = AnalyzerUtil.format(releaseDate);
						if (AnalyzerUtil.getAgeInDays(releaseDate.getTime(), projectMapper.versionCutoffTime) > 90) {
							date = "~~" + date + "~~";
						}
						System.out.print(" \u2022 " + date);
					}
				}
				System.out.println();
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

				Map<String, Integer> projectIDs = getProjectIDs(contributionAnalysis);
				String label = contributionAnalysis.getLabel();
				Predicate<String> filter = new Predicate<String>() {
					private final Pattern pattern = Pattern.compile(
							".*:webtools.java-ee-config|.*:webtools\\.releng|.*:eclipse\\.jdt\\.ls|Web Tools Platform:tools.oomph|.*To-Be-Deleted.*");

					@Override
					public boolean test(String projectID) {
						return pattern.matcher(label + ":" + projectID).matches();
					}
				};

				Set<String> rootProjectIDs = new LinkedHashSet<>(projectIDs.keySet());
				getProjectIDs(projectIDs, contributionAnalysis.getAllProjects());

				for (String projectID : rootProjectIDs) {
					if (!filter.test(projectID)) {
						projects.add(createProject(filter, projectID, projectIDs, true));
					}
				}
			}

			return result;
		}

		private Project createProject(Predicate<String> filter, String projectID, Map<String, Integer> projectIDs,
				boolean root) throws IOException {
			Project project = AnalyzerFactory.eINSTANCE.createProject();
			Integer rank = projectIDs.get(projectID);
			project.setRank(rank == null ? 0 : rank);
			project.setSite(URI.createURI(ProjectMapper.ECLIPSE_PROJECT_PORTAL + projectID));
			project.setName(projectMapper.getProjectName(projectID));

			if (root) {
				String latestReleaseURL = projectMapper.getLatestReleaseInfo(String.class, projectID);
				if (latestReleaseURL != null) {
					project.setVersion(URI.createURI(latestReleaseURL));
					Date date = projectMapper.getLatestReleaseInfo(Date.class, projectID);
					if (date != null) {
						project.setReleaseDate(date);
					}
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
					if (!filter.test(subprojectID)) {
						subprojects.add(createProject(filter, subprojectID, projectIDs, false));
					}
				}
			}

			return project;
		}

		private Map<String, Integer> getProjectIDs(ContributionAnalysis contributionAnalysis) {
			Map<String, Integer> projects = new TreeMap<>();
			Contribution contribution = contributionAnalysis.getContribution();
			if (contribution != null) {
				for (MappedRepository mappedRepository : contribution.getRepositories(false)) {
					String resolvedLocation = mappedRepository.getResolvedLocation();
					String projectID = projectMapper.getProjectID(URI.createURI(resolvedLocation));
					if (projectID == null) {
						System.out.println("Not found: " + resolvedLocation);
					} else {
						projects.put(projectID, null);
					}
				}
			}

			getProjectIDs(projects, contributionAnalysis.getProjects());

			return projects;
		}

		private void getProjectIDs(Map<String, Integer> projectIDs, List<Project> projects) {
			for (Project project : projects) {
				URI site = project.getSite();
				if (site.toString().startsWith(ProjectMapper.ECLIPSE_PROJECT_PORTAL)) {
					String projectID = site.lastSegment();
					if (projectMapper.getProjectName(projectID) != null) {
						projectIDs.put(projectID, project.getRank());
					}
				}
			}
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

		private Pattern gitRepositoryPattern;

		public ProjectMapper(Date releaseDate, Pattern gitRepositoryPattern) throws IOException {

			this.gitRepositoryPattern = gitRepositoryPattern;
			if (releaseDate == null) {
				long now = System.currentTimeMillis();
				// Three months from now.
				versionCutoffTime = now + 1000L * 60L * 60L * 24L * 30L * 3L;
			} else {
				// Plus one day for time zone differences.
				versionCutoffTime = releaseDate.getTime() + 1000L * 60L * 60L * 24L;
			}

			String mappings = getContent(MAPPINGS);
			mappings += "tools/ptp/\ttools.ptp\n";
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
			projects += "tools.ptp\tEclipse Parallel Tools Platform (PTP)\n";
			for (String line : projects.split("\r?\n")) {
				int tab = line.indexOf('\t');
				if (tab != -1) {
					String id = line.substring(0, tab);
					if (!id.endsWith(".incubator")) {
						String name = line.substring(tab + 1);
						this.projects.put(id, name.replace("\\", ""));
					}
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

			String github = getGroup("github", content);
			if (github != null) {
				Set<String> orgs = getValues("org", github);
				for (String org : orgs) {
					for (int i = 1; i < 10; i++) {
						String repos = getContent(
								URI.createURI("https://api.github.com/orgs/" + org + "/repos?page=" + i));
						List<String> urls = getFilteredValues("clone_url", "archived", repos).stream()
								.map(it -> it.replaceAll(".git$", "")).collect(Collectors.toList());
						if (urls.isEmpty()) {
							break;
						}
						result.addAll(urls);
					}
				}
			}

			String githubRepos = getSection("github_repos", content);
			if (githubRepos != null) {
				result.addAll(getValues("url", githubRepos));
			}

			cleanupRepos(projectID, result);

			if (result.isEmpty()) {
				String gerritRepos = getSection("gerrit_repos", content);
				if (gerritRepos != null) {
					result.addAll(getValues("url", gerritRepos));
					cleanupRepos(projectID, result);
				}
			}

			String gitlab = getGroup("gitlab", content);
			if (gitlab != null) {
				Set<String> groups = getValues("project_group", gitlab);
				for (String group : groups) {
					for (int i = 1; i < 10; i++) {
						String repos = getContent(URI.createURI("https://gitlab.eclipse.org/api/v4/groups/"
								+ group.replace("\\", "").replace("/", "%2f") + "?page=" + i));
						Set<String> urls = getValues("http_url_to_repo", repos);
						if (!result.addAll(
								urls.stream().map(it -> it.replaceAll("\\.git$", "")).collect(Collectors.toList()))) {
							break;
						}
					}
				}
			}

			String gitlabRepos = getSection("gitlab_repos", content);
			if (githubRepos != null) {
				result.addAll(getValues("url", gitlabRepos).stream().map(it -> it.replaceAll("\\.git$", ""))
						.collect(Collectors.toList()));
				cleanupRepos(projectID, result);
			}

			return result;
		}

		private void cleanupRepos(String projectID, Set<String> repos) {
			if (gitRepositoryPattern != null) {
				repos.removeIf(it -> gitRepositoryPattern.matcher(projectID + ":" + it).matches());
			}
		}

		public <T> T getLatestReleaseInfo(Class<T> type, String projectID) throws IOException {
			String content = getPMIContent(projectID);
			String releases = getSection("releases", content);
			if (releases != null) {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Map<String, String> values = getValues("url", "date", releases);
				for (Map.Entry<String, String> release : values.entrySet()) {
					String releaseURI = release.getKey();
					try {
						Date dateValue = simpleDateFormat.parse(release.getValue());
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
							System.out.println("-- " + projectID + " -> " + releaseURI + " -> " + release.getValue()
									+ " > " + simpleDateFormat.format(new Date(versionCutoffTime)));
						}
					} catch (ParseException e) {
						throw new IOException(e);
					}
				}
			}
			return null;
		}

		private String getGroup(String key, String content) {
			// {{
			Pattern pattern = Pattern.compile('"' + key + "\":\\{([^}]*)\\}"); // }
			Matcher matcher = pattern.matcher(content);
			if (matcher.find()) {
				return matcher.group(1);
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

		private Set<String> getFilteredValues(String key, String booleanKey, String content) {
			Set<String> result = new LinkedHashSet<>();
			Matcher matcher1 = Pattern.compile('"' + key + "\":\"([^\"]+)\"").matcher(content);
			Matcher matcher2 = Pattern.compile('"' + booleanKey + "\":(true|false)").matcher(content);
			while (matcher1.find() && matcher2.find()) {
				if ("false".equals(matcher2.group(1))) {
					result.add(matcher1.group(1).replace("\\", ""));
				}
			}
			return result;
		}

		private Set<String> getValues(String key, String content) {
			Set<String> result = new LinkedHashSet<>();
			Matcher matcher = Pattern.compile('"' + key + "\":\"([^\"]+)\"").matcher(content);
			while (matcher.find()) {
				result.add(matcher.group(1).replace("\\", ""));
			}
			return result;
		}

		private Map<String, String> getValues(String key, String value, String content) {
			Map<String, String> result = new LinkedHashMap<>();
			// {
			Matcher matcher = Pattern.compile('"' + key + "\":\"([^\"]+)\"" + "[^}]*" + '"' + value + "\":\"([^\"]+)\"")
					.matcher(content);
			while (matcher.find()) {
				result.put(matcher.group(1).replace("\\", ""), matcher.group(2).replace("\\", ""));
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
