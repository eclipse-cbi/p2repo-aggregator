/**
 * Copyright (c) 2006-2007, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.engine.maven;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.function.Supplier;

import org.apache.maven.artifact.repository.metadata.io.xpp3.MetadataXpp3Reader;
import org.apache.maven.artifact.versioning.ArtifactVersion;
import org.apache.maven.artifact.versioning.DefaultArtifactVersion;
import org.apache.maven.artifact.versioning.InvalidVersionSpecificationException;
import org.apache.maven.artifact.versioning.VersionRange;
import org.apache.maven.model.Dependency;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.bouncycastle.openpgp.PGPException;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;

/**
 * @author Filip Hrbek (filip.hrbek@cloudsmith.com)
 *
 */
public class MavenRepositoryHelper {
	private String[][] mappingRules;

	private InstallableUnitMapping top;

	public MavenRepositoryHelper(InstallableUnitMapping top, String[][] mappingRules) {
		this.top = top;
		this.mappingRules = mappingRules;
	}

	public String[][] getMappingRules() {
		return mappingRules;
	}

	public InstallableUnitMapping getTop() {
		return top;
	}

	public void pgpSign(File repository) throws IOException {
		var passphrase = System.getProperty("gpg.passphrase", System.getenv("MAVEN_GPG_PASSPHRASE"));
		var keyPathFile = System.getProperty("gpg.keyFilePath", System.getenv("KEYRING"));
		if (passphrase != null && keyPathFile != null) {
			var bouncyCastleSigner = new BouncyCastleSigner();
			try {
				bouncyCastleSigner.configure(System.getProperty("gpg.keyname"), passphrase, null,
						Files.readString(Path.of(keyPathFile), StandardCharsets.US_ASCII));
			} catch (PGPException e) {
				throw new IOException(e);
			}

			var repositoryPath = repository.toPath();
			Files.walkFileTree(repositoryPath, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					if (!repositoryPath.equals(file.getParent())) {
						var name = file.getFileName().toString();
						if (name.endsWith(".jar") || name.endsWith((".pom"))) {
							try {
								bouncyCastleSigner.generateSignatureForFile(file.toFile(),
										new File(file.toString() + ".asc"));
							} catch (PGPException e) {
								new IOException(e);
							}
						}
					}
					return super.visitFile(file, attrs);
				}
			});
		}
	}

	public void filter(File repository, boolean validatePOMDependencies, boolean filterPublishedArtficts)
			throws IOException, CoreException {
		var repositoryPath = repository.toPath();
		var mavenXpp3Reader = new MavenXpp3Reader();
		var metadataXpp3Reader = new MetadataXpp3Reader();
		var httpClient = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL).build();
		var availableVersions = new TreeMap<String, Set<ArtifactVersion>>();
		var errorMessageSuppliers = new ArrayList<Supplier<String>>();
		var unpublishedArtifacts = new ArrayList<Path>();

		Files.walkFileTree(repositoryPath, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				var name = file.getFileName().toString();
				if (name.endsWith(".pom")) {
					try (var inputStream = Files.newInputStream(file)) {
						try {
							var model = mavenXpp3Reader.read(inputStream);
							var groupId = model.getGroupId();
							var artifactId = model.getArtifactId();
							var version = model.getVersion();

							computePublishedVersions(groupId, artifactId);
							var isAlreadyPulished = !addVersion(groupId, artifactId,
									new DefaultArtifactVersion(version));
							if (!isAlreadyPulished) {
								unpublishedArtifacts.add(repositoryPath.relativize(file.getParent()));
							}

							for (var dependency : model.getDependencies()) {
								analayze(groupId, artifactId, version, dependency);
							}
							for (var profile : model.getProfiles()) {
								for (var dependency : profile.getDependencies()) {
									analayze(groupId, artifactId, version, dependency);
								}
							}
						} catch (XmlPullParserException e) {
							throw new IOException(e);
						}
					}
				}
				return super.visitFile(file, attrs);
			}

			private void analayze(String groupId, String artifactId, String version, Dependency dependency)
					throws IOException {
				var dependencyGroupId = dependency.getGroupId();
				var dependencyArtifactId = dependency.getArtifactId();
				computePublishedVersions(dependencyGroupId, dependencyArtifactId);
				errorMessageSuppliers.add(() -> {
					var key = dependencyGroupId + ':' + dependencyArtifactId;
					var versions = availableVersions.get(key);
					if (versions == null) {
						return groupId + ':' + artifactId + ':' + version + " -> No available versions for " + key;
					}
					var dependencyVersion = dependency.getVersion();
					if (dependencyVersion != null) {
						try {
							var versionRange = VersionRange.createFromVersionSpec(dependencyVersion);
							var hasRestrictions = versionRange.hasRestrictions();
							for (var availableVersion : versions) {
								if (hasRestrictions //
										? versionRange.containsVersion(availableVersion)
										: versionRange.getRecommendedVersion().compareTo(availableVersion) == 0) {
									return null;
								}
							}
							return groupId + ':' + artifactId + ':' + version + " -> No available version for " + key
									+ " -> " + dependencyVersion + " available " + versions;
						} catch (InvalidVersionSpecificationException e) {
							return groupId + ':' + artifactId + ':' + version + " -> Invalid version specification for "
									+ key + " -> " + dependencyVersion;
						}
					}
					return null;
				});
			}

			private void computePublishedVersions(String groupId, String artifactId) throws IOException {
				if (availableVersions.containsKey(groupId + ':' + artifactId)) {
					return;
				}

				var uri = URI.create("https://repo.maven.apache.org/maven2/" + groupId.replace('.', '/') + "/"
						+ artifactId + "/maven-metadata.xml");
				LogUtils.info("Checking available versions: " + uri);
				var requestBuilder = HttpRequest.newBuilder(uri).GET();

				try {
					var request = requestBuilder.build();
					var response = httpClient.send(request, BodyHandlers.ofInputStream());
					var statusCode = response.statusCode();
					if (statusCode == 404) {
						return;
					}

					if (statusCode != 200) {
						throw new IOException("status code " + statusCode + " -> " + uri);
					}

					try (var inputStream = response.body()) {
						var metadata = metadataXpp3Reader.read(inputStream);
						var versioning = metadata.getVersioning();
						if (versioning != null) {
							for (var string : versioning.getVersions()) {
								var defaultArtifactVersion = new DefaultArtifactVersion(string);
								addVersion(groupId, artifactId, defaultArtifactVersion);
							}
						}
					}
				} catch (InterruptedException | XmlPullParserException ex) {
					throw new IOException(ex.getMessage() + " -> " + uri, ex);
				}
			}

			private boolean addVersion(String groupId, String artifactId, ArtifactVersion version) {
				return availableVersions.computeIfAbsent(groupId + ':' + artifactId, it -> new TreeSet<>())
						.add(version);
			}
		});

		var status = new MultiStatus(getClass(), 0,
				errorMessageSuppliers.stream().map(Supplier::get).filter(Objects::nonNull).distinct()
						.map(message -> new Status(IStatus.ERROR, getClass(), message)).toArray(IStatus[]::new),
				"Missing dependencies", null);
		if (!status.isOK()) {
			if (validatePOMDependencies) {
				throw new CoreException(status);
			} else {
				LogUtils.log(status);
			}
		}

		if (filterPublishedArtficts) {
			var filteredRepositoryPath = Path.of(repositoryPath + "-unpublished");
			Files.createDirectories(filteredRepositoryPath);
			for (var path : unpublishedArtifacts) {
				Files.walkFileTree(repositoryPath.resolve(path), new SimpleFileVisitor<Path>() {
					public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
						var target = filteredRepositoryPath.resolve(repositoryPath.relativize(file));
						Files.createDirectories(target.getParent());
						Files.copy(file, target, StandardCopyOption.REPLACE_EXISTING);
						return super.visitFile(file, attrs);
					}
				});
			}
		}
	}
}
