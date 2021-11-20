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
package org.eclipse.cbi.p2repo.aggregator.p2view.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.Status;
import org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryBrowser;
import org.eclipse.cbi.p2repo.aggregator.p2view.impl.RepositoryBrowserImpl;
import org.eclipse.cbi.p2repo.aggregator.provider.AggregatorEditPlugin;
import org.eclipse.cbi.p2repo.aggregator.provider.AggregatorItemProviderAdapter;
import org.eclipse.cbi.p2repo.aggregator.util.OverlaidImage;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemFontProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryBrowser} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class RepositoryBrowserItemProvider extends AggregatorItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource, IItemColorProvider, IItemFontProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositoryBrowserItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This adds a property descriptor for the Loading feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLoadingPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_RepositoryBrowser_loading_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_RepositoryBrowser_loading_feature",
								"_UI_RepositoryBrowser_type"),
						P2viewPackage.Literals.REPOSITORY_BROWSER__LOADING, false, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Repositories feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRepositoriesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_RepositoryBrowser_repositories_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_RepositoryBrowser_repositories_feature",
								"_UI_RepositoryBrowser_type"),
						P2viewPackage.Literals.REPOSITORY_BROWSER__REPOSITORIES, false, false, true, null, null, null));
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

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(P2viewPackage.Literals.REPOSITORY_BROWSER__REPOSITORIES);
		}
		return childrenFeatures;
	}

	/**
	 * This returns RepositoryBrowser.gif with possible overlays
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {

		ResourceLocator locator = getResourceLocator();
		Object baseImage = locator.getImage("full/obj16/RepositoryBrowser");

		RepositoryBrowserImpl mdrs = (RepositoryBrowserImpl) object;
		Status status = mdrs.getStatus();
		Object overlayImage;
		switch (status.getCode()) {
			case BROKEN:
				overlayImage = locator.getImage("full/ovr16/Error");
				break;
			case WAITING:
				overlayImage = locator.getImage("full/ovr16/Loading");
				break;
			default:
				overlayImage = null;
		}
		if (overlayImage != null) {
			Object[] images = new Object[2];
			int[] positions = new int[2];

			images[0] = baseImage;
			positions[0] = OverlaidImage.BASIC;

			images[1] = overlayImage;
			positions[1] = OverlaidImage.OVERLAY_BOTTOM_RIGHT;

			return new OverlaidImage(images, positions);
		}
		return baseImage;
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

			addRepositoriesPropertyDescriptor(object);
			addLoadingPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return AggregatorEditPlugin.INSTANCE;
	}

	/**
	 * This returns the label text for the adapted class.
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		RepositoryBrowser mdrs = (RepositoryBrowser) object;
		StringBuilder bld = new StringBuilder(getString("_UI_RepositoryBrowser_type"));
		if (mdrs.isLoading())
			bld.append(" : loading...");
		return bld.toString();
	}

	@Override
	public boolean hasChildren(Object object) {
		return true;
	}

	/**
	 * @generated NOT
	 */
	@Override
	public void notifyChanged(Notification notification) {
		notifyChangedGen(notification);
		Object notifier = notification.getNotifier();
		if (!(notifier instanceof RepositoryBrowser))
			return;

		RepositoryBrowser mdrs = (RepositoryBrowser) notifier;
		if (notification.getFeatureID(RepositoryBrowser.class) != P2viewPackage.REPOSITORY_BROWSER__LOADING)
			return;

		for (MetadataRepositoryStructuredView mdr : mdrs.getRepositories())
			fireNotifyChanged(new ViewerNotification(notification, mdr, false, true));
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

		switch (notification.getFeatureID(RepositoryBrowser.class)) {
			case P2viewPackage.REPOSITORY_BROWSER__STATUS:
			case P2viewPackage.REPOSITORY_BROWSER__LOADING:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

}
