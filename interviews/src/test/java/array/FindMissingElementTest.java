package array;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindMissingElementTest {

	@Test
	public void test() {
		assertEquals(6, FindMissingElement.missOne(new int[] {2, 4, 5, 7, 1, 3}));
	}

	//	@Test
	//	public void test2() {
	//		assertEquals(new Pair<>(3, 6), FindMissingElement.missTwo(new int[] {2, 4, 5, 7, 1}));
	//	}
}