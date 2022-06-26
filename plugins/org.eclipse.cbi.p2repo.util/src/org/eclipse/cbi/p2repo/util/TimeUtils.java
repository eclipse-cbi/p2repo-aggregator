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

package org.eclipse.cbi.p2repo.util;

import java.text.ChoiceFormat;
import java.text.MessageFormat;

/**
 * @author Filip Hrbek
 *
 */
public class TimeUtils {
	private static final MessageFormat TIME_FORMAT = new MessageFormat("{0}{1}");

	private static final double[] LIMITS = { 0, 1, 2 };

	private static final String[] MINUTES_PART = { "", "1 minute ", "{0,number} minutes " };

	private static final String[] SECONDS_PART = { "0 seconds", "1 second", "{1,number} seconds" };

	private static final ChoiceFormat MINUTES_FORMAT = new ChoiceFormat(LIMITS, MINUTES_PART);

	private static final ChoiceFormat SECONDS_FORMAT = new ChoiceFormat(LIMITS, SECONDS_PART);

	private static final int MS_IN_SECOND = 1000;

	private static final int SEC_IN_MINUTE = 60;

	static {
		TIME_FORMAT.setFormat(0, MINUTES_FORMAT);
		TIME_FORMAT.setFormat(1, SECONDS_FORMAT);
	}

	public static long getDuration(long fromTime) {
		return System.currentTimeMillis() - fromTime;
	}

	public static String getFormattedDuration(long fromTime) {
		long milliseconds = getDuration(fromTime);
		long seconds = milliseconds / MS_IN_SECOND;
		long minutes = seconds / SEC_IN_MINUTE;
		Object[] args = { Long.valueOf(minutes), Long.valueOf(seconds % SEC_IN_MINUTE) };

		return TIME_FORMAT.format(args);
	}

	public static long getNow() {
		return System.currentTimeMillis();
	}
}
