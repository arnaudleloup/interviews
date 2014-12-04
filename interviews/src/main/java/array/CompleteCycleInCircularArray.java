package array;


/**
 * Given a circular array of relative indices, find out if there is a complete cycle. Each cell
 * points relatively to another cell (e.g., -1 to the previous cell, 2 to the second next cell and 0
 * to the same cell). A complete cycle corresponds to visiting all the cells, only once each.
 *
 * Example:
 *   [2, 2, -1] --> true
 *   [2, 2, 0] --> false
 *   [0] --> true
 *   [1, -1] --> true
 */
public class CompleteCycleInCircularArray {

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static boolean f(int[] a) {
		int n = a.length;
		boolean[] visited = new boolean[n];

		int index = 0;
		for (int i = 0; i < n; i++) {
			index = (index + a[index] + n) % n;

			if (visited[index]) {
				return false;
			}

			visited[index] = true;
		}

		return true;
	}

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	public static boolean f2(int[] a) {
		int n = a.length;
		int index = 0;

		for (int i = 0; i < n; i++) {
			index = (index + a[index] + n) % n;

			if (index == 0 && i < n - 1) {
				return false;
			}
		}

		return index == 0;
	}
}