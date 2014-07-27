package exercice;

public class NegativeFirst {

	public static void f(int[] t) {
		int negativeCount = 0;
		for (int i = 0; i < t.length; i++) { // O(n) time
			if (t[i] < 0) {
				negativeCount++;
			}
		}

		int i = 0;
		int j = 1;
		int negativeCount2 = 0;

		while (negativeCount2 < negativeCount) {
			if (t[i] < 0) {
				i++;
				j++;
				negativeCount2++;
			} else {
				if (t[j] > 0) {
					swap(t, i, j); // swap of positive integer to maintain order
					j++;
				} else {
					swap(t, i, j);
					negativeCount2++;
					i++;
					j = i + 1; // On reset j to i + 1
				}
			}
		}
	}

	private static void swap(int[] t, int i, int j) {
		int temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}
}