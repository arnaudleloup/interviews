package array;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SecretSantaTest {

	@Test
	public void test() {
		int n = 5;
		SecretSanta santa = new SecretSanta();

		int T = 10000;
		for (int t = 0; t < T; t++) {
			int[] a = santa.f(n);

			boolean[] receive = new boolean[n];
			for (int i = 0; i < n; i++) {
				assertTrue(String.valueOf(i), i != a[i]);
				receive[a[i]] = true;
			}
			for (int i = 0; i < n; i++) {
				assertTrue(String.valueOf(i), receive[i]);
			}
		}
	}
}
