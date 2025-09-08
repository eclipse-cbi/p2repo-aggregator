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

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping;
import org.eclipse.cbi.p2repo.aggregator.MavenMapping;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.aggregator.Aggregation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class AggregationItemProvider extends DescriptionProviderItemProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This adds a property descriptor for the Allow Legacy Sites feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addAllowLegacySitesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_allowLegacySites_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_allowLegacySites_feature",
								"_UI_Aggregation_type"),
						AggregatorPackage.Literals.AGGREGATION__ALLOW_LEGACY_SITES, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Include Sources feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIncludeSourcesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_includeSources_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_includeSources_feature",
								"_UI_Aggregation_type"),
						AggregatorPackage.Literals.AGGREGATION__INCLUDE_SOURCES, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Exclude Validation Set Units feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExcludeValidationSetUnitsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_excludeValidationSetUnits_feature"),
						getString("_UI_Aggregation_excludeValidationSetUnits_description"),
						AggregatorPackage.Literals.AGGREGATION__EXCLUDE_VALIDATION_SET_UNITS, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Exclude Features feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addExcludeFeaturesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_excludeFeatures_feature"),
						getString("_UI_Aggregation_excludeFeatures_description"),
						AggregatorPackage.Literals.AGGREGATION__EXCLUDE_FEATURES, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Included IU Pattern feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIncludedIUPatternPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_includedIUPattern_feature"),
						getString("_UI_Aggregation_includedIUPattern_description"),
						AggregatorPackage.Literals.AGGREGATION__INCLUDED_IU_PATTERN, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Validate Nexus Publishing Requirements feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValidateNexusPublishingRequirementsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_validateNexusPublishingRequirements_feature"),
						getString("_UI_Aggregation_validateNexusPublishingRequirements_description"),
						AggregatorPackage.Literals.AGGREGATION__VALIDATE_NEXUS_PUBLISHING_REQUIREMENTS, true, false,
						false, ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Validate POM Dependencies feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addValidatePOMDependenciesPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_validatePOMDependencies_feature"),
						getString("_UI_Aggregation_validatePOMDependencies_description"),
						AggregatorPackage.Literals.AGGREGATION__VALIDATE_POM_DEPENDENCIES, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Filter Published Artifacts feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFilterPublishedArtifactsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_filterPublishedArtifacts_feature"),
						getString("_UI_Aggregation_filterPublishedArtifacts_description"),
						AggregatorPackage.Literals.AGGREGATION__FILTER_PUBLISHED_ARTIFACTS, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Buildmaster feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBuildmasterPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_buildmaster_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_buildmaster_feature",
								"_UI_Aggregation_type"),
						AggregatorPackage.Literals.AGGREGATION__BUILDMASTER, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Buildmaster Backup feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBuildmasterBackupPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_buildmasterBackup_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_buildmasterBackup_feature",
								"_UI_Aggregation_type"),
						AggregatorPackage.Literals.AGGREGATION__BUILDMASTER_BACKUP, true, false, true, null, null,
						null));
	}

	/**
	 * This adds a property descriptor for the Build Root feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBuildRootPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_buildRoot_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_buildRoot_feature",
								"_UI_Aggregation_type"),
						AggregatorPackage.Literals.AGGREGATION__BUILD_ROOT, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Label feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLabelPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_label_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_label_feature",
								"_UI_Aggregation_type"),
						AggregatorPackage.Literals.AGGREGATION__LABEL, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Maven Result feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMavenResultPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_mavenResult_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_mavenResult_feature",
								"_UI_Aggregation_type"),
						AggregatorPackage.Literals.AGGREGATION__MAVEN_RESULT, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Strict Maven Versions feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addStrictMavenVersionsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_strictMavenVersions_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_strictMavenVersions_feature",
								"_UI_Aggregation_type"),
						AggregatorPackage.Literals.AGGREGATION__STRICT_MAVEN_VERSIONS, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Version Format feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addVersionFormatPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_versionFormat_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_versionFormat_feature",
								"_UI_Aggregation_type"),
						AggregatorPackage.Literals.AGGREGATION__VERSION_FORMAT, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Maven Build Number feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMavenBuildNumberPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_mavenBuildNumber_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_mavenBuildNumber_feature",
								"_UI_Aggregation_type"),
						AggregatorPackage.Literals.AGGREGATION__MAVEN_BUILD_NUMBER, true, false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Packed Strategy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPackedStrategyPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_packedStrategy_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_packedStrategy_feature",
								"_UI_Aggregation_type"),
						AggregatorPackage.Literals.AGGREGATION__PACKED_STRATEGY, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Sendmail feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addSendmailPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_sendmail_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_sendmail_feature",
								"_UI_Aggregation_type"),
						AggregatorPackage.Literals.AGGREGATION__SENDMAIL, true, false, false,
						ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_Aggregation_type_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_type_feature",
								"_UI_Aggregation_type"),
						AggregatorPackage.Literals.AGGREGATION__TYPE, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private void collectNewChildDescriptorsGen(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(AggregatorPackage.Literals.AGGREGATION__VALIDATION_SETS,
				AggregatorFactory.eINSTANCE.createValidationSet()));

		newChildDescriptors.add(createChildParameter(AggregatorPackage.Literals.AGGREGATION__CONFIGURATIONS,
				AggregatorFactory.eINSTANCE.createConfiguration()));

		newChildDescriptors.add(createChildParameter(AggregatorPackage.Literals.AGGREGATION__CUSTOM_CATEGORIES,
				AggregatorFactory.eINSTANCE.createCustomCategory()));

		newChildDescriptors.add(createChildParameter(AggregatorPackage.Literals.AGGREGATION__CONTACTS,
				AggregatorFactory.eINSTANCE.createContact()));

		newChildDescriptors.add(createChildParameter(AggregatorPackage.Literals.AGGREGATION__MAVEN_MAPPINGS,
				AggregatorFactory.eINSTANCE.createMavenMapping()));

		newChildDescriptors.add(createChildParameter(AggregatorPackage.Literals.AGGREGATION__MAVEN_DEPENDENCY_MAPPINGS,
				AggregatorFactory.eINSTANCE.createMavenDependencyMapping()));
	}

	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		collectNewChildDescriptorsGen(newChildDescriptors, object);

		ContributionItemProvider.addNewChildDescriptor(this::createChildParameter, newChildDescriptors,
				AggregatorPackage.Literals.AGGREGATION__MAVEN_MAPPINGS,
				ContributionItemProvider.createGenericMavenMapping());
		ContributionItemProvider.addNewChildDescriptor(this::createChildParameter, newChildDescriptors,
				AggregatorPackage.Literals.AGGREGATION__MAVEN_DEPENDENCY_MAPPINGS,
				ContributionItemProvider.createJavaPackageMapping());
	}

	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		if (child instanceof MavenDependencyMapping || child instanceof MavenMapping) {
			return new AdapterFactoryItemDelegator(getRootAdapterFactory()).getText(child);
		}
		return super.getCreateChildText(owner, feature, child, selection);
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
			childrenFeatures.add(AggregatorPackage.Literals.AGGREGATION__VALIDATION_SETS);
			childrenFeatures.add(AggregatorPackage.Literals.AGGREGATION__CONFIGURATIONS);
			childrenFeatures.add(AggregatorPackage.Literals.AGGREGATION__CUSTOM_CATEGORIES);
			childrenFeatures.add(AggregatorPackage.Literals.AGGREGATION__CONTACTS);
			childrenFeatures.add(AggregatorPackage.Literals.AGGREGATION__MAVEN_MAPPINGS);
			childrenFeatures.add(AggregatorPackage.Literals.AGGREGATION__MAVEN_DEPENDENCY_MAPPINGS);
		}
		return childrenFeatures;
	}

	/**
	 * This returns Aggregation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Aggregation"));
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

			addBuildmasterPropertyDescriptor(object);
			addBuildmasterBackupPropertyDescriptor(object);
			addLabelPropertyDescriptor(object);
			addBuildRootPropertyDescriptor(object);
			addPackedStrategyPropertyDescriptor(object);
			addSendmailPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addMavenResultPropertyDescriptor(object);
			addStrictMavenVersionsPropertyDescriptor(object);
			addVersionFormatPropertyDescriptor(object);
			addMavenBuildNumberPropertyDescriptor(object);
			addAllowLegacySitesPropertyDescriptor(object);
			addIncludeSourcesPropertyDescriptor(object);
			addExcludeValidationSetUnitsPropertyDescriptor(object);
			addExcludeFeaturesPropertyDescriptor(object);
			addIncludedIUPatternPropertyDescriptor(object);
			addValidateNexusPublishingRequirementsPropertyDescriptor(object);
			addValidatePOMDependenciesPropertyDescriptor(object);
			addFilterPublishedArtifactsPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns the label text for the adapted class.
	 *
	 *
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		Aggregation self = (Aggregation) object;
		String label = self.getLabel();
		StringBuilder bld = new StringBuilder(getString("_UI_Aggregation_type")).append(" : ");
		if (label != null)
			bld.append(label);
		Resource resource = ((EObject) object).eResource();
		if (resource != null) {
			URI uri = resource.getURI();
			if (uri != null) {
				bld.append(" [");
				bld.append(uri);
				bld.append(']');
			}
		}
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

		switch (notification.getFeatureID(Aggregation.class)) {
			case AggregatorPackage.AGGREGATION__STATUS:
			case AggregatorPackage.AGGREGATION__LABEL:
			case AggregatorPackage.AGGREGATION__BUILD_ROOT:
			case AggregatorPackage.AGGREGATION__PACKED_STRATEGY:
			case AggregatorPackage.AGGREGATION__SENDMAIL:
			case AggregatorPackage.AGGREGATION__TYPE:
			case AggregatorPackage.AGGREGATION__MAVEN_RESULT:
			case AggregatorPackage.AGGREGATION__STRICT_MAVEN_VERSIONS:
			case AggregatorPackage.AGGREGATION__VERSION_FORMAT:
			case AggregatorPackage.AGGREGATION__MAVEN_BUILD_NUMBER:
			case AggregatorPackage.AGGREGATION__ALLOW_LEGACY_SITES:
			case AggregatorPackage.AGGREGATION__INCLUDE_SOURCES:
			case AggregatorPackage.AGGREGATION__EXCLUDE_VALIDATION_SET_UNITS:
			case AggregatorPackage.AGGREGATION__EXCLUDE_FEATURES:
			case AggregatorPackage.AGGREGATION__INCLUDED_IU_PATTERN:
			case AggregatorPackage.AGGREGATION__VALIDATE_NEXUS_PUBLISHING_REQUIREMENTS:
			case AggregatorPackage.AGGREGATION__VALIDATE_POM_DEPENDENCIES:
			case AggregatorPackage.AGGREGATION__FILTER_PUBLISHED_ARTIFACTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case AggregatorPackage.AGGREGATION__VALIDATION_SETS:
			case AggregatorPackage.AGGREGATION__CONFIGURATIONS:
			case AggregatorPackage.AGGREGATION__CUSTOM_CATEGORIES:
			case AggregatorPackage.AGGREGATION__CONTACTS:
			case AggregatorPackage.AGGREGATION__MAVEN_MAPPINGS:
			case AggregatorPackage.AGGREGATION__MAVEN_DEPENDENCY_MAPPINGS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

}
