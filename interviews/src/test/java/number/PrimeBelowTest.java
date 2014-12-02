package number;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class PrimeBelowTest {

	@Test
	public void test() {
		assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19), PrimeBelow.f(20));
	}

	@Test
	public void test2() {
		assertEquals(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19), PrimeBelow.f2(20));
	}
}