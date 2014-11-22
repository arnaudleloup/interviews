package array;

import java.util.Random;

/**
 * Find the k-th element in an unsorted array.
 */
public class FindKth {

	/**
	 * Quick select based implementation.
	 * O(n) / O(1)
	 */
	public static int f(int[] a, int k) {
		shuffle(a);
		select(a, 0, a.length - 1, k);
		return a[k];
	}

	private static void select(int[] a, int lo, int hi, int k) {
		int i = partition(a, lo, hi);

		if (i < k) {
			select(a, i + 1, hi, k);
		} else if (i == k) {
			return;
		} else {
			select(a, lo, i - 1, k);
		}
	}

	private static int partition(int[] a, int lo, int hi) {
		int p = hi;
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
		for (int i = a.length - 1; i > 0; i--) {
			int j = r.nextInt(i + 1);
			swap(a, i, j);
		}
	}
}