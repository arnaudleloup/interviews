package sort;

public class RadixSort {

	public static int[] radixSort(int[] table) {
//		int[][] count = new int[2][table.length];
//
//
//		CountingSort.countingSort(table);
//
//		int zeroIndex = 0;
//		int oneIndex = 0;
//		for (int i = 0; i < table.length; i++) {
//			int bit = getBit(table[i], 0);
//
//			if (bit == 0) {
//				count[bit][zeroIndex] = table[i];
//				zeroIndex++;
//			} else {
//				count[bit][oneIndex] = table[i];
//				oneIndex++;
//			}
//		}

		
		int mostSignificantBit = getMostSignificantBit(table);
		return DP(table, 0, mostSignificantBit);
	}

	private static int[] DP(int[] table, int index, int mostSignificantBit) {
		if (index == mostSignificantBit + 1) {
			return table;
		}
		
		int[][] count = new int[2][table.length];

		int zeroIndex = 0;
		int oneIndex = 0;
		for (int i = 0; i < table.length; i++) {
			int bit = getBit(table[i], index);

			if (bit == 0) {
				count[bit][zeroIndex] = table[i];
				zeroIndex++;
			} else {
				count[bit][oneIndex] = table[i];
				oneIndex++;
			}
		}

		int[] sorted = new int[table.length];
		int sortedIndex = 0;
		for (int i = 0; i < count[0].length; i++) {
			sorted[sortedIndex] = count[0][i];
			sortedIndex++;
		}
		
		for (int i = 0; i < count[1].length; i++) {
			sorted[sortedIndex] = count[1][i];
			sortedIndex++;
		}
		
		return DP(sorted, index + 1, mostSignificantBit);
	}

	private static int getMostSignificantBit(int[] table) {
		int max = 0;
		
		for (int i = 0; i < table.length; i++) {
			int j = 0;
			while (table[i] < Math.pow(2, j)) {
				j++;
			}
			
			if (j > max) {
				max = j;
			}
		}
		
		return max;
	}

	private static int getBit(int k, int i) {
		return k >> i & 1;
	}
}