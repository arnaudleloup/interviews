package number;

/**
 * Calculate n choose k.
 */
public class NChooseK {

	/**
	 * Time complexity: O(k)
	 * Space complexity: O(1)
	 */
	public static long f(long n, long k) {
		// n choose k = n!/k!*(n - k) * = n * (n - 1) * ... *  (n - k + 1) / (k * (k - 1) ... * 2 * 1)
		double result = 1;

		for (int i = 0; i < k; i++) {
			result *= ((double) n - i) / (k - i);
		}

		return Double.valueOf(result).longValue();
	}
}