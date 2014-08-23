package exercice;

/**
 * You are given an array of integers (both positive and negative).
 * Find the contiguous sequence with the largest sum. Return the sum.
 */
public class ContiguousSequenceLargestSum {

	/**
	 * Brute force approach.
	 * 
	 * O(n²) / O(1)
	 * ~ n²/2 / ~ 1
	 */
	public static int f(int[] t) {
		int max = Integer.MIN_VALUE;
		int count = 0;

		for (int i = 0; i < t.length; i++) {
			count = t[i];

			for (int j = i + 1; j < t.length; j++) {
				if (count > max) {
					max = count;
				}

				count += t[j];
			}
		}

		return max;
	}

	/**
	 * O(n) / O(1)
	 * ~ 3n / ~ 1
	 */
	public static int f2(int[] t) {
		int max = Integer.MIN_VALUE;
		int currentSum = 0;

		for (int i = 0; i < t.length; i++) {
			currentSum += t[i];

			if (currentSum > max) {
				max = currentSum;
			}

			if (currentSum < 0) {
				currentSum = 0;
			}
		}

		return max;
	}
}