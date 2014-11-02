package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Palindrome {

	/**
	 * Returns true if s is a palindrome, returns false otherwise.
	 * 
	 * Time complexity : O(n)
	 * Space complexity : O(1)
	 */
	public static boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Returns the minimal number of strings such that each string is a palindrome
	 * and the concatenation of the strings is s.
	 */
	public static List<String> minPalindromes(String s) {
		List<String> leftToRight = palindromes(s);
		List<String> rightToLeft = palindromes(flip(s));

		if (leftToRight.size() < rightToLeft.size()) {
			return leftToRight;
		} else {
			Collections.reverse(rightToLeft);
			return rightToLeft;
		}
	}

	private static List<String> palindromes(String s) {
		int n = s.length();
		int lastIndex = 0;
		List<String> palindromes = new ArrayList<>();

		while (lastIndex < n) {
			int nextIndex = lastIndex + 1;
			for (int i = lastIndex + 1; i <= n; i++) {
				if (isPalindrome(s.substring(lastIndex, i))) {
					nextIndex = i;
				}
			}

			palindromes.add(s.substring(lastIndex, nextIndex));
			lastIndex = nextIndex;
		}

		return palindromes;
	}

	private static String flip(String s) {
		int n = s.length();
		char[] flip = new char[n];

		int i = 0;
		int j = n - 1;
		while (i <= j) {
			flip[i] = s.charAt(j);
			flip[j--] = s.charAt(i++);
		}

		return new String(flip);
	}
}