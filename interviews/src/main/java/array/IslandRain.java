package array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * "Given an island represented as an array of integer heights,
 * return the amount of rain it can contain.
 * For instance, given the island below, the amount of rain is 21 (number of X).
       _       _   _
      | |X X X| |X| |
     _| |X X X|     |_   _
   _|   |X X X|       |X| |_         _
 _|     |X X|               |X X X X| |
|         |X|                 |X X X| |
[1 2 3 5 1 0 2 5 4 5 3 2 3 2 1 0 0 0 2]
 */
public class IslandRain {

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static int f(int[] heights) {
		int n = heights.length;
		int count = 0;
		Deque<Integer> stack = new ArrayDeque<>();

		for (int i = 0; i < n; i++) {
			if (!stack.isEmpty() && heights[i] >= heights[stack.getLast()]) {
				int h = heights[stack.removeLast()];

				while(!stack.isEmpty() && heights[stack.getLast()] > h) {
					int j = stack.getLast();
					int H = Math.min(heights[j], heights[i]);
					count += (H - h) * (i - j - 1);
					h = H;

					if (heights[stack.getLast()] <= heights[i]) {
						stack.removeLast();
					} else {
						break;
					}
				}
			}

			stack.addLast(i);
		}

		return count;
	}
}