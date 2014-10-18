package sort;

import java.util.Random;

public class QuickSort {

	public static void sort(int[] a) {
		shuffle(a);
		sort(a, 0, a.length - 1);
	}

	private static void sort(int[] a, int lo, int hi) {
		if (hi <= lo) {
			return;
		}

		int k = partition(a, lo, hi);
		sort(a, lo, k - 1);
		sort(a, k + 1, hi);
	}

	private static int partition(int[] a, int lo, int hi) {
		int p = hi; // pivot
		int firstHigh = lo;
		for (int i = lo; i <= hi; i++) {
			if (a[i] < a[p]) {
				swap(a, i, firstHigh++);
			}
		}

		swap(a, firstHigh, p);
		return firstHigh;
	}

	private static void shuffle(int[] a) {
		Random r = new Random();
		for (int i = a.length - 1; i > 0; i--) {
			int j = r.nextInt(i + 1);
			swap(a, i, j);
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}