package matrix;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * You have a matrix, where each cell is either black or white.
 * Find the maximum subsquare such that all four borders are filled with black pixels.
 */
public class SubSquare {

	private static int BLACK = 1;

	/**
	 * Time complexity: O(n^4)
	 * Space complexity: O(n^2)
	 */
	public static int f(int[][] matrix) {
		Map<Integer, Map<Integer, Integer>> rows = rows(matrix);
		Map<Integer, Map<Integer, Integer>> columns = columns(matrix);
		int max = Integer.MIN_VALUE;

		for (Entry<Integer, Map<Integer, Integer>> entry : rows.entrySet()) {
			int i = entry.getKey();
			for (Entry<Integer, Integer> ent : entry.getValue().entrySet()) {
				int j = ent.getKey();

				for (int k = ent.getValue(); k > j + 1; k--) {
					int length = k - j + 1;

					if (hasLine(columns, j, i, i + length - 1)
							&& hasLine(rows, k, j, j + length - 1)
							&& hasLine(columns, k, i, i + length - 1)
							&& (length - 1) * (length - 1) > max) {
						max = (k - j - 1) * (k - j - 1);
					}
				}
			}
		}

		return max < 0 ? 0 : max;
	}

	/**
	 * Returns true if there is a black line (row or column) at index i between a and b.
	 * 
	 * Time complexity: O(n)
	 */
	private static boolean hasLine(Map<Integer, Map<Integer, Integer>> lines, int i, int a, int b) {
		if (!lines.containsKey(i)) {
			return false;
		}

		for (Entry<Integer, Integer> entry : lines.get(i).entrySet()) {
			if (entry.getKey() <= a && entry.getValue() >= b) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Returns ranges of black rows of length greater than 2.
	 * 
	 * Time complexity: O(n^2)
	 */
	private static Map<Integer, Map<Integer, Integer>> rows(int[][] matrix) {
		int n = matrix.length;
		Map<Integer, Map<Integer, Integer>> rows = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int count = 0;
			int a = 0;
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == BLACK) {
					if (count == 0) {
						a = j;
					}
					count++;

					if (count > 2) {
						if (!rows.containsKey(i)) {
							rows.put(i, new HashMap<Integer, Integer>());
						}

						rows.get(i).put(a, j);
					}
				} else {
					count = 0;
				}
			}
		}

		return rows;
	}

	/**
	 * Returns ranges of black columns of length greater than 2.
	 * 
	 * Time complexity: O(n^2)
	 */
	private static Map<Integer, Map<Integer, Integer>> columns(int[][] matrix) {
		int n = matrix.length;
		Map<Integer, Map<Integer, Integer>> columns = new HashMap<>();

		for (int j = 0; j < n; j++) {
			int count = 0;
			int a = 0;
			for (int i = 0; i < n; i++) {
				if (matrix[i][j] == BLACK) {
					if (count == 0) {
						a = i;
					}
					count++;

					if (count > 2) {
						if (!columns.containsKey(j)) {
							columns.put(j, new HashMap<Integer, Integer>());
						}

						columns.get(j).put(a, i);
					}
				} else {
					count = 0;
				}
			}
		}

		return columns;
	}
}