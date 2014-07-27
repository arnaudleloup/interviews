package exercice;

public class ReplaceWhiteSpace {

	/**
	 * Write a method to replace all spaces in a String with '%20'.
	 * You may assume that the String has sufficient space at the end to hold
	 * the additional characters.
	 */
	public static void f(char[] chars, int n) {
		char space = ' ';
		int count = 0;

		for (int i = 0; i < n; i++) { // O(n) time
			char c = chars[i];
			if (c == space) {
				count++;
			}
		}

		int did = 0;
		for (int i = n + 2 * count - 1; i >=0; i--) { // O(n) time
			char c = chars[i - 2 * (count - did)];
			if (c != space) {
				chars[i]  = c;
			} else {
				chars[i] = '0';
				chars[i - 1] = '2';
				chars[i - 2] = '%';
				i -= 2;
				did++;
			}
		}
	}
}
