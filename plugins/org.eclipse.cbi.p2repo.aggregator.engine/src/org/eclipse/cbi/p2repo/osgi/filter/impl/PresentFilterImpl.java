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

class PresentFilterImpl extends FilterImpl {
	PresentFilterImpl(String attr) {
		super(FilterImpl.PRESENT, attr);
	}

	@Override
	public int compareTo(FilterImpl o) {
		return internalCompareTo(o);
	}

	@Override
	boolean match0(Map<String, ? extends Object> properties) {
		return (properties == null) ? false : properties.get(getAttr()) != null;
	}

	@Override
	void toString(StringBuilder sb) {
		sb.append('(');
		sb.append(getAttr());
		sb.append("=*)"); //$NON-NLS-1$
	}
}
