package misc;

import misc.RateLimiter.Clock;

public class ClockMock implements Clock {

	private long current;

	public ClockMock(long current) {
		this.current = current;
	}

	@Override
	public long currentTimeMillis() {
		return current;
	}

	public void setCurrent(long current) {
		this.current = current;
	}
}