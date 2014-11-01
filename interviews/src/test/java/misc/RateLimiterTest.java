package misc;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RateLimiterTest {

	@Test
	public void test() {
		ClockMock clock = new ClockMock(0);

		RateLimiter limiter = new RateLimiter(4, 10, clock);
		assertTrue(limiter.add());
		assertTrue(limiter.add());
		assertTrue(limiter.add());
		assertTrue(limiter.add());
		assertFalse(limiter.add());

		clock.setCurrent(1);
		assertFalse(limiter.add());

		clock.setCurrent(5);
		assertTrue(limiter.add());
		assertTrue(limiter.add());
		assertFalse(limiter.add());

		clock.setCurrent(10);
		assertTrue(limiter.add());
		assertTrue(limiter.add());
		assertFalse(limiter.add());

		clock.setCurrent(20);
		assertTrue(limiter.add());
		assertTrue(limiter.add());
		assertTrue(limiter.add());
		assertTrue(limiter.add());
		assertFalse(limiter.add());
	}
}