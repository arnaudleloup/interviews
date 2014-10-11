package array;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class RotationTest {

	@Test
	public void test() {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int d = 3;
		int[] expected = {5, 6, 7, 1, 2, 3, 4};

		Rotation.rotate(a, d);
		assertTrue(Arrays.equals(expected, a));
	}

	@Test
	public void test2() {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int d = 2;
		int[] expected = {6, 7, 1, 2, 3, 4, 5};

		Rotation.rotate(a, d);
		assertTrue(Arrays.equals(expected, a));
	}

	@Test
	public void test3() {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int d = 8;
		int[] expected = {7, 1, 2, 3, 4, 5, 6};

		Rotation.rotate(a, d);
		assertTrue(Arrays.equals(expected, a));
	}

	@Test
	public void test4() {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int d = -8;
		int[] expected = {2, 3, 4, 5, 6, 7, 1};

		Rotation.rotate(a, d);
		assertTrue(Arrays.equals(expected, a));
	}

	@Test
	public void test5() {
		int[] a = {2, 3, 4, 5, 6};
		int d = 3;
		int[] expected = {4, 5, 6, 2, 3};

		Rotation.rotate(a, d);
		assertTrue(Arrays.equals(expected, a));
	}

	@Test
	public void test6() {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int d = 2;
		int lo = 1;
		int hi = 5;
		int[] expected = {1, 5, 6, 2, 3, 4, 7};

		Rotation.rotate(a, d, lo, hi);
		assertTrue(Arrays.equals(expected, a));
	}
	@Test
	public void test7() {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int d = 3;
		int lo = 1;
		int hi = 5;
		int[] expected = {1, 4, 5, 6, 2, 3, 7};

		Rotation.rotate(a, d, lo, hi);
		assertTrue(Arrays.equals(expected, a));
	}


	@Test
	public void test8() {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int d = 3;
		int[] expected = {5, 6, 7, 1, 2, 3, 4};

		Rotation.rotate2(a, d);
		assertTrue(Arrays.equals(expected, a));
	}

	@Test
	public void test9() {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int d = 2;
		int[] expected = {6, 7, 1, 2, 3, 4, 5};

		Rotation.rotate2(a, d);
		assertTrue(Arrays.equals(expected, a));
	}

	@Test
	public void test10() {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int d = 8;
		int[] expected = {7, 1, 2, 3, 4, 5, 6};

		Rotation.rotate2(a, d);
		assertTrue(Arrays.equals(expected, a));
	}

	@Test
	public void test11() {
		int[] a = {1, 2, 3, 4, 5, 6, 7};
		int d = -8;
		int[] expected = {2, 3, 4, 5, 6, 7, 1};

		Rotation.rotate2(a, d);
		assertTrue(Arrays.equals(expected, a));
	}

	@Test
	public void test12() {
		int[] a = {2, 3, 4, 5, 6};
		int d = 3;
		int[] expected = {4, 5, 6, 2, 3};

		Rotation.rotate2(a, d);
		assertTrue(Arrays.equals(expected, a));
	}
}