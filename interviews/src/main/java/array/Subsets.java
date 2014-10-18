package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Return all the 2^n subsets of a list
 */
public class Subsets {

	public static <E> List<List<E>> f(List<E> list) {
		List<List<E>> subsets = new ArrayList<>();
		dfs(list, subsets);
		return subsets;
	}

	private static <E> void dfs(List<E> list, List<List<E>> subsets) {
		if (subsets.contains(list)) {
			return;
		}

		subsets.add(list);

		for (int i = 0; i < list.size(); i++) {
			List<E> subset = new ArrayList<>(list);
			subset.remove(i);
			dfs(subset, subsets);
		}
	}
}