package array;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import lib.Pair;

import org.junit.Test;

public class FrequencyTest {

	@Test
	public void test() {
		assertEquals(Arrays.asList(new Pair<Integer, Integer>(0, 4), new Pair<Integer, Integer>(1, 3), new Pair<Integer, Integer>(2, 3), new Pair<Integer, Integer>(3, 1), new Pair<Integer, Integer>(4, 2)), Frequency.f(new int[] {0, 0, 0, 0, 1, 1, 1, 2, 2, 2, 3, 4, 4}));
	}
}