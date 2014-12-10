package number;

/**
 * For a given number, return a number with its bits reversed.
 */
public class BitReversal {

	/**
	 * Let n be the number base.
	 * 
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	public static int f(int k) {
		int MSTIndex = 0;
		for (int i = 0; i < 32; i++) {
			if (((k >> i) & 1) == 1) {
				MSTIndex = i;
			}
		}

		int reversed = 0;

		for (int i = 0; i <= MSTIndex; i++) {
			if (((k >> i) & 1) == 1) {
				reversed |= 1 << (MSTIndex - i);
			}
		}

		return reversed;
	}
}