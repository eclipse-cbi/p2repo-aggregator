/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 * 
 */
package org.eclipse.b3.p2.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.b3.p2.MetadataRepository;
import org.eclipse.b3.p2.P2Factory;
import org.eclipse.b3.p2.P2Package;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.b3.p2.MetadataRepository} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class MetadataRepositoryItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public MetadataRepositoryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if(childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(P2Package.Literals.METADATA_REPOSITORY__INSTALLABLE_UNITS);
			childrenFeatures.add(P2Package.Literals.METADATA_REPOSITORY__REFERENCES);
			childrenFeatures.add(P2Package.Literals.METADATA_REPOSITORY__PROPERTY_MAP);
		}
		return childrenFeatures;
	}

	/**
	 * This returns MetadataRepository.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MetadataRepository"));
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if(itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addLocationPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addVersionPropertyDescriptor(object);
			addDescriptionPropertyDescriptor(object);
			addProviderPropertyDescriptor(object);
			addModifiablePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return P2EditPlugin.INSTANCE;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((MetadataRepository) object).getName();
		return label == null || label.length() == 0
				? getString("_UI_MetadataRepository_type")
				: getString("_UI_MetadataRepository_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch(notification.getFeatureID(MetadataRepository.class)) {
			case P2Package.METADATA_REPOSITORY__LOCATION:
			case P2Package.METADATA_REPOSITORY__NAME:
			case P2Package.METADATA_REPOSITORY__TYPE:
			case P2Package.METADATA_REPOSITORY__VERSION:
			case P2Package.METADATA_REPOSITORY__DESCRIPTION:
			case P2Package.METADATA_REPOSITORY__PROVIDER:
			case P2Package.METADATA_REPOSITORY__MODIFIABLE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case P2Package.METADATA_REPOSITORY__INSTALLABLE_UNITS:
			case P2Package.METADATA_REPOSITORY__REFERENCES:
			case P2Package.METADATA_REPOSITORY__PROPERTY_MAP:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds a property descriptor for the Description feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addDescriptionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_IRepository_description_feature"),
			getString(
				"_UI_PropertyDescriptor_description", "_UI_IRepository_description_feature", "_UI_IRepository_type"),
			P2Package.Literals.IREPOSITORY__DESCRIPTION, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Location feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addLocationPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_IRepository_location_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_IRepository_location_feature", "_UI_IRepository_type"),
			P2Package.Literals.IREPOSITORY__LOCATION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
			null, null));
	}

	/**
	 * This adds a property descriptor for the Modifiable feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addModifiablePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_IRepository_modifiable_feature"),
			getString(
				"_UI_PropertyDescriptor_description", "_UI_IRepository_modifiable_feature", "_UI_IRepository_type"),
			P2Package.Literals.IREPOSITORY__MODIFIABLE, true, false, false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
			null, null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_IRepository_name_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_IRepository_name_feature", "_UI_IRepository_type"),
			P2Package.Literals.IREPOSITORY__NAME, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
			null));
	}

	/**
	 * This adds a property descriptor for the Provider feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addProviderPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_IRepository_provider_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_IRepository_provider_feature", "_UI_IRepository_type"),
			P2Package.Literals.IREPOSITORY__PROVIDER, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
			null, null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_IRepository_type_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_IRepository_type_feature", "_UI_IRepository_type"),
			P2Package.Literals.IREPOSITORY__TYPE, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null,
			null));
	}

	/**
	 * This adds a property descriptor for the Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_IRepository_version_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_IRepository_version_feature", "_UI_IRepository_type"),
			P2Package.Literals.IREPOSITORY__VERSION, true, false, false, ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
			null, null));
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(
			P2Package.Literals.METADATA_REPOSITORY__INSTALLABLE_UNITS, P2Factory.eINSTANCE.createInstallableUnit()));

		newChildDescriptors.add(createChildParameter(
			P2Package.Literals.METADATA_REPOSITORY__INSTALLABLE_UNITS,
			P2Factory.eINSTANCE.createInstallableUnitFragment()));

		newChildDescriptors.add(createChildParameter(
			P2Package.Literals.METADATA_REPOSITORY__INSTALLABLE_UNITS, P2Factory.eINSTANCE.createInstallableUnitPatch()));

		newChildDescriptors.add(createChildParameter(
			P2Package.Literals.METADATA_REPOSITORY__REFERENCES, P2Factory.eINSTANCE.createRepositoryReference()));

		newChildDescriptors.add(createChildParameter(
			P2Package.Literals.METADATA_REPOSITORY__PROPERTY_MAP,
			P2Factory.eINSTANCE.create(P2Package.Literals.PROPERTY)));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

}
