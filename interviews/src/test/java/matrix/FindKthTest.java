package matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindKthTest {

	@Test
	public void test() {
		int[][] matrix = {
				{1, 2, 3, 4},
				{2, 3, 4, 5},
				{3, 4, 5, 6},
				{4, 5, 6, 7}
		};

		assertEquals(1, FindKth.f(matrix, 0));
		assertEquals(2, FindKth.f(matrix, 1));
		assertEquals(2, FindKth.f(matrix, 2));
		assertEquals(3, FindKth.f(matrix, 3));
		assertEquals(3, FindKth.f(matrix, 4));
		assertEquals(3, FindKth.f(matrix, 5));
		assertEquals(4, FindKth.f(matrix, 6));
		assertEquals(4, FindKth.f(matrix, 7));
		assertEquals(4, FindKth.f(matrix, 8));
		assertEquals(4, FindKth.f(matrix, 9));
		assertEquals(5, FindKth.f(matrix, 10));
		assertEquals(5, FindKth.f(matrix, 11));
		assertEquals(5, FindKth.f(matrix, 12));
		assertEquals(6, FindKth.f(matrix, 13));
		assertEquals(6, FindKth.f(matrix, 14));
		assertEquals(7, FindKth.f(matrix, 15));
	}

	@Test
	public void test2() {
		int[][] matrix = {
				{1, 8, 11, 13},
				{2, 10, 17, 18},
				{3, 16, 18, 19},
				{4, 19, 20, 21}
		};

		assertEquals(1, FindKth.f(matrix, 0));
		assertEquals(2, FindKth.f(matrix, 1));
		assertEquals(3, FindKth.f(matrix, 2));
		assertEquals(4, FindKth.f(matrix, 3));
		assertEquals(8, FindKth.f(matrix, 4));
		assertEquals(10, FindKth.f(matrix, 5));
		assertEquals(11, FindKth.f(matrix, 6));
		assertEquals(13, FindKth.f(matrix, 7));
		assertEquals(16, FindKth.f(matrix, 8));
		assertEquals(17, FindKth.f(matrix, 9));
		assertEquals(18, FindKth.f(matrix, 10));
		assertEquals(18, FindKth.f(matrix, 11));
		assertEquals(19, FindKth.f(matrix, 12));
		assertEquals(19, FindKth.f(matrix, 13));
		assertEquals(20, FindKth.f(matrix, 14));
		assertEquals(21, FindKth.f(matrix, 15));
	}
}