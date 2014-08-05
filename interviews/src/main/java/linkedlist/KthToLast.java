package linkedlist;

import linkedlist.node.Node;

public class KthToLast {

	/**
	 * Find the kth to last element of a singly linked list.
	 * 
	 * O(n) / O(1)
	 */
	public static <E> E kthToLast(Node<E> first, int k) {
		int n = 0;
		Node<E> actual = first;

		while (actual != null) {
			n++;
			actual = actual.next;
		}

		actual = first;
		int count = 1;

		while (count != n - k) {
			count++;
			actual = actual.next;
		}

		return actual.item;
	}
}