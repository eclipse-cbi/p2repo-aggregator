/**
 * Copyright (c) 2006-2007, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.cbi.p2repo.aggregator.util;

import org.eclipse.cbi.p2repo.p2.InstallableUnit;
import org.eclipse.cbi.p2repo.aggregator.Status;
import org.eclipse.cbi.p2repo.aggregator.StatusProvider;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * @author Karel Brezina
 *
 */
public class StatusProviderAdapterFactory extends AdapterFactoryImpl {
	static class StatusProviderAdapter extends AdapterImpl implements StatusProvider {
		public Status getStatus() {
			synchronized(getTarget()) {
				if(getTarget() instanceof StatusProvider)
					return ((StatusProvider) getTarget()).getStatus();
				if(getTarget() instanceof InstallableUnit)
					return InstallableUnitUtils.getStatus((InstallableUnit) getTarget());
			}

			throw new UnsupportedOperationException();
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return type == StatusProvider.class;
		}
	}

	@Override
	protected Adapter createAdapter(Notifier target) {
		return (target instanceof StatusProvider || target instanceof InstallableUnit)
				? new StatusProviderAdapter()
				: null;
	}

	@Override
	public boolean isFactoryForType(Object type) {
		if(type instanceof EPackageImpl)
			return true;

		return type == StatusProvider.class;
	}
}
