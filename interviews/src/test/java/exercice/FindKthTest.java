package exercice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindKthTest {

	@Test
	public void test() {
		int[] t = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		assertEquals(1, FindKth.f(t, 1));
		assertEquals(2, FindKth.f(t, 2));
		assertEquals(3, FindKth.f(t, 3));
		assertEquals(4, FindKth.f(t, 4));
		assertEquals(5, FindKth.f(t, 5));
		assertEquals(6, FindKth.f(t, 6));
		assertEquals(7, FindKth.f(t, 7));
		assertEquals(8, FindKth.f(t, 8));
		assertEquals(9, FindKth.f(t, 9));
		assertEquals(10, FindKth.f(t, 10));
	}
}