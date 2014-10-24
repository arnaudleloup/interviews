package number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PowerOfTwoTest {

	@Test
	public void testCeiling() {
		assertEquals(2, PowerOfTwo.ceiling(2));
		assertEquals(8, PowerOfTwo.ceiling(5));
		assertEquals(16, PowerOfTwo.ceiling(9));
		assertEquals(1, PowerOfTwo.ceiling(1));
		assertEquals(4, PowerOfTwo.ceiling(3));
		assertEquals(8, PowerOfTwo.ceiling(8));
	}

	@Test
	public void testFloor() {
		assertEquals(2, PowerOfTwo.floor(2));
		assertEquals(4, PowerOfTwo.floor(5));
		assertEquals(4, PowerOfTwo.floor(7));
		assertEquals(8, PowerOfTwo.floor(9));
		assertEquals(8, PowerOfTwo.floor(8));
		assertEquals(8, PowerOfTwo.floor(13));
	}

	@Test
	public void testPowered() {
		assertEquals(0, PowerOfTwo.powered(1));
		assertEquals(1, PowerOfTwo.powered(2));
		assertEquals(2, PowerOfTwo.powered(4));
		assertEquals(3, PowerOfTwo.powered(8));
		assertEquals(4, PowerOfTwo.powered(16));
		assertEquals(5, PowerOfTwo.powered(32));
		assertEquals(6, PowerOfTwo.powered(64));
	}
}