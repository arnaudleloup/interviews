package matrix;

/**
 * Given a matrix A of 0s (water) and 1s (land), return the total number of islands. Two pieces of
 * land are connected if they touch each other (left/up/down/right, not in diagonal). An island
 * corresponds to a set of connected lands.
 */
public class Islands {

	/**
	 * Time complexity: O(n * m)
	 * Space complexity: O(1)
	 */
	public static int count(int[][] A) {
		int count = 0;

		int n = A.length;
		int m = A[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 1) {
					dfs(A, i, j, n, m);
					count++;
				}
			}
		}

		return count;
	}

	private static void dfs(int[][] A, int i, int j, int n, int m) {
		A[i][j] = -1;

		if (i > 0 && A[i - 1][j] == 1) {
			dfs(A, i - 1, j, n, m);
		}

		if (i < n - 1 && A[i + 1][j] == 1) {
			dfs(A, i + 1, j, n, m);
		}

		if (j > 0 && A[i][j - 1] == 1) {
			dfs(A, i, j - 1, n, m);
		}

		if (j < m - 1 && A[i][j + 1] == 1) {
			dfs(A, i, j + 1, n, m);
		}
	}
}