package exercice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class Exo1Test {

	@Test
	public void test() {
		int[] t = {};
		int expected = 0;
		assertEquals(expected, Exo1.f(t));
		assertEquals(expected, Exo1.f2(t));
	}

	@Test
	public void test2() {
		int[] t = {3, 8, 15, 7};
		int expected = 3;
		assertEquals(expected, Exo1.f(t));
		assertEquals(expected, Exo1.f2(t));
	}

	@Test
	public void test3() {
		int[] t = {3, 8, 15, 7, 2, 1, 2, 2, 5};
		int expected = 4;
		assertEquals(expected, Exo1.f(t));
		assertEquals(expected, Exo1.f2(t));
	}

	@Test
	public void test4() {
		int[] t = {3, 8, 15, 7, 2, 1, 5, 2, 5};
		int expected = 5;
		assertEquals(expected, Exo1.f(t));
		assertEquals(expected, Exo1.f2(t));
	}

}