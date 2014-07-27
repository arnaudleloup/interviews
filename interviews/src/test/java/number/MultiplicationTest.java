package number;

import static org.junit.Assert.assertEquals;

import number.Multiplication;

import org.junit.Test;

public class MultiplicationTest {

	@Test
	public void test() {
		assertEquals(2, Multiplication.times(2, 1));
		assertEquals(4, Multiplication.times(2, 2));
		assertEquals(6, Multiplication.times(2, 3));
		assertEquals(6, Multiplication.times(3, 2));
		assertEquals(9, Multiplication.times(3, 3));
		assertEquals(60, Multiplication.times(10, 6));
		assertEquals(-24, Multiplication.times(8, -3));
		assertEquals(-24, Multiplication.times(-8, 3));
		assertEquals(24, Multiplication.times(-8, -3));
	}
}