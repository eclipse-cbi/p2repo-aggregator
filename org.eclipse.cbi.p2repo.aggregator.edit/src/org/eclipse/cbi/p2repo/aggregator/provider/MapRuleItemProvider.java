/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.provider;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.ExclusionRule;
import org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest;
import org.eclipse.cbi.p2repo.aggregator.MapRule;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.util.SpecialQueries;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.QueryUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.aggregator.MapRule} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MapRuleItemProvider extends InstallableUnitRequestItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MapRuleItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This adds a property descriptor for the Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_EnabledStatusProvider_enabled_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_EnabledStatusProvider_enabled_feature",
						"_UI_EnabledStatusProvider_type"),
				AggregatorPackage.Literals.ENABLED_STATUS_PROVIDER__ENABLED, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean shouldComposeCreationImage() {
		return true;
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	@Override
	protected List<? extends InstallableUnitRequest> getContainerChildren(MappedRepository container) {
		List<InstallableUnitRequest> featureRefs = new ArrayList<>();
		featureRefs.addAll(container.getMapRules());
		featureRefs.addAll(container.getFeatures());

		return featureRefs;
	}

	@Override
	protected IQuery<IInstallableUnit> getInstallableUnitQuery() {
		List<IQuery<IInstallableUnit>> queries = new ArrayList<>();
		queries.add(SpecialQueries.createProductQuery());
		queries.add(SpecialQueries.createFeatureQuery());
		queries.add(SpecialQueries.createBundleQuery());
		return QueryUtil.createCompoundQuery(queries, false);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addEnabledPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns the label text for the adapted class.
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		MapRule self = (MapRule) object;
		String name = self.getName();
		StringBuilder bld = new StringBuilder(getString("_UI_MapRule_type")).append(" : ");
		if (name != null)
			bld.append(name);
		return bld.toString();
	}

	/**
	 *
	 * @generated NOT
	 */
	@Override
	public void notifyChanged(Notification notification) {
		notifyChangedGen(notification);

		if (notification.getEventType() != Notification.SET)
			return;
		MapRule notifier = ((MapRule) notification.getNotifier());
		switch (notification.getFeatureID(ExclusionRule.class)) {
			case AggregatorPackage.EXCLUSION_RULE__NAME:
			case AggregatorPackage.EXCLUSION_RULE__VERSION_RANGE:
				fireNotifyChanged(new ViewerNotification(notification, notifier, true, false));

				Set<Object> affectedNodes = new HashSet<>();
				affectedNodes.add(notifier);

				// Go through all direct ancestors first
				EObject container = ((EObject) notifier).eContainer();
				affectedNodes.add(((EObject) notifier).eResource());
				while (container != null) {
					affectedNodes.add(container);
					container = container.eContainer();
				}
				for (Object affectedNode : affectedNodes)
					fireNotifyChanged(new ViewerNotification(notification, affectedNode, false, true));
				return;
		}
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void notifyChangedGen(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MapRule.class)) {
			case AggregatorPackage.MAP_RULE__ENABLED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}
}
