package array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import array.DuplicatesExceptOne;

public class DuplicatesExceptOneTest {

	@Test
	public void test() {
		int[] t = {3, 2, 3, 4, 2, 5, 3, 2, 5, 5};
		int k = 3;
		int expected = 4;
		assertEquals(expected, DuplicatesExceptOne.f(t, k));
	}

	@Test
	public void test2() {
		int[] t = {1, 1, 1, 1, 1, 1,
				2, 2, 2, 2, 2, 2,
				3,
				4, 4, 4, 4, 4, 4,
				5, 5, 5, 5, 5, 5,
				7, 7, 7, 7, 7, 7};
		int k = 6;
		int expected = 3;
		assertEquals(expected, DuplicatesExceptOne.f(t, k));
	}
}