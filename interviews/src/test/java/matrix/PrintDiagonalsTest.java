package matrix;

import org.junit.Test;

public class PrintDiagonalsTest {

	@Test
	public void test() {
		int[][] A = {
				{1,		2,		3,		4},
				{5,		6,		7,		8},
				{9,		10,		11,		12},
				{13,	14,		15,		16}
		};

		PrintDiagonals.f(A);
	}

	@Test
	public void test2() {
		int[][] A = {
				{1,		2,		3,		4},
				{5,		6,		7,		8},
				{9,		10,		11,		12}
		};

		PrintDiagonals.f(A);
	}

	@Test
	public void test3() {
		int[][] A = {
				{1,		2,		3,		4, 		41,		42},
				{5,		6,		7,		8,		81, 	82},
				{9,		10,		11,		12,		121, 	122}
		};

		PrintDiagonals.f(A);
	}

	@Test
	public void test4() {
		int[][] A = {
				{1,		2,		3},
				{5,		6,		7},
				{9,		10,		11},
				{13,	14,		15}
		};

		PrintDiagonals.f(A);
	}

	@Test
	public void test5() {
		int[][] A = {
				{1,		2,		3},
				{5,		6,		7},
				{9,		10,		11},
				{13,	14,		15},
				{16,	17,		18},
				{19,	20,		21},
				{22,	23,		24},
				{25,	26,		27},
		};

		PrintDiagonals.f(A);
	}
}