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

import org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentationWithDetails;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentationWithDetails} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class IUPresentationWithDetailsItemProvider extends IUPresentationItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IUPresentationWithDetailsItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This adds a property descriptor for the Copyright feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCopyrightPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IUDetails_copyright_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IUDetails_copyright_feature", "_UI_IUDetails_type"),
				 P2viewPackage.Literals.IU_DETAILS__COPYRIGHT,
				 false,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Update Descriptor feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUpdateDescriptorPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_IUDetails_updateDescriptor_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_IUDetails_updateDescriptor_feature", "_UI_IUDetails_type"),
				 P2viewPackage.Literals.IU_DETAILS__UPDATE_DESCRIPTOR,
				 false,
				 false,
				 true,
				 null,
				 null,
				 null));
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
			childrenFeatures.add(P2viewPackage.Literals.IU_DETAILS__REQUIREMENTS_CONTAINER);
			childrenFeatures.add(P2viewPackage.Literals.IU_DETAILS__PROVIDED_CAPABILITIES_CONTAINER);
			childrenFeatures.add(P2viewPackage.Literals.IU_DETAILS__PROPERTIES_CONTAINER);
			childrenFeatures.add(P2viewPackage.Literals.IU_DETAILS__TOUCHPOINTS_CONTAINER);
			childrenFeatures.add(P2viewPackage.Literals.IU_DETAILS__UPDATE_DESCRIPTOR);
			childrenFeatures.add(P2viewPackage.Literals.IU_DETAILS__COPYRIGHT);
			childrenFeatures.add(P2viewPackage.Literals.IU_DETAILS__LICENSES_CONTAINER);
		}
		return childrenFeatures;
	}

	/**
	 * This returns IUPresentationWithDetails.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/IUPresentationWithDetails"));
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

			addUpdateDescriptorPropertyDescriptor(object);
			addCopyrightPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((IUPresentationWithDetails)object).getName();
		return label == null || label.length() == 0 ?
			getString("_UI_IUPresentationWithDetails_type") :
			getString("_UI_IUPresentationWithDetails_type") + " " + label;
	}

	// Every IUPresentationWithDetail has always some children - children of IUDetails
	// This construction helps to lazily load IUDetails when they are really needed.
	// Originally hasChildren method called getIUDetails() and it loaded IUDetails.
	// It took significant amount of time to load IUDetails for all bundles from a MDR
	// when Bundles node was expanded.
	@Override
	public boolean hasChildren(Object object) {
		return true;
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

		switch (notification.getFeatureID(IUPresentationWithDetails.class)) {
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS__DETAILS_RESOLVED:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}
}
