package exercice;

/**
 * Datastructure supporting void add(int e) and int median() method
 * where each added value is bounded by k.
 * add and median in O(k) time
 */
public class FindMedianBounded {

	private final int[] count;
	private int n = 0;

	public FindMedianBounded(int k) {
		count = new int[k];
	}

	public void add(int e) {
		count[e]++;
		n++;
	}

	public int median() {
		if (n == 0) {
			throw new UnsupportedOperationException();
		}

		int m = -1;
		int c = 0;

		if (n % 2 == 1) {
			for (int i = 0; i < count.length; i++) {
				c += count[i];
				if (c >= n / 2) {
					m = count[i];
					break;
				}
			}
		} else {
			for (int i= 0; i < count.length; i++) {
				if (c + 1 > n / 2) {
					m = (count[i - 1] + count[i]) / 2;
					break;
				} else {
					c += count[i];
					if (c > n / 2) {
						m = count[i];
						break;
					}
				}
			}
		}

		return m;
	}
}