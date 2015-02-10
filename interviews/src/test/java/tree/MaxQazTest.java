package tree;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxQazTest {

	@Test
	public void test() {
		assertEquals(4, MaxQaz.f(new int[] {33 , 25 , 26 , 58 , 41 , 59}));
		assertEquals(5, MaxQaz.f(new int[] {3 , 25 , 26 , 58 , 41 , 59}));
		assertEquals(0, MaxQaz.f(new int[] {33 , 25 , 22 , 10 , 4 , 2}));
	}
}