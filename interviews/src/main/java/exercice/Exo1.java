package exercice;

import java.util.Arrays;

public class Exo1 {

	public static int f(int[] t) {
		Arrays.sort(t); // O(n log(n))

		int count = 0;
		int i = t.length - 1;

		while (i >= 0 && t[i] >= count + 1) { // O(n)
			count++;
			i--;
		}

		return count;
	}

	public static int f2(int[] t) {
		int n = t.length;
		// values frequency
		int[] fr = new int[n + 1]; // O(n) space

		for (int i : t) { // O(n) time
			if (i > n) {
				fr[n]++;
			} else {
				fr[i]++;
			}
		}

		int m = 0;
		int count = 0;
		for (int i = n; i > 0; i--) { // O(n) time
			count += fr[i];
			if (count >= i) {
				m = i;
				break;
			}
		}

		return m;
	}
}
