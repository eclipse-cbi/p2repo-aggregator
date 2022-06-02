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
package org.eclipse.cbi.p2repo.p2.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.cbi.p2repo.p2.InstallableUnit;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.cbi.p2repo.p2.P2Factory;
import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl;
import org.eclipse.cbi.p2repo.p2.util.IUUtils;
import org.eclipse.cbi.p2repo.p2.util.RepositoryTranslationSupport;
import org.eclipse.cbi.p2repo.util.StringUtils;
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
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.VersionedId;
import org.eclipse.equinox.p2.query.QueryUtil;

/**
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.p2.InstallableUnit} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class InstallableUnitItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InstallableUnitItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This adds a property descriptor for the Filter feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFilterPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_IInstallableUnit_filter_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_IInstallableUnit_filter_feature",
								"_UI_IInstallableUnit_type"),
						P2Package.Literals.IINSTALLABLE_UNIT__FILTER, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_IVersionedId_id_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_IVersionedId_id_feature",
								"_UI_IVersionedId_type"),
						P2Package.Literals.IVERSIONED_ID__ID, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Resolved feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addResolvedPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_IInstallableUnit_resolved_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_IInstallableUnit_resolved_feature",
								"_UI_IInstallableUnit_type"),
						P2Package.Literals.IINSTALLABLE_UNIT__RESOLVED, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Singleton feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSingletonPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_IInstallableUnit_singleton_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_IInstallableUnit_singleton_feature",
								"_UI_IInstallableUnit_type"),
						P2Package.Literals.IINSTALLABLE_UNIT__SINGLETON, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Version feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_IVersionedId_version_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_IVersionedId_version_feature",
								"_UI_IVersionedId_type"),
						P2Package.Literals.IVERSIONED_ID__VERSION, true, false, false,
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

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__ARTIFACTS,
				P2Factory.eINSTANCE.createArtifactKey()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__COPYRIGHT,
				P2Factory.eINSTANCE.createCopyright()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__FRAGMENTS,
				P2Factory.eINSTANCE.createInstallableUnitFragment()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__LICENSES,
				P2Factory.eINSTANCE.createLicense()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__META_REQUIREMENTS,
				P2Factory.eINSTANCE.createRequirement()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__META_REQUIREMENTS,
				P2Factory.eINSTANCE.createRequiredCapability()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__META_REQUIREMENTS,
				P2Factory.eINSTANCE.createRequiredPropertiesMatch()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__PROVIDED_CAPABILITIES,
				P2Factory.eINSTANCE.createProvidedCapability()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__REQUIREMENTS,
				P2Factory.eINSTANCE.createRequirement()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__REQUIREMENTS,
				P2Factory.eINSTANCE.createRequiredCapability()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__REQUIREMENTS,
				P2Factory.eINSTANCE.createRequiredPropertiesMatch()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__TOUCHPOINT_DATA,
				P2Factory.eINSTANCE.createTouchpointData()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__TOUCHPOINT_TYPE,
				P2Factory.eINSTANCE.createTouchpointType()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.IINSTALLABLE_UNIT__UPDATE_DESCRIPTOR,
				P2Factory.eINSTANCE.createUpdateDescriptor()));

		newChildDescriptors.add(createChildParameter(P2Package.Literals.INSTALLABLE_UNIT__PROPERTY_MAP,
				P2Factory.eINSTANCE.create(P2Package.Literals.PROPERTY)));
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
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT__ARTIFACTS);
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT__COPYRIGHT);
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT__FILTER);
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT__FRAGMENTS);
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT__LICENSES);
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT__META_REQUIREMENTS);
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT__PROVIDED_CAPABILITIES);
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT__REQUIREMENTS);
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT__TOUCHPOINT_DATA);
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT__TOUCHPOINT_TYPE);
			childrenFeatures.add(P2Package.Literals.IINSTALLABLE_UNIT__UPDATE_DESCRIPTOR);
			childrenFeatures.add(P2Package.Literals.INSTALLABLE_UNIT__PROPERTY_MAP);
		}
		return childrenFeatures;
	}

	/**
	 * This returns the label text for {@link org.eclipse.emf.edit.command.CreateChildCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		Object childFeature = feature;
		Object childObject = child;

		boolean qualify = childFeature == P2Package.Literals.IINSTALLABLE_UNIT__META_REQUIREMENTS
				|| childFeature == P2Package.Literals.IINSTALLABLE_UNIT__REQUIREMENTS;

		if (qualify) {
			return getString("_UI_CreateChild_text2",
					new Object[] { getTypeText(childObject), getFeatureText(childFeature), getTypeText(owner) });
		}
		return super.getCreateChildText(owner, feature, child, selection);
	}

	/**
	 * This returns InstallableUnit.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/InstallableUnit"));
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
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addIdPropertyDescriptor(object);
			addVersionPropertyDescriptor(object);
			addFilterPropertyDescriptor(object);
			addResolvedPropertyDescriptor(object);
			addSingletonPropertyDescriptor(object);
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
		return P2EditPlugin.INSTANCE;
	}

	/**
	 * This returns the label text for the adapted class.
	 *
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		InstallableUnit iu = (InstallableUnit) object;
		String label = StringUtils.trimmedOrNull(iu.getId());

		if (label == null) {
			VersionedId vn = IUUtils.getVersionedNameFromProxy(iu);
			if (vn != null)
				label = vn.getId() + " / " + IUUtils.stringifyVersion(vn.getVersion()) + " (missing)";
		} else if (QueryUtil.isCategory(iu)) {
			// The id and version are meaningless in categories. We display the
			// name
			// instead.
			String name = iu.getProperty(IInstallableUnit.PROP_NAME);
			if (name != null)
				label = name;
		} else {
			String name = RepositoryTranslationSupport
					.getInstance((MetadataRepository) ((InstallableUnitImpl) iu).eContainer())
					.getIUProperty(iu, IInstallableUnit.PROP_NAME);
			if (name != null && name.startsWith("%"))
				name = null;

			label += " / " + IUUtils.stringifyVersion(iu.getVersion())
					+ (name != null && name.length() > 0 ? " (" + name + ")" : "");
		}

		return label == null || label.length() == 0 ? getString("_UI_InstallableUnit_type") : label;
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

		switch (notification.getFeatureID(InstallableUnit.class)) {
			case P2Package.INSTALLABLE_UNIT__ID:
			case P2Package.INSTALLABLE_UNIT__VERSION:
			case P2Package.INSTALLABLE_UNIT__RESOLVED:
			case P2Package.INSTALLABLE_UNIT__SINGLETON:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case P2Package.INSTALLABLE_UNIT__ARTIFACTS:
			case P2Package.INSTALLABLE_UNIT__COPYRIGHT:
			case P2Package.INSTALLABLE_UNIT__FILTER:
			case P2Package.INSTALLABLE_UNIT__LICENSES:
			case P2Package.INSTALLABLE_UNIT__META_REQUIREMENTS:
			case P2Package.INSTALLABLE_UNIT__PROVIDED_CAPABILITIES:
			case P2Package.INSTALLABLE_UNIT__REQUIREMENTS:
			case P2Package.INSTALLABLE_UNIT__TOUCHPOINT_DATA:
			case P2Package.INSTALLABLE_UNIT__TOUCHPOINT_TYPE:
			case P2Package.INSTALLABLE_UNIT__UPDATE_DESCRIPTOR:
			case P2Package.INSTALLABLE_UNIT__PROPERTY_MAP:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

}
