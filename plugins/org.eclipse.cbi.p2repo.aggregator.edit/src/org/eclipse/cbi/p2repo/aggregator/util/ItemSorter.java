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

import org.eclipse.cbi.p2repo.aggregator.InstallableUnitType;
import org.eclipse.cbi.p2repo.aggregator.p2view.Feature;
import org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation;
import org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView;
import org.eclipse.cbi.p2repo.aggregator.p2view.Product;
import org.eclipse.cbi.p2repo.p2.InstallableUnit;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.emf.ecore.EObject;

/**
 * Sorts items into several groups, new groups can be added
 *
 * @author Karel Brezina
 */
public class ItemSorter {
	public static enum ItemGroup {
		MDR, IU, FEATURE, MDR_STRUCTURED, IU_STRUCTURED, FEATURE_STRUCTURED, PRODUCT_STRUCTURED, OTHER
	}

	private final Map<ItemGroup, List<?>> groups = new HashMap<ItemGroup, List<?>>();

	private int totalItemCount;

	public ItemSorter(Collection<?> items) {
		List<InstallableUnit> ius = new ArrayList<InstallableUnit>();
		List<InstallableUnit> features = new ArrayList<InstallableUnit>();
		List<MetadataRepository> mdrs = new ArrayList<MetadataRepository>();

		List<IUPresentation> iups = new ArrayList<IUPresentation>();
		List<Feature> structuredFeatures = new ArrayList<Feature>();
		List<Product> structuredProducts = new ArrayList<Product>();
		List<MetadataRepositoryStructuredView> mdrsvs = new ArrayList<MetadataRepositoryStructuredView>();

		List<Object> others = new ArrayList<Object>();

		if(items != null)
			for(Object item : items) {
				totalItemCount++;

				if(item instanceof InstallableUnit) {
					InstallableUnit iu = (InstallableUnit) item;
					if(((EObject) iu).eContainer() instanceof MetadataRepository &&
							InstallableUnitUtils.getType(iu) != InstallableUnitType.OTHER) {
						ius.add(iu);

						if(InstallableUnitUtils.getType(iu) == InstallableUnitType.FEATURE)
							features.add(iu);
					}
					else
						others.add(item);
				}
				else if(item instanceof MetadataRepository)
					mdrs.add((MetadataRepository) item);
				else if(item instanceof IUPresentation) {
					IUPresentation iup = (IUPresentation) item;
					if(iup.getType() != InstallableUnitType.OTHER) {
						iups.add(iup);

						if(iup.getType() == InstallableUnitType.FEATURE)
							structuredFeatures.add((Feature) iup);
						else if(iup.getType() == InstallableUnitType.PRODUCT)
							structuredProducts.add((Product) iup);
					}
					else
						others.add(item);
				}
				else if(item instanceof MetadataRepositoryStructuredView)
					mdrsvs.add((MetadataRepositoryStructuredView) item);
				else
					others.add(item);
			}

		groups.put(ItemGroup.MDR, mdrs);
		groups.put(ItemGroup.IU, ius);
		groups.put(ItemGroup.FEATURE, features);
		groups.put(ItemGroup.MDR_STRUCTURED, mdrsvs);
		groups.put(ItemGroup.IU_STRUCTURED, iups);
		groups.put(ItemGroup.FEATURE_STRUCTURED, structuredFeatures);
		groups.put(ItemGroup.PRODUCT_STRUCTURED, structuredProducts);
		groups.put(ItemGroup.OTHER, others);
	}

	public List<?> getGroupItems(ItemGroup group) {
		return groups.get(group);
	}

	public int getTotalItemCount() {
		return totalItemCount;
	}
}
