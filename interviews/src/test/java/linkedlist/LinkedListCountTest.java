package linkedlist;

import static org.junit.Assert.assertEquals;
import linkedlist.node.Node;

import org.junit.Test;

public class LinkedListCountTest {

	@Test
	public void test() {
		int[] t1 = {7, 1, 6};
		int[] t2 = {5, 9, 2};
		Node<Integer> a = LinkedListUtils.build(t1);
		Node<Integer> b = LinkedListUtils.build(t2);

		Node<Integer> actual = LinkedListCount.count(a, b);
		assertEquals(2, (int) actual.item);
		assertEquals(1, (int) actual.next.item);
		assertEquals(9, (int) actual.next.next.item);
	}

}
