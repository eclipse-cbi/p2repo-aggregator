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
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Tree path expressed by Resource and EObejcts
 *
 * @author Karel Brezina
 */
public class TreePath {
	private Resource resource;

	private List<EObject> segments = new ArrayList<EObject>();

	private List<EReference> segmentContainers = new ArrayList<EReference>();

	public TreePath(Resource resource) {
		this.resource = resource;
	}

	protected TreePath(Resource resource, List<EObject> segments, List<EReference> segmentContainers) {
		this.resource = resource;
		this.segments.addAll(segments);
		this.segmentContainers.addAll(segmentContainers);
	}

	public void addToLastSegmentContainer(EObject eobject) {
		if(getLastSegment() == null)
			getResource().getContents().add(eobject);
		else
			addToSegmentContainer(segments.size() - 1, eobject);
	}

	@SuppressWarnings("unchecked")
	public void addToSegmentContainer(int index, EObject eobject) {
		EObject segment = getSegment(index);
		EReference container = getSegmentContainer(index);

		if(segment == null)
			throw new IndexOutOfBoundsException("List size is " + segments.size() + ", requred index is " + index);

		Object containerValue = segment.eGet(container);

		if(!container.isMany())
			getSegment(index).eSet(container, eobject);
		else if(containerValue instanceof List<?>)
			((List<EObject>) containerValue).add(eobject);
		else
			throw new IllegalArgumentException("Unsupported EReference value - " + containerValue.getClass());
	}

	public TreePath createChildTreePath(EObject segment, EReference container) {
		TreePath tp = new TreePath(resource, segments, segmentContainers);
		tp.segments.add(segment);
		tp.segmentContainers.add(container);
		return tp;
	}

	public EObject getLastSegment() {
		if(segments.size() == 0)
			return null;

		return segments.get(segments.size() - 1);
	}

	public EReference getLastSegmentContainer() {
		if(segmentContainers.size() == 0)
			return null;

		return segmentContainers.get(segmentContainers.size() - 1);
	}

	public Resource getResource() {
		return resource;
	}

	public EObject getSegment(int index) {
		return segments.get(index);
	}

	public EObject getSegment(String eclassName) {
		if(eclassName == null)
			return null;

		for(EObject eo : segments)
			if(eclassName.equals(eo.eClass().getName()))
				return eo;

		return null;
	}

	public EReference getSegmentContainer(int index) {
		return segmentContainers.get(index);
	}

	public EReference getSegmentContainer(String eclassName) {
		if(eclassName == null)
			return null;

		for(int i = 0; i < segmentContainers.size(); i++)
			if(eclassName.equals(segments.get(i).eClass().getName()))
				return segmentContainers.get(i);

		return null;
	}
}
