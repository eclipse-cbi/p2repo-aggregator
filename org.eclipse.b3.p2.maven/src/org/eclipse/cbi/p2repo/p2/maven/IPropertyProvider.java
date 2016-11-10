/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */

package org.eclipse.cbi.p2repo.p2.maven;

import org.eclipse.core.runtime.CoreException;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public interface IPropertyProvider {

	String getProperty(String key) throws CoreException;

}
