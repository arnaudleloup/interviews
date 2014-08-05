package linkedlist;

import linkedlist.node.Node;

public class MiddleNodeDeletion {

	/**
	 * Delete a node in the middle of a singly linked list, given only access to that node.
	 * 
	 * Example:
	 * Input: the node from the linked list a > b > c > d > e
	 * Output: nothing is returned but the new linked list
	 * looks like a > b > d > e
	 * 
	 *  O(n) / O(1)
	 */
	public static <E> void delete(Node<E> node) {
		Node<E> current = node;
		Node<E> next = node.next;

		while(next != null) {
			current.item = next.item;
			current = next;
			next = next.next;
		}
	}
}
