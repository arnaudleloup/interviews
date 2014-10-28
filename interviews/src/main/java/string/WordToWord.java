package string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	 * n = number of words into the dictionary
	 * L = word length
	 * Time complexity: O(n * L)
	 * Space complexity: O(n)
	 */
	public static List<String> f(Set<String> dictionnary, String start, String end) {
		if (start.equals(end)) {
			return Arrays.asList(start);
		}

		Map<String, String> parent = new HashMap<>();
		Set<String> marked = new HashSet<>();
		Set<String> frontier = new HashSet<>();
		frontier.add(start);

		while (!frontier.isEmpty()) {
			Set<String> next = new HashSet<>();
			for (String s : frontier) {
				marked.add(s);

				for (String adj : adj(dictionnary, s)) {
					if (!marked.contains(adj)) {
						next.add(adj);
						parent.put(adj, s);
						if (adj.equals(end)) {
							break;
						}
					}
				}
			}

			frontier = next;
			if (frontier.contains(end)) {
				break;
			}
		}

		if (!frontier.contains(end)) {
			return new ArrayList<>();
		}

		Deque<String> stack = new ArrayDeque<>();
		String s = end;
		while (s != null) {
			stack.addLast(s);
			s = parent.get(s);
		}

		List<String> list = new ArrayList<>();
		while (!stack.isEmpty()) {
			list.add(stack.removeLast());
		}

		return list;
	}

	/**
	 * Time complexity : O(L)
	 * Space complexity : O(1)
	 */
	private static Set<String> adj(Set<String> dictionnary, String word) {
		Set<String> adjs = new HashSet<>();

		for (int i = 0; i < word.length(); i++) {
			for (char c = 'A'; c <= 'Z'; c++) {
				if (c != word.charAt(i)) {
					String adj = word.substring(0, i) + c + word.substring(i + 1, word.length());
					if (dictionnary.contains(adj)) {
						adjs.add(adj);
					}
				}
			}
		}

		return adjs;
	}
}