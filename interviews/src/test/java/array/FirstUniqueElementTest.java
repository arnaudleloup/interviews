package array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FirstUniqueElementTest {

	@Test
	public void test() {
		assertEquals(2, FirstUniqueElement.f(new int[] {1, 4, 2, 5, 9, 0, 4, 6, 1, 4}));
		assertEquals(-1, FirstUniqueElement.f(new int[] {1, 4, 2, 6, 5, 9, 0, 4, 6, 5, 1, 0, 4, 9, 2, 5}));
	}
}