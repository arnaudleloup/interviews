package array;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Prints all permutations of an array.
 */
public class Permutater {

	/**
	 * Prints all permutations of an array and returns the number of permutations.
	 * 
	 * Time complexity: O(n!)
	 * Space complexity: O(1)
	 */
	public static int f(int[] a) {
		AtomicInteger count = new AtomicInteger();
		dfs(a, 0, count);
		return count.intValue();
	}

	private static void dfs(int[] a, int i, AtomicInteger count) {
		if (i == a.length) {
			System.out.println(Arrays.toString(a));
			count.incrementAndGet();
		}

		for (int j = i; j < a.length; j++) {
			swap(a, i, j);
			dfs(a, i + 1, count);
			swap(a, i, j);
		}
	}

	/**
	 * Returns the number of permutations of an array, respecting the following rule:
	 * two elements can be permuted if the sum of their value is lesser than or equals k.
	 * 
	 * Time complexity: O(n!)
	 * Space complexity: O(1)
	 */
	public static int f2(int[] a, int k) {
		AtomicInteger count = new AtomicInteger();
		dfs(a, 0, k, count);
		return count.intValue();
	}

	private static void dfs(int[] a, int i, int k, AtomicInteger count) {
		if (i == a.length) {
			count.incrementAndGet();
			return;
		}

		boolean hasChanged = false;
		for (int j = i; j < a.length; j++) {
			if (a[i] + a[j] <= k) {
				swap(a, i, j);
				dfs(a, i + 1, k, count);
				swap(a, i, j);
				hasChanged = true;
			}
		}

		if (!hasChanged) {
			count.incrementAndGet();
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
