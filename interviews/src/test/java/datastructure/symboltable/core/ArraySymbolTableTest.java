package datastructure.symboltable.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import datastructure.symboltable.api.OrderedSymbolTable;

public class ArraySymbolTableTest {

	@Test
	public void test() {
		OrderedSymbolTable<Integer, Integer> t = new ArraySymbolTable<>();

		t.put(1, 1);
		t.put(3, 3);
		t.put(6, 6);
		assertEquals(3, t.size());
		assertTrue(t.contains(3));
		assertFalse(t.contains(8));

		assertEquals(2, t.rank(5));
		assertEquals(2, t.rank(6));


		t.delete(2);
		t.delete(6);
		assertEquals(2, t.size());
		assertEquals(3, (int) t.get(3));
	}
}
