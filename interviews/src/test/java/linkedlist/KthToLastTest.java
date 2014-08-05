package linkedlist;

import static org.junit.Assert.assertEquals;
import linkedlist.node.Node;

import org.junit.Test;

public class KthToLastTest {

	@Test
	public void test() {
		int[] t = {0, 1, 2, 3, 4};
		Node<Integer> node = LinkedListUtils.build(t);

		assertEquals(3, (int) KthToLast.kthToLast(node, 1));
	}
}