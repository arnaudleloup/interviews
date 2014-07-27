package number;

import static org.junit.Assert.assertEquals;

import number.Power;

import org.junit.Test;

public class PowerTest {

	@Test
	public void test() {
		assertEquals(2, Power.power(2, 1));
		assertEquals(4, Power.power(2, 2));
		assertEquals(8, Power.power(2, 3));
		assertEquals(9, Power.power(3, 2));
		assertEquals(27, Power.power(3, 3));
		assertEquals(1000000, Power.power(10, 6));

		// a negative
		assertEquals(-125, Power.power(-5, 3));
		assertEquals(1000000, Power.power(-10, 6));
	}
}