/**
 * Copyright (c) 2006-2010, Markus Alexander Kuppe.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */

package org.eclipse.b3.aggregator.engine;

import java.io.File;

import org.eclipse.b3.aggregator.Aggregation;
import org.eclipse.b3.aggregator.transformer.TransformationManager;
import org.eclipse.b3.aggregator.util.ResourceUtils;
import org.eclipse.b3.cli.AbstractCommand;
import org.eclipse.b3.p2.util.ResourceSetWithAgent;
import org.eclipse.b3.util.ExceptionUtils;
import org.eclipse.b3.util.LogUtils;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.kohsuke.args4j.Option;

/**
 * @author Markus Alexaneder Kuppe <b3-dev_eclipse.org@lemmster dot de>
 *
 */
public abstract class ModelAbstractCommand extends AbstractCommand {
	@Option(name = "--buildModel", required = true, usage = "Appoints the aggregation definition that drives the execution")
	protected File buildModelLocation;

	protected ResourceSet resourceSet;

	/**
	 * Loads the model into memory
	 *
	 * @throws CoreException
	 *             If something goes wrong with during the process
	 */
	protected Aggregation loadModelFromFile() throws CoreException {
		try {
			// Load the Java model into memory
			resourceSet = new ResourceSetWithAgent();
			String modelPath = buildModelLocation.getAbsolutePath();
			File modelFile = new File(modelPath);
			if(!modelFile.exists())
				throw ExceptionUtils.fromMessage("Specified build model file does not exist");
			if(!modelFile.isFile())
				throw ExceptionUtils.fromMessage("Specified build model location does not appoint a file");
			org.eclipse.emf.common.util.URI fileURI = org.eclipse.emf.common.util.URI.createFileURI(modelPath);

			Resource resource;
			if(ResourceUtils.isCurrentModel(fileURI))
				resource = resourceSet.getResource(fileURI, true);
			else {
				LogUtils.warning("The build model file is obsolete, using the default transformation");

				TransformationManager tm = new TransformationManager(fileURI);
				if(!tm.isSrcNamespaceFound())
					throw ExceptionUtils.fromMessage("No transformation found for specified build model");

				resource = tm.transformResource(true);
				resourceSet.getResources().add(resource);
			}

			EList<EObject> content = resource.getContents();
			if(content.size() != 1)
				throw ExceptionUtils.fromMessage(
					"ECore Resource did not contain one resource. It had %d", Integer.valueOf(content.size()));

			return (Aggregation) content.get(0);
		}
		catch(Exception e) {
			throw ExceptionUtils.wrap(e);
		}
	}
}
