/*******************************************************************************
 * Copyright (c) 2006-2007, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 ******************************************************************************/

package org.eclipse.cbi.p2repo.aggregator.engine.maven;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.VersionFormat;
import org.eclipse.cbi.p2repo.p2.maven.MavenMetadata;
import org.eclipse.cbi.p2repo.p2.maven.metadata.MetaData;
import org.eclipse.cbi.p2repo.p2.maven.metadata.MetadataFactory;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Snapshot;
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersion;
import org.eclipse.cbi.p2repo.p2.maven.metadata.SnapshotVersions;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Versioning;
import org.eclipse.cbi.p2repo.p2.maven.metadata.Versions;
import org.eclipse.cbi.p2repo.p2.maven.util.DigestUtil;
import org.eclipse.cbi.p2repo.p2.maven.util.VersionUtil;
import org.eclipse.cbi.p2repo.p2.util.IUUtils;
import org.eclipse.cbi.p2repo.util.ExceptionUtils;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.core.runtime.CoreException;
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

		private VersionFormat versionFormat;

		private boolean finalized;

		MavenMetadataHelper(String groupId, String artifactId, VersionFormat versionFormat) {
			this.groupId = groupId;
			this.artifactId = artifactId;
			this.versionList = new ArrayList<Version>();
			this.versionFormat = versionFormat;
		}

		public void addVersion(Version version) {
			if(finalized)
				throw new Error("Version added after finalization");

			versionList.add(version);
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
				if (versions[idx].toString().contains(VersionUtil.DASH_SNAPSHOT))
					continue;

				return versions[idx];
			}

			return null;
		}

		public VersionFormat getVersionFormat() {
			return versionFormat;
		}

		public List<Version> getVersions() {
			finalizeMetadata();
			return versionList;
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
		String versionString = VersionUtil.getVersionString(version, VersionFormat.MAVEN_SNAPSHOT);
		String versionDir = VersionUtil.versionAsSnapshot(versionString);
		return URI.createURI(root.toString() + "/" + md.getRelativePath() + "/" + versionDir + "/maven-metadata.xml");
	}

	public static void saveMetadata(URI root, InstallableUnitMapping iu, Map<Contribution, List<String>> errors)
			throws CoreException {
		ResourceSet resourceSet = new ResourceSetImpl();
		URIConverter uriConverter = resourceSet.getURIConverter();
		Map<String, MavenMetadataHelper> metadataCollector = new HashMap<String, MavenMetadataHelper>();

		savePOMs(root, iu, uriConverter, DigestUtil.MESSAGE_DIGESTERS, metadataCollector, errors);
		saveXMLs(root, uriConverter, DigestUtil.MESSAGE_DIGESTERS, metadataCollector);
	}

	private static void savePOMs(URI root, InstallableUnitMapping iu, URIConverter uriConverter,
			MessageDigest[] digests, Map<String, MavenMetadataHelper> metadataCollector,
			Map<Contribution, List<String>> errors) throws CoreException {
		if(!iu.isTransient()) {
			boolean isSource = iu.isSourceArtifact();
			if(!isSource) {
				URI pomUri = createPomURI(root, iu);
				iu.asPOM().save(pomUri);
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
				md = new MavenMetadataHelper(iu.map().getGroupId(), iu.map().getArtifactId(), iu.getVersionFormat());
				metadataCollector.put(key, md);
			}
			md.addVersion(iu.getMappedVersion()); // will potentially be mapped to the global VersionFormat during saveXMLs
		}

		for(InstallableUnitMapping child : iu.getChildren())
			savePOMs(root, child, uriConverter, digests, metadataCollector, errors);
	}

	private static void saveXMLs(URI root, URIConverter uriConverter, MessageDigest[] digests,
			Map<String, MavenMetadataHelper> metadataCollector) throws CoreException {
		String timestamp = String.format("%1$tY%1$tm%1$td%1$tH%1$tM%1$tS", new Date());

		for(MavenMetadataHelper mdh : metadataCollector.values()) {
			mdh.finalizeMetadata();
			VersionFormat versionFormat = mdh.getVersionFormat();

			MavenMetadata mdConainter = new MavenMetadata();
			MetaData md = mdConainter.getMetaData();
			md.setGroupId(mdh.getGroupId());
			md.setArtifactId(mdh.getArtifactId());
			md.setVersion("1");
			Versioning versioning = MetadataFactory.eINSTANCE.createVersioning();
			md.setVersioning(versioning);
			versioning.setLastUpdated(timestamp);
			Version release = mdh.getRelease();
			if(release != null)
				versioning.setRelease(VersionUtil.getVersionString(release, versionFormat));
			Versions versions = MetadataFactory.eINSTANCE.createVersions();
			versioning.setVersions(versions);
			List<String> versionList = versions.getVersion();
			for(Version version : mdh.getVersions())
				versionList.add(VersionUtil.getVersionString(version, versionFormat));

			URI xmlUri = createXmlURI(root, mdh);
			mdConainter.save(xmlUri);
			createCheckSum(xmlUri, uriConverter, digests);
			
			if (versionFormat == VersionFormat.MAVEN_SNAPSHOT) {
				for (Version version : mdh.getVersions()) {
					mdConainter = new MavenMetadata();
					md = mdConainter.getMetaData();
					md.setGroupId(mdh.getGroupId());
					md.setArtifactId(mdh.getArtifactId());
					String versionString = VersionUtil.getVersionString(version, versionFormat);
					md.setVersion(versionString);

					versioning = MetadataFactory.eINSTANCE.createVersioning();
					md.setVersioning(versioning);
					versioning.setLastUpdated(timestamp);

					Snapshot snapshot = MetadataFactory.eINSTANCE.createSnapshot();
					versioning.setSnapshot(snapshot);
					snapshot.setTimestamp(timestamp);
					String versionQualifier = VersionUtil.getVersionQualifier(versionString);
					if (versionQualifier != null)
						snapshot.setBuildNumber(versionQualifier);

					SnapshotVersions snapVersions = MetadataFactory.eINSTANCE.createSnapshotVersions();
					versioning.setSnapshotVersions(snapVersions);
					EList<SnapshotVersion> snapVersionList = snapVersions.getSnapshotVersion();
					for (String extension : new String[] { "jar", "pom" }) {
						SnapshotVersion snapshotVersion = MetadataFactory.eINSTANCE.createSnapshotVersion();
						snapVersionList.add(snapshotVersion);
						snapshotVersion.setExtension(extension);
						snapshotVersion.setValue(VersionUtil.getVersionString(version, versionFormat));
						snapshotVersion.setUpdated(timestamp);
					}
					xmlUri = createSnapshotXmlURI(root, mdh, version);
					mdConainter.save(xmlUri);
					createCheckSum(xmlUri, uriConverter, digests);
				}
			}
		}
	}

}
