package exercice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindMedianBoundedTest {

	@Test(expected = UnsupportedOperationException.class)
	public void testEmpty() {
		FindMedianBounded fm = new FindMedianBounded(5);
		fm.median();
	}

	public void test() {
		FindMedianBounded fm = new FindMedianBounded(5);
		fm.add(1);
		assertEquals(1, fm.median()); // 1

		fm.add(3);
		assertEquals(2, fm.median()); // 1 3

		fm.add(3);
		assertEquals(3, fm.median()); // 1 3 3

		fm.add(1);
		assertEquals(2, fm.median()); // 1 1 3 3

		fm.add(2);
		assertEquals(2, fm.median()); // 1 1 2 3 3
	}
}
