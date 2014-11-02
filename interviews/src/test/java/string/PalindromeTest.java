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
}