package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Given a set of numbers, find the longest subset with consecutive numbers.
 *
 * For example, for A = [5, 1, 9, 3, 8, 20, 4, 10, 2, 11, 3], return [1, 2, 3, 4, 5]
 */
public class MaximumConsecutiveSubset {

	/**
	 * Time complexity : O(n log(n))
	 * Space complexity : O(1)
	 */
	public static int[] f(int[] a) {
		Arrays.sort(a);

		int maxIndex = 0;
		int max = 1;

		int index = 0;
		int count = 1;

		int i = 1;
		while (i < a.length) {
			if (a[i] == a[i - 1] + 1) {
				count++;
			}

			if (count > max) {
				max = count;
				maxIndex = index;
			}

			if (a[i] > a[i - 1] + 1) {
				count = 1;
				index = i;
			}

			i++;
		}

		int[] subset = new int[max];
		subset[0] = a[maxIndex];
		int j = 1;
		int k = 1;
		while (j < max) {
			if (a[maxIndex + k] != subset[j - 1]) {
				subset[j++] = a[maxIndex + k];
			}

			k++;
		}

		return subset;
	}

	/**
	 * Time complexity : O(n)
	 * Space complexity : O(n)
	 */
	public static int[] f2(int[] a) {
		int n = a.length;

		Set<Integer> saw = new HashSet<>();
		Map<Integer, Integer> lower = new HashMap<>();
		Map<Integer, Integer> higher = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int e = a[i];

			if (!saw.contains(e)) {
				if (lower.containsKey(e - 1) && higher.containsKey(e + 1)) {
					int lo = lower.get(e - 1);
					int hi = higher.get(e + 1);
					higher.put(lo, hi);
					lower.put(hi, lo);
					higher.remove(e + 1);
					lower.remove(e - 1);
				} else if (lower.containsKey(e - 1)) {
					int lo = lower.get(e - 1);
					lower.put(e, lo);
					higher.put(lo, e);
					lower.remove(e - 1);
				} else if (higher.containsKey(e + 1)) {
					int hi = higher.get(e + 1);
					higher.put(e, hi);
					lower.put(hi, e);
					higher.remove(e + 1);
				} else {
					lower.put(e, e);
					higher.put(e, e);
				}

			}

			saw.add(e);
		}

		int lo = 0;
		int hi = 0;

		for (Entry<Integer, Integer> entry : higher.entrySet()) {
			if (entry.getValue() - entry.getKey() > hi - lo) {
				lo = entry.getKey();
				hi = entry.getValue();
			}
		}

		int[] subset = new int[hi - lo + 1];
		for (int i = lo; i <= hi; i++) {
			subset[i - lo] = i;
		}

		return subset;
	}
}