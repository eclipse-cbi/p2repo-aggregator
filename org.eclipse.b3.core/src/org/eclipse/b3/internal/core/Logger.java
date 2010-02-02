package org.eclipse.b3.internal.core;

/*****************************************************************************
 * Copyright (c) 2006-2007, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 *****************************************************************************/

import java.io.OutputStream;
import java.io.PrintStream;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.ILogListener;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.osgi.framework.Bundle;

/**
 * This logger will disptach all messages to two destinations; the eclipse logger and the console. Depending on the
 * settings, the message might be dispatched to none, one, or both destinations. The logger can also be made to dispatch
 * console messages through the eclipse logger. It does that by adding an ILogListener to the platform that will
 * dispatch all messages to standard out.
 * 
 * @author Thomas Hallgren
 */
@SuppressWarnings("synthetic-access")
public class Logger
{
	private static class EclipseLogListener implements ILogListener
	{
		public void logging(IStatus status, String plugin)
		{
			int severity = status.getSeverity();
			if(severity >= s_consoleThreshold)
			{
				PrintStream out;
				switch(severity)
				{
				case IStatus.ERROR:
				case IStatus.WARNING:
					out = System.err;
					break;
				default:
					out = System.out;
				}
				Logger.printStatus(status, out);
			}
		}
	}

	public static final int SILENT = IStatus.CANCEL; // We use this constant to avoid collisions

	public static final int DEBUG = IStatus.OK;

	public static final int ERROR = IStatus.ERROR;

	public static final int INFO = IStatus.INFO;

	public static final int WARNING = IStatus.WARNING;

	// Magic used as the bundle specific code in log entries. Can be used
	// for filtering (although not in the Eclipse log viewer since it
	// doesn't support filtering on plugin specific code yet)
	//
	private static final int MAGIC = 293;

	private static Logger s_defaultLogger;

	private static int s_consoleThreshold = 0x1;

	//	private static int s_consoleThreshold = IBuckminsterPreferenceConstants.LOG_LEVEL_CONSOLE_DEFAULT;

	private static int s_eclipseLoggerThreshold = 0x2;

	//	private static int s_eclipseLoggerThreshold = IBuckminsterPreferenceConstants.LOG_LEVEL_ECLIPSE_LOGGER_DEFAULT;

	private static ILogListener s_eclipseLogListener;

	private static PrintStream s_errStream;

	private static PrintStream s_outStream;

	static
	{
		setOutStream(getLoggerStream(false));
		setErrStream(getLoggerStream(true));
	}

	public static Logger getDefault()
	{
		return s_defaultLogger;
	}

	public static PrintStream getErrStream()
	{
		return s_errStream;
	}

	public static PrintStream getOutStream()
	{
		return s_outStream;
	}

	public static void printStatus(IStatus status, PrintStream out)
	{
		synchronized(out)
		{
			printStatus(status, out, 0);
			out.flush();
		}
	}

	public static void setConsoleLevelThreshold(int threshold)
	{
		s_consoleThreshold = threshold;
	}

	public static void setEclipseLoggerLevelThreshold(int threshold)
	{
		s_eclipseLoggerThreshold = threshold;
	}

	public static synchronized void setEclipseLoggerToConsole(boolean flag)
	{
		if(flag)
		{
			if(s_eclipseLogListener == null)
			{
				s_eclipseLogListener = new EclipseLogListener();
				Platform.addLogListener(s_eclipseLogListener);
			}
		}
		else
		{
			if(s_eclipseLogListener != null)
			{
				Platform.removeLogListener(s_eclipseLogListener);
				s_eclipseLogListener = null;
			}
		}
	}

	public static void setErrStream(PrintStream err)
	{
		s_errStream = err;
	}

	public static void setOutStream(PrintStream out)
	{
		s_outStream = out;
	}

	static void setDefaultLogger(Bundle bundle)
	{
		s_defaultLogger = new Logger(bundle);
	}

	private static PrintStream getLoggerStream(boolean errorStream)
	{
		// collect all implementors of a builder log receiver and hook them all
		// up in a tee
		//
		PrintStream sysStream = errorStream
				? System.err
				: System.out;
//		if(Buckminster.isHeadless())
//			return sysStream;

		IExtensionRegistry ier = Platform.getExtensionRegistry();
		IConfigurationElement[] elems = ier.getConfigurationElementsFor(BUILDER_LOG_RECEIVER_POINT);
		int idx = elems.length;
		if(idx == 0)
			return sysStream;

		try
		{
			OutputStream[] streams = new OutputStream[idx + 1];
			streams[idx] = sysStream;
			while(--idx >= 0)
			{
				ILogReceiver receiver = (ILogReceiver)elems[idx].createExecutableExtension("class"); //$NON-NLS-1$
				streams[idx] = receiver.start("B3 log", "org.eclipse.ui.MessageConsole", true, errorStream); //$NON-NLS-1$ //$NON-NLS-2$
			}
			return new PrintStream(new MultiTeeOutputStream(streams), true);
		}
		catch(Throwable t)
		{
			t.printStackTrace(System.err);
			return sysStream;
		}
	}

	private static void printStatus(IStatus status, PrintStream out, int indent)
	{
		boolean hasSeverityPrefix = false;
		String msg = status.getMessage();
		if(msg != null)
			hasSeverityPrefix = msg.startsWith("ERROR") || msg.startsWith("WARN") || msg.startsWith("INFO"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$

		for(int idx = 0; idx < indent; ++idx)
			out.print(' ');

		if(!hasSeverityPrefix)
		{
			switch(status.getSeverity())
			{
			case IStatus.CANCEL:
				return;
			case IStatus.ERROR:
				out.print("ERROR: "); //$NON-NLS-1$
				break;
			case IStatus.INFO:
				out.print("INFO:  "); //$NON-NLS-1$
				break;
			case IStatus.WARNING:
				out.print("WARN:  "); //$NON-NLS-1$
			}
		}

		out.println(msg);
		Throwable t = status.getException();
		if(t != null)
			t.printStackTrace(out);

		indent += 2;
		for(IStatus child : status.getChildren())
			printStatus(child, out, indent);
	}

	private final ILog m_log;

	public static final String BUILDER_LOG_RECEIVER_POINT = BuildBundle.PLUGIN_ID + ".logReceivers"; //$NON-NLS-1$

	public Logger(Bundle bundle)
	{
		if(bundle == null)
			throw new IllegalArgumentException("The bundle for a logger cannot be null"); //$NON-NLS-1$
		m_log = Platform.getLog(bundle);
	}

	public Logger(ILog log)
	{
		m_log = log;
	}

	public Logger(String bundleId)
	{
		this(Platform.getBundle(bundleId));
	}

	public void debug(String msg, Object... args)
	{
		log(DEBUG, msg, args);
	}

	public void debug(Throwable t, String msg, Object... args)
	{
		log(DEBUG, t, msg, args);
	}

	public void error(String msg, Object... args)
	{
		log(ERROR, msg, args);
	}

	public void error(Throwable t, String msg, Object... args)
	{
		log(ERROR, t, msg, args);
	}

	public void info(String msg, Object... args)
	{
		log(INFO, msg, args);
	}

	public void info(Throwable t, String msg, Object... args)
	{
		log(INFO, t, msg, args);
	}

	public boolean isDebugEnabled()
	{
		return s_consoleThreshold <= DEBUG || s_eclipseLoggerThreshold <= DEBUG;
	}

	public boolean isErrorEnabled()
	{
		return s_consoleThreshold <= ERROR || s_eclipseLoggerThreshold <= ERROR;
	}

	public boolean isInfoEnabled()
	{
		return s_consoleThreshold <= INFO || s_eclipseLoggerThreshold <= INFO;
	}

	public boolean isWarningEnabled()
	{
		return s_consoleThreshold <= WARNING || s_eclipseLoggerThreshold <= WARNING;
	}

	public void log(int level, String msg, Object... args)
	{
		log(level, null, msg, args);
	}

	public void log(int level, Throwable t, String msg, Object... args)
	{
		if(level >= s_consoleThreshold && (s_eclipseLogListener == null || level < s_eclipseLoggerThreshold))
		{
			PrintStream logStream = (level == WARNING || level == ERROR)
					? s_errStream
					: s_outStream;
			synchronized(logStream)
			{
				if(args == null || args.length == 0)
					logStream.print(msg);
				else
					logStream.format(msg, args);

				logStream.println();
				if(t != null && s_consoleThreshold == DEBUG)
					t.printStackTrace(logStream);
				logStream.flush();
			}
		}
		if(level >= s_eclipseLoggerThreshold)
			m_log.log(new Status(level, m_log.getBundle().getSymbolicName(), MAGIC, (args == null || args.length == 0)
					? msg
					: String.format(msg, args), t));
	}

	public void warning(String msg, Object... args)
	{
		log(WARNING, msg, args);
	}

	public void warning(Throwable t, String msg, Object... args)
	{
		log(WARNING, t, msg, args);
	}
}
