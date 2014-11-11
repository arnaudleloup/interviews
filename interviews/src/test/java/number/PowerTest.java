package number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PowerTest {

	@Test
	public void test() {
		assertEquals(2, Power.f(2, 1));
		assertEquals(4, Power.f(2, 2));
		assertEquals(8, Power.f(2, 3));
		assertEquals(9, Power.f(3, 2));
		assertEquals(27, Power.f(3, 3));
		assertEquals(1000000, Power.f(10, 6));

		// a negative
		assertEquals(-125, Power.f(-5, 3));
		assertEquals(1000000, Power.f(-10, 6));
	}

	@Test
	public void test2() {
		assertEquals(2, Power.f2(2, 1), 0);
		assertEquals(4, Power.f2(2, 2), 0);
		assertEquals(8, Power.f2(2, 3), 0);
		assertEquals(9, Power.f2(3, 2), 0);
		assertEquals(27, Power.f2(3, 3), 0);
		assertEquals(1000000, Power.f2(10, 6), 0);

		// a negative
		assertEquals(-125, Power.f2(-5, 3), 0);
		assertEquals(1000000, Power.f2(-10, 6), 0);

		// b negative
		assertEquals(0.125, Power.f2(2, -3), 0);
	}

}