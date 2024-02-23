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

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class LastModifiedHandler extends BaseHandler {

	protected Activity createActivity(Analysis analysis) {
		return new LastModifiedUpdater(analysis);
	}

	public static class LastModifiedUpdater extends Activity {

		private static final String GIT_ECLIPSE = "https://git.eclipse.org/";

		private static final String ECLIPSE_GIT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss Z";

		private static final String GITHUB = "https://github.com/";

		private static final String GITLAB_ECLIPSE = "https://gitlab.eclipse.org";

		private static final String GIT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSX";

		private static final String GITLAB_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss'Z'";

		private static final Pattern ECLIPSE_GITLAB_TIME_PATTERN = Pattern.compile("<time[^>]+datetime=\"([^\"]+)\"");

		private static final Pattern GIT_CONFIG_URL_PATTERN = Pattern.compile("\n[ \t]*url[ \t]*=[ \t]*([^\n\r \t]+)");

		private static final Pattern GIT_CONFIG_BRANCH_PATTERN = Pattern
				.compile("\n\\[[ \t]*branch[ \t]+\"([^\"]+)\"[ \t]*\\]");

		private Analysis analysis;

		private ExecutorService executor;

		public LastModifiedUpdater(Analysis analysis) {
			this.analysis = analysis;
		}

		private ExecutorService getExecutor() {
			if (executor == null) {
				executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
			}

			return executor;
		}

		private void shutDownExecutor() throws InterruptedException {
			if (executor != null) {
				executor.shutdown();
				executor.awaitTermination(10, TimeUnit.MINUTES);
				executor = null;
			}
		}

		@Override
		protected void perform(IProgressMonitor monitor) throws Exception {
			SubMonitor subMonitor = SubMonitor.convert(monitor);
			subMonitor.setTaskName("Analyzing Git History");
			List<Callable<Void>> callables = new ArrayList<>();
			for (ContributionAnalysis contributionAnalysis : analysis.getContributions()) {
				Contribution contribution = contributionAnalysis.getContribution();
				if (contribution != null) {
					Resource resource = ((EObject) contribution).eResource();
					if (resource != null
							&& EcoreUtil.getRootContainer((EObject) contribution).eResource() != resource) {
						callables.add(() -> {
							URI uri = resource.getURI();
							subMonitor.subTask(uri.toString());
							Long lastModified = getLastModified(CommonPlugin.resolve(uri));
							if (lastModified != null) {
								contributionAnalysis.setLastModified(lastModified);
							}
							subMonitor.worked(1);
							return null;
						});
					}
				}

				for (TreeIterator<EObject> eAllContents = contributionAnalysis.eAllContents(); eAllContents
						.hasNext();) {
					EObject eObject = eAllContents.next();
					if (eObject instanceof GitRepository) {
						GitRepository gitRepository = (GitRepository) eObject;
						URI uri = gitRepository.getURI();
						if (uri != null) {
							callables.add(() -> {
								subMonitor.subTask(uri.toString());
								Long lastModified = getLastModified(uri.toString());
								if (lastModified != null) {
									gitRepository.setLastModified(lastModified);
								}
								subMonitor.worked(1);
								return null;
							});
						}
					}
				}
			}

			subMonitor.setWorkRemaining(callables.size());

			ExecutorService executor = getExecutor();
			for (Callable<Void> callable : callables) {
				executor.submit(callable);
			}

			shutDownExecutor();
		}

		public Long getLastModified(String repo) throws Exception {
			if (repo.startsWith(GITLAB_ECLIPSE)) {
				URI historyURI = URI.createURI(repo + "/-/commits");
				return BaseHandler.getLastModified(historyURI, ECLIPSE_GITLAB_TIME_PATTERN, GITLAB_DATE_FORMAT);
			} else if (repo.startsWith(GITHUB)) {
				URI historyURI = URI.createURI(repo + "/commits");
				return BaseHandler.getLastModified(historyURI, GITHUB_TIME_PATTERN, GIT_DATE_FORMAT);
			} else if (repo.startsWith(GIT_ECLIPSE)) {
				URI historyURI = URI.createURI(repo.replace("/r/", "/c/") + ".git/log/");
				return BaseHandler.getLastModified(historyURI, ECLIPSE_COMMIT_TIME_PATTERN, ECLIPSE_GIT_DATE_FORMAT);
			}
			// https://gitlab.eclipse.org/eclipse/mpc/org.eclipse.epp.mpc
			return null;
		}

		private Long getLastModified(URI contributionURI) throws Exception {
			if (contributionURI.isFile()) {
				Path contributionPath = Path.of(contributionURI.toFileString());
				for (Path path = contributionPath.getParent(); path != null
						&& Files.isReadable(path); path = path.getParent()) {
					// Look for a git repository configuration.
					Path configPath = path.resolve(".git/config");
					if (Files.isRegularFile(configPath)) {
						String config = Files.readString(configPath);
						// Determine branch and repo URL.
						Matcher branchMatcher = GIT_CONFIG_BRANCH_PATTERN.matcher(config);
						Matcher urlMatcher = GIT_CONFIG_URL_PATTERN.matcher(config);
						if (urlMatcher.find() && branchMatcher.find()) {
							URI repoRelativeURI = URI.createFileURI(path.relativize(contributionPath).toString());
							return getLastModified(urlMatcher.group(1), repoRelativeURI, branchMatcher.group(1));
						}

						break;
					}
				}
			}

			return null;
		}

		private Long getLastModified(String url, URI repoRelativeURI, String branch) throws Exception {
			Matcher eclipseGitMatcher = ECLIPSE_GIT_URL_PATTERN.matcher(url);
			if (eclipseGitMatcher.matches()) {
				URI logURI = URI.createURI(GIT_ECLIPSE + "c/" + eclipseGitMatcher.group(1) + ".git/log/"
						+ repoRelativeURI + "?h=" + branch);
				return BaseHandler.getLastModified(logURI, ECLIPSE_COMMIT_TIME_PATTERN, ECLIPSE_GIT_DATE_FORMAT);
			}

			Matcher githubGitMatcher = GITHUB_URL_PATTERN.matcher(url);
			if (githubGitMatcher.matches()) {
				URI logURI = URI.createURI(GITHUB + githubGitMatcher.group(1).replaceAll("\\.git$", "") + "/commits/"
						+ branch + "/" + repoRelativeURI);
				return BaseHandler.getLastModified(logURI, GITHUB_TIME_PATTERN, GIT_DATE_FORMAT);
			}

			return null;
		}
	}
}
