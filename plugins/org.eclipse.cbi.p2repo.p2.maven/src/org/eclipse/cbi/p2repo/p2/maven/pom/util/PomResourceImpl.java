/**
 * Copyright (c) 2021 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.p2.maven.pom.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.eclipse.cbi.p2repo.p2.maven.util.XMLResourceImplWithCheck;
import org.eclipse.emf.common.util.URI;

/**
 * 
 *
 * @see org.eclipse.cbi.p2repo.p2.maven.pom.util.PomResourceFactoryImpl
 * @generated NOT
 */
public class PomResourceImpl extends XMLResourceImplWithCheck {
	private String md5;

	private String sha1;

	private Long timestamp;

	/**
	 * Creates an instance of the resource. 
	 *
	 * @param uri
	 *            the URI of the new resource.
	 * @generated NOT
	 */
	public PomResourceImpl(URI uri) {
		super(uri);
	}

	@Override
	public void doLoad(InputStream is, Map<?, ?> options) throws IOException {
		if (is instanceof InputStreamWithInfo) {
			InputStreamWithInfo isi = (InputStreamWithInfo) is;
			timestamp = isi.getTimestamp();
			md5 = isi.getMd5();
			sha1 = isi.getSha1();
		}

		super.doLoad(is, options);
	}

	public String getMd5() {
		return md5;
	}

	public String getSha1() {
		return sha1;
	}

	public Long getTimestamp() {
		return timestamp;
	}
} // PomResourceImpl
