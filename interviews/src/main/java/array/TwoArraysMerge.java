package array;

public class TwoArraysMerge {

	/**
	 * 
	 * @param A
	 * @param B
	 * @param n = number of elements in A (not the size of A)
	 */
	public static void merge(int[] A, int[] B, int n) {
		int m = B.length;

		int indexA = n - 1;
		int indexB = m - 1;
		int index = n + m - 1;

		while (indexB >= 0) {
			if (indexA >= 0 && A[indexA] > B[indexB]) {
				A[index] = A[indexA];
				indexA--;
			} else {
				A[index] = B[indexB];
				indexB--;
			}

			index--;
		}
	}
}