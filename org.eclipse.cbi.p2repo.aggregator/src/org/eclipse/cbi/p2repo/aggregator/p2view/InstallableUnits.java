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
package org.eclipse.cbi.p2repo.aggregator.p2view;

import org.eclipse.cbi.p2repo.aggregator.ChildrenProvider;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Installable Units</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits#getAllIUs <em>All IUs</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits#getCategoryContainer <em>Category Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits#getFeatureContainer <em>Feature Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits#getProductContainer <em>Product Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits#getBundleContainer <em>Bundle Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits#getFragmentContainer <em>Fragment Container</em>}</li>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits#getMiscellaneousContainer <em>Miscellaneous Container</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getInstallableUnits()
 * @model
 * @generated
 */
public interface InstallableUnits extends ChildrenProvider<EObject> {
	/**
	 * Returns the value of the '<em><b>All IUs</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>All IUs</em>' containment reference list.
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getInstallableUnits_AllIUs()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<IUPresentation> getAllIUs();

	/**
	 * Returns the value of the '<em><b>Bundle Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bundle Container</em>' containment reference.
	 * @see #setBundleContainer(Bundles)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getInstallableUnits_BundleContainer()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Bundles getBundleContainer();

	/**
	 * Returns the value of the '<em><b>Category Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Category Container</em>' containment reference.
	 * @see #setCategoryContainer(Categories)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getInstallableUnits_CategoryContainer()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Categories getCategoryContainer();

	/**
	 * Returns the value of the '<em><b>Feature Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Container</em>' containment reference.
	 * @see #setFeatureContainer(Features)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getInstallableUnits_FeatureContainer()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Features getFeatureContainer();

	/**
	 * Returns the value of the '<em><b>Fragment Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fragment Container</em>' containment reference.
	 * @see #setFragmentContainer(Fragments)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getInstallableUnits_FragmentContainer()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Fragments getFragmentContainer();

	/**
	 * Returns the value of the '<em><b>Miscellaneous Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Miscellaneous Container</em>' containment reference.
	 * @see #setMiscellaneousContainer(Miscellaneous)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getInstallableUnits_MiscellaneousContainer()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Miscellaneous getMiscellaneousContainer();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Bundles getNotNullBundleContainer();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Categories getNotNullCategoryContainer();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Features getNotNullFeatureContainer();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Fragments getNotNullFragmentContainer();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Miscellaneous getNotNullMiscellaneousContainer();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Products getNotNullProductContainer();

	/**
	 * Returns the value of the '<em><b>Product Container</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Product Container</em>' containment reference.
	 * @see #setProductContainer(Products)
	 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage#getInstallableUnits_ProductContainer()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	Products getProductContainer();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits#getBundleContainer <em>Bundle Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bundle Container</em>' containment reference.
	 * @see #getBundleContainer()
	 * @generated
	 */
	void setBundleContainer(Bundles value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits#getCategoryContainer <em>Category Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Category Container</em>' containment reference.
	 * @see #getCategoryContainer()
	 * @generated
	 */
	void setCategoryContainer(Categories value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits#getFeatureContainer <em>Feature Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Container</em>' containment reference.
	 * @see #getFeatureContainer()
	 * @generated
	 */
	void setFeatureContainer(Features value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits#getFragmentContainer <em>Fragment Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fragment Container</em>' containment reference.
	 * @see #getFragmentContainer()
	 * @generated
	 */
	void setFragmentContainer(Fragments value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits#getMiscellaneousContainer <em>Miscellaneous Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Miscellaneous Container</em>' containment reference.
	 * @see #getMiscellaneousContainer()
	 * @generated
	 */
	void setMiscellaneousContainer(Miscellaneous value);

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits#getProductContainer <em>Product Container</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Product Container</em>' containment reference.
	 * @see #getProductContainer()
	 * @generated
	 */
	void setProductContainer(Products value);

} // InstallableUnits
