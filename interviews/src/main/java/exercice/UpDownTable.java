package exercice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UpDownTable {

	public static void main(String[] args) {
		int[] list = {8, 4, 10, 4, 6, 6};

		// La réponse doit être doit
		// mais renvoit 4 car on swap le dernier 6 pour rien
		// Il faut checker les doublons
		System.out.println(minSwaps(list));
	}

	public static int minSwaps(int[] list) {
		List<Integer> ints = new ArrayList<>();
		for (int i : list) {
			ints.add(i);
		}

		Arrays.sort(list); // O(n * log n)

		int count = 0;

		for (int i = 0; i < list.length; i++) { // O(n)
			int index = ints.indexOf(list[i]);

			if (index < ints.size() - 1 - index) {
				count += index;
			} else {
				count += ints.size() - 1 -  index;
			}

			ints.remove(index);
		}

		return count;
	}
}