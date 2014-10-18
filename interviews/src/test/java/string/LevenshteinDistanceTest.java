package string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LevenshteinDistanceTest {

	@Test
	public void test() {
		String s1 = "a";
		String s2 = "b";
		int expected = 1;
		int actual = LevenshteinDistance.d(s1, s2);
		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		String s1 = "abcd";
		String s2 = "defgpo";
		int expected = 6;
		int actual = LevenshteinDistance.d(s1, s2);
		assertEquals(expected, actual);
	}

	@Test
	public void test3() {
		String s1 = "teast";
		String s2 = "test";
		int expected = 1;
		int actual = LevenshteinDistance.d(s1, s2);
		assertEquals(expected, actual);
	}

	@Test
	public void test4() {
		String s1 = "bcdefgha";
		String s2 = "abcdefgh";
		int expected = 2;
		int actual = LevenshteinDistance.d(s1, s2);
		assertEquals(expected, actual);
	}

	@Test
	public void test5() {
		String s1 = "abcdefgh";
		String s2 = "abcegh";
		int expected = 2;
		int actual = LevenshteinDistance.d(s1, s2);
		assertEquals(expected, actual);
	}

	@Test
	public void test6() {
		String s1 = "abcdefgh";
		String s2 = "abcueogh";
		int expected = 2;
		int actual = LevenshteinDistance.d(s1, s2);
		assertEquals(expected, actual);
	}
}