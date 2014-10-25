package array;

import number.PowerOfTwo;

/**
 * Takes an unmodifiable array as input of the constructor.
 * The constructor can pre process anything.
 * Has a method that returns the minimum of the array given a range.
 */
public class MinQueryRange {

	public enum Option {

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

			private int[] tree;
			private int n;

			@Override
			protected void init(int[] a) {
				n = a.length;
				tree = new int[PowerOfTwo.ceiling(n) * 2];
				initTree(1, 0, n - 1, a);
			}

			private int initTree(int i, int lo, int hi, int[] a) {
				if (lo == hi) {
					tree[i] = a[lo];
				} else {
					int mid = lo + (hi - lo) / 2;
					int min1 = initTree(2 * i, lo, mid, a);
					int min2 = initTree(2 * i + 1, mid + 1, hi, a);
					tree[i] = Math.min(min1, min2);
				}

				return tree[i];
			}

			@Override
			protected int min(int lo, int hi) {
				return min(lo, hi, 0, n - 1, 1);
			}

			private int min(int lo, int hi, int i, int j, int node) {
				if (lo > j || hi < i) {
					return Integer.MAX_VALUE;
				}

				if (i >= lo && j <= hi) {
					return tree[node];
				}

				int mid = i + (j - i) / 2;
				int left = min(lo, hi, i, mid, 2 * node);
				int right = min(lo, hi, mid + 1, j, 2 * node + 1);
				return Math.min(left, right);
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

	private final Option option;

	public MinQueryRange(int[] a, Option option) {
		this.option = option;
		option.init(a);
	}

	public int min(int lo, int hi) {
		return option.min(lo, hi);
	}
}