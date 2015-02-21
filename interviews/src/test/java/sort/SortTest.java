package sort;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class SortTest {

	@Test
	public void testInsertionSort() {
		int[] table = getUnsortedArray(100000);

		InsertionSort.insertionSort(table);

		for (int i = 0; i < table.length; i++) {
			if (i != table.length - 1) {
				assertTrue(table[i] <= table[i + 1]);
			}
		}
	}

	@Test
	public void testCountingSort() {
		int[] table = getUnsortedArray(1000);

		for (int i : table) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] sorted = CountingSort.countingSort(table);
		for (int i : sorted) {
			System.out.print(i + " ");
		}

		for (int i = 0; i < sorted.length; i++) {
			if (i != sorted.length - 1) {
				assertTrue(sorted[i] <= sorted[i + 1]);
			}
		}
	}

	private int[] getUnsortedArray(int n) {
		int[] table = new int[n];

		for (int i = 0; i < n; i++) {
			table[i] = new Random().nextInt(1000);
		}

		return table;
	}
}