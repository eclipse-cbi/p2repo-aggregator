/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.aggregator.p2view.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.StatusCode;
import org.eclipse.cbi.p2repo.aggregator.p2.util.MetadataRepositoryResourceImpl;
import org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.cbi.p2repo.aggregator.provider.AggregatorEditPlugin;
import org.eclipse.cbi.p2repo.aggregator.provider.AggregatorItemProviderAdapter;
import org.eclipse.cbi.p2repo.aggregator.util.OverlaidImage;
import org.eclipse.cbi.p2repo.aggregator.util.ResourceUtils;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
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
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MetadataRepositoryStructuredViewItemProvider extends AggregatorItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource, IItemColorProvider, IItemFontProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MetadataRepositoryStructuredViewItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This adds a property descriptor for the Installable Unit List feature. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	protected void addInstallableUnitListPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_MetadataRepositoryStructuredView_installableUnitList_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_MetadataRepositoryStructuredView_installableUnitList_feature",
						"_UI_MetadataRepositoryStructuredView_type"),
				P2viewPackage.Literals.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST, false, false, true,
				null, null, null));
	}

	/**
	 * This adds a property descriptor for the Loaded feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLoadedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_MetadataRepositoryStructuredView_loaded_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_MetadataRepositoryStructuredView_loaded_feature",
						"_UI_MetadataRepositoryStructuredView_type"),
				P2viewPackage.Literals.METADATA_REPOSITORY_STRUCTURED_VIEW__LOADED, false, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Location feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLocationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_MetadataRepositoryStructuredView_location_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_MetadataRepositoryStructuredView_location_feature",
						"_UI_MetadataRepositoryStructuredView_type"),
				P2viewPackage.Literals.METADATA_REPOSITORY_STRUCTURED_VIEW__LOCATION, false, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_MetadataRepositoryStructuredView_name_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_MetadataRepositoryStructuredView_name_feature",
						"_UI_MetadataRepositoryStructuredView_type"),
				P2viewPackage.Literals.METADATA_REPOSITORY_STRUCTURED_VIEW__NAME, false, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Properties feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertiesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_MetadataRepositoryStructuredView_properties_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_MetadataRepositoryStructuredView_properties_feature",
								"_UI_MetadataRepositoryStructuredView_type"),
						P2viewPackage.Literals.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES, false, false, true,
						null, null, null));
	}

	/**
	 * This adds a property descriptor for the Repository References feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRepositoryReferencesPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_MetadataRepositoryStructuredView_repositoryReferences_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_MetadataRepositoryStructuredView_repositoryReferences_feature",
						"_UI_MetadataRepositoryStructuredView_type"),
				P2viewPackage.Literals.METADATA_REPOSITORY_STRUCTURED_VIEW__REPOSITORY_REFERENCES, false, false, true,
				null, null, null));
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(P2viewPackage.Literals.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST);
			childrenFeatures.add(P2viewPackage.Literals.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES);
			childrenFeatures.add(P2viewPackage.Literals.METADATA_REPOSITORY_STRUCTURED_VIEW__REPOSITORY_REFERENCES);
		}
		return childrenFeatures;
	}

	@Override
	public Object getFont(Object object) {
		MetadataRepositoryResourceImpl mdr = (MetadataRepositoryResourceImpl) ((EObject) object).eResource();
		return mdr != null && mdr.getStatus().getCode() == StatusCode.WAITING ? IItemFontProvider.ITALIC_FONT : null;
	}

	/**
	 * This returns MetadataRepositoryStructuredView.gif with possible overlay
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		ResourceLocator locator = getResourceLocator();
		Object baseImage = locator.getImage("full/obj16/MetadataRepositoryStructuredView");

		MetadataRepositoryResourceImpl mdr = (MetadataRepositoryResourceImpl) ((EObject) object).eResource();
		Object overlayImage = null;
		if (mdr != null) {
			if (mdr.getLastException() != null)
				overlayImage = locator.getImage("full/ovr16/Error");
			else if (mdr.getStatus().getCode() == StatusCode.WAITING)
				overlayImage = locator.getImage("full/ovr16/Loading");
		} else
			overlayImage = locator.getImage("full/ovr16/Error");

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
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addNamePropertyDescriptor(object);
			addInstallableUnitListPropertyDescriptor(object);
			addPropertiesPropertyDescriptor(object);
			addLoadedPropertyDescriptor(object);
			addRepositoryReferencesPropertyDescriptor(object);
			addLocationPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return AggregatorEditPlugin.INSTANCE;
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 *
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		MetadataRepositoryStructuredView self = (MetadataRepositoryStructuredView) object;
		String label = self.getName();
		StringBuilder bld = new StringBuilder();
		MetadataRepositoryResourceImpl mdr = (MetadataRepositoryResourceImpl) ((EObject) object).eResource();
		if (mdr != null) {
			if (mdr.getLastException() != null) {
				bld.append(mdr.getLastException().getMessage());
				return bld.toString();
			}
			URI uri = mdr.getURI();
			if (uri != null) {
				int startPos = 0;
				String uriStr = uri.toString();
				if (uriStr.startsWith("cbiaggr:"))
					startPos = 8;
				if (uriStr.startsWith("p2:", startPos))
					startPos += 3;
				bld.append(uriStr, startPos, uriStr.length());
				bld.append(' ');
			}
		}
		int blen = bld.length();
		if (label != null) {
			bld.append('(');
			bld.append(label);
		}
		String statusText = null;
		if (!self.isLoaded()) {
			if (mdr != null) {
				if (mdr.isLoading())
					statusText = "loading...";
			} else
				statusText = "missing";
		}
		if (statusText != null) {
			if (bld.length() == blen)
				bld.append('(');
			else
				bld.append(' ');
			bld.append(statusText);
		}
		if (bld.length() > blen)
			bld.append(')');
		return bld.toString();
	}

	@Override
	public String getTooltipText(Object object) {
		return AggregatorItemProviderAdapter.getTooltipText(object, this);
	}

	/**
	 * Force the children to be wrapped
	 */
	@Override
	protected boolean isWrappingNeeded(Object object) {
		return true;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated NOT
	 */
	@Override
	public void notifyChanged(Notification notification) {
		notifyChangedGen(notification);

		if (notification.getFeatureID(
				MetadataRepositoryStructuredView.class) == P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__LOADED) {
			MetadataRepositoryStructuredView mdrView = (MetadataRepositoryStructuredView) notification.getNotifier();
			Aggregation aggregation = ResourceUtils.getAggregation(((EObject) mdrView).eResource().getResourceSet());

			if (aggregation != null)
				fireNotifyChanged(new ViewerNotification(notification, aggregation, true, true));
		}
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 *
	 * @generated
	 */
	public void notifyChangedGen(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(MetadataRepositoryStructuredView.class)) {
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__NAME:
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__METADATA_REPOSITORY:
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__LOADED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__INSTALLABLE_UNIT_LIST:
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__PROPERTIES:
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW__REPOSITORY_REFERENCES:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

}
