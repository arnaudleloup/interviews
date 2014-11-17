package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Given an arraylist of N integers,
 * (1) find a non-empty subset whose sum is a multiple of N.
 * (2) find a non-empty subset whose sum is a multiple of 2N.
 * Compare the solutions of the two questions.
 */
public class KMultipleSubset {

	/**
	 * n = list.size()
	 * Time complexity: O(2^n)
	 * Space complexity: O(n)
	 */
	public static List<Integer> f(List<Integer> list, int k) {
		List<Integer> subset = new ArrayList<>();

		if (dfs(list, k, 0, subset, 0)) {
			return subset;
		}

		return null;
	}

	private static boolean dfs(List<Integer> list, int k, int i, List<Integer> subset, int currentSum) {
		if (!subset.isEmpty() && currentSum % k == 0) {
			return true;
		}

		if (i == list.size()) {
			return false;
		}
		if (dfs(list, k, i + 1, subset, currentSum)) {
			return true;
		}

		currentSum = (currentSum + list.get(i)) % k;
		subset.add(list.get(i));
		if (dfs(list, k, i + 1, subset, currentSum)) {
			return true;
		}

		currentSum = (currentSum - list.get(i)) % k;
		subset.remove(subset.size() - 1);
		return false;
	}

	/**
	 * n = list.size()
	 * Time complexity: O(k * n^2)
	 * Space complexity: O(k * n)
	 */
	public static List<Integer> f2(List<Integer> list, int k) {
		// key = current sum, values = subsets
		Map<Integer, List<Integer>> subsets = new HashMap<>();
		subsets.put(0, new ArrayList<Integer>());

		for (int e : list) {
			Set<Entry<Integer, List<Integer>>> entries = new HashSet<>(subsets.entrySet());
			for (Entry<Integer, List<Integer>> entry : entries) { // k sums
				int sum = (entry.getKey() + e) % k;

				List<Integer> sbst = new ArrayList<>(entry.getValue());
				sbst.add(e);
				if (sum % k == 0) {
					return sbst;
				}

				if (!subsets.containsKey(sum)) {
					subsets.put(sum, sbst);
				}
			}
		}

		return null;
	}
}