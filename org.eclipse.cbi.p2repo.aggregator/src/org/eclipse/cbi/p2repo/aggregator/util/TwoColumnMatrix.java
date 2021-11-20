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
import java.util.List;
import java.util.NoSuchElementException;

/**
 * @author Karel Brezina
 *
 */
public class TwoColumnMatrix<K, V> {
	public class MatrixEntry {
		K m_key;

		V m_value;

		public MatrixEntry(K key, V value) {
			m_key = key;
			m_value = value;
		}

		public K getKey() {
			return m_key;
		}

		public V getValue() {
			return m_value;
		}
	}

	class MatrixIterator implements ExtendedListIterator<MatrixEntry> {
		private TwoColumnMatrix<K, V> matrix;

		private int index = -1;

		public MatrixIterator(TwoColumnMatrix<K, V> matrix) {
			this.matrix = matrix;
		}

		public void add(MatrixEntry entry) {
			matrix.add(index++, entry);
		}

		public MatrixEntry first() {
			index = 0;
			return matrix.getEntry(index);
		}

		public boolean hasNext() {
			return index < (matrix.size() - 1);
		}

		public boolean hasPrevious() {
			return index > 0;
		}

		public MatrixEntry last() {
			index = matrix.size() - 1;
			return matrix.getEntry(index);
		}

		public MatrixEntry next() {
			index++;

			if(index >= matrix.size())
				throw new NoSuchElementException();

			return matrix.getEntry(index);
		}

		public int nextIndex() {
			return index + 1;
		}

		public MatrixEntry previous() {
			index--;

			if(index < 0)
				throw new NoSuchElementException();

			return matrix.getEntry(index);
		}

		public int previousIndex() {
			return index - 1;
		}

		public void remove() {
			matrix.remove(index);
		}

		public void set(MatrixEntry entry) {
			matrix.set(index, entry);
		}
	}

	List<K> m_keys;

	List<V> m_values;

	public TwoColumnMatrix() {
		this(10);
	}

	public TwoColumnMatrix(int size) {
		m_keys = new ArrayList<K>(size);
		m_values = new ArrayList<V>(size);
	}

	public void add(int index, K key, V value) {
		m_keys.add(index, key);
		m_values.add(index, value);
	}

	public void add(int index, MatrixEntry entry) {
		add(index, entry.getKey(), entry.getValue());
	}

	public void add(K key, V value) {
		m_keys.add(key);
		m_values.add(value);
	}

	public void add(MatrixEntry entry) {
		add(entry.getKey(), entry.getValue());
	}

	public void addAll(TwoColumnMatrix<K, V> matrix) {
		m_keys.addAll(matrix.m_keys);
		m_values.addAll(matrix.m_values);
	}

	public void clear() {
		m_keys.clear();
		m_values.clear();
	}

	public List<MatrixEntry> getEntries() {
		List<MatrixEntry> entries = new ArrayList<MatrixEntry>(size());
		for(int i = 0; i < size(); i++)
			entries.add(getEntry(i));

		return entries;
	}

	public MatrixEntry getEntry(int index) {
		return index < size()
				? new MatrixEntry(m_keys.get(index), m_values.get(index))
				: null;
	}

	public K getKey(int index) {
		return m_keys.get(index);
	}

	public V getValue(int index) {
		return m_values.get(index);
	}

	public int indexOf(K key) {
		return m_keys.indexOf(key);
	}

	public void remove(int index) {
		m_keys.remove(index);
		m_values.remove(index);
	}

	public void set(int index, K key, V value) {
		m_keys.set(index, key);
		m_values.set(index, value);
	}

	public void set(int index, MatrixEntry entry) {
		set(index, entry.getKey(), entry.getValue());
	}

	public int size() {
		return m_keys.size();
	}
}
