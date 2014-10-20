package number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FibonacciTest {

	@Test
	public void test() {
		assertEquals(1, Fibonacci.f(1));
		assertEquals(2, Fibonacci.f(2));
		assertEquals(3, Fibonacci.f(3));
		assertEquals(5, Fibonacci.f(4));
		assertEquals(8, Fibonacci.f(5));
		assertEquals(13, Fibonacci.f(6));
		assertEquals(21, Fibonacci.f(7));
		assertEquals(34, Fibonacci.f(8));
		assertEquals(55, Fibonacci.f(9));
		assertEquals(89, Fibonacci.f(10));
		assertEquals(144, Fibonacci.f(11));
		assertEquals(233, Fibonacci.f(12));
	}
}