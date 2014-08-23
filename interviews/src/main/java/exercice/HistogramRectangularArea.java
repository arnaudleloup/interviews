package exercice;

/**
 * Find the maximum rectangular area under a given histogram.
 * The histogram is considered as a succession of bars (vertical rectangle) of width 1.
 * Hence, we only need to store the heights of each bar and the histogram as an array of integers.
 * Example: [3, 1, 2, 4, 1] -> 5
 */
public class HistogramRectangularArea {

	/**
	 * Brute force approach.
	 * O(n²) / O(1)
	 */
	public static int max(int[] t) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < t.length; i++) {
			int before = 0;
			for (int j = i -1; j >= 0 && t[j] >= t[i]; j--) {
				before++;
			}

			int after = 0;
			for (int k = i + 1; k < t.length && t[k] >= t[i]; k++) {
				after++;
			}

			int area = t[i] * (before + after + 1);

			if (area > max) {
				max = area;
			}
		}

		return max;
	}
}