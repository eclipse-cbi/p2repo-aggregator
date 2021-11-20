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
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.cbi.p2repo.aggregator.transformer.ITransformer;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;

/**
 * Transforms scrResource to trgtResource using the same node, attribute and reference names. Extend this class if there
 * is a need for a special handling.
 *
 * @author Karel Brezina
 */
public class ResourceTransformer implements ITransformer {
	public static boolean equalsOneOf(String str, String... candidates) {
		for(String candidate : candidates)
			if(str.equals(candidate))
				return true;
		return false;
	}

	protected static Object getFeatureValue(EObject eobject, String featureName) {
		EStructuralFeature feature = eobject.eClass().getEStructuralFeature(featureName);

		if(feature == null)
			throw new IllegalArgumentException(featureName + " is not a valid feature name of " +
					eobject.eClass().getName() + " EClass");

		return eobject.eGet(feature);
	}

	protected Resource srcResource;

	protected Resource trgtResource;

	protected EPackage trgtPackage;

	protected EFactory trgtPackageFactory;

	protected Map<EObject, EObject> transformationMapping = new HashMap<EObject, EObject>();

	protected Map<String, Object> context;

	protected boolean resolveProxies = true;

	private Set<Resource> checkedResources = new HashSet<Resource>();

	private List<Diagnostic> resourceErrors = new ArrayList<Diagnostic>();

	private void checkResource(EObject srcEObject) {
		Resource res = srcEObject.eResource();
		if(checkedResources.add(res))
			resourceErrors.addAll(res.getErrors());
	}

	protected void copyAttributes(EObject srcEObject, EObject trgtEObject) {
		for(EAttribute srcEAttr : srcEObject.eClass().getEAllAttributes()) {
			Object srcEAttrValue = srcEObject.eGet(srcEAttr);

			if(srcEAttrValue == null)
				continue;

			EAttribute trgtEAttr = (EAttribute) trgtEObject.eClass().getEStructuralFeature(srcEAttr.getName());

			if(trgtEAttr == null)
				continue;
			// throw new IllegalArgumentException(srcEObject.eClass().getName() + "." + srcEAttr.getName()
			// + " is not a valid EAttribute in the target model");

			Object trgtEAttrValue = null;

			if(srcEAttrValue instanceof EEnumLiteral)
				// tries to create an enum with the same name and value
				trgtEAttrValue = createTrgtEEnumLiteral(
					((EEnumLiteral) srcEAttrValue).getEEnum().getName(), ((EEnumLiteral) srcEAttrValue).getLiteral());
			else
				trgtEAttrValue = srcEAttrValue;

			trgtEObject.eSet(trgtEAttr, trgtEAttrValue);
		}
	}

	@SuppressWarnings("unchecked")
	protected void copyReferences(EObject srcEObject, EObject trgtEObject, TreePath trgtParentTreePath) {
		for(EReference srcERef : srcEObject.eClass().getEAllContainments()) {
			Object srcERefValue = srcEObject.eGet(srcERef);

			if(srcERefValue == null)
				continue;

			EReference trgtERef = (EReference) trgtEObject.eClass().getEStructuralFeature(srcERef.getName());

			if(trgtERef == null)
				continue;
			// throw new IllegalArgumentException(srcEObject.eClass().getName() + "." + srcERef.getName()
			// + " is not a valid EReference in the target model");

			TreePath trgtTreePath = trgtParentTreePath.createChildTreePath(trgtEObject, trgtERef);

			if(!srcERef.isMany())
				transform((EObject) srcERefValue, trgtTreePath);
			else
				for(EObject srcChild : (List<EObject>) srcERefValue)
					transform(srcChild, trgtTreePath);
		}
	}

	protected Object createTrgtEEnumLiteral(String enumName, String literal) {
		if(enumName == null)
			throw new IllegalArgumentException(enumName + " is not a valid EEnum in the target model");

		EDataType trgtEDataType = (EDataType) trgtPackage.getEClassifier(enumName);

		Object enumerator = trgtPackageFactory.createFromString(trgtEDataType, literal);

		if(enumerator == null)
			throw new IllegalArgumentException(literal + " is not a valid literal for EEnum " + enumName +
					" in the target model");

		return enumerator;
	}

	protected EObject createTrgtEObject(String className, EObject mappedFromSrcEObject) {
		EClass trgtEClass = (EClass) trgtPackage.getEClassifier(className);

		if(trgtEClass == null)
			throw new IllegalArgumentException(className + " is not a valid EClass in the target model");

		EObject trgtEObject = trgtPackageFactory.create(trgtEClass);

		if(mappedFromSrcEObject != null)
			transformationMapping.put(mappedFromSrcEObject, trgtEObject);

		return trgtEObject;
	}

	/**
	 * Transforms srcEObject
	 *
	 * @param srcEObject
	 * @param trgtParentTreePath
	 *            tree path in the target structure
	 */
	protected void doTransform(EObject srcEObject, TreePath trgtParentTreePath) {
		EClass srcEClass = srcEObject.eClass();
		EObject trgtEObject = createTrgtEObject(srcEClass.getName(), srcEObject);
		trgtParentTreePath.addToLastSegmentContainer(trgtEObject);
		if(srcEObject.eIsProxy()) {
			((InternalEObject) trgtEObject).eSetProxyURI(((EObjectImpl) srcEObject).eProxyURI());
		}
		else {
			copyAttributes(srcEObject, trgtEObject);
			copyReferences(srcEObject, trgtEObject, trgtParentTreePath);
		}
		trgtParentTreePath.addToLastSegmentContainer(trgtEObject);
	}

	protected void doTransformRef(EObject srcEObject) {
		doTransformRef(srcEObject, true);
	}

	/**
	 * Transforms references in srcEObject
	 *
	 * @param srcEObject
	 */
	@SuppressWarnings("unchecked")
	protected void doTransformRef(EObject srcEObject, boolean resolve) {
		EClass scrEClass = srcEObject.eClass();

		EObject trgtEObject = transformationMapping.get(srcEObject);

		if(trgtEObject != null) {
			EClass trgtEClass = trgtEObject.eClass();

			for(EReference srcERef : scrEClass.getEAllReferences()) {
				if(scrEClass.getEAllContainments().contains(srcERef))
					continue;

				Object srcERefValue = srcEObject.eGet(srcERef, resolveProxies || resolve);

				if(srcERefValue == null)
					continue;

				EReference trgtERef = (EReference) trgtEClass.getEStructuralFeature(srcERef.getName());

				if(trgtERef == null || trgtERef.isTransient())
					continue;
				// throw new IllegalArgumentException(srcEObject.eClass().getName() + "." + srcERef.getName()
				// + " is not a valid EReference in the target model");

				if(!trgtERef.isMany())
					trgtEObject.eSet(trgtERef, transformationMapping.get(srcERefValue));
				else if(srcERefValue instanceof List<?>) {
					BasicEList<EObject> srcRefList = (BasicEList<EObject>) srcERefValue;
					List<EObject> trgtRefList = (List<EObject>) trgtEObject.eGet(trgtERef);

					int top = srcRefList.size();
					for(int idx = 0; idx < top; ++idx) {
						EObject trgtObj;
						if(resolveProxies || resolve)
							trgtObj = transformationMapping.get(srcRefList.get(idx));
						else {
							EObject perhapsProxy = srcRefList.basicGet(idx);
							if(perhapsProxy == null)
								continue;
							if(perhapsProxy.eIsProxy()) {
								trgtObj = createTrgtEObject(perhapsProxy.eClass().getName(), perhapsProxy);
								((InternalEObject) trgtObj).eSetProxyURI(((EObjectImpl) perhapsProxy).eProxyURI());
							}
							else
								trgtObj = transformationMapping.get(srcRefList.get(idx));
						}
						trgtRefList.add(trgtObj);
					}
				}
			}
		}

		for(EReference srcERef : scrEClass.getEAllContainments()) {
			Object srcERefValue = srcEObject.eGet(srcERef, resolveProxies || resolve);

			if(srcERefValue == null)
				continue;

			if(!srcERef.isMany())
				transformRef((EObject) srcERefValue);
			else
				for(EObject srcChild : (List<EObject>) srcERefValue)
					transformRef(srcChild);
		}
	}

	@Override
	public List<Diagnostic> getResourceErrors() {
		return resourceErrors;
	}

	@Override
	public void initTransformer(Resource srcResource, Resource trgtResource, EPackage trgtPackage,
			Map<String, Object> context) {
		this.srcResource = srcResource;
		this.trgtResource = trgtResource;
		this.trgtPackage = trgtPackage;
		this.context = context;

		if(this.context == null)
			this.context = new HashMap<String, Object>();

		trgtPackageFactory = trgtPackage.getEFactoryInstance();
	}

	/**
	 * Starts transformation
	 */
	@Override
	public final void startTransformation(boolean resolveProxies) {
		this.resolveProxies = resolveProxies;
		for(EObject srcEObject : srcResource.getContents())
			transform(srcEObject, new TreePath(trgtResource));

		for(EObject srcEObject : srcResource.getContents())
			transformRef(srcEObject);
	}

	public final void transform(EObject srcEObject, TreePath treePath) {
		checkResource(srcEObject);
		doTransform(srcEObject, treePath);
	}

	public final void transformRef(EObject srcEObject) {
		checkResource(srcEObject);
		doTransformRef(srcEObject);
	}
}
