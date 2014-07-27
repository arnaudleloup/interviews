package exercice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NextIntegerSameDigitTest {
	//	Example: 217650  --> 250167, 3276510 --> 3501267, 12301 --> 12310".

	@Test
	public void test0() {
		int num = 217650;
		int expected = 250167;
		int actual = NextIntegerSameDigit.f(num);

		assertEquals(actual, expected, actual);
	}

	@Test
	public void test1() {
		int num = 3276510;
		int expected = 3501267;
		int actual = NextIntegerSameDigit.f(num);

		assertEquals(actual, expected, actual);
	}

	@Test
	public void test2() {
		int num = 12301;
		int expected = 12310;
		int actual = NextIntegerSameDigit.f(num);

		assertEquals(actual, expected, actual);
	}

}
