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
package org.eclipse.cbi.p2repo.aggregator.analyzer.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerFactory;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.GitRepository;
import org.eclipse.emf.common.CommonPlugin;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;

public final class AnalyzerUtil {

	private AnalyzerUtil() {
		throw new RuntimeException("Not instantiable");
	}

	public static final Comparator<ContributionAnalysis> CONTRIBUTION_ANALYSIS_COMPARATOR = new Comparator<ContributionAnalysis>() {
		private static final Comparator<String> comparator = CommonPlugin.INSTANCE.getComparator();

		@Override
		public int compare(ContributionAnalysis c1, ContributionAnalysis c2) {
			String label1 = c1.getLabel();
			String label2 = c2.getLabel();
			return comparator.compare(label1, label2);
		}
	};

	public static final Comparator<ContributionAnalysis> CONTRIBUTION_ANALYSIS_COMPARATOR_WITH_RANK = new Comparator<ContributionAnalysis>() {
		private static final Comparator<String> comparator = CommonPlugin.INSTANCE.getComparator();

		@Override
		public int compare(ContributionAnalysis c1, ContributionAnalysis c2) {
			int compare = Integer.compare(c2.getRank(), c1.getRank());
			if (compare != 0) {
				return compare;
			}
			String label1 = c1.getLabel();
			String label2 = c2.getLabel();
			return comparator.compare(label1, label2);
		}
	};

	public static Float getAgeInDays(ContributionAnalysis contributionAnalysis) {
		long lastModified = contributionAnalysis.getLastModified();
		if (lastModified != Long.MIN_VALUE) {
			return getAgeInDays(lastModified);
		}
		return null;
	}

	public static Float getGitRepositoryAgeInDays(ContributionAnalysis contributionAnalysis) {
		Float result = null;
		for (TreeIterator<EObject> eAllContents = contributionAnalysis.eAllContents(); eAllContents.hasNext();) {
			EObject eObject = eAllContents.next();
			if (eObject instanceof GitRepository) {
				Float ageInDays = getAgeInDays((GitRepository) eObject);
				if (ageInDays != null) {
					if (result == null) {
						result = ageInDays;
					} else {
						result = Math.min(ageInDays, result);
					}
				}
			}
		}
		return result;
	}

	public static Float getAgeInDays(GitRepository gitRepository) {
		long lastModified = gitRepository.getLastModified();
		if (lastModified != Long.MIN_VALUE) {
			return getAgeInDays(lastModified);
		}
		return null;
	}

	public static float getAgeInDays(long lastModified) {
		return getAgeInDays(lastModified, System.currentTimeMillis());
	}

	public static float getAgeInDays(long lastModified, long relativeTo) {
		long ageInMillis = Math.max(0, relativeTo - lastModified);
		float ageInDays = ((float) ageInMillis) / 1000 / 60 / 60 / 24;
		return ageInDays;
	}

	public static String format(Date date) {
		return AnalyzerFactory.eINSTANCE.convertToString(AnalyzerPackage.Literals.DATE, date);
	}

	/**
	 * https://github.com/merks/org.eclipse.simrel.build.git
	 * git@github.com:merks/org.eclipse.simrel.build.git
	 */
	private static final Pattern ECLIPSE_GIT_URL_PATTERN = Pattern
			.compile("(?:https?://git.eclipse.org/r/|ssh://[^@]+@git.eclipse.org:29418/)(.*)");

	/**
	 * https://git.eclipse.org/r/simrel/org.eclipse.simrel.build.git
	 * ssh://user_id@git.eclipse.org:29418/simrel/org.eclipse.simrel.build.git
	 */
	private static final Pattern GITHUB_URL_PATTERN = Pattern.compile("(?:https?://github.com/|git@github.com:)(.*)");

	private static final Pattern GIT_CONFIG_URL_PATTERN = Pattern.compile("\n[ \t]*url[ \t]*=[ \t]*([^\n\r \t]+)");

	private static final Pattern GIT_CONFIG_BRANCH_PATTERN = Pattern
			.compile("\n\\[[ \t]*branch[ \t]+\"([^\"]+)\"[ \t]*\\]");

	private static final String GIT_ECLIPSE = "https://git.eclipse.org/";

	private static final String GITHUB = "https://github.com/";

	private static final String RAW_GITHUB = "https://raw.githubusercontent.com/";

	// private static final String GITLAB_ECLIPSE = "https://gitlab.eclipse.org";

	public record Repo(URI base, URI path, String branch) {

		public URI getPlainURI() {
			String base = this.base.toString();
			Matcher eclipseGitMatcher = ECLIPSE_GIT_URL_PATTERN.matcher(base);
			if (eclipseGitMatcher.matches()) {
				return URI.createURI(
						GIT_ECLIPSE + "c/" + eclipseGitMatcher.group(1) + ".git/log/" + path + "?h=" + branch);
			}

			Matcher githubGitMatcher = GITHUB_URL_PATTERN.matcher(base);
			if (githubGitMatcher.matches()) {
				return URI.createURI(
						GITHUB + githubGitMatcher.group(1).replaceAll("\\.git$", "") + "/blob/" + branch
						+ "/" + path);
			}

			return null;
		}

		public URI getRawURI() {
			String base = this.base.toString();
			Matcher eclipseGitMatcher = ECLIPSE_GIT_URL_PATTERN.matcher(base);
			if (eclipseGitMatcher.matches()) {
				return URI.createURI(
						GIT_ECLIPSE + "c/" + eclipseGitMatcher.group(1) + ".git/log/" + path + "?h=" + branch);
			}

			Matcher githubGitMatcher = GITHUB_URL_PATTERN.matcher(base);
			if (githubGitMatcher.matches()) {
				return URI.createURI(
						RAW_GITHUB + githubGitMatcher.group(1).replaceAll("\\.git$", "") + "/" + branch + "/" + path);
			}

			return null;
		}
	}

	public static Repo getGitRepositoryURI(URI uri) {
		URI resolvedURI = CommonPlugin.resolve(uri);
		if (resolvedURI.isFile()) {
			Path contributionPath = Path.of(resolvedURI.toFileString());
			for (Path path = contributionPath.getParent(); path != null
					&& Files.isReadable(path); path = path.getParent()) {
				// Look for a git repository configuration.
				Path configPath = path.resolve(".git/config");
				if (Files.isRegularFile(configPath)) {
					try {
						String config = Files.readString(configPath);
						// Determine branch and repo URL.
						Matcher branchMatcher = GIT_CONFIG_BRANCH_PATTERN.matcher(config);
						Matcher urlMatcher = GIT_CONFIG_URL_PATTERN.matcher(config);
						if (urlMatcher.find() && branchMatcher.find()) {
							URI repoRelativeURI = URI.createFileURI(path.relativize(contributionPath).toString());
							String repo = urlMatcher.group(1);
							return new Repo(URI.createURI(repo), repoRelativeURI, branchMatcher.group(1));
						}
					} catch (IOException e) {
					}

					break;
				}
			}
		}

		return null;
	}

}
