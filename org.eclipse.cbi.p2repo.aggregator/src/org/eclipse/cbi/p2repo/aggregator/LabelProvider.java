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
package org.eclipse.cbi.p2repo.aggregator;

import java.util.Comparator;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Label Provider</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.eclipse.cbi.p2repo.aggregator.LabelProvider#getLabel <em>Label</em>}</li>
 * </ul>
 *
 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getLabelProvider()
 * @model interface="true" abstract="true"
 * @generated
 */
public interface LabelProvider {

	static class LabelProviderComparator implements Comparator<LabelProvider> {

		@Override
		public int compare(LabelProvider lp1, LabelProvider lp2) {
			if (lp1 != null) {
				if (lp2 == null)
					return 1;

				String label1 = lp1.getLabel();
				String label2 = lp2.getLabel();

				if (label1 != null)
					return (label2 == null) ? 1 : label1.toLowerCase().compareTo(label2.toLowerCase());

				if (label2 != null)
					return -1;
			} else if (lp2 != null)
				return -1;

			return 0;
		}
	}

	static Comparator<LabelProvider> COMPARATOR = new LabelProviderComparator();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' attribute.
	 * @see #setLabel(String)
	 * @see org.eclipse.cbi.p2repo.aggregator.AggregatorPackage#getLabelProvider_Label()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	String getLabel();

	/**
	 * Sets the value of the '{@link org.eclipse.cbi.p2repo.aggregator.LabelProvider#getLabel <em>Label</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' attribute.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(String value);

} // LabelProvider
