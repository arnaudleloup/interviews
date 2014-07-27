package number;

public class GCD {

	public final static int getGcd(int a, int b) {
		int n = a;
		int d = b;
		int m = -1;

		while (m != 0) {
			m = n % d;
			n = d;

			if (m != 0) {
				d = m;
			}
		}

		return d;
	}
}
