package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings a and b, find whether any anagram of string a is a sub-string of string b.
 *
 * For example, given: a = xyz, b = xyazyfdgzyxksldfm then there is a match at index 8.
 */
public class AnagramsInString {

	/**
	 * Time complexity: O(n + m)
	 * Space complexity: O(m)
	 */
	public static boolean f(String s, String sub) {
		int n = s.length();
		int m = sub.length();

		Map<Character, Integer> fr = new HashMap<>();
		for (char c : sub.toCharArray()) {
			if (!fr.containsKey(c)) {
				fr.put(c, 0);
			}

			fr.put(c, fr.get(c) + 1);
		}

		int i = 0;
		while(i < n - m) {
			char c = s.charAt(i);
			if (!fr.containsKey(c)) {
				i++;
				continue;
			}

			int j = i;
			Map<Character, Integer> temp = new HashMap<>(fr);
			while (j < i + m) {
				char d = s.charAt(j);
				if (!temp.containsKey(d)) {
					i = j + 1;
					break;
				}

				if (temp.get(d) == 1) {
					temp.remove(d);
				} else {
					temp.put(d, temp.get(d) - 1);
				}

				j++;
			}

			if (j == i + m) {
				return true;
			}
		}

		return false;
	}
}