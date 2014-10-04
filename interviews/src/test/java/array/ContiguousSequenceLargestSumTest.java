package array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import array.ContiguousSequenceLargestSum;

public class ContiguousSequenceLargestSumTest {

	@Test
	public void test() {
		int[] t = {2, -8, 3, -2, 4, -10};
		int expected = 5;
		int actual1 = ContiguousSequenceLargestSum.f(t);
		int actual2 = ContiguousSequenceLargestSum.f2(t);
		assertEquals(actual1, actual2);
		assertEquals(expected, actual1);
	}

	@Test
	public void test2() {
		int[] t = {-3, -4, -2, -3, -8};
		int expected = -2;
		int actual1 = ContiguousSequenceLargestSum.f(t);
		int actual2 = ContiguousSequenceLargestSum.f2(t);
		assertEquals(actual1, actual2);
		assertEquals(expected, actual1);
	}
}