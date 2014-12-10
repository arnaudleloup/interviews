package number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BitReversalTest {

	@Test
	public void test() {
		assertEquals(1, BitReversal.f(1));
		assertEquals(3, BitReversal.f(3));
		assertEquals(3, BitReversal.f(96));
		assertEquals(11, BitReversal.f(52));
		assertEquals(601, BitReversal.f(617));
	}
}