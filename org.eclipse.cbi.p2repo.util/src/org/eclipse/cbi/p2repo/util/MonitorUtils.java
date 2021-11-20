/**
 * Copyright (c) 2004, 2016
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.util;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.SubMonitor;

/**
 * @author kolwing
 */
public class MonitorUtils {
	public static void begin(IProgressMonitor monitor, int ticks) {
		begin(monitor, null, ticks);
	}

	public static void begin(IProgressMonitor monitor, String taskName, int ticks) {
		if(monitor != null && !monitor.isCanceled()) {
			// we should not throw exception during 'begin'
			// checkedTestCancelStatus(monitor);
			monitor.beginTask(taskName, ticks);
		}
	}

	/**
	 * Any method receiving a monitor must always do *something* with it. It can be passed on to another method (in
	 * which case the current receiver must not touch it in any other way) Or, the receiver can do the
	 * beginTask()/done() pattern and pass sub-monitors to others. Sometimes the receiver decides that it should do
	 * nothing. It still *must* have the monitor 'completed' in order to correctly signal callers that the receiver 'did
	 * some work' (even if it was nothing)
	 *
	 * @param monitor
	 *            the monitor to run beginTask()/isCanceled()/done() for. Can be <code>null</code>
	 */
	public static void complete(IProgressMonitor monitor) {
		if(monitor != null) {
			try {
				if(!monitor.isCanceled()) {
					monitor.beginTask(null, 1);
				}
			}
			finally {
				monitor.done();
			}
		}
	}

	public static void done(IProgressMonitor monitor) {
		if(monitor != null) {
			// Do not throw OperationCanceledException when "done".
			// but still mark it "done".
			// Consumer's may need to check if monitor.isCanceled() before
			// or after calling 'done' depending on their use.
			monitor.done();
		}
	}

	/**
	 * Makes it easier to follow the pattern of ensuring there's a real monitor to talk to for the rest of the code in a
	 * monitor receiver
	 *
	 * @param monitor
	 *            the monitor to check for nullness and replace with a 'real' monitor if necessary
	 * @return The argument or a new {@link NullProgressMonitor} if the argument was <code>null</code>
	 */
	public static IProgressMonitor ensureNotNull(IProgressMonitor monitor) {
		if(monitor == null) {
			monitor = new NullProgressMonitor();
		}
		return monitor;
	}

	/**
	 * Creates a new sub-progress monitor for the given monitor. The sub progress monitor uses the given number of work
	 * ticks from its parent monitor. A check for cancellation is made prior to the creation of the sub-progress
	 * monitor.
	 *
	 * @param monitor
	 *            the parent progress monitor. Can be <code>null</code>
	 * @param ticks
	 *            the number of work ticks allocated from the parent monitor
	 * @return The sub monitor or <code>null</code> if the provided <code>monitor</code> parameter was <code>null</code> .
	 */
	public static IProgressMonitor subMonitor(IProgressMonitor monitor, int ticks) {
		if(monitor != null && !monitor.isCanceled()) {
			monitor = SubMonitor.convert(monitor, ticks);
		}
		return monitor;
	}

	/**
	 * Creates a new sub-progress monitor for the given monitor. The sub progress monitor uses the given number of work
	 * ticks from its parent monitor. A check for cancellation is made prior to the creation of the sub-progress
	 * monitor.
	 *
	 * @param monitor
	 *            the parent progress monitor. Can be <code>null</code>
	 * @param ticks
	 *            the number of work ticks allocated from the parent monitor
	 * @param style
	 *            one of
	 *            <ul>
	 *            <li><code>SUPPRESS_SUBTASK_LABEL</code></li>
	 *            <li><code>PREPEND_MAIN_LABEL_TO_SUBTASK</code></li>
	 *            </ul>
	 * @see SubMonitor#SUPPRESS_SUBTASK_LABEL
	 * @see SubMonitor#PREPEND_MAIN_LABEL_TO_SUBTASK
	 * @return The sub monitor or <code>null</code> if the provided <code>monitor</code> parameter was <code>null</code>
	 */
	// Appears not used
	// public static IProgressMonitor subMonitor(IProgressMonitor monitor, int ticks, boolean prependMainLabelToSubtask) {
	// SubMonitor subMonitor = null;
	// if(monitor != null && !monitor.isCanceled()) {
	// int style = prependMainLabelToSubtask
	// ? SubMonitor.SUPPRESS_NONE
	// : SubMonitor.SUPPRESS_ALL_LABELS;
	// subMonitor = SubMonitor.convert(monitor, ticks);
	// subMonitor.split(ticks, style);
	// return subMonitor;
	// }
	// return monitor;
	// }

	/**
	 * Notifies that a subtask of the main task is beginning. Subtasks are optional; the main task might not have
	 * subtasks. A check for cancellation is made prior to notifying.
	 *
	 * @param monitor
	 *            the progress monitor. Can be <code>null</code>
	 * @param name
	 *            the name (or description) of the subtask
	 */
	public static void subTask(IProgressMonitor monitor, String name) {
		if(monitor != null && !monitor.isCanceled()) {
			monitor.subTask(name);
		}
	}

	/**
	 * The typical pattern is to always check cancellation before doing any action. Use this to easily make the check a
	 * one-liner.
	 *
	 * @param monitor
	 *            the monitor to check for cancellation. Can be <code>null</code>
	 * @throws OperationCanceledException
	 *             if the monitor was canceled
	 */
	public static void testCancelStatus(IProgressMonitor monitor) throws OperationCanceledException {
		if(monitor != null && monitor.isCanceled()) {
			throw new OperationCanceledException();
		}
	}

	/**
	 * A monitor should timely be checked for cancellation. This method makes it simple to ensure it is done at every
	 * work tick.
	 *
	 * @param monitor
	 *            the monitor to test and then tick
	 * @param work
	 *            the tick amount
	 * @throws OperationCanceledException
	 *             if the monitor was cancelled
	 */
	public static void worked(IProgressMonitor monitor, int work) throws OperationCanceledException {
		if(monitor != null) {
			testCancelStatus(monitor);
			monitor.worked(work);
		}
	}
}
