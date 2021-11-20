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

import org.eclipse.cbi.p2repo.p2.util.IUUtils;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.metadata.VersionedId;

/**
 * Transforms aggregator model instance from version 0.9.0 to 1.0.0
 *
 * @author Karel Brezina
 */
public class AggregatorTransformer_090_2_100 extends ResourceTransformer {

	public static final String CONTEXT_FIXED_VERSION = "AggregatorTransformer_090_2_100.FIXED_VERSION";

	private static final String FEATURE_NODE = "Feature";

	private static final String BUNDLE_NODE = "Bundle";

	private static final String PRODUCT_NODE = "Product";

	private static final String CATEGORY_NODE = "Category";

	private static final String EXCLUSION_RULE_NODE = "ExclusionRule";

	private static final String VALID_CONFIGURATIONS_RULE_NODE = "ValidConfigurationsRule";

	private static final String INSTALLABLE_UNIT_REF = "installableUnit";

	private static final String NAME_ATTR = "name";

	private static final String VERSIONRANGE_ATTR = "versionRange";

	private boolean fixedVersion;

	@Override
	public void initTransformer(Resource srcResource, Resource trgtResource, EPackage trgtPackage,
			Map<String, Object> context) {
		super.initTransformer(srcResource, trgtResource, trgtPackage, context);

		fixedVersion = false;
		Object object = context.get(CONTEXT_FIXED_VERSION);
		if(object != null)
			fixedVersion = ((Boolean) object).booleanValue();
	}

	@Override
	protected void doTransform(EObject srcEObject, TreePath trgtParentTreePath) {
		EClass scrEClass = srcEObject.eClass();

		if(FEATURE_NODE.equals(scrEClass.getName()))
			transformIUNode(srcEObject, trgtParentTreePath);
		else if(BUNDLE_NODE.equals(scrEClass.getName()))
			transformIUNode(srcEObject, trgtParentTreePath);
		else if(PRODUCT_NODE.equals(scrEClass.getName()))
			transformIUNode(srcEObject, trgtParentTreePath);
		else if(CATEGORY_NODE.equals(scrEClass.getName()))
			transformIUNode(srcEObject, trgtParentTreePath);
		else if(EXCLUSION_RULE_NODE.equals(scrEClass.getName()))
			transformIUNode(srcEObject, trgtParentTreePath);
		else if(VALID_CONFIGURATIONS_RULE_NODE.equals(scrEClass.getName()))
			transformIUNode(srcEObject, trgtParentTreePath);
		else
			super.doTransform(srcEObject, trgtParentTreePath);
	}

	private void transformIUNode(EObject srcEObject, TreePath trgtParentTreePath) {
		EObject srcIU = (EObject) getFeatureValue(srcEObject, INSTALLABLE_UNIT_REF);
		if(srcIU == null)
			return;

		VersionedId versionedId = IUUtils.getVersionedNameFromProxy((InternalEObject) srcIU);
		if(versionedId == null || versionedId.getId() == null)
			return;

		EObject iuEObject = createTrgtEObject(srcEObject.eClass().getName(), srcEObject);
		trgtParentTreePath.addToLastSegmentContainer(iuEObject);
		copyAttributes(srcEObject, iuEObject);

		EAttribute trgtNameEAttr = (EAttribute) iuEObject.eClass().getEStructuralFeature(NAME_ATTR);
		iuEObject.eSet(trgtNameEAttr, versionedId.getId());

		EAttribute trgtVersionRangeEAttr = (EAttribute) iuEObject.eClass().getEStructuralFeature(VERSIONRANGE_ATTR);

		if(versionedId.getVersion() != null) {
			VersionRange vr = new VersionRange(versionedId.getVersion(), true, fixedVersion
					? versionedId.getVersion()
					: null, true);
			iuEObject.eSet(trgtVersionRangeEAttr, vr);
		}
	}
}
