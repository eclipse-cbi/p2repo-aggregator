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

package org.eclipse.cbi.p2repo.cli.helpers;

import org.eclipse.cbi.p2repo.cli.AbstractCommand;
import org.eclipse.core.runtime.IProgressMonitor;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public final class EmptyCommand extends AbstractCommand {

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.cbi.p2repo.cli.AbstractCommand#getShortDescription()
	 */
	@Override
	public String getShortDescription() {
		return "This is a dummy command";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.cbi.p2repo.cli.AbstractCommand#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected int run(IProgressMonitor monitor) throws Exception {
		return AbstractCommand.EXIT_OK;
	}

}
