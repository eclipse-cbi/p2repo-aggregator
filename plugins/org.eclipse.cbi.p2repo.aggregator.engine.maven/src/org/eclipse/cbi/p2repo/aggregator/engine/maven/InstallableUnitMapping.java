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

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.Parent;
import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.Architecture;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.MavenItem;
import org.eclipse.cbi.p2repo.aggregator.MavenMapping;
import org.eclipse.cbi.p2repo.aggregator.OperatingSystem;
import org.eclipse.cbi.p2repo.aggregator.StatusCode;
import org.eclipse.cbi.p2repo.aggregator.VersionFormat;
import org.eclipse.cbi.p2repo.aggregator.WindowSystem;
import org.eclipse.cbi.p2repo.aggregator.util.InstallableUnitUtils;
import org.eclipse.cbi.p2repo.p2.maven.util.VersionUtil;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.equinox.internal.p2.metadata.IRequiredCapability;
import org.eclipse.equinox.internal.p2.metadata.InstallableUnit;
import org.eclipse.equinox.internal.p2.metadata.RequiredCapability;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.metadata.ICopyright;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IInstallableUnitFragment;
import org.eclipse.equinox.p2.metadata.ILicense;
import org.eclipse.equinox.p2.metadata.IProvidedCapability;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.ITouchpointData;
import org.eclipse.equinox.p2.metadata.ITouchpointType;
import org.eclipse.equinox.p2.metadata.IUpdateDescriptor;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.metadata.expression.IFilterExpression;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;

/**
 * @author Filip Hrbek (filip.hrbek@cloudsmith.com)
 *
 */
// Implement parent subtraction on all relevant getters (as an example, dependencies are implemented that way)
// However, repo optimization is not implemented yet, so it does not make much sense to do it now

public class InstallableUnitMapping implements IInstallableUnit {
	public enum Type {
		TOP, GROUP, IU, PROXY;
	}

	private static final String GENERIC_PLATFORM_SUFFIX = ".${osgi.platform}";

	private static final Set<String> KNOWN_OSGI_WS, KNOWN_OSGI_OS, KNOWN_OSGI_ARCH;
	static {
		Set<String> values = new HashSet<>();
		for(WindowSystem ws : WindowSystem.values())
			values.add(ws.getLiteral());
		KNOWN_OSGI_WS = Collections.unmodifiableSet(values);
		values = new HashSet<>();
		for(OperatingSystem os : OperatingSystem.values())
			values.add(os.getLiteral());
		KNOWN_OSGI_OS = Collections.unmodifiableSet(values);
		values = new HashSet<>();
		for(Architecture arch : Architecture.values())
			values.add(arch.getLiteral());
		KNOWN_OSGI_ARCH = Collections.unmodifiableSet(values);
	}

	private static final Version DUMMY_VERSION = Version.parseVersion("1");

	private Type type;

	private IInstallableUnit installableUnit;

	private List<MavenMapping> mappings;

	private MavenItem mapped;

	private InstallableUnitMapping parent;

	private List<InstallableUnitMapping> children = new ArrayList<InstallableUnitMapping>();

	private List<InstallableUnitMapping> siblings = new ArrayList<InstallableUnitMapping>();

	private boolean transientFlag;

	private IArtifactKey mainArtifact;

	private Contribution contribution;

	private VersionFormat versionFormat;

	private int mavenBuildNumber;

	private boolean hasSources;

	public InstallableUnitMapping(Contribution contribution, IInstallableUnit iu) {
		this(contribution, iu, Collections.<MavenMapping> emptyList());
	}

	public InstallableUnitMapping(Contribution contribution, IInstallableUnit iu, List<MavenMapping> mappings) {
		this.contribution = contribution;
		this.mappings = new ArrayList<MavenMapping>(mappings.size() + 1);
		this.mappings.addAll(mappings);
		this.mappings.add(MavenMapping.DEFAULT_MAPPING);

		for(MavenMapping mapping : mappings)
			if(mapping.getStatus().getCode() != StatusCode.OK)
				throw new RuntimeException("Invalid maven mapping: " + mapping.toString());

		switch(iu.getArtifacts().size()) {
			case 1:
				mainArtifact = iu.getArtifacts().iterator().next();
				// no break here, we really want to continue initialization
			case 0:
				type = Type.IU;
				installableUnit = iu;
				break;
			default:
				// We have more than one artifact - we need to make a proxy depending on the artifacts
				InstallableUnitOverrider proxy = new InstallableUnitOverrider(iu);
				List<IRequirement> dependencies = new ArrayList<IRequirement>(iu.getArtifacts().size());
				int idx = 0;
				for(IArtifactKey artifact : iu.getArtifacts()) {
					String genId = artifact.getId() + ".artifact-" + (idx + 1);
					dependencies.add(
						new RequiredCapability(
							NAMESPACE_IU_ID, genId, new VersionRange(iu.getVersion(), true, iu.getVersion(), true),
									null, 1, 1, true, null));
					InstallableUnitOverrider sibling = new InstallableUnitOverrider(iu);
					sibling.overrideId(genId);
					sibling.overrideArtifacts(Collections.singletonList(artifact));

					siblings.add(new InstallableUnitMapping(contribution, sibling));
				}

				proxy.overrideRequirements(dependencies);
				proxy.overrideArtifacts(Collections.<IArtifactKey> emptyList());
				installableUnit = proxy;
		}
		Aggregation aggregation = (Aggregation) ((EObject) contribution).eContainer().eContainer();
		versionFormat = aggregation.getVersionFormat();
		mavenBuildNumber = aggregation.getMavenBuildNumber();
	}

	public InstallableUnitMapping(String name) {
		String groupId = name;
		if(groupId == null)
			groupId = "_top";
		String artifactId = name == null
				? "_common"
				: "_group-common";

		type = name == null
				? Type.TOP
				: Type.GROUP;

		InstallableUnit installableUnit = new InstallableUnit();
		installableUnit.setId(artifactId);
		installableUnit.setVersion(DUMMY_VERSION);

		this.installableUnit = installableUnit;
		mapped = AggregatorFactory.eINSTANCE.createMavenItem();
		mapped.setGroupId(groupId);
		mapped.setArtifactId(artifactId);
	}

	public InstallableUnitMapping(VersionFormat versionFormat) {
		this((String) null);
		this.versionFormat = versionFormat;
	}

	public org.apache.maven.model.Model asPOM() throws CoreException {
		Model pom = new Model();
		if(parent != null && !parent.isTransient()) {
			Parent newParent = new Parent();
			newParent.setGroupId(parent.map().getGroupId());
			newParent.setArtifactId(parent.map().getArtifactId());
			newParent.setVersion(parent.getVersionString(false, -1));
			pom.setParent(newParent);
		}
		pom.setModelVersion("4.0");
		pom.setGroupId(map().getGroupId());
		pom.setArtifactId(map().getArtifactId());
		if(getMainArtifact() == null) {
			pom.setPackaging("pom");
		}

		if(getVersion() != null && !getVersion().equals(Version.emptyVersion)) {
			pom.setVersion(getVersionString(false, -1));
		}

		boolean hasPlatformFragmentDependency[] = { false };
		pom.setDependencies(getRequirements().stream() //
			.filter(IRequiredCapability.class::isInstance) //
			.map(IRequiredCapability.class::cast) //
				// only consider require-bundle so far
			.filter(req -> IInstallableUnit.NAMESPACE_IU_ID.equals(req.getNamespace())
						|| "osgi.bundle".equals(req.getNamespace()))
			.map(req -> {
				Dependency dependency = new Dependency();
					MavenItem dependencyMapping = map(req.getName(), mappings);
				dependency.setGroupId(dependencyMapping.getGroupId());
				String artifactId = dependencyMapping.getArtifactId();
				String generifiedId = generifyPlatformDependency(artifactId, req.getFilter());
				if(generifiedId != null) {
					if(hasPlatformFragmentDependency[0]) {
						return null; // don't add again
					}
					hasPlatformFragmentDependency[0] = true;
					artifactId = generifiedId;
				}
				dependency.setArtifactId(artifactId);
					if (req.getRange() != null && !req.getRange().equals(VersionRange.emptyRange)) {
						StringBuilder versionRangeString = new StringBuilder();
						Version low = req.getRange().getMinimum();
						Version high = req.getRange().getMaximum();
						if (req.getRange().getIncludeMinimum() && Version.MAX_VERSION.equals(high)) {
							versionRangeString.append("[").append(getVersionStringForDependency(dependencyMapping, low))
									.append(",)");
					}
					else {
							versionRangeString.append(req.getRange().getIncludeMinimum() ? '[' : '(');
							versionRangeString.append(getVersionStringForDependency(dependencyMapping, low));
							versionRangeString.append(',');
							versionRangeString.append(getVersionStringForDependency(dependencyMapping, high));
							versionRangeString.append(req.getRange().getIncludeMaximum() ? ']' : ')');
					}

						dependency.setVersion(versionRangeString.toString());
					} else {
						dependency.setVersion("[0.0,)");
				}
					dependency.setOptional(req.getMin() == 0);
					return dependency;
				}).filter(Objects::nonNull) //
				.collect(Collectors.toList()));

		Map<String, String> iuProperties = new HashMap<String, String>(installableUnit.getProperties());
		String name = extractProperty(iuProperties, IInstallableUnit.PROP_NAME);
		String description = extractProperty(iuProperties, IInstallableUnit.PROP_DESCRIPTION);

		if(name != null || description != null) {
			if(name != null) {
				if(description != null) {
					name = name + "\n\n";
				}
			}
			else
				name = "";

			if(description == null)
				description = "";

			pom.setDescription(name + description);
		}

		List<org.apache.maven.model.License> mavenLicenses = new ArrayList<>();
		installableUnit.getLicenses().stream() //
				.filter(license -> license.getLocation() != null || license.getBody() != null).map(license -> {
					org.apache.maven.model.License mavenLicense = new org.apache.maven.model.License();
					if (license.getLocation() != null) {
						mavenLicense.setUrl(license.getLocation().toString());
				}
					mavenLicense.setComments(license.getBody());
					return mavenLicense;
				}).forEach(mavenLicenses::add);

		ICopyright iuCopyright = installableUnit.getCopyright();
		if(iuCopyright != null && (iuCopyright.getLocation() != null || iuCopyright.getBody() != null)) {
			org.apache.maven.model.License copyright = new org.apache.maven.model.License();
			if(iuCopyright.getLocation() != null) {
				copyright.setUrl(iuCopyright.getLocation().toString());
			}
			copyright.setComments(iuCopyright.getBody());
			mavenLicenses.add(copyright);
		}
		pom.setLicenses(mavenLicenses);
		return pom;
	}

	@Override
	public int compareTo(IInstallableUnit other) {
		return installableUnit.compareTo(other);
	}

	private String extractProperty(Map<String, String> iuProperties, String key) {
		String value = iuProperties.remove(key);

		if(value != null) {
			if(value.startsWith("%")) {
				String localizedKey = "df_LT." + value.substring(1);
				String localizedValue = iuProperties.remove(localizedKey);

				if(localizedValue != null)
					value = localizedValue;
			}
		}

		return trimOrNull(value);
	}

	private String generifyPlatformDependency(String artifactId, IMatchExpression<IInstallableUnit> filter) {
		if(artifactId == null || filter == null)
			return null;
		String[] tokens = artifactId.split("\\.");
		if(tokens.length < 4)
			return null;
		Map<String, String> declared = new HashMap<>();
		int end = artifactId.length();
		int platformStart = tokens.length - 3;

		String token = tokens[platformStart];
		if(!KNOWN_OSGI_WS.contains(token))
			return null;
		declared.put("osgi.ws", token);
		end -= token.length() + 1;

		token = tokens[platformStart + 1];
		if(!KNOWN_OSGI_OS.contains(token))
			return null;
		declared.put("osgi.os", token);
		end -= token.length() + 1;

		token = tokens[platformStart + 2];
		if(!KNOWN_OSGI_ARCH.contains(token))
			return null;
		declared.put("osgi.arch", token);
		end -= token.length() + 1;

		if(!matchesFilter(filter, declared))
			return null;

		return artifactId.substring(0, end) + GENERIC_PLATFORM_SUFFIX;
	}

	private String getArtifactFileName() throws CoreException {
		return getFileName(null);
	}

	@Override
	public Collection<IArtifactKey> getArtifacts() {
		return installableUnit.getArtifacts();
	}

	public List<InstallableUnitMapping> getChildren() {
		return children;
	}

	public final Contribution getContribution() {
		return contribution;
	}

	@Override
	public ICopyright getCopyright() {
		return installableUnit.getCopyright();
	}

	@Override
	public ICopyright getCopyright(String locale) {
		return installableUnit.getCopyright(locale);
	}

	private String getFileName(String extension) throws CoreException {
		String fileId = mapped.getArtifactId();
		StringBuilder fileName = new StringBuilder(fileId);
		fileName.append('-');
		fileName.append(getVersionString(true, mavenBuildNumber));
		if(isSourceArtifact())
			fileName.append('-').append(mapped.getClassifier());

		if(extension == null) {
			if(!(getMainArtifact() != null && "binary".equals(getMainArtifact().getClassifier()))) {
				fileName.append(".jar");
			}
		}
		else {
			fileName.append('.');
			fileName.append(extension);
		}

		return fileName.toString();
	}

	@Override
	public IMatchExpression<IInstallableUnit> getFilter() {
		return installableUnit.getFilter();
	}

	@Override
	public Collection<IInstallableUnitFragment> getFragments() {
		return installableUnit.getFragments();
	}

	@Override
	public String getId() {
		return installableUnit.getId();
	}

	@Override
	public Collection<ILicense> getLicenses() {
		return installableUnit.getLicenses();
	}

	@Override
	public Collection<ILicense> getLicenses(String locale) {
		return installableUnit.getLicenses(locale);
	}

	public IArtifactKey getMainArtifact() {
		return mainArtifact;
	}

	public Version getMappedVersion() {
		if(this.mapped != null) {
			String mappedVersion = this.mapped.getMappedVersion();
			if(mappedVersion != null)
				return VersionUtil.mappedVersion(mappedVersion, this.versionFormat);
		}
		return installableUnit.getVersion();
	}

	@Override
	public Collection<IRequirement> getMetaRequirements() {
		return installableUnit.getMetaRequirements();
	}

	public InstallableUnitMapping getParent() {
		return parent;
	}

	public String getPomName() throws CoreException {
		return getFileName("pom");
	}

	@Override
	public Map<String, String> getProperties() {
		return installableUnit.getProperties();
	}

	@Override
	public String getProperty(String key) {
		return installableUnit.getProperty(key);
	}

	@Override
	public String getProperty(String key, String locale) {
		return installableUnit.getProperty(key, locale);
	}

	@Override
	public Collection<IProvidedCapability> getProvidedCapabilities() {
		return installableUnit.getProvidedCapabilities();
	}

	public String getRelativeFullPath() throws CoreException {
		return getRelativePath() + "/" + getArtifactFileName();
	}

	public String getRelativePath() throws CoreException {
		String artifactId = map().getArtifactId();
		String versionPath = getVersionString(false, -1);
		return map().getGroupId().replace('.', '/') + "/" + artifactId + "/" + versionPath;
	}

	@Override
	public Collection<IRequirement> getRequirements() {
		if(parent != null) {
			Collection<IRequirement> myList = new ArrayList<IRequirement>();
			Collection<IRequirement> parentList = parent.installableUnit.getRequirements();
			for(IRequirement my : installableUnit.getRequirements())
				if(!parentList.contains(my))
					myList.add(my);

			return myList;
		}

		return installableUnit.getRequirements();
	}

	public List<InstallableUnitMapping> getSiblings() {
		return siblings;
	}

	@Override
	public Collection<ITouchpointData> getTouchpointData() {
		return installableUnit.getTouchpointData();
	}

	@Override
	public ITouchpointType getTouchpointType() {
		return installableUnit.getTouchpointType();
	}

	public Type getType() {
		return type;
	}

	@Override
	public IUpdateDescriptor getUpdateDescriptor() {
		return installableUnit.getUpdateDescriptor();
	}

	@Override
	public Version getVersion() {
		return installableUnit.getVersion();
	}

	/**
	 * @return the version format to be used when generating for Maven.
	 */
	public VersionFormat getVersionFormat() {
		return versionFormat;
	}

	public String getVersionString(boolean fineGrained, int mavenBuildNumber) {
		if (this.mapped != null && this.mapped.getMappedVersion() != null) {
			String mappedVersion = this.mapped.getMappedVersion();
			if (!fineGrained && versionFormat == VersionFormat.MAVEN_SNAPSHOT)
				return VersionUtil.versionAsSnapshot(mappedVersion);
			return mappedVersion;
		}
		return VersionUtil.getVersionString(getVersion(), versionFormat, fineGrained, mavenBuildNumber);
	}

	public String getVersionStringForDependency(MavenItem dependencyMapping, Version dependencyVersion) {
		MavenMapping mavenMapping = dependencyMapping.getMavenMapping();
		if(mavenMapping != null) {
			String mappedVersion = mavenMapping.mapVersion(dependencyVersion);
			if(mappedVersion != null)
				return mappedVersion;
		}
		return VersionUtil.getVersionString(dependencyVersion, versionFormat, false, -1);
	}

	@Override
	public boolean isResolved() {
		return installableUnit.isResolved();
	}

	@Override
	public boolean isSingleton() {
		return installableUnit.isSingleton();
	}

	public boolean isSourceArtifact() {
		// consult p2 metadata:
		if(!InstallableUnitUtils.isSourceBundle(this.installableUnit))
			return false;
		try {
			// consult the mapped maven item:
			return map().isSources();
		}
		catch(CoreException e) {
			LogUtils.error(e, "Failed to map artifact {0}", getId());
			return false;
		}
	}

	public boolean isTransient() {
		return transientFlag;
	}

	public MavenItem map() throws CoreException {
		if(mapped != null)
			return mapped;

		mapped = map(getId(), mappings);
		if (mapped != null && this.versionFormat != VersionFormat.MAVEN_SNAPSHOT) {
			if (mapped.getMavenMapping().isSnapshot()) {
				versionFormat = VersionFormat.MAVEN_SNAPSHOT; // override global format
			} else { // fade out the following workaround?
				String mappedVersion = this.mapped.getMappedVersion();
				if (mappedVersion != null && mappedVersion.contains(VersionUtil.DASH_SNAPSHOT))
					versionFormat = VersionFormat.MAVEN_SNAPSHOT; // override global format
			}
		}
		return mapped;
	}

	private MavenItem map(String id, List<MavenMapping> mappings) throws InvalidParameterException {
		MavenItem item = null;

		for(MavenMapping mapping : mappings)
			if((item = mapping.map(id, getVersion())) != null)
				return item;

		StringBuilder mappingDescriptor = new StringBuilder();
		boolean first = true;
		for(MavenMapping mapping : mappings) {
			if(first)
				first = false;
			else
				mappingDescriptor.append(',');
			mappingDescriptor.append(mapping.toString());
		}

		throw new InvalidParameterException(String.format("Unable to map IU to maven artifact: id=%s, mappings=%s", id,
				mappingDescriptor.toString()));
	}

	private boolean matchesFilter(IMatchExpression<IInstallableUnit> filter, Map<String, String> map) {
		for(Object object : filter.getParameters()) {
			if(object instanceof IFilterExpression) {
				return ((IFilterExpression) object).match(map);
			}
		}
		return false;
	}

	public boolean satisfies(IRequiredCapability candidate) {
		return installableUnit.satisfies(candidate);
	}

	@Override
	public boolean satisfies(IRequirement candidate) {
		return installableUnit.satisfies(candidate);
	}

	public void setParent(InstallableUnitMapping parent) {
		if(this.parent != null)
			this.parent.children.remove(this);
		(this.parent = parent).children.add(this);
	}

	public void setTransient(boolean isTransient) {
		transientFlag = isTransient;
	}

	private String trimOrNull(String value) {
		if(value != null) {
			value = value.trim();
			if(value.length() == 0)
				value = null;
		}
		return value;
	}

	@Override
	public IInstallableUnit unresolved() {
		return installableUnit.unresolved();
	}

	public void setHasSources(boolean flag) {
		this.hasSources = flag;
	}

	public boolean hasSources() {
		return hasSources;
	}
}
