package array;

/**
 * Sort an array which each value is 0, 1 or 2.
 */
public class DutchFlag {

	public static void sort(int[] a) {
		int BLUE = 0;
		int WHITE = 2;

		int lo = 0;
		while (lo < a.length && a[lo] == BLUE) {
			lo++;
		}

		int hi = a.length - 1;
		while(hi >= 0 && a[hi] == WHITE) {
			hi--;
		}

		int i = lo;
		while (i <= hi) {
			if (a[i] == BLUE) {
				swap(a, lo++, i++);
			} else if (a[i] == WHITE) {
				swap(a, i, hi--);
			} else {
				i++;
			}
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}