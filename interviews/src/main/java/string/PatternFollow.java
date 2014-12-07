package string;


/**
 * Question was "Given a pattern and a string input -
 * find if the string follows the same pattern and return 0 or 1.
 * Examples:
 * 1) Pattern : "abba", input: "redbluebluered" should return 1.
 * 2) Pattern: "aaaa", input: "asdasdasdasd" should return 1.
 * 3) Pattern: "aabb", input: "xyzabcxzyabc" should return 0.
 */
public class PatternFollow {

	public static boolean f(String text, String pat) {
		int n = text.length();
		int m = pat.length();

		int a = 0; // number of a's
		int b = 0; // number of b's
		for (int i = 0; i < m; i++) {
			if (pat.charAt(i) == 'a') {
				a++;
			} else {
				b++;
			}
		}

		if (a == 0 || b == 0) {
			if (n % m != 0) {
				return false;
			}

			int length = n / m;
			String pattern = text.substring(0, length);
			for (int i = 0; i < m; i++) {
				if (!text.substring(i * length, (i + 1) * length).equals(pattern)) {
					return false;
				}
			}

			return true;
		}

		// x = length of pattern a
		// y = length of pattern b
		// let's check all possible x and y
		// a * x + b * y = n
		for (int x = 0; x < n / a; x++) {
			if((n - a * x) % b != 0) {
				continue;
			}

			int y = (n - a * x) / b;
			String aPattern = null;
			String bPattern = null;
			int aCount = 0;
			int bCount = 0;
			int i;
			for (i = 0; i < m; i++) {
				char c = pat.charAt(i);
				int start = aCount * x + bCount * y;

				if (c == 'a') {
					int end = start + x;

					if (end > n) {
						break;
					}

					if (aPattern == null) {
						aPattern = text.substring(start, end);
					} else if(!text.substring(start, end).equals(aPattern)) {
						break;
					}

					aCount++;
				} else {
					int end = start + y;

					if (end > n) {
						break;
					}

					if (bPattern == null) {
						bPattern = text.substring(start, end);
					} else if(!text.substring(start, end).equals(bPattern)) {
						break;
					}

					bCount++;
				}
			}

			if (i == m) {
				return true;
			}
		}

		return false;
	}
}