package string;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class CoderTest {

	@Test
	public void test() {
		String s = "1123";
		Set<String> expected = new HashSet<>(Arrays.asList("aabc", "kbc", "alc", "aaw", "kw"));
		Set<String> actual = Coder.f(s);
		assertEquals(actual.toString(), expected, actual);
	}
}