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
import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.ExclusionRule;
import org.eclipse.cbi.p2repo.aggregator.MapRule;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MappedUnit;
import org.eclipse.cbi.p2repo.aggregator.ValidConfigurationsRule;
import org.eclipse.cbi.p2repo.aggregator.provider.AggregatorEditPlugin;
import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.DragAndDropFeedback;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;

/**
 * @author Karel Brezina
 *
 */
public class AddIUsToMappedRepositoryCommand extends AbstractCommand implements DragAndDropFeedback {
	private MappedRepository mappedRepo;

	private List<IInstallableUnit> selectedIUs;

	private int operation;

	private List<MappedUnit> addedMappedUnits = new ArrayList<MappedUnit>();

	private List<MapRule> addedMapRules = new ArrayList<MapRule>();

	public AddIUsToMappedRepositoryCommand(MappedRepository mappedRepo, List<IInstallableUnit> selectedIUs) {
		this(mappedRepo, selectedIUs, AggregatorEditPlugin.ADD_IU);
	}

	public AddIUsToMappedRepositoryCommand(MappedRepository mappedRepo, List<IInstallableUnit> selectedIUs,
			int operation) {
		super(AggregatorEditPlugin.INSTANCE.getString("_UI_Map_to_command_prefix") + " " +
				AggregatorEditPlugin.INSTANCE.getString("_UI_MappedRepository_type") + " " + mappedRepo.getLocation());

		this.mappedRepo = mappedRepo;
		this.selectedIUs = selectedIUs;
		this.operation = operation;
	}

	@Override
	public void execute() {
		addedMappedUnits.clear();
		addedMapRules.clear();

		if((operation & AggregatorEditPlugin.ADD_IU) > 0)
			for(IInstallableUnit iu : selectedIUs) {
				MappedUnit newMU = ItemUtils.addIU(mappedRepo, iu);
				if(newMU != null)
					addedMappedUnits.add(newMU);
			}
		else if((operation & (AggregatorEditPlugin.ADD_EXCLUSION_RULE | AggregatorEditPlugin.ADD_VALID_CONFIGURATIONS_RULE)) > 0)
			for(IInstallableUnit iu : selectedIUs) {
				MapRule newMR = ItemUtils.addMapRule(
					mappedRepo, iu, (operation & AggregatorEditPlugin.ADD_EXCLUSION_RULE) > 0
							? ExclusionRule.class
							: ValidConfigurationsRule.class);
				if(newMR != null)
					addedMapRules.add(newMR);
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

	@Override
	protected boolean prepare() {
		boolean result = mappedRepo != null && mappedRepo.isBranchEnabled() && selectedIUs != null &&
				selectedIUs.size() > 0 && ItemUtils.haveSameLocation(mappedRepo, selectedIUs);

		if(result)
			for(IInstallableUnit iu : selectedIUs)
				if(ItemUtils.findMappedUnit(mappedRepo, iu) != null || ItemUtils.findMapRule(mappedRepo, iu) != null)
					return false;

		return result;
	}

	@Override
	public void redo() {
		execute();
	}

	@Override
	public void undo() {
		for(MappedUnit unit : addedMappedUnits) {
			MappedRepository repo = (MappedRepository) ((EObject) unit).eContainer();
			repo.removeUnit(unit);
		}

		for(MapRule rule : addedMapRules) {
			MappedRepository repo = (MappedRepository) ((EObject) rule).eContainer();
			repo.getMapRules().remove(rule);
		}
	}

	// validated prior command creation
	@Override
	public boolean validate(Object owner, float location, int operations, int operation, Collection<?> collection) {
		return true;
	}
}
