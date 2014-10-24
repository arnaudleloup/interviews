package array;

import java.util.HashSet;
import java.util.Set;

import number.PowerOfTwo;

/**
 * Takes an unmodifiable array as input of the constructor.
 * The constructor can pre process anything.
 * Has a method that returns the minimum of the array given a range.
 */
public class MinQueryRange {

	public enum MinOption {

		/**
		 * Time complexity of min : O(1)
		 * Space complexity : O(n^2)
		 */
		MATRIX {
			private int[][] matrix;

			@Override
			protected void init(int[] a) {
				int n = a.length;
				matrix = new int[n][n];

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						matrix[i][j] = min(a, i, j);
					}
				}
			}

			@Override
			protected int min(int lo, int hi) {
				return matrix[lo][hi];
			}
		},

		/**
		 * Time complexity of min : O(log(n))
		 * Space complexity : O(n)
		 */
		TREE {
			class Range {
				int lo;
				int hi;
				int min;

				public Range(int lo, int hi) {
					this.lo = lo;
					this.hi = hi;
				}
			}

			private Range[] tree;

			@Override
			protected void init(int[] a) {
				int n = a.length;
				tree = new Range[PowerOfTwo.ceiling(n) * 2];
				initTree(1, 0, n - 1);
				initMin(a);
			}

			private void initTree(int i, int lo, int hi) {
				tree[i] = new Range(lo, hi);

				if (lo != hi) {
					int mid = lo + (hi - lo) / 2;
					initTree(2 * i, lo, mid);
					initTree(2 * i + 1, mid + 1, hi);
				}
			}

			private void initMin(int[] a) {
				for (int i = tree.length - 1; i > 0; i--) {
					Range r = tree[i];
					if (r != null) {
						if (r.hi - r.lo == 0) {
							r.min = a[r.lo];
						} else {
							r.min = Math.min(tree[2 * i].min, tree[2 * i + 1].min);
						}
					}
				}
			}

			@Override
			protected int min(int lo, int hi) {
				Set<Range> ranges = new HashSet<>();

				while (lo <= hi) {
					Range r = findRange(lo, hi);
					ranges.add(r);
					lo = r.hi + 1;
				}

				int min = Integer.MAX_VALUE;
				for (Range r : ranges) {
					if (r.min < min) {
						min = r.min;
					}
				}

				return min;
			}

			private Range findRange(int lo, int hi) {
				Range r = tree[1];
				int i = 1;

				while (r.lo != lo || r.hi > hi) {
					int mid = r.lo + (r.hi - r.lo) / 2;

					if (r.lo != lo) {
						if (lo <= mid) {
							i *= 2;
							r = tree[i];
						} else {
							i = 2 * i + 1;
							r = tree[i];
						}
					} else {
						i *= 2;
						r = tree[i];
					}
				}
				return r;
			}
		},

		/**
		 * Time complexity of min : O(1)
		 * Space complexity : O(n * log(n))
		 */
		POWER_OF_2 {
			private int[][] matrix;
			private int a[];

			@Override
			protected void init(int[] a) {
				this.a = a;
				int n = a.length;
				int m = Double.valueOf(Math.log(n) / Math.log(2)).intValue() + 2;
				matrix = new int[n][m];

				for (int i = 0; i < n; i++) {
					int index = 0;
					int j = 1;

					while (i + j < n) {
						matrix[i][index++] = min(a, i, i + j);
						j *= 2;
					}

					if (i + j > n - 1) {
						matrix[i][index] = min(a, i, n - 1);
					}
				}
			}

			@Override
			protected int min(int lo, int hi) {
				if (lo == hi) {
					return a[lo];
				}

				int diff = hi - lo;
				int j = PowerOfTwo.floor(diff);
				int powered = PowerOfTwo.powered(j);
				return Math.min(matrix[lo][powered], matrix[hi - j][powered]);
			}
		};

		protected abstract void init(int[] a);
		protected abstract int min(int lo, int hi);


		protected int min(int[] a, int lo, int hi) {
			int min = Integer.MAX_VALUE;
			for (int i = lo; i <= hi; i++) {
				if (a[i] < min) {
					min = a[i];
				}
			}

			return min;
		}
	}

	private final MinOption option;

	public MinQueryRange(int[] a, MinOption option) {
		this.option = option;
		option.init(a);
	}

	public int min(int lo, int hi) {
		return option.min(lo, hi);
	}
}