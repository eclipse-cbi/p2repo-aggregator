/**
 * Copyright (c) 2022 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.analyzer.presentation.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.aggregator.analyzer.Analysis;
import org.eclipse.cbi.p2repo.aggregator.analyzer.presentation.AggregationAnalyzerEditorPlugin;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.expressions.IEvaluationContext;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public abstract class BaseHandler extends AbstractHandler {

	/**
	 * https://github.com/merks/org.eclipse.simrel.build.git
	 * git@github.com:merks/org.eclipse.simrel.build.git
	 */
	protected static final Pattern ECLIPSE_GIT_URL_PATTERN = Pattern
			.compile("(?:https?://git.eclipse.org/r/|ssh://[^@]+@git.eclipse.org:29418/)(.*)");

	protected static final Pattern ECLIPSE_COMMIT_TIME_PATTERN = Pattern.compile("<span[^>]+?title='([^']*)'");

	/**
	 * https://git.eclipse.org/r/simrel/org.eclipse.simrel.build.git
	 * ssh://user_id@git.eclipse.org:29418/simrel/org.eclipse.simrel.build.git
	 */
	protected static final Pattern GITHUB_URL_PATTERN = Pattern.compile("(?:https?://github.com/|git@github.com:)(.*)");

	protected static final Pattern GITHUB_TIME_PATTERN = Pattern.compile("<relative-time[ \t]+datetime=\"([^\"]+)\"");

	protected static Path CACHE = Path
			.of(AggregationAnalyzerEditorPlugin.getPlugin().getStateLocation().append("cache").toOSString());

	protected static Path getCachePath(URI uri) throws IOException {
		String decodedURI = URI.decode(uri.toString());
		String[] uriSegments = decodedURI.split("[:/?#&;]+");
		Path result = CACHE.resolve(String.join("/", uriSegments));
		return result;
	}

	protected static String getContent(URI uri) throws IOException {
		Path path = getCachePath(uri);
		if (Files.isRegularFile(path)) {
			return Files.readString(path);
		}

		try (InputStream in = URIConverter.INSTANCE.createInputStream(uri)) {
			String content = new String(in.readAllBytes(), StandardCharsets.UTF_8);
			Files.createDirectories(path.getParent());
			Files.writeString(path, content);
			return content;
		}
	}

	protected static Long getLastModified(URI logURI, Pattern datePattern, String dateFormat) throws Exception {
		String content = getContent(logURI);
		Matcher timeMatcher = datePattern.matcher(content);
		if (timeMatcher.find()) {
			Date date = new SimpleDateFormat(dateFormat).parse(timeMatcher.group(1));
			long time = date.getTime();
			return time;
		}
		return null;
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		ISelection selection = HandlerUtil.getCurrentSelection(event);
		Activity activity = createActivity(selection);
		if (activity != null && activity.isEnabled()) {
			IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
			Shell shell = window.getShell();
			activity.perform(shell);
		}

		return null;
	}

	@Override
	public void setEnabled(Object evaluationContext) {
		IEvaluationContext evaluationContext2 = (IEvaluationContext) evaluationContext;
		Object selection = evaluationContext2.getVariable(ISources.ACTIVE_CURRENT_SELECTION_NAME);
		Activity activity = createActivity(selection);
		setBaseEnabled(activity.isEnabled());
	}

	protected Activity createActivity(Object selection) {
		if (selection instanceof IStructuredSelection) {
			Object firstElement = ((IStructuredSelection) selection).getFirstElement();
			if (firstElement instanceof Analysis) {
				return createActivity((Analysis) firstElement);
			}
		}

		return null;
	}

	protected Activity createActivity(Analysis analysis) {
		return null;
	}

	protected abstract static class Activity {

		public boolean isEnabled() {
			return true;
		}

		public void perform(Shell shell) {
			try {
				AggregationAnalyzerEditorPlugin.runInProgressDialog(shell, monitor -> {
					try {
						perform(monitor);
						shell.getDisplay().asyncExec(() -> {
							asyncExec();
						});
					} catch (Exception e) {
						throw new InvocationTargetException(e);
					}
				});
			} catch (InvocationTargetException | InterruptedException e) {
				handleFailure("Failure", e);
			}
		}

		protected void handleFailure(String message, Throwable e) {
			AggregationAnalyzerEditorPlugin.INSTANCE.showError(message, e);
			AggregationAnalyzerEditorPlugin.INSTANCE.log(e);
		}

		protected abstract void perform(IProgressMonitor monitor) throws Exception;

		protected void asyncExec() {
		}
	}

	public static void checkStaleCache(Shell shel) {
		long lastModified = getCacheOldestLastModifiedTime();
		long now = System.currentTimeMillis();
		long age = now - lastModified;
		long ageInHours = age / 1000 / 60 / 60;
		if (ageInHours > 24) {
			MessageDialog prompt = new MessageDialog(shel, "Stale Cache", null,
					"Some of the cached internet pages are more than 24 hours old.  Would you like to refresh them?",
					MessageDialog.NONE, new String[] { "&Refresh Cache", "Re&use Cache" }, 0);
			prompt.setBlockOnOpen(true);
			int open = prompt.open();
			if (open == 0) {
				try {
					new ClearCacheHandler().execute(null);
				} catch (ExecutionException e) {
					AggregationAnalyzerEditorPlugin.INSTANCE.log(e);
				}
			}
		}
	}

	public static long getCacheOldestLastModifiedTime() {
		return new SimpleFileVisitor<Path>() {
			FileTime lastModifiedTime;

			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
				FileTime lastModifiedTime = Files.getLastModifiedTime(file);
				if (this.lastModifiedTime == null || this.lastModifiedTime.compareTo(lastModifiedTime) >= 0) {
					this.lastModifiedTime = lastModifiedTime;
				}
				return FileVisitResult.CONTINUE;
			}

			@Override
			public FileVisitResult postVisitDirectory(Path directory, IOException exception) throws IOException {
				if (exception == null) {
					Files.delete(directory);
				}
				return super.postVisitDirectory(directory, exception);
			}

			public long getCacheAge() {
				try {
					Files.walkFileTree(CACHE, this);
				} catch (IOException e) {
				}

				return lastModifiedTime == null ? System.currentTimeMillis() : lastModifiedTime.toMillis();
			}
		}.getCacheAge();
	}
}
