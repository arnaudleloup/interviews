package string;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

public class TrieTest {

	@Test
	public void test() {
		String[] strings = {"she", "sells", "sea", "shells", "by", "the", "sea", "shore"};

		Trie trie = new Trie();
		int i = 0;
		for (String s : strings) {
			trie.add(s, i++);
		}

		assertTrue(!trie.isEmpty());
		assertEquals(7, trie.size());

		assertEquals(0, trie.get(strings[0]));
		assertEquals(1, trie.get(strings[1]));
		assertEquals(6, trie.get(strings[2]));
		assertEquals(3, trie.get(strings[3]));
		assertEquals(4, trie.get(strings[4]));
		assertEquals(5, trie.get(strings[5]));
		assertEquals(7, trie.get(strings[7]));

		Set<String> keys = trie.keys();
		assertTrue(keys.contains(strings[0]));
		assertTrue(keys.contains(strings[1]));
		assertTrue(keys.contains(strings[2]));
		assertTrue(keys.contains(strings[3]));
		assertTrue(keys.contains(strings[4]));
		assertTrue(keys.contains(strings[5]));
		assertTrue(keys.contains(strings[6]));
		assertTrue(keys.contains(strings[7]));

		Set<String> prefix1 = trie.keysWithPrefix("se");
		assertEquals(2, prefix1.size());
		assertTrue(prefix1.contains("sea"));
		assertTrue(prefix1.contains("sells"));
	}

}
