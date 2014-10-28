package array;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FruitsBasketTest {

	@Test
	public void test() {
		Map<String, Integer> fruits = new HashMap<>();
		fruits.put("Kiwi", 7);
		fruits.put("Orange", 12);
		fruits.put("Banana", 5);
		fruits.put("Apple", 8);

		assertEquals("Orange", new FruitsBasket(1234L).f(fruits));
		assertEquals("Apple", new FruitsBasket(12345L).f(fruits));
		assertEquals("Kiwi", new FruitsBasket(13457891L).f(fruits));
	}
}