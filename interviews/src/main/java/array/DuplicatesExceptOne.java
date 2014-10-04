package array;

import java.util.Random;

/**
 * Given an array of integers where every element appears k > 1 times except for one that appears
 * once, find that unique element.
 */
public class DuplicatesExceptOne {

	/**
	 * Quick select based implementation.
	 * O(n) / O(1)
	 */
	public static int f(int[] t, int k) {
		shuffle(t);

		int lo = 0;
		int hi = t.length - 1;

		while (true) {
			int p = partition(t, lo, hi);

			if (p % k == 0) {
				// If p = q * k then all elements before p
				// are k duplicates.
				// t[p] is unique or a k duplicate too
				if (isUnique(t, p, hi)) { // O(hi -lo) / O(1)
					return t[p];
				} else {
					// if t[p] is a k duplicate
					// we partition all its duplicates
					lo = partitionDuplicates(t, p, hi); // O(hi - lo) / O(1)
				}
			} else {
				// Here p = q * k + 1.
				// This means the unique element is before p.
				hi = p - 1;
			}
		}
	}

	private static boolean isUnique(int[] t, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++) {
			if (t[i] == t[lo]) {
				return false;
			}
		}

		return true;
	}

	private static int partition(int[] t, int lo, int hi) {
		int p = hi;
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

	private static int partitionDuplicates(int[] t, int p, int hi) {
		int firstHigh = p + 1;

		for (int i = p + 1; i <= hi; i++) {
			if (t[i] == t[p]) {
				swap(t, firstHigh, i);
				firstHigh++;
			}
		}

		return firstHigh;
	}

	private static void shuffle(int[] t) {
		Random random = new Random();
		for (int i = 0; i < t.length - 1; i++) {
			int r = random.nextInt(t.length);
			swap(t, i, r);
		}
	}

	private static void swap(int[] t, int i, int j) {
		int temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}
}