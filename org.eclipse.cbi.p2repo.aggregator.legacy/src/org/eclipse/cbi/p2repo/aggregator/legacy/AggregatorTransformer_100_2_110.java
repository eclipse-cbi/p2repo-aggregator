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

package org.eclipse.cbi.p2repo.aggregator.legacy;

import java.util.Map;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Transforms aggregator model instance from version 0.9.0 to 1.0.0
 *
 * @author Karel Brezina
 */
public class AggregatorTransformer_100_2_110 extends ResourceTransformer {

	private static final String AGGREGATOR_NODE = "Aggregator";

	private static final String AGGREGATION_NODE = "Aggregation";

	private static final String VALIDATION_SET = "ValidationSet";

	private static final String VALIDATION_SETS_REF = "validationSets";

	@Override
	protected void doTransform(EObject srcEObject, TreePath trgtParentTreePath) {
		try {
			EClass scrEClass = srcEObject.eClass();
			if(AGGREGATOR_NODE.equals(scrEClass.getName()))
				transformAggregatorNode(srcEObject, trgtParentTreePath);
			else
				super.doTransform(srcEObject, trgtParentTreePath);
		}
		catch(RuntimeException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	protected void doTransformRef(EObject srcEObject) {
		EClass scrEClass = srcEObject.eClass();
		boolean resolve = !"CustomCategory".equals(scrEClass.getName());
		super.doTransformRef(srcEObject, resolve);
	}

	@Override
	public void initTransformer(Resource srcResource, Resource trgtResource, EPackage trgtPackage,
			Map<String, Object> context) {
		super.initTransformer(srcResource, trgtResource, trgtPackage, context);
	}

	@SuppressWarnings("unchecked")
	private void transformAggregatorNode(EObject srcEObject, TreePath targetParentTreePath) {
		EObject aggregation = createTrgtEObject(AGGREGATION_NODE, srcEObject);
		EClass aggregationClass = aggregation.eClass();
		targetParentTreePath.addToLastSegmentContainer(aggregation);

		EObject validationSet = createTrgtEObject(VALIDATION_SET, null);
		EClass validationSetClass = validationSet.eClass();

		EList<EObject> validationSets = (EList<EObject>) getFeatureValue(aggregation, VALIDATION_SETS_REF);
		validationSets.add(validationSet);
		TreePath vsTreePath = targetParentTreePath.createChildTreePath(
			aggregation, (EReference) aggregationClass.getEStructuralFeature("validationSets"));

		validationSet.eSet(validationSetClass.getEStructuralFeature("label"), "main");
		copyAttributes(srcEObject, aggregation);

		for(EReference srcERef : srcEObject.eClass().getEAllContainments()) {
			String refName = srcERef.getName();
			boolean isContributions = "contributions".equals(refName);
			Object srcERefValue = srcEObject.eGet(srcERef, resolveProxies || !isContributions);
			if(srcERefValue == null)
				continue;

			TreePath treePath;
			EObject target;
			if(equalsOneOf(refName, "configurations", "customCategories", "contacts", "buildmaster", "mavenMappings")) {
				target = aggregation;
				treePath = targetParentTreePath;
			}
			else {
				target = validationSet;
				treePath = vsTreePath;
			}

			EReference targetERef = (EReference) target.eClass().getEStructuralFeature(refName);

			if(targetERef == null)
				continue;
			// throw new IllegalArgumentException(srcEObject.eClass().getName() + "." + srcERef.getName()
			// + " is not a valid EReference in the target model");

			TreePath targetTreePath = treePath.createChildTreePath(target, targetERef);
			if(!srcERef.isMany())
				transform((EObject) srcERefValue, targetTreePath);
			else {
				BasicEList<EObject> srcChildren = (BasicEList<EObject>) srcERefValue;
				int top = srcChildren.size();
				for(int idx = 0; idx < top; ++idx) {
					EObject srcChild = resolveProxies || !isContributions
							? srcChildren.get(idx)
							: srcChildren.basicGet(idx);
					transform(srcChild, targetTreePath);
				}
			}
		}
	}
}
