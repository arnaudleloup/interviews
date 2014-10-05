package exercice.queryexpansion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * From a query, such as "pictures of cat", return all the similar queries.
 * Each word of the original query has some synonyms.
 */
public class QueryExpansion {

	public static List<String[]> queryExpansion(String[] query, Map<String, List<String>> synonyms) {
		List<String[]> all = new ArrayList<>(); // all queries
		String[] partial = new String[query.length]; // current query
		dfs(query, partial, all, synonyms, 0);

		return all;
	}

	/**
	 * Build all similar queries of an original query.
	 * 
	 * @param original the original query.
	 * @param partial the partial query being built.
	 * @param all the already built queries.
	 * @param synonyms the dictionary of synonyms.
	 * @param i the i-th word of the original query to be considered.
	 */
	private static void dfs(String[] original, String[] partial, List<String[]> all,
			Map<String, List<String>> synonyms, int i) {
		if (i == original.length) {
			all.add(copy(partial));
			return;
		}

		String nextWord = original[i];
		for (String synonym : synonyms.get(nextWord)) { // next synonym to be handled
			partial[i] = synonym;
			dfs(original, partial, all, synonyms, ++i);
			i--;
			partial[i] = null;
		}
	}

	private static String[] copy(String[] a) {
		String[] c = new String[a.length];

		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
		}

		return c;
	}
}