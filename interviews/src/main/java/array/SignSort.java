package array;

/**
 * In place stable sign sort.
 * Example : [2, -4, 3, -2, -4, 4, 2] -> [-4, -2, -4, 2, 3, 4, 2]
 */
public class SignSort {

	public static void f(int[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(int[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		partition(a, lo, mid, hi);
	}

	private static void partition(int[] a, int lo, int mid, int hi) {
		int f = findFirstPositive(a, lo, mid);
		int s = findFirstPositive(a, mid + 1, hi);

		if (s == -1) {
			s = hi + 1;
		}

		if (f != -1) {
			Rotation.rotate(a, s - (mid + 1), f, s - 1);
		}
	}

	private static int findFirstPositive(int[] a, int lo, int hi) {
		for (int i = lo; i <= hi; i++) {
			if (a[i] > 0) {
				return i;
			}
		}

		return -1;
	}
}