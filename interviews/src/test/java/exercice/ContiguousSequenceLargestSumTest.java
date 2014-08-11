package exercice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ContiguousSequenceLargestSumTest {

	@Test
	public void test() {
		int[] t = {2, -8, 3, -2, 4, -10};
		int expected = 5;
		int actual = ContiguousSequenceLargestSum.f(t);
		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		int[] t = {-3, -4, -2, -3, -8};
		int expected = -2;
		int actual = ContiguousSequenceLargestSum.f(t);
		assertEquals(expected, actual);
	}

}