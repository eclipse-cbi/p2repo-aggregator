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

import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage;
import org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.InstallableUnitAnalysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.RequirementAnalysis;
import org.eclipse.cbi.p2repo.p2.util.P2Utils;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.equinox.internal.p2.metadata.IRequiredCapability;
import org.eclipse.equinox.internal.p2.metadata.RequiredPropertiesMatch;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.expression.IFilterExpression;
import org.eclipse.equinox.p2.metadata.expression.IMatchExpression;

/**
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.aggregator.analyzer.CapabilityResolution} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class CapabilityResolutionItemProvider extends AnalyzerItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource, IItemColorProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CapabilityResolutionItemProvider(AdapterFactory adapterFactory) {
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

			addRequirementPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Requirement feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRequirementPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_CapabilityResolution_requirement_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_CapabilityResolution_requirement_feature",
						"_UI_CapabilityResolution_type"),
				AnalyzerPackage.Literals.CAPABILITY_RESOLUTION__REQUIREMENT, true, false, true, null, null, null));
	}

	@Override
	protected Object getDirectionOverlay(Object object) {
		return getResourceLocator().getImage("full/ovr16/OverlayMappedTop");
	}

	/**
	 * This returns CapabilityResolution.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		CapabilityResolution capabilityResolution = (CapabilityResolution) object;
		RequirementAnalysis requirementAnalysis = capabilityResolution.getRequirement();
		if (requirementAnalysis != null) {
			IRequirement requirement = requirementAnalysis.getRequirement();
			if (requirement instanceof IRequiredCapability) {
				IRequiredCapability requiredCapability = (IRequiredCapability) requirement;
				P2Utils.versionRangeToString(requiredCapability.getRange());
			}
		}

		return overlayImage(object, getResourceLocator().getImage("full/obj16/CapabilityResolution"));
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
		CapabilityResolution capabilityResolution = (CapabilityResolution) object;
		RequirementAnalysis requirementAnalysis = capabilityResolution.getRequirement();
		if (requirementAnalysis != null) {
			InstallableUnitAnalysis installableUnitAnalysis = requirementAnalysis.getInstallableUnit();
			if (installableUnitAnalysis != null) {
				ContributionAnalysis contribution = installableUnitAnalysis.getContribution();
				if (contribution != null) {
					String suffix = getItemDelegator().getText(installableUnitAnalysis) + " - "
							+ contribution.getLabel();
					IRequirement requirement = requirementAnalysis.getRequirement();
					if (requirement instanceof IRequiredCapability) {
						IRequiredCapability requiredCapability = (IRequiredCapability) requirement;
						return P2Utils.versionRangeToString(requiredCapability.getRange()) + " - " + suffix;
					} else {
						IMatchExpression<IInstallableUnit> matches = requirement.getMatches();
						if (RequiredPropertiesMatch.isPropertiesMatchRequirement(matches)) {
							IFilterExpression propertiesMatch = RequiredPropertiesMatch.extractPropertiesMatch(matches);
							return propertiesMatch + " - " + suffix;
						} else {
							return matches + " - " + suffix;
						}
					}
				}
			}
		}

		return getString("_UI_CapabilityResolution_type");
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
		return AggregationAnalyzerEditPlugin.INSTANCE;
	}

}
