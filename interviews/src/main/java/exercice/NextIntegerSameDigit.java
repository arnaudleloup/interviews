package exercice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NextIntegerSameDigit {

	/**
	 * Given an integer, returns the next (smallest one greater than) integer containing the same digits.
	 * Example: 217650  --> 250167, 3276510 --> 3501267, 12301 --> 12310.
	 * 
	 * If n == number of digits of the integer,
	 * this algorithms runs in O(n) time and O(n) space
	 */
	public static int f(int num) {
		String s = String.valueOf(num);
		int switchIndex = -1;
		char max = s.charAt(s.length() - 1);
		List<Character> chars = new ArrayList<>(); // O(n) space
		chars.add(s.charAt(s.length() - 1));
		for (int i = s.length() - 2; i >= 0; i--) { // O(n) time
			chars.add(s.charAt(i));

			if (s.charAt(i) >= max) {
				max = s.charAt(i);
			} else {
				switchIndex = i;
				break;
			}
		}

		if (switchIndex == -1) {
			return num;
		}

		char m = s.charAt(switchIndex);
		char c = '9';
		for (char d : chars) { // O(n) time
			if (d > m && d < c) {
				c = d;
			}
		}

		chars.remove(new Character(c));
		Collections.sort(chars);
		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(0, switchIndex)).append(c);

		for (char d : chars) { // O(n) time
			sb.append(d);
		}

		return Integer.valueOf(sb.toString());
	}
}