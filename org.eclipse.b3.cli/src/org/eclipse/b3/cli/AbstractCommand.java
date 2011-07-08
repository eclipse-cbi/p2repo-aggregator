/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */

package org.eclipse.b3.cli;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.b3.util.B3Util;
import org.eclipse.b3.util.LogLevel;
import org.eclipse.b3.util.LogUtils;
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

	@Option(name = "--logLevel", usage = "Controls the verbosity of the console trace output. Defaults to global b3 settings.")
	private LogLevel logLevel;

	@Option(name = "--eclipseLogLevel", usage = "Controls the verbosity of the eclipse log trace output. Defaults to global b3 settings.")
	private LogLevel eclipseLogLevel;

	private String name;

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
		Bundle[] bundles = B3Util.getPlugin().getBundle().getBundleContext().getBundles();
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

		LogLevel originalConsoleLogLevel = B3Util.getPlugin().getConsoleLogLevel();
		LogLevel originalEclipseLogLevel = B3Util.getPlugin().getEclipseLogLevel();

		try {
			if(logLevel != null)
				B3Util.getPlugin().setConsoleLogLevel(logLevel);
			if(eclipseLogLevel != null)
				B3Util.getPlugin().setEclipseLogLevel(logLevel);

			if(B3Util.getPlugin().getConsoleLogLevel().ordinal() <= LogLevel.DEBUG.ordinal() ||
					B3Util.getPlugin().getEclipseLogLevel().ordinal() <= LogLevel.DEBUG.ordinal())
				printConfiguration();

			return run(monitor);
		}
		finally {
			monitor.done();

			if(logLevel != null)
				B3Util.getPlugin().setConsoleLogLevel(originalConsoleLogLevel);
			if(eclipseLogLevel != null)
				B3Util.getPlugin().setEclipseLogLevel(originalEclipseLogLevel);

		}
	}

	protected abstract int run(IProgressMonitor monitor) throws Exception;

	final void setName(String name) {
		this.name = name;
	}
}
