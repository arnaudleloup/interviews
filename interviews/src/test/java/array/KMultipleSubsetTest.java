package array;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class KMultipleSubsetTest {

	@Test
	public void test() {
		int k = 5;
		List<Integer> subset = KMultipleSubset.f(Arrays.asList(2, 3, 8, 6, 4), k);
		assertNotNull(subset);

		int sum = 0;
		for (int e : subset) {
			sum = (sum + e) % k;
		}

		assertEquals(0, sum);
	}

	@Test
	public void test2() {
		int k = 10;
		List<Integer> subset = KMultipleSubset.f(Arrays.asList(2, 3, 8, 6, 4), k);
		assertNotNull(subset);

		int sum = 0;
		for (int e : subset) {
			sum = (sum + e) % k;
		}

		assertEquals(0, sum);
	}

	@Test
	public void test3() {
		int k = 9;
		List<Integer> subset = KMultipleSubset.f(Arrays.asList(2, 3, 5), k);
		assertNull(subset);
	}

	@Test
	public void test4() {
		int k = 5;
		List<Integer> subset = KMultipleSubset.f2(Arrays.asList(2, 3, 8, 6, 4), k);
		assertNotNull(subset);

		int sum = 0;
		for (int e : subset) {
			sum = (sum + e) % k;
		}

		assertEquals(0, sum);
	}

	@Test
	public void test5() {
		int k = 10;
		List<Integer> subset = KMultipleSubset.f2(Arrays.asList(2, 3, 8, 6, 4), k);
		assertNotNull(subset);

		int sum = 0;
		for (int e : subset) {
			sum = (sum + e) % k;
		}

		assertEquals(0, sum);
	}

	@Test
	public void test6() {
		int k = 9;
		List<Integer> subset = KMultipleSubset.f2(Arrays.asList(2, 3, 5), k);
		assertNull(subset);
	}
}