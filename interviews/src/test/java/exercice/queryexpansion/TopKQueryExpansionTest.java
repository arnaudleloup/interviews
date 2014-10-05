package exercice.queryexpansion;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class TopKQueryExpansionTest {

	@Test
	public void test() {
		String[] query = {"pictures", "of", "cat", "and", "dog"};
		Map<String, List<QuerySynonym>> synos = buildSyno();
		int k = 10;
		List<String[]> queries = TopKQueryExpansion.queryExpansion(query, synos, k);

		assertEquals(10, queries.size());
		for (String[] list : queries) {
			for (String s : list) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}

	private Map<String, List<QuerySynonym>> buildSyno() {
		Map<String, List<QuerySynonym>> synos = new HashMap<>();

		List<QuerySynonym> syno1 = Arrays.asList(new QuerySynonym("pictures", 0.8),
				new QuerySynonym("images", 0.8),
				new QuerySynonym("photos", 0.7),
				new QuerySynonym("draw", 0.3),
				new QuerySynonym("paint", 0.2));
		synos.put("pictures", syno1);

		List<QuerySynonym> syno2 = Arrays.asList(new QuerySynonym("of", 1));
		synos.put("of", syno2);

		List<QuerySynonym> syno3 = Arrays.asList(new QuerySynonym("cat", 1),
				new QuerySynonym("dog", 0.3),
				new QuerySynonym("kitten", 0.9),
				new QuerySynonym("feline", 0.7));
		synos.put("cat", syno3);

		List<QuerySynonym> syno4 = Arrays.asList(new QuerySynonym("and", 1),
				new QuerySynonym("or", 0.9));
		synos.put("and", syno4);

		List<QuerySynonym> syno5 = Arrays.asList(new QuerySynonym("dog", 1),
				new QuerySynonym("cat", 0.3),
				new QuerySynonym("puppy", 0.9));
		synos.put("dog", syno5);

		return synos;
	}
}