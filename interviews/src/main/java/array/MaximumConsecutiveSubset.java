package array;

import java.util.Arrays;

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
}