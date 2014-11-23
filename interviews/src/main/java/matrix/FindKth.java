package matrix;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

import lib.Pair;

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

		PriorityQueue<Value> heap = new PriorityQueue<>(8, Value.comparator());
		heap.add(new Value(0, 0, matrix[0][0]));
		Set<Pair<Integer, Integer>> done = new HashSet<>();
		done.add(new Pair<Integer, Integer>(0, 0));
		int count = 0;

		while (count < k) {
			Value value = heap.poll();
			int i = value.i;
			int j = value.j;
			if (i < n - 1 && !done.contains(new Pair<Integer, Integer>(i + 1, j))) {
				heap.add(new Value(i + 1, j, matrix[i + 1][j]));
				done.add(new Pair<Integer, Integer>(i + 1, j));
			}

			if (j < n - 1 && !done.contains(new Pair<Integer, Integer>(i, j + 1))) {
				heap.add(new Value(i, j + 1, matrix[i][j + 1]));
				done.add(new Pair<Integer, Integer>(i, j + 1));
			}

			count++;
		}

		return heap.peek().v;
	}

	private static class Value {
		int i;
		int j;
		int v;

		public Value(int i, int j, int v) {
			this.i = i;
			this.j = j;
			this.v = v;
		}

		public static Comparator<Value> comparator() {
			return new Comparator<Value>() {

				@Override
				public int compare(Value o1, Value o2) {
					if (o1.v < o2.v) {
						return -1;
					} else if (o1.v == o2.v) {
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
			result = prime * result + v;
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
			Value other = (Value) obj;
			if (i != other.i) {
				return false;
			}
			if (j != other.j) {
				return false;
			}
			if (v != other.v) {
				return false;
			}
			return true;
		}
	}
}