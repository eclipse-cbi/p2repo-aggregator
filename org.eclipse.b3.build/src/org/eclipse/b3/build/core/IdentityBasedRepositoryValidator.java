/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */

package org.eclipse.b3.build.core;

/**
 * Validator for a repository that uses identity as key, and has no branches.
 * Does not provide any options.
 */
public class IdentityBasedRepositoryValidator extends AbstractRepositoryValidator {
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.b3.build.core.AbstractRepositoryValidator#supportsBranches()
	 */
	@Override
	public boolean supportsBranches() {
		return false;
	}
}
