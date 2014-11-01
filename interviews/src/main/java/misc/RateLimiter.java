package misc;

public class RateLimiter {

	public interface Clock {
		public long currentTimeMillis();
	}

	private final int D;
	private final long T;
	private final Clock clock;
	private double amount;
	private long last;

	public RateLimiter(int D, long T, Clock clock) {
		this.D = D;
		this.T = T;
		this.clock = clock;
		amount = D;
		last = clock.currentTimeMillis();
	}

	public synchronized boolean add() {
		long t = clock.currentTimeMillis();
		amount += D * (((double) t - last)) / T;
		if (amount > D) {
			amount = D;
		}

		last = t;
		if (amount >= 1) {
			amount--;
			return true;
		}

		return false;
	}
}