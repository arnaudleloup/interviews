package array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PermutaterTest {

	@Test
	public void test() {
		assertEquals(6, Permutater.f(new int[] {1, 2, 3}));
	}

	@Test
	public void test2() {
		assertEquals(2, Permutater.f2(new int[] {1, 2, 3}, 3));
		assertEquals(6, Permutater.f2(new int[] {1, 2, 3}, 1000));
		assertEquals(5, Permutater.f2(new int[] {1, 2, 3}, 4));
		assertEquals(720, Permutater.f2(new int[] {1, 1, 1, 1, 1, 1}, 2));
		assertEquals(1, Permutater.f2(new int[] {1000}, 1000));
	}
}