package number;

import org.junit.Test;

public class SwapInPlaceTest {

	@Test
	public void test() {
		int a = 2;
		int b = 3;
		SwapInPlace.f(a, b);
		SwapInPlace.f2(a, b);
	}
}