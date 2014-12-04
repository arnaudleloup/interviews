package array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompleteCycleInCircularArrayTest {

	@Test
	public void test() {
		assertEquals(true, CompleteCycleInCircularArray.f(new int[] {2, 2, -1}));
		assertEquals(false, CompleteCycleInCircularArray.f(new int[] {2, 2, 0}));
		assertEquals(true, CompleteCycleInCircularArray.f(new int[] {1, 1, 1, 1}));
		assertEquals(true, CompleteCycleInCircularArray.f(new int[] {1, -1}));
		assertEquals(true, CompleteCycleInCircularArray.f(new int[] {0}));
		assertEquals(false,CompleteCycleInCircularArray.f(new int[] {2, 2, 1}));
		assertEquals(false,CompleteCycleInCircularArray.f(new int[] {1, 1, 1, -1}));
		assertEquals(true,CompleteCycleInCircularArray.f(new int[] {-1, -1}));
		assertEquals(false,CompleteCycleInCircularArray.f(new int[] {1, -1, 1, 1}));
	}

	@Test
	public void test2() {
		assertEquals(true, CompleteCycleInCircularArray.f2(new int[] {2, 2, -1}));
		assertEquals(false, CompleteCycleInCircularArray.f2(new int[] {2, 2, 0}));
		assertEquals(true, CompleteCycleInCircularArray.f2(new int[] {1, 1, 1, 1}));
		assertEquals(true, CompleteCycleInCircularArray.f2(new int[] {1, -1}));
		assertEquals(true, CompleteCycleInCircularArray.f2(new int[] {0}));
		assertEquals(false,CompleteCycleInCircularArray.f2(new int[] {2, 2, 1}));
		assertEquals(false,CompleteCycleInCircularArray.f2(new int[] {1, 1, 1, -1}));
		assertEquals(true,CompleteCycleInCircularArray.f2(new int[] {-1, -1}));
		assertEquals(false,CompleteCycleInCircularArray.f2(new int[] {1, -1, 1, 1}));
	}
}