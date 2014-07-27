package number;

public class BitUtils2 {

	public static int getBit(int num, int i) {
		return num >> i & 1;
	}

	public static void setBit(int num, int i) {
		num |= 1 << i;
	}

	public static void clearBit(int num, int i) {
		int mask = ~(1 << i);
		num &= mask;
	}

	public static void clearBitsFromMSBToI(int num, int i) {
		int mask = (1 << i) - 1;
		num &= mask;
	}

	public static void clearBitsFromITo0(int num, int i) {
		int mask = ~((1 << i) - 1) << 1;
		num &= mask;
	}

	public static void updateBit(int num, int i, int val) {

	}
}