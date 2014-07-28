package string;

public class SubstringReversal {

	/**
	 * You are given a String S. The string can have up to 2500 characters.
	 * You have to reverse exactly one substring of S.
	 * Formally, you have to choose two 0-based indices {x,y} such that x <= y,
	 * and then you have to reverse the order of the letters with indices x through y, inclusive.
	 * That is, S[x]S[x+1]...S[y] becomes S[y]...S[x+1]S[x].
	 * For example, if S="abcdefg", you can choose the indices {2,5} to obtain "abfedcg",
	 * the indices {0,1} to obtain "bacdefg", or the indices {3,3} to obtain "abcdefg".
	 * (In the last example, only one letter was selected, so the string did not change.)
	 * Your goal is to produce the lexicographically smallest string possible.
	 * Return a int[] containing two elements: the optimal indices x and y.
	 * If there are multiple optimal choices, find the one with the smallest x.
	 * If there are still multiple optimal choices, find the one with the smallest y.
	 * 
	 * http://community.topcoder.com/stat?c=problem_statement&pm=12516
	 * 
	 * Solved in O(n) time, O(1) space, where n = S.length()
	 */
	public static int[] solve(String S) {
		int x = findX(S);

		if (x == S.length() - 1) { // already sorted, nothing to reverse
			int[] t = {0, 0};
			return t;
		} else {
			x++;
		}

		int y = findY(S, x);

		int[] t = {x, y};
		return t;
	}

	/**
	 * O(n) time, O(1) space
	 */
	private static int findX(String S) {
		int x = 0;
		int i = 1;

		//
		while (x != -1 && i < S.length()) { // O(n) time, O(1) space
			char c = S.charAt(i);

			if (c >= S.charAt(x)) {
				x++;
			} else {
				while (x != -1 && c < S.charAt(x)) { // get back!
					x--;
				}
			}

			i++;
		}

		return x;
	}

	/**
	 * O(n) time, O(1) space
	 */
	private static int findY(String S, int x) {
		int y = 0;
		int min = Integer.MAX_VALUE;
		for (int i = x + 1; i < S.length(); i++) { // O(n) time, O(1) space
			char c = S.charAt(i);
			if (c < min || (c == min && i == y+ 1)) {
				y = i;
				min = c;
			}
		}

		return y;
	}
}