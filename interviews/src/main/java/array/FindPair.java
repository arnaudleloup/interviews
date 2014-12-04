package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import lib.Pair;

/**
 * Write a method to find all pairs of integers within an array
 * which sum to a specified value.
 */
public class FindPair {

	/**
	 * Time complexity: O(n * log(n))
	 * Space complexity: O(1)
	 */
	public static Set<Pair<Integer, Integer>> f(int[] a, int x) {
		Arrays.sort(a);

		Set<Pair<Integer, Integer>> pairs = new HashSet<>();

		int n = a.length;
		int lo = 0;
		int hi = n - 1;
		while (lo <= hi) {
			if (a[lo] + a[hi] < x) {
				lo++;
			} else if (a[lo] + a[hi] == x) {
				pairs.add(new Pair<Integer, Integer>(a[lo++], a[hi--]));
			} else {
				hi--;
			}
		}

		return pairs;
	}

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static Set<Pair<Integer, Integer>> f2(int[] a, int x) {
		Set<Pair<Integer, Integer>> pairs = new HashSet<>();

		Set<Integer> saw = new HashSet<>();
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int v = a[i];
			if (saw.contains(x - v)) {
				pairs.add(new Pair<Integer, Integer>(v, x - v));
			}

			saw.add(v);
		}

		return pairs;
	}
}