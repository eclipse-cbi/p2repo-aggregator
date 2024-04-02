/**
 * Copyright (c) 2006-2010, Markus Alexander Kuppe.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.cbi.p2repo.aggregator.engine;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorFactory;
import org.eclipse.cbi.p2repo.aggregator.MetadataRepositoryReference;
import org.eclipse.cbi.p2repo.aggregator.ValidationSet;
import org.eclipse.cbi.p2repo.aggregator.impl.MetadataRepositoryReferenceImpl;
import org.eclipse.cbi.p2repo.util.ExceptionUtils;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.kohsuke.args4j.Option;

/**
 * @author Markus Alexaneder Kuppe <cbi-dev_eclipse.org@lemmster dot de>
 *
 */
public class Modifier extends ModelAbstractCommand {
	public enum ActionType {
		ADD, REMOVE
	}

	@Option(name = "--action", usage = "Specifies the type of the execution.")
	private ActionType action;

	@Option(name = "--repoLocation", usage = "Appoints a new repository for aggregation")
	private String repoLocation;

	@Option(name = "--validationSet", usage = "Appoints the targeted validation set")
	private String validationSetName;

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.cbi.p2repo.cli.AbstractCommand#getShortDescription()
	 */
	@Override
	public String getShortDescription() {
		return "Modifies the validationSets model from the command line";
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.eclipse.cbi.p2repo.cli.AbstractCommand#run(org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	protected int run(IProgressMonitor monitor) throws Exception {
		try {
			final Aggregation aggregation = loadModelFromFile();
			List<ValidationSet> validationSets = aggregation.getValidationSets(true);
			ValidationSet validationSet = null;
			if(validationSetName == null) {
				if(validationSets.size() != 1)
					throw ExceptionUtils.fromMessage("Unable to determine what validation set to modify");
				validationSet = validationSets.get(0);
			}
			else {
				for(ValidationSet vs : validationSets) {
					if(validationSetName.equals(vs.getLabel())) {
						validationSet = vs;
						break;
					}
				}
				if(validationSet == null)
					throw ExceptionUtils.fromMessage(
						"Unable to find a validation set named '" + validationSetName + '\'');
			}

			if(action == ActionType.ADD) {
				// create a metadata repo from the String
				final MetadataRepositoryReferenceImpl newRepository = (MetadataRepositoryReferenceImpl) AggregatorFactory.eINSTANCE.createMetadataRepositoryReference();
				newRepository.setLocation(repoLocation);

				// add new repository to the existing onces
				final EList<MetadataRepositoryReference> metadataRepos = validationSet.getValidationRepositories();
				metadataRepos.add(newRepository);
			}
			else if(action == ActionType.REMOVE) {
				final Set<MetadataRepositoryReference> removees = new HashSet<MetadataRepositoryReference>();
				final EList<MetadataRepositoryReference> metadataRepos = validationSet.getValidationRepositories();
				for(MetadataRepositoryReference metadataRepositoryReference : metadataRepos) {
					if(metadataRepositoryReference.getLocation().equals(repoLocation)) {
						removees.add(metadataRepositoryReference);
					}
				}

				if(removees.size() == 0) {
					throw ExceptionUtils.fromMessage("Unable to find validation repository " + repoLocation);
				}
				metadataRepos.removeAll(removees);
			}

			// store the model persistently
			final EObject eObj = (EObject) aggregation;
			final Resource resource = eObj.eResource();
			final Map<Object, Object> saveOptions = new HashMap<Object, Object>();
			saveOptions.put(Resource.OPTION_SAVE_ONLY_IF_CHANGED, Resource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
			resource.save(saveOptions);

		}
		catch(Exception e) {
			ExceptionUtils.wrap(e);
		}

		return 0;
	}
}
