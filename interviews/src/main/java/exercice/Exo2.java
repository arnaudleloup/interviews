package exercice;

public class Exo2 {

	public static void f(int[] t) {
		// Two fingers
		int i = 0;
		int j = t.length - 1;

		while (i < j) { // O(n)
			if (t[i] > 0 && t[j] < 0) {
				int temp = t[i];
				t[i] = t[j];
				t[j] = temp;
			}

			if (t[i] <= 0) {
				i++;
			}

			if (t[j] >= 0) {
				j--;
			}
		}
	}
}
