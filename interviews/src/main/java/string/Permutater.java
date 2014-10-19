package string;

import java.util.HashSet;
import java.util.Set;

/**
 * Return all the permutations of a String.
 */
public class Permutater {

	public static Set<String> f(String s) {
		int n = s.length();
		Set<String> set = new HashSet<>();
		dfs(new char[s.length()], s, new HashSet<Integer>(), 0, set, n);
		return set;
	}

	private static void dfs(char[] a, String s, Set<Integer> done, int i, Set<String> set, int n) {
		if (i == n) {
			set.add(new String(a));
			return;
		}

		for (int j = 0; j < n; j++) {
			if (!done.contains(j)) {
				a[i] = s.charAt(j);
				done.add(j);
				dfs(a, s, done, i + 1, set, n);
				done.remove(j);
			}
		}
	}
}