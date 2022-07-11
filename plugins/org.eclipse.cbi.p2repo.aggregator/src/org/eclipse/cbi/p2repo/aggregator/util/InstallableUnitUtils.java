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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.IAggregatorConstants;
import org.eclipse.cbi.p2repo.aggregator.InstallableUnitType;
import org.eclipse.cbi.p2repo.aggregator.Status;
import org.eclipse.cbi.p2repo.aggregator.StatusCode;
import org.eclipse.cbi.p2repo.p2.InstallableUnit;
import org.eclipse.cbi.p2repo.util.StringUtils;
import org.eclipse.equinox.internal.p2.metadata.RequiredCapability;
import org.eclipse.equinox.internal.p2.metadata.TranslationSupport;
import org.eclipse.equinox.internal.p2.metadata.index.CapabilityIndex;
import org.eclipse.equinox.internal.p2.metadata.index.IdIndex;
import org.eclipse.equinox.internal.p2.metadata.index.IndexProvider;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.IProvidedCapability;
import org.eclipse.equinox.p2.metadata.IRequirement;
import org.eclipse.equinox.p2.metadata.KeyWithLocale;
import org.eclipse.equinox.p2.metadata.MetadataFactory.InstallableUnitDescription;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.metadata.index.IIndex;
import org.eclipse.equinox.p2.query.IQueryable;

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

	public static IQueryable<IInstallableUnit> getIndex(Collection<? extends IInstallableUnit> ius) {
		return new InstallableUnitIndex(ius);
	}

	private static class InstallableUnitIndex extends IndexProvider<IInstallableUnit> {
		private final List<IInstallableUnit> dataSet;
		private final IIndex<IInstallableUnit> capabilityIndex;
		private final IIndex<IInstallableUnit> idIndex;
		private final TranslationSupport translationSupport;

		public InstallableUnitIndex(Collection<? extends IInstallableUnit> ius) {
			dataSet = new ArrayList<>(ius);
			capabilityIndex = new CapabilityIndex(dataSet.iterator());
			idIndex = new IdIndex(dataSet.iterator());
			translationSupport = new TranslationSupport(this);
		}

		@Override
		public Iterator<IInstallableUnit> everything() {
			return dataSet.iterator();
		}

		@Override
		public IIndex<IInstallableUnit> getIndex(String memberName) {
			if (org.eclipse.equinox.internal.p2.metadata.InstallableUnit.MEMBER_PROVIDED_CAPABILITIES
					.equals(memberName)) {
				return capabilityIndex;
			}
			if (org.eclipse.equinox.internal.p2.metadata.InstallableUnit.MEMBER_ID.equals(memberName)) {
				return idIndex;
			}
			return null;
		}

		@Override
		public Object getManagedProperty(Object client, String memberName, Object key) {
			if (client instanceof IInstallableUnit
					&& org.eclipse.equinox.internal.p2.metadata.InstallableUnit.MEMBER_TRANSLATED_PROPERTIES
							.equals(memberName)) {
				IInstallableUnit iu = (IInstallableUnit) client;
				return key instanceof KeyWithLocale ? translationSupport.getIUProperty(iu, (KeyWithLocale) key)
						: translationSupport.getIUProperty(iu, key.toString());
			}
			return null;
		}
	}
}
