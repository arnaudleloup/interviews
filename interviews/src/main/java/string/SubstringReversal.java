package string;

/**
 * You are given a String s. The string can have up to 2500 characters.
 *
 * You have to reverse exactly one substring of s. Formally, you have to choose two 0-based indices
 * {x,y} such that x <= y, and then you have to reverse the order of the letters with indices x
 * through y, inclusive. That is, S[x]S[x+1]...S[y] becomes S[y]...S[x+1]S[x].
 *
 * For example, if s="abcdefg", you can choose the indices {2,5} to obtain "abfedcg", the indices
 * {0,1} to obtain "bacdefg", or the indices {3,3} to obtain "abcdefg". (In the last example, only
 * one letter was selected, so the string did not change.)
 *
 * Your goal is to produce the lexicographically smallest string possible. Return a int[] containing
 * two elements: the optimal indices x and y. If there are multiple optimal choices, find the one
 * with the smallest x. If there are still multiple optimal choices, find the one with the smallest
 * y.
 */
public class SubstringReversal {

	public static int[] solve(String S) {
		int y = -1;
		for (int i = 1; i < S.length(); i++) {
			if (S.charAt(i) < S.charAt(i - 1)) {
				y = i;
				break;
			}
		}

		if (y == -1) {
			return new int[] {0, 0};
		}

		// find the smallest one after y
		for (int i = y + 1; i < S.length(); i++) {
			if (S.charAt(i) < S.charAt(y)) {
				y = i;
			}
		}

		int x = -1;
		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) > S.charAt(y)) {
				x = i;
				break;
			}
		}

		return new int[] {x, y};
	}
}