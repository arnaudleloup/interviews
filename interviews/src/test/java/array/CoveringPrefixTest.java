package array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CoveringPrefixTest {

	@Test
	public void testEmpty() {
		int[] a = {};
		int expected = -1;
		int actual = CoveringPrefix.f(a);
		assertEquals(expected, actual);
	}

	@Test
	public void testAll() {
		int[] a = {1, 2, 3};
		int expected = 2;
		int actual = CoveringPrefix.f(a);
		assertEquals(expected, actual);
	}

	@Test
	public void test() {
		int[] a = {1, 2, 3, 2, 1};
		int expected = 2;
		int actual = CoveringPrefix.f(a);
		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		int[] a = {1, 8, 15, 6, 8, 2, 4, 8, 1, 15};
		int expected = 6;
		int actual = CoveringPrefix.f(a);
		assertEquals(expected, actual);
	}
}