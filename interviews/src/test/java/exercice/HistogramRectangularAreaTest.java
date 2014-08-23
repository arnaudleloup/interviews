package exercice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HistogramRectangularAreaTest {

	@Test
	public void test() {
		int[] t = {3, 1, 2, 4, 1};
		int expected = 5;
		int actual = HistogramRectangularArea.max(t);
		assertEquals(expected, actual);
	}
}