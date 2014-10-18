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
}