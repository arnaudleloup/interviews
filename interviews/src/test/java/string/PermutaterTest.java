package string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class PermutaterTest {

	@Test
	public void test() {
		String s = "abc";
		Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca", "cab", "cba"));
		Set<String> actual = Permutater.f(s);
		assertEquals(6, actual.size());
		assertEquals(actual.toString(), expected, actual);
	}
}