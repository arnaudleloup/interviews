package datastructure.symboltable.core;

import java.util.LinkedList;
import java.util.Queue;

import datastructure.symboltable.api.OrderedSymbolTable;

public class BinarySearchTree<K extends Comparable<K>, V> implements OrderedSymbolTable<K, V> {

	private Node root;

	@Override
	public void put(K key, V value) {
		root = put(root, key, value);
	}

	private Node put(Node x, K key, V value) {
		if (x == null) {
			return new Node(key, value, 1);
		}

		int comp = key.compareTo(x.key);

		if (comp < 0) {
			x.left = put(x.left, key, value);
		} else if (comp > 0) {
			x.right = put(x.right, key, value);
		} else {
			x.value = value;
		}

		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	@Override
	public V get(K key) {
		return get(root, key);
	}

	private V get(Node x, K key) {
		if (x == null) {
			return null;
		}

		int comp = key.compareTo(x.key);
		if (comp < 0) {
			return get(x.left, key);
		} else if (comp > 0) {
			return get(x.right, key);
		} else {
			return x.value;
		}
	}

	@Override
	public void delete(K key) {
		root = delete(root, key);
	}

	private Node delete(Node x, K key) {
		if (x == null) {
			return null;
		}

		int comp = key.compareTo(x.key);
		if (comp < 0) {
			return delete(x.left, key);
		} else if (comp > 0) {
			return delete(x.right, key);
		} else {
			if (x.right == null) {
				return x.left;
			}

			if (x.left == null) {
				return x.right;
			}

			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}

		x.N = size(x.right) + size(x.left) + 1;
		return x;
	}

	@Override
	public boolean contains(K key) {
		return get(key) != null;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public int size() {
		return size(root);
	}

	private int size(Node x) {
		if (x == null) {
			return 0;
		}

		return x.N;
	}

	@Override
	public Iterable<K> keys() {
		return keys(min(), max());
	}

	@Override
	public Iterable<K> keys(K lo, K hi) {
		Queue<K> queue = new LinkedList<>();
		keys(root, queue, lo, hi);
		return queue;
	}

	private void keys(Node x, Queue<K> queue, K lo, K hi) {
		if (x == null) {
			return;
		}

		int complo = lo.compareTo(x.key);
		int comphi = hi.compareTo(x.key);

		if (complo < 0) {
			keys(x.left, queue, lo, hi);
		}

		if (complo <= 0 && comphi >= 0) {
			queue.add(x.key);
		}

		if (comphi > 0) {
			keys(x.right, queue, lo, hi);
		}
	}

	@Override
	public K min() {
		return min(root).key;
	}

	public Node min(Node x) {
		if (x.left == null) {
			return x;
		}

		return min(x.left);
	}

	@Override
	public K max() {
		return max(root).key;
	}

	private Node max(Node x) {
		if (x.right == null) {
			return x;
		}

		return max(x.right);
	}

	@Override
	public K floor(K key) {
		return floor(root, key).key;
	}

	private Node floor(Node x, K key) {
		if (x == null) {
			return null;
		}

		int comp = key.compareTo(x.key);

		if (comp == 0) {
			return x;
		}

		if (comp < 0) {
			return floor(x.left, key);
		}

		Node t = floor(x.right, key);

		if (t != null) {
			return t;
		} else {
			return x;
		}
	}

	@Override
	public K ceiling(K key) {
		return ceiling(root, key).key;
	}

	private Node ceiling(Node x, K key) {
		if (x == null) {
			return null;
		}

		int comp = key.compareTo(x.key);

		if (comp == 0) {
			return x;
		}

		if (comp > 0) {
			return ceiling(x.right, key);
		}

		Node t = ceiling(x.left, key);
		if (t != null) {
			return t;
		} else {
			return x;
		}
	}

	@Override
	public int rank(K key) {
		return rank(root, key);
	}

	private int rank(Node x, K key) {
		if (x == null) {
			return 0;
		}

		int comp = key.compareTo(x.key);
		if (comp == 0) {
			return size(x.left);
		} else if (comp < 0) {
			return rank(x.left, key);
		} else {
			return 1 + size(x.left) + rank(x.right, key);
		}
	}

	@Override
	public K select(int k) {
		return select(root, k).key;
	}

	private Node select(Node x, int k) {
		if (x == null) {
			return null;
		}

		int t = size(x.left);
		if (t == k) {
			return x;
		} else if (t < k) {
			return select(x.right, k - t - 1);
		} else {
			return select(x.left, k);
		}
	}

	@Override
	public void deleteMin() {
		root = deleteMin(root);
	}

	private Node deleteMin(Node x) {
		if (x.left == null) {
			return x.right;
		}

		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	@Override
	public void deleteMax() {
		root = deleteMax(root);
	}

	private Node deleteMax(Node x) {
		if (x.right == null) {
			return x.left;
		}

		x.right = deleteMax(x.right);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	@Override
	public int size(K lo, K hi) {
		Iterable<K> itr = keys(lo, hi);
		int size = 0;
		while (itr.iterator().hasNext()) {
			itr.iterator().next();
			size++;
		}

		return size;
	}

	private class Node {
		K key;
		V value;
		int N;

		Node left;
		Node right;

		public Node(K key, V value, int N) {
			this.key = key;
			this.value = value;
			this.N = N;
		}
	}
}