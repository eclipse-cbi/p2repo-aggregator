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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerFactory;
import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage;
import org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemColorProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;

/**
 * This is the item provider adapter for a {@link org.eclipse.cbi.p2repo.aggregator.analyzer.ContributionAnalysis} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ContributionAnalysisItemProvider extends AnalyzerItemProviderAdapter
		implements IEditingDomainItemProvider, IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource, IItemColorProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContributionAnalysisItemProvider(AdapterFactory adapterFactory) {
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

			addEnabledPropertyDescriptor(object);
			addLabelPropertyDescriptor(object);
			addDominantPropertyDescriptor(object);
			addMatchPropertyDescriptor(object);
			addLastModifiedPropertyDescriptor(object);
			addRankPropertyDescriptor(object);
			addTagsPropertyDescriptor(object);
			addContributionPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
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
				getString("_UI_ContributionAnalysis_enabled_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ContributionAnalysis_enabled_feature",
						"_UI_ContributionAnalysis_type"),
				AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__ENABLED, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
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
						getResourceLocator(), getString("_UI_ContributionAnalysis_label_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_ContributionAnalysis_label_feature",
								"_UI_ContributionAnalysis_type"),
						AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__LABEL, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Dominant feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addDominantPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ContributionAnalysis_dominant_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ContributionAnalysis_dominant_feature",
						"_UI_ContributionAnalysis_type"),
				AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__DOMINANT, true, false, false,
				ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Match feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addMatchPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ContributionAnalysis_match_feature"),
						getString("_UI_ContributionAnalysis_match_description"),
						AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__MATCH, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Last Modified feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLastModifiedPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ContributionAnalysis_lastModified_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ContributionAnalysis_lastModified_feature",
						"_UI_ContributionAnalysis_type"),
				AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__LAST_MODIFIED, true, false, false,
				ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null,
				URI.createURI("editor://org.eclipse.nebula.widgets.cdatetime/yyyy-MM-dd\'T\'HH:mm:ss\'.\'SSSZ")));
	}

	/**
	 * This adds a property descriptor for the Rank feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addRankPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ContributionAnalysis_rank_feature"),
						getString("_UI_PropertyDescriptor_description", "_UI_ContributionAnalysis_rank_feature",
								"_UI_ContributionAnalysis_type"),
						AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__RANK, false, false, false,
						ItemPropertyDescriptor.INTEGRAL_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Tags feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTagsPropertyDescriptor(Object object) {
		itemPropertyDescriptors
				.add(createItemPropertyDescriptor(((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
						getResourceLocator(), getString("_UI_ContributionAnalysis_tags_feature"),
						getString("_UI_ContributionAnalysis_tags_description"),
						AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__TAGS, true, false, false,
						ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	@Override
	protected Collection<?> getChoiceOfValues(Object object, Object feature) {
		if (feature == AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__TAGS) {
			ContributionAnalysis contributionAnalysis = (ContributionAnalysis) object;
			Analysis analysis = contributionAnalysis.getAnalysis();
			if (analysis != null) {
				return new ArrayList<>(analysis.getTags());
			}
		}
		return super.getChoiceOfValues(object, feature);
	}

	/**
	 * This adds a property descriptor for the Contribution feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addContributionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
				((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
				getString("_UI_ContributionAnalysis_contribution_feature"),
				getString("_UI_PropertyDescriptor_description", "_UI_ContributionAnalysis_contribution_feature",
						"_UI_ContributionAnalysis_type"),
				AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__CONTRIBUTION, false, false, true, null, null, null));
	}

	private boolean showTags(Object object) {
		ContributionAnalysis contributionAnalysis = (ContributionAnalysis) object;
		Analysis analysis = contributionAnalysis.getAnalysis();
		return analysis != null && analysis.isShowTags();
	}

	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		childrenFeatures = null;
		Collection<? extends EStructuralFeature> result = getChildrenFeaturesGen(object);
		if (!showTags(object)) {
			result.remove(AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__TAGS);
		}
		return result;
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Collection<? extends EStructuralFeature> getChildrenFeaturesGen(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__TAGS);
			childrenFeatures.add(AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__INSTALLABLE_UNITS);
			childrenFeatures.add(AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__PROJECTS);
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

	private boolean isDisabled(Object object) {
		ContributionAnalysis contributionAnalysis = (ContributionAnalysis) object;
		Contribution contribution = contributionAnalysis.getContribution();
		return contribution != null && !((EObject) contribution).eIsProxy() && !contribution.isEnabled();
	}

	/**
	 * This returns ContributionAnalysis.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object,
				getResourceLocator()
						.getImage(((ContributionAnalysis) object).getContribution() == null ? "full/obj16/PatternGroup"
								: "full/obj16/ContributionAnalysis"));
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

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.emf.edit.provider.ItemProviderAdapter#getForeground(java.lang.Object)
	 */
	@Override
	public Object getForeground(Object object) {
		if (isDisabled(object) || ((ContributionAnalysis) object).getContribution() == null) {
			return GRAYED_OUT_COLOR;
		}

		return super.getForeground(object);
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		ContributionAnalysis contributionAnalysis = (ContributionAnalysis) object;
		String label = contributionAnalysis.getLabel();
		if (label != null && !label.isEmpty()) {
			return label;
		}

		Contribution contribution = contributionAnalysis.getContribution();
		if (contribution != null) {
			String location = EcoreUtil.getURI((EObject) contribution).trimFragment().toString();
			return location;
		}

		return getString("_UI_ContributionAnalysis_type");
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

		switch (notification.getFeatureID(ContributionAnalysis.class)) {
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__ENABLED:
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__LABEL:
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__DOMINANT:
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__MATCH:
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__LAST_MODIFIED:
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__RANK:
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__CONTRIBUTION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__TAGS:
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__INSTALLABLE_UNITS:
			case AnalyzerPackage.CONTRIBUTION_ANALYSIS__PROJECTS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
			default:
				super.notifyChanged(notification);
				return;
		}
	}

	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		ContributionAnalysis contributionAnalysis = (ContributionAnalysis) object;
		Analysis analysis = contributionAnalysis.getAnalysis();
		if (analysis != null && analysis.isShowTags()) {
			EList<String> existingTags = contributionAnalysis.getTags();
			for (String tag : analysis.getTags()) {
				if (!existingTags.contains(tag)) {
					newChildDescriptors
							.add(createChildParameter(AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__TAGS, tag));
				}
			}
		}
		collectNewChildDescriptorsGen(newChildDescriptors, object);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void collectNewChildDescriptorsGen(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add(createChildParameter(AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__INSTALLABLE_UNITS,
				AnalyzerFactory.eINSTANCE.createInstallableUnitAnalysis()));

		newChildDescriptors.add(createChildParameter(AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__PROJECTS,
				AnalyzerFactory.eINSTANCE.createProject()));
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
