package array;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class SignSortTest {

	@Test
	public void test() {
		int[] a = {2, -4, 3, -2, -4, 4, 2};
		int[] expected = {-4, -2, -4, 2, 3, 4, 2};
		SignSort.f(a);
		System.out.println(Arrays.toString(a));
		assertTrue(Arrays.equals(expected, a));
	}

	@Test
	public void test2() {
		int[] a = {10, -20, 11, 5, -15, -16, 6, 3, -7};
		int[] expected = {-20, -15, -16, -7, 10, 11, 5, 6, 3};
		SignSort.f(a);
		assertTrue(Arrays.equals(expected, a));
	}


	@Test
	public void testAllNegative() {
		int[] a = {-1, -2, -4, -3, -2, -4};
		SignSort.f(a);
		int[] expected = {-1, -2, -4, -3, -2, -4};
		assertTrue(Arrays.toString(a), Arrays.equals(expected, a));
	}

	@Test
	public void testAllPositive() {
		int[] a = {1, 2, 4, 3, 2, 4};
		SignSort.f(a);
		int[] expected = {1, 2, 4, 3, 2, 4};
		assertTrue(Arrays.toString(a), Arrays.equals(expected, a));
	}
}