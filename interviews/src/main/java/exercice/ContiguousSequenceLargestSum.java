package exercice;

public class ContiguousSequenceLargestSum {

	/**
	 * Brute force approach.
	 * 
	 * O(n²) / O(1)
	 * ~ n²/2 / ~ 1
	 */
	public static int f(int[] t) {
		int max = -Integer.MAX_VALUE;
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
}
