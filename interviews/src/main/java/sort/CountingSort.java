package sort;

public class CountingSort {

	
	public static int[] countingSort(int[] table) {
		int n = table.length;
		int countSize = getMax(table) + 1;
		int[] count = new int[countSize];
		
		for (int i = 0; i < n; i++) {
			int value = table[i];
			count[value] += 1;
		}
		
		int[] sorted = new int[n];
		int sortedIndex = 0;
		for (int i = 0; i < countSize; i++) {
			for (int j = 0; j < count[i]; j++) {
				sorted[sortedIndex] = i;
				sortedIndex++;
			}
		}
		
		return sorted;
	}
	
	private static int getMax(int[] table) {
		int max = 0;
		
		for (int i = 0; i < table.length; i++) {
			if (table[i] > max) {
				max = table[i];
			}
		}
		
		return max;
	}
}
