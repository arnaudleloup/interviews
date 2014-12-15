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

	@Test
	public void test3() {
		NavigableSet<Integer> t = new TreeSet<>();
		t.add(10);
		t.add(5);
		t.add(3);
		t.add(12);
		t.add(11);
		t.add(1);

		int x = 100;

		Pair<Integer, Integer> p = FindSum.f(t, x);
		assertNull(p);
	}

	@Test
	public void test4() {
		NavigableSet<Integer> t = new TreeSet<>();
		t.add(10);
		t.add(5);
		t.add(3);
		t.add(12);
		t.add(11);
		t.add(1);

		int x = -1;

		Pair<Integer, Integer> p = FindSum.f(t, x);
		assertNull(p);
	}

	@Test
	public void test11() {
		int[] a = {10, 5, 3, 12, 11, 1};
		FindSum bst = new FindSum(a);
		int x = 9;
		Pair<Integer, Integer> p = bst.find(x);
		assertNull(p);
	}

	@Test
	public void test12() {
		int[] a = {10, 5, 3, 12, 11, 1};
		FindSum bst = new FindSum(a);
		int x = 8;
		Pair<Integer, Integer> p = bst.find(x);
		assertNotNull(p);
		assertEquals(x, p.getX() + p.getY());
	}

	@Test
	public void test13() {
		int[] a = {30, 15, 7, 4, 1, 3, 10, 9, 13, 12, 14, 50, 70, 40, 45, 47, 49, 46};
		FindSum bst = new FindSum(a);
		int x = 49;
		Pair<Integer, Integer> p = bst.find(x);
		assertNotNull(p);
		assertEquals(x, p.getX() + p.getY());
	}

	@Test
	public void test14() {
		int[] a = {30, 15, 7, 4, 1, 3, 10, 9, 13, 12, 14, 50, 70, 40, 45, 47, 49, 46};
		FindSum bst = new FindSum(a);
		int x = 28;
		Pair<Integer, Integer> p = bst.find(x);
		assertNotNull(p);
		assertEquals(x, p.getX() + p.getY());
	}

	@Test
	public void test15() {
		int[] a = {30, 15, 7, 4, 1, 3, 10, 9, 13, 12, 14, 50, 70, 40, 45, 47, 49, 46};
		FindSum bst = new FindSum(a);
		int x = 32;
		Pair<Integer, Integer> p = bst.find(x);
		assertNull(p);
	}
}