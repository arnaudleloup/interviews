package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Input: two sorted arrays.
 * <p/>
 * Output: the intersection of the two arrays.
 */
public class Intersection {

	/**
	 * n = a.length
	 * m = b.length
	 * Time complexity: O(n + m)
	 * Space complexity: O(min(n, m))
	 */
	public static Set<Integer> f(int[] a, int[] b) {
		Set<Integer> intersection = new HashSet<>();

		int n = a.length;
		int m = b.length;

		int i = 0;
		int j = 0;

		while (i < n && j < m) {
			if (a[i] < b[j]) {
				i++;
			} else if (a[i] == b[j]) {
				intersection.add(a[i]);
				i++;
				j++;
			} else {
				j++;
			}
		}

		return intersection;
	}

	/**
	 * a is much bigger than b.
	 * n = a.length
	 * m = b.length
	 * 
	 * Time complexity: O(m * log(n))
	 * Space complexity: O(m)
	 */
	public static Set<Integer> f2(int[] a, int[] b) {
		Set<Integer> intersection = new HashSet<>();

		for (int e : b) {
			if (contains(a, e)) {
				intersection.add(e);
			}
		}

		return intersection;
	}

	/**
	 * Returns true if a contains the value v, returns false otherwise.
	 */
	private static boolean contains(int[] a, int v) {
		int lo = 0;
		int hi = a.length;

		while (lo <= hi) {
			int mid = lo +  (hi - lo) / 2;
			if (a[mid] < v) {
				lo = mid + 1;
			} else if (a[mid] == v) {
				return true;
			} else {
				hi = mid - 1;
			}
		}

		return false;
	}
}