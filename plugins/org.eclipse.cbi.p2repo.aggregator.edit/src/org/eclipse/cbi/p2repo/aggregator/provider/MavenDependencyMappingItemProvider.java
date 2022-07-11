/**
 * Copyright (c) 2022 Eclipse Foundation and others.
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
import org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping;
import org.eclipse.cbi.p2repo.util.StringUtils;
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
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @since 1.1.0
 * @generated
 */
public class MavenDependencyMappingItemProvider extends AggregatorItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource, IItemColorProvider, IItemFontProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MavenDependencyMappingItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
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

			addIuNamePatternPropertyDescriptor(object);
			addNamespacePatternPropertyDescriptor(object);
			addNamePatternPropertyDescriptor(object);
			addGroupIdPropertyDescriptor(object);
			addArtifactIdPropertyDescriptor(object);
			addVersionRangePatternPropertyDescriptor(object);
			addVersionRangeTemplatePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Iu Name Pattern feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIuNamePatternPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_MavenDependencyMapping_iuNamePattern_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_MavenDependencyMapping_iuNamePattern_feature", "_UI_MavenDependencyMapping_type"),
						AggregatorPackage.Literals.MAVEN_DEPENDENCY_MAPPING__IU_NAME_PATTERN, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Namespace Pattern feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamespacePatternPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_MavenDependencyMapping_namespacePattern_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_MavenDependencyMapping_namespacePattern_feature",
						"_UI_MavenDependencyMapping_type"),
				AggregatorPackage.Literals.MAVEN_DEPENDENCY_MAPPING__NAMESPACE_PATTERN, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Name Pattern feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePatternPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_MavenDependencyMapping_namePattern_feature"),
						getString("_UI_PropertyDescriptor_description",
								"_UI_MavenDependencyMapping_namePattern_feature", "_UI_MavenDependencyMapping_type"),
						AggregatorPackage.Literals.MAVEN_DEPENDENCY_MAPPING__NAME_PATTERN, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Group Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addGroupIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_MavenDependencyMapping_groupId_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_MavenDependencyMapping_groupId_feature",
								"_UI_MavenDependencyMapping_type"),
						AggregatorPackage.Literals.MAVEN_DEPENDENCY_MAPPING__GROUP_ID, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Artifact Id feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addArtifactIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_MavenDependencyMapping_artifactId_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_MavenDependencyMapping_artifactId_feature",
								"_UI_MavenDependencyMapping_type"),
						AggregatorPackage.Literals.MAVEN_DEPENDENCY_MAPPING__ARTIFACT_ID, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Version Range Pattern feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionRangePatternPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_MavenDependencyMapping_versionRangePattern_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_MavenDependencyMapping_versionRangePattern_feature", "_UI_MavenDependencyMapping_type"),
				AggregatorPackage.Literals.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_PATTERN, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Version Range Template feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionRangeTemplatePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_MavenDependencyMapping_versionRangeTemplate_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_MavenDependencyMapping_versionRangeTemplate_feature", "_UI_MavenDependencyMapping_type"),
				AggregatorPackage.Literals.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_TEMPLATE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This returns MavenDependencyMapping.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MavenDependencyMapping"));
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
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		MavenDependencyMapping mapping = (MavenDependencyMapping) object;
		StringBuilder result = new StringBuilder(getString("_UI_MavenDependencyMapping_type")).append(" : ['");
		String iuNamePattern = StringUtils.trimmedOrNull(mapping.getIuNamePattern());
		if (iuNamePattern != null) {
			result.append(iuNamePattern).append("' ~ '");
		}

		String namespacePattern = mapping.getNamespacePattern();

		if (namespacePattern != null) {
			result.append(namespacePattern).append("' : '");
		}

		String namePattern = mapping.getNamePattern();
		if (namePattern != null) {
			result.append(namePattern);
		}

		result.append("' => '");
		String groupId = mapping.getGroupId();
		if (groupId != null) {
			result.append(groupId);
		}

		String artifactId = mapping.getArtifactId();
		if (artifactId != null) {
			result.append('/');
			result.append(artifactId);
		}

		String versionRangePattern = mapping.getVersionRangePattern();
		String versionRangeTemplate = mapping.getVersionRangeTemplate();
		if (versionRangePattern != null) {
			result.append("', '").append(versionRangePattern);
			result.append("' => '").append(versionRangeTemplate == null ? "" : versionRangeTemplate);
		}
		result.append("']");
		return result.toString();
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

		switch (notification.getFeatureID(MavenDependencyMapping.class)) {
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__STATUS:
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__IU_NAME_PATTERN:
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__NAMESPACE_PATTERN:
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__NAME_PATTERN:
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__GROUP_ID:
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__ARTIFACT_ID:
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_PATTERN:
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING__VERSION_RANGE_TEMPLATE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
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
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return AggregatorEditPlugin.INSTANCE;
	}

}
