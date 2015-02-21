package string;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * You are given a String of number characters (S), like the following for example:
 * "132493820173849029382910382"
 * Now, let's assume we tie letters to numbers in order such that:
 * 
 * A = "0"
 * B = "1"
 * C = "2"
 * ...
 * M = "12"
 * N = "13"
 * ...
 * Y = "24"
 * Z = "25"
 * 
 * Write an algorithm to determine how many strings of letters we can make with S,
 * by converting from numbers to letters.
 */
public class StringNumber {

	public static int f(String s) {
		AtomicInteger count = new AtomicInteger();
		dfs(s, 0, count);
		return count.get();
	}

	private static void dfs(String s, int i, AtomicInteger count) {
		int n = s.length();
		if (i == n) {
			count.incrementAndGet();
			return;
		}

		dfs(s, i + 1, count);

		if (i < n - 1) {
			String sub = s.substring(i, i + 2);
			if (Integer.valueOf(sub) <= 25) {
				dfs(s, i + 2, count);
			}
		}
	}
}