/**
 * Copyright (c) 2006-2013, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.osgi.filter.impl;

import java.util.Map;

import org.eclipse.cbi.p2repo.osgi.filter.Filter;

class NotFilterImpl extends FilterImpl {
	private final FilterImpl filter;

	NotFilterImpl(FilterImpl value) {
		super(FilterImpl.NOT, null);
		filter = value;
	}

	@Override
	public void addConsultedAttributes(Map<String, String[]> propertyChoices) {
		filter.addConsultedAttributes(propertyChoices);
	}

	@Override
	public int compareTo(FilterImpl that) {
		int cmp = internalCompareTo(that);
		if (cmp == 0)
			cmp = filter.compareTo(((NotFilterImpl) that).filter);
		return cmp;
	}

	@Override
	public FilterImpl stripFilter(Filter subFilter) {
		if (equals(subFilter))
			return null;

		FilterImpl newFilter = (FilterImpl) filter.stripFilter(subFilter);
		if (newFilter == filter)
			return this;

		if (newFilter == null)
			return null;

		return new NotFilterImpl(newFilter);
	}

	FilterImpl getFilter() {
		return filter;
	}

	@Override
	boolean match0(Map<String, ? extends Object> properties) {
		return !filter.match0(properties);
	}

	@Override
	void toString(StringBuilder sb) {
		sb.append('(');
		sb.append('!');
		filter.toString(sb);
		sb.append(')');
	}
}
