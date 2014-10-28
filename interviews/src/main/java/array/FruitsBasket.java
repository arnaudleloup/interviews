package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

/**
 * You are given a basket of fruits. A same fruits can appear several times into the basker.
 * Returns a randomly picked fruit.
 * <p/>
 * Example:
 * <br/> 3 bananas, 6 kiwis, 12 oranges
 * <br/> A kiwi has twice as many chance to being picked than a banana
 * and an orange has twice as many chance to be picked tahn a kiwi.
 */
public class FruitsBasket {

	private final Random random;

	public FruitsBasket() {
		random = new Random();
	}

	public FruitsBasket(Long seed) {
		random = new Random(seed);
	}

	public String f(Map<String, Integer> fruits) {
		int n = fruits.size();
		Map<Integer, String> cumulativeFrMap = new HashMap<>();
		int[] cumulativeFr = new int[n];

		int acc = 0;
		int i = 0;
		int last = 0;
		for (Entry<String, Integer> entry : fruits.entrySet()) {
			String fruit = entry.getKey();
			Integer fr = entry.getValue();
			cumulativeFrMap.put(acc, fruit);
			cumulativeFr[i++] = acc;

			if (i == n) {
				last = acc;
			}

			acc += fr;
		}

		int r = random.nextInt(acc);
		if (r >= last) {
			return cumulativeFrMap.get(last);
		}

		int j = binarySearch(cumulativeFr, r, 0, n - 1);
		return cumulativeFrMap.get(j);
	}

	private static int binarySearch(int[] fr, int r, int lo, int hi) {
		int mid = lo + (hi - lo) / 2;
		if (fr[mid] <= r && fr[mid + 1] > r) {
			return fr[mid];
		} else if (fr[mid] > r) {
			return binarySearch(fr, r, lo, mid);
		} else {
			return binarySearch(fr, r, mid, hi);
		}
	}
}