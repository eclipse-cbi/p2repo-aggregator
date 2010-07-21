/**
 * Copyright (c) 2010, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */
package org.eclipse.b3.ui.outline;

import org.eclipse.b3.build.BeeModel;
import org.eclipse.xtext.ui.editor.outline.actions.DefaultContentOutlineNodeAdapterFactory;

public class BeeLangOutlineNodeAdapterFactory extends DefaultContentOutlineNodeAdapterFactory {

	@SuppressWarnings("rawtypes")
	private static final Class[] types = { BeeModel.class };

	@Override
	public Class<?>[] getAdapterList() {
		return types;
	}

}
