package misc;

import java.util.Random;

/**
 * Provides two methods:
 * <ul>
 * <li> void add(in e) to add an element into this reservoir sample </li>
 * <li> void int[] sample() to retrieve K elements already added.
 * The probability that an element is returned by this method must be uniform. </li>
 * </ul>
 */
public class ReservoirSample {

	private final int[] bag;
	private final Random r = new Random();
	private final int K;
	private int i = 0;

	public ReservoirSample(int K) {
		this.K = K;
		bag = new int[K];
	}

	public void add(int e) {
		if (i < K) {
			bag[i] = e;
		} else {
			boolean insert = r.nextInt(i) < K;

			if (insert) {
				bag[r.nextInt(K)] = e;
			}
		}

		i++;
	}

	public int[] sample() {
		return bag;
	}
}