package string;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeralToInteger {

	private static final String REGEX = "M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})";

	private static Map<Character, Integer> map = new HashMap<>();

	static {
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
	}

	public static int f(String s) {
		if (!s.matches(REGEX)) {
			System.out.println(s);
			throw new IllegalArgumentException();
		}

		int value = 0;
		int acc = map.get(s.charAt(0));
		int previous = map.get(s.charAt(0));

		for (int i = 1; i < s.length(); i++) {
			char c = s.charAt(i);
			int v = map.get(c);

			if (v == previous) {
				acc += v;
			} else if (v < previous) {
				value += acc;
				acc = v;
				previous = v;
			} else {
				value -= acc;
				acc = v;
				previous = v;
			}
		}
		value += acc;

		return value;
	}

	public static int f2(String s) {
		if (!s.matches(REGEX)) {
			throw new IllegalArgumentException();
		}

		int value = 0;
		int previous = 0;

		for (int i = s.length() - 1; i >= 0; i--) {
			char c = s.charAt(i);
			int v = map.get(c);

			if (v < previous) {
				value -= v;
			} else {
				value += v;
				previous = v;
			}
		}

		return value;
	}
}