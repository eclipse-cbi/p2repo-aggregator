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

import java.util.Map;

/**
 * This interface adds some introspection capabilities to the standard OSGi
 * {@link org.osgi.framework.Filter Filter} together with match methods that
 * accepts the {@link Map} interface.
 *
 * @author Thomas Hallgren
 */
public interface Filter extends org.osgi.framework.Filter {
	/**
	 * Add the attributes that are interrogated by this filter. For each added
	 * attribute, also add the list of values that the attribute is compared to.
	 *
	 * @param propertyChoices
	 */
	void addConsultedAttributes(Map<String, String[]> propertyChoices);

	/**
	 * Concatenate this filter with subFilter using the AND operand.
	 *
	 * @param subFilter
	 *            The filter that should be concatenated. Can be
	 *            <code>null</code>.
	 * @return The concatenated filter or this filter in case the subFilter was
	 *         null or already concatenated.
	 */
	Filter addFilterWithAnd(Filter subFilter);

	/**
	 * Concatenate this filter with subFilter using the OR operand.
	 *
	 * @param subFilter
	 *            The filter that should be concatenated. Can be
	 *            <code>null</code>.
	 * @return The concatenated filter or this filter in case the subFilter was
	 *         null or already concatenated.
	 */
	Filter addFilterWithOr(Filter subFilter);

	/**
	 * Filter using the <code>properties</code> keys and values.
	 *
	 * @param properties
	 *            The properties whose keys and values are used in the match.
	 * @return <code>true</code> if the properties match this filter;
	 *         <code>false</code> otherwise.
	 */
	boolean matchCase(Map<String, ? extends Object> properties);

	/**
	 * <p>
	 * Strip the <code>subFilter</code> from this filter.
	 * </p>
	 * <p>
	 * If this filter is equal to the <code>subFilter</code>, then this method
	 * returns <code>null</code>, otherwise, the subFilter will be excluded from
	 * any NOT, AND, or OR expressions. If the result of the exclusion is an
	 * empty expression, then <code>null</code> is returned.
	 *
	 * @param subFilter
	 *            The filter to exclude from this filter.
	 * @return A filter that does not contain <code>subFilter</code>.
	 */
	Filter stripFilter(Filter subFilter);
}
