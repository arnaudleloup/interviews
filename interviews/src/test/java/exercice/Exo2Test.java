package exercice;

import java.util.Arrays;

import org.junit.Test;

public class Exo2Test {

	@Test
	public void test() {
		int[] t = {};
		Exo2.f(t);
		System.out.println(Arrays.toString(t));
	}

	@Test
	public void test2() {
		int[] t = {1, -2, 4, -3, -2, 5};
		// expected -2, -3, -2, 1, 4, 5
		Exo2.f(t);
		System.out.println(Arrays.toString(t));
	}
}