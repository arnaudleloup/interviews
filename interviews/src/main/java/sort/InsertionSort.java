package sort;

public class InsertionSort {

	public static void insertionSort(int[] table) {
		for (int i = 1; i < table.length; i++) {
			int j = i - 1;

			while (j >= 0 && table[j] > table[j + 1]) {
				int temp = table[j];
				table[j] = table[j + 1];
				table[j + 1] = temp;
				j--;
			}
		}
	}
}