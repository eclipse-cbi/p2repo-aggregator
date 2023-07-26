/**
 * Copyright (c) 2023 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.presentation;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.Bundle;
import org.eclipse.cbi.p2repo.aggregator.ExclusionRule;
import org.eclipse.cbi.p2repo.aggregator.Feature;
import org.eclipse.cbi.p2repo.aggregator.MapRule;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MappedUnit;
import org.eclipse.cbi.p2repo.aggregator.Product;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.jface.action.Action;

public class MapAllUnitsAction extends Action {

	private final MappedRepository mappedRepository;
	private final EditingDomain editingDomain;

	public MapAllUnitsAction(List<?> objects, EditingDomain editingDomain) {
		super("Explicitly Map All Units");
		mappedRepository = objects.size() == 1 && objects.get(0) instanceof MappedRepository
				? (MappedRepository) objects.get(0)
				: null;
		this.editingDomain = editingDomain;
		setEnabled(mappedRepository != null);
	}

	@Override
	public void run() {
		EObject rootContainer = EcoreUtil.getRootContainer((EObject) mappedRepository);
		boolean excludeSource = rootContainer instanceof Aggregation
				&& ((Aggregation) rootContainer).isIncludeSources();
		Map<String, MapRule> excludedKeys = new TreeMap<>();
		EList<MapRule> exclusionRules = mappedRepository.getMapRules();
		for (MapRule mapRule : exclusionRules) {
			if (mapRule instanceof ExclusionRule) {
				String name = mapRule.getName();
				VersionRange versionRange = mapRule.getVersionRange();
				String key = name + "_" + versionRange;
				excludedKeys.put(key, mapRule);
			}
		}

		MetadataRepository metadataRepository = mappedRepository.getMetadataRepository();
		MappedRepository prototype = AggregatorFactory.eINSTANCE.createMappedRepository();

		EList<IInstallableUnit> installableUnits = metadataRepository.getInstallableUnits();
		for (IInstallableUnit iu : installableUnits) {
			try {
				if (!excludeSource
						|| !iu.getId().endsWith(".source") && !iu.getId().endsWith(".source.feature.group")) {
					MappedUnit mappedUnit = AggregatorFactory.eINSTANCE.createMappedUnit(iu);
					Version version = iu.getVersion();
					VersionRange versionRange = new VersionRange(version, true, version, true);
					mappedUnit.setVersionRange(versionRange);
					String id = mappedUnit.getName();
					String key = id + "_" + versionRange;
					MapRule mapRule = excludedKeys.get(key);
					if (mapRule == null) {
						prototype.addUnit(mappedUnit);
					}
				}
			} catch (IllegalArgumentException ex) {
				//$FALL-THROUGH$
			}
		}

		editingDomain.getCommandStack().execute(new ChangeCommand((Notifier) mappedRepository) {
			@Override
			public String getLabel() {
				return getText();
			}

			@Override
			protected void doExecute() {
				EList<Bundle> bundles = mappedRepository.getBundles();
				bundles.clear();
				bundles.addAll(prototype.getBundles());

				EList<Feature> features = mappedRepository.getFeatures();
				features.clear();
				features.addAll(prototype.getFeatures());

				EList<Product> products = mappedRepository.getProducts();
				products.clear();
				products.addAll(prototype.getProducts());

				EList<MapRule> mapRules = mappedRepository.getMapRules();
				mapRules.removeAll(excludedKeys.values());
				mapRules.addAll(excludedKeys.values());
			}
		});
	}

}
