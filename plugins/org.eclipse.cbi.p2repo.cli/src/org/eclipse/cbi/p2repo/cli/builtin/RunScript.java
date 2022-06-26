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

package org.eclipse.cbi.p2repo.cli.builtin;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.cbi.p2repo.cli.AbstractCommand;
import org.eclipse.cbi.p2repo.cli.Headless;
import org.eclipse.cbi.p2repo.cli.helpers.ScriptLineParser;
import org.eclipse.cbi.p2repo.util.StringUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class RunScript extends AbstractCommand {
	private final static String SCRIPT_FILE_META_VAR = "<script file>";

	@Option(name = "-c", aliases = "--continueonerror", usage = "If this flag is set, script execution will continue after a command fails.")
	private boolean continueOnError;

	@Argument(required = true, multiValued = false, metaVar = SCRIPT_FILE_META_VAR)
	private List<String> args = new ArrayList<String>();

	@Override
	public InputStream getHelpStream() {
		return new ByteArrayInputStream(
			("Commands defined in the script file are launched sequentially. Following rules apply:\n"
					+ "- command is defined on a single line\n" //
					+ "- parameters may be enclosed in quotes or double quotes\n" //
					+ "- parameters may contain variables ${var}, $var or $env:var, ${env.var}\n" //
					+ "- variables are expanded only if parameters are double quoted\n" //
					+ "- parameters may contain escaped characters\n" //
					+ "- \\t, \\r and \\n are replaced with tab, return or new line\n" //
					+ "- empty lines and lines beginning with '#' are comments\n").getBytes());
	}

	@Override
	public String getShortDescription() {
		return "Runs a set of commands from a script file";
	}

	@Override
	public String getUsageTitle() {
		return super.getUsageTitle() + " " + SCRIPT_FILE_META_VAR;
	}

	@Override
	protected int run(IProgressMonitor monitor) throws Exception {
		if(args.size() > 1)
			throw new Exception("Only one script file may be specified");

		InputStream is = null;
		String urlOrFile = args.get(0);
		try {
			URL scriptURL = new URL(urlOrFile);
			is = scriptURL.openStream();
		}
		catch(MalformedURLException e) {
			try {
				is = new FileInputStream(urlOrFile);
			}
			catch(IOException ioe) {
				// ignore
			}
		}

		if(is == null)
			throw new Exception(urlOrFile + " is neither a valid accessible URL nor an existing accessible file");

		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		List<String[]> parsedLines = new ArrayList<String[]>();

		try {
			String commandLine;
			while((commandLine = reader.readLine()) != null) {
				commandLine = StringUtils.trimmedOrNull(commandLine);
				if(commandLine == null || commandLine.charAt(0) == '#')
					continue;
				ScriptLineParser parser = new ScriptLineParser(commandLine);
				List<String> commandArgs = new ArrayList<String>();
				while(parser.hasNext())
					commandArgs.add(parser.next());

				parsedLines.add(commandArgs.toArray(new String[commandArgs.size()]));
			}
		}
		finally {
			reader.close();
		}

		int result = AbstractCommand.EXIT_OK;

		try {
			monitor.beginTask("Executing script file...", parsedLines.size());
			for(String[] commandArgs : parsedLines) {
				monitor.subTask("Command '" + commandArgs[0] + "'");
				try {
					if(Headless.run(commandArgs, false) != AbstractCommand.EXIT_OK) {
						result = AbstractCommand.EXIT_ERROR;
						if(!continueOnError)
							break;
					}
				}
				finally {
					monitor.worked(1);
				}
			}
		}
		finally {
			monitor.done();
		}

		return result;
	}

}
