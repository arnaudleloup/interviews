package exercice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FindMedianTest {

	@Test(expected = UnsupportedOperationException.class)
	public void testEmpty() {
		FindMedian fm = new FindMedian();
		fm.median();
	}

	@Test
	public void test() {
		FindMedian fm = new FindMedian();
		fm.add(1);
		assertEquals(1, fm.median()); // 1

		fm.add(3);
		assertEquals(2, fm.median()); // 1 3

		fm.add(9);
		assertEquals(3, fm.median()); // 1 3 9

		fm.add(16);
		assertEquals(6, fm.median()); // 1 3 9 16

		fm.add(2);
		assertEquals(3, fm.median()); // 1 2 3 9 16

		fm.add(5);
		assertEquals(4, fm.median()); // 1 2 3 5 9 16

		fm.add(10);
		assertEquals(5, fm.median()); // 1 2 3 5 9 10 16
	}
}
