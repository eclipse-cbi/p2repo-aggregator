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

package org.eclipse.cbi.p2repo.aggregator.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.CustomCategory;
import org.eclipse.cbi.p2repo.aggregator.Feature;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MappedUnit;
import org.eclipse.cbi.p2repo.aggregator.provider.AggregatorEditPlugin;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DragAndDropFeedback;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;

/**
 * @author Karel Brezina
 *
 */
public class AddIUsToCustomCategoryCommand extends AbstractCommand implements DragAndDropFeedback {
	private CustomCategory customCategory;

	private Map<IInstallableUnit, MappedRepository> mapFeatureMappedRepo = new HashMap<IInstallableUnit, MappedRepository>();

	private List<IInstallableUnit> selectedFeatures;

	private List<Feature> featuresAddedToCustomCategory = new ArrayList<Feature>();

	private Map<MappedRepository, List<MappedUnit>> unitsAddedToMappedRepo = new HashMap<MappedRepository, List<MappedUnit>>();

	public AddIUsToCustomCategoryCommand(CustomCategory category, List<IInstallableUnit> selectedFeatures) {
		super(AggregatorEditPlugin.INSTANCE.getString("_UI_Add_to_command_prefix") + " " +
				((category.getLabel() == null || category.getLabel().length() == 0)
						? AggregatorEditPlugin.INSTANCE.getString("_UI_Category_type") + " ''"
						: AggregatorEditPlugin.INSTANCE.getString("_UI_Category_type") + " " + category.getLabel()));

		this.selectedFeatures = selectedFeatures;
		customCategory = category;
	}

	@Override
	public void execute() {
		featuresAddedToCustomCategory.clear();
		unitsAddedToMappedRepo.clear();

		for(IInstallableUnit feature : selectedFeatures) {
			MappedRepository repo = mapFeatureMappedRepo.get(feature);

			if(!repo.isBranchEnabled())
				continue;

			MappedUnit unit = ItemUtils.findMappedUnit(repo, feature);

			if(unit == null) {
				unit = AggregatorFactory.eINSTANCE.createMappedUnit(feature);
				repo.addUnit(unit);

				List<MappedUnit> units = unitsAddedToMappedRepo.get(repo);
				if(units == null) {
					units = new ArrayList<MappedUnit>();
					unitsAddedToMappedRepo.put(repo, units);
				}
				units.add(unit);
			}
			else if(!unit.isBranchEnabled())
				continue;

			if(unit instanceof Feature) {
				customCategory.getFeatures().add((Feature) unit);
				featuresAddedToCustomCategory.add((Feature) unit);
			}
		}
	}

	@Override
	public int getFeedback() {
		return FEEDBACK_SELECT;
	}

	@Override
	public int getOperation() {
		return DROP_LINK;
	}

	private boolean isEnabled() {
		for(IInstallableUnit feature : mapFeatureMappedRepo.keySet()) {
			MappedRepository repo = mapFeatureMappedRepo.get(feature);

			if(repo == null)
				return false;

			MappedUnit unit = ItemUtils.findMappedUnit(repo, feature);

			if(unit != null && !unit.isBranchEnabled() || unit == null && repo != null && !repo.isBranchEnabled())
				return false;
		}

		return true;
	}

	@Override
	protected boolean prepare() {
		Aggregation aggregation = (Aggregation) ((EObject) customCategory).eContainer();

		for(IInstallableUnit feature : selectedFeatures) {
			if(!(((EObject) feature).eContainer() instanceof MetadataRepository))
				return false;

			MetadataRepository mdr = (MetadataRepository) ((EObject) feature).eContainer();

			MappedRepository mappedRepo = ItemUtils.findMappedRepository(aggregation, mdr);

			if(mappedRepo != null) {
				mapFeatureMappedRepo.put(feature, mappedRepo);

				if(ItemUtils.findMapRule(mappedRepo, feature) != null)
					return false;
			}
		}

		return customCategory != null && selectedFeatures != null && selectedFeatures.size() > 0 && isEnabled();
	}

	@Override
	public void redo() {
		execute();
	}

	@Override
	public void undo() {
		customCategory.getFeatures().removeAll(featuresAddedToCustomCategory);

		for(MappedRepository mappedRepo : unitsAddedToMappedRepo.keySet())
			for(MappedUnit unit : unitsAddedToMappedRepo.get(mappedRepo))
				mappedRepo.removeUnit(unit);
	}

	// validated prior command creation
	@Override
	public boolean validate(Object owner, float location, int operations, int operation, Collection<?> collection) {
		return true;
	}
}
