package exercice;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class TwoArraysMergeTest {


	@Test
	public void test() {
		int[] A = {1, 2, 5, 7, 9, 9, 0, 0, 0, 0};
		int[] B = {1, 4, 5, 8};
		int n = 6;

		TwoArraysMerge.merge(A, B, n);

		System.out.println(Arrays.toString(A));
		for (int i = 0; i < A.length - 1; i++) {
			assertTrue(A[i] <= A[i + 1]);
		}
	}
}