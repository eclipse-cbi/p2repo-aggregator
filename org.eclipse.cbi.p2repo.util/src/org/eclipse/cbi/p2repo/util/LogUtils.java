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

package org.eclipse.cbi.p2repo.util;

import static org.eclipse.cbi.p2repo.util.LogLevel.DEBUG;
import static org.eclipse.cbi.p2repo.util.LogLevel.ERROR;
import static org.eclipse.cbi.p2repo.util.LogLevel.INFO;
import static org.eclipse.cbi.p2repo.util.LogLevel.WARNING;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class LogUtils {

	public static void debug(String msg, Object... args) {
		log(DEBUG, msg, args);
	}

	public static void debug(Throwable t, String msg, Object... args) {
		log(DEBUG, t, msg, args);
	}

	public static void error(String msg, Object... args) {
		log(ERROR, msg, args);
	}

	public static void error(Throwable t, String msg, Object... args) {
		log(ERROR, t, msg, args);
	}

	public static ILog getLog() {
		return Platform.getLog(P2RepoUtil.getPlugin().getBundle());
	}

	public static void info(String msg, Object... args) {
		log(INFO, msg, args);
	}

	public static void info(Throwable t, String msg, Object... args) {
		log(INFO, t, msg, args);
	}

	public static void log(IStatus status) {
		P2RepoUtil plugin = P2RepoUtil.getPlugin();
		if(status.getSeverity() >= plugin.getConsoleLogLevel().ordinal()) {
			String fullMessage = status.getMessage();
			if(status.getSeverity() >= IStatus.WARNING)
				System.err.println(fullMessage);
			else
				System.out.println(fullMessage);
		}
		getLog().log(status);
	}

	public static void log(LogLevel level, String msg, Object... args) {
		log(level, null, msg, args);
	}

	public static void log(LogLevel level, Throwable t, String msg, Object... args) {
		String fullMessage = (args == null || args.length == 0)
				? msg
				: String.format(msg, args);

		P2RepoUtil plugin = P2RepoUtil.getPlugin();
		if(level.ordinal() >= plugin.getConsoleLogLevel().ordinal())
			if(level.ordinal() >= IStatus.WARNING)
				System.err.println(fullMessage);
			else
				System.out.println(fullMessage);

		if(level.ordinal() >= plugin.getEclipseLogLevel().ordinal())
			getLog().log(new Status(level.getStatusLevel(), P2RepoUtil.getPluginID(), MAGIC, fullMessage, t));
	}

	public static void warning(String msg, Object... args) {
		log(WARNING, msg, args);
	}

	public static void warning(Throwable t, String msg, Object... args) {
		log(WARNING, t, msg, args);
	}

	private static final int MAGIC = P2RepoUtil.getPluginID().hashCode();
}
