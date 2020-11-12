/*******************************************************************************
 * Copyright (c) 2016-2020, Red Hat Inc. and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.cbi.tycho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.Configuration;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.CustomCategory;
import org.eclipse.cbi.p2repo.aggregator.Feature;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MappedUnit;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public class AggregatorToTycho {

	private Aggregation agg;
	private Set<String> enabledRepoLocations = new HashSet<>();

	public AggregatorToTycho(Aggregation agg) {
		this.agg = agg;
	}

	public Map<IPath, String> createTychoFiles() {
		this.enabledRepoLocations.clear();
		StringBuilder tychoRepositories = new StringBuilder();
		StringBuilder categoriesBuilder = new StringBuilder();
		StringBuilder unitsBuilder = new StringBuilder();
		StringBuilder onlyCategorizedUnitsBuilder = new StringBuilder();
		StringBuilder featureIncludesBuilder = new StringBuilder();
		for (CustomCategory category : agg.getCustomCategories()) {
			addCategory(category, categoriesBuilder);
		}
		for (Contribution contribution : agg.getAllContributions(false)) {
			for (MappedRepository repo : contribution.getRepositories()) {
				addTychoRepo(repo, tychoRepositories, contribution.isEnabled());
				for (MappedUnit unit : repo.getUnits(false)) {
					addUnit(unit, unitsBuilder, agg.getCustomCategories(), contribution.isEnabled() && repo.isEnabled());
					addFeatureIncludes(unit, featureIncludesBuilder, contribution.isEnabled() && repo.isEnabled());
					for (CustomCategory category : agg.getCustomCategories()) {
						if (category.getFeatures().contains(unit)) {
							addUnit(unit, onlyCategorizedUnitsBuilder, agg.getCustomCategories(), contribution.isEnabled() && repo.isEnabled() && unit.isEnabled());
						}
					}
				}
			}
		}
		StringBuilder targetEnvironments = new StringBuilder();
		for (Configuration targetConfig : agg.getConfigurations()) {
			targetEnvironments.append("<environment>\n");
			targetEnvironments.append("	<os>" + targetConfig.getOperatingSystem().getLiteral() + "</os>\n");
			targetEnvironments.append("	<ws>" + targetConfig.getWindowSystem().getLiteral() + "</ws>\n");
			targetEnvironments.append("	<arch>" + targetConfig.getArchitecture().getLiteral() + "</arch>\n");
			targetEnvironments.append("</environment>\n");
		}

		IPath[] files = new IPath[] {
			Path.fromOSString("categories/pom.xml"),
			Path.fromOSString("categories/category.xml"),
			Path.fromOSString("categories/removeUncategorized.xml")
		};
		Map<IPath, String> res = new HashMap<>();
		for (IPath path : files) {
			try (
				InputStream pomStream = getClass().getResourceAsStream(path.toString());
				BufferedReader pomReader = new BufferedReader(new InputStreamReader(pomStream));
			) {
				String line = null;
				StringBuilder pomXmlContent = new StringBuilder();
				while ((line = pomReader.readLine()) != null) {
					String newLine = line.replaceAll("__tychoRepositories__", tychoRepositories.toString());
					newLine = newLine.replaceAll("__aggregationFileName__", agg.getLabel());
					newLine = newLine.replaceAll("__categories__", categoriesBuilder.toString());
					newLine = newLine.replaceAll("__fileName__", agg.getLabel());
					newLine = newLine.replaceAll("__description__", agg.getDescription());
					newLine = newLine.replaceAll("__featureIncludes__", featureIncludesBuilder.toString());
					newLine = newLine.replaceAll("__units__", unitsBuilder.toString());
					newLine = newLine.replaceAll("__onlyCategorizedUnits__", onlyCategorizedUnitsBuilder.toString());
					newLine = newLine.replaceAll("__environments__", targetEnvironments.toString());
					pomXmlContent.append(newLine);
					pomXmlContent.append(System.lineSeparator());
				}
				res.put(Path.fromOSString(path.toString()), pomXmlContent.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return res;
	}

	private void addUnit(MappedUnit unit, final StringBuilder unitsBuilder, List<CustomCategory> allCategories, boolean parentEnabled) {
		if (!(parentEnabled && unit.isEnabled())) {
			unitsBuilder.append(" <!-- disabled");
		}
		boolean isFeature = unit.getName().endsWith(".feature.group");
		String unitType = isFeature ? "feature" : "bundle";
		unitsBuilder.append("<");
		unitsBuilder.append(unitType);
		unitsBuilder.append(" id=\"");
		unitsBuilder.append(isFeature ? unit.getName().substring(0, unit.getName().length() - ".feature.group".length()) : unit.getName());
		unitsBuilder.append("\" range=\"");
		unitsBuilder.append(unit.getVersionRange().toString());
		unitsBuilder.append('"');
		if (unit.getFilter() != null) {
			Arrays.stream(unit.getFilter().getParameters()) //
				.map(Object::toString)
				.forEach(filter -> {
					find("osgi.os", filter).map(os -> " os=\"" + os + '"').ifPresent(unitsBuilder::append);
					find("osgi.ws", filter).map(os -> " ws=\"" + os + '"').ifPresent(unitsBuilder::append);
					find("osgi.arch", filter).map(os -> " arch=\"" + os + '"').ifPresent(unitsBuilder::append);
				});
		}
		unitsBuilder.append('>');
		unitsBuilder.append(System.lineSeparator());
		allCategories.stream().filter(category -> category.getFeatures().contains(unit)).forEach(category -> {
			unitsBuilder.append("  <category name=\"");
			unitsBuilder.append(category.getIdentifier());
			unitsBuilder.append("\"/>");
			unitsBuilder.append(System.lineSeparator());
		});
		unitsBuilder.append("</");
		unitsBuilder.append(unitType);
		unitsBuilder.append('>');
		if (!(parentEnabled && unit.isEnabled())) {
			unitsBuilder.append(" -->");
		}
		unitsBuilder.append(System.lineSeparator());
	}

	private Optional<String> find(String pattern, String source) {
		int index = source.indexOf(pattern + '=');
		if (index < 0) {
			return Optional.empty();
		}
		index += pattern.length() + 1;
		int closingbraceIndex = source.indexOf(')', index);
		return Optional.of(source.substring(index, closingbraceIndex));
	}

	private void addCategory(CustomCategory category, StringBuilder categoriesBuilder) {
		 categoriesBuilder.append("<category-def name=\"");
		 categoriesBuilder.append(category.getIdentifier());
		 categoriesBuilder.append("\" label=\"");
		 categoriesBuilder.append(category.getLabel());
		 categoriesBuilder.append("\">");
		 categoriesBuilder.append(System.lineSeparator());
		 categoriesBuilder.append("  <description>");
		 categoriesBuilder.append(System.lineSeparator());
		 categoriesBuilder.append(category.getDescription());
		 categoriesBuilder.append(System.lineSeparator());
		 categoriesBuilder.append("  </description>");
		 categoriesBuilder.append(System.lineSeparator());
	     categoriesBuilder.append("</category-def>");
	     categoriesBuilder.append(System.lineSeparator());
	}

	private void addTychoRepo(MappedRepository repo, StringBuilder tychoRepoBuilder, boolean parentEnabled) {
		if (this.enabledRepoLocations.contains(repo.getLocation())) {
			return;
		}
		if (!(parentEnabled && repo.isEnabled())) {
			tychoRepoBuilder.append("<!-- disabled\n");
		}
		tychoRepoBuilder.append("<repository>\n");
		tychoRepoBuilder.append("	<id>");
		tychoRepoBuilder.append(repo.getDescription() != null && !repo.getDescription().isBlank() ? repo.getDescription() : makeId(repo.getLocation()));
		tychoRepoBuilder.append("</id>");
		tychoRepoBuilder.append(System.lineSeparator());
		tychoRepoBuilder.append("	<url>");
		tychoRepoBuilder.append(repo.getLocation());
		tychoRepoBuilder.append("</url>\n");
		tychoRepoBuilder.append("	<layout>p2</layout>\n");
		tychoRepoBuilder.append("</repository>\n");
		if (!(parentEnabled && repo.isEnabled())) {
			tychoRepoBuilder.append("-->\n");
		} else {
			this.enabledRepoLocations.add(repo.getLocation());
		}
	}

	private String makeId(String url) {
		return URI.create(url).getPath().replaceAll("/", "_");
	}

	private void addFeatureIncludes(MappedUnit unit, StringBuilder featureIncludes, boolean parentEnabled) {
		if (unit instanceof Feature) {
			if (!(parentEnabled && unit.isEnabled())) {
				featureIncludes.append("<!-- disabled ");
			}
			featureIncludes.append("<includes id='");
			featureIncludes.append(unit.getName().endsWith(".feature.group") ? unit.getName().substring(0, unit.getName().length() - ".feature.group".length()) : unit.getName());
			featureIncludes.append("' version='");
			String version = "0.0.0";
			if (unit.getVersionRange().getMinimum().equals(unit.getVersionRange().getMaximum())) {
				version = unit.getVersionRange().getMinimum().toString();
			}
			featureIncludes.append(version);
			featureIncludes.append("' optional='true'/>");
			if (!(parentEnabled && unit.isEnabled())) {
				featureIncludes.append(" -->");
			}
			featureIncludes.append(System.lineSeparator());
		} else {
			featureIncludes.append("<!-- Not supported ");
			featureIncludes.append(unit.toString());
			featureIncludes.append(" -->");
			featureIncludes.append(System.lineSeparator());
		}
	}
}
