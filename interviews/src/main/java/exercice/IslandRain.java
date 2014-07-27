package exercice;


public class IslandRain {

	/**
	 * "Given an island represented as an array of integer heights,
	 * return the amount of rain it can contain.
	 * For instance, given the island below, the amount of rain is 21 (number of X).
       _       _   _
      | |X X X| |X| |
     _| |X X X|     |_   _
   _|   |X X X|       |X| |_         _
 _|     |X X|               |X X X X| |
|         |X|                 |X X X| |
[1 2 3 5 1 0 2 5 4 5 3 2 3 2 1 0 0 0 2]
	 *
	 * O(n) time / O(1) space
	 */
	public static int f(int[] heights) {
		if (countLocalMax(heights) < 2) { // O(n)
			return 0;
		}

		int count = 0;
		int startIndex = nextGoodLocalMaxIndex(heights, 0, heights[0]);
		int endIndex = nextGoodLocalMaxIndex(heights, startIndex + 1, heights[startIndex]);

		while(endIndex != -1) {
			count += countRain(heights, startIndex, endIndex);
			startIndex = endIndex;
			endIndex = nextGoodLocalMaxIndex(heights, startIndex + 1, heights[startIndex]);
		}

		return count;
	}

	private static int countRain(int t[], int start, int end) {
		int count = 0;

		int min = t[start] < t[end] ? t[start] : t[end];

		for (int i = start + 1; i < end; i++) {
			count += min - t[i];
		}

		return count;
	}

	/**
	 * Returns the next "good" local max index after a given index.
	 * The next local max index is the good one if
	 * 	1/ the value of the element is greater or equals to the value of the element at start index.
	 *  2/ if no such element exists, it is the next one with the greater value
	 * 
	 *  O(n) time / O(1) space
	 */
	private static int nextGoodLocalMaxIndex(int[] t, int start, int value) {
		if (start == t.length - 1) {
			return -1;
		}

		int nextMaxIndex = nextLocalMaxIndex(t, start);
		int temp = nextMaxIndex;
		while (nextMaxIndex != -1 && t[nextMaxIndex] < value) {
			if (t[nextMaxIndex] > t[temp]) {
				temp = nextMaxIndex;
			}

			nextMaxIndex = nextLocalMaxIndex(t, nextMaxIndex);
		}

		if (nextMaxIndex == -1) {
			return temp;
		}

		return nextMaxIndex;
	}

	/**
	 * Returns the next local max index after a given index.
	 * O(n) time / O(1) space
	 */
	private static int nextLocalMaxIndex(int[] t, int start) {
		int index = -1;

		if (start == 0 && t[0] > t[1]) {
			return 0;
		}

		for (int i = start + 1; i < t.length; i++) {
			if (t[i] >= t[i - 1]
					&& (i == t.length - 1 || t[i] > t[i + 1])) {
				index = i;
				break;
			}
		}

		return index;
	}


	/**
	 * Counts all local max (local max is greater than its previous and next number)
	 * O(n) time / O(1) space
	 */
	private static int countLocalMax(int[] t) {
		int count = 0;

		if (t[0] > t[1]) {
			count++;
		}

		for (int i = 1; i < t.length - 1; i++) {
			if (t[i] >= t[i - 1]
					&& (t[i] > t[i + 1] || i == t.length - 2)) {
				count++;
			}
		}

		return count;
	}
}