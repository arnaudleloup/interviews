package number;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class UglyNumbersTest {

	@Test
	public void test() {
		int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14};
		int k = expected.length;
		int[] actual = UglyNumbers.uglyNumbers(k);
		assertTrue(Arrays.toString(actual), Arrays.equals(expected, actual));
	}

	@Test
	public void test1() {
		int[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14,
				15, 16, 18, 20, 21, 24, 25, 27, 28, 30, 32, 35, 36, 40};
		int k = expected.length;
		int[] actual = UglyNumbers.uglyNumbers(k);
		assertTrue(Arrays.toString(actual), Arrays.equals(expected, actual));
	}
}