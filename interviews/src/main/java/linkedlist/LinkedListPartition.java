package linkedlist;

import linkedlist.node.Node;

public class LinkedListPartition {

	/**
	 * Partition a linked list around a value x, such that all nodes less than x come
	 * before all nodes greater than or equal to x.
	 * 
	 * O(n) / O(1)
	 */
	public static Node<Integer> partition(Node<Integer> first, int x) {
		Node<Integer> firstSmaller = null;
		Node<Integer> lastSmaller = null;
		Node<Integer> firstGreater = null;
		Node<Integer> actualGreater = null;
		Node<Integer> previous = first;
		Node<Integer> current = previous.next;

		if (previous.item < x) {
			firstSmaller = previous;
			lastSmaller = previous;
		} else {
			firstGreater = previous;
			actualGreater = previous;
		}

		while (current != null) {
			if (current.item < x) {
				if (lastSmaller == null) {
					firstSmaller = current;
					lastSmaller = current;
				} else {
					previous.next = current.next;
					lastSmaller.next = current;
					lastSmaller = lastSmaller.next;
				}
			} else {
				if(firstGreater == null) {
					firstGreater = current;
					actualGreater = current;
				} else {
					previous.next = current.next;
					actualGreater.next = current;
					actualGreater = actualGreater.next;
				}
			}

			previous = current;
			current = current.next;
		}

		lastSmaller.next = firstGreater;

		return firstSmaller;
	}
}