package array;

import java.util.Random;

/**
 * Find the k-th element in an unsorted array.
 */
public class FindKth {

	/**
	 * Quick select based implementation.
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	public static int f(int[] a, int k) {
		shuffle(a);

		int lo = 0;
		int hi = a.length - 1;
		int m = -1;
		while (m != k) {
			m = partition(a, lo, hi);
			if (m < k) {
				lo = m + 1;
			} else if (m > k) {
				hi = m - 1;
			}
		}

		return a[k];
	}

	private static int partition(int[] a, int lo, int hi) {
		int p = hi; // pivot
		int firstHigh = lo;
		for (int i = lo; i <= hi; i++) {
			if (a[i] < a[p]) {
				swap(a, i, firstHigh++);
			}
		}

		swap(a, firstHigh, p);
		return firstHigh;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void shuffle(int[] a) {
		Random r = new Random();
		for (int i = a.length - 1; i >= 0; i--) {
			int j = r.nextInt(i + 1);
			swap(a, i, j);
		}
	}
}