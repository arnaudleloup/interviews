package datastructure.symboltable.core;

import java.util.Iterator;

import datastructure.symboltable.api.OrderedSymbolTable;

public class ArraySymbolTable<K extends Comparable<K>, V> implements OrderedSymbolTable<K, V> {

	private final static int INITIAL_CAPACITY = 8;
	@SuppressWarnings("unchecked")
	private K[] keys = (K[]) new Comparable[INITIAL_CAPACITY];
	@SuppressWarnings("unchecked")
	private V[] values = (V[]) new Object[INITIAL_CAPACITY];
	private int N = 0;

	@Override
	public void put(K key, V value) {
		if (value == null) {
			delete(key);
			return;
		}

		int rank = rank(key);
		if (rank < N && keys[rank].compareTo(key) == 0) {
			values[rank] = value;
		} else {
			for (int i = N; i > rank; i--) {
				keys[i] = keys[i - 1];
				values[i] = values[i - 1];
			}

			keys[rank] = key;
			values[rank] = value;

			N++;
			if (N == keys.length) {
				resize(keys.length * 2);
			}
		}
	}

	@Override
	public V get(K key) {
		V value = null;
		int rank = rank(key);

		if (rank < N && keys[rank].compareTo(key) == 0) {
			value = values[rank];
		}

		return value;
	}

	@Override
	public void delete(K key) {
		int rank = rank(key);
		if (keys[rank] == key) {
			for (int i = rank; i < N - 1; i++) {
				keys[i] = keys[i + 1];
				values[i] = values[i + 1];
			}

			keys[N - 1] = null; // Avoid loitering
			values[N - 1] = null;
			N--;
			if (N == keys.length / 4) {
				resize(keys.length / 2);
			}
		}
	}

	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public Iterable<K> keys() {
		return new Iterable<K>() {

			@Override
			public Iterator<K> iterator() {
				return new ArraySTIterator(keys[0], keys[N - 1]);
			}
		};
	}

	@Override
	public K min() {
		if (isEmpty()) {
			return null;
		}

		return keys[0];
	}

	@Override
	public K max() {
		if (isEmpty()) {
			return null;
		}

		return keys[N - 1];
	}

	@Override
	public K floor(K key) {
		if (isEmpty()) {
			return null;
		}

		int rank = rank(key);

		if (rank == 0) {
			return null;
		}

		K k = null;
		if (keys[rank].compareTo(key) == 0) {
			k = keys[rank - 1];
		} else {
			k = keys[rank];
		}

		return k;
	}

	@Override
	public K ceiling(K key) {
		if (isEmpty()) {
			return null;
		}

		int rank = rank(key);

		if (rank == N -1) {
			return null;
		}

		K k = null;
		if (keys[rank].compareTo(key) == 0) {
			k = keys[rank + 1];
		} else {
			k = keys[rank];
		}

		return k;
	}

	@Override
	public int rank(K key) {
		int lo = 0;
		int hi = N - 1;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int comp = keys[mid].compareTo(key);
			if (comp < 0) {
				lo = mid + 1;
			} else if (comp > 0) {
				hi = mid - 1;
			} else  {
				return mid;
			}
		}

		return lo;
	}

	@Override
	public K select(int k) {
		if (k + 1 >= N) {
			return null;
		}

		return keys[k + 1];
	}

	@Override
	public void deleteMin() { // O(n)
		delete(keys[0]);
	}

	@Override
	public void deleteMax() { // O(1)
		delete(keys[N - 1]);
	}

	@Override
	public int size(K lo, K hi) {
		return rank(hi) - rank(lo);
	}

	@Override
	public Iterable<K> keys(final K lo, final K hi) {
		return new Iterable<K>() {

			@Override
			public Iterator<K> iterator() {
				return new ArraySTIterator(lo, hi);
			}
		};
	}

	private void resize(int size) {
		@SuppressWarnings("unchecked")
		K[] keysTemp = (K[]) new Comparable[size];
		for (int i = 0; i < N; i++) {
			keysTemp[i] = keys[i];
		}
		keys = keysTemp;

		@SuppressWarnings("unchecked")
		V[] valuesTemp = (V[]) new Object[size];
		for (int i = 0; i < N; i++) {
			valuesTemp[i] = values[i];
		}
		values = valuesTemp;
	}

	private class ArraySTIterator implements Iterator<K> {
		private int lo;
		private  int hi;

		public ArraySTIterator(K l, K h) {
			lo = rank(l);
			hi = rank(h);

			if (keys[lo].compareTo(l) != 0) {
				lo++;
			}

			if (keys[hi].compareTo(h) != 0) {
				hi++;
			}
		}

		@Override
		public boolean hasNext() {
			return hi < N && lo < hi;
		}

		@Override
		public K next() {
			return keys[lo++];
		}

		@Override
		public void remove() {
		}
	}
}