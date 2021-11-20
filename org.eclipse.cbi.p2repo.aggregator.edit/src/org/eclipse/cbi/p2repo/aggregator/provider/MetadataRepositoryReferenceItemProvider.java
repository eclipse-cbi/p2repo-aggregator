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
package org.eclipse.cbi.p2repo.aggregator.provider;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPlugin;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.CustomCategory;
import org.eclipse.cbi.p2repo.aggregator.Feature;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MappedUnit;
import org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference;
import org.eclipse.cbi.p2repo.aggregator.StatusCode;
import org.eclipse.cbi.p2repo.aggregator.StatusProvider;
import org.eclipse.cbi.p2repo.aggregator.ValidationSet;
import org.eclipse.cbi.p2repo.aggregator.util.ResourceUtils;
import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.cbi.p2repo.p2.impl.MetadataRepositoryImpl;
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
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MetadataRepositoryReferenceItemProvider extends AggregatorItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource, IItemColorProvider, IItemFontProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetadataRepositoryReferenceItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This adds a property descriptor for the Enabled feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEnabledPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_EnabledStatusProvider_enabled_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_EnabledStatusProvider_enabled_feature",
						"_UI_EnabledStatusProvider_type"),
				AggregatorPackage.Literals.ENABLED_STATUS_PROVIDER__ENABLED, true, false, false,
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
				getString("_UI_MetadataRepositoryReference_location_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_MetadataRepositoryReference_location_feature",
						"_UI_MetadataRepositoryReference_type"),
				AggregatorPackage.Literals.METADATA_REPOSITORY_REFERENCE__LOCATION, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Metadata Repository feature.
	 *
	 * @generated NOT
	 */
	protected void addMetadataRepositoryPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(new ContributionItemProvider.DynamicItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_MetadataRepositoryReference_metadataRepository_feature"),
				getString("_UI_PropertyDescriptor_description",
						"_UI_MetadataRepositoryReference_metadataRepository_feature",
						"_UI_MetadataRepositoryReference_type"),
				AggregatorPackage.Literals.METADATA_REPOSITORY_REFERENCE__METADATA_REPOSITORY, true, false, true, null,
				null, null) {
			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				// Provide a list of repositories that has not already been mapped
				//
				MetadataRepositoryReference self = (MetadataRepositoryReference) object;
				Aggregation aggregation = self.getAggregation();
				Collection<?> repos = super.getChoiceOfValues(object);
				for (ValidationSet vs : aggregation.getValidationSets(true)) {
					for (Contribution contribution : vs.getDeclaredContributions()) {
						for (MappedRepository mappedRepo : contribution.getRepositories()) {
							if (mappedRepo == self)
								continue;
							MetadataRepository repo = mappedRepo.getMetadataRepository(false);
							if (repo != null && !((EObject) repo).eIsProxy())
								repos.remove(repo);
						}
					}
					for (MetadataRepositoryReference mrRef : vs.getDeclaredValidationRepositories()) {
						if (mrRef == self)
							continue;
						MetadataRepository repo = mrRef.getMetadataRepository(false);
						if (repo != null && !((EObject) repo).eIsProxy())
							repos.remove(repo);
					}
				}
				return repos;
			}
		});
	}

	/**
	 * This adds a property descriptor for the Nature feature.
	 *
	 * @generated NOT
	 */
	protected void addNaturePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(new ItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_MetadataRepositoryReference_nature_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_MetadataRepositoryReference_nature_feature",
						"_UI_MetadataRepositoryReference_type"),
				AggregatorPackage.Literals.METADATA_REPOSITORY_REFERENCE__NATURE, true, false, false,
				ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null) {
			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				MetadataRepositoryReference repo = (MetadataRepositoryReference) object;
				String currentValue = repo.getNature();
				List<String> supportedValues = AggregatorPlugin.getPlugin().getSupportedRepositoryNatureList();
				if (!supportedValues.contains(currentValue)) {
					List<String> globallySupportedValues = supportedValues;
					supportedValues = new ArrayList<>(globallySupportedValues.size() + 1);
					supportedValues.addAll(globallySupportedValues);
					supportedValues.add(currentValue);
					Collections.sort(supportedValues);
				}

				return supportedValues;
			}
		});
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

	@Override
	public Object getFont(Object object) {
		return ((StatusProvider) object).getStatus().getCode() == StatusCode.WAITING ? IItemFontProvider.ITALIC_FONT
				: null;
	}

	/**
	 * This returns MetadataRepositoryReference.gif.
	 *
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/MetadataRepositoryReference"
				+ (((MetadataRepositoryReference) object).isBranchEnabled() ? "" : "Disabled")));

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

			addEnabledPropertyDescriptor(object);
			addLocationPropertyDescriptor(object);
			addNaturePropertyDescriptor(object);
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
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		MetadataRepositoryReference repoRef = (MetadataRepositoryReference) object;
		MetadataRepositoryImpl mdr = null;
		if (repoRef.isBranchEnabled())
			mdr = (MetadataRepositoryImpl) repoRef.getMetadataRepository(false);
		StringBuilder bld = new StringBuilder();
		bld.append(getString(getTypeName()));
		bld.append(" : ");
		if (mdr != null && !((EObject) mdr).eIsProxy()) {
			String name;
			String nature = repoRef.getNature();
			URI location;

			if (!((EObject) mdr).eIsProxy()) {
				name = mdr.getName();
				location = mdr.getLocation();
			} else {
				name = mdr.getNameFromProxy();
				location = mdr.getLocationFromProxy();
			}

			if (location != null) {
				if (!"p2".equals(nature)) {
					bld.append(nature);
					bld.append(':');
				}
				bld.append(location);
			} else
				bld.append("no location");

			if (name != null) {
				bld.append(" (");
				bld.append(name);
				bld.append(')');
			}
		} else {
			if (repoRef.getLocation() != null) {
				if (!"p2".equals(repoRef.getNature())) {
					bld.append(repoRef.getNature());
					bld.append(':');
				}
				bld.append(repoRef.getLocation());
				StatusCode status = repoRef.getStatus().getCode();
				if (status != StatusCode.OK) {
					bld.append(" (");
					bld.append(status == StatusCode.WAITING ? "loading" : "missing");
					bld.append(')');
				}
			} else
				bld.append("no location");
		}

		return bld.toString();
	}

	protected String getTypeName() {
		return "_UI_MetadataRepositoryReference_type";
	}

	/**
	 * Experimental. Loads a resource when the user types in a URL.
	 *
	 * @generated NOT
	 */
	@Override
	public void notifyChanged(Notification notification) {
		notifyChangedGen(notification);

		if (notification.getEventType() != Notification.SET)
			return;

		MetadataRepositoryReference repoRef = (MetadataRepositoryReference) notification.getNotifier();
		switch (notification.getFeatureID(MetadataRepositoryReference.class)) {
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__NATURE:
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__LOCATION:
				if (notification.getNewStringValue() != null
						&& !notification.getNewStringValue().equals(notification.getOldStringValue())
						|| notification.getOldStringValue() != null
								&& !notification.getOldStringValue().equals(notification.getNewStringValue())) {
					onLocationChange(repoRef);
					// we have started repository load in the background - that's all for now
					// once the repository is loaded (or fails to load), we'll return again
					// by setting a MDR reference (which may be null if the load fails)
					return;
				}

			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__METADATA_REPOSITORY:
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ENABLED:
				fireNotifyChanged(new ViewerNotification(notification, repoRef, true, false));

				Set<Object> affectedNodeLabels = new HashSet<>();
				affectedNodeLabels.add(repoRef);

				// Go through all direct ancestors first
				EObject container = ((EObject) repoRef).eContainer();

				// Add the aggregator resource. If the contribution is detached, then the primary resource
				// is different from the top resource! We must go up to the resource set and get the first
				// resource which is supposed to be the one we are looking for
				affectedNodeLabels.add(((EObject) repoRef).eResource().getResourceSet().getResources().get(0));

				while (container != null) {
					affectedNodeLabels.add(container);
					container = container.eContainer();
				}

				if (repoRef instanceof MappedRepository) {
					// Browse all mapped units which may have changed their virtual status (inherently enabled/disabled)
					Set<EObject> affectedNodes = new HashSet<>();
					for (MappedUnit unit : ((MappedRepository) repoRef).getUnits(true)) {
						affectedNodes.add((EObject) unit);
						// And now, find all categories which may contain the feature just being enabled/disabled
						if (unit instanceof Feature)
							for (CustomCategory category : ((Feature) unit).getCategories())
								affectedNodes.add((EObject) category);
					}
					for (EObject affectedNode : affectedNodes)
						fireNotifyChanged(new ViewerNotification(notification, affectedNode, true, true));
				}

				for (Object affectedNode : affectedNodeLabels)
					fireNotifyChanged(new ViewerNotification(notification, affectedNode, false, true));

				Aggregation aggregation = repoRef.getAggregation();
				if (notification.getFeatureID(
						MetadataRepositoryReference.class) == AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ENABLED) {
					if (notification.getNewBooleanValue())
						ResourceUtils.loadResourceForMappedRepository(repoRef);
					else
						ResourceUtils.cleanUpResources(aggregation);
				} else
					ResourceUtils.cleanUpResources(aggregation);

				break;
		}

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

		switch (notification.getFeatureID(MetadataRepositoryReference.class)) {
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__ENABLED:
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__STATUS:
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__LOCATION:
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE__NATURE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	private void onLocationChange(MetadataRepositoryReference repository) {
		repository.startRepositoryLoad(false);
	}
}
