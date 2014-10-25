package matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SubSquareTest {

	@Test
	public void test() {
		int[][] matrix = {
				{0, 1, 0, 1, 1, 0},
				{0, 1, 1, 1, 1, 0},
				{0, 1, 0, 1, 1, 0},
				{0, 1, 1, 0, 1, 0},
				{0, 1, 1, 1, 1, 0},
				{0, 1, 1, 0, 0, 0}
		};

		assertEquals(4, SubSquare.f(matrix));
	}

	@Test
	public void test2() {
		int[][] matrix = {
				{0, 1, 0, 1, 1, 0},
				{0, 1, 1, 1, 1, 0},
				{0, 1, 0, 1, 1, 0},
				{0, 0, 1, 0, 1, 0},
				{0, 1, 1, 1, 1, 0},
				{0, 1, 1, 0, 0, 0}
		};

		assertEquals(0, SubSquare.f(matrix));
	}

	@Test
	public void test3() {
		int[][] matrix = {
				{0, 1, 0, 1, 1, 0},
				{0, 1, 1, 1, 1, 0},
				{0, 1, 0, 1, 1, 0},
				{0, 0, 1, 1, 1, 1},
				{0, 1, 1, 1, 1, 1},
				{0, 1, 1, 1, 1, 1}
		};

		assertEquals(1, SubSquare.f(matrix));
	}

}