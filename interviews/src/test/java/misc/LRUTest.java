package misc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class LRUTest {

	@Test
	public void test() {
		int n = 5;
		LRU<Integer, Integer> lru = new LRU<>(n);

		lru.insert(1, 1);
		lru.insert(2, 2);
		lru.insert(3, 3);
		assertEquals(new Integer(1), lru.get(1));
		assertEquals(new Integer(2), lru.get(2));
		assertEquals(new Integer(3), lru.get(3));
		assertEquals(3, lru.size());

		lru.insert(2, -1);
		assertEquals(new Integer(-1), lru.get(2));
		assertEquals(3, lru.size());

		lru.insert(4, 4);
		lru.insert(5, 5);
		assertEquals(5, lru.size());

		lru.insert(6, 6);
		assertEquals(5, lru.size());
		assertNull(lru.get(1));

		lru.insert(7, 7);
		assertNull(lru.get(3));
		assertEquals(new Integer(-1), lru.get(2));
	}
}