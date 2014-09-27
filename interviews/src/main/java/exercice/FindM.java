package exercice;

import java.util.Arrays;
import java.util.Random;

/**
 * Given an unsorted array of integers of size n,
 * return the maximum possible m such that the array consists
 * at least m values greater than or equals to m.
 * Array can contain duplicate values.
 */
public class FindM {

	/**
	 * O(n log(n)) / O(1)
	 */
	public static int f(int[] t) {
		Arrays.sort(t); // O(n log(n))

		int count = 0;
		int i = t.length - 1;

		while (i >= 0 && t[i] >= count + 1) { // O(n)
			count++;
			i--;
		}

		return count;
	}

	/**
	 * O(n) / O(n)
	 */
	public static int f2(int[] t) {
		int n = t.length;
		// values frequency
		int[] fr = new int[n + 1]; // O(n) space

		for (int i : t) { // O(n) time
			if (i > n) {
				fr[n]++;
			} else {
				fr[i]++;
			}
		}

		int m = 0;
		int count = 0;
		for (int i = n; i > 0; i--) { // O(n) time
			count += fr[i];
			if (count >= i) {
				m = i;
				break;
			}
		}

		return m;
	}

	/**
	 * Quick select based implementation.
	 * O(n) / O(1)
	 */
	public static int f3(int[] t) {
		shuffle(t);

		if (t.length == 0) {
			return 0;
		}

		int lo = 0;
		int hi = t.length - 1;
		while (hi > lo) {
			int p = partition(t, lo, hi);
			if (t[p] < t.length - 1 - p) {
				lo = p;
			} else {
				hi = p - 1;
			}
		}

		if (lo == t.length - 1) {
			return t[lo];
		}

		int m = t[lo];
		int next = FindKth.f(t, lo + 2);
		if (next == m) {
			return m;
		}

		return t.length - 1 - lo;
	}

	private static int partition(int[] t, int lo, int hi) {
		int p = hi; //pivot
		int firstHigh = lo;
		for (int i = lo; i < hi; i++) {
			if (t[i] <= t[p]) {
				swap(t, firstHigh, i);
				firstHigh++;
			}
		}

		swap(t, firstHigh, p);
		return firstHigh;
	}

	private static void shuffle(int[] t) {
		Random random = new Random();

		for (int i = 0; i < t.length; i++) {
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