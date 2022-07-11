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
package org.eclipse.cbi.p2repo.aggregator.util;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.AvailableVersion;
import org.eclipse.cbi.p2repo.aggregator.AvailableVersionsHeader;
import org.eclipse.cbi.p2repo.aggregator.Bundle;
import org.eclipse.cbi.p2repo.aggregator.Category;
import org.eclipse.cbi.p2repo.aggregator.ChildrenProvider;
import org.eclipse.cbi.p2repo.aggregator.Configuration;
import org.eclipse.cbi.p2repo.aggregator.Contact;
import org.eclipse.cbi.p2repo.aggregator.Contribution;
import org.eclipse.cbi.p2repo.aggregator.CustomCategory;
import org.eclipse.cbi.p2repo.aggregator.DescriptionProvider;
import org.eclipse.cbi.p2repo.aggregator.EnabledStatusProvider;
import org.eclipse.cbi.p2repo.aggregator.ExclusionRule;
import org.eclipse.cbi.p2repo.aggregator.Feature;
import org.eclipse.cbi.p2repo.aggregator.IdentificationProvider;
import org.eclipse.cbi.p2repo.aggregator.InfosProvider;
import org.eclipse.cbi.p2repo.aggregator.InstallableUnitRequest;
import org.eclipse.cbi.p2repo.aggregator.LabelProvider;
import org.eclipse.cbi.p2repo.aggregator.MapRule;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.cbi.p2repo.aggregator.MappedUnit;
import org.eclipse.cbi.p2repo.aggregator.MavenDependencyItem;
import org.eclipse.cbi.p2repo.aggregator.MavenDependencyMapping;
import org.eclipse.cbi.p2repo.aggregator.MavenItem;
import org.eclipse.cbi.p2repo.aggregator.MavenMapping;
import org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference;
import org.eclipse.cbi.p2repo.aggregator.Product;
import org.eclipse.cbi.p2repo.aggregator.Property;
import org.eclipse.cbi.p2repo.aggregator.Status;
import org.eclipse.cbi.p2repo.aggregator.StatusProvider;
import org.eclipse.cbi.p2repo.aggregator.ValidConfigurationsRule;
import org.eclipse.cbi.p2repo.aggregator.ValidationSet;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy. It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage
 * @generated
 */
public class AggregatorSwitch<T1> extends Switch<T1> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static AggregatorPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AggregatorSwitch() {
		if (modelPackage == null) {
			modelPackage = AggregatorPackage.eINSTANCE;
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAggregation(Aggregation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Available Version</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Available Version</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAvailableVersion(AvailableVersion object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Available Versions Header</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Available Versions Header</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseAvailableVersionsHeader(AvailableVersionsHeader object) {
		return null;
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
	 * Returns the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comparable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public <T> T1 caseComparable(Comparable<T> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Configuration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseConfiguration(Configuration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contact</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contact</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseContact(Contact object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Contribution</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Contribution</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseContribution(Contribution object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Custom Category</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Custom Category</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseCustomCategory(CustomCategory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Description Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Description Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseDescriptionProvider(DescriptionProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Enabled Status Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Enabled Status Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseEnabledStatusProvider(EnabledStatusProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exclusion Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exclusion Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseExclusionRule(ExclusionRule object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Identification Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Identification Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseIdentificationProvider(IdentificationProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Infos Provider</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Infos Provider</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInfosProvider(InfosProvider object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Installable Unit Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Installable Unit Request</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseInstallableUnitRequest(InstallableUnitRequest object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Mapped Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapped Repository</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMappedRepository(MappedRepository object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mapped Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mapped Unit</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMappedUnit(MappedUnit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Map Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Map Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMapRule(MapRule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Maven Dependency Item</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Maven Dependency Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @since 1.1.0
	 * @generated
	 */
	public T1 caseMavenDependencyItem(MavenDependencyItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Maven Item</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Maven Item</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMavenItem(MavenItem object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Maven Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Maven Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMavenMapping(MavenMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Maven Dependency Mapping</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Maven Dependency Mapping</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @since 1.1.0
	 * @generated
	 */
	public T1 caseMavenDependencyMapping(MavenDependencyMapping object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Metadata Repository Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Metadata Repository Reference</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseMetadataRepositoryReference(MetadataRepositoryReference object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Status</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Status</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseStatus(Status object) {
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
	 * Returns the result of interpreting the object as an instance of '<em>Validation Set</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Validation Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseValidationSet(ValidationSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Valid Configurations Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Valid Configurations Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T1 caseValidConfigurationsRule(ValidConfigurationsRule object) {
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
			case AggregatorPackage.AGGREGATION: {
				Aggregation aggregation = (Aggregation) theEObject;
				T1 result = caseAggregation(aggregation);
				if (result == null)
					result = caseDescriptionProvider(aggregation);
				if (result == null)
					result = caseStatusProvider(aggregation);
				if (result == null)
					result = caseInfosProvider(aggregation);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.AVAILABLE_VERSIONS_HEADER: {
				AvailableVersionsHeader availableVersionsHeader = (AvailableVersionsHeader) theEObject;
				T1 result = caseAvailableVersionsHeader(availableVersionsHeader);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.AVAILABLE_VERSION: {
				AvailableVersion availableVersion = (AvailableVersion) theEObject;
				T1 result = caseAvailableVersion(availableVersion);
				if (result == null)
					result = caseComparable(availableVersion);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.BUNDLE: {
				Bundle bundle = (Bundle) theEObject;
				T1 result = caseBundle(bundle);
				if (result == null)
					result = caseMappedUnit(bundle);
				if (result == null)
					result = caseInstallableUnitRequest(bundle);
				if (result == null)
					result = caseEnabledStatusProvider(bundle);
				if (result == null)
					result = caseIdentificationProvider(bundle);
				if (result == null)
					result = caseStatusProvider(bundle);
				if (result == null)
					result = caseInfosProvider(bundle);
				if (result == null)
					result = caseDescriptionProvider(bundle);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.CATEGORY: {
				Category category = (Category) theEObject;
				T1 result = caseCategory(category);
				if (result == null)
					result = caseMappedUnit(category);
				if (result == null)
					result = caseInstallableUnitRequest(category);
				if (result == null)
					result = caseEnabledStatusProvider(category);
				if (result == null)
					result = caseIdentificationProvider(category);
				if (result == null)
					result = caseStatusProvider(category);
				if (result == null)
					result = caseInfosProvider(category);
				if (result == null)
					result = caseDescriptionProvider(category);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.CHILDREN_PROVIDER: {
				ChildrenProvider<?> childrenProvider = (ChildrenProvider<?>) theEObject;
				T1 result = caseChildrenProvider(childrenProvider);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.CONFIGURATION: {
				Configuration configuration = (Configuration) theEObject;
				T1 result = caseConfiguration(configuration);
				if (result == null)
					result = caseEnabledStatusProvider(configuration);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.CONTACT: {
				Contact contact = (Contact) theEObject;
				T1 result = caseContact(contact);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.CONTRIBUTION: {
				Contribution contribution = (Contribution) theEObject;
				T1 result = caseContribution(contribution);
				if (result == null)
					result = caseEnabledStatusProvider(contribution);
				if (result == null)
					result = caseDescriptionProvider(contribution);
				if (result == null)
					result = caseStatusProvider(contribution);
				if (result == null)
					result = caseInfosProvider(contribution);
				if (result == null)
					result = caseIdentificationProvider(contribution);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.FEATURE: {
				Feature feature = (Feature) theEObject;
				T1 result = caseFeature(feature);
				if (result == null)
					result = caseMappedUnit(feature);
				if (result == null)
					result = caseInstallableUnitRequest(feature);
				if (result == null)
					result = caseEnabledStatusProvider(feature);
				if (result == null)
					result = caseIdentificationProvider(feature);
				if (result == null)
					result = caseStatusProvider(feature);
				if (result == null)
					result = caseInfosProvider(feature);
				if (result == null)
					result = caseDescriptionProvider(feature);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.CUSTOM_CATEGORY: {
				CustomCategory customCategory = (CustomCategory) theEObject;
				T1 result = caseCustomCategory(customCategory);
				if (result == null)
					result = caseStatusProvider(customCategory);
				if (result == null)
					result = caseInfosProvider(customCategory);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.DESCRIPTION_PROVIDER: {
				DescriptionProvider descriptionProvider = (DescriptionProvider) theEObject;
				T1 result = caseDescriptionProvider(descriptionProvider);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.ENABLED_STATUS_PROVIDER: {
				EnabledStatusProvider enabledStatusProvider = (EnabledStatusProvider) theEObject;
				T1 result = caseEnabledStatusProvider(enabledStatusProvider);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.EXCLUSION_RULE: {
				ExclusionRule exclusionRule = (ExclusionRule) theEObject;
				T1 result = caseExclusionRule(exclusionRule);
				if (result == null)
					result = caseMapRule(exclusionRule);
				if (result == null)
					result = caseInstallableUnitRequest(exclusionRule);
				if (result == null)
					result = caseEnabledStatusProvider(exclusionRule);
				if (result == null)
					result = caseStatusProvider(exclusionRule);
				if (result == null)
					result = caseInfosProvider(exclusionRule);
				if (result == null)
					result = caseDescriptionProvider(exclusionRule);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.IDENTIFICATION_PROVIDER: {
				IdentificationProvider identificationProvider = (IdentificationProvider) theEObject;
				T1 result = caseIdentificationProvider(identificationProvider);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.INFOS_PROVIDER: {
				InfosProvider infosProvider = (InfosProvider) theEObject;
				T1 result = caseInfosProvider(infosProvider);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.INSTALLABLE_UNIT_REQUEST: {
				InstallableUnitRequest installableUnitRequest = (InstallableUnitRequest) theEObject;
				T1 result = caseInstallableUnitRequest(installableUnitRequest);
				if (result == null)
					result = caseStatusProvider(installableUnitRequest);
				if (result == null)
					result = caseInfosProvider(installableUnitRequest);
				if (result == null)
					result = caseDescriptionProvider(installableUnitRequest);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.LABEL_PROVIDER: {
				LabelProvider labelProvider = (LabelProvider) theEObject;
				T1 result = caseLabelProvider(labelProvider);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.MAPPED_REPOSITORY: {
				MappedRepository mappedRepository = (MappedRepository) theEObject;
				T1 result = caseMappedRepository(mappedRepository);
				if (result == null)
					result = caseMetadataRepositoryReference(mappedRepository);
				if (result == null)
					result = caseDescriptionProvider(mappedRepository);
				if (result == null)
					result = caseIdentificationProvider(mappedRepository);
				if (result == null)
					result = caseEnabledStatusProvider(mappedRepository);
				if (result == null)
					result = caseStatusProvider(mappedRepository);
				if (result == null)
					result = caseInfosProvider(mappedRepository);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.MAPPED_UNIT: {
				MappedUnit mappedUnit = (MappedUnit) theEObject;
				T1 result = caseMappedUnit(mappedUnit);
				if (result == null)
					result = caseInstallableUnitRequest(mappedUnit);
				if (result == null)
					result = caseEnabledStatusProvider(mappedUnit);
				if (result == null)
					result = caseIdentificationProvider(mappedUnit);
				if (result == null)
					result = caseStatusProvider(mappedUnit);
				if (result == null)
					result = caseInfosProvider(mappedUnit);
				if (result == null)
					result = caseDescriptionProvider(mappedUnit);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.MAP_RULE: {
				MapRule mapRule = (MapRule) theEObject;
				T1 result = caseMapRule(mapRule);
				if (result == null)
					result = caseInstallableUnitRequest(mapRule);
				if (result == null)
					result = caseEnabledStatusProvider(mapRule);
				if (result == null)
					result = caseStatusProvider(mapRule);
				if (result == null)
					result = caseInfosProvider(mapRule);
				if (result == null)
					result = caseDescriptionProvider(mapRule);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.MAVEN_DEPENDENCY_ITEM: {
				MavenDependencyItem mavenDependencyItem = (MavenDependencyItem) theEObject;
				T1 result = caseMavenDependencyItem(mavenDependencyItem);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.MAVEN_ITEM: {
				MavenItem mavenItem = (MavenItem) theEObject;
				T1 result = caseMavenItem(mavenItem);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.MAVEN_MAPPING: {
				MavenMapping mavenMapping = (MavenMapping) theEObject;
				T1 result = caseMavenMapping(mavenMapping);
				if (result == null)
					result = caseStatusProvider(mavenMapping);
				if (result == null)
					result = caseInfosProvider(mavenMapping);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.MAVEN_DEPENDENCY_MAPPING: {
				MavenDependencyMapping mavenDependencyMapping = (MavenDependencyMapping) theEObject;
				T1 result = caseMavenDependencyMapping(mavenDependencyMapping);
				if (result == null)
					result = caseStatusProvider(mavenDependencyMapping);
				if (result == null)
					result = caseInfosProvider(mavenDependencyMapping);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.METADATA_REPOSITORY_REFERENCE: {
				MetadataRepositoryReference metadataRepositoryReference = (MetadataRepositoryReference) theEObject;
				T1 result = caseMetadataRepositoryReference(metadataRepositoryReference);
				if (result == null)
					result = caseEnabledStatusProvider(metadataRepositoryReference);
				if (result == null)
					result = caseStatusProvider(metadataRepositoryReference);
				if (result == null)
					result = caseInfosProvider(metadataRepositoryReference);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.PRODUCT: {
				Product product = (Product) theEObject;
				T1 result = caseProduct(product);
				if (result == null)
					result = caseMappedUnit(product);
				if (result == null)
					result = caseInstallableUnitRequest(product);
				if (result == null)
					result = caseEnabledStatusProvider(product);
				if (result == null)
					result = caseIdentificationProvider(product);
				if (result == null)
					result = caseStatusProvider(product);
				if (result == null)
					result = caseInfosProvider(product);
				if (result == null)
					result = caseDescriptionProvider(product);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.PROPERTY: {
				Property property = (Property) theEObject;
				T1 result = caseProperty(property);
				if (result == null)
					result = caseComparable(property);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.STATUS: {
				Status status = (Status) theEObject;
				T1 result = caseStatus(status);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.STATUS_PROVIDER: {
				StatusProvider statusProvider = (StatusProvider) theEObject;
				T1 result = caseStatusProvider(statusProvider);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.VALIDATION_SET: {
				ValidationSet validationSet = (ValidationSet) theEObject;
				T1 result = caseValidationSet(validationSet);
				if (result == null)
					result = caseEnabledStatusProvider(validationSet);
				if (result == null)
					result = caseDescriptionProvider(validationSet);
				if (result == null)
					result = caseStatusProvider(validationSet);
				if (result == null)
					result = caseInfosProvider(validationSet);
				if (result == null)
					result = caseIdentificationProvider(validationSet);
				if (result == null)
					result = defaultCase(theEObject);
				return result;
			}
			case AggregatorPackage.VALID_CONFIGURATIONS_RULE: {
				ValidConfigurationsRule validConfigurationsRule = (ValidConfigurationsRule) theEObject;
				T1 result = caseValidConfigurationsRule(validConfigurationsRule);
				if (result == null)
					result = caseMapRule(validConfigurationsRule);
				if (result == null)
					result = caseInstallableUnitRequest(validConfigurationsRule);
				if (result == null)
					result = caseEnabledStatusProvider(validConfigurationsRule);
				if (result == null)
					result = caseStatusProvider(validConfigurationsRule);
				if (result == null)
					result = caseInfosProvider(validConfigurationsRule);
				if (result == null)
					result = caseDescriptionProvider(validConfigurationsRule);
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

} // AggregatorSwitch
