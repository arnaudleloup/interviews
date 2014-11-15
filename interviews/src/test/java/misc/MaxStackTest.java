package misc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class MaxStackTest {

	@Test
	public void test() {
		MaxStack stack = new MaxStack();
		stack.add(2);
		assertEquals(2, stack.max());

		stack.add(5);
		assertEquals(5, stack.max());

		stack.add(4);
		assertEquals(5, stack.max());

		stack.pop();
		assertEquals(5, stack.max());

		stack.add(15);
		assertEquals(15, stack.max());

		stack.pop();
		assertEquals(5, stack.max());

		stack.pop();
		assertEquals(2, stack.max());

		stack.pop();
		try {
			stack.max();
			fail();
		} catch(UnsupportedOperationException e) {
		}
	}
}