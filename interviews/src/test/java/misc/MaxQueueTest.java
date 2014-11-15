package misc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class MaxQueueTest {

	@Test
	public void test() {
		MaxQueue queue = new MaxQueue();
		queue.add(2);
		assertEquals(2, (int) queue.max());

		queue.add(5);
		assertEquals(5, (int) queue.max());

		queue.add(4);
		assertEquals(5, (int) queue.max());

		queue.pop();
		assertEquals(5, (int) queue.max());

		queue.add(15);
		assertEquals(15, (int) queue.max());

		queue.add(8);
		assertEquals(15, (int) queue.max());

		queue.add(7);
		assertEquals(15, (int) queue.max());

		queue.pop();
		assertEquals(15, (int) queue.max());

		queue.pop();
		assertEquals(15, (int) queue.max());

		queue.pop();
		assertEquals(8, (int) queue.max());

		queue.pop();
		assertEquals(7, (int) queue.max());

		queue.pop();
		assertNull(queue.max());
	}
}