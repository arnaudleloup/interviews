package datastructure.symboltable.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import datastructure.symboltable.api.SymbolTable;

public class LinkedListSymbolTableTest {

	@Test
	public void test() {
		SymbolTable<Integer, Integer> t = new LinkedListSymbolTable<>();

		t.put(1, 1);
		t.put(3, 3);
		t.put(6, 6);
		assertEquals(3, t.size());
		assertTrue(t.contains(3));
		assertFalse(t.contains(8));
		t.delete(2);
		t.delete(6);
		assertEquals(2, t.size());

		assertEquals(3, (int) t.get(3));
	}
}