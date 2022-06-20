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
package org.eclipse.cbi.p2repo.aggregator.p2.provider;

import org.eclipse.emf.common.notify.Adapter;

public class P2ItemProviderAdapterFactory extends org.eclipse.cbi.p2repo.p2.provider.P2ItemProviderAdapterFactory {

	@Override
	public Adapter createMetadataRepositoryAdapter() {
		if (metadataRepositoryItemProvider == null) {
			metadataRepositoryItemProvider = new MetadataRepositoryItemProvider(this);
		}

		return metadataRepositoryItemProvider;
	}

	@Override
	public Adapter createProvidedCapabilityAdapter() {
		if (providedCapabilityItemProvider == null) {
			providedCapabilityItemProvider = new ProvidedCapabilityItemProvider(this);
		}

		return providedCapabilityItemProvider;
	}

	@Override
	public Adapter createRequiredCapabilityAdapter() {
		if (requiredCapabilityItemProvider == null) {
			requiredCapabilityItemProvider = new RequiredCapabilityItemProvider(this);
		}

		return requiredCapabilityItemProvider;
	}
}
