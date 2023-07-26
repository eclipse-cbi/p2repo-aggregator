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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.ExclusionRule;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MappedUnit;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.ChangeCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.jface.action.Action;

public class ConvertToExclusionRule extends Action {

	private final List<MappedUnit> mappedUnits = new ArrayList<>();
	private final EditingDomain editingDomain;

	public ConvertToExclusionRule(List<?> objects, EditingDomain editingDomain) {
		super("Convert to Exclusion Rule");

		for (Object object : objects) {
			if (object instanceof MappedUnit) {
				MappedUnit mappedUnit = (MappedUnit) object;
				EObject eContainer = ((EObject) mappedUnit).eContainer();
				if (eContainer instanceof MappedRepository) {
					mappedUnits.add(mappedUnit);
				}
			}
		}

		this.editingDomain = editingDomain;
		setEnabled(!mappedUnits.isEmpty());
	}

	@Override
	public void run() {
		Set<Notifier> containers = mappedUnits.stream().map(unit -> ((EObject) unit).eContainer())
				.collect(Collectors.toSet());
		editingDomain.getCommandStack().execute(new ChangeCommand(containers) {
			@Override
			public String getLabel() {
				return getText();
			}

			@Override
			protected void doExecute() {
				for (MappedUnit mappedUnit : mappedUnits) {
					MappedRepository mappedRespoitory = (MappedRepository) ((EObject) mappedUnit).eContainer();
					EcoreUtil.remove((EObject) mappedUnit);
					ExclusionRule exclusionRule = AggregatorFactory.eINSTANCE.createExclusionRule();
					exclusionRule.setName(mappedUnit.getName());
					exclusionRule.setVersionRange(mappedUnit.getVersionRange());
					mappedRespoitory.getMapRules().add(exclusionRule);
				}
			}
		});
	}

}
