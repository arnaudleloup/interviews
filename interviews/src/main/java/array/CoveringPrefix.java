package array;

import java.util.HashSet;
import java.util.Set;

public class CoveringPrefix {

	public static int f(int[] a) {
		Set<Integer> seen = new HashSet<>();
		int index = -1;

		for (int i = 0; i < a.length; i++) {
			if (!seen.contains(a[i])) {
				seen.add(a[i]);
				index = i;
			}
		}

		return index;
	}
}
