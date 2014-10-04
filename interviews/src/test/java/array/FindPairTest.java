package array;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import array.FindPair.Pair;

public class FindPairTest {

	@Test
	public void test() {
		int[] a = {2, 8, 4, 9, 12, -1, -4, 10, -9, 3, 2, 4, 0};
		int x = 8;
		Set<Pair> pairs1 = FindPair.f(a, x);

		assertEquals(4, pairs1.size());

		Set<Pair> pairs2 = FindPair.f2(a, x);
		assertEquals(4, pairs2.size());
	}
}