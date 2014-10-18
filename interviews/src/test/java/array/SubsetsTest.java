package array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SubsetsTest {

	@Test
	public void test() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		List<List<Integer>> subsets = Subsets.f(list);

		assertEquals(8, subsets.size());
		assertTrue(subsets.contains(Arrays.asList()));
		assertTrue(subsets.contains(Arrays.asList(1, 2, 3)));
		assertTrue(subsets.contains(Arrays.asList(2, 3)));
		assertTrue(subsets.contains(Arrays.asList(1, 3)));
		assertTrue(subsets.contains(Arrays.asList(1, 2)));
		assertTrue(subsets.contains(Arrays.asList(1)));
		assertTrue(subsets.contains(Arrays.asList(2)));
		assertTrue(subsets.contains(Arrays.asList(3)));
	}

	@Test
	public void test2() {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		List<List<Integer>> subsets = Subsets.f(list);
		assertEquals(256, subsets.size());
	}
}