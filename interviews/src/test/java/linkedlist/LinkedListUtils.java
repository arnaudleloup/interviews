package linkedlist;

import datastructure.linkedlist.Node;

public class LinkedListUtils {

	public static Node<Integer> build(int[] t) {
		Node<Integer> actual = new Node<>();
		actual.item = t[0];

		Node<Integer> next = new Node<>();
		next.item = t[1];

		actual.next = next;

		Node<Integer> first = actual;
		for (int i = 2; i < t.length; i++) {
			actual = actual.next;

			next = new Node<>();
			next.item = t[i];

			actual.next = next;
		}

		return first;
	}
}
