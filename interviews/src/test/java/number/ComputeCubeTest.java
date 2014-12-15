package number;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class ComputeCubeTest {

	@Test
	public void test() {
		int N = 20;
		int[] a = ComputeCube.f(N);
		int[] b = ComputeCube.f2(N);
		assertTrue(Arrays.equals(a, b));
	}
}