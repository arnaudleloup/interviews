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

	/**
	 * Trie implementation.
	 * 
	 * n = number of Strings
	 * L = String length
	 * 
	 * Time complexity: O(n * L)
	 * Space complexity: O(n * L)
	 */
	public static Set<String> f(String[] strings) {
		Node root = new Node();
		for (String s : strings) {
			root = put(root, s, 0);
		}

		Set<String> prefix = new HashSet<>();
		collect(root, new StringBuilder(), prefix);
		return prefix;
	}

	private static void collect(Node x, StringBuilder sb, Set<String> prefix) {
		if (x.n == 1) { // Shortest prefix found
			prefix.add(sb.toString());
			return;
		}

		if (x.value) { // Shortest prefix to this String is itself
			prefix.add(sb.toString());
		}

		for (char c = 0; c < R; c++) {
			if (x.next[c] != null) {
				sb.append(c);
				collect(x.next[c], sb, prefix);
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}

	private static Node put(Node x, String s, int d) {
		if (x == null) {
			x = new Node();
		}

		x.n++;

		if (d == s.length()) {
			x.value = true;
			return x;
		}

		char c = s.charAt(d);
		x.next[c] = put(x.next[c], s, d + 1);
		return x;
	}

	private static int R = 256; // ASCII
	private static class Node {
		int n; // number of children characters
		boolean value; // true if the node corresponds to an added String
		Node[] next = new Node[R];
	}
}