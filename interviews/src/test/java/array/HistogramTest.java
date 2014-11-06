package array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HistogramTest {

	@Test
	public void test() {
		assertEquals(5, Histogram.f(new int[] {3, 1, 2, 4, 1}));
		assertEquals(5, Histogram.f2(new int[] {3, 1, 2, 4, 1}));
	}

	@Test
	public void test2() {
		assertEquals(20, Histogram.f(new int[] {3, 5, 7, 6, 7, 4, 2, 5, 6, 3}));
		assertEquals(20, Histogram.f2(new int[] {3, 5, 7, 6, 7, 4, 2, 5, 6, 3}));
	}

	@Test
	public void test3() {
		assertEquals(21, Histogram.f(new int[] {3, 5, 7, 7, 7, 4, 2, 5, 6, 3}));
		assertEquals(21, Histogram.f2(new int[] {3, 5, 7, 7, 7, 4, 2, 5, 6, 3}));
	}

	@Test
	public void testAscending() {
		assertEquals(10, Histogram.f(new int[] {3, 5, 7}));
		assertEquals(10, Histogram.f2(new int[] {3, 5, 7}));
	}

	@Test
	public void testDescending() {
		assertEquals(10, Histogram.f(new int[] {7, 5, 3}));
		assertEquals(10, Histogram.f2(new int[] {7, 5, 3}));
	}

	@Test
	public void testPlatform() {
		assertEquals(21, Histogram.f(new int[] {7, 7, 7}));
		assertEquals(21, Histogram.f2(new int[] {7, 7, 7}));
	}
}