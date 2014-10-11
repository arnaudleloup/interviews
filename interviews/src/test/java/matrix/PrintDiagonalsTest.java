package matrix;

import org.junit.Test;

public class PrintDiagonalsTest {

	@Test
	public void test() {
		int[][] A = {
				{1, 2, 3, 4},
				{5, 6, 7, 8},
				{9, 10, 11, 12},
				{13, 14, 15, 16}
		};

		PrintDiagonals.f(A);
	}
}