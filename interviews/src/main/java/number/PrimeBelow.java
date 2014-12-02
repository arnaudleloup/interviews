package number;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Returns the prime numbers below a given number.
 */
public class PrimeBelow {

	/**
	 * Eratosthène sieve.
	 * Time complexity: O(n * p)
	 * Space complexity: O(n)
	 */
	public static List<Integer> f(int n) {
		List<Integer> primes = new ArrayList<>();

		boolean[] numbers = new boolean[n + 1];
		Arrays.fill(numbers, true);

		for (int i = 2; i <= n; i++) {
			if (numbers[i]) {
				for (int j = i + 1; j <= n; j++) {
					if (j % i == 0) {
						numbers[j] = false;
					}
				}

				primes.add(i);
			}
		}

		return primes;
	}

	/**
	 * Time complexity: O(n * p)
	 * Space complexity: O(p)
	 */
	public static List<Integer> f2(int n) {
		List<Integer> primes = new ArrayList<>();

		for (int i = 2; i <= n; i++) {
			boolean isPrime = true;

			if (!primes.isEmpty()) {
				int index = 0;
				int p = primes.get(index);
				while (p <= Math.sqrt(i)) {
					if (i % p == 0) {
						isPrime = false;
						break;
					}

					p = primes.get(++index);
				}
			}

			if (isPrime) {
				primes.add(i);
			}
		}

		return primes;
	}
}