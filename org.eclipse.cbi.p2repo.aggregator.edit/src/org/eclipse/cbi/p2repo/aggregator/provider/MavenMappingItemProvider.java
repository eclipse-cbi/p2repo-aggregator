/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 * $Id$
 */
package org.eclipse.cbi.p2repo.aggregator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.MavenMapping;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
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
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.aggregator.MavenMapping} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 *
 * @generated
 */
public class MavenMappingItemProvider extends AggregatorItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource, IItemColorProvider, IItemFontProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public MavenMappingItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This adds a property descriptor for the Artifact Id feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addArtifactIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_MavenMapping_artifactId_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_MavenMapping_artifactId_feature",
								"_UI_MavenMapping_type"),
						AggregatorPackage.Literals.MAVEN_MAPPING__ARTIFACT_ID, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Group Id feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGroupIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_MavenMapping_groupId_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_MavenMapping_groupId_feature",
								"_UI_MavenMapping_type"),
						AggregatorPackage.Literals.MAVEN_MAPPING__GROUP_ID, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Name Pattern feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePatternPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_MavenMapping_namePattern_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_MavenMapping_namePattern_feature",
								"_UI_MavenMapping_type"),
						AggregatorPackage.Literals.MAVEN_MAPPING__NAME_PATTERN, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Version Pattern feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionPatternPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_MavenMapping_versionPattern_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_MavenMapping_versionPattern_feature",
								"_UI_MavenMapping_type"),
						AggregatorPackage.Literals.MAVEN_MAPPING__VERSION_PATTERN, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Version Template feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionTemplatePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_MavenMapping_versionTemplate_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_MavenMapping_versionTemplate_feature",
								"_UI_MavenMapping_type"),
						AggregatorPackage.Literals.MAVEN_MAPPING__VERSION_TEMPLATE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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
	 * This returns MavenMapping.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MavenMapping"));
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

			addNamePatternPropertyDescriptor(object);
			addGroupIdPropertyDescriptor(object);
			addArtifactIdPropertyDescriptor(object);
			addVersionPatternPropertyDescriptor(object);
			addVersionTemplatePropertyDescriptor(object);
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
		MavenMapping self = (MavenMapping) object;
		StringBuilder bld = new StringBuilder(getString("_UI_MavenMapping_type")).append(" : ['");
		String namePattern = self.getNamePattern();
		if (namePattern != null)
			bld.append(namePattern);
		bld.append("' => '");
		String groupId = self.getGroupId();
		if (groupId != null)
			bld.append(groupId);
		String artifactId = self.getArtifactId();
		if (artifactId != null) {
			bld.append('/');
			bld.append(artifactId);
		}
		String versionPattern = self.getVersionPattern();
		String versionTemplate = self.getVersionTemplate();
		if (versionPattern != null && versionTemplate != null) {
			bld.append("', '").append(versionPattern);
			bld.append("' => '").append(versionTemplate);
		}
		bld.append("']");
		return bld.toString();
	}

	@Override
	public void notifyChanged(Notification notification) {
		notifyChangedGen(notification);

		// Go through all ancestors and update labels
		MavenMapping mapping = (MavenMapping) notification.getNotifier();
		fireNotifyChanged(new ViewerNotification(notification, ((EObject) mapping).eResource(), false, true));
		EObject container = ((EObject) mapping).eContainer();
		while (container != null) {
			fireNotifyChanged(new ViewerNotification(notification, container, false, true));
			container = container.eContainer();
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

		switch (notification.getFeatureID(MavenMapping.class)) {
			case AggregatorPackage.MAVEN_MAPPING__STATUS:
			case AggregatorPackage.MAVEN_MAPPING__NAME_PATTERN:
			case AggregatorPackage.MAVEN_MAPPING__GROUP_ID:
			case AggregatorPackage.MAVEN_MAPPING__ARTIFACT_ID:
			case AggregatorPackage.MAVEN_MAPPING__VERSION_PATTERN:
			case AggregatorPackage.MAVEN_MAPPING__VERSION_TEMPLATE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

}
