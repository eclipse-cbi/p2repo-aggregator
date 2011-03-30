/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *
 * $Id$
 */
package org.eclipse.b3.aggregator.p2view.impl;

import org.eclipse.b3.aggregator.InstallableUnitType;
import org.eclipse.b3.aggregator.p2view.Bundle;
import org.eclipse.b3.aggregator.p2view.P2viewPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Bundle</b></em>'. <!-- end-user-doc -->
 * <p>
 * </p>
 * 
 * @generated
 */
public class BundleImpl extends IUPresentationWithDetailsImpl implements Bundle {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	protected BundleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected BundleImpl(IInstallableUnit iu) {
		super(iu);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
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
