package misc;

import java.util.Random;

public class Sample {

	private final int[] bag;
	private final Random r = new Random();
	private final int K;
	private int i = 0;

	public Sample(int K) {
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