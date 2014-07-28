package string;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class SubstringReversalTest {

	@Test
	public void test0() {
		String S = "abdc";
		int[] expected = {2, 3};
		int[] actual = SubstringReversal.solve(S);
		assertTrue(Arrays.toString(actual), Arrays.equals(expected, actual));
	}

	@Test
	public void test1() {
		String S = "aabbcc";
		int[] expected = {0, 0};
		int[] actual = SubstringReversal.solve(S);
		assertTrue(Arrays.toString(actual), Arrays.equals(expected, actual));
	}

	@Test
	public void test2() {
		String S = "misof";
		int[] expected = {0, 4};
		int[] actual = SubstringReversal.solve(S);
		assertTrue(Arrays.toString(actual), Arrays.equals(expected, actual));
	}

	@Test
	public void test3() {
		String S = "ivan";
		int[] expected = {0, 2};
		int[] actual = SubstringReversal.solve(S);
		assertTrue(Arrays.toString(actual), Arrays.equals(expected, actual));
	}

	@Test
	public void test4() {
		String S = "thisseemstobeaneasyproblem";
		int[] expected = {0, 13};
		int[] actual = SubstringReversal.solve(S);
		assertTrue(Arrays.toString(actual), Arrays.equals(expected, actual));
	}

	@Test
	public void test5() {
		String S = "abcdcd";
		int[] expected = {3, 4};
		int[] actual = SubstringReversal.solve(S);
		assertTrue(Arrays.toString(actual), Arrays.equals(expected, actual));
	}


}