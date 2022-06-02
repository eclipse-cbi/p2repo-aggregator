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

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.AdapterFactoryItemDelegator;
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
				isSettable, multiLine, sortChoices, staticImage, category, filterFlags, propertyEditorFactory) {
			@Override
			protected Object createPropertyValueWrapper(Object object, Object propertyValue) {
				if (propertyValue instanceof EObject) {
					return new PropertyValueWrapper(adapterFactory, object, propertyValue, propertyValue);
				}
				return super.createPropertyValueWrapper(object, propertyValue);
			}

			/*
			 * (non-Javadoc)
			 * 
			 * @see org.eclipse.emf.edit.provider.ItemPropertyDescriptor#getChoiceOfValues(java.lang.Object)
			 */
			@Override
			public Collection<?> getChoiceOfValues(Object object) {
				// TODO Auto-generated method stub
				return super.getChoiceOfValues(object);
			}

		};
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
