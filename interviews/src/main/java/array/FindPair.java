package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a method to find all pairs of integers within an array
 * which sum to a specified value.
 */
public class FindPair {

	/**
	 * O(n log(n)) / O(1)
	 */
	public static Set<Pair> f(int[] a, int x) {
		Arrays.sort(a);
		Set<Pair> pairs = new HashSet<>();

		int lo = 0;
		int hi = a.length - 1;
		while (lo < hi) {
			int c = a[lo] + a[hi];
			if (c < x) {
				lo++;
			} else if (c == x) {
				pairs.add(new Pair(a[lo++], a[hi--]));
			} else {
				hi--;
			}
		}

		return pairs;
	}

	/**
	 * O(n) / O(n)
	 */
	public static Set<Pair> f2(int[] a, int x) {
		Set<Pair> pairs = new HashSet<>();
		Set<Integer> elements = new HashSet<>();

		boolean foundHalf = false;
		for (int i = 0; i < a.length; i++) {
			if (2 * a[i] == x) { // we have to treat here the case of the half
				if (foundHalf) {
					pairs.add(new Pair(a[i], a[i]));
				} else {
					foundHalf = true;
				}
			} else {
				elements.add(a[i]);
			}
		}

		for (int i : elements) {
			if (elements.contains(x - i)) {
				if (i < x - i) {
					pairs.add(new Pair(i, x - i));
				} else {
					pairs.add(new Pair(x - i, i));
				}
			}
		}

		return pairs;
	}

	public static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}


		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
				return false;
			}
			if (getClass() != obj.getClass()) {
				return false;
			}
			Pair other = (Pair) obj;
			if (x != other.x) {
				return false;
			}
			if (y != other.y) {
				return false;
			}
			return true;
		}

		@Override
		public String toString() {
			return "Pair [x=" + x + ", y=" + y + "]";
		}
	}
}