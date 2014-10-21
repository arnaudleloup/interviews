package number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LuckyConversionTest {

	@Test
	public void test() {
		assertEquals(0, LuckyConversion.f("7474", "7474"));
		assertEquals(2, LuckyConversion.f("4747", "7474"));
		assertEquals(4, LuckyConversion.f("4474744", "7447477"));
		assertEquals(1, LuckyConversion.f("47", "74"));
		assertEquals(1, LuckyConversion.f("774", "744"));
		assertEquals(3, LuckyConversion.f("777", "444"));
		assertEquals(4, LuckyConversion.f("74777474", "44744747"));

		assertEquals(0, LuckyConversion.f2("7474", "7474"));
		assertEquals(2, LuckyConversion.f2("4747", "7474"));
		assertEquals(4, LuckyConversion.f2("4474744", "7447477"));
		assertEquals(1, LuckyConversion.f2("47", "74"));
		assertEquals(1, LuckyConversion.f2("774", "744"));
		assertEquals(3, LuckyConversion.f2("777", "444"));
		assertEquals(4, LuckyConversion.f2("74777474", "44744747"));
	}
}