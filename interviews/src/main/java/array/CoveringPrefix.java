package array;

import java.util.HashSet;
import java.util.Set;

/**
 * Find the first covering prefix of a given array.
 * The first covering prefix of an array is the smallest index from which all
 * the elements have already been seen.
 */
public class CoveringPrefix {

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static int f(int[] a) {
		Set<Integer> seen = new HashSet<>();
		int index = -1;

		for (int i = 0; i < a.length; i++) {
			if (!seen.contains(a[i])) {
				seen.add(a[i]);
				index = i;
			}
		}

		return index;
	}
}