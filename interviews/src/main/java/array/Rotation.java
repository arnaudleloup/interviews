package array;

/**
 * Rotate (shift) an array by d elements.
 */
public class Rotation {

	public static void rotate(int[] a, int d) {
		rotate(a, d, 0, a.length - 1);
	}

	public static void rotate2(int[] a, int d) {
		if (d == 0) {
			return;
		}

		int n = a.length;

		if (d > n || d < n) {
			d = d % n;
		}

		if (d < 0) {
			d = n + d;
		}

		reverse(a, 0, n - 1);
		reverse(a, 0, d - 1);
		reverse(a, d, n - 1);
	}

	/**
	 * Rotates only the elements included between lo and hi (both inclusive)
	 */
	public static void rotate(int[] a, int d, int lo, int hi) {
		if (d == 0) {
			return;
		}

		int n = hi - lo + 1;

		if (d > n || d < n) {
			d = d % n;
		}

		if (d < 0) {
			d = n + d;
		}

		int blocks = n / d;
		for (int i = 1; i < blocks; i++) {
			for (int j = 0; j < d; j++) {
				swap(a, lo + j, lo + i * d + j);
			}
		}

		// Last block is partial
		int left = n - blocks * d;
		if (left > 0) {
			for (int i = 0; i < left; i++) {
				swap(a, lo + i, lo + n - left + i);
			}

			rotate(a, d - left, lo, lo + d - 1);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int n = a.length;
		int k = j % n;

		int temp = a[i];
		a[i] = a[k];
		a[k] = temp;
	}

	private static void reverse(int[] a, int lo, int hi) {
		while (lo < hi) {
			swap(a, lo++, hi--);
		}
	}
}