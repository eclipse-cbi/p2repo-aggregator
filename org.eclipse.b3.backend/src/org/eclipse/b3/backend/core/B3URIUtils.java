/**
 * Copyright (c) 2006-2010, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */

package org.eclipse.b3.backend.core;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.eclipse.b3.provisional.core.BuildException;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

public abstract class B3URIUtils {
	public static URI appendPath(URI uri, IPath path) {
		String uriPath;

		try {
			path = path.setDevice(null);
			if(path.isAbsolute())
				uriPath = path.toPortableString();
			else {
				uriPath = uri.getPath();
				if(uriPath == null || uriPath.length() == 0)
					uriPath = path.makeAbsolute().toPortableString();
				else {
					StringBuilder bld = new StringBuilder();
					bld.append(uriPath);
					if(!uriPath.endsWith("/")) //$NON-NLS-1$
						bld.append('/');
					bld.append(path.toPortableString());
					uriPath = bld.toString();
				}
			}
			return new URI(uri.getScheme(), uri.getAuthority(), uriPath, uri.getQuery(), uri.getFragment());
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}

	}

	public static URI appendPath(URI uri, URI path) {
		try {
			return uri.resolve(path);
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Append <code>path</code> to <code>url</code> while preserving all other
	 * characteristics of the <code>url</code>. If <code>path</code> is
	 * absolute, it will become the new path of the <code>url</code> else, if <code>url</code> doesn't end with a
	 * trailing slash, it is appended prior
	 * to appending the <code>path</code>.
	 * 
	 * @param url
	 *            The url to use as root.
	 * @param path
	 *            The path to append
	 * 
	 * @return The url with the new path.
	 */
	public static URL appendPath(URL url, IPath path) {
		if(path == null || path.segmentCount() == 0)
			return url;

		try {
			URI u = url.toURI();
			return appendPath(u, path).toURL();
		}
		catch(RuntimeException e) {
			throw e;
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	// private static void appendQueryItem(StringBuilder query, String item) {
	// int top = item.length();
	// for(int idx = 0; idx < top; ++idx) {
	// char c = item.charAt(idx);
	// if(c == '&')
	// query.append(c);
	// query.append(c);
	// }
	// }

	// /**
	// * Appends a trailing slash to <code>url</code> and returns the result. If
	// * the <code>url</code> already has a trailing slash, the argument is
	// * returned without modification.
	// *
	// * @param url
	// * The <code>url</code> that should receive the trailing slash.
	// * Cannot be <code>null</code>.
	// * @return A <code>url</code> that has a trailing slash
	// */
	// public static URL appendTrailingSlash(URL url) {
	//		if(!url.getPath().endsWith("/")) //$NON-NLS-1$
	// {
	// try {
	// URI u = url.toURI();
	// url = new URI(u.getScheme(), u.getAuthority(), u.getPath() + '/', u.getQuery(), u.getFragment()).toURL();
	// }
	// catch(RuntimeException e) {
	// throw e;
	// }
	// catch(Exception e) {
	// // Not very likely since original was a URL.
	// //
	// throw new RuntimeException(e);
	// }
	// }
	// return url;
	// }

	// public static String[] decodeToQueryPairs(String query) {
	// if(query == null || query.length() == 0)
	// return Trivial.EMPTY_STRING_ARRAY;
	//
	// // split on a solitary '&'
	// //
	//		String[] pairs = query.split("(?<!&)&(?!&)"); //$NON-NLS-1$
	// int idx = pairs.length;
	// if(idx == 0)
	// return Trivial.EMPTY_STRING_ARRAY;
	//
	// while(--idx >= 0)
	//			pairs[idx] = pairs[idx].replace("&&", "&"); //$NON-NLS-1$ //$NON-NLS-2$
	// return pairs;
	// }

	// public static String encodeFromQueryPairs(List<String> pairs) {
	// if(pairs == null || pairs.size() == 0)
	// return null;
	//
	// StringBuilder query = new StringBuilder();
	// for(String pair : pairs) {
	// // if k/v pairs have already been added, add a single delimiter
	// //
	// if(query.length() > 0)
	// query.append('&');
	//
	// appendQueryItem(query, pair);
	// }
	//
	// return query.toString();
	// }

	// public static String encodeFromQueryPairs(Map<String, String> map) {
	// if(map == null || map.size() == 0)
	// return null;
	//
	// StringBuilder query = new StringBuilder();
	// for(Map.Entry<String, String> entry : map.entrySet()) {
	// // if k/v pairs have already been added, add a single delimiter
	// //
	// if(query.length() > 0)
	// query.append('&');
	//
	// appendQueryItem(query, entry.getKey());
	// query.append('=');
	// appendQueryItem(query, entry.getValue());
	// }
	// return query.toString();
	// }

	public static URI getParentURI(URI uri) {
		if(uri == null)
			return uri;

		IPath uriPath = Path.fromPortableString(uri.getPath());
		if(uriPath.segmentCount() == 0)
			return null;

		uriPath = uriPath.removeLastSegments(1).addTrailingSeparator();
		try {
			return new URI(
				uri.getScheme(), uri.getUserInfo(), uri.getHost(), uri.getPort(), uriPath.toPortableString(),
				uri.getQuery(), uri.getFragment());
		}
		catch(URISyntaxException e) {
			// Shouldn't happen since we started with a valid URI
			//
			return null;
		}
	}

	public static URL getParentURL(URL url) {
		if(url == null)
			return null;

		try {
			return getParentURI(url.toURI()).toURL();
		}
		catch(MalformedURLException e) {
			return null;
		}
		catch(URISyntaxException e) {
			return null;
		}
	}

	public static boolean isLocalURL(URL url) {
		String proto = url.getProtocol();
		if(proto.equals("jar") || proto.equals("reference")) //$NON-NLS-1$ //$NON-NLS-2$
		{
			String spec = url.getFile();
			int sepIdx = spec.indexOf(':');
			if(sepIdx == -1)
				return false;
			proto = spec.substring(0, sepIdx);
		}
		return "file".equals(proto) || "platform".equals(proto) || proto.startsWith("bundle"); //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
	}

	public static URI normalizeToURI(String pathOrURI, boolean asFolder) throws CoreException {
		if(pathOrURI == null || pathOrURI.length() == 0)
			return null;

		// If we have a protocol part that consists of one single letter, then
		// we assume
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
				throw BuildException.wrap(e);

			try {
				uri = new URI(pathOrURI.replaceAll("\\s", "%20")); //$NON-NLS-1$ //$NON-NLS-2$
			}
			catch(URISyntaxException e2) {
				throw BuildException.wrap(e2);
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
			throw BuildException.wrap(e);
		}
	}

	public static URL normalizeToURL(String surl) throws MalformedURLException {
		if(surl == null)
			return null;

		try {
			return new URL(surl);
		}
		catch(MalformedURLException e) {
			// Do a space check.
			//
			if(surl.indexOf(' ') > 0) {
				try {
					return new URL(surl.replaceAll("\\s", "%20")); //$NON-NLS-1$ //$NON-NLS-2$
				}
				catch(MalformedURLException me1) {
				}
			}

			try {
				return new File(surl).toURI().toURL();
			}
			catch(MalformedURLException me2) {
				// Throw the original exception
				//
				throw e;
			}
		}
	}

	// public static Map<String, String> queryAsParameters(String query) {
	// if(query == null)
	// return Collections.emptyMap();
	//
	// String[] pairs = decodeToQueryPairs(query);
	// int top = pairs.length;
	// if(top == 0)
	// return Collections.emptyMap();
	//
	// Map<String, String> p = new HashMap<String, String>(top);
	// while(--top >= 0) {
	// // now split the pair on the first '=' only
	// // (one '=' is required to be there, even if the value is blank)
	// //
	//			String[] kv = pairs[top].split("=", 2); //$NON-NLS-1$
	// p.put(kv[0], kv[1]);
	// }
	// return p;
	// }

	public static URL resolveURL(URL contextURL, String url) {
		if(url == null)
			return null;

		try {
			if(contextURL == null)
				return normalizeToURL(url);
			return new URL(contextURL, url);
		}
		catch(MalformedURLException e) {
			return null;
		}
	}
}
