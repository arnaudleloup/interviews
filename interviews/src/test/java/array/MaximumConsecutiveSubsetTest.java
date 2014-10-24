package array;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

public class MaximumConsecutiveSubsetTest {

	@Test
	public void test() {
		int[] a = {5, 1, 9, 3, 8, 20, 4, 10, 2, 11, 3};
		int[] expected = {1, 2, 3, 4, 5};
		int[] actual = MaximumConsecutiveSubset.f(a);
		assertArrayEquals(Arrays.toString(actual), expected, actual);
	}

	@Test
	public void test2() {
		int[] a = {5, 1, 9, 3, 8, 20, 4, 10, 2, 11, 3};
		int[] expected = {1, 2, 3, 4, 5};
		int[] actual = MaximumConsecutiveSubset.f2(a);
		assertArrayEquals(Arrays.toString(actual), expected, actual);
	}

	@Test
	public void test3() {
		int[] a = {3, 8, 15, 22, 5, 7, 99, 9, 0, 4, 78, 18, 6};
		int[] expected = {3, 4, 5, 6, 7, 8, 9};
		int[] actual = MaximumConsecutiveSubset.f2(a);
		assertArrayEquals(Arrays.toString(actual), expected, actual);
	}
}