package number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NChooseKTest {

	@Test
	public void test() {
		assertEquals(45, NChooseK.f(10, 2));
		assertEquals(120, NChooseK.f(10, 3));
	}
}