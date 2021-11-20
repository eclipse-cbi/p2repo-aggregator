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

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class IOUtils {

	/**
	 * @param is
	 */
	public static void close(Closeable is) {
		if(is != null)
			try {
				is.close();
			}
			catch(IOException e) {
				// ignore
			}
	}

	public static void copyStream(InputStream is, OutputStream os) throws IOException {
		copyStream(is, os, true, true);
	}

	public static void copyStream(InputStream is, OutputStream os, boolean closeInput, boolean closeOutput)
			throws IOException {
		byte[] buffer = new byte[1024];
		int len;

		try {
			while((len = is.read(buffer)) != -1) {
				os.write(buffer, 0, len);
			}
		}
		finally {
			try {
				if(closeInput)
					is.close();
			}
			catch(IOException e) {
				// ignore
			}

			if(closeOutput)
				os.close();
		}
	}

	/**
	 * @param is
	 *            source
	 * @return string initialized by input stream content
	 * @throws IOException
	 */
	public static String readString(InputStream is) throws IOException {
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		copyStream(is, os);
		return new String(os.toByteArray());
	}
}
