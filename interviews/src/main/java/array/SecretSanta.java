package array;

import java.util.Random;

/**
 * n people want to give each others gift.
 * Each person must give a gift to another person, and each person must receive a gift.
 * A person can not give a gift to himself.
 */
public class SecretSanta {

	private static Random r;

	public SecretSanta(long seed) {
		r = new Random(seed);
	}

	public SecretSanta() {
		r = new Random();
	}

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public int[] f(int n) {
		int[] receivers = new int[n];
		int[] indices = new int[n];

		for (int i = 0; i < n; i++) {
			receivers[i] = i;
			indices[i] = i;
		}

		int[] gifts = new int[n];
		boolean[] received = new boolean[n];
		for (int i = 0; i < n; i++) {
			int j = r.nextInt(n);

			if (i == n - 1 && !received[n - 1]) {
				return f(n);
			}
			while(j == i || received[j]) {
				j = r.nextInt(n);
			}
			gifts[i] = j;
			received[j] = true;
		}

		return gifts;
	}
}