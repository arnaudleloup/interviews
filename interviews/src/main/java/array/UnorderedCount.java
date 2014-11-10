package array;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Given an array of integer, find the number of unordered pairs.
 * <p/>
 * Examples:
 * <ul>
 * <li> Input: {1, 3, 2}, output: 1 because {3, 2} is unordered. </li>
 * <li> Input: {3, 2, 1}, output: 3 because {3, 2}, {3, 1} and {2, 1} are unordered. </li>
 * </ul>
 */
public class UnorderedCount {

	/**
	 * Time complexity: O(n * log(n))
	 * Space complexity: O(n)
	 */
	public static int f(int[] a) {
		int n = a.length;
		int count = 0;

		SortedSet<Integer> tree = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			SortedSet<Integer> lowers = tree.tailSet(a[i]);
			count += lowers.size();
			tree.add(a[i]);
		}

		return count;
	}

	/**
	 * Brute force approach
	 * 
	 * Time complexity: O(n^2)
	 * Space complexity: O(1)
	 */
	public static int f2(int[] a) {
		int n = a.length;
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (a[j] <= a[i]) {
					count++;
				}
			}
		}

		return count;
	}
}