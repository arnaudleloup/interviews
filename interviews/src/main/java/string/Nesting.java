package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class Nesting {

	/**
	 * Returns true if a set of parenthesis is nested.
	 * ()() -> return true
	 * ( -> return false
	 */
	public static boolean f(String s) {
		String REGEX = "[()]*";
		if (!s.matches(REGEX)) {
			throw new IllegalArgumentException();
		}

		int count = 0;
		char OPENED = '(';
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			if (c == OPENED) {
				count++;
			} else {
				count--;
			}

			if (count < 0) {
				return false;
			}
		}

		return count == 0;
	}

	/**
	 * Returns true if a set of parenthesis and brackets are nested.
	 * (){} -> return true
	 * ([]) -> return true
	 * ([)] -> return false
	 * @param s
	 * @return
	 */
	public static boolean f2(String s) {
		String REGEX = "[(){}\\[\\]]*";
		if (!s.matches(REGEX)) {
			throw new IllegalArgumentException();
		}

		Deque<Character> stack = new ArrayDeque<>();
		char OPENED_PARENTHESIS = '(';
		char CLOSED_PARENTHESIS = ')';
		char OPENED_BRACKET = '{';
		char CLOSED_BRACKET = '}';
		char OPENED_RANGE = '[';
		char CLOSED_RANGE = ']';
		int n = s.length();

		for (int i = 0; i < n;i ++) {
			char c = s.charAt(i);
			if (c == OPENED_BRACKET || c == OPENED_PARENTHESIS || c == OPENED_RANGE) {
				stack.addLast(c);
			} else {
				char last = stack.removeLast();

				if ((c == CLOSED_BRACKET && last != OPENED_BRACKET)
						|| (c == CLOSED_PARENTHESIS && last != OPENED_PARENTHESIS)
						||(c == CLOSED_RANGE && last != OPENED_RANGE)) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}