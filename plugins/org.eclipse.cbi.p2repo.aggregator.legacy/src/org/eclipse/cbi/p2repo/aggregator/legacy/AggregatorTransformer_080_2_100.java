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

package org.eclipse.cbi.p2repo.aggregator.legacy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.cbi.p2repo.aggregator.IAggregatorConstants;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;

/**
 * Transforms aggregator model instance from version 0.8.0 to 1.0.0
 *
 * @author Karel Brezina
 */
public class AggregatorTransformer_080_2_100 extends ResourceTransformer {
	private static final String BUILD_NODE = "Build";

	private static final String CONFIG_NODE = "Config";

	private static final String CATEGORY_NODE = "Category";

	private static final String FEATURE_NODE = "Feature";

	private static final String CONTRIBUTION_NODE = "Contribution";

	private static final String CONTACT_NODE = "Contact";

	private static final String REPOSITORY_NODE = "Repository";

	private static final String MAPPEDREPOSITORY_NODE = "MappedRepository";

	private static final String BUNDLE_NODE = "Bundle";

	private static final String PRODUCT_NODE = "Product";

	private static final String AGGREGATOR_NODE = "Aggregator";

	private static final String PLATFORMS_REF = "platforms";

	private static final String MAP_REF = "map";

	private static final String PRODUCT_REF = "Product";

	private static final String BASE_REF = "Base";

	private static final String BUILDER_REF = "Builder";

	private static final String COMPILER_REF = "compiler";

	private static final String PROMOTION_REF = "promotion";

	private static final String CONFIGS_REF = "configs";

	private static final String CONTRIBUTIONS_REF = "contributions";

	private static final String CATEGORIES_REF = "categories";

	private static final String CATEGORY_REF = "category";

	private static final String DEFAULTMAILLIST_REF = "defaultMailList";

	private static final String BUILDMASTER_REF = "buildmaster";

	private static final String CONFIGURATIONS_REF = "configurations";

	private static final String CUSTOMCATEGORIES_REF = "customCategories";

	private static final String CONTACTS_REF = "contacts";

	private static final String AGGREGATETYPE_ENUM = "ValidationSetType";

	private static final String AGGREGATOR_REF = "aggregator";

	private static final String CONFIGURATION_NODE = "Configuration";

	private static final String OS_ATTR = "os";

	private static final String WS_ATTR = "ws";

	private static final String ARCH_ATTR = "arch";

	private static final String OPERATINGSYSTEM_ATTR = "operatingSystem";

	private static final String WINDOWSYSTEM_ATTR = "windowSystem";

	private static final String ARCHITECTURE_ATTR = "architecture";

	private static final String OPERATINGSYSTEM_ENUM = "OperatingSystem";

	private static final String WINDOWSYSTEM_ENUM = "WindowSystem";

	private static final String ARCHITECTURE_ENUM = "Architecture";

	private static final String NAME_ATTR = "name";

	private static final String IDENTIFIER_ATTR = "identifier";

	private static final String CUSTOMCATEGORY_NODE = "CustomCategory";

	private static final String REPOSITORIES_REF = "repositories";

	private static final String FEATURES_REF = "features";

	private static final String BUNDLES_REF = "bundles";

	private static final String PRODUCTS_REF = "products";

	private static final String REPO_REF = "repo";

	private static final String LABEL_ATTR = "label";

	private static final String DESCRIPTION_ATTR = "description";

	private static final String ID_ATTR = "id";

	private static final String VERSION_ATTR = "version";

	private static final String VERSIONRANGE_ATTR = "versionRange";

	private static final String ENABLED_ATTR = "enabled";

	private static final String EMAIL_ATTR = "email";

	private List<EObject> srcCategories = new ArrayList<EObject>();

	private List<EObject> srcContributions = new ArrayList<EObject>();

	private List<EObject> srcIUsWithoutRepo = new ArrayList<EObject>();

	private Map<String, EObject> trgtEmailToContactMap = new HashMap<String, EObject>();

	private EReference srcIURepoRef;

	@Override
	protected void doTransform(EObject srcEObject, TreePath trgtParentTreePath) {
		EClass scrEClass = srcEObject.eClass();

		if(BUILD_NODE.equals(scrEClass.getName()))
			transformBuildNode(srcEObject, trgtParentTreePath);
		else if(CONTACT_NODE.equals(scrEClass.getName()))
			transformContactNode(srcEObject, trgtParentTreePath);
		else if(CONFIG_NODE.equals(scrEClass.getName()))
			transformConfigNode(srcEObject, trgtParentTreePath);
		else if(CATEGORY_NODE.equals(scrEClass.getName()))
			transformCategoryNode(srcEObject, trgtParentTreePath);
		else if(CONTRIBUTION_NODE.equals(scrEClass.getName()))
			transformContributionNode(srcEObject, trgtParentTreePath);
		else if(REPOSITORY_NODE.equals(scrEClass.getName()))
			transformRepositoryNode(srcEObject, trgtParentTreePath);
		else if(FEATURE_NODE.equals(scrEClass.getName()))
			transformIUNode(srcEObject, trgtParentTreePath, FEATURE_NODE);
		else if(BUNDLE_NODE.equals(scrEClass.getName()))
			transformIUNode(srcEObject, trgtParentTreePath, BUNDLE_NODE);
		else if(PRODUCT_NODE.equals(scrEClass.getName()))
			transformIUNode(srcEObject, trgtParentTreePath, PRODUCT_NODE);
	}

	@Override
	protected void doTransformRef(EObject srcEObject) {
		transformCategoryRef();
	}

	private void collectSrcIUs(Map<EObject, List<EObject>> srcRepositoryToIUsMap, List<EObject> srcRepositories,
			List<EObject> ius) {
		for(EObject iu : ius) {
			EObject srcRepo = (EObject) iu.eGet(getSrcIURepoRef(iu));

			if(srcRepo == null) {
				srcIUsWithoutRepo.add(iu);
			}
			else {
				if(!srcRepositories.contains(srcRepo))
					srcRepositories.add(srcRepo);

				List<EObject> srcRepoIUs = srcRepositoryToIUsMap.get(srcRepo);

				if(srcRepoIUs == null) {
					srcRepoIUs = new ArrayList<EObject>();
					srcRepositoryToIUsMap.put(srcRepo, srcRepoIUs);
				}

				srcRepoIUs.add(iu);
			}
		}
	}

	private void copyBuildNodeAttributes(EObject srcEObject, EObject trgtEObject) {
		for(EAttribute srcEAttr : srcEObject.eClass().getEAllAttributes()) {
			Object srcEAttrValue = srcEObject.eGet(srcEAttr);

			if(srcEAttrValue == null)
				continue;

			EAttribute trgtEAttr = (EAttribute) trgtEObject.eClass().getEStructuralFeature(srcEAttr.getName());

			if(trgtEAttr == null)
				continue;

			if("type".equals(srcEAttr.getName())) {
				Object trgtEAttrValue = createTrgtEEnumLiteral(
					AGGREGATETYPE_ENUM, ((EEnumLiteral) srcEAttrValue).getLiteral());
				trgtEObject.eSet(trgtEAttr, trgtEAttrValue);
			}
			else {
				trgtEObject.eSet(trgtEAttr, srcEAttrValue);
			}
		}
	}

	private void copyCategoryNodeAttributes(EObject srcEObject, EObject trgtEObject) {
		for(EAttribute srcEAttr : srcEObject.eClass().getEAllAttributes()) {
			Object srcEAttrValue = srcEObject.eGet(srcEAttr);

			if(srcEAttrValue == null)
				continue;

			String trgtEAttrName = srcEAttr.getName();

			if(NAME_ATTR.equals(trgtEAttrName))
				trgtEAttrName = IDENTIFIER_ATTR;

			EAttribute trgtEAttr = (EAttribute) trgtEObject.eClass().getEStructuralFeature(trgtEAttrName);

			if(trgtEAttr == null)
				continue;

			trgtEObject.eSet(trgtEAttr, srcEAttrValue);
		}
	}

	private void copyConfigNodeAttributes(EObject srcEObject, EObject trgtEObject) {
		for(EAttribute srcEAttr : srcEObject.eClass().getEAllAttributes()) {
			Object srcEAttrValue = srcEObject.eGet(srcEAttr);

			if(srcEAttrValue == null)
				continue;

			if(OS_ATTR.equals(srcEAttr.getName())) {
				EAttribute trgtEAttr = (EAttribute) trgtEObject.eClass().getEStructuralFeature(OPERATINGSYSTEM_ATTR);
				Object trgtEAttrValue = createTrgtEEnumLiteral(
					OPERATINGSYSTEM_ENUM, ((EEnumLiteral) srcEAttrValue).getLiteral());
				trgtEObject.eSet(trgtEAttr, trgtEAttrValue);
			}
			else if(WS_ATTR.equals(srcEAttr.getName())) {
				EAttribute trgtEAttr = (EAttribute) trgtEObject.eClass().getEStructuralFeature(WINDOWSYSTEM_ATTR);
				Object trgtEAttrValue = createTrgtEEnumLiteral(
					WINDOWSYSTEM_ENUM, ((EEnumLiteral) srcEAttrValue).getLiteral());
				trgtEObject.eSet(trgtEAttr, trgtEAttrValue);
			}
			else if(ARCH_ATTR.equals(srcEAttr.getName())) {
				EAttribute trgtEAttr = (EAttribute) trgtEObject.eClass().getEStructuralFeature(ARCHITECTURE_ATTR);
				Object trgtEAttrValue = createTrgtEEnumLiteral(
					ARCHITECTURE_ENUM, ((EEnumLiteral) srcEAttrValue).getLiteral());
				trgtEObject.eSet(trgtEAttr, trgtEAttrValue);
			}
			else
				continue;
		}
	}

	private void copyIUNodeAttributes(EObject srcEObject, EObject trgtEObject, String iuNodeName) {
		EAttribute srcIdEAttr = (EAttribute) srcEObject.eClass().getEStructuralFeature(ID_ATTR);
		String srcIdEAttrValue = (String) srcEObject.eGet(srcIdEAttr);

		if(iuNodeName == FEATURE_NODE && srcIdEAttrValue != null)
			srcIdEAttrValue = srcIdEAttrValue + IAggregatorConstants.FEATURE_SUFFIX;

		EAttribute trgtNameEAttr = (EAttribute) trgtEObject.eClass().getEStructuralFeature(NAME_ATTR);
		trgtEObject.eSet(trgtNameEAttr, srcIdEAttrValue);

		EAttribute srcVersionEAttr = (EAttribute) srcEObject.eClass().getEStructuralFeature(VERSION_ATTR);
		String srcVersionEAttrValue = (String) srcEObject.eGet(srcVersionEAttr);

		EAttribute trgtVersionRangeEAttr = (EAttribute) trgtEObject.eClass().getEStructuralFeature(VERSIONRANGE_ATTR);

		if(srcVersionEAttrValue != null) {
			// TODO error handling
			VersionRange vr = new VersionRange(Version.create(srcVersionEAttrValue), true, null, true);
			trgtEObject.eSet(trgtVersionRangeEAttr, vr);
		}
	}

	private void copyRepositoryNodeAttributes(EObject srcEObject, EObject trgtEObject) {
		for(EAttribute srcEAttr : srcEObject.eClass().getEAllAttributes()) {
			Object srcEAttrValue = srcEObject.eGet(srcEAttr);

			if(srcEAttrValue == null)
				continue;

			String trgtEAttrName = srcEAttr.getName();

			if(LABEL_ATTR.equals(trgtEAttrName))
				trgtEAttrName = DESCRIPTION_ATTR;

			EAttribute trgtEAttr = (EAttribute) trgtEObject.eClass().getEStructuralFeature(trgtEAttrName);

			if(trgtEAttr == null)
				continue;

			trgtEObject.eSet(trgtEAttr, srcEAttrValue);
		}
	}

	private EReference getSrcIURepoRef(EObject iu) {
		if(srcIURepoRef == null) {
			srcIURepoRef = (EReference) iu.eClass().getEStructuralFeature(REPO_REF);
		}
		return srcIURepoRef;
	}

	@SuppressWarnings("unchecked")
	private void transformBuildNode(EObject srcEObject, TreePath trgtParentTreePath) {
		EObject aggregatorEObject = createTrgtEObject(AGGREGATOR_NODE, srcEObject);
		trgtParentTreePath.addToLastSegmentContainer(aggregatorEObject);
		copyBuildNodeAttributes(srcEObject, aggregatorEObject);

		List<String> unsupportedRefs = Arrays.asList(new String[] {
				PLATFORMS_REF, MAP_REF, PRODUCT_REF, BASE_REF, BUILDER_REF, COMPILER_REF, PROMOTION_REF });

		for(EReference srcERef : srcEObject.eClass().getEAllContainments()) {
			if(unsupportedRefs.contains(srcERef.getName()))
				continue;

			Object srcERefValue = srcEObject.eGet(srcERef);

			if(srcERefValue == null)
				continue;

			EReference trgtERef = null;

			if(CONFIGS_REF.equals(srcERef.getName())) {
				trgtERef = (EReference) aggregatorEObject.eClass().getEStructuralFeature(CONFIGURATIONS_REF);
			}
			else if(CONTRIBUTIONS_REF.equals(srcERef.getName())) {
				trgtERef = (EReference) aggregatorEObject.eClass().getEStructuralFeature(CONTRIBUTIONS_REF);
			}
			else if(CATEGORIES_REF.equals(srcERef.getName())) {
				trgtERef = (EReference) aggregatorEObject.eClass().getEStructuralFeature(CUSTOMCATEGORIES_REF);
			}
			else if(DEFAULTMAILLIST_REF.equals(srcERef.getName()) || BUILDMASTER_REF.equals(srcERef.getName())) {
				trgtERef = (EReference) aggregatorEObject.eClass().getEStructuralFeature(CONTACTS_REF);
			}
			else
				continue;

			TreePath trgtTreePath = trgtParentTreePath.createChildTreePath(aggregatorEObject, trgtERef);

			if(!srcERef.isMany())
				transform((EObject) srcERefValue, trgtTreePath);
			else
				for(EObject srcChild : (List<EObject>) srcERefValue)
					transform(srcChild, trgtTreePath);

			if(BUILDMASTER_REF.equals(srcERef.getName())) {
				EReference buildmasterERef = (EReference) aggregatorEObject.eClass().getEStructuralFeature(
					BUILDMASTER_REF);
				aggregatorEObject.eSet(buildmasterERef, transformationMapping.get(srcERefValue));
			}
		}
	}

	private void transformCategoryNode(EObject srcEObject, TreePath trgtParentTreePath) {
		EObject categoryEobject = createTrgtEObject(CUSTOMCATEGORY_NODE, srcEObject);
		trgtParentTreePath.addToLastSegmentContainer(categoryEobject);
		copyCategoryNodeAttributes(srcEObject, categoryEobject);

		srcCategories.add(srcEObject);
	}

	@SuppressWarnings("unchecked")
	private void transformCategoryRef() {
		// explore from category to feature
		{
			EClass scrEClass = null;
			EReference srcERef = null;
			EClass trgtEClass = null;
			EReference trgtERef = null;
			EReference trgtCategoriesERef = null;

			for(EObject srcCategory : srcCategories) {

				EObject trgtCategory = transformationMapping.get(srcCategory);

				if(scrEClass == null) {
					scrEClass = srcCategory.eClass();
					srcERef = (EReference) scrEClass.getEStructuralFeature(FEATURES_REF);
					trgtEClass = trgtCategory.eClass();
					trgtERef = (EReference) trgtEClass.getEStructuralFeature(FEATURES_REF);
				}

				Object srcERefValue = srcCategory.eGet(srcERef);

				if(srcERefValue == null)
					continue;

				List<EObject> trgtCategoryFeatureList = (List<EObject>) trgtCategory.eGet(trgtERef);

				for(EObject srcFeature : (List<EObject>) srcERefValue) {

					EObject srcContribution = srcFeature.eContainer();

					if(!srcContributions.contains(srcContribution)) {
						String srcCategoryName = (String) getFeatureValue(srcCategory, NAME_ATTR);
						String srcContributionLabel = (String) getFeatureValue(srcContribution, LABEL_ATTR);
						String srcFeatureId = (String) getFeatureValue(srcFeature, ID_ATTR);

						throw new RuntimeException("Category " + srcCategoryName + " references feature " +
								srcFeatureId + " which belongs to a missing contribution " + srcContributionLabel);
					}

					// e.g. branding feature - only for source build not for aggregation
					if(srcIUsWithoutRepo.contains(srcFeature))
						continue;

					EObject trgtFeature = transformationMapping.get(srcFeature);

					if(trgtFeature == null) {
						String srcIUId = (String) getFeatureValue(srcFeature, ID_ATTR);
						String srcCategoryName = (String) getFeatureValue(srcCategory, NAME_ATTR);
						throw new RuntimeException("Feature " + srcIUId + " is located in category " + srcCategoryName +
								" but not in any contribution");
					}

					if(trgtCategoriesERef == null)
						trgtCategoriesERef = (EReference) trgtFeature.eClass().getEStructuralFeature(CATEGORIES_REF);

					List<EObject> trgtFeatureCategoryList = (List<EObject>) trgtFeature.eGet(trgtCategoriesERef);

					trgtFeatureCategoryList.add(trgtCategory);
					trgtCategoryFeatureList.add(trgtFeature);
				}
			}
		}

		// explore from feature to category

		{
			EReference srcFeaturesERef = null;
			EReference srcCategoriesERef = null;
			EReference trgtCategoriesERef = null;
			EReference trgtFeaturesERef = null;

			for(EObject srcContribution : srcContributions) {

				if(srcFeaturesERef == null)
					srcFeaturesERef = (EReference) srcContribution.eClass().getEStructuralFeature(FEATURES_REF);

				for(EObject srcFeature : ((List<EObject>) srcContribution.eGet(srcFeaturesERef))) {

					if(srcCategoriesERef == null)
						srcCategoriesERef = (EReference) srcFeature.eClass().getEStructuralFeature(CATEGORY_REF);

					EObject trgtFeature = transformationMapping.get(srcFeature);

					if(trgtFeature == null)
						continue;

					if(trgtCategoriesERef == null)
						trgtCategoriesERef = (EReference) trgtFeature.eClass().getEStructuralFeature(CATEGORIES_REF);

					List<EObject> trgtFeatureCategoryList = (List<EObject>) trgtFeature.eGet(trgtCategoriesERef);

					for(EObject srcCategory : ((List<EObject>) srcFeature.eGet(srcCategoriesERef))) {

						EObject trgtCategory = transformationMapping.get(srcCategory);

						if(trgtCategory == null)
							continue;

						if(trgtFeaturesERef == null)
							trgtFeaturesERef = (EReference) trgtCategory.eClass().getEStructuralFeature(FEATURES_REF);

						List<EObject> trgtCategoryFeatureList = (List<EObject>) trgtCategory.eGet(trgtFeaturesERef);

						if(!trgtCategoryFeatureList.contains(trgtFeature))
							trgtCategoryFeatureList.add(trgtFeature);

						if(!trgtFeatureCategoryList.contains(trgtCategory))
							trgtFeatureCategoryList.add(trgtCategory);
					}
				}
			}
		}
	}

	private void transformConfigNode(EObject srcEObject, TreePath trgtParentTreePath) {
		EObject configurationEobject = createTrgtEObject(CONFIGURATION_NODE, srcEObject);
		trgtParentTreePath.addToLastSegmentContainer(configurationEobject);
		copyConfigNodeAttributes(srcEObject, configurationEobject);

		EAttribute enabledEAttr = (EAttribute) configurationEobject.eClass().getEStructuralFeature(ENABLED_ATTR);
		configurationEobject.eSet(enabledEAttr, Boolean.TRUE);
	}

	private void transformContactNode(EObject srcEObject, TreePath trgtParentTreePath) {
		EObject contactEObject = createTrgtEObject(CONTACT_NODE, srcEObject);
		copyAttributes(srcEObject, contactEObject);

		String email = (String) getFeatureValue(contactEObject, EMAIL_ATTR);
		EObject trgtRetrievedContact = trgtEmailToContactMap.get(email);

		if(trgtRetrievedContact != null)
			transformationMapping.put(srcEObject, trgtRetrievedContact);
		else {
			trgtEmailToContactMap.put(email, contactEObject);
			trgtParentTreePath.addToLastSegmentContainer(contactEObject);

			EReference aggrERef = (EReference) contactEObject.eClass().getEStructuralFeature(AGGREGATOR_REF);
			contactEObject.eSet(aggrERef, trgtParentTreePath.getSegment(AGGREGATOR_NODE));
		}
	}

	@SuppressWarnings("unchecked")
	private void transformContributionNode(EObject srcEObject, TreePath trgtParentTreePath) {

		if(srcContributions.contains(srcEObject))
			return;

		EAttribute srcLabelEAttr = (EAttribute) srcEObject.eClass().getEStructuralFeature(LABEL_ATTR);

		// check duplicate contribution label - its used as a key
		String srcLabel1 = (String) srcEObject.eGet(srcLabelEAttr);
		for(EObject contribution : srcContributions) {
			String srcLabel2 = (String) contribution.eGet(srcLabelEAttr);

			if(srcLabel1 != null && srcLabel1.equals(srcLabel2))
				throw new IllegalArgumentException("Label " + srcLabel1 + " is used for more than one contribution");
		}

		EObject contributionEObject = createTrgtEObject(CONTRIBUTION_NODE, srcEObject);
		trgtParentTreePath.addToLastSegmentContainer(contributionEObject);
		copyAttributes(srcEObject, contributionEObject);

		srcContributions.add(srcEObject);

		EAttribute enabledEAttr = (EAttribute) contributionEObject.eClass().getEStructuralFeature(ENABLED_ATTR);
		contributionEObject.eSet(enabledEAttr, Boolean.TRUE);

		List<EObject> srcRepositories = new ArrayList<EObject>();
		Map<EObject, List<EObject>> srcRepositoryToFeturesMap = new HashMap<EObject, List<EObject>>();
		Map<EObject, List<EObject>> srcRepositoryToBundlesMap = new HashMap<EObject, List<EObject>>();
		Map<EObject, List<EObject>> srcRepositoryToProductsMap = new HashMap<EObject, List<EObject>>();

		for(EReference srcERef : srcEObject.eClass().getEAllContainments()) {
			Object srcERefValue = srcEObject.eGet(srcERef);

			if(srcERefValue == null)
				continue;

			EReference trgtERef = null;
			TreePath trgtTreePath = null;

			if(REPOSITORIES_REF.equals(srcERef.getName())) {
				for(EObject srcRepo : (List<EObject>) srcERefValue)
					if(!srcRepositories.contains(srcRepo))
						srcRepositories.add(srcRepo);
			}
			else if(FEATURES_REF.equals(srcERef.getName())) {
				collectSrcIUs(srcRepositoryToFeturesMap, srcRepositories, (List<EObject>) srcERefValue);
			}
			else if(BUNDLES_REF.equals(srcERef.getName())) {
				collectSrcIUs(srcRepositoryToBundlesMap, srcRepositories, (List<EObject>) srcERefValue);
			}
			else if(PRODUCTS_REF.equals(srcERef.getName())) {
				collectSrcIUs(srcRepositoryToProductsMap, srcRepositories, (List<EObject>) srcERefValue);
			}
			else if(CONTACTS_REF.equals(srcERef.getName())) {
				// move contacts to the aggregator node (containment)
				EObject aggregatorEobject = trgtParentTreePath.getSegment(AGGREGATOR_NODE);

				trgtERef = (EReference) aggregatorEobject.eClass().getEStructuralFeature(CONTACTS_REF);
				trgtTreePath = trgtParentTreePath.createChildTreePath(aggregatorEobject, trgtERef);

				for(EObject srcChild : (List<EObject>) srcERefValue)
					transform(srcChild, trgtTreePath);

				// setup contacts references
				EReference contactsERef = (EReference) contributionEObject.eClass().getEStructuralFeature(CONTACTS_REF);
				List<EObject> contactsERefValues = (List<EObject>) contributionEObject.eGet(contactsERef);

				for(EObject srcChild : (List<EObject>) srcERefValue)
					contactsERefValues.add(transformationMapping.get(srcChild));
			}
			else
				continue;
		}
		// handle repos
		EReference trgtERef = (EReference) contributionEObject.eClass().getEStructuralFeature(REPOSITORIES_REF);
		TreePath trgtRepositoryTreePath = trgtParentTreePath.createChildTreePath(contributionEObject, trgtERef);

		for(EObject srcRepo : srcRepositories)
			transform(srcRepo, trgtRepositoryTreePath);

		// handle features, bundles and products
		for(EObject srcRepositoryEObject : srcRepositories) {
			transformRepoIUs(trgtRepositoryTreePath, srcRepositoryEObject, srcRepositoryToFeturesMap, FEATURES_REF);
			transformRepoIUs(trgtRepositoryTreePath, srcRepositoryEObject, srcRepositoryToBundlesMap, BUNDLES_REF);
			transformRepoIUs(trgtRepositoryTreePath, srcRepositoryEObject, srcRepositoryToProductsMap, PRODUCTS_REF);
		}
	}

	private void transformIUNode(EObject srcEObject, TreePath trgtParentTreePath, String iuNodeName) {
		EObject iuEObject = createTrgtEObject(iuNodeName, srcEObject);
		trgtParentTreePath.addToLastSegmentContainer(iuEObject);
		copyIUNodeAttributes(srcEObject, iuEObject, iuNodeName);

		EAttribute enabledEAttr = (EAttribute) iuEObject.eClass().getEStructuralFeature(ENABLED_ATTR);
		iuEObject.eSet(enabledEAttr, Boolean.TRUE);

		// enable used repository, repositories without IUs are disabled
		trgtParentTreePath.getLastSegment().eSet(enabledEAttr, Boolean.TRUE);
	}

	private void transformRepoIUs(TreePath trgtRepositoryTreePath, EObject srcRepositoryEObject,
			Map<EObject, List<EObject>> srcRepositoryToIUsMap, String trgtIURefName) {
		List<EObject> srcIUs = srcRepositoryToIUsMap.get(srcRepositoryEObject);

		if(srcIUs == null)
			return;

		EObject trgtRepositoryEObject = transformationMapping.get(srcRepositoryEObject);

		EReference trgtERef = (EReference) trgtRepositoryEObject.eClass().getEStructuralFeature(trgtIURefName);
		TreePath trgtTreePath = trgtRepositoryTreePath.createChildTreePath(trgtRepositoryEObject, trgtERef);

		for(EObject srcIU : srcIUs)
			transform(srcIU, trgtTreePath);
	}

	private void transformRepositoryNode(EObject srcEObject, TreePath trgtParentTreePath) {
		EObject repositoryEObject = createTrgtEObject(MAPPEDREPOSITORY_NODE, srcEObject);
		trgtParentTreePath.addToLastSegmentContainer(repositoryEObject);
		copyRepositoryNodeAttributes(srcEObject, repositoryEObject);

		EAttribute enabledEAttr = (EAttribute) repositoryEObject.eClass().getEStructuralFeature(ENABLED_ATTR);

		// it's enabled once an IU is added
		repositoryEObject.eSet(enabledEAttr, Boolean.FALSE);
	}

}
