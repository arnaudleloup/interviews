package number;

import java.util.Arrays;

public class Exercices {

	/**
	 * Given an unsorted array of integers of size n,
	 * return the maximum possible m such that the array consists at least m values
	 * greater than or equals to m. Array can contain duplicate values.
	 */
	public static int find(int[] t) {
		Arrays.sort(t); // O(n log(n))

		int count = 0;
		int i = t.length - 1;

		while (i >= 0 && t[i] >= count + 1) { // O(n)
			count++;
			i--;
		}

		return count;
	}
}