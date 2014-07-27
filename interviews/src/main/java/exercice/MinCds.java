package exercice;

import java.util.Arrays;

public class MinCds {

	public int minCds2(int X, int[] sizes) { // O(log n)
		Arrays.sort(sizes); // O(log n)

		int count = 0;
		int up = 0;
		int down = sizes.length;

		while (up < down) { // O(n)
			down--;

			if (sizes[up] + sizes[down] <= X) {
				up++;
			}

			count++;
		}

		return count;
	}
}