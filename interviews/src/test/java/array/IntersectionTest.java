package array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class IntersectionTest {

	@Test
	public void test() {
		Set<Integer> expected = new HashSet<>(Arrays.asList(4, 7, 10));
		int[] a = {1, 2, 4, 4, 7, 8, 10, 15, 18, 22, 25, 40, 44, 48, 100, 189, 489};
		int[] b = {3, 4, 5, 6, 7, 9, 10};

		assertEquals(expected, Intersection.f(a, b));
		assertEquals(expected, Intersection.f2(a, b));
	}
}