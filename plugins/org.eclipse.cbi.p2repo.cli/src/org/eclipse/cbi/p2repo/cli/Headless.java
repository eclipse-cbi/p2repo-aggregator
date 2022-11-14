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

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.eclipse.cbi.p2repo.cli.helpers.CliException;
import org.eclipse.cbi.p2repo.cli.helpers.EmptyCommand;
import org.eclipse.cbi.p2repo.util.ExceptionUtils;
import org.eclipse.cbi.p2repo.util.IOUtils;
import org.eclipse.cbi.p2repo.util.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class Headless implements IApplication {

	private static final int CONSOLE_WIDTH = 80;

	private static final String APPLICATION_NAME = "cbiAggr";

	private static final String COMMAND_EXTENSION = "org.eclipse.cbi.p2repo.cli.commands";

	private static final String COMMAND_NAME_ATTR = "name";

	private static final String COMMAND_CLASS_ATTR = "class";

	private static AbstractCommand createCommand(IConfigurationElement commandConfiguration) throws CoreException {
		AbstractCommand command = (AbstractCommand) commandConfiguration.createExecutableExtension(COMMAND_CLASS_ATTR);
		command.setName(commandConfiguration.getAttribute(COMMAND_NAME_ATTR));
		return command;
	}

	private static List<AbstractCommand> getAvailableCommands() throws CoreException {
		IConfigurationElement[] commandConfigurations = getCommandConfigurations();
		List<AbstractCommand> commands = new ArrayList<AbstractCommand>(commandConfigurations.length);

		for (IConfigurationElement commandConfiguration : commandConfigurations) {
			commands.add(createCommand(commandConfiguration));
		}

		Collections.sort(commands);
		return commands;
	}

	private static AbstractCommand getCommand(String string) throws CoreException {
		for (IConfigurationElement commandConfiguration : getCommandConfigurations()) {
			if (commandConfiguration.getAttribute(COMMAND_NAME_ATTR).equals(string))
				return createCommand(commandConfiguration);
		}

		return null;
	}

	private static IConfigurationElement[] getCommandConfigurations() {
		return Platform.getExtensionRegistry().getConfigurationElementsFor(COMMAND_EXTENSION);
	}

	public static int run(String args[], boolean verbose) throws Exception {
		try {
			if (args.length == 0 || !args[0].matches("^(?i:[a-z_][-a-z_]+)$"))
				throw new CliException("No command was specified");

			AbstractCommand command = getCommand(args[0]);
			if (command == null)
				throw new CliException("No such command: " + args[0]);

			CmdLineParser commandParser = new CmdLineParser(command);
			String problem = null;

			// remove the command name, pass remaining arguments to the command
			String[] commandArgs = new String[args.length - 1];
			System.arraycopy(args, 1, commandArgs, 0, commandArgs.length);
			try {
				commandParser.parseArgument(commandArgs);
			} catch (CmdLineException e) {
				problem = e.getMessage();
			}

			PrintStream output = null;

			if (command.isHelp())
				output = System.out;
			else if (problem != null)
				output = System.err;

			if (output != null) {
				if (problem != null && !command.isHelp()) {
					output.println(command.getName() + ": " + problem);
					if (commandArgs.length > 0) {
						for (String arg : commandArgs) {
							output.print("  '");
							output.print(arg);
							output.println("'");
						}
					}
					output.println();
				}
				output.println("Usage: " + APPLICATION_NAME + " " + command.getUsageTitle());
				commandParser.getProperties().withUsageWidth(CONSOLE_WIDTH);
				commandParser.printUsage(output);

				if (command.isHelp()) {
					InputStream helpStream = command.getHelpStream();
					if (helpStream != null) {
						try {
							output.println();
							output.println("More information:");

							BufferedReader lineReader = new BufferedReader(new InputStreamReader(helpStream));
							String helpLine;
							while ((helpLine = lineReader.readLine()) != null) {
								BreakIterator breaker = BreakIterator.getLineInstance(Locale.US);
								breaker.setText(helpLine);
								int start = breaker.first();
								int endOk = 0;
								int end = 0;
								while (end != BreakIterator.DONE) {
									end = breaker.next();
									if (end == BreakIterator.DONE
											|| (end - start - (Character.isWhitespace(helpLine.charAt(end - 1)) ? 1
													: 0)) > CONSOLE_WIDTH) {
										output.print(StringUtils.trimRight(helpLine.substring(start, endOk)));
										output.println();
										start = endOk;
										endOk = end;
									}
									endOk = end;
								}
							}
						} finally {
							IOUtils.close(helpStream);
						}
					}
				}

				return problem == null || command.isHelp() ? AbstractCommand.EXIT_OK : AbstractCommand.EXIT_ERROR;
			}

			try {
				return Integer.valueOf(command.run());
			} catch (Exception e) {
				ExceptionUtils.deeplyPrint(e, System.err, command.isDisplayStacktrace());
			}
		} catch (CliException e) {
			System.err.println(e.getMessage());
			if (verbose) {
				System.err.println();
				System.err.println("Usage: " + APPLICATION_NAME + " command [options...]");
				CmdLineParser globalParser = new CmdLineParser(new EmptyCommand());
				globalParser.printUsage(System.err);

				System.err.println();
				System.err.println("Available commands:");

				List<AbstractCommand> availableCommands = getAvailableCommands();
				if (availableCommands.size() > 0)
					for (AbstractCommand command : availableCommands) {
						System.err.printf("%s - %s\n", command.getName(), command.getShortDescription());

					}
				else
					System.err.println("None");
			}
		}

		return AbstractCommand.EXIT_ERROR;
	}

	@Override
	public Object start(IApplicationContext context) throws Exception {
		HeadlessActivator.getInstance().setHeadless();

		String args[] = (String[]) context.getArguments().get(IApplicationContext.APPLICATION_ARGS);

		return Integer.valueOf(run(args, true));
	}

	@Override
	public void stop() {
		// do nothing
	}
}
