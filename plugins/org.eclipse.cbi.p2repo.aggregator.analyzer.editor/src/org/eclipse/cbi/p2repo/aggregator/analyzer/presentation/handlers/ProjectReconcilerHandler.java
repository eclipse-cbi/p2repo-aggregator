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
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerFactory;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Project;
import org.eclipse.cbi.p2repo.aggregator.analyzer.presentation.AggregationAnalyzerEditorPlugin;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.URIMappingRegistryImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.swt.widgets.Shell;
import org.json.JSONArray;
import org.json.JSONObject;

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
			var gitRepositoryFilters = analysis.getGitRepositoryFilters();
			projectMapper = new ProjectMapper(analysis.getReleaseDate(),
					gitRepositoryFilters.isEmpty() ? null : Pattern.compile(String.join("|", gitRepositoryFilters)));
			projects = reconcile(monitor);
		}

		@Override
		protected void asyncExec() {
			var editingDomain = AdapterFactoryEditingDomain.getEditingDomainFor(analysis);
			var commandStack = editingDomain.getCommandStack();
			class ProjectReconcileCommand extends ChangeCommand {
				private ProjectReconcileCommand(Collection<Notifier> notifiers) {
					super(notifiers);
				}

				@Override
				protected void doExecute() {
					for (var entry : projects.entrySet()) {
						var oldProjects = entry.getKey().getProjects();
						var newProjects = entry.getValue();
						reconcile(oldProjects, newProjects);
						if (!EcoreUtil.equals(oldProjects, newProjects)) {
							ECollections.setEList(oldProjects, newProjects);
						}
					}
				}

				private void reconcile(List<Project> oldProjects, List<Project> newProjects) {
					var tags = new HashMap<String, EList<String>>();
					for (var it = EcoreUtil.<EObject>getAllContents(oldProjects); it.hasNext();) {
						var eObject = it.next();
						if (eObject instanceof Project project) {
							tags.put(project.getName(), project.getTags());
						}
					}
					for (var it = EcoreUtil.<EObject>getAllContents(newProjects); it.hasNext();) {
						var eObject = it.next();
						if (eObject instanceof Project project) {
							var projectTags = tags.get(project.getName());
							if (projectTags != null) {
								project.getTags().addAll(projectTags);
							}
						}
					}
				}

				@Override
				public String getLabel() {
					return "Reconcile Projects";
				}

				public boolean hasChanges() {
					return changeDescription != null && !changeDescription.getObjectChanges().isEmpty();
				}
			}

			var reconcileCommand = new ProjectReconcileCommand(List.of(analysis));
			commandStack.execute(reconcileCommand);

			// If the reconcile operation produced no changes, the command is a no-op so we can remove it from the command stack.
			// This way the resource is only dirty if it's actually been reconciled in a way that changes the structure.
			if (!reconcileCommand.hasChanges()) {
				commandStack.undo();
			}
		}

		public Map<ContributionAnalysis, List<Project>> reconcile(IProgressMonitor monitor) throws Exception {
			var projectLinks = computeProjectLinks(monitor, analysis);
			update(projectLinks);
			return projectLinks;
		}

		private void update(Map<ContributionAnalysis, List<Project>> projectLinks) {
			var csv = System.getProperty(
					"org.eclipse.cbi.p2repo.aggregator.analyzer.presentation.handlers.ProjectReconcilerHandler.csv");

			var sitesToProjects = new LinkedHashMap<URI, List<Project>>();
			for (var projects : projectLinks.values()) {
				for (var allContents = EcoreUtil.getAllContents(projects); allContents.hasNext();) {
					var content = allContents.next();
					if (content instanceof Project project) {
						sitesToProjects.computeIfAbsent(project.getSite(), it -> new ArrayList<>()).add(project);
					}
				}
			}

			if (csv != null && Files.exists(Path.of(csv))) {
				try {
					var lines = Files.readAllLines(Path.of(csv));
					for (var line : lines) {
						var parts = line.split(";", -1);
						var url = parts[1];
						if (url.startsWith("https:")) {
							var rank = Integer.valueOf(parts[parts.length - 1]);
							var uri = URI.createURI(url);
							var projects = sitesToProjects.get(uri);
							if (projects != null && !projects.isEmpty()) {
								for (var project : projects) {
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

		private Map<ContributionAnalysis, List<Project>> computeProjectLinks(IProgressMonitor monitor,
				Analysis analysis) throws Exception {
			var result = new LinkedHashMap<ContributionAnalysis, List<Project>>();
			var contributions = analysis.getContributions();
			var subMonitor = SubMonitor.convert(monitor, "Analyzing", contributions.size());
			for (var contributionAnalysis : contributions) {
				var projects = new ArrayList<Project>();
				result.put(contributionAnalysis, projects);

				var projectSubMonitor = subMonitor.newChild(1);
				projectSubMonitor.subTask(contributionAnalysis.getLabel());

				var projectIDs = getProjectIDs(contributionAnalysis);
				var label = contributionAnalysis.getLabel();
				var filter = new Predicate<String>() {
					private final Pattern pattern = Pattern.compile(
							".*:webtools.java-ee-config|.*:webtools\\.releng|.*:eclipse\\.jdt\\.ls|Web Tools Platform:tools.oomph|.*To-Be-Deleted.*");

					@Override
					public boolean test(String projectID) {
						return pattern.matcher(label + ":" + projectID).matches();
					}
				};

				var rootProjectIDs = new LinkedHashSet<String>(projectIDs.keySet());
				getProjectIDs(projectIDs, contributionAnalysis.getAllProjects());

				for (var projectID : rootProjectIDs) {
					if (!filter.test(projectID)) {
						projects.add(createProject(filter, projectID, projectIDs, true));
					}
				}
			}

			return result;
		}

		private Project createProject(Predicate<String> filter, String projectID, Map<String, Integer> projectIDs,
				boolean root) throws IOException {
			var project = AnalyzerFactory.eINSTANCE.createProject();
			var rank = projectIDs.get(projectID);
			project.setRank(rank == null ? 0 : rank);
			project.setSite(URI.createURI(ProjectMapper.ECLIPSE_PROJECT_PORTAL + projectID));
			project.setName(projectMapper.getProjectName(projectID));

			if (root) {
				var latestReleaseURL = projectMapper.getLatestReleaseInfo(String.class, projectID);
				if (latestReleaseURL != null) {
					project.setVersion(URI.createURI(latestReleaseURL));
					var date = projectMapper.getLatestReleaseInfo(Date.class, projectID);
					if (date != null) {
						project.setReleaseDate(date);
					}
				}
			}

			var repositories = project.getRepositories();
			var repositoryURIs = projectMapper.getRepositories(projectID);
			for (var repositoryURI : repositoryURIs) {
				var gitRepository = AnalyzerFactory.eINSTANCE.createGitRepository();
				gitRepository.setURI(URI.createURI(repositoryURI));
				if (project.getNews() == null) {
					var news = projectMapper.getNews(gitRepository.getURI());
					if (news != null) {
						project.setNews(URI.createURI(news));
					}
				}
				repositories.add(gitRepository);
			}

			if (!projectID.contains(".")) {
				var subprojects = project.getSubprojects();
				var subprojectIDs = projectMapper.getSubprojects(projectID);
				for (var subprojectID : subprojectIDs) {
					if (!filter.test(subprojectID)) {
						subprojects.add(createProject(filter, subprojectID, projectIDs, false));
					}
				}
			}

			return project;
		}

		private Map<String, Integer> getProjectIDs(ContributionAnalysis contributionAnalysis) {
			var projects = new TreeMap<String, Integer>();
			var contribution = contributionAnalysis.getContribution();
			if (contribution != null) {
				for (var mappedRepository : contribution.getRepositories(true)) {
					var resolvedLocation = mappedRepository.getResolvedLocation();
					var projectID = projectMapper.getProjectID(URI.createURI(resolvedLocation));
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
			for (var project : projects) {
				var site = project.getSite();
				if (site.toString().startsWith(ProjectMapper.ECLIPSE_PROJECT_PORTAL)) {
					var projectID = site.lastSegment();
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

		private final Map<String, JSONObject> pmiContent = new TreeMap<>();

		private final Map<String, String> projects = new TreeMap<>();

		private final long versionCutoffTime;

		private final LocalDate releaseDate;

		private final Version platformVersion;

		private final Pattern gitRepositoryPattern;

		public ProjectMapper(Date releaseDate, Pattern gitRepositoryPattern) throws IOException {
			this.gitRepositoryPattern = gitRepositoryPattern;

			if (releaseDate == null) {
				var now = System.currentTimeMillis();
				// Three months from now.
				versionCutoffTime = now + 1000L * 60L * 60L * 24L * 30L * 3L;
			} else {
				// Plus one day for time zone differences.
				versionCutoffTime = releaseDate.getTime() + 1000L * 60L * 60L * 24L;
			}

			this.releaseDate = releaseDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			int year = this.releaseDate.getYear();
			int month = this.releaseDate.getMonthValue();
			int quater = month / 3;
			int offset = year - 2025;
			platformVersion = Version.createOSGi(4, 34 + 4 * offset + quater, 0);

			var mappings = getContent(MAPPINGS);
			mappings += "tools/ptp/\ttools.ptp\n";
			mappings += "modeling/emft/mwe/\tmodeling.mwe\n";
			mappings += "mmt/qvto/\tmodeling.qvt-oml\n";
			mappings += "mmt/qvtd/\tmodeling.qvtd\n";
			mappings += "mmt/atl/\tmodeling.atl\n";
			for (var line : mappings.split("\r?\n")) {
				var tab = line.indexOf('\t');
				var path = line.substring(0, tab);
				var project = line.substring(tab + 1);

				if ("webtools.releng".equals(project)) {
					project = "webtools";
				} else if ("eclipse.platform".equals(project)) {
					project = "eclipse";
				} else if ("modeling.emft".equals(project)) {
					continue;
				} else {
					project = toActualID(project);
				}

				var projectURI = URI.createURI("project://" + project + "/");
				for (String host : new String[] { "https://download.eclipse.org", "https://archive.eclipse.org",
						"http://download.eclipse.org", "http://archive.eclipse.org" }) {
					registry.put(createURI(host, path), projectURI);
				}
			}

			var projects = getContent(PROJECTS);
			projects += "tools.ptp\tEclipse Parallel Tools Platform (PTP)\n";
			for (var line : projects.split("\r?\n")) {
				var tab = line.indexOf('\t');
				if (tab != -1) {
					var id = toActualID(line.substring(0, tab));
					if (!id.endsWith(".incubator")) {
						var name = line.substring(tab + 1);
						this.projects.put(id, name.replace("\\", ""));
					}
				}
			}
		}

		private String toActualID(String project) {
			if ("modeling.tmf.xtext".equals(project)) {
				return "modeling.xtext";
			} else if (project.startsWith("modeling.emf.")) {
				return project.replace("modeling.emf.", "modeling.");
			} else if (project.startsWith("modeling.mdt.")) {
				return project.replace("modeling.mdt.", "modeling.");
			} else if (project.startsWith("modeling.mmt.")) {
				return project.replace("modeling.mmt.", "modeling.");
			}
			return project;
		}

		public String getProjectID(URI uri) {
			var projectURI = registry.getURI(uri);
			if (projectURI != null && "project".equals(projectURI.scheme())) {
				return projectURI.authority();
			}

			return null;
		}

		public String getProjectName(String projectID) {
			return projects.get(projectID);
		}

		public Set<String> getRepositories(String projectID) throws IOException {
			var result = new TreeSet<String>();
			var content = getPMIContent(projectID);
			var github = get(content, "github");
			if (github != null) {
				var org = github.getString("org");
				if (!org.isBlank()) {
					var repos = getPaginatedContent(URI.createURI("https://api.github.com/orgs/" + org + "/repos"));
					for (var repo : toJSONObjects(repos)) {
						if (!repo.getBoolean("archived")) {
							result.add(repo.getString("clone_url").replaceAll(".git$", ""));
						}
					}
				}
			}

			if (content.has("github_repos")) {
				var githubRepos = content.getJSONArray("github_repos");
				if (githubRepos != null) {
					for (var repo : toJSONObjects(githubRepos)) {
						result.add(repo.getString("url"));
					}
				}
			}

			// var gitlab = get(content, "gitlab");
			// if (gitlab != null) {
			// var group = gitlab.getString("project_group");
			// if (!group.isBlank()) {
			// var repos = new JSONObject(getContent(URI.createURI("https://gitlab.eclipse.org/api/v4/groups/"
			// + group.replace("\\", "").replace("/", "%2f") + "/")));
			// }
			// }

			if (content.has("gitlab_repos")) {
				var gitlabRepos = content.getJSONArray("gitlab_repos");
				for (var repo : toJSONObjects(gitlabRepos)) {
					result.add(repo.getString("url").replaceAll(".git$", ""));
				}
			}

			cleanupRepos(projectID, result);

			return result;
		}

		private void cleanupRepos(String projectID, Set<String> repos) {
			if (gitRepositoryPattern != null) {
				repos.removeIf(it -> gitRepositoryPattern.matcher(projectID + ":" + it).matches());
			}
		}

		public <T> T getLatestReleaseInfo(Class<T> type, String projectID) throws IOException {
			var content = getPMIContent(projectID);
			var releases = content.getString("releases");
			var jsonArray = getPaginatedContent(URI.createURI(releases + "/"));
			var values = new TreeMap<>(Collections.reverseOrder());
			var simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			for (var release : toJSONObjects(jsonArray)) {
				var releaseURI = release.getString("url");
				var date = release.getString("date");
				if (!date.isBlank() && !releaseURI.contains("testme")) {
					try {
						var dateValue = simpleDateFormat.parse(date);
						var delta = versionCutoffTime - dateValue.getTime();
						if (delta > 0) {
							if (type.isInstance(releaseURI)) {
								values.put(dateValue, releaseURI);
								// return type.cast(releaseURI);
							} else if (type.isInstance(dateValue)) {
								values.put(dateValue, dateValue);
								// return type.cast(dateValue);
							} else {
								throw new IllegalArgumentException("Type " + type.getName() + " not expected");
							}
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
			if (values.isEmpty()) {
				return null;
			}
			return type.cast(values.firstEntry().getValue());
		}

		public Set<String> getSubprojects(String projectID) {
			var result = new LinkedHashSet<String>();
			var prefix = projectID + '.';
			for (var otherProjectID : projects.keySet()) {
				if (otherProjectID.startsWith(prefix) && !otherProjectID.equals("eclipse.e4")) {
					result.add(otherProjectID);
				}
			}
			return result;
		}

		public JSONObject getPMIContent(String projectID) throws IOException {
			var result = pmiContent.get(projectID);
			if (result == null) {
				var pmiID = projectID.replace('.', '_');
				var pmiURI = URI.createURI(ECLIPSE_PROJECT_PORTAL_HOST + "api/projects/" + pmiID + "/");
				var text = getContent(pmiURI);
				result = new JSONArray(text).getJSONObject(0);
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

		public String getNews(URI gitRepository) {
			var host = gitRepository.host();
			if ("gitlab.eclipse.org".equals(host)) {
				var org = gitRepository.segment(1);
				if ("graphiti".equals(org)) {
					return getGitLabWebsiteFile("eclipse%2Fgraphiti%2Fgraphiti-website", "https://eclipse.dev/graphiti",
							Pattern.compile("whats-new-(?<version>[0-9.]+)\\.html"));
				}
			} else {
				if ("github.com".equals(host)) {
					var org = gitRepository.segment(0);
					var repo = gitRepository.segment(1);
					if ("eclipse-cdo".equals(org)) {
						return "https://download.eclipse.org/modeling/emf/cdo/updates/all-relnotes.html";
					}
					if ("eclipse-equinox".equals(org)) {
						return getEclipseProjectNews("platform_isv.html");
					}
					if ("eclipse-pde".equals(org)) {
						return getEclipseProjectNews("pde.html");
					}
					if ("eclipse-jdt".equals(org)) {
						return getEclipseProjectNews("jdt.html");
					}
					if ("eclipse-platform".equals(org)) {
						return getEclipseProjectNews("platform.html");
					}
					if ("eclipse-cdt".equals(org)) {
						return getGitHubFile("eclipse-cdt", "cdt", "NewAndNoteworthy",
								Pattern.compile("CDT-(?<version>[0-9.]+)\\.md"));
					}
					if ("eclipse-egit".equals(org)) {
						return getWikiPage("eclipse-egit", "egit",
								Pattern.compile("(?<path>New-and-Noteworthy-(?<version>[0-9.]+))\\.md"));
					}
					if ("eclipse-jgit".equals(org)) {
						return getWikiPage("eclipse-jgit", "jgit",
								Pattern.compile("(?<path>New-and-Noteworthy-(?<version>[0-9.]+))\\.md"));
					}
					if ("eclipse-tracecompass".equals(org)) {
						return getWikiPage("eclipse-tracecompass", "org.eclipse.tracecompass",
								Pattern.compile("(?<path>NewIn(?<version>[0-9.]{4,}))\\.md"));
					}
					if ("eclipse-windowbuilder".equals(org)) {
						return getGitHubFile("eclipse-windowbuilder", "windowbuilder",
								"org.eclipse.wb.doc.user/html-src/whatsnew",
								Pattern.compile("v(?<version>[0-9.]+)\\.asciidoc"));
					}
					if ("eclipse-scout".equals(org)) {
						return validate("https://eclipsescout.github.io/");
					}
					if ("eclipse-tm4e".equals(org) || "eclipse-lsp4e".equals(org)
							|| "eclipse-wildwebdeveloper".equals(org)) {
						return getGitHubLatestRelease(org, repo);
					}
					if ("eclipse-emfservices".equals(org)) {
						// There are three repositories and the release notes are not well maintained.
						return null;
					}
					if ("eclipse-gef".equals(org)) {
						// The GEF 5 repo is basically dead.
						if ("gef".equals(repo)) {
							return null;
						}
					}
					if ("eclipse-ecf".equals(org)) {
						return "https://github.com/eclipse-ecf/ecf/blob/master/README.md";
					}

					var releaseInfoNews = getGitHubReleaseInfo(org, repo);
					if (releaseInfoNews != null) {
						return releaseInfoNews;
					}

					if (!Set.of("eclipse-embed-cdt", "eclipse-efx").contains(org)) {
						var githubReleastLatestNews = getGitHubLatestRelease(org, repo);
						if (githubReleastLatestNews != null) {
							return githubReleastLatestNews;
						}
					}
				}
			}
			return null;
		}

		private String validate(String uri) {
			try {
				getContent(uri);
				return uri;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		private String getEclipseProjectNews(String name) {
			var latestVersionNewsFolder = getGitHubFolder("eclipse-platform", "www.eclipse.org-eclipse", "news",
					Pattern.compile("(?<version>" + platformVersion.getSegment(0) + "\\."
							+ platformVersion.getSegment(1) + ")"));
			var lastSegment = URI.createURI(latestVersionNewsFolder).lastSegment();
			return validate("https://eclipse.dev/eclipse/news/" + lastSegment + "/" + name);
		}

		private String getGitHubLatestRelease(String org, String repo) {
			var latestURI = "https://api.github.com/repos/" + org + "/" + repo + "/releases/latest";
			try {
				var content = getContent(URI.createURI(latestURI));
				var jsonEntry = new JSONObject(content);
				jsonEntry.getString("html_url");
				var created = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(jsonEntry.getString("created_at"))
						.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				var age = ChronoUnit.DAYS.between(created, releaseDate);
				if (age > 30 * 6) {
					return null;
				}
				return "https://github.com/" + org + "/" + repo + "/releases/latest";
			} catch (IOException | ParseException e) {
				return null;
			}
		}

		private String getGitHubReleaseInfo(String org, String repo) {
			var contentURI = "https://api.github.com/repos/" + org + "/" + repo + "/contents/";
			try {
				var content = getContent(URI.createURI(contentURI));
				var jsonContent = new JSONArray(content);
				for (var jsonEntry : toJSONObjects(jsonContent)) {
					if ("file".equals(jsonEntry.getString("type"))) {
						var name = jsonEntry.getString("name");
						var pattern = Pattern.compile("(CHANGELOG|RELEASE_NOTES)\\..*");
						if (pattern.matcher(name).matches()) {
							return jsonEntry.getString("html_url");
						}
					}
				}
				return null;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		private String getGitHubFolder(String org, String repo, String path, Pattern versionPattern) {
			var contentURI = "https://api.github.com/repos/" + org + "/" + repo + "/contents/" + path;
			try {
				var content = getContent(URI.createURI(contentURI));
				var jsonContent = new JSONArray(content);
				var entries = new TreeMap<Version, String>(Collections.reverseOrder());
				for (var entry : jsonContent) {
					var jsonEntry = (JSONObject) entry;
					if ("dir".equals(jsonEntry.getString("type"))) {
						var name = jsonEntry.getString("name");
						var matcher = versionPattern.matcher(name);
						if (matcher.matches()) {
							var version = Version.create(matcher.group("version"));
							entries.put(version, jsonEntry.getString("html_url"));
						}
					}
				}
				return entries.firstEntry().getValue();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		private String getGitHubFile(String org, String repo, String path, Pattern versionPattern) {
			var contentURI = "https://api.github.com/repos/" + org + "/" + repo + "/contents/" + path;
			try {
				var content = getContent(URI.createURI(contentURI));
				var jsonContent = new JSONArray(content);
				var entries = new TreeMap<Version, String>(Collections.reverseOrder());
				for (var entry : jsonContent) {
					var jsonEntry = (JSONObject) entry;
					if ("file".equals(jsonEntry.getString("type"))) {
						var name = jsonEntry.getString("name");
						var matcher = versionPattern.matcher(name);
						if (matcher.matches()) {
							var version = Version.create(matcher.group("version"));
							entries.put(version, jsonEntry.getString("html_url"));
						}
					}
				}
				return entries.firstEntry().getValue();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		private String getGitLabWebsiteFile(String id, String website, Pattern versionPatterm) {
			var contentURI = "https://gitlab.eclipse.org/api/v4/projects/" + id
					+ "/repository/tree/?recursive=true&per_page=100";
			try {
				var entries = new TreeMap<Version, String>(Collections.reverseOrder());
				var content = getPaginatedContent(URI.createURI(contentURI));
				for (var entry : toJSONObjects(content)) {
					var name = entry.getString("name");
					var matcher = versionPatterm.matcher(name);
					if (matcher.matches()) {
						var version = Version.create(matcher.group("version"));
						entries.put(version, entry.getString("path"));
					}
				}
				return validate(website + "/" + entries.firstEntry().getValue());
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		private String getWikiPage(String org, String repo1, Pattern versionPattern) {
			var wikiCloneURI = "https://github.com/" + org + "/" + repo1 + ".wiki.git";
			var cloneFolder = getClone(wikiCloneURI);
			var entries = new TreeMap<Version, String>(Collections.reverseOrder());
			try {
				Files.walkFileTree(cloneFolder, new SimpleFileVisitor<Path>() {
					@Override
					public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
						var fileName = file.getFileName().toString();
						var matcher = versionPattern.matcher(fileName);
						if (matcher.matches()) {
							var version = Version.create(matcher.group("version"));
							var relativePath = cloneFolder.relativize(file);
							entries.put(version, "https://github.com/" + org + "/" + repo1 + "/wiki/"
									+ relativePath.toString().replace("\\", "/").replaceAll("\\.md$", ""));
						}
						return FileVisitResult.CONTINUE;
					}
				});
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			return validate(entries.firstEntry().getValue());
		}
	}
}
