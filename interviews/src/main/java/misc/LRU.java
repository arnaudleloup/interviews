package misc;

import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of a LRU (least recently used)
 * that supports insert and get in constant time.
 */
public class LRU<K, V> {

	private final Map<K, DoublyLinkedListNode> cache;
	private final int n;
	private int size = 0;
	private DoublyLinkedListNode first;
	private DoublyLinkedListNode last;

	/**
	 * Constructs a new LRU cache with the specified capacity.
	 */
	public LRU(int n) {
		cache = new HashMap<>(n);
		this.n = n;
	}

	/**
	 * Returns the value of a specified key, or null if the key is unknown.
	 */
	public V get(K key) {
		if (!cache.containsKey(key)) {
			return null;
		}

		return cache.get(key).value;
	}

	/**
	 * Insert a new value for a specified key.
	 */
	public void insert(K key, V value) {
		if (cache.containsKey(key)) {
			update(key, value);
		} else {
			add(key, value);
		}
	}

	/**
	 * Add a new key/value into the map and the linked list.
	 */
	private void add(K key, V value) {
		DoublyLinkedListNode node = new DoublyLinkedListNode(key, value);
		if (isEmpty()) {
			first = node;
			last = node;
		} else {
			last.right = node;
			node.left = last;
			last = node;
		}

		cache.put(key, node);
		size++;

		if (size > n) {
			remove();
		}
	}

	/**
	 * Removes the last recently used.
	 */
	private void remove() {
		K key = first.key;
		cache.remove(key);
		first = first.right;
		first.left = null;
		size--;
	}

	/**
	 * Update a specified key with a specified value.
	 */
	private void update(K key, V value) {
		DoublyLinkedListNode node = cache.get(key);
		node.value = value;
		node.left.right = node.right;
		last.right = node;
		node.left = last;
		last = node;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Doubly linked list node.
	 */
	private class DoublyLinkedListNode {
		K key;
		V value;
		DoublyLinkedListNode left;
		DoublyLinkedListNode right;

		public DoublyLinkedListNode(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((left == null) ? 0 : left.hashCode());
			result = prime * result + ((right == null) ? 0 : right.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}

		@Override
		public String toString() {
			return "DoublyLinkedListNode [value=" + value + ", left=" + left
					+ ", right=" + right + "]";
		}
	}
}