package datastructure.symboltable.core;

import java.util.Iterator;

import datastructure.symboltable.api.SymbolTable;

public class LinkedListSymbolTable<K, V> implements SymbolTable<K, V> {

	private Node first;
	private int N = 0;

	@Override
	public void put(K key, V value) { // O(n)
		if (value == null) {
			delete(key);
			return;
		}

		Node node = retrieve(key);
		if (node == null) {
			first = new Node(key, value, first);
			N++;
		} else {
			node.value = value;
		}
	}

	@Override
	public V get(K key) { // O(n)
		Node node = retrieve(key);
		return node == null ? null : node.value;
	}

	private Node retrieve(K key) { // O(n)
		Node actual = first;

		while (actual != null) {
			if (actual.key.equals(key)) {
				return actual;
			}

			actual = actual.next;
		}

		return null;
	}

	@Override
	public void delete(K key) { // O(n)
		if (isEmpty()) {
			return;
		}

		if (first.key.equals(key)) {
			first = first.next;
			N--;
			return;
		}

		Node previous = first;
		Node actual = first.next;

		while (actual != null) {
			if (actual.key.equals(key)) {
				previous.next = actual.next;
				N--;
				break;
			}

			previous = actual;
			actual = actual.next;
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
				return new LinkedListSTIterator();
			}
		};
	}

	private class LinkedListSTIterator implements Iterator<K> {

		private Node actual = first;

		@Override
		public boolean hasNext() {
			return actual != null;
		}

		@Override
		public K next() {
			K key = actual.key;
			actual = actual.next;
			return key;
		}

		@Override
		public void remove() {
		}
	}

	private class Node {
		K key;
		V value;
		Node next;

		public Node(K key, V value, Node next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}
}