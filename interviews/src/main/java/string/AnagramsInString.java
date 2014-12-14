package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings a and b, find whether any anagram of string a is a sub-string of string b.
 *
 * For example, given: a = xyz, b = xyazyfdgzyxksldfm then there is a match at index 8.
 */
public class AnagramsInString {

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

	/**
	 * Rabin Karp implementation
	 * 
	 * Time complexity: O(n + m)
	 * Space complexity: O(1)
	 */
	public static int f(String s, String pat) {
		int n = s.length();
		int m = pat.length();

		int patHash = 1;
		for (int i = 0; i < m; i++) {
			patHash *= hash.get(pat.charAt(i));
		}

		int sHash = 1;
		for (int i = 0; i < m; i++) {
			sHash *= hash.get(s.charAt(i));
		}

		if (sHash == patHash) {
			return 0;
		}

		for (int i = m; i < n; i++) {
			sHash /= hash.get(s.charAt(i - m));
			sHash *= hash.get(s.charAt(i));
			if (sHash == patHash) {
				return i - m + 1;
			}
		}

		return n;
	}
}