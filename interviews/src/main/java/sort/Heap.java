package sort;

public class Heap {

	public static int[] heapSort(int[] table) {
		int[] sorted = new int[table.length];
		int i = 0;

		buildMaxHeap(table);

		while (table.length > 0) {
			// Find max element
			int max = table[0];

			// Swap element table[n] with table[0]
			table[0] = table[table.length - 1];
			table[table.length - 1] = max;

			// Discard node n from heap by decreasing heap size
			int[] temp = new int[table.length - 1];
			for (int j = 0; j < table.length - 1; j++) {
				temp[j] = table[j];
			}

			table = temp;

			// New root may violate max heap property
			// but its children are max heaps
			// -> maxHeapify
			maxHeapify(table, 0);

			sorted[i] = max;
			i++;
		}

		return sorted;
	}
	
	public static void buildMaxHeap(int[] table) {
		int n = table.length / 2;

		for (int i = n - 1; i >= 0; i--) {
			maxHeapify(table, i);
		}
	}

	public static void maxHeapify(int[] table, int i) {
		if (table.length >= 3 && i <= (table.length - 3) / 2) {
			int node = table[i];
			int left = table[2 * i + 1];
			int right = table[2 * i + 2];

			int max = getMax(node, left, right);
			if (node != max) {
				if (left == max) {
					int temp = node;
					table[i] = left;
					table[2 * i + 1] = temp;
					maxHeapify(table, 2 * i + 1);
				} else {
					int temp = node;
					table[i] = right;
					table[2 * i + 2] = temp;
					maxHeapify(table, 2 * i + 2);
				}
			}
		} else if (table.length == 2 && table[0] < table[1]) {
			int temp = table[0];
			table[0] = table[1];
			table[1] = temp;
		}
	}

	private static int getMax(int a, int b, int c) {		
		if (a >= b && a >= c) {
			return a;
		} else if (b >= a && b >= c) {
			return b;
		} else {
			return c;
		}
	}
}