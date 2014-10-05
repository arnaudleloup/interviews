package exercice.queryexpansion;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class QueryExpansionTest {

	@Test
	public void test() {
		String[] query = {"pictures", "of", "cat", "and", "dog"};
		Map<String, List<String>> synos = buildSyno();
		List<String[]> queries = QueryExpansion.queryExpansion(query, synos);

		assertEquals(120, queries.size()); // 5 * 1 * 4 * 2 * 3
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
