package matrix;

public class Islands {

	public static int count(int[][] A) {
		int count = 0;

		int n = A.length;
		int m = A[0].length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 1) {
					count++;
					dfs(A, i, j, n, m);
				}
			}
		}

		return count;
	}

	private static void dfs(int[][] A, int i, int j, int n, int m) {
		if (A[i][j] == 1) {
			A[i][j] = -1;
			if (i > 0) {
				dfs(A, i - 1, j, n, m);
			}

			if (i < n - 1) {
				dfs(A, i + 1, j, n, m);
			}

			if (j > 0) {
				dfs(A, i, j - 1, n, m);
			}

			if (j < m - 1) {
				dfs(A, i, j + 1, n, m);
			}
		}
	}
}