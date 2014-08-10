package number.uglynumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class UglyNumbersTest {

	@Test
	public void test() {
		long[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14};
		int k = expected.length;
		long[] actual = UglyNumbers2.f(k);
		assertTrue(Arrays.toString(actual), Arrays.equals(expected, actual));
	}

	@Test
	public void test1() {
		long[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14,
				15, 16, 18, 20, 21, 24, 25, 27, 28, 30, 32, 35, 36, 40};
		int k = expected.length;
		long[] actual = UglyNumbers2.f(k);
		assertTrue(Arrays.toString(actual), Arrays.equals(expected, actual));
	}

	@Test
	public void test1000() {
		int k = 1000;
		long expected = 385875;
		long[] actual = UglyNumbers2.f(k);
		assertEquals(expected, actual[k - 1]);
	}

	@Test
	public void test10000() {
		int k = 10000;
		long expected = 63221760000L;
		long[] actual = UglyNumbers2.f(k);
		assertEquals(expected, actual[k - 1]);
	}

}