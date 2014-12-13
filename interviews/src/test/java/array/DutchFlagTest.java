package array;

import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class DutchFlagTest {

	@Test
	public void test() {
		Random r = new Random();

		for (int t = 0; t < 1000; t++) {
			int n = r.nextInt(1000);
			int a[] = randomArray(n);
			DutchFlag.sort(a);

			for (int i = 1; i < a.length; i++) {
				assertTrue(a[i] >= a[i - 1]);
			}
		}
	}

	private int[] randomArray(int n) {
		int[] a = new int[n];
		Random r = new Random();

		for (int i = 0; i < n; i++) {
			a[i] = r.nextInt(3);
		}

		return a;
	}
}