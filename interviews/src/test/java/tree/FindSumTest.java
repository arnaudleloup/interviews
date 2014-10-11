package tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.NavigableSet;
import java.util.TreeSet;

import lib.Pair;

import org.junit.Test;

public class FindSumTest {

	@Test
	public void test() {
		NavigableSet<Integer> t = new TreeSet<>();
		t.add(10);
		t.add(5);
		t.add(3);
		t.add(12);
		t.add(11);
		t.add(1);

		int x = 9;

		Pair<Integer, Integer> p = FindSum.f(t, x);
		assertNull(p);
	}

	@Test
	public void test2() {
		NavigableSet<Integer> t = new TreeSet<>();
		t.add(10);
		t.add(5);
		t.add(3);
		t.add(12);
		t.add(11);
		t.add(1);

		int x = 8;

		Pair<Integer, Integer> p = FindSum.f(t, x);
		assertNotNull(p);
		assertEquals(x, p.getX() + p.getY());
	}
}