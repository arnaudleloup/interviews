package tree;

import java.util.NavigableSet;

import lib.Pair;

/**
 * Given a BST and a value x, find two nodes in the tree whose sum is equal to x.
 * It is not allowed to modify the tree
 */
public class FindSum {

	/**
	 * O(n log(n)) / O(1)
	 */
	public static Pair<Integer, Integer> f(NavigableSet<Integer> t, int x) {
		int lo = t.first();
		int hi = t.last();

		while (lo <= hi) {
			if (lo + hi < x) {
				lo = t.higher(lo);
			} else if (lo + hi == x) {
				return new Pair<Integer, Integer>(lo, hi);
			} else {
				hi = t.lower(hi);
			}
		}

		return null;
	}

}