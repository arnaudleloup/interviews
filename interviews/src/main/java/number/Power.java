package number;

public class Power {

	public static int power(int a, int b) {
		int count = a;

		for (int i = 1; i < b; i++) {
			count = Multiplication.times(count, a);
		}

		return count;
	}
}