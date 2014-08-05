package linkedlist;

import static org.junit.Assert.assertEquals;
import linkedlist.node.Node;

import org.junit.Test;

public class MiddleNodeDeletionTest {

	@Test
	public void test() {
		int[] t = {0, 1, 2, 3};
		Node<Integer> first = LinkedListUtils.build(t);

		Node<Integer> node = first.next;
		MiddleNodeDeletion.delete(node);

		assertEquals(0, (int) first.item);
		assertEquals(2, (int) first.next.item);
		assertEquals(3, (int) first.next.next.item);
	}
}