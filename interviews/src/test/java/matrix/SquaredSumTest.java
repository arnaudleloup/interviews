package matrix;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class SquaredSumTest {

	@Test
	public void test() {
		int[][] A = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16},
				{17, 18, 19, 20}
		};

		int[][] expected = {
				{1, 3, 6, 10},
				{6, 14, 24, 36},
				{15, 33, 54, 78},
				{28, 60, 96, 136},
				{45, 95, 150, 210}
		};

		SquaredSum.f(A);
		for (int i = 0; i < A.length; i++) {
			assertTrue(Arrays.toString(A[i]), Arrays.equals(A[i], expected[i]));
		}
	}
}