package string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ShortestUniquePrefixTest {

	@Test
	public void test() {
		String[] strings = {"she", "sells", "sea", "shells", "by", "the", "sea", "shore"};
		Set<String> prefix = new HashSet<>(Arrays.asList("she", "sel", "sea", "shel", "b", "t", "sho"));
		assertEquals(prefix, ShortestUniquePrefix.f(strings));
	}

	@Test
	public void test2() {
		String[] strings = {"zebra", "dog", "duck", "dot", "dove"};
		Set<String> prefix = new HashSet<>(Arrays.asList("z", "dog", "du", "dot", "dov"));
		assertEquals(prefix, ShortestUniquePrefix.f(strings));
	}

	@Test
	public void testDuplicates() {
		String[] strings = {"test", "test", "some"};
		Set<String> prefix = new HashSet<>(Arrays.asList("s", "t"));
		assertEquals(prefix, ShortestUniquePrefix.f(strings));
	}
}