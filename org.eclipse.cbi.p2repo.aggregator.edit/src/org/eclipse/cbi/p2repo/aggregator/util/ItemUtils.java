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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.MapRule;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MappedUnit;
import org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation;
import org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;

/**
 * @author Karel Brezina
 *
 */
public class ItemUtils {

	/**
	 * Tries to add an InstallableUnit to a MappedRepository
	 *
	 * @param mappedRepo
	 *            mapped repository
	 * @param iu
	 *            installable unit
	 * @return null if the MappedRepository already contains the InstallableUnit or MappedUnit (created from the IU) if
	 *         the InstallableUnit was added
	 */
	public static MappedUnit addIU(MappedRepository mappedRepo, IInstallableUnit iu) {
		if(iu == null)
			return null;

		MappedUnit foundUnit = null;

		for(MappedUnit unit : mappedRepo.getUnits(false))
			if(iu.getId().equals(unit.getName())) {
				foundUnit = unit;
			}

		if(foundUnit != null)
			return null;

		MappedUnit newMU = AggregatorFactory.eINSTANCE.createMappedUnit(iu);
		mappedRepo.addUnit(newMU);

		return newMU;
	}

	/**
	 * Tries to add a MappedRule to a MappedRepository
	 *
	 * @param mappedRepo
	 *            mapped repository
	 * @param iu
	 *            installable unit
	 * @param ruleClass
	 *            defines which kind of rule is required
	 * @return null if the MappedRepository already contains a MapRule created from the InstallableUnit or MapRule
	 *         (created from the IU) if the InstallableUnit was added
	 */
	public static MapRule addMapRule(MappedRepository mappedRepo, IInstallableUnit iu,
			Class<? extends MapRule> ruleClass) {
		if(iu == null)
			return null;

		MapRule foundRule = null;

		for(MapRule rule : mappedRepo.getMapRules())
			if(iu.getId().equals(rule.getName())) {
				foundRule = rule;
			}

		if(foundRule != null)
			return null;

		MapRule newMR = AggregatorFactory.eINSTANCE.createMapRule(iu, ruleClass);
		mappedRepo.getMapRules().add(newMR);

		return newMR;
	}

	/**
	 * Tries to add a MetadataRepository to a Contribution
	 *
	 * @param contribution
	 *            contribution
	 * @param mdr
	 *            metadata repository
	 * @return null if the Contribution already contains the MetadataRepository or MappedRepository (created from the
	 *         MDR) if the MetadataRepository was added
	 */
	public static MappedRepository addMDR(Contribution contribution, MetadataRepository mdr) {
		if(mdr == null)
			return null;

		if(findMappedRepository(contribution, mdr) != null)
			return null;

		MappedRepository newMappedRepo = AggregatorFactory.eINSTANCE.createMappedRepository(mdr);
		contribution.getRepositories().add(newMappedRepo);

		return newMappedRepo;
	}

	public static MappedRepository findMappedRepository(Aggregation aggregator, MetadataRepository mdr) {
		for(Contribution contribution : aggregator.getAllContributions(true)) {
			MappedRepository repo = findMappedRepository(contribution, mdr);
			if(repo != null)
				return repo;
		}

		return null;
	}

	/**
	 * Searches for a MappedRepository with the same location
	 *
	 * @param mappedRepos
	 * @param mappedRepo
	 * @return
	 */
	public static MappedRepository findMappedRepository(Contribution contribution, MetadataRepository mdr) {
		if(mdr == null)
			return null;

		for(MappedRepository repo : contribution.getRepositories())
			if(mdr.equals(repo.getMetadataRepository(false)) && repo.isBranchEnabled())
				return repo;

		return null;
	}

	public static MappedUnit findMappedUnit(MappedRepository mappedRepo, IInstallableUnit iu) {
		for(MappedUnit unit : mappedRepo.getUnits(false))
			if(iu.getId().equals(unit.getName()))
				return unit;

		return null;
	}

	public static MapRule findMapRule(MappedRepository mappedRepo, IInstallableUnit iu) {
		for(MapRule rule : mappedRepo.getMapRules())
			if(iu.getId().equals(rule.getName()))
				return rule;

		return null;
	}

	public static Collection<? extends IInstallableUnit> getIUs(Collection<? extends IUPresentation> iups) {
		List<IInstallableUnit> set = new ArrayList<IInstallableUnit>();

		for(IUPresentation iup : iups)
			if(iup.getInstallableUnit() != null)
				set.add(iup.getInstallableUnit());

		return set;
	}

	public static Collection<MetadataRepository> getMDRs(Collection<? extends MetadataRepositoryStructuredView> mdrsvs) {
		Set<MetadataRepository> set = new HashSet<MetadataRepository>();

		for(MetadataRepositoryStructuredView mdrsv : mdrsvs)
			if(mdrsv.getMetadataRepository() != null)
				set.add(mdrsv.getMetadataRepository());

		return set;
	}

	/**
	 * Tests if selectedUIs come from a MDR with the same location as mappedRepo
	 *
	 * @param mappedRepo
	 * @param selectedIUs
	 * @return
	 */
	public static boolean haveSameLocation(MappedRepository mappedRepo,
			Collection<? extends IInstallableUnit> selectedIUs) {
		String location = mappedRepo.getResolvedLocation();

		if(location == null)
			return false;

		for(IInstallableUnit iu : selectedIUs) {
			if(!(((EObject) iu).eContainer() instanceof MetadataRepository))
				return false;
			MetadataRepository mdr = (MetadataRepository) ((EObject) iu).eContainer();
			if(mdr.getLocation() == null)
				return false;
			if(!(location.equalsIgnoreCase(mdr.getLocation().toString())))
				return false;
		}

		return true;
	}
}
