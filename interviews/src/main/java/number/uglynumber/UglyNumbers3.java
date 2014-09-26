package number.uglynumber;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Numbers whose only prime factors are 2, 3, 5 or 7 are called ugly numbers.
 * Generate the first k ugly numbers (in increasing order).
 * 1 is considered the first.
 * So the sequence starts with 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 12, 14...
 * 
 * O(klog(k)) / O(k)
 */
public class UglyNumbers3 {

	private final static int[] PRIMES = {2, 3, 5, 7};

	public static long[] f(int k) {
		long[] t = new long[k];

		SortedSet<Long> set = new TreeSet<>();
		set.add(1L);

		for (int i = 0; i < k; i++) {
			long l = set.first();
			t[i] = l;

			for (int p : PRIMES) {
				set.add(l * p);
			}

			set.remove(l);
		}

		return t;
	}
}