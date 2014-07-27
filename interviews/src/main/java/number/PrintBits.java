package number;

public class PrintBits {

	public static String print(int a) {
		String s = new String();

		int b = a;
		for (int i = 0; i < 32; i++) {
			s = (a & 1) + s;
			a = a >> 1;
		}

		System.out.println("Bits representation of " + b + " is " + s);
		return s;
	}
}
