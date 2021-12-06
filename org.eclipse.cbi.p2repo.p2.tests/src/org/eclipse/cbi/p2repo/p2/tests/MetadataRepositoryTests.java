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

package org.eclipse.cbi.p2repo.p2.tests;

import java.io.File;
import java.util.Iterator;

import org.eclipse.cbi.p2repo.p2.P2Factory;
import org.eclipse.cbi.p2repo.p2.impl.InstallableUnitImpl;
import org.eclipse.cbi.p2repo.p2.impl.MetadataRepositoryImpl;
import org.eclipse.cbi.p2repo.p2.impl.RequiredCapabilityImpl;
import org.eclipse.cbi.p2repo.p2.util.P2Bridge;
import org.eclipse.cbi.p2repo.p2.util.P2Utils;
import org.eclipse.cbi.p2repo.util.LogUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.metadata.Version;
import org.eclipse.equinox.p2.metadata.VersionRange;
import org.eclipse.equinox.p2.query.IQueryResult;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;
import org.junit.Test;

/**
 * @author filip.hrbek@cloudsmith.com
 *
 */
public class MetadataRepositoryTests {
	private static final String SIMPLE_METADATA_TYPE = "org.eclipse.equinox.p2.metadata.repository.simpleRepository"; //$NON-NLS-1$

	@Test
	public void createAndLoadMDR() throws Exception {
		File tempRepositoryLocation = null;
		try {
			tempRepositoryLocation = File.createTempFile("p2mdr", null);
			String path = tempRepositoryLocation.getAbsolutePath();
			tempRepositoryLocation.delete();
			tempRepositoryLocation = new File(path);
			IMetadataRepositoryManager mdrMgr = P2Utils.getRepositoryManager(IMetadataRepositoryManager.class);

			IMetadataRepository created = createMetadataRepository(mdrMgr, tempRepositoryLocation);

			IMetadataRepository reloaded = loadMetadataRepository(mdrMgr, tempRepositoryLocation);

			IQueryResult<IInstallableUnit> iusCreated = created.query(
				P2Bridge.QUERY_ALL_IUS, new NullProgressMonitor());
			Iterator<IInstallableUnit> itorCreated = iusCreated.iterator();
			IQueryResult<IInstallableUnit> iusReloaded = reloaded.query(
				P2Bridge.QUERY_ALL_IUS, new NullProgressMonitor());
			Iterator<IInstallableUnit> itorReloaded = iusReloaded.iterator();

			while(itorCreated.hasNext()) {
				if(!itorReloaded.hasNext())
					throw new Exception("IU counts differ");
				IInstallableUnit iuCreated = itorCreated.next();
				IInstallableUnit iuReloaded = itorReloaded.next();

				if(!iuCreated.equals(iuReloaded))
					throw new Exception("IUs differ");
			}

			if(itorReloaded.hasNext())
				throw new Exception("IU counts differ");
		}
		finally {
			File repoFile = new File(tempRepositoryLocation, "content.xml");
			repoFile.delete();
			tempRepositoryLocation.delete();
		}
	}

	private IMetadataRepository createMetadataRepository(IMetadataRepositoryManager mdrMgr, File location)
			throws CoreException {

		MetadataRepositoryImpl mdr = (MetadataRepositoryImpl) P2Factory.eINSTANCE.createMetadataRepository();
		mdr.setLocation(location.toURI());
		mdr.setName("Testing Repository");
		mdr.setProperty("test.property", "test value");
		mdr.setDescription("This is a testing repository");
		mdr.setType(SIMPLE_METADATA_TYPE);
		mdr.setModifiable(true);
		mdr.setProvider("Eclipse CBI");
		mdr.setVersion("1.0.0");

		InstallableUnitImpl iu1 = createTestingIU("org.eclipse.cbi.p2repo.testing.iu.01", "1.0.0");
		InstallableUnitImpl iu2 = createTestingIU("org.eclipse.cbi.p2repo.testing.iu.02", "1.0.0");
		RequiredCapabilityImpl dep = (RequiredCapabilityImpl) P2Factory.eINSTANCE.createRequiredCapability();
		dep.setName(iu2.getId());
		dep.setNamespace(IInstallableUnit.NAMESPACE_IU_ID);
		dep.setGreedy(true);
		dep.setRange(new VersionRange("1.0.0"));

		iu1.getRequirements().add(dep);

		mdr.getInstallableUnits().add(iu1);
		mdr.getInstallableUnits().add(iu2);
		try {
			P2Bridge.exportFromModel(mdrMgr, mdr, true, null);
		}
		catch(OperationCanceledException e) {
			LogUtils.info("Operation canceled."); //$NON-NLS-1$
		}
		return mdr;
	}

	private InstallableUnitImpl createTestingIU(String name, String version) {
		InstallableUnitImpl iu = (InstallableUnitImpl) P2Factory.eINSTANCE.createInstallableUnit();
		iu.setId(name);
		iu.setVersion(Version.create(version));

		return iu;
	}

	private IMetadataRepository loadMetadataRepository(IMetadataRepositoryManager mdrMgr, File location)
			throws Exception {
		ResourceSet resourceSet = new ResourceSetImpl();
		Resource resource = resourceSet.getResource(
			org.eclipse.emf.common.util.URI.createGenericURI("p2aggr", "p2:" + location.toURI(), null), true);
		if(resource.getErrors().size() > 0)
			throw new Exception(resource.getErrors().get(0).getMessage());

		for(EObject object : resource.getContents()) {
			Diagnostic diag = Diagnostician.INSTANCE.validate(object);
			for(Diagnostic childDiag : diag.getChildren())
				throw new Exception(childDiag.getMessage());
		}

		return (IMetadataRepository) resource.getContents().get(0);
	}

}
