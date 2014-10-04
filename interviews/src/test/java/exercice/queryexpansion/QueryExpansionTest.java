package exercice.queryexpansion;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class QueryExpansionTest {

	@Test
	public void test() {
		List<String> query = Arrays.asList("pictures", "of", "cat", "and", "dog");
		Map<String, List<String>> synos = buildSyno();
		List<List<String>> queries = QueryExpansion.queryExpansion(query, synos);

		List<String> query1 = Arrays.asList("pictures", "of", "kitten", "and", "puppy");
		List<String> query2 = Arrays.asList("images", "of", "cat", "or", "puppy");
		List<String> query3 = Arrays.asList("photos", "of", "feline", "and", "cat");
		List<String> query4 = Arrays.asList("draw", "of", "cat", "or", "cat");
		List<String> query5 = Arrays.asList("paint", "of", "dog", "and", "puppy");

		assertTrue(queries.contains(query));
		assertTrue(queries.contains(query1));
		assertTrue(queries.contains(query2));
		assertTrue(queries.contains(query3));
		assertTrue(queries.contains(query4));
		assertTrue(queries.contains(query5));
	}

	private Map<String, List<String>> buildSyno() {
		Map<String, List<String>> synos = new HashMap<>();

		List<String> syno1 = Arrays.asList("pictures", "images", "photos", "draw", "paint");
		synos.put("pictures", syno1);

		List<String> syno2 = Arrays.asList("of");
		synos.put("of", syno2);

		List<String> syno3 = Arrays.asList("cat", "dog", "kitten", "feline");
		synos.put("cat", syno3);

		List<String> syno4 = Arrays.asList("and", "or");
		synos.put("and", syno4);

		List<String> syno5 = Arrays.asList("dog", "cat", "puppy");
		synos.put("dog", syno5);

		return synos;
	}
}
