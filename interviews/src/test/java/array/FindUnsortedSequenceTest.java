package array;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import array.FindUnsortedSequence;

public class FindUnsortedSequenceTest {

	@Test
	public void test() {
		int[] t = {1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19};
		int[] expected = {3, 9};
		int[] actual = FindUnsortedSequence.f(t);
		assertTrue(Arrays.toString(actual), Arrays.equals(expected, actual));
	}

	@Test
	public void test2() {
		int[] t = {1, 2, 4, 7, 10, 11};
		int[] expected = {-1, -1};
		int[] actual = FindUnsortedSequence.f(t);
		assertTrue(Arrays.toString(actual), Arrays.equals(expected, actual));
	}
}