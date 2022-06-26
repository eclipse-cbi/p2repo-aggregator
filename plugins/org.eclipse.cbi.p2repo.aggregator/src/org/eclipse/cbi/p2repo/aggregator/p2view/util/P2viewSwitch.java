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
package org.eclipse.cbi.p2repo.aggregator.p2view.util;

import org.eclipse.cbi.p2repo.aggregator.ChildrenProvider;
import org.eclipse.cbi.p2repo.aggregator.LabelProvider;
import org.eclipse.cbi.p2repo.aggregator.StatusProvider;
import org.eclipse.cbi.p2repo.aggregator.p2view.Bundle;
import org.eclipse.cbi.p2repo.aggregator.p2view.Bundles;
import org.eclipse.cbi.p2repo.aggregator.p2view.Categories;
import org.eclipse.cbi.p2repo.aggregator.p2view.Category;
import org.eclipse.cbi.p2repo.aggregator.p2view.Feature;
import org.eclipse.cbi.p2repo.aggregator.p2view.Features;
import org.eclipse.cbi.p2repo.aggregator.p2view.Fragment;
import org.eclipse.cbi.p2repo.aggregator.p2view.Fragments;
import org.eclipse.cbi.p2repo.aggregator.p2view.IUDetails;
import org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentation;
import org.eclipse.cbi.p2repo.aggregator.p2view.IUPresentationWithDetails;
import org.eclipse.cbi.p2repo.aggregator.p2view.InstallableUnits;
import org.eclipse.cbi.p2repo.aggregator.p2view.Licenses;
import org.eclipse.cbi.p2repo.aggregator.p2view.MetadataRepositoryStructuredView;
import org.eclipse.cbi.p2repo.aggregator.p2view.Miscellaneous;
import org.eclipse.cbi.p2repo.aggregator.p2view.OtherIU;
import org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage;
import org.eclipse.cbi.p2repo.aggregator.p2view.Product;
import org.eclipse.cbi.p2repo.aggregator.p2view.Products;
import org.eclipse.cbi.p2repo.aggregator.p2view.Properties;
import org.eclipse.cbi.p2repo.aggregator.p2view.ProvidedCapabilities;
import org.eclipse.cbi.p2repo.aggregator.p2view.ProvidedCapabilityWrapper;
import org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryBrowser;
import org.eclipse.cbi.p2repo.aggregator.p2view.RepositoryReferences;
import org.eclipse.cbi.p2repo.aggregator.p2view.RequirementWrapper;
import org.eclipse.cbi.p2repo.aggregator.p2view.Requirements;
import org.eclipse.cbi.p2repo.aggregator.p2view.Touchpoints;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;
import org.eclipse.equinox.p2.metadata.IProvidedCapability;
import org.eclipse.equinox.p2.metadata.IRequirement;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.aggregator.p2view.P2viewPackage
 * @generated
 */
public class P2viewSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static P2viewPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public P2viewSwitch() {
		if (modelPackage == null) {
			modelPackage = P2viewPackage.eINSTANCE;
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bundle</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bundle</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBundle(Bundle object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Bundles</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Bundles</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseBundles(Bundles object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Categories</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Categories</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCategories(Categories object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCategory(Category object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Children Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Children Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseChildrenProvider(ChildrenProvider<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFeature(Feature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Features</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Features</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFeatures(Features object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFragment(Fragment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fragments</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fragments</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseFragments(Fragments object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Installable Units</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Installable Units</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInstallableUnits(InstallableUnits object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IProvided Capability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IProvided Capability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIProvidedCapability(IProvidedCapability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IRequirement</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IRequirement</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIRequirement(IRequirement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IU Details</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IU Details</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIUDetails(IUDetails object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IU Presentation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IU Presentation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIUPresentation(IUPresentation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IU Presentation With Details</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IU Presentation With Details</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIUPresentationWithDetails(IUPresentationWithDetails object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLabelProvider(LabelProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Licenses</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Licenses</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseLicenses(Licenses object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metadata Repository Structured View</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metadata Repository Structured View</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMetadataRepositoryStructuredView(MetadataRepositoryStructuredView object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Miscellaneous</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Miscellaneous</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMiscellaneous(Miscellaneous object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Other IU</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Other IU</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseOtherIU(OtherIU object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Product</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Product</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProduct(Product object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Products</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Products</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProducts(Products object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Properties</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Properties</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProperties(Properties object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Provided Capabilities</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Provided Capabilities</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProvidedCapabilities(ProvidedCapabilities object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Provided Capability Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Provided Capability Wrapper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProvidedCapabilityWrapper(ProvidedCapabilityWrapper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repository Browser</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repository Browser</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRepositoryBrowser(RepositoryBrowser object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Repository References</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Repository References</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRepositoryReferences(RepositoryReferences object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirements</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRequirements(Requirements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Requirement Wrapper</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Requirement Wrapper</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseRequirementWrapper(RequirementWrapper object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Status Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Status Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStatusProvider(StatusProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Touchpoints</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Touchpoints</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseTouchpoints(Touchpoints object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T1 defaultCase(EObject object) {
		return null;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T1 doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case P2viewPackage.BUNDLE: {
				Bundle bundle = (Bundle) theEObject;
				T1 result = caseBundle(bundle);
				if (result == null)
					result = caseIUPresentationWithDetails(bundle);
				if (result == null)
					result = caseIUPresentation(bundle);
				if (result == null)
					result = caseIUDetails(bundle);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.BUNDLES: {
				Bundles bundles = (Bundles) theEObject;
				T1 result = caseBundles(bundles);
				if (result == null)
					result = caseChildrenProvider(bundles);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.CATEGORY: {
				Category category = (Category) theEObject;
				T1 result = caseCategory(category);
				if (result == null)
					result = caseIUPresentation(category);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.CATEGORIES: {
				Categories categories = (Categories) theEObject;
				T1 result = caseCategories(categories);
				if (result == null)
					result = caseChildrenProvider(categories);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.FEATURE: {
				Feature feature = (Feature) theEObject;
				T1 result = caseFeature(feature);
				if (result == null)
					result = caseIUPresentationWithDetails(feature);
				if (result == null)
					result = caseIUPresentation(feature);
				if (result == null)
					result = caseIUDetails(feature);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.FEATURES: {
				Features features = (Features) theEObject;
				T1 result = caseFeatures(features);
				if (result == null)
					result = caseChildrenProvider(features);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.FRAGMENT: {
				Fragment fragment = (Fragment) theEObject;
				T1 result = caseFragment(fragment);
				if (result == null)
					result = caseBundle(fragment);
				if (result == null)
					result = caseIUPresentationWithDetails(fragment);
				if (result == null)
					result = caseIUPresentation(fragment);
				if (result == null)
					result = caseIUDetails(fragment);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.FRAGMENTS: {
				Fragments fragments = (Fragments) theEObject;
				T1 result = caseFragments(fragments);
				if (result == null)
					result = caseChildrenProvider(fragments);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.INSTALLABLE_UNITS: {
				InstallableUnits installableUnits = (InstallableUnits) theEObject;
				T1 result = caseInstallableUnits(installableUnits);
				if (result == null)
					result = caseChildrenProvider(installableUnits);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.IU_DETAILS: {
				IUDetails iuDetails = (IUDetails) theEObject;
				T1 result = caseIUDetails(iuDetails);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.IU_PRESENTATION: {
				IUPresentation iuPresentation = (IUPresentation) theEObject;
				T1 result = caseIUPresentation(iuPresentation);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.IU_PRESENTATION_WITH_DETAILS: {
				IUPresentationWithDetails iuPresentationWithDetails = (IUPresentationWithDetails) theEObject;
				T1 result = caseIUPresentationWithDetails(iuPresentationWithDetails);
				if (result == null)
					result = caseIUPresentation(iuPresentationWithDetails);
				if (result == null)
					result = caseIUDetails(iuPresentationWithDetails);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.LICENSES: {
				Licenses licenses = (Licenses) theEObject;
				T1 result = caseLicenses(licenses);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.REPOSITORY_BROWSER: {
				RepositoryBrowser repositoryBrowser = (RepositoryBrowser) theEObject;
				T1 result = caseRepositoryBrowser(repositoryBrowser);
				if (result == null)
					result = caseStatusProvider(repositoryBrowser);
				if (result == null)
					result = caseChildrenProvider(repositoryBrowser);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.METADATA_REPOSITORY_STRUCTURED_VIEW: {
				MetadataRepositoryStructuredView metadataRepositoryStructuredView = (MetadataRepositoryStructuredView) theEObject;
				T1 result = caseMetadataRepositoryStructuredView(metadataRepositoryStructuredView);
				if (result == null)
					result = caseChildrenProvider(metadataRepositoryStructuredView);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.MISCELLANEOUS: {
				Miscellaneous miscellaneous = (Miscellaneous) theEObject;
				T1 result = caseMiscellaneous(miscellaneous);
				if (result == null)
					result = caseChildrenProvider(miscellaneous);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.OTHER_IU: {
				OtherIU otherIU = (OtherIU) theEObject;
				T1 result = caseOtherIU(otherIU);
				if (result == null)
					result = caseIUPresentationWithDetails(otherIU);
				if (result == null)
					result = caseIUPresentation(otherIU);
				if (result == null)
					result = caseIUDetails(otherIU);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.PRODUCT: {
				Product product = (Product) theEObject;
				T1 result = caseProduct(product);
				if (result == null)
					result = caseIUPresentationWithDetails(product);
				if (result == null)
					result = caseIUPresentation(product);
				if (result == null)
					result = caseIUDetails(product);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.PRODUCTS: {
				Products products = (Products) theEObject;
				T1 result = caseProducts(products);
				if (result == null)
					result = caseChildrenProvider(products);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.PROPERTIES: {
				Properties properties = (Properties) theEObject;
				T1 result = caseProperties(properties);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.PROVIDED_CAPABILITIES: {
				ProvidedCapabilities providedCapabilities = (ProvidedCapabilities) theEObject;
				T1 result = caseProvidedCapabilities(providedCapabilities);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.PROVIDED_CAPABILITY_WRAPPER: {
				ProvidedCapabilityWrapper providedCapabilityWrapper = (ProvidedCapabilityWrapper) theEObject;
				T1 result = caseProvidedCapabilityWrapper(providedCapabilityWrapper);
				if (result == null)
					result = caseIProvidedCapability(providedCapabilityWrapper);
				if (result == null)
					result = caseLabelProvider(providedCapabilityWrapper);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.REPOSITORY_REFERENCES: {
				RepositoryReferences repositoryReferences = (RepositoryReferences) theEObject;
				T1 result = caseRepositoryReferences(repositoryReferences);
				if (result == null)
					result = caseChildrenProvider(repositoryReferences);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.REQUIREMENTS: {
				Requirements requirements = (Requirements) theEObject;
				T1 result = caseRequirements(requirements);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.REQUIREMENT_WRAPPER: {
				RequirementWrapper requirementWrapper = (RequirementWrapper) theEObject;
				T1 result = caseRequirementWrapper(requirementWrapper);
				if (result == null)
					result = caseIRequirement(requirementWrapper);
				if (result == null)
					result = caseLabelProvider(requirementWrapper);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case P2viewPackage.TOUCHPOINTS: {
				Touchpoints touchpoints = (Touchpoints) theEObject;
				T1 result = caseTouchpoints(touchpoints);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			default:
				return defaultCase(theEObject);
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

} // P2viewSwitch
