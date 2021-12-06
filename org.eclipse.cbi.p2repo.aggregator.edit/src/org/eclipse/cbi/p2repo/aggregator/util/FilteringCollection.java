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

package org.eclipse.cbi.p2repo.aggregator.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * A collection delegating all of its functionality to an underlying collection.
 * Useful for implementing filtering collections.
 *
 * @author michal.ruzicka@cloudsmith.com
 */
public class FilteringCollection<E> implements Collection<E> {

	protected Collection<E> delegate;

	protected FilteringCollection() {
	}

	public FilteringCollection(Collection<E> delegate) {
		setDelegate(delegate);
	}

	@Override
	public boolean add(E e) {
		return delegate.add(e);
	}

	/* call the single argument method in a loop to simplify overriding */
	@Override
	public boolean addAll(Collection<? extends E> c) {
		boolean result = false;
		for(E e : c) {
			if(delegate.add(e) && !result)
				result = true;
		}
		return result;
	}

	@Override
	public void clear() {
		delegate.clear();
	}

	@Override
	public boolean contains(Object o) {
		return delegate.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		return delegate.containsAll(c);
	}

	@Override
	public boolean isEmpty() {
		return delegate.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return delegate.iterator();
	}

	@Override
	public boolean remove(Object o) {
		return delegate.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		return delegate.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		return delegate.retainAll(c);
	}

	public FilteringCollection<E> setDelegate(Collection<E> delegate) {
		if(this.delegate != null)
			throw new IllegalStateException();
		if(delegate == null)
			throw new NullPointerException();
		this.delegate = delegate;
		return this;
	}

	@Override
	public int size() {
		return delegate.size();
	}

	@Override
	public Object[] toArray() {
		return delegate.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a) {
		return delegate.toArray(a);
	}

}
