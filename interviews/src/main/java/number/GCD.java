package number;

/**
 * Returns the GCD of two numbers.
 */
public class GCD {

	public static int f(int a, int b) {
		int d = b;
		while (a % b != 0) {
			d = a % b;
			a = b;
			b = d;
		}

		return d;
	}
}