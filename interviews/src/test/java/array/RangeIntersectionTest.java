package array;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class RangeIntersectionTest {

	@Test
	public void test() {
		int[][] ranges = {
				{1, 4},
				{2, 6},
				{5, 7}
		};

		int[] expected = {2, 6};
		int[] actual = RangeIntersection.f(ranges);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test2() {
		int[][] ranges = {
				{1, 4},
				{15, 25},
				{5, 7},
		};

		int[] expected = {1, 4};
		int[] actual = RangeIntersection.f(ranges);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test3() {
		int[][] ranges = {
				{1, 25},
				{3, 9},
				{2, 8},
				{12, 30}
		};

		int[] expected = {1, 25};
		int[] actual = RangeIntersection.f(ranges);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void test4() {
		int[][] ranges = {
				{26, 27},
				{1, 3},
				{2, 7},
				{22, 24},
				{8, 10},
				{19, 20},
				{9, 15},
				{12, 30},
				{28, 200},
				{17, 29},
				{23, 25},
				{13, 15},
		};

		int[] expected = {12, 30};
		int[] actual = RangeIntersection.f(ranges);
		assertArrayEquals(expected, actual);
	}
}