package number;

public class Max {

	public static int max(int a, int b) {
		return a + (a - b >> 31 & 1) * (b - a);
	}
}