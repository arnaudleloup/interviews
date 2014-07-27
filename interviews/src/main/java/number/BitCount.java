package number;

/**
 * 
 * Returns the number of 1 in a bits sequence.
 */
public class BitCount {

	/**
	 * Check each bit to see if equals to 1.
	 */
	public static int count(int a) {
		int count = 0;

		for (int c = a; c != 0; c = c >> 1) {
			count += c & 1;
		}

		return count;
	}

	/**
	 * c & c - 1 clear the least significant bit of c.
	 */
	public static int count2(int a) {
		int count = 0;

		for (int c = a; c != 0; c &= c - 1) {
			count++;
		}

		return count;
	}
}
