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

	public static int[] f(int[] t) {
		int m = findM(t);
		int n = findN(t);

		int[] ret = {m, n};
		return ret;
	}

	/**
	 * O(n) / O(1)
	 * ~ 2n / ~ 1
	 */
	private static int findM(int[] t) {
		int i = 1;
		int previous = t[0];
		while (i < t.length && t[i] >= previous) {
			previous = t[i];
			i++;
		}

		if (i == t.length) {
			return -1;
		}

		int min = Integer.MAX_VALUE;
		while (i < t.length) {
			if (t[i] < min) {
				min = t[i];
			}
			i++;
		}

		i = 0;
		while (t[i] <= min) {
			i++;
		}

		return i;
	}

	/**
	 * O(n) / O(1)
	 * ~ 2n / ~ 1
	 */
	private static int findN(int[] t) {
		int j = t.length - 2;
		int previous = t[t.length - 1];
		while (j >= 0 && t[j] <= previous) {
			previous = t[j];
			j--;
		}

		if (j == -1) {
			return -1;
		}

		int max = -Integer.MAX_VALUE;
		while (j >= 0) {
			if (t[j] > max) {
				max = t[j];
			}

			j--;
		}

		j = t.length - 1;
		while (t[j] >= max) {
			j--;
		}

		return j;
	}
}