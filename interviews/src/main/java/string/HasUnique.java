package string;

public class HasUnique {

	public static void main(String[] args) {
		String s = "abcdefghiu";

		System.out.println(hasUnique(s));
		System.out.println(hasUnique2(s));
	}

	/**
	 * Returns true if all characters in a string are unique.
	 */
	public static boolean hasUnique(String s) {

		boolean[] done = new boolean[128];

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (done[c]) {
				return false;
			}

			done[c] = true;
		}

		return true;
	}

	public static boolean hasUnique2(String s) {
		int a = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if ((a >> c & 1) == 1) {
				return false;
			}

			a |= 1 << c;
		}

		return true;
	}
}
