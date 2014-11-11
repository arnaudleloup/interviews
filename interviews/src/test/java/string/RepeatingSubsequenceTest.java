package string;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class RepeatingSubsequenceTest {

	@Test
	public void test() {
		assertTrue(RepeatingSubsequence.f("abab"));
		assertFalse(RepeatingSubsequence.f("abba"));
		assertTrue(RepeatingSubsequence.f("acbdaghfb"));
		assertTrue(RepeatingSubsequence.f("abcdacb"));
	}
}