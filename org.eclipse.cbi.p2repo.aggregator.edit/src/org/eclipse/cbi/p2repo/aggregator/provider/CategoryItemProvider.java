/**
 * Copyright (c) 2021 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.Category;
import org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.QueryUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.aggregator.Category} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CategoryItemProvider extends MappedUnitItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CategoryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This adds a property descriptor for the Label Override feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLabelOverridePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Category_labelOverride_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Category_labelOverride_feature",
								"_UI_Category_type"),
						AggregatorPackage.Literals.CATEGORY__LABEL_OVERRIDE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
		return container.getCategories();
	}

	/**
	 * This returns Category.gif.
	 *
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Category"
				+ (!((Category) object).isBranchDisabledOrMappedRepositoryBroken() ? "" : "Disabled")));
	}

	@Override
	protected IQuery<IInstallableUnit> getInstallableUnitQuery() {
		return QueryUtil.createIUCategoryQuery();
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

			addLabelOverridePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns the label text for the adapted class.
	 *
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		Category category = (Category) object;
		IInstallableUnit iu = category.resolveAsSingleton();
		StringBuilder bld = new StringBuilder();
		bld.append(getString("_UI_Category_type"));
		bld.append(" : ");
		if (iu != null) {
			String label = iu.getProperty(IInstallableUnit.PROP_NAME);
			if (label == null)
				label = iu.getId();
			bld.append(label);
			if (!category.isEnabled())
				bld.append(" - disabled");
		} else
			bld.append("not mapped");
		return bld.toString();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(Category.class)) {
			case AggregatorPackage.CATEGORY__LABEL_OVERRIDE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}
}
