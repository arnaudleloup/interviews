package number;

public class Power {

	/**
	 * Time complexity: O(b)
	 * Space complexity: O(1)
	 */
	public static int f(int a, int b) {
		int count = a;

		for (int i = 1; i < b; i++) {
			count = Multiplication.times(count, a);
		}

		return count;
	}

	/**
	 * Time complexity: O(log(b))
	 * Space complexity: O(1)
	 */
	public static double f2(double a, int b) {
		double count = 1;
		if (b < 0) {
			a = 1 / a;
			b = -b;
		}

		for (int i = 0; i < 32; i++) {
			if ((b & 1) == 1) {
				double temp = a;
				for (int j = 0; j < i; j++) {
					temp *= temp;
				}

				count *= temp;
			}

			b = b >> 1;
		}

		return count;
	}
}