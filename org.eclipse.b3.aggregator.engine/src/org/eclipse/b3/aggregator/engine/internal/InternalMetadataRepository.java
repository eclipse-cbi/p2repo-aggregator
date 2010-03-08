/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */

package org.eclipse.b3.aggregator.engine.internal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.Arrays;
import java.util.Map;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.URIUtil;
import org.eclipse.equinox.internal.p2.core.helpers.LogHelper;
import org.eclipse.equinox.internal.p2.core.helpers.ServiceHelper;
import org.eclipse.equinox.internal.p2.metadata.repository.Activator;
import org.eclipse.equinox.internal.p2.metadata.repository.LocalMetadataRepository;
import org.eclipse.equinox.internal.p2.metadata.repository.MetadataRepositoryManager;
import org.eclipse.equinox.p2.core.IProvisioningAgent;
import org.eclipse.equinox.p2.core.ProvisionException;
import org.eclipse.equinox.p2.metadata.IInstallableUnit;
import org.eclipse.equinox.p2.repository.IRepository;
import org.eclipse.equinox.p2.repository.metadata.IMetadataRepositoryManager;

/**
 * @author filip.hrbek@cloudsmith.com
 * 
 */
@Deprecated
public class InternalMetadataRepository extends LocalMetadataRepository {

	static final public String CONTENT_FILENAME = "internalContent"; //$NON-NLS-1$

	static final public String JAR_EXTENSION = ".jar"; //$NON-NLS-1$

	static final public String XML_EXTENSION = ".xml"; //$NON-NLS-1$

	static File getActualLocation(URI location, String extension) {
		File spec = URIUtil.toFile(location);
		String path = spec.getAbsolutePath();
		if(path.endsWith(CONTENT_FILENAME + extension)) {
			// todo this is the old code that doesn't look right
			// return new File(spec + extension);
			return spec;
		}
		if(path.endsWith("/")) //$NON-NLS-1$
			path += CONTENT_FILENAME;
		else
			path += "/" + CONTENT_FILENAME; //$NON-NLS-1$
		return new File(path + extension);
	}

	public InternalMetadataRepository(IProvisioningAgent agent) {
		super(agent);
	}

	/**
	 * @param location
	 * @param name
	 * @param properties
	 */
	public InternalMetadataRepository(IProvisioningAgent agent, URI location, String name,
			Map<String, String> properties) {
		super(agent);
		setName(name);
		setType(getClass().getName());
		setVersion("1");
		setLocation(location);
		if(properties != null)
			getProperties().putAll(properties);
		save();
	}

	public synchronized void addInstallableUnits(IInstallableUnit[] installableUnits) {
		if(installableUnits == null || installableUnits.length == 0)
			return;
		units.addAll(installableUnits);
		save();
	}

	public synchronized String basicSetProperty(String key, String value) {
		assertModifiable();
		return(value == null
				? getProperties().remove(key)
				: getProperties().put(key, value));
	}

	public synchronized void removeAll() {
		units.clear();
		save();
	}

	public synchronized boolean removeInstallableUnits(IInstallableUnit[] installableUnits, IProgressMonitor monitor) {
		boolean changed = false;
		if(installableUnits != null && installableUnits.length > 0) {
			changed = true;
			units.removeAll(Arrays.asList(installableUnits));
		}
		if(changed)
			save();
		return changed;
	}

	public String setProperty(String key, String newValue) {
		String oldValue = null;
		synchronized(this) {
			oldValue = basicSetProperty(key, newValue);
			if(oldValue == newValue || (oldValue != null && oldValue.equals(newValue)))
				return oldValue;
			save();
		}
		// force repository manager to reload this repository because it caches properties
		MetadataRepositoryManager manager = (MetadataRepositoryManager) ServiceHelper.getService(
				Activator.getContext(), IMetadataRepositoryManager.SERVICE_NAME);
		if(manager.removeRepository(getLocation()))
			manager.addRepository(this);
		return oldValue;
	}

	private void save() {
		File file = getActualLocation(getLocation(), XML_EXTENSION);
		File jarFile = getActualLocation(getLocation(), JAR_EXTENSION);
		boolean compress = "true".equalsIgnoreCase(getProperties().get(PROP_COMPRESSED)); //$NON-NLS-1$
		try {
			OutputStream output = null;
			if(!compress) {
				if(jarFile.exists()) {
					jarFile.delete();
				}
				if(!file.exists()) {
					if(!file.getParentFile().exists())
						file.getParentFile().mkdirs();
					file.createNewFile();
				}
				output = new FileOutputStream(file);
			}
			else {
				if(file.exists()) {
					file.delete();
				}
				if(!jarFile.exists()) {
					if(!jarFile.getParentFile().exists())
						jarFile.getParentFile().mkdirs();
					jarFile.createNewFile();
				}
				JarEntry jarEntry = new JarEntry(file.getName());
				JarOutputStream jOutput = new JarOutputStream(new FileOutputStream(jarFile));
				jOutput.putNextEntry(jarEntry);
				output = jOutput;
			}
			basicSetProperty(IRepository.PROP_TIMESTAMP, Long.toString(System.currentTimeMillis()));
			new InternalMetadataRepositoryIO(getProvisioningAgent()).write(this, output);
		}
		catch(IOException e) {
			LogHelper.log(new Status(IStatus.ERROR, Activator.ID, ProvisionException.REPOSITORY_FAILED_WRITE,
					"Error saving metadata repository: " + getLocation(), e)); //$NON-NLS-1$
		}
	}
}
