package number;

/**
 * Returns the nth Fibonacci number.
 */
public class Fibonacci {

	/**
	 * Time complexity : O(n)
	 * Space complexity : O(1)
	 */
	public static int f(int n) {
		if (n == 1) {
			return 1;
		}

		int i = 1;
		int j = 2;
		for (int k = 0; k < n - 2; k++) {
			int temp = j;
			j += i;
			i = temp;
		}

		return j;
	}
}