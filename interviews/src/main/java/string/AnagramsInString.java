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

	/**
	 * Rabin-Karpe implementation.
	 * Time complexity: O(n + m)
	 * Space complexity: O(1)
	 */
	public static boolean f2(String s, String sub) {
		int n = s.length();
		int m = sub.length();
		int v = initHash(sub, m);
		int h = initHash(s, m);
		if (h == v) {
			return true;
		}

		for (int i = m; i < n; i++) {
			h = removeHash(h, s.charAt(i - m));
			h = addHash(h, s.charAt(i));
			if (h == v) {
				return true;
			}
		}

		return false;
	}

	private static Map<Character, Integer> hash = new HashMap<>();
	static {
		hash.put('a', 2);
		hash.put('b', 3);
		hash.put('c', 5);
		hash.put('d', 7);
		hash.put('e', 11);
		hash.put('f', 13);
		hash.put('g', 17);
		hash.put('h', 19);
	}

	private static int initHash(String s, int n) {
		int h = 1;

		for (int i = 0; i < n; i++) {
			h *= hash.get(s.charAt(i));
		}

		return h;
	}

	private static int removeHash(int h, char c) {
		return h / hash.get(c);
	}

	private static int addHash(int h, char c) {
		return h * hash.get(c);
	}
}