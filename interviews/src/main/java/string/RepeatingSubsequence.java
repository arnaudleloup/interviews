package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string (1-d array) , find if there is any sub-sequence that repeats itself.
 * Here, sub-sequence can be a non-contiguous pattern, with the same relative order.
 * Eg:
 * 1. abab <------yes, ab is repeated
 * 2. abba <---- No, a and b follow different order
 * 3. acbdaghfb <-------- yes there is a followed by b at two places
 * 4. abcdacb <----- yes a followed by b twice
 */
public class RepeatingSubsequence {

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static boolean f(String s) {
		int n = s.length();
		int R = 256; // ASCII
		int[] freq = new int[R];
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			freq[c]++;
		}

		int[] intersections = new int[R];
		Set<Character> opened = new HashSet<>();
		int openedCount = 0;
		int closedCount = 0;

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (opened.contains(c)) { // we close old one
				intersections[c] += openedCount - closedCount - 1;
				if (intersections[c] > 0) {
					return true;
				}

				closedCount++;
			}

			freq[c]--;
			if (freq[c] > 0) { // we open new one
				opened.add(c);
				intersections[c] -= openedCount;
				openedCount++;
			}

		}

		return false;
	}
}