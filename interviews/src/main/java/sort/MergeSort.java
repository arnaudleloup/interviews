package sort;

public class MergeSort {

	
	public static int[] mergeSort(int[] table) {
		int[] sorted = new int[table.length];
		
		if (table.length > 1) {
			int[] left = mergeSort(getLeft(table));
			int[] right = mergeSort(getRight(table));
			sorted = merge(left, right);
		} else {
			sorted[0] = table[0];
		}
		
		return sorted;
	}
	
	private static int[] getLeft(int[] table) {
		int n = table.length / 2;
		int[] left = new int[n];
		
		for (int i = 0; i < n; i++) {
			left[i] = table[i];
		}
		
		return left;
	}
	
	private static int[] getRight(int[] table) {
		int n = table.length / 2;
		
		if (table.length % 2 == 1) {
			n += 1;
		}
		
		int[] right = new int[n];
		
		int index = 0;
		for (int i = table.length / 2; i < table.length; i++) {
			right[index] = table[i];
			index++;
		}
		
		return right;
	}
	
	private static int[] merge(int[] left, int[] right) {
		int n = right.length + left.length;
		int[] merged = new int[n];
		
		int leftIndex = 0;
		int rightIndex = 0;
		int mergedIndex = 0;
		
		while (mergedIndex < n) {
			if (leftIndex == left.length) {
				merged[mergedIndex] = right[rightIndex];
				rightIndex++;
			} else if (rightIndex == right.length) {
				merged[mergedIndex] = left[leftIndex];
				leftIndex++;
			} else {
				if (left[leftIndex] < right[rightIndex]) {
					merged[mergedIndex] = left[leftIndex];
					leftIndex++;
				} else {
					merged[mergedIndex] = right[rightIndex];
					rightIndex++;
				}
			}
			
			mergedIndex++;
		}
		
		return merged;
	}
}
