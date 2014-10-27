package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two words of equal length that are in a dictionary, write a method to transform
 * one word into another word by changing only one letter at a time.
 * The new word you get in each step must be in the dictionary.
 * <p/>
 * Example:
 * <br/>
 * Input: DAMP, LIKE
 * <br/>
 * Output: DAMP -> LAMP -> LIMP -> LIME -> LIKE
 */
public class WordToWord {

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static int f(Set<String> words, String start, String end) {
		Set<String> marked = new HashSet<>();
		marked.add(start);
		Set<String> frontier = new HashSet<>();
		frontier.addAll(adj(words, start));
		int i = 1;

		while (!frontier.isEmpty()) {
			Set<String> next = new HashSet<>();
			for (String adj : frontier) {
				if (!marked.contains(adj)) {
					if (adj.equals(end)) {
						return i;
					}

					marked.add(adj);
					next.addAll(adj(words, adj));
				}
			}

			i++;
			frontier = next;
		}

		return -1;
	}

	private static Set<String> adj(Set<String> words, String word) {
		Set<String> adj = new HashSet<>();

		for (String w : words) {
			if (isAdj(word, w)) {
				adj.add(w);
			}
		}

		return adj;
	}

	private static boolean isAdj(String word1, String word2) {
		if (word1.length() != word2.length()) {
			return false;
		}

		int diff = 0;
		for (int i = 0; i < word1.length(); i++) {
			if (word1.charAt(i) != word2.charAt(i)) {
				diff++;
			}

			if (diff > 1) {
				return false;
			}
		}

		return diff == 1;
	}
}