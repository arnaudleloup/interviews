package string;

public class LongestPrefix {
	public static String f(String s) {
		String[] all = s.split(" ");

		if (all.length == 0) {
			return new String();
		}

		if (all.length == 1) {
			return all[0];
		}

		char[] chars = all[0].toCharArray();
		int left = chars.length;
		for (int i = 1; i < all.length; i++) {
			String t = all[i];

			for (int j = 0; j < left; j++) {
				if (chars[j] != t.charAt(j)) {
					for (int k = j; k < left; k++) {
						chars[k] = ' ';
					}

					left = j;
					break;
				}
			}
		}

		String ret = new String();
		for (char c : chars) {
			if (c != ' ') {
				ret += c;
			}
		}

		return ret;
	}
}
