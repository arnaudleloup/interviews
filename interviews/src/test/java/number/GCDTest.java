package number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class GCDTest {

	@Test
	public void test() {
		assertEquals(3, GCD.f(123, 18));
		assertEquals(123, GCD.f(123, 123));
		assertEquals(15, GCD.f(15, 90));
		assertEquals(1, GCD.f(17, 997));
		assertEquals(123, GCD.f(31488, 123));
	}
}