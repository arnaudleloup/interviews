package number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AliceGameTest {

	@Test
	public void testEasy() {
		assertEquals(2, AliceGame.findMinimumValueEasy(7, 14));
		assertEquals(4, AliceGame.findMinimumValueEasy(10, 0));
		assertEquals(1047062, AliceGame.findMinimumValueEasy(932599670050L, 67400241741L));
		assertEquals(-1, AliceGame.findMinimumValueEasy(7, 13));
		assertEquals(0, AliceGame.findMinimumValueEasy(0, 0));
		assertEquals(106, AliceGame.findMinimumValueEasy(100000, 400500));
	}

	@Test
	public void testHard() {
		assertEquals(2, AliceGame.findMinimumValueHard(8, 17));
		assertEquals(3, AliceGame.findMinimumValueHard(17, 8));
		assertEquals(0, AliceGame.findMinimumValueHard(0, 0));
		assertEquals(-1, AliceGame.findMinimumValueHard(9, 9));
		assertEquals(294, AliceGame.findMinimumValueHard(500000, 500000));
	}
}