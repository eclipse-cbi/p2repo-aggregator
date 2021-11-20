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

import java.util.Collection;
import java.util.Map;

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
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;

/**
 * @author Filip Hrbek (filip.hrbek@cloudsmith.com)
 *
 */
public class InstallableUnitOverrider implements IInstallableUnit {
	private IInstallableUnit installableUnit;

	private String id;

	private Collection<IRequirement> requirements;

	private Collection<IArtifactKey> artifacts;

	public InstallableUnitOverrider(IInstallableUnit iu) {
		installableUnit = iu;
	}

	@Override
	public int compareTo(IInstallableUnit other) {
		return installableUnit.compareTo(other);
	}

	@Override
	public Collection<IArtifactKey> getArtifacts() {
		if(artifacts != null)
			return artifacts;

		return installableUnit.getArtifacts();
	}

	@Override
	public ICopyright getCopyright() {
		return installableUnit.getCopyright();
	}

	@Override
	public ICopyright getCopyright(String locale) {
		return installableUnit.getCopyright(locale);
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
		if(id != null)
			return id;

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

	@Override
	public Collection<IRequirement> getMetaRequirements() {
		return installableUnit.getMetaRequirements();
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

	@Override
	public Collection<IRequirement> getRequirements() {
		if(requirements != null)
			return requirements;

		return installableUnit.getRequirements();
	}

	@Override
	public Collection<ITouchpointData> getTouchpointData() {
		return installableUnit.getTouchpointData();
	}

	@Override
	public ITouchpointType getTouchpointType() {
		return installableUnit.getTouchpointType();
	}

	@Override
	public IUpdateDescriptor getUpdateDescriptor() {
		return installableUnit.getUpdateDescriptor();
	}

	@Override
	public Version getVersion() {
		return installableUnit.getVersion();
	}

	@Override
	public boolean isResolved() {
		return installableUnit.isResolved();
	}

	@Override
	public boolean isSingleton() {
		return installableUnit.isSingleton();
	}

	public void overrideArtifacts(Collection<IArtifactKey> artifacts) {
		this.artifacts.clear();
		this.artifacts.addAll(artifacts);
	}

	public void overrideId(String id) {
		this.id = id;
	}

	public void overrideRequirements(Collection<IRequirement> requirements) {
		this.requirements.clear();
		this.requirements.addAll(requirements);
	}

	@Override
	public boolean satisfies(IRequirement candidate) {
		return installableUnit.satisfies(candidate);
	}

	@Override
	public IInstallableUnit unresolved() {
		return installableUnit.unresolved();
	}

}
