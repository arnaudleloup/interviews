package exercice;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class NegativeFirstTest {

	@Test
	public void test() {
		int[] t = {1, -2, 4, -3, -2, 5};
		NegativeFirst.f(t);
		int[] expected = {-2, -3, -2, 1, 4, 5};
		assertTrue(Arrays.toString(t), Arrays.equals(expected, t));
	}

	@Test
	public void testAllNegative() {
		int[] t = {-1, -2, -4, -3, -2, -4};
		NegativeFirst.f(t);
		int[] expected = {-1, -2, -4, -3, -2, -4};
		assertTrue(Arrays.toString(t), Arrays.equals(expected, t));
	}

	@Test
	public void testAllPositive() {
		int[] t = {1, 2, 4, 3, 2, 4};
		NegativeFirst.f(t);
		int[] expected = {1, 2, 4, 3, 2, 4};
		assertTrue(Arrays.toString(t), Arrays.equals(expected, t));
	}

	@Test
	public void test2() {
		int[] t = {1, 2, -4, 3};
		NegativeFirst.f(t);
		int[] expected = {-4, 1, 2, 3};
		assertTrue(Arrays.toString(t), Arrays.equals(expected, t));
	}

	@Test
	public void test3() {
		int[] t = {10, -20, 11, 5, -15, -16, 6, 3, -7};
		NegativeFirst.f(t);
		int[] expected = {-20, -15, -16, -7, 10, 11, 5, 6, 3};
		assertTrue(Arrays.toString(t), Arrays.equals(expected, t));
	}


}