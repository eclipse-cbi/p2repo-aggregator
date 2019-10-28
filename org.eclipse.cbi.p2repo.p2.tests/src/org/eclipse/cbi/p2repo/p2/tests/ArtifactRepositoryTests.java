/**
 * Copyright (c) 2006-2010, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */

package org.eclipse.cbi.p2repo.p2.tests;

import java.util.Set;

import org.eclipse.cbi.p2repo.p2.util.P2Bridge;
import org.eclipse.cbi.p2repo.p2.util.P2Utils;
import org.eclipse.equinox.p2.metadata.IArtifactKey;
import org.eclipse.equinox.p2.metadata.expression.ExpressionUtil;
import org.eclipse.equinox.p2.query.IQuery;
import org.eclipse.equinox.p2.query.QueryUtil;
import org.eclipse.equinox.p2.repository.artifact.IArtifactDescriptor;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepository;
import org.eclipse.equinox.p2.repository.artifact.IArtifactRepositoryManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArtifactRepositoryTests extends RepositoryTests<IArtifactKey> {

	protected IArtifactRepository source;

	protected IArtifactRepository target;

	protected IQuery<IArtifactKey> query;

	@Before
	public void createAndLoadAR() throws Exception {
		IArtifactRepositoryManager arMgr = P2Utils.getRepositoryManager(IArtifactRepositoryManager.class);
		source = arMgr.loadRepository(getTestData("bucky"), monitor);
		target = P2Bridge.importToModel(arMgr, source, monitor);
		query = QueryUtil.createMatchQuery(IArtifactKey.class, ExpressionUtil.TRUE_EXPRESSION);
	}

	@Test
	public void testContainer() throws Exception {
		Set<IArtifactKey> keys = target.query(query, monitor).toUnmodifiableSet();
		for(IArtifactKey key : keys) {
			for (IArtifactDescriptor desc : target.getArtifactDescriptors(key)) {
				Assert.assertTrue("Parent is not correct", target == desc.getRepository());
			}
		}
	}

	@Test
	public void testEquality() throws Exception {
		super.assertEquals(source, target);
		Set<IArtifactKey> aKeys = source.query(query, monitor).toUnmodifiableSet();
		Set<IArtifactKey> bKeys = target.query(query, monitor).toUnmodifiableSet();
		Assert.assertEquals("Artifact keys differ", aKeys, bKeys);
		for(IArtifactKey key : aKeys) {
			IArtifactDescriptor[] aDescs = source.getArtifactDescriptors(key);
			IArtifactDescriptor[] bDescs = target.getArtifactDescriptors(key);
			if(aDescs.length != bDescs.length) {
				Assert.fail("ArtifactDescriptorCount for " + key + " differs");
			}
			for(IArtifactDescriptor desc : aDescs) {
				Assert.assertTrue("Missing artifact descriptor", target.contains(desc));
			}
		}
	}
}
