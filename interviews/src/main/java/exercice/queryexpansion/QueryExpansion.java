package exercice.queryexpansion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * From a query, such as "pictures of cat", return all the similar queries.
 * Each word of the original query has some synonyms.
 */
public class QueryExpansion {

	public static List<List<String>> queryExpansion(List<String> query, Map<String, List<String>> synos) {
		List<List<String>> all = new ArrayList<>(); // all queries
		List<String> partial = new ArrayList<>(); // current query
		dfs(query, partial, all, synos);

		return all;
	}

	/**
	 * Build all similar queries of an original query.
	 * 
	 * @param original the original query.
	 * @param partial the partial query being built.
	 * @param all the already built queries.
	 * @param synos the dictionary of synonyms.
	 */
	private static void dfs(List<String> original, List<String> partial, List<List<String>> all,
			Map<String, List<String>> synos) {
		if (partial.size() == original.size()) {
			all.add(partial);
			return;
		}

		for (String syno : synos.get(original.get(partial.size()))) {
			List<String> newCq = new ArrayList<>(partial);
			newCq.add(syno);
			dfs(original, newCq, all, synos);
		}
	}
}