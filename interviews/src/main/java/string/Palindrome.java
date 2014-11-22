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
		return isPalindrome(s, 0, s.length() - 1);
	}

	private static boolean isPalindrome(String s, int lo, int hi) {
		int i = lo;
		int j = hi;

		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				return false;
			}
		}

		return true;
	}

	/**
	 * Given a string S, you are allowed to convert it to a palindrome by adding 0 or more characters
	 * in front of it.
	 * Find the length of the shortest palindrome
	 * that you can create from S by applying the above transformation.
	 * 
	 * n = s.length()
	 * Time complexity: O(n^2)
	 * Space complexity: O(1)
	 */
	public static int f(String s) {
		int n = s.length();
		int index = 0;

		for (int i = 0; i < n; i++) {
			if (isPalindrome(s, 0, i)) {
				index = i;
			}
		}

		return 2 * n - index - 1;
	}

	/**
	 * Returns the longest palindromic substring.
	 * 
	 * Time complexity: O(n^2)
	 * Space complexity: O(1)
	 */
	public static String longestPalindromicSubstring(String s) {
		int n = s.length();
		String longest = new String();

		for (int i = 0; i < n; i++) {
			String pal1 = expandAroundCenter(s, i, i);
			if (pal1.length() > longest.length()) {
				longest = pal1;
			}

			if (i < n - 1) {
				String pal2 = expandAroundCenter(s, i, i + 1);
				if (pal2.length() > longest.length()) {
					longest = pal2;
				}
			}
		}

		return longest;
	}

	private static String expandAroundCenter(String s, int left, int right) {
		while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}

		return s.substring(left + 1, right);
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