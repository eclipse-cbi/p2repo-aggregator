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
import java.lang.reflect.InvocationTargetException;
import java.net.CookieManager;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Iterator;
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
import org.eclipse.equinox.security.storage.ISecurePreferences;
import org.eclipse.equinox.security.storage.SecurePreferencesFactory;
import org.eclipse.equinox.security.storage.StorageException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.lib.TextProgressMonitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.ISources;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;
import org.json.JSONArray;
import org.json.JSONObject;

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

	protected static final Pattern GITHUB_TIME_PATTERN = Pattern.compile("\"committedDate\":\"([^\"]+)\"");

	protected static Path CACHE = Path
			.of(AggregationAnalyzerEditorPlugin.getPlugin().getStateLocation().append("cache").toOSString());

	private static final HttpClient HTTP_CLIENT;

	private static final String PAT;

	static {
		String githubPATPreference = System.getProperty(
				"org.eclipse.cbi.p2repo.aggregator.analyzer.presentation.handlers.BaseHandler.github.pat.preference");
		String pat = null;
		if (githubPATPreference != null) {
			int slash = githubPATPreference.lastIndexOf('/');
			ISecurePreferences node = SecurePreferencesFactory.getDefault()
					.node(githubPATPreference.substring(0, slash));
			try {
				pat = node.get(githubPATPreference.substring(slash + 1), null);
			} catch (StorageException ex) {
				AggregationAnalyzerEditorPlugin.INSTANCE.log(ex);
			}
		}

		PAT = pat;
		HTTP_CLIENT = HttpClient.newBuilder().followRedirects(HttpClient.Redirect.NORMAL)
				.cookieHandler(new CookieManager()).build();
	}

	protected static JSONObject get(JSONObject jsonObject, String key) {
		return jsonObject.has(key) ? jsonObject.getJSONObject(key) : null;
	}

	protected static Iterable<JSONObject> toJSONObjects(JSONArray jsonArray) {
		return toIterable(jsonArray, JSONObject.class);
	}

	protected static <T> Iterable<T> toIterable(JSONArray jsonArray, Class<T> clazz) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				var it = jsonArray.iterator();
				return new Iterator<T>() {
					@Override
					public boolean hasNext() {
						return it.hasNext();
					}

					@Override
					public T next() {
						return clazz.cast(it.next());
					}
				};
			}
		};
	}

	protected static String basicGetContent(URI uri) throws IOException {
		return basicGetContent(java.net.URI.create(URIConverter.INSTANCE.normalize(uri).toString()));
	}

	protected static String basicGetContent(java.net.URI uri) throws IOException {
		var requestBuilder = HttpRequest.newBuilder(uri).GET();

		if (PAT != null && "api.github.com".equals(uri.getHost())) {
			requestBuilder.header("Authorization", "Bearer " + PAT);
			requestBuilder.header("X-GitHub-Api-Version", "2022-11-28");
		}

		try {
			var request = requestBuilder.build();
			var response = HTTP_CLIENT.send(request, BodyHandlers.ofString());
			var statusCode = response.statusCode();
			if (statusCode != 200) {
				throw new IOException("status code " + statusCode + " -> " + uri);
			}

			return response.body();
		} catch (IOException | InterruptedException ex) {
			throw new IOException(ex.getMessage() + " -> " + uri, ex);
		}
	}

	protected static Path getCachePath(URI uri) {
		String decodedURI = URI.decode(uri.toString());
		String[] uriSegments = decodedURI.split("[:/?#&;]+");
		Path result = CACHE.resolve(String.join("/", uriSegments));
		if (uri.hasTrailingPathSeparator()) {
			return result.resolve("folder-contents");
		}
		return result;
	}

	protected static Path getClone(String repo) {
		try {
			Path cloneFolder = getCachePath(URI.createURI(repo));
			if (!Files.isDirectory(cloneFolder)) {
				System.out.println("Cloning: " + repo);
				long start = System.currentTimeMillis();
				var cloneRepository = Git.cloneRepository();
				cloneRepository.setCloneSubmodules(false);
				cloneRepository.setURI(repo);
				cloneRepository.setDepth(1);
				cloneRepository.setDirectory(cloneFolder.toFile());
				cloneRepository.setProgressMonitor(new TextProgressMonitor() {
					@Override
					protected void onUpdate(String taskName, int cmp, int totalWork, int pcnt, Duration duration) {
						if (pcnt % 25 == 0)
							super.onUpdate(taskName, cmp, totalWork, pcnt, duration);
					}

					@Override
					protected void onEndTask(String taskName, int cmp, int totalWork, int pcnt, Duration duration) {
						// super.onEndTask(taskName, cmp, totalWork, pcnt, duration);
					}
				});

				var clone = cloneRepository.call();
				long finish = System.currentTimeMillis();
				System.out.println("Cloned: " + repo + " elapsed=" + (finish - start) / 1000);
				clone.close();
			}
			return cloneFolder;
		} catch (GitAPIException e) {
			throw new RuntimeException(e);
		}
	}

	protected static String getContent(String uri) throws IOException {
		return getContent(URI.createURI(uri));
	}

	protected static JSONArray getPaginatedContent(URI uri) throws IOException {
		var result = new JSONArray();
		var query = uri.query();
		for (var i = 1; i < 100; ++i) {
			var page = "page=" + i;
			var pageURI = uri.appendQuery(query == null ? page : query + "&" + page);
			var content = getContent(pageURI);
			if (content.startsWith("{")) { // }
				var pageObject = new JSONObject(content);
				var names = pageObject.keySet();
				if (names.size() != 1) {
					throw new IOException();
				}
				var pageContent = pageObject.getJSONArray(names.iterator().next());
				result.putAll(pageContent);
				if (pageContent.length() == 0) {
					break;
				}
			} else {
				var pageContent = new JSONArray(content);
				result.putAll(pageContent);
				if (pageContent.length() == 0) {
					break;
				}
			}
		}
		return result;
	}

	protected static String getContent(URI uri) throws IOException {
		Path path = getCachePath(uri);
		if (Files.isRegularFile(path)) {
			return Files.readString(path);
		}

		String content = basicGetContent(uri);
		Files.createDirectories(path.getParent());
		Files.writeString(path, content);
		return content;
	}

	protected static String getContentOrEmpty(URI uri) {
		Path path = getCachePath(uri);
		if (Files.isRegularFile(path)) {
			try {
				return Files.readString(path);
			} catch (IOException ex) {
				AggregationAnalyzerEditorPlugin.INSTANCE.log(ex);
				return "";
			}
		}

		try {
			Files.createDirectories(path.getParent());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try {
			String content = basicGetContent(uri);
			Files.writeString(path, content);
			return content;
		} catch (IOException e) {
			try {
				Files.writeString(path, "");
			} catch (IOException e1) {
				//$FALL-THROUGH$
			}
			return "";
		}
	}

	protected static Long getLastModified(URI logURI, Pattern datePattern, String dateFormat) throws Exception {
		String content = getContent(logURI);
		Matcher timeMatcher = datePattern.matcher(content);
		if (timeMatcher.find()) {
			try {
				String dateLiteral = timeMatcher.group(1);
				Date date = new SimpleDateFormat(dateFormat).parse(dateLiteral);
				long time = date.getTime();
				return time;
			} catch (Exception ex) {
				AggregationAnalyzerEditorPlugin.INSTANCE.log(ex);
			}
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

			public long getCacheAge() {
				if (Files.exists(CACHE))
					try {
						Files.walkFileTree(CACHE, this);
					} catch (IOException ex) {
						AggregationAnalyzerEditorPlugin.INSTANCE.log(ex);
					}

				return lastModifiedTime == null ? System.currentTimeMillis() : lastModifiedTime.toMillis();
			}
		}.getCacheAge();
	}
}
