package exercice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextIntegerSameDigit {

	private final static int ASCII_0_INDEX = 48;
	/**
	 * Given an integer, returns the next (smallest one greater than) integer containing the same digits.
	 * Example: 217650  --> 250167, 3276510 --> 3501267, 12301 --> 12310.
	 * 
	 * If n == number of digits of the integer,
	 * this algorithms runs in O(n) time and O(n) space
	 */
	public static int f2(int num) {
		String s = String.valueOf(num);
		char[] chars = s.toCharArray();
		int[] digitsFrequency = new int[10];

		int last = chars[chars.length - 1];
		int switchIndex = chars.length - 2;
		while (switchIndex >= 0 && chars[switchIndex] > last) {
			last = chars[switchIndex];
			digitsFrequency[last - ASCII_0_INDEX]++; // in ASCII, the 48ith char is 0
			switchIndex--;
		}

		char[] next = Arrays.copyOfRange(chars, 0, switchIndex);

		int switchIndexValue = chars[switchIndex] - ASCII_0_INDEX;
		int value = switchIndexValue + 1;
		while (digitsFrequency[value] == 0) {
			value++;
		}

		next[switchIndex + 1] = Character.forDigit(value, 10);
		digitsFrequency[value]--;

		int i = 2;
		int j = 0;
		while (switchIndex + i < chars.length) {
			while (digitsFrequency[j] > 0) {
				next[switchIndex + i] = Character.forDigit(digitsFrequency[j], 10);
				i++;
			}

			j++;
		}

		String t = new String(next);
		return Integer.valueOf(t);
	}

	/**
	 * O(n * log(n)) time and O(n) space, where n == number of digits of the integer
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
		Collections.sort(chars); // O(n * log(n))
		StringBuilder sb = new StringBuilder();
		sb.append(s.substring(0, switchIndex)).append(c);

		for (char d : chars) { // O(n) time
			sb.append(d);
		}

		return Integer.valueOf(sb.toString());
	}
}