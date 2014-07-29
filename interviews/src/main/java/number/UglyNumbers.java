package number;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UglyNumbers {

	/**
	 * Numbers whose only prime factors are 2, 3, 5 or 7 are called ugly numbers.
	 * Generate the first k ugly numbers (in increasing order).
	 * 1 is considered the first.
	 * So the sequence starts with 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14...
	 */
	public static int[] f(int k) {
		int[] ugly = new int[k];



		return ugly;
	}

	private static final Map<Integer, Boolean> memo = new HashMap<>();
	private static final Set<Integer> goodPrimes = new HashSet<>();

	/**
	 * Solved by DP
	 */
	public static int[] f2(int k) {
		goodPrimes.add(2);
		goodPrimes.add(3);
		goodPrimes.add(5);
		goodPrimes.add(7);

		int[] ugly = new int[k];

		ugly[0] = 1;
		int i = 1;
		while (i < k) {
			ugly[i] = nextUgly(ugly[i - 1] + 1);
			i++;
		}

		return ugly;
	}

	private static int nextUgly(int n) {
		if (isUgly(n)) {
			memo.put(n, true);
			return n;
		} else {
			memo.put(n, false);
			return nextUgly(n + 1);
		}
	}

	/**
	 * O(1) / O(1)
	 */
	private static boolean isUgly(int n) {
		if (memo.containsKey(n)) {
			return memo.get(n);
		}

		int div1 = getFirstDivisor(n);
		int div2 = n / div1;

		if (memo.containsKey(div1) && memo.containsKey(div2)) {
			return memo.get(div1) && memo.get(div2);
		}

		// If memo does not contain one of the divisors of n
		// then n is prime.
		return goodPrimes.contains(n);
	}

	/**
	 * Returns the first divisor > 1 and <= 7 (the last ugly prime number).
	 * 
	 * O(1) / O(1)
	 */
	private static int getFirstDivisor(int n) {
		for (int i = 2; i <= 7; i++) {
			if (n % i == 0) {
				return i;
			}
		}

		return n;
	}
}