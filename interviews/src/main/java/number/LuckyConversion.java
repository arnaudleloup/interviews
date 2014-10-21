package number;

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
	 * Space complexity: O(1)
	 */
	public static int f(String a, String b) {
		int count = 0;
		int n = a.length();
		char[] ca = a.toCharArray();
		char[] cb = b.toCharArray();

		int j = 1;
		for (int i = 0; i < n ; i++) {
			char c = ca[i];
			char d = cb[i];

			if (c != d) {
				while (j < n) {
					if (ca[j] == d && cb[j] == c) {
						swap(ca, i, j++);
						break;
					}

					j++;
				}

				if (j == n) {
					ca[i] = d;
				}

				count++;
			}
		}

		return count;
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

	private static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}