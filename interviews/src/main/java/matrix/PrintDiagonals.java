package matrix;

public class PrintDiagonals {

	public static void f(int[][] matrix) {
		int n = matrix.length;
		int m = matrix[0].length;

		for (int j = 0; j < m; j++) {
			for (int i = 0; i <= j && i < n; i++) {
				System.out.print(matrix[i][j - i] + " ");
			}
			System.out.println();
		}

		for (int i = 1; i < n; i++) {
			for (int j = m - 1; i + m - 1 - j < n && j >= 0; j--) {
				System.out.print(matrix[i + m - 1 - j][j] + " ");
			}
			System.out.println();
		}
	}
}