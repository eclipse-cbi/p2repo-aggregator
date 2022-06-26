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

package org.eclipse.cbi.p2repo.aggregator.util;

import org.eclipse.cbi.p2repo.p2.InstallableUnit;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.IAggregatorConstants;
import org.eclipse.cbi.p2repo.aggregator.InstallableUnitType;
import org.eclipse.cbi.p2repo.aggregator.Status;
import org.eclipse.cbi.p2repo.aggregator.StatusCode;
import org.eclipse.cbi.p2repo.util.StringUtils;
import org.eclipse.equinox.internal.p2.metadata.RequiredCapability;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IProvidedCapability;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.MetadataFactory.InstallableUnitDescription;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;

/**
 * @author Karel Brezina
 *
 */
public class InstallableUnitUtils {
	public static void appendIdentifier(StringBuilder bld, IInstallableUnit iu) {
		InstallableUnitType riuType = getType(iu);
		bld.append(riuType.toString());
		bld.append('(');
		bld.append(iu.getId());
		Version v = iu.getVersion();
		if(!(v == null || v.equals(Version.emptyVersion))) {
			bld.append(' ');
			bld.append(v);
		}
		bld.append(')');
	}

	public static void appendIdentifier(StringBuilder bld, IRequirement req) {
		if(req instanceof RequiredCapability) {
			RequiredCapability rc = (RequiredCapability) req;
			String ns = rc.getNamespace();
			if("osgi.bundle".equals(ns))
				bld.append("Bundle(");
			else if("java.package".equals(ns))
				bld.append("JavaPackage(");
			else
				bld.append("InstallableUnit(");
			bld.append(rc.getName());
			VersionRange range = rc.getRange();
			if(!(range == null || VersionRange.emptyRange.equals(range))) {
				bld.append(' ');
				bld.append(range);
			}
			bld.append(')');
		}
		else
			bld.append(req.toString());
	}

	public static Status getStatus(InstallableUnit iu) {
		synchronized(iu) {
			return StringUtils.trimmedOrNull(iu.getId()) != null
					? AggregatorFactory.eINSTANCE.createStatus(StatusCode.OK)
					: AggregatorFactory.eINSTANCE.createStatus(StatusCode.BROKEN);
		}
	}

	public static InstallableUnitType getType(IInstallableUnit iu) {
		if("true".equalsIgnoreCase(iu.getProperty(InstallableUnitDescription.PROP_TYPE_CATEGORY)))
			return InstallableUnitType.CATEGORY;
		if(iu.getId().endsWith(IAggregatorConstants.FEATURE_SUFFIX))
			return InstallableUnitType.FEATURE;
		if("true".equalsIgnoreCase(iu.getProperty(InstallableUnitDescription.PROP_TYPE_GROUP)))
			return InstallableUnitType.PRODUCT;
		if(isOSGiFragment(iu))
			return InstallableUnitType.FRAGMENT;
		if(isOSGiBundle(iu))
			return InstallableUnitType.BUNDLE;
		return InstallableUnitType.OTHER;
	}

	private static boolean isOSGiBundle(IInstallableUnit iu) {
		for(IProvidedCapability rc : iu.getProvidedCapabilities())
			if(IAggregatorConstants.NAMESPACE_TYPE.equals(rc.getNamespace()) &&
					(IAggregatorConstants.CAPABILITY_TYPE_BUNDLE.equals(rc.getName()) || IAggregatorConstants.CAPABILITY_TYPE_SOURCE.equals(rc.getName())))
				return true;
		return false;
	}

	private static boolean isOSGiFragment(IInstallableUnit iu) {
		for(IProvidedCapability rc : iu.getProvidedCapabilities())
			if(IAggregatorConstants.NAMESPACE_OSGI_FRAGMENT.equals(rc.getNamespace()))
				return true;
		return false;
	}

	public static boolean isSourceBundle(IInstallableUnit iu) {
		for(IProvidedCapability rc : iu.getProvidedCapabilities())
			if(IAggregatorConstants.NAMESPACE_TYPE.equals(rc.getNamespace()) &&
					IAggregatorConstants.CAPABILITY_TYPE_SOURCE.equals(rc.getName()))
				return true;
		return false;
	}

}
