package number;

/**
 * Swaps two numbers in place (that is, without temporary variables)
 */
public class SwapInPlace {

	public static void f(int a, int b) {
		b = a + b;
		a = b - a;
		b = b - a;
		System.out.println("f : a = " + a + ", b = " + b);
	}

	public static void f2(int a, int b) {
		a ^= b;
		b ^= a;
		a ^= b;
		System.out.println("f2 : a = " + a + ", b = " + b);
	}
}