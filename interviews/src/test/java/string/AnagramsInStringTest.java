package string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnagramsInStringTest {

	@Test
	public void test() {
		assertEquals(true, AnagramsInString.f("ababcbaba", "baba"));
		assertEquals(true, AnagramsInString.f("ababcbaba", "cbbba"));
		assertEquals(false, AnagramsInString.f("ababcbaba", "cbaa"));
		assertEquals(false, AnagramsInString.f("ababcbaba", "cbad"));

		assertEquals(true, AnagramsInString.f2("ababcbaba", "baba"));
		assertEquals(true, AnagramsInString.f2("ababcbaba", "cbbba"));
		assertEquals(false, AnagramsInString.f2("ababcbaba", "cbaa"));
		assertEquals(false, AnagramsInString.f2("ababcbaba", "cbad"));
	}
}