package matrix;

public class PrintDiagonals {

	public static void f(int[][] A) {
		int n = A.length;

		for (int j = 0; j < n; j++) {
			for (int i = 0; i <= j; i++) {
				System.out.print(A[i][j - i] + " ");
			}
			System.out.println();
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				System.out.print(A[i + j][n - 1 - j] + " ");
			}
			System.out.println();
		}
	}
}