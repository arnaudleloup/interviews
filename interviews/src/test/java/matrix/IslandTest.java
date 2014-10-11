package matrix;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IslandTest {

	@Test
	public void test() {
		int[][] A = {
				{0, 0, 0, 0},
				{0, 0, 0, 0},
				{0, 0, 0, 0},
		};
		int expected = 0;
		int actual = Islands.count(A);
		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		int[][] A = {
				{0, 0, 0, 1},
				{1, 1, 0, 0},
				{1, 1, 0, 0},
				{0, 0, 1, 0},
		};
		int expected = 3;
		int actual = Islands.count(A);
		assertEquals(expected, actual);
	}

	@Test
	public void test3() {
		int[][] A = {
				{0, 0, 0, 1},
				{1, 1, 0, 1},
				{1, 1, 0, 1},
				{0, 0, 1, 1},
		};
		int expected = 2;
		int actual = Islands.count(A);
		assertEquals(expected, actual);
	}

	@Test
	public void test4() {
		int[][] A = {
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 1, 1},
		};
		int expected = 1;
		int actual = Islands.count(A);
		assertEquals(expected, actual);
	}
}