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
package org.eclipse.cbi.p2repo.aggregator.analyzer.provider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.analyzer.AnalyzerPackage;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
import org.eclipse.emf.edit.provider.AttributeValueWrapperItemProvider;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedImage;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;

public class AnalyzerItemProviderAdapter extends ItemProviderAdapter {

	private AdapterFactoryItemDelegator itemDelegator;

	public AnalyzerItemProviderAdapter(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * @return the itemDelegator
	 */
	public AdapterFactoryItemDelegator getItemDelegator() {
		if (itemDelegator == null) {
			itemDelegator = new AdapterFactoryItemDelegator(
					((ComposeableAdapterFactory) adapterFactory).getRootAdapterFactory());
		}
		return itemDelegator;
	}

	@Override
	protected ItemPropertyDescriptor createItemPropertyDescriptor(AdapterFactory adapterFactory,
			ResourceLocator resourceLocator, String displayName, String description, EStructuralFeature feature,
			boolean isSettable, boolean multiLine, boolean sortChoices, Object staticImage, String category,
			String[] filterFlags, Object propertyEditorFactory) {
		return new ItemPropertyDescriptor(adapterFactory, resourceLocator, displayName, description, feature,
				isSettable, multiLine, sortChoices, getPropertyImage(feature, staticImage), category, filterFlags,
				propertyEditorFactory) {
			@Override
			protected Object createPropertyValueWrapper(Object object, Object propertyValue) {
				if (propertyValue instanceof EObject) {
					return new PropertyValueWrapper(adapterFactory, object, propertyValue, propertyValue);
				}
				return super.createPropertyValueWrapper(object, propertyValue);
			}

			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				Collection<?> choiceOfValues = AnalyzerItemProviderAdapter.this.getChoiceOfValues(object,
						getFeature(object));
				return choiceOfValues != null ? choiceOfValues : super.getChoiceOfValues(object);
			}

		};
	}

	protected boolean isTagsFeature(Object feature) {
		return feature == AnalyzerPackage.Literals.CONTRIBUTION_ANALYSIS__TAGS
				|| feature == AnalyzerPackage.Literals.ANALYSIS__TAGS
				|| feature == AnalyzerPackage.Literals.PROJECT__TAGS;
	}

	@Override
	protected Object createWrapper(EObject object, EStructuralFeature feature, Object value, int index) {
		return isTagsFeature(feature) ? //
				new AttributeValueWrapperItemProvider(value, object, (EAttribute) feature, index, adapterFactory,
						getResourceLocator()) {
					@Override
					public Object getImage(Object object) {
						return getResourceLocator().getImage("full/obj16/Tag");
					}
				} : super.createWrapper(object, feature, value, index);
	}

	protected Object getPropertyImage(Object feature, Object staticImage) {
		return isTagsFeature(feature) ? getImage("full/obj16/Tag") : staticImage;
	}

	@Override
	public Object getCreateChildImage(Object owner, Object feature, Object child, Collection<?> selection) {
		return getPropertyImage(feature, super.getCreateChildImage(owner, feature, child, selection));
	}

	@Override
	public String getCreateChildText(Object owner, Object feature, Object child, Collection<?> selection) {
		return isTagsFeature(feature) ? child.toString() : super.getCreateChildText(owner, feature, child, selection);
	}

	protected Collection<?> getChoiceOfValues(Object object, Object feature) {
		return null;
	}

	protected Object getDirectionOverlay(Object object) {
		return null;
	}

	@Override
	protected Object overlayImage(Object object, Object image) {
		Object overlay = getDirectionOverlay(object);
		if (overlay != null) {
			List<Object> images = new ArrayList<>();
			images.add(image);
			images.add(overlay);
			return super.overlayImage(object, new DecoratedImage(images));
		}
		return super.overlayImage(object, image);
	}

	private static final class DecoratedImage extends ComposedImage {
		private DecoratedImage(Collection<?> images) {
			super(images);
		}

		@Override
		public List<Point> getDrawPoints(Size size) {
			Point point = new Point();
			point.x = size.width - 7;
			point.y = size.height - 8;
			return Arrays.asList(new Point[] { new Point(), point });
		}
	}

}
