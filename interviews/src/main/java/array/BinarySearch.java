package array;

/**
 * Implements a binary search on a sorted array.
 */
public class BinarySearch {

	public static int f(int[] a, int v) {
		int lo = 0;
		int hi = a.length - 1;

		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (a[mid] < v) {
				lo = mid + 1;
			} else if (a[mid] == v) {
				return mid;
			} else {
				hi = mid - 1;
			}
		}

		return -(lo + 1);
	}
}