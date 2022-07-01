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
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.maven.model.io.DefaultModelWriter;
import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.MavenItem;
import org.eclipse.cbi.p2repo.aggregator.VersionFormat;
import org.eclipse.cbi.p2repo.aggregator.impl.MavenMappingImpl;
import org.eclipse.cbi.p2repo.p2.maven.MavenMetadata;
import org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData;
import org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataFactory;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot;
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion;
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersionsType;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning;
import org.eclipse.cbi.p2repo.p2.maven.metadata.VersionsType;
import org.eclipse.cbi.p2repo.p2.maven.util.DigestUtil;
import org.eclipse.cbi.p2repo.p2.maven.util.VersionUtil;
import org.eclipse.cbi.p2repo.p2.util.IUUtils;
import org.eclipse.cbi.p2repo.util.ExceptionUtils;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.equinox.internal.p2.metadata.BasicVersion;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.metadata.Version;

/**
 * @author Filip Hrbek (filip.hrbek@cloudsmith.com)
 *
 */
public class MavenManager {
	static class MavenMetadataHelper {
		private String groupId;

		private String artifactId;

		private List<Version> versionList;
		private Map<Version, Boolean> snapshots;

		private VersionFormat versionFormat;

		private boolean finalized;

		private boolean hasSources;

		MavenMetadataHelper(String groupId, String artifactId, VersionFormat versionFormat, boolean hasSources) {
			this.groupId = groupId;
			this.artifactId = artifactId;
			this.versionList = new ArrayList<Version>();
			this.snapshots = new HashMap<>();
			this.versionFormat = versionFormat;
			this.hasSources = hasSources;
		}

		public void addVersion(Version version, boolean isSnapshot) {
			if(finalized)
				throw new Error("Version added after finalization");

			versionList.add(version);
			snapshots.put(version, isSnapshot);
		}

		private void finalizeMetadata() {
			Collections.sort(versionList);
			finalized = true;
		}

		public String getArtifactId() {
			return artifactId;
		}

		public String getGroupId() {
			return groupId;
		}

		public String getRelativePath() {
			return groupId.replace('.', '/') + "/" + artifactId;
		}

		public Version getRelease() {
			finalizeMetadata();
			Version[] versions = versionList.toArray(new Version[versionList.size()]);
			for(int idx = versions.length - 1; idx >= 0; idx--) {
				String qualifier = null;
				try {
					if(versions[idx] instanceof BasicVersion)
						qualifier = ((BasicVersion) versions[idx]).getQualifier();
				}
				catch(UnsupportedOperationException e) {
					// ignore
				}

				if(qualifier != null && qualifier.length() > 0 &&
						(qualifier.charAt(0) == 'R' || qualifier.charAt(0) == 'M'))
					continue;
				if (snapshots.get(versions[idx]) == Boolean.TRUE)
					continue;
				if (versions[idx].toString().contains(VersionUtil.DASH_SNAPSHOT)) // fade out name based recognition of snapshot?
					continue;

				return versions[idx];
			}

			return null;
		}

		public Version getLatest() {
			Version[] sortable = versionList.toArray(new Version[versionList.size()]);
			Arrays.sort(sortable);
			return sortable[sortable.length - 1];
		}

		public VersionFormat getVersionFormat() {
			return versionFormat;
		}

		public List<Version> getVersions() {
			finalizeMetadata();
			return versionList;
		}

		public boolean hasSources() {
			return hasSources;
		}
	}

	private static void addMappingRule(List<String[]> mappingRulesList, InstallableUnitMapping iu) throws CoreException {
		if(iu.getMainArtifact() != null) {
			IArtifactKey artifact = iu.getMainArtifact();
			mappingRulesList.add(new String[] {
					"(& (classifier=" + IUUtils.encodeFilterValue(artifact.getClassifier()) + ")(id=" +
							IUUtils.encodeFilterValue(artifact.getId()) + ")(version=" +
							IUUtils.encodeFilterValue(iu.getVersion().toString()) + "))",
					"${repoUrl}/" + iu.getRelativeFullPath() });
		}
	}

	private static URI createArtifactURI(URI root, InstallableUnitMapping iu) throws CoreException {
		if(iu.getMainArtifact() != null)
			return URI.createURI(root.toString() + "/" + iu.getRelativeFullPath());

		return null;
	}

	private static void createCheckSum(URI fileUri, URIConverter uriConverter, MessageDigest[] digests)
			throws CoreException {
		InputStream is = null;
		PrintWriter digestWriter = null;
		try {
			is = uriConverter.createInputStream(fileUri);
			for(MessageDigest digest : digests)
				digest.reset();

			byte[] buffer = new byte[4096];
			int read;
			while((read = is.read(buffer)) != -1)
				for(MessageDigest digest : digests)
					digest.update(buffer, 0, read);
			is.close();

			for(MessageDigest digest : digests) {
				byte[] result = digest.digest();

				URI digestUri = URI.createURI(fileUri.toString() + "." + digest.getAlgorithm().toLowerCase());
				digestWriter = new PrintWriter(uriConverter.createOutputStream(digestUri));
				for(byte b : result)
					digestWriter.printf("%02x", Byte.valueOf(b));
				digestWriter.close();
			}
		}
		catch(IOException e) {
			throw ExceptionUtils.fromMessage(e, "Error creating digest for %s", fileUri.toString());
		}
		finally {
			if(is != null)
				try {
					is.close();
				}
				catch(IOException e) {
					// ignore
				}
			if(digestWriter != null)
				digestWriter.close();
		}
	}

	public static MavenRepositoryHelper createMavenStructure(List<InstallableUnitMapping> ius, Aggregation aggregation)
			throws CoreException {
		List<String[]> mappingRulesList = new ArrayList<String[]>();

		// Initialize with standard rules for packed artifacts (which are not usable for maven anyway)
		mappingRulesList.add(new String[] {
				"(& (classifier=osgi.bundle) (format=packed))",
				"${repoUrl}/p2.packed/plugins/${id}_${version}.jar.pack.gz" });
		mappingRulesList.add(new String[] {
				"(& (classifier=org.eclipse.update.feature) (format=packed))",
				"${repoUrl}/p2.packed/features/${id}_${version}.jar.pack.gz" });

		Map<String, List<InstallableUnitMapping>> groupMap = new HashMap<String, List<InstallableUnitMapping>>();

		for(InstallableUnitMapping iu : ius) {
			String groupId = iu.map().getGroupId();
			List<InstallableUnitMapping> group = groupMap.get(groupId);
			if(group == null)
				groupMap.put(groupId, group = new ArrayList<InstallableUnitMapping>());
			group.add(iu);
		}

		InstallableUnitMapping top = new InstallableUnitMapping(aggregation.getVersionFormat());
		top.setTransient(true);
		addMappingRule(mappingRulesList, top);
		// FIXME: rule uses mavenized name, OK?

		for(Map.Entry<String, List<InstallableUnitMapping>> entry : groupMap.entrySet()) {
			InstallableUnitMapping group = new InstallableUnitMapping(entry.getKey());
			addMappingRule(mappingRulesList, group);

			// This is a place where we can find common-in-group properties
			// and store them in the group IU mapping.
			// This is left out for now to make the whole thing functional,
			// but can be done later to optimize the maven structure...

			for(InstallableUnitMapping iu : entry.getValue()) {
				addMappingRule(mappingRulesList, iu);
				iu.setParent(group);

				// original IUs with more than 1 artifact have generated siblings
				for(InstallableUnitMapping sibling : iu.getSiblings()) {
					addMappingRule(mappingRulesList, sibling);
					sibling.setParent(group);
				}
			}

			group.setParent(top);
			group.setTransient(true);
		}

		return new MavenRepositoryHelper(top, mappingRulesList.toArray(new String[mappingRulesList.size()][]));
	}

	private static URI createPomURI(URI root, InstallableUnitMapping iu) throws CoreException {
		return URI.createURI(root.toString() + "/" + iu.getRelativePath() + "/" + iu.getPomName());
	}

	private static URI createXmlURI(URI root, MavenMetadataHelper md) throws CoreException {
		return URI.createURI(root.toString() + "/" + md.getRelativePath() + "/maven-metadata.xml");
	}

	private static URI createSnapshotXmlURI(URI root, MavenMetadataHelper md, Version version)
			throws CoreException {
		String versionDir = VersionUtil.getVersionString(version, VersionFormat.MAVEN_SNAPSHOT, false, -1);
		return URI.createURI(root.toString() + "/" + md.getRelativePath() + "/" + versionDir + "/maven-metadata.xml");
	}

	public static void saveMetadata(URI root, InstallableUnitMapping iu, Map<Contribution, List<String>> errors,
			int buildNumber)
			throws CoreException {
		ResourceSet resourceSet = new ResourceSetImpl();
		URIConverter uriConverter = resourceSet.getURIConverter();
		Map<String, MavenMetadataHelper> metadataCollector = new HashMap<String, MavenMetadataHelper>();

		savePOMs(root, iu, uriConverter, DigestUtil.MESSAGE_DIGESTERS, metadataCollector, errors);
		saveXMLs(root, uriConverter, DigestUtil.MESSAGE_DIGESTERS, metadataCollector, buildNumber);
	}

	private static void savePOMs(URI root, InstallableUnitMapping iu, URIConverter uriConverter,
			MessageDigest[] digests, Map<String, MavenMetadataHelper> metadataCollector,
			Map<Contribution, List<String>> errors) throws CoreException {
		if(!iu.isTransient()) {
			boolean isSource = iu.isSourceArtifact();
			if(!isSource) {
				URI pomUri = createPomURI(root, iu);
				try {
					new DefaultModelWriter().write(new File(java.net.URI.create(pomUri.toString())), Map.of(),
							iu.asPOM());
				} catch (IOException | CoreException e) {
					throw new CoreException(new Status(IStatus.ERROR, MavenManager.class, e.getMessage(), e));
				}
				createCheckSum(pomUri, uriConverter, digests);
			}

			URI artifactUri = createArtifactURI(root, iu);
			if(artifactUri != null) {
				try {
					createCheckSum(artifactUri, uriConverter, digests);
				}
				catch(CoreException e) {
					Contribution contrib = iu.getContribution();
					List<String> contribErrors = errors.get(contrib);
					if(contribErrors == null)
						errors.put(contrib, contribErrors = new ArrayList<String>());
					StringBuilder msgBuilder = new StringBuilder(e.getMessage());
					if(e.getCause() != null) {
						msgBuilder.append(':');
						msgBuilder.append(' ');
						msgBuilder.append(e.getCause().toString());
					}
					String msg = msgBuilder.toString();
					LogUtils.error(msg);
					contribErrors.add(msg);
				}
			}
			if(isSource) {
				return; // don't add source jar to metadataCollector
			}

			String key = iu.map().getGroupId() + "/" + iu.map().getArtifactId();
			MavenMetadataHelper md = metadataCollector.get(key);
			if (md == null) {
				md = new MavenMetadataHelper(iu.map().getGroupId(), iu.map().getArtifactId(), iu.getVersionFormat(),
						iu.hasSources());
				metadataCollector.put(key, md);
			}
			md.addVersion(iu.getMappedVersion(), iu.getVersionFormat() == VersionFormat.MAVEN_SNAPSHOT);
			// will potentially be mapped to the global VersionFormat during saveXMLs
		}
		for (InstallableUnitMapping child : iu.getChildren()) {
			if (child.isSourceArtifact()) {
				markSiblingHasSources(child, iu.getChildren());
			}
		}

		for(InstallableUnitMapping child : iu.getChildren())
			savePOMs(root, child, uriConverter, digests, metadataCollector, errors);
	}

	public static void markSiblingHasSources(InstallableUnitMapping sourcesIU, List<InstallableUnitMapping> siblings)
			throws CoreException {
		// find the matching classifier-less sibling IU:
		MavenItem sourcesItem = sourcesIU.map();
		for (InstallableUnitMapping siblingMapping : siblings) {
			if (siblingMapping == sourcesIU)
				continue;
			MavenItem sibling = siblingMapping.map();
			if (sibling.getGroupId().equals(sourcesItem.getGroupId())
					&& sibling.getArtifactId().equals(sourcesItem.getArtifactId()) && sibling.getClassifier() == null) {
				siblingMapping.setHasSources(true);
				break;
			}
		}
	}

	private static void saveXMLs(URI root, URIConverter uriConverter, MessageDigest[] digests,
			Map<String, MavenMetadataHelper> metadataCollector, int buildNumber) throws CoreException {
		String timestamp = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date());
		String timestampDot = String.format("%1$tY%1$tm%1$td.%1$tH%1$tM%1$tS", new Date());

		for(MavenMetadataHelper mdh : metadataCollector.values()) {
			mdh.finalizeMetadata();
			VersionFormat versionFormat = mdh.getVersionFormat();

			MavenMetadata mdConainter = new MavenMetadata();
			MetaData md = mdConainter.getMetaData();
			md.setGroupId(mdh.getGroupId());
			md.setArtifactId(mdh.getArtifactId());
			Versioning versioning = MetadataFactory.eINSTANCE.createVersioning();
			md.setVersioning(versioning);
			versioning.setLastUpdated(timestamp);
			Version release = mdh.getRelease();
			if(release != null)
				versioning.setRelease(VersionUtil.getVersionString(release, versionFormat, false, -1));
			versioning.setLatest(VersionUtil.getVersionString(mdh.getLatest(), versionFormat, false, -1));
			VersionsType versions = MetadataFactory.eINSTANCE.createVersionsType();
			versioning.setVersions(versions);
			List<String> versionList = versions.getVersion();
			mdh.getVersions().stream().map(v -> VersionUtil.getVersionString(v, versionFormat, false, -1)) //
					.distinct() // avoid duplicates
					.forEach(versionList::add);

			URI xmlUri = createXmlURI(root, mdh);
			mdConainter.save(xmlUri);
			createCheckSum(xmlUri, uriConverter, digests);
			
			if (versionFormat == VersionFormat.MAVEN_SNAPSHOT) {
				for (Version version : mdh.getVersions()) {
					mdConainter = new MavenMetadata();
					md = mdConainter.getMetaData();
					md.setGroupId(mdh.getGroupId());
					md.setArtifactId(mdh.getArtifactId());
					String versionString = VersionUtil.getVersionString(version, versionFormat, false, -1);
					md.setVersion(versionString);

					versioning = MetadataFactory.eINSTANCE.createVersioning();
					md.setVersioning(versioning);
					versioning.setLastUpdated(timestamp);

					Snapshot snapshot = MetadataFactory.eINSTANCE.createSnapshot();
					versioning.setSnapshot(snapshot);
					snapshot.setTimestamp(timestampDot);
					snapshot.setBuildNumber(buildNumber);

					SnapshotVersionsType snapVersions = MetadataFactory.eINSTANCE.createSnapshotVersionsType();
					versioning.setSnapshotVersions(snapVersions);
					EList<SnapshotVersion> snapVersionList = snapVersions.getSnapshotVersion();
					String snapshotVersion = VersionUtil.getVersionString(version, VersionFormat.MAVEN_SNAPSHOT, true,
							buildNumber);
					snapVersionList.add(createSnapshotVersion(null, "jar", snapshotVersion, timestamp));
					snapVersionList.add(createSnapshotVersion(null, "pom", snapshotVersion, timestamp));
					if (mdh.hasSources()) {
						snapVersionList.add(createSnapshotVersion(MavenMappingImpl.MAVEN_SOURCES_CLASSIFIER, "jar", snapshotVersion, timestamp));
					}
					xmlUri = createSnapshotXmlURI(root, mdh, version);
					mdConainter.save(xmlUri);
					createCheckSum(xmlUri, uriConverter, digests);
				}
			}
		}
	}

	public static SnapshotVersion createSnapshotVersion(String classifier, String extension, String version,
			String updated) {
		SnapshotVersion snapshotVersion = MetadataFactory.eINSTANCE.createSnapshotVersion();
		snapshotVersion.setExtension(extension);
		snapshotVersion.setValue(version);
		snapshotVersion.setUpdated(updated);
		if (classifier != null) {
			snapshotVersion.setClassifier(classifier);
		}
		return snapshotVersion;
	}

}
