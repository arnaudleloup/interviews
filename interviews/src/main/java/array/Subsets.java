package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Return all the 2^n subsets of a list
 */
public class Subsets {

	public static <E> List<List<E>> f(List<E> list) {
		List<List<E>> subsets = new ArrayList<>();
		dfs(list, 0, new ArrayList<E>(), subsets);
		return subsets;
	}

	private static <E> void dfs(List<E> list, int i, List<E> subset, List<List<E>> subsets) {
		if (i == list.size()) {
			subsets.add(new ArrayList<>(subset));
			return;
		}

		dfs(list, i + 1, subset, subsets);
		subset.add(list.get(i));
		dfs(list, i + 1, subset, subsets);
		subset.remove(list.get(i));
	}
}