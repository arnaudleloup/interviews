package array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import array.MinQueryRange.Option;

public class MinQueryRangeTest {

	@Test
	public void testMatrix() {
		int[] a = {2, 5, 8, 4, 2, 1, 7, 4, 9, 3};
		MinQueryRange matrix = new MinQueryRange(a, Option.MATRIX);
		assertEquals(1, matrix.min(0, 9));
		assertEquals(1, matrix.min(2, 7));
		assertEquals(4, matrix.min(6, 8));
		assertEquals(2, matrix.min(1, 4));
		assertEquals(4, matrix.min(3, 3));
	}

	@Test
	public void testTree() {
		int[] a = {2, 5, 8, 4, 2, 1, 7, 4, 9, 3};
		MinQueryRange matrix = new MinQueryRange(a, Option.TREE);
		assertEquals(1, matrix.min(0, 9));
		assertEquals(1, matrix.min(2, 7));
		assertEquals(4, matrix.min(6, 8));
		assertEquals(2, matrix.min(1, 4));
		assertEquals(4, matrix.min(3, 3));
	}

	@Test
	public void testPowerOfTwo() {
		int[] a = {2, 5, 8, 4, 2, 1, 7, 4, 9, 3};
		MinQueryRange matrix = new MinQueryRange(a, Option.POWER_OF_2);
		assertEquals(1, matrix.min(0, 9));
		assertEquals(1, matrix.min(2, 7));
		assertEquals(4, matrix.min(6, 8));
		assertEquals(2, matrix.min(1, 4));
		assertEquals(4, matrix.min(3, 3));
	}
}