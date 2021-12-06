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

import org.eclipse.cbi.p2repo.p2.MetadataRepository;
import org.eclipse.cbi.p2repo.p2.P2Package;
import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.provider.ViewerNotification;

public class MetadataRepositoryItemProvider extends org.eclipse.cbi.p2repo.p2.provider.MetadataRepositoryItemProvider {

	public MetadataRepositoryItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public void notifyChanged(Notification notification) {
		super.notifyChanged(notification);

		if(notification.getFeatureID(MetadataRepository.class) != P2Package.METADATA_REPOSITORY__INSTALLABLE_UNITS)
			return;

		Aggregation aggregation = (Aggregation) ((EObject) notification.getNotifier()).eResource().getResourceSet().getResources().get(
			0).getContents().get(0);
		fireNotifyChanged(new ViewerNotification(notification, aggregation, true, true));
	}
}
