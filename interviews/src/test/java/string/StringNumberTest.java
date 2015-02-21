package string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StringNumberTest {

	@Test
	public void test() {
		assertEquals(1, StringNumber.f("593784"));
		assertEquals(2, StringNumber.f("5913784"));
		assertEquals(4, StringNumber.f("59237814"));
		assertEquals(8, StringNumber.f("11111"));
	}
}