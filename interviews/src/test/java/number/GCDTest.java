package number;

import static org.junit.Assert.assertEquals;

import number.GCD;

import org.junit.Test;

public class GCDTest {

	@Test
	public void test() {
		int a = 31488;
		int b = 123;
		int expected = 123;

		double d = Math.pow(2, 64);
		double q = Math.pow(10, 12);

		System.out.println(d);
		System.out.println(q);
		assertEquals(expected, GCD.getGcd(a, b));
	}

	@Test
	public void toto() {
		String a = "a";
		String b = a.substring(a.length(), a.length());

		System.out.println(a);
		System.out.println(b);
		System.out.println(b.length());

	}


}