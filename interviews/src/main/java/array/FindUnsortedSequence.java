package array;

/**
 * Given an array of integers, write a method to find indices m and n
 * such that if you sorted elements m through n, the entire array would be sorted.
 * Minimize n - m.
 *
 * O(n) / O(1)
 * ~ 4n / ~ 1
 */
public class FindUnsortedSequence {

	public static int[] f(int[] a) {
		int m = findM(a);

		if (m == a.length) {
			return new int[] {-1, -1};
		}

		int n = findN(a);
		return new int[] {m, n};
	}

	private static int findM(int[] a) {
		int n = a.length;
		int m = 0;
		boolean ascending = true;
		int min = Integer.MAX_VALUE;
		for (int i = 1; i < n; i++) {
			if (ascending && a[i] >= a[i - 1]) {
				m = i;
			} else {
				ascending = false;
				if (a[i] < min) {
					min = a[i];
				}
			}
		}

		while (a[m] > min) {
			m--;

			if (m < 0) {
				break;
			}
		}
		m++;

		return m;
	}

	private static int findN(int[] a) {
		int n = a.length;
		int hi = n - 1;
		boolean descending = true;
		int max = Integer.MIN_VALUE;
		for (int i = n - 2; i >= 0; i--) {
			if (descending && a[i] <= a[i + 1]) {
				hi = i;
			} else {
				descending = false;
				if (a[i] > max) {
					max = a[i];
				}
			}
		}

		while (a[hi] < max) {
			hi++;

			if (hi >= n) {
				break;
			}
		}
		hi--;
		return hi;
	}
}