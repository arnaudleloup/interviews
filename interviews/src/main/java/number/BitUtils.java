package number;

public class BitUtils {


	public static int getBit(int num, int i) {
		return num >> i & 1;
	}

	public static void setBit(int num, int i) {
		int mask = 1 << i;
		num |= mask;
	}

	public static void clearBit(int num, int i) {
		int mask = ~(1 << i);
		num &= mask;
	}

	public static void clearBitsFromMSBToI(int num, int i) {
		int mask = (1 << i) - 1;
		num &= mask;
	}

	public static void clearBitsFromIToLSB(int num, int i) {

	}

	public static void setBitValue(int num, int i, int val) {

	}
}