package string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RomanNumeralToIntegerTest {

	@Test
	public void test() {
		assertEquals(1, RomanNumeralToInteger.f("I"));
		assertEquals(2, RomanNumeralToInteger.f("II"));
		assertEquals(3, RomanNumeralToInteger.f("III"));
		assertEquals(4, RomanNumeralToInteger.f("IV"));
		assertEquals(5, RomanNumeralToInteger.f("V"));
		assertEquals(6, RomanNumeralToInteger.f("VI"));
		assertEquals(7, RomanNumeralToInteger.f("VII"));
		assertEquals(8, RomanNumeralToInteger.f("VIII"));
		assertEquals(9, RomanNumeralToInteger.f("IX"));
		assertEquals(10, RomanNumeralToInteger.f("X"));
		assertEquals(11, RomanNumeralToInteger.f("XI"));
		assertEquals(12, RomanNumeralToInteger.f("XII"));
		assertEquals(13, RomanNumeralToInteger.f("XIII"));
		assertEquals(14, RomanNumeralToInteger.f("XIV"));
		assertEquals(15, RomanNumeralToInteger.f("XV"));
		assertEquals(1618, RomanNumeralToInteger.f("MDCXVIII"));
		assertEquals(1789, RomanNumeralToInteger.f("MDCCLXXXIX"));
		assertEquals(1492, RomanNumeralToInteger.f("MCDXCII"));
	}

	@Test
	public void test2() {
		assertEquals(1, RomanNumeralToInteger.f2("I"));
		assertEquals(2, RomanNumeralToInteger.f2("II"));
		assertEquals(3, RomanNumeralToInteger.f2("III"));
		assertEquals(4, RomanNumeralToInteger.f2("IV"));
		assertEquals(5, RomanNumeralToInteger.f2("V"));
		assertEquals(6, RomanNumeralToInteger.f2("VI"));
		assertEquals(7, RomanNumeralToInteger.f2("VII"));
		assertEquals(8, RomanNumeralToInteger.f2("VIII"));
		assertEquals(9, RomanNumeralToInteger.f2("IX"));
		assertEquals(10, RomanNumeralToInteger.f2("X"));
		assertEquals(11, RomanNumeralToInteger.f2("XI"));
		assertEquals(12, RomanNumeralToInteger.f2("XII"));
		assertEquals(13, RomanNumeralToInteger.f2("XIII"));
		assertEquals(1618, RomanNumeralToInteger.f2("MDCXVIII"));
		assertEquals(1789, RomanNumeralToInteger.f2("MDCCLXXXIX"));
		assertEquals(1492, RomanNumeralToInteger.f2("MCDXCII"));
	}
}