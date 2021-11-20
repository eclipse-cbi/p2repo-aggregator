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
package org.eclipse.cbi.p2repo.aggregator.p2.provider;

import org.eclipse.cbi.p2repo.p2.ProvidedCapability;
import org.eclipse.cbi.p2repo.aggregator.util.CapabilityNamespaceImageProvider;
import org.eclipse.emf.common.notify.AdapterFactory;

public class ProvidedCapabilityItemProvider extends org.eclipse.cbi.p2repo.p2.provider.ProvidedCapabilityItemProvider {
	public ProvidedCapabilityItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public Object getImage(Object object) {
		ProvidedCapability pc = (ProvidedCapability) object;

		Object image = CapabilityNamespaceImageProvider.getImage(pc.getNamespace());
		if(image == null)
			image = getResourceLocator().getImage("full/obj16/ProvidedCapability");

		return overlayImage(object, image);
	}
}
