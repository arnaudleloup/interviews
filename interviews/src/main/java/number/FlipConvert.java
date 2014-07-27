package number;

/**
 * Write a function to determine the number of bits you would need to flip
 * to convert interger A to integer B.
 */
public class FlipConvert {

	public static int convert(int A,  int B) {
		int X = 0;
		int Y = 0;
		if (A > B) {
			X = A;
			Y = B;
		} else {
			X = B;
			Y = A;
		}

		int count = 0;
		while (X > 0) {
			int x = X & 1;
			int y = Y & 1;

			if (x != y) {
				count++;
			}

			X = X >> 1;
			Y = Y >> 1;
		}

		return count;
	}

	public static int convert2(int a,  int b) {
		int count = 0;

		for (int c = a ^ b; c != 0; c = c >> 1) {
			count += c & 1;
		}

		return count;
	}

	/**
	 * c & c - 1 clear the least significant bit of c.
	 */
	public static int convert3(int a,  int b) {
		int count = 0;

		for (int c = a ^ b; c != 0; c &= c - 1) {
			count ++;
		}

		return count;
	}
}