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
	public static int f(int[] t, int k) {
		shuffle(t);

		int p = -2;
		int lo = 0;
		int hi = t.length - 1;

		while (p  + 1 != k) {
			p = partition(t, lo, hi);
			if (p + 1 < k) {
				lo = p + 1;
			} else if (p + 1 > k) {
				hi = p - 1;
			}
		}

		return t[p];
	}

	private static int partition(int[] t, int lo, int hi) {
		int p = hi; // pivot
		int firstHigh = lo;
		for (int i = lo; i <= hi; i++) {
			if (t[i] < t[p]) {
				swap(t, firstHigh, i);
				firstHigh++;
			}
		}

		swap(t, firstHigh, p);
		return firstHigh;
	}

	private static void swap(int[] t, int i, int j) {
		int temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}

	private static void shuffle(int[] t) {
		Random random = new Random();
		for (int i = t.length - 1; i >= 0; i--) {
			int r = random.nextInt(i);
			swap(t, i, r);
		}
	}
}