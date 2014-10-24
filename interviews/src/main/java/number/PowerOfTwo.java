package number;


/**
 * Provides convenient methods for manipulating the powers of two.
 */
public class PowerOfTwo {

	/**
	 * Returns the least power of two greater than or equals to the given number.
	 */
	public static int ceiling(int a) {
		if (isPowerOfTwo(a)) {
			return a;
		}

		int i = 0;
		while (a > 0) {
			a /= 2;
			i++;
		}

		return Double.valueOf(Math.pow(2, i)).intValue();
	}

	/**
	 * Returns the greatest power of two less than or equal to the given number
	 */
	public static int floor(int a) {
		if (isPowerOfTwo(a)) {
			return a;
		}

		int i = 0;
		while (a > 1) {
			a /= 2;
			i++;
		}

		return Double.valueOf(Math.pow(2, i)).intValue();
	}

	/**
	 * Returns the power of a power of two.
	 */
	public static int powered(int a) {
		if (!isPowerOfTwo(a)) {
			throw new UnsupportedOperationException();
		}

		int i = 0;
		while (a > 1) {
			a /= 2;
			i++;
		}

		return i;
	}

	private static boolean isPowerOfTwo(int a) {
		return (a & a - 1) == 0;
	}
}