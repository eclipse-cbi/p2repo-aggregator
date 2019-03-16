/*******************************************************************************
 * Copyright (c) 2006-2007, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 ******************************************************************************/

package org.eclipse.cbi.p2repo.p2.maven.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.cbi.p2repo.aggregator.VersionFormat;
import org.eclipse.cbi.p2repo.util.StringUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.equinox.p2.metadata.IVersionFormat;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;

/**
 * @author Filip Hrbek (filip.hrbek@cloudsmith.com)
 *
 */
public class VersionUtil {

	/**
	 * Suffix for maven SNAPSHOT versions.
	 */
	public static final String DASH_SNAPSHOT = "-SNAPSHOT";

	/**
	 * Wrapper class to provide dual views on a version: mostly OSGi-like, but string representation uses the mapped variant (from
	 * #versionPattern & #versionTemplate).
	 */
	private static class MappedVersion extends Version {
		private static final long serialVersionUID = 1L;

		private final String mappedVersion;

		private final Version version;

		private final VersionFormat versionFormat;

		/**
		 * @param version
		 * @param mappedVersion
		 * @param versionFormat
		 */
		public MappedVersion(Version version, String mappedVersion, VersionFormat versionFormat) {
			this.mappedVersion = mappedVersion;
			this.version = version;
			this.versionFormat = versionFormat;
		}

		@Override
		public int compareTo(Version o) {
			VersionFormat oFormat = VersionFormat.NORMAL;
			String oMapped = null;
			if (o instanceof MappedVersion) {
				MappedVersion mv = (MappedVersion) o;
				o = mv.version;
				oFormat = mv.versionFormat;
				oMapped = mv.mappedVersion;
			}
			int vComp = version.compareTo(o);
			if (vComp != 0) {
				return vComp;
			}
			if (this.versionFormat == oFormat)
				return oMapped != null ? mappedVersion.compareTo(oMapped) : 0;
			else
				return this.versionFormat.compareTo(oFormat);
		}

		@Override
		public IVersionFormat getFormat() {
			return version.getFormat();
		}

		@Override
		public String getOriginal() {
			return mappedVersion;
		}

		@Override
		public Comparable<?> getPad() {
			return version.getPad();
		}

		@Override
		public Comparable<?> getSegment(int index) {
			return version.getSegment(index);
		}

		@Override
		public int getSegmentCount() {
			return version.getSegmentCount();
		}

		@Override
		public boolean isOSGiCompatible() {
			return this.versionFormat != VersionFormat.MAVEN_SNAPSHOT && version.isOSGiCompatible();
		}

		@Override
		public void toString(StringBuffer sb) {
			sb.append(mappedVersion);
		}
	}

	public static Version createVersion(String versionStr) throws CoreException {
		versionStr = StringUtils.trimmedOrNull(versionStr);
		if(versionStr == null)
			return null;

		Matcher m = timestampPattern.matcher(versionStr);
		if(m.matches())
			// Timestamp
			return createVersionFromFormatAndOriginal("S=[0-9];={8};[.S=[0-9];={6};='000000';]", versionStr);

		try {
			// Triplet
			return createVersionFromFormatAndOriginal("n[.n=0;[.n=0;]][d?S=M;]", versionStr);
		}
		catch(IllegalArgumentException e) {
			// String
			return createVersionFromFormatAndOriginal("S", versionStr);
		}
	}

	public static Version createVersionFromFormatAndOriginal(String format, String versionStr) {
		return Version.parseVersion("format(" + format + "):" + versionStr);
	}

	public static VersionRange createVersionRange(String versionRangeString) throws CoreException {
		String vr = StringUtils.trimmedOrNull(versionRangeString);
		if(vr == null)
			return VersionRange.emptyRange;

		Matcher m = versionRangePattern.matcher(vr);
		if(m.matches()) {
			return new VersionRange(
				createVersion(m.group(2)), "[".equals(m.group(1)), createVersion(m.group(3)), "[".equals(m.group(4)));
		}
		Version v = createVersion(vr);
		return new VersionRange(v, true, Version.MAX_VERSION, true);
	}

	public static String getVersionString(Version version) {
		String versionString = version.getOriginal();
		if(versionString == null)
			versionString = version.toString();

		return versionString;
	}

	public static String getVersionString(Version version, VersionFormat versionFormat) {
		if(version instanceof MappedVersion)
			return version.getOriginal(); // MappedVersion indicates that VersionFormat is overridden from MavenMapping

		String versionString = getVersionString(version);
		if(versionFormat == VersionFormat.NORMAL)
			return versionString;

		// Some components (jgit in particular) uses an OSGi version that translates
		// into a four digit version followed by dash and then 'r', 'rc1' etc. We don't
		// touch those
		Matcher m = mavenTrickPattern.matcher(versionString);
		if(m.matches())
			return versionString;

		m = osgiPattern.matcher(versionString);
		if(!m.matches())
			return versionString;

		if (versionFormat == VersionFormat.MAVEN_RELEASE)
			return m.group(1);

		// Ensure that the qualifier is separated with a dash and then don't contain dashes
		StringBuilder bld = new StringBuilder();
		bld.append(m.group(1));
		bld.append('-');
		bld.append(m.group(2));
		return bld.toString();
	}

	public static Version mappedVersion(String original, VersionFormat versionFormat) {
		String version;
		int idx = original.indexOf(DASH_SNAPSHOT);
		if (idx > -1) {
			version = original.substring(0, idx);
		} else {
			version = original;
		}
		return new MappedVersion(Version.create(version), original, versionFormat);
	}

	private static Pattern versionRangePattern = Pattern.compile("^(\\([)([^,]+),([^,]+)(\\)])$");

	private static final Pattern timestampPattern = Pattern.compile(//
	"^((?:19|20)\\d{2}(?:0[1-9]|1[012])(?:0[1-9]|[12][0-9]|3[01]))" + // //$NON-NLS-1$
			"(?:\\.((?:[01][0-9]|2[0-3])[0-5][0-9][0-5][0-9]))?$"); //$NON-NLS-1$

	private static final Pattern mavenTrickPattern = Pattern.compile("^\\d+\\.\\d+\\.\\d+(?:\\.\\d+-[a-zA-Z][a-zA-Z0-9_]*)?$");

	private static final Pattern osgiPattern = Pattern.compile("^(\\d+\\.\\d+\\.\\d+)\\.([a-zA-Z0-9_-]+)$");

	public static String getVersionQualifier(String versionString) {
		int dash = versionString.indexOf('-');
		if (dash == -1)
			return null;
		return versionString.substring(dash + 1);
	}

	public static String versionAsSnapshot(String version) {
		int dash = version.indexOf('-');
		if (dash != -1) {
			version = version.substring(0, dash) + DASH_SNAPSHOT;
		}
		return version;
	}
}
