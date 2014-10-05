package exercice.queryexpansion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * From a query, such as "pictures of cat", return the top k similar queries.
 * Each word of the original query has some synonyms with some probability.
 */
public class TopKQueryExpansion {

	public static List<String[]> queryExpansion(String[] query,
			Map<String, List<QuerySynonym>> synonyms, int k) {
		PriorityQueue<PartialQuery> topK = new PriorityQueue<>();
		PartialQuery partial = new PartialQuery(query.length);
		dfs(query, partial, synonyms, topK, k);

		// Build the queries to be returned from the priority queue
		List<String[]> queries = buildQueries(topK, query.length);

		return queries;
	}

	/**
	 * Build top k similar queries of an original query.
	 * 
	 * @param original the original query.
	 * @param partial the partial query being built.
	 * @param synonyms the dictionary of synonyms.
	 * @param topK the heap containing the top k queries
	 * @param k the max number of similar queries
	 */
	private static void dfs(String[] original, PartialQuery partial,
			Map<String, List<QuerySynonym>> synonyms, PriorityQueue<PartialQuery> topK, int k) {
		if (topK.size() == k && partial.getProbability() < topK.peek().getProbability()) {
			return;
		}

		if (partial.getWords() == original.length) {
			topK.add(new PartialQuery(partial));
			if (topK.size() > k) {
				topK.poll();
			}

			return;
		}

		String nextWord = original[partial.getWords()];
		for (QuerySynonym synonym : synonyms.get(nextWord)) { // next synonym to be handled
			partial.add(synonym);
			dfs(original, partial, synonyms, topK, k);
			partial.removeLast();
		}
	}

	private static List<String[]> buildQueries(PriorityQueue<PartialQuery> topK, int queryLength) {
		List<String[]> queries = new ArrayList<>();

		while (!topK.isEmpty()) {
			PartialQuery list = topK.poll();
			String[] q = new String[queryLength];
			int i = 0;
			for(QuerySynonym s : list) {
				q[i++] = s.getValue();
			}

			queries.add(q);
		}

		return queries;
	}
}