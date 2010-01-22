/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 * $Id$
 */
package org.eclipse.b3.aggregator.p2view.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.b3.aggregator.AggregatorPackage;
import org.eclipse.b3.aggregator.LabelProvider;
import org.eclipse.b3.aggregator.p2.P2Package;
import org.eclipse.b3.aggregator.p2view.P2viewPackage;
import org.eclipse.b3.aggregator.p2view.RequiredCapabilityWrapper;
import org.eclipse.b3.aggregator.provider.AggregatorEditPlugin;
import org.eclipse.b3.aggregator.provider.AggregatorItemProviderAdapter;
import org.eclipse.b3.aggregator.util.CapabilityNamespaceImageProvider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

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
 * This is the item provider adapter for a {@link org.eclipse.b3.aggregator.p2view.RequiredCapabilityWrapper} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class RequiredCapabilityWrapperItemProvider extends AggregatorItemProviderAdapter implements
		IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider,
		IItemPropertySource, IItemColorProvider, IItemFontProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public RequiredCapabilityWrapperItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns RequiredCapabilityWrapper.gif.
	 * 
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		RequiredCapabilityWrapper rcw = (RequiredCapabilityWrapper) object;

		Object image = CapabilityNamespaceImageProvider.getImage(rcw.getNamespace());
		if(image == null)
			image = getResourceLocator().getImage("full/obj16/RequiredCapability");

		return overlayImage(object, image);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if(itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addFilterPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addNamespacePropertyDescriptor(object);
			addRangePropertyDescriptor(object);
			addNegationPropertyDescriptor(object);
			addSelectorListPropertyDescriptor(object);
			addMultiplePropertyDescriptor(object);
			addOptionalPropertyDescriptor(object);
			addGreedyPropertyDescriptor(object);
			addLabelPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
		return ((LabelProvider) object).getLabel();
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch(notification.getFeatureID(RequiredCapabilityWrapper.class)) {
		case P2viewPackage.REQUIRED_CAPABILITY_WRAPPER__FILTER:
		case P2viewPackage.REQUIRED_CAPABILITY_WRAPPER__NAME:
		case P2viewPackage.REQUIRED_CAPABILITY_WRAPPER__NAMESPACE:
		case P2viewPackage.REQUIRED_CAPABILITY_WRAPPER__RANGE:
		case P2viewPackage.REQUIRED_CAPABILITY_WRAPPER__NEGATION:
		case P2viewPackage.REQUIRED_CAPABILITY_WRAPPER__SELECTOR_LIST:
		case P2viewPackage.REQUIRED_CAPABILITY_WRAPPER__MULTIPLE:
		case P2viewPackage.REQUIRED_CAPABILITY_WRAPPER__OPTIONAL:
		case P2viewPackage.REQUIRED_CAPABILITY_WRAPPER__GREEDY:
		case P2viewPackage.REQUIRED_CAPABILITY_WRAPPER__LABEL:
			fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
			return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds a property descriptor for the Filter feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addFilterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_IRequiredCapability_filter_feature"), getString("_UI_PropertyDescriptor_description",
						"_UI_IRequiredCapability_filter_feature", "_UI_IRequiredCapability_type"),
				P2Package.Literals.IREQUIRED_CAPABILITY__FILTER, false, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Greedy feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addGreedyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_IRequiredCapability_greedy_feature"), getString("_UI_PropertyDescriptor_description",
						"_UI_IRequiredCapability_greedy_feature", "_UI_IRequiredCapability_type"),
				P2Package.Literals.IREQUIRED_CAPABILITY__GREEDY, false, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Label feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addLabelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_LabelProvider_label_feature"), getString("_UI_PropertyDescriptor_description",
						"_UI_LabelProvider_label_feature", "_UI_LabelProvider_type"),
				AggregatorPackage.Literals.LABEL_PROVIDER__LABEL, false, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Multiple feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMultiplePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_IRequiredCapability_multiple_feature"), getString("_UI_PropertyDescriptor_description",
						"_UI_IRequiredCapability_multiple_feature", "_UI_IRequiredCapability_type"),
				P2Package.Literals.IREQUIRED_CAPABILITY__MULTIPLE, false, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_IRequiredCapability_name_feature"), getString("_UI_PropertyDescriptor_description",
						"_UI_IRequiredCapability_name_feature", "_UI_IRequiredCapability_type"),
				P2Package.Literals.IREQUIRED_CAPABILITY__NAME, false, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Namespace feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamespacePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_IRequiredCapability_namespace_feature"), getString("_UI_PropertyDescriptor_description",
						"_UI_IRequiredCapability_namespace_feature", "_UI_IRequiredCapability_type"),
				P2Package.Literals.IREQUIRED_CAPABILITY__NAMESPACE, false, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Negation feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNegationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_IRequiredCapability_negation_feature"), getString("_UI_PropertyDescriptor_description",
						"_UI_IRequiredCapability_negation_feature", "_UI_IRequiredCapability_type"),
				P2Package.Literals.IREQUIRED_CAPABILITY__NEGATION, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Optional feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addOptionalPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_IRequiredCapability_optional_feature"), getString("_UI_PropertyDescriptor_description",
						"_UI_IRequiredCapability_optional_feature", "_UI_IRequiredCapability_type"),
				P2Package.Literals.IREQUIRED_CAPABILITY__OPTIONAL, false, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Range feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addRangePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_IRequiredCapability_range_feature"), getString("_UI_PropertyDescriptor_description",
						"_UI_IRequiredCapability_range_feature", "_UI_IRequiredCapability_type"),
				P2Package.Literals.IREQUIRED_CAPABILITY__RANGE, false, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Selector List feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSelectorListPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_IRequiredCapability_selectorList_feature"), getString(
						"_UI_PropertyDescriptor_description", "_UI_IRequiredCapability_selectorList_feature",
						"_UI_IRequiredCapability_type"), P2Package.Literals.IREQUIRED_CAPABILITY__SELECTOR_LIST, true,
				false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
