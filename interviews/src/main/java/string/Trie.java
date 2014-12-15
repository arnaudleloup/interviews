package string;

import java.util.HashSet;
import java.util.Set;

public class Trie {
	private final int R = 256;
	private Node root = new Node();

	public void add(String key, int value) {
		root = add(root, key, value, 0);
	}

	private Node add(Node x, String key, int value, int d) {
		if (x == null) {
			x = new Node();
		}

		if (d == key.length()) {
			if (x.value == null) {
				x.size++;
			}
			x.value = value;
			return x;
		}

		char c = key.charAt(d);
		if (x.next[c] != null) {
			x.size -= x.next[c].size;
		}
		x.next[c] = add(x.next[c], key, value, d + 1);
		x.size += x.next[c].size;
		return x;
	}

	public int get(String key) {
		Node x = get(root, key, 0);
		return x == null ? null : x.value;
	}

	private Node get(Node x, String key, int d) {
		if (x == null) {
			return null;
		}

		if (d == key.length()) {
			return x;
		}

		return get(x.next[key.charAt(d)], key, d + 1);
	}

	public Set<String> keys() {
		return keysWithPrefix("");
	}

	public Set<String> keysWithPrefix(String pre) {
		Node x = get(root, pre, 0);
		Set<String> strings = new HashSet<>();
		collect(x, new StringBuilder(pre), strings);
		return strings;
	}

	private void collect(Node x, StringBuilder sb, Set<String> strings) {
		if (x == null) {
			return;
		}

		if (x.value != null) {
			strings.add(sb.toString());
		}

		for (char c = 0; c < R; c++) {
			sb.append(c);
			collect(x.next[c], sb, strings);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	public int size() {
		return root.size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	private class Node {
		Node[] next = new Node[R];
		Integer value = null;
		int size;
	}
}