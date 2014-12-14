package linkedlist;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import datastructure.linkedlist.Node;

public class LinkedListPartitionTest {

	@Test
	public void test() {
		int[] t = {1, 5, 13, 2, 8, 5};
		Node<Integer> node = LinkedListUtils.build(t);
		int x = 6;

		LinkedListPartition.partition(node, x);

		assertTrue(node.item < x);
		assertTrue(node.next.item < x);
		assertTrue(node.next.next.item < x);
		assertTrue(node.next.next.next.item < x);
		assertTrue(node.next.next.next.next.item > x);
		assertTrue(node.next.next.next.next.next.item > x);
	}

	@Test
	public void test2() {
		int[] t = {13, 5, 1, 2, 8, 5};
		Node<Integer> node = LinkedListUtils.build(t);
		int x = 6;

		Node<Integer> first = LinkedListPartition.partition(node, x);

		System.out.println(first);
		assertTrue(first.item < x);
		assertTrue(first.next.item < x);
		assertTrue(first.next.next.item < x);
		assertTrue(first.next.next.next.item < x);
		assertTrue(first.next.next.next.next.item > x);
		assertTrue(first.next.next.next.next.next.item > x);
	}
}