package exercice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Exo3Test {
	//	 * Example: 987 -> 1234, 3599 -> 3678"

	@Test
	public void test0() {
		int num = 987;
		int expected = 1234;
		int actual = Exo3.f(num);
		assertEquals(expected, actual);
	}

	@Test
	public void test1() {
		int num = 3599;
		int expected = 3678;
		int actual = Exo3.f(num);
		assertEquals(expected, actual);
	}

	@Test
	public void test2() {
		int num = 9876543;
		int expected = 12345678;
		int actual = Exo3.f(num);
		assertEquals(expected, actual);
	}

}
