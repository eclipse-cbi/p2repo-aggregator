/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipse.b3.aggregator.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.b3.aggregator.Aggregation;
import org.eclipse.b3.aggregator.AggregatorFactory;
import org.eclipse.b3.aggregator.AggregatorPackage;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
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
 * This is the item provider adapter for a {@link org.eclipse.b3.aggregator.Aggregation} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * 
 * @generated
 */
public class AggregationItemProvider extends DescriptionProviderItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource,
		IItemColorProvider, IItemFontProvider {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public AggregationItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This adds a property descriptor for the Buildmaster feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBuildmasterPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_Aggregation_buildmaster_feature"),
			getString(
				"_UI_PropertyDescriptor_description", "_UI_Aggregation_buildmaster_feature", "_UI_Aggregation_type"),
			AggregatorPackage.Literals.AGGREGATION__BUILDMASTER, true, false, true, null, null, null));
	}

	/**
	 * This adds a property descriptor for the Build Root feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addBuildRootPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_Aggregation_buildRoot_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_buildRoot_feature", "_UI_Aggregation_type"),
			AggregatorPackage.Literals.AGGREGATION__BUILD_ROOT, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Label feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addLabelPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_Aggregation_label_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_label_feature", "_UI_Aggregation_type"),
			AggregatorPackage.Literals.AGGREGATION__LABEL, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Maven Result feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addMavenResultPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_Aggregation_mavenResult_feature"),
			getString(
				"_UI_PropertyDescriptor_description", "_UI_Aggregation_mavenResult_feature", "_UI_Aggregation_type"),
			AggregatorPackage.Literals.AGGREGATION__MAVEN_RESULT, true, false, false,
			ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Packed Strategy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addPackedStrategyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_Aggregation_packedStrategy_feature"),
			getString(
				"_UI_PropertyDescriptor_description", "_UI_Aggregation_packedStrategy_feature", "_UI_Aggregation_type"),
			AggregatorPackage.Literals.AGGREGATION__PACKED_STRATEGY, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Sendmail feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addSendmailPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(),
			getResourceLocator(),
			getString("_UI_Aggregation_sendmail_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_sendmail_feature", "_UI_Aggregation_type"),
			AggregatorPackage.Literals.AGGREGATION__SENDMAIL, true, false, false,
			ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE, null, null));
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add(createItemPropertyDescriptor(
			((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory(), getResourceLocator(),
			getString("_UI_Aggregation_type_feature"),
			getString("_UI_PropertyDescriptor_description", "_UI_Aggregation_type_feature", "_UI_Aggregation_type"),
			AggregatorPackage.Literals.AGGREGATION__TYPE, true, false, false,
			ItemPropertyDescriptor.GENERIC_VALUE_IMAGE, null, null));
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

		newChildDescriptors.add(createChildParameter(
			AggregatorPackage.Literals.AGGREGATION__VALIDATION_SETS, AggregatorFactory.eINSTANCE.createValidationSet()));

		newChildDescriptors.add(createChildParameter(
			AggregatorPackage.Literals.AGGREGATION__CONFIGURATIONS, AggregatorFactory.eINSTANCE.createConfiguration()));

		newChildDescriptors.add(createChildParameter(
			AggregatorPackage.Literals.AGGREGATION__CUSTOM_CATEGORIES,
			AggregatorFactory.eINSTANCE.createCustomCategory()));

		newChildDescriptors.add(createChildParameter(
			AggregatorPackage.Literals.AGGREGATION__CONTACTS, AggregatorFactory.eINSTANCE.createContact()));

		newChildDescriptors.add(createChildParameter(
			AggregatorPackage.Literals.AGGREGATION__MAVEN_MAPPINGS, AggregatorFactory.eINSTANCE.createMavenMapping()));
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
			childrenFeatures.add(AggregatorPackage.Literals.AGGREGATION__VALIDATION_SETS);
			childrenFeatures.add(AggregatorPackage.Literals.AGGREGATION__CONFIGURATIONS);
			childrenFeatures.add(AggregatorPackage.Literals.AGGREGATION__CUSTOM_CATEGORIES);
			childrenFeatures.add(AggregatorPackage.Literals.AGGREGATION__CONTACTS);
			childrenFeatures.add(AggregatorPackage.Literals.AGGREGATION__MAVEN_MAPPINGS);
		}
		return childrenFeatures;
	}

	/**
	 * This returns Aggregation.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/Aggregation"));
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

			addBuildmasterPropertyDescriptor(object);
			addLabelPropertyDescriptor(object);
			addBuildRootPropertyDescriptor(object);
			addPackedStrategyPropertyDescriptor(object);
			addSendmailPropertyDescriptor(object);
			addTypePropertyDescriptor(object);
			addMavenResultPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(Object object) {
		Aggregation self = (Aggregation) object;
		String label = self.getLabel();
		StringBuilder bld = new StringBuilder(getString("_UI_Aggregation_type")).append(" : ");
		if(label != null)
			bld.append(label);
		URI uri = ((EObject) object).eResource().getURI();
		if(uri != null) {
			bld.append(" [");
			bld.append(uri);
			bld.append(']');
		}
		return bld.toString();
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

		switch(notification.getFeatureID(Aggregation.class)) {
			case AggregatorPackage.AGGREGATION__STATUS:
			case AggregatorPackage.AGGREGATION__LABEL:
			case AggregatorPackage.AGGREGATION__BUILD_ROOT:
			case AggregatorPackage.AGGREGATION__PACKED_STRATEGY:
			case AggregatorPackage.AGGREGATION__SENDMAIL:
			case AggregatorPackage.AGGREGATION__TYPE:
			case AggregatorPackage.AGGREGATION__MAVEN_RESULT:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case AggregatorPackage.AGGREGATION__VALIDATION_SETS:
			case AggregatorPackage.AGGREGATION__CONFIGURATIONS:
			case AggregatorPackage.AGGREGATION__CUSTOM_CATEGORIES:
			case AggregatorPackage.AGGREGATION__CONTACTS:
			case AggregatorPackage.AGGREGATION__MAVEN_MAPPINGS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

}
