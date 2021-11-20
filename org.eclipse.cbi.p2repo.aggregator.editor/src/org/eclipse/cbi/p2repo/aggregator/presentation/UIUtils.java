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

package org.eclipse.cbi.p2repo.aggregator.presentation;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.TreePath;
import org.eclipse.swt.widgets.Text;

/**
 * @author Karel Brezina
 *
 */
public class UIUtils {

	public static TreePath createTreePath(EObject eObject) {
		if(eObject == null)
			return null;

		List<EObject> segments = new ArrayList<EObject>();

		segments.add(eObject);

		while(eObject.eContainer() != null) {
			eObject = eObject.eContainer();
			segments.add(0, eObject);
		}

		return new TreePath(segments.toArray());
	}

	public static void safeSetText(Text formatStringText, String currentFormatString) {
		formatStringText.setText(currentFormatString == null
				? ""
				: currentFormatString);

	}

	public static String trimmedValue(String string) {
		String value = null;

		if(string != null) {
			value = string.trim();
			if(value.length() == 0)
				value = null;
		}
		return value;
	}

	public static String trimmedValue(Text text) {
		String value = null;
		if(text != null) {
			value = text.getText().trim();
			if(value.length() == 0)
				value = null;
		}
		return value;
	}

}
