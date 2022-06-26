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

package org.eclipse.cbi.p2repo.p2.maven.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class DigestUtil {
	public static final MessageDigest[] MESSAGE_DIGESTERS;

	static {
		String[] algorithms = { "MD5", "SHA1" };
		MESSAGE_DIGESTERS = new MessageDigest[algorithms.length];
		int i = 0;
		for(String checkSumAlgorithm : algorithms)
			try {
				MESSAGE_DIGESTERS[i++] = MessageDigest.getInstance(checkSumAlgorithm);
			}
			catch(NoSuchAlgorithmException e) {
				throw new RuntimeException("Unable to create checksum algorithm for " + checkSumAlgorithm + ": " +
						e.getMessage());
			}
	}

	public static String[] createCheckSum(byte[] content, MessageDigest[] digests) {
		String[] result = new String[digests.length];

		int i = 0;
		StringBuilder checkSumStr = new StringBuilder(32);
		for(MessageDigest digest : digests) {
			digest.reset();
			byte[] checkSum = digest.digest(content);
			checkSumStr.setLength(0);
			for(byte b : checkSum)
				checkSumStr.append(String.format("%02x", Byte.valueOf(b)));

			result[i++] = checkSumStr.toString();
		}

		return result;
	}

	public static String encodeMD5(String str) {
		return encode(str, 0);
	}

	public static String encodeSHA1(String str) {
		return encode(str, 1);
	}

	private static String encode(String str, int algorithmIndex) {
		byte[] digest = MESSAGE_DIGESTERS[algorithmIndex].digest(str.getBytes());
		return formatDigest(digest);
	}

	private static String formatDigest(byte[] digest) {
		StringBuilder result = new StringBuilder(digest.length << 1);

		for(byte b : digest)
			result.append(String.format("%02x", Byte.valueOf(b)));

		return result.toString();
	}

}
