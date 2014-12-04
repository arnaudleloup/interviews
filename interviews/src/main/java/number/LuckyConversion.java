package number;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two strings a and b of the same length n that consist only of lucky digits (4 and 7).
 * What is the minimum number of operations that are needed to make string a equal to string b?
 * You can only perform operations of two types:
 *   - replace any one digit from string a by its opposite (i.e. replace 4 by 7 and 7 by 4)
 *   - swap any pair of digits in string a
 */
public class LuckyConversion {

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(n)
	 */
	public static int f(String a, String b) {
		int count = 0;
		char[] ca = a.toCharArray();
		char[] cb = b.toCharArray();
		Set<Integer> fourToSeven = fourToSeven(a, b);
		Set<Integer> sevenToFour = sevenToFour(a, b);

		for (int i = 0; i < a.length(); i++) {
			if (ca[i] == '4' && cb[i] == '7') {
				if (!sevenToFour.isEmpty()) {
					int index = sevenToFour.iterator().next();
					swap(ca, i, index);
					sevenToFour.remove(index);
					fourToSeven.remove(i);
				}
				count++;
			} else if (ca[i] == '7' && cb[i] == '4') {
				if (!fourToSeven.isEmpty()) {
					int index = fourToSeven.iterator().next();
					swap(ca, i, index);
					fourToSeven.remove(index);
					sevenToFour.remove(i);
				}
				count++;
			}
		}

		return count;
	}

	private static Set<Integer> fourToSeven(String a, String b) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '4' && b.charAt(i) != '4') {
				set.add(i);
			}
		}

		return set;
	}

	private static Set<Integer> sevenToFour(String a, String b) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == '7' && b.charAt(i) != '7') {
				set.add(i);
			}
		}

		return set;
	}

	private static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	/**
	 * Time complexity: O(n)
	 * Space complexity: O(1)
	 */
	public static int f2(String a, String b) {
		int n = a.length();
		int count4To7 = 0;
		int count7To4 = 0;

		for (int i = 0; i < n; i++) {
			if (a.charAt(i) == b.charAt(i)) {
				continue;
			}

			if (a.charAt(i) == '4') {
				count4To7++;
			} else {
				count7To4++;
			}
		}

		return Math.max(count4To7, count7To4);
	}
}