package array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Find the maximum rectangular area under a given histogram.
 * The histogram is considered as a succession of bars (vertical rectangle) of width 1.
 * Hence, we only need to store the heights of each bar and the histogram as an array of integers.
 * Example: [3, 1, 2, 4, 1] -> 5
 */
public class Histogram {

	/**
	 * Brute force approach.
	 * Time complexity : O(n^2)
	 * Space complexity : O(1)
	 */
	public static int f(int[] t) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < t.length; i++) {
			int before = 0;
			for (int j = i -1; j >= 0 && t[j] >= t[i]; j--) {
				before++;
			}

			int after = 0;
			for (int k = i + 1; k < t.length && t[k] >= t[i]; k++) {
				after++;
			}

			int area = t[i] * (before + after + 1);

			if (area > max) {
				max = area;
			}
		}

		return max;
	}

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static int f2(int[] heights) {
		int n = heights.length;
		int max = 0;

		Deque<Column> stack = new ArrayDeque<>();
		for (int i = 0; i < n + 1; i++) {
			Column column = new Column(i);
			int currentHeight = i == n ? 0 : heights[i]; // last height is 0

			while (!stack.isEmpty() && currentHeight < heights[stack.getLast().index]) {
				Column last = stack.removeLast();
				int H = heights[last.index];
				int L = i - last.index;
				int area = last.leftArea + H * L;
				if (area > max) {
					max = area;
				}

				column.leftArea = currentHeight * L;
			}

			if (stack.isEmpty() || currentHeight > heights[stack.getLast().index]) {
				stack.addLast(column);
			}
		}

		return max;
	}

	public static class Column {
		int leftArea; // area in the left of the column
		int index; // index of the column

		public Column(int index) {
			this.index = index;
		}
	}
}