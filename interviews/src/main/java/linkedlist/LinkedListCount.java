package linkedlist;

import linkedlist.node.Node;

public class LinkedListCount {

	public static Node<Integer> count(Node<Integer> a, Node<Integer> b) {
		Node<Integer> first = null;
		Node<Integer> actual = null;
		int remainder = 0;

		Node<Integer> c1 = a;
		Node<Integer> c2 = b;
		while (c1 != null || c2 != null) {
			int v1 = 0;
			if (c1 != null) {
				v1 = c1.item;
			}

			int v2 = 0;
			if (c2 != null) {
				v2 = c2.item;
			}

			int count = (v1 + v2 + remainder) % 10;
			remainder = (v1 + v2 + remainder) / 10;

			Node<Integer> next = new Node<>();
			next.item = count;

			if (actual == null) {
				actual = next;
				first = next;
			} else {
				actual.next = next;
				actual = next;
			}

			c1 = c1.next;
			c2 = c2.next;
		}

		return first;
	}
}