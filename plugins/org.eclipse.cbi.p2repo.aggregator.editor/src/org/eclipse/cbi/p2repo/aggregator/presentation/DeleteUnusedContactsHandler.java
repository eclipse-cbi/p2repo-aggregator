/**
 * Copyright (c) 2024 Eclipse contributors and others.
 *
 * This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License 2.0
 * which accompanies this distribution, and is available at
 * https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.cbi.p2repo.aggregator.presentation;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.cbi.p2repo.aggregator.Aggregation;
import org.eclipse.cbi.p2repo.aggregator.AggregatorPackage;
import org.eclipse.cbi.p2repo.aggregator.Contact;
import org.eclipse.cbi.p2repo.aggregator.MappedRepository;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EContentsEList;
import org.eclipse.emf.ecore.util.EContentsEList.FeatureIterator;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.command.SetCommand;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.handlers.HandlerUtil;

/**
 * Handler removing contacts that are not referenced anywhere in the model.
 */
public class DeleteUnusedContactsHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		EditingDomain domain = null;
		IEditorPart editor = HandlerUtil.getActiveEditor(event);
		if (editor instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider) editor).getEditingDomain();
		} else {
			return null;
		}

		Resource resource = domain.getResourceSet().getResources().get(0);
		Aggregation aggregation = (Aggregation) EcoreUtil.getObjectByType(resource.getContents(),
				AggregatorPackage.Literals.AGGREGATION);
		if (aggregation == null) {
			return null;
		}

		EList<Contact> contacts = aggregation.getContacts();
		List<Contact> remainingContacts = new ArrayList<>(contacts);
		for (Contact contact : contacts) {
			Collection<Setting> usages = new EcoreUtil.UsageCrossReferencer(resource) {
				private static final long serialVersionUID = 1L;

				@Override
				protected boolean containment(EObject eObject) {
					if (eObject instanceof MappedRepository) {
						return false;
					}
					return true;
				}

				protected EContentsEList.FeatureIterator<EObject> getCrossReferences(EObject eObject) {
					FeatureIterator<EObject> crossReferences = super.getCrossReferences(eObject);
					if (crossReferences instanceof EContentsEList.Filterable) {
						((EContentsEList.Filterable) crossReferences).filter(new EContentsEList.FeatureFilter() {
							@Override
							public boolean isIncluded(EStructuralFeature eStructuralFeature) {
								if (eStructuralFeature == AggregatorPackage.Literals.STATUS_PROVIDER__STATUS) {
									return false;
								}
								return true;
							}
						});

					}
					return crossReferences;
				}

				@Override
				public Collection<Setting> findUsage(EObject eObject) {
					return super.findUsage(eObject);
				}
			}.findUsage((EObject) contact);

			if (usages.isEmpty()) {
				remainingContacts.remove(contact);
			}
		}

		Collections.sort(remainingContacts, new Comparator<Contact>() {
			@Override
			public int compare(Contact o1, Contact o2) {
				int result = compare(o1.getName(), o2.getName());
				if (result == 0) {
					result = compare(o1.getEmail(), o2.getEmail());
				}
				return result;
			}

			private int compare(String s1, String s2) {
				if (s1 == s2) {
					return 0;
				}
				if (s1 == null) {
					return -1;
				}
				if (s2 == null) {
					return 1;
				}
				return Collator.getInstance().compare(s1, s2);

			}
		});

		if (!contacts.equals(remainingContacts)) {
			domain.getCommandStack().execute(SetCommand.create(domain, aggregation,
					AggregatorPackage.Literals.AGGREGATION__CONTACTS, remainingContacts));
		}

		return null;
	}
}
