package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Compute the shortest unique prefix to represent each word in the array.
 * 
 * Input: "zebra", "dog", "duck", "dot"
 * Output: "z", "dog", "du", "dot"
 */
public class ShortestUniquePrefix {

	private static final int R = 256; // extended ASCII

	/**
	 * n = number of Strings
	 * L = average string length
	 * R = alphabet radix (extended ASCII)
	 * 
	 * Time complexity: O(n * L)
	 * Space complexity: O(n * L * R)
	 */
	public static Set<String> f(String[] strings) {
		Node root = new Node();
		for (String s : strings) {
			root = add(root, s, 0);
		}

		Set<String> prefixs = new HashSet<>();
		collect(root, new StringBuilder(), prefixs);
		return prefixs;
	}

	private static Node add(Node x, String s, int d) {
		if (x == null) {
			x = new Node();
		}

		if (d == s.length()) {
			if (!x.value) {
				x.value = true;
				x.size++;
			}

			return x;
		}

		char c = s.charAt(d);
		if (x.next[c] != null) {
			x.size -= x.next[c].size;
		}
		x.next[c] = add(x.next[c], s, d + 1);
		x.size += x.next[c].size;

		return x;
	}

	private static void collect(Node x, StringBuilder sb, Set<String> prefixs) {
		if (x == null) {
			return;
		}

		if (x.value) {
			prefixs.add(sb.toString());
		}

		if (x.size == 1) {
			prefixs.add(sb.toString());
			return;
		}

		for (char c = 0; c < R; c++) {
			sb.append(c);
			collect(x.next[c], sb, prefixs);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static class Node {
		Node[] next = new Node[R];
		boolean value = false;
		int size = 0;
	}
}