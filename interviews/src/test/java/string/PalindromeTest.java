package string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class PalindromeTest {

	@Test
	public void testIsPalindrome() {
		assertTrue(Palindrome.isPalindrome("abcba"));
		assertTrue(Palindrome.isPalindrome("engagelejeuquejelegagne"));

		assertFalse(Palindrome.isPalindrome("abcb"));
		assertFalse(Palindrome.isPalindrome("xkdih"));
	}

	@Test
	public void testMinPalindrom() {
		assertEquals(Arrays.asList("abcba", "kik"), Palindrome.minPalindromes("abcbakik"));
		assertEquals(Arrays.asList("a", "aba"), Palindrome.minPalindromes("aaba"));
	}

	@Test
	public void testLongestPalindromicSubstring() {
		assertEquals("ghihg", Palindrome.longestPalindromicSubstring("abaefghihgtu"));
		assertEquals("fggf", Palindrome.longestPalindromicSubstring("abaefggfhihgtu"));
		assertEquals("a", Palindrome.longestPalindromicSubstring("abcdefgh"));
	}

	@Test
	public void test() {
		assertEquals(5, Palindrome.f("xyz"));
		assertEquals(7, Palindrome.f("abaxy"));
		assertEquals(9, Palindrome.f("ababaxy"));
	}
}