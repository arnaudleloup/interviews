package array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UnorderedCountTest {

	@Test
	public void test() {
		assertEquals(1, UnorderedCount.f(new int[] {1, 3, 2}));
		assertEquals(3, UnorderedCount.f(new int[] {3, 2, 1}));
		assertEquals(0, UnorderedCount.f(new int[] {1, 2, 3, 4}));
		assertEquals(6, UnorderedCount.f(new int[] {4, 3, 2, 1}));
		assertEquals(8, UnorderedCount.f(new int[] {1, 7, 4, 5, 2, 3}));
	}

	@Test
	public void test2() {
		assertEquals(1, UnorderedCount.f2(new int[] {1, 3, 2}));
		assertEquals(3, UnorderedCount.f2(new int[] {3, 2, 1}));
		assertEquals(0, UnorderedCount.f2(new int[] {1, 2, 3, 4}));
		assertEquals(6, UnorderedCount.f2(new int[] {4, 3, 2, 1}));
		assertEquals(8, UnorderedCount.f2(new int[] {1, 7, 4, 5, 2, 3}));
	}
}