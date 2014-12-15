package matrix;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given a n*n Matrix.
 * All rows are sorted, and all columns are sorted.
 * Find the Kth Largest element of the matrix.
 */
public class FindKth {

	/**
	 * Time complexity: O(k * log(k))
	 * Space complexity: O(k)
	 */
	public static int f(int[][] matrix, int k) {
		int n = matrix.length;
		PriorityQueue<Element> pq = new PriorityQueue<>(k + 1, Element.comparator());
		pq.add(new Element(0, 0, matrix[0][0]));
		Set<Element> seen = new HashSet<>();
		seen.add(new Element(0, 0, matrix[0][0]));
		int value = -1;

		while (k >= 0) {
			Element e = pq.poll();
			value = e.val;
			if (e.i + 1 < n) {
				Element e1 = new Element(e.i + 1, e.j, matrix[e.i + 1][e.j]);
				if (!seen.contains(e1)) {
					pq.add(e1);
					seen.add(e1);
				}
			}

			if (e.j + 1 < n) {
				Element e2 = new Element(e.i, e.j + 1, matrix[e.i][e.j + 1]);
				if (!seen.contains(e2)) {
					pq.add(e2);
					seen.add(e2);
				}
			}
			k--;
		}

		return value;
	}

	private static class Element {
		int i;
		int j;
		int val;

		public Element(int i, int j, int val) {
			this.i = i;
			this.j = j;
			this.val = val;
		}

		private static Comparator<Element> comparator() {
			return new Comparator<Element>() {

				@Override
				public int compare(Element e1, Element e2) {
					if (e1.val < e2.val) {
						return -1;
					} else if (e1.val == e2.val) {
						return 0;
					} else {
						return 1;
					}
				}
			};
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + i;
			result = prime * result + j;
			result = prime * result + val;
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
			Element other = (Element) obj;
			if (i != other.i) {
				return false;
			}
			if (j != other.j) {
				return false;
			}
			if (val != other.val) {
				return false;
			}
			return true;
		}
	}
}