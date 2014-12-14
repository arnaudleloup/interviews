package string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AnagramsInStringTest {

	@Test
	public void test() {
		assertEquals(0, AnagramsInString.f("ababcbaba", "baba"));
		assertEquals(1, AnagramsInString.f("ababcbaba", "cbbba"));
		assertEquals(9, AnagramsInString.f("ababcbaba", "cbaa"));
		assertEquals(9, AnagramsInString.f("ababcbaba", "cbad"));
		assertEquals(4, AnagramsInString.f("cccaababccc", "baba"));
	}
}