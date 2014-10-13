package tree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import lib.Pair;

import org.junit.Test;

public class BSTSumTest {

	@Test
	public void test() {
		int[] a = {10, 5, 3, 12, 11, 1};
		BSTSum bst = new BSTSum(a);
		int x = 9;
		Pair<Integer, Integer> p = bst.sum(x);
		assertNull(p);
	}

	@Test
	public void test2() {
		int[] a = {10, 5, 3, 12, 11, 1};
		BSTSum bst = new BSTSum(a);
		int x = 8;
		Pair<Integer, Integer> p = bst.sum(x);
		assertNotNull(p);
		assertEquals(x, p.getX() + p.getY());
	}

	@Test
	public void test3() {
		int[] a = {30, 15, 7, 4, 1, 3, 10, 9, 13, 12, 14, 50, 70, 40, 45, 47, 49, 46};
		BSTSum bst = new BSTSum(a);
		int x = 49;
		Pair<Integer, Integer> p = bst.sum(x);
		assertNotNull(p);
		assertEquals(x, p.getX() + p.getY());
	}

	@Test
	public void test4() {
		int[] a = {30, 15, 7, 4, 1, 3, 10, 9, 13, 12, 14, 50, 70, 40, 45, 47, 49, 46};
		BSTSum bst = new BSTSum(a);
		int x = 28;
		Pair<Integer, Integer> p = bst.sum(x);
		assertNotNull(p);
		assertEquals(x, p.getX() + p.getY());
	}

	@Test
	public void test5() {
		int[] a = {30, 15, 7, 4, 1, 3, 10, 9, 13, 12, 14, 50, 70, 40, 45, 47, 49, 46};
		BSTSum bst = new BSTSum(a);
		int x = 32;
		Pair<Integer, Integer> p = bst.sum(x);
		assertNull(p);
	}
}