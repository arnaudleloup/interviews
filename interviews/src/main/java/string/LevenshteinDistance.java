package string;

/**
 * Compute the Levenshtein distance (a.k.a. edit distance) between two strings.
 * It corresponds to the least number of single-character edits (add, delete and substitute) that
 * are necessary to obtain one string from the other.
 */
public class LevenshteinDistance {

	private static int max = Integer.MAX_VALUE;

	public static int d(String s1, String s2) {
		dfs(s1, s2, 0, 0);
		return max;
	}

	private static int dfs(String s1, String s2, int i, int count) {
		if (count > max) {
			return count;
		}

		if (s1.length() <= i && s2.length() <= i) {
			if (count < max) {
				max = count;
			}

			return count;
		}

		if (s1.length() <= i) {
			count += s2.length() - i;
			if (count < max) {
				max = count;
			}

			return count;
		}

		if (s2.length() <= i) {
			count += s1.length() - i;
			if (count < max) {
				max = count;
			}

			return count;
		}

		if (s1.charAt(i) == s2.charAt(i)) {
			return dfs(s1, s2, i + 1, count);
		}

		// add
		int c1 = dfs(s1.substring(0, i) + s2.charAt(i) + s1.substring(i, s1.length()), s2, i + 1, count + 1);

		// delete
		int c2 = dfs(s1.substring(0, i) + s1.substring(i + 1, s1.length()), s2, i, count + 1);

		// substitute
		int c3 = dfs(s1.substring(0, i) + s2.charAt(i) + s1.substring(i + 1, s1.length()), s2, i + 1, count + 1);

		return min(c1, c2, c3);
	}

	private static int min(int a, int b, int c) {
		if (a < b && a < c) {
			return a;
		}

		if (b < c) {
			return b;
		}

		return c;
	}
}