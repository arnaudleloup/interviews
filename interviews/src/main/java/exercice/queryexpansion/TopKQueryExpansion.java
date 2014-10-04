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

	public static List<List<String>> queryExpansion(List<String> query,
			Map<String, List<QuerySynonym>> synos, int k) {
		PriorityQueue<PartialQuery> heap = new PriorityQueue<>();
		PartialQuery partial = new PartialQuery();
		dfs(query, partial, synos, heap, k);

		// Build the queries to be returned from the priority queue
		List<List<String>> queries = buildQueries(heap);

		return queries;
	}

	/**
	 * Build top k similar queries of an original query.
	 * 
	 * @param original the original query.
	 * @param partial the partial query being built.
	 * @param synos the dictionary of synonyms.
	 * @param heap the heap containing the top k queries
	 * @param k the max number of similar queries
	 */
	private static void dfs(List<String> original, PartialQuery partial,
			Map<String, List<QuerySynonym>> synos, PriorityQueue<PartialQuery> heap, int k) {
		if (heap.size() == k && partial.getProba() < heap.peek().getProba()) {
			return;
		}

		if (partial.size() == original.size()) {
			heap.add(partial);
			if (heap.size() > k) {
				heap.poll();
			}

			return;
		}

		for (QuerySynonym s : synos.get(original.get(partial.size()))) {
			PartialQuery newCq = new PartialQuery(partial);
			newCq.add(s);
			dfs(original, newCq, synos, heap, k);
		}
	}

	private static List<List<String>> buildQueries(PriorityQueue<PartialQuery> heap) {
		List<List<String>> queries = new ArrayList<>();
		while (!heap.isEmpty()) {
			PartialQuery list = heap.poll();
			List<String> q = new ArrayList<>();
			for(QuerySynonym s : list) {
				q.add(s.getValue());
			}

			queries.add(q);
		}

		return queries;
	}
}