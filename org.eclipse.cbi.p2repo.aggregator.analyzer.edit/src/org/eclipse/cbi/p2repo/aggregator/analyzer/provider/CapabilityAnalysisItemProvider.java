/**
 * Copyright (c) 2021 Eclipse Foundation and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.analyzer.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerFactory;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage;
import org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis;
import org.eclipse.cbi.p2repo.aggregator.util.CapabilityNamespace;
import org.eclipse.cbi.p2repo.aggregator.util.CapabilityNamespaceImageProvider;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ViewerNotification;
import org.eclipse.equinox.p2.metadata.IProvidedCapability;

/**
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityAnalysis} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CapabilityAnalysisItemProvider extends AnalyzerItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource, IItemColorProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapabilityAnalysisItemProvider(AdapterFactory adapterFactory) {
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

			addCapabilityPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Capability feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCapabilityPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_CapabilityAnalysis_capability_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_CapabilityAnalysis_capability_feature",
								"_UI_CapabilityAnalysis_type"),
						AnalyzerPackage.Literals.CAPABILITY_ANALYSIS__CAPABILITY, true, false, true, null, null, null));
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
			childrenFeatures.add(AnalyzerPackage.Literals.CAPABILITY_ANALYSIS__RESOLUTIONS);
		}
		return childrenFeatures;
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

	protected Object getDirectionOverlay(Object object) {
		return getResourceLocator().getImage("full/ovr16/OverlayMappedBottom");
	}

	/**
	 * This returns CapabilityAnalysis.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		CapabilityAnalysis capabilityAnalysis = (CapabilityAnalysis) object;
		IProvidedCapability capability = capabilityAnalysis.getCapability();
		Object image = capability == null ? null : CapabilityNamespaceImageProvider.getImage(capability.getNamespace());
		if (image == null) {
			image = getResourceLocator().getImage("full/obj16/CapabilityAnalysis");
		}

		return overlayImage(object, image);
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
		CapabilityAnalysis capabilityAnalysis = (CapabilityAnalysis) object;
		IProvidedCapability capability = capabilityAnalysis.getCapability();
		if (capability != null) {
			StringBuilder result = new StringBuilder();
			CapabilityNamespace capabilityNamespace = CapabilityNamespace.byId(capability.getNamespace());
			if (capabilityNamespace == CapabilityNamespace.UNKNOWN) {

				result.append(capability.getNamespace() + ":" + " " + capability.getName());
			} else {
				result.append(capabilityNamespace.getLabel() + " " + capability.getName());
			}
			result.append(" / ");
			result.append(capability.getVersion().toString());
			return result.toString();
		}
		return getString("_UI_CapabilityAnalysis_type");
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

		switch (notification.getFeatureID(CapabilityAnalysis.class)) {
			case AnalyzerPackage.CAPABILITY_ANALYSIS__RESOLUTIONS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
			default:
				super.notifyChanged(notification);
				return;
		}
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

		newChildDescriptors.add(createChildParameter(AnalyzerPackage.Literals.CAPABILITY_ANALYSIS__RESOLUTIONS,
				AnalyzerFactory.eINSTANCE.createCapabilityResolution()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return AggregationAnalyzerEditPlugin.INSTANCE;
	}

}
