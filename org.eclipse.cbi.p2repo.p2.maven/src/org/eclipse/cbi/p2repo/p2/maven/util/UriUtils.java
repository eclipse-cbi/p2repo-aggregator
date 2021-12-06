/**
 * Copyright (c) 2006-2007, Cloudsmith Inc.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.cbi.p2repo.p2.maven.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.cbi.p2repo.util.ExceptionUtils;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.cbi.p2repo.util.MonitorUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.equinox.internal.p2.repository.Transport;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * @author Filip Hrbek
 *
 */
public class UriUtils {
	private static final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();

	static {
		documentBuilderFactory.setIgnoringComments(true);
		documentBuilderFactory.setValidating(false);
		documentBuilderFactory.setNamespaceAware(false);
	}

	/**
	 * Pattern string that matches links that are relative, don't start with '?' or '#' and don't contain a slash (i.e.
	 * folders leading too deep)
	 */
	private static final String linkPatternString = "([^?#][^\"]+/?)";

	/**
	 * Pattern that scans for hrefs and don't start with '?' or '#'
	 */
	private static final Pattern htmlPattern = Pattern.compile("<A\\s+HREF=\"([^?#][^\"]+)\"\\s*>[^<]+</A>", //$NON-NLS-1$
		Pattern.CASE_INSENSITIVE);

	/**
	 * Pattern that scans for links that are relative, don't start with '?' and don't contain a slash (i.e. folders
	 * leading too deep)
	 */
	private static final Pattern linkPattern = Pattern.compile(linkPatternString, Pattern.CASE_INSENSITIVE);

	/**
	 * Scan a listing obtained using FTP. The file name comes after a timestamp that ends with <hh:mm> or <year> and
	 * might contain a link, i.e. xxx -> yyy.
	 */
	private static final Pattern ftpPattern = Pattern.compile(
		"[a-z]+\\s+[0-9]+\\s+(?:(?:[0-9]+:[0-9]+)|(?:[0-9]{4}))\\s+(.+?)(?:([\\r|\\n])|(\\s+->\\s+))", //$NON-NLS-1$
		Pattern.CASE_INSENSITIVE);

	/**
	 * Check if pattern matches an index.html or other index.xxx. We transform such URL's to denote folders instead.
	 */
	private static final Pattern indexPath = Pattern.compile("^(.*/)?index\\.[a-z][a-z0-9]+$"); //$NON-NLS-1$

	public static final URI[] EMPTY_URI_ARRAY = new URI[0];

	/**
	 * Appends a trailing slash to <code>uri</code> and returns the result. If the <code>uri</code> already has a
	 * trailing slash, the argument is returned without modification.
	 *
	 * @param uri
	 *            The <code>uri</code> that should receive the trailing slash. Cannot be <code>null</code>.
	 * @return A <code>uri</code> that has a trailing slash
	 */
	public static URI appendTrailingSlash(URI uri) {
		if(!uri.getPath().endsWith("/")) //$NON-NLS-1$
		{
			try {
				uri = new URI(
					uri.getScheme(), uri.getAuthority(), uri.getPath() + '/', uri.getQuery(), uri.getFragment());
			}
			catch(RuntimeException e) {
				throw e;
			}
			catch(Exception e) {
				// Not very likely since original was a URL.
				//
				throw new RuntimeException(e);
			}
		}
		return uri;
	}

	public static URI[] extractHTMLLinks(Transport transport, URI uriToHTML, IProgressMonitor monitor)
			throws CoreException {
		ArrayList<URI> links = new ArrayList<URI>();
		try {
			AccessibleByteArrayOutputStream buffer = new AccessibleByteArrayOutputStream(0x2000, 0x200000);
			transport.download(uriToHTML, buffer, monitor);
			try {
				final DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();

				// Use a very silent error handler
				//
				builder.setErrorHandler(new ErrorHandler() {
					@Override
					public void error(SAXParseException ex) throws SAXException {
						throw ex;
					}

					@Override
					public void fatalError(SAXParseException ex) throws SAXException {
						throw ex;
					}

					@Override
					public void warning(SAXParseException ex) throws SAXException {
					}
				});
				InputSource source = new InputSource(buffer.getInputStream());
				source.setSystemId(uriToHTML.toString());
				Document document = builder.parse(source);
				collectLinks(document.getDocumentElement(), uriToHTML, links);
			}
			catch(SAXException e) {
				// HTML was not well formed. Use a scanner instead
				//
				Scanner scanner = new Scanner(buffer.getInputStream());
				URI parent = appendTrailingSlash(uriToHTML);
				while(scanner.findWithinHorizon(htmlPattern, 0) != null) {
					MatchResult mr = scanner.match();
					addLink(links, parent, mr.group(1));
				}
				scanner.close();
			}
		}
		catch(IllegalStateException e) {
			LogUtils.warning(e, e.getMessage());
			return EMPTY_URI_ARRAY;
		}
		catch(FileNotFoundException e) {
			return EMPTY_URI_ARRAY;
		}
		catch(IOException e) {
			LogUtils.warning(e, e.getMessage());
			return EMPTY_URI_ARRAY;
		}
		catch(ParserConfigurationException e) {
			LogUtils.warning(e, e.getMessage());
			return EMPTY_URI_ARRAY;
		}
		catch(URISyntaxException e) {
			LogUtils.warning(e, e.getMessage());
			return EMPTY_URI_ARRAY;
		}
		return links.toArray(new URI[links.size()]);
	}

	public static File getFile(URI uri) throws MalformedURLException {
		if(uri == null)
			return null;

		String proto = uri.toURL().getProtocol();
		if(proto == null) {
			return new File(uri);
		}
		else if("file".equalsIgnoreCase(proto)) //$NON-NLS-1$
		{
			String path = uri.toString().replace("file:", "");
			return new File(path);
		}
		return null;
	}

	public static URI[] list(Transport transport, URI uri, IProgressMonitor monitor) throws CoreException {
		File dir = null;

		try {
			dir = getFile(uri);
		}
		catch(MalformedURLException e) {
			LogUtils.warning(e, e.getMessage());
			return EMPTY_URI_ARRAY;
		}

		if(dir != null) {
			File[] list = dir.listFiles();
			if(list == null)
				return EMPTY_URI_ARRAY;
			int top = list.length;
			if(top == 0)
				return EMPTY_URI_ARRAY;
			URI[] result = new URI[top];
			while(--top >= 0) {
				File file = list[top];
				URI fileUri = normalizeToURI(file.toString(), file.isDirectory());
				result[top] = fileUri;
			}
			MonitorUtils.complete(monitor);
			return result;
		}

		String proto = null;
		try {
			proto = uri.toURL().getProtocol();
		}
		catch(MalformedURLException e) {
			LogUtils.warning(e, e.getMessage());
			return EMPTY_URI_ARRAY;
		}

		if(proto.equalsIgnoreCase("ftp") || proto.equalsIgnoreCase("sftp")) //$NON-NLS-1$ //$NON-NLS-2$
		{
			final ArrayList<URI> result = new ArrayList<URI>();
			Scanner scanner = null;
			try {
				scanner = new Scanner(transport.stream(uri, monitor));
				uri = appendTrailingSlash(uri);
				while(scanner.findWithinHorizon(ftpPattern, 0) != null) {
					MatchResult mr = scanner.match();
					result.add(new URI(
						uri.getScheme(), uri.getAuthority(), uri.getPath() + '/' + mr.group(1), uri.getQuery(),
						uri.getFragment()));
				}
				return result.toArray(new URI[result.size()]);
			}
			catch(CoreException e) {
				LogUtils.warning(e, e.getMessage());
				return EMPTY_URI_ARRAY;
			}
			catch(FileNotFoundException e) {
				return EMPTY_URI_ARRAY;
			}
			catch(IOException e) {
				LogUtils.warning(e, e.getMessage());
				return EMPTY_URI_ARRAY;
			}
			catch(URISyntaxException e) {
				LogUtils.warning(e, e.getMessage());
				return EMPTY_URI_ARRAY;
			}
			finally {
				if(scanner != null)
					scanner.close();
			}
		}
		return extractHTMLLinks(transport, uri, monitor);
	}

	public static URI normalizeToURI(String pathOrURI, boolean asFolder) throws CoreException {
		if(pathOrURI == null || pathOrURI.length() == 0)
			return null;

		// If we have a protocol part that consists of one single letter, then we assume
		// that this is a windows path.
		//
		pathOrURI = pathOrURI.replace('\\', '/');
		if(pathOrURI.length() > 1 && pathOrURI.charAt(1) == ':') {
			char c = pathOrURI.charAt(0);
			if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
				pathOrURI = "file:/" + pathOrURI; //$NON-NLS-1$
		}

		URI uri;
		try {
			uri = new URI(pathOrURI);
		}
		catch(URISyntaxException e) {
			if(pathOrURI.indexOf(' ') < 0)
				throw ExceptionUtils.wrap(e);

			try {
				uri = new URI(pathOrURI.replaceAll("\\s", "%20")); //$NON-NLS-1$ //$NON-NLS-2$
			}
			catch(URISyntaxException e2) {
				throw ExceptionUtils.wrap(e2);
			}
		}

		boolean change = false;
		String path = uri.getPath();
		if(asFolder && !path.endsWith("/")) //$NON-NLS-1$
		{
			path += "/"; //$NON-NLS-1$
			change = true;
		}

		String scheme = uri.getScheme();
		if(scheme == null) {
			scheme = "file"; //$NON-NLS-1$
			change = true;
		}

		try {
			if(change)
				uri = new URI(scheme, uri.getAuthority(), path, uri.getQuery(), uri.getFragment());
			return uri;
		}
		catch(URISyntaxException e) {
			throw ExceptionUtils.wrap(e);
		}
	}

	private static void addLink(List<URI> links, URI parent, String link) throws URISyntaxException {
		if(link.equals("../")) //$NON-NLS-1$
			return;

		try {
			URI child = URI.create(link);
			String query = child.getQuery();
			String fragment = child.getFragment();
			if(!(query == null && fragment == null))
				// We just accept plain URL's
				return;

			// Check that scheme is unset or equal
			String scheme = parent.getScheme();
			String childScheme = child.getScheme();
			if(scheme == null) {
				if(childScheme != null)
					return;
			}
			else {
				if(!(childScheme == null || childScheme.equals(scheme)))
					return;
			}

			// Check that host is unset or equal
			String host = parent.getHost();
			String childHost = child.getHost();
			if(host == null) {
				if(childHost != null)
					return;
			}
			else {
				if(!(childHost == null || childHost.equals(host)))
					return;
			}

			// Check that port is unset or equal
			int port = parent.getPort();
			int childPort = child.getPort();
			if(port == -1) {
				if(childPort != -1)
					return;
			}
			else {
				if(!(childPort == -1 || childPort == port))
					return;
			}

			// Check that path is relative or use the same prefix
			// and doesn't point deeper than one folder
			String path = parent.getPath();
			String childPath = child.getPath();
			if(path == null || childPath == null)
				return;

			if(childPath.startsWith(path))
				childPath = childPath.substring(path.length());

			int slashIdx = childPath.indexOf('/');
			if(slashIdx >= 0 && slashIdx != childPath.length() - 1)
				return;

			if(childPath.length() == 0 || childPath.startsWith(".") || childPath.equals("/"))
				return;

			link = childPath;
		}
		catch(IllegalArgumentException e) {
			// We don't know what to do with this link
			return;
		}

		Matcher m = indexPath.matcher(link);
		if(m.matches()) {
			link = m.group(1);
			if(link == null)
				return;
		}

		links.add(new URI(
			parent.getScheme(), parent.getAuthority(), parent.getPath() + link, parent.getQuery(), parent.getFragment()));
	}

	private static void collectLinks(Element element, URI parent, ArrayList<URI> links) throws URISyntaxException {
		if(element.getNodeName().equals("a")) //$NON-NLS-1$
		{
			String link = element.getAttribute("href"); //$NON-NLS-1$
			if(linkPattern.matcher(link).matches())
				addLink(links, parent, link);
		}
		else {
			for(Node child = element.getFirstChild(); child != null; child = child.getNextSibling()) {
				if(child.getNodeType() == Node.ELEMENT_NODE)
					collectLinks((Element) child, parent, links);
			}
		}
	}

}
