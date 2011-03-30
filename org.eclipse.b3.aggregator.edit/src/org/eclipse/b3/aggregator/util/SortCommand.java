/**
 * Copyright (c) 2006-2009, Cloudsmith Inc.
 * The code, documentation and other materials contained herein have been
 * licensed under the Eclipse Public License - v 1.0 by the copyright holder
 * listed above, as the Initial Contributor under such license. The text of
 * such license is available at www.eclipse.org.
 */

package org.eclipse.b3.aggregator.util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.eclipse.emf.common.command.AbstractCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.provider.IItemLabelProvider;

/**
 * @author Karel Brezina
 * 
 */
public class SortCommand<T> extends AbstractCommand {

	class LabelHashComparator implements Comparator<T> {

		private IItemLabelProvider labelProvider;

		public LabelHashComparator(IItemLabelProvider labelProvider) {
			this.labelProvider = labelProvider;
		}

		public int compare(T o1, T o2) {

			if(o1 == null)
				if(o2 == null)
					return 0;
				else
					return -1;
			else if(o2 == null)
				return 1;
			else {
				int result = labelProvider.getText(o1).compareTo(labelProvider.getText(o2));

				// when two different instances have the same label, sort them according to their hash
				if(result == 0)
					result = System.identityHashCode(o1) - System.identityHashCode(o2);

				return result;
			}
		}

	};

	private EList<T> containment;

	private List<T> originalList;

	private Set<T> sortedSet;

	private T itemTemplate;

	private IItemLabelProvider labelProvider;

	public SortCommand(EditingDomain editingDomain, EList<T> containment, T itemTemplate, String label) {
		super("Sort " + label);

		this.containment = containment;
		this.itemTemplate = itemTemplate;

		labelProvider = (IItemLabelProvider) ((AdapterFactoryEditingDomain) editingDomain).getAdapterFactory().adapt(
			itemTemplate, IItemLabelProvider.class);

		if(labelProvider == null)
			throw new IllegalArgumentException(itemTemplate.getClass() + " does not provide label");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.eclipse.emf.common.command.Command#execute()
	 */
	public void execute() {
		sortedSet = new TreeSet<T>(new LabelHashComparator(labelProvider));
		sortedSet.addAll(containment);

		originalList = new ArrayList<T>();
		originalList.addAll(containment);

		containment.clear();
		containment.addAll(sortedSet);
	}

	public Object getImage() {
		return labelProvider.getImage(itemTemplate);
	}

	@Override
	protected boolean prepare() {
		return containment.size() > 1;
	}

	public void redo() {
		containment.clear();
		containment.addAll(sortedSet);
	}

	@Override
	public void undo() {
		containment.clear();
		containment.addAll(originalList);
	}
}
