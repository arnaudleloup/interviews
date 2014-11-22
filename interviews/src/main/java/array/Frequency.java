package array;

import java.util.ArrayList;
import java.util.List;

import lib.Pair;

/**
 * You have a sorted array containing the age of every person on Earth.
 * [0, 0, 0, 0, ..., 1, 1, ..., 28, 28, ..., 110, ...]
 * Find out how many people have each age.
 */
public class Frequency {

	/**
	 * n = a.length
	 * k = number of different values
	 * Time complexity: O(k * log(n))
	 * Space complexity: O(1)
	 */
	public static List<Pair<Integer, Integer>> f(int[] a) {
		int n = a.length;
		List<Pair<Integer, Integer>> freqs = new ArrayList<>();

		int i = 0;
		int acc = 0;
		while (i < n) {
			int index = binarySearch(a, 0, n - 1, a[i]);
			int freq = index + 1 - acc;
			freqs.add(new Pair<Integer, Integer>(a[i], freq));
			acc += freq;
			i = index + 1;
		}

		return freqs;
	}

	private static int binarySearch(int[] a, int lo, int hi, int v) {
		if (a[lo] == v && (lo == a.length - 1 || a[lo + 1] > v)) {
			return lo;
		}

		if (a[hi] == v && (hi == a.length - 1 || a[hi + 1] > v)) {
			return hi;
		}

		int mid = lo + (hi - lo) / 2;
		if (a[mid] <= v) {
			return binarySearch(a, mid, hi, v);
		} else {
			return binarySearch(a, lo, mid, v);
		}
	}
}