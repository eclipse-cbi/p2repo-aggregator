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
package org.eclipse.cbi.p2repo.osgi.filter;

import org.eclipse.cbi.p2repo.osgi.filter.impl.Parser;
import org.osgi.framework.InvalidSyntaxException;

public class FilterFactory {
	/**
	 * Constructs a {@link Filter} object.
	 *
	 * <p>
	 * If the filter cannot be parsed, an {@link InvalidSyntaxException} will be
	 * thrown with a human readable message where the filter became unparsable.
	 *
	 * @param filterString
	 *            the filter string.
	 * @exception InvalidSyntaxException
	 *                If the filter parameter contains an invalid filter string
	 *                that cannot be parsed.
	 */
	public static Filter newInstance(String filterString) throws InvalidSyntaxException {
		return Parser.parse(filterString);
	}
}
