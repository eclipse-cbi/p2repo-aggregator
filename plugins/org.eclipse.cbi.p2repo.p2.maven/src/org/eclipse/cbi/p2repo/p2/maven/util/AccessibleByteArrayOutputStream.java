/**
 * Copyright (c) 2004, 2005
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.p2.maven.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Thomas Hallgren
 */
public class AccessibleByteArrayOutputStream extends ByteArrayOutputStream {
	private final int maxSize;

	public AccessibleByteArrayOutputStream() {
		super();
		maxSize = -1;
	}

	public AccessibleByteArrayOutputStream(int size) {
		super(size);
		maxSize = -1;
	}

	public AccessibleByteArrayOutputStream(int size, int maxSize) {
		super(size);
		this.maxSize = maxSize;
	}

	/**
	 * Reset the counter to zero so that the stream can be reused.
	 */
	@Override
	public void close() throws IOException {
		count = 0;
	}

	/**
	 * Returns an InputStream that can read the content of this output stream up to the point where this call was
	 * issued. Further writes on this OutputStream will not be available for the returned InputStream. The typical
	 * scenario is that some byte image is built with a series of writes and an InputStream is desired that can read
	 * this image without copying it (as would have been done using {@link ByteArrayOutputStream#toByteArray()}.
	 *
	 * @return
	 */
	public InputStream getInputStream() {
		return new ByteArrayInputStream(buf, 0, count);
	}

	@Override
	public void write(byte b[], int off, int len) {
		super.write(b, off, len);
		if(maxSize > 0 && count >= maxSize)
			throw new IllegalStateException("Maximum size " + Integer.valueOf(maxSize) + " exceeded");
	}

	@Override
	public void write(int b) {
		super.write(b);
		if(maxSize > 0 && count >= maxSize)
			throw new IllegalStateException("Maximum size " + Integer.valueOf(maxSize) + " exceeded");
	}
}
