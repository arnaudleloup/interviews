package number;

import static org.junit.Assert.assertEquals;

import number.FlipConvert;

import org.junit.Test;

public class FlipConvertTest {

	@Test
	public void test0() {
		int A = 29;
		int B = 15;
		int expected = 2;
		assertEquals(expected, FlipConvert.convert2(A, B));
	}

	@Test
	public void test1() {
		int A = 16;
		int B = 7;
		int expected = 4;
		assertEquals(expected, FlipConvert.convert2(A, B));
	}

}