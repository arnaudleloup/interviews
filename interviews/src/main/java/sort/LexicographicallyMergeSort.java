package sort;

public class LexicographicallyMergeSort {

	public static int[] sort(int[] t) {

		int[] sorted = new int[t.length];
		if (t.length > 1) {
			int[] left = sort(getLeft(t));
			int[] right = sort(getRight(t));
			sorted = merge(left, right);
		} else {
			sorted[0] = t[0];
		}

		return sorted;
	}

	private static int[] getLeft(int[] t) {
		int n = t.length / 2;
		int[] left = new int[n];

		for (int i = 0; i < n; i++) {
			left[i] = t[i];
		}

		return left;
	}

	private static int[] getRight(int[] t) {
		int n = t.length / 2;

		if (t.length % 2 == 1) {
			n++;
		}

		int[] right = new int[n];

		int index = 0;
		for (int i = t.length / 2; i < t.length; i++) {
			right[index] = t[i];
			index++;
		}

		return right;
	}

	private static int[] merge(int[] a, int[] b) {
		int n = a.length + b.length;
		int[] merged = new int[n];

		int indexA = 0;
		int indexB = 0;
		int indexMerged = 0;

		while (indexMerged < n) {
			if (indexA == a.length) {
				merged[indexMerged] = b[indexB];
				indexB++;
			} else if (indexB == b.length) {
				merged[indexMerged] = a[indexA];
				indexA++;
			} else {
				String sA = String.valueOf(a[indexA]);
				String sB = String.valueOf(b[indexB]);

				if (sA.compareTo(sB) < 0) {
					merged[indexMerged] = a[indexA];
					indexA++;
				} else {
					merged[indexMerged] = b[indexB];
					indexB++;
				}
			}

			indexMerged++;
		}

		return merged;
	}
}