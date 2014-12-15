package string;

import java.util.ArrayDeque;
import java.util.ArrayList;
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
	 * L = average word length
	 * Time complexity: O(n * L)
	 * Space complexity: O(n)
	 */
	public static List<String> f(Set<String> dictionary, String start, String end) {
		Map<String, String> parent = new HashMap<>();
		parent.put(start, null);
		Set<String> frontier = new HashSet<>();
		frontier.add(start);
		boolean endReached = false;

		while (!frontier.isEmpty() && !endReached) {
			Set<String> next = new HashSet<>();

			for (String s : frontier) {
				for (String t : adj(dictionary, s)) {
					if (!parent.containsKey(t)) {
						parent.put(t, s);
						next.add(t);
					}

					if (t.equals(end)) {
						endReached = true;
						break;
					}
				}

				if (endReached) {
					break;
				}
			}

			frontier = next;
		}

		if (!parent.containsKey(end)) {
			return new ArrayList<String>();
		}

		Deque<String> stack = new ArrayDeque<>();
		String current = end;
		while (current != null) {
			stack.addLast(current);
			current = parent.get(current);
		}

		List<String> ret = new ArrayList<>();
		while (!stack.isEmpty()) {
			ret.add(stack.pollLast());
		}

		return ret;
	}

	/**
	 * Time complexity : O(L)
	 * Space complexity : O(1)
	 */
	private static Set<String> adj(Set<String> dictionary, String s) {
		Set<String>  adjs = new HashSet<>();

		for (int i = 0; i < s.length(); i++) {
			for (char c = 0; c < 256; c++) { // ASCII
				String t = s.substring(0, i) + c + s.substring(i + 1, s.length());
				if (dictionary.contains(t)) {
					adjs.add(t);
				}
			}
		}

		return adjs;
	}
}