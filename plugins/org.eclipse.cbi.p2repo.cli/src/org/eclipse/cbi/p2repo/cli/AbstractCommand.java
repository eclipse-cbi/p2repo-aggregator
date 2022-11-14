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

package org.eclipse.cbi.p2repo.cli;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.cbi.p2repo.util.LogLevel;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.cbi.p2repo.util.P2RepoUtil;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.core.runtime.jobs.ProgressProvider;
import org.eclipse.equinox.app.IApplication;
import org.kohsuke.args4j.Option;
import org.osgi.framework.Bundle;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public abstract class AbstractCommand implements Comparable<AbstractCommand> {
	public static final Integer EXIT_OK = IApplication.EXIT_OK;

	public static final Integer EXIT_ERROR = Integer.valueOf(13);

	@Option(name = "-?", aliases = { "--help" }, usage = "Print help screen for specified command")
	private boolean help;

	@Option(name = "--stacktrace", usage = "Display stack trace on error")
	private boolean displayStacktrace;

	@Option(name = "--logLevel", usage = "Controls the verbosity of the console trace output. Defaults to global settings.")
	private LogLevel logLevel;

	@Option(name = "--eclipseLogLevel", usage = "Controls the verbosity of the eclipse log trace output. Defaults to global settings.")
	private LogLevel eclipseLogLevel;

	@Option(name = "--ignored", usage = "This has no effect.", hidden = true)
	private boolean ignored;

	@Option(name = "--ignore", usage = "This has no efffect and ignores all values.", hidden = true)
	private String[] ignore;

	private String name;

	@Override
	public final int compareTo(AbstractCommand another) {
		return another == null
				? 1
				: getName().compareTo(another.getName());
	}

	/**
	 * @return the eclipseLogLevel
	 */
	public final LogLevel getEclipseLogLevel() {
		return eclipseLogLevel;
	}

	public InputStream getHelpStream() {
		return null;
	}

	/**
	 * @return the logLevel
	 */
	public final LogLevel getLogLevel() {
		return logLevel;
	}

	public final String getName() {
		return name;
	};

	public ProgressProvider getProgressProvider() {
		return new ProgressProvider() {
			@Override
			public IProgressMonitor createMonitor(Job job) {
				return getDefaultMonitor();
			}
		};
	}

	public abstract String getShortDescription();

	public String getUsageTitle() {
		return getName() + " [options...]";
	}

	public boolean isDisplayStacktrace() {
		return displayStacktrace;
	}

	public boolean isHelp() {
		return help;
	}

	private void printConfiguration() {
		LogUtils.debug("Configuration:");
		Bundle[] bundles = P2RepoUtil.getPlugin().getBundle().getBundleContext().getBundles();
		List<String> configLines = new ArrayList<String>(bundles.length);
		for(Bundle bundle : bundles)
			configLines.add(bundle.getSymbolicName() + " / " + bundle.getVersion());

		Collections.sort(configLines);

		for(String configLine : configLines)
			LogUtils.debug(configLine);
		LogUtils.debug("");
	}

	public final int run() throws Exception {
		IProgressMonitor monitor = getProgressProvider().getDefaultMonitor();
		if(monitor == null)
			monitor = new NullProgressMonitor();

		LogLevel originalConsoleLogLevel = P2RepoUtil.getPlugin().getConsoleLogLevel();
		LogLevel originalEclipseLogLevel = P2RepoUtil.getPlugin().getEclipseLogLevel();

		try {
			if(logLevel != null)
				P2RepoUtil.getPlugin().setConsoleLogLevel(logLevel);
			if(eclipseLogLevel != null)
				P2RepoUtil.getPlugin().setEclipseLogLevel(logLevel);

			if(P2RepoUtil.getPlugin().getConsoleLogLevel().ordinal() <= LogLevel.DEBUG.ordinal() ||
					P2RepoUtil.getPlugin().getEclipseLogLevel().ordinal() <= LogLevel.DEBUG.ordinal())
				printConfiguration();

			return run(monitor);
		}
		finally {
			monitor.done();

			if(logLevel != null)
				P2RepoUtil.getPlugin().setConsoleLogLevel(originalConsoleLogLevel);
			if(eclipseLogLevel != null)
				P2RepoUtil.getPlugin().setEclipseLogLevel(originalEclipseLogLevel);

		}
	}

	protected abstract int run(IProgressMonitor monitor) throws Exception;

	final void setName(String name) {
		this.name = name;
	}
}
