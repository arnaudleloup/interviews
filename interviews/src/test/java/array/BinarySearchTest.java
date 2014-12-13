package array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void test() {
		int[] a = {0, 5, 8, 9, 12, 15, 20, 22};

		assertEquals(0, BinarySearch.f(a, a[0]));
		assertEquals(1, BinarySearch.f(a, a[1]));
		assertEquals(2, BinarySearch.f(a, a[2]));
		assertEquals(3, BinarySearch.f(a, a[3]));
		assertEquals(4, BinarySearch.f(a, a[4]));
		assertEquals(5, BinarySearch.f(a, a[5]));
		assertEquals(6, BinarySearch.f(a, a[6]));
		assertEquals(7, BinarySearch.f(a, a[7]));

		assertEquals(-7, BinarySearch.f(a, 17));
		assertEquals(-9, BinarySearch.f(a, 25));
		assertEquals(-2, BinarySearch.f(a, 2));
		assertEquals(-1, BinarySearch.f(a, -1));
	}
}