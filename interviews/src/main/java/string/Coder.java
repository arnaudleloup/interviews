package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Let a=1, b=2, c=3,....z=26.
 * Given a string, find all possible codes that string can generate.
 *
 * For example:
 * Input: "1123". You need to generate all valid alphabet codes from this string.
 * Output:
 * aabc // a = 1, a = 1, b = 2, c = 3
 * kbc  // k = 11, b = 2, c= 3
 * alc  // a = 1, l = 12, c = 3
 * aaw  // a= 1, a =1, w= 23
 * kw   // k = 11, w = 23
 */
public class Coder {

	private static char[] map = new char[]
			{'!',
		'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
		'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
		's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			};

	public static Set<String> f(String s) {
		int n = s.length();
		Set<String> set = new HashSet<>();
		Integer.valueOf(s.charAt(2));
		dfs(new StringBuilder(), toIntArray(s), 0, set, n);
		return set;
	}

	private static void dfs(StringBuilder sb, int[] codes, int i, Set<String> set, int n) {
		if (i == n) {
			set.add(sb.toString());
			return;
		}

		sb.append(map[codes[i]]);
		dfs(sb, codes, i + 1, set, n);
		sb.deleteCharAt(sb.length() - 1);

		if (i < n - 1 && codes[i] * 10 + codes[i + 1] <= 26) {
			sb.append(map[codes[i] * 10 + codes[i + 1]]);
			dfs(sb, codes, i + 2, set, n);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private static int[] toIntArray(String s) {
		int[] a = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			a[i] = Integer.parseInt(s.substring(i, i + 1));
		}

		return a;
	}
}