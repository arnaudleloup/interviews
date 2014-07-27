package exercice;

public class Exo3 {

	/**
	 * "Given an integer, returns an integer that satisfies the following conditions:
	 * 1. positive integer,
	 * 2. no repeated digits: 123 (valid), 122 (invalid),
	 * 3. incremental digit sequence: 1234 (valid), 1243 (invalid),
	 * 4. smallest one greater than the input.
	 * 
	 * Example: 987 -> 1234, 3599 -> 3678"
	 */
	public static int f(int num) {
		int i = num + 1;
		while (true) {
			if (!hasRepeatedDigits(i) && hasIncreasingOrder(i)) {
				break;
			}

			i++;
		}

		return i;
	}

	private static boolean hasRepeatedDigits(int num) {
		int[] digits = new int[10];
		int n = num;
		while(n > 0) {
			int d = n % 10;

			if (digits[d] > 0)  {
				return true;
			}

			digits[d]++;
			n /= 10;
		}

		return false;
	}

	private static boolean hasIncreasingOrder(int num) {
		int last = 10;
		int n = num;

		while (n > 0) {
			int d = n % 10;

			if (d >= last) {
				return false;
			}

			last = d;
			n /= 10;
		}

		return true;
	}
}