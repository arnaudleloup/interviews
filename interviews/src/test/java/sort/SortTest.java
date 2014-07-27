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
	public void testMergeSort() {
		int[] table = getUnsortedArray(100);
		//		int[] table = {3, 1, 2};
		for (int i : table) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] merged = MergeSort.mergeSort(table);
		for (int i : merged) {
			System.out.print(i + " ");
		}
		for (int i = 0; i < merged.length; i++) {
			if (i != merged.length - 1) {
				assertTrue(merged[i] <= merged[i + 1]);
			}
		}
	}

	@Test
	public void testLexicographicallyMergeSort() {
		int[] table = getUnsortedArray(100);
		//		int[] table = {3, 1, 2};
		for (int i : table) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] merged = LexicographicallyMergeSort.sort(table);
		for (int i : merged) {
			System.out.print(i + " ");
		}
		for (int i = 0; i < merged.length; i++) {
			if (i != merged.length - 1) {
				String s1 = String.valueOf(merged[i]);
				String s2 = String.valueOf(merged[i + 1]);

				assertTrue(s1.compareTo(s2) <= 0);
			}
		}
	}

	@Test
	public void testMaxHeapify() {
		//		int[] table = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		int[] table = {9, 16};

		Heap.maxHeapify(table, 0);

		for (int i : table) {
			System.out.print(i + " ");
		}
	}

	@Test
	public void testBuildMaxHeap() {
		//		int[] table = {16, 4, 10, 14, 7, 9, 3, 2, 8, 1};
		int[] table = getUnsortedArray(7);

		for (int i : table) {
			System.out.print(i + " ");
		}
		System.out.println();
		Heap.buildMaxHeap(table);

		for (int i : table) {
			System.out.print(i + " ");
		}
	}

	@Test
	public void testHeapSort() {
		int[] table = getUnsortedArray(100000);

		//		for (int i : table) {
		//			System.out.print(i + " ");
		//		}
		//		System.out.println();
		int[] sorted = Heap.heapSort(table);
		//		for (int i : sorted) {
		//			System.out.print(i + " ");
		//		}

		for (int i = 0; i < sorted.length; i++) {
			if (i != sorted.length - 1) {
				assertTrue(sorted[i] >= sorted[i + 1]);
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

	@Test
	public void testRadixSort() {
		int[] table = getUnsortedArray(10);

		for (int i : table) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] sorted = RadixSort.radixSort(table);
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
