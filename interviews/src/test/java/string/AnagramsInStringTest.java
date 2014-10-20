package string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnagramsInStringTest {

	@Test
	public void test() {
		String s = "ababcbaba";
		String sub = "baba";
		boolean expected = true;
		boolean actual = AnagramsInString.f(s, sub);
		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		String s = "ababcbaba";
		String sub = "cbbba";
		boolean expected = true;
		boolean actual = AnagramsInString.f(s, sub);
		assertEquals(expected, actual);
	}

	@Test
	public void test3() {
		String s = "ababcbaba";
		String sub = "cbaa";
		boolean expected = false;
		boolean actual = AnagramsInString.f(s, sub);
		assertEquals(expected, actual);
	}

	@Test
	public void test4() {
		String s = "ababcbaba";
		String sub = "cbad";
		boolean expected = false;
		boolean actual = AnagramsInString.f(s, sub);
		assertEquals(expected, actual);
	}
}