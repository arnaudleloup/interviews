package tree;

import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * qaz is a value for a number where this number is less than the other next values
 * which have indexes larger than the index of this number.
 * for example: 33 , 25 , 26 , 58 , 41 , 59
 * -> qaz of (33) = 3 where 33 less than 3 numbers (58 , 41 , 59),
 * qaz of (25) = 4 and not 5 because the index of 33 is less than the index of 25, qaz of (26) = 3,
 * qaz of (58) = 1 , qaz of (41) = 1 , qaz of (59) = 0.
 * the question is to find the max qaz.
 */
public class MaxQaz {

	/**
	 * Time complexity: O(n * log(n))
	 * Space complexity: O(n)
	 */
	public static int f(int[] a) {
		int max = Integer.MIN_VALUE;

		int n = a.length;
		NavigableSet<Integer> set = new TreeSet<>();

		for (int i = n - 1; i >= 0; i--) {
			int e = a[i];
			SortedSet<Integer> greater = set.tailSet(e, false);
			if (greater.size() > max) {
				max = greater.size();
			}

			set.add(e);
		}

		return max;
	}
}