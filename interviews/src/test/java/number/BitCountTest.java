package number;

import static org.junit.Assert.assertEquals;
import number.BitCount;
import number.Max;

import org.junit.Test;

public class BitCountTest {

	@Test
	public void test() {
		int a = 7;
		int expected = 3;
		assertEquals(expected, BitCount.count2(a));
	}

	@Test
	public void test1() {
		int a = 8;
		int expected = 1;
		assertEquals(expected, BitCount.count2(a));
	}

	@Test
	public void ttt() {
		int a = 8;
		int c = 17;
		int b = a >> 31;

		System.out.println(b);
		System.out.println(Max.max(a, c));
	}
}