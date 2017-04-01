/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 */
package org.eclipse.cbi.p2repo.p2.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.cbi.p2repo.p2.InstallableUnitPatch;
import org.eclipse.cbi.p2repo.p2.P2Factory;
import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.p2.InstallableUnitPatch} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class InstallableUnitPatchItemProvider extends InstallableUnitItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	public InstallableUnitPatchItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
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

		newChildDescriptors.add(
			createChildParameter(
				P2Package.Literals.IINSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE,
				P2Factory.eINSTANCE.createRequirementChange()));

		newChildDescriptors.add(
			createChildParameter(
				P2Package.Literals.IINSTALLABLE_UNIT_PATCH__LIFE_CYCLE, P2Factory.eINSTANCE.createRequirement()));

		newChildDescriptors.add(
			createChildParameter(
				P2Package.Literals.IINSTALLABLE_UNIT_PATCH__LIFE_CYCLE,
				P2Factory.eINSTANCE.createRequiredCapability()));

		newChildDescriptors.add(
			createChildParameter(
				P2Package.Literals.IINSTALLABLE_UNIT_PATCH__APPLIES_TO, P2Factory.eINSTANCE.createRequirement()));

		newChildDescriptors.add(
			createChildParameter(
				P2Package.Literals.IINSTALLABLE_UNIT_PATCH__APPLIES_TO,
				P2Factory.eINSTANCE.createRequiredCapability()));
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
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE);
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT_PATCH__LIFE_CYCLE);
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT_PATCH__APPLIES_TO);
		}
		return childrenFeatures;
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == P2Package.Literals.IINSTALLABLE_UNIT__META_REQUIREMENTS ||
				childFeature == P2Package.Literals.IINSTALLABLE_UNIT__REQUIREMENTS ||
				childFeature == P2Package.Literals.IINSTALLABLE_UNIT_PATCH__LIFE_CYCLE ||
				childFeature == P2Package.Literals.IINSTALLABLE_UNIT_PATCH__APPLIES_TO;

		if(qualify) {
			return getString(
				"_UI_CreateChild_text2",
				new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * This returns InstallableUnitPatch.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 *
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/InstallableUnitPatch"));
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

		}
		return itemPropertyDescriptors;
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
		String label = ((InstallableUnitPatch) object).getId();
		return label == null || label.length() == 0
				? getString("_UI_InstallableUnitPatch_type")
				: getString("_UI_InstallableUnitPatch_type") + " " + label;
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

		switch(notification.getFeatureID(InstallableUnitPatch.class)) {
			case P2Package.INSTALLABLE_UNIT_PATCH__REQUIREMENTS_CHANGE:
			case P2Package.INSTALLABLE_UNIT_PATCH__LIFE_CYCLE:
			case P2Package.INSTALLABLE_UNIT_PATCH__APPLIES_TO:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

}
