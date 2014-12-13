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
		merge(a, lo, mid, hi);
	}

	private static void merge(int[] a, int lo, int mid, int hi) {
		if (a[mid + 1] >= 0) {
			return;
		}

		if (a[mid] <= 0) {
			return;
		}

		int i = lo;
		while (i <= mid && a[i] < 0) {
			i++;
		}

		int j = mid + 1;
		while (j <= hi && a[j] < 0) {
			j++;
		}
		j--;

		rotate(a, i, j, i - (mid + 1));
	}

	private static void rotate(int[] a, int lo, int hi, int d) {
		int n = hi - lo + 1;
		d = ((d % n) + n) % n; // 0 <= d < n
		flip(a, lo, hi);
		flip(a, lo, lo + d - 1);
		flip(a, lo + d, hi);
	}

	private static void flip(int[] a, int lo, int hi) {
		while (lo < hi) {
			int temp = a[lo];
			a[lo++] = a[hi];
			a[hi--] = temp;
		}
	}
}