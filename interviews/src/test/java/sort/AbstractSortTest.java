package sort;

import java.util.Random;

public class AbstractSortTest {

	protected int[] getUnsortedArray(int n) {
		int[] table = new int[n];

		for (int i = 0; i < n; i++) {
			table[i] = new Random().nextInt(1000);
		}

		return table;
	}

	protected boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] > a[i + 1]) {
				return false;
			}
		}

		return true;
	}
}
