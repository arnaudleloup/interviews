package string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import string.LongestPrefix;

public class LongestPrefixTest {

	@Test
	public void test() {
		String s = "abcdef abcdxxx abcdabcdef abcyy";
		String expected = "abc";
		assertEquals(expected, LongestPrefix.f(s));
	}
}