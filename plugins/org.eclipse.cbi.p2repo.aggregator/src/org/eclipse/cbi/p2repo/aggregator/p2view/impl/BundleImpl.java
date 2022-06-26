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
package org.eclipse.cbi.p2repo.aggregator.p2view.impl;

import org.eclipse.cbi.p2repo.aggregator.InstallableUnitType;
import org.eclipse.cbi.p2repo.aggregator.p2view.Bundle;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bundle</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class BundleImpl extends IUPresentationWithDetailsImpl implements Bundle {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BundleImpl() {
		super();
	}

	/**
	 *
	 *
	 * @generated NOT
	 */
	protected BundleImpl(IInstallableUnit iu) {
		super(iu);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return P2viewPackage.Literals.BUNDLE;
	}

	@Override
	public InstallableUnitType getType() {
		return InstallableUnitType.BUNDLE;
	}

} // BundleImpl
