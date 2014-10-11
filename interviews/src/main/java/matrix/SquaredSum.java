package matrix;

/**
 * Given a matrix A, modify it in place such that A[i][j] = sum_{0 <= k,l <= i,j}{A[k][l]}.
 */
public class SquaredSum {

	/**
	 * O(nm) / O(1)
	 */
	public static void f(int[][] A) {
		int n = A.length;
		int m = A[0].length;

		for (int i = 1; i < n; i++) {
			A[i][0] += A[i - 1][0];
		}

		for (int j = 1; j < m; j++) {
			A[0][j] += A[0][j - 1];
		}

		for (int i = 1; i < n; i++) {
			for (int j = 1; j < m; j++) {
				A[i][j] += A[i - 1][j] + A[i][j - 1] - A[i - 1][j - 1];
			}
		}
	}
}